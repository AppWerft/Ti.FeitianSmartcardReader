/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.TreeScanner;
import gnu.lists.AbstractSequence;
import gnu.lists.ItemPredicate;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class PrecedingAxis
extends TreeScanner {
    public static PrecedingAxis make(NodePredicate type) {
        PrecedingAxis axis = new PrecedingAxis();
        axis.type = type;
        return axis;
    }

    private static void scan(AbstractSequence seq, int ipos, int end, NodePredicate type, PositionConsumer out) {
        int parent = seq.parentPos(ipos);
        if (parent == end) {
            return;
        }
        PrecedingAxis.scan(seq, parent, ipos, type, out);
        int child = seq.firstChildPos(parent);
        if (child == 0 || child == ipos) {
            return;
        }
        if (type.isInstancePos(seq, child)) {
            out.writePosition(seq, child);
        }
        while ((child = seq.nextMatching(child, type, ipos, true)) != 0) {
            out.writePosition(seq, child);
        }
    }

    @Override
    public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
        PrecedingAxis.scan(seq, ipos, seq.endPos(), this.type, out);
    }
}

