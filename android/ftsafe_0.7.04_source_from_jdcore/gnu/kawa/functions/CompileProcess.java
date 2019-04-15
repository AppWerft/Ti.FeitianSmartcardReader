package gnu.kawa.functions;

import gnu.expr.ApplyExp;
import gnu.expr.Expression;

public class CompileProcess
{
  public CompileProcess() {}
  
  public static Expression validateApplyRunProcess(ApplyExp exp, gnu.expr.InlineCalls visitor, gnu.bytecode.Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    int inArg = -1;
    for (int i = 0; i < nargs; i++) {
      Expression arg = args[i];
      gnu.expr.Keyword key = arg.checkLiteralKeyword();
      if ((key != null) && (i + 1 < nargs)) {
        String name = key.getName();
        if ("in".equals(name))
          inArg = i + 1;
        i++;
      } else if ((inArg < 0) && (i + 1 < nargs)) {
        inArg = i;
      } }
    if ((inArg >= 0) && 
      ((args[inArg] instanceof ApplyExp))) {
      ApplyExp inApp = (ApplyExp)args[inArg];
      Object inFun = inApp.getFunction().valueIfConstant();
      if ((inFun instanceof RunProcess)) {
        Expression[] inArgs = inApp.getArgs();
        Expression[] xargs = new Expression[inArgs.length + 2];
        xargs[0] = gnu.expr.QuoteExp.getInstance(gnu.expr.Keyword.make("out-to"));
        xargs[1] = gnu.expr.QuoteExp.getInstance(RunProcess.pipeSymbol);
        System.arraycopy(inArgs, 0, xargs, 2, inArgs.length);
        inApp.setArgs(xargs);
      }
    }
    
    return exp;
  }
}
