package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;








public abstract class Attribute
{
  AttrContainer container;
  private Attribute next;
  String name;
  int name_index;
  
  public final AttrContainer getContainer() { return container; }
  
  public final void setContainer(AttrContainer container) { this.container = container; }
  


  public final Attribute getNext() { return next; }
  
  public final void setNext(Attribute next) { this.next = next; }
  
  public ConstantPool getConstants()
  {
    return getContainer().getConstants();
  }
  

  public void addToFrontOf(AttrContainer container)
  {
    setContainer(container);
    setNext(container.getAttributes());
    container.setAttributes(this);
  }
  





  public final boolean isSkipped()
  {
    return name_index < 0;
  }
  
  public final void setSkipped(boolean skip) { name_index = (skip ? -1 : 0); }
  

  public final void setSkipped() { name_index = -1; }
  
  public final String getName() { return name; }
  public final void setName(String name) { this.name = name.intern(); }
  
  public final int getNameIndex() { return name_index; }
  public final void setNameIndex(int index) { name_index = index; }
  


  public Attribute(String name)
  {
    this.name = name;
  }
  





  public static Attribute get(AttrContainer container, String name)
  {
    for (Attribute attr = container.getAttributes(); 
        attr != null; attr = next)
    {
      if (attr.getName() == name)
        return attr;
    }
    return null;
  }
  



  public void assignConstants(ClassType cl)
  {
    if (name_index == 0) {
      name_index = cl.getConstants().addUtf8(name).getIndex();
    }
  }
  

  public static void assignConstants(AttrContainer container, ClassType cl)
  {
    for (Attribute attr = container.getAttributes(); 
        attr != null; attr = next)
    {
      if (!attr.isSkipped()) {
        attr.assignConstants(cl);
      }
    }
  }
  

  public abstract int getLength();
  

  public static int getLengthAll(AttrContainer container)
  {
    int length = 0;
    for (Attribute attr = container.getAttributes(); 
        attr != null; attr = next)
    {
      if (!attr.isSkipped())
        length += 6 + attr.getLength();
    }
    return length;
  }
  

  public abstract void write(DataOutputStream paramDataOutputStream)
    throws IOException;
  

  public static int count(AttrContainer container)
  {
    int count = 0;
    for (Attribute attr = container.getAttributes(); 
        attr != null; attr = next)
    {
      if (!attr.isSkipped())
        count++;
    }
    return count;
  }
  
  public static void writeAll(AttrContainer container, DataOutputStream dstr)
    throws IOException
  {
    int count = count(container);
    dstr.writeShort(count);
    for (Attribute attr = container.getAttributes(); 
        attr != null; attr = next)
    {
      if (!attr.isSkipped())
      {
        if (name_index == 0)
          throw new Error("Attribute.writeAll called without assignConstants");
        dstr.writeShort(name_index);
        dstr.writeInt(attr.getLength());
        attr.write(dstr);
      }
    }
  }
  
  public void print(ClassTypeWriter dst) {
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.println(getLength());
  }
}
