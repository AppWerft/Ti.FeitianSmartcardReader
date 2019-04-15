package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;







public class DComplex
  extends Complex
  implements Externalizable
{
  double real;
  double imag;
  
  public DComplex() {}
  
  public DComplex(double real, double imag)
  {
    this.real = real;
    this.imag = imag;
  }
  
  public RealNum re() { return new DFloNum(real); }
  public double doubleValue() { return real; }
  public RealNum im() { return new DFloNum(imag); }
  public double doubleImagValue() { return imag; }
  
  public boolean isExact()
  {
    return false;
  }
  
  public Complex toExact()
  {
    return new CComplex(DFloNum.toExact(real), DFloNum.toExact(imag));
  }
  
  public boolean equals(Object obj)
  {
    if ((obj == null) || (!(obj instanceof Complex)))
      return false;
    Complex y = (Complex)obj;
    return (y.unit() == Unit.Empty) && (Double.doubleToLongBits(real) == Double.doubleToLongBits(y.reValue())) && (Double.doubleToLongBits(imag) == Double.doubleToLongBits(y.imValue()));
  }
  




  public String toString()
  {
    String prefix = "";
    
    String reString = DFloNum.toString(real);
    
    if (Double.doubleToLongBits(imag) == 0L) {
      return reString;
    }
    String imString = DFloNum.toString(imag);
    StringBuilder sbuf = new StringBuilder();
    if (!reString.equals("0.0"))
      sbuf.append(reString);
    char ch0 = imString.charAt(0);
    if ((ch0 != '-') && (ch0 != '+'))
      sbuf.append('+');
    sbuf.append(imString);
    sbuf.append('i');
    return sbuf.toString();
  }
  
  public String toString(int radix)
  {
    if (radix == 10)
      return toString();
    return "#d" + toString();
  }
  
  public final Numeric neg()
  {
    return new DComplex(-real, -imag);
  }
  
  public Numeric add(Object y, int k) {
    if ((y instanceof Complex))
    {
      Complex yc = (Complex)y;
      if (yc.dimensions() != Dimensions.Empty)
        throw new ArithmeticException("units mis-match");
      return new DComplex(real + k * yc.reValue(), imag + k * yc.imValue());
    }
    
    return ((Numeric)y).addReversed(this, k);
  }
  
  public Numeric mul(Object y)
  {
    if ((y instanceof Complex))
    {
      Complex yc = (Complex)y;
      if (yc.unit() == Unit.Empty)
      {
        double y_re = yc.reValue();
        double y_im = yc.imValue();
        return new DComplex(real * y_re - imag * y_im, real * y_im + imag * y_re);
      }
      
      return Complex.times(this, yc);
    }
    return ((Numeric)y).mulReversed(this);
  }
  
  public Numeric div(Object y)
  {
    if ((y instanceof Complex))
    {
      Complex yc = (Complex)y;
      return div(real, imag, yc.doubleValue(), yc.doubleImagValue());
    }
    
    return ((Numeric)y).divReversed(this);
  }
  

  public static Complex power(double x_re, double x_im, double y_re, double y_im)
  {
    if ((x_re == 0.0D) && (x_im == 0.0D)) {
      if (y_re > 0.0D)
        return DFloNum.zero();
      if ((y_re == 0.0D) && (y_im == 0.0D)) {
        return DFloNum.valueOf(1.0D);
      }
    }
    
    double h = Math.hypot(x_re, x_im);
    


    double logr = Math.log(h);
    double t = Math.atan2(x_im, x_re);
    double r = Math.exp(logr * y_re - y_im * t);
    t = y_im * logr + y_re * t;
    return Complex.polar(r, t);
  }
  


  public static Complex log(double x_re, double x_im)
  {
    double h = Math.hypot(x_re, x_im);
    


    return make(Math.log(h), Math.atan2(x_im, x_re));
  }
  



























  public static DComplex div(double x_re, double x_im, double y_re, double y_im)
  {
    double ar = Math.abs(y_re);
    double ai = Math.abs(y_im);
    double ni;
    double d;
    double nr; double ni; if (ar <= ai)
    {
      double t = y_re / y_im;
      double d = y_im * (1.0D + t * t);
      double nr = x_re * t + x_im;
      ni = x_im * t - x_re;
    }
    else
    {
      double t = y_im / y_re;
      d = y_re * (1.0D + t * t);
      nr = x_re + x_im * t;
      ni = x_im - x_re * t;
    }
    return new DComplex(nr / d, ni / d);
  }
  

  public static Complex sqrt(double x_re, double x_im)
  {
    double r = Math.hypot(x_re, x_im);
    
    double nr;
    double ni;
    double nr;
    if (r == 0.0D) { double ni;
      nr = ni = r; } else { double ni;
      if (x_re > 0.0D)
      {
        double nr = Math.sqrt(0.5D * (r + x_re));
        ni = x_im / nr / 2.0D;
      }
      else
      {
        ni = Math.sqrt(0.5D * (r - x_re));
        if (x_im < 0.0D)
          ni = -ni;
        nr = x_im / ni / 2.0D;
      } }
    return new DComplex(nr, ni);
  }
  
  public static Complex sin(double x_re, double x_im) {
    if (x_im == 0.0D)
      return new DFloNum(Math.sin(x_re));
    return Complex.make(Math.sin(x_re) * Math.cosh(x_im), Math.cos(x_re) * Math.sinh(x_im));
  }
  
  public static Complex cos(double x_re, double x_im)
  {
    if (x_im == 0.0D)
      return new DFloNum(Math.cos(x_re));
    return Complex.make(Math.cos(x_re) * Math.cosh(x_im), -Math.sin(x_re) * Math.sinh(x_im));
  }
  
  public static Complex tan(double x_re, double x_im)
  {
    if (x_im == 0.0D) {
      return new DFloNum(Math.tan(x_re));
    }
    double sin_re = Math.sin(x_re);
    double cos_re = Math.cos(x_re);
    double sinh_im = Math.sinh(x_im);
    double cosh_im = Math.cosh(x_im);
    
    return div(sin_re * cosh_im, cos_re * sinh_im, cos_re * cosh_im, -sin_re * sinh_im);
  }
  
  public static Complex unitQuaternion(double x_re, double x_im)
  {
    double r = Math.hypot(x_re, x_im);
    if (r == 0.0D) return IntNum.zero();
    return Complex.make(x_re / r, x_im / r);
  }
  









































































































































  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeDouble(real);
    out.writeDouble(imag);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    real = in.readDouble();
    imag = in.readDouble();
  }
}
