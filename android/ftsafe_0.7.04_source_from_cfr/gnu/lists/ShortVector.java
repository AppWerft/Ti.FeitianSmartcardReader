/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.PrimIntegerVector;

public abstract class ShortVector<E>
extends PrimIntegerVector<E> {
    short[] data;
    protected static short[] empty = new short[0];

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
            short[] tmp = new short[length];
            System.arraycopy(this.data, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    public short[] getBuffer() {
        return this.data;
    }

    @Override
    protected void setBuffer(Object buffer) {
        this.data = (short[])buffer;
    }

    public final short getShort(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final short getShortRaw(int index) {
        return this.data[index];
    }

    public final void setShort(int index, short value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex((int)index)] = value;
    }

    public final void setShortRaw(int index, short value) {
        this.data[index] = value;
    }

    public void add(short v) {
        int sz = this.size();
        this.addSpace(sz, 1);
        this.setShort(sz, v);
    }

    @Override
    protected void clearBuffer(int start, int count) {
        short[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0;
        }
    }
}

