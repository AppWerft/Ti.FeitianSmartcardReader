/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class module_implements
extends Syntax {
    public static final module_implements module_implements = new module_implements();

    @Override
    public void scanForm(Pair form, ScopeExp defs2, Translator tr) {
        tr.getModule().setFlag(262144);
        super.scanForm(form, defs2, tr);
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object args = form.getCdr();
        int len = LList.listLength(args, false);
        if (len < 0) {
            tr.syntaxError("improper argument list for " + this.getName());
        } else {
            ClassType[] interfaces = new ClassType[len];
            for (int i = 0; i < len; ++i) {
                Pair pair = (Pair)args;
                interfaces[i] = (ClassType)tr.exp2Type(pair);
                args = pair.getCdr();
            }
            ModuleExp module = tr.getModule();
            module.setInterfaces(interfaces);
        }
        return QuoteExp.voidExp;
    }

    static {
        module_implements.setName("module-implements");
    }
}

