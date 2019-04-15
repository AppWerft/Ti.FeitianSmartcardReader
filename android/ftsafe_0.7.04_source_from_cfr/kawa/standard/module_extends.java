/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class module_extends
extends Syntax {
    public static final module_extends module_extends = new module_extends();

    @Override
    public void scanForm(Pair form, ScopeExp defs2, Translator tr) {
        tr.getModule().setFlag(262144);
        super.scanForm(form, defs2, tr);
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Type base2 = tr.exp2Type((Pair)form.getCdr());
        ModuleExp module = tr.getModule();
        module.setSuperType((ClassType)base2);
        return QuoteExp.voidExp;
    }

    static {
        module_extends.setName("module-extends");
    }
}

