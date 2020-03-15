// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.TryExp;
import gnu.expr.CatchClause;
import gnu.expr.LambdaExp;
import gnu.expr.ErrorExp;
import gnu.lists.FVector;
import gnu.expr.Compilation;
import kawa.lang.Translator;
import gnu.expr.Expression;

public class try_catch
{
    public static Expression rewrite(final Object try_part, final Object clauses) {
        final Translator tr = (Translator)Compilation.getCurrent();
        final Expression try_part_exp = tr.rewrite(try_part);
        CatchClause prev = null;
        CatchClause chain = null;
        final FVector vec = (FVector)clauses;
        for (int n = vec.size(), i = 0; i < n; ++i) {
            final Expression cl = SchemeCompilation.lambda.rewrite(vec.get(i), tr);
            if (cl instanceof ErrorExp) {
                return cl;
            }
            if (!(cl instanceof LambdaExp)) {
                return tr.syntaxError("internal error with try-catch");
            }
            final CatchClause ccl = new CatchClause((LambdaExp)cl);
            if (prev == null) {
                chain = ccl;
            }
            else {
                prev.setNext(ccl);
            }
            prev = ccl;
        }
        if (try_part_exp instanceof ErrorExp) {
            return try_part_exp;
        }
        final TryExp texp = new TryExp(try_part_exp, null);
        texp.setCatchClauses(chain);
        return texp;
    }
}
