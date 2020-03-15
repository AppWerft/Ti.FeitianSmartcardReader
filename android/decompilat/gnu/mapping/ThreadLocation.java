// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class ThreadLocation<T> extends NamedLocation<T> implements Named
{
    static int counter;
    static final Object NULL_PROXY;
    private ThreadLocal thLocal;
    private boolean stringName;
    private boolean importedThreadLocal;
    
    private static synchronized int nextCounter() {
        return ++ThreadLocation.counter;
    }
    
    private boolean importedThreadLocal() {
        return this.importedThreadLocal;
    }
    
    public ThreadLocation() {
        this("param#" + nextCounter());
    }
    
    public ThreadLocation(final String name) {
        this(Symbol.makeUninterned(name));
    }
    
    public ThreadLocation(final Symbol name) {
        super(name, null);
        this.thLocal = new ThreadLocalWithDefault(null);
    }
    
    public ThreadLocation(final Symbol name, final ThreadLocal<T> thLocal) {
        super(name, null);
        this.thLocal = thLocal;
        this.importedThreadLocal = true;
    }
    
    public static ThreadLocation makeAnonymous(final String name) {
        final ThreadLocation loc = new ThreadLocation(name);
        loc.stringName = true;
        return loc;
    }
    
    public static ThreadLocation makeAnonymous(final Symbol name) {
        return new ThreadLocation(name);
    }
    
    public void setGlobal(final T value) {
        synchronized (this) {
            ((ThreadLocalWithDefault)this.thLocal).setDefault(value);
        }
    }
    
    @Override
    public T get() {
        final Object value = this.thLocal.get();
        if (this.importedThreadLocal()) {
            return (T)value;
        }
        if (value == Location.UNBOUND) {
            throw new UnboundLocationException(this);
        }
        return (T)((value == ThreadLocation.NULL_PROXY) ? null : value);
    }
    
    @Override
    public T get(final T defaultValue) {
        final Object value = this.thLocal.get();
        if (this.importedThreadLocal()) {
            return (T)value;
        }
        if (value == ThreadLocation.UNBOUND) {
            return defaultValue;
        }
        return (T)((value == ThreadLocation.NULL_PROXY) ? null : value);
    }
    
    @Override
    public boolean isBound() {
        return this.importedThreadLocal() || this.thLocal.get() != Location.UNBOUND;
    }
    
    @Override
    public void set(final T value) {
        this.thLocal.set((value == null && !this.importedThreadLocal()) ? ThreadLocation.NULL_PROXY : value);
    }
    
    @Override
    public Object setWithSave(final T newValue) {
        final Object old = this.thLocal.get();
        this.set(newValue);
        return old;
    }
    
    @Override
    public void setRestore(final Object oldValue) {
        this.thLocal.set(oldValue);
    }
    
    @Override
    public void undefine() {
        if (this.importedThreadLocal()) {
            this.thLocal.remove();
        }
        else {
            this.thLocal.set(ThreadLocation.UNBOUND);
        }
    }
    
    @Override
    public String getName() {
        return (this.name == null) ? null : this.name.toString();
    }
    
    @Override
    public Object getSymbol() {
        if (this.stringName) {
            return this.name.toString();
        }
        return this.name;
    }
    
    @Override
    public void setName(final String name) {
        throw new RuntimeException("setName not allowed");
    }
    
    static {
        NULL_PROXY = new Object();
    }
    
    static class ThreadLocalWithDefault<T> extends InheritableThreadLocal<T>
    {
        T defaultValue;
        
        public ThreadLocalWithDefault(final T defaultValue) {
            this.defaultValue = defaultValue;
        }
        
        public void setDefault(final T value) {
            this.defaultValue = value;
        }
        
        @Override
        protected T initialValue() {
            return this.defaultValue;
        }
    }
}
