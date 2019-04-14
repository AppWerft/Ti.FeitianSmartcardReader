package gnu.text;

import gnu.kawa.util.GeneralHashTable;
import gnu.kawa.util.HashNode;






public class NamedCharTable
  extends GeneralHashTable<String, String>
{
  public NamedCharTable() {}
  
  protected HashNode<String, String> makeEntry(String key, int hash, String value)
  {
    return new Entry(key, value, hash);
  }
  
  public boolean appendTo(String key, Appendable out) {
    Entry e = (Entry)getNode(key);
    if (e == null)
      return false;
    e.appendTo(out);
    return true;
  }
  
  public void put(String name, int char1) {
    put(name, (String)null);
    Entry e = (Entry)getNode(name);
    char1 = char1;
  }
  
  public void put(String name, int char1, int char2) {
    put(name, null);
    Entry e = (Entry)getNode(name);
    char1 = char1;
    char2 = char2;
  }
  
  static class Entry extends HashNode<String, String> {
    int char1;
    int char2;
    
    public Entry(String key, String value, int hash) { super(value, hash); }
    
    public void appendTo(Appendable out)
    {
      Char.print(char1, out);
      if (char2 != 0)
        Char.print(char2, out);
    }
    
    public synchronized String getValue() {
      String v = (String)super.getValue();
      if (v == null) {
        StringBuilder sb = new StringBuilder(char2 == 0 ? 1 : 2);
        appendTo(sb);
        v = sb.toString();
        super.setValue(v);
      }
      return v;
    }
  }
}
