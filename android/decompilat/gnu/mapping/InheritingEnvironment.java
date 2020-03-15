// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class InheritingEnvironment extends SimpleEnvironment
{
    int numInherited;
    Environment[] inherited;
    int baseTimestamp;
    
    public InheritingEnvironment(final String name, final Environment parent) {
        super(name);
        this.addParent(parent);
        if (parent instanceof SimpleEnvironment) {
            final int timestamp = ++((SimpleEnvironment)parent).currentTimestamp;
            this.baseTimestamp = timestamp;
            this.currentTimestamp = timestamp;
        }
    }
    
    public final int getNumParents() {
        return this.numInherited;
    }
    
    public final Environment getParent(final int index) {
        return this.inherited[index];
    }
    
    public void addParent(final Environment env) {
        if (this.numInherited == 0) {
            this.inherited = new Environment[4];
        }
        else if (this.numInherited <= this.inherited.length) {
            final Environment[] newInherited = new Environment[2 * this.numInherited];
            System.arraycopy(this.inherited, 0, newInherited, 0, this.numInherited);
            this.inherited = newInherited;
        }
        this.inherited[this.numInherited] = env;
        ++this.numInherited;
    }
    
    public NamedLocation lookupInherited(final Symbol name, final Object property, final int hash) {
        for (int i = 0; i < this.numInherited; ++i) {
            final Symbol sym = name;
            final Object prop = property;
            final NamedLocation loc = this.inherited[i].lookup(sym, prop, hash);
            if (loc != null && loc.isBound() && (!(loc instanceof SharedLocation) || ((SharedLocation)loc).timestamp < this.baseTimestamp)) {
                return loc;
            }
        }
        return null;
    }
    
    @Override
    public NamedLocation lookup(final Symbol name, final Object property, final int hash) {
        final NamedLocation loc = super.lookup(name, property, hash);
        if (loc != null && loc.isBound()) {
            return loc;
        }
        return this.lookupInherited(name, property, hash);
    }
    
    @Override
    public synchronized NamedLocation getLocation(final Symbol name, final Object property, final int hash, final boolean create) {
        NamedLocation loc = this.lookupDirect(name, property, hash);
        if (loc != null && (create || loc.isBound())) {
            return loc;
        }
        if ((this.flags & 0x20) != 0x0 && create) {
            loc = this.inherited[0].getLocation(name, property, hash, true);
        }
        else {
            loc = this.lookupInherited(name, property, hash);
        }
        if (loc == null) {
            return create ? this.addUnboundLocation(name, property, hash) : null;
        }
        if (create) {
            final NamedLocation xloc = this.addUnboundLocation(name, property, hash);
            if ((this.flags & 0x1) == 0x0 && loc.isBound()) {
                this.redefineError(name, property, xloc);
            }
            xloc.base = (Location<T>)loc;
            if (loc.value == IndirectableLocation.INDIRECT_FLUIDS) {
                xloc.value = loc.value;
            }
            else if ((this.flags & 0x10) != 0x0) {
                xloc.value = IndirectableLocation.DIRECT_ON_SET;
            }
            else {
                xloc.value = null;
            }
            if (xloc instanceof SharedLocation) {
                ((SharedLocation)xloc).timestamp = this.baseTimestamp;
            }
            return xloc;
        }
        return loc;
    }
    
    @Override
    public LocationEnumeration enumerateAllLocations() {
        final LocationEnumeration it = new LocationEnumeration(this.table, 1 << this.log2Size);
        it.env = this;
        if (this.inherited != null && this.inherited.length > 0) {
            it.inherited = this.inherited[0].enumerateAllLocations();
            it.index = 0;
        }
        return it;
    }
    
    @Override
    protected boolean hasMoreElements(final LocationEnumeration it) {
        Label_0151: {
            if (it.inherited != null) {
                while (true) {
                    NamedLocation loc = it.nextLoc;
                    while (true) {
                        it.inherited.nextLoc = loc;
                        if (!it.inherited.hasMoreElements()) {
                            it.prevLoc = null;
                            it.nextLoc = it.inherited.nextLoc;
                            if (++it.index == this.numInherited) {
                                it.inherited = null;
                                it.bindings = this.table;
                                it.index = 1 << this.log2Size;
                                break Label_0151;
                            }
                            it.inherited = this.inherited[it.index].enumerateAllLocations();
                            break;
                        }
                        else {
                            loc = it.inherited.nextLoc;
                            if (this.lookup(loc.name, loc.property) == loc) {
                                it.nextLoc = loc;
                                return true;
                            }
                            loc = loc.next;
                        }
                    }
                }
            }
        }
        return super.hasMoreElements(it);
    }
    
    @Override
    protected void toStringBase(final StringBuffer sbuf) {
        sbuf.append(" baseTs:");
        sbuf.append(this.baseTimestamp);
        for (int i = 0; i < this.numInherited; ++i) {
            sbuf.append(" base:");
            sbuf.append(this.inherited[i].toStringVerbose());
        }
    }
}
