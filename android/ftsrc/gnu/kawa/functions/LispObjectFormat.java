package gnu.kawa.functions;

import gnu.kawa.format.PadFormat;
import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.text.FieldPosition;






































































































































































































































































































































































































































































































































































































































































































































































class LispObjectFormat
  extends ReportFormat
{
  int minWidth;
  int colInc;
  int minPad;
  int padChar;
  int where;
  ObjectFormat base;
  
  public LispObjectFormat(ObjectFormat base, int minWidth, int colInc, int minPad, int padChar, int where)
  {
    this.base = base;
    this.minWidth = minWidth;
    this.colInc = colInc;
    this.minPad = minPad;
    this.padChar = padChar;
    this.where = where;
  }
  
  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    int minWidth = getParam(this.minWidth, 0, args, start);
    if (this.minWidth == -1610612736) start++;
    int colInc = getParam(this.colInc, 1, args, start);
    if (this.colInc == -1610612736) start++;
    int minPad = getParam(this.minPad, 0, args, start);
    if (this.minPad == -1610612736) start++;
    char padChar = getParam(this.padChar, ' ', args, start);
    if (this.padChar == -1610612736) start++;
    if ((base.readable) && ((dst instanceof OutPort)) && (minWidth == 0))
    {


      return base.format(args, start, dst, fpos);
    }
    return PadFormat.format(base, args, start, dst, padChar, minWidth, colInc, minPad, where, fpos);
  }
}
