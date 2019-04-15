/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AbstractHashTable<Entry extends Map.Entry<K, V>, K, V>
extends AbstractMap<K, V> {
    protected Entry[] table;
    protected int mask;
    protected int num_bindings;
    public static final int DEFAULT_INITIAL_SIZE = 64;

    protected abstract int getEntryHashCode(Entry var1);

    protected abstract Entry getEntryNext(Entry var1);

    protected abstract void setEntryNext(Entry var1, Entry var2);

    protected abstract Entry[] allocEntries(int var1);

    public AbstractHashTable() {
        this(64);
    }

    public AbstractHashTable(int capacity) {
        int log2Size = 4;
        while (capacity > 1 << log2Size) {
            ++log2Size;
        }
        capacity = 1 << log2Size;
        this.table = this.allocEntries(capacity);
        this.mask = capacity - 1;
    }

    protected abstract Entry makeEntry(K var1, int var2, V var3);

    public int hash(Object key) {
        return key == null ? 0 : key.hashCode();
    }

    protected int hashToIndex(int hash) {
        hash ^= hash >>> 15;
        return hash & this.mask;
    }

    protected boolean matches(Object key, int hash, Entry node) {
        return this.getEntryHashCode(node) == hash && this.matches(node.getKey(), key);
    }

    protected boolean matches(K key1, Object key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }

    @Override
    public V get(Object key) {
        return this.get(key, null);
    }

    public Entry getNode(Object key) {
        int hash = this.hash(key);
        int index = this.hashToIndex(hash);
        Entry node = this.table[index];
        while (node != null) {
            if (this.matches(key, hash, node)) {
                return node;
            }
            node = this.getEntryNext(node);
        }
        return null;
    }

    public V get(Object key, V defaultValue) {
        Entry node = this.getNode(key);
        return node == null ? defaultValue : node.getValue();
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return this.get(key, defaultValue);
    }

    protected void rehash() {
        Entry[] oldTable = this.table;
        int oldCapacity = oldTable.length;
        int newCapacity = 2 * oldCapacity;
        Map.Entry[] newTable = this.allocEntries(newCapacity);
        int newMask = newCapacity - 1;
        this.table = newTable;
        this.mask = newMask;
        int i = oldCapacity;
        while (--i >= 0) {
            Entry chain = oldTable[i];
            if (chain != null && this.getEntryNext(chain) != null) {
                Entry prev = null;
                do {
                    Entry node = chain;
                    chain = this.getEntryNext(node);
                    this.setEntryNext(node, prev);
                    prev = node;
                } while (chain != null);
                chain = prev;
            }
            Entry element = chain;
            while (element != null) {
                Entry next = this.getEntryNext(element);
                int hash = this.getEntryHashCode(element);
                int j = this.hashToIndex(hash);
                Map.Entry head = newTable[j];
                this.setEntryNext(element, head);
                newTable[j] = element;
                element = next;
            }
        }
    }

    @Override
    public V put(K key, V value) {
        return this.put(key, this.hash(key), value);
    }

    public V put(K key, int hash, V value) {
        Entry first;
        int index = this.hashToIndex(hash);
        Entry node = first = this.table[index];
        do {
            if (node == null) {
                if (++this.num_bindings >= this.table.length) {
                    this.rehash();
                    index = this.hashToIndex(hash);
                    first = this.table[index];
                }
                node = this.makeEntry(key, hash, value);
                this.setEntryNext(node, first);
                this.table[index] = node;
                return null;
            }
            if (this.matches(key, hash, node)) {
                V oldValue = node.getValue();
                node.setValue(value);
                return oldValue;
            }
            node = this.getEntryNext(node);
        } while (true);
    }

    @Override
    public V remove(Object key) {
        int hash = this.hash(key);
        int index = this.hashToIndex(hash);
        Entry prev = null;
        Entry node = this.table[index];
        while (node != null) {
            Entry next = this.getEntryNext(node);
            if (this.matches(key, hash, node)) {
                if (prev == null) {
                    this.table[index] = next;
                } else {
                    this.setEntryNext(prev, next);
                }
                --this.num_bindings;
                return node.getValue();
            }
            prev = node;
            node = next;
        }
        return null;
    }

    @Override
    public void clear() {
        Entry[] t = this.table;
        int i = t.length;
        while (--i >= 0) {
            Entry e = t[i];
            while (e != null) {
                Entry next = this.getEntryNext(e);
                this.setEntryNext(e, null);
                e = next;
            }
            t[i] = null;
        }
        this.num_bindings = 0;
    }

    @Override
    public int size() {
        return this.num_bindings;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new AbstractEntrySet<Entry, K, V>(this);
    }

    static class AbstractEntrySet<Entry extends Map.Entry<K, V>, K, V>
    extends AbstractSet<Entry> {
        AbstractHashTable<Entry, K, V> htable;

        public AbstractEntrySet(AbstractHashTable<Entry, K, V> htable) {
            this.htable = htable;
        }

        @Override
        public int size() {
            return this.htable.size();
        }

        @Override
        public Iterator<Entry> iterator() {
            return new Iterator<Entry>(){
                int nextIndex;
                Entry previousEntry;
                Entry currentEntry;
                Entry nextEntry;
                int curIndex = -1;

                @Override
                public boolean hasNext() {
                    if (this.curIndex < 0) {
                        this.curIndex = this.nextIndex = AbstractEntrySet.this.htable.table.length;
                        this.advance();
                    }
                    return this.nextEntry != null;
                }

                private void advance() {
                    while (this.nextEntry == null && --this.nextIndex >= 0) {
                        this.nextEntry = AbstractEntrySet.this.htable.table[this.nextIndex];
                    }
                }

                @Override
                public Entry next() {
                    if (this.nextEntry == null) {
                        throw new NoSuchElementException();
                    }
                    this.previousEntry = this.currentEntry;
                    this.currentEntry = this.nextEntry;
                    this.curIndex = this.nextIndex;
                    this.nextEntry = AbstractEntrySet.this.htable.getEntryNext(this.currentEntry);
                    this.advance();
                    return this.currentEntry;
                }

                @Override
                public void remove() {
                    if (this.previousEntry == this.currentEntry) {
                        throw new IllegalStateException();
                    }
                    if (this.previousEntry == null) {
                        AbstractEntrySet.this.htable.table[this.curIndex] = this.nextEntry;
                    } else {
                        AbstractEntrySet.this.htable.setEntryNext(this.previousEntry, this.nextEntry);
                    }
                    --AbstractEntrySet.this.htable.num_bindings;
                    this.previousEntry = this.currentEntry;
                }
            };
        }

    }

}

