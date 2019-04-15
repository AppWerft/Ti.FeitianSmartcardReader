/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;

public class ConstrainedLocation<T>
extends Location<T> {
    protected Location<T> base;
    protected Procedure converter;

    public static <T> ConstrainedLocation<T> make(Location<T> base2, Procedure converter) {
        ConstrainedLocation<T> cloc = new ConstrainedLocation<T>();
        cloc.base = base2;
        cloc.converter = converter;
        return cloc;
    }

    @Override
    public Symbol getKeySymbol() {
        return this.base == null ? null : this.base.getKeySymbol();
    }

    @Override
    public Object getKeyProperty() {
        return this.base.getKeyProperty();
    }

    @Override
    public boolean isConstant() {
        return this.base.isConstant();
    }

    @Override
    public final T get() {
        return this.base.get();
    }

    @Override
    public final T get(T defaultValue) {
        return this.base.get(defaultValue);
    }

    @Override
    public boolean isBound() {
        return this.base.isBound();
    }

    protected T coerce(T newValue) {
        try {
            return (T)this.converter.apply1(newValue);
        }
        catch (Throwable ex) {
            throw WrappedException.rethrow(ex);
        }
    }

    @Override
    public final void set(T newValue) {
        this.base.set(this.coerce(newValue));
    }

    @Override
    public void undefine() {
        this.base.undefine();
    }

    @Override
    public Object setWithSave(T newValue) {
        return this.base.setWithSave(this.coerce(newValue));
    }

    @Override
    public void setRestore(Object oldValue) {
        this.base.setRestore(oldValue);
    }
}

