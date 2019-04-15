/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.functions.AddOp;
import gnu.lists.Sequence;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.xquery.util.MinMax;

public class Reduce {
    public static Object sum(Object arg) throws Throwable {
        return Reduce.sum(arg, IntNum.zero());
    }

    public static Object sum(Object arg, Object zero) throws Throwable {
        if (arg instanceof Values) {
            Values tlist = (Values)arg;
            int pos = 0;
            Object next = tlist.getPosNext(pos);
            if (next == Sequence.eofValue) {
                return zero;
            }
            Object result = MinMax.convert(next);
            do {
                if ((next = tlist.getPosNext(pos = tlist.nextPos(pos))) == Sequence.eofValue) {
                    return result;
                }
                next = MinMax.convert(next);
                result = AddOp.apply2(1, result, next);
            } while (true);
        }
        return (Number)MinMax.convert(arg);
    }
}

