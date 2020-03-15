// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lang;

import gnu.expr.ReferenceExp;
import gnu.expr.Declaration;
import gnu.expr.BeginExp;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import kawa.lang.Syntax;

public class prog1 extends Syntax
{
    int index;
    public static final prog1 prog1;
    public static final prog1 prog2;
    
    public prog1(final String name, final int index) {
        this.index = index;
        this.setName(name);
    }
    
    @Override
    public Expression rewrite(Object obj, final Translator tr) {
        final int nexps = LList.length(obj);
        if (nexps < this.index) {
            return tr.syntaxError("too few expressions in " + this.getName());
        }
        if (this.index == 2) {
            final Pair pair = (Pair)obj;
            return new BeginExp(tr.rewrite(pair.getCar()), gnu.commonlisp.lang.prog1.prog1.rewrite(pair.getCdr(), tr));
        }
        tr.letStart();
        final Expression[] body = new Expression[nexps];
        Pair pair2 = (Pair)obj;
        final Declaration decl = new Declaration((Object)null);
        tr.letVariable(decl, tr.rewrite(pair2.getCar()));
        tr.letEnter();
        obj = pair2.getCdr();
        for (int i = 0; i < nexps - 1; ++i) {
            pair2 = (Pair)obj;
            body[i] = tr.rewrite(pair2.getCar());
            obj = pair2.getCdr();
        }
        body[nexps - 1] = new ReferenceExp(decl);
        tr.mustCompileHere();
        return tr.letDone(BeginExp.canonicalize(body));
    }
    
    static {
        prog1 = new prog1("prog1", 1);
        prog2 = new prog1("prog2", 2);
    }
}
