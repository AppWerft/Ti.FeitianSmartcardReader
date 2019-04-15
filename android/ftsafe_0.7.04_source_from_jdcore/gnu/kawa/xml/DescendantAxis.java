package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class DescendantAxis extends TreeScanner
{
  public DescendantAxis() {}
  
  public static DescendantAxis make(NodePredicate type)
  {
    DescendantAxis axis = new DescendantAxis();
    type = type;
    return axis;
  }
  
  public void scan(AbstractSequence seq, int ipos, PositionConsumer out)
  {
    if (!(seq instanceof gnu.lists.TreeList))
    {
      ipos = seq.firstChildPos(ipos);
      while (ipos != 0)
      {
        if (type.isInstancePos(seq, ipos))
          out.writePosition(seq, ipos);
        scan(seq, ipos, out);
        ipos = seq.nextPos(ipos);
      }
      return;
    }
    int limit = seq.nextPos(ipos);
    int child = ipos;
    for (;;)
    {
      child = seq.nextMatching(child, type, limit, true);
      if (child == 0)
        break;
      out.writePosition(seq, child);
    }
  }
}
