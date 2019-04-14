package gnu.kawa.util;



public class IntHashTable
{
  private static final int DEFAULT_INITIAL_SIZE = 64;
  

  protected Object[] objs;
  
  protected int[] ints;
  
  protected int mask;
  
  protected int num_bindings;
  
  private static Object DELETED = new Object();
  




  public IntHashTable()
  {
    objs = new Object[64];
    ints = new int[64];
    mask = 63;
  }
  



  public IntHashTable(int capacity)
  {
    int log2Size = 4;
    while (capacity > 1 << log2Size) {
      log2Size++;
    }
    capacity = 1 << log2Size;
    objs = new Object[capacity];
    ints = new int[capacity];
    mask = (capacity - 1);
  }
  





  public int hash(Object key)
  {
    return System.identityHashCode(key);
  }
  








  public int lookup(Object key, int hash)
  {
    int hash1 = hash ^ hash >>> 15;
    int hash2 = hash ^ hash << 6 | 0x1;
    int deleted = -1;
    for (int i = hash1 & mask;; i = i + hash2 & mask) {
      Object node = objs[i];
      if (node == key)
        return i;
      if (node == null)
        return deleted >= 0 ? deleted : i;
      if ((node == DELETED) && (deleted < 0)) {
        deleted = i;
      }
    }
  }
  





  public int lookup(Object key)
  {
    return lookup(key, hash(key));
  }
  






  public int getFromIndex(int index)
  {
    Object node = objs[index];
    return (node == null) || (node == DELETED) ? -1 : ints[index];
  }
  









  public int putAtIndex(Object key, int value, int index)
  {
    Object old = objs[index];
    if ((old == null) || (old == DELETED)) {
      objs[index] = key;
      ints[index] = value;
      if (old != DELETED)
        num_bindings += 1;
      if (3 * num_bindings >= 2 * objs.length)
        rehash();
      return -1;
    }
    int oldValue = ints[index];
    ints[index] = value;
    return oldValue;
  }
  
  public int remove(Object key)
  {
    int index = lookup(key);
    Object old = objs[index];
    if ((old == null) || (old == DELETED))
      return -1;
    objs[index] = DELETED;
    return ints[index];
  }
  




  protected void rehash()
  {
    Object[] oldObjsTable = objs;
    int[] oldIntsTable = ints;
    int oldCapacity = oldObjsTable.length;
    int newCapacity = oldCapacity << 1;
    Object[] newObjTable = new Object[newCapacity];
    int[] newIntTable = new int[newCapacity];
    int newMask = newCapacity - 1;
    objs = newObjTable;
    ints = newIntTable;
    mask = newMask;
    num_bindings = 0;
    
    int i = oldIntsTable.length; for (;;) { i--; if (i < 0) break;
      Object key = oldObjsTable[i];
      if ((key != null) && (key != DELETED)) {
        putAtIndex(key, oldIntsTable[i], lookup(key, hash(key)));
      }
    }
  }
  

  public void clear()
  {
    int i = objs.length; for (;;) { i--; if (i < 0) break;
      objs[i] = null;
    }
    num_bindings = 0;
  }
}
