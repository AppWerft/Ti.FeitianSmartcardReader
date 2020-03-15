// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class ReadOnlyLocation extends ConstrainedLocation
{
    public static ReadOnlyLocation make(final Location base) {
        final ReadOnlyLocation rloc = new ReadOnlyLocation();
        rloc.base = (Location<T>)base;
        return rloc;
    }
    
    @Override
    public boolean isConstant() {
        return true;
    }
    
    @Override
    protected Object coerce(final Object newValue) {
        final StringBuffer sbuf = new StringBuffer("attempt to modify read-only location");
        final Symbol name = this.getKeySymbol();
        if (name != null) {
            sbuf.append(": ");
            sbuf.append(name);
        }
        throw new IllegalStateException(sbuf.toString());
    }
}
