/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.NodeConstructor;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.xml.TextUtils;
import gnu.xml.XMLFilter;

public class MakeCDATA
extends MethodProc {
    public static final MakeCDATA makeCDATA = new MakeCDATA();

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
            while ((arg = ctx.getNextArg(endMarker)) != endMarker) {
                TextUtils.stringValue(arg, sbuf);
            }
            int n = sbuf.length();
            char[] chars = new char[n];
            sbuf.getChars(0, n, chars, 0);
            out.writeCDATA(chars, 0, n);
        }
        finally {
            NodeConstructor.popNodeContext(saved, ctx);
        }
    }
}

