// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.bytecode.Type;
import gnu.expr.Expression;

public abstract class Procedure extends PropertySet
{
    private static final String sourceLocationKey = "source-location";
    private static final Symbol setterKey;
    public static final Symbol validateApplyKey;
    public static final Symbol validateXApplyKey;
    public static final Symbol compilerXKey;
    public static final LazyPropertyKey<?> compilerKey;
    
    public void setSourceLocation(final String file, final int line) {
        this.setProperty("source-location", file + ":" + line);
    }
    
    public String getSourceLocation() {
        final Object value = this.getProperty("source-location", null);
        return (value == null) ? null : value.toString();
    }
    
    public Procedure() {
    }
    
    public Procedure(final String n) {
        this.setName(n);
    }
    
    public abstract Object applyN(final Object[] p0) throws Throwable;
    
    public abstract Object apply0() throws Throwable;
    
    public abstract Object apply1(final Object p0) throws Throwable;
    
    public abstract Object apply2(final Object p0, final Object p1) throws Throwable;
    
    public abstract Object apply3(final Object p0, final Object p1, final Object p2) throws Throwable;
    
    public abstract Object apply4(final Object p0, final Object p1, final Object p2, final Object p3) throws Throwable;
    
    public final int minArgs() {
        return minArgs(this.numArgs());
    }
    
    public final int maxArgs() {
        return maxArgs(this.numArgs());
    }
    
    public int numArgs() {
        return -4096;
    }
    
    public static int minArgs(final int num) {
        return num & 0xFFF;
    }
    
    public static int maxArgs(final int num) {
        return num >> 12;
    }
    
    public static void checkArgCount(final Procedure proc, final int argCount) {
        final int num = proc.numArgs();
        if (argCount < minArgs(num) || (num >= 0 && argCount > maxArgs(num))) {
            throw new WrongArguments(proc, argCount);
        }
    }
    
    public void apply(final CallContext ctx) throws Throwable {
        apply(this, ctx);
    }
    
    public static void apply(final Procedure proc, final CallContext ctx) throws Throwable {
        final int count = ctx.count;
        Object result = null;
        if (ctx.where == 0 && count != 0) {
            result = proc.applyN(ctx.values);
        }
        else {
            switch (count) {
                case 0: {
                    result = proc.apply0();
                    break;
                }
                case 1: {
                    result = proc.apply1(ctx.getNextArg());
                    break;
                }
                case 2: {
                    result = proc.apply2(ctx.getNextArg(), ctx.getNextArg());
                    break;
                }
                case 3: {
                    result = proc.apply3(ctx.getNextArg(), ctx.getNextArg(), ctx.getNextArg());
                    break;
                }
                case 4: {
                    result = proc.apply4(ctx.getNextArg(), ctx.getNextArg(), ctx.getNextArg(), ctx.getNextArg());
                    break;
                }
                default: {
                    result = proc.applyN(ctx.getArgs());
                    break;
                }
            }
        }
        ctx.writeValue(result);
    }
    
    public int match0(final CallContext ctx) {
        final int num = this.numArgs();
        final int min = minArgs(num);
        if (min > 0) {
            return 0xFFF10000 | min;
        }
        if (num < 0) {
            return this.matchN(ProcedureN.noArgs, ctx);
        }
        ctx.count = 0;
        ctx.where = 0;
        ctx.next = 0;
        ctx.proc = this;
        return 0;
    }
    
    public int match1(final Object arg1, final CallContext ctx) {
        final int num = this.numArgs();
        final int min = minArgs(num);
        if (min > 1) {
            return 0xFFF10000 | min;
        }
        if (num < 0) {
            final Object[] args = { arg1 };
            return this.matchN(args, ctx);
        }
        final int max = maxArgs(num);
        if (max < 1) {
            return 0xFFF20000 | max;
        }
        ctx.value1 = arg1;
        ctx.count = 1;
        ctx.where = 1;
        ctx.next = 0;
        ctx.proc = this;
        return 0;
    }
    
    public int match2(final Object arg1, final Object arg2, final CallContext ctx) {
        final int num = this.numArgs();
        final int min = minArgs(num);
        if (min > 2) {
            return 0xFFF10000 | min;
        }
        if (num < 0) {
            final Object[] args = { arg1, arg2 };
            return this.matchN(args, ctx);
        }
        final int max = maxArgs(num);
        if (max < 2) {
            return 0xFFF20000 | max;
        }
        ctx.value1 = arg1;
        ctx.value2 = arg2;
        ctx.count = 2;
        ctx.where = 33;
        ctx.next = 0;
        ctx.proc = this;
        return 0;
    }
    
    public int match3(final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        final int num = this.numArgs();
        final int min = minArgs(num);
        if (min > 3) {
            return 0xFFF10000 | min;
        }
        if (num < 0) {
            final Object[] args = { arg1, arg2, arg3 };
            return this.matchN(args, ctx);
        }
        final int max = maxArgs(num);
        if (max < 3) {
            return 0xFFF20000 | max;
        }
        ctx.value1 = arg1;
        ctx.value2 = arg2;
        ctx.value3 = arg3;
        ctx.count = 3;
        ctx.where = 801;
        ctx.next = 0;
        ctx.proc = this;
        return 0;
    }
    
    public int match4(final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        final int num = this.numArgs();
        final int min = minArgs(num);
        if (min > 4) {
            return 0xFFF10000 | min;
        }
        if (num < 0) {
            final Object[] args = { arg1, arg2, arg3, arg4 };
            return this.matchN(args, ctx);
        }
        final int max = maxArgs(num);
        if (max < 4) {
            return 0xFFF20000 | max;
        }
        ctx.value1 = arg1;
        ctx.value2 = arg2;
        ctx.value3 = arg3;
        ctx.value4 = arg4;
        ctx.count = 4;
        ctx.where = 17185;
        ctx.next = 0;
        ctx.proc = this;
        return 0;
    }
    
    public int matchN(final Object[] args, final CallContext ctx) {
        final int num = this.numArgs();
        final int min = minArgs(num);
        if (args.length < min) {
            return 0xFFF10000 | min;
        }
        if (num >= 0) {
            switch (args.length) {
                case 0: {
                    return this.match0(ctx);
                }
                case 1: {
                    return this.match1(args[0], ctx);
                }
                case 2: {
                    return this.match2(args[0], args[1], ctx);
                }
                case 3: {
                    return this.match3(args[0], args[1], args[2], ctx);
                }
                case 4: {
                    return this.match4(args[0], args[1], args[2], args[3], ctx);
                }
                default: {
                    final int max = maxArgs(num);
                    if (args.length > max) {
                        return 0xFFF20000 | max;
                    }
                    break;
                }
            }
        }
        ctx.values = args;
        ctx.count = args.length;
        ctx.where = 0;
        ctx.next = 0;
        ctx.proc = this;
        return 0;
    }
    
    public void check0(final CallContext ctx) {
        final int code = this.match0(ctx);
        if (code != 0) {
            throw MethodProc.matchFailAsException(code, this, ProcedureN.noArgs);
        }
    }
    
    public void check1(final Object arg1, final CallContext ctx) {
        final int code = this.match1(arg1, ctx);
        if (code != 0) {
            final Object[] args = { arg1 };
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }
    
    public void check2(final Object arg1, final Object arg2, final CallContext ctx) {
        final int code = this.match2(arg1, arg2, ctx);
        if (code != 0) {
            final Object[] args = { arg1, arg2 };
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }
    
    public void check3(final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        final int code = this.match3(arg1, arg2, arg3, ctx);
        if (code != 0) {
            final Object[] args = { arg1, arg2, arg3 };
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }
    
    public void check4(final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        final int code = this.match4(arg1, arg2, arg3, arg4, ctx);
        if (code != 0) {
            final Object[] args = { arg1, arg2, arg3, arg4 };
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }
    
    public void checkN(final Object[] args, final CallContext ctx) {
        final int code = this.matchN(args, ctx);
        if (code != 0) {
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }
    
    public Procedure getSetter() {
        if (!(this instanceof HasSetter)) {
            final Object setter = this.getProperty(Procedure.setterKey, null);
            if (setter instanceof Procedure) {
                return (Procedure)setter;
            }
            throw new RuntimeException("procedure '" + this.getName() + "' has no setter");
        }
        else {
            final int num_args = this.numArgs();
            if (num_args == 0) {
                return new Setter0(this);
            }
            if (num_args == 4097) {
                return new Setter1(this);
            }
            return new Setter(this);
        }
    }
    
    public void setSetter(final Procedure setter) {
        if (this instanceof HasSetter) {
            throw new RuntimeException("procedure '" + this.getName() + "' has builtin setter - cannot be modified");
        }
        this.setProperty(Procedure.setterKey, setter);
    }
    
    public void set0(final Object result) throws Throwable {
        this.getSetter().apply1(result);
    }
    
    public void set1(final Object arg1, final Object value) throws Throwable {
        this.getSetter().apply2(arg1, value);
    }
    
    public void setN(final Object[] args) throws Throwable {
        this.getSetter().applyN(args);
    }
    
    public boolean isSideEffectFree() {
        return false;
    }
    
    public Type getReturnType(final Expression[] args) {
        return Type.objectType;
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append("#<procedure ");
        String n = this.getName();
        if (n == null) {
            n = this.getSourceLocation();
        }
        if (n == null) {
            n = this.getClass().getName();
        }
        sbuf.append(n);
        sbuf.append('>');
        return sbuf.toString();
    }
    
    static {
        setterKey = Namespace.EmptyNamespace.getSymbol("setter");
        validateApplyKey = Namespace.EmptyNamespace.getSymbol("validate-apply");
        validateXApplyKey = Namespace.EmptyNamespace.getSymbol("validate-xapply");
        compilerXKey = Namespace.EmptyNamespace.getSymbol("compile-apply");
        compilerKey = new LazyPropertyKey<Object>("compiler");
    }
}
