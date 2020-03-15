// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.math.IntNum;
import gnu.lists.Sequence;
import gnu.mapping.Values;
import gnu.mapping.Procedure1;

public class Average extends Procedure1
{
    public static final Average avg;
    
    public Average(final String name) {
        super(name);
    }
    
    @Override
    public Object apply1(final Object arg) throws Throwable {
        Object sum = Values.empty;
        int count = 0;
        if (arg instanceof Values) {
            final Values tlist = (Values)arg;
            int index = 0;
            while (true) {
                final Object next = tlist.getPosNext(index);
                if (next == Sequence.eofValue) {
                    break;
                }
                ++count;
                sum = ((sum == Values.empty) ? next : ArithOp.add.apply2(sum, next));
                index = tlist.nextPos(index);
            }
        }
        else {
            count = 1;
            sum = arg;
        }
        if (sum == Values.empty) {
            return sum;
        }
        return sum = ArithOp.div.apply2(sum, IntNum.make(count));
    }
    
    static {
        avg = new Average("avg");
    }
}
