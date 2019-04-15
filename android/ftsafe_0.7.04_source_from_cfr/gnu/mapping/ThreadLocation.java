/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;

public class ThreadLocation<T>
extends NamedLocation<T>
implements Named {
    static int counter;
    static final Object NULL_PROXY;
    private ThreadLocal thLocal;
    private boolean stringName;
    private boolean importedThreadLocal;

    private static synchronized int nextCounter() {
        return ++counter;
    }

    private boolean importedThreadLocal() {
        return this.importedThreadLocal;
    }

    public ThreadLocation() {
        this("param#" + ThreadLocation.nextCounter());
    }

    public ThreadLocation(String name) {
        this(Symbol.makeUninterned(name));
    }

    public ThreadLocation(Symbol name) {
        super(name, null);
        this.thLocal = new ThreadLocalWithDefault<Object>(null);
    }

    public ThreadLocation(Symbol name, ThreadLocal<T> thLocal) {
        super(name, null);
        this.thLocal = thLocal;
        this.importedThreadLocal = true;
    }

    public static ThreadLocation makeAnonymous(String name) {
        ThreadLocation<T> loc = new ThreadLocation<T>(name);
        loc.stringName = true;
        return loc;
    }

    public static ThreadLocation makeAnonymous(Symbol name) {
        return new ThreadLocation<T>(name);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setGlobal(T value) {
        ThreadLocation threadLocation = this;
        synchronized (threadLocation) {
            ((ThreadLocalWithDefault)this.thLocal).setDefault(value);
        }
    }

    @Override
    public T get() {
        Object value = this.thLocal.get();
        if (this.importedThreadLocal()) {
            return value;
        }
        if (value == Location.UNBOUND) {
            throw new UnboundLocationException(this);
        }
        return value == NULL_PROXY ? null : (T)value;
    }

    @Override
    public T get(T defaultValue) {
        Object value = this.thLocal.get();
        if (this.importedThreadLocal()) {
            return value;
        }
        if (value == UNBOUND) {
            return defaultValue;
        }
        return value == NULL_PROXY ? null : (T)value;
    }

    @Override
    public boolean isBound() {
        return this.importedThreadLocal() || this.thLocal.get() != Location.UNBOUND;
    }

    @Override
    public void set(T value) {
        this.thLocal.set(value == null && !this.importedThreadLocal() ? NULL_PROXY : value);
    }

    @Override
    public Object setWithSave(T newValue) {
        Object old = this.thLocal.get();
        this.set(newValue);
        return old;
    }

    @Override
    public void setRestore(Object oldValue) {
        this.thLocal.set(oldValue);
    }

    @Override
    public void undefine() {
        if (this.importedThreadLocal()) {
            this.thLocal.remove();
        } else {
            this.thLocal.set(UNBOUND);
        }
    }

    @Override
    public String getName() {
        return this.name == null ? null : this.name.toString();
    }

    @Override
    public Object getSymbol() {
        if (this.stringName) {
            return this.name.toString();
        }
        return this.name;
    }

    @Override
    public void setName(String name) {
        throw new RuntimeException("setName not allowed");
    }

    static {
        NULL_PROXY = new Object();
    }

    static class ThreadLocalWithDefault<T>
    extends InheritableThreadLocal<T> {
        T defaultValue;

        public ThreadLocalWithDefault(T defaultValue) {
            this.defaultValue = defaultValue;
        }

        public void setDefault(T value) {
            this.defaultValue = value;
        }

        @Override
        protected T initialValue() {
            return this.defaultValue;
        }
    }

}

