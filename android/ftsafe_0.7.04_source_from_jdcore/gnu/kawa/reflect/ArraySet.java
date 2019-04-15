package gnu.kawa.reflect;

import gnu.bytecode.Type;

public class ArraySet extends gnu.mapping.Procedure3 implements java.io.Externalizable
{
  Type element_type;
  
  public ArraySet(Type element_type) {
    this.element_type = element_type;
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArraySet");
    
    setProperty(gnu.mapping.Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileSet");
  }
  

  public Object apply3(Object array, Object index, Object value)
  {
    value = element_type.coerceFromObject(value);
    if ((element_type instanceof gnu.bytecode.PrimType))
      value = ((gnu.bytecode.PrimType)element_type).convertToRaw(value);
    java.lang.reflect.Array.set(array, ((Number)index).intValue(), value);
    

    return gnu.mapping.Values.empty;
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
