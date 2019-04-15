package gnu.lists;

import gnu.math.ULong;





public class U64Vector
  extends LongVector<ULong>
{
  public U64Vector()
  {
    data = empty;
  }
  
  public U64Vector(int size, long value) {
    long[] array = new long[size];
    data = array;
    if (value != 0L)
      for (;;) { size--; if (size < 0) break;
        array[size] = value;
      }
  }
  
  public U64Vector(int size) {
    this(new long[size]);
  }
  
  public U64Vector(long[] data)
  {
    this.data = data;
  }
  

  public U64Vector(long[] values, int offset, int length)
  {
    this(length);
    System.arraycopy(values, offset, data, 0, length);
  }
  
  public final ULong get(int index) {
    return ULong.valueOf(data[effectiveIndex(index)]);
  }
  
  public final ULong getRaw(int index) {
    return ULong.valueOf(data[index]);
  }
  
  public final void setRaw(int index, ULong value)
  {
    data[index] = value.longValue();
  }
  
  protected U64Vector newInstance(int newLength)
  {
    return new U64Vector(newLength < 0 ? data : new long[newLength]);
  }
  
  public int getElementKind() { return 23; }
  
  public String getTag() { return "u64"; }
  
  public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
    if (out.ignoring())
      return;
    int i = nextIndex(iposStart);
    int end = nextIndex(iposEnd);
    for (; i < end; i++)
      Sequences.writeULong(getLong(i), out);
  }
  
  public int compareTo(Object obj) {
    U64Vector vec2 = (U64Vector)obj;
    long[] arr1 = data;
    long[] arr2 = data;
    int n1 = size();
    int n2 = vec2.size();
    int n = n1 > n2 ? n2 : n1;
    for (int i = 0; i < n; i++) {
      long v1 = arr1[effectiveIndex(i)];
      long v2 = arr2[effectiveIndex(i)];
      if (v1 != v2)
        return v1 > v2 ? 1 : -1;
    }
    return n1 - n2;
  }
}
