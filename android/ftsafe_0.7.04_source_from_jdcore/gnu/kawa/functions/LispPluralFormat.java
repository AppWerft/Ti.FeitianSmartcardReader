package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.math.IntNum;
import java.io.IOException;
import java.text.FieldPosition;
























































































































































































































































































































































































































































































































































































class LispPluralFormat
  extends ReportFormat
{
  boolean backup;
  boolean y;
  
  LispPluralFormat() {}
  
  public static LispPluralFormat getInstance(boolean backup, boolean y)
  {
    LispPluralFormat fmt = new LispPluralFormat();
    backup = backup;
    y = y;
    return fmt;
  }
  
  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    if (backup)
      start--;
    Object arg = args[(start++)];
    boolean plural = arg != IntNum.one();
    if (y) {
      dst.append(plural ? "ies" : "y");
    } else if (plural)
      dst.append('s');
    return start;
  }
}
