package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import kawa.lang.Continuation;

public class CallCC extends MethodProc implements gnu.expr.Inlineable
{
  public static final CallCC callcc = new CallCC();
  
  CallCC()
  {
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyCallCC");
  }
  
  public int numArgs() {
    return 4097;
  }
  
  public int match1(Object proc, CallContext ctx) {
    if (!(proc instanceof Procedure))
      return -786432;
    return super.match1(proc, ctx);
  }
  
  public void apply(CallContext ctx) throws Throwable
  {
    Procedure proc = (Procedure)value1;
    Continuation cont = new Continuation(ctx);
    proc.check1(cont, ctx);
    proc = proc;
    proc = null;
    try
    {
      proc.apply(ctx);
      ctx.runUntilDone();
      invoked = true;
    }
    catch (Exception ex)
    {
      Continuation.handleException$X(ex, cont, ctx);
    }
  }
  










  public void compile(ApplyExp exp, Compilation comp, Target target)
  {
    CompileMisc.compileCallCC(exp, comp, target, this);
  }
  
  public Type getReturnType(Expression[] args)
  {
    return Type.pointer_type;
  }
}
