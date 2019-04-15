/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.LongVector;
import gnu.lists.SimpleVector;

public class S64Vector
extends LongVector<Long> {
    public S64Vector() {
        this.data = empty;
    }

    public S64Vector(int size, long value) {
        long[] array = new long[size];
        this.data = array;
        if (value != 0L) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public S64Vector(int size) {
        this(new long[size]);
    }

    public S64Vector(long[] data) {
        this.data = data;
    }

    public S64Vector(long[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

    @Override
    public final Long get(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final Long getRaw(int index) {
        return this.data[index];
    }

    @Override
    public final void setRaw(int index, Long value) {
        this.data[index] = value;
    }

    @Override
    protected S64Vector newInstance(int newLength) {
        return new S64Vector(newLength < 0 ? this.data : new long[newLength]);
    }

    @Override
    public int getElementKind() {
        return 24;
    }

    @Override
    public String getTag() {
        return "s64";
    }

    @Override
    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int end = this.nextIndex(iposEnd);
        for (int i = this.nextIndex((int)iposStart); i < end; ++i) {
            out.writeLong(this.getLong(i));
        }
    }

    public int compareTo(Object obj) {
        int n2;
        S64Vector vec2 = (S64Vector)obj;
        long[] arr1 = this.data;
        long[] arr2 = vec2.data;
        int n1 = this.size();
        int n = n1 > (n2 = vec2.size()) ? n2 : n1;
        for (int i = 0; i < n; ++i) {
            long v2;
            long v1 = arr1[this.effectiveIndex(i)];
            if (v1 == (v2 = arr2[this.effectiveIndex(i)])) continue;
            return v1 > v2 ? 1 : -1;
        }
        return n1 - n2;
    }
}

