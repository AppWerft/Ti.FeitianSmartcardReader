package gnu.kawa.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map.Entry;




public abstract class AbstractWeakHashTable<K, V>
  extends AbstractHashTable<WEntry<K, V>, K, V>
{
  ReferenceQueue<V> rqueue = new ReferenceQueue();
  


  public AbstractWeakHashTable()
  {
    super(64);
  }
  
  public AbstractWeakHashTable(int capacity)
  {
    super(capacity);
  }
  
  protected abstract K getKeyFromValue(V paramV);
  
  protected int getEntryHashCode(WEntry<K, V> entry) { return hash; }
  protected WEntry<K, V> getEntryNext(WEntry<K, V> entry) { return next; }
  protected void setEntryNext(WEntry<K, V> entry, WEntry<K, V> next) { next = next; }
  protected WEntry<K, V>[] allocEntries(int n) { return (WEntry[])new WEntry[n]; }
  
  protected V getValueIfMatching(WEntry<K, V> node, Object key)
  {
    V val = node.getValue();
    if ((val != null) && (matches(getKeyFromValue(val), key)))
      return val;
    return null;
  }
  
  public V get(Object key, V defaultValue)
  {
    cleanup();
    return super.get(key, defaultValue);
  }
  
  public int hash(Object key)
  {
    return System.identityHashCode(key);
  }
  
  protected boolean valuesEqual(V oldValue, V newValue)
  {
    return oldValue == newValue;
  }
  
  protected WEntry<K, V> makeEntry(K key, int hash, V value)
  {
    return new WEntry(value, this, hash);
  }
  
  public V put(K key, V value)
  {
    cleanup();
    int hash = hash(key);
    int index = hashToIndex(hash);
    WEntry<K, V> first = ((WEntry[])table)[index];
    WEntry<K, V> node = first;
    WEntry<K, V> prev = null;
    V oldValue = null;
    for (;;)
    {
      if (node == null)
      {
        if (++num_bindings >= ((WEntry[])table).length)
        {
          rehash();
          index = hashToIndex(hash);
          first = ((WEntry[])table)[index];
        }
        node = makeEntry(null, hash, value);
        next = first;
        ((WEntry[])table)[index] = node;
        return oldValue;
      }
      V curValue = node.getValue();
      if (curValue == value)
        return curValue;
      WEntry<K, V> next = next;
      if ((curValue != null) && (valuesEqual(curValue, value)))
      {
        if (prev == null) {
          ((WEntry[])table)[index] = next;
        } else
          next = next;
        oldValue = curValue;
      }
      else {
        prev = node; }
      node = next;
    }
  }
  

  protected void cleanup()
  {
    cleanup(this, rqueue);
  }
  



  static <Entry extends Map.Entry<K, V>, K, V> void cleanup(AbstractHashTable<Entry, ?, ?> map, ReferenceQueue<?> rqueue)
  {
    for (;;)
    {
      Entry oldref = (Map.Entry)rqueue.poll();
      if (oldref == null)
        break;
      int index = map.hashToIndex(map.getEntryHashCode(oldref));
      Entry prev = null;
      Entry node = table[index];
      while (node != null)
      {
        Entry next = map.getEntryNext(node);
        if (node == oldref)
        {
          if (prev == null) {
            table[index] = next; break;
          }
          map.setEntryNext(prev, next);
          break;
        }
        prev = node;
        node = next;
      }
      num_bindings -= 1;
    }
  }
  

  public static class WEntry<K, V>
    extends WeakReference<V>
    implements Map.Entry<K, V>
  {
    public WEntry next;
    
    public int hash;
    
    AbstractWeakHashTable<K, V> htable;
    

    public WEntry(V value, AbstractWeakHashTable<K, V> htable, int hash)
    {
      super(rqueue);
      


      this.htable = htable;
      this.hash = hash;
    }
    




    public K getKey()
    {
      V v = get();
      return v == null ? null : htable.getKeyFromValue(v);
    }
    
    public V getValue()
    {
      return get();
    }
    
    public V setValue(V value)
    {
      throw new UnsupportedOperationException();
    }
  }
}
