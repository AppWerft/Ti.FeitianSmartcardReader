package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import java.util.Iterator;
import java.util.List;



public class ListItems
  extends MethodProc
{
  public static ListItems listItems = new ListItems();
  
  public ListItems() {}
  
  public void apply(CallContext ctx) { Consumer out = consumer;
    Object arg = ctx.getNextArg();
    ctx.lastArg();
    

    List list = (List)arg;
    if ((arg instanceof AbstractSequence))
    {
      ((AbstractSequence)arg).consumePosRange(0, -1, out);
      return;
    }
    Iterator iter = list.iterator();
    while (iter.hasNext())
    {
      Object val = iter.next();
      Values.writeValues(val, out);
    }
  }
}
