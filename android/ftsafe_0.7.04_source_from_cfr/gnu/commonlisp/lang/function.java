/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class function
extends Syntax {
    Syntax lambda;

    public function(Syntax lambda) {
        this.lambda = lambda;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object obj = form.getCdr();
        if (obj instanceof Pair) {
            Pair pair = (Pair)obj;
            if (pair.getCdr() != LList.Empty) {
                return tr.syntaxError("too many forms after 'function'");
            }
            Object name = pair.getCar();
            if (name instanceof String || name instanceof Symbol) {
                Declaration decl = tr.lookup(name, 2);
                ReferenceExp rexp = new ReferenceExp(name, decl);
                rexp.setProcedureName(true);
                rexp.setFlag(2);
                return rexp;
            }
            if (name instanceof Pair) {
                pair = (Pair)name;
                name = pair.getCar();
                if (name instanceof String ? "lambda".equals(name) : name instanceof Symbol && "lambda".equals(((Symbol)name).getName())) {
                    return this.lambda.rewriteForm(pair, tr);
                }
            }
        }
        return tr.syntaxError("function must be followed by name or lambda expression");
    }
}

