// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class KeyPair implements EnvironmentKey
{
    Symbol name;
    Object property;
    
    public KeyPair(final Symbol name, final Object property) {
        this.name = name;
        this.property = property;
    }
    
    @Override
    public Symbol getKeySymbol() {
        return this.name;
    }
    
    @Override
    public Object getKeyProperty() {
        return this.property;
    }
    
    @Override
    public final boolean matches(final EnvironmentKey key) {
        return Symbol.equals(key.getKeySymbol(), this.name) && key.getKeyProperty() == this.property;
    }
    
    @Override
    public final boolean matches(final Symbol symbol, final Object property) {
        return Symbol.equals(symbol, this.name) && property == this.property;
    }
    
    @Override
    public boolean equals(final Object x) {
        if (!(x instanceof KeyPair)) {
            return false;
        }
        final KeyPair e2 = (KeyPair)x;
        return this.property == e2.property && ((this.name != null) ? this.name.equals(e2.name) : (e2.name == null));
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode() ^ System.identityHashCode(this.property);
    }
    
    @Override
    public String toString() {
        return "KeyPair[sym:" + this.name + " prop:" + this.property + "]";
    }
}
