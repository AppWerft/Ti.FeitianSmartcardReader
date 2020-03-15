// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.mapping.Values;
import gnu.mapping.Procedure2;

public class IntersectNodes extends Procedure2
{
    boolean isExcept;
    public static final IntersectNodes intersectNodes;
    public static final IntersectNodes exceptNodes;
    
    public IntersectNodes(final boolean isExcept) {
        this.isExcept = isExcept;
    }
    
    @Override
    public Object apply2(final Object vals1, final Object vals2) {
        final SortedNodes nodes1 = new SortedNodes();
        final SortedNodes nodes2 = new SortedNodes();
        final SortedNodes result = new SortedNodes();
        Values.writeValues(vals1, nodes1);
        Values.writeValues(vals2, nodes2);
        int i2 = 0;
        AbstractSequence seq2 = null;
        int ipos2 = 0;
        int cmp = 0;
        int i3 = 0;
        while (true) {
            final AbstractSequence seq3 = nodes1.getSeq(i3);
            if (seq3 == null) {
                break;
            }
            final int ipos3 = nodes1.getPos(i3);
            if (cmp == -1) {
                cmp = AbstractSequence.compare(seq3, ipos3, seq2, ipos2);
            }
            else if (cmp == 0) {
                cmp = 1;
            }
            while (cmp > 0) {
                seq2 = nodes2.getSeq(i2);
                if (seq2 == null) {
                    cmp = -2;
                    break;
                }
                ipos2 = nodes2.getPos(i2++);
                cmp = AbstractSequence.compare(seq3, ipos3, seq2, ipos2);
            }
            if (cmp == 0 != this.isExcept) {
                result.writePosition(seq3, ipos3);
            }
            ++i3;
        }
        return result;
    }
    
    static {
        intersectNodes = new IntersectNodes(false);
        exceptNodes = new IntersectNodes(true);
    }
}
