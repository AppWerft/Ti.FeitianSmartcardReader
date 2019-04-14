package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolMethodType
  extends CpoolEntry
{
  CpoolUtf8 descriptor;
  
  public CpoolMethodType() {}
  
  public int getTag()
  {
    return 16;
  }
  
  void write(DataOutputStream dstr) throws IOException { throw new Error(); }
  
  public void print(ClassTypeWriter dst, int verbosity)
  {
    if (verbosity > 0) {
      dst.print("MethodType");
      if (verbosity == 2) {
        dst.print(" descriptor: ");
        dst.printOptionalIndex(descriptor);
      } else {
        dst.print(' ');
      } }
    descriptor.print(dst, 0);
  }
}
