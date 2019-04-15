/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.lists.Sequence;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.xquery.util.ArithOp;

public class Average
extends Procedure1 {
    public static final Average avg = new Average("avg");

    public Average(String name) {
        super(name);
    }

    @Override
    public Object apply1(Object arg) throws Throwable {
        Object sum = Values.empty;
        int count = 0;
        if (arg instanceof Values) {
            Object next;
            Values tlist = (Values)arg;
            int index = 0;
            while ((next = tlist.getPosNext(index)) != Sequence.eofValue) {
                ++count;
                sum = sum == Values.empty ? next : ArithOp.add.apply2(sum, next);
                index = tlist.nextPos(index);
            }
        } else {
            count = 1;
            sum = arg;
        }
        if (sum == Values.empty) {
            return sum;
        }
        sum = ArithOp.div.apply2(sum, IntNum.make(count));
        return sum;
    }
}

