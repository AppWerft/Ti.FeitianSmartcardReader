// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class ConstrainedLocation<T> extends Location<T>
{
    protected Location<T> base;
    protected Procedure converter;
    
    public static <T> ConstrainedLocation<T> make(final Location<T> base, final Procedure converter) {
        final ConstrainedLocation<T> cloc = new ConstrainedLocation<T>();
        cloc.base = base;
        cloc.converter = converter;
        return cloc;
    }
    
    @Override
    public Symbol getKeySymbol() {
        return (this.base == null) ? null : this.base.getKeySymbol();
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
    public final T get(final T defaultValue) {
        return this.base.get(defaultValue);
    }
    
    @Override
    public boolean isBound() {
        return this.base.isBound();
    }
    
    protected T coerce(final T newValue) {
        try {
            return (T)this.converter.apply1(newValue);
        }
        catch (Throwable ex) {
            throw WrappedException.rethrow(ex);
        }
    }
    
    @Override
    public final void set(final T newValue) {
        this.base.set(this.coerce(newValue));
    }
    
    @Override
    public void undefine() {
        this.base.undefine();
    }
    
    @Override
    public Object setWithSave(final T newValue) {
        return this.base.setWithSave(this.coerce(newValue));
    }
    
    @Override
    public void setRestore(final Object oldValue) {
        this.base.setRestore(oldValue);
    }
}
