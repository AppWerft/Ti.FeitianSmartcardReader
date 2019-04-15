package gnu.expr;

import gnu.bytecode.Type;

public class StackTarget extends Target
{
  Type type;
  protected boolean autoTruncates;
  
  public StackTarget(Type type)
  {
    this.type = type;
  }
  




  boolean autoTruncates(Type stackType)
  {
    if ((autoTruncates) && (stackType == Type.intType)) {
      char sig1 = type.getSignature().charAt(0);
      if ((sig1 == 'B') || (sig1 == 'S') || (sig1 == 'C'))
        return true;
    }
    return false;
  }
  
  public Type getType() { return type; }
  
  public static Target getInstance(Type type)
  {
    return type == Type.pointer_type ? Target.pushObject : type.isVoid() ? Target.Ignore : new StackTarget(type);
  }
  

  public static Target getTruncatingInstance(Type type)
  {
    if (type.isVoid())
      return Target.Ignore;
    if (type == Type.pointer_type)
      return Target.pushObject;
    StackTarget target = new StackTarget(type);
    autoTruncates = true;
    return target;
  }
  
  protected StackTarget getClonedInstance(Type type) {
    return new StackTarget(type);
  }
  
  public static Type forceLazyIfNeeded(Compilation comp, Type stackType, Type type) {
    if ((gnu.kawa.reflect.LazyType.maybeLazy(stackType)) && (!gnu.kawa.reflect.LazyType.maybeLazy(type)))
      stackType = forceLazy(comp, stackType, type);
    return stackType;
  }
  
  public static Type forceLazy(Compilation comp, Type stackType, Type type) {
    Type rawType = type.getRawType();
    if (rawType.compare(stackType.getRawType()) < 0) { gnu.bytecode.Method forceMethod;
      gnu.bytecode.Method forceMethod;
      if ((stackType instanceof gnu.kawa.reflect.LazyType)) {
        forceMethod = gnu.kawa.reflect.LazyType.lazyType.getDeclaredMethod("getValue", 0);
      } else {
        int nargsforce;
        if ((rawType instanceof gnu.bytecode.ClassType)) {
          int nargsforce = 2;
          comp.loadClassRef((gnu.bytecode.ClassType)rawType);
        } else {
          nargsforce = 1; }
        forceMethod = gnu.bytecode.ClassType.make("gnu.mapping.Promise").getDeclaredStaticMethod("force", nargsforce);
      }
      
      gnu.bytecode.CodeAttr code = comp.getCode();
      code.emitInvoke(forceMethod);
      if ((stackType instanceof gnu.kawa.reflect.LazyType)) {
        stackType = ((gnu.kawa.reflect.LazyType)stackType).getValueType();
        if (type.isCompatibleWithValue(Type.objectType) != 2) {
          code.emitCheckcast(stackType.getRawType());
        }
      } else {
        stackType = Type.objectType;
      } }
    return stackType;
  }
  
  protected boolean compileFromStack0(Compilation comp, Type stackType)
  {
    return compileFromStack0(comp, stackType, type);
  }
  
  static boolean compileFromStack0(Compilation comp, Type stackType, Type type)
  {
    gnu.bytecode.CodeAttr code = comp.getCode();
    stackType = forceLazyIfNeeded(comp, stackType, type);
    if ((type.isCompatibleWithValue(stackType) == 2) || (!code.reachableHere()))
    {
      return true; }
    if (stackType.isVoid())
    {
      comp.compileConstant(gnu.mapping.Values.empty);
      stackType = Type.pointer_type;
    }
    else if (((stackType instanceof gnu.bytecode.PrimType)) && ((type instanceof gnu.bytecode.PrimType)))
    {
      code.emitConvert((gnu.bytecode.PrimType)stackType, (gnu.bytecode.PrimType)type);
      return true;
    }
    
    if ((stackType instanceof gnu.bytecode.ArrayType))
    {
      if ((type == Type.pointer_type) || ("java.lang.Cloneable".equals(type.getName())))
      {
        return true;
      }
    } else if ((stackType.getImplementationType() instanceof gnu.bytecode.PrimType))
    {
      type.emitConvertFromPrimitive(stackType, code);
      stackType = code.topType();
    }
    return type.isCompatibleWithValue(stackType) > 1;
  }
  
  public static void convert(Compilation comp, Type stackType, Type targetType)
  {
    if (!compileFromStack0(comp, stackType, targetType)) {
      emitCoerceFromObject(targetType, comp);
    }
  }
  
  protected static void emitCoerceFromObject(Type type, Compilation comp) {
    gnu.bytecode.CodeAttr code = comp.getCode();
    if ((type instanceof gnu.kawa.reflect.OccurrenceType))
    {

      comp.compileConstant(type, Target.pushObject);
      code.emitSwap();
      code.emitInvokeVirtual(gnu.bytecode.ClassType.make("gnu.bytecode.Type").getDeclaredMethod("coerceFromObject", 1));
      
      Type raw = type.getRawType();
      if (raw != Type.objectType) {
        code.emitCheckcast(raw);
      }
    }
    else {
      comp.usedClass(type);
      type.emitCoerceFromObject(code);
    }
  }
  
  public void compileFromStack(Compilation comp, Type stackType) {
    if (((type instanceof gnu.kawa.reflect.LazyType)) && (!(stackType instanceof gnu.kawa.reflect.LazyType))) {
      gnu.kawa.reflect.LazyType ltype = (gnu.kawa.reflect.LazyType)type;
      if (!gnu.kawa.reflect.LazyType.maybeLazy(stackType))
        getClonedInstance(ltype.getValueType()).compileFromStack(comp, stackType);
      gnu.bytecode.Method wrapMethod = gnu.bytecode.ClassType.make("gnu.mapping.Promise").getDeclaredStaticMethod("coerceToLazy", 1);
      comp.getCode().emitInvokeStatic(wrapMethod);
      comp.getCode().emitCheckcast(ltype.getRawType());
    }
    else if ((!autoTruncates(stackType)) && (!compileFromStack0(comp, stackType)))
    {
      doCoerce(comp);
    }
  }
  
  protected void doCoerce(Compilation comp) { emitCoerceFromObject(type, comp); }
}
