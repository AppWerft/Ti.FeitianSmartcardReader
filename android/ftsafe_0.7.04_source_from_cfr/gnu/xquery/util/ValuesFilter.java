/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.Target;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.ValuesMap;
import gnu.kawa.xml.SortedNodes;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.xquery.util.BooleanValue;

public class ValuesFilter
extends MethodProc
implements Inlineable {
    char kind;
    int last_or_position_needed = 2;
    public static final ValuesFilter forwardFilter = new ValuesFilter('F');
    public static final ValuesFilter reverseFilter = new ValuesFilter('R');
    public static final ValuesFilter exprFilter = new ValuesFilter('P');
    public static final ClassType typeValuesFilter = ClassType.make("gnu.xquery.util.ValuesFilter");
    public static final Method matchesMethod = typeValuesFilter.getDeclaredMethod("matches", 2);

    public ValuesFilter(char kind) {
        this.kind = kind;
        this.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyValuesFilter");
    }

    public static ValuesFilter get(char kind) {
        if (kind == 'F') {
            return forwardFilter;
        }
        if (kind == 'R') {
            return reverseFilter;
        }
        return exprFilter;
    }

    @Override
    public int numArgs() {
        return 8194;
    }

    public static boolean matches(Object result, long count) {
        if (result instanceof Values) {
            result = ((Values)result).canonicalize();
        }
        if (result instanceof Number) {
            if (result instanceof IntNum) {
                return IntNum.compare((IntNum)result, count) == 0;
            }
            if (result instanceof Double || result instanceof Float || result instanceof DFloNum) {
                return ((Number)result).doubleValue() == (double)count;
            }
            if (result instanceof Long || result instanceof Integer || result instanceof Short || result instanceof Byte) {
                return count == ((Number)result).longValue();
            }
            return NumberCompare.applyWithPromotion(8, IntNum.make(count), result);
        }
        return BooleanValue.booleanValue(result);
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Values values;
        Object arg = ctx.getNextArg();
        Procedure proc = (Procedure)ctx.getNextArg();
        Consumer out = ctx.consumer;
        if (this.kind != 'P') {
            SortedNodes nodes = new SortedNodes();
            Values.writeValues(arg, nodes);
            values = nodes;
        } else if (arg instanceof Values) {
            values = (Values)arg;
        } else {
            IntNum one = IntNum.one();
            if (ValuesFilter.matches(proc.apply3(arg, one, one), 1L)) {
                out.writeObject(arg);
            }
            return;
        }
        int count = values.size();
        int it = 0;
        IntNum countObj = IntNum.make(count);
        int pmax = proc.maxArgs();
        for (int i = 0; i < count; ++i) {
            Object pred_res;
            it = values.nextPos(it);
            Object dot = values.getPosPrevious(it);
            int pos = this.kind == 'R' ? count - i : i + 1;
            IntNum posObj = IntNum.make(pos);
            Object object2 = pred_res = pmax == 2 ? proc.apply2(dot, posObj) : proc.apply3(dot, posObj, countObj);
            if (!ValuesFilter.matches(pred_res, pos)) continue;
            out.writeObject(dot);
        }
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        Expression[] args = exp.getArgs();
        Expression exp1 = args[0];
        Expression exp2 = args[1];
        if (target instanceof IgnoreTarget) {
            exp1.compile(comp, target);
            exp2.compile(comp, target);
            return;
        }
        if (!(exp2 instanceof LambdaExp)) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        if (!(target instanceof ConsumerTarget)) {
            ConsumerTarget.compileUsingConsumer(exp, comp, target);
            return;
        }
        LambdaExp lexp2 = (LambdaExp)exp2;
        ValuesMap.compileInlined(lexp2, exp1, 1, matchesMethod, comp, target);
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Type.pointer_type;
    }
}

