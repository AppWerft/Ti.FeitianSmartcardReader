package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class InnerClassesAttr
  extends Attribute
{
  int count;
  short[] data;
  
  public InnerClassesAttr(ClassType cl)
  {
    super("InnerClasses");
    addToFrontOf(cl);
  }
  
  public InnerClassesAttr(short[] data, ClassType cl)
  {
    this(cl);
    count = ((short)(data.length >> 2));
    this.data = data;
  }
  
  public static InnerClassesAttr getFirstInnerClasses(Attribute attr)
  {
    for (;; attr = attr.getNext())
    {
      if ((attr == null) || ((attr instanceof InnerClassesAttr))) {
        return (InnerClassesAttr)attr;
      }
    }
  }
  


  void addClass(CpoolClass centry, ClassType owner)
  {
    int i = 4 * count++;
    if (data == null) {
      data = new short[16];
    } else if (i >= data.length)
    {
      short[] tmp = new short[2 * i];
      System.arraycopy(data, 0, tmp, 0, i);
      data = tmp;
    }
    ConstantPool constants = constants;
    ClassType clas = (ClassType)centry.getClassType();
    
    String name = clas.getSimpleName();
    int name_index = (name == null) || (name.length() == 0) ? 0 : addUtf8index;
    
    data[i] = ((short)index);
    ClassType outer = clas.getDeclaringClass();
    data[(i + 1)] = (outer == null ? 0 : (short)addClassindex);
    
    data[(i + 2)] = ((short)name_index);
    int flags = clas.getModifiers();
    flags &= 0xFFFFFFDF;
    data[(i + 3)] = ((short)flags);
  }
  
  public void assignConstants(ClassType cl)
  {
    super.assignConstants(cl);
  }
  

  public int getLength()
  {
    return 2 + 8 * count;
  }
  

  public void write(DataOutputStream dstr)
    throws IOException
  {
    dstr.writeShort(count);
    for (int i = 0; i < count; i++)
    {
      dstr.writeShort(data[(4 * i)]);
      dstr.writeShort(data[(4 * i + 1)]);
      dstr.writeShort(data[(4 * i + 2)]);
      dstr.writeShort(data[(4 * i + 3)]);
    }
  }
  
  public void print(ClassTypeWriter dst)
  {
    ClassType ctype = (ClassType)container;
    ConstantPool constants = data == null ? null : ctype.getConstants();
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.print(getLength());
    dst.print(", count: ");
    dst.println(count);
    for (int i = 0; i < count; i++)
    {
      int inner_index = constants == null ? 0 : data[(4 * i)] & 0xFFFF;
      CpoolClass centry = (constants == null) || (inner_index == 0) ? null : constants.getForcedClass(inner_index);
      
      ClassType clas = (centry != null) && ((clas instanceof ClassType)) ? (ClassType)clas : null;
      

      dst.print(' ');
      int access = (inner_index == 0) && (clas != null) ? clas.getModifiers() : data[(4 * i + 3)] & 0xFFFF;
      
      dst.print(Access.toString(access, 'I'));
      dst.print(' ');
      String name;
      String name;
      if ((inner_index == 0) && (clas != null)) {
        name = clas.getSimpleName();
      }
      else {
        int index = data[(4 * i + 2)] & 0xFFFF;
        String name; if ((constants == null) || (index == 0)) {
          name = "(Anonymous)";
        }
        else {
          dst.printOptionalIndex(index);
          name = getForced1string;
        }
      }
      
      dst.print(name);
      dst.print(" = ");
      if (centry != null)
      {
        dst.printOptionalIndex(inner_index);
        name = centry.getClassName();
      }
      else {
        name = "(Unknown)"; }
      dst.print(name);
      dst.print("; ");
      if ((inner_index == 0) && (clas != null))
      {
        String iname = clas.getName();
        int dot = iname.lastIndexOf('.');
        if (dot > 0)
          iname = iname.substring(dot + 1);
        int start = iname.lastIndexOf('$') + 1;
        char ch;
        if ((start < iname.length()) && ((ch = iname.charAt(start)) >= '0') && (ch <= '9'))
        {
          dst.print("not a member");
        }
        else {
          dst.print("member of ");
          dst.print(ctype.getName());
        }
        
      }
      else
      {
        int index = data[(4 * i + 1)] & 0xFFFF;
        if (index == 0) {
          dst.print("not a member");
        }
        else {
          dst.print("member of ");
          CpoolEntry oentry = constants.getForced(index, 7);
          dst.print(((CpoolClass)oentry).getStringName());
        }
      }
      dst.println();
    }
  }
}
