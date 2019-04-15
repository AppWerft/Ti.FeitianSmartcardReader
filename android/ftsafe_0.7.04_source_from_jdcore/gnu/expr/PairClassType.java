package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;






















public class PairClassType
  extends ClassType
{
  Object staticLink;
  public ClassType instanceType;
  
  public PairClassType() {}
  
  PairClassType(Class reflectInterface, Class reflectInstanceClass)
  {
    super(reflectInterface.getName());
    setExisting(true);
    reflectClass = reflectInterface;
    Type.registerTypeForClass(reflectInterface, this);
    instanceType = ((ClassType)Type.make(reflectInstanceClass));
  }
  

  public static PairClassType make(Class reflectInterface, Class reflectInstanceClass)
  {
    return new PairClassType(reflectInterface, reflectInstanceClass);
  }
  


  public static PairClassType make(Class reflectInterface, Class reflectInstanceClass, Object staticLink)
  {
    PairClassType type = new PairClassType(reflectInterface, reflectInstanceClass);
    
    staticLink = staticLink;
    return type;
  }
  
  public Object getStaticLink()
  {
    return staticLink;
  }
  

  public static Object extractStaticLink(ClassType type)
  {
    return staticLink;
  }
}
