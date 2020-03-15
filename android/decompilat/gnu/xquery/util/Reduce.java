// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.kawa.functions.AddOp;
import gnu.lists.Sequence;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class Reduce
{
    public static Object sum(final Object arg) throws Throwable {
        return sum(arg, IntNum.zero());
    }
    
    public static Object sum(final Object arg, final Object zero) throws Throwable {
        if (!(arg instanceof Values)) {
            return MinMax.convert(arg);
        }
        final Values tlist = (Values)arg;
        int pos = 0;
        Object next = tlist.getPosNext(pos);
        if (next == Sequence.eofValue) {
            return zero;
        }
        Object result = MinMax.convert(next);
        while (true) {
            pos = tlist.nextPos(pos);
            next = tlist.getPosNext(pos);
            if (next == Sequence.eofValue) {
                break;
            }
            next = MinMax.convert(next);
            result = AddOp.apply2(1, result, next);
        }
        return result;
    }
}
