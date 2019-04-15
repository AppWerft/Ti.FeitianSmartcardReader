/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.TreeScanner;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class AncestorOrSelfAxis
extends TreeScanner {
    public static AncestorOrSelfAxis make(NodePredicate type) {
        AncestorOrSelfAxis axis = new AncestorOrSelfAxis();
        axis.type = type;
        return axis;
    }

    private static void scan(AbstractSequence seq, int ipos, int end, NodePredicate type, PositionConsumer out) {
        if (ipos != end) {
            AncestorOrSelfAxis.scan(seq, seq.parentPos(ipos), end, type, out);
            if (type.isInstancePos(seq, ipos)) {
                out.writePosition(seq, ipos);
            }
        }
    }

    @Override
    public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
        int end = seq.endPos();
        AncestorOrSelfAxis.scan(seq, ipos, end, this.type, out);
    }
}

