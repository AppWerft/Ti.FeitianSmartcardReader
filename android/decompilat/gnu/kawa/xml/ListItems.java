// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import java.util.Iterator;
import gnu.lists.Consumer;
import gnu.mapping.Values;
import gnu.lists.AbstractSequence;
import java.util.List;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;

public class ListItems extends MethodProc
{
    public static ListItems listItems;
    
    @Override
    public void apply(final CallContext ctx) {
        final Consumer out = ctx.consumer;
        final Object arg = ctx.getNextArg();
        ctx.lastArg();
        final List list = (List)arg;
        if (arg instanceof AbstractSequence) {
            ((AbstractSequence)arg).consumePosRange(0, -1, out);
            return;
        }
        for (final Object val : list) {
            Values.writeValues(val, out);
        }
    }
    
    static {
        ListItems.listItems = new ListItems();
    }
}
