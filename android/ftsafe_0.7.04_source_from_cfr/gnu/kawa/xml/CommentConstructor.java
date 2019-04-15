/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.NodeConstructor;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import gnu.xml.TextUtils;
import gnu.xml.XMLFilter;

public class CommentConstructor
extends MethodProc {
    public static final CommentConstructor commentConstructor = new CommentConstructor();

    @Override
    public int numArgs() {
        return 4097;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void apply(CallContext ctx) {
        Consumer saved = ctx.consumer;
        XMLFilter out = NodeConstructor.pushNodeContext(ctx);
        try {
            Object arg;
            StringBuffer sbuf = new StringBuffer();
            String endMarker = Location.UNBOUND;
            boolean first = true;
            int i = 0;
            while ((arg = ctx.getNextArg(endMarker)) != endMarker) {
                if (arg instanceof Values) {
                    Values vals = (Values)arg;
                    int it = 0;
                    while ((it = vals.nextPos(it)) != 0) {
                        if (!first) {
                            sbuf.append(' ');
                        }
                        first = false;
                        TextUtils.stringValue(vals.getPosPrevious(it), sbuf);
                    }
                } else {
                    if (!first) {
                        sbuf.append(' ');
                    }
                    first = false;
                    TextUtils.stringValue(arg, sbuf);
                }
                ++i;
            }
            int len = sbuf.length();
            char[] buf = new char[len];
            sbuf.getChars(0, len, buf, 0);
            out.writeComment(buf, 0, len);
        }
        finally {
            NodeConstructor.popNodeContext(saved, ctx);
        }
    }
}

