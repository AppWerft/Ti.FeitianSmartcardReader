// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public abstract class CpoolEntry
{
    int hash;
    public int index;
    CpoolEntry next;
    
    public int getIndex() {
        return this.index;
    }
    
    public abstract int getTag();
    
    @Override
    public int hashCode() {
        return this.hash;
    }
    
    abstract void write(final DataOutputStream p0) throws IOException;
    
    void add_hashed(final ConstantPool cpool) {
        final CpoolEntry[] hashTab = cpool.hashTab;
        final int index = (this.hash & Integer.MAX_VALUE) % hashTab.length;
        this.next = hashTab[index];
        hashTab[index] = this;
    }
    
    protected CpoolEntry() {
    }
    
    public CpoolEntry(final ConstantPool cpool, final int h) {
        this.hash = h;
        if (cpool.locked) {
            throw new Error("adding new entry to locked contant pool");
        }
        this.index = ++cpool.count;
        if (cpool.pool == null) {
            cpool.pool = new CpoolEntry[60];
        }
        else if (this.index >= cpool.pool.length) {
            final int old_size = cpool.pool.length;
            final int new_size = 2 * cpool.pool.length;
            final CpoolEntry[] new_pool = new CpoolEntry[new_size];
            for (int i = 0; i < old_size; ++i) {
                new_pool[i] = cpool.pool[i];
            }
            cpool.pool = new_pool;
        }
        if (cpool.hashTab == null || this.index >= 0.6 * cpool.hashTab.length) {
            cpool.rehash();
        }
        (cpool.pool[this.index] = this).add_hashed(cpool);
    }
    
    public abstract void print(final ClassTypeWriter p0, final int p1);
}
