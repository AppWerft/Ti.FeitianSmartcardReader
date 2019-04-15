package gnu.kawa.format;

import gnu.lists.Strings;
import java.text.FieldPosition;
import java.text.ParsePosition;

public class LiteralFormat extends ReportFormat
{
  String text;
  public static final LiteralFormat separator = new LiteralFormat("");
  
  public LiteralFormat(char[] text) {
    this.text = String.valueOf(text);
  }
  
  public LiteralFormat(String text) {
    this.text = text;
  }
  
  public LiteralFormat(StringBuffer sbuf) {
    this(sbuf.toString());
  }
  
  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws java.io.IOException
  {
    dst.append(text);
    return start;
  }
  
  public Object parseObject(String text, ParsePosition status) {
    throw new Error("LiteralFormat.parseObject - not implemented");
  }
  
  public String content()
  {
    return text;
  }
  
  public String toString() {
    StringBuilder sbuf = new StringBuilder("LiteralFormat[");
    Strings.printQuoted(text, sbuf, 1);
    sbuf.append(']');
    return sbuf.toString();
  }
}
