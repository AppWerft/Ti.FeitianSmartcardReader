package gnu.kawa.util;

import java.util.Map.Entry;














public class HashNode<K, V>
  implements Map.Entry<K, V>
{
  public HashNode<K, V> next;
  protected int keyHash;
  K key;
  V value;
  
  public K getKey()
  {
    return key;
  }
  
  public V getValue() {
    return value;
  }
  
  public V setValue(V value) {
    V old = this.value;
    this.value = value;
    return old;
  }
  



  public int hashCode()
  {
    return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
  }
  





  public HashNode(K key, V value)
  {
    this.key = key;
    this.value = value;
  }
  

  public HashNode(K key, V value, int keyHash)
  {
    this(key, value);
    this.keyHash = keyHash;
  }
  
  public V get(V defaultValue)
  {
    return getValue();
  }
  




  public boolean equals(Object o)
  {
    if (!(o instanceof HashNode)) {
      return false;
    }
    

    HashNode h2 = (HashNode)o;
    return (key == null ? key == null : key.equals(key)) && (value == null ? value == null : value.equals(value));
  }
}
