package gnu.math;

import java.math.BigDecimal;


public abstract class RealNum
  extends Complex
  implements Comparable
{
  public RealNum() {}
  
  public final RealNum re() { return this; }
  public final RealNum im() { return IntNum.zero(); }
  
  public final RealNum angle() {
    return isNegative() ? DFloNum.valueOf(3.141592653589793D) : DFloNum.zero();
  }
  
  public final Quaternion vectorPart() { return IntNum.zero(); }
  public final Quaternion unitVector() { return IntNum.zero(); }
  
  public final Quaternion unitQuaternion() { switch (sign()) {
    case 1:  return IntNum.one();
    case 0:  return IntNum.zero();
    case -1:  return IntNum.minusOne(); }
    return this;
  }
  
  public final Quaternion conjugate() { return this; }
  
  public static boolean isReal(Object value) {
    return ((value instanceof Number)) && (((value instanceof RealNum)) || (!(value instanceof Numeric)));
  }
  

  public static RealNum asRealNumOrNull(Object value)
  {
    if ((value instanceof RealNum))
      return (RealNum)value;
    if (((value instanceof Float)) || ((value instanceof Double)))
      return new DFloNum(((Number)value).doubleValue());
    return RatNum.asRatNumOrNull(value);
  }
  
  public abstract boolean isNegative();
  
  public int classifyFinite()
  {
    double d = doubleValue();
    return Double.isInfinite(d) ? 0 : Double.isNaN(d) ? -1 : 1;
  }
  

  public abstract int sign();
  
  public RealNum max(RealNum x)
  {
    boolean exact = (isExact()) && (x.isExact());
    RealNum result = grt(x) ? this : x;
    if ((!exact) && (result.isExact()))
      result = new DFloNum(result.doubleValue());
    return result;
  }
  
  public RealNum min(RealNum x)
  {
    boolean exact = (isExact()) && (x.isExact());
    RealNum result = grt(x) ? x : this;
    if ((!exact) && (result.isExact()))
      result = new DFloNum(result.doubleValue());
    return result;
  }
  
  public static RealNum add(RealNum x, RealNum y, int k)
  {
    return (RealNum)x.add(y, k);
  }
  
  public static RealNum times(RealNum x, RealNum y)
  {
    return (RealNum)x.mul(y);
  }
  
  public static RealNum divide(RealNum x, RealNum y)
  {
    return (RealNum)x.div(y);
  }
  
  public abstract Numeric add(Object paramObject, int paramInt);
  
  public abstract Numeric mul(Object paramObject);
  
  public abstract Numeric div(Object paramObject);
  
  public Numeric abs() {
    return isNegative() ? neg() : this;
  }
  
  public RealNum rneg() { return (RealNum)neg(); }
  
  public boolean isZero()
  {
    return sign() == 0;
  }
  



  public RatNum toExact()
  {
    return DFloNum.toExact(doubleValue());
  }
  
  public RealNum toInexact()
  {
    if (isExact()) {
      return new DFloNum(doubleValue());
    }
    return this;
  }
  



  public static double toInt(double d, int rounding_mode)
  {
    switch (rounding_mode)
    {
    case 1: 
      return Math.floor(d);
    case 2: 
      return Math.ceil(d);
    case 3: 
      return d < 0.0D ? Math.ceil(d) : Math.floor(d);
    case 4: 
      return Math.rint(d);
    }
    return d;
  }
  




  public RealNum toInt(int rounding_mode)
  {
    return new DFloNum(toInt(doubleValue(), rounding_mode));
  }
  

  public IntNum toExactInt(int rounding_mode)
  {
    return toExactInt(doubleValue(), rounding_mode);
  }
  

  public static IntNum toExactInt(double value, int rounding_mode)
  {
    return toExactInt(toInt(value, rounding_mode));
  }
  

  public static IntNum toExactInt(double value)
  {
    if ((Double.isInfinite(value)) || (Double.isNaN(value)))
      throw new ArithmeticException("cannot convert " + value + " to exact integer");
    long bits = Double.doubleToLongBits(value);
    boolean neg = bits < 0L;
    int exp = (int)(bits >> 52) & 0x7FF;
    bits &= 0xFFFFFFFFFFFFF;
    if (exp == 0) {
      bits <<= 1;
    } else
      bits |= 0x10000000000000;
    if (exp <= 1075)
    {
      int rshift = 1075 - exp;
      if (rshift > 53)
        return IntNum.zero();
      bits >>= rshift;
      return IntNum.make(neg ? -bits : bits);
    }
    return IntNum.shift(IntNum.make(neg ? -bits : bits), exp - 1075);
  }
  
  public Complex exp()
  {
    return new DFloNum(Math.exp(doubleValue()));
  }
  
  public Complex log()
  {
    double x = doubleValue();
    if (x <= 0.0D)
      return DComplex.log(x, 0.0D);
    return new DFloNum(Math.log(x));
  }
  
  public final RealNum sin() {
    return new DFloNum(Math.sin(doubleValue()));
  }
  
  public final RealNum cos() { return new DFloNum(Math.cos(doubleValue())); }
  
  public final RealNum tan() {
    return new DFloNum(Math.tan(doubleValue()));
  }
  
  public final Complex sqrt()
  {
    double d = doubleValue();
    if (d >= 0.0D) {
      return new DFloNum(Math.sqrt(d));
    }
    return Complex.make(IntNum.zero(), new DFloNum(Math.sqrt(-d)));
  }
  

  public static IntNum toScaledInt(double f, int k)
  {
    return toScaledInt(DFloNum.toExact(f), k);
  }
  

  public static IntNum toScaledInt(RatNum r, int k)
  {
    if (k != 0)
    {
      IntNum power = IntNum.power(IntNum.ten(), k < 0 ? -k : k);
      IntNum num = r.numerator();
      IntNum den = r.denominator();
      if (k >= 0) {
        num = IntNum.times(num, power);
      } else
        den = IntNum.times(den, power);
      r = RatNum.make(num, den);
    }
    return r.toExactInt(4);
  }
  

  public IntNum toScaledInt(int k)
  {
    return toScaledInt(toExact(), k);
  }
  



















  public int compareTo(Object o)
  {
    return compare(o);
  }
  
  public BigDecimal asBigDecimal()
  {
    return new BigDecimal(doubleValue());
  }
  
  public static String toStringScientific(float d)
  {
    return toStringScientific(Float.toString(d));
  }
  
  public static String toStringScientific(double d)
  {
    return toStringScientific(Double.toString(d));
  }
  




  public static String toStringScientific(String dstr)
  {
    int indexE = dstr.indexOf('E');
    if (indexE >= 0)
      return dstr;
    int len = dstr.length();
    
    char ch = dstr.charAt(len - 1);
    if ((ch == 'y') || (ch == 'N'))
      return dstr;
    StringBuffer sbuf = new StringBuffer(len + 10);
    int exp = toStringScientific(dstr, sbuf);
    sbuf.append('E');
    sbuf.append(exp);
    return sbuf.toString();
  }
  
  public static int toStringScientific(String dstr, StringBuffer sbuf)
  {
    boolean neg = dstr.charAt(0) == '-';
    if (neg)
      sbuf.append('-');
    int pos = neg ? 1 : 0;
    
    int len = dstr.length();
    int exp; int exp; if (dstr.charAt(pos) == '0')
    {
      int start = pos;
      for (;;)
      {
        if (pos == len)
        {
          sbuf.append("0");
          int exp = 0;
          break;
        }
        char ch = dstr.charAt(pos++);
        if ((ch >= '0') && (ch <= '9') && ((ch != '0') || (pos == len)))
        {
          sbuf.append(ch);
          sbuf.append('.');
          int exp = ch == '0' ? 0 : start - pos + 2;
          if (pos == len) {
            sbuf.append('0'); break;
          }
          
          while (pos < len) {
            sbuf.append(dstr.charAt(pos++));
          }
          
        }
        
      }
    }
    else
    {
      int ndigits = len - (neg ? 2 : 1);
      int dot = dstr.indexOf('.');
      



      exp = ndigits - len + dot;
      sbuf.append(dstr.charAt(pos++));
      sbuf.append('.');
      while (pos < len)
      {
        char ch = dstr.charAt(pos++);
        if (ch != '.') {
          sbuf.append(ch);
        }
      }
    }
    pos = sbuf.length();
    int slen = -1;
    for (;;)
    {
      char ch = sbuf.charAt(--pos);
      if (ch == '0') {
        slen = pos;
      }
      else {
        if (ch != '.') break;
        slen = pos + 2; break;
      }
    }
    
    if (slen >= 0)
      sbuf.setLength(slen);
    return exp;
  }
  
  public static String toStringDecimal(String dstr)
  {
    int indexE = dstr.indexOf('E');
    if (indexE < 0)
      return dstr;
    int len = dstr.length();
    
    char ch = dstr.charAt(len - 1);
    if ((ch == 'y') || (ch == 'N'))
      return dstr;
    StringBuffer sbuf = new StringBuffer(len + 10);
    boolean neg = dstr.charAt(0) == '-';
    if (dstr.charAt(indexE + 1) != '-')
    {
      throw new UnsupportedOperationException("not implemented: toStringDecimal given non-negative exponent: " + dstr);
    }
    

    int pos = indexE + 2;
    int exp = 0;
    while (pos < len)
      exp = 10 * exp + (dstr.charAt(pos++) - '0');
    if (neg)
      sbuf.append('-');
    sbuf.append("0.");
    for (;;) { exp--; if (exp <= 0) break; sbuf.append('0'); }
    for (pos = 0; (ch = dstr.charAt(pos++)) != 'E';)
    {
      if ((((ch != '-' ? 1 : 0) & (ch != '.' ? 1 : 0)) != 0) && ((ch != '0') || (pos < indexE)))
      {
        sbuf.append(ch); }
    }
    return sbuf.toString();
  }
}
