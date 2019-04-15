/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class CpoolEntry {
    int hash;
    public int index;
    CpoolEntry next;

    public int getIndex() {
        return this.index;
    }

    public abstract int getTag();

    public int hashCode() {
        return this.hash;
    }

    abstract void write(DataOutputStream var1) throws IOException;

    void add_hashed(ConstantPool cpool) {
        CpoolEntry[] hashTab = cpool.hashTab;
        int index = (this.hash & Integer.MAX_VALUE) % hashTab.length;
        this.next = hashTab[index];
        hashTab[index] = this;
    }

    protected CpoolEntry() {
    }

    public CpoolEntry(ConstantPool cpool, int h) {
        this.hash = h;
        if (cpool.locked) {
            throw new Error("adding new entry to locked contant pool");
        }
        this.index = ++cpool.count;
        if (cpool.pool == null) {
            cpool.pool = new CpoolEntry[60];
        } else if (this.index >= cpool.pool.length) {
            int old_size = cpool.pool.length;
            int new_size = 2 * cpool.pool.length;
            CpoolEntry[] new_pool = new CpoolEntry[new_size];
            for (int i = 0; i < old_size; ++i) {
                new_pool[i] = cpool.pool[i];
            }
            cpool.pool = new_pool;
        }
        if (cpool.hashTab == null || (double)this.index >= 0.6 * (double)cpool.hashTab.length) {
            cpool.rehash();
        }
        cpool.pool[this.index] = this;
        this.add_hashed(cpool);
    }

    public abstract void print(ClassTypeWriter var1, int var2);
}

