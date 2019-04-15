/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.TreeScanner;
import gnu.lists.AbstractSequence;
import gnu.lists.ItemPredicate;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.TreeList;

public class DescendantAxis
extends TreeScanner {
    public static DescendantAxis make(NodePredicate type) {
        DescendantAxis axis = new DescendantAxis();
        axis.type = type;
        return axis;
    }

    @Override
    public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
        if (!(seq instanceof TreeList)) {
            ipos = seq.firstChildPos(ipos);
            while (ipos != 0) {
                if (this.type.isInstancePos(seq, ipos)) {
                    out.writePosition(seq, ipos);
                }
                this.scan(seq, ipos, out);
                ipos = seq.nextPos(ipos);
            }
            return;
        }
        int limit = seq.nextPos(ipos);
        int child = ipos;
        while ((child = seq.nextMatching(child, this.type, limit, true)) != 0) {
            out.writePosition(seq, child);
        }
    }
}

