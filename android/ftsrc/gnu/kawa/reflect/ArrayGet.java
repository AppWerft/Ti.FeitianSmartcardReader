package gnu.kawa.reflect;

import gnu.bytecode.Type;

public class ArrayGet extends gnu.mapping.Procedure2 implements java.io.Externalizable
{
  Type element_type;
  
  public ArrayGet(Type element_type)
  {
    this.element_type = element_type;
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArrayGet");
    
    setProperty(gnu.mapping.Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileGet");
  }
  

  public Object apply2(Object array, Object index)
  {
    Object value = java.lang.reflect.Array.get(array, ((Number)index).intValue());
    return element_type.coerceToObject(value);
  }
  
  public boolean isSideEffectFree()
  {
    return true;
  }
  
  public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException
  {
    out.writeObject(element_type);
  }
  
  public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    element_type = ((Type)in.readObject());
  }
}
