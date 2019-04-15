package gnu.lists;














public class CharVector
  extends AbstractCharVector<Character>
{
  public CharVector(char[] values)
  {
    data = values;
  }
  
  public final Character getRaw(int index) {
    return Character.valueOf(data[index]);
  }
  
  public final void setRaw(int index, Character value)
  {
    data[index] = value.charValue();
  }
  
  public boolean equals(Object obj) {
    return ((obj instanceof CharVector)) && (equals(this, (CharVector)obj));
  }
  
  protected CharVector newInstance(int newLength)
  {
    return new CharVector(newLength < 0 ? data : new char[newLength]);
  }
  
  public int getElementKind() { return 29; }
  
  public String getTag() { return "c16"; }
}
