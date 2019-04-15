package gnu.mapping;

import java.lang.ref.WeakReference;







public class Table2D
{
  private static Table2D instance = new Table2D();
  public static final Table2D getInstance() { return instance; }
  





  public Table2D()
  {
    this(64);
  }
  
  public Table2D(int capacity)
  {
    log2Size = 4;
    while (capacity > 1 << log2Size)
      log2Size += 1;
    capacity = 1 << log2Size;
    table = new Entry[capacity];
    mask = (capacity - 1);
  }
  
  public Object get(Object key1, Object key2, Object defaultValue)
  {
    int h1 = System.identityHashCode(key1);
    int h2 = System.identityHashCode(key2);
    Entry entry = lookup(key1, key2, h1, h2, false);
    return (entry == null) || (value == entry) ? defaultValue : value;
  }
  
  public boolean isBound(Object key1, Object key2)
  {
    int h1 = System.identityHashCode(key1);
    int h2 = System.identityHashCode(key2);
    Entry entry = lookup(key1, key2, h1, h2, false);
    return (entry != null) && (value != entry);
  }
  
  public Object put(Object key1, Object key2, Object newValue)
  {
    int h1 = System.identityHashCode(key1);
    int h2 = System.identityHashCode(key2);
    Entry entry = lookup(key1, key2, h1, h2, true);
    Object oldValue = entry.getValue();
    value = newValue;
    return oldValue;
  }
  
  public Object remove(Object key1, Object key2)
  {
    int h1 = System.identityHashCode(key1);
    int h2 = System.identityHashCode(key2);
    int hash = h1 ^ h2;
    return remove(key1, key2, hash);
  }
  
  public Object remove(Object key1, Object key2, int hash)
  {
    return remove(key1, key2, hash);
  }
  
  public Object remove(Object key1, Object key2, int hash1, int hash2)
  {
    int hash = hash1 ^ hash2;
    int index = hash & mask;
    Entry prev = null;
    Entry first = table[index];
    for (Entry e = first; e != null;)
    {
      Object k1 = key1;
      Object k2 = key2;
      boolean dead = false;
      
      if ((k1 instanceof WeakReference))
      {
        k1 = ((WeakReference)k1).get();
        dead = k1 == null;
      }
      if ((k2 instanceof WeakReference))
      {
        k2 = ((WeakReference)k2).get();
        dead = k2 == null;
      }
      
      Entry next = chain;
      Object oldValue = value;
      boolean matches = (k1 == key1) && (k2 == key2);
      if ((dead) || (matches))
      {
        if (prev == null) {
          table[index] = next;
        } else
          chain = next;
        num_bindings -= 1;
        value = e;
      } else {
        if (matches) {
          return oldValue;
        }
        prev = e; }
      e = next;
    }
    return null;
  }
  










  Entry[] table;
  









  int log2Size;
  








  int mask;
  








  int num_bindings;
  








  void rehash()
  {
    Entry[] oldTable = table;
    int oldCapacity = oldTable.length;
    int newCapacity = 2 * oldCapacity;
    Entry[] newTable = new Entry[newCapacity];
    int newMask = newCapacity - 1;
    num_bindings = 0;
    int i = oldCapacity; Entry e; for (;;) { i--; if (i < 0)
        break;
      Entry first = oldTable[i];
      Entry prev = null;
      for (e = first; e != null;)
      {
        Object k1 = key1;
        Object k2 = key2;
        boolean dead = false;
        
        if ((k1 instanceof WeakReference))
        {
          k1 = ((WeakReference)k1).get();
          dead = k1 == null;
        }
        if ((k2 instanceof WeakReference))
        {
          k2 = ((WeakReference)k2).get();
          dead = k2 == null;
        }
        
        Entry next = chain;
        if (dead) {
          value = e;
        }
        else {
          int hash = System.identityHashCode(k1) ^ System.identityHashCode(k2);
          
          int index = hash & newMask;
          chain = newTable[index];
          newTable[index] = e;
          num_bindings += 1;
        }
        e = next;
      }
    }
    table = newTable;
    log2Size += 1;
    mask = newMask;
  }
  

  protected Entry lookup(Object key1, Object key2, int hash1, int hash2, boolean create)
  {
    int hash = hash1 ^ hash2;
    int index = hash & mask;
    Entry prev = null;
    Entry first = table[index];
    for (Entry e = first; e != null;)
    {
      Object k1 = key1;
      Object k2 = key2;
      boolean dead = false;
      
      if ((k1 instanceof WeakReference))
      {
        k1 = ((WeakReference)k1).get();
        dead = k1 == null;
      }
      if ((k2 instanceof WeakReference))
      {
        k2 = ((WeakReference)k2).get();
        dead = k2 == null;
        dead = true;
      }
      
      Entry next = chain;
      if (dead)
      {
        if (prev == null) {
          table[index] = next;
        } else
          chain = next;
        num_bindings -= 1;
        value = e;
      } else {
        if ((k1 == key1) && (k2 == key2)) {
          return e;
        }
        prev = e; }
      e = next;
    }
    if (create)
    {
      Entry e = new Entry();
      































      key1 = wrapReference(key1);
      key2 = wrapReference(key2);
      key1 = key1;
      key2 = key2;
      num_bindings += 1;
      
      chain = first;
      table[index] = e;
      value = e;
      return e;
    }
    
    return null;
  }
  

  protected Object wrapReference(Object key)
  {
    return (key == null) || ((key instanceof Symbol)) ? key : new WeakReference(key);
  }
}
