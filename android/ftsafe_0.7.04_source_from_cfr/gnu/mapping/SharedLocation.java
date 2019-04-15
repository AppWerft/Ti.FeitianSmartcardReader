/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;

public class SharedLocation<T>
extends NamedLocation<T> {
    int timestamp;

    public SharedLocation(Symbol symbol, Object property, int timestamp) {
        super(symbol, property);
        this.timestamp = timestamp;
    }

    @Override
    public final synchronized T get() {
        if (this.base != null) {
            return this.base.get();
        }
        if (this.value == Location.UNBOUND) {
            throw new UnboundLocationException(this);
        }
        return (T)this.value;
    }

    @Override
    public final synchronized T get(T defaultValue) {
        return (T)(this.base != null ? this.base.get(defaultValue) : (this.value == Location.UNBOUND ? defaultValue : this.value));
    }

    @Override
    public synchronized boolean isBound() {
        return this.base != null ? this.base.isBound() : this.value != Location.UNBOUND;
    }

    @Override
    public final synchronized void set(T newValue) {
        if (this.base == null) {
            this.value = newValue;
        } else if (this.value == DIRECT_ON_SET) {
            this.base = null;
            this.value = newValue;
        } else if (this.base.isConstant()) {
            this.getEnvironment().put(this.getKeySymbol(), this.getKeyProperty(), newValue);
        } else {
            this.base.set(newValue);
        }
    }
}

