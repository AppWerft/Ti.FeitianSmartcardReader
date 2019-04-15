package kawa.standard;

import gnu.lists.Pair;
import kawa.lang.Translator;

public class module_name extends kawa.lang.Syntax
{
  public static final module_name module_name = new module_name();
  static { module_name.setName("module-name"); }
  
  public void scanForm(Pair form, gnu.expr.ScopeExp defs, Translator tr) {
    Object form_cdr = form.getCdr();
    kawa.lang.SyntaxForm nameSyntax = null;
    while ((form_cdr instanceof kawa.lang.SyntaxForm)) {
      nameSyntax = (kawa.lang.SyntaxForm)form_cdr;
      form_cdr = nameSyntax.getDatum();
    }
    Object arg = (form_cdr instanceof Pair) ? ((Pair)form_cdr).getCar() : null;
    while ((arg instanceof kawa.lang.SyntaxForm)) {
      nameSyntax = (kawa.lang.SyntaxForm)arg;
      arg = nameSyntax.getDatum();
    }
    String name = null;
    
    String err = null;
    Pair p; if (((arg instanceof Pair)) && ((p = (Pair)arg).getCar() == "quote")) {
      arg = p.getCdr();
      if ((!(arg instanceof Pair)) || ((p = (Pair)arg).getCdr() != gnu.lists.LList.Empty) || (!(p.getCar() instanceof String)))
      {

        err = "invalid quoted symbol for 'module-name'";
      } else
        name = (String)p.getCar();
    } else if ((arg instanceof Pair)) {
      name = listToModuleName(arg, tr);
    } else if (((arg instanceof gnu.lists.FString)) || ((arg instanceof String))) {
      name = arg.toString();
    } else if ((arg instanceof gnu.mapping.Symbol)) {
      name = arg.toString();
      int len = name.length();
      if ((len > 2) && (name.charAt(0) == '<') && (name.charAt(len - 1) == '>'))
      {

        name = name.substring(1, len - 1);
      }
    } else {
      err = "un-implemented expression in module-name"; }
    if (err != null) {
      tr.pushForm(tr.syntaxError(err));
    } else {
      int index = name.lastIndexOf('.');
      String className = name;
      if (index >= 0) {
        classPrefix = name.substring(0, index + 1);
      } else
        className = classPrefix + gnu.expr.Mangling.mangleClassName(name);
      gnu.expr.ModuleExp module = tr.getModule();
      if (mainClass == null) {
        mainClass = new gnu.bytecode.ClassType(className);
      } else {
        String oldName = mainClass.getName();
        if (oldName == null) {
          mainClass.setName(className);
        } else if (!oldName.equals(className))
          tr.syntaxError("inconsistent module-name - old name: " + oldName);
      }
      if (tr.getState() > 1)
        tr.error('e', "too late to set module-name");
      module.setType(mainClass);
      module.setName(name);
      
      tr.mustCompileHere();
    }
  }
  
  public static String listToModuleName(Object list, Translator tr) {
    StringBuilder sbuf = new StringBuilder(gnu.expr.Compilation.classPrefixDefault);
    boolean first = true;
    for (;;) {
      Pair parg = (Pair)list;
      if (!first)
        sbuf.append('.');
      first = false;
      Object car = parg.getCar();
      if (car != null)
        sbuf.append(gnu.expr.Mangling.mangleClassName(car.toString()));
      list = parg.getCdr();
      if (list == gnu.lists.LList.Empty)
        break;
      if ((car == null) || (!(list instanceof Pair))) {
        tr.error('e', "invalid list in module name");
        break;
      }
    }
    return sbuf.toString();
  }
  
  public module_name() {}
}
