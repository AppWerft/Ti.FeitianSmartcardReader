/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.Values;

public class ApplyWithValues
extends Procedure2 {
    public static final ApplyWithValues applyWithValues = new ApplyWithValues();

    public static Object applyWithValues(Object values, Procedure consumer) throws Throwable {
        if (values instanceof Values) {
            return ((Values)values).call_with(consumer);
        }
        return consumer.apply1(values);
    }

    @Override
    public Object apply2(Object values, Object consumer) throws Throwable {
        return ApplyWithValues.applyWithValues(values, LangObjType.coerceToProcedure(consumer));
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Procedure.checkArgCount(this, 2);
        Object[] args = ctx.getArgs();
        Object values = args[0];
        Procedure consumer = LangObjType.coerceToProcedure(args[1]);
        if (values instanceof Values) {
            ((Values)values).check_with(consumer, ctx);
        } else {
            consumer.check1(values, ctx);
        }
    }

    static {
        applyWithValues.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileValues:validateApplyWithValues");
    }
}

