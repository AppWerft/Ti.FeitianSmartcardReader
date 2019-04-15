package gnu.math;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CQuantity extends Quantity implements java.io.Externalizable
{
  Quaternion num;
  Unit unt;
  
  public CQuantity(Quaternion num, Unit unit)
  {
    this.num = num;
    unt = unit;
  }
  
  public CQuantity(RealNum real, RealNum imag, Unit unit) {
    num = new CComplex(real, imag);
    unt = unit;
  }
  
  public CQuantity(RealNum real, RealNum imag, RealNum jmag, RealNum kmag, Unit unit)
  {
    num = new CQuaternion(real, imag, jmag, kmag);
    unt = unit;
  }
  
  public Quaternion number() { return num; }
  public Unit unit() { return unt; }
  
  public boolean isExact() { return num.isExact(); }
  
  public boolean isZero() { return num.isZero(); }
  



  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(num);
    out.writeObject(unt);
  }
  
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
  {
    num = ((Quaternion)in.readObject());
    unt = ((Unit)in.readObject());
  }
}
