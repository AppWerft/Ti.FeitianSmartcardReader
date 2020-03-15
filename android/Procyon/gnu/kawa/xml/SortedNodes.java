// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.SeqPosition;
import gnu.lists.AbstractSequence;

public class SortedNodes extends Nodes
{
    private int compareIndex(final int index, final AbstractSequence seq2, final int ipos2) {
        final AbstractSequence seq3 = this.vector.getSeq(index);
        final int ipos3 = this.vector.getPos(index);
        return AbstractSequence.compare(seq3, ipos3, seq2, ipos2);
    }
    
    private int find(final int start, final int count, final AbstractSequence seq, final int ipos) {
        int lo = 0;
        int hi = count;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int cmp = this.compareIndex(start + mid, seq, ipos);
            if (cmp == 0) {
                return -1;
            }
            if (cmp > 0) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return start + lo;
    }
    
    int find(final AbstractSequence seq, final int ipos) {
        final int count = this.size();
        if (count <= 0) {
            return 0;
        }
        final int lastIndex = this.vector.getLastIndex();
        final int cmp = (lastIndex < 0) ? -1 : this.compareIndex(lastIndex, seq, ipos);
        if (cmp < 0) {
            final int i = lastIndex + 1;
            return this.find(i, count - i, seq, ipos);
        }
        if (cmp == 0) {
            return -1;
        }
        return this.find(0, lastIndex, seq, ipos);
    }
    
    @Override
    public void writePosition(final SeqPosition position) {
        final AbstractSequence seq = position.sequence;
        final int ipos = position.ipos;
        final int i = this.find(seq, ipos);
        if (i >= 0) {
            this.vector.add(i, position);
        }
    }
    
    @Override
    public void writePosition(final AbstractSequence seq, final int ipos) {
        final int i = this.find(seq, ipos);
        if (i >= 0) {
            this.vector.add(i, null);
            this.vector.setBuffer(i, seq, ipos);
        }
    }
}
