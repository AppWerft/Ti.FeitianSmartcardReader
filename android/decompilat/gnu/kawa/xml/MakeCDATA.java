// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.XConsumer;
import gnu.lists.Consumer;
import gnu.xml.TextUtils;
import gnu.mapping.Location;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;

public class MakeCDATA extends MethodProc
{
    public static final MakeCDATA makeCDATA;
    
    @Override
    public void apply(final CallContext ctx) {
        final Consumer saved = ctx.consumer;
        final XConsumer out = NodeConstructor.pushNodeContext(ctx);
        try {
            final StringBuffer sbuf = new StringBuffer();
            final Object endMarker = Location.UNBOUND;
            while (true) {
                final Object arg = ctx.getNextArg(endMarker);
                if (arg == endMarker) {
                    break;
                }
                TextUtils.stringValue(arg, sbuf);
            }
            final int n = sbuf.length();
            final char[] chars = new char[n];
            sbuf.getChars(0, n, chars, 0);
            out.writeCDATA(chars, 0, n);
        }
        finally {
            NodeConstructor.popNodeContext(saved, ctx);
        }
    }
    
    static {
        makeCDATA = new MakeCDATA();
    }
}
