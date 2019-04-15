/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.EnvironmentKey;
import gnu.mapping.InheritingEnvironment;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.NamedLocation;
import gnu.mapping.Namespace;
import gnu.mapping.PropertySet;
import gnu.mapping.SharedLocation;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import java.util.Hashtable;

public abstract class Environment
extends PropertySet {
    static Environment global;
    static final int CAN_DEFINE = 1;
    static final int CAN_REDEFINE = 2;
    static final int CAN_IMPLICITLY_DEFINE = 4;
    static final int THREAD_SAFE = 8;
    static final int DIRECT_INHERITED_ON_SET = 16;
    public static final int INDIRECT_DEFINES = 32;
    int flags = 23;
    static final Hashtable envTable;
    protected static final InheritedLocal curEnvironment;

    public static void setGlobal(Environment env) {
        global = env;
    }

    public static Environment getGlobal() {
        return global;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setFlag(boolean setting, int flag) {
        this.flags = setting ? (this.flags |= flag) : (this.flags &= ~flag);
    }

    public boolean getCanDefine() {
        return (this.flags & 1) != 0;
    }

    public void setCanDefine(boolean canDefine) {
        this.flags = canDefine ? (this.flags |= 1) : (this.flags &= -2);
    }

    public boolean getCanRedefine() {
        return (this.flags & 2) != 0;
    }

    public void setCanRedefine(boolean canRedefine) {
        this.flags = canRedefine ? (this.flags |= 2) : (this.flags &= -3);
    }

    public final boolean isLocked() {
        return (this.flags & 3) == 0;
    }

    public void setLocked() {
        this.flags &= -8;
    }

    public final void setIndirectDefines() {
        this.flags |= 32;
        ((InheritingEnvironment)this).baseTimestamp = Integer.MAX_VALUE;
    }

    public final Location getLocation(Symbol key, Object property) {
        return this.getLocation(key, property, true);
    }

    public final Location getLocation(Symbol key) {
        return this.getLocation(key, null, true);
    }

    public final Location lookup(Symbol key, Object property) {
        return this.getLocation(key, property, false);
    }

    public abstract NamedLocation lookup(Symbol var1, Object var2, int var3);

    public final Location lookup(Symbol key) {
        return this.getLocation(key, null, false);
    }

    public abstract NamedLocation getLocation(Symbol var1, Object var2, int var3, boolean var4);

    public final NamedLocation getLocation(Symbol name, Object property, boolean create) {
        int hash = name.hashCode() ^ System.identityHashCode(property);
        return this.getLocation(name, property, hash, create);
    }

    public final Location getLocation(Object key, boolean create) {
        Object property = null;
        if (key instanceof EnvironmentKey) {
            EnvironmentKey k = (EnvironmentKey)key;
            key = k.getKeySymbol();
            property = k.getKeyProperty();
        }
        Symbol sym = key instanceof Symbol ? (Symbol)key : this.getSymbol((String)key);
        return this.getLocation(sym, property, create);
    }

    public boolean isBound(Symbol key, Object property) {
        Location loc = this.lookup(key, property);
        if (loc == null) {
            return false;
        }
        return loc.isBound();
    }

    public final boolean isBound(Symbol key) {
        return this.isBound(key, null);
    }

    public final boolean containsKey(Object key) {
        Object property = null;
        if (key instanceof EnvironmentKey) {
            EnvironmentKey k = (EnvironmentKey)key;
            key = k.getKeySymbol();
            property = k.getKeyProperty();
        }
        Symbol sym = key instanceof Symbol ? (Symbol)key : this.getSymbol((String)key);
        return this.isBound(sym, property);
    }

    public final Object getChecked(String name) {
        Object value = this.get(name, (Object)Location.UNBOUND);
        if (value == Location.UNBOUND) {
            throw new UnboundLocationException(name + " in " + this);
        }
        return value;
    }

    public Object get(Symbol key, Object property, Object defaultValue) {
        Location loc = this.lookup(key, property);
        if (loc == null) {
            return defaultValue;
        }
        return loc.get(defaultValue);
    }

    public final Object get(EnvironmentKey key, Object defaultValue) {
        Symbol symbol = key.getKeySymbol();
        Object property = key.getKeyProperty();
        return this.get(symbol, property, defaultValue);
    }

    public final Object get(String key, Object defaultValue) {
        return this.get(this.getSymbol(key), null, defaultValue);
    }

    public Object get(Symbol sym) {
        String unb = Location.UNBOUND;
        Object val = this.get(sym, null, unb);
        if (val == unb) {
            throw new UnboundLocationException(sym);
        }
        return val;
    }

    public final Object getFunction(Symbol key, Object defaultValue) {
        return this.get(key, EnvironmentKey.FUNCTION, defaultValue);
    }

    public final Object getFunction(Symbol sym) {
        String unb = Location.UNBOUND;
        Object val = this.get(sym, EnvironmentKey.FUNCTION, unb);
        if (val == unb) {
            throw new UnboundLocationException(sym);
        }
        return val;
    }

    public final Object get(Object key) {
        Object property = null;
        if (key instanceof EnvironmentKey) {
            EnvironmentKey k = (EnvironmentKey)key;
            key = k.getKeySymbol();
            property = k.getKeyProperty();
        }
        Symbol sym = key instanceof Symbol ? (Symbol)key : this.getSymbol((String)key);
        return this.get(sym, property, null);
    }

    public void put(Symbol key, Object property, Object newValue) {
        Location loc = this.getLocation(key, property);
        if (loc.isConstant()) {
            this.define(key, property, newValue);
        } else {
            loc.set(newValue);
        }
    }

    public abstract void define(Symbol var1, Object var2, Object var3);

    public final void put(Symbol key, Object newValue) {
        this.put(key, null, newValue);
    }

    public final Object put(Object key, Object newValue) {
        Location loc = this.getLocation(key, true);
        Object oldValue = loc.get(null);
        loc.set(newValue);
        return oldValue;
    }

    public final void putFunction(Symbol key, Object newValue) {
        this.put(key, EnvironmentKey.FUNCTION, newValue);
    }

    public final Object put(String key, Object value) {
        return this.put((Object)key, value);
    }

    public Location unlink(Symbol key, Object property, int hash) {
        throw new RuntimeException("unsupported operation: unlink (aka undefine)");
    }

    public Object remove(Symbol key, Object property, int hash) {
        Location loc = this.unlink(key, property, hash);
        if (loc == null) {
            return null;
        }
        Object value = loc.get(null);
        loc.undefine();
        return value;
    }

    public final Object remove(EnvironmentKey key) {
        Symbol symbol = key.getKeySymbol();
        Object property = key.getKeyProperty();
        int hash = symbol.hashCode() ^ System.identityHashCode(property);
        return this.remove(symbol, property, hash);
    }

    public final Object remove(Symbol symbol, Object property) {
        int hash = symbol.hashCode() ^ System.identityHashCode(property);
        return this.remove(symbol, property, hash);
    }

    public final void remove(Symbol sym) {
        this.remove(sym, null, sym.hashCode());
    }

    public final void removeFunction(Symbol sym) {
        this.remove(sym, EnvironmentKey.FUNCTION);
    }

    public final Object remove(Object key) {
        Object property = null;
        if (key instanceof EnvironmentKey) {
            EnvironmentKey k = (EnvironmentKey)key;
            return this.remove(k.getKeySymbol(), k.getKeyProperty());
        }
        Symbol symbol = key instanceof Symbol ? (Symbol)key : this.getSymbol((String)key);
        int hash = symbol.hashCode() ^ System.identityHashCode(property);
        return this.remove(symbol, property, hash);
    }

    public Namespace defaultNamespace() {
        return Namespace.getDefault();
    }

    public Symbol getSymbol(String name) {
        return this.defaultNamespace().getSymbol(name);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Environment getInstance(String name) {
        if (name == null) {
            name = "";
        }
        Hashtable hashtable2 = envTable;
        synchronized (hashtable2) {
            Environment env = (Environment)envTable.get(name);
            if (env != null) {
                return env;
            }
            env = new SimpleEnvironment();
            env.setName(name);
            envTable.put(name, env);
            return env;
        }
    }

    public abstract LocationEnumeration enumerateLocations();

    public abstract LocationEnumeration enumerateAllLocations();

    protected abstract boolean hasMoreElements(LocationEnumeration var1);

    @Deprecated
    public static Environment current() {
        return Environment.getCurrent();
    }

    public static Environment getCurrent() {
        Environment env = (Environment)curEnvironment.get();
        if (env == null) {
            if (global == null) {
                throw new Error("Environment.global not set - need to do Scheme.registerEnvironment() or similar");
            }
            env = Environment.make(Thread.currentThread().getName(), global);
            env.flags |= 8;
            curEnvironment.set(env);
        }
        return env;
    }

    public static void setCurrent(Environment env) {
        curEnvironment.set(env);
    }

    public static Environment setSaveCurrent(Environment env) {
        Environment save = (Environment)curEnvironment.get();
        curEnvironment.set(env);
        return save;
    }

    public static void restoreCurrent(Environment saved) {
        curEnvironment.set(saved);
    }

    public static Environment user() {
        return Environment.getCurrent();
    }

    public final void addLocation(NamedLocation loc) {
        this.addLocation(loc.getKeySymbol(), loc.getKeyProperty(), loc);
    }

    public abstract NamedLocation addLocation(Symbol var1, Object var2, Location var3);

    public final void addLocation(EnvironmentKey key, Location loc) {
        this.addLocation(key.getKeySymbol(), key.getKeyProperty(), loc);
    }

    public static SimpleEnvironment make() {
        return new SimpleEnvironment();
    }

    public static SimpleEnvironment make(String name) {
        return new SimpleEnvironment(name);
    }

    public static InheritingEnvironment make(String name, Environment parent) {
        return new InheritingEnvironment(name, parent);
    }

    public String toString() {
        return "#<environment " + this.getName() + '>';
    }

    public String toStringVerbose() {
        return this.toString();
    }

    SimpleEnvironment cloneForThread() {
        InheritingEnvironment env = new InheritingEnvironment(null, this);
        if (this instanceof InheritingEnvironment) {
            int numInherited;
            InheritingEnvironment p = (InheritingEnvironment)this;
            env.numInherited = numInherited = p.numInherited;
            env.inherited = new Environment[numInherited];
            for (int i = 0; i < numInherited; ++i) {
                env.inherited[i] = p.inherited[i];
            }
        }
        LocationEnumeration e = this.enumerateLocations();
        while (e.hasMoreElements()) {
            Location loc = e.nextLocation();
            Symbol name = loc.getKeySymbol();
            Object property = loc.getKeyProperty();
            if (name == null || !(loc instanceof NamedLocation)) continue;
            SharedLocation<T> nloc = (SharedLocation<T>)loc;
            if (nloc.base == null) {
                SharedLocation<T> sloc = new SharedLocation<T>(name, property, 0);
                sloc.value = nloc.value;
                nloc.base = sloc;
                nloc.value = null;
                nloc = sloc;
            }
            int hash = name.hashCode() ^ System.identityHashCode(property);
            NamedLocation xloc = env.addUnboundLocation(name, property, hash);
            xloc.base = nloc;
        }
        return env;
    }

    static {
        envTable = new Hashtable<K, V>(50);
        curEnvironment = new InheritedLocal();
    }

    static class InheritedLocal
    extends InheritableThreadLocal<Environment> {
        InheritedLocal() {
        }

        @Override
        protected Environment childValue(Environment parentValue) {
            if (parentValue == null) {
                parentValue = Environment.getCurrent();
            }
            SimpleEnvironment env = parentValue.cloneForThread();
            env.flags |= 8;
            env.flags &= -17;
            return env;
        }
    }

}

