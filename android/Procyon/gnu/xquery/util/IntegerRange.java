// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.kawa.xml.UntypedAtomic;
import gnu.mapping.Values;
import gnu.kawa.xml.KNode;
import gnu.mapping.CallContext;
import gnu.lists.Consumer;
import gnu.math.IntNum;

public class IntegerRange
{
    public static final IntNum MIN_INT;
    public static final IntNum MAX_INT;
    
    public static void integerRange(IntNum first, final IntNum last, final Consumer out) {
        if (IntNum.compare(first, IntegerRange.MIN_INT) >= 0 && IntNum.compare(last, IntegerRange.MAX_INT) <= 0) {
            int fst = first.intValue();
            final int lst = last.intValue();
            if (fst <= lst) {
                while (true) {
                    out.writeInt(fst);
                    if (fst == lst) {
                        break;
                    }
                    ++fst;
                }
            }
            return;
        }
        while (IntNum.compare(first, last) <= 0) {
            out.writeObject(first);
            first = IntNum.add(first, 1);
        }
    }
    
    public static void integerRange$X(Object first, Object last, final CallContext ctx) {
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
        integerRange((IntNum)first, (IntNum)last, ctx.consumer);
    }
    
    static {
        MIN_INT = IntNum.make(Integer.MIN_VALUE);
        MAX_INT = IntNum.make(Integer.MAX_VALUE);
    }
}
