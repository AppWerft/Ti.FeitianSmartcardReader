package gnu.kawa.util;

import java.util.Hashtable;



public class RangeTable
  implements Cloneable
{
  Object[] index = new Object[''];
  Hashtable hash = new Hashtable(200);
  
  public RangeTable() {}
  
  public Object lookup(int key, Object defaultValue) { if ((key & 0x7F) == key)
      return index[key];
    return hash.get(new Integer(key));
  }
  
  public void set(int lo, int hi, Object value)
  {
    if (lo > hi)
      return;
    for (int i = lo;; i++)
    {
      if ((i & 0x7F) == i) {
        index[i] = value;
      } else
        hash.put(new Integer(i), value);
      if (i == hi) {
        break;
      }
    }
  }
  
  public void set(int key, Object value) {
    set(key, key, value);
  }
  
  public void remove(int lo, int hi)
  {
    if (lo > hi)
      return;
    for (int i = lo;; i++)
    {
      if ((i & 0x7F) == i) {
        index[i] = null;
      } else
        hash.remove(new Integer(i));
      if (i == hi) {
        break;
      }
    }
  }
  
  public void remove(int key) {
    remove(key, key);
  }
  
  public RangeTable copy()
  {
    RangeTable copy = new RangeTable();
    index = ((Object[])index.clone());
    hash = ((Hashtable)hash.clone());
    return copy;
  }
  
  public Object clone()
  {
    return copy();
  }
}
