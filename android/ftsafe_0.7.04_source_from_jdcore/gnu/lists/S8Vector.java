package gnu.lists;






public class S8Vector
  extends ByteVector<Byte>
{
  public S8Vector()
  {
    data = empty;
  }
  
  public S8Vector(int size, byte value) {
    byte[] array = new byte[size];
    data = array;
    if (value != 0)
      for (;;) { size--; if (size < 0) break;
        array[size] = value;
      }
  }
  
  public S8Vector(int size) {
    this(new byte[size]);
  }
  
  public S8Vector(byte[] data)
  {
    this.data = data;
  }
  

  public S8Vector(byte[] values, int offset, int length)
  {
    this(length);
    System.arraycopy(values, offset, data, 0, length);
  }
  
  public final int getIntRaw(int index) {
    return data[index];
  }
  
  public final Byte get(int index) {
    return Byte.valueOf(data[effectiveIndex(index)]);
  }
  
  public final Byte getRaw(int index) {
    return Byte.valueOf(data[index]);
  }
  
  public final void setRaw(int index, Byte value)
  {
    data[index] = value.byteValue();
  }
  
  protected S8Vector newInstance(int newLength)
  {
    return new S8Vector(newLength < 0 ? data : new byte[newLength]);
  }
  
  public int getElementKind() { return 18; }
  
  public String getTag() { return "s8"; }
  
  public int compareTo(Object obj) {
    return compareToInt(this, (S8Vector)obj);
  }
}
