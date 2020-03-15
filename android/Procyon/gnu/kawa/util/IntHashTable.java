// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

public class IntHashTable
{
    private static final int DEFAULT_INITIAL_SIZE = 64;
    protected Object[] objs;
    protected int[] ints;
    protected int mask;
    protected int num_bindings;
    private static Object DELETED;
    
    public IntHashTable() {
        this.objs = new Object[64];
        this.ints = new int[64];
        this.mask = 63;
    }
    
    public IntHashTable(int capacity) {
        int log2Size;
        for (log2Size = 4; capacity > 1 << log2Size; ++log2Size) {}
        capacity = 1 << log2Size;
        this.objs = new Object[capacity];
        this.ints = new int[capacity];
        this.mask = capacity - 1;
    }
    
    public int hash(final Object key) {
        return System.identityHashCode(key);
    }
    
    public int lookup(final Object key, final int hash) {
        final int hash2 = hash ^ hash >>> 15;
        final int hash3 = (hash ^ hash << 6) | 0x1;
        int deleted = -1;
        int i = hash2 & this.mask;
        while (true) {
            final Object node = this.objs[i];
            if (node == key) {
                return i;
            }
            if (node == null) {
                return (deleted >= 0) ? deleted : i;
            }
            if (node == IntHashTable.DELETED && deleted < 0) {
                deleted = i;
            }
            i = (i + hash3 & this.mask);
        }
    }
    
    public int lookup(final Object key) {
        return this.lookup(key, this.hash(key));
    }
    
    public int getFromIndex(final int index) {
        final Object node = this.objs[index];
        return (node == null || node == IntHashTable.DELETED) ? -1 : this.ints[index];
    }
    
    public int putAtIndex(final Object key, final int value, final int index) {
        final Object old = this.objs[index];
        if (old == null || old == IntHashTable.DELETED) {
            this.objs[index] = key;
            this.ints[index] = value;
            if (old != IntHashTable.DELETED) {
                ++this.num_bindings;
            }
            if (3 * this.num_bindings >= 2 * this.objs.length) {
                this.rehash();
            }
            return -1;
        }
        final int oldValue = this.ints[index];
        this.ints[index] = value;
        return oldValue;
    }
    
    public int remove(final Object key) {
        final int index = this.lookup(key);
        final Object old = this.objs[index];
        if (old == null || old == IntHashTable.DELETED) {
            return -1;
        }
        this.objs[index] = IntHashTable.DELETED;
        return this.ints[index];
    }
    
    protected void rehash() {
        final Object[] oldObjsTable = this.objs;
        final int[] oldIntsTable = this.ints;
        final int oldCapacity = oldObjsTable.length;
        final int newCapacity = oldCapacity << 1;
        final Object[] newObjTable = new Object[newCapacity];
        final int[] newIntTable = new int[newCapacity];
        final int newMask = newCapacity - 1;
        this.objs = newObjTable;
        this.ints = newIntTable;
        this.mask = newMask;
        this.num_bindings = 0;
        int i = oldIntsTable.length;
        while (--i >= 0) {
            final Object key = oldObjsTable[i];
            if (key != null && key != IntHashTable.DELETED) {
                this.putAtIndex(key, oldIntsTable[i], this.lookup(key, this.hash(key)));
            }
        }
    }
    
    public void clear() {
        int i = this.objs.length;
        while (--i >= 0) {
            this.objs[i] = null;
        }
        this.num_bindings = 0;
    }
    
    static {
        IntHashTable.DELETED = new Object();
    }
}
