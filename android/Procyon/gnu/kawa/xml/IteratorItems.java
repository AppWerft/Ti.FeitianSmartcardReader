// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.mapping.Values;
import java.util.Iterator;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;

public class IteratorItems extends MethodProc
{
    public static IteratorItems iteratorItems;
    
    @Override
    public void apply(final CallContext ctx) {
        final Consumer out = ctx.consumer;
        final Object arg = ctx.getNextArg();
        ctx.lastArg();
        final Iterator iter = (Iterator)arg;
        while (iter.hasNext()) {
            final Object val = iter.next();
            Values.writeValues(val, out);
        }
    }
    
    static {
        IteratorItems.iteratorItems = new IteratorItems();
    }
}
