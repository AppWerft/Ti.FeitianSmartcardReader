/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.AbstractWeakHashTable;
import gnu.kawa.util.WeakHashNode;
import java.lang.ref.ReferenceQueue;
import java.util.Map;

public class WeakIdentityHashMap<K, V>
extends AbstractHashTable<WeakHashNode<K, V>, K, V> {
    ReferenceQueue<K> rqueue = new ReferenceQueue();

    public WeakIdentityHashMap() {
        super(64);
    }

    public WeakIdentityHashMap(int capacity) {
        super(capacity);
    }

    @Override
    protected int getEntryHashCode(WeakHashNode<K, V> entry) {
        return entry.hash;
    }

    @Override
    protected WeakHashNode<K, V> getEntryNext(WeakHashNode<K, V> entry) {
        return entry.next;
    }

    @Override
    protected void setEntryNext(WeakHashNode<K, V> entry, WeakHashNode<K, V> next) {
        entry.next = next;
    }

    protected WeakHashNode<K, V>[] allocEntries(int n) {
        return new WeakHashNode[n];
    }

    @Override
    public int hash(Object key) {
        return System.identityHashCode(key);
    }

    @Override
    protected boolean matches(K key1, Object key2) {
        return key1 == key2;
    }

    @Override
    protected WeakHashNode<K, V> makeEntry(K key, int hash, V value) {
        WeakHashNode node = new WeakHashNode(key, this.rqueue, hash);
        node.value = value;
        return node;
    }

    @Override
    public V get(Object key, V defaultValue) {
        this.cleanup();
        return super.get(key, defaultValue);
    }

    @Override
    public V put(K key, int hash, V value) {
        this.cleanup();
        return super.put(key, hash, value);
    }

    @Override
    public V remove(Object key) {
        this.cleanup();
        return super.remove(key);
    }

    void cleanup() {
        AbstractWeakHashTable.cleanup(this, this.rqueue);
    }
}

