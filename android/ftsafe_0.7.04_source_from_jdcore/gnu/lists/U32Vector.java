package gnu.lists;

import gnu.math.UInt;





public class U32Vector
  extends IntVector<UInt>
{
  public U32Vector()
  {
    data = empty;
  }
  
  public U32Vector(int size, int value) {
    int[] array = new int[size];
    data = array;
    if (value != 0)
      for (;;) { size--; if (size < 0) break;
        array[size] = value;
      }
  }
  
  public U32Vector(int size) {
    this(new int[size]);
  }
  
  public U32Vector(int[] data)
  {
    this.data = data;
  }
  

  public U32Vector(int[] values, int offset, int length)
  {
    this(length);
    System.arraycopy(values, offset, data, 0, length);
  }
  
  public final long getLongRaw(int index) {
    return data[index] & 0xFFFFFFFF;
  }
  
  public final UInt get(int index) {
    return UInt.valueOf(data[effectiveIndex(index)]);
  }
  
  public final UInt getRaw(int index) {
    return UInt.valueOf(data[index]);
  }
  
  public final void setRaw(int index, UInt value)
  {
    data[index] = value.intValue();
  }
  
  protected U32Vector newInstance(int newLength)
  {
    return new U32Vector(newLength < 0 ? data : new int[newLength]);
  }
  
  public int getElementKind() { return 21; }
  
  public String getTag() { return "u32"; }
  
  public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
    if (out.ignoring())
      return;
    int i = nextIndex(iposStart);
    int end = nextIndex(iposEnd);
    for (; i < end; i++)
      Sequences.writeUInt(getInt(i), out);
  }
  
  public int compareTo(Object obj) {
    return compareToInt(this, (U32Vector)obj);
  }
}
