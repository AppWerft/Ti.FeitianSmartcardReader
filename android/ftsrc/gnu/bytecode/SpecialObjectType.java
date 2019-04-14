package gnu.bytecode;

import java.util.List;



public class SpecialObjectType
  extends ObjectType
{
  protected ClassType implementationType;
  
  public SpecialObjectType(String name, ClassType implementationType)
  {
    super(name);
    this.implementationType = implementationType;
    setSignature(implementationType.getSignature());
  }
  
  public Field getField(String name, int mask)
  {
    return implementationType.getField(name, mask);
  }
  
  public Method getMethod(String name, Type[] arg_types)
  {
    return implementationType.getMethod(name, arg_types);
  }
  
  public Method getDeclaredMethod(String name, int argCount) {
    return implementationType.getDeclaredMethod(name, argCount);
  }
  

  public int getMethods(Filter filter, int searchSupers, List<Method> result)
  {
    return implementationType.getMethods(filter, searchSupers, result);
  }
  
  public Class getReflectClass()
  {
    return implementationType.getReflectClass();
  }
  
  public Type getRealType()
  {
    return implementationType;
  }
  
  public Type getImplementationType()
  {
    return implementationType;
  }
  
  public int compare(Type other)
  {
    if (this == toStringType) {
      return other == Type.javalangObjectType ? -1 : (other == this) || (other == Type.javalangStringType) ? 0 : 1;
    }
    
    return super.compare(other);
  }
}
