// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;

public class MakeResponseHeader extends MethodProc
{
    public static MakeResponseHeader makeResponseHeader;
    
    @Override
    public void apply(final CallContext ctx) {
        final String key = ctx.getNextArg().toString();
        final Object val = ctx.getNextArg();
        ctx.lastArg();
        final Consumer out = ctx.consumer;
        out.startAttribute(key);
        out.write(val.toString());
        out.endAttribute();
    }
    
    static {
        MakeResponseHeader.makeResponseHeader = new MakeResponseHeader();
    }
}
