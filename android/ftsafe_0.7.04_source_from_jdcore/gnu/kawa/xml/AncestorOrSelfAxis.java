package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class AncestorOrSelfAxis extends TreeScanner
{
  public AncestorOrSelfAxis() {}
  
  public static AncestorOrSelfAxis make(NodePredicate type)
  {
    AncestorOrSelfAxis axis = new AncestorOrSelfAxis();
    type = type;
    return axis;
  }
  

  private static void scan(AbstractSequence seq, int ipos, int end, NodePredicate type, PositionConsumer out)
  {
    if (ipos != end)
    {
      scan(seq, seq.parentPos(ipos), end, type, out);
      if (type.isInstancePos(seq, ipos)) {
        out.writePosition(seq, ipos);
      }
    }
  }
  
  public void scan(AbstractSequence seq, int ipos, PositionConsumer out) {
    int end = seq.endPos();
    scan(seq, ipos, end, type, out);
  }
}
