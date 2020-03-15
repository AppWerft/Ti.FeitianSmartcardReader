// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import gnu.math.UShort;

public class U16Vector extends ShortVector<UShort>
{
    public U16Vector() {
        this.data = U16Vector.empty;
    }
    
    public U16Vector(int size, final short value) {
        final short[] array = new short[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public U16Vector(final int size) {
        this(new short[size]);
    }
    
    public U16Vector(final short[] data) {
        this.data = data;
    }
    
    public U16Vector(final short[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
    @Override
    public final int getIntRaw(final int index) {
        return this.data[index] & 0xFFFF;
    }
    
    @Override
    public final UShort get(final int index) {
        return UShort.valueOf(this.data[this.effectiveIndex(index)]);
    }
    
    @Override
    public final UShort getRaw(final int index) {
        return UShort.valueOf(this.data[index]);
    }
    
    @Override
    public final void setRaw(final int index, final UShort value) {
        this.data[index] = value.shortValue();
    }
    
    @Override
    protected U16Vector newInstance(final int newLength) {
        return new U16Vector((newLength < 0) ? this.data : new short[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 19;
    }
    
    @Override
    public String getTag() {
        return "u16";
    }
    
    @Override
    public int compareTo(final Object obj) {
        return PrimIntegerVector.compareToInt((PrimIntegerVector<Object>)this, (PrimIntegerVector<Object>)obj);
    }
}
