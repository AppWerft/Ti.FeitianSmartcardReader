/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.xml.SortedNodes;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;

public class RelativeStepFilter
extends FilterConsumer
implements PositionConsumer {
    char seen;
    SortedNodes snodes;

    public RelativeStepFilter(Consumer base2) {
        super(base2);
    }

    @Override
    public void writePosition(SeqPosition position) {
        this.writePosition((AbstractSequence)position.sequence, position.ipos);
    }

    @Override
    public void writeObject(Object v) {
        if (v instanceof SeqPosition) {
            SeqPosition n = (SeqPosition)v;
            this.writePosition((AbstractSequence)n.sequence, n.ipos);
        } else {
            super.writeObject(v);
        }
    }

    @Override
    protected void beforeContent() {
        if (this.seen == 'N') {
            throw new Error("path returns mix of atoms and nodes");
        }
        this.seen = (char)65;
    }

    @Override
    public void writePosition(AbstractSequence seq, int ipos) {
        if (this.seen == 'A') {
            throw new Error("path returns mix of atoms and nodes");
        }
        this.seen = (char)78;
        if (this.snodes == null) {
            this.snodes = new SortedNodes();
        }
        this.snodes.writePosition(seq, ipos);
    }

    public void finish() {
        if (this.snodes != null) {
            this.snodes.consume(this.base);
        }
        this.snodes = null;
    }
}

