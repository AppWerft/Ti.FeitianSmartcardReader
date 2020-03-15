// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.CallContext;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Values;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;

public class ApplyWithValues extends Procedure2
{
    public static final ApplyWithValues applyWithValues;
    
    public static Object applyWithValues(final Object values, final Procedure consumer) throws Throwable {
        if (values instanceof Values) {
            return ((Values)values).call_with(consumer);
        }
        return consumer.apply1(values);
    }
    
    @Override
    public Object apply2(final Object values, final Object consumer) throws Throwable {
        return applyWithValues(values, LangObjType.coerceToProcedure(consumer));
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        Procedure.checkArgCount(this, 2);
        final Object[] args = ctx.getArgs();
        final Object values = args[0];
        final Procedure consumer = LangObjType.coerceToProcedure(args[1]);
        if (values instanceof Values) {
            ((Values)values).check_with(consumer, ctx);
        }
        else {
            consumer.check1(values, ctx);
        }
    }
    
    static {
        (applyWithValues = new ApplyWithValues()).setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileValues:validateApplyWithValues");
    }
}
