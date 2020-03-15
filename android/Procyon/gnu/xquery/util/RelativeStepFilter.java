// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;
import gnu.lists.Consumer;
import gnu.kawa.xml.SortedNodes;
import gnu.lists.PositionConsumer;
import gnu.lists.FilterConsumer;

public class RelativeStepFilter extends FilterConsumer implements PositionConsumer
{
    char seen;
    SortedNodes snodes;
    
    public RelativeStepFilter(final Consumer base) {
        super(base);
    }
    
    @Override
    public void writePosition(final SeqPosition position) {
        this.writePosition(position.sequence, position.ipos);
    }
    
    @Override
    public void writeObject(final Object v) {
        if (v instanceof SeqPosition) {
            final SeqPosition n = (SeqPosition)v;
            this.writePosition(n.sequence, n.ipos);
        }
        else {
            super.writeObject(v);
        }
    }
    
    @Override
    protected void beforeContent() {
        if (this.seen == 'N') {
            throw new Error("path returns mix of atoms and nodes");
        }
        this.seen = 'A';
    }
    
    @Override
    public void writePosition(final AbstractSequence seq, final int ipos) {
        if (this.seen == 'A') {
            throw new Error("path returns mix of atoms and nodes");
        }
        this.seen = 'N';
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
