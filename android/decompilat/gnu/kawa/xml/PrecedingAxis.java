// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.ItemPredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class PrecedingAxis extends TreeScanner
{
    public static PrecedingAxis make(final NodePredicate type) {
        final PrecedingAxis axis = new PrecedingAxis();
        axis.type = type;
        return axis;
    }
    
    private static void scan(final AbstractSequence seq, final int ipos, final int end, final NodePredicate type, final PositionConsumer out) {
        final int parent = seq.parentPos(ipos);
        if (parent == end) {
            return;
        }
        scan(seq, parent, ipos, type, out);
        int child = seq.firstChildPos(parent);
        if (child == 0 || child == ipos) {
            return;
        }
        if (type.isInstancePos(seq, child)) {
            out.writePosition(seq, child);
        }
        while (true) {
            child = seq.nextMatching(child, type, ipos, true);
            if (child == 0) {
                break;
            }
            out.writePosition(seq, child);
        }
    }
    
    @Override
    public void scan(final AbstractSequence seq, final int ipos, final PositionConsumer out) {
        scan(seq, ipos, seq.endPos(), this.type, out);
    }
}
