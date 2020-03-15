// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class SelfAxis extends TreeScanner
{
    public static SelfAxis make(final NodePredicate type) {
        final SelfAxis axis = new SelfAxis();
        axis.type = type;
        return axis;
    }
    
    @Override
    public void scan(final AbstractSequence seq, final int ipos, final PositionConsumer out) {
        if (this.type.isInstancePos(seq, ipos)) {
            out.writePosition(seq, ipos);
        }
    }
}
