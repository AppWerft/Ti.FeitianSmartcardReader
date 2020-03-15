// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.XConsumer;
import gnu.lists.Consumer;
import gnu.xml.TextUtils;
import gnu.mapping.Values;
import gnu.mapping.Location;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;

public class CommentConstructor extends MethodProc
{
    public static final CommentConstructor commentConstructor;
    
    @Override
    public int numArgs() {
        return 4097;
    }
    
    @Override
    public void apply(final CallContext ctx) {
        final Consumer saved = ctx.consumer;
        final XConsumer out = NodeConstructor.pushNodeContext(ctx);
        try {
            final StringBuffer sbuf = new StringBuffer();
            final Object endMarker = Location.UNBOUND;
            boolean first = true;
            int i = 0;
            while (true) {
                final Object arg = ctx.getNextArg(endMarker);
                if (arg == endMarker) {
                    break;
                }
                if (arg instanceof Values) {
                    final Values vals = (Values)arg;
                    int it = 0;
                    while ((it = vals.nextPos(it)) != 0) {
                        if (!first) {
                            sbuf.append(' ');
                        }
                        first = false;
                        TextUtils.stringValue(vals.getPosPrevious(it), sbuf);
                    }
                }
                else {
                    if (!first) {
                        sbuf.append(' ');
                    }
                    first = false;
                    TextUtils.stringValue(arg, sbuf);
                }
                ++i;
            }
            final int len = sbuf.length();
            final char[] buf = new char[len];
            sbuf.getChars(0, len, buf, 0);
            out.writeComment(buf, 0, len);
        }
        finally {
            NodeConstructor.popNodeContext(saved, ctx);
        }
    }
    
    static {
        commentConstructor = new CommentConstructor();
    }
}
