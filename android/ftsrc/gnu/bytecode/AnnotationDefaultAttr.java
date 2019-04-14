package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;



public class AnnotationDefaultAttr
  extends Attribute
{
  int dataLength;
  AnnotationEntry.Value value;
  
  public AnnotationDefaultAttr(String name, AnnotationEntry.Value value, AttrContainer container)
  {
    super(name);
    this.value = value;
    addToFrontOf(container);
  }
  
  public int getLength() { return dataLength; }
  
  public void print(ClassTypeWriter dst)
  {
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.println(getLength());
    dst.print("  Default: ");
    value.print(2, dst);
  }
  
  public void assignConstants(ClassType cl)
  {
    super.assignConstants(cl);
    dataLength += RuntimeAnnotationsAttr.assignConstants(value, cl.getConstants());
  }
  
  public void write(DataOutputStream dstr) throws IOException
  {
    RuntimeAnnotationsAttr.write(value, getConstants(), dstr);
  }
}
