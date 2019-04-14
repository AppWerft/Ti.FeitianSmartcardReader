package gnu.kawa.format;

import java.io.Flushable;

public class FlushFormat extends ReportFormat
{
  private static FlushFormat flush;
  
  public FlushFormat() {}
  
  public static FlushFormat getInstance()
  {
    if (flush == null)
      flush = new FlushFormat();
    return flush;
  }
  
  public int format(Object[] args, int start, Appendable dst, java.text.FieldPosition fpos) throws java.io.IOException
  {
    if ((dst instanceof Flushable))
      ((Flushable)dst).flush();
    return start;
  }
}
