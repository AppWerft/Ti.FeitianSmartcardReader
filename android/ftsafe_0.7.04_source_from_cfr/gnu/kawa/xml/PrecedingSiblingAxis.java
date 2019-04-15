/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.TreeScanner;
import gnu.lists.AbstractSequence;
import gnu.lists.ItemPredicate;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class PrecedingSiblingAxis
extends TreeScanner {
    public static PrecedingSiblingAxis make(NodePredicate type) {
        PrecedingSiblingAxis axis = new PrecedingSiblingAxis();
        axis.type = type;
        return axis;
    }

    @Override
    public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
        int end = seq.endPos();
        int parent = seq.parentPos(ipos);
        if (parent == end) {
            return;
        }
        int child = seq.firstChildPos(parent);
        if (child == 0) {
            return;
        }
        if (this.type.isInstancePos(seq, child)) {
            out.writePosition(seq, child);
        }
        while ((child = seq.nextMatching(child, this.type, ipos, false)) != 0) {
            out.writePosition(seq, child);
        }
    }
}

