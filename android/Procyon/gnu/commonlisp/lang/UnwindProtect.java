// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.expr.TryExp;
import gnu.lists.Pair;
import gnu.expr.Expression;
import kawa.lang.Translator;
import kawa.lang.Syntax;

public class UnwindProtect extends Syntax
{
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("invalid syntax for unwind-protect");
        }
        final Pair pair = (Pair)obj;
        return new TryExp(tr.rewrite(pair.getCar()), tr.rewrite_body(pair.getCdr()));
    }
}
