// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.lists.Consumer;
import gnu.mapping.Values;
import gnu.mapping.CallContext;

public class DistinctValues
{
    public static void distinctValues$X(final Object values, final NamedCollator coll, final CallContext ctx) {
        final DistinctValuesConsumer out = new DistinctValuesConsumer(coll, ctx.consumer);
        Values.writeValues(values, out);
    }
}
