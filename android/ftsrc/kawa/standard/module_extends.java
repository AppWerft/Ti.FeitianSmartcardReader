package kawa.standard;

import gnu.lists.Pair;
import kawa.lang.Translator;

public class module_extends extends kawa.lang.Syntax
{
  public static final module_extends module_extends = new module_extends();
  static { module_extends.setName("module-extends"); }
  
  public void scanForm(Pair form, gnu.expr.ScopeExp defs, Translator tr) {
    tr.getModule().setFlag(262144);
    super.scanForm(form, defs, tr);
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr) {
    gnu.bytecode.Type base = tr.exp2Type((Pair)form.getCdr());
    gnu.expr.ModuleExp module = tr.getModule();
    module.setSuperType((gnu.bytecode.ClassType)base);
    return gnu.expr.QuoteExp.voidExp;
  }
  
  public module_extends() {}
}
