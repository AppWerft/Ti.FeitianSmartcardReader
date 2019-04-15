package gnu.kawa.xml;

import gnu.lists.SeqPosition;
import gnu.lists.TreeList;

public class Attributes extends gnu.mapping.MethodProc
{
  public Attributes() {}
  
  public static final Attributes attributes = new Attributes();
  
  public int numArgs() { return 4097; }
  
  public static void attributes(TreeList tlist, int index, gnu.lists.Consumer consumer)
  {
    int attr = tlist.gotoAttributesStart(index);
    System.out.print("Attributes called, at:" + attr + " ");tlist.dump();
    while (attr >= 0)
    {
      int ipos = attr << 1;
      int kind = tlist.getNextKind(ipos);
      if (kind != 35) {
        break;
      }
      int next = tlist.nextDataIndex(attr);
      if ((consumer instanceof gnu.lists.PositionConsumer)) {
        ((gnu.lists.PositionConsumer)consumer).writePosition(tlist, ipos);
      } else
        tlist.consumeIRange(attr, next, consumer);
      attr = next;
    }
  }
  
  public static void attributes(Object node, gnu.lists.Consumer consumer)
  {
    if ((node instanceof TreeList))
    {
      attributes((TreeList)node, 0, consumer);
    }
    else if (((node instanceof SeqPosition)) && (!(node instanceof gnu.lists.TreePosition)))
    {
      SeqPosition pos = (SeqPosition)node;
      if ((sequence instanceof TreeList)) {
        attributes((TreeList)sequence, ipos >> 1, consumer);
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
          attributes(tlist.getPosNext(index << 1), consumer);
        } else
          attributes(tlist, index, consumer);
        index = tlist.nextDataIndex(index);
      }
    }
    else {
      attributes(node, consumer);
    }
  }
}
