// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.mapping.Values;
import gnu.mapping.Procedure2;

public class ItemAt extends Procedure2
{
    public static final ItemAt itemAt;
    
    public static Object itemAt(final Object seq, final int index) {
        if (seq instanceof Values) {
            final Values vals = (Values)seq;
            if (vals.isEmpty()) {
                return Values.empty;
            }
            return vals.get(index - 1);
        }
        else {
            if (index != 1) {
                throw new IndexOutOfBoundsException();
            }
            return seq;
        }
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        return itemAt(arg1, ((Number)arg2).intValue());
    }
    
    static {
        itemAt = new ItemAt();
    }
}
