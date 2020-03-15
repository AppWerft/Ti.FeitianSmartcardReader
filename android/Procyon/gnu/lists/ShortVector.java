// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public abstract class ShortVector<E> extends PrimIntegerVector<E>
{
    short[] data;
    protected static short[] empty;
    
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
            final short[] tmp = new short[length];
            System.arraycopy(this.data, 0, tmp, 0, (oldLength < length) ? oldLength : length);
            this.data = tmp;
        }
    }
    
    public short[] getBuffer() {
        return this.data;
    }
    
    @Override
    protected void setBuffer(final Object buffer) {
        this.data = (short[])buffer;
    }
    
    public final short getShort(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final short getShortRaw(final int index) {
        return this.data[index];
    }
    
    public final void setShort(final int index, final short value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex(index)] = value;
    }
    
    public final void setShortRaw(final int index, final short value) {
        this.data[index] = value;
    }
    
    public void add(final short v) {
        final int sz = this.size();
        this.addSpace(sz, 1);
        this.setShort(sz, v);
    }
    
    @Override
    protected void clearBuffer(int start, int count) {
        final short[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0;
        }
    }
    
    static {
        ShortVector.empty = new short[0];
    }
}
