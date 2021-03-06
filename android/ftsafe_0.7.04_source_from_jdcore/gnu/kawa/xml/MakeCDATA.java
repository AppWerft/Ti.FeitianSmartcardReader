package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.xml.TextUtils;

public class MakeCDATA extends gnu.mapping.MethodProc
{
  public static final MakeCDATA makeCDATA = new MakeCDATA();
  
  public MakeCDATA() {}
  
  public void apply(CallContext ctx) {
    Consumer saved = consumer;
    XConsumer out = NodeConstructor.pushNodeContext(ctx);
    try
    {
      StringBuffer sbuf = new StringBuffer();
      Object endMarker = Location.UNBOUND;
      for (;;)
      {
        Object arg = ctx.getNextArg(endMarker);
        if (arg == endMarker)
          break;
        TextUtils.stringValue(arg, sbuf);
      }
      int n = sbuf.length();
      char[] chars = new char[n];
      sbuf.getChars(0, n, chars, 0);
      out.writeCDATA(chars, 0, n);
    }
    finally
    {
      NodeConstructor.popNodeContext(saved, ctx);
    }
  }
}
