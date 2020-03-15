// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.util.Map;
import java.lang.ref.WeakReference;

class SymbolRef extends WeakReference<Symbol> implements Map.Entry<String, Symbol>
{
    SymbolRef next;
    
    String getName() {
        final Symbol sym = this.getSymbol();
        return (sym == null) ? null : sym.getName();
    }
    
    SymbolRef(final Symbol sym) {
        super(sym);
    }
    
    @Override
    public String getKey() {
        final Symbol sym = this.getSymbol();
        return (sym == null) ? null : sym.getName();
    }
    
    @Override
    public Symbol getValue() {
        return this.getSymbol();
    }
    
    @Override
    public int hashCode() {
        final Symbol sym = this.getSymbol();
        return (sym == null) ? 0 : sym.hashCode();
    }
    
    @Override
    public Symbol setValue(final Symbol value) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof SymbolRef && this.get() == ((SymbolRef)o).get();
    }
    
    Symbol getSymbol() {
        return this.get();
    }
    
    @Override
    public String toString() {
        return "SymbolRef[" + this.getSymbol() + "]";
    }
}
