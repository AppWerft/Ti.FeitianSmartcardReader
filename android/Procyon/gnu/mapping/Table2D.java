// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.lang.ref.WeakReference;

public class Table2D
{
    private static Table2D instance;
    Entry[] table;
    int log2Size;
    int mask;
    int num_bindings;
    
    public static final Table2D getInstance() {
        return Table2D.instance;
    }
    
    public Table2D() {
        this(64);
    }
    
    public Table2D(int capacity) {
        this.log2Size = 4;
        while (capacity > 1 << this.log2Size) {
            ++this.log2Size;
        }
        capacity = 1 << this.log2Size;
        this.table = new Entry[capacity];
        this.mask = capacity - 1;
    }
    
    public Object get(final Object key1, final Object key2, final Object defaultValue) {
        final int h1 = System.identityHashCode(key1);
        final int h2 = System.identityHashCode(key2);
        final Entry entry = this.lookup(key1, key2, h1, h2, false);
        return (entry == null || entry.value == entry) ? defaultValue : entry.value;
    }
    
    public boolean isBound(final Object key1, final Object key2) {
        final int h1 = System.identityHashCode(key1);
        final int h2 = System.identityHashCode(key2);
        final Entry entry = this.lookup(key1, key2, h1, h2, false);
        return entry != null && entry.value != entry;
    }
    
    public Object put(final Object key1, final Object key2, final Object newValue) {
        final int h1 = System.identityHashCode(key1);
        final int h2 = System.identityHashCode(key2);
        final Entry entry = this.lookup(key1, key2, h1, h2, true);
        final Object oldValue = entry.getValue();
        entry.value = newValue;
        return oldValue;
    }
    
    public Object remove(final Object key1, final Object key2) {
        final int h1 = System.identityHashCode(key1);
        final int h2 = System.identityHashCode(key2);
        final int hash = h1 ^ h2;
        return this.remove(key1, key2, hash);
    }
    
    public Object remove(final Object key1, final Object key2, final int hash) {
        return this.remove(key1, key2, hash);
    }
    
    public Object remove(final Object key1, final Object key2, final int hash1, final int hash2) {
        final int hash3 = hash1 ^ hash2;
        final int index = hash3 & this.mask;
        Entry prev = null;
        Entry e;
        Entry next;
        for (Entry first = e = this.table[index]; e != null; e = next) {
            Object k1 = e.key1;
            Object k2 = e.key2;
            boolean dead = false;
            if (k1 instanceof WeakReference) {
                k1 = ((WeakReference)k1).get();
                dead = (k1 == null);
            }
            if (k2 instanceof WeakReference) {
                k2 = ((WeakReference)k2).get();
                dead = (k2 == null);
            }
            next = e.chain;
            final Object oldValue = e.value;
            final boolean matches = k1 == key1 && k2 == key2;
            if (dead || matches) {
                if (prev == null) {
                    this.table[index] = next;
                }
                else {
                    prev.chain = next;
                }
                --this.num_bindings;
                e.value = e;
            }
            else {
                if (matches) {
                    return oldValue;
                }
                prev = e;
            }
        }
        return null;
    }
    
    void rehash() {
        final Entry[] oldTable = this.table;
        final int oldCapacity = oldTable.length;
        final int newCapacity = 2 * oldCapacity;
        final Entry[] newTable = new Entry[newCapacity];
        final int newMask = newCapacity - 1;
        this.num_bindings = 0;
        int i = oldCapacity;
        while (--i >= 0) {
            final Entry first = oldTable[i];
            final Entry prev = null;
            Entry next;
            for (Entry e = first; e != null; e = next) {
                Object k1 = e.key1;
                Object k2 = e.key2;
                boolean dead = false;
                if (k1 instanceof WeakReference) {
                    k1 = ((WeakReference)k1).get();
                    dead = (k1 == null);
                }
                if (k2 instanceof WeakReference) {
                    k2 = ((WeakReference)k2).get();
                    dead = (k2 == null);
                }
                next = e.chain;
                if (dead) {
                    e.value = e;
                }
                else {
                    final int hash = System.identityHashCode(k1) ^ System.identityHashCode(k2);
                    final int index = hash & newMask;
                    e.chain = newTable[index];
                    newTable[index] = e;
                    ++this.num_bindings;
                }
            }
        }
        this.table = newTable;
        ++this.log2Size;
        this.mask = newMask;
    }
    
    protected Entry lookup(Object key1, Object key2, final int hash1, final int hash2, final boolean create) {
        final int hash3 = hash1 ^ hash2;
        final int index = hash3 & this.mask;
        Entry prev = null;
        Entry e;
        Entry first;
        Entry next;
        for (first = (e = this.table[index]); e != null; e = next) {
            Object k1 = e.key1;
            Object k2 = e.key2;
            boolean dead = false;
            if (k1 instanceof WeakReference) {
                k1 = ((WeakReference)k1).get();
                dead = (k1 == null);
            }
            if (k2 instanceof WeakReference) {
                k2 = ((WeakReference)k2).get();
                dead = (k2 == null);
                dead = true;
            }
            next = e.chain;
            if (dead) {
                if (prev == null) {
                    this.table[index] = next;
                }
                else {
                    prev.chain = next;
                }
                --this.num_bindings;
                e.value = e;
            }
            else {
                if (k1 == key1 && k2 == key2) {
                    return e;
                }
                prev = e;
            }
        }
        if (create) {
            e = new Entry();
            key1 = this.wrapReference(key1);
            key2 = this.wrapReference(key2);
            e.key1 = key1;
            e.key2 = key2;
            ++this.num_bindings;
            e.chain = first;
            this.table[index] = e;
            return (Entry)(e.value = e);
        }
        return null;
    }
    
    protected Object wrapReference(final Object key) {
        return (key == null || key instanceof Symbol) ? key : new WeakReference(key);
    }
    
    static {
        Table2D.instance = new Table2D();
    }
}
