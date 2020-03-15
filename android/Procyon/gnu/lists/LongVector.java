// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public abstract class LongVector<E> extends PrimIntegerVector<E>
{
    long[] data;
    protected static long[] empty;
    
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
            final long[] tmp = new long[length];
            System.arraycopy(this.data, 0, tmp, 0, (oldLength < length) ? oldLength : length);
            this.data = tmp;
        }
    }
    
    public long[] getBuffer() {
        return this.data;
    }
    
    @Override
    protected void setBuffer(final Object buffer) {
        this.data = (long[])buffer;
    }
    
    @Override
    public final long getLong(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final long getLongRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final int getIntRaw(final int index) {
        return (int)this.data[index];
    }
    
    public final void setLong(final int index, final long value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex(index)] = value;
    }
    
    public final void setLongRaw(final int index, final long value) {
        this.data[index] = value;
    }
    
    public void add(final long v) {
        final int sz = this.size();
        this.addSpace(sz, 1);
        this.setLong(sz, v);
    }
    
    @Override
    protected void clearBuffer(int start, int count) {
        final long[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0L;
        }
    }
    
    static {
        LongVector.empty = new long[0];
    }
}
