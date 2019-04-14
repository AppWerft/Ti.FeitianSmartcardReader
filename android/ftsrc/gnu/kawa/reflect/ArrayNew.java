package gnu.kawa.reflect;

import gnu.bytecode.Type;

public class ArrayNew extends gnu.mapping.Procedure1 implements java.io.Externalizable
{
  Type element_type;
  
  public ArrayNew(Type element_type) {
    this.element_type = element_type;
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArrayNew");
    
    setProperty(gnu.mapping.Procedure.compilerXKey, "gnu.kawa.reflect.CompileArrays:compileNew");
  }
  

  public boolean isSideEffectFree()
  {
    return true;
  }
  
  public Object apply1(Object count)
  {
    Class clas = element_type.getImplementationType().getReflectClass();
    return java.lang.reflect.Array.newInstance(clas, ((Number)count).intValue());
  }
  
  public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException
  {
    out.writeObject(element_type);
  }
  
  public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    element_type = ((Type)in.readObject());
  }
}
