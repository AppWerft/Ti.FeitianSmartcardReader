// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class BitVector extends SimpleVector<Boolean> implements Comparable
{
    boolean[] data;
    protected static boolean[] empty;
    
    public BitVector() {
        this.data = BitVector.empty;
    }
    
    public BitVector(int size, final boolean value) {
        final boolean[] array = new boolean[size];
        this.data = array;
        if (value) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public BitVector(final int size) {
        this(new boolean[size]);
    }
    
    public BitVector(final boolean[] data) {
        this.data = data;
    }
    
    public BitVector(final boolean[] values, final int offset, final int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }
    
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
            final boolean[] tmp = new boolean[length];
            System.arraycopy(this.data, 0, tmp, 0, (oldLength < length) ? oldLength : length);
            this.data = tmp;
        }
    }
    
    public boolean[] getBuffer() {
        return this.data;
    }
    
    @Override
    protected void setBuffer(final Object buffer) {
        this.data = (boolean[])buffer;
    }
    
    public final boolean getBoolean(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final boolean getBooleanRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final Boolean get(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final Boolean getRaw(final int index) {
        return this.data[index];
    }
    
    public final void setBoolean(final int index, final boolean value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex(index)] = value;
    }
    
    public final void setBooleanRaw(final int index, final boolean value) {
        this.data[index] = value;
    }
    
    @Override
    public final void setRaw(final int index, final Boolean value) {
        this.data[index] = value;
    }
    
    public void add(final boolean v) {
        final int sz = this.size();
        this.addSpace(sz, 1);
        this.setBoolean(sz, v);
    }
    
    @Override
    protected void clearBuffer(int start, int count) {
        final boolean[] d = this.data;
        while (--count >= 0) {
            d[start++] = false;
        }
    }
    
    @Override
    protected BitVector newInstance(final int newLength) {
        return new BitVector((newLength < 0) ? this.data : new boolean[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 27;
    }
    
    @Override
    public String getTag() {
        return "b";
    }
    
    @Override
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        for (int i = this.nextIndex(iposStart), end = this.nextIndex(iposEnd); i < end; ++i) {
            out.writeBoolean(this.getBoolean(i));
        }
    }
    
    @Override
    public int compareTo(final Object obj) {
        final BitVector vec2 = (BitVector)obj;
        final boolean[] arr1 = this.data;
        final boolean[] arr2 = vec2.data;
        final int n1 = this.size();
        final int n2 = vec2.size();
        for (int n3 = (n1 > n2) ? n2 : n1, i = 0; i < n3; ++i) {
            final boolean v1 = arr1[this.effectiveIndex(i)];
            final boolean v2 = arr2[this.effectiveIndex(i)];
            if (v1 != v2) {
                return (v1 && !v2) ? 1 : -1;
            }
        }
        return n1 - n2;
    }
    
    static {
        BitVector.empty = new boolean[0];
    }
}
