/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.xquery.util.CompileMisc;
import gnu.xquery.util.OrderedTuples;

public class OrderedMap
extends MethodProc
implements Inlineable {
    public static final OrderedMap orderedMap = new OrderedMap();

    public static Object[] makeTuple$V(Object[] values) {
        return values;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        OrderedTuples tuples;
        Object[] args = ctx.getArgs();
        Object values = args[0];
        if (args.length == 2) {
            tuples = (OrderedTuples)args[1];
        } else {
            Object[] comps = new Object[args.length - 2];
            System.arraycopy(args, 2, comps, 0, comps.length);
            tuples = OrderedTuples.make$V((Procedure)args[1], comps);
        }
        Values.writeValues(values, tuples);
        tuples.run$X(ctx);
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        CompileMisc.compileOrderedMap(exp, comp, target, this);
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Type.pointer_type;
    }

    static {
        orderedMap.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyOrderedMap");
    }
}

