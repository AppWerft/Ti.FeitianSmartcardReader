// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public interface EnvironmentKey
{
    public static final Object FUNCTION = Symbol.FUNCTION;
    
    Symbol getKeySymbol();
    
    Object getKeyProperty();
    
    boolean matches(final EnvironmentKey p0);
    
    boolean matches(final Symbol p0, final Object p1);
}
