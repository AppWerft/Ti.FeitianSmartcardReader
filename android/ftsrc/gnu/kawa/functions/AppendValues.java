package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.kawa.reflect.OccurrenceType;
import gnu.mapping.CallContext;

public class AppendValues extends gnu.mapping.MethodProc implements gnu.expr.Inlineable
{
  public static final AppendValues appendValues = new AppendValues();
  

  public AppendValues()
  {
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyAppendValues");
  }
  

  public void apply(CallContext ctx)
  {
    Object endMarker = gnu.expr.Special.dfault;
    for (;;)
    {
      Object arg = ctx.getNextArg(endMarker);
      if (arg == endMarker)
        break;
      if ((arg instanceof gnu.lists.Consumable)) {
        ((gnu.lists.Consumable)arg).consume(consumer);
      } else
        ctx.writeValue(arg);
    }
  }
  
  public void compile(ApplyExp exp, gnu.expr.Compilation comp, Target target) {
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    
    int nonVoid = -1;
    for (int i = 0; i < nargs; i++) {
      if (!args[i].getType().isVoid()) {
        nonVoid = nonVoid == -1 ? i : -2;
      }
    }
    if (nonVoid == -1)
      nonVoid = nargs - 1;
    if (nonVoid >= 0) {
      for (int i = 0; i < nargs; i++) {
        args[i].compileWithPosition(comp, i == nonVoid ? target : Target.Ignore);
      }
      
      return;
    }
    boolean simple;
    boolean simple;
    if ((target instanceof gnu.expr.IgnoreTarget)) {
      simple = true; } else { boolean simple;
      if ((target instanceof ConsumerTarget)) {
        Type type = target.getType();
        simple = (type == Type.objectType) || (((type instanceof OccurrenceType)) && (((OccurrenceType)type).minOccurs() == 0));
      }
      else
      {
        simple = false;
      } }
    if (simple) {
      for (int i = 0; i < nargs; i++)
        args[i].compileWithPosition(comp, target);
    } else {
      Expression nexp;
      if ((target instanceof ConsumerTarget)) {
        Expression nexp = new gnu.expr.BeginExp(new Expression[] { exp });
        nexp.setType(Type.objectType);
      } else {
        nexp = exp; }
      ConsumerTarget.compileUsingValues(nexp, comp, target);
    }
  }
}
