/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.ShortVector;
import gnu.lists.SimpleVector;
import gnu.math.UShort;

public class U16Vector
extends ShortVector<UShort> {
    public U16Vector() {
        this.data = empty;
    }

    public U16Vector(int size, short value) {
        short[] array = new short[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public U16Vector(int size) {
        this(new short[size]);
    }

    public U16Vector(short[] data) {
        this.data = data;
    }

    public U16Vector(short[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

    @Override
    public final int getIntRaw(int index) {
        return this.data[index] & 65535;
    }

    @Override
    public final UShort get(int index) {
        return UShort.valueOf(this.data[this.effectiveIndex(index)]);
    }

    @Override
    public final UShort getRaw(int index) {
        return UShort.valueOf(this.data[index]);
    }

    @Override
    public final void setRaw(int index, UShort value) {
        this.data[index] = value.shortValue();
    }

    @Override
    protected U16Vector newInstance(int newLength) {
        return new U16Vector(newLength < 0 ? this.data : new short[newLength]);
    }

    @Override
    public int getElementKind() {
        return 19;
    }

    @Override
    public String getTag() {
        return "u16";
    }

    public int compareTo(Object obj) {
        return U16Vector.compareToInt(this, (U16Vector)obj);
    }
}

