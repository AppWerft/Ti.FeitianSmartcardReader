package gnu.kawa.functions;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.ReferenceExp;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Values;

public class ValuesMap extends gnu.mapping.MethodProc implements gnu.expr.Inlineable
{
  public static final ValuesMap valuesMap = new ValuesMap(-1);
  public static final ValuesMap valuesMapWithPos = new ValuesMap(1);
  private final int startCounter;
  
  private ValuesMap(int startCounter) {
    this.startCounter = startCounter;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyValuesMap");
  }
  



  public int numArgs()
  {
    return 8194;
  }
  
  public void apply(CallContext ctx) throws Throwable {
    Procedure proc = (Procedure)ctx.getNextArg();
    gnu.lists.Consumer out = consumer;
    Object val = ctx.getNextArg();
    Procedure.checkArgCount(proc, 1);
    if ((val instanceof Values))
    {
      int ipos = 0;
      int count = startCounter;
      Values values = (Values)val;
      while ((ipos = values.nextPos(ipos)) != 0)
      {
        Object v = values.getPosPrevious(ipos);
        if (startCounter >= 0) {
          proc.check2(v, gnu.math.IntNum.make(count++), ctx);
        } else
          proc.check1(v, ctx);
        ctx.runUntilDone();
      }
    }
    else
    {
      if (startCounter >= 0) {
        proc.check2(val, gnu.math.IntNum.make(startCounter), ctx);
      } else
        proc.check1(val, ctx);
      ctx.runUntilDone();
    }
  }
  

  static LambdaExp canInline(ApplyExp exp, ValuesMap proc)
  {
    Expression[] args = exp.getArgs();
    
    Expression arg0;
    if ((args.length == 2) && (((arg0 = args[0]) instanceof LambdaExp)))
    {
      LambdaExp lexp = (LambdaExp)arg0;
      if (min_args == max_args) if (min_args == (startCounter >= 0 ? 2 : 1))
        {
          return lexp; }
    }
    return null;
  }
  
  public void compile(ApplyExp exp, Compilation comp, gnu.expr.Target target)
  {
    LambdaExp lambda = canInline(exp, this);
    if (lambda == null)
    {
      ApplyExp.compile(exp, comp, target);
      return;
    }
    Expression[] args = exp.getArgs();
    if ((!(target instanceof gnu.expr.IgnoreTarget)) && (!(target instanceof gnu.expr.ConsumerTarget)))
    {

      gnu.expr.ConsumerTarget.compileUsingConsumer(exp, comp, target);
      return;
    }
    Expression vals = args[1];
    compileInlined(lambda, vals, startCounter, null, comp, target);
  }
  


  public static void compileInlined(LambdaExp lambda, Expression vals, int startCounter, gnu.bytecode.Method matchesMethod, Compilation comp, gnu.expr.Target target)
  {
    Declaration param = lambda.firstDecl();
    CodeAttr code = comp.getCode();
    gnu.bytecode.Scope scope = code.pushScope();
    

    Type paramType = param.getType();
    Declaration counterDecl; Variable counter; Declaration counterDecl; if (startCounter >= 0)
    {
      Variable counter = scope.addVariable(code, Type.intType, "position");
      code.emitPushInt(startCounter);
      code.emitStore(counter);
      counterDecl = new Declaration(counter);
    }
    else
    {
      counter = null;
      counterDecl = null;
    }
    

    if ((param.isSimple()) && (matchesMethod == null)) {
      param.allocateVariable(code);
    }
    else {
      String pname = gnu.expr.Mangling.mangleNameIfNeeded(param.getName());
      param = new Declaration(code.addLocal(paramType.getImplementationType(), pname)); }
    Expression[] args;
    Expression[] args;
    if (startCounter >= 0)
    {
      args = new Expression[] { new ReferenceExp(param), new ReferenceExp(counterDecl) };
    }
    else
    {
      args = new Expression[] { new ReferenceExp(param) }; }
    Expression app = new ApplyExp(lambda, args);
    if (matchesMethod != null)
    {

      if (app.getType().getImplementationType() != Type.booleanType) {
        app = new ApplyExp(matchesMethod, new Expression[] { app, new ReferenceExp(counterDecl) });
      }
      

      app = new gnu.expr.IfExp(app, new ReferenceExp(param), gnu.expr.QuoteExp.voidExp);
    }
    












    Variable indexVar = code.addLocal(Type.intType);
    Variable valuesVar = code.addLocal(Type.pointer_type);
    Variable nextVar = code.addLocal(Type.intType);
    
    vals.compileWithPosition(comp, gnu.expr.Target.pushObject);
    code.emitStore(valuesVar);
    code.emitPushInt(0);
    code.emitStore(indexVar);
    
    Label top = new Label(code);
    Label doneLabel = new Label(code);
    top.define(code);
    code.emitLoad(valuesVar);
    code.emitLoad(indexVar);
    code.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextIndex", 2));
    code.emitDup(Type.intType);
    code.emitStore(nextVar);
    
    code.emitGotoIfIntLtZero(doneLabel);
    
    code.emitLoad(valuesVar);
    code.emitLoad(indexVar);
    code.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextValue", 2));
    
    gnu.expr.StackTarget.convert(comp, Type.objectType, paramType);
    param.compileStore(comp);
    
    app.compile(comp, target);
    
    if (startCounter >= 0)
    {
      code.emitInc(counter, (short)1);
    }
    
    code.emitLoad(nextVar);
    code.emitStore(indexVar);
    code.emitGoto(top);
    
    doneLabel.define(code);
    
    code.popScope();
  }
  
  public Type getReturnType(Expression[] args)
  {
    return Type.pointer_type;
  }
}
