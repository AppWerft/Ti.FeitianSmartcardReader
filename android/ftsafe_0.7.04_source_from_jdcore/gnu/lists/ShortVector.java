package gnu.lists;




public abstract class ShortVector<E>
  extends PrimIntegerVector<E>
{
  short[] data;
  


  protected static short[] empty = new short[0];
  
  public ShortVector() {}
  
  public int getBufferLength() { return data.length; }
  
  public void copyBuffer(int length)
  {
    int oldLength = data.length;
    if (length == -1)
      length = oldLength;
    if (oldLength != length) {
      short[] tmp = new short[length];
      System.arraycopy(data, 0, tmp, 0, oldLength < length ? oldLength : length);
      
      data = tmp;
    }
  }
  
  public short[] getBuffer() { return data; }
  
  protected void setBuffer(Object buffer) { data = ((short[])buffer); }
  
  public final short getShort(int index) {
    return data[effectiveIndex(index)];
  }
  
  public final short getShortRaw(int index) {
    return data[index];
  }
  
  public final void setShort(int index, short value) {
    checkCanWrite();
    data[effectiveIndex(index)] = value;
  }
  
  public final void setShortRaw(int index, short value) {
    data[index] = value;
  }
  
  public void add(short v) {
    int sz = size();
    addSpace(sz, 1);
    setShort(sz, v);
  }
  
  protected void clearBuffer(int start, int count) {
    short[] d = data;
    for (;;) { count--; if (count < 0) break;
      d[(start++)] = 0;
    }
  }
}
