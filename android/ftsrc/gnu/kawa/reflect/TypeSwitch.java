package gnu.kawa.reflect;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

public class TypeSwitch extends MethodProc implements gnu.expr.Inlineable
{
  public static final TypeSwitch typeSwitch = new TypeSwitch("typeswitch");
  
  public TypeSwitch(String name) {
    setName(name);
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplyTypeSwitch");
  }
  

  public int numArgs() { return 61442; }
  
  public void apply(CallContext ctx) throws Throwable {
    Object[] args = ctx.getArgs();
    Object selector = args[0];
    int n = args.length - 1;
    for (int i = 1; i < n; i++) {
      MethodProc caseProc = (MethodProc)args[i];
      int m = caseProc.match1(selector, ctx);
      if (m >= 0)
        return;
    }
    Procedure defaultProc = (Procedure)args[n];
    defaultProc.check1(selector, ctx);
  }
  
  public void compile(ApplyExp exp, Compilation comp, Target target) {
    Expression[] args = exp.getArgs();
    
    CodeAttr code = comp.getCode();
    code.pushScope();
    Variable selector = code.addLocal(Type.pointer_type);
    args[0].compile(comp, Target.pushObject);
    code.emitStore(selector);
    int numCondClauses = 0;
    
    for (int i = 1; i < args.length;) {
      Expression arg = args[(i++)];
      
      if ((Compilation.enableANF) && ((arg instanceof ReferenceExp)))
      {
        arg = ((ReferenceExp)arg).getBinding().getValue();
      }
      
      if ((arg instanceof LambdaExp)) {
        LambdaExp lambda = (LambdaExp)arg;
        int numConditionsThisLambda = 0;
        for (Declaration param = lambda.firstDecl(); 
            param != null; param = param.nextDecl()) {
          Type type = param.getType();
          boolean hasInitExpr = param.getFlag(1099511627776L);
          
          Type valType = hasInitExpr ? param.getInitValue().getType() : args[0].getType();
          

          boolean isConditional = (type != Type.objectType) && (type != Type.toStringType) && (type != valType);
          

          if ((param.getCanRead()) || (isConditional))
            param.allocateVariable(code);
          if (isConditional) {
            if (numConditionsThisLambda > 0)
              code.emitAndThen();
            numConditionsThisLambda++;
          }
          Variable incoming;
          if (hasInitExpr) {
            Expression initExpr = param.getInitValue();
            Target ptarget = (isConditional) || (param.getCanRead()) ? Target.pushValue(valType) : Target.Ignore;
            

            initExpr.compile(comp, ptarget);
            Variable incoming; if (ptarget == Target.Ignore) {
              incoming = null;
            } else {
              Variable incoming = param.getContext().getVarScope().addVariable(code, valType.getImplementationType(), null);
              code.emitStore(incoming);
            }
          }
          else {
            incoming = selector;
          }
          if ((LazyType.maybeLazy(valType)) && (!LazyType.maybeLazy(type)))
          {
            code.emitLoad(incoming);
            valType = gnu.expr.StackTarget.forceLazy(comp, valType, type);
            incoming = param.getContext().getVarScope().addVariable(code, valType.getImplementationType(), null);
            code.emitStore(incoming);
          }
          boolean storeNeeded = param.getCanRead();
          if (isConditional) {
            if ((type instanceof TypeValue)) {
              ((TypeValue)type).emitTestIf(incoming, param, comp);
              storeNeeded = false;
            }
            else {
              code.emitLoad(incoming);
              type.emitIsInstance(code);
              code.emitIfIntNotZero();
            }
          }
          if (storeNeeded) {
            code.emitLoad(incoming);
            if ((isConditional) || (type == Type.toStringType))
              type.emitCoerceFromObject(code);
            param.compileStore(comp);
          }
        }
        lambda.allocChildClasses(comp);
        body.compileWithPosition(comp, target);
        if (numConditionsThisLambda == 0)
          break;
        if (i < args.length) {
          numCondClauses++;
          code.emitElse();
        }
      }
      else {
        throw new Error("not implemented: typeswitch arg not LambdaExp");
      }
    }
    for (;;) { numCondClauses--; if (numCondClauses < 0) break;
      code.emitFi();
    }
    code.popScope();
  }
  
  public Type getReturnType(Expression[] args)
  {
    return Type.pointer_type;
  }
}
