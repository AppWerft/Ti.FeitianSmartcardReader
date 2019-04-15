/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.ByteVector;
import gnu.lists.SimpleVector;

public class S8Vector
extends ByteVector<Byte> {
    public S8Vector() {
        this.data = empty;
    }

    public S8Vector(int size, byte value) {
        byte[] array = new byte[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public S8Vector(int size) {
        this(new byte[size]);
    }

    public S8Vector(byte[] data) {
        this.data = data;
    }

    public S8Vector(byte[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

    @Override
    public final int getIntRaw(int index) {
        return this.data[index];
    }

    @Override
    public final Byte get(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final Byte getRaw(int index) {
        return this.data[index];
    }

    @Override
    public final void setRaw(int index, Byte value) {
        this.data[index] = value;
    }

    @Override
    protected S8Vector newInstance(int newLength) {
        return new S8Vector(newLength < 0 ? this.data : new byte[newLength]);
    }

    @Override
    public int getElementKind() {
        return 18;
    }

    @Override
    public String getTag() {
        return "s8";
    }

    public int compareTo(Object obj) {
        return S8Vector.compareToInt(this, (S8Vector)obj);
    }
}

