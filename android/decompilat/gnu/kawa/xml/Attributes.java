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

public class Attributes extends MethodProc
{
    public static final Attributes attributes;
    
    @Override
    public int numArgs() {
        return 4097;
    }
    
    public static void attributes(final TreeList tlist, final int index, final Consumer consumer) {
        int attr = tlist.gotoAttributesStart(index);
        System.out.print("Attributes called, at:" + attr + " ");
        tlist.dump();
        while (attr >= 0) {
            final int ipos = attr << 1;
            final int kind = tlist.getNextKind(ipos);
            if (kind != 35) {
                break;
            }
            final int next = tlist.nextDataIndex(attr);
            if (consumer instanceof PositionConsumer) {
                ((PositionConsumer)consumer).writePosition(tlist, ipos);
            }
            else {
                tlist.consumeIRange(attr, next, consumer);
            }
            attr = next;
        }
    }
    
    public static void attributes(final Object node, final Consumer consumer) {
        if (node instanceof TreeList) {
            attributes((TreeList)node, 0, consumer);
        }
        else if (node instanceof SeqPosition && !(node instanceof TreePosition)) {
            final SeqPosition pos = (SeqPosition)node;
            if (pos.sequence instanceof TreeList) {
                attributes((TreeList)pos.sequence, pos.ipos >> 1, consumer);
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
                    attributes(tlist.getPosNext(index << 1), consumer);
                }
                else {
                    attributes(tlist, index, consumer);
                }
                index = tlist.nextDataIndex(index);
            }
        }
        else {
            attributes(node, consumer);
        }
    }
    
    static {
        attributes = new Attributes();
    }
}
