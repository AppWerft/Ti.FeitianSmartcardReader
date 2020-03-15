// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class AttributeAxis extends TreeScanner
{
    public static AttributeAxis make(final NodePredicate type) {
        final AttributeAxis axis = new AttributeAxis();
        axis.type = type;
        return axis;
    }
    
    @Override
    public void scan(final AbstractSequence seq, int ipos, final PositionConsumer out) {
        for (ipos = seq.firstAttributePos(ipos); ipos != 0 && seq.getNextKind(ipos) == 35; ipos = seq.nextPos(ipos)) {
            if (this.type.isInstancePos(seq, ipos)) {
                out.writePosition(seq, ipos);
            }
            else if (seq.getNextKind(ipos) != 35) {
                break;
            }
        }
    }
}
