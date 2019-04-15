/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.IndirectableLocation;
import gnu.mapping.Location;
import gnu.mapping.Symbol;
import java.util.Map;

public abstract class NamedLocation<T>
extends IndirectableLocation<T>
implements Map.Entry<EnvironmentKey, T>,
EnvironmentKey {
    NamedLocation next;
    final Symbol name;
    final Object property;

    @Override
    public boolean entered() {
        return this.next != null;
    }

    @Override
    public Environment getEnvironment() {
        NamedLocation loc = this;
        while (loc != null) {
            Environment env;
            if (loc.name == null && (env = (Environment)loc.value) != null) {
                return env;
            }
            loc = loc.next;
        }
        return super.getEnvironment();
    }

    public NamedLocation(NamedLocation loc) {
        this.name = loc.name;
        this.property = loc.property;
    }

    public NamedLocation(Symbol name, Object property) {
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
    public final boolean matches(EnvironmentKey key) {
        return Symbol.equals(key.getKeySymbol(), this.name) && key.getKeyProperty() == this.property;
    }

    @Override
    public final boolean matches(Symbol symbol, Object property) {
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
    public boolean equals(Object x) {
        Object val2;
        if (!(x instanceof NamedLocation)) {
            return false;
        }
        NamedLocation e2 = (NamedLocation)x;
        if (this.name == null ? e2.name != null : !this.name.equals(e2.name)) {
            return false;
        }
        if (this.property != e2.property) {
            return false;
        }
        Object val1 = this.getValue();
        if (val1 == (val2 = e2.getValue())) {
            return true;
        }
        if (val1 == null || val2 == null) {
            return false;
        }
        return val1.equals(val2);
    }

    @Override
    public int hashCode() {
        int h = this.name.hashCode() ^ System.identityHashCode(this.property);
        Object val = this.getValue();
        if (val != null) {
            h ^= val.hashCode();
        }
        return h;
    }

    @Override
    public synchronized Object setWithSave(T newValue) {
        Object old;
        if (this.base != null) {
            if (this.value == INDIRECT_FLUIDS) {
                return this.base.setWithSave(newValue);
            }
            old = this.base;
            this.base = null;
        } else {
            old = this.value;
        }
        this.value = newValue;
        return old;
    }

    @Override
    public synchronized void setRestore(Object oldValue) {
        if (this.value == INDIRECT_FLUIDS) {
            this.base.setRestore(oldValue);
        } else if (oldValue instanceof Location) {
            this.value = null;
            this.base = (Location)oldValue;
        } else {
            this.value = oldValue;
            this.base = null;
        }
    }
}

