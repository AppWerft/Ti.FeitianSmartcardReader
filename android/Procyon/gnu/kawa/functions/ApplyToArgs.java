// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.lists.IntSequence;
import gnu.mapping.WrongType;
import java.util.List;
import gnu.lists.ComposedArray;
import gnu.lists.Array;
import gnu.text.Char;
import gnu.lists.Strings;
import gnu.lists.Sequences;
import gnu.mapping.WrongArguments;
import gnu.kawa.reflect.Invoke;
import gnu.bytecode.Type;
import gnu.mapping.Promise;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.CallContext;
import gnu.expr.Language;
import gnu.mapping.ProcedureN;

public class ApplyToArgs extends ProcedureN
{
    Language language;
    
    @Override
    public int match1(final Object arg1, final CallContext ctx) {
        if (arg1 instanceof Procedure) {
            return ((Procedure)arg1).match0(ctx);
        }
        return super.match1(arg1, ctx);
    }
    
    @Override
    public int match2(final Object arg1, final Object arg2, final CallContext ctx) {
        if (arg1 instanceof Procedure) {
            return ((Procedure)arg1).match1(arg2, ctx);
        }
        return super.match2(arg1, arg2, ctx);
    }
    
    @Override
    public int match3(final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        if (arg1 instanceof Procedure) {
            return ((Procedure)arg1).match2(arg2, arg3, ctx);
        }
        return super.match3(arg1, arg2, arg3, ctx);
    }
    
    @Override
    public int match4(final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        if (arg1 instanceof Procedure) {
            return ((Procedure)arg1).match3(arg2, arg3, arg4, ctx);
        }
        return super.match4(arg1, arg2, arg3, arg4, ctx);
    }
    
    @Override
    public int matchN(final Object[] args, final CallContext ctx) {
        final int n = args.length;
        if (n <= 0 || !(args[0] instanceof Procedure)) {
            return super.matchN(args, ctx);
        }
        final Procedure proc = (Procedure)args[0];
        switch (n) {
            case 1: {
                return proc.match0(ctx);
            }
            case 2: {
                return proc.match1(args[1], ctx);
            }
            case 3: {
                return proc.match2(args[1], args[2], ctx);
            }
            case 4: {
                return proc.match3(args[1], args[2], args[3], ctx);
            }
            case 5: {
                return proc.match4(args[1], args[2], args[3], args[4], ctx);
            }
            default: {
                final Object[] xargs = new Object[n - 1];
                System.arraycopy(args, 1, xargs, 0, n - 1);
                return proc.matchN(xargs, ctx);
            }
        }
    }
    
    @Override
    public void check1(final Object arg1, final CallContext ctx) {
        if (arg1 instanceof Procedure) {
            ((Procedure)arg1).check0(ctx);
        }
        else {
            super.check1(arg1, ctx);
        }
    }
    
    @Override
    public void check2(final Object arg1, final Object arg2, final CallContext ctx) {
        if (arg1 instanceof Procedure) {
            ((Procedure)arg1).check1(arg2, ctx);
        }
        else {
            super.check2(arg1, arg2, ctx);
        }
    }
    
    @Override
    public void check3(final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        if (arg1 instanceof Procedure) {
            ((Procedure)arg1).check2(arg2, arg3, ctx);
        }
        else {
            super.check3(arg1, arg2, arg3, ctx);
        }
    }
    
    @Override
    public void check4(final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        if (arg1 instanceof Procedure) {
            ((Procedure)arg1).check3(arg2, arg3, arg4, ctx);
        }
        else {
            super.check4(arg1, arg2, arg3, arg4, ctx);
        }
    }
    
    @Override
    public void checkN(Object[] args, final CallContext ctx) {
        final int code = this.matchN(args, ctx);
        if (code != 0) {
            Procedure proc = this;
            if (args.length > 0 && args[0] instanceof Procedure) {
                proc = (Procedure)args[0];
                final Object[] xargs = new Object[args.length - 1];
                System.arraycopy(args, 1, xargs, 0, xargs.length);
                args = xargs;
            }
            throw MethodProc.matchFailAsException(code, proc, args);
        }
    }
    
    public ApplyToArgs(final String name, final Language language) {
        super(name);
        this.language = language;
        this.setProperty(Procedure.validateXApplyKey, "gnu.kawa.functions.CompilationHelpers:validateApplyToArgs");
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        final Object proc = Promise.force(args[0]);
        if (proc instanceof Procedure) {
            final Object[] rargs = new Object[args.length - 1];
            System.arraycopy(args, 1, rargs, 0, rargs.length);
            return ((Procedure)proc).applyN(rargs);
        }
        if (proc instanceof Type || proc instanceof Class) {
            return Invoke.make.applyN(args);
        }
        if (proc instanceof CharSequence) {
            if (args.length != 2) {
                throw new WrongArguments(this, args.length);
            }
            final Object index = Promise.force(args[1]);
            final IntSequence indexes = Sequences.asIntSequenceOrNull(index);
            final CharSequence str = (CharSequence)proc;
            if (indexes != null) {
                return Strings.indirectIndexed(str, indexes);
            }
            final int iindex = ((Number)index).intValue();
            return Char.valueOf(Strings.characterAt(str, iindex));
        }
        else {
            if (proc instanceof Array) {
                return ComposedArray.generalIndex((Array)proc, false, 1, args.length - 1, args);
            }
            if (proc instanceof List) {
                if (args.length != 2) {
                    throw new WrongArguments(this, args.length);
                }
                final List lst = (List)proc;
                final Object arg1 = Promise.force(args[1]);
                final IntSequence indexes2 = Sequences.asIntSequenceOrNull(arg1);
                if (indexes2 != null) {
                    return Sequences.indirectIndexed(lst, indexes2);
                }
                final int index2 = ((Number)arg1).intValue();
                return lst.get(index2);
            }
            else {
                final Class pclass = proc.getClass();
                if (!pclass.isArray()) {
                    throw new WrongType(this, 0, proc, "procedure");
                }
                if (args.length != 2) {
                    throw new WrongArguments(this, args.length);
                }
                return java.lang.reflect.Array.get(proc, ((Number)args[1]).intValue());
            }
        }
    }
}
