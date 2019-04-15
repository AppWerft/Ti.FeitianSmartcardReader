package gnu.text;

import gnu.kawa.util.AbstractWeakHashTable;
import gnu.kawa.util.AbstractWeakHashTable.WEntry;
import gnu.lists.Consumer;
import gnu.lists.Sequence;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Map;













public class Char
  implements Comparable, Externalizable
{
  int value;
  public static final int IGNORABLE_CHAR = 2097151;
  static Char[] ascii;
  
  Char(int ch)
  {
    value = ch;
  }
  
  public void print(Consumer out) {
    print(value, out);
  }
  
  public static char castToChar(Object obj) {
    if ((obj instanceof Char)) {
      return ((Char)obj).charValue();
    }
    return ((Character)obj).charValue();
  }
  
  public static int castToCharacter(Object obj) {
    if ((obj instanceof Char)) {
      return ((Char)obj).intValue();
    }
    return ((Character)obj).charValue();
  }
  
  public static int castToCharacterOrEof(Object obj) {
    if (obj == Sequence.eofValue)
      return -1;
    return castToCharacter(obj);
  }
  
  public static boolean isChar(Object obj) {
    return ((obj instanceof Char)) || ((obj instanceof Character));
  }
  
  public static boolean isCharOrEof(Object obj) {
    return ((obj instanceof Char)) || ((obj instanceof Character)) || (obj == Sequence.eofValue);
  }
  


  public static int checkCharOrEof(Object obj)
  {
    if ((obj instanceof Char))
      return ((Char)obj).intValue();
    if ((obj instanceof Character))
      return ((Character)obj).charValue();
    if (obj == Sequence.eofValue)
      return -1;
    return -2;
  }
  
  public static void print(int i, Appendable out) {
    try {
      append(i, out);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  public static void append(int i, Appendable out) throws IOException
  {
    if ((i >= 65536) && (i != 2097151)) {
      out.append((char)((i - 65536 >> 10) + 55296));
      i = (i & 0x3FF) + 56320;
    }
    out.append((char)i);
  }
  
  public final char charValue() {
    return (char)value;
  }
  
  public final int intValue() {
    return value;
  }
  
  public int hashCode() {
    return value;
  }
  


  static CharMap hashTable = new CharMap();
  
  static {
    ascii = new Char[''];
    int i = 128; for (;;) { i--; if (i < 0) break;
      ascii[i] = new Char(i);
    }
  }
  
  public static Char valueOf(int ch) { if (ch < 128)
      return ascii[ch];
    synchronized (hashTable) {
      return hashTable.get(ch);
    }
  }
  
  public static Char make(int ch) {
    return valueOf(ch);
  }
  
  public static Object makeOrEof(int ch) {
    if (ch < 0)
      return Sequence.eofValue;
    return make(ch);
  }
  

  public boolean equals(Object obj)
  {
    return (obj != null) && ((obj instanceof Char)) && (((Char)obj).intValue() == value);
  }
  

  private static String charNameValues = " \t\n\n\r\f\b\033\033\007\007\013\000\000";
  
  static String[] charNames = { "space", "tab", "newline", "linefeed", "return", "page", "backspace", "escape", "esc", "delete", "del", "rubout", "alarm", "bel", "vtab", "null", "nul" };
  















  public static void addNamedChars(Map<String, String> map)
  {
    int i = charNames.length; for (;;) { i--; if (i < 0) break;
      map.put(charNames[i], charNameValues.substring(i, i + 1));
    }
  }
  
  public static int nameToChar(String name) {
    int i = charNames.length; do { i--; if (i < 0) break;
    } while (!charNames[i].equals(name));
    return charNameValues.charAt(i);
    
    int i = charNames.length; do { i--; if (i < 0) break;
    } while (!charNames[i].equalsIgnoreCase(name));
    return charNameValues.charAt(i);
    
    if ("ignorable-char".equalsIgnoreCase(name))
      return 2097151;
    int len = name.length();
    if ((len > 1) && (name.charAt(0) == 'u')) {
      int value = 0;
      for (int pos = 1;; pos++) {
        if (pos == len)
          return value;
        int dig = Character.digit(name.charAt(pos), 16);
        if (dig < 0)
          break;
        value = (value << 4) + dig;
      }
    }
    

    if ((len == 3) && (name.charAt(1) == '-')) {
      char ch = name.charAt(0);
      if ((ch == 'c') || (ch == 'C')) {
        ch = name.charAt(2);
        return ch & 0x1F;
      }
    }
    
    return -1;
  }
  
  public String toString() {
    return toString(value);
  }
  
  public static String toString(int value) {
    StringBuffer buf = new StringBuffer();
    buf.append('\'');
    if ((value >= 32) && (value < 127) && (value != 39)) {
      buf.append((char)value);
    } else {
      buf.append('\\');
      if (value == 39) {
        buf.append('\'');
      } else if (value == 10) {
        buf.append('n');
      } else if (value == 13) {
        buf.append('r');
      } else if (value == 9) {
        buf.append('t');
      } else if (value < 256) {
        String str = Integer.toOctalString(value);
        int i = 3 - str.length(); for (;;) { i--; if (i < 0) break;
          buf.append('0'); }
        buf.append(str);
      } else {
        buf.append('u');
        String str = Integer.toHexString(value);
        int i = 4 - str.length(); for (;;) { i--; if (i < 0) break;
          buf.append('0'); }
        buf.append(str);
      }
    }
    buf.append('\'');
    return buf.toString();
  }
  
  public static String toScmReadableString(int ch) {
    StringBuffer sbuf = new StringBuffer(20);
    sbuf.append("#\\");
    int nlen = charNameValues.length();
    for (int i = 0; i < nlen; i++) {
      if ((char)ch == charNameValues.charAt(i)) {
        sbuf.append(charNames[i]);
        return sbuf.toString();
      }
    }
    if (ch == 2097151) {
      sbuf.append("ignorable-char");
    } else if ((ch < 32) || (ch > 127)) {
      sbuf.append('x');
      sbuf.append(Integer.toString(ch, 16));
    } else {
      sbuf.append((char)ch); }
    return sbuf.toString();
  }
  

  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeInt(value);
  }
  
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
  {
    value = in.readInt();
  }
  
  public Object readResolve() throws ObjectStreamException {
    return make(value);
  }
  

  public int compareTo(Object o) { return value - value; }
  
  public Char() {}
  
  static class CharMap extends AbstractWeakHashTable<Char, Char> {
    CharMap() {}
    
    public Char get(int key) { cleanup();
      int hash = key;
      int index = hashToIndex(hash);
      for (AbstractWeakHashTable.WEntry<Char, Char> node = ((AbstractWeakHashTable.WEntry[])table)[index]; 
          node != null; node = next) {
        Char val = (Char)node.getValue();
        if ((val != null) && (val.intValue() == key))
          return val;
      }
      Char val = new Char(key);
      super.put(val, val);
      return val;
    }
    
    protected Char getKeyFromValue(Char ch) {
      return ch;
    }
    
    protected boolean matches(Char oldValue, Char newValue) {
      return oldValue.intValue() == newValue.intValue();
    }
  }
}
