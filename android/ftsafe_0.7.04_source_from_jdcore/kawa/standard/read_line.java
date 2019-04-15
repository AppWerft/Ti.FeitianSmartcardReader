package kawa.standard;

import gnu.kawa.io.InPort;

public class read_line
{
  public read_line() {}
  
  public static Object apply(InPort in, String handling) throws java.io.IOException
  {
    int ch = in.read();
    if (ch < 0)
      return gnu.expr.Special.eof;
    int start = in.pos - 1;
    int pos = start;
    int limit = in.limit;
    char[] buffer = in.buffer;
    int delim = -1;
    

    while (pos < limit)
    {
      ch = buffer[(pos++)];
      if ((ch == 13) || (ch == 10))
      {
        pos--;
        if ((handling == "trim") || (handling == "peek"))
        {
          if (handling == "peek")
            delim = 0;
          if (ch == 10) {
            delim = 1;
          } else { if (pos + 1 >= limit) break;
            delim = buffer[(pos + 1)] == '\n' ? 2 : 1;
          }
          
          in.pos = (pos + delim);
        } else {
          if ((handling != "concat") || (ch != 10))
            break;
          in.pos = (++pos);
        }
        

        return new gnu.lists.FString(buffer, start, pos - start);
      }
    }
    


    StringBuffer sbuf = new StringBuffer(100);
    if (pos > start)
      sbuf.append(buffer, start, pos - start);
    in.pos = pos;
    char mode = (handling == "concat") || (handling == "split") ? 'A' : handling == "peek" ? 'P' : 'I';
    

    in.readLine(sbuf, mode);
    int length = sbuf.length();
    if (handling == "split")
    {
      if (length == 0) {
        delim = 0;
      }
      else {
        char last = sbuf.charAt(length - 1);
        if (last == '\r') {
          delim = 1;
        } else if (last != '\n') {
          delim = 0;
        } else if ((last > '\002') && (sbuf.charAt(length - 2) == '\r')) {
          delim = 2;
        } else
          delim = 1;
        length -= delim;
      }
    }
    gnu.lists.FString dataStr = new gnu.lists.FString(sbuf, 0, length);
    if (handling == "split")
    {
      gnu.lists.FString delimStr = new gnu.lists.FString(sbuf, length - delim, delim);
      return gnu.mapping.Values.values2(dataStr, delimStr);
    }
    
    return dataStr;
  }
}
