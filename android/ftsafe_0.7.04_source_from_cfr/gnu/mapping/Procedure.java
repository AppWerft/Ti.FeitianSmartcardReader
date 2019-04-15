/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.mapping.CallContext;
import gnu.mapping.HasSetter;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.MethodProc;
import gnu.mapping.Namespace;
import gnu.mapping.ProcedureN;
import gnu.mapping.PropertySet;
import gnu.mapping.Setter;
import gnu.mapping.Setter0;
import gnu.mapping.Setter1;
import gnu.mapping.Symbol;
import gnu.mapping.WrongArguments;

public abstract class Procedure
extends PropertySet {
    private static final String sourceLocationKey = "source-location";
    private static final Symbol setterKey = Namespace.EmptyNamespace.getSymbol("setter");
    public static final Symbol validateApplyKey = Namespace.EmptyNamespace.getSymbol("validate-apply");
    public static final Symbol validateXApplyKey = Namespace.EmptyNamespace.getSymbol("validate-xapply");
    public static final Symbol compilerXKey = Namespace.EmptyNamespace.getSymbol("compile-apply");
    public static final LazyPropertyKey<?> compilerKey = new LazyPropertyKey<T>("compiler");

    public void setSourceLocation(String file2, int line) {
        this.setProperty(sourceLocationKey, file2 + ":" + line);
    }

    public String getSourceLocation() {
        Object value = this.getProperty(sourceLocationKey, null);
        return value == null ? null : value.toString();
    }

    public Procedure() {
    }

    public Procedure(String n) {
        this.setName(n);
    }

    public abstract Object applyN(Object[] var1) throws Throwable;

    public abstract Object apply0() throws Throwable;

    public abstract Object apply1(Object var1) throws Throwable;

    public abstract Object apply2(Object var1, Object var2) throws Throwable;

    public abstract Object apply3(Object var1, Object var2, Object var3) throws Throwable;

    public abstract Object apply4(Object var1, Object var2, Object var3, Object var4) throws Throwable;

    public final int minArgs() {
        return Procedure.minArgs(this.numArgs());
    }

    public final int maxArgs() {
        return Procedure.maxArgs(this.numArgs());
    }

    public int numArgs() {
        return -4096;
    }

    public static int minArgs(int num) {
        return num & 4095;
    }

    public static int maxArgs(int num) {
        return num >> 12;
    }

    public static void checkArgCount(Procedure proc, int argCount) {
        int num = proc.numArgs();
        if (argCount < Procedure.minArgs(num) || num >= 0 && argCount > Procedure.maxArgs(num)) {
            throw new WrongArguments(proc, argCount);
        }
    }

    public void apply(CallContext ctx) throws Throwable {
        Procedure.apply(this, ctx);
    }

    public static void apply(Procedure proc, CallContext ctx) throws Throwable {
        Object result;
        int count = ctx.count;
        if (ctx.where == 0 && count != 0) {
            result = proc.applyN(ctx.values);
        } else {
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
                }
            }
        }
        ctx.writeValue(result);
    }

    public int match0(CallContext ctx) {
        int num = this.numArgs();
        int min = Procedure.minArgs(num);
        if (min > 0) {
            return -983040 | min;
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

    public int match1(Object arg1, CallContext ctx) {
        int num = this.numArgs();
        int min = Procedure.minArgs(num);
        if (min > 1) {
            return -983040 | min;
        }
        if (num >= 0) {
            int max = Procedure.maxArgs(num);
            if (max < 1) {
                return -917504 | max;
            }
            ctx.value1 = arg1;
            ctx.count = 1;
            ctx.where = 1;
            ctx.next = 0;
            ctx.proc = this;
            return 0;
        }
        Object[] args = new Object[]{arg1};
        return this.matchN(args, ctx);
    }

    public int match2(Object arg1, Object arg2, CallContext ctx) {
        int num = this.numArgs();
        int min = Procedure.minArgs(num);
        if (min > 2) {
            return -983040 | min;
        }
        if (num >= 0) {
            int max = Procedure.maxArgs(num);
            if (max < 2) {
                return -917504 | max;
            }
            ctx.value1 = arg1;
            ctx.value2 = arg2;
            ctx.count = 2;
            ctx.where = 33;
            ctx.next = 0;
            ctx.proc = this;
            return 0;
        }
        Object[] args = new Object[]{arg1, arg2};
        return this.matchN(args, ctx);
    }

    public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx) {
        int num = this.numArgs();
        int min = Procedure.minArgs(num);
        if (min > 3) {
            return -983040 | min;
        }
        if (num >= 0) {
            int max = Procedure.maxArgs(num);
            if (max < 3) {
                return -917504 | max;
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
        Object[] args = new Object[]{arg1, arg2, arg3};
        return this.matchN(args, ctx);
    }

    public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx) {
        int num = this.numArgs();
        int min = Procedure.minArgs(num);
        if (min > 4) {
            return -983040 | min;
        }
        if (num >= 0) {
            int max = Procedure.maxArgs(num);
            if (max < 4) {
                return -917504 | max;
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
        Object[] args = new Object[]{arg1, arg2, arg3, arg4};
        return this.matchN(args, ctx);
    }

    public int matchN(Object[] args, CallContext ctx) {
        int num = this.numArgs();
        int min = Procedure.minArgs(num);
        if (args.length < min) {
            return -983040 | min;
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
            }
            int max = Procedure.maxArgs(num);
            if (args.length > max) {
                return -917504 | max;
            }
        }
        ctx.values = args;
        ctx.count = args.length;
        ctx.where = 0;
        ctx.next = 0;
        ctx.proc = this;
        return 0;
    }

    public void check0(CallContext ctx) {
        int code = this.match0(ctx);
        if (code != 0) {
            throw MethodProc.matchFailAsException(code, this, ProcedureN.noArgs);
        }
    }

    public void check1(Object arg1, CallContext ctx) {
        int code = this.match1(arg1, ctx);
        if (code != 0) {
            Object[] args = new Object[]{arg1};
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }

    public void check2(Object arg1, Object arg2, CallContext ctx) {
        int code = this.match2(arg1, arg2, ctx);
        if (code != 0) {
            Object[] args = new Object[]{arg1, arg2};
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }

    public void check3(Object arg1, Object arg2, Object arg3, CallContext ctx) {
        int code = this.match3(arg1, arg2, arg3, ctx);
        if (code != 0) {
            Object[] args = new Object[]{arg1, arg2, arg3};
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }

    public void check4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx) {
        int code = this.match4(arg1, arg2, arg3, arg4, ctx);
        if (code != 0) {
            Object[] args = new Object[]{arg1, arg2, arg3, arg4};
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }

    public void checkN(Object[] args, CallContext ctx) {
        int code = this.matchN(args, ctx);
        if (code != 0) {
            throw MethodProc.matchFailAsException(code, this, args);
        }
    }

    public Procedure getSetter() {
        if (!(this instanceof HasSetter)) {
            Object setter = this.getProperty(setterKey, null);
            if (setter instanceof Procedure) {
                return (Procedure)setter;
            }
            throw new RuntimeException("procedure '" + this.getName() + "' has no setter");
        }
        int num_args = this.numArgs();
        if (num_args == 0) {
            return new Setter0(this);
        }
        if (num_args == 4097) {
            return new Setter1(this);
        }
        return new Setter(this);
    }

    public void setSetter(Procedure setter) {
        if (this instanceof HasSetter) {
            throw new RuntimeException("procedure '" + this.getName() + "' has builtin setter - cannot be modified");
        }
        this.setProperty(setterKey, setter);
    }

    public void set0(Object result) throws Throwable {
        this.getSetter().apply1(result);
    }

    public void set1(Object arg1, Object value) throws Throwable {
        this.getSetter().apply2(arg1, value);
    }

    public void setN(Object[] args) throws Throwable {
        this.getSetter().applyN(args);
    }

    public boolean isSideEffectFree() {
        return false;
    }

    public Type getReturnType(Expression[] args) {
        return Type.objectType;
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer();
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
}

