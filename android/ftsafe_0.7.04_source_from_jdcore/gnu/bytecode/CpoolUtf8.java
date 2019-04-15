package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;



public class CpoolUtf8
  extends CpoolEntry
{
  String string;
  
  CpoolUtf8() {}
  
  CpoolUtf8(ConstantPool cpool, int h, String s)
  {
    super(cpool, h);
    string = s;
  }
  
  public int hashCode()
  {
    if (hash == 0)
      hash = string.hashCode();
    return hash;
  }
  
  public final void intern() { string = string.intern(); }
  
  public int getTag() { return 1; }
  
  public final String getString()
  {
    return string;
  }
  
  void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeByte(1);
    dstr.writeUTF(string);
  }
  
  public void print(ClassTypeWriter dst, int verbosity)
  {
    if (verbosity > 0)
      dst.print("Utf8: ");
    dst.printQuotedString(string);
  }
}
