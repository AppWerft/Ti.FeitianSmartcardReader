// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.expr.Declaration;
import gnu.expr.InlineCalls;
import gnu.expr.Compilation;
import gnu.bytecode.Type;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.expr.ApplyExp;

public class CurryExp extends ApplyExp
{
    Procedure currier;
    Procedure actual;
    
    public CurryExp(final Procedure currier, final Procedure actual, final Expression... initial) {
        super(new QuoteExp(currier), initial);
        this.actual = actual;
    }
    
    @Override
    protected Type calculateType() {
        return Compilation.typeProcedure;
    }
    
    @Override
    public Expression validateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Declaration decl) {
        final Expression[] initial = this.getArgs();
        final Expression[] xargs = exp.getArgs();
        final int nargs = initial.length + xargs.length;
        final int num = this.actual.numArgs();
        final int min = Procedure.minArgs(num);
        final int max = Procedure.maxArgs(num);
        if (nargs < min || (max >= 0 && nargs > max)) {
            return super.validateApply(exp, visitor, required, decl);
        }
        final Expression[] targs = new Expression[nargs];
        System.arraycopy(initial, 0, targs, 0, initial.length);
        System.arraycopy(xargs, 0, targs, initial.length, xargs.length);
        return visitor.visit(new ApplyExp(this.actual, targs), required);
    }
}
