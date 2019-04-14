package gnu.kawa.util;






public class GeneralHashTable<K, V>
  extends AbstractHashTable<HashNode<K, V>, K, V>
{
  public GeneralHashTable() {}
  




  public GeneralHashTable(int capacity)
  {
    super(capacity);
  }
  
  protected int getEntryHashCode(HashNode<K, V> entry) { return keyHash; }
  protected HashNode<K, V> getEntryNext(HashNode<K, V> entry) { return next; }
  protected void setEntryNext(HashNode<K, V> entry, HashNode<K, V> next) { next = next; }
  protected HashNode<K, V>[] allocEntries(int n) { return (HashNode[])new HashNode[n]; }
  

  protected HashNode<K, V> makeEntry(K key, int hash, V value)
  {
    return new HashNode(key, value, hash);
  }
  

  public HashNode<K, V> getNode(Object key)
  {
    return (HashNode)super.getNode(key);
  }
}
