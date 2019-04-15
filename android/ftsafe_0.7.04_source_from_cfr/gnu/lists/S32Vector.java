/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.IntSequence;
import gnu.lists.IntVector;
import gnu.lists.SimpleVector;

public class S32Vector
extends IntVector<Integer>
implements IntSequence {
    public S32Vector() {
        this.data = empty;
    }

    public S32Vector(int size, int value) {
        int[] array = new int[size];
        this.data = array;
        if (value != 0) {
            while (--size >= 0) {
                array[size] = value;
            }
        }
    }

    public S32Vector(int size) {
        this(new int[size]);
    }

    public S32Vector(int[] data) {
        this.data = data;
    }

    public S32Vector(int[] values, int offset, int length) {
        this(length);
        System.arraycopy(values, offset, this.data, 0, length);
    }

    @Override
    public final long getLongRaw(int index) {
        return this.data[index];
    }

    @Override
    public final Integer get(int index) {
        return this.data[this.effectiveIndex(index)];
    }

    @Override
    public final Integer getRaw(int index) {
        return this.data[index];
    }

    @Override
    public final void setRaw(int index, Integer value) {
        this.data[index] = value;
    }

    @Override
    protected S32Vector newInstance(int newLength) {
        return new S32Vector(newLength < 0 ? this.data : new int[newLength]);
    }

    @Override
    public int getElementKind() {
        return 22;
    }

    @Override
    public String getTag() {
        return "s32";
    }

    public int compareTo(Object obj) {
        return S32Vector.compareToInt(this, (S32Vector)obj);
    }
}

