package gnu.kawa.functions;

import gnu.mapping.Procedure;

public class CallWithValues extends gnu.mapping.Procedure2 {
  public static final CallWithValues callWithValues = new CallWithValues();
  
  static { callWithValues.setName("call-with-values");
    callWithValues.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileValues:validateCallWithValues");
  }
  
  public static Object callWithValues(Procedure producer, Procedure consumer)
    throws Throwable
  {
    return ApplyWithValues.applyWithValues(producer.apply0(), consumer);
  }
  
  public Object apply2(Object producer, Object consumer) throws Throwable {
    return callWithValues(gnu.kawa.lispexpr.LangObjType.coerceToProcedure(producer), gnu.kawa.lispexpr.LangObjType.coerceToProcedure(consumer));
  }
  
  public void apply(gnu.mapping.CallContext ctx) throws Throwable
  {
    Procedure.checkArgCount(this, 2);
    Object[] args = ctx.getArgs();
    Object values = gnu.kawa.lispexpr.LangObjType.coerceToProcedure(args[0]).apply0();
    Procedure consumer = gnu.kawa.lispexpr.LangObjType.coerceToProcedure(args[1]);
    if ((values instanceof gnu.mapping.Values)) {
      ((gnu.mapping.Values)values).check_with(consumer, ctx);
    } else {
      consumer.check1(values, ctx);
    }
  }
  
  public CallWithValues() {}
}
