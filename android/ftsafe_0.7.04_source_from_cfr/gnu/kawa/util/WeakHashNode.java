/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

public class WeakHashNode<K, V>
extends WeakReference<K>
implements Map.Entry<K, V> {
    public WeakHashNode<K, V> next;
    public int hash;
    public V value;

    public WeakHashNode(K key, ReferenceQueue<K> q, int hash) {
        super(key, q);
        this.hash = hash;
    }

    @Override
    public K getKey() {
        return (K)this.get();
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
}

