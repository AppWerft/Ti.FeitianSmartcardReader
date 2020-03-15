// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.util.List;

public class IndirectIndexedSeq<E> extends AbstractSequence<E> implements Sequence<E>, Array<E>
{
    List<E> base;
    IntSequence indexes;
    
    public IndirectIndexedSeq(final List<E> base, final IntSequence indexes) {
        this.base = base;
        this.indexes = indexes;
    }
    
    @Override
    public int size() {
        return this.indexes.size();
    }
    
    @Override
    public int getElementKind() {
        return (int)((this.base instanceof AbstractSequence) ? ((AbstractSequence)this.base).getElementKind() : null);
    }
    
    public int getBufferLength() {
        return this.base.size();
    }
    
    @Override
    public int effectiveIndex(final int i) {
        return this.indexes.getInt(i);
    }
    
    @Override
    public E get(final int index) {
        return this.base.get(this.indexes.getInt(index));
    }
    
    @Override
    public E set(final int index, final E value) {
        return this.base.set(this.indexes.getInt(index), value);
    }
    
    @Override
    public E getRaw(final int i) {
        return this.base.get(i);
    }
    
    @Override
    public void setRaw(final int index, final E value) {
        this.base.set(index, value);
    }
    
    public void copyBuffer(final int length) {
        throw this.unsupported("copyBuffer");
    }
}
