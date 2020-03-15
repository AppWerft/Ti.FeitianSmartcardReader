// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class PlainLocation<T> extends NamedLocation<T>
{
    public PlainLocation(final Symbol symbol, final Object property) {
        super(symbol, property);
    }
    
    public PlainLocation(final Symbol symbol, final Object property, final T value) {
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
    public final T get(final T defaultValue) {
        return (T)((this.base != null) ? this.base.get(defaultValue) : ((this.value == Location.UNBOUND) ? defaultValue : this.value));
    }
    
    @Override
    public boolean isBound() {
        return (this.base != null) ? this.base.isBound() : (this.value != Location.UNBOUND);
    }
    
    @Override
    public final void set(final T newValue) {
        if (this.base == null) {
            this.value = newValue;
        }
        else if (this.value == PlainLocation.DIRECT_ON_SET) {
            this.base = null;
            this.value = newValue;
        }
        else if (this.base.isConstant()) {
            this.getEnvironment().put(this.getKeySymbol(), this.getKeyProperty(), newValue);
        }
        else {
            this.base.set(newValue);
        }
    }
}
