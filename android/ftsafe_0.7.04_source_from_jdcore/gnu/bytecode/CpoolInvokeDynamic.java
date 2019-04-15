package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;



public class CpoolInvokeDynamic
  extends CpoolEntry
{
  int bootstrapMethodIndex;
  CpoolNameAndType nameAndType;
  
  public CpoolInvokeDynamic() {}
  
  public int getTag() { return 18; }
  
  void write(DataOutputStream dstr) throws IOException {
    dstr.writeByte(18);
    dstr.writeShort(bootstrapMethodIndex);
    dstr.writeShort(nameAndType.index);
  }
  
  public void print(ClassTypeWriter dst, int verbosity) {
    if (verbosity > 0) {
      dst.print("InvokeDynamic ");
    }
    

    dst.print("bootstrap_method: #");
    dst.print(bootstrapMethodIndex);
    dst.print(' ');
    nameAndType.print(dst, 0);
  }
}
