// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class AncestorAxis extends TreeScanner
{
    public static AncestorAxis make(final NodePredicate type) {
        final AncestorAxis axis = new AncestorAxis();
        axis.type = type;
        return axis;
    }
    
    private static void scan(final AbstractSequence seq, int ipos, final int end, final NodePredicate type, final PositionConsumer out) {
        ipos = seq.parentPos(ipos);
        if (ipos != end) {
            scan(seq, ipos, end, type, out);
            if (type.isInstancePos(seq, ipos)) {
                out.writePosition(seq, ipos);
            }
        }
    }
    
    @Override
    public void scan(final AbstractSequence seq, final int ipos, final PositionConsumer out) {
        scan(seq, ipos, seq.endPos(), this.type, out);
    }
}
