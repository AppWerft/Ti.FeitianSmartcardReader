package gnu.kawa.functions;

import gnu.kawa.format.AbstractFormat;
import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.OutPort;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.ParsePosition;





public class ObjectFormat
  extends ReportFormat
{
  int maxChars;
  boolean readable;
  private static ObjectFormat readableFormat;
  private static ObjectFormat plainFormat;
  
  public static ObjectFormat getInstance(boolean readable)
  {
    if (readable)
    {
      if (readableFormat == null)
        readableFormat = new ObjectFormat(true);
      return readableFormat;
    }
    

    if (plainFormat == null)
      plainFormat = new ObjectFormat(false);
    return plainFormat;
  }
  

  public ObjectFormat(boolean readable)
  {
    this.readable = readable;
    maxChars = -1073741824;
  }
  
  public ObjectFormat(boolean readable, int maxChars)
  {
    this.readable = readable;
    this.maxChars = maxChars;
  }
  
  public int format(Object[] args, int start, Appendable dst, FieldPosition fpos)
    throws IOException
  {
    int maxChars = getParam(this.maxChars, -1, args, start);
    if (this.maxChars == -1610612736) start++;
    return format(args, start, dst, maxChars, readable);
  }
  

  private static void print(Object obj, OutPort out, boolean readable)
  {
    AbstractFormat format = readable ? DisplayFormat.schemeWriteFormat : DisplayFormat.schemeDisplayFormat;
    

    Object save = out.pushFormat(format);
    try
    {
      format.writeObject(obj, out);
    }
    finally
    {
      out.popFormat(save);
    }
  }
  






  public static boolean format(Object arg, Appendable dst, int maxChars, boolean readable)
    throws IOException
  {
    if ((maxChars < 0) && ((dst instanceof OutPort)))
    {
      print(arg, (OutPort)dst, readable);
      return true;
    }
    if ((maxChars < 0) && ((dst instanceof CharArrayWriter)))
    {
      OutPort oport = new OutPort((CharArrayWriter)dst);
      print(arg, oport, readable);
      oport.close();
      return true;
    }
    

    CharArrayOutPort oport = new CharArrayOutPort();
    print(arg, oport, readable);
    int len = oport.size();
    if ((maxChars < 0) || (len <= maxChars))
    {
      oport.writeTo(dst);
      return true;
    }
    

    oport.writeTo(0, maxChars, dst);
    return false;
  }
  

  public static int format(Object[] args, int start, Appendable dst, int maxChars, boolean readable)
    throws IOException
  {
    Object arg;
    
    if (start >= args.length)
    {
      Object arg = "#<missing format argument>";
      start--;
      readable = false;
      maxChars = -1;
    }
    else {
      arg = args[start]; }
    format(arg, dst, maxChars, readable);
    return start + 1;
  }
  
  public Object parseObject(String text, ParsePosition status)
  {
    throw new RuntimeException("ObjectFormat.parseObject - not implemented");
  }
}
