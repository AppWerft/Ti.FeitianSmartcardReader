// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.expr.Expression;
import gnu.bytecode.Type;
import gnu.expr.StackTarget;
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

public class SortNodes extends Procedure1 implements Inlineable
{
    public static final SortNodes sortNodes;
    public static final ClassType typeSortedNodes;
    public static final Method makeSortedNodesMethod;
    public static final Method canonicalizeMethod;
    
    @Override
    public Object apply1(final Object values) {
        final SortedNodes nodes = new SortedNodes();
        Values.writeValues(values, nodes);
        return nodes.canonicalize();
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        if (args.length != 1 || !comp.mustCompile) {
            ApplyExp.compile(exp, comp, target);
        }
        else {
            Method resultMethod;
            if (target instanceof ConsumerTarget || (target instanceof StackTarget && target.getType().isSubtype(Compilation.typeValues))) {
                resultMethod = null;
            }
            else {
                resultMethod = SortNodes.canonicalizeMethod;
            }
            ConsumerTarget.compileUsingConsumer(args[0], comp, target, SortNodes.makeSortedNodesMethod, resultMethod);
        }
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Compilation.typeObject;
    }
    
    static {
        sortNodes = new SortNodes();
        typeSortedNodes = ClassType.make("gnu.kawa.xml.SortedNodes");
        makeSortedNodesMethod = SortNodes.typeSortedNodes.getDeclaredMethod("<init>", 0);
        canonicalizeMethod = Compilation.typeValues.getDeclaredMethod("canonicalize", 0);
    }
}
