/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import java.util.Hashtable;

public class RangeTable
implements Cloneable {
    Object[] index = new Object[128];
    Hashtable hash = new Hashtable(200);

    public Object lookup(int key, Object defaultValue) {
        if ((key & 127) == key) {
            return this.index[key];
        }
        return this.hash.get(new Integer(key));
    }

    public void set(int lo, int hi, Object value) {
        if (lo > hi) {
            return;
        }
        int i = lo;
        do {
            if ((i & 127) == i) {
                this.index[i] = value;
            } else {
                this.hash.put(new Integer(i), value);
            }
            if (i == hi) break;
            ++i;
        } while (true);
    }

    public void set(int key, Object value) {
        this.set(key, key, value);
    }

    public void remove(int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int i = lo;
        do {
            if ((i & 127) == i) {
                this.index[i] = null;
            } else {
                this.hash.remove(new Integer(i));
            }
            if (i == hi) break;
            ++i;
        } while (true);
    }

    public void remove(int key) {
        this.remove(key, key);
    }

    public RangeTable copy() {
        RangeTable copy = new RangeTable();
        copy.index = (Object[])this.index.clone();
        copy.hash = (Hashtable)this.hash.clone();
        return copy;
    }

    public Object clone() {
        return this.copy();
    }
}

