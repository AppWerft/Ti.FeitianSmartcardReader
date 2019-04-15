/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import gnu.kawa.util.AbstractHashTable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract class AbstractWeakHashTable<K, V>
extends AbstractHashTable<WEntry<K, V>, K, V> {
    ReferenceQueue<V> rqueue = new ReferenceQueue();

    public AbstractWeakHashTable() {
        super(64);
    }

    public AbstractWeakHashTable(int capacity) {
        super(capacity);
    }

    protected abstract K getKeyFromValue(V var1);

    @Override
    protected int getEntryHashCode(WEntry<K, V> entry) {
        return entry.hash;
    }

    @Override
    protected WEntry<K, V> getEntryNext(WEntry<K, V> entry) {
        return entry.next;
    }

    @Override
    protected void setEntryNext(WEntry<K, V> entry, WEntry<K, V> next) {
        entry.next = next;
    }

    protected WEntry<K, V>[] allocEntries(int n) {
        return new WEntry[n];
    }

    protected V getValueIfMatching(WEntry<K, V> node, Object key) {
        V val = node.getValue();
        if (val != null && this.matches(this.getKeyFromValue(val), key)) {
            return val;
        }
        return null;
    }

    @Override
    public V get(Object key, V defaultValue) {
        this.cleanup();
        return super.get(key, defaultValue);
    }

    @Override
    public int hash(Object key) {
        return System.identityHashCode(key);
    }

    protected boolean valuesEqual(V oldValue, V newValue) {
        return oldValue == newValue;
    }

    @Override
    protected WEntry<K, V> makeEntry(K key, int hash, V value) {
        return new WEntry<K, V>(value, this, hash);
    }

    @Override
    public V put(K key, V value) {
        WEntry first;
        this.cleanup();
        int hash = this.hash(key);
        int index = this.hashToIndex(hash);
        Map.Entry<K, V> node = first = ((WEntry[])this.table)[index];
        WEntry prev = null;
        V oldValue = null;
        do {
            if (node == null) {
                if (++this.num_bindings >= ((WEntry[])this.table).length) {
                    this.rehash();
                    index = this.hashToIndex(hash);
                    first = ((WEntry[])this.table)[index];
                }
                node = this.makeEntry((Object)null, hash, (Object)value);
                node.next = first;
                ((WEntry[])this.table)[index] = node;
                return oldValue;
            }
            V curValue = node.getValue();
            if (curValue == value) {
                return curValue;
            }
            WEntry next = node.next;
            if (curValue != null && this.valuesEqual(curValue, value)) {
                if (prev == null) {
                    ((WEntry[])this.table)[index] = next;
                } else {
                    prev.next = next;
                }
                oldValue = curValue;
            } else {
                prev = node;
            }
            node = next;
        } while (true);
    }

    protected void cleanup() {
        AbstractWeakHashTable.cleanup(this, this.rqueue);
    }

    static <Entry extends Map.Entry<K, V>, K, V> void cleanup(AbstractHashTable<Entry, ?, ?> map, ReferenceQueue<?> rqueue) {
        Map.Entry oldref;
        while ((oldref = (Map.Entry)((Object)rqueue.poll())) != null) {
            int index = map.hashToIndex(map.getEntryHashCode(oldref));
            Entry prev = null;
            Entry node = map.table[index];
            while (node != null) {
                Entry next = map.getEntryNext((Map.Entry)node);
                if (node == oldref) {
                    if (prev == null) {
                        map.table[index] = next;
                        break;
                    }
                    map.setEntryNext((Map.Entry)prev, (Map.Entry)next);
                    break;
                }
                prev = node;
                node = next;
            }
            --map.num_bindings;
        }
    }

    public static class WEntry<K, V>
    extends WeakReference<V>
    implements Map.Entry<K, V> {
        public WEntry next;
        public int hash;
        AbstractWeakHashTable<K, V> htable;

        public WEntry(V value, AbstractWeakHashTable<K, V> htable, int hash) {
            super(value, htable.rqueue);
            this.htable = htable;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            Object v = this.get();
            return v == null ? null : (K)this.htable.getKeyFromValue(v);
        }

        @Override
        public V getValue() {
            return (V)this.get();
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }
    }

}

