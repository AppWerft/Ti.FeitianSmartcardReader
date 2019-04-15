/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.mapping.Values;
import gnu.xml.NodeTree;
import gnu.xquery.util.DistinctValuesHashTable;
import gnu.xquery.util.NamedCollator;

class DistinctValuesConsumer
extends FilterConsumer
implements PositionConsumer {
    DistinctValuesHashTable table;

    public DistinctValuesConsumer(NamedCollator collator, Consumer out) {
        super(out);
        this.table = new DistinctValuesHashTable(collator);
    }

    @Override
    public void writePosition(SeqPosition position) {
        this.writeObject(position);
    }

    @Override
    public void writePosition(AbstractSequence seq, int ipos) {
        this.writeObject(((NodeTree)seq).typedValue(ipos));
    }

    @Override
    public void writeBoolean(boolean v) {
        this.writeObject(v ? Boolean.TRUE : Boolean.FALSE);
    }

    @Override
    public void writeObject(Object value) {
        if (value instanceof Values) {
            Values.writeValues(value, this);
            return;
        }
        if (value instanceof KNode) {
            KNode node = (KNode)value;
            this.writeObject(((NodeTree)node.sequence).typedValue(node.ipos));
            return;
        }
        Object old = this.table.get(value, null);
        if (old != null) {
            return;
        }
        this.table.put(value, value);
        this.base.writeObject(value);
    }
}

