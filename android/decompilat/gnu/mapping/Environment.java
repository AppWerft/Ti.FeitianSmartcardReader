// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.util.Hashtable;

public abstract class Environment extends PropertySet
{
    static Environment global;
    static final int CAN_DEFINE = 1;
    static final int CAN_REDEFINE = 2;
    static final int CAN_IMPLICITLY_DEFINE = 4;
    static final int THREAD_SAFE = 8;
    static final int DIRECT_INHERITED_ON_SET = 16;
    public static final int INDIRECT_DEFINES = 32;
    int flags;
    static final Hashtable envTable;
    protected static final InheritedLocal curEnvironment;
    
    public Environment() {
        this.flags = 23;
    }
    
    public static void setGlobal(final Environment env) {
        Environment.global = env;
    }
    
    public static Environment getGlobal() {
        return Environment.global;
    }
    
    public int getFlags() {
        return this.flags;
    }
    
    public void setFlag(final boolean setting, final int flag) {
        if (setting) {
            this.flags |= flag;
        }
        else {
            this.flags &= ~flag;
        }
    }
    
    public boolean getCanDefine() {
        return (this.flags & 0x1) != 0x0;
    }
    
    public void setCanDefine(final boolean canDefine) {
        if (canDefine) {
            this.flags |= 0x1;
        }
        else {
            this.flags &= 0xFFFFFFFE;
        }
    }
    
    public boolean getCanRedefine() {
        return (this.flags & 0x2) != 0x0;
    }
    
    public void setCanRedefine(final boolean canRedefine) {
        if (canRedefine) {
            this.flags |= 0x2;
        }
        else {
            this.flags &= 0xFFFFFFFD;
        }
    }
    
    public final boolean isLocked() {
        return (this.flags & 0x3) == 0x0;
    }
    
    public void setLocked() {
        this.flags &= 0xFFFFFFF8;
    }
    
    public final void setIndirectDefines() {
        this.flags |= 0x20;
        ((InheritingEnvironment)this).baseTimestamp = Integer.MAX_VALUE;
    }
    
    public final Location getLocation(final Symbol key, final Object property) {
        return this.getLocation(key, property, true);
    }
    
    public final Location getLocation(final Symbol key) {
        return this.getLocation(key, null, true);
    }
    
    public final Location lookup(final Symbol key, final Object property) {
        return this.getLocation(key, property, false);
    }
    
    public abstract NamedLocation lookup(final Symbol p0, final Object p1, final int p2);
    
    public final Location lookup(final Symbol key) {
        return this.getLocation(key, null, false);
    }
    
    public abstract NamedLocation getLocation(final Symbol p0, final Object p1, final int p2, final boolean p3);
    
    public final NamedLocation getLocation(final Symbol name, final Object property, final boolean create) {
        final int hash = name.hashCode() ^ System.identityHashCode(property);
        return this.getLocation(name, property, hash, create);
    }
    
    public final Location getLocation(Object key, final boolean create) {
        Object property = null;
        if (key instanceof EnvironmentKey) {
            final EnvironmentKey k = (EnvironmentKey)key;
            key = k.getKeySymbol();
            property = k.getKeyProperty();
        }
        final Symbol sym = (Symbol)((key instanceof Symbol) ? key : this.getSymbol((String)key));
        return this.getLocation(sym, property, create);
    }
    
    public boolean isBound(final Symbol key, final Object property) {
        final Location loc = this.lookup(key, property);
        return loc != null && loc.isBound();
    }
    
    public final boolean isBound(final Symbol key) {
        return this.isBound(key, null);
    }
    
    public final boolean containsKey(Object key) {
        Object property = null;
        if (key instanceof EnvironmentKey) {
            final EnvironmentKey k = (EnvironmentKey)key;
            key = k.getKeySymbol();
            property = k.getKeyProperty();
        }
        final Symbol sym = (Symbol)((key instanceof Symbol) ? key : this.getSymbol((String)key));
        return this.isBound(sym, property);
    }
    
    public final Object getChecked(final String name) {
        final Object value = this.get(name, Location.UNBOUND);
        if (value == Location.UNBOUND) {
            throw new UnboundLocationException((Object)(name + " in " + this));
        }
        return value;
    }
    
    public Object get(final Symbol key, final Object property, final Object defaultValue) {
        final Location loc = this.lookup(key, property);
        if (loc == null) {
            return defaultValue;
        }
        return loc.get(defaultValue);
    }
    
    public final Object get(final EnvironmentKey key, final Object defaultValue) {
        final Symbol symbol = key.getKeySymbol();
        final Object property = key.getKeyProperty();
        return this.get(symbol, property, defaultValue);
    }
    
    public final Object get(final String key, final Object defaultValue) {
        return this.get(this.getSymbol(key), null, defaultValue);
    }
    
    public Object get(final Symbol sym) {
        final Object unb = Location.UNBOUND;
        final Object val = this.get(sym, null, unb);
        if (val == unb) {
            throw new UnboundLocationException(sym);
        }
        return val;
    }
    
    public final Object getFunction(final Symbol key, final Object defaultValue) {
        return this.get(key, EnvironmentKey.FUNCTION, defaultValue);
    }
    
    public final Object getFunction(final Symbol sym) {
        final Object unb = Location.UNBOUND;
        final Object val = this.get(sym, EnvironmentKey.FUNCTION, unb);
        if (val == unb) {
            throw new UnboundLocationException(sym);
        }
        return val;
    }
    
    public final Object get(Object key) {
        Object property = null;
        if (key instanceof EnvironmentKey) {
            final EnvironmentKey k = (EnvironmentKey)key;
            key = k.getKeySymbol();
            property = k.getKeyProperty();
        }
        final Symbol sym = (Symbol)((key instanceof Symbol) ? key : this.getSymbol((String)key));
        return this.get(sym, property, null);
    }
    
    public void put(final Symbol key, final Object property, final Object newValue) {
        final Location loc = this.getLocation(key, property);
        if (loc.isConstant()) {
            this.define(key, property, newValue);
        }
        else {
            loc.set(newValue);
        }
    }
    
    public abstract void define(final Symbol p0, final Object p1, final Object p2);
    
    public final void put(final Symbol key, final Object newValue) {
        this.put(key, null, newValue);
    }
    
    public final Object put(final Object key, final Object newValue) {
        final Location loc = this.getLocation(key, true);
        final Object oldValue = loc.get(null);
        loc.set(newValue);
        return oldValue;
    }
    
    public final void putFunction(final Symbol key, final Object newValue) {
        this.put(key, EnvironmentKey.FUNCTION, newValue);
    }
    
    public final Object put(final String key, final Object value) {
        return this.put((Object)key, value);
    }
    
    public Location unlink(final Symbol key, final Object property, final int hash) {
        throw new RuntimeException("unsupported operation: unlink (aka undefine)");
    }
    
    public Object remove(final Symbol key, final Object property, final int hash) {
        final Location loc = this.unlink(key, property, hash);
        if (loc == null) {
            return null;
        }
        final Object value = loc.get(null);
        loc.undefine();
        return value;
    }
    
    public final Object remove(final EnvironmentKey key) {
        final Symbol symbol = key.getKeySymbol();
        final Object property = key.getKeyProperty();
        final int hash = symbol.hashCode() ^ System.identityHashCode(property);
        return this.remove(symbol, property, hash);
    }
    
    public final Object remove(final Symbol symbol, final Object property) {
        final int hash = symbol.hashCode() ^ System.identityHashCode(property);
        return this.remove(symbol, property, hash);
    }
    
    public final void remove(final Symbol sym) {
        this.remove(sym, null, sym.hashCode());
    }
    
    public final void removeFunction(final Symbol sym) {
        this.remove(sym, EnvironmentKey.FUNCTION);
    }
    
    public final Object remove(final Object key) {
        final Object property = null;
        if (key instanceof EnvironmentKey) {
            final EnvironmentKey k = (EnvironmentKey)key;
            return this.remove(k.getKeySymbol(), k.getKeyProperty());
        }
        final Symbol symbol = (Symbol)((key instanceof Symbol) ? key : this.getSymbol((String)key));
        final int hash = symbol.hashCode() ^ System.identityHashCode(property);
        return this.remove(symbol, property, hash);
    }
    
    public Namespace defaultNamespace() {
        return Namespace.getDefault();
    }
    
    public Symbol getSymbol(final String name) {
        return this.defaultNamespace().getSymbol(name);
    }
    
    public static Environment getInstance(String name) {
        if (name == null) {
            name = "";
        }
        synchronized (Environment.envTable) {
            Environment env = Environment.envTable.get(name);
            if (env != null) {
                return env;
            }
            env = new SimpleEnvironment();
            env.setName(name);
            Environment.envTable.put(name, env);
            return env;
        }
    }
    
    public abstract LocationEnumeration enumerateLocations();
    
    public abstract LocationEnumeration enumerateAllLocations();
    
    protected abstract boolean hasMoreElements(final LocationEnumeration p0);
    
    @Deprecated
    public static Environment current() {
        return getCurrent();
    }
    
    public static Environment getCurrent() {
        Environment env = Environment.curEnvironment.get();
        if (env == null) {
            if (Environment.global == null) {
                throw new Error("Environment.global not set - need to do Scheme.registerEnvironment() or similar");
            }
            final InheritingEnvironment make;
            env = (make = make(Thread.currentThread().getName(), Environment.global));
            make.flags |= 0x8;
            Environment.curEnvironment.set(env);
        }
        return env;
    }
    
    public static void setCurrent(final Environment env) {
        Environment.curEnvironment.set(env);
    }
    
    public static Environment setSaveCurrent(final Environment env) {
        final Environment save = Environment.curEnvironment.get();
        Environment.curEnvironment.set(env);
        return save;
    }
    
    public static void restoreCurrent(final Environment saved) {
        Environment.curEnvironment.set(saved);
    }
    
    public static Environment user() {
        return getCurrent();
    }
    
    public final void addLocation(final NamedLocation loc) {
        this.addLocation(loc.getKeySymbol(), loc.getKeyProperty(), loc);
    }
    
    public abstract NamedLocation addLocation(final Symbol p0, final Object p1, final Location p2);
    
    public final void addLocation(final EnvironmentKey key, final Location loc) {
        this.addLocation(key.getKeySymbol(), key.getKeyProperty(), loc);
    }
    
    public static SimpleEnvironment make() {
        return new SimpleEnvironment();
    }
    
    public static SimpleEnvironment make(final String name) {
        return new SimpleEnvironment(name);
    }
    
    public static InheritingEnvironment make(final String name, final Environment parent) {
        return new InheritingEnvironment(name, parent);
    }
    
    @Override
    public String toString() {
        return "#<environment " + this.getName() + '>';
    }
    
    public String toStringVerbose() {
        return this.toString();
    }
    
    SimpleEnvironment cloneForThread() {
        final InheritingEnvironment env = new InheritingEnvironment(null, this);
        if (this instanceof InheritingEnvironment) {
            final InheritingEnvironment p = (InheritingEnvironment)this;
            final int numInherited = p.numInherited;
            env.numInherited = numInherited;
            env.inherited = new Environment[numInherited];
            for (int i = 0; i < numInherited; ++i) {
                env.inherited[i] = p.inherited[i];
            }
        }
        final LocationEnumeration e = this.enumerateLocations();
        while (e.hasMoreElements()) {
            final Location loc = e.nextLocation();
            final Symbol name = loc.getKeySymbol();
            final Object property = loc.getKeyProperty();
            if (name != null && loc instanceof NamedLocation) {
                NamedLocation nloc = (NamedLocation)loc;
                if (nloc.base == null) {
                    final SharedLocation sloc = new SharedLocation(name, property, 0);
                    sloc.value = nloc.value;
                    nloc.base = (Location<T>)sloc;
                    nloc.value = null;
                    nloc = sloc;
                }
                final int hash = name.hashCode() ^ System.identityHashCode(property);
                final NamedLocation xloc = env.addUnboundLocation(name, property, hash);
                xloc.base = (Location<T>)nloc;
            }
        }
        return env;
    }
    
    static {
        envTable = new Hashtable(50);
        curEnvironment = new InheritedLocal();
    }
    
    static class InheritedLocal extends InheritableThreadLocal<Environment>
    {
        @Override
        protected Environment childValue(Environment parentValue) {
            if (parentValue == null) {
                parentValue = Environment.getCurrent();
            }
            final SimpleEnvironment cloneForThread;
            final SimpleEnvironment env = cloneForThread = parentValue.cloneForThread();
            cloneForThread.flags |= 0x8;
            final SimpleEnvironment simpleEnvironment = env;
            simpleEnvironment.flags &= 0xFFFFFFEF;
            return env;
        }
    }
}
