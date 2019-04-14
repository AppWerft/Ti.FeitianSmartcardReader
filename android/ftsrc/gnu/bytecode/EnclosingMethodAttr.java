package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class EnclosingMethodAttr
  extends Attribute
{
  int class_index;
  int method_index;
  Method method;
  
  public EnclosingMethodAttr(ClassType cl)
  {
    super("EnclosingMethod");
    addToFrontOf(cl);
  }
  
  public EnclosingMethodAttr(int class_index, int method_index, ClassType ctype)
  {
    this(ctype);
    this.class_index = class_index;
    this.method_index = method_index;
  }
  
  public static EnclosingMethodAttr getFirstEnclosingMethod(Attribute attr)
  {
    for (;; attr = attr.getNext())
    {
      if ((attr == null) || ((attr instanceof EnclosingMethodAttr)))
        return (EnclosingMethodAttr)attr; }
  }
  
  public int getLength() {
    return 4;
  }
  
  public void assignConstants(ClassType cl) {
    super.assignConstants(cl);
    if (method != null)
    {
      ConstantPool constants = cl.getConstants();
      class_index = constants.addClass(method.getDeclaringClass()).getIndex();
      method_index = constants.addNameAndType(method).getIndex();
    }
  }
  
  public void write(DataOutputStream dstr)
    throws IOException
  {
    dstr.writeShort(class_index);
    dstr.writeShort(method_index);
  }
  
  public void print(ClassTypeWriter dst)
  {
    ClassType ctype = (ClassType)container;
    ConstantPool constants = ctype.getConstants();
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.println(getLength());
    dst.print("  class: ");
    dst.printOptionalIndex(class_index);
    CpoolEntry centry = constants.getForced(class_index, 7);
    dst.print(((CpoolClass)centry).getClassName());
    if (method_index != 0)
    {
      dst.print(", method: ");
      dst.printOptionalIndex(method_index);
      centry = constants.getForced(method_index, 12);
      centry.print(dst, 0);
    }
    dst.println();
  }
}
