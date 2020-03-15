// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.Expression;
import gnu.lists.LList;
import java.util.Stack;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class module_compile_options extends Syntax
{
    public static final module_compile_options module_compile_options;
    
    @Override
    public boolean scanForDefinitions(final Pair st, final ScopeExp defs, final Translator tr) {
        final Object rest = with_compile_options.getOptions(st.getCdr(), null, this, tr);
        if (rest != LList.Empty) {
            tr.error('e', this.getName() + " key must be a keyword");
        }
        return true;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        return null;
    }
    
    static {
        (module_compile_options = new module_compile_options()).setName("module-compile-options");
    }
}
