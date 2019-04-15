/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.Type;
import gnu.expr.Keyword;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;

public class GenericProc
extends MethodProc {
    protected MethodProc[] methods;
    int count;
    int minArgs;
    int maxArgs;

    public GenericProc(String name) {
        this.setName(name);
    }

    public GenericProc() {
    }

    public int getMethodCount() {
        return this.count;
    }

    public MethodProc getMethod(int i) {
        return i >= this.count ? null : this.methods[i];
    }

    @Override
    public int numArgs() {
        return this.minArgs | this.maxArgs << 12;
    }

    protected synchronized void addAll(MethodProc[] procs) {
        int n = procs.length;
        if (this.methods == null) {
            this.methods = new MethodProc[n];
        }
        for (int i = 0; i < n; ++i) {
            this.add(procs[i]);
        }
    }

    public synchronized void addAtEnd(MethodProc method) {
        int oldCount = this.count;
        if (this.methods == null) {
            this.methods = new MethodProc[8];
        } else if (oldCount >= this.methods.length) {
            MethodProc[] copy = new MethodProc[2 * this.methods.length];
            System.arraycopy(this.methods, 0, copy, 0, oldCount);
            this.methods = copy;
        }
        this.methods[oldCount] = method;
        int n = method.minArgs();
        if (n < this.minArgs || this.count == 0) {
            this.minArgs = n;
        }
        if (((n = method.maxArgs()) < 0 || n > this.maxArgs) && this.maxArgs >= 0) {
            this.maxArgs = n;
        }
        this.count = ++oldCount;
    }

    public synchronized void add(MethodProc method) {
        int oldCount = this.count;
        this.addAtEnd(method);
        for (int i = 0; i < oldCount; ++i) {
            MethodProc best = MethodProc.mostSpecific(method, this.methods[i]);
            if (best != method) continue;
            System.arraycopy(this.methods, i, this.methods, i + 1, oldCount - i);
            this.methods[i] = method;
            break;
        }
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        if (this.count == 1) {
            return this.methods[0].applyN(args);
        }
        GenericProc.checkArgCount(this, args.length);
        CallContext ctx = CallContext.getInstance();
        for (int i = 0; i < this.count; ++i) {
            MethodProc method = this.methods[i];
            int m = method.matchN(args, ctx);
            if (m != 0) continue;
            return ctx.runUntilValue();
        }
        throw new WrongType((Procedure)this, -1, null);
    }

    @Override
    public int isApplicable(Type[] args, Type restType) {
        int best = -1;
        int i = this.count;
        while (--i >= 0) {
            MethodProc method = this.methods[i];
            int result = method.isApplicable(args, restType);
            if (result == 1) {
                return 1;
            }
            if (result != 0) continue;
            best = 0;
        }
        return best;
    }

    @Override
    public int match0(CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match0(ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            MethodProc method = this.methods[i];
            int code = method.match0(ctx);
            if (code != 0) continue;
            return 0;
        }
        ctx.proc = null;
        return -1;
    }

    @Override
    public int match1(Object arg1, CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match1(arg1, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            MethodProc method = this.methods[i];
            int code = method.match1(arg1, ctx);
            if (code != 0) continue;
            return 0;
        }
        ctx.proc = null;
        return -1;
    }

    @Override
    public int match2(Object arg1, Object arg2, CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match2(arg1, arg2, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            MethodProc method = this.methods[i];
            int code = method.match2(arg1, arg2, ctx);
            if (code != 0) continue;
            return 0;
        }
        ctx.proc = null;
        return -1;
    }

    @Override
    public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match3(arg1, arg2, arg3, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            MethodProc method = this.methods[i];
            int code = method.match3(arg1, arg2, arg3, ctx);
            if (code != 0) continue;
            return 0;
        }
        ctx.proc = null;
        return -1;
    }

    @Override
    public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].match4(arg1, arg2, arg3, arg4, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            MethodProc method = this.methods[i];
            int code = method.match4(arg1, arg2, arg3, arg4, ctx);
            if (code != 0) continue;
            return 0;
        }
        ctx.proc = null;
        return -1;
    }

    @Override
    public int matchN(Object[] args, CallContext ctx) {
        if (this.count == 1) {
            return this.methods[0].matchN(args, ctx);
        }
        for (int i = 0; i < this.count; ++i) {
            MethodProc method = this.methods[i];
            int code = method.matchN(args, ctx);
            if (code != 0) continue;
            return 0;
        }
        ctx.proc = null;
        return -1;
    }

    public void setProperty(Keyword key, Object value) {
        String name = key.getName();
        if (name == "name") {
            this.setName(value.toString());
        } else if (name == "method") {
            this.add((MethodProc)value);
        } else {
            super.setProperty(key.asSymbol(), value);
        }
    }

    public final void setProperties(Object[] args) {
        int alen = args.length;
        for (int i = 0; i < alen; ++i) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                this.setProperty((Keyword)arg, args[++i]);
                continue;
            }
            this.add((MethodProc)arg);
        }
    }

    public static GenericProc make(Object[] args) {
        GenericProc result = new GenericProc();
        result.setProperties(args);
        return result;
    }

    public static /* varargs */ GenericProc makeWithoutSorting(Object ... args) {
        GenericProc result = new GenericProc();
        int alen = args.length;
        for (int i = 0; i < alen; ++i) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                result.setProperty((Keyword)arg, args[++i]);
                continue;
            }
            result.addAtEnd((MethodProc)arg);
        }
        return result;
    }
}

