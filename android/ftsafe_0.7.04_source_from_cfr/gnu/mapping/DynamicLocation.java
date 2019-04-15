/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Environment;
import gnu.mapping.IndirectableLocation;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.NamedLocation;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.Symbol;

public class DynamicLocation<T>
extends NamedLocation<T>
implements Named {
    private int hash;
    static SimpleEnvironment env;

    public DynamicLocation(Symbol name, Object property) {
        super(name, property);
        this.hash = name.hashCode() ^ System.identityHashCode(property);
    }

    public NamedLocation<T> getLocation() {
        Environment curenv = Environment.getCurrent();
        NamedLocation loc = curenv.getLocation(this.name, this.property, this.hash, true);
        return loc;
    }

    @Override
    public T get() {
        return this.getLocation().get();
    }

    @Override
    public T get(T defaultValue) {
        return this.getLocation().get(defaultValue);
    }

    @Override
    public boolean isBound() {
        return this.getLocation().isBound();
    }

    @Override
    public void set(T value) {
        this.getLocation().set(value);
    }

    @Override
    public Object setWithSave(T newValue) {
        return this.getLocation().setWithSave(newValue);
    }

    @Override
    public void setRestore(Object oldValue) {
        this.getLocation().setRestore(oldValue);
    }

    @Override
    public void undefine() {
        this.getLocation().undefine();
    }

    @Override
    public String getName() {
        return this.name == null ? null : this.name.toString();
    }

    @Override
    public Object getSymbol() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        throw new RuntimeException("setName not allowed");
    }

    public static synchronized DynamicLocation getInstance(Symbol name, Object property) {
        if (env == null) {
            env = new SimpleEnvironment("[thread-locations]");
        }
        IndirectableLocation loc = (IndirectableLocation)env.getLocation(name, property);
        if (loc.base != null) {
            return (DynamicLocation)loc.base;
        }
        DynamicLocation<T> tloc = new DynamicLocation<T>(name, property);
        loc.base = tloc;
        return tloc;
    }
}

