package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class FollowingAxis extends TreeScanner
{
  public FollowingAxis() {}
  
  public static FollowingAxis make(NodePredicate type)
  {
    FollowingAxis axis = new FollowingAxis();
    type = type;
    return axis;
  }
  
  public void scan(AbstractSequence seq, int ipos, PositionConsumer out)
  {
    int limit = seq.endPos();
    ipos = seq.nextPos(ipos);
    if ((ipos != 0) && (type.isInstancePos(seq, ipos))) {
      out.writePosition(seq, ipos);
    }
    for (;;) {
      ipos = seq.nextMatching(ipos, type, limit, true);
      if (ipos == 0)
        break;
      out.writePosition(seq, ipos);
    }
  }
}
