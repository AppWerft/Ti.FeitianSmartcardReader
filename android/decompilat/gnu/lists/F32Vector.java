// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class F32Vector extends SimpleVector<Float> implements Comparable
{
    float[] data;
    protected static float[] empty;
    
    public F32Vector() {
        this.data = F32Vector.empty;
    }
    
    public F32Vector(int size, final float value) {
        final float[] array = new float[size];
        this.data = array;
        if (value != 0.0f) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public F32Vector(final int size) {
        this(new float[size]);
    }
    
    public F32Vector(final float[] data) {
        this.data = data;
    }
    
    public F32Vector(final float[] values, final int offset, final int length) {
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
            final float[] tmp = new float[length];
            System.arraycopy(this.data, 0, tmp, 0, (oldLength < length) ? oldLength : length);
            this.data = tmp;
        }
    }
    
    public float[] getBuffer() {
        return this.data;
    }
    
    @Override
    protected void setBuffer(final Object buffer) {
        this.data = (float[])buffer;
    }
    
    public final float getFloat(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final float getFloatRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final Float get(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final Float getRaw(final int index) {
        return this.data[index];
    }
    
    public final void setFloat(final int index, final float value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex(index)] = value;
    }
    
    public final void setFloatRaw(final int index, final float value) {
        this.data[index] = value;
    }
    
    @Override
    public final void setRaw(final int index, final Float value) {
        this.data[index] = value;
    }
    
    public void add(final float v) {
        final int sz = this.size();
        this.addSpace(sz, 1);
        this.setFloat(sz, v);
    }
    
    @Override
    protected void clearBuffer(int start, int count) {
        final float[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0.0f;
        }
    }
    
    @Override
    protected F32Vector newInstance(final int newLength) {
        return new F32Vector((newLength < 0) ? this.data : new float[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 25;
    }
    
    @Override
    public String getTag() {
        return "f32";
    }
    
    @Override
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        for (int i = this.nextIndex(iposStart), end = this.nextIndex(iposEnd); i < end; ++i) {
            out.writeFloat(this.getFloat(i));
        }
    }
    
    @Override
    public int compareTo(final Object obj) {
        final F32Vector vec2 = (F32Vector)obj;
        final float[] arr1 = this.data;
        final float[] arr2 = vec2.data;
        final int n1 = this.size();
        final int n2 = vec2.size();
        for (int n3 = (n1 > n2) ? n2 : n1, i = 0; i < n3; ++i) {
            final float v1 = arr1[this.effectiveIndex(i)];
            final float v2 = arr2[this.effectiveIndex(i)];
            if (v1 != v2) {
                return (v1 > v2) ? 1 : -1;
            }
        }
        return n1 - n2;
    }
    
    static {
        F32Vector.empty = new float[0];
    }
}
