package gnu.xquery.util;

import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.XDataType;
import gnu.lists.Sequence;
import gnu.mapping.Values;

public class MinMax
{
  public MinMax() {}
  
  public static Object min(Object arg, NamedCollator collation)
  {
    return minMax(arg, false, collation);
  }
  
  public static Object max(Object arg, NamedCollator collation)
  {
    return minMax(arg, true, collation);
  }
  

  public static Object minMax(Object arg, boolean returnMax, NamedCollator collation)
  {
    if ((arg instanceof Values))
    {
      Values tlist = (Values)arg;
      int pos = 0;
      int flags = returnMax ? 16 : 4;
      Object cur = tlist.getPosNext(pos);
      if (cur == Sequence.eofValue)
        return Values.empty;
      Object result = convert(cur);
      for (;;)
      {
        pos = tlist.nextPos(pos);
        cur = tlist.getPosNext(pos);
        if (cur == Sequence.eofValue)
          return result;
        cur = convert(cur);
        
        if (((result instanceof Number)) || ((cur instanceof Number)))
        {
          int code1 = Arithmetic.classifyValue(result);
          int code2 = Arithmetic.classifyValue(cur);
          int rcode = NumberCompare.compare(result, code1, cur, code2, false);
          
          if (rcode == -3)
            throw new IllegalArgumentException("values cannot be compared");
          int code = Arithmetic.leastSpecificCode(code1, code2);
          boolean castNeeded;
          boolean castNeeded; if (rcode == -2)
          {
            result = NumberValue.NaN;
            castNeeded = true;
          }
          else if (!NumberCompare.checkCompareCode(rcode, flags))
          {
            boolean castNeeded = code != code2;
            result = cur;
          }
          else
          {
            castNeeded = code != code1;
          }
          if (castNeeded) {
            result = Arithmetic.convert(result, code);
          }
          
        }
        else if (!Compare.atomicCompare(flags, result, cur, collation)) {
          result = cur;
        }
      }
    }
    

    arg = convert(arg);
    
    Compare.atomicCompare(16, arg, arg, collation);
    return arg;
  }
  

  static Object convert(Object arg)
  {
    arg = gnu.kawa.xml.KNode.atomicValue(arg);
    if ((arg instanceof gnu.kawa.xml.UntypedAtomic)) {
      arg = (Double)XDataType.doubleType.valueOf(gnu.xml.TextUtils.stringValue(arg));
    }
    return arg;
  }
}
