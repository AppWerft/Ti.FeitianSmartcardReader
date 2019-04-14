package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.OccurrenceType;

public class ConsumerTarget extends Target
{
  Variable consumer;
  boolean isContextTarget;
  Type type;
  private ConsumerTarget singleTarget;
  
  public ConsumerTarget(Variable consumer)
  {
    this.consumer = consumer;
    type = Type.objectType;
  }
  
  public ConsumerTarget(Variable consumer, Type type)
  {
    this.consumer = consumer;
    this.type = type;
  }
  


  public ConsumerTarget getSingleTarget()
  {
    if (singleTarget == null) { Type base;
      Type base;
      if ((!(type instanceof OccurrenceType)) || (!OccurrenceType.itemCountIsOne(base = ((OccurrenceType)type).getBase())))
      {

        base = gnu.kawa.reflect.SingletonType.getInstance(); }
      singleTarget = new ConsumerTarget(consumer, base);
      singleTarget.isContextTarget = isContextTarget;
    }
    return singleTarget;
  }
  
  public Variable getConsumerVariable() { return consumer; }
  
  public final boolean isContextTarget() {
    return isContextTarget;
  }
  
  public static Target makeContextTarget(Compilation comp, Type type)
  {
    CodeAttr code = comp.getCode();
    comp.loadCallContext();
    code.emitGetField(Compilation.typeCallContext.getDeclaredField("consumer"));
    
    Scope scope = code.getCurrentScope();
    Variable result = scope.addVariable(code, Compilation.typeConsumer, "$result");
    
    code.emitStore(result);
    ConsumerTarget target = new ConsumerTarget(result, type);
    isContextTarget = true;
    return target;
  }
  
  public static void compileUsingValues(Expression exp, Compilation comp, Target target)
  {
    ClassType typeValues = Compilation.typeValues;
    compileUsingConsumer(exp, comp, target, typeValues.getDeclaredMethod("make", 0), typeValues.getDeclaredMethod("canonicalize", 0));
  }
  



  public static void compileUsingConsumer(Expression exp, Compilation comp, Target target)
  {
    if (((target instanceof IgnoreTarget)) || ((target instanceof ConsumerTarget))) {
      exp.compile(comp, target);
    } else {
      compileUsingValues(exp, comp, target);
    }
  }
  


  public static void compileUsingConsumer(Expression exp, Compilation comp, Target target, Method makeMethod, Method resultMethod)
  {
    CodeAttr code = comp.getCode();
    Scope scope = code.pushScope();
    Type ctype;
    if (makeMethod.getName() == "<init>")
    {
      ClassType cltype = makeMethod.getDeclaringClass();
      Type ctype = cltype;
      code.emitNew(cltype);
      code.emitDup(ctype);
      code.emitInvoke(makeMethod);
    }
    else
    {
      ctype = makeMethod.getReturnType();
      code.emitInvokeStatic(makeMethod);
    }
    Variable consumer = scope.addVariable(code, ctype, null);
    ConsumerTarget ctarget = new ConsumerTarget(consumer, exp.getType());
    code.emitStore(consumer);
    exp.compile(comp, ctarget);
    code.emitLoad(consumer);
    if (resultMethod != null)
      code.emitInvoke(resultMethod);
    code.popScope();
    target.compileFromStack(comp, exp.getType());
  }
  

  public void compileFromStack(Compilation comp, Type stackType)
  {
    compileFromStack(comp, stackType, -1);
  }
  






  void compileFromStack(Compilation comp, Type stackType, int consumerPushed)
  {
    CodeAttr code = comp.getCode();
    String methodName = null;
    Method method = null;
    ClassType methodClass = Compilation.typeConsumer;
    Type methodArg = null;
    boolean islong = false;
    
    Type ttype = getType();
    if (!stackType.isVoid()) {
      StackTarget.convert(comp, stackType, ttype);
      stackType = ttype;
    }
    

    if (((stackType instanceof LangPrimType)) && ((stackType == LangPrimType.characterType) || (stackType == LangPrimType.characterOrEofType)))
    {

      stackType.emitCoerceToObject(code);
      stackType = Type.objectType;
    }
    Type implType = stackType.getImplementationType();
    char sig; if ((implType instanceof PrimType))
    {
      char sig = implType.getSignature().charAt(0);
      switch (sig)
      {
      case 'I': 
        if (stackType == LangPrimType.unsignedIntType) {
          methodName = "writeUInt";
          methodClass = typeSequences; }
        break;
      
      case 'B': 
      case 'S': 
        methodName = "writeInt";
        methodArg = Type.intType;
        break;
      case 'J': 
        if (stackType == LangPrimType.unsignedLongType) {
          methodName = "writeULong";
          methodClass = typeSequences;
        } else {
          methodName = "writeLong";
          methodArg = Type.longType;
        }
        islong = true;
        break;
      case 'F': 
        methodName = "writeFloat";
        methodArg = Type.floatType;
        break;
      case 'D': 
        methodName = "writeDouble";
        methodArg = Type.doubleType;
        islong = true;
        break;
      
      case 'C': 
        methodName = "append";
        methodArg = Type.charType;
        



        break;
      case 'Z': 
        methodName = "writeBoolean";
        methodArg = Type.booleanType;
        break;
      case 'V':  return;
      }
    }
    else
    {
      sig = '\000';
      if ((consumerPushed == 1) || (OccurrenceType.itemCountIsOne(implType)))
      {
        methodName = "writeObject";
        methodArg = Type.pointer_type;
      }
      else
      {
        method = Compilation.typeValues.getDeclaredMethod("writeValues", 2);
        
        code.emitLoad(consumer);
        if (consumerPushed == 0)
          code.emitSwap();
        code.emitInvokeStatic(method);
        return;
      }
    }
    if (consumerPushed >= 0)
    {
      if (methodClass == typeSequences) throw new InternalError();
    }
    else if (methodClass == typeSequences)
    {
      code.emitLoad(consumer);
    }
    else if (islong)
    {
      code.pushScope();
      Variable temp = code.addLocal(implType);
      code.emitStore(temp);
      code.emitLoad(consumer);
      code.emitLoad(temp);
      code.popScope();
    }
    else
    {
      code.emitLoad(consumer);
      code.emitSwap();
    }
    if (methodClass == typeSequences)
    {
      method = methodClass.getDeclaredMethod(methodName, 2);
    }
    else if ((method == null) && (methodName != null))
    {
      Type[] methodArgs = { methodArg };
      method = methodClass.getDeclaredMethod(methodName, methodArgs);
    }
    if (method != null)
      code.emitInvoke(method);
    if (sig == 'C') {
      code.emitPop(1);
    }
  }
  
  public boolean compileWrite(Expression exp, Compilation comp) {
    Type stackType = exp.getType();
    Type implType = stackType.getImplementationType();
    if ((implType instanceof PrimType) ? (!implType.isVoid()) && (stackType != LangPrimType.characterType) && (stackType != LangPrimType.characterOrEofType) && (stackType != LangPrimType.unsignedLongType) && (stackType != LangPrimType.unsignedIntType) : OccurrenceType.itemCountIsOne(implType))
    {







      comp.getCode().emitLoad(consumer);
      Type ttype = type;
      exp.compile(comp, StackTarget.getInstance(ttype));
      compileFromStack(comp, ttype, 1);
      return true;
    }
    return false;
  }
  
  public Type getType() { return type; }
  
  public static final ClassType typeSequences = ClassType.make("gnu.lists.Sequences");
}
