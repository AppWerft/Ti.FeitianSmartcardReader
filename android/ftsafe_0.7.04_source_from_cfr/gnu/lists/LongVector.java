/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.PrimIntegerVector;

public abstract class LongVector<E>
extends PrimIntegerVector<E> {
    long[] data;
    protected static long[] empty = new long[0];

    @Override
    public int getBufferLength() {
        return this.data.length;
    }

    @Override
    public void copyBuffer(int length) {
        int oldLength = this.data.length;
        if (length == -1) {
            length = oldLength;
        }
        if (oldLength != length) {
            long[] tmp = new long[length];
            System.arraycopy(this.data, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    public long[] getBuffer() {
        return this.data;
    }

    @Override
    protected void setBuffer(Object buffer) {
        this.data = (long[])buffer;
    }

    @Override
    public final long getLong(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final long getLongRaw(int index) {
        return this.data[index];
    }

    @Override
    public final int getIntRaw(int index) {
        return (int)this.data[index];
    }

    public final void setLong(int index, long value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex((int)index)] = value;
    }

    public final void setLongRaw(int index, long value) {
        this.data[index] = value;
    }

    public void add(long v) {
        int sz = this.size();
        this.addSpace(sz, 1);
        this.setLong(sz, v);
    }

    @Override
    protected void clearBuffer(int start, int count) {
        long[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0L;
        }
    }
}

