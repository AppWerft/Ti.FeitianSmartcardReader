package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class PrecedingAxis extends TreeScanner
{
  public PrecedingAxis() {}
  
  public static PrecedingAxis make(NodePredicate type)
  {
    PrecedingAxis axis = new PrecedingAxis();
    type = type;
    return axis;
  }
  

  private static void scan(AbstractSequence seq, int ipos, int end, NodePredicate type, PositionConsumer out)
  {
    int parent = seq.parentPos(ipos);
    if (parent == end)
      return;
    scan(seq, parent, ipos, type, out);
    int child = seq.firstChildPos(parent);
    if ((child == 0) || (child == ipos))
      return;
    if (type.isInstancePos(seq, child)) {
      out.writePosition(seq, child);
    }
    for (;;) {
      child = seq.nextMatching(child, type, ipos, true);
      if (child == 0)
        break;
      out.writePosition(seq, child);
    }
  }
  
  public void scan(AbstractSequence seq, int ipos, PositionConsumer out)
  {
    scan(seq, ipos, seq.endPos(), type, out);
  }
}
