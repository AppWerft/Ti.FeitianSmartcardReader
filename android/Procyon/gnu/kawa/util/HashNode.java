// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.util.Map;

public class HashNode<K, V> implements Map.Entry<K, V>
{
    public HashNode<K, V> next;
    protected int keyHash;
    K key;
    V value;
    
    @Override
    public K getKey() {
        return this.key;
    }
    
    @Override
    public V getValue() {
        return this.value;
    }
    
    @Override
    public V setValue(final V value) {
        final V old = this.value;
        this.value = value;
        return old;
    }
    
    @Override
    public int hashCode() {
        return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value.hashCode());
    }
    
    public HashNode(final K key, final V value) {
        this.key = key;
        this.value = value;
    }
    
    public HashNode(final K key, final V value, final int keyHash) {
        this(key, value);
        this.keyHash = keyHash;
    }
    
    public V get(final V defaultValue) {
        return this.getValue();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof HashNode)) {
            return false;
        }
        final HashNode h2 = (HashNode)o;
        if (this.key == null) {
            if (h2.key != null) {
                return false;
            }
        }
        else if (!this.key.equals(h2.key)) {
            return false;
        }
        if ((this.value != null) ? this.value.equals(h2.value) : (h2.value == null)) {
            return true;
        }
        return false;
    }
}
