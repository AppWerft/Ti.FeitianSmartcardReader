package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolValue1
  extends CpoolEntry
{
  int tag;
  int value;
  
  CpoolValue1(int tag)
  {
    this.tag = tag;
  }
  
  CpoolValue1(ConstantPool cpool, int tag, int hash, int value) {
    super(cpool, hash);
    this.tag = tag;
    this.value = value;
  }
  
  public int getTag() { return tag; }
  
  public final int getValue()
  {
    return value;
  }
  
  static int hashCode(int val) { return val; }
  
  public int hashCode()
  {
    if (hash == 0)
      hash = value;
    return hash;
  }
  
  void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeByte(tag);
    dstr.writeInt(value);
  }
  
  public void print(ClassTypeWriter dst, int verbosity)
  {
    if (tag == 3)
    {
      if (verbosity > 0)
        dst.print("Integer ");
      dst.print(value);
      if ((verbosity > 1) && (value != 0))
      {
        dst.print("=0x");
        dst.print(Integer.toHexString(value));
      }
    }
    else
    {
      if (verbosity > 0)
        dst.print("Float ");
      dst.print(Float.intBitsToFloat(value));
      if (verbosity > 1)
      {
        dst.print("=0x");
        dst.print(Integer.toHexString(value));
      }
    }
  }
}
