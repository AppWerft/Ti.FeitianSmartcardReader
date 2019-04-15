package gnu.math;

public class ULong extends UnsignedPrim implements Comparable<ULong> { long ival;
  
  public int numBits() { return 64; }
  
  public ULong(long ival) { this.ival = ival; }
  
  public static ULong valueOf(long ival) { return new ULong(ival); }
  
  public int intValue() { return (int)ival; }
  public long longValue() { return ival; }
  
  public IntNum toIntNum() { return IntNum.valueOfUnsigned(ival); }
  
  public boolean equals(Object obj) {
    return ((obj instanceof ULong)) && (ival == ival);
  }
  



  public int compareTo(ULong other)
  {
    long x = ival + Long.MIN_VALUE;
    long y = ival + Long.MIN_VALUE;
    return x == y ? 0 : x < y ? -1 : 1;
  }
  
  public static String toString(long ival)
  {
    if (ival >= 0L) {
      return Long.toString(ival);
    }
    return IntNum.valueOfUnsigned(ival).toString(); }
  
  public String toString() { return toString(ival); }
}
