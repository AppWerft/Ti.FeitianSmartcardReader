package gnu.kawa.xml;

import gnu.lists.SeqPosition;
import gnu.lists.TreeList;

public class Children extends gnu.mapping.MethodProc
{
  public Children() {}
  
  public static final Children children = new Children();
  
  public int numArgs() { return 4097; }
  
  public static void children(TreeList tlist, int index, gnu.lists.Consumer consumer)
  {
    int child = tlist.gotoChildrenStart(index);
    if (child < 0)
      return;
    int limit = tlist.nextDataIndex(index);
    for (;;)
    {
      int ipos = child << 1;
      
      int next = tlist.nextNodeIndex(child, limit);
      
      int next0 = next;
      if (next == child)
        next = tlist.nextDataIndex(child);
      if (next < 0)
        break;
      if ((consumer instanceof gnu.lists.PositionConsumer)) {
        ((gnu.lists.PositionConsumer)consumer).writePosition(tlist, ipos);
      } else
        tlist.consumeIRange(child, next, consumer);
      child = next;
    }
  }
  
  public static void children(Object node, gnu.lists.Consumer consumer)
  {
    if ((node instanceof TreeList))
    {
      children((TreeList)node, 0, consumer);
    }
    else if (((node instanceof SeqPosition)) && (!(node instanceof gnu.lists.TreePosition)))
    {
      SeqPosition pos = (SeqPosition)node;
      if ((sequence instanceof TreeList)) {
        children((TreeList)sequence, ipos >> 1, consumer);
      }
    }
  }
  
  public void apply(gnu.mapping.CallContext ctx) {
    gnu.lists.Consumer consumer = consumer;
    Object node = ctx.getNextArg();
    ctx.lastArg();
    if ((node instanceof gnu.mapping.Values))
    {
      TreeList tlist = (TreeList)node;
      int index = 0;
      for (;;)
      {
        int kind = tlist.getNextKind(index << 1);
        if (kind == 0)
          break;
        if (kind == 32) {
          children(tlist.getPosNext(index << 1), consumer);
        } else
          children(tlist, index, consumer);
        index = tlist.nextDataIndex(index);
      }
    }
    else {
      children(node, consumer);
    }
  }
}
