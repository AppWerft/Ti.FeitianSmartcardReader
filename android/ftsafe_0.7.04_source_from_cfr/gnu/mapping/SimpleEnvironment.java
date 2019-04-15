/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.DynamicLocation;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentMappings;
import gnu.mapping.IndirectableLocation;
import gnu.mapping.InheritingEnvironment;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.NamedLocation;
import gnu.mapping.PlainLocation;
import gnu.mapping.SharedLocation;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;
import java.util.Set;

public class SimpleEnvironment
extends Environment {
    NamedLocation[] table;
    int log2Size = 4;
    private int mask;
    int num_bindings;
    int currentTimestamp;
    NamedLocation sharedTail;

    public int size() {
        return this.num_bindings;
    }

    public static Location getCurrentLocation(String name) {
        return SimpleEnvironment.getCurrent().getLocation(name, true);
    }

    public static Object lookup_global(Symbol name) throws UnboundLocationException {
        Location binding = SimpleEnvironment.getCurrent().lookup(name);
        if (binding == null) {
            throw new UnboundLocationException(name);
        }
        return binding.get();
    }

    public SimpleEnvironment() {
        this(64);
    }

    public SimpleEnvironment(String name) {
        this();
        this.setName(name);
    }

    public SimpleEnvironment(int capacity) {
        while (capacity > 1 << this.log2Size) {
            ++this.log2Size;
        }
        capacity = 1 << this.log2Size;
        this.table = new NamedLocation[capacity];
        this.mask = capacity - 1;
        this.sharedTail = new PlainLocation<SimpleEnvironment>(null, null, this);
    }

    @Override
    public NamedLocation lookup(Symbol name, Object property, int hash) {
        return this.lookupDirect(name, property, hash);
    }

    public NamedLocation lookupDirect(Symbol name, Object property, int hash) {
        int index = hash & this.mask;
        NamedLocation loc = this.table[index];
        while (loc != null) {
            if (loc.matches(name, property)) {
                return loc;
            }
            loc = loc.next;
        }
        return null;
    }

    @Override
    public synchronized NamedLocation getLocation(Symbol name, Object property, int hash, boolean create) {
        NamedLocation loc = this.lookup(name, property, hash);
        if (loc != null) {
            return loc;
        }
        if (!create) {
            return null;
        }
        return this.addUnboundLocation(name, property, hash);
    }

    protected NamedLocation addUnboundLocation(Symbol name, Object property, int hash) {
        int index = hash & this.mask;
        NamedLocation loc = this.newEntry(name, property, index);
        loc.base = null;
        loc.value = Location.UNBOUND;
        return loc;
    }

    @Override
    public void put(Symbol key, Object property, Object newValue) {
        boolean create = (this.flags & 4) != 0;
        NamedLocation loc = this.getLocation(key, property, create);
        if (loc == null) {
            throw new UnboundLocationException(key);
        }
        if (((Location)loc).isConstant()) {
            throw new IllegalStateException("attempt to modify read-only location: " + key + " in " + this + " loc:" + loc);
        }
        loc.set(newValue);
    }

    protected NamedLocation newLocation(Symbol name, Object property) {
        if ((this.flags & 8) != 0) {
            return new SharedLocation(name, property, this.currentTimestamp);
        }
        return new PlainLocation(name, property);
    }

    NamedLocation newEntry(Symbol name, Object property, int index) {
        NamedLocation loc = this.newLocation(name, property);
        NamedLocation first = this.table[index];
        loc.next = first == null ? this.sharedTail : first;
        this.table[index] = loc;
        ++this.num_bindings;
        if (this.num_bindings >= this.table.length) {
            this.rehash();
        }
        return loc;
    }

    public NamedLocation define(Symbol sym, Object property, int hash, Object newValue) {
        NamedLocation first;
        int index = hash & this.mask;
        NamedLocation loc = first = this.table[index];
        do {
            if (loc == null) {
                loc = this.newEntry(sym, property, index);
                loc.set(newValue);
                return loc;
            }
            if (loc.matches(sym, property)) {
                if (!(!loc.isBound() ? this.getCanRedefine() : this.getCanDefine())) {
                    this.redefineError(sym, property, loc);
                }
                loc.base = null;
                loc.value = newValue;
                return loc;
            }
            loc = loc.next;
        } while (true);
    }

    @Override
    public void define(Symbol sym, Object property, Object newValue) {
        int hash = sym.hashCode() ^ System.identityHashCode(property);
        this.define(sym, property, hash, newValue);
    }

    protected void redefineError(Symbol name, Object property, Location loc) {
        throw new IllegalStateException("prohibited define/redefine of " + name + " in " + this);
    }

    @Override
    public NamedLocation addLocation(Symbol name, Object property, Location loc) {
        return this.addLocation(name, property, name.hashCode() ^ System.identityHashCode(property), loc);
    }

    NamedLocation addLocation(Symbol name, Object property, int hash, Location loc) {
        boolean bound;
        NamedLocation nloc;
        if (loc instanceof DynamicLocation && ((DynamicLocation)loc).property == property) {
            loc = ((DynamicLocation)loc).getLocation();
        }
        if (loc == (nloc = this.lookupDirect(name, property, hash))) {
            return nloc;
        }
        boolean bl = bound = nloc != null;
        if (!bound) {
            nloc = this.addUnboundLocation(name, property, hash);
        }
        if ((this.flags & 3) != 3) {
            if (bound) {
                bound = nloc.isBound();
            }
            if (bound ? (this.flags & 2) == 0 : (this.flags & 1) == 0 && loc.isBound()) {
                this.redefineError(name, property, nloc);
            }
        }
        nloc.base = (this.flags & 32) != 0 ? ((SimpleEnvironment)((InheritingEnvironment)this).getParent(0)).addLocation(name, property, hash, loc) : loc;
        nloc.value = IndirectableLocation.INDIRECT_FLUIDS;
        return nloc;
    }

    void rehash() {
        NamedLocation[] oldTable = this.table;
        int oldCapacity = oldTable.length;
        int newCapacity = 2 * oldCapacity;
        NamedLocation[] newTable = new NamedLocation[newCapacity];
        int newMask = newCapacity - 1;
        int i = oldCapacity;
        while (--i >= 0) {
            NamedLocation element = oldTable[i];
            while (element != null && element != this.sharedTail) {
                NamedLocation next = element.next;
                Symbol name = element.name;
                Object property = element.property;
                int hash = name.hashCode() ^ System.identityHashCode(property);
                int j = hash & newMask;
                NamedLocation head = newTable[j];
                if (head == null) {
                    head = this.sharedTail;
                }
                element.next = head;
                newTable[j] = element;
                element = next;
            }
        }
        this.table = newTable;
        ++this.log2Size;
        this.mask = newMask;
    }

    @Override
    public Location unlink(Symbol symbol, Object property, int hash) {
        int index = hash & this.mask;
        NamedLocation prev = null;
        NamedLocation loc = this.table[index];
        while (loc != null) {
            NamedLocation next = loc.next;
            if (loc.matches(symbol, property)) {
                if (!this.getCanRedefine()) {
                    this.redefineError(symbol, property, loc);
                }
                if (prev == null) {
                    this.table[index] = next;
                } else {
                    prev.next = loc;
                }
                --this.num_bindings;
                return loc;
            }
            prev = loc;
            loc = next;
        }
        return null;
    }

    @Override
    public LocationEnumeration enumerateLocations() {
        LocationEnumeration it = new LocationEnumeration(this.table, 1 << this.log2Size);
        it.env = this;
        return it;
    }

    @Override
    public LocationEnumeration enumerateAllLocations() {
        return this.enumerateLocations();
    }

    @Override
    protected boolean hasMoreElements(LocationEnumeration it) {
        do {
            if (it.nextLoc == null) {
                it.prevLoc = null;
                if (--it.index < 0) {
                    return false;
                }
                it.nextLoc = it.bindings[it.index];
                if (it.nextLoc == null) continue;
            }
            if (it.nextLoc.name != null) break;
            it.nextLoc = it.nextLoc.next;
        } while (true);
        return true;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getSymbol());
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setSymbol(in.readObject());
    }

    public Object readResolve() throws ObjectStreamException {
        String name = this.getName();
        Environment env = (Environment)envTable.get(name);
        if (env != null) {
            return env;
        }
        envTable.put(name, this);
        return this;
    }

    public Set entrySet() {
        return new EnvironmentMappings(this);
    }

    @Override
    public String toStringVerbose() {
        StringBuffer sbuf = new StringBuffer();
        this.toStringBase(sbuf);
        return "#<environment " + this.getName() + " num:" + this.num_bindings + " ts:" + this.currentTimestamp + sbuf + '>';
    }

    protected void toStringBase(StringBuffer sbuf) {
    }
}

