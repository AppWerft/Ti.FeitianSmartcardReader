package kawa.standard;

import gnu.lists.Pair;
import kawa.lang.Translator;

public class module_compile_options extends kawa.lang.Syntax
{
  public static final module_compile_options module_compile_options = new module_compile_options();
  
  static { module_compile_options.setName("module-compile-options"); }
  

  public boolean scanForDefinitions(Pair st, gnu.expr.ScopeExp defs, Translator tr)
  {
    Object rest = with_compile_options.getOptions(st.getCdr(), null, this, tr);
    if (rest != gnu.lists.LList.Empty)
      tr.error('e', getName() + " key must be a keyword");
    return true;
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr)
  {
    return null;
  }
  
  public module_compile_options() {}
}
