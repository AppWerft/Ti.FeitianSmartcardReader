package gnu.kawa.reflect;

import gnu.bytecode.Type;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ArrayLength extends gnu.mapping.Procedure1 implements java.io.Externalizable
{
  Type element_type;
  
  public ArrayLength(Type element_type)
  {
    this.element_type = element_type;
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArrayLength");
    
    setProperty(gnu.mapping.Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileLength");
  }
  

  public Object apply1(Object array)
  {
    return gnu.math.IntNum.make(java.lang.reflect.Array.getLength(array));
  }
  
  public boolean isSideEffectFree()
  {
    return true;
  }
  
  public void writeExternal(ObjectOutput out) throws java.io.IOException
  {
    out.writeObject(element_type);
  }
  
  public void readExternal(ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    element_type = ((Type)in.readObject());
  }
}
