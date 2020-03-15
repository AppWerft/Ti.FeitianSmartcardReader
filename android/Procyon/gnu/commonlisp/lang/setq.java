// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.expr.BeginExp;
import java.util.Vector;
import gnu.expr.SetExp;
import gnu.mapping.Symbol;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class setq extends Syntax
{
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        Object obj = form.getCdr();
        Vector results = null;
        while (obj != LList.Empty) {
            if (!(obj instanceof Pair)) {
                return tr.syntaxError("invalid syntax for setq");
            }
            Pair pair = (Pair)obj;
            final Object sym = pair.getCar();
            Object name;
            if (sym instanceof Symbol || sym instanceof String) {
                name = sym;
            }
            else {
                if (sym != CommonLisp.FALSE) {
                    return tr.syntaxError("invalid variable name in setq");
                }
                name = "nil";
            }
            obj = pair.getCdr();
            if (!(obj instanceof Pair)) {
                return tr.syntaxError("wrong number of arguments for setq");
            }
            pair = (Pair)obj;
            final Expression value = tr.rewrite(pair.getCar());
            obj = pair.getCdr();
            final SetExp sexp = new SetExp(name, value);
            if (obj == LList.Empty) {
                sexp.setHasValue(true);
                if (results == null) {
                    return sexp;
                }
            }
            if (results == null) {
                results = new Vector(10);
            }
            results.addElement(sexp);
        }
        if (results == null) {
            return CommonLisp.nilExpr;
        }
        final Expression[] stmts = new Expression[results.size()];
        results.copyInto(stmts);
        return new BeginExp(stmts);
    }
}
