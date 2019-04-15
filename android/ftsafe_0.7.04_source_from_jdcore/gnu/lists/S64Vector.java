package gnu.lists;






public class S64Vector
  extends LongVector<Long>
{
  public S64Vector()
  {
    data = empty;
  }
  
  public S64Vector(int size, long value) {
    long[] array = new long[size];
    data = array;
    if (value != 0L)
      for (;;) { size--; if (size < 0) break;
        array[size] = value;
      }
  }
  
  public S64Vector(int size) {
    this(new long[size]);
  }
  
  public S64Vector(long[] data)
  {
    this.data = data;
  }
  

  public S64Vector(long[] values, int offset, int length)
  {
    this(length);
    System.arraycopy(values, offset, data, 0, length);
  }
  
  public final Long get(int index) {
    return Long.valueOf(data[effectiveIndex(index)]);
  }
  
  public final Long getRaw(int index) {
    return Long.valueOf(data[index]);
  }
  
  public final void setRaw(int index, Long value)
  {
    data[index] = value.longValue();
  }
  
  protected S64Vector newInstance(int newLength)
  {
    return new S64Vector(newLength < 0 ? data : new long[newLength]);
  }
  
  public int getElementKind() { return 24; }
  
  public String getTag() { return "s64"; }
  
  public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
    if (out.ignoring())
      return;
    int i = nextIndex(iposStart);
    int end = nextIndex(iposEnd);
    for (; i < end; i++)
      out.writeLong(getLong(i));
  }
  
  public int compareTo(Object obj) {
    S64Vector vec2 = (S64Vector)obj;
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
