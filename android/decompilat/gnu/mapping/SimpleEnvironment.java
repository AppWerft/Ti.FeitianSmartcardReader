// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.util.Set;
import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;

public class SimpleEnvironment extends Environment
{
    NamedLocation[] table;
    int log2Size;
    private int mask;
    int num_bindings;
    int currentTimestamp;
    NamedLocation sharedTail;
    
    public int size() {
        return this.num_bindings;
    }
    
    public static Location getCurrentLocation(final String name) {
        return Environment.getCurrent().getLocation(name, true);
    }
    
    public static Object lookup_global(final Symbol name) throws UnboundLocationException {
        final Location binding = Environment.getCurrent().lookup(name);
        if (binding == null) {
            throw new UnboundLocationException(name);
        }
        return binding.get();
    }
    
    public SimpleEnvironment() {
        this(64);
    }
    
    public SimpleEnvironment(final String name) {
        this();
        this.setName(name);
    }
    
    public SimpleEnvironment(int capacity) {
        this.log2Size = 4;
        while (capacity > 1 << this.log2Size) {
            ++this.log2Size;
        }
        capacity = 1 << this.log2Size;
        this.table = new NamedLocation[capacity];
        this.mask = capacity - 1;
        this.sharedTail = new PlainLocation(null, null, this);
    }
    
    @Override
    public NamedLocation lookup(final Symbol name, final Object property, final int hash) {
        return this.lookupDirect(name, property, hash);
    }
    
    public NamedLocation lookupDirect(final Symbol name, final Object property, final int hash) {
        final int index = hash & this.mask;
        for (NamedLocation loc = this.table[index]; loc != null; loc = loc.next) {
            if (loc.matches(name, property)) {
                return loc;
            }
        }
        return null;
    }
    
    @Override
    public synchronized NamedLocation getLocation(final Symbol name, final Object property, final int hash, final boolean create) {
        final NamedLocation loc = this.lookup(name, property, hash);
        if (loc != null) {
            return loc;
        }
        if (!create) {
            return null;
        }
        return this.addUnboundLocation(name, property, hash);
    }
    
    protected NamedLocation addUnboundLocation(final Symbol name, final Object property, final int hash) {
        final int index = hash & this.mask;
        final NamedLocation loc = this.newEntry(name, property, index);
        loc.base = null;
        loc.value = Location.UNBOUND;
        return loc;
    }
    
    @Override
    public void put(final Symbol key, final Object property, final Object newValue) {
        final boolean create = (this.flags & 0x4) != 0x0;
        final Location loc = this.getLocation(key, property, create);
        if (loc == null) {
            throw new UnboundLocationException(key);
        }
        if (loc.isConstant()) {
            throw new IllegalStateException("attempt to modify read-only location: " + key + " in " + this + " loc:" + loc);
        }
        loc.set(newValue);
    }
    
    protected NamedLocation newLocation(final Symbol name, final Object property) {
        if ((this.flags & 0x8) != 0x0) {
            return new SharedLocation(name, property, this.currentTimestamp);
        }
        return new PlainLocation(name, property);
    }
    
    NamedLocation newEntry(final Symbol name, final Object property, final int index) {
        final NamedLocation loc = this.newLocation(name, property);
        final NamedLocation first = this.table[index];
        loc.next = ((first == null) ? this.sharedTail : first);
        this.table[index] = loc;
        ++this.num_bindings;
        if (this.num_bindings >= this.table.length) {
            this.rehash();
        }
        return loc;
    }
    
    public NamedLocation define(final Symbol sym, final Object property, final int hash, final Object newValue) {
        final int index = hash & this.mask;
        NamedLocation loc;
        for (NamedLocation first = loc = this.table[index]; loc != null; loc = loc.next) {
            if (loc.matches(sym, property)) {
                Label_0089: {
                    if (loc.isBound()) {
                        if (this.getCanDefine()) {
                            break Label_0089;
                        }
                    }
                    else if (this.getCanRedefine()) {
                        break Label_0089;
                    }
                    this.redefineError(sym, property, loc);
                }
                loc.base = null;
                loc.value = newValue;
                return loc;
            }
        }
        loc = this.newEntry(sym, property, index);
        loc.set(newValue);
        return loc;
    }
    
    @Override
    public void define(final Symbol sym, final Object property, final Object newValue) {
        final int hash = sym.hashCode() ^ System.identityHashCode(property);
        this.define(sym, property, hash, newValue);
    }
    
    protected void redefineError(final Symbol name, final Object property, final Location loc) {
        throw new IllegalStateException("prohibited define/redefine of " + name + " in " + this);
    }
    
    @Override
    public NamedLocation addLocation(final Symbol name, final Object property, final Location loc) {
        return this.addLocation(name, property, name.hashCode() ^ System.identityHashCode(property), loc);
    }
    
    NamedLocation addLocation(final Symbol name, final Object property, final int hash, Location loc) {
        if (loc instanceof DynamicLocation && ((DynamicLocation<T>)loc).property == property) {
            loc = ((DynamicLocation<T>)loc).getLocation();
        }
        NamedLocation nloc = this.lookupDirect(name, property, hash);
        if (loc == nloc) {
            return nloc;
        }
        boolean bound = nloc != null;
        if (!bound) {
            nloc = this.addUnboundLocation(name, property, hash);
        }
        Label_0139: {
            if ((this.flags & 0x3) != 0x3) {
                if (bound) {
                    bound = nloc.isBound();
                }
                if (bound) {
                    if ((this.flags & 0x2) != 0x0) {
                        break Label_0139;
                    }
                }
                else if ((this.flags & 0x1) != 0x0 || !loc.isBound()) {
                    break Label_0139;
                }
                this.redefineError(name, property, nloc);
            }
        }
        if ((this.flags & 0x20) != 0x0) {
            nloc.base = (Location<T>)((SimpleEnvironment)((InheritingEnvironment)this).getParent(0)).addLocation(name, property, hash, loc);
        }
        else {
            nloc.base = loc;
        }
        nloc.value = IndirectableLocation.INDIRECT_FLUIDS;
        return nloc;
    }
    
    void rehash() {
        final NamedLocation[] oldTable = this.table;
        final int oldCapacity = oldTable.length;
        final int newCapacity = 2 * oldCapacity;
        final NamedLocation[] newTable = new NamedLocation[newCapacity];
        final int newMask = newCapacity - 1;
        int i = oldCapacity;
        while (--i >= 0) {
            NamedLocation next;
            for (NamedLocation element = oldTable[i]; element != null && element != this.sharedTail; element = next) {
                next = element.next;
                final Symbol name = element.name;
                final Object property = element.property;
                final int hash = name.hashCode() ^ System.identityHashCode(property);
                final int j = hash & newMask;
                NamedLocation head = newTable[j];
                if (head == null) {
                    head = this.sharedTail;
                }
                element.next = head;
                newTable[j] = element;
            }
        }
        this.table = newTable;
        ++this.log2Size;
        this.mask = newMask;
    }
    
    @Override
    public Location unlink(final Symbol symbol, final Object property, final int hash) {
        final int index = hash & this.mask;
        NamedLocation prev = null;
        NamedLocation next;
        for (NamedLocation loc = this.table[index]; loc != null; loc = next) {
            next = loc.next;
            if (loc.matches(symbol, property)) {
                if (!this.getCanRedefine()) {
                    this.redefineError(symbol, property, loc);
                }
                if (prev == null) {
                    this.table[index] = next;
                }
                else {
                    prev.next = loc;
                }
                --this.num_bindings;
                return loc;
            }
            prev = loc;
        }
        return null;
    }
    
    @Override
    public LocationEnumeration enumerateLocations() {
        final LocationEnumeration it = new LocationEnumeration(this.table, 1 << this.log2Size);
        it.env = this;
        return it;
    }
    
    @Override
    public LocationEnumeration enumerateAllLocations() {
        return this.enumerateLocations();
    }
    
    @Override
    protected boolean hasMoreElements(final LocationEnumeration it) {
        while (true) {
            if (it.nextLoc == null) {
                it.prevLoc = null;
                if (--it.index < 0) {
                    return false;
                }
                it.nextLoc = it.bindings[it.index];
                if (it.nextLoc == null) {
                    continue;
                }
            }
            if (it.nextLoc.name != null) {
                return true;
            }
            it.nextLoc = it.nextLoc.next;
        }
    }
    
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.getSymbol());
    }
    
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setSymbol(in.readObject());
    }
    
    public Object readResolve() throws ObjectStreamException {
        final String name = this.getName();
        final Environment env = SimpleEnvironment.envTable.get(name);
        if (env != null) {
            return env;
        }
        SimpleEnvironment.envTable.put(name, this);
        return this;
    }
    
    public Set entrySet() {
        return new EnvironmentMappings(this);
    }
    
    @Override
    public String toStringVerbose() {
        final StringBuffer sbuf = new StringBuffer();
        this.toStringBase(sbuf);
        return "#<environment " + this.getName() + " num:" + this.num_bindings + " ts:" + this.currentTimestamp + (Object)sbuf + '>';
    }
    
    protected void toStringBase(final StringBuffer sbuf) {
    }
}
