package kawa.standard;

import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import kawa.lang.Translator;

public class constant_fold extends kawa.lang.Syntax
{
  public static final constant_fold constant_fold = new constant_fold();
  static { constant_fold.setName("constant-fold"); }
  
  static Object checkConstant(Expression exp, Translator tr)
  {
    if ((exp instanceof gnu.expr.QuoteExp))
      return ((gnu.expr.QuoteExp)exp).getValue();
    if ((exp instanceof ReferenceExp))
    {
      ReferenceExp rexp = (ReferenceExp)exp;
      gnu.expr.Declaration decl = rexp.getBinding();
      if ((decl == null) || (decl.getFlag(65536L))) {
        return gnu.mapping.Environment.user().get(rexp.getName(), null);
      }
      return gnu.expr.Declaration.followAliases(decl).getConstantValue();
    }
    return null;
  }
  
  public Expression rewrite(Object obj, Translator tr)
  {
    Expression exp = tr.rewrite(obj);
    if (!(exp instanceof ApplyExp))
      return exp;
    ApplyExp aexp = (ApplyExp)exp;
    Object func = checkConstant(aexp.getFunction(), tr);
    if (!(func instanceof gnu.mapping.Procedure)) {
      return exp;
    }
    



    Expression[] args = aexp.getArgs();
    int i = args.length;
    Object[] vals = new Object[i];
    for (;;) { i--; if (i < 0)
        break;
      Object val = checkConstant(args[i], tr);
      if (val == null)
        return exp;
      vals[i] = val;
    }
    try
    {
      return new gnu.expr.QuoteExp(((gnu.mapping.Procedure)func).applyN(vals));
    }
    catch (Error ex)
    {
      throw ex;
    }
    catch (Throwable ex)
    {
      exp = tr.syntaxError("caught exception in constant-fold:");
      tr.syntaxError(ex.toString()); }
    return exp;
  }
  
  public constant_fold() {}
}
