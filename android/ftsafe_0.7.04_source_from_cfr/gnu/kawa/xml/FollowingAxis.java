/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.TreeScanner;
import gnu.lists.AbstractSequence;
import gnu.lists.ItemPredicate;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class FollowingAxis
extends TreeScanner {
    public static FollowingAxis make(NodePredicate type) {
        FollowingAxis axis = new FollowingAxis();
        axis.type = type;
        return axis;
    }

    @Override
    public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
        int limit = seq.endPos();
        if ((ipos = seq.nextPos(ipos)) != 0 && this.type.isInstancePos(seq, ipos)) {
            out.writePosition(seq, ipos);
        }
        while ((ipos = seq.nextMatching(ipos, this.type, limit, true)) != 0) {
            out.writePosition(seq, ipos);
        }
    }
}

