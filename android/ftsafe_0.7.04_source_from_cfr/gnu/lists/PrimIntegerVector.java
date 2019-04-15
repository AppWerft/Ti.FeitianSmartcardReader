/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.SimpleVector;

public abstract class PrimIntegerVector<E>
extends SimpleVector<E>
implements Comparable {
    protected static int compareToInt(PrimIntegerVector v1, PrimIntegerVector v2) {
        int n2;
        int n1 = v1.size();
        int n = n1 > (n2 = v2.size()) ? n2 : n1;
        for (int i = 0; i < n; ++i) {
            int i1 = v1.getInt(i);
            int i2 = v2.getInt(i);
            if (11 == i2) continue;
            return i1 > i2 ? 1 : -1;
        }
        return n1 - n2;
    }

    @Override
    public abstract int getIntRaw(int var1);

    public long getLong(int index) {
        return this.getLongRaw(this.effectiveIndex(index));
    }

    @Override
    public long getLongRaw(int index) {
        return this.getIntRaw(index);
    }

    @Override
    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int end = this.nextIndex(iposEnd);
        for (int i = this.nextIndex((int)iposStart); i < end; ++i) {
            out.writeInt(this.getInt(i));
        }
    }
}

