package gnu.text;

import java.io.ObjectOutput;

public final class StringCursor implements Comparable, java.io.Externalizable {
  int value;
  
  public StringCursor() {}
  
  public static StringCursor valueOf(int value) {
    StringCursor sc = new StringCursor();
    value = value;
    return sc;
  }
  
  public int getValue() { return value; }
  
  public int compareTo(Object o) {
    return value - value;
  }
  
  public static int checkStringCursor(Object obj) {
    return (obj instanceof StringCursor) ? value : -2;
  }
  
  public void writeExternal(ObjectOutput out) throws java.io.IOException {
    out.writeInt(value);
  }
  
  public void readExternal(java.io.ObjectInput in) throws java.io.IOException {
    value = in.readInt();
  }
}
