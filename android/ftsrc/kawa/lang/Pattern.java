package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.kawa.format.Printable;
import gnu.lists.Consumer;






public abstract class Pattern
  implements Printable
{
  public Pattern() {}
  
  public Object[] match(Object obj)
  {
    Object[] vars = new Object[varCount()];
    return match(obj, vars, 0) ? vars : null;
  }
  




  public abstract boolean match(Object paramObject, Object[] paramArrayOfObject, int paramInt);
  




  public static ClassType typePattern = ClassType.make("kawa.lang.Pattern");
  private static Type[] matchArgs = { Type.pointer_type, Compilation.objArrayType, Type.intType };
  
  public static final Method matchPatternMethod = typePattern.addMethod("match", matchArgs, Type.booleanType, 1);
  
  public abstract int varCount();
  
  public void print(Consumer out) { out.write(toString()); }
}
