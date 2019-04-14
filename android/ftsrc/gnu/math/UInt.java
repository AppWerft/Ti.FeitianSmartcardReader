package gnu.math;

public class UInt extends UnsignedPrim implements Comparable<UInt> { int ival;
  
  public int numBits() { return 32; }
  
  public UInt(int ival) { this.ival = ival; }
  
  public static UInt valueOf(int ival) { return new UInt(ival); }
  
  public int intValue() { return ival; }
  public long longValue() { return ival & 0xFFFFFFFF; }
  
  public IntNum toIntNum() {
    return IntNum.valueOf(longValue());
  }
  
  public static String toString(int ival) {
    if (ival >= 0) {
      return Integer.toString(ival);
    }
    return Long.toString(0xFFFFFFFF & ival);
  }
  
  public boolean equals(Object obj) {
    return ((obj instanceof UInt)) && (ival == ival);
  }
  



  public int compareTo(UInt other)
  {
    int x = ival + Integer.MIN_VALUE;
    int y = ival + Integer.MIN_VALUE;
    return x == y ? 0 : x < y ? -1 : 1;
  }
  
  public String toString() {
    return toString(ival);
  }
}
