// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.util.Map;
import java.lang.ref.ReferenceQueue;

public class WeakIdentityHashMap<K, V> extends AbstractHashTable<WeakHashNode<K, V>, K, V>
{
    ReferenceQueue<K> rqueue;
    
    public WeakIdentityHashMap() {
        super(64);
        this.rqueue = new ReferenceQueue<K>();
    }
    
    public WeakIdentityHashMap(final int capacity) {
        super(capacity);
        this.rqueue = new ReferenceQueue<K>();
    }
    
    @Override
    protected int getEntryHashCode(final WeakHashNode<K, V> entry) {
        return entry.hash;
    }
    
    @Override
    protected WeakHashNode<K, V> getEntryNext(final WeakHashNode<K, V> entry) {
        return entry.next;
    }
    
    @Override
    protected void setEntryNext(final WeakHashNode<K, V> entry, final WeakHashNode<K, V> next) {
        entry.next = next;
    }
    
    @Override
    protected WeakHashNode<K, V>[] allocEntries(final int n) {
        return (WeakHashNode<K, V>[])new WeakHashNode[n];
    }
    
    @Override
    public int hash(final Object key) {
        return System.identityHashCode(key);
    }
    
    @Override
    protected boolean matches(final K key1, final Object key2) {
        return key1 == key2;
    }
    
    @Override
    protected WeakHashNode<K, V> makeEntry(final K key, final int hash, final V value) {
        final WeakHashNode<K, V> node = new WeakHashNode<K, V>(key, this.rqueue, hash);
        node.value = value;
        return node;
    }
    
    @Override
    public V get(final Object key, final V defaultValue) {
        this.cleanup();
        return super.get(key, defaultValue);
    }
    
    @Override
    public V put(final K key, final int hash, final V value) {
        this.cleanup();
        return super.put(key, hash, value);
    }
    
    @Override
    public V remove(final Object key) {
        this.cleanup();
        return super.remove(key);
    }
    
    void cleanup() {
        AbstractWeakHashTable.cleanup((AbstractHashTable<Map.Entry, ?, ?>)this, this.rqueue);
    }
}
