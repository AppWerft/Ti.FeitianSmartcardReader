package gnu.xquery.util;

import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.FilterConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;































public class OrderedTuples
  extends FilterConsumer
{
  int n;
  Object[] tuples;
  Object[] comps;
  int first;
  int[] next;
  Procedure body;
  
  public boolean ignoring()
  {
    return false;
  }
  
  public void writeObject(Object v) {
    if (n >= tuples.length)
    {
      Object[] tmp = new Object[2 * n];
      System.arraycopy(tuples, 0, tmp, 0, n);
      tuples = tmp;
    }
    tuples[(n++)] = v;
  }
  
  OrderedTuples()
  {
    super(null);
    tuples = new Object[10];
  }
  
  public static OrderedTuples make$V(Procedure body, Object[] comps)
  {
    OrderedTuples tuples = new OrderedTuples();
    comps = comps;
    body = body;
    return tuples;
  }
  
  public void run$X(CallContext ctx) throws Throwable
  {
    first = listsort(0);
    emit(ctx);
  }
  
  void emit(CallContext ctx) throws Throwable
  {
    for (int p = first; p >= 0; p = next[p]) {
      emit(p, ctx);
    }
  }
  
  void emit(int index, CallContext ctx) throws Throwable {
    Object[] args = (Object[])tuples[index];
    body.checkN(args, ctx);
    ctx.runUntilDone();
  }
  






































  int cmp(int a, int b)
    throws Throwable
  {
    for (int i = 0; i < comps.length; i += 3)
    {
      Procedure comparator = (Procedure)comps[i];
      String flags = (String)comps[(i + 1)];
      NamedCollator collator = (NamedCollator)comps[(i + 2)];
      if (collator == null)
        collator = NamedCollator.codepointCollation;
      Object val1 = comparator.applyN((Object[])tuples[a]);
      Object val2 = comparator.applyN((Object[])tuples[b]);
      val1 = KNode.atomicValue(val1);
      val2 = KNode.atomicValue(val2);
      if ((val1 instanceof UntypedAtomic))
        val1 = val1.toString();
      if ((val2 instanceof UntypedAtomic))
        val2 = val2.toString();
      boolean empty1 = SequenceUtils.isEmptySequence(val1);
      boolean empty2 = SequenceUtils.isEmptySequence(val2);
      if ((!empty1) || (!empty2)) {
        int c;
        int c;
        if ((empty1) || (empty2))
        {
          char emptyOrder = flags.charAt(1);
          c = empty1 == (emptyOrder == 'L') ? -1 : 1;
        }
        else
        {
          boolean isNaN1 = ((val1 instanceof Number)) && (Double.isNaN(((Number)val1).doubleValue()));
          
          boolean isNaN2 = ((val2 instanceof Number)) && (Double.isNaN(((Number)val2).doubleValue()));
          
          if ((isNaN1) && (isNaN2)) continue;
          int c;
          if ((isNaN1) || (isNaN2))
          {
            char emptyOrder = flags.charAt(1);
            c = isNaN1 == (emptyOrder == 'L') ? -1 : 1;
          } else { int c;
            if (((val1 instanceof Number)) && ((val2 instanceof Number))) {
              c = NumberCompare.compare(val1, val2, false);
            } else
              c = collator.compare(val1.toString(), val2.toString());
          } }
        if (c != 0)
        {
          return flags.charAt(0) == 'A' ? c : -c; }
      } }
    return 0;
  }
  


















  int listsort(int list)
    throws Throwable
  {
    if (n == 0) {
      return -1;
    }
    next = new int[n];
    
    for (int i = 1;; i++)
    {
      if (i == n)
      {
        next[(i - 1)] = -1;
        break;
      }
      
      next[(i - 1)] = i;
    }
    
    int insize = 1;
    for (;;)
    {
      int p = list;
      list = -1;
      int tail = -1;
      
      int nmerges = 0;
      
      while (p >= 0) {
        nmerges++;
        
        int q = p;
        int psize = 0;
        for (i = 0; i < insize; i++) {
          psize++;
          q = next[q];
          if (q < 0)
            break;
        }
        int qsize = insize;
        

        while ((psize > 0) || ((qsize > 0) && (q >= 0)))
        {
          int e;
          if (psize == 0)
          {
            int e = q;q = next[q];qsize--;
          } else if ((qsize == 0) || (q < 0))
          {
            int e = p;p = next[p];psize--;
          } else if (cmp(p, q) <= 0)
          {

            int e = p;p = next[p];psize--;
          }
          else {
            e = q;q = next[q];qsize--;
          }
          

          if (tail >= 0) {
            next[tail] = e;
          } else
            list = e;
          tail = e;
        }
        

        p = q;
      }
      next[tail] = -1;
      

      if (nmerges <= 1) {
        return list;
      }
      
      insize *= 2;
    }
  }
}
