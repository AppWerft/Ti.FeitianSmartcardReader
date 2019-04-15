/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.lists.TreePosition;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;

public class Children
extends MethodProc {
    public static final Children children = new Children();

    @Override
    public int numArgs() {
        return 4097;
    }

    public static void children(TreeList tlist, int index, Consumer consumer) {
        int child = tlist.gotoChildrenStart(index);
        if (child < 0) {
            return;
        }
        int limit = tlist.nextDataIndex(index);
        do {
            int next;
            int ipos = child << 1;
            int next0 = next = tlist.nextNodeIndex(child, limit);
            if (next == child) {
                next = tlist.nextDataIndex(child);
            }
            if (next < 0) break;
            if (consumer instanceof PositionConsumer) {
                ((PositionConsumer)((Object)consumer)).writePosition(tlist, ipos);
            } else {
                tlist.consumeIRange(child, next, consumer);
            }
            child = next;
        } while (true);
    }

    public static void children(Object node, Consumer consumer) {
        if (node instanceof TreeList) {
            Children.children((TreeList)node, 0, consumer);
        } else if (node instanceof SeqPosition && !(node instanceof TreePosition)) {
            SeqPosition pos = (SeqPosition)node;
            if (pos.sequence instanceof TreeList) {
                Children.children((TreeList)pos.sequence, pos.ipos >> 1, consumer);
            }
        }
    }

    @Override
    public void apply(CallContext ctx) {
        Consumer consumer = ctx.consumer;
        Object node = ctx.getNextArg();
        ctx.lastArg();
        if (node instanceof Values) {
            int kind;
            TreeList tlist = (TreeList)node;
            int index = 0;
            while ((kind = tlist.getNextKind(index << 1)) != 0) {
                if (kind == 32) {
                    Children.children(tlist.getPosNext(index << 1), consumer);
                } else {
                    Children.children(tlist, index, consumer);
                }
                index = tlist.nextDataIndex(index);
            }
        } else {
            Children.children(node, consumer);
        }
    }
}

