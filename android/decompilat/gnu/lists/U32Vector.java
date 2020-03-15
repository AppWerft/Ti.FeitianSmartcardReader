// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import gnu.math.UInt;

public class U32Vector extends IntVector<UInt>
{
    public U32Vector() {
        this.data = U32Vector.empty;
    }
    
    public U32Vector(int size, final int value) {
        final int[] array = new int[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public U32Vector(final int size) {
        this(new int[size]);
    }
    
    public U32Vector(final int[] data) {
        this.data = data;
    }
    
    public U32Vector(final int[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
    @Override
    public final long getLongRaw(final int index) {
        return (long)this.data[index] & 0xFFFFFFFFL;
    }
    
    @Override
    public final UInt get(final int index) {
        return UInt.valueOf(this.data[this.effectiveIndex(index)]);
    }
    
    @Override
    public final UInt getRaw(final int index) {
        return UInt.valueOf(this.data[index]);
    }
    
    @Override
    public final void setRaw(final int index, final UInt value) {
        this.data[index] = value.intValue();
    }
    
    @Override
    protected U32Vector newInstance(final int newLength) {
        return new U32Vector((newLength < 0) ? this.data : new int[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 21;
    }
    
    @Override
    public String getTag() {
        return "u32";
    }
    
    @Override
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        for (int i = this.nextIndex(iposStart), end = this.nextIndex(iposEnd); i < end; ++i) {
            Sequences.writeUInt(this.getInt(i), out);
        }
    }
    
    @Override
    public int compareTo(final Object obj) {
        return PrimIntegerVector.compareToInt((PrimIntegerVector<Object>)this, (PrimIntegerVector<Object>)obj);
    }
}
