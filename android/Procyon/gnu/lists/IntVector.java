// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public abstract class IntVector<E> extends PrimIntegerVector<E>
{
    int[] data;
    protected static int[] empty;
    
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
            final int[] tmp = new int[length];
            System.arraycopy(this.data, 0, tmp, 0, (oldLength < length) ? oldLength : length);
            this.data = tmp;
        }
    }
    
    public int[] getBuffer() {
        return this.data;
    }
    
    @Override
    protected void setBuffer(final Object buffer) {
        this.data = (int[])buffer;
    }
    
    @Override
    public final int getInt(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final int getIntRaw(final int index) {
        return this.data[index];
    }
    
    public final void setInt(final int index, final int value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex(index)] = value;
    }
    
    public final void setIntRaw(final int index, final int value) {
        this.data[index] = value;
    }
    
    public void add(final int v) {
        final int sz = this.size();
        this.addSpace(sz, 1);
        this.setInt(sz, v);
    }
    
    @Override
    protected void clearBuffer(int start, int count) {
        final int[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0;
        }
    }
    
    static {
        IntVector.empty = new int[0];
    }
}
