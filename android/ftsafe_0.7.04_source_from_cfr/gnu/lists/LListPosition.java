/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.EmptyList;
import gnu.lists.ExtPosition;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.SeqPosition;
import java.util.NoSuchElementException;

class LListPosition
extends ExtPosition<Object, LList> {
    Object xpos;

    public LListPosition(LListPosition old) {
        this.sequence = old.sequence;
        this.ipos = old.ipos;
        this.xpos = old.xpos;
    }

    public LListPosition copy() {
        return new LListPosition(this);
    }

    public LListPosition(LList seq, int index, boolean isAfter) {
        this.set(seq, index, isAfter);
    }

    @Override
    public void set(LList seq, int index, boolean isAfter) {
        this.sequence = seq;
        this.ipos = index << 1 | (isAfter ? 1 : 0);
        int skip = index;
        skip = isAfter ? (skip -= 2) : --skip;
        if (skip >= 0) {
            Object p = seq;
            while (--skip >= 0) {
                p = ((Pair)p).getCdr();
            }
            this.xpos = p;
        } else {
            this.xpos = null;
        }
    }

    @Override
    public boolean hasNext() {
        if (this.xpos == null) {
            if (this.ipos >> 1 == 0) {
                return this.sequence != LList.Empty;
            }
            return ((Pair)this.sequence).getCdr() != LList.Empty;
        }
        Object next = ((Pair)this.xpos).getCdr();
        if ((this.ipos & 1) > 0) {
            next = ((Pair)next).getCdr();
        }
        return next != LList.Empty;
    }

    @Override
    public boolean hasPrevious() {
        return this.ipos >>> 1 != 0;
    }

    public Pair getNextPair() {
        Object next;
        int isAfter = this.ipos & 1;
        if (isAfter > 0) {
            if (this.xpos == null) {
                next = this.sequence;
                if (this.ipos >> 1 != 0) {
                    next = ((Pair)next).getCdr();
                }
            } else {
                next = ((Pair)((Pair)this.xpos).getCdr()).getCdr();
            }
        } else {
            next = this.xpos == null ? this.sequence : ((Pair)this.xpos).getCdr();
        }
        if (next == LList.Empty) {
            return null;
        }
        return (Pair)next;
    }

    @Override
    public Object getNext() {
        Pair pair = this.getNextPair();
        return pair == null ? LList.eofValue : pair.getCar();
    }

    @Override
    public void setNext(Object value) {
        Pair pair = this.getNextPair();
        pair.car = value;
    }

    public Pair getPreviousPair() {
        int isAfter = this.ipos & 1;
        Object p = this.xpos;
        if (isAfter > 0) {
            p = p == null ? this.sequence : ((Pair)p).getCdr();
        } else if (p == null) {
            return null;
        }
        if (p == LList.Empty) {
            return null;
        }
        return (Pair)p;
    }

    @Override
    public Object getPrevious() {
        Pair pair = this.getPreviousPair();
        return pair == null ? LList.eofValue : pair.getCar();
    }

    @Override
    public void setPrevious(Object value) {
        Pair pair = this.getPreviousPair();
        pair.car = value;
    }

    @Override
    public int nextIndex() {
        return this.ipos >> 1;
    }

    @Override
    public Object next() {
        Pair pair = this.getNextPair();
        if (pair == null || !this.gotoNext()) {
            throw new NoSuchElementException();
        }
        return pair.getCar();
    }

    @Override
    public boolean gotoNext() {
        boolean isAfter = (this.ipos & 1) != 0;
        int old_i = this.ipos;
        Object xp = this.xpos;
        if (xp != null) {
            if (isAfter) {
                xp = ((Pair)xp).getCdr();
            }
            if (((Pair)xp).getCdr() == LList.Empty) {
                return false;
            }
            this.xpos = xp;
            this.ipos = (this.ipos | 1) + 2;
        } else if (this.ipos >> 1 == 0) {
            if (this.sequence == LList.Empty) {
                return false;
            }
            this.ipos = 3;
        } else {
            xp = this.sequence;
            if (((Pair)xp).getCdr() == LList.Empty) {
                return false;
            }
            this.ipos = 5;
            this.xpos = xp;
        }
        return true;
    }

    @Override
    public boolean gotoPrevious() {
        if (this.ipos >>> 1 == 0) {
            return false;
        }
        if ((this.ipos & 1) != 0) {
            this.ipos -= 3;
            return true;
        }
        int index = this.nextIndex();
        this.set((LList)this.sequence, index - 1, false);
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("LListPos[");
        sbuf.append("index:");
        sbuf.append(this.ipos);
        if (this.isAfter()) {
            sbuf.append(" after");
        }
        if (this.position >= 0) {
            sbuf.append(" position:");
            sbuf.append(this.position);
        }
        sbuf.append(']');
        return sbuf.toString();
    }
}

