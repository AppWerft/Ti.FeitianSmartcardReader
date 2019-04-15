/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.TreeScanner;
import gnu.lists.AbstractSequence;
import gnu.lists.ItemPredicate;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class FollowingSiblingAxis
extends TreeScanner {
    public static FollowingSiblingAxis make(NodePredicate type) {
        FollowingSiblingAxis axis = new FollowingSiblingAxis();
        axis.type = type;
        return axis;
    }

    @Override
    public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
        int limit = seq.endPos();
        while ((ipos = seq.nextMatching(ipos, this.type, limit, false)) != 0) {
            out.writePosition(seq, ipos);
        }
    }
}

