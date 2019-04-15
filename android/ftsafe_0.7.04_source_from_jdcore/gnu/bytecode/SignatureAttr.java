package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;





public class SignatureAttr
  extends Attribute
{
  String signature;
  int signature_index;
  
  public final String getSignature() { return signature; }
  
  protected void setSignature(String sig) {
    signature = sig;
    signature_index = 0;
  }
  
  public SignatureAttr(String signature)
  {
    super("Signature");
    this.signature = signature;
  }
  
  public SignatureAttr(int index, Member owner)
  {
    super("Signature");
    ClassType ctype = (owner instanceof ClassType) ? (ClassType)owner : owner.getDeclaringClass();
    
    CpoolUtf8 signatureConstant = (CpoolUtf8)constants.getForced(index, 1);
    
    signature = string;
    signature_index = index;
  }
  
  public void assignConstants(ClassType cl)
  {
    super.assignConstants(cl);
    if (signature_index == 0)
      signature_index = cl.getConstants().addUtf8(signature).getIndex();
  }
  
  public final int getLength() { return 2; }
  
  public void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeShort(signature_index);
  }
  
  public void print(ClassTypeWriter dst)
  {
    super.print(dst);
    dst.print("  ");
    dst.printOptionalIndex(signature_index);
    dst.print('"');
    dst.print(getSignature());
    dst.println('"');
  }
}
