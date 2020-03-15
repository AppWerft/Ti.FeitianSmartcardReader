// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.bytecode.ClassType;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class module_implements extends Syntax
{
    public static final module_implements module_implements;
    
    @Override
    public void scanForm(final Pair form, final ScopeExp defs, final Translator tr) {
        tr.getModule().setFlag(262144);
        super.scanForm(form, defs, tr);
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        Object args = form.getCdr();
        final int len = LList.listLength(args, false);
        if (len < 0) {
            tr.syntaxError("improper argument list for " + this.getName());
        }
        else {
            final ClassType[] interfaces = new ClassType[len];
            for (int i = 0; i < len; ++i) {
                final Pair pair = (Pair)args;
                interfaces[i] = (ClassType)tr.exp2Type(pair);
                args = pair.getCdr();
            }
            final ModuleExp module = tr.getModule();
            module.setInterfaces(interfaces);
        }
        return QuoteExp.voidExp;
    }
    
    static {
        (module_implements = new module_implements()).setName("module-implements");
    }
}
