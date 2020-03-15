// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public abstract class IndirectableLocation<T> extends Location<T>
{
    protected static final Object DIRECT_ON_SET;
    protected static final Object INDIRECT_FLUIDS;
    protected Location<T> base;
    protected Object value;
    
    @Override
    public Symbol getKeySymbol() {
        return (this.base != null) ? this.base.getKeySymbol() : null;
    }
    
    @Override
    public Object getKeyProperty() {
        return (this.base != null) ? this.base.getKeyProperty() : null;
    }
    
    @Override
    public boolean isConstant() {
        return this.base != null && this.base.isConstant();
    }
    
    @Override
    public Location getBase() {
        return (this.base == null) ? this : this.base.getBase();
    }
    
    public Location getBaseForce() {
        if (this.base == null) {
            return new PlainLocation(this.getKeySymbol(), this.getKeyProperty(), this.value);
        }
        return this.base;
    }
    
    public void setBase(final Location base) {
        this.base = (Location<T>)base;
        this.value = null;
    }
    
    public void setAlias(final Location base) {
        this.base = (Location<T>)base;
        this.value = IndirectableLocation.INDIRECT_FLUIDS;
    }
    
    @Override
    public void undefine() {
        this.base = null;
        this.value = IndirectableLocation.UNBOUND;
    }
    
    public Environment getEnvironment() {
        return (this.base instanceof NamedLocation) ? ((NamedLocation)this.base).getEnvironment() : null;
    }
    
    static {
        DIRECT_ON_SET = new String("(direct-on-set)");
        INDIRECT_FLUIDS = new String("(indirect-fluids)");
    }
}
