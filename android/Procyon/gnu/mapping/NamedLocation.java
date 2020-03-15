// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.util.Map;

public abstract class NamedLocation<T> extends IndirectableLocation<T> implements Map.Entry<EnvironmentKey, T>, EnvironmentKey
{
    NamedLocation next;
    final Symbol name;
    final Object property;
    
    @Override
    public boolean entered() {
        return this.next != null;
    }
    
    @Override
    public Environment getEnvironment() {
        for (NamedLocation loc = this; loc != null; loc = loc.next) {
            if (loc.name == null) {
                final Environment env = (Environment)loc.value;
                if (env != null) {
                    return env;
                }
            }
        }
        return super.getEnvironment();
    }
    
    public NamedLocation(final NamedLocation loc) {
        this.name = loc.name;
        this.property = loc.property;
    }
    
    public NamedLocation(final Symbol name, final Object property) {
        this.name = name;
        this.property = property;
    }
    
    @Override
    public final Symbol getKeySymbol() {
        return this.name;
    }
    
    @Override
    public final Object getKeyProperty() {
        return this.property;
    }
    
    @Override
    public final boolean matches(final EnvironmentKey key) {
        return Symbol.equals(key.getKeySymbol(), this.name) && key.getKeyProperty() == this.property;
    }
    
    @Override
    public final boolean matches(final Symbol symbol, final Object property) {
        return Symbol.equals(symbol, this.name) && property == this.property;
    }
    
    @Override
    public final EnvironmentKey getKey() {
        if (this.property == null) {
            return this.name;
        }
        return this;
    }
    
    @Override
    public boolean equals(final Object x) {
        if (!(x instanceof NamedLocation)) {
            return false;
        }
        final NamedLocation e2 = (NamedLocation)x;
        Label_0047: {
            if (this.name == null) {
                if (e2.name == null) {
                    break Label_0047;
                }
            }
            else if (this.name.equals(e2.name)) {
                break Label_0047;
            }
            return false;
        }
        if (this.property != e2.property) {
            return false;
        }
        final Object val1 = this.getValue();
        final Object val2 = e2.getValue();
        return val1 == val2 || (val1 != null && val2 != null && val1.equals(val2));
    }
    
    @Override
    public int hashCode() {
        int h = this.name.hashCode() ^ System.identityHashCode(this.property);
        final Object val = this.getValue();
        if (val != null) {
            h ^= val.hashCode();
        }
        return h;
    }
    
    @Override
    public synchronized Object setWithSave(final T newValue) {
        Object old;
        if (this.base != null) {
            if (this.value == NamedLocation.INDIRECT_FLUIDS) {
                return this.base.setWithSave(newValue);
            }
            old = this.base;
            this.base = null;
        }
        else {
            old = this.value;
        }
        this.value = newValue;
        return old;
    }
    
    @Override
    public synchronized void setRestore(final Object oldValue) {
        if (this.value == NamedLocation.INDIRECT_FLUIDS) {
            this.base.setRestore(oldValue);
        }
        else if (oldValue instanceof Location) {
            this.value = null;
            this.base = (Location<T>)oldValue;
        }
        else {
            this.value = oldValue;
            this.base = null;
        }
    }
}
