package kawa.standard;

import gnu.lists.Pair;
import kawa.lang.Translator;

public class module_implements extends kawa.lang.Syntax
{
  public static final module_implements module_implements = new module_implements();
  
  static { module_implements.setName("module-implements"); }
  
  public void scanForm(Pair form, gnu.expr.ScopeExp defs, Translator tr) {
    tr.getModule().setFlag(262144);
    super.scanForm(form, defs, tr);
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr) {
    Object args = form.getCdr();
    int len = gnu.lists.LList.listLength(args, false);
    if (len < 0) {
      tr.syntaxError("improper argument list for " + getName());
    } else {
      gnu.bytecode.ClassType[] interfaces = new gnu.bytecode.ClassType[len];
      for (int i = 0; i < len; i++) {
        Pair pair = (Pair)args;
        interfaces[i] = ((gnu.bytecode.ClassType)tr.exp2Type(pair));
        args = pair.getCdr();
      }
      gnu.expr.ModuleExp module = tr.getModule();
      module.setInterfaces(interfaces);
    }
    return gnu.expr.QuoteExp.voidExp;
  }
  
  public module_implements() {}
}
