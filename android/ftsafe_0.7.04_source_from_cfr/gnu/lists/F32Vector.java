/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.SimpleVector;

public class F32Vector
extends SimpleVector<Float>
implements Comparable {
    float[] data;
    protected static float[] empty = new float[0];

    public F32Vector() {
        this.data = empty;
    }

    public F32Vector(int size, float value) {
        float[] array = new float[size];
        this.data = array;
        if (value != 0.0f) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public F32Vector(int size) {
        this(new float[size]);
    }

    public F32Vector(float[] data) {
        this.data = data;
    }

    public F32Vector(float[] values, int offset, int length) {
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
            float[] tmp = new float[length];
            System.arraycopy(this.data, 0, tmp, 0, oldLength < length ? oldLength : length);
            this.data = tmp;
        }
    }

    public float[] getBuffer() {
        return this.data;
    }

    @Override
    protected void setBuffer(Object buffer) {
        this.data = (float[])buffer;
    }

    public final float getFloat(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final float getFloatRaw(int index) {
        return this.data[index];
    }

    @Override
    public final Float get(int index) {
        return Float.valueOf(this.data[this.effectiveIndex(index)]);
    }

    @Override
    public final Float getRaw(int index) {
        return Float.valueOf(this.data[index]);
    }

    public final void setFloat(int index, float value) {
        this.checkCanWrite();
        this.data[this.effectiveIndex((int)index)] = value;
    }

    public final void setFloatRaw(int index, float value) {
        this.data[index] = value;
    }

    @Override
    public final void setRaw(int index, Float value) {
        this.data[index] = value.floatValue();
    }

    public void add(float v) {
        int sz = this.size();
        this.addSpace(sz, 1);
        this.setFloat(sz, v);
    }

    @Override
    protected void clearBuffer(int start, int count) {
        float[] d = this.data;
        while (--count >= 0) {
            d[start++] = 0.0f;
        }
    }

    @Override
    protected F32Vector newInstance(int newLength) {
        return new F32Vector(newLength < 0 ? this.data : new float[newLength]);
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
    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int end = this.nextIndex(iposEnd);
        for (int i = this.nextIndex((int)iposStart); i < end; ++i) {
            out.writeFloat(this.getFloat(i));
        }
    }

    public int compareTo(Object obj) {
        int n2;
        F32Vector vec2 = (F32Vector)obj;
        float[] arr1 = this.data;
        float[] arr2 = vec2.data;
        int n1 = this.size();
        int n = n1 > (n2 = vec2.size()) ? n2 : n1;
        for (int i = 0; i < n; ++i) {
            float v2;
            float v1 = arr1[this.effectiveIndex(i)];
            if (v1 == (v2 = arr2[this.effectiveIndex(i)])) continue;
            return v1 > v2 ? 1 : -1;
        }
        return n1 - n2;
    }
}

