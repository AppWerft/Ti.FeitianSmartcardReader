package gnu.kawa.format;

import gnu.lists.UnescapedData;
import java.io.IOException;
import java.text.FieldPosition;
import java.util.List;















public class DelimitSubstitutionFormat
  extends ReportFormat
{
  public static final char MARK_GROUP_START = '';
  public static final char MARK_GROUP_END = '';
  public static final char MARK_SUBSTITUTION_START = '';
  public static final char MARK_SUBSTITUTION_END = '';
  public char markGroupStart = 61952;
  public char markGroupEnd = 61953;
  public char markSubstitutionStart = 61954;
  public char markSubstitutionEnd = 61955;
  ReportFormat base;
  
  public DelimitSubstitutionFormat(ReportFormat base) { this.base = base; }
  
  public static DelimitSubstitutionFormat getInstance(ReportFormat base)
  {
    return new DelimitSubstitutionFormat(base);
  }
  

  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    if (start >= args.length) {
      dst.append("#<missing format argument>");
      return start;
    }
    Object arg = args[start];
    if (((arg instanceof List)) && (!(arg instanceof CharSequence))) {
      dst.append(markGroupStart);
      Object[] tmp = new Object[1];
      for (Object a : (List)arg) {
        tmp[0] = a;
        format1(tmp, 0, dst, fpos);
      }
      dst.append(markGroupEnd);
    } else {
      format1(args, start, dst, fpos);
    }
    return start + 1;
  }
  
  int format1(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException
  {
    Object arg = args[start];
    if ((arg instanceof UnescapedData)) {
      dst.append(((UnescapedData)arg).getData());
      start += 1;
    } else {
      dst.append(markSubstitutionStart);
      start = base.format(args, start, dst, fpos);
      dst.append(markSubstitutionEnd);
    }
    return start;
  }
}
