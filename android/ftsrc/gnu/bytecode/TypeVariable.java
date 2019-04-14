package gnu.bytecode;

import java.lang.reflect.ParameterizedType;



public class TypeVariable
  extends ObjectType
{
  ClassType rawType;
  java.lang.reflect.TypeVariable rtype;
  
  public TypeVariable(String name)
  {
    super(name);
  }
  
  public static TypeVariable make(java.lang.reflect.TypeVariable rtype) {
    TypeVariable tvar = new TypeVariable(rtype.getName());
    rawType = Type.objectType;
    java.lang.reflect.Type[] bounds = rtype.getBounds();
    Type bound = null;
    if (bounds.length == 1) {
      java.lang.reflect.Type bound0 = bounds[0];
      if ((bound0 instanceof Class)) {
        bound = Type.make(bound0);
      } else if ((bound0 instanceof ParameterizedType))
        bound = Type.make(((ParameterizedType)bound0).getRawType());
    }
    if (bound != null)
      bound = bound.getRawType();
    if ((bound instanceof ClassType))
      rawType = ((ClassType)bound);
    rtype = rtype;
    return tvar;
  }
  
  public int compare(Type other) {
    return rawType.compare(other);
  }
  
  public ClassType getRawType() {
    return rawType;
  }
  
  public void emitCoerceFromObject(CodeAttr code) {
    rawType.emitCoerceFromObject(code);
  }
  

  public String getSignature() { return getRawType().getSignature(); }
  
  public boolean equals(Object other) {
    if (!(other instanceof TypeVariable))
      return false;
    TypeVariable tvother = (TypeVariable)other;
    return (Type.isSame(rawType, rawType)) && (getName().equals(tvother.getName()));
  }
}
