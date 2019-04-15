/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.functions.ApplyToArgs;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;
import java.lang.reflect.Array;

public class Apply
extends ProcedureN {
    ApplyToArgs applyToArgs;

    public Apply(String name, ApplyToArgs applyToArgs) {
        super(name);
        this.applyToArgs = applyToArgs;
    }

    public static Object[] getArguments(LList args, int skip, Procedure proc) {
        return Apply.getArguments(args.toArray(), skip, proc);
    }

    public static Object[] getArguments(Object[] args, int skip, Procedure proc) {
        Object[] proc_args;
        block12 : {
            int last_count;
            Object last;
            block11 : {
                int i;
                int count = args.length;
                if (count < skip + 1) {
                    throw new WrongArguments("apply", 2, "(apply proc [args] args)");
                }
                last = args[count - 1];
                if (last instanceof Object[]) {
                    Object[] last_arr = (Object[])last;
                    if (count == skip + 1) {
                        return last_arr;
                    }
                    last_count = last_arr.length;
                } else {
                    last_count = last instanceof Sequence ? ((Sequence)last).size() : (last.getClass().isArray() ? Array.getLength(last) : -1);
                }
                if (last_count < 0) {
                    throw new WrongType(proc, count, last, "sequence or array");
                }
                int numArgs = last_count + (count - skip - 1);
                proc_args = new Object[numArgs];
                for (i = 0; i < count - skip - 1; ++i) {
                    proc_args[i] = args[i + skip];
                }
                if (!(last instanceof Object[])) break block11;
                System.arraycopy((Object[])last, 0, proc_args, i, last_count);
                break block12;
            }
            while (last instanceof Pair) {
                Pair pair = (Pair)last;
                proc_args[i++] = pair.getCar();
                last = pair.getCdr();
                --last_count;
            }
            if (last_count <= 0) break block12;
            if (last.getClass().isArray()) {
                for (int j = 0; j < last_count; ++j) {
                    proc_args[i++] = Array.get(last, j);
                }
            } else {
                Sequence last_seq = (Sequence)last;
                for (int j = 0; j < last_count; ++j) {
                    proc_args[i++] = last_seq.get(j);
                }
            }
        }
        return proc_args;
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        return this.applyToArgs.applyN(Apply.getArguments(args, 0, (Procedure)this));
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Object[] args = ctx.getArgs();
        this.applyToArgs.checkN(Apply.getArguments(args, 0, (Procedure)this), ctx);
    }
}

