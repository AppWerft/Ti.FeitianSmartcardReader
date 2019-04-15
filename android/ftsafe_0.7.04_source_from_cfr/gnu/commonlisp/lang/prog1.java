/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lang;

import gnu.expr.BeginExp;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class prog1
extends Syntax {
    int index;
    public static final prog1 prog1 = new prog1("prog1", 1);
    public static final prog1 prog2 = new prog1("prog2", 2);

    public prog1(String name, int index) {
        this.index = index;
        this.setName(name);
    }

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        int nexps = LList.length(obj);
        if (nexps < this.index) {
            return tr.syntaxError("too few expressions in " + this.getName());
        }
        if (this.index == 2) {
            Pair pair = (Pair)obj;
            return new BeginExp(tr.rewrite(pair.getCar()), prog1.rewrite(pair.getCdr(), tr));
        }
        tr.letStart();
        Expression[] body = new Expression[nexps];
        Pair pair = (Pair)obj;
        Declaration decl = new Declaration((Object)null);
        tr.letVariable(decl, tr.rewrite(pair.getCar()));
        tr.letEnter();
        obj = pair.getCdr();
        for (int i = 0; i < nexps - 1; ++i) {
            pair = (Pair)obj;
            body[i] = tr.rewrite(pair.getCar());
            obj = pair.getCdr();
        }
        body[nexps - 1] = new ReferenceExp(decl);
        tr.mustCompileHere();
        return tr.letDone(BeginExp.canonicalize(body));
    }
}

