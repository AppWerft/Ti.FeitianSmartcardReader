// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.ItemPredicate;
import gnu.lists.TreeList;
import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class DescendantAxis extends TreeScanner
{
    public static DescendantAxis make(final NodePredicate type) {
        final DescendantAxis axis = new DescendantAxis();
        axis.type = type;
        return axis;
    }
    
    @Override
    public void scan(final AbstractSequence seq, int ipos, final PositionConsumer out) {
        if (!(seq instanceof TreeList)) {
            for (ipos = seq.firstChildPos(ipos); ipos != 0; ipos = seq.nextPos(ipos)) {
                if (this.type.isInstancePos(seq, ipos)) {
                    out.writePosition(seq, ipos);
                }
                this.scan(seq, ipos, out);
            }
            return;
        }
        final int limit = seq.nextPos(ipos);
        int child = ipos;
        while (true) {
            child = seq.nextMatching(child, this.type, limit, true);
            if (child == 0) {
                break;
            }
            out.writePosition(seq, child);
        }
    }
}
