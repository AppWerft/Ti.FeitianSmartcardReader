// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.CallContext;
import gnu.lists.Pair;
import gnu.mapping.WrongType;
import java.lang.reflect.Array;
import gnu.lists.Sequence;
import gnu.mapping.WrongArguments;
import gnu.mapping.Procedure;
import gnu.lists.LList;
import gnu.mapping.ProcedureN;

public class Apply extends ProcedureN
{
    ApplyToArgs applyToArgs;
    
    public Apply(final String name, final ApplyToArgs applyToArgs) {
        super(name);
        this.applyToArgs = applyToArgs;
    }
    
    public static Object[] getArguments(final LList args, final int skip, final Procedure proc) {
        return getArguments(args.toArray(), skip, proc);
    }
    
    public static Object[] getArguments(final Object[] args, final int skip, final Procedure proc) {
        final int count = args.length;
        if (count < skip + 1) {
            throw new WrongArguments("apply", 2, "(apply proc [args] args)");
        }
        Object last = args[count - 1];
        int last_count;
        if (last instanceof Object[]) {
            final Object[] last_arr = (Object[])last;
            if (count == skip + 1) {
                return last_arr;
            }
            last_count = last_arr.length;
        }
        else if (last instanceof Sequence) {
            last_count = ((Sequence)last).size();
        }
        else if (last.getClass().isArray()) {
            last_count = Array.getLength(last);
        }
        else {
            last_count = -1;
        }
        if (last_count < 0) {
            throw new WrongType(proc, count, last, "sequence or array");
        }
        final int numArgs = last_count + (count - skip - 1);
        final Object[] proc_args = new Object[numArgs];
        int i;
        for (i = 0; i < count - skip - 1; ++i) {
            proc_args[i] = args[i + skip];
        }
        if (last instanceof Object[]) {
            System.arraycopy(last, 0, proc_args, i, last_count);
        }
        else {
            while (last instanceof Pair) {
                final Pair pair = (Pair)last;
                proc_args[i++] = pair.getCar();
                last = pair.getCdr();
                --last_count;
            }
            if (last_count > 0) {
                if (last.getClass().isArray()) {
                    for (int j = 0; j < last_count; ++j) {
                        proc_args[i++] = Array.get(last, j);
                    }
                }
                else {
                    final Sequence last_seq = (Sequence)last;
                    for (int k = 0; k < last_count; ++k) {
                        proc_args[i++] = last_seq.get(k);
                    }
                }
            }
        }
        return proc_args;
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        return this.applyToArgs.applyN(getArguments(args, 0, this));
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Object[] args = ctx.getArgs();
        this.applyToArgs.checkN(getArguments(args, 0, this), ctx);
    }
}
