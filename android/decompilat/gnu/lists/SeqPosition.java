// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.util.NoSuchElementException;
import java.util.Enumeration;
import java.util.ListIterator;

public class SeqPosition<E, ESEQ extends AbstractSequence<E>> implements ListIterator<E>, Enumeration<E>
{
    public ESEQ sequence;
    public int ipos;
    
    public SeqPosition() {
    }
    
    public SeqPosition(final ESEQ seq) {
        this.sequence = seq;
    }
    
    public SeqPosition(final ESEQ seq, final int offset, final boolean isAfter) {
        this.sequence = seq;
        this.ipos = seq.createPos(offset, isAfter);
    }
    
    public SeqPosition(final ESEQ seq, final int ipos) {
        this.sequence = seq;
        this.ipos = ipos;
    }
    
    public static <E, ESEQ extends AbstractSequence<E>> SeqPosition<E, ESEQ> make(final ESEQ seq, final int ipos) {
        return new SeqPosition<E, ESEQ>(seq, seq.copyPos(ipos));
    }
    
    public SeqPosition<E, ESEQ> copy() {
        return new SeqPosition<E, ESEQ>(this.sequence, this.sequence.copyPos(this.getPos()));
    }
    
    public final void gotoStart(final ESEQ seq) {
        this.setPos(seq, seq.startPos());
    }
    
    public final void gotoEnd(final ESEQ seq) {
        this.setPos(seq, seq.endPos());
    }
    
    public boolean gotoChildrenStart() {
        final int child = this.sequence.firstChildPos(this.getPos());
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
        return this.sequence.hasNext(this.getPos());
    }
    
    public int getNextKind() {
        return this.sequence.getNextKind(this.getPos());
    }
    
    public String getNextTypeName() {
        return this.sequence.getNextTypeName(this.getPos());
    }
    
    public E getNextTypeObject() {
        return this.sequence.getNextTypeObject(this.getPos());
    }
    
    @Override
    public boolean hasPrevious() {
        return this.sequence.hasPrevious(this.getPos());
    }
    
    @Override
    public E next() {
        final Object result = this.getNext();
        final int next = this.sequence.nextPos(this.ipos);
        if (next == 0) {
            throw new NoSuchElementException();
        }
        this.ipos = next;
        return (E)result;
    }
    
    public boolean gotoNext() {
        final int next = this.sequence.nextPos(this.ipos);
        if (next != 0) {
            this.ipos = next;
            return true;
        }
        this.ipos = -1;
        return false;
    }
    
    public boolean gotoPrevious() {
        final int prev = this.sequence.previousPos(this.ipos);
        if (prev != -1) {
            this.ipos = prev;
            return true;
        }
        this.ipos = 0;
        return false;
    }
    
    @Override
    public E previous() {
        final Object result = this.getPrevious();
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
        return this.sequence.getPosNext(this.getPos());
    }
    
    public Object getPrevious() {
        return this.sequence.getPosPrevious(this.getPos());
    }
    
    @Override
    public int nextIndex() {
        return this.sequence.nextIndex(this.getPos());
    }
    
    public final int fromEndIndex() {
        return this.sequence.fromEndIndex(this.getPos());
    }
    
    public int getContainingSequenceSize() {
        return this.sequence.getContainingSequenceSize(this.getPos());
    }
    
    @Override
    public final int previousIndex() {
        return this.sequence.nextIndex(this.getPos()) - 1;
    }
    
    public boolean isAfter() {
        return this.sequence.isAfterPos(this.getPos());
    }
    
    @Override
    public final void set(final E value) {
        if (this.isAfter()) {
            this.setPrevious(value);
        }
        else {
            this.setNext(value);
        }
    }
    
    public void setNext(final E value) {
        this.sequence.setPosNext(this.getPos(), value);
    }
    
    public void setPrevious(final E value) {
        this.sequence.setPosPrevious(this.getPos(), value);
    }
    
    @Override
    public void remove() {
        this.sequence.removePos(this.getPos(), this.isAfter() ? -1 : 1);
    }
    
    @Override
    public void add(final E o) {
        this.setPos(this.sequence.addPos(this.getPos(), o));
    }
    
    public int getPos() {
        return this.ipos;
    }
    
    public void setPos(final ESEQ seq, final int ipos) {
        if (this.sequence != null) {
            this.sequence.releasePos(this.getPos());
        }
        this.ipos = ipos;
        this.sequence = seq;
    }
    
    public void setPos(final int ipos) {
        if (this.sequence != null) {
            this.sequence.releasePos(this.getPos());
        }
        this.ipos = ipos;
    }
    
    public void set(final ESEQ seq, final int index, final boolean isAfter) {
        if (this.sequence != null) {
            this.sequence.releasePos(this.ipos);
        }
        this.sequence = seq;
        this.ipos = seq.createPos(index, isAfter);
    }
    
    public void set(final SeqPosition<E, ESEQ> pos) {
        if (this.sequence != null) {
            this.sequence.releasePos(this.ipos);
        }
        this.sequence = pos.sequence;
        pos.ipos = this.sequence.copyPos(pos.ipos);
    }
    
    public void release() {
        if (this.sequence != null) {
            this.sequence.releasePos(this.getPos());
            this.sequence = null;
        }
    }
    
    public void finalize() {
        this.release();
    }
    
    @Override
    public String toString() {
        if (this.sequence == null) {
            return this.toInfo();
        }
        final Object item = this.sequence.getPosNext(this.ipos);
        return "@" + this.nextIndex() + ": " + ((item == null) ? "(null)" : item.toString());
    }
    
    public String toInfo() {
        final StringBuffer sbuf = new StringBuffer(60);
        sbuf.append('{');
        if (this.sequence == null) {
            sbuf.append("null sequence");
        }
        else {
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
