// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class S8Vector extends ByteVector<Byte>
{
    public S8Vector() {
        this.data = S8Vector.empty;
    }
    
    public S8Vector(int size, final byte value) {
        final byte[] array = new byte[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public S8Vector(final int size) {
        this(new byte[size]);
    }
    
    public S8Vector(final byte[] data) {
        this.data = data;
    }
    
    public S8Vector(final byte[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
    @Override
    public final int getIntRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final Byte get(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final Byte getRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final void setRaw(final int index, final Byte value) {
        this.data[index] = value;
    }
    
    @Override
    protected S8Vector newInstance(final int newLength) {
        return new S8Vector((newLength < 0) ? this.data : new byte[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 18;
    }
    
    @Override
    public String getTag() {
        return "s8";
    }
    
    @Override
    public int compareTo(final Object obj) {
        return PrimIntegerVector.compareToInt((PrimIntegerVector<Object>)this, (PrimIntegerVector<Object>)obj);
    }
}
