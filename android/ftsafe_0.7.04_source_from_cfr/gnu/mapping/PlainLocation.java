/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;

public class PlainLocation<T>
extends NamedLocation<T> {
    public PlainLocation(Symbol symbol, Object property) {
        super(symbol, property);
    }

    public PlainLocation(Symbol symbol, Object property, T value) {
        super(symbol, property);
        this.value = value;
    }

    @Override
    public final T get() {
        if (this.base != null) {
            return this.base.get();
        }
        if (this.value == Location.UNBOUND) {
            throw new UnboundLocationException(this);
        }
        return (T)this.value;
    }

    @Override
    public final T get(T defaultValue) {
        return (T)(this.base != null ? this.base.get(defaultValue) : (this.value == Location.UNBOUND ? defaultValue : this.value));
    }

    @Override
    public boolean isBound() {
        return this.base != null ? this.base.isBound() : this.value != Location.UNBOUND;
    }

    @Override
    public final void set(T newValue) {
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

