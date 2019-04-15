package gnu.lists;




public abstract class LongVector<E>
  extends PrimIntegerVector<E>
{
  long[] data;
  


  protected static long[] empty = new long[0];
  
  public LongVector() {}
  
  public int getBufferLength() { return data.length; }
  
  public void copyBuffer(int length)
  {
    int oldLength = data.length;
    if (length == -1)
      length = oldLength;
    if (oldLength != length) {
      long[] tmp = new long[length];
      System.arraycopy(data, 0, tmp, 0, oldLength < length ? oldLength : length);
      
      data = tmp;
    }
  }
  
  public long[] getBuffer() { return data; }
  
  protected void setBuffer(Object buffer) { data = ((long[])buffer); }
  
  public final long getLong(int index) {
    return data[effectiveIndex(index)];
  }
  
  public final long getLongRaw(int index) {
    return data[index];
  }
  
  public final int getIntRaw(int index) {
    return (int)data[index];
  }
  
  public final void setLong(int index, long value) {
    checkCanWrite();
    data[effectiveIndex(index)] = value;
  }
  
  public final void setLongRaw(int index, long value) {
    data[index] = value;
  }
  
  public void add(long v) {
    int sz = size();
    addSpace(sz, 1);
    setLong(sz, v);
  }
  
  protected void clearBuffer(int start, int count) {
    long[] d = data;
    for (;;) { count--; if (count < 0) break;
      d[(start++)] = 0L;
    }
  }
}
