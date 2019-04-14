package gnu.expr;

import gnu.bytecode.Type;







public abstract class Target
{
  public Target() {}
  
  public abstract Type getType();
  
  public static final Target Ignore = new IgnoreTarget();
  

  public static final Target pushObject = new StackTarget(Type.pointer_type);
  
  public abstract void compileFromStack(Compilation paramCompilation, Type paramType);
  
  public static Target pushValue(Type type) {
    return type.isVoid() ? Ignore : StackTarget.getInstance(type);
  }
}
