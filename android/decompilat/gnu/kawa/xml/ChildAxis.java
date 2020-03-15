// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.ItemPredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class ChildAxis extends TreeScanner
{
    public static ChildAxis make(final NodePredicate type) {
        final ChildAxis axis = new ChildAxis();
        axis.type = type;
        return axis;
    }
    
    @Override
    public void scan(final AbstractSequence seq, final int ipos, final PositionConsumer out) {
        for (int child = seq.firstChildPos(ipos, this.type); child != 0; child = seq.nextMatching(child, this.type, -1, false)) {
            out.writePosition(seq, child);
        }
    }
}
