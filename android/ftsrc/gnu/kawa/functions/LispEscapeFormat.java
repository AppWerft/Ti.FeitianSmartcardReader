package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import java.io.IOException;
import java.text.FieldPosition;















































































































































































































































































































































































































































































































































































































































































































































































































class LispEscapeFormat
  extends ReportFormat
{
  int param1;
  int param2;
  int param3;
  boolean escapeAll;
  public static final LispEscapeFormat alwaysTerminate = new LispEscapeFormat(0, -1073741824);
  public static final int ESCAPE_NORMAL = 241;
  public static final int ESCAPE_ALL = 242;
  
  public LispEscapeFormat(int param1, int param2) {
    this.param1 = param1;
    this.param2 = param2;
    param3 = -1073741824;
  }
  
  public LispEscapeFormat(int param1, int param2, int param3)
  {
    this.param1 = param1;
    this.param2 = param2;
    this.param3 = param3;
  }
  
  static Numeric getParam(int param, Object[] args, int start)
  {
    if (param == -1342177280)
      return IntNum.make(args.length - start);
    if (param == -1610612736)
    {
      Object arg = args[start];
      if ((arg instanceof Numeric))
        return (Numeric)arg;
      if ((arg instanceof Number))
      {
        if (((arg instanceof Float)) || ((arg instanceof Double)))
          return new DFloNum(((Number)arg).doubleValue());
        return IntNum.make(((Number)arg).longValue());
      }
      if ((arg instanceof Char))
        return new IntNum(((Char)arg).intValue());
      if ((arg instanceof Character))
        return new IntNum(((Character)arg).charValue());
      return new DFloNum(NaN.0D);
    }
    return IntNum.make(param);
  }
  








  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    int orig_start = start;
    boolean do_terminate;
    boolean do_terminate; if (param1 == -1073741824) {
      do_terminate = start == args.length; } else { boolean do_terminate;
      if ((param2 == -1073741824) && (param1 == 0)) {
        do_terminate = true;
      }
      else {
        Numeric arg1 = getParam(param1, args, start);
        if (param1 == -1610612736) start++;
        boolean do_terminate; if (param2 == -1073741824)
        {
          do_terminate = arg1.isZero();
        }
        else
        {
          Numeric arg2 = getParam(param2, args, start);
          if (param2 == -1610612736) start++;
          boolean do_terminate; if (param3 == -1073741824)
          {
            do_terminate = arg1.equals(arg2);
          }
          else
          {
            Numeric arg3 = getParam(param3, args, start);
            if (param3 == -1610612736) start++;
            do_terminate = (arg2.geq(arg1)) && (arg3.geq(arg2));
          }
        }
      } }
    return result(escapeAll ? 242 : !do_terminate ? 0 : 241, start);
  }
}
