// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class F64Vector extends SimpleVector<Double> implements Comparable
{
    double[] data;
    protected static double[] empty;
    
    public F64Vector() {
        this.data = F64Vector.empty;
    }
    
    public F64Vector(int size, final double value) {
        final double[] array = new double[size];
        this.data = array;
        if (value != 0.0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }
    
    public F64Vector(final int size) {
        this(new double[size]);
    }
    
    public F64Vector(final double[] data) {
        this.data = data;
    }
    
    public F64Vector(final double[] values, final int offset, final int length) {
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
            final double[] tmp = new double[length];
            System.arraycopy(this.data, 0, tmp, 0, (oldLength < length) ? oldLength : length);
            this.data = tmp;
        }
    }
    
    public double[] getBuffer() {
        return this.data;
    }
    
    @Override
    protected void setBuffer(final Object buffer) {
        this.data = (double[])buffer;
    }
    
    public final double getDouble(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final double getDoubleRaw(final int index) {
        return this.data[index];
    }
    
    @Override
    public final Double get(final int index) {
        return this.data[this.effectiveIndex(index)];
    }
    
    @Override
    public final Double getRaw(final int index) {
        return this.data[index];
    }
    
    public final void setDouble(final int index, final double value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex(index)] = value;
    }
    
    public final void setDoubleRaw(final int index, final double value) {
        this.data[index] = value;
    }
    
    @Override
    public final void setRaw(final int index, final Double value) {
        this.data[index] = value;
    }
    
    public void add(final double v) {
        final int sz = this.size();
        this.addSpace(sz, 1);
        this.setDouble(sz, v);
    }
    
    @Override
    protected void clearBuffer(int start, int count) {
        final double[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0.0;
        }
    }
    
    @Override
    protected F64Vector newInstance(final int newLength) {
        return new F64Vector((newLength < 0) ? this.data : new double[newLength]);
    }
    
    @Override
    public int getElementKind() {
        return 26;
    }
    
    @Override
    public String getTag() {
        return "f64";
    }
    
    @Override
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        if (out.ignoring()) {
            return;
        }
        for (int i = this.nextIndex(iposStart), end = this.nextIndex(iposEnd); i < end; ++i) {
            out.writeDouble(this.getDouble(i));
        }
    }
    
    @Override
    public int compareTo(final Object obj) {
        final F64Vector vec2 = (F64Vector)obj;
        final double[] arr1 = this.data;
        final double[] arr2 = vec2.data;
        final int n1 = this.size();
        final int n2 = vec2.size();
        for (int n3 = (n1 > n2) ? n2 : n1, i = 0; i < n3; ++i) {
            final double v1 = arr1[this.effectiveIndex(i)];
            final double v2 = arr2[this.effectiveIndex(i)];
            if (v1 != v2) {
                return (v1 > v2) ? 1 : -1;
            }
        }
        return n1 - n2;
    }
    
    static {
        F64Vector.empty = new double[0];
    }
}
