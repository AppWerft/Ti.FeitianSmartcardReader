/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

public interface Array<E> {
    public boolean isEmpty();

    public int rank();

    public int getElementKind();

    public int effectiveIndex();

    public int effectiveIndex(int var1);

    public int effectiveIndex(int var1, int var2);

    public /* varargs */ int effectiveIndex(int var1, int var2, int var3, int ... var4);

    public int effectiveIndex(int[] var1);

    public E getRaw(int var1);

    public boolean getBooleanRaw(int var1);

    public char getCharRaw(int var1);

    public byte getByteRaw(int var1);

    public short getShortRaw(int var1);

    public int getIntRaw(int var1);

    public long getLongRaw(int var1);

    public float getFloatRaw(int var1);

    public double getDoubleRaw(int var1);

    public void setRaw(int var1, E var2);

    public E get();

    public E get(int var1);

    public E get(int var1, int var2);

    public /* varargs */ E get(int var1, int var2, int var3, int ... var4);

    public E get(int[] var1);

    public void set(int[] var1, E var2);

    public int getInt();

    public int getInt(int var1);

    public int getInt(int var1, int var2);

    public /* varargs */ int getInt(int var1, int var2, int var3, int ... var4);

    public int getInt(int[] var1);

    public E getRowMajor(int var1);

    public Array<E> asImmutable();

    public int getLowBound(int var1);

    public int getSize(int var1);

    public int getSize();
}

