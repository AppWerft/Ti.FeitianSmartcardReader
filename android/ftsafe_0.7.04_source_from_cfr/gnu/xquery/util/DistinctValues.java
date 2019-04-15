/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.xquery.util.DistinctValuesConsumer;
import gnu.xquery.util.NamedCollator;

public class DistinctValues {
    public static void distinctValues$X(Object values, NamedCollator coll, CallContext ctx) {
        DistinctValuesConsumer out = new DistinctValuesConsumer(coll, ctx.consumer);
        Values.writeValues(values, out);
    }
}

