// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.ItemPredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class PrecedingSiblingAxis extends TreeScanner
{
    public static PrecedingSiblingAxis make(final NodePredicate type) {
        final PrecedingSiblingAxis axis = new PrecedingSiblingAxis();
        axis.type = type;
        return axis;
    }
    
    @Override
    public void scan(final AbstractSequence seq, final int ipos, final PositionConsumer out) {
        final int end = seq.endPos();
        final int parent = seq.parentPos(ipos);
        if (parent == end) {
            return;
        }
        int child = seq.firstChildPos(parent);
        if (child == 0) {
            return;
        }
        if (this.type.isInstancePos(seq, child)) {
            out.writePosition(seq, child);
        }
        while (true) {
            child = seq.nextMatching(child, this.type, ipos, false);
            if (child == 0) {
                break;
            }
            out.writePosition(seq, child);
        }
    }
}
