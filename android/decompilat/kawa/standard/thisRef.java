// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.LambdaExp;
import gnu.expr.Declaration;
import gnu.expr.ThisExp;
import gnu.lists.LList;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class thisRef extends Syntax
{
    public static final thisRef thisSyntax;
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        if (form.getCdr() == LList.Empty) {
            final LambdaExp method = tr.curMethodLambda;
            Declaration firstParam = (method == null) ? null : method.firstDecl();
            if (firstParam == null || !firstParam.isThisParameter()) {
                firstParam = null;
                if (method == null || method.nameDecl == null) {
                    tr.error('e', "use of 'this' not in a named method");
                }
                else if (method.nameDecl.isStatic()) {
                    tr.error('e', "use of 'this' in a static method");
                }
                else {
                    firstParam = new Declaration(ThisExp.THIS_NAME);
                    method.add(null, firstParam);
                    method.nameDecl.setFlag(4096L);
                }
            }
            return new ThisExp(firstParam);
        }
        return tr.syntaxError("this with parameter not implemented");
    }
    
    static {
        (thisSyntax = new thisRef()).setName("this");
    }
}
