package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import java.io.IOException;
import java.text.FieldPosition;
































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































class LispRepositionFormat
  extends ReportFormat
{
  boolean backwards;
  boolean absolute;
  int count;
  
  public LispRepositionFormat(int count, boolean backwards, boolean absolute)
  {
    this.count = count;
    this.backwards = backwards;
    this.absolute = absolute;
  }
  
  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    int count = getParam(this.count, absolute ? 0 : 1, args, start);
    
    if (!absolute)
    {
      if (backwards)
        count = -count;
      count += start;
    }
    return count > args.length ? args.length : count < 0 ? 0 : count;
  }
}
