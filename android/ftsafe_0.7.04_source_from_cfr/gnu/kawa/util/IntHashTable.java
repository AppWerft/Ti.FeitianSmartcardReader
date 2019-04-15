/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

public class IntHashTable {
    private static final int DEFAULT_INITIAL_SIZE = 64;
    protected Object[] objs;
    protected int[] ints;
    protected int mask;
    protected int num_bindings;
    private static Object DELETED = new Object();

    public IntHashTable() {
        this.objs = new Object[64];
        this.ints = new int[64];
        this.mask = 63;
    }

    public IntHashTable(int capacity) {
        int log2Size = 4;
        while (capacity > 1 << log2Size) {
            ++log2Size;
        }
        capacity = 1 << log2Size;
        this.objs = new Object[capacity];
        this.ints = new int[capacity];
        this.mask = capacity - 1;
    }

    public int hash(Object key) {
        return System.identityHashCode(key);
    }

    public int lookup(Object key, int hash) {
        int hash1 = hash ^ hash >>> 15;
        int hash2 = hash ^ hash << 6 | 1;
        int deleted = -1;
        int i = hash1 & this.mask;
        Object node;
        while ((node = this.objs[i]) != key) {
            if (node == null) {
                return deleted >= 0 ? deleted : i;
            }
            if (node == DELETED && deleted < 0) {
                deleted = i;
            }
            i = i + hash2 & this.mask;
        }
        return i;
    }

    public int lookup(Object key) {
        return this.lookup(key, this.hash(key));
    }

    public int getFromIndex(int index) {
        Object node = this.objs[index];
        return node == null || node == DELETED ? -1 : this.ints[index];
    }

    public int putAtIndex(Object key, int value, int index) {
        Object old = this.objs[index];
        if (old == null || old == DELETED) {
            this.objs[index] = key;
            this.ints[index] = value;
            if (old != DELETED) {
                ++this.num_bindings;
            }
            if (3 * this.num_bindings >= 2 * this.objs.length) {
                this.rehash();
            }
            return -1;
        }
        int oldValue = this.ints[index];
        this.ints[index] = value;
        return oldValue;
    }

    public int remove(Object key) {
        int index = this.lookup(key);
        Object old = this.objs[index];
        if (old == null || old == DELETED) {
            return -1;
        }
        this.objs[index] = DELETED;
        return this.ints[index];
    }

    protected void rehash() {
        Object[] oldObjsTable = this.objs;
        int[] oldIntsTable = this.ints;
        int oldCapacity = oldObjsTable.length;
        int newCapacity = oldCapacity << 1;
        Object[] newObjTable = new Object[newCapacity];
        int[] newIntTable = new int[newCapacity];
        int newMask = newCapacity - 1;
        this.objs = newObjTable;
        this.ints = newIntTable;
        this.mask = newMask;
        this.num_bindings = 0;
        int i = oldIntsTable.length;
        while (--i >= 0) {
            Object key = oldObjsTable[i];
            if (key == null || key == DELETED) continue;
            this.putAtIndex(key, oldIntsTable[i], this.lookup(key, this.hash(key)));
        }
    }

    public void clear() {
        int i = this.objs.length;
        while (--i >= 0) {
            this.objs[i] = null;
        }
        this.num_bindings = 0;
    }
}

