package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.kawa.lispexpr.ReadTable;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public abstract class Lisp2 extends gnu.kawa.lispexpr.LispLanguage
{
  public static final gnu.lists.LList FALSE = gnu.lists.LList.Empty;
  
  public static final Symbol TRUE = gnu.mapping.Namespace.getDefault().getSymbol("t");
  public static final gnu.expr.Expression nilExpr = new gnu.expr.QuoteExp(FALSE);
  
  public Lisp2() {}
  
  public boolean isTrue(Object value) { return isTrueLisp(value); }
  
  public static boolean isTrueLisp(Object value)
  {
    return (value != FALSE) && (value != null) && ((!(value instanceof Boolean)) || (((Boolean)value).booleanValue()));
  }
  


  public Object booleanObject(boolean b)
  {
    return b ? TRUE : FALSE;
  }
  
  public Object noValue()
  {
    return FALSE;
  }
  













  public boolean hasSeparateFunctionNamespace()
  {
    return true;
  }
  





  public boolean selfEvaluatingSymbol(Object obj)
  {
    return ((obj instanceof gnu.expr.Keyword)) || (obj == TRUE) || (obj == FALSE);
  }
  












  public Object getEnvPropertyFor(java.lang.reflect.Field fld, Object value)
  {
    if ((gnu.expr.Compilation.typeProcedure.getReflectClass().isAssignableFrom(fld.getType())) || ((value instanceof kawa.lang.Syntax)))
    {

      return EnvironmentKey.FUNCTION;
    }
    return null;
  }
  











  public int getNamespaceOf(Declaration decl)
  {
    if (decl.isAlias())
      return 3;
    return decl.getFlag(32896L) ? 2 : 1;
  }
  



  public static Object asSymbol(String name)
  {
    if (name == "nil")
      return FALSE;
    return Environment.getCurrent().getSymbol(name);
  }
  
  protected Symbol fromLangSymbol(Object obj)
  {
    if (obj == gnu.lists.LList.Empty)
      return environ.getSymbol("nil");
    return super.fromLangSymbol(obj);
  }
  

  public static Object getString(String name)
  {
    return new gnu.lists.FString(name);
  }
  

  public static Object getString(Symbol symbol)
  {
    return getString(symbol.getName());
  }
  
  protected void defun(String name, Object value)
  {
    environ.define(getSymbol(name), EnvironmentKey.FUNCTION, value);
    if ((value instanceof Named))
    {
      Named n = (Named)value;
      if (n.getName() == null) {
        n.setName(name);
      }
    }
  }
  
  protected void defun(Symbol sym, Object value) {
    environ.define(sym, EnvironmentKey.FUNCTION, value);
    if ((value instanceof Procedure))
    {
      Procedure n = (Procedure)value;
      if (n.getSymbol() == null) {
        n.setSymbol(sym);
      }
    }
  }
  
  private void defun(Procedure proc) {
    defun(proc.getName(), proc);
  }
  
  protected void importLocation(Location loc)
  {
    Symbol name = ((gnu.mapping.NamedLocation)loc).getKeySymbol();
    if (environ.isBound(name, EnvironmentKey.FUNCTION)) {
      return;
    }
    loc = loc.getBase();
    




    if (((loc instanceof gnu.kawa.reflect.FieldLocation)) && (((gnu.kawa.reflect.FieldLocation)loc).isProcedureOrSyntax()))
    {

      environ.addLocation(name, EnvironmentKey.FUNCTION, loc);
    } else { Object val;
      if ((val = loc.get(null)) != null)
      {
        if (((val instanceof Procedure)) || ((val instanceof kawa.lang.Syntax))) {
          defun(name, val);
        } else if ((val instanceof gnu.kawa.lispexpr.LangObjType)) {
          defun(name, ((gnu.kawa.lispexpr.LangObjType)val).getConstructor());
        } else
          define(name.getName(), val);
      }
    }
  }
  
  public ReadTable createReadTable() {
    ReadTable tab = new Lisp2ReadTable();
    tab.initialize(false);
    tab.setInitialColonIsKeyword(true);
    return tab;
  }
  
  public String getCompilationClass() { return "gnu.commonlisp.lang.Lisp2Compilation"; }
}
