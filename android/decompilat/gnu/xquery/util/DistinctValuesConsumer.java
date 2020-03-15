// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.mapping.Values;
import gnu.xml.NodeTree;
import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.FilterConsumer;

class DistinctValuesConsumer extends FilterConsumer implements PositionConsumer
{
    DistinctValuesHashTable table;
    
    public DistinctValuesConsumer(final NamedCollator collator, final Consumer out) {
        super(out);
        this.table = new DistinctValuesHashTable(collator);
    }
    
    @Override
    public void writePosition(final SeqPosition position) {
        this.writeObject(position);
    }
    
    @Override
    public void writePosition(final AbstractSequence seq, final int ipos) {
        this.writeObject(((NodeTree)seq).typedValue(ipos));
    }
    
    @Override
    public void writeBoolean(final boolean v) {
        this.writeObject(v ? Boolean.TRUE : Boolean.FALSE);
    }
    
    @Override
    public void writeObject(final Object value) {
        if (value instanceof Values) {
            Values.writeValues(value, this);
            return;
        }
        if (value instanceof KNode) {
            final KNode node = (KNode)value;
            this.writeObject(((NodeTree)node.sequence).typedValue(node.ipos));
            return;
        }
        final Object old = this.table.get(value, null);
        if (old != null) {
            return;
        }
        this.table.put(value, value);
        this.base.writeObject(value);
    }
}
