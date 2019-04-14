package gnu.lists;






public class S32Vector
  extends IntVector<Integer>
  implements IntSequence
{
  public S32Vector()
  {
    data = empty;
  }
  
  public S32Vector(int size, int value) {
    int[] array = new int[size];
    data = array;
    if (value != 0)
      for (;;) { size--; if (size < 0) break;
        array[size] = value;
      }
  }
  
  public S32Vector(int size) {
    this(new int[size]);
  }
  
  public S32Vector(int[] data)
  {
    this.data = data;
  }
  

  public S32Vector(int[] values, int offset, int length)
  {
    this(length);
    System.arraycopy(values, offset, data, 0, length);
  }
  
  public final long getLongRaw(int index) {
    return data[index];
  }
  
  public final Integer get(int index) {
    return Integer.valueOf(data[effectiveIndex(index)]);
  }
  
  public final Integer getRaw(int index) {
    return Integer.valueOf(data[index]);
  }
  
  public final void setRaw(int index, Integer value)
  {
    data[index] = value.intValue();
  }
  
  protected S32Vector newInstance(int newLength)
  {
    return new S32Vector(newLength < 0 ? data : new int[newLength]);
  }
  
  public int getElementKind() { return 22; }
  
  public String getTag() { return "s32"; }
  
  public int compareTo(Object obj) {
    return compareToInt(this, (S32Vector)obj);
  }
}
