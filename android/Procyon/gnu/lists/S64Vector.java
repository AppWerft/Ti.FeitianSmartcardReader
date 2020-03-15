// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class S64Vector extends LongVector<Long>
{
    public S64Vector() {
        this.data = S64Vector.empty;
    }
    
    public S64Vector(int size, final long value) {
        final long[] array = new long[size];
        this.data = array;
        if (value != 0L) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public S64Vector(final int size) {
        this(new long[size]);
    }
    
    public S64Vector(final long[] data) {
        this.data = data;
    }
    
    public S64Vector(final long[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
    @Override
    public final Long get(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final Long getRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final void setRaw(final int index, final Long value) {
        this.data[index] = value;
    }
    
    @Override
    protected S64Vector newInstance(final int newLength) {
        return new S64Vector((newLength < 0) ? this.data : new long[newLength]);
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
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        for (int i = this.nextIndex(iposStart), end = this.nextIndex(iposEnd); i < end; ++i) {
            out.writeLong(this.getLong(i));
        }
    }
    
    @Override
    public int compareTo(final Object obj) {
        final S64Vector vec2 = (S64Vector)obj;
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
