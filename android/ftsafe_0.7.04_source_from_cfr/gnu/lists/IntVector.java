/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.PrimIntegerVector;

public abstract class IntVector<E>
extends PrimIntegerVector<E> {
    int[] data;
    protected static int[] empty = new int[0];

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
            int[] tmp = new int[length];
            System.arraycopy(this.data, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    public int[] getBuffer() {
        return this.data;
    }

    @Override
    protected void setBuffer(Object buffer) {
        this.data = (int[])buffer;
    }

    @Override
    public final int getInt(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final int getIntRaw(int index) {
        return this.data[index];
    }

    public final void setInt(int index, int value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex((int)index)] = value;
    }

    public final void setIntRaw(int index, int value) {
        this.data[index] = value;
    }

    public void add(int v) {
        int sz = this.size();
        this.addSpace(sz, 1);
        this.setInt(sz, v);
    }

    @Override
    protected void clearBuffer(int start, int count) {
        int[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0;
        }
    }
}

