package gnu.expr;

import gnu.mapping.Symbol;






public abstract class AccessExp
  extends Expression
{
  public static final int PREFER_BINDING2 = 2;
  public static final int NEXT_AVAIL_FLAG = 4;
  Object symbol;
  Declaration binding;
  private Declaration context;
  
  public AccessExp() {}
  
  public String string_name()
  {
    return symbol.toString();
  }
  
  public final String getName() {
    return (symbol instanceof Symbol) ? ((Symbol)symbol).getName() : symbol == null ? null : symbol.toString();
  }
  


  public final String getSimpleName()
  {
    if ((symbol instanceof String))
      return (String)symbol;
    if ((symbol instanceof Symbol)) {
      Symbol sym = (Symbol)symbol;
      if (sym.hasEmptyNamespace())
        return sym.getLocalName();
      if (sym.hasUnknownNamespace())
        return sym.getPrefix() + ':' + sym.getLocalPart();
    }
    return null;
  }
  
  public final Object getSymbol() { return symbol; }
  
  public final Declaration getBinding() { return binding; }
  
  public final void setBinding(Declaration decl) {
    if ((decl != null) && (symbol == null))
      symbol = decl.getSymbol();
    binding = decl;
  }
  




  public final Declaration contextDecl() { return context; }
  
  public final void setContextDecl(Declaration decl) { context = decl; }
}
