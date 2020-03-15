// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.expr.Expression;
import kawa.lang.Translator;
import kawa.lang.Syntax;

public class begin extends Syntax
{
    public static final begin begin;
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        return tr.rewrite_body(obj);
    }
    
    @Override
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        tr.scanBody(st.getCdr(), defs, false);
    }
    
    static {
        (begin = new begin()).setName("begin");
    }
}
