/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongType;

public class append
extends ProcedureN {
    public static final append append = new append();

    @Override
    public Object applyN(Object[] args) {
        return append.append$V(args);
    }

    public static Object append$V(Object[] args) {
        int count = args.length;
        if (count == 0) {
            return LList.Empty;
        }
        Object result = args[count - 1];
        int i = count - 1;
        while (--i >= 0) {
            Object list = args[i];
            Pair copy = null;
            Pair last = null;
            while (list instanceof Pair) {
                Pair list_pair = (Pair)list;
                Pair new_pair = new Pair(list_pair.getCar(), null);
                if (last == null) {
                    copy = new_pair;
                } else {
                    last.setCdr(new_pair);
                }
                last = new_pair;
                list = list_pair.getCdr();
            }
            if (list != LList.Empty) {
                throw new WrongType((Procedure)append, i + 1, args[i], "list");
            }
            if (last == null) continue;
            last.setCdr(result);
            result = copy;
        }
        return result;
    }

    static {
        append.setName("append");
    }
}

