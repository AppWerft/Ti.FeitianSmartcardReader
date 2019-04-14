package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;

public class CheckedTarget extends StackTarget
{
  LambdaExp proc;
  String procname;
  int argno;
  static ClassType typeClassCastException;
  static ClassType typeWrongType;
  static Method initWrongTypeStringMethod;
  static Method initWrongTypeProcMethod;
  
  public CheckedTarget(Type type)
  {
    super(type);
    argno = -4;
  }
  
  public CheckedTarget(Type type, LambdaExp proc, int argno)
  {
    super(type);
    this.proc = proc;
    procname = proc.getName();
    this.argno = argno;
  }
  
  public CheckedTarget(Type type, String procname, int argno)
  {
    super(type);
    this.procname = procname;
    this.argno = argno;
  }
  
  public static Target getInstance(Type type, String procname, int argno)
  {
    return type == Type.objectType ? Target.pushObject : new CheckedTarget(type, procname, argno);
  }
  

  public static Target getInstance(Type type, LambdaExp proc, int argno)
  {
    return type == Type.objectType ? Target.pushObject : new CheckedTarget(type, proc, argno);
  }
  

  public static Target getInstance(Type type)
  {
    return type == Type.objectType ? Target.pushObject : new CheckedTarget(type);
  }
  
  public static Target getInstance(Declaration decl)
  {
    Type type = decl.getType();
    if (type == Type.objectType)
      return Target.pushObject;
    StackTarget targ = new CheckedTarget(type, decl.getName(), -2);
    
    if (field != null)
      autoTruncates = true;
    return targ;
  }
  
  protected StackTarget getClonedInstance(Type type) {
    CheckedTarget target = new CheckedTarget(type);
    procname = procname;
    proc = proc;
    argno = argno;
    return target;
  }
  





  private static void initWrongType()
  {
    if (typeClassCastException == null)
      typeClassCastException = ClassType.make("java.lang.ClassCastException");
    if (typeWrongType == null)
    {
      typeWrongType = ClassType.make("gnu.mapping.WrongType");
      Type[] args = new Type[4];
      args[0] = typeClassCastException;
      args[1] = Compilation.javaStringType;
      args[2] = Type.intType;
      args[3] = Type.objectType;
      initWrongTypeStringMethod = typeWrongType.addMethod("<init>", 1, args, Type.voidType);
      

      args = new Type[4];
      args[0] = typeClassCastException;
      args[1] = Compilation.typeProcedure;
      args[2] = Type.intType;
      args[3] = Type.objectType;
      initWrongTypeProcMethod = typeWrongType.addMethod("<init>", 1, args, Type.voidType);
    }
  }
  

  protected void doCoerce(Compilation comp)
  {
    emitCheckedCoerce(comp, proc, procname, argno, type, null);
  }
  

  public static void emitCheckedCoerce(Compilation comp, String procname, int argno, Type type)
  {
    forceLazyIfNeeded(comp, Type.objectType, type);
    emitCheckedCoerce(comp, null, procname, argno, type, null);
  }
  

  public static void emitCheckedCoerce(Compilation comp, LambdaExp proc, int argno, Type stackType, Type type, Variable argValue)
  {
    forceLazyIfNeeded(comp, stackType, type);
    emitCheckedCoerce(comp, proc, proc.getName(), argno, type, argValue);
  }
  


  static void emitCheckedCoerce(Compilation comp, LambdaExp proc, String procname, int argno, Type type, Variable argValue)
  {
    CodeAttr code = comp.getCode();
    



    boolean isInTry = code.isInTry();
    initWrongType();
    Label startTry = new Label(code);
    gnu.bytecode.Scope tmpScope;
    if ((argValue == null) && (type != Type.toStringType))
    {
      gnu.bytecode.Scope tmpScope = code.pushScope();
      argValue = code.addLocal(Type.objectType);
      code.emitDup(1);
      code.emitStore(argValue);
    }
    else {
      tmpScope = null; }
    int startPC = code.getPC();
    startTry.define(code);
    emitCoerceFromObject(type, comp);
    
    int endPC = code.getPC();
    



    if ((endPC == startPC) || (type == Type.toStringType))
    {



      if (tmpScope != null)
        code.popScope();
      return;
    }
    
    Label endTry = new Label(code);
    endTry.define(code);
    
    Label endLabel = new Label(code);
    endLabel.setTypes(code);
    if (isInTry)
      code.emitGoto(endLabel);
    int fragment_cookie = 0;
    code.setUnreachable();
    if (!isInTry)
      fragment_cookie = code.beginFragment(endLabel);
    code.addHandler(startTry, endTry, typeClassCastException);
    

    boolean thisIsProc = false;
    if ((proc != null) && (proc.isClassGenerated()) && (!method.getStaticFlag()))
    {

      if (method.getDeclaringClass() == proc.getCompiledClassType(comp))
        thisIsProc = true;
    }
    int line = comp.getLineNumber();
    if (line > 0)
      code.putLineNumber(line);
    code.emitNew(typeWrongType);
    code.emitDupX();
    code.emitSwap();
    if (thisIsProc) {
      code.emitPushThis();
    } else {
      code.emitPushString((procname == null) && (argno != -4) ? "lambda" : procname);
    }
    
    code.emitPushInt(argno);
    code.emitLoad(argValue);
    code.emitInvokeSpecial(thisIsProc ? initWrongTypeProcMethod : initWrongTypeStringMethod);
    
    if (tmpScope != null)
      code.popScope();
    code.emitThrow();
    if (isInTry) {
      endLabel.define(code);
    } else {
      code.endFragment(fragment_cookie);
    }
  }
}
