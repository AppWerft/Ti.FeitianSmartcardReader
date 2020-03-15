// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.ModuleExp;
import gnu.bytecode.Type;
import gnu.expr.QuoteExp;
import gnu.bytecode.ClassType;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class module_extends extends Syntax
{
    public static final module_extends module_extends;
    
    @Override
    public void scanForm(final Pair form, final ScopeExp defs, final Translator tr) {
        tr.getModule().setFlag(262144);
        super.scanForm(form, defs, tr);
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Type base = tr.exp2Type((Pair)form.getCdr());
        final ModuleExp module = tr.getModule();
        module.setSuperType((ClassType)base);
        return QuoteExp.voidExp;
    }
    
    static {
        (module_extends = new module_extends()).setName("module-extends");
    }
}
