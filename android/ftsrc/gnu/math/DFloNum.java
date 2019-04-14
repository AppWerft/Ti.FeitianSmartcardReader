package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DFloNum
  extends RealNum implements Externalizable
{
  double value;
  
  public DFloNum() {}
  
  public DFloNum(double value)
  {
    this.value = value;
  }
  
  public DFloNum(String s) throws NumberFormatException
  {
    Double d = Double.valueOf(s);
    value = d.doubleValue();
    












    if ((value == 0.0D) && (s.charAt(0) == '-')) {
      value = -0.0D;
    }
  }
  
  @Deprecated
  public static DFloNum make(double value) {
    return new DFloNum(value);
  }
  
  public static DFloNum valueOf(double value) {
    return new DFloNum(value);
  }
  
  private static final DFloNum zero = new DFloNum(0.0D);
  public static DFloNum zero() { return zero; }
  
  public static DFloNum asDFloNumOrNull(Object value)
  {
    if ((value instanceof DFloNum))
      return (DFloNum)value;
    if (RealNum.isReal(value))
      return new DFloNum(((Number)value).doubleValue());
    return null;
  }
  
  public final double doubleValue()
  {
    return value;
  }
  
  public long longValue()
  {
    return value;
  }
  
  public int hashCode() {
    long v = Double.doubleToLongBits(value);
    return (int)(v ^ v >>> 32);
  }
  

  public boolean equals(Object obj)
  {
    return (obj != null) && ((obj instanceof DFloNum)) && (Double.doubleToLongBits(value) == Double.doubleToLongBits(value));
  }
  



  public Numeric add(Object y, int k)
  {
    if ((y instanceof RealNum))
      return new DFloNum(value + k * ((RealNum)y).doubleValue());
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).addReversed(this, k);
  }
  
  public Numeric addReversed(Numeric x, int k)
  {
    if ((x instanceof RealNum))
      return new DFloNum(((RealNum)x).doubleValue() + k * value);
    throw new IllegalArgumentException();
  }
  
  public Numeric mul(Object y)
  {
    if ((y instanceof RealNum))
      return new DFloNum(value * ((RealNum)y).doubleValue());
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).mulReversed(this);
  }
  
  public Numeric mulReversed(Numeric x)
  {
    if ((x instanceof RealNum))
      return new DFloNum(((RealNum)x).doubleValue() * value);
    throw new IllegalArgumentException();
  }
  
  private static final DFloNum one = new DFloNum(1.0D);
  public static final DFloNum one() { return one; }
  
  public Numeric div(Object y)
  {
    if ((y instanceof RealNum))
      return new DFloNum(value / ((RealNum)y).doubleValue());
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).divReversed(this);
  }
  
  public Numeric divReversed(Numeric x)
  {
    if ((x instanceof RealNum))
      return new DFloNum(((RealNum)x).doubleValue() / value);
    throw new IllegalArgumentException();
  }
  
  public Numeric power(IntNum y)
  {
    return new DFloNum(Math.pow(doubleValue(), y.doubleValue()));
  }
  
  public boolean isNegative()
  {
    return value < 0.0D;
  }
  
  public Numeric neg()
  {
    return new DFloNum(-value);
  }
  
  public int sign()
  {
    return value == 0.0D ? 0 : value < 0.0D ? -1 : value > 0.0D ? 1 : -2;
  }
  
  public static int compare(double x, double y)
  {
    return x == y ? 0 : x < y ? -1 : x > y ? 1 : -2;
  }
  

  public static int compare(IntNum x_num, IntNum x_den, double y)
  {
    if (Double.isNaN(y))
      return -2;
    if (Double.isInfinite(y))
    {
      int result = y >= 0.0D ? -1 : 1;
      if (!x_den.isZero())
        return result;
      if (x_num.isZero())
        return -2;
      result >>= 1;
      return x_num.isNegative() ? result : result ^ 0xFFFFFFFF;
    }
    

    long bits = Double.doubleToLongBits(y);
    boolean neg = bits < 0L;
    int exp = (int)(bits >> 52) & 0x7FF;
    bits &= 0xFFFFFFFFFFFFF;
    if (exp == 0) {
      bits <<= 1;
    } else
      bits |= 0x10000000000000;
    IntNum y_num = IntNum.make(neg ? -bits : bits);
    if (exp >= 1075) {
      y_num = IntNum.shift(y_num, exp - 1075);
    } else
      x_num = IntNum.shift(x_num, 1075 - exp);
    return IntNum.compare(x_num, IntNum.times(y_num, x_den));
  }
  

  public int compare(Object obj)
  {
    if ((obj instanceof RatNum))
    {
      RatNum y_rat = (RatNum)obj;
      int i = compare(y_rat.numerator(), y_rat.denominator(), value);
      return i < -1 ? i : -i;
    }
    if ((obj instanceof RealNum)) {
      return compare(value, ((RealNum)obj).doubleValue());
    }
    return ((Numeric)obj).compareReversed(this);
  }
  
  public int compareReversed(Numeric x)
  {
    if ((x instanceof RatNum))
    {
      RatNum x_rat = (RatNum)x;
      return compare(x_rat.numerator(), x_rat.denominator(), value);
    }
    return compare(((RealNum)x).doubleValue(), value);
  }
  
  public boolean isExact()
  {
    return false;
  }
  
  public boolean isZero()
  {
    return value == 0.0D;
  }
  

  public static RatNum toExact(double value)
  {
    if (Double.isInfinite(value))
      return RatNum.infinity(value >= 0.0D ? 1 : -1);
    if (Double.isNaN(value))
      throw new ArithmeticException("cannot convert NaN to exact rational");
    long bits = Double.doubleToLongBits(value);
    boolean neg = bits < 0L;
    int exp = (int)(bits >> 52) & 0x7FF;
    bits &= 0xFFFFFFFFFFFFF;
    if (exp == 0) {
      bits <<= 1;
    } else
      bits |= 0x10000000000000;
    IntNum mant = IntNum.make(neg ? -bits : bits);
    if (exp >= 1075) {
      return IntNum.shift(mant, exp - 1075);
    }
    return RatNum.make(mant, IntNum.shift(IntNum.one(), 1075 - exp));
  }
  
  public String toString()
  {
    return toString(value);
  }
  
  public static String toString(double value)
  {
    return Double.isNaN(value) ? "+nan.0" : value == Double.NEGATIVE_INFINITY ? "-inf.0" : value == Double.POSITIVE_INFINITY ? "+inf.0" : Double.toString(value);
  }
  



  public String toString(int radix)
  {
    if (radix == 10)
      return toString();
    return "#d" + toString();
  }
  


  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeDouble(value);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    value = in.readDouble();
  }
}
