/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.IntVector;
import gnu.lists.Sequences;
import gnu.lists.SimpleVector;
import gnu.math.UInt;

public class U32Vector
extends IntVector<UInt> {
    public U32Vector() {
        this.data = empty;
    }

    public U32Vector(int size, int value) {
        int[] array = new int[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public U32Vector(int size) {
        this(new int[size]);
    }

    public U32Vector(int[] data) {
        this.data = data;
    }

    public U32Vector(int[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

    @Override
    public final long getLongRaw(int index) {
        return (long)this.data[index] & 0xFFFFFFFFL;
    }

    @Override
    public final UInt get(int index) {
        return UInt.valueOf(this.data[this.effectiveIndex(index)]);
    }

    @Override
    public final UInt getRaw(int index) {
        return UInt.valueOf(this.data[index]);
    }

    @Override
    public final void setRaw(int index, UInt value) {
        this.data[index] = value.intValue();
    }

    @Override
    protected U32Vector newInstance(int newLength) {
        return new U32Vector(newLength < 0 ? this.data : new int[newLength]);
    }

    @Override
    public int getElementKind() {
        return 21;
    }

    @Override
    public String getTag() {
        return "u32";
    }

    @Override
    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        if (out.ignoring()) {
            return;
        }
        int end = this.nextIndex(iposEnd);
        for (int i = this.nextIndex((int)iposStart); i < end; ++i) {
            Sequences.writeUInt(this.getInt(i), out);
        }
    }

    public int compareTo(Object obj) {
        return U32Vector.compareToInt(this, (U32Vector)obj);
    }
}

