package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

class MulUnit
  extends Unit
  implements Externalizable
{
  Unit unit1;
  Unit unit2;
  int power1;
  int power2;
  MulUnit next;
  
  MulUnit(Unit unit1, int power1, Unit unit2, int power2)
  {
    this.unit1 = unit1;
    this.unit2 = unit2;
    this.power1 = power1;
    this.power2 = power2;
    dims = Dimensions.product(dims, power1, dims, power2);
    
    if (power1 == 1) {
      factor = factor;
    } else
      factor = Math.pow(factor, power1);
    if (power2 < 0)
    {
      int i = -power2; for (;;) { i--; if (i < 0) break;
        factor /= factor;
      }
    }
    else {
      int i = power2; for (;;) { i--; if (i < 0) break;
        factor *= factor;
      }
    }
    next = products;
    products = this;
  }
  
  MulUnit(Unit unit1, Unit unit2, int power2)
  {
    this(unit1, 1, unit2, power2);
  }
  
  public String toString()
  {
    StringBuffer str = new StringBuffer(60);
    str.append(unit1);
    if (power1 != 1)
    {
      str.append('^');
      str.append(power1);
    }
    if (power2 != 0)
    {
      str.append('*');
      str.append(unit2);
      if (power2 != 1)
      {
        str.append('^');
        str.append(power2);
      }
    }
    return str.toString();
  }
  
  public Unit sqrt()
  {
    if (((power1 & 0x1) == 0) && ((power2 & 0x1) == 0))
      return times(unit1, power1 >> 1, unit2, power2 >> 1);
    return super.sqrt();
  }
  

  static MulUnit lookup(Unit unit1, int power1, Unit unit2, int power2)
  {
    for (MulUnit u = products; u != null; u = next)
    {
      if ((unit1 == unit1) && (unit2 == unit2) && (power1 == power1) && (power2 == power2))
      {
        return u; }
    }
    return null;
  }
  
  public static MulUnit make(Unit unit1, int power1, Unit unit2, int power2)
  {
    MulUnit u = lookup(unit1, power1, unit2, power2);
    if (u != null)
      return u;
    return new MulUnit(unit1, power1, unit2, power2);
  }
  



  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(unit1);
    out.writeInt(power1);
    out.writeObject(unit2);
    out.writeInt(power2);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    unit1 = ((Unit)in.readObject());
    power1 = in.readInt();
    unit2 = ((Unit)in.readObject());
    power2 = in.readInt();
  }
  
  public Object readResolve() throws ObjectStreamException
  {
    MulUnit u = lookup(unit1, power1, unit2, power2);
    if (u != null)
      return u;
    return this;
  }
}
