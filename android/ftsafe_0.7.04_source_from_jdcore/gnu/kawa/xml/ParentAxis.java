package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class ParentAxis extends TreeScanner
{
  public ParentAxis() {}
  
  public static ParentAxis make(NodePredicate type)
  {
    ParentAxis axis = new ParentAxis();
    type = type;
    return axis;
  }
  
  public void scan(AbstractSequence seq, int ipos, PositionConsumer out)
  {
    ipos = seq.parentPos(ipos);
    int end = seq.endPos();
    if ((ipos != end) && (type.isInstancePos(seq, ipos))) {
      out.writePosition(seq, ipos);
    }
  }
}
