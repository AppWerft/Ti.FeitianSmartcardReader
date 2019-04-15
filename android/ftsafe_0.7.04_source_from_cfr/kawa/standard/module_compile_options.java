/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;
import kawa.standard.with_compile_options;

public class module_compile_options
extends Syntax {
    public static final module_compile_options module_compile_options = new module_compile_options();

    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        Object rest = with_compile_options.getOptions(st.getCdr(), null, this, tr);
        if (rest != LList.Empty) {
            tr.error('e', this.getName() + " key must be a keyword");
        }
        return true;
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        return null;
    }

    static {
        module_compile_options.setName("module-compile-options");
    }
}

