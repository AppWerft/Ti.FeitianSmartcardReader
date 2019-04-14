package kawa.lang;

import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.mapping.Named;
import gnu.mapping.Symbol;

public abstract class Syntax
  implements Printable, Named
{
  Object name;
  
  public final String getName()
  {
    return (name instanceof Symbol) ? ((Symbol)name).getName() : name == null ? null : name.toString();
  }
  

  public Object getSymbol() { return name; }
  
  public void setName(Object name) { this.name = name; }
  public void setName(String name) { this.name = name; }
  

  public Syntax() {}
  

  public Syntax(Object name)
  {
    setName(name);
  }
  








  public Expression rewrite(Object obj, Translator tr)
  {
    throw new InternalError("rewrite method not defined");
  }
  
  public Expression rewriteForm(Pair form, Translator tr)
  {
    return rewrite(form.getCdr(), tr);
  }
  
  public void scanForm(Pair st, ScopeExp defs, Translator tr)
  {
    boolean ok = scanForDefinitions(st, defs, tr);
    if (!ok) {
      tr.pushForm(new ErrorExp("syntax error expanding " + this));
    }
  }
  






  public boolean scanForDefinitions(Pair st, ScopeExp defs, Translator tr)
  {
    tr.pushForm(st);
    return true;
  }
  
  public void print(Consumer out)
  {
    out.write("#<syntax ");
    String name = getName();
    out.write(name == null ? "<unnamed>" : name);
    out.write(62);
  }
}
