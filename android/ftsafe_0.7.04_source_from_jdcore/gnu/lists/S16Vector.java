package gnu.lists;






public class S16Vector
  extends ShortVector<Short>
{
  public S16Vector()
  {
    data = empty;
  }
  
  public S16Vector(int size, short value) {
    short[] array = new short[size];
    data = array;
    if (value != 0)
      for (;;) { size--; if (size < 0) break;
        array[size] = value;
      }
  }
  
  public S16Vector(int size) {
    this(new short[size]);
  }
  
  public S16Vector(short[] data)
  {
    this.data = data;
  }
  

  public S16Vector(short[] values, int offset, int length)
  {
    this(length);
    System.arraycopy(values, offset, data, 0, length);
  }
  
  public final int getIntRaw(int index) {
    return data[index];
  }
  
  public final Short get(int index) {
    return Short.valueOf(data[effectiveIndex(index)]);
  }
  
  public final Short getRaw(int index) {
    return Short.valueOf(data[index]);
  }
  
  public final void setRaw(int index, Short value)
  {
    data[index] = value.shortValue();
  }
  
  protected S16Vector newInstance(int newLength)
  {
    return new S16Vector(newLength < 0 ? data : new short[newLength]);
  }
  
  public int getElementKind() { return 20; }
  
  public String getTag() { return "s16"; }
  
  public int compareTo(Object obj) {
    return compareToInt(this, (S16Vector)obj);
  }
}
