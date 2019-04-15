/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lang;

import gnu.commonlisp.lang.CommonLisp;
import gnu.expr.BeginExp;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.SetExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class setq
extends Syntax {
    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object obj = form.getCdr();
        Vector<SetExp> results = null;
        while (obj != LList.Empty) {
            Object name;
            if (!(obj instanceof Pair)) {
                return tr.syntaxError("invalid syntax for setq");
            }
            Pair pair = (Pair)obj;
            Object sym = pair.getCar();
            if (sym instanceof Symbol || sym instanceof String) {
                name = sym;
            } else if (sym == CommonLisp.FALSE) {
                name = "nil";
            } else {
                return tr.syntaxError("invalid variable name in setq");
            }
            obj = pair.getCdr();
            if (!(obj instanceof Pair)) {
                return tr.syntaxError("wrong number of arguments for setq");
            }
            pair = (Pair)obj;
            Expression value = tr.rewrite(pair.getCar());
            obj = pair.getCdr();
            SetExp sexp = new SetExp(name, value);
            if (obj == LList.Empty) {
                sexp.setHasValue(true);
                if (results == null) {
                    return sexp;
                }
            }
            if (results == null) {
                results = new Vector<SetExp>(10);
            }
            results.addElement(sexp);
        }
        if (results == null) {
            return CommonLisp.nilExpr;
        }
        Object[] stmts = new Expression[results.size()];
        results.copyInto(stmts);
        return new BeginExp((Expression[])stmts);
    }
}

