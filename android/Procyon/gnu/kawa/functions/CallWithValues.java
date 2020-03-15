// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Values;
import gnu.mapping.CallContext;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;

public class CallWithValues extends Procedure2
{
    public static final CallWithValues callWithValues;
    
    public static Object callWithValues(final Procedure producer, final Procedure consumer) throws Throwable {
        return ApplyWithValues.applyWithValues(producer.apply0(), consumer);
    }
    
    @Override
    public Object apply2(final Object producer, final Object consumer) throws Throwable {
        return callWithValues(LangObjType.coerceToProcedure(producer), LangObjType.coerceToProcedure(consumer));
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        Procedure.checkArgCount(this, 2);
        final Object[] args = ctx.getArgs();
        final Object values = LangObjType.coerceToProcedure(args[0]).apply0();
        final Procedure consumer = LangObjType.coerceToProcedure(args[1]);
        if (values instanceof Values) {
            ((Values)values).check_with(consumer, ctx);
        }
        else {
            consumer.check1(values, ctx);
        }
    }
    
    static {
        (callWithValues = new CallWithValues()).setName("call-with-values");
        CallWithValues.callWithValues.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileValues:validateCallWithValues");
    }
}
