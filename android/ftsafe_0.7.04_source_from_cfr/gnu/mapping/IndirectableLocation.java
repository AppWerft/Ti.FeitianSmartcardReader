/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.NamedLocation;
import gnu.mapping.PlainLocation;
import gnu.mapping.Symbol;

public abstract class IndirectableLocation<T>
extends Location<T> {
    protected static final Object DIRECT_ON_SET = new String("(direct-on-set)");
    protected static final Object INDIRECT_FLUIDS = new String("(indirect-fluids)");
    protected Location<T> base;
    protected Object value;

    @Override
    public Symbol getKeySymbol() {
        return this.base != null ? this.base.getKeySymbol() : null;
    }

    @Override
    public Object getKeyProperty() {
        return this.base != null ? this.base.getKeyProperty() : null;
    }

    @Override
    public boolean isConstant() {
        return this.base != null && this.base.isConstant();
    }

    @Override
    public Location getBase() {
        return this.base == null ? this : this.base.getBase();
    }

    public Location getBaseForce() {
        if (this.base == null) {
            return new PlainLocation<Object>(this.getKeySymbol(), this.getKeyProperty(), this.value);
        }
        return this.base;
    }

    public void setBase(Location base2) {
        this.base = base2;
        this.value = null;
    }

    public void setAlias(Location base2) {
        this.base = base2;
        this.value = INDIRECT_FLUIDS;
    }

    @Override
    public void undefine() {
        this.base = null;
        this.value = UNBOUND;
    }

    public Environment getEnvironment() {
        return this.base instanceof NamedLocation ? ((NamedLocation)this.base).getEnvironment() : null;
    }
}

