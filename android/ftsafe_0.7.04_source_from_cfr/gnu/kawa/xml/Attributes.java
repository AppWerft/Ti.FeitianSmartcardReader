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
import java.io.PrintStream;

public class Attributes
extends MethodProc {
    public static final Attributes attributes = new Attributes();

    @Override
    public int numArgs() {
        return 4097;
    }

    public static void attributes(TreeList tlist, int index, Consumer consumer) {
        int ipos;
        int kind;
        int attr = tlist.gotoAttributesStart(index);
        System.out.print("Attributes called, at:" + attr + " ");
        tlist.dump();
        while (attr >= 0 && (kind = tlist.getNextKind(ipos = attr << 1)) == 35) {
            int next = tlist.nextDataIndex(attr);
            if (consumer instanceof PositionConsumer) {
                ((PositionConsumer)((Object)consumer)).writePosition(tlist, ipos);
            } else {
                tlist.consumeIRange(attr, next, consumer);
            }
            attr = next;
        }
    }

    public static void attributes(Object node, Consumer consumer) {
        if (node instanceof TreeList) {
            Attributes.attributes((TreeList)node, 0, consumer);
        } else if (node instanceof SeqPosition && !(node instanceof TreePosition)) {
            SeqPosition pos = (SeqPosition)node;
            if (pos.sequence instanceof TreeList) {
                Attributes.attributes((TreeList)pos.sequence, pos.ipos >> 1, consumer);
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
                    Attributes.attributes(tlist.getPosNext(index << 1), consumer);
                } else {
                    Attributes.attributes(tlist, index, consumer);
                }
                index = tlist.nextDataIndex(index);
            }
        } else {
            Attributes.attributes(node, consumer);
        }
    }
}

