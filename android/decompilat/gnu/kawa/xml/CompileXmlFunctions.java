// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.NodePredicate;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;

public class CompileXmlFunctions
{
    public static Expression validateApplyMakeUnescapedData(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        if (args.length == 1 && args[0] instanceof QuoteExp) {
            return new QuoteExp(((MakeUnescapedData)proc).apply1(((QuoteExp)args[0]).getValue()));
        }
        return exp;
    }
    
    public static Expression validateApplyTreeScanner(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final NodePredicate type = ((TreeScanner)proc).type;
        if (exp.getTypeRaw() == null && type instanceof Type) {
            exp.setType(NodeSetType.getInstance((Type)type));
        }
        return exp;
    }
}
