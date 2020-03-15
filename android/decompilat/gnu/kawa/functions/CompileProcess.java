// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.expr.QuoteExp;
import gnu.expr.Keyword;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;

public class CompileProcess
{
    public static Expression validateApplyRunProcess(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        final int nargs = args.length;
        int inArg = -1;
        for (int i = 0; i < nargs; ++i) {
            final Expression arg = args[i];
            final Keyword key = arg.checkLiteralKeyword();
            if (key != null && i + 1 < nargs) {
                final String name = key.getName();
                if ("in".equals(name)) {
                    inArg = i + 1;
                }
                ++i;
            }
            else if (inArg < 0 && i + 1 < nargs) {
                inArg = i;
            }
        }
        if (inArg >= 0 && args[inArg] instanceof ApplyExp) {
            final ApplyExp inApp = (ApplyExp)args[inArg];
            final Object inFun = inApp.getFunction().valueIfConstant();
            if (inFun instanceof RunProcess) {
                final Expression[] inArgs = inApp.getArgs();
                final Expression[] xargs = new Expression[inArgs.length + 2];
                xargs[0] = QuoteExp.getInstance(Keyword.make("out-to"));
                xargs[1] = QuoteExp.getInstance(RunProcess.pipeSymbol);
                System.arraycopy(inArgs, 0, xargs, 2, inArgs.length);
                inApp.setArgs(xargs);
            }
        }
        return exp;
    }
}
