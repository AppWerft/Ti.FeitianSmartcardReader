/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.TreeScanner;
import gnu.lists.AbstractSequence;
import gnu.lists.ItemPredicate;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class ChildAxis
extends TreeScanner {
    public static ChildAxis make(NodePredicate type) {
        ChildAxis axis = new ChildAxis();
        axis.type = type;
        return axis;
    }

    @Override
    public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
        int child = seq.firstChildPos(ipos, this.type);
        while (child != 0) {
            out.writePosition(seq, child);
            child = seq.nextMatching(child, this.type, -1, false);
        }
    }
}

