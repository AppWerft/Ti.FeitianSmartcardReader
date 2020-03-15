// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class ParentAxis extends TreeScanner
{
    public static ParentAxis make(final NodePredicate type) {
        final ParentAxis axis = new ParentAxis();
        axis.type = type;
        return axis;
    }
    
    @Override
    public void scan(final AbstractSequence seq, int ipos, final PositionConsumer out) {
        ipos = seq.parentPos(ipos);
        final int end = seq.endPos();
        if (ipos != end && this.type.isInstancePos(seq, ipos)) {
            out.writePosition(seq, ipos);
        }
    }
}
