// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.expr.ReferenceExp;
import gnu.mapping.Symbol;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class function extends Syntax
{
    Syntax lambda;
    
    public function(final Syntax lambda) {
        this.lambda = lambda;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Object obj = form.getCdr();
        if (obj instanceof Pair) {
            Pair pair = (Pair)obj;
            if (pair.getCdr() != LList.Empty) {
                return tr.syntaxError("too many forms after 'function'");
            }
            Object name = pair.getCar();
            if (name instanceof String || name instanceof Symbol) {
                final Declaration decl = tr.lookup(name, 2);
                final ReferenceExp rexp = new ReferenceExp(name, decl);
                rexp.setProcedureName(true);
                rexp.setFlag(2);
                return rexp;
            }
            if (name instanceof Pair) {
                pair = (Pair)name;
                name = pair.getCar();
                if (name instanceof String) {
                    if (!"lambda".equals(name)) {
                        return tr.syntaxError("function must be followed by name or lambda expression");
                    }
                }
                else if (!(name instanceof Symbol) || !"lambda".equals(((Symbol)name).getName())) {
                    return tr.syntaxError("function must be followed by name or lambda expression");
                }
                return this.lambda.rewriteForm(pair, tr);
            }
        }
        return tr.syntaxError("function must be followed by name or lambda expression");
    }
}
