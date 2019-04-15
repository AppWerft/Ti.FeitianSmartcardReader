package gnu.xquery.util;

import gnu.kawa.functions.AddOp;
import gnu.lists.Sequence;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class Reduce
{
  public Reduce() {}
  
  public static Object sum(Object arg)
    throws Throwable
  {
    return sum(arg, IntNum.zero());
  }
  
  public static Object sum(Object arg, Object zero)
    throws Throwable
  {
    if ((arg instanceof Values))
    {
      Values tlist = (Values)arg;
      int pos = 0;
      Object next = tlist.getPosNext(pos);
      if (next == Sequence.eofValue)
        return zero;
      Object result = MinMax.convert(next);
      for (;;)
      {
        pos = tlist.nextPos(pos);
        next = tlist.getPosNext(pos);
        if (next == Sequence.eofValue)
          return result;
        next = MinMax.convert(next);
        result = AddOp.apply2(1, result, next);
      }
    }
    
    return (Number)MinMax.convert(arg);
  }
}
