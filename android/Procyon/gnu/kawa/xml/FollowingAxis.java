// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.ItemPredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class FollowingAxis extends TreeScanner
{
    public static FollowingAxis make(final NodePredicate type) {
        final FollowingAxis axis = new FollowingAxis();
        axis.type = type;
        return axis;
    }
    
    @Override
    public void scan(final AbstractSequence seq, int ipos, final PositionConsumer out) {
        final int limit = seq.endPos();
        ipos = seq.nextPos(ipos);
        if (ipos != 0 && this.type.isInstancePos(seq, ipos)) {
            out.writePosition(seq, ipos);
        }
        while (true) {
            ipos = seq.nextMatching(ipos, this.type, limit, true);
            if (ipos == 0) {
                break;
            }
            out.writePosition(seq, ipos);
        }
    }
}
