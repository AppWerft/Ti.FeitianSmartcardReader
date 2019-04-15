package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.mapping.Values;
import gnu.xml.NodeTree;
































































































class DistinctValuesConsumer
  extends FilterConsumer
  implements PositionConsumer
{
  DistinctValuesHashTable table;
  
  public DistinctValuesConsumer(NamedCollator collator, Consumer out)
  {
    super(out);
    table = new DistinctValuesHashTable(collator);
  }
  
  public void writePosition(SeqPosition position)
  {
    writeObject(position);
  }
  
  public void writePosition(AbstractSequence seq, int ipos)
  {
    writeObject(((NodeTree)seq).typedValue(ipos));
  }
  
  public void writeBoolean(boolean v)
  {
    writeObject(v ? Boolean.TRUE : Boolean.FALSE);
  }
  
  public void writeObject(Object value)
  {
    if ((value instanceof Values))
    {
      Values.writeValues(value, this);
      return;
    }
    if ((value instanceof KNode))
    {
      KNode node = (KNode)value;
      writeObject(((NodeTree)sequence).typedValue(ipos));
      return;
    }
    Object old = table.get(value, null);
    if (old != null)
      return;
    table.put(value, value);
    base.writeObject(value);
  }
}
