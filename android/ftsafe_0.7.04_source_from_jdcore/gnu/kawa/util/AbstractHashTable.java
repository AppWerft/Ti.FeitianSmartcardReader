package gnu.kawa.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;






public abstract class AbstractHashTable<Entry extends Map.Entry<K, V>, K, V>
  extends AbstractMap<K, V>
{
  protected Entry[] table;
  protected int mask;
  protected int num_bindings;
  public static final int DEFAULT_INITIAL_SIZE = 64;
  
  protected abstract int getEntryHashCode(Entry paramEntry);
  
  protected abstract Entry getEntryNext(Entry paramEntry);
  
  protected abstract void setEntryNext(Entry paramEntry1, Entry paramEntry2);
  
  protected abstract Entry[] allocEntries(int paramInt);
  
  public AbstractHashTable()
  {
    this(64);
  }
  
  public AbstractHashTable(int capacity)
  {
    int log2Size = 4;
    while (capacity > 1 << log2Size)
      log2Size++;
    capacity = 1 << log2Size;
    table = allocEntries(capacity);
    mask = (capacity - 1);
  }
  


  protected abstract Entry makeEntry(K paramK, int paramInt, V paramV);
  

  public int hash(Object key)
  {
    return key == null ? 0 : key.hashCode();
  }
  


  protected int hashToIndex(int hash)
  {
    hash ^= hash >>> 15;
    return hash & mask;
  }
  

  protected boolean matches(Object key, int hash, Entry node)
  {
    return (getEntryHashCode(node) == hash) && (matches(node.getKey(), key));
  }
  




  protected boolean matches(K key1, Object key2)
  {
    return (key1 == key2) || ((key1 != null) && (key1.equals(key2)));
  }
  

  public V get(Object key)
  {
    return get(key, null);
  }
  

  public Entry getNode(Object key)
  {
    int hash = hash(key);
    int index = hashToIndex(hash);
    for (Entry node = table[index]; 
        node != null; node = getEntryNext(node))
    {
      if (matches(key, hash, node))
        return node;
    }
    return null;
  }
  

  public V get(Object key, V defaultValue)
  {
    Entry node = getNode(key);
    return node == null ? defaultValue : node.getValue();
  }
  

  public V getOrDefault(Object key, V defaultValue)
  {
    return get(key, defaultValue);
  }
  
  protected void rehash()
  {
    Entry[] oldTable = table;
    int oldCapacity = oldTable.length;
    int newCapacity = 2 * oldCapacity;
    Entry[] newTable = allocEntries(newCapacity);
    int newMask = newCapacity - 1;
    table = newTable;
    mask = newMask;
    int i = oldCapacity; Entry element; for (;;) { i--; if (i < 0)
        break;
      Entry chain = oldTable[i];
      if ((chain != null) && (getEntryNext(chain) != null))
      {




        Entry prev = null;
        do
        {
          Entry node = chain;
          chain = getEntryNext(node);
          setEntryNext(node, prev);
          prev = node;
        }
        while (chain != null);
        chain = prev;
      }
      
      for (element = chain; element != null;)
      {
        Entry next = getEntryNext(element);
        int hash = getEntryHashCode(element);
        int j = hashToIndex(hash);
        Entry head = newTable[j];
        setEntryNext(element, head);
        newTable[j] = element;
        element = next;
      }
    }
  }
  
  public V put(K key, V value)
  {
    return put(key, hash(key), value);
  }
  
  public V put(K key, int hash, V value)
  {
    int index = hashToIndex(hash);
    Entry first = table[index];
    Entry node = first;
    for (;;)
    {
      if (node == null)
      {
        if (++num_bindings >= table.length)
        {
          rehash();
          index = hashToIndex(hash);
          first = table[index];
        }
        node = makeEntry(key, hash, value);
        setEntryNext(node, first);
        table[index] = node;
        return null;
      }
      if (matches(key, hash, node))
      {
        V oldValue = node.getValue();
        node.setValue(value);
        return oldValue;
      }
      node = getEntryNext(node);
    }
  }
  
  public V remove(Object key)
  {
    int hash = hash(key);
    int index = hashToIndex(hash);
    Entry prev = null;
    Entry node = table[index];
    while (node != null)
    {
      Entry next = getEntryNext(node);
      if (matches(key, hash, node))
      {
        if (prev == null) {
          table[index] = next;
        } else
          setEntryNext(prev, next);
        num_bindings -= 1;
        return node.getValue();
      }
      prev = node;
      node = next;
    }
    return null;
  }
  
  public void clear()
  {
    Entry[] t = table;
    int i = t.length; for (;;) { i--; if (i < 0) {
        break;
      }
      
      for (Entry e = t[i]; e != null;)
      {
        Entry next = getEntryNext(e);
        setEntryNext(e, null);
        e = next;
      }
      t[i] = null;
    }
    num_bindings = 0;
  }
  
  public int size()
  {
    return num_bindings;
  }
  

  public Set<Map.Entry<K, V>> entrySet()
  {
    return new AbstractEntrySet(this);
  }
  
  static class AbstractEntrySet<Entry extends Map.Entry<K, V>, K, V> extends AbstractSet<Entry>
  {
    AbstractHashTable<Entry, K, V> htable;
    
    public AbstractEntrySet(AbstractHashTable<Entry, K, V> htable)
    {
      this.htable = htable;
    }
    
    public int size()
    {
      return htable.size();
    }
    
    public Iterator<Entry> iterator()
    {
      new Iterator()
      {
        int nextIndex;
        Entry previousEntry;
        Entry currentEntry;
        Entry nextEntry;
        int curIndex = -1;
        






        public boolean hasNext()
        {
          if (curIndex < 0)
          {
            nextIndex = htable.table.length;
            curIndex = nextIndex;
            advance();
          }
          return nextEntry != null;
        }
        
        private void advance() {
          while ((nextEntry == null) && (--nextIndex >= 0))
          {
            nextEntry = htable.table[nextIndex];
          }
        }
        
        public Entry next()
        {
          if (nextEntry == null)
            throw new NoSuchElementException();
          previousEntry = currentEntry;
          currentEntry = nextEntry;
          curIndex = nextIndex;
          nextEntry = htable.getEntryNext(currentEntry);
          advance();
          return currentEntry;
        }
        
        public void remove() {
          if (previousEntry == currentEntry)
            throw new IllegalStateException();
          if (previousEntry == null) {
            htable.table[curIndex] = nextEntry;
          } else
            htable.setEntryNext(previousEntry, nextEntry);
          htable.num_bindings -= 1;
          previousEntry = currentEntry;
        }
      };
    }
  }
}
