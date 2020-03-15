// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class S32Vector extends IntVector<Integer> implements IntSequence
{
    public S32Vector() {
        this.data = S32Vector.empty;
    }
    
    public S32Vector(int size, final int value) {
        final int[] array = new int[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public S32Vector(final int size) {
        this(new int[size]);
    }
    
    public S32Vector(final int[] data) {
        this.data = data;
    }
    
    public S32Vector(final int[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
    @Override
    public final long getLongRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final Integer get(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final Integer getRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final void setRaw(final int index, final Integer value) {
        this.data[index] = value;
    }
    
    @Override
    protected S32Vector newInstance(final int newLength) {
        return new S32Vector((newLength < 0) ? this.data : new int[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 22;
    }
    
    @Override
    public String getTag() {
        return "s32";
    }
    
    @Override
    public int compareTo(final Object obj) {
        return PrimIntegerVector.compareToInt((PrimIntegerVector<Object>)this, (PrimIntegerVector<Object>)obj);
    }
}
