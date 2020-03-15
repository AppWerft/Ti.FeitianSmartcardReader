// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class AncestorOrSelfAxis extends TreeScanner
{
    public static AncestorOrSelfAxis make(final NodePredicate type) {
        final AncestorOrSelfAxis axis = new AncestorOrSelfAxis();
        axis.type = type;
        return axis;
    }
    
    private static void scan(final AbstractSequence seq, final int ipos, final int end, final NodePredicate type, final PositionConsumer out) {
        if (ipos != end) {
            scan(seq, seq.parentPos(ipos), end, type, out);
            if (type.isInstancePos(seq, ipos)) {
                out.writePosition(seq, ipos);
            }
        }
    }
    
    @Override
    public void scan(final AbstractSequence seq, final int ipos, final PositionConsumer out) {
        final int end = seq.endPos();
        scan(seq, ipos, end, this.type, out);
    }
}
