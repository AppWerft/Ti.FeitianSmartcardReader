// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class ImmutablePair extends Pair
{
    public ImmutablePair(final Object carval, final Object cdrval) {
        super(carval, cdrval);
    }
    
    public ImmutablePair() {
    }
    
    @Override
    public void setCar(final Object car) {
        throw new UnsupportedOperationException("cannot modify read-only pair");
    }
    
    @Override
    public void setCdr(final Object cdr) {
        throw new UnsupportedOperationException("cannot modify read-only pair");
    }
}
