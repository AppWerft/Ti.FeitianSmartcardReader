package gnu.lists;




public abstract class IntVector<E>
  extends PrimIntegerVector<E>
{
  int[] data;
  


  protected static int[] empty = new int[0];
  
  public IntVector() {}
  
  public int getBufferLength() { return data.length; }
  
  public void copyBuffer(int length)
  {
    int oldLength = data.length;
    if (length == -1)
      length = oldLength;
    if (oldLength != length) {
      int[] tmp = new int[length];
      System.arraycopy(data, 0, tmp, 0, oldLength < length ? oldLength : length);
      
      data = tmp;
    }
  }
  
  public int[] getBuffer() { return data; }
  
  protected void setBuffer(Object buffer) { data = ((int[])buffer); }
  
  public final int getInt(int index) {
    return data[effectiveIndex(index)];
  }
  
  public final int getIntRaw(int index) {
    return data[index];
  }
  
  public final void setInt(int index, int value) {
    checkCanWrite();
    data[effectiveIndex(index)] = value;
  }
  
  public final void setIntRaw(int index, int value) {
    data[index] = value;
  }
  
  public void add(int v) {
    int sz = size();
    addSpace(sz, 1);
    setInt(sz, v);
  }
  
  protected void clearBuffer(int start, int count) {
    int[] d = data;
    for (;;) { count--; if (count < 0) break;
      d[(start++)] = 0;
    }
  }
}
