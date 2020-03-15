// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.mapping.Values;
import gnu.mapping.CallContext;
import gnu.lists.TreePosition;
import gnu.lists.SeqPosition;
import gnu.lists.AbstractSequence;
import gnu.lists.PositionConsumer;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.mapping.MethodProc;

public class Children extends MethodProc
{
    public static final Children children;
    
    @Override
    public int numArgs() {
        return 4097;
    }
    
    public static void children(final TreeList tlist, final int index, final Consumer consumer) {
        int child = tlist.gotoChildrenStart(index);
        if (child < 0) {
            return;
        }
        final int limit = tlist.nextDataIndex(index);
        while (true) {
            final int ipos = child << 1;
            final int next2;
            int next = next2 = tlist.nextNodeIndex(child, limit);
            if (next == child) {
                next = tlist.nextDataIndex(child);
            }
            if (next < 0) {
                break;
            }
            if (consumer instanceof PositionConsumer) {
                ((PositionConsumer)consumer).writePosition(tlist, ipos);
            }
            else {
                tlist.consumeIRange(child, next, consumer);
            }
            child = next;
        }
    }
    
    public static void children(final Object node, final Consumer consumer) {
        if (node instanceof TreeList) {
            children((TreeList)node, 0, consumer);
        }
        else if (node instanceof SeqPosition && !(node instanceof TreePosition)) {
            final SeqPosition pos = (SeqPosition)node;
            if (pos.sequence instanceof TreeList) {
                children((TreeList)pos.sequence, pos.ipos >> 1, consumer);
            }
        }
    }
    
    @Override
    public void apply(final CallContext ctx) {
        final Consumer consumer = ctx.consumer;
        final Object node = ctx.getNextArg();
        ctx.lastArg();
        if (node instanceof Values) {
            final TreeList tlist = (TreeList)node;
            int index = 0;
            while (true) {
                final int kind = tlist.getNextKind(index << 1);
                if (kind == 0) {
                    break;
                }
                if (kind == 32) {
                    children(tlist.getPosNext(index << 1), consumer);
                }
                else {
                    children(tlist, index, consumer);
                }
                index = tlist.nextDataIndex(index);
            }
        }
        else {
            children(node, consumer);
        }
    }
    
    static {
        children = new Children();
    }
}
