package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;






public class ExceptionsAttr
  extends Attribute
{
  ClassType[] exceptions;
  short[] exception_table;
  
  public ExceptionsAttr(Method meth)
  {
    super("Exceptions");
    addToFrontOf(meth);
  }
  


  public void setExceptions(short[] indices, ClassType cl)
  {
    exception_table = indices;
    exceptions = new ClassType[indices.length];
    ConstantPool cp = cl.getConstants();
    for (int i = indices.length - 1; i >= 0; i--) {
      exceptions[i] = ((ClassType)((CpoolClass)cp.getPoolEntry(indices[i])).getClassType());
    }
  }
  


  public void setExceptions(ClassType[] excep_types)
  {
    exceptions = excep_types;
  }
  
  public void assignConstants(ClassType cl)
  {
    super.assignConstants(cl);
    ConstantPool cp = cl.getConstants();
    int count = exceptions.length;
    exception_table = new short[count];
    for (int i = count - 1; i >= 0; i--)
    {
      exception_table[i] = ((short)addClassexceptions[i]).index);
    }
  }
  


  public final int getLength()
  {
    return 2 + 2 * (exceptions == null ? 0 : exceptions.length);
  }
  

  public final ClassType[] getExceptions()
  {
    return exceptions;
  }
  
  public void write(DataOutputStream dstr) throws IOException
  {
    int count = exceptions.length;
    dstr.writeShort(count);
    for (int i = 0; i < count; i++)
    {
      dstr.writeShort(exception_table[i]);
    }
  }
  
  public void print(ClassTypeWriter dst)
  {
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.print(getLength());
    dst.print(", count: ");
    int count = exceptions.length;
    dst.println(count);
    for (int i = 0; i < count; i++)
    {
      int catch_type_index = exception_table[i] & 0xFFFF;
      dst.print("  ");
      dst.printOptionalIndex(catch_type_index);
      dst.printConstantTersely(catch_type_index, 7);
      dst.println();
    }
  }
}
