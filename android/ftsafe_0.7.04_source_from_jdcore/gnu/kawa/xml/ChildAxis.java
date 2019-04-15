package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class ChildAxis extends TreeScanner
{
  public ChildAxis() {}
  
  public static ChildAxis make(NodePredicate type)
  {
    ChildAxis axis = new ChildAxis();
    type = type;
    return axis;
  }
  
  public void scan(AbstractSequence seq, int ipos, PositionConsumer out)
  {
    int child = seq.firstChildPos(ipos, type);
    while (child != 0)
    {
      out.writePosition(seq, child);
      child = seq.nextMatching(child, type, -1, false);
    }
  }
}
