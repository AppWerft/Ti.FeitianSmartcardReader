// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.bytecode.Method;
import gnu.expr.Expression;
import gnu.expr.ConsumerTarget;
import gnu.mapping.Procedure;
import gnu.kawa.functions.AppendValues;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.lists.Consumer;
import gnu.mapping.Values;
import gnu.expr.Inlineable;
import gnu.mapping.Procedure2;

public class UnionNodes extends Procedure2 implements Inlineable
{
    public static final UnionNodes unionNodes;
    
    @Override
    public Object apply2(final Object vals1, final Object vals2) {
        final SortedNodes nodes = new SortedNodes();
        Values.writeValues(vals1, nodes);
        Values.writeValues(vals2, nodes);
        return nodes;
    }
    
    @Override
    public void compile(ApplyExp exp, final Compilation comp, final Target target) {
        exp = new ApplyExp(AppendValues.appendValues, exp.getArgs());
        ConsumerTarget.compileUsingConsumer(exp, comp, target, SortNodes.makeSortedNodesMethod, null);
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Compilation.typeObject;
    }
    
    static {
        unionNodes = new UnionNodes();
    }
}
