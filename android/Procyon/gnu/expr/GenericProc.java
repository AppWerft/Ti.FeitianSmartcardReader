// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Type;
import gnu.mapping.WrongType;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.MethodProc;

public class GenericProc extends MethodProc
{
    protected MethodProc[] methods;
    int count;
    int minArgs;
    int maxArgs;
    
    public GenericProc(final String name) {
        this.setName(name);
    }
    
    public GenericProc() {
    }
    
    public int getMethodCount() {
        return this.count;
    }
    
    public MethodProc getMethod(final int i) {
        return (i >= this.count) ? null : this.methods[i];
    }
    
    @Override
    public int numArgs() {
        return this.minArgs | this.maxArgs << 12;
    }
    
    protected synchronized void addAll(final MethodProc[] procs) {
        final int n = procs.length;
        if (this.methods == null) {
            this.methods = new MethodProc[n];
        }
        for (int i = 0; i < n; ++i) {
            this.add(procs[i]);
        }
    }
    
    public synchronized void addAtEnd(final MethodProc method) {
        int oldCount = this.count;
        if (this.methods == null) {
            this.methods = new MethodProc[8];
        }
        else if (oldCount >= this.methods.length) {
            final MethodProc[] copy = new MethodProc[2 * this.methods.length];
            System.arraycopy(this.methods, 0, copy, 0, oldCount);
            this.methods = copy;
        }
        this.methods[oldCount] = method;
        int n = method.minArgs();
        if (n < this.minArgs || this.count == 0) {
            this.minArgs = n;
        }
        n = method.maxArgs();
        if ((n < 0 || n > this.maxArgs) && this.maxArgs >= 0) {
            this.maxArgs = n;
        }
        this.count = ++oldCount;
    }
    
    public synchronized void add(final MethodProc method) {
        final int oldCount = this.count;
        this.addAtEnd(method);
        for (int i = 0; i < oldCount; ++i) {
            final MethodProc best = MethodProc.mostSpecific(method, this.methods[i]);
            if (best == method) {
                System.arraycopy(this.methods, i, this.methods, i + 1, oldCount - i);
                this.methods[i] = method;
                break;
            }
        }
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        if (this.count == 1) {
            return this.methods[0].applyN(args);
        }
        Procedure.checkArgCount(this, args.length);
        final CallContext ctx = CallContext.getInstance();
        for (int i = 0; i < this.count; ++i) {
            final MethodProc method = this.methods[i];
            final int m = method.matchN(args, ctx);
            if (m == 0) {
                return ctx.runUntilValue();
            }
        }
        throw new WrongType(this, -1, null);
    }
    
    @Override
    public int isApplicable(final Type[] args, final Type restType) {
        int best = -1;
        int i = this.count;
        while (--i >= 0) {
            final MethodProc method = this.methods[i];
            final int result = method.isApplicable(args, restType);
            if (result == 1) {
                return 1;
            }
            if (result != 0) {
                continue;
            }
            best = 0;
        }
        return best;
    }
    
    @Override
    public int match0(final CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match0(ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            final MethodProc method = this.methods[i];
            final int code = method.match0(ctx);
            if (code == 0) {
                return 0;
            }
        }
        ctx.proc = null;
        return -1;
    }
    
    @Override
    public int match1(final Object arg1, final CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match1(arg1, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            final MethodProc method = this.methods[i];
            final int code = method.match1(arg1, ctx);
            if (code == 0) {
                return 0;
            }
        }
        ctx.proc = null;
        return -1;
    }
    
    @Override
    public int match2(final Object arg1, final Object arg2, final CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match2(arg1, arg2, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            final MethodProc method = this.methods[i];
            final int code = method.match2(arg1, arg2, ctx);
            if (code == 0) {
                return 0;
            }
        }
        ctx.proc = null;
        return -1;
    }
    
    @Override
    public int match3(final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match3(arg1, arg2, arg3, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            final MethodProc method = this.methods[i];
            final int code = method.match3(arg1, arg2, arg3, ctx);
            if (code == 0) {
                return 0;
            }
        }
        ctx.proc = null;
        return -1;
    }
    
    @Override
    public int match4(final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match4(arg1, arg2, arg3, arg4, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            final MethodProc method = this.methods[i];
            final int code = method.match4(arg1, arg2, arg3, arg4, ctx);
            if (code == 0) {
                return 0;
            }
        }
        ctx.proc = null;
        return -1;
    }
    
    @Override
    public int matchN(final Object[] args, final CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].matchN(args, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            final MethodProc method = this.methods[i];
            final int code = method.matchN(args, ctx);
            if (code == 0) {
                return 0;
            }
        }
        ctx.proc = null;
        return -1;
    }
    
    public void setProperty(final Keyword key, final Object value) {
        final String name = key.getName();
        if (name == "name") {
            this.setName(value.toString());
        }
        else if (name == "method") {
            this.add((MethodProc)value);
        }
        else {
            super.setProperty(key.asSymbol(), value);
        }
    }
    
    public final void setProperties(final Object[] args) {
        for (int alen = args.length, i = 0; i < alen; ++i) {
            final Object arg = args[i];
            if (arg instanceof Keyword) {
                this.setProperty((Keyword)arg, args[++i]);
            }
            else {
                this.add((MethodProc)arg);
            }
        }
    }
    
    public static GenericProc make(final Object[] args) {
        final GenericProc result = new GenericProc();
        result.setProperties(args);
        return result;
    }
    
    public static GenericProc makeWithoutSorting(final Object... args) {
        final GenericProc result = new GenericProc();
        for (int alen = args.length, i = 0; i < alen; ++i) {
            final Object arg = args[i];
            if (arg instanceof Keyword) {
                result.setProperty((Keyword)arg, args[++i]);
            }
            else {
                result.addAtEnd((MethodProc)arg);
            }
        }
        return result;
    }
}
