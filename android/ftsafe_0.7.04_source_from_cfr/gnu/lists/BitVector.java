/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.SimpleVector;

public class BitVector
extends SimpleVector<Boolean>
implements Comparable {
    boolean[] data;
    protected static boolean[] empty = new boolean[0];

    public BitVector() {
        this.data = empty;
    }

    public BitVector(int size, boolean value) {
        boolean[] array = new boolean[size];
        this.data = array;
        if (value) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public BitVector(int size) {
        this(new boolean[size]);
    }

    public BitVector(boolean[] data) {
        this.data = data;
    }

    public BitVector(boolean[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

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
            boolean[] tmp = new boolean[length];
            System.arraycopy(this.data, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    public boolean[] getBuffer() {
        return this.data;
    }

    @Override
    protected void setBuffer(Object buffer) {
        this.data = (boolean[])buffer;
    }

    public final boolean getBoolean(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final boolean getBooleanRaw(int index) {
        return this.data[index];
    }

    @Override
    public final Boolean get(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final Boolean getRaw(int index) {
        return this.data[index];
    }

    public final void setBoolean(int index, boolean value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex((int)index)] = value;
    }

    public final void setBooleanRaw(int index, boolean value) {
        this.data[index] = value;
    }

    @Override
    public final void setRaw(int index, Boolean value) {
        this.data[index] = value;
    }

    public void add(boolean v) {
        int sz = this.size();
        this.addSpace(sz, 1);
        this.setBoolean(sz, v);
    }

    @Override
    protected void clearBuffer(int start, int count) {
        boolean[] d = this.data;
        while (--count >= 0) {
            d[start++] = false;
        }
    }

    @Override
    protected BitVector newInstance(int newLength) {
        return new BitVector(newLength < 0 ? this.data : new boolean[newLength]);
    }

    @Override
    public int getElementKind() {
        return 27;
    }

    @Override
    public String getTag() {
        return "b";
    }

    @Override
    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int end = this.nextIndex(iposEnd);
        for (int i = this.nextIndex((int)iposStart); i < end; ++i) {
            out.writeBoolean(this.getBoolean(i));
        }
    }

    public int compareTo(Object obj) {
        int n2;
        BitVector vec2 = (BitVector)obj;
        boolean[] arr1 = this.data;
        boolean[] arr2 = vec2.data;
        int n1 = this.size();
        int n = n1 > (n2 = vec2.size()) ? n2 : n1;
        for (int i = 0; i < n; ++i) {
            boolean v2;
            boolean v1 = arr1[this.effectiveIndex(i)];
            if (v1 == (v2 = arr2[this.effectiveIndex(i)])) continue;
            return v1 && !v2 ? 1 : -1;
        }
        return n1 - n2;
    }
}

