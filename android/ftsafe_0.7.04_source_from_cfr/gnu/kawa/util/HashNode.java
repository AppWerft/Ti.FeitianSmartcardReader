/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import java.util.Map;

public class HashNode<K, V>
implements Map.Entry<K, V> {
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
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }

    @Override
    public int hashCode() {
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
    }

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public HashNode(K key, V value, int keyHash) {
        this(key, value);
        this.keyHash = keyHash;
    }

    public V get(V defaultValue) {
        return this.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HashNode)) {
            return false;
        }
        HashNode h2 = (HashNode)o;
        return (this.key == null ? h2.key == null : this.key.equals(h2.key)) && (this.value == null ? h2.value == null : this.value.equals(h2.value));
    }
}

