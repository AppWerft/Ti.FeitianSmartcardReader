// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public abstract class TransformedArray<E> extends AbstractSequence<E> implements Array<E>
{
    protected Array<E> base;
    
    public TransformedArray() {
    }
    
    public TransformedArray(final Array<E> base) {
        this.base = base;
    }
    
    @Override
    public int getElementKind() {
        return this.base.getElementKind();
    }
    
    @Override
    public E getRowMajor(final int index) {
        return Arrays.getRowMajor((Array<E>)this, index);
    }
    
    @Override
    public E getRaw(final int effi) {
        return this.base.getRaw(effi);
    }
    
    @Override
    public boolean getBooleanRaw(final int effi) {
        return this.base.getBooleanRaw(effi);
    }
    
    @Override
    public byte getByteRaw(final int effi) {
        return this.base.getByteRaw(effi);
    }
    
    @Override
    public char getCharRaw(final int effi) {
        return this.base.getCharRaw(effi);
    }
    
    @Override
    public short getShortRaw(final int effi) {
        return this.base.getShortRaw(effi);
    }
    
    @Override
    public int getIntRaw(final int effi) {
        return this.base.getIntRaw(effi);
    }
    
    @Override
    public long getLongRaw(final int effi) {
        return this.base.getLongRaw(effi);
    }
    
    @Override
    public float getFloatRaw(final int effi) {
        return this.base.getFloatRaw(effi);
    }
    
    @Override
    public double getDoubleRaw(final int effi) {
        return this.base.getDoubleRaw(effi);
    }
    
    @Override
    public int getInt(final int i) {
        return this.base.getIntRaw(this.effectiveIndex(i));
    }
    
    @Override
    public int getInt(final int i, final int j) {
        return this.base.getIntRaw(this.effectiveIndex(i, j));
    }
    
    @Override
    public void setRaw(final int index, final E value) {
        this.base.setRaw(index, value);
    }
    
    @Override
    protected void checkCanWrite() {
        if (this.base instanceof AbstractSequence) {
            ((AbstractSequence)this.base).checkCanWrite();
        }
    }
}
