// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.ConsumerTarget;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.lists.Consumer;
import gnu.mapping.Values;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.Inlineable;
import gnu.mapping.Procedure1;

public class CoerceNodes extends Procedure1 implements Inlineable
{
    public static final CoerceNodes coerceNodes;
    public static final ClassType typeNodes;
    public static final Method makeNodesMethod;
    
    @Override
    public Object apply1(final Object values) {
        final Nodes nodes = new Nodes();
        Values.writeValues(values, nodes);
        return nodes;
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        if (args.length != 1) {
            ApplyExp.compile(exp, comp, target);
        }
        else {
            ConsumerTarget.compileUsingConsumer(args[0], comp, target, CoerceNodes.makeNodesMethod, null);
        }
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return CoerceNodes.typeNodes;
    }
    
    static {
        coerceNodes = new CoerceNodes();
        typeNodes = ClassType.make("gnu.kawa.xml.Nodes");
        makeNodesMethod = CoerceNodes.typeNodes.getDeclaredMethod("<init>", 0);
    }
}
