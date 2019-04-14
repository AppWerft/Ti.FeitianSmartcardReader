package gnu.lists;

import gnu.math.UByte;





public class U8Vector
  extends ByteVector<UByte>
{
  public U8Vector()
  {
    data = empty;
  }
  
  public U8Vector(int size, byte value) {
    byte[] array = new byte[size];
    data = array;
    if (value != 0)
      for (;;) { size--; if (size < 0) break;
        array[size] = value;
      }
  }
  
  public U8Vector(int size) {
    this(new byte[size]);
  }
  
  public U8Vector(byte[] data)
  {
    this.data = data;
  }
  

  public U8Vector(byte[] values, int offset, int length)
  {
    this(length);
    System.arraycopy(values, offset, data, 0, length);
  }
  
  public final int getIntRaw(int index) {
    return data[index] & 0xFF;
  }
  
  public final UByte get(int index) {
    return UByte.valueOf(data[effectiveIndex(index)]);
  }
  
  public final UByte getRaw(int index) {
    return UByte.valueOf(data[index]);
  }
  
  public final void setRaw(int index, UByte value)
  {
    data[index] = value.byteValue();
  }
  
  protected U8Vector newInstance(int newLength)
  {
    return new U8Vector(newLength < 0 ? data : new byte[newLength]);
  }
  
  public int getElementKind() { return 17; }
  
  public String getTag() { return "u8"; }
  
  public int compareTo(Object obj) {
    return compareToInt(this, (U8Vector)obj);
  }
}
