// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class S16Vector extends ShortVector<Short>
{
    public S16Vector() {
        this.data = S16Vector.empty;
    }
    
    public S16Vector(int size, final short value) {
        final short[] array = new short[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public S16Vector(final int size) {
        this(new short[size]);
    }
    
    public S16Vector(final short[] data) {
        this.data = data;
    }
    
    public S16Vector(final short[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
    @Override
    public final int getIntRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final Short get(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final Short getRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final void setRaw(final int index, final Short value) {
        this.data[index] = value;
    }
    
    @Override
    protected S16Vector newInstance(final int newLength) {
        return new S16Vector((newLength < 0) ? this.data : new short[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 20;
    }
    
    @Override
    public String getTag() {
        return "s16";
    }
    
    @Override
    public int compareTo(final Object obj) {
        return PrimIntegerVector.compareToInt((PrimIntegerVector<Object>)this, (PrimIntegerVector<Object>)obj);
    }
}
