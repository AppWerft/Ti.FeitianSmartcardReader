package gnu.bytecode;

import java.util.Vector;

public class ObjectType extends Type
{
  static final int ADD_FIELDS_DONE = 1;
  static final int ADD_METHODS_DONE = 2;
  static final int ADD_MEMBERCLASSES_DONE = 4;
  static final int ADD_ENCLOSING_DONE = 8;
  static final int EXISTING_CLASS = 16;
  static final int HAS_OUTER_LINK = 32;
  public int flags;
  
  protected ObjectType() {
    size = 4;
  }
  
  public ObjectType(String name)
  {
    this_name = name;
    size = 4;
  }
  












  public final boolean isExisting()
  {
    Type t = getImplementationType();
    if ((t instanceof ArrayType))
      t = ((ArrayType)t).getComponentType();
    if (t == this) {
      return (flags & 0x10) != 0;
    }
    return t.isExisting();
  }
  
  public final void setExisting(boolean existing)
  {
    if (existing) flags |= 0x10; else {
      flags &= 0xFFFFFFEF;
    }
  }
  





  public String getInternalName()
  {
    return getName().replace('.', '/');
  }
  




















  public static Class getContextClass(String cname)
    throws ClassNotFoundException
  {
    return Class.forName(cname, false, getContextClassLoader());
  }
  
  public static ClassLoader getContextClassLoader()
  {
    try
    {
      return Thread.currentThread().getContextClassLoader();
    }
    catch (SecurityException ex) {}
    



    return ObjectType.class.getClassLoader();
  }
  





  public Class getReflectClass()
  {
    try
    {
      if (reflectClass == null)
        reflectClass = getContextClass(getInternalName().replace('/', '.'));
      setExisting(true);
    }
    catch (ClassNotFoundException ex)
    {
      if ((flags & 0x10) != 0)
      {
        throw new RuntimeException("no such class: " + getName(), ex);
      }
    }
    return reflectClass;
  }
  
  public boolean isInstance(Object obj)
  {
    if (this == nullType)
      return obj == null;
    return super.isInstance(obj);
  }
  
  public Field getField(String name, int mask)
  {
    return null;
  }
  
  public Method getMethod(String name, Type[] arg_types)
  {
    return Type.objectType.getMethod(name, arg_types);
  }
  

  @Deprecated
  public final int getMethods(Filter filter, int searchSupers, Vector result, String context)
  {
    return getMethods(filter, searchSupers, result);
  }
  
  public int getMethods(Filter filter, int searchSupers, java.util.List<Method> result)
  {
    return Type.objectType.getMethods(filter, searchSupers, result);
  }
  
  public int compare(Type other) {
    if (this == other)
      return 0;
    if (this == nullType) {
      return -1;
    }
    return -3;
  }
  





  public Object coerceFromObject(Object obj)
  {
    if (obj != null)
    {
      if (this == Type.toStringType)
        return obj.toString();
      Class clas = getReflectClass();
      Class objClass = obj.getClass();
      if (!clas.isAssignableFrom(objClass)) {
        throw new ClassCastException("don't know how to coerce " + objClass.getName() + " to " + getName());
      }
    }
    
    return obj;
  }
  

  public void emitCoerceFromObject(CodeAttr code)
  {
    if (this == Type.toStringType)
    {






      code.emitDup();
      code.emitIfNull();
      code.emitPop(1);
      code.emitPushNull();
      code.emitElse();
      code.emitInvokeVirtual(Type.toString_method);
      code.emitFi();
    }
    else if (this != Type.objectType) {
      code.emitCheckcast(this);
    }
  }
}
