package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;




public class BaseUnit
  extends NamedUnit
  implements Externalizable
{
  String dimension;
  static int base_count = 0;
  




  int index;
  




  private static final String unitName = "(name)";
  





  public String getDimension()
  {
    return dimension;
  }
  




  public BaseUnit()
  {
    name = "(name)";
    index = Integer.MAX_VALUE;
    dims = Dimensions.Empty;
  }
  
  protected void init()
  {
    base = this;
    scale = 1.0D;
    dims = new Dimensions(this);
    super.init();
    
    index = (base_count++);
  }
  


























  public BaseUnit(String name)
  {
    this.name = name;
    init();
  }
  
  public BaseUnit(String name, String dimension)
  {
    this.name = name;
    this.dimension = dimension;
    init();
  }
  
  public int hashCode() { return name.hashCode(); }
  
  public Unit unit() { return this; }
  




  public static BaseUnit lookup(String name, String dimension)
  {
    name = name.intern();
    if ((name == "(name)") && (dimension == null))
      return Unit.Empty;
    int hash = name.hashCode();
    int index = (hash & 0x7FFFFFFF) % table.length;
    for (NamedUnit unit = table[index]; unit != null; unit = chain)
    {
      if ((name == name) && ((unit instanceof BaseUnit)))
      {
        BaseUnit bunit = (BaseUnit)unit;
        if (dimension == dimension)
          return bunit;
      }
    }
    return null;
  }
  
  public static BaseUnit make(String name, String dimension)
  {
    BaseUnit old = lookup(name, dimension);
    return old == null ? new BaseUnit(name, dimension) : old;
  }
  
  public static int compare(BaseUnit unit1, BaseUnit unit2)
  {
    int code = name.compareTo(name);
    if (code != 0)
      return code;
    String dim1 = dimension;
    String dim2 = dimension;
    if (dim1 == dim2)
      return 0;
    if (dim1 == null)
      return -1;
    if (dim2 == null)
      return 1;
    return dim1.compareTo(dim2);
  }
  





  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeUTF(name);
    out.writeObject(dimension);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    name = in.readUTF();
    dimension = ((String)in.readObject());
  }
  
  public Object readResolve() throws ObjectStreamException
  {
    BaseUnit unit = lookup(name, dimension);
    if (unit != null)
      return unit;
    init();
    return this;
  }
}
