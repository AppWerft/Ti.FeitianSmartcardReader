// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public interface Array<E>
{
    boolean isEmpty();
    
    int rank();
    
    int getElementKind();
    
    int effectiveIndex();
    
    int effectiveIndex(final int p0);
    
    int effectiveIndex(final int p0, final int p1);
    
    int effectiveIndex(final int p0, final int p1, final int p2, final int... p3);
    
    int effectiveIndex(final int[] p0);
    
    E getRaw(final int p0);
    
    boolean getBooleanRaw(final int p0);
    
    char getCharRaw(final int p0);
    
    byte getByteRaw(final int p0);
    
    short getShortRaw(final int p0);
    
    int getIntRaw(final int p0);
    
    long getLongRaw(final int p0);
    
    float getFloatRaw(final int p0);
    
    double getDoubleRaw(final int p0);
    
    void setRaw(final int p0, final E p1);
    
    E get();
    
    E get(final int p0);
    
    E get(final int p0, final int p1);
    
    E get(final int p0, final int p1, final int p2, final int... p3);
    
    E get(final int[] p0);
    
    void set(final int[] p0, final E p1);
    
    int getInt();
    
    int getInt(final int p0);
    
    int getInt(final int p0, final int p1);
    
    int getInt(final int p0, final int p1, final int p2, final int... p3);
    
    int getInt(final int[] p0);
    
    E getRowMajor(final int p0);
    
    Array<E> asImmutable();
    
    int getLowBound(final int p0);
    
    int getSize(final int p0);
    
    int getSize();
}
