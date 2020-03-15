// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.util.Hashtable;

public class RangeTable implements Cloneable
{
    Object[] index;
    Hashtable hash;
    
    public RangeTable() {
        this.index = new Object[128];
        this.hash = new Hashtable(200);
    }
    
    public Object lookup(final int key, final Object defaultValue) {
        if ((key & 0x7F) == key) {
            return this.index[key];
        }
        return this.hash.get(new Integer(key));
    }
    
    public void set(final int lo, final int hi, final Object value) {
        if (lo > hi) {
            return;
        }
        int i = lo;
        while (true) {
            if ((i & 0x7F) == i) {
                this.index[i] = value;
            }
            else {
                this.hash.put(new Integer(i), value);
            }
            if (i == hi) {
                break;
            }
            ++i;
        }
    }
    
    public void set(final int key, final Object value) {
        this.set(key, key, value);
    }
    
    public void remove(final int lo, final int hi) {
        if (lo > hi) {
            return;
        }
        int i = lo;
        while (true) {
            if ((i & 0x7F) == i) {
                this.index[i] = null;
            }
            else {
                this.hash.remove(new Integer(i));
            }
            if (i == hi) {
                break;
            }
            ++i;
        }
    }
    
    public void remove(final int key) {
        this.remove(key, key);
    }
    
    public RangeTable copy() {
        final RangeTable copy = new RangeTable();
        copy.index = this.index.clone();
        copy.hash = (Hashtable)this.hash.clone();
        return copy;
    }
    
    public Object clone() {
        return this.copy();
    }
}
