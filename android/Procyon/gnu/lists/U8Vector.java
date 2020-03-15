// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import gnu.math.UByte;

public class U8Vector extends ByteVector<UByte>
{
    public U8Vector() {
        this.data = U8Vector.empty;
    }
    
    public U8Vector(int size, final byte value) {
        final byte[] array = new byte[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public U8Vector(final int size) {
        this(new byte[size]);
    }
    
    public U8Vector(final byte[] data) {
        this.data = data;
    }
    
    public U8Vector(final byte[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
    @Override
    public final int getIntRaw(final int index) {
        return this.data[index] & 0xFF;
    }
    
    @Override
    public final UByte get(final int index) {
        return UByte.valueOf(this.data[this.effectiveIndex(index)]);
    }
    
    @Override
    public final UByte getRaw(final int index) {
        return UByte.valueOf(this.data[index]);
    }
    
    @Override
    public final void setRaw(final int index, final UByte value) {
        this.data[index] = value.byteValue();
    }
    
    @Override
    protected U8Vector newInstance(final int newLength) {
        return new U8Vector((newLength < 0) ? this.data : new byte[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 17;
    }
    
    @Override
    public String getTag() {
        return "u8";
    }
    
    @Override
    public int compareTo(final Object obj) {
        return PrimIntegerVector.compareToInt((PrimIntegerVector<Object>)this, (PrimIntegerVector<Object>)obj);
    }
}
