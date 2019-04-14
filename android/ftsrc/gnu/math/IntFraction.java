package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;




public class IntFraction
  extends RatNum
  implements Externalizable
{
  IntNum num;
  IntNum den;
  
  IntFraction() {}
  
  public IntFraction(IntNum num, IntNum den)
  {
    this.num = num;
    this.den = den;
  }
  
  public final IntNum numerator() { return num; }
  public final IntNum denominator() { return den; }
  
  public final boolean isNegative() { return num.isNegative(); }
  
  public final int sign() { return num.sign(); }
  
  public final int compare(Object obj)
  {
    if ((obj instanceof RatNum))
      return RatNum.compare(this, (RatNum)obj);
    return ((RealNum)obj).compareReversed(this);
  }
  
  public int compareReversed(Numeric x)
  {
    return RatNum.compare((RatNum)x, this);
  }
  
  public Numeric add(Object y, int k)
  {
    if ((y instanceof RatNum))
      return RatNum.add(this, (RatNum)y, k);
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).addReversed(this, k);
  }
  
  public Numeric addReversed(Numeric x, int k)
  {
    if (!(x instanceof RatNum))
      throw new IllegalArgumentException();
    return RatNum.add((RatNum)x, this, k);
  }
  
  public Numeric mul(Object y)
  {
    if ((y instanceof RatNum))
      return RatNum.times(this, (RatNum)y);
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).mulReversed(this);
  }
  
  public Numeric mulReversed(Numeric x)
  {
    if (!(x instanceof RatNum))
      throw new IllegalArgumentException();
    return RatNum.times((RatNum)x, this);
  }
  
  public Numeric div(Object y)
  {
    if ((y instanceof RatNum))
      return RatNum.divide(this, (RatNum)y);
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).divReversed(this);
  }
  
  public Numeric divReversed(Numeric x)
  {
    if (!(x instanceof RatNum))
      throw new IllegalArgumentException();
    return RatNum.divide((RatNum)x, this);
  }
  

  public static IntFraction neg(IntFraction x)
  {
    return new IntFraction(IntNum.neg(x.numerator()), x.denominator());
  }
  
  public Numeric neg()
  {
    return neg(this);
  }
  
  public long longValue()
  {
    return toExactInt(4).longValue();
  }
  
  public double doubleValue()
  {
    boolean neg = num.isNegative();
    if (den.isZero()) {
      return num.isZero() ? NaN.0D : neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
    }
    
    IntNum n = num;
    if (neg)
      n = IntNum.neg(n);
    int num_len = n.intLength();
    int den_len = den.intLength();
    int exp = 0;
    if (num_len < den_len + 54)
    {
      exp = den_len + 54 - num_len;
      n = IntNum.shift(n, exp);
      exp = -exp;
    }
    


    IntNum quot = new IntNum();
    IntNum remainder = new IntNum();
    IntNum.divide(n, den, quot, remainder, 3);
    quot = quot.canonicalize();
    remainder = remainder.canonicalize();
    
    return quot.roundToDouble(exp, neg, !remainder.isZero());
  }
  
  public String toString(int radix)
  {
    return num.toString(radix) + '/' + den.toString(radix);
  }
  


  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(num);
    out.writeObject(den);
  }
  




  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    num = ((IntNum)in.readObject());
    den = ((IntNum)in.readObject());
  }
}
