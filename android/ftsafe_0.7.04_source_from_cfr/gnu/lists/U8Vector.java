/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.ByteVector;
import gnu.lists.SimpleVector;
import gnu.math.UByte;

public class U8Vector
extends ByteVector<UByte> {
    public U8Vector() {
        this.data = empty;
    }

    public U8Vector(int size, byte value) {
        byte[] array = new byte[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public U8Vector(int size) {
        this(new byte[size]);
    }

    public U8Vector(byte[] data) {
        this.data = data;
    }

    public U8Vector(byte[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

    @Override
    public final int getIntRaw(int index) {
        return this.data[index] & 255;
    }

    @Override
    public final UByte get(int index) {
        return UByte.valueOf(this.data[this.effectiveIndex(index)]);
    }

    @Override
    public final UByte getRaw(int index) {
        return UByte.valueOf(this.data[index]);
    }

    @Override
    public final void setRaw(int index, UByte value) {
        this.data[index] = value.byteValue();
    }

    @Override
    protected U8Vector newInstance(int newLength) {
        return new U8Vector(newLength < 0 ? this.data : new byte[newLength]);
    }

    @Override
    public int getElementKind() {
        return 17;
    }

    @Override
    public String getTag() {
        return "u8";
    }

    public int compareTo(Object obj) {
        return U8Vector.compareToInt(this, (U8Vector)obj);
    }
}

