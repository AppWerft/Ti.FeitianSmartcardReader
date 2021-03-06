package gnu.kawa.servlet;

import gnu.kawa.xml.HttpPrinter;
import java.io.IOException;







public class ServletPrinter
  extends HttpPrinter
{
  HttpRequestContext hctx;
  
  public ServletPrinter(HttpRequestContext hctx, int bufSize)
    throws IOException
  {
    super(new HttpOutputStream(hctx, bufSize));
    this.hctx = hctx;
  }
  
  public void addHeader(String label, String value)
  {
    if (label.equalsIgnoreCase("Content-type"))
    {
      sawContentType = value;
      hctx.setContentType(value);
    }
    else if (label.equalsIgnoreCase("Status"))
    {
      int lval = value.length();
      int code = 0;
      
      for (int i = 0; i < lval; i++)
      {
        if (i >= lval)
        {
          hctx.statusCode = code;
          break;
        }
        char ch = value.charAt(i);
        int digit = Character.digit(ch, 10);
        if (digit >= 0) {
          code = 10 * code + digit;
        }
        else {
          if (ch == ' ')
            i++;
          hctx.statusCode = code;
          hctx.statusReasonPhrase = value.substring(i);
          break;
        }
      }
    }
    else {
      hctx.setResponseHeader(label, value);
    }
  }
  

  public void printHeaders() {}
  
  public boolean reset(boolean headersAlso)
  {
    return ((HttpOutputStream)ostream).reset() & super.reset(headersAlso);
  }
}
