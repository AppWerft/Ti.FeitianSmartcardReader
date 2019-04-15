/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;
import java.io.PrintStream;

public class TreePosition
extends SeqPosition
implements Cloneable {
    private Object xpos;
    AbstractSequence[] sstack;
    int[] istack;
    int depth;
    int start;

    public TreePosition() {
        this.depth = -1;
    }

    public TreePosition(Object root) {
        this.xpos = root;
        this.depth = -1;
    }

    public TreePosition(AbstractSequence seq, int index) {
        super(seq, index, false);
    }

    public TreePosition(TreePosition pos) {
        this.set(pos);
    }

    public Object clone() {
        return new TreePosition(this);
    }

    @Override
    public void set(TreePosition position) {
        AbstractSequence seq;
        int d;
        this.release();
        this.depth = d = position.depth;
        if (d < 0) {
            this.xpos = position.xpos;
            return;
        }
        if (this.sstack == null || this.sstack.length <= d) {
            this.sstack = new AbstractSequence[d + 10];
        }
        if (this.istack == null || this.istack.length <= d) {
            this.istack = new int[d + 10];
        }
        for (int i = 0; i < this.depth; ++i) {
            int j = i + position.start;
            this.sstack[this.depth - 1] = seq = position.sstack[j];
            this.istack[this.depth - i] = seq.copyPos(position.istack[j]);
        }
        this.sequence = seq = position.sequence;
        this.ipos = seq.copyPos(position.ipos);
    }

    public int getDepth() {
        return this.depth + 1;
    }

    public AbstractSequence getRoot() {
        return this.depth == 0 ? this.sequence : this.sstack[this.start];
    }

    public Object getPosNext() {
        return this.sequence == null ? this.xpos : this.sequence.getPosNext(this.ipos);
    }

    public void push(AbstractSequence child, int iposChild) {
        int d = this.depth + this.start;
        if (d >= 0) {
            if (d == 0) {
                this.istack = new int[8];
                this.sstack = new AbstractSequence[8];
            } else if (d >= this.istack.length) {
                int ndepth = 2 * d;
                int[] itemp = new int[ndepth];
                Object[] xtemp = new Object[ndepth];
                AbstractSequence[] stemp = new AbstractSequence[ndepth];
                System.arraycopy(this.istack, 0, itemp, 0, this.depth);
                System.arraycopy(this.sstack, 0, stemp, 0, this.depth);
                this.istack = itemp;
                this.sstack = stemp;
            }
            this.sstack[d] = this.sequence;
            this.istack[d] = this.ipos;
        }
        ++this.depth;
        this.sequence = child;
        this.ipos = iposChild;
    }

    public void pop() {
        this.sequence.releasePos(this.ipos);
        this.popNoRelease();
    }

    public void popNoRelease() {
        if (--this.depth < 0) {
            this.xpos = this.sequence;
            this.sequence = null;
        } else {
            this.sequence = this.sstack[this.start + this.depth];
            this.ipos = this.istack[this.start + this.depth];
        }
    }

    public final boolean gotoParent() {
        return this.sequence == null ? false : this.sequence.gotoParent(this);
    }

    @Override
    public boolean gotoChildrenStart() {
        if (this.sequence == null) {
            if (!(this.xpos instanceof AbstractSequence)) {
                return false;
            }
            this.depth = 0;
            this.sequence = (AbstractSequence)this.xpos;
            this.setPos(this.sequence.startPos());
        } else if (!this.sequence.gotoChildrenStart(this)) {
            return false;
        }
        return true;
    }

    public boolean gotoAttributesStart() {
        if (this.sequence == null) {
            if (this.xpos instanceof AbstractSequence) {
                // empty if block
            }
            return false;
        }
        return this.sequence.gotoAttributesStart(this);
    }

    public Object getAncestor(int up) {
        if (up == 0) {
            return this.sequence.getPosNext(this.ipos);
        }
        int i = this.depth - up;
        if (i <= 0) {
            return this.getRoot();
        }
        return this.sstack[i].getPosNext(this.istack[i += this.start]);
    }

    @Override
    public void release() {
        while (this.sequence != null) {
            this.sequence.releasePos(this.ipos);
            this.pop();
        }
        this.xpos = null;
    }

    public void dump() {
        System.err.println("TreePosition dump depth:" + this.depth + " start:" + this.start);
        for (int i = 0; i <= this.depth; ++i) {
            AbstractSequence seq = i == 0 ? this.sequence : this.sstack[this.depth - i];
            System.err.print("#" + i + " seq:" + seq);
            System.err.println(" ipos:" + (i == 0 ? this.ipos : this.istack[this.depth - i]));
        }
    }
}

