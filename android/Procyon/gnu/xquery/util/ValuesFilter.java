// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.bytecode.Type;
import gnu.kawa.functions.ValuesMap;
import gnu.expr.Expression;
import gnu.expr.ConsumerTarget;
import gnu.expr.LambdaExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.lists.Consumer;
import gnu.kawa.xml.SortedNodes;
import gnu.mapping.CallContext;
import gnu.kawa.functions.NumberCompare;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.mapping.Values;
import gnu.mapping.Procedure;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.Inlineable;
import gnu.mapping.MethodProc;

public class ValuesFilter extends MethodProc implements Inlineable
{
    char kind;
    int last_or_position_needed;
    public static final ValuesFilter forwardFilter;
    public static final ValuesFilter reverseFilter;
    public static final ValuesFilter exprFilter;
    public static final ClassType typeValuesFilter;
    public static final Method matchesMethod;
    
    public ValuesFilter(final char kind) {
        this.last_or_position_needed = 2;
        this.kind = kind;
        this.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyValuesFilter");
    }
    
    public static ValuesFilter get(final char kind) {
        if (kind == 'F') {
            return ValuesFilter.forwardFilter;
        }
        if (kind == 'R') {
            return ValuesFilter.reverseFilter;
        }
        return ValuesFilter.exprFilter;
    }
    
    @Override
    public int numArgs() {
        return 8194;
    }
    
    public static boolean matches(Object result, final long count) {
        if (result instanceof Values) {
            result = ((Values)result).canonicalize();
        }
        if (!(result instanceof Number)) {
            return BooleanValue.booleanValue(result);
        }
        if (result instanceof IntNum) {
            return IntNum.compare((IntNum)result, count) == 0;
        }
        if (result instanceof Double || result instanceof Float || result instanceof DFloNum) {
            return ((Number)result).doubleValue() == count;
        }
        if (result instanceof Long || result instanceof Integer || result instanceof Short || result instanceof Byte) {
            return count == ((Number)result).longValue();
        }
        return NumberCompare.applyWithPromotion(8, IntNum.make(count), result);
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Object arg = ctx.getNextArg();
        final Procedure proc = (Procedure)ctx.getNextArg();
        final Consumer out = ctx.consumer;
        Values values;
        if (this.kind != 'P') {
            final SortedNodes nodes = new SortedNodes();
            Values.writeValues(arg, nodes);
            values = nodes;
        }
        else {
            if (!(arg instanceof Values)) {
                final IntNum one = IntNum.one();
                if (matches(proc.apply3(arg, one, one), 1L)) {
                    out.writeObject(arg);
                }
                return;
            }
            values = (Values)arg;
        }
        final int count = values.size();
        int it = 0;
        final IntNum countObj = IntNum.make(count);
        final int pmax = proc.maxArgs();
        for (int i = 0; i < count; ++i) {
            it = values.nextPos(it);
            final Object dot = values.getPosPrevious(it);
            final int pos = (this.kind == 'R') ? (count - i) : (i + 1);
            final IntNum posObj = IntNum.make(pos);
            final Object pred_res = (pmax == 2) ? proc.apply2(dot, posObj) : proc.apply3(dot, posObj, countObj);
            if (matches(pred_res, pos)) {
                out.writeObject(dot);
            }
        }
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final Expression exp2 = args[0];
        final Expression exp3 = args[1];
        if (target instanceof IgnoreTarget) {
            exp2.compile(comp, target);
            exp3.compile(comp, target);
            return;
        }
        if (!(exp3 instanceof LambdaExp)) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        if (!(target instanceof ConsumerTarget)) {
            ConsumerTarget.compileUsingConsumer(exp, comp, target);
            return;
        }
        final LambdaExp lexp2 = (LambdaExp)exp3;
        ValuesMap.compileInlined(lexp2, exp2, 1, ValuesFilter.matchesMethod, comp, target);
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Type.pointer_type;
    }
    
    static {
        forwardFilter = new ValuesFilter('F');
        reverseFilter = new ValuesFilter('R');
        exprFilter = new ValuesFilter('P');
        typeValuesFilter = ClassType.make("gnu.xquery.util.ValuesFilter");
        matchesMethod = ValuesFilter.typeValuesFilter.getDeclaredMethod("matches", 2);
    }
}
