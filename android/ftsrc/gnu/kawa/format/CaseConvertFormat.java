package gnu.kawa.format;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;




public class CaseConvertFormat
  extends ReportFormat
{
  char code;
  Format baseFormat;
  
  public CaseConvertFormat(Format baseFormat, char action)
  {
    this.baseFormat = baseFormat;
    code = action;
  }
  
  public Format getBaseFormat() { return baseFormat; }
  public void setBaseFormat(Format baseFormat) { this.baseFormat = baseFormat; }
  
  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    StringBuffer sbuf = new StringBuffer(100);
    int result = format(baseFormat, args, start, sbuf, fpos);
    int len = sbuf.length();
    char prev = ' ';
    for (int i = 0; i < len; i++)
    {
      char ch = sbuf.charAt(i);
      if (code == 'U') {
        ch = Character.toUpperCase(ch);
      } else if (((code == 'T') && (i == 0)) || ((code == 'C') && (!Character.isLetterOrDigit(prev))))
      {
        ch = Character.toTitleCase(ch);
      } else
        ch = Character.toLowerCase(ch);
      prev = ch;
      dst.append(ch);
    }
    return result;
  }
}
