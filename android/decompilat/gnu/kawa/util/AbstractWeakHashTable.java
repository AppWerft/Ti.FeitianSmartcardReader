// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.lang.ref.ReferenceQueue;

public abstract class AbstractWeakHashTable<K, V> extends AbstractHashTable<WEntry<K, V>, K, V>
{
    ReferenceQueue<V> rqueue;
    
    public AbstractWeakHashTable() {
        super(64);
        this.rqueue = new ReferenceQueue<V>();
    }
    
    public AbstractWeakHashTable(final int capacity) {
        super(capacity);
        this.rqueue = new ReferenceQueue<V>();
    }
    
    protected abstract K getKeyFromValue(final V p0);
    
    @Override
    protected int getEntryHashCode(final WEntry<K, V> entry) {
        return entry.hash;
    }
    
    @Override
    protected WEntry<K, V> getEntryNext(final WEntry<K, V> entry) {
        return entry.next;
    }
    
    @Override
    protected void setEntryNext(final WEntry<K, V> entry, final WEntry<K, V> next) {
        entry.next = next;
    }
    
    @Override
    protected WEntry<K, V>[] allocEntries(final int n) {
        return (WEntry<K, V>[])new WEntry[n];
    }
    
    protected V getValueIfMatching(final WEntry<K, V> node, final Object key) {
        final V val = node.getValue();
        if (val != null && this.matches(this.getKeyFromValue(val), key)) {
            return val;
        }
        return null;
    }
    
    @Override
    public V get(final Object key, final V defaultValue) {
        this.cleanup();
        return super.get(key, defaultValue);
    }
    
    @Override
    public int hash(final Object key) {
        return System.identityHashCode(key);
    }
    
    protected boolean valuesEqual(final V oldValue, final V newValue) {
        return oldValue == newValue;
    }
    
    @Override
    protected WEntry<K, V> makeEntry(final K key, final int hash, final V value) {
        return new WEntry<K, V>(value, this, hash);
    }
    
    @Override
    public V put(final K key, final V value) {
        this.cleanup();
        final int hash = this.hash(key);
        int index = this.hashToIndex(hash);
        WEntry<K, V> node;
        WEntry<K, V> first = node = (WEntry<K, V>)((WEntry[])this.table)[index];
        WEntry<K, V> prev = null;
        V oldValue = null;
        while (node != null) {
            final V curValue = node.getValue();
            if (curValue == value) {
                return curValue;
            }
            final WEntry<K, V> next = node.next;
            if (curValue != null && this.valuesEqual(curValue, value)) {
                if (prev == null) {
                    ((WEntry[])this.table)[index] = next;
                }
                else {
                    prev.next = next;
                }
                oldValue = curValue;
            }
            else {
                prev = node;
            }
            node = next;
        }
        if (++this.num_bindings >= ((WEntry[])this.table).length) {
            this.rehash();
            index = this.hashToIndex(hash);
            first = (WEntry<K, V>)((WEntry[])this.table)[index];
        }
        node = this.makeEntry(null, hash, value);
        node.next = first;
        ((WEntry[])this.table)[index] = node;
        return oldValue;
    }
    
    protected void cleanup() {
        cleanup((AbstractHashTable<Map.Entry, ?, ?>)this, this.rqueue);
    }
    
    static <Entry extends Map.Entry<K, V>, K, V> void cleanup(final AbstractHashTable<Entry, ?, ?> map, final ReferenceQueue<?> rqueue) {
        while (true) {
            final Entry oldref = (Entry)(Map.Entry)rqueue.poll();
            if (oldref == null) {
                break;
            }
            final int index = map.hashToIndex(map.getEntryHashCode(oldref));
            Entry prev = null;
            Entry node = map.table[index];
            while (node != null) {
                final Entry next = map.getEntryNext(node);
                if (node == oldref) {
                    if (prev == null) {
                        map.table[index] = next;
                        break;
                    }
                    map.setEntryNext(prev, next);
                    break;
                }
                else {
                    prev = node;
                    node = next;
                }
            }
            --map.num_bindings;
        }
    }
    
    public static class WEntry<K, V> extends WeakReference<V> implements Map.Entry<K, V>
    {
        public WEntry next;
        public int hash;
        AbstractWeakHashTable<K, V> htable;
        
        public WEntry(final V value, final AbstractWeakHashTable<K, V> htable, final int hash) {
            super(value, htable.rqueue);
            this.htable = htable;
            this.hash = hash;
        }
        
        @Override
        public K getKey() {
            final V v = this.get();
            return (v == null) ? null : this.htable.getKeyFromValue(v);
        }
        
        @Override
        public V getValue() {
            return this.get();
        }
        
        @Override
        public V setValue(final V value) {
            throw new UnsupportedOperationException();
        }
    }
}
