package kawa.standard;

import gnu.lists.Pair;
import java.util.Stack;
import kawa.lang.Translator;

public class with_compile_options extends kawa.lang.Syntax
{
  public static final with_compile_options with_compile_options = new with_compile_options();
  
  static { with_compile_options.setName("with-compile-options"); }
  
  public void scanForm(Pair form, gnu.expr.ScopeExp defs, Translator tr)
  {
    Stack stack = new Stack();
    Object rest = getOptions(form.getCdr(), stack, this, tr);
    if (rest == gnu.lists.LList.Empty)
      return;
    if (rest == form.getCdr())
    {
      tr.scanBody(rest, defs, false);
      return;
    }
    rest = tr.scanBody(rest, defs, true);
    rest = new Pair(stack, rest);
    currentOptions.popOptionValues(stack);
    tr.pushForm(Translator.makePair(form, form.getCar(), rest));
  }
  

  public static Object getOptions(Object form, Stack stack, kawa.lang.Syntax command, Translator tr)
  {
    boolean seenKey = false;
    gnu.text.Options options = currentOptions;
    kawa.lang.SyntaxForm syntax = null;
    for (;;)
    {
      if ((form instanceof kawa.lang.SyntaxForm))
      {
        syntax = (kawa.lang.SyntaxForm)form;
        form = syntax.getDatum();
      } else {
        if (!(form instanceof Pair))
          break;
        Pair pair = (Pair)form;
        Object pair_car = Translator.stripSyntax(pair.getCar());
        if (!(pair_car instanceof gnu.expr.Keyword))
          break;
        String key = ((gnu.expr.Keyword)pair_car).getName();
        seenKey = true;
        Object savePos = tr.pushPositionOf(pair);
        try
        {
          form = pair.getCdr();
          while ((form instanceof kawa.lang.SyntaxForm))
          {
            syntax = (kawa.lang.SyntaxForm)form;
            form = syntax.getDatum();
          }
          if (!(form instanceof Pair))
          {
            tr.error('e', "keyword " + key + " not followed by value");
            return gnu.lists.LList.Empty;
          }
          pair = (Pair)form;
          Object value = Translator.stripSyntax(pair.getCar());
          form = pair.getCdr();
          Object oldValue = options.getLocal(key);
          if (options.getInfo(key) == null)
          {
            tr.error('w', "unknown compile option: " + key);
            





















            tr.popPositionOf(savePos);
          }
          else
          {
            if ((value instanceof gnu.lists.FString)) {
              value = value.toString();
            } else if ((!(value instanceof Boolean)) && (!(value instanceof Number)))
            {



              value = null;
              tr.error('e', "invalid literal value for key " + key);
            }
            options.set(key, value, tr.getMessages());
            if (stack != null)
            {
              stack.push(key);
              stack.push(oldValue);
              stack.push(value);
            }
          }
        }
        finally {
          tr.popPositionOf(savePos);
        }
      } }
    if (!seenKey)
      tr.error('e', "no option keyword in " + command.getName());
    return Translator.wrapSyntax(form, syntax);
  }
  


  public gnu.expr.Expression rewriteForm(Pair form, Translator tr)
  {
    Object obj = form.getCdr();
    Pair p;
    Stack stack; Object rest; if (((obj instanceof Pair)) && (((p = (Pair)obj).getCar() instanceof Stack)))
    {

      Stack stack = (Stack)p.getCar();
      Object rest = p.getCdr();
      currentOptions.pushOptionValues(stack);
    }
    else
    {
      stack = new Stack();
      rest = getOptions(obj, stack, this, tr);
    }
    
    try
    {
      gnu.expr.Expression result = tr.rewrite_body(rest);
      gnu.expr.BeginExp bresult;
      gnu.expr.BeginExp bresult; if ((result instanceof gnu.expr.BeginExp)) {
        bresult = (gnu.expr.BeginExp)result;
      } else
        bresult = new gnu.expr.BeginExp(new gnu.expr.Expression[] { result });
      bresult.setCompileOptions(stack);
      return bresult;
    }
    finally
    {
      currentOptions.popOptionValues(stack);
    }
  }
  
  public with_compile_options() {}
}
