package gnu.mapping;

import java.lang.ref.WeakReference;
import java.util.Map.Entry;




























































































































































































































































































































class SymbolRef
  extends WeakReference<Symbol>
  implements Map.Entry<String, Symbol>
{
  SymbolRef next;
  
  String getName()
  {
    Symbol sym = getSymbol();
    return sym == null ? null : sym.getName();
  }
  
  SymbolRef(Symbol sym) {
    super(sym);
  }
  
  public String getKey() {
    Symbol sym = getSymbol();
    return sym == null ? null : sym.getName();
  }
  
  public Symbol getValue() {
    return getSymbol();
  }
  
  public int hashCode() {
    Symbol sym = getSymbol();
    return sym == null ? 0 : sym.hashCode();
  }
  
  public Symbol setValue(Symbol value) {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object o) {
    return ((o instanceof SymbolRef)) && (get() == ((SymbolRef)o).get());
  }
  
  Symbol getSymbol()
  {
    return (Symbol)get();
  }
  
  public String toString() {
    return "SymbolRef[" + getSymbol() + "]";
  }
}
