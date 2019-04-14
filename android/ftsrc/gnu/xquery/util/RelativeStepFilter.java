package gnu.xquery.util;

import gnu.kawa.xml.SortedNodes;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;








public class RelativeStepFilter
  extends FilterConsumer
  implements PositionConsumer
{
  char seen;
  SortedNodes snodes;
  
  public RelativeStepFilter(Consumer base)
  {
    super(base);
  }
  

  public void writePosition(SeqPosition position)
  {
    writePosition(sequence, ipos);
  }
  
  public void writeObject(Object v)
  {
    if ((v instanceof SeqPosition))
    {
      SeqPosition n = (SeqPosition)v;
      writePosition(sequence, ipos);
    }
    else {
      super.writeObject(v);
    }
  }
  
  protected void beforeContent() {
    if (seen == 'N')
      throw new Error("path returns mix of atoms and nodes");
    seen = 'A';
  }
  
  public void writePosition(AbstractSequence seq, int ipos)
  {
    if (seen == 'A')
      throw new Error("path returns mix of atoms and nodes");
    seen = 'N';
    if (snodes == null)
      snodes = new SortedNodes();
    snodes.writePosition(seq, ipos);
  }
  
  public void finish()
  {
    if (snodes != null)
      snodes.consume(base);
    snodes = null;
  }
}
