package gnu.math;




public abstract class Quantity
  extends Numeric
{
  public Quantity() {}
  


  public Unit unit() { return Unit.Empty; }
  public Dimensions dimensions() { return unit().dimensions(); }
  

  public abstract Quaternion number();
  

  public RealNum re()
  {
    return number().re();
  }
  

  public RealNum im()
  {
    return number().im();
  }
  

  public RealNum jm()
  {
    return number().jm();
  }
  

  public RealNum km()
  {
    return number().km();
  }
  

  public final double reValue()
  {
    return doubleValue();
  }
  

  public final double imValue()
  {
    return doubleImagValue();
  }
  

  public final double jmValue()
  {
    return doubleJmagValue();
  }
  

  public final double kmValue()
  {
    return doubleKmagValue();
  }
  

  public double doubleValue()
  {
    return unit().doubleValue() * re().doubleValue();
  }
  
  public double doubleImagValue()
  {
    return unit().doubleValue() * im().doubleValue();
  }
  

  public double doubleJmagValue()
  {
    return unit().doubleValue() * jm().doubleValue();
  }
  


  public double doubleKmagValue()
  {
    return unit().doubleValue() * km().doubleValue();
  }
  
  public static Quantity make(Quaternion x, Unit u) {
    if (u == Unit.Empty)
      return x;
    if ((x instanceof DFloNum))
      return new DQuantity(x.doubleValue(), u);
    return new CQuantity(x, u);
  }
  
  public static Quantity make(RealNum re, RealNum im, RealNum jm, RealNum km, Unit unit)
  {
    if (unit == Unit.Empty)
      return Quaternion.make(re, im, jm, km);
    if ((im.isZero()) && (jm.isZero()) && (km.isZero()) && ((!re.isExact()) || (!im.isExact()) || (!jm.isExact()) || (!km.isExact())))
    {

      return new DQuantity(re.doubleValue(), unit); }
    return new CQuantity(re, im, jm, km, unit);
  }
  
  public static Quantity make(double re, double im, double jm, double km, Unit unit)
  {
    if (unit == Unit.Empty)
      return Quaternion.make(re, im, jm, km);
    if ((im == 0.0D) && (jm == 0.0D) && (km == 0.0D))
      return new DQuantity(re, unit);
    return new CQuantity(new DFloNum(re), new DFloNum(im), new DFloNum(jm), new DFloNum(km), unit);
  }
  






















  public Numeric neg() { return make((Quaternion)number().neg(), unit()); }
  public Numeric abs() { return make((Quaternion)number().abs(), unit()); }
  
  public static int compare(Quantity x, Quantity y)
  {
    if (x.unit() == y.unit())
      return Quaternion.compare(x.number(), y.number());
    if ((x.dimensions() != y.dimensions()) || (x.imValue() != y.imValue()) || (x.jmValue() != y.jmValue()) || (x.kmValue() != y.kmValue()))
    {
      return -3; }
    return DFloNum.compare(x.reValue(), y.reValue());
  }
  
  public int compare(Object obj)
  {
    if (!(obj instanceof Quantity))
      return ((Numeric)obj).compareReversed(this);
    return compare(this, (Quantity)obj);
  }
  
  public int compareReversed(Numeric x)
  {
    if ((x instanceof Quantity))
      return compare((Quantity)x, this);
    throw new IllegalArgumentException();
  }
  
  public static Quantity add(Quantity x, Quantity y, int k)
  {
    if (x.unit() == y.unit())
      return make(Quaternion.add(x.number(), y.number(), k), x.unit());
    if (x.dimensions() != y.dimensions()) {
      throw new ArithmeticException("units mis-match");
    }
    
    double x_factor = x.unit().doubleValue();
    double re = (x.reValue() + k * y.reValue()) / x_factor;
    double im = (x.imValue() + k * y.imValue()) / x_factor;
    double jm = (x.jmValue() + k * y.jmValue()) / x_factor;
    double km = (x.kmValue() + k * y.kmValue()) / x_factor;
    return make(re, im, jm, km, x.unit());
  }
  

  public Numeric add(Object y, int k)
  {
    if ((y instanceof Quantity))
      return add(this, (Quantity)y, k);
    return ((Numeric)y).addReversed(this, k);
  }
  
  public Numeric addReversed(Numeric x, int k)
  {
    if ((x instanceof Quantity))
      return add((Quantity)x, this, k);
    throw new IllegalArgumentException();
  }
  
  public static Quantity times(Quantity x, Quantity y)
  {
    Unit unit = Unit.times(x.unit(), y.unit());
    
    Numeric num = x.number().mul(y.number());
    return make((Quaternion)num, unit);
  }
  
  public Numeric mul(Object y)
  {
    if ((y instanceof Quantity))
      return times(this, (Quantity)y);
    return ((Numeric)y).mulReversed(this);
  }
  
  public Numeric mulReversed(Numeric x)
  {
    if ((x instanceof Quantity))
      return times((Quantity)x, this);
    throw new IllegalArgumentException();
  }
  
  public static Quantity divide(Quantity x, Quantity y)
  {
    Unit unit = Unit.divide(x.unit(), y.unit());
    Numeric num = x.number().div(y.number());
    return make((Quaternion)num, unit);
  }
  
  public Numeric div(Object y)
  {
    if ((y instanceof Quantity))
      return divide(this, (Quantity)y);
    return ((Numeric)y).divReversed(this);
  }
  
  public Numeric divReversed(Numeric x)
  {
    if ((x instanceof Quantity))
      return divide((Quantity)x, this);
    throw new IllegalArgumentException();
  }
  
  public String toString(int radix)
  {
    String str = number().toString(radix);
    if (unit() == Unit.Empty)
      return str;
    return str + unit().toString();
  }
}
