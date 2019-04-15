package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.QuoteExp;
import gnu.mapping.Procedure;

public class CurryExp extends ApplyExp
{
  Procedure currier;
  Procedure actual;
  
  public CurryExp(Procedure currier, Procedure actual, Expression... initial)
  {
    super(new QuoteExp(currier), initial);
    this.actual = actual;
  }
  
  protected Type calculateType() {
    return Compilation.typeProcedure;
  }
  
  public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl)
  {
    Expression[] initial = getArgs();
    Expression[] xargs = exp.getArgs();
    int nargs = initial.length + xargs.length;
    int num = actual.numArgs();
    int min = Procedure.minArgs(num);
    int max = Procedure.maxArgs(num);
    if ((nargs < min) || ((max >= 0) && (nargs > max)))
    {
      return super.validateApply(exp, visitor, required, decl);
    }
    Expression[] targs = new Expression[nargs];
    System.arraycopy(initial, 0, targs, 0, initial.length);
    System.arraycopy(xargs, 0, targs, initial.length, xargs.length);
    return visitor.visit(new ApplyExp(actual, targs), required);
  }
}
