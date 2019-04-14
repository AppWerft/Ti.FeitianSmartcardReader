package gnu.ecmascript;

public class Convert {
  public Convert() {}
  
  public static double toNumber(Object x) {
    if ((x instanceof Number)) {
      return ((Number)x).doubleValue();
    }
    
    if ((x instanceof Boolean))
      return ((Boolean)x).booleanValue() ? 1.0D : 0.0D;
    if ((x instanceof String))
    {
      try
      {

        return Double.valueOf((String)x).doubleValue();
      }
      catch (NumberFormatException ex)
      {
        return NaN.0D;
      }
    }
    
    return NaN.0D;
  }
  
  public static double toInteger(double x)
  {
    if (Double.isNaN(x))
      return 0.0D;
    return x < 0.0D ? Math.ceil(x) : Math.floor(x);
  }
  
  public static double toInteger(Object x)
  {
    return toInteger(toNumber(x));
  }
  
  public int toInt32(double x)
  {
    if ((Double.isNaN(x)) || (Double.isInfinite(x))) {
      return 0;
    }
    return (int)x;
  }
  
  public int toInt32(Object x)
  {
    return toInt32(toNumber(x));
  }
}
