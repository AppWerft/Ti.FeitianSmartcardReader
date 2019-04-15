/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Environment;
import gnu.mapping.IndirectableLocation;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.NamedLocation;
import gnu.mapping.SharedLocation;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.Symbol;

public class InheritingEnvironment
extends SimpleEnvironment {
    int numInherited;
    Environment[] inherited;
    int baseTimestamp;

    public InheritingEnvironment(String name, Environment parent) {
        super(name);
        this.addParent(parent);
        if (parent instanceof SimpleEnvironment) {
            int timestamp;
            this.baseTimestamp = timestamp = ++((SimpleEnvironment)parent).currentTimestamp;
            this.currentTimestamp = timestamp;
        }
    }

    public final int getNumParents() {
        return this.numInherited;
    }

    public final Environment getParent(int index) {
        return this.inherited[index];
    }

    public void addParent(Environment env) {
        if (this.numInherited == 0) {
            this.inherited = new Environment[4];
        } else if (this.numInherited <= this.inherited.length) {
            Environment[] newInherited = new Environment[2 * this.numInherited];
            System.arraycopy(this.inherited, 0, newInherited, 0, this.numInherited);
            this.inherited = newInherited;
        }
        this.inherited[this.numInherited] = env;
        ++this.numInherited;
    }

    public NamedLocation lookupInherited(Symbol name, Object property, int hash) {
        for (int i = 0; i < this.numInherited; ++i) {
            Symbol sym = name;
            Object prop = property;
            NamedLocation loc = this.inherited[i].lookup(sym, prop, hash);
            if (loc == null || !loc.isBound() || loc instanceof SharedLocation && ((SharedLocation)loc).timestamp >= this.baseTimestamp) continue;
            return loc;
        }
        return null;
    }

    @Override
    public NamedLocation lookup(Symbol name, Object property, int hash) {
        NamedLocation loc = super.lookup(name, property, hash);
        if (loc != null && loc.isBound()) {
            return loc;
        }
        return this.lookupInherited(name, property, hash);
    }

    @Override
    public synchronized NamedLocation getLocation(Symbol name, Object property, int hash, boolean create) {
        NamedLocation loc = this.lookupDirect(name, property, hash);
        if (loc != null && (create || loc.isBound())) {
            return loc;
        }
        loc = (this.flags & 32) != 0 && create ? this.inherited[0].getLocation(name, property, hash, true) : this.lookupInherited(name, property, hash);
        if (loc != null) {
            if (create) {
                NamedLocation xloc = this.addUnboundLocation(name, property, hash);
                if ((this.flags & 1) == 0 && loc.isBound()) {
                    this.redefineError(name, property, xloc);
                }
                xloc.base = loc;
                xloc.value = loc.value == IndirectableLocation.INDIRECT_FLUIDS ? loc.value : ((this.flags & 16) != 0 ? IndirectableLocation.DIRECT_ON_SET : null);
                if (xloc instanceof SharedLocation) {
                    ((SharedLocation)xloc).timestamp = this.baseTimestamp;
                }
                return xloc;
            }
            return loc;
        }
        return create ? this.addUnboundLocation(name, property, hash) : null;
    }

    @Override
    public LocationEnumeration enumerateAllLocations() {
        LocationEnumeration it = new LocationEnumeration(this.table, 1 << this.log2Size);
        it.env = this;
        if (this.inherited != null && this.inherited.length > 0) {
            it.inherited = this.inherited[0].enumerateAllLocations();
            it.index = 0;
        }
        return it;
    }

    @Override
    protected boolean hasMoreElements(LocationEnumeration it) {
        if (it.inherited != null) {
            do {
                NamedLocation loc = it.nextLoc;
                do {
                    it.inherited.nextLoc = loc;
                    if (!it.inherited.hasMoreElements()) break;
                    loc = it.inherited.nextLoc;
                    if (this.lookup(loc.name, loc.property) == loc) {
                        it.nextLoc = loc;
                        return true;
                    }
                    loc = loc.next;
                } while (true);
                it.prevLoc = null;
                it.nextLoc = it.inherited.nextLoc;
                if (++it.index == this.numInherited) break;
                it.inherited = this.inherited[it.index].enumerateAllLocations();
            } while (true);
            it.inherited = null;
            it.bindings = this.table;
            it.index = 1 << this.log2Size;
        }
        return super.hasMoreElements(it);
    }

    @Override
    protected void toStringBase(StringBuffer sbuf) {
        sbuf.append(" baseTs:");
        sbuf.append(this.baseTimestamp);
        for (int i = 0; i < this.numInherited; ++i) {
            sbuf.append(" base:");
            sbuf.append(this.inherited[i].toStringVerbose());
        }
    }
}

