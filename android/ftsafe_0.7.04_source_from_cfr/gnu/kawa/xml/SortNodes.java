/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.xml.SortedNodes;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;

public class SortNodes
extends Procedure1
implements Inlineable {
    public static final SortNodes sortNodes = new SortNodes();
    public static final ClassType typeSortedNodes = ClassType.make("gnu.kawa.xml.SortedNodes");
    public static final Method makeSortedNodesMethod = typeSortedNodes.getDeclaredMethod("<init>", 0);
    public static final Method canonicalizeMethod = Compilation.typeValues.getDeclaredMethod("canonicalize", 0);

    @Override
    public Object apply1(Object values) {
        SortedNodes nodes = new SortedNodes();
        Values.writeValues(values, nodes);
        return nodes.canonicalize();
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        Expression[] args = exp.getArgs();
        if (args.length != 1 || !comp.mustCompile) {
            ApplyExp.compile(exp, comp, target);
        } else {
            Method resultMethod = target instanceof ConsumerTarget || target instanceof StackTarget && target.getType().isSubtype(Compilation.typeValues) ? null : canonicalizeMethod;
            ConsumerTarget.compileUsingConsumer(args[0], comp, target, makeSortedNodesMethod, resultMethod);
        }
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Compilation.typeObject;
    }
}

