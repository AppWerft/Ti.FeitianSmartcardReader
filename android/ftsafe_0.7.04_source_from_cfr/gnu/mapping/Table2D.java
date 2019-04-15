/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Entry;
import gnu.mapping.Symbol;
import java.lang.ref.WeakReference;

public class Table2D {
    private static Table2D instance = new Table2D();
    Entry[] table;
    int log2Size = 4;
    int mask;
    int num_bindings;

    public static final Table2D getInstance() {
        return instance;
    }

    public Table2D() {
        this(64);
    }

    public Table2D(int capacity) {
        while (capacity > 1 << this.log2Size) {
            ++this.log2Size;
        }
        capacity = 1 << this.log2Size;
        this.table = new Entry[capacity];
        this.mask = capacity - 1;
    }

    public Object get(Object key1, Object key2, Object defaultValue) {
        int h2;
        int h1 = System.identityHashCode(key1);
        Entry entry = this.lookup(key1, key2, h1, h2 = System.identityHashCode(key2), false);
        return entry == null || entry.value == entry ? defaultValue : entry.value;
    }

    public boolean isBound(Object key1, Object key2) {
        int h2;
        int h1 = System.identityHashCode(key1);
        Entry entry = this.lookup(key1, key2, h1, h2 = System.identityHashCode(key2), false);
        return entry != null && entry.value != entry;
    }

    public Object put(Object key1, Object key2, Object newValue) {
        int h1 = System.identityHashCode(key1);
        int h2 = System.identityHashCode(key2);
        Entry entry = this.lookup(key1, key2, h1, h2, true);
        Object oldValue = entry.getValue();
        entry.value = newValue;
        return oldValue;
    }

    public Object remove(Object key1, Object key2) {
        int h1 = System.identityHashCode(key1);
        int h2 = System.identityHashCode(key2);
        int hash = h1 ^ h2;
        return this.remove(key1, key2, hash);
    }

    public Object remove(Object key1, Object key2, int hash) {
        return this.remove(key1, key2, hash);
    }

    public Object remove(Object key1, Object key2, int hash1, int hash2) {
        Entry first;
        int hash = hash1 ^ hash2;
        int index = hash & this.mask;
        Entry prev = null;
        Entry e = first = this.table[index];
        while (e != null) {
            boolean matches;
            Object k1 = e.key1;
            Object k2 = e.key2;
            boolean dead = false;
            if (k1 instanceof WeakReference) {
                boolean bl = dead = (k1 = ((WeakReference)k1).get()) == null;
            }
            if (k2 instanceof WeakReference) {
                dead = (k2 = ((WeakReference)k2).get()) == null;
            }
            Entry next = e.chain;
            Object oldValue = e.value;
            boolean bl = matches = k1 == key1 && k2 == key2;
            if (dead || matches) {
                if (prev == null) {
                    this.table[index] = next;
                } else {
                    prev.chain = next;
                }
                --this.num_bindings;
                e.value = e;
            } else {
                if (matches) {
                    return oldValue;
                }
                prev = e;
            }
            e = next;
        }
        return null;
    }

    void rehash() {
        Entry[] oldTable = this.table;
        int oldCapacity = oldTable.length;
        int newCapacity = 2 * oldCapacity;
        Entry[] newTable = new Entry[newCapacity];
        int newMask = newCapacity - 1;
        this.num_bindings = 0;
        int i = oldCapacity;
        while (--i >= 0) {
            Entry first = oldTable[i];
            Object prev = null;
            Entry e = first;
            while (e != null) {
                Object k1 = e.key1;
                Object k2 = e.key2;
                boolean dead = false;
                if (k1 instanceof WeakReference) {
                    boolean bl = dead = (k1 = ((WeakReference)k1).get()) == null;
                }
                if (k2 instanceof WeakReference) {
                    dead = (k2 = ((WeakReference)k2).get()) == null;
                }
                Entry next = e.chain;
                if (dead) {
                    e.value = e;
                } else {
                    int hash = System.identityHashCode(k1) ^ System.identityHashCode(k2);
                    int index = hash & newMask;
                    e.chain = newTable[index];
                    newTable[index] = e;
                    ++this.num_bindings;
                }
                e = next;
            }
        }
        this.table = newTable;
        ++this.log2Size;
        this.mask = newMask;
    }

    protected Entry lookup(Object key1, Object key2, int hash1, int hash2, boolean create) {
        Entry first;
        int hash = hash1 ^ hash2;
        int index = hash & this.mask;
        Entry prev = null;
        Entry e = first = this.table[index];
        while (e != null) {
            Object k1 = e.key1;
            Object k2 = e.key2;
            boolean dead = false;
            if (k1 instanceof WeakReference) {
                boolean bl = dead = (k1 = ((WeakReference)k1).get()) == null;
            }
            if (k2 instanceof WeakReference) {
                dead = (k2 = ((WeakReference)k2).get()) == null;
                dead = true;
            }
            Entry next = e.chain;
            if (dead) {
                if (prev == null) {
                    this.table[index] = next;
                } else {
                    prev.chain = next;
                }
                --this.num_bindings;
                e.value = e;
            } else {
                if (k1 == key1 && k2 == key2) {
                    return e;
                }
                prev = e;
            }
            e = next;
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
            e.value = e;
            return e;
        }
        return null;
    }

    protected Object wrapReference(Object key) {
        return key == null || key instanceof Symbol ? key : new WeakReference<Object>(key);
    }
}

