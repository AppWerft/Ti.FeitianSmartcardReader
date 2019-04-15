package gnu.math;

public abstract class UnsignedPrim extends Number { public UnsignedPrim() {}
  public long longValue() { return intValue(); }
  public float floatValue() { return (float)longValue(); }
  public double doubleValue() { return longValue(); }
  

  public int hashCode() { return intValue(); }
  
  public IntNum toIntNum() { return IntNum.valueOf(intValue()); }
  
  public abstract int numBits();
}
