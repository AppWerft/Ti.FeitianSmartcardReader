/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.TreeScanner;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class AncestorAxis
extends TreeScanner {
    public static AncestorAxis make(NodePredicate type) {
        AncestorAxis axis = new AncestorAxis();
        axis.type = type;
        return axis;
    }

    private static void scan(AbstractSequence seq, int ipos, int end, NodePredicate type, PositionConsumer out) {
        if ((ipos = seq.parentPos(ipos)) != end) {
            AncestorAxis.scan(seq, ipos, end, type, out);
            if (type.isInstancePos(seq, ipos)) {
                out.writePosition(seq, ipos);
            }
        }
    }

    @Override
    public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
        AncestorAxis.scan(seq, ipos, seq.endPos(), this.type, out);
    }
}

