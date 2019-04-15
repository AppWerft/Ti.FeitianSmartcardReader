/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class begin
extends Syntax {
    public static final begin begin = new begin();

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        return tr.rewrite_body(obj);
    }

    @Override
    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        tr.scanBody(st.getCdr(), defs2, false);
    }

    static {
        begin.setName("begin");
    }
}

