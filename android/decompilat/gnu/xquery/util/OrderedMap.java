// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.lists.Consumer;
import gnu.mapping.Values;
import gnu.mapping.Procedure;
import gnu.mapping.CallContext;
import gnu.expr.Inlineable;
import gnu.mapping.MethodProc;

public class OrderedMap extends MethodProc implements Inlineable
{
    public static final OrderedMap orderedMap;
    
    public static Object[] makeTuple$V(final Object[] values) {
        return values;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Object[] args = ctx.getArgs();
        final Object values = args[0];
        OrderedTuples tuples;
        if (args.length == 2) {
            tuples = (OrderedTuples)args[1];
        }
        else {
            final Object[] comps = new Object[args.length - 2];
            System.arraycopy(args, 2, comps, 0, comps.length);
            tuples = OrderedTuples.make$V((Procedure)args[1], comps);
        }
        Values.writeValues(values, tuples);
        tuples.run$X(ctx);
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        CompileMisc.compileOrderedMap(exp, comp, target, this);
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Type.pointer_type;
    }
    
    static {
        (orderedMap = new OrderedMap()).setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyOrderedMap");
    }
}
