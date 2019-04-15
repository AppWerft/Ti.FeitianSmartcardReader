/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.SimpleVector;

public class F64Vector
extends SimpleVector<Double>
implements Comparable {
    double[] data;
    protected static double[] empty = new double[0];

    public F64Vector() {
        this.data = empty;
    }

    public F64Vector(int size, double value) {
        double[] array = new double[size];
        this.data = array;
        if (value != 0.0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public F64Vector(int size) {
        this(new double[size]);
    }

    public F64Vector(double[] data) {
        this.data = data;
    }

    public F64Vector(double[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

    @Override
    public int getBufferLength() {
        return this.data.length;
    }

    @Override
    public void copyBuffer(int length) {
        int oldLength = this.data.length;
        if (length == -1) {
            length = oldLength;
        }
        if (oldLength != length) {
            double[] tmp = new double[length];
            System.arraycopy(this.data, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    public double[] getBuffer() {
        return this.data;
    }

    @Override
    protected void setBuffer(Object buffer) {
        this.data = (double[])buffer;
    }

    public final double getDouble(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final double getDoubleRaw(int index) {
        return this.data[index];
    }

    @Override
    public final Double get(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final Double getRaw(int index) {
        return this.data[index];
    }

    public final void setDouble(int index, double value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex((int)index)] = value;
    }

    public final void setDoubleRaw(int index, double value) {
        this.data[index] = value;
    }

    @Override
    public final void setRaw(int index, Double value) {
        this.data[index] = value;
    }

    public void add(double v) {
        int sz = this.size();
        this.addSpace(sz, 1);
        this.setDouble(sz, v);
    }

    @Override
    protected void clearBuffer(int start, int count) {
        double[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0.0;
        }
    }

    @Override
    protected F64Vector newInstance(int newLength) {
        return new F64Vector(newLength < 0 ? this.data : new double[newLength]);
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
    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int end = this.nextIndex(iposEnd);
        for (int i = this.nextIndex((int)iposStart); i < end; ++i) {
            out.writeDouble(this.getDouble(i));
        }
    }

    public int compareTo(Object obj) {
        int n2;
        F64Vector vec2 = (F64Vector)obj;
        double[] arr1 = this.data;
        double[] arr2 = vec2.data;
        int n1 = this.size();
        int n = n1 > (n2 = vec2.size()) ? n2 : n1;
        for (int i = 0; i < n; ++i) {
            double v2;
            double v1 = arr1[this.effectiveIndex(i)];
            if (v1 == (v2 = arr2[this.effectiveIndex(i)])) continue;
            return v1 > v2 ? 1 : -1;
        }
        return n1 - n2;
    }
}

