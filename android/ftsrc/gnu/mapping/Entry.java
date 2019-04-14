package gnu.mapping;

import java.lang.ref.WeakReference;






























































































































































































































































































































































class Entry
{
  Entry chain;
  Object value;
  Object key1;
  Object key2;
  
  Entry() {}
  
  public Object getKey1()
  {
    if ((key1 instanceof WeakReference)) {
      return ((WeakReference)key1).get();
    }
    return key1;
  }
  

  public Object getKey2()
  {
    if ((key2 instanceof WeakReference)) {
      return ((WeakReference)key2).get();
    }
    return key2;
  }
  
  public boolean matches(Object key1, Object key2)
  {
    return (key1 == getKey1()) && (key2 == getKey2());
  }
  
  public Object getValue() { return value == this ? null : value; }
}
