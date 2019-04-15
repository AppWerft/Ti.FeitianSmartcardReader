/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.SimpleVector;
import java.util.Arrays;
import java.util.List;

public class FVector<E>
extends SimpleVector<E>
implements Consumable,
Comparable {
    Object[] data;
    protected static Object[] empty = new Object[0];

    public FVector() {
        this.data = empty;
    }

    public FVector(int size, Object value) {
        Object[] array = new Object[size];
        this.data = array;
        if (value != null) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public FVector(int size) {
        this(new Object[size]);
    }

    public FVector(Object[] data) {
        this.data = data;
    }

    public FVector(Object[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

    public FVector(List seq) {
        this.data = new Object[seq.size()];
        int i = 0;
        for (Object this.data[i++] : seq) {
        }
    }

    public static /* varargs */ FVector make(Object ... data) {
        return new FVector<E>(data);
    }

    public static /* varargs */ <E> FVector<E> makeConstant(E ... data) {
        FVector<E> vec = new FVector<E>(data);
        vec.setReadOnly();
        return vec;
    }

    public void replaceAll(E[] data) {
        this.data = data;
        this.info = Long.MIN_VALUE;
    }

    public void copyFrom(int index, FVector<E> src, int start, int end) {
        int dseg;
        int count = end - start;
        int sz = this.size();
        int src_sz = src.size();
        if (count < 0 || index + count > sz || end > src_sz) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int sseg = src.getSegmentReadOnly(start, count);
        if (sseg >= 0 && (dseg = this.getSegment(index, count)) >= 0) {
            System.arraycopy(src.data, sseg, this.data, dseg, count);
        } else {
            for (int i = 0; i < count; ++i) {
                this.set(index + i, src.get(start + i));
            }
        }
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
            Object[] tmp = new Object[length];
            System.arraycopy(this.data, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    public Object[] getBuffer() {
        return this.data;
    }

    @Override
    protected void setBuffer(Object buffer) {
        this.data = (Object[])buffer;
    }

    @Override
    public final E get(int index) {
        return (E)this.data[this.effectiveIndex(index)];
    }

    @Override
    public final E getRaw(int index) {
        return (E)this.data[index];
    }

    @Override
    public final void setRaw(int index, Object value) {
        this.data[index] = value;
    }

    @Override
    protected void clearBuffer(int start, int count) {
        Object[] d = this.data;
        while (--count >= 0) {
            d[start++] = null;
        }
    }

    @Override
    protected FVector<E> newInstance(int newLength) {
        return new FVector<E>(newLength < 0 ? this.data : new Object[newLength]);
    }

    @Override
    public final void fill(int start, int end, E new_value) {
        if (this.isVerySimple()) {
            Arrays.fill(this.data, start, end, new_value);
        } else {
            super.fill(start, end, new_value);
        }
    }

    @Override
    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int end = this.nextIndex(iposEnd);
        for (int i = this.nextIndex((int)iposStart); i < end; ++i) {
            out.writeObject(this.get(i));
        }
    }

    @Override
    public void consume(Consumer out) {
        out.startElement("#vector");
        int len = this.size();
        for (int i = 0; i < len; ++i) {
            out.writeObject(this.get(i));
        }
        out.endElement();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FVector)) {
            return false;
        }
        FVector obj_vec = (FVector)obj;
        int n = this.size();
        if (obj_vec.data == null || obj_vec.size() != n) {
            return false;
        }
        Object[] this_data = this.data;
        Object[] obj_data = obj_vec.data;
        for (int i = 0; i < n; ++i) {
            if (this_data[this.effectiveIndex(i)].equals(obj_data[obj_vec.effectiveIndex(i)])) continue;
            return false;
        }
        return true;
    }

    public int compareTo(Object obj) {
        int n2;
        FVector vec2 = (FVector)obj;
        Object[] arr1 = this.data;
        Object[] arr2 = vec2.data;
        int n1 = this.size();
        int n = n1 > (n2 = vec2.size()) ? n2 : n1;
        for (int i = 0; i < n; ++i) {
            int d;
            Object v2;
            Object v1 = arr1[this.effectiveIndex(i)];
            if (v1 == (v2 = arr2[this.effectiveIndex(i)]) || (d = ((Comparable)v1).compareTo((Comparable)v2)) == 0) continue;
            return d;
        }
        return n1 - n2;
    }
}

