/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.TreeScanner;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class ParentAxis
extends TreeScanner {
    public static ParentAxis make(NodePredicate type) {
        ParentAxis axis = new ParentAxis();
        axis.type = type;
        return axis;
    }

    @Override
    public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
        int end;
        if ((ipos = seq.parentPos(ipos)) != (end = seq.endPos()) && this.type.isInstancePos(seq, ipos)) {
            out.writePosition(seq, ipos);
        }
    }
}

