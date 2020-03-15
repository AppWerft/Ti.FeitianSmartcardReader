// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.ItemPredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class FollowingSiblingAxis extends TreeScanner
{
    public static FollowingSiblingAxis make(final NodePredicate type) {
        final FollowingSiblingAxis axis = new FollowingSiblingAxis();
        axis.type = type;
        return axis;
    }
    
    @Override
    public void scan(final AbstractSequence seq, int ipos, final PositionConsumer out) {
        final int limit = seq.endPos();
        while (true) {
            ipos = seq.nextMatching(ipos, this.type, limit, false);
            if (ipos == 0) {
                break;
            }
            out.writePosition(seq, ipos);
        }
    }
}
