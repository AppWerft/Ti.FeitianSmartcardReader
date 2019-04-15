package gnu.lists;

import gnu.math.UShort;





public class U16Vector
  extends ShortVector<UShort>
{
  public U16Vector()
  {
    data = empty;
  }
  
  public U16Vector(int size, short value) {
    short[] array = new short[size];
    data = array;
    if (value != 0)
      for (;;) { size--; if (size < 0) break;
        array[size] = value;
      }
  }
  
  public U16Vector(int size) {
    this(new short[size]);
  }
  
  public U16Vector(short[] data)
  {
    this.data = data;
  }
  

  public U16Vector(short[] values, int offset, int length)
  {
    this(length);
    System.arraycopy(values, offset, data, 0, length);
  }
  
  public final int getIntRaw(int index) {
    return data[index] & 0xFFFF;
  }
  
  public final UShort get(int index) {
    return UShort.valueOf(data[effectiveIndex(index)]);
  }
  
  public final UShort getRaw(int index) {
    return UShort.valueOf(data[index]);
  }
  
  public final void setRaw(int index, UShort value)
  {
    data[index] = value.shortValue();
  }
  
  protected U16Vector newInstance(int newLength)
  {
    return new U16Vector(newLength < 0 ? data : new short[newLength]);
  }
  
  public int getElementKind() { return 19; }
  
  public String getTag() { return "u16"; }
  
  public int compareTo(Object obj) {
    return compareToInt(this, (U16Vector)obj);
  }
}
