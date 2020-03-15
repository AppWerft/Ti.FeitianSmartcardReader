// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import gnu.math.ULong;

public class U64Vector extends LongVector<ULong>
{
    public U64Vector() {
        this.data = U64Vector.empty;
    }
    
    public U64Vector(int size, final long value) {
        final long[] array = new long[size];
        this.data = array;
        if (value != 0L) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public U64Vector(final int size) {
        this(new long[size]);
    }
    
    public U64Vector(final long[] data) {
        this.data = data;
    }
    
    public U64Vector(final long[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
    @Override
    public final ULong get(final int index) {
        return ULong.valueOf(this.data[this.effectiveIndex(index)]);
    }
    
    @Override
    public final ULong getRaw(final int index) {
        return ULong.valueOf(this.data[index]);
    }
    
    @Override
    public final void setRaw(final int index, final ULong value) {
        this.data[index] = value.longValue();
    }
    
    @Override
    protected U64Vector newInstance(final int newLength) {
        return new U64Vector((newLength < 0) ? this.data : new long[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 23;
    }
    
    @Override
    public String getTag() {
        return "u64";
    }
    
    @Override
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        for (int i = this.nextIndex(iposStart), end = this.nextIndex(iposEnd); i < end; ++i) {
            Sequences.writeULong(this.getLong(i), out);
        }
    }
    
    @Override
    public int compareTo(final Object obj) {
        final U64Vector vec2 = (U64Vector)obj;
        final long[] arr1 = this.data;
        final long[] arr2 = vec2.data;
        final int n1 = this.size();
        final int n2 = vec2.size();
        for (int n3 = (n1 > n2) ? n2 : n1, i = 0; i < n3; ++i) {
            final long v1 = arr1[this.effectiveIndex(i)];
            final long v2 = arr2[this.effectiveIndex(i)];
            if (v1 != v2) {
                return (v1 > v2) ? 1 : -1;
            }
        }
        return n1 - n2;
    }
}
