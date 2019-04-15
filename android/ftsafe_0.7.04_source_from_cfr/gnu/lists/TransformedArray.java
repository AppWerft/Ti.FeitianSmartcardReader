/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.Array;
import gnu.lists.Arrays;

public abstract class TransformedArray<E>
extends AbstractSequence<E>
implements Array<E> {
    protected Array<E> base;

    public TransformedArray() {
    }

    public TransformedArray(Array<E> base2) {
        this.base = base2;
    }

    @Override
    public int getElementKind() {
        return this.base.getElementKind();
    }

    @Override
    public E getRowMajor(int index) {
        return Arrays.getRowMajor(this, index);
    }

    @Override
    public E getRaw(int effi) {
        return this.base.getRaw(effi);
    }

    @Override
    public boolean getBooleanRaw(int effi) {
        return this.base.getBooleanRaw(effi);
    }

    @Override
    public byte getByteRaw(int effi) {
        return this.base.getByteRaw(effi);
    }

    @Override
    public char getCharRaw(int effi) {
        return this.base.getCharRaw(effi);
    }

    @Override
    public short getShortRaw(int effi) {
        return this.base.getShortRaw(effi);
    }

    @Override
    public int getIntRaw(int effi) {
        return this.base.getIntRaw(effi);
    }

    @Override
    public long getLongRaw(int effi) {
        return this.base.getLongRaw(effi);
    }

    @Override
    public float getFloatRaw(int effi) {
        return this.base.getFloatRaw(effi);
    }

    @Override
    public double getDoubleRaw(int effi) {
        return this.base.getDoubleRaw(effi);
    }

    @Override
    public int getInt(int i) {
        return this.base.getIntRaw(this.effectiveIndex(i));
    }

    @Override
    public int getInt(int i, int j) {
        return this.base.getIntRaw(this.effectiveIndex(i, j));
    }

    @Override
    public void setRaw(int index, E value) {
        this.base.setRaw(index, value);
    }

    @Override
    protected void checkCanWrite() {
        if (this.base instanceof AbstractSequence) {
            ((AbstractSequence)((Object)this.base)).checkCanWrite();
        }
    }
}

