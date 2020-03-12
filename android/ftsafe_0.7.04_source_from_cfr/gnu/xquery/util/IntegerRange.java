/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class IntegerRange {
    public static final IntNum MIN_INT = IntNum.make(Integer.MIN_VALUE);
    public static final IntNum MAX_INT = IntNum.make(Integer.MAX_VALUE);

    public static void integerRange(IntNum first, IntNum last, Consumer out) {
        if (IntNum.compare(first, MIN_INT) >= 0 && IntNum.compare(last, MAX_INT) <= 0) {
            int lst;
            int fst = first.intValue();
            if (fst <= (lst = last.intValue())) {
                do {
                    out.writeInt(fst);
                    if (fst == lst) break;
                    ++fst;
                } while (true);
            }
            return;
        }
        while (IntNum.compare(first, last) <= 0) {
            out.writeObject(first);
            first = IntNum.add(first, 1);
        }
    }

    public static void integerRange$X(Object first, Object last, CallContext ctx) {
        first = KNode.atomicValue(first);
        last = KNode.atomicValue(last);
        if (first == Values.empty || first == null || last == Values.empty || last == null) {
            return;
        }
        if (first instanceof UntypedAtomic) {
            first = IntNum.valueOf(first.toString().trim(), 10);
        }
        if (last instanceof UntypedAtomic) {
            last = IntNum.valueOf(last.toString().trim(), 10);
        }
        IntegerRange.integerRange((IntNum)first, (IntNum)last, ctx.consumer);
    }
}
