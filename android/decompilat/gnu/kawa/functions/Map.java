// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Values;
import java.util.Iterator;
import gnu.lists.Sequences;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;

public class Map extends ProcedureN
{
    boolean collect;
    final ApplyToArgs applyToArgs;
    final IsEq isEq;
    
    public Map(final boolean collect, final ApplyToArgs applyToArgs, final IsEq isEq) {
        super(collect ? "map" : "for-each");
        this.collect = collect;
        this.applyToArgs = applyToArgs;
        this.isEq = isEq;
        this.setProperty(Procedure.validateApplyKey, collect ? "kawa.lib.compile_map:listMapValidateApply" : "kawa.lib.compile_map:listForEachValidateApply");
    }
    
    public static Object map1(final Procedure proc, final LList list) throws Throwable {
        Object cur = list;
        Object result = LList.Empty;
        Pair last = null;
        while (cur != LList.Empty) {
            final Pair pair = (Pair)cur;
            final Pair new_pair = new Pair(proc.apply1(pair.getCar()), LList.Empty);
            if (last == null) {
                result = new_pair;
            }
            else {
                last.setCdr(new_pair);
            }
            last = new_pair;
            cur = pair.getCdr();
        }
        return result;
    }
    
    public static Object map1(final Procedure proc, final Object list) throws Throwable {
        if (list instanceof LList) {
            return map1(proc, (LList)list);
        }
        Object result = LList.Empty;
        Pair last = null;
        final Iterator it = Sequences.getIterator(list);
        while (it.hasNext()) {
            final Pair new_pair = new Pair(proc.apply1(it.next()), LList.Empty);
            if (last == null) {
                result = new_pair;
            }
            else {
                last.setCdr(new_pair);
            }
            last = new_pair;
        }
        return result;
    }
    
    public static void forEach1(final Procedure proc, final LList list) throws Throwable {
        Pair pair;
        for (Object cur = list; cur != LList.Empty; cur = pair.getCdr()) {
            pair = (Pair)cur;
            proc.apply1(pair.getCar());
        }
    }
    
    public static void forEach1(final Procedure proc, final Object list) throws Throwable {
        if (list instanceof LList) {
            forEach1(proc, (LList)list);
        }
        else {
            final Iterator it = Sequences.getIterator(list);
            while (it.hasNext()) {
                proc.apply1(it.next());
            }
        }
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) throws Throwable {
        if (!(arg1 instanceof Procedure)) {
            return this.applyN(new Object[] { arg1, arg2 });
        }
        final Procedure proc = (Procedure)arg1;
        if (this.collect) {
            return map1(proc, arg2);
        }
        forEach1(proc, arg2);
        return Values.empty;
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        final int arity = args.length - 1;
        if (arity != 1 || !(args[0] instanceof Procedure)) {
            Pair last = null;
            Object result;
            if (this.collect) {
                result = LList.Empty;
            }
            else {
                result = Values.empty;
            }
            int need_apply;
            Object[] each_args;
            Procedure proc;
            if (args[0] instanceof Procedure) {
                need_apply = 0;
                each_args = new Object[arity];
                proc = (Procedure)args[0];
            }
            else {
                need_apply = 1;
                each_args = new Object[arity + 1];
                each_args[0] = args[0];
                proc = this.applyToArgs;
            }
            final Iterator[] iterators = new Iterator[arity];
            for (int i = 0; i < arity; ++i) {
                iterators[i] = Sequences.getIterator(args[i + 1]);
            }
        Block_8:
            while (true) {
                for (int i = 0; i < arity; ++i) {
                    final Iterator it = iterators[i];
                    if (!it.hasNext()) {
                        break Block_8;
                    }
                    each_args[need_apply + i] = it.next();
                }
                final Object value = proc.applyN(each_args);
                if (this.collect) {
                    final Pair new_pair = new Pair(value, LList.Empty);
                    if (last == null) {
                        result = new_pair;
                    }
                    else {
                        last.setCdr(new_pair);
                    }
                    last = new_pair;
                }
            }
            return result;
        }
        final Procedure proc2 = (Procedure)args[0];
        if (this.collect) {
            return map1(proc2, args[1]);
        }
        forEach1(proc2, args[1]);
        return Values.empty;
    }
    
    @Override
    public int numArgs() {
        return -4094;
    }
}
