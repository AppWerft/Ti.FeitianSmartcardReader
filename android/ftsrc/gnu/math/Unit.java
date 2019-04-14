package gnu.math;




public abstract class Unit
  extends Quantity
{
  Dimensions dims;
  


  double factor;
  

  MulUnit products;
  

  Unit base;
  

  static NamedUnit[] table = new NamedUnit[100];
  
  public final Dimensions dimensions() { return dims; }
  
  public final double doubleValue() { return factor; }
  
  public int hashCode() { return dims.hashCode(); }
  
  public String getName() { return null; }
  

  static Unit times(Unit unit1, int power1, Unit unit2, int power2)
  {
    if (unit1 == unit2)
    {
      power1 += power2;
      unit2 = Empty;
      power2 = 0;
    }
    if ((power1 == 0) || (unit1 == Empty))
    {
      unit1 = unit2;
      power1 = power2;
      unit2 = Empty;
      power2 = 0;
    }
    if ((power2 == 0) || (unit2 == Empty))
    {
      if (power1 == 1)
        return unit1;
      if (power1 == 0)
        return Empty;
    }
    if ((unit1 instanceof MulUnit))
    {
      MulUnit munit1 = (MulUnit)unit1;
      if (unit1 == unit2) {
        return times(unit2, power1 * power1 + power2, unit2, power2 * power1);
      }
      if (unit2 == unit2) {
        return times(unit1, power1 * power1, unit2, power2 * power1 + power2);
      }
      if ((unit2 instanceof MulUnit))
      {
        MulUnit munit2 = (MulUnit)unit2;
        if ((unit1 == unit1) && (unit2 == unit2)) {
          return times(unit1, power1 * power1 + power1 * power2, unit2, power2 * power1 + power2 * power2);
        }
        

        if ((unit1 == unit2) && (unit2 == unit1)) {
          return times(unit1, power1 * power1 + power2 * power2, unit2, power2 * power1 + power1 * power2);
        }
      }
    }
    

    if ((unit2 instanceof MulUnit))
    {
      MulUnit munit2 = (MulUnit)unit2;
      if (unit1 == unit1) {
        return times(unit1, power1 + power1 * power2, unit2, power2 * power2);
      }
      if (unit2 == unit1) {
        return times(unit1, power1 * power2, unit1, power1 + power2 * power2);
      }
    }
    
    return MulUnit.make(unit1, power1, unit2, power2);
  }
  
  public static Unit times(Unit unit1, Unit unit2)
  {
    return times(unit1, 1, unit2, 1);
  }
  
  public static Unit divide(Unit unit1, Unit unit2)
  {
    return times(unit1, 1, unit2, -1);
  }
  
  public static Unit pow(Unit unit, int power)
  {
    return times(unit, power, Empty, 0);
  }
  
  Unit()
  {
    factor = 1.0D;
  }
  
  public static NamedUnit make(String name, Quantity value)
  {
    return NamedUnit.make(name, value);
  }
  
  public static Unit define(String name, DQuantity value)
  {
    return new NamedUnit(name, value);
  }
  
  public static Unit define(String name, double factor, Unit base)
  {
    return new NamedUnit(name, factor, base);
  }
  
  public Complex number() { return DFloNum.one(); }
  public boolean isExact() { return false; }
  public final boolean isZero() { return false; }
  
  public Numeric power(IntNum y)
  {
    if (words != null)
      throw new ArithmeticException("Unit raised to bignum power");
    return pow(this, ival);
  }
  
  public Unit sqrt()
  {
    if (this == Empty)
      return this;
    throw new RuntimeException("unimplemented Unit.sqrt");
  }
  
  public static BaseUnit Empty = new BaseUnit();
  static { Emptybases[0] = Empty; }
  
  public static NamedUnit lookup(String name)
  {
    return NamedUnit.lookup(name);
  }
  
  public String toString(double val)
  {
    String str = Double.toString(val);
    if (this == Empty) {
      return str;
    }
    return str + toString();
  }
  
  public String toString(RealNum val)
  {
    return toString(val.doubleValue());
  }
  












  public String toString()
  {
    String name = getName();
    if (name != null)
      return name;
    if (this == Empty) {
      return "unit";
    }
    return Double.toString(factor) + "<unnamed unit>";
  }
  
  public Unit unit()
  {
    return this;
  }
  







  public static double NON_COMBINABLE = 0.0D;
  
  public static final BaseUnit meter = new BaseUnit("m", "Length");
  public static final BaseUnit duration = new BaseUnit("duration", "Time");
  public static final BaseUnit gram = new BaseUnit("g", "Mass");
  public static final Unit cm = define("cm", 0.01D, meter);
  public static final Unit mm = define("mm", 0.1D, cm);
  public static final Unit in = define("in", 0.0254D, meter);
  public static final Unit pt = define("pt", 3.527778E-4D, meter);
  public static final Unit pica = define("pica", 0.004233333D, meter);
  public static final Unit radian = define("rad", 1.0D, Empty);
  public static final Unit degree = define("deg", 0.017453292519943295D, Empty);
  public static final Unit gradian = define("grad", 0.015707963267948967D, Empty);
  
  public static final NamedUnit date = new NamedUnit("date", NON_COMBINABLE, duration);
  
  public static final NamedUnit second = new NamedUnit("s", NON_COMBINABLE, duration);
  
  public static final NamedUnit month = new NamedUnit("month", NON_COMBINABLE, duration);
  
  public static final Unit minute = define("min", 60.0D, second);
  public static final Unit hour = define("hour", 60.0D, minute);
}
