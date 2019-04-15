package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;





public class CComplex
  extends Complex
  implements Externalizable
{
  RealNum real;
  RealNum imag;
  
  public CComplex() {}
  
  public CComplex(RealNum real, RealNum imag)
  {
    this.real = real;
    this.imag = imag;
  }
  
  public RealNum re() { return real; }
  public RealNum im() { return imag; }
  


  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(real);
    out.writeObject(imag);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    real = ((RealNum)in.readObject());
    imag = ((RealNum)in.readObject());
  }
}
