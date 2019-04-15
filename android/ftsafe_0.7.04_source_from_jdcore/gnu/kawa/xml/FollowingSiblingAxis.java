package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class FollowingSiblingAxis extends TreeScanner
{
  public FollowingSiblingAxis() {}
  
  public static FollowingSiblingAxis make(NodePredicate type)
  {
    FollowingSiblingAxis axis = new FollowingSiblingAxis();
    type = type;
    return axis;
  }
  
  public void scan(AbstractSequence seq, int ipos, PositionConsumer out)
  {
    int limit = seq.endPos();
    for (;;)
    {
      ipos = seq.nextMatching(ipos, type, limit, false);
      if (ipos == 0)
        break;
      out.writePosition(seq, ipos);
    }
  }
}
