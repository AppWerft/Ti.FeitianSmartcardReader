// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.mapping.ProcedureN;

public class append extends ProcedureN
{
    public static final append append;
    
    @Override
    public Object applyN(final Object[] args) {
        return append$V(args);
    }
    
    public static Object append$V(final Object[] args) {
        final int count = args.length;
        if (count == 0) {
            return LList.Empty;
        }
        Object result = args[count - 1];
        int i = count - 1;
        while (--i >= 0) {
            Object list = args[i];
            Object copy = null;
            Pair last = null;
            while (list instanceof Pair) {
                final Pair list_pair = (Pair)list;
                final Pair new_pair = new Pair(list_pair.getCar(), null);
                if (last == null) {
                    copy = new_pair;
                }
                else {
                    last.setCdr(new_pair);
                }
                last = new_pair;
                list = list_pair.getCdr();
            }
            if (list != LList.Empty) {
                throw new WrongType(kawa.standard.append.append, i + 1, args[i], "list");
            }
            if (last == null) {
                continue;
            }
            last.setCdr(result);
            result = copy;
        }
        return result;
    }
    
    static {
        (append = new append()).setName("append");
    }
}
