// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.ItemPredicate;
import gnu.lists.TreeList;
import gnu.lists.PositionConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;

public class DescendantOrSelfAxis extends TreeScanner
{
    public static final DescendantOrSelfAxis anyNode;
    
    private DescendantOrSelfAxis(final NodePredicate type) {
        this.type = type;
    }
    
    public static DescendantOrSelfAxis make(final NodePredicate type) {
        if (type == NodeType.anyNodeTest) {
            return DescendantOrSelfAxis.anyNode;
        }
        return new DescendantOrSelfAxis(type);
    }
    
    @Override
    public void scan(final AbstractSequence seq, int ipos, final PositionConsumer out) {
        if (this.type.isInstancePos(seq, ipos)) {
            out.writePosition(seq, ipos);
        }
        if (!(seq instanceof TreeList)) {
            for (ipos = seq.firstChildPos(ipos); ipos != 0; ipos = seq.nextPos(ipos)) {
                this.scan(seq, ipos, out);
            }
            return;
        }
        final int limit = seq.nextPos(ipos);
        int child = ipos;
        while (true) {
            child = seq.nextMatching(child, this.type, limit, true);
            if (child == 0) {
                break;
            }
            out.writePosition(seq, child);
        }
    }
    
    static {
        anyNode = new DescendantOrSelfAxis(NodeType.anyNodeTest);
    }
}
