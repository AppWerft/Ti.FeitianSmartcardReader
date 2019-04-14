package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class fluid_let extends kawa.lang.Syntax
{
  public static final fluid_let fluid_let = new fluid_let();
  static { fluid_let.setName("fluid-set"); }
  


  boolean star;
  

  Expression defaultInit;
  
  boolean warnIfUndefined;
  
  public fluid_let(boolean star, boolean warnIfUndefined, Expression defaultInit)
  {
    this.star = star;
    this.defaultInit = defaultInit;
    this.warnIfUndefined = warnIfUndefined;
  }
  
  public fluid_let()
  {
    star = false;
  }
  
  public Expression rewrite(Object obj, Translator tr)
  {
    if (!(obj instanceof Pair))
      return tr.syntaxError("missing let arguments");
    Pair pair = (Pair)obj;
    return rewrite(pair.getCar(), pair.getCdr(), tr);
  }
  
  public Expression rewrite(Object bindings, Object body, Translator tr)
  {
    int decl_count = star ? 1 : LList.length(bindings);
    FluidLetExp let = new FluidLetExp();
    for (int i = 0; i < decl_count; i++)
    {
      Pair bind_pair = (Pair)bindings;
      Object savePos = tr.pushPositionOf(bind_pair);
      

      try
      {
        Object name = bind_pair.getCar();
        Expression value; if (((name instanceof String)) || ((name instanceof Symbol)))
        {
          value = defaultInit; } else { Pair binding;
          gnu.expr.ErrorExp localErrorExp;
          Expression value; if (((name instanceof Pair)) && ((((binding = (Pair)name).getCar() instanceof String)) || ((binding.getCar() instanceof Symbol)) || ((binding.getCar() instanceof SyntaxForm))))
          {



            name = binding.getCar();
            if ((name instanceof SyntaxForm))
              name = ((SyntaxForm)name).getDatum();
            Expression value;
            if (binding.getCdr() == LList.Empty) {
              value = defaultInit;
            } else { if ((!(binding.getCdr() instanceof Pair)) || ((binding = (Pair)binding.getCdr()).getCdr() != LList.Empty))
              {
                return tr.syntaxError("bad syntax for value of " + name + " in " + getName());
              }
              
              value = tr.rewrite(binding.getCar());
            }
          } else {
            return tr.syntaxError("invalid " + getName() + " syntax"); } }
        Expression value; Declaration decl = let.addDeclaration(name);
        Declaration found = tr.lookup(name, -1);
        if ((found == null) && ((name instanceof Symbol)))
        {
          gnu.mapping.Location loc = tr.getLanguage().getLangEnvironment().lookup((Symbol)name, null);
          
          if (loc != null)
            loc = loc.getBase();
          if ((loc instanceof StaticFieldLocation))
            found = ((StaticFieldLocation)loc).getDeclaration();
        }
        if (found != null)
        {
          found.maybeIndirectBinding(tr);
          base = found;
          found.setFluid(true);
          found.setCanWrite(true);
        }
        else if (!warnIfUndefined) {
          decl.setFlag(268435456L); }
        decl.setCanWrite(true);
        decl.setFluid(true);
        decl.setIndirectBinding(true);
        if (value == null)
          value = new gnu.expr.ReferenceExp(name);
        decl.setInitValue(value);
        decl.noteValueUnknown();
        bindings = bind_pair.getCdr();
      }
      finally
      {
        tr.popPositionOf(savePos);
      }
    }
    tr.push(let);
    let.setBody((star) && (bindings != LList.Empty) ? rewrite(bindings, body, tr) : tr.rewrite_body(body));
    
    tr.pop(let);
    return let;
  }
}
