// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class TreePosition extends SeqPosition implements Cloneable
{
    private Object xpos;
    AbstractSequence[] sstack;
    int[] istack;
    int depth;
    int start;
    
    public TreePosition() {
        this.depth = -1;
    }
    
    public TreePosition(final Object root) {
        this.xpos = root;
        this.depth = -1;
    }
    
    public TreePosition(final AbstractSequence seq, final int index) {
        super(seq, index, false);
    }
    
    public TreePosition(final TreePosition pos) {
        this.set(pos);
    }
    
    public Object clone() {
        return new TreePosition(this);
    }
    
    public void set(final TreePosition position) {
        this.release();
        final int d = position.depth;
        this.depth = d;
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
            final int j = i + position.start;
            final AbstractSequence seq = position.sstack[j];
            this.sstack[this.depth - 1] = seq;
            this.istack[this.depth - i] = seq.copyPos(position.istack[j]);
        }
        final AbstractSequence seq = position.sequence;
        this.sequence = (ESEQ)seq;
        this.ipos = seq.copyPos(position.ipos);
    }
    
    public int getDepth() {
        return this.depth + 1;
    }
    
    public AbstractSequence getRoot() {
        return (this.depth == 0) ? this.sequence : this.sstack[this.start];
    }
    
    public Object getPosNext() {
        return (this.sequence == null) ? this.xpos : this.sequence.getPosNext(this.ipos);
    }
    
    public void push(final AbstractSequence child, final int iposChild) {
        final int d = this.depth + this.start;
        if (d >= 0) {
            if (d == 0) {
                this.istack = new int[8];
                this.sstack = new AbstractSequence[8];
            }
            else if (d >= this.istack.length) {
                final int ndepth = 2 * d;
                final int[] itemp = new int[ndepth];
                final Object[] xtemp = new Object[ndepth];
                final AbstractSequence[] stemp = new AbstractSequence[ndepth];
                System.arraycopy(this.istack, 0, itemp, 0, this.depth);
                System.arraycopy(this.sstack, 0, stemp, 0, this.depth);
                this.istack = itemp;
                this.sstack = stemp;
            }
            this.sstack[d] = this.sequence;
            this.istack[d] = this.ipos;
        }
        ++this.depth;
        this.sequence = (ESEQ)child;
        this.ipos = iposChild;
    }
    
    public void pop() {
        this.sequence.releasePos(this.ipos);
        this.popNoRelease();
    }
    
    public void popNoRelease() {
        final int depth = this.depth - 1;
        this.depth = depth;
        if (depth < 0) {
            this.xpos = this.sequence;
            this.sequence = null;
        }
        else {
            this.sequence = (ESEQ)this.sstack[this.start + this.depth];
            this.ipos = this.istack[this.start + this.depth];
        }
    }
    
    public final boolean gotoParent() {
        return this.sequence != null && this.sequence.gotoParent(this);
    }
    
    @Override
    public boolean gotoChildrenStart() {
        if (this.sequence == null) {
            if (!(this.xpos instanceof AbstractSequence)) {
                return false;
            }
            this.depth = 0;
            this.sequence = (ESEQ)this.xpos;
            this.setPos(this.sequence.startPos());
        }
        else if (!this.sequence.gotoChildrenStart(this)) {
            return false;
        }
        return true;
    }
    
    public boolean gotoAttributesStart() {
        if (this.sequence == null) {
            if (this.xpos instanceof AbstractSequence) {}
            return false;
        }
        return this.sequence.gotoAttributesStart(this);
    }
    
    public Object getAncestor(final int up) {
        if (up == 0) {
            return this.sequence.getPosNext(this.ipos);
        }
        int i = this.depth - up;
        if (i <= 0) {
            return this.getRoot();
        }
        i += this.start;
        return this.sstack[i].getPosNext(this.istack[i]);
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
            final AbstractSequence seq = (i == 0) ? this.sequence : this.sstack[this.depth - i];
            System.err.print("#" + i + " seq:" + seq);
            System.err.println(" ipos:" + ((i == 0) ? this.ipos : this.istack[this.depth - i]));
        }
    }
}
