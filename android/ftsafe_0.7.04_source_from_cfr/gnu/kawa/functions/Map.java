/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEq;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequences;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import java.util.Iterator;

public class Map
extends ProcedureN {
    boolean collect;
    final ApplyToArgs applyToArgs;
    final IsEq isEq;

    public Map(boolean collect, ApplyToArgs applyToArgs, IsEq isEq) {
        super(collect ? "map" : "for-each");
        this.collect = collect;
        this.applyToArgs = applyToArgs;
        this.isEq = isEq;
        this.setProperty(Procedure.validateApplyKey, collect ? "kawa.lib.compile_map:listMapValidateApply" : "kawa.lib.compile_map:listForEachValidateApply");
    }

    public static Object map1(Procedure proc, LList list) throws Throwable {
        Object cur = list;
        LList result = LList.Empty;
        Pair last = null;
        while (cur != LList.Empty) {
            Pair pair = (Pair)cur;
            Pair new_pair = new Pair(proc.apply1(pair.getCar()), LList.Empty);
            if (last == null) {
                result = new_pair;
            } else {
                last.setCdr(new_pair);
            }
            last = new_pair;
            cur = pair.getCdr();
        }
        return result;
    }

    public static Object map1(Procedure proc, Object list) throws Throwable {
        if (list instanceof LList) {
            return Map.map1(proc, (LList)list);
        }
        LList result = LList.Empty;
        Pair last = null;
        Iterator it = Sequences.getIterator(list);
        while (it.hasNext()) {
            Pair new_pair = new Pair(proc.apply1(it.next()), LList.Empty);
            if (last == null) {
                result = new_pair;
            } else {
                last.setCdr(new_pair);
            }
            last = new_pair;
        }
        return result;
    }

    public static void forEach1(Procedure proc, LList list) throws Throwable {
        Object cur = list;
        while (cur != LList.Empty) {
            Pair pair = (Pair)cur;
            proc.apply1(pair.getCar());
            cur = pair.getCdr();
        }
    }

    public static void forEach1(Procedure proc, Object list) throws Throwable {
        if (list instanceof LList) {
            Map.forEach1(proc, (LList)list);
        } else {
            Iterator it = Sequences.getIterator(list);
            while (it.hasNext()) {
                proc.apply1(it.next());
            }
        }
    }

    @Override
    public Object apply2(Object arg1, Object arg2) throws Throwable {
        if (arg1 instanceof Procedure) {
            Procedure proc = (Procedure)arg1;
            if (this.collect) {
                return Map.map1(proc, arg2);
            }
            Map.forEach1(proc, arg2);
            return Values.empty;
        }
        return this.applyN(new Object[]{arg1, arg2});
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public Object applyN(Object[] args) throws Throwable {
        arity = args.length - 1;
        if (arity == 1 && args[0] instanceof Procedure) {
            proc = (Procedure)args[0];
            if (this.collect) {
                return Map.map1(proc, args[1]);
            }
            Map.forEach1(proc, args[1]);
            return Values.empty;
        }
        last = null;
        if (this.collect) {
            result = LList.Empty;
        } else {
            result = Values.empty;
        }
        if (args[0] instanceof Procedure) {
            need_apply = 0;
            each_args = new Object[arity];
            proc = (Procedure)args[0];
        } else {
            need_apply = 1;
            each_args = new Object[arity + 1];
            each_args[0] = args[0];
            proc = this.applyToArgs;
        }
        iterators = new Iterator[arity];
        for (i = 0; i < arity; ++i) {
            iterators[i] = Sequences.getIterator(args[i + 1]);
        }
        do {
            for (i = 0; i < arity; ++i) {
                it = iterators[i];
                if (!it.hasNext()) {
                    return result;
                }
                each_args[need_apply + i] = it.next();
            }
            value = proc.applyN(each_args);
            if (!this.collect) ** continue;
            new_pair = new Pair(value, LList.Empty);
            if (last == null) {
                result = new_pair;
            } else {
                last.setCdr(new_pair);
            }
            last = new_pair;
        } while (true);
    }

    @Override
    public int numArgs() {
        return -4094;
    }
}

