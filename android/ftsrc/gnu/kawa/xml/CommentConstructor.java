package gnu.kawa.xml;

import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.xml.TextUtils;

public class CommentConstructor extends gnu.mapping.MethodProc
{
  public CommentConstructor() {}
  
  public static final CommentConstructor commentConstructor = new CommentConstructor();
  
  public int numArgs() {
    return 4097;
  }
  
  public void apply(CallContext ctx) {
    gnu.lists.Consumer saved = consumer;
    gnu.lists.XConsumer out = NodeConstructor.pushNodeContext(ctx);
    try
    {
      StringBuffer sbuf = new StringBuffer();
      Object endMarker = gnu.mapping.Location.UNBOUND;
      boolean first = true;
      for (int i = 0;; i++)
      {
        Object arg = ctx.getNextArg(endMarker);
        if (arg == endMarker) break;
        Values vals;
        int it; if ((arg instanceof Values))
        {
          vals = (Values)arg;
          for (it = 0; (it = vals.nextPos(it)) != 0;)
          {
            if (!first)
              sbuf.append(' ');
            first = false;
            TextUtils.stringValue(vals.getPosPrevious(it), sbuf);
          }
        }
        else
        {
          if (!first)
            sbuf.append(' ');
          first = false;
          TextUtils.stringValue(arg, sbuf);
        }
      }
      int len = sbuf.length();
      char[] buf = new char[len];
      sbuf.getChars(0, len, buf, 0);
      out.writeComment(buf, 0, len);
    }
    finally
    {
      NodeConstructor.popNodeContext(saved, ctx);
    }
  }
}
