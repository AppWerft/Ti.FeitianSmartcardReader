/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.Nodes;
import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;

public class SortedNodes
extends Nodes {
    private int compareIndex(int index, AbstractSequence seq2, int ipos2) {
        AbstractSequence seq1 = this.vector.getSeq(index);
        int ipos1 = this.vector.getPos(index);
        return AbstractSequence.compare(seq1, ipos1, seq2, ipos2);
    }

    private int find(int start, int count, AbstractSequence seq, int ipos) {
        int lo = 0;
        int hi = count;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            int cmp = this.compareIndex(start + mid, seq, ipos);
            if (cmp == 0) {
                return -1;
            }
            if (cmp > 0) {
                hi = mid;
                continue;
            }
            lo = mid + 1;
        }
        return start + lo;
    }

    int find(AbstractSequence seq, int ipos) {
        int cmp;
        int count = this.size();
        if (count <= 0) {
            return 0;
        }
        int lastIndex = this.vector.getLastIndex();
        int n = cmp = lastIndex < 0 ? -1 : this.compareIndex(lastIndex, seq, ipos);
        if (cmp < 0) {
            int i = lastIndex + 1;
            return this.find(i, count - i, seq, ipos);
        }
        if (cmp == 0) {
            return -1;
        }
        return this.find(0, lastIndex, seq, ipos);
    }

    @Override
    public void writePosition(SeqPosition position) {
        Object seq = position.sequence;
        int ipos = position.ipos;
        int i = this.find((AbstractSequence)seq, ipos);
        if (i >= 0) {
            this.vector.add(i, position);
        }
    }

    @Override
    public void writePosition(AbstractSequence seq, int ipos) {
        int i = this.find(seq, ipos);
        if (i >= 0) {
            this.vector.add(i, null);
            this.vector.setBuffer(i, seq, ipos);
        }
    }
}

