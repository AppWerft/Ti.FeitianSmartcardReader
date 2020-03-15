// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class SubSequence<E> extends AbstractSequence<E> implements Sequence<E>
{
    AbstractSequence<E> base;
    int ipos0;
    int ipos1;
    
    public SubSequence() {
    }
    
    public SubSequence(final AbstractSequence<E> base, final int startPos, final int endPos) {
        this.base = base;
        this.ipos0 = startPos;
        this.ipos1 = endPos;
    }
    
    public SubSequence(final AbstractSequence<E> base) {
        this.base = base;
    }
    
    @Override
    public E get(final int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        final int start = this.base.nextIndex(this.ipos0);
        return this.base.get(start + index);
    }
    
    @Override
    public int size() {
        return this.base.getIndexDifference(this.ipos1, this.ipos0);
    }
    
    public void removePosRange(final int istart, final int iend) {
        this.base.removePosRange((istart == 0) ? this.ipos0 : ((istart == -1) ? this.ipos1 : istart), (iend == -1) ? this.ipos1 : ((iend == 0) ? this.ipos0 : iend));
    }
    
    @Override
    protected boolean isAfterPos(final int ipos) {
        return this.base.isAfterPos(ipos);
    }
    
    @Override
    public int createPos(final int offset, final boolean isAfter) {
        return this.base.createRelativePos(this.ipos0, offset, isAfter);
    }
    
    @Override
    public int createRelativePos(final int pos, final int offset, final boolean isAfter) {
        return this.base.createRelativePos(pos, offset, isAfter);
    }
    
    @Override
    protected int getIndexDifference(final int ipos1, final int ipos0) {
        return this.base.getIndexDifference(ipos1, ipos0);
    }
    
    public void releasePos(final int ipos) {
        this.base.releasePos(ipos);
    }
    
    @Override
    protected int nextIndex(final int ipos) {
        return this.getIndexDifference(ipos, this.ipos0);
    }
    
    @Override
    public int compare(final int ipos1, final int ipos2) {
        return this.base.compare(ipos1, ipos2);
    }
    
    @Override
    public Object getPosNext(final int ipos) {
        if (this.base.compare(ipos, this.ipos1) >= 0) {
            return SubSequence.eofValue;
        }
        return this.base.getPosNext(ipos);
    }
    
    @Override
    public int getNextKind(final int ipos) {
        if (this.base.compare(ipos, this.ipos1) >= 0) {
            return 0;
        }
        return this.base.getNextKind(ipos);
    }
    
    @Override
    public int startPos() {
        return this.ipos0;
    }
    
    @Override
    public int endPos() {
        return this.ipos1;
    }
    
    @Override
    public Object getPosPrevious(final int ipos) {
        if (this.base.compare(ipos, this.ipos0) <= 0) {
            return SubSequence.eofValue;
        }
        return this.base.getPosPrevious(ipos);
    }
    
    @Override
    protected Sequence<E> subSequencePos(final int ipos0, final int ipos1) {
        return new SubSequence((AbstractSequence<Object>)this.base, ipos0, ipos1);
    }
    
    @Override
    public void clear() {
        this.removePosRange(this.ipos0, this.ipos1);
    }
    
    public void finalize() {
        this.base.releasePos(this.ipos0);
        this.base.releasePos(this.ipos1);
    }
}
