/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.ShortVector;
import gnu.lists.SimpleVector;

public class S16Vector
extends ShortVector<Short> {
    public S16Vector() {
        this.data = empty;
    }

    public S16Vector(int size, short value) {
        short[] array = new short[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public S16Vector(int size) {
        this(new short[size]);
    }

    public S16Vector(short[] data) {
        this.data = data;
    }

    public S16Vector(short[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

    @Override
    public final int getIntRaw(int index) {
        return this.data[index];
    }

    @Override
    public final Short get(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final Short getRaw(int index) {
        return this.data[index];
    }

    @Override
    public final void setRaw(int index, Short value) {
        this.data[index] = value;
    }

    @Override
    protected S16Vector newInstance(int newLength) {
        return new S16Vector(newLength < 0 ? this.data : new short[newLength]);
    }

    @Override
    public int getElementKind() {
        return 20;
    }

    @Override
    public String getTag() {
        return "s16";
    }

    public int compareTo(Object obj) {
        return S16Vector.compareToInt(this, (S16Vector)obj);
    }
}

