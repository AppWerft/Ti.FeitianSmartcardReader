/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.Sequence;
import java.util.Enumeration;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SeqPosition<E, ESEQ extends AbstractSequence<E>>
implements ListIterator<E>,
Enumeration<E> {
    public ESEQ sequence;
    public int ipos;

    public SeqPosition() {
    }

    public SeqPosition(ESEQ seq) {
        this.sequence = seq;
    }

    public SeqPosition(ESEQ seq, int offset, boolean isAfter) {
        this.sequence = seq;
        this.ipos = ((AbstractSequence)seq).createPos(offset, isAfter);
    }

    public SeqPosition(ESEQ seq, int ipos) {
        this.sequence = seq;
        this.ipos = ipos;
    }

    public static <E, ESEQ extends AbstractSequence<E>> SeqPosition<E, ESEQ> make(ESEQ seq, int ipos) {
        return new SeqPosition<E, ESEQ>(seq, ((AbstractSequence)seq).copyPos(ipos));
    }

    public SeqPosition<E, ESEQ> copy() {
        return new SeqPosition<E, ESEQ>(this.sequence, ((AbstractSequence)this.sequence).copyPos(this.getPos()));
    }

    public final void gotoStart(ESEQ seq) {
        this.setPos(seq, ((AbstractSequence)seq).startPos());
    }

    public final void gotoEnd(ESEQ seq) {
        this.setPos(seq, ((AbstractSequence)seq).endPos());
    }

    public boolean gotoChildrenStart() {
        int child = ((AbstractSequence)this.sequence).firstChildPos(this.getPos());
        if (child == 0) {
            return false;
        }
        this.ipos = child;
        return true;
    }

    @Override
    public final boolean hasMoreElements() {
        return this.hasNext();
    }

    @Override
    public boolean hasNext() {
        return ((AbstractSequence)this.sequence).hasNext(this.getPos());
    }

    public int getNextKind() {
        return ((AbstractSequence)this.sequence).getNextKind(this.getPos());
    }

    public String getNextTypeName() {
        return ((AbstractSequence)this.sequence).getNextTypeName(this.getPos());
    }

    public E getNextTypeObject() {
        return ((AbstractSequence)this.sequence).getNextTypeObject(this.getPos());
    }

    @Override
    public boolean hasPrevious() {
        return ((AbstractSequence)this.sequence).hasPrevious(this.getPos());
    }

    @Override
    public E next() {
        Object result = this.getNext();
        int next = ((AbstractSequence)this.sequence).nextPos(this.ipos);
        if (next == 0) {
            throw new NoSuchElementException();
        }
        this.ipos = next;
        return (E)result;
    }

    public boolean gotoNext() {
        int next = ((AbstractSequence)this.sequence).nextPos(this.ipos);
        if (next != 0) {
            this.ipos = next;
            return true;
        }
        this.ipos = -1;
        return false;
    }

    public boolean gotoPrevious() {
        int prev = ((AbstractSequence)this.sequence).previousPos(this.ipos);
        if (prev != -1) {
            this.ipos = prev;
            return true;
        }
        this.ipos = 0;
        return false;
    }

    @Override
    public E previous() {
        Object result = this.getPrevious();
        if (result == Sequence.eofValue || !this.gotoPrevious()) {
            throw new NoSuchElementException();
        }
        return (E)result;
    }

    @Override
    public final E nextElement() {
        return this.next();
    }

    public Object getNext() {
        return ((AbstractSequence)this.sequence).getPosNext(this.getPos());
    }

    public Object getPrevious() {
        return ((AbstractSequence)this.sequence).getPosPrevious(this.getPos());
    }

    @Override
    public int nextIndex() {
        return ((AbstractSequence)this.sequence).nextIndex(this.getPos());
    }

    public final int fromEndIndex() {
        return ((AbstractSequence)this.sequence).fromEndIndex(this.getPos());
    }

    public int getContainingSequenceSize() {
        return ((AbstractSequence)this.sequence).getContainingSequenceSize(this.getPos());
    }

    @Override
    public final int previousIndex() {
        return ((AbstractSequence)this.sequence).nextIndex(this.getPos()) - 1;
    }

    public boolean isAfter() {
        return ((AbstractSequence)this.sequence).isAfterPos(this.getPos());
    }

    @Override
    public final void set(E value) {
        if (this.isAfter()) {
            this.setPrevious(value);
        } else {
            this.setNext(value);
        }
    }

    public void setNext(E value) {
        ((AbstractSequence)this.sequence).setPosNext(this.getPos(), value);
    }

    public void setPrevious(E value) {
        ((AbstractSequence)this.sequence).setPosPrevious(this.getPos(), value);
    }

    @Override
    public void remove() {
        ((AbstractSequence)this.sequence).removePos(this.getPos(), this.isAfter() ? -1 : 1);
    }

    @Override
    public void add(E o) {
        this.setPos(((AbstractSequence)this.sequence).addPos(this.getPos(), o));
    }

    public int getPos() {
        return this.ipos;
    }

    public void setPos(ESEQ seq, int ipos) {
        if (this.sequence != null) {
            ((AbstractSequence)this.sequence).releasePos(this.getPos());
        }
        this.ipos = ipos;
        this.sequence = seq;
    }

    public void setPos(int ipos) {
        if (this.sequence != null) {
            ((AbstractSequence)this.sequence).releasePos(this.getPos());
        }
        this.ipos = ipos;
    }

    public void set(ESEQ seq, int index, boolean isAfter) {
        if (this.sequence != null) {
            ((AbstractSequence)this.sequence).releasePos(this.ipos);
        }
        this.sequence = seq;
        this.ipos = ((AbstractSequence)seq).createPos(index, isAfter);
    }

    @Override
    public void set(SeqPosition<E, ESEQ> pos) {
        if (this.sequence != null) {
            ((AbstractSequence)this.sequence).releasePos(this.ipos);
        }
        this.sequence = pos.sequence;
        pos.ipos = ((AbstractSequence)this.sequence).copyPos(pos.ipos);
    }

    public void release() {
        if (this.sequence != null) {
            ((AbstractSequence)this.sequence).releasePos(this.getPos());
            this.sequence = null;
        }
    }

    public void finalize() {
        this.release();
    }

    public String toString() {
        Object item;
        if (this.sequence == null) {
            return this.toInfo();
        }
        return "@" + this.nextIndex() + ": " + ((item = ((AbstractSequence)this.sequence).getPosNext(this.ipos)) == null ? "(null)" : item.toString());
    }

    public String toInfo() {
        StringBuffer sbuf = new StringBuffer(60);
        sbuf.append('{');
        if (this.sequence == null) {
            sbuf.append("null sequence");
        } else {
            sbuf.append(this.sequence.getClass().getName());
            sbuf.append('@');
            sbuf.append(System.identityHashCode(this.sequence));
        }
        sbuf.append(" ipos: ");
        sbuf.append(this.ipos);
        sbuf.append('}');
        return sbuf.toString();
    }
}

