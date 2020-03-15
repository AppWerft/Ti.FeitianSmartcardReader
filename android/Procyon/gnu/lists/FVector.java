// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FVector<E> extends SimpleVector<E> implements Consumable, Comparable
{
    Object[] data;
    protected static Object[] empty;
    
    public FVector() {
        this.data = FVector.empty;
    }
    
    public FVector(int size, final Object value) {
        final Object[] array = new Object[size];
        this.data = array;
        if (value != null) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public FVector(final int size) {
        this(new Object[size]);
    }
    
    public FVector(final Object[] data) {
        this.data = data;
    }
    
    public FVector(final Object[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
    public FVector(final List seq) {
        this.data = new Object[seq.size()];
        int i = 0;
        final Iterator<? extends E> it = seq.iterator();
        while (it.hasNext()) {
            this.data[i++] = it.next();
        }
    }
    
    public static FVector make(final Object... data) {
        return new FVector(data);
    }
    
    public static <E> FVector<E> makeConstant(final E... data) {
        final FVector<E> vec = new FVector<E>(data);
        vec.setReadOnly();
        return vec;
    }
    
    public void replaceAll(final E[] data) {
        this.data = data;
        this.info = Long.MIN_VALUE;
    }
    
    public void copyFrom(final int index, final FVector<E> src, final int start, final int end) {
        final int count = end - start;
        final int sz = this.size();
        final int src_sz = src.size();
        if (count < 0 || index + count > sz || end > src_sz) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final int sseg;
        final int dseg;
        if ((sseg = src.getSegmentReadOnly(start, count)) >= 0 && (dseg = this.getSegment(index, count)) >= 0) {
            System.arraycopy(src.data, sseg, this.data, dseg, count);
        }
        else {
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
        final int oldLength = this.data.length;
        if (length == -1) {
            length = oldLength;
        }
        if (oldLength != length) {
            final Object[] tmp = new Object[length];
            System.arraycopy(this.data, 0, tmp, 0, (oldLength < length) ? oldLength : length);
            this.data = tmp;
        }
    }
    
    public Object[] getBuffer() {
        return this.data;
    }
    
    @Override
    protected void setBuffer(final Object buffer) {
        this.data = (Object[])buffer;
    }
    
    @Override
    public final E get(final int index) {
        return (E)this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final E getRaw(final int index) {
        return (E)this.data[index];
    }
    
    @Override
    public final void setRaw(final int index, final Object value) {
        this.data[index] = value;
    }
    
    @Override
    protected void clearBuffer(int start, int count) {
        final Object[] d = this.data;
        while (--count >= 0) {
            d[start++] = null;
        }
    }
    
    @Override
    protected FVector<E> newInstance(final int newLength) {
        return new FVector<E>((newLength < 0) ? this.data : new Object[newLength]);
    }
    
    @Override
    public final void fill(final int start, final int end, final E new_value) {
        if (this.isVerySimple()) {
            Arrays.fill(this.data, start, end, new_value);
        }
        else {
            super.fill(start, end, new_value);
        }
    }
    
    @Override
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        for (int i = this.nextIndex(iposStart), end = this.nextIndex(iposEnd); i < end; ++i) {
            out.writeObject(this.get(i));
        }
    }
    
    @Override
    public void consume(final Consumer out) {
        out.startElement("#vector");
        for (int len = this.size(), i = 0; i < len; ++i) {
            out.writeObject(this.get(i));
        }
        out.endElement();
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !(obj instanceof FVector)) {
            return false;
        }
        final FVector obj_vec = (FVector)obj;
        final int n = this.size();
        if (obj_vec.data == null || obj_vec.size() != n) {
            return false;
        }
        final Object[] this_data = this.data;
        final Object[] obj_data = obj_vec.data;
        for (int i = 0; i < n; ++i) {
            if (!this_data[this.effectiveIndex(i)].equals(obj_data[obj_vec.effectiveIndex(i)])) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int compareTo(final Object obj) {
        final FVector vec2 = (FVector)obj;
        final Object[] arr1 = this.data;
        final Object[] arr2 = vec2.data;
        final int n1 = this.size();
        final int n2 = vec2.size();
        for (int n3 = (n1 > n2) ? n2 : n1, i = 0; i < n3; ++i) {
            final Object v1 = arr1[this.effectiveIndex(i)];
            final Object v2 = arr2[this.effectiveIndex(i)];
            if (v1 != v2) {
                final int d = ((Comparable)v1).compareTo(v2);
                if (d != 0) {
                    return d;
                }
            }
        }
        return n1 - n2;
    }
    
    static {
        FVector.empty = new Object[0];
    }
}
