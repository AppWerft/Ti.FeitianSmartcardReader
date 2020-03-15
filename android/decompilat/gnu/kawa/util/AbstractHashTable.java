// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.AbstractSet;
import java.util.Set;
import java.util.AbstractMap;
import java.util.Map;

public abstract class AbstractHashTable<Entry extends Map.Entry<K, V>, K, V> extends AbstractMap<K, V>
{
    protected Entry[] table;
    protected int mask;
    protected int num_bindings;
    public static final int DEFAULT_INITIAL_SIZE = 64;
    
    protected abstract int getEntryHashCode(final Entry p0);
    
    protected abstract Entry getEntryNext(final Entry p0);
    
    protected abstract void setEntryNext(final Entry p0, final Entry p1);
    
    protected abstract Entry[] allocEntries(final int p0);
    
    public AbstractHashTable() {
        this(64);
    }
    
    public AbstractHashTable(int capacity) {
        int log2Size;
        for (log2Size = 4; capacity > 1 << log2Size; ++log2Size) {}
        capacity = 1 << log2Size;
        this.table = this.allocEntries(capacity);
        this.mask = capacity - 1;
    }
    
    protected abstract Entry makeEntry(final K p0, final int p1, final V p2);
    
    public int hash(final Object key) {
        return (key == null) ? 0 : key.hashCode();
    }
    
    protected int hashToIndex(int hash) {
        hash ^= hash >>> 15;
        return hash & this.mask;
    }
    
    protected boolean matches(final Object key, final int hash, final Entry node) {
        return this.getEntryHashCode(node) == hash && this.matches(((Map.Entry<K, V>)node).getKey(), key);
    }
    
    protected boolean matches(final K key1, final Object key2) {
        return key1 == key2 || (key1 != null && key1.equals(key2));
    }
    
    @Override
    public V get(final Object key) {
        return this.get(key, null);
    }
    
    public Entry getNode(final Object key) {
        final int hash = this.hash(key);
        final int index = this.hashToIndex(hash);
        for (Entry node = this.table[index]; node != null; node = this.getEntryNext(node)) {
            if (this.matches(key, hash, node)) {
                return node;
            }
        }
        return null;
    }
    
    public V get(final Object key, final V defaultValue) {
        final Entry node = this.getNode(key);
        return (node == null) ? defaultValue : ((Map.Entry<K, V>)node).getValue();
    }
    
    @Override
    public V getOrDefault(final Object key, final V defaultValue) {
        return this.get(key, defaultValue);
    }
    
    protected void rehash() {
        final Entry[] oldTable = this.table;
        final int oldCapacity = oldTable.length;
        final int newCapacity = 2 * oldCapacity;
        final Entry[] newTable = this.allocEntries(newCapacity);
        final int newMask = newCapacity - 1;
        this.table = newTable;
        this.mask = newMask;
        int i = oldCapacity;
        while (--i >= 0) {
            Entry chain = oldTable[i];
            if (chain != null && this.getEntryNext(chain) != null) {
                Entry prev = null;
                do {
                    final Entry node = chain;
                    chain = this.getEntryNext(node);
                    this.setEntryNext(node, prev);
                    prev = node;
                } while (chain != null);
                chain = prev;
            }
            Entry next;
            for (Entry element = chain; element != null; element = next) {
                next = this.getEntryNext(element);
                final int hash = this.getEntryHashCode(element);
                final int j = this.hashToIndex(hash);
                final Entry head = newTable[j];
                this.setEntryNext(element, head);
                newTable[j] = element;
            }
        }
    }
    
    @Override
    public V put(final K key, final V value) {
        return this.put(key, this.hash(key), value);
    }
    
    public V put(final K key, final int hash, final V value) {
        int index = this.hashToIndex(hash);
        Entry node;
        Entry first;
        for (first = (node = this.table[index]); node != null; node = this.getEntryNext(node)) {
            if (this.matches(key, hash, node)) {
                final V oldValue = ((Map.Entry<K, V>)node).getValue();
                ((Map.Entry<K, V>)node).setValue(value);
                return oldValue;
            }
        }
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
    
    @Override
    public V remove(final Object key) {
        final int hash = this.hash(key);
        final int index = this.hashToIndex(hash);
        Entry prev = null;
        Entry next;
        for (Entry node = this.table[index]; node != null; node = next) {
            next = this.getEntryNext(node);
            if (this.matches(key, hash, node)) {
                if (prev == null) {
                    this.table[index] = next;
                }
                else {
                    this.setEntryNext(prev, next);
                }
                --this.num_bindings;
                return ((Map.Entry<K, V>)node).getValue();
            }
            prev = node;
        }
        return null;
    }
    
    @Override
    public void clear() {
        final Entry[] t = this.table;
        int i = t.length;
        while (--i >= 0) {
            Entry next;
            for (Entry e = t[i]; e != null; e = next) {
                next = this.getEntryNext(e);
                this.setEntryNext(e, null);
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
        return (Set<Map.Entry<K, V>>)new AbstractEntrySet((AbstractHashTable<Map.Entry, Object, Object>)this);
    }
    
    static class AbstractEntrySet<Entry extends Map.Entry<K, V>, K, V> extends AbstractSet<Entry>
    {
        AbstractHashTable<Entry, K, V> htable;
        
        public AbstractEntrySet(final AbstractHashTable<Entry, K, V> htable) {
            this.htable = htable;
        }
        
        @Override
        public int size() {
            return this.htable.size();
        }
        
        @Override
        public Iterator<Entry> iterator() {
            return new Iterator<Entry>() {
                int nextIndex;
                Entry previousEntry;
                Entry currentEntry;
                Entry nextEntry;
                int curIndex = -1;
                
                @Override
                public boolean hasNext() {
                    if (this.curIndex < 0) {
                        this.nextIndex = AbstractEntrySet.this.htable.table.length;
                        this.curIndex = this.nextIndex;
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
                    }
                    else {
                        AbstractEntrySet.this.htable.setEntryNext(this.previousEntry, this.nextEntry);
                    }
                    final AbstractHashTable<Entry, K, V> htable = AbstractEntrySet.this.htable;
                    --htable.num_bindings;
                    this.previousEntry = this.currentEntry;
                }
            };
        }
    }
}
