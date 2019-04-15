package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;










public class NamedUnit
  extends Unit
  implements Externalizable
{
  String name;
  double scale;
  Unit base;
  NamedUnit chain;
  
  public NamedUnit() {}
  
  public NamedUnit(String name, DQuantity value)
  {
    this.name = name.intern();
    scale = factor;
    base = unt;
    init();
  }
  
  public NamedUnit(String name, double factor, Unit base)
  {
    this.name = name;
    this.base = base;
    scale = factor;
    init();
  }
  
  protected void init()
  {
    factor = (scale * base.factor);
    dims = base.dims;
    name = name.intern();
    int hash = name.hashCode();
    int index = (hash & 0x7FFFFFFF) % table.length;
    chain = table[index];
    table[index] = this;
  }
  
  public String getName() { return name; }
  
  public static NamedUnit lookup(String name)
  {
    name = name.intern();
    int hash = name.hashCode();
    int index = (hash & 0x7FFFFFFF) % table.length;
    for (NamedUnit unit = table[index]; unit != null; unit = chain)
    {
      if (name == name)
        return unit;
    }
    return null;
  }
  
  public static NamedUnit lookup(String name, double scale, Unit base)
  {
    name = name.intern();
    int hash = name.hashCode();
    int index = (hash & 0x7FFFFFFF) % table.length;
    for (NamedUnit unit = table[index]; unit != null; unit = chain)
    {
      if ((name == name) && (scale == scale) && (base == base))
        return unit;
    }
    return null;
  }
  
  public static NamedUnit make(String name, double scale, Unit base)
  {
    NamedUnit old = lookup(name, scale, base);
    return old == null ? new NamedUnit(name, scale, base) : old;
  }
  
  public static NamedUnit make(String name, Quantity value) {
    double scale;
    double scale;
    if ((value instanceof DQuantity)) {
      scale = factor;
    } else { if (value.imValue() != 0.0D) {
        throw new ArithmeticException("defining " + name + " using complex value");
      }
      
      scale = value.re().doubleValue(); }
    Unit base = value.unit();
    NamedUnit old = lookup(name, scale, base);
    return old == null ? new NamedUnit(name, scale, base) : old;
  }
  




  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeUTF(name);
    out.writeDouble(scale);
    out.writeObject(base);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    name = in.readUTF();
    scale = in.readDouble();
    base = ((Unit)in.readObject());
  }
  
  public Object readResolve() throws ObjectStreamException
  {
    NamedUnit unit = lookup(name, scale, base);
    if (unit != null)
      return unit;
    init();
    return this;
  }
}
