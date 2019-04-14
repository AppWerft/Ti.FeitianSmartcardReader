package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;



public class CpoolString
  extends CpoolEntry
{
  CpoolUtf8 str;
  
  CpoolString() {}
  
  CpoolString(ConstantPool cpool, int hash, CpoolUtf8 str)
  {
    super(cpool, hash);
    this.str = str;
  }
  
  public int getTag() { return 8; }
  
  public final CpoolUtf8 getString()
  {
    return str;
  }
  
  static final int hashCode(CpoolUtf8 str) { return str.hashCode() ^ 0xF30F; }
  
  public int hashCode()
  {
    if (hash == 0)
      hash = hashCode(str);
    return hash;
  }
  
  void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeByte(8);
    dstr.writeShort(str.index);
  }
  
  public void print(ClassTypeWriter dst, int verbosity)
  {
    if (verbosity > 0)
    {
      dst.print("String ");
      if (verbosity == 2)
        dst.printOptionalIndex(str);
    }
    dst.printConstantTersely(str.index, 1);
  }
}
