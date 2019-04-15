/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.SortedNodes;
import gnu.lists.AbstractSequence;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;

public class IntersectNodes
extends Procedure2 {
    boolean isExcept;
    public static final IntersectNodes intersectNodes = new IntersectNodes(false);
    public static final IntersectNodes exceptNodes = new IntersectNodes(true);

    public IntersectNodes(boolean isExcept) {
        this.isExcept = isExcept;
    }

    @Override
    public Object apply2(Object vals1, Object vals2) {
        AbstractSequence seq1;
        SortedNodes nodes1 = new SortedNodes();
        SortedNodes nodes2 = new SortedNodes();
        SortedNodes result = new SortedNodes();
        Values.writeValues(vals1, nodes1);
        Values.writeValues(vals2, nodes2);
        int i2 = 0;
        AbstractSequence seq2 = null;
        int ipos2 = 0;
        int cmp = 0;
        int i1 = 0;
        while ((seq1 = nodes1.getSeq(i1)) != null) {
            int ipos1 = nodes1.getPos(i1);
            if (cmp == -1) {
                cmp = AbstractSequence.compare(seq1, ipos1, seq2, ipos2);
            } else if (cmp == 0) {
                cmp = 1;
            }
            while (cmp > 0) {
                seq2 = nodes2.getSeq(i2);
                if (seq2 == null) {
                    cmp = -2;
                    break;
                }
                ipos2 = nodes2.getPos(i2++);
                cmp = AbstractSequence.compare(seq1, ipos1, seq2, ipos2);
            }
            if (cmp == 0 != this.isExcept) {
                result.writePosition(seq1, ipos1);
            }
            ++i1;
        }
        return result;
    }
}

