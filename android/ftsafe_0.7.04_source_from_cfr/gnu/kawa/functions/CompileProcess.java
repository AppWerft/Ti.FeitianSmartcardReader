/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.kawa.functions.RunProcess;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;

public class CompileProcess {
    public static Expression validateApplyRunProcess(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Object inFun;
        ApplyExp inApp;
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        int inArg = -1;
        for (int i = 0; i < nargs; ++i) {
            Expression arg = args[i];
            Keyword key = arg.checkLiteralKeyword();
            if (key != null && i + 1 < nargs) {
                String name = key.getName();
                if ("in".equals(name)) {
                    inArg = i + 1;
                }
                ++i;
                continue;
            }
            if (inArg >= 0 || i + 1 >= nargs) continue;
            inArg = i;
        }
        if (inArg >= 0 && args[inArg] instanceof ApplyExp && (inFun = (inApp = (ApplyExp)args[inArg]).getFunction().valueIfConstant()) instanceof RunProcess) {
            Expression[] inArgs = inApp.getArgs();
            Expression[] xargs = new Expression[inArgs.length + 2];
            xargs[0] = QuoteExp.getInstance(Keyword.make("out-to"));
            xargs[1] = QuoteExp.getInstance(RunProcess.pipeSymbol);
            System.arraycopy(inArgs, 0, xargs, 2, inArgs.length);
            inApp.setArgs(xargs);
        }
        return exp;
    }
}

