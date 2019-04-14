package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.Type;

public class LazyType
  extends ObjectType
{
  ClassType rawType;
  Type valueType;
  ParameterizedType implementationType;
  
  public Type getValueType()
  {
    return valueType;
  }
  
  public Type getRawType() {
    return rawType;
  }
  
  public LazyType(ClassType rawType, Type valueType) {
    this.rawType = rawType;
    this.valueType = valueType;
  }
  
  public Type getImplementationType()
  {
    if (implementationType == null) {
      implementationType = new ParameterizedType(rawType, new Type[] { valueType });
      implementationType.setTypeArgumentBound(0, '+');
    }
    return implementationType;
  }
  
  public static LazyType getInstance(ClassType rawType, Type valueType) {
    return new LazyType(rawType, valueType);
  }
  
  public static final ClassType lazyType = ClassType.make("gnu.mapping.Lazy");
  public static final ClassType promiseType = ClassType.make("gnu.mapping.Promise");
  
  public int compare(Type other) {
    return valueType.compare(other);
  }
  
  public static LazyType getLazyType(Type valueType) {
    return getInstance(lazyType, valueType);
  }
  
  public static LazyType getPromiseType(Type valueType) {
    return getInstance(promiseType, valueType);
  }
  
  public String toString() {
    return rawType.toString() + '[' + valueType.toString() + ']';
  }
  
  public static boolean maybeLazy(Type type) {
    type = type.getRawType();
    if (((type instanceof ClassType)) && (((ClassType)type).implementsInterface(lazyType)))
    {
      return true; }
    if (type == Type.objectType)
      return true;
    return false;
  }
}
