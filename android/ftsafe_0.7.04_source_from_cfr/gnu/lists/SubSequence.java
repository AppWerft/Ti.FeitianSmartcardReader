/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.Sequence;

public class SubSequence<E>
extends AbstractSequence<E>
implements Sequence<E> {
    AbstractSequence<E> base;
    int ipos0;
    int ipos1;

    public SubSequence() {
    }

    public SubSequence(AbstractSequence<E> base2, int startPos, int endPos) {
        this.base = base2;
        this.ipos0 = startPos;
        this.ipos1 = endPos;
    }

    public SubSequence(AbstractSequence<E> base2) {
        this.base = base2;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        int start = this.base.nextIndex(this.ipos0);
        return this.base.get(start + index);
    }

    @Override
    public int size() {
        return this.base.getIndexDifference(this.ipos1, this.ipos0);
    }

    @Override
    public void removePosRange(int istart, int iend) {
        this.base.removePosRange(istart == 0 ? this.ipos0 : (istart == -1 ? this.ipos1 : istart), iend == -1 ? this.ipos1 : (iend == 0 ? this.ipos0 : iend));
    }

    @Override
    protected boolean isAfterPos(int ipos) {
        return this.base.isAfterPos(ipos);
    }

    @Override
    public int createPos(int offset, boolean isAfter) {
        return this.base.createRelativePos(this.ipos0, offset, isAfter);
    }

    @Override
    public int createRelativePos(int pos, int offset, boolean isAfter) {
        return this.base.createRelativePos(pos, offset, isAfter);
    }

    @Override
    protected int getIndexDifference(int ipos1, int ipos0) {
        return this.base.getIndexDifference(ipos1, ipos0);
    }

    @Override
    public void releasePos(int ipos) {
        this.base.releasePos(ipos);
    }

    @Override
    protected int nextIndex(int ipos) {
        return this.getIndexDifference(ipos, this.ipos0);
    }

    @Override
    public int compare(int ipos1, int ipos2) {
        return this.base.compare(ipos1, ipos2);
    }

    @Override
    public Object getPosNext(int ipos) {
        if (this.base.compare(ipos, this.ipos1) >= 0) {
            return eofValue;
        }
        return this.base.getPosNext(ipos);
    }

    @Override
    public int getNextKind(int ipos) {
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
    public Object getPosPrevious(int ipos) {
        if (this.base.compare(ipos, this.ipos0) <= 0) {
            return eofValue;
        }
        return this.base.getPosPrevious(ipos);
    }

    @Override
    protected Sequence<E> subSequencePos(int ipos0, int ipos1) {
        return new SubSequence<E>(this.base, ipos0, ipos1);
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

