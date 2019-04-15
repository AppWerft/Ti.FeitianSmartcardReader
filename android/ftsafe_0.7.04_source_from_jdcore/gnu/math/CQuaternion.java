package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;





public class CQuaternion
  extends Quaternion
  implements Externalizable
{
  RealNum real;
  RealNum imag;
  RealNum jmag;
  RealNum kmag;
  
  public CQuaternion() {}
  
  public CQuaternion(RealNum real, RealNum imag, RealNum jmag, RealNum kmag)
  {
    this.real = real;
    this.imag = imag;
    this.jmag = jmag;
    this.kmag = kmag;
  }
  
  public RealNum re() { return real; }
  public RealNum im() { return imag; }
  public RealNum jm() { return jmag; }
  public RealNum km() { return kmag; }
  

  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(real);
    out.writeObject(imag);
    out.writeObject(jmag);
    out.writeObject(kmag);
  }
  
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
  {
    real = ((RealNum)in.readObject());
    imag = ((RealNum)in.readObject());
    jmag = ((RealNum)in.readObject());
    kmag = ((RealNum)in.readObject());
  }
}
