/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.ModuleMethod;
import gnu.expr.RunnableModule;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.WriterManager;
import gnu.kawa.util.ExitCalled;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure0;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import kawa.Shell;

public abstract class ModuleBody
extends Procedure0
implements RunnableModule {
    protected boolean runDone;
    private static boolean mainPrintValues;
    private static int exitCounter;

    @Override
    public void apply(CallContext ctx) throws Throwable {
        if (ctx.pc == 0) {
            this.run(ctx);
        }
    }

    @Override
    public void run(CallContext ctx) throws Throwable {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        ModuleBody moduleBody = this;
        synchronized (moduleBody) {
            if (this.runDone) {
                return;
            }
            this.runDone = true;
        }
        this.run(VoidConsumer.instance);
    }

    public void run(Consumer out) {
        Throwable th;
        CallContext ctx = CallContext.getInstance();
        Consumer save = ctx.consumer;
        ctx.consumer = out;
        try {
            this.run(ctx);
            th = null;
        }
        catch (Throwable ex) {
            th = ex;
        }
        ModuleBody.runCleanup(ctx, th, save);
    }

    public static void runCleanup(CallContext ctx, Throwable th, Consumer save) {
        if (th == null) {
            try {
                ctx.runUntilDone();
            }
            catch (Throwable ex) {
                th = ex;
            }
        }
        ctx.consumer = save;
        if (th != null) {
            WrappedException.rethrow(th);
        }
    }

    @Override
    public Object apply0() throws Throwable {
        CallContext ctx = CallContext.getInstance();
        this.match0(ctx);
        return ctx.runUntilValue();
    }

    public static boolean getMainPrintValues() {
        return mainPrintValues;
    }

    public static void setMainPrintValues(boolean value) {
        mainPrintValues = value;
    }

    public static synchronized void exitIncrement() {
        if (exitCounter == 0) {
            ++exitCounter;
        }
        ++exitCounter;
    }

    public static synchronized void exitDecrement() {
        int counter = exitCounter;
        if (counter > 0) {
            if (--counter == 0) {
                System.exit(0);
            } else {
                exitCounter = counter;
            }
        }
    }

    public final void runAsMain() {
        ModuleBody.runAsMain(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void runAsMain(RunnableModule module) {
        boolean registered = WriterManager.instance.registerShutdownHook();
        try {
            ExitCalled.push();
            CallContext ctx = CallContext.getInstance();
            if (ModuleBody.getMainPrintValues()) {
                OutPort out = OutPort.outDefault();
                ctx.consumer = Shell.getOutputConsumer(out);
                module.run(ctx);
                ctx.runUntilDone();
                out.freshLine();
            } else {
                ctx.consumer = VoidConsumer.instance;
                module.run(ctx);
                ctx.runUntilDone();
            }
            if (!registered) {
                OutPort.runCleanups();
            }
            ModuleBody.exitDecrement();
        }
        catch (ExitCalled ex) {
            throw ex;
        }
        catch (Throwable ex) {
            ex.printStackTrace();
            OutPort.runCleanups();
            System.exit(-1);
        }
        finally {
            ExitCalled.pop();
        }
    }

    public Object apply0(ModuleMethod method) throws Throwable {
        return this.applyN(method, Values.noArgs);
    }

    public Object apply1(ModuleMethod method, Object arg1) throws Throwable {
        Object[] args = new Object[]{arg1};
        return this.applyN(method, args);
    }

    public Object apply2(ModuleMethod method, Object arg1, Object arg2) throws Throwable {
        Object[] args = new Object[]{arg1, arg2};
        return this.applyN(method, args);
    }

    public Object apply3(ModuleMethod method, Object arg1, Object arg2, Object arg3) throws Throwable {
        Object[] args = new Object[]{arg1, arg2, arg3};
        return this.applyN(method, args);
    }

    public Object apply4(ModuleMethod method, Object arg1, Object arg2, Object arg3, Object arg4) throws Throwable {
        Object[] args = new Object[]{arg1, arg2, arg3, arg4};
        return this.applyN(method, args);
    }

    public Object applyN(ModuleMethod method, Object[] args) throws Throwable {
        int count = args.length;
        int num = method.numArgs();
        if (count >= (num & 4095) && (num < 0 || count <= num >> 12)) {
            switch (count) {
                case 0: {
                    return this.apply0(method);
                }
                case 1: {
                    return this.apply1(method, args[0]);
                }
                case 2: {
                    return this.apply2(method, args[0], args[1]);
                }
                case 3: {
                    return this.apply3(method, args[0], args[1], args[2]);
                }
                case 4: {
                    return this.apply4(method, args[0], args[1], args[2], args[3]);
                }
            }
        }
        throw new WrongArguments(method, count);
    }

    public int match0(ModuleMethod proc, CallContext ctx) {
        int num = proc.numArgs();
        int min = num & 4095;
        if (min > 0) {
            return -983040 | min;
        }
        if (num < 0) {
            return this.matchN(proc, ProcedureN.noArgs, ctx);
        }
        ctx.count = 0;
        ctx.where = 0;
        ctx.next = 0;
        ctx.proc = proc;
        return 0;
    }

    public int match1(ModuleMethod proc, Object arg1, CallContext ctx) {
        int num = proc.numArgs();
        int min = num & 4095;
        if (min > 1) {
            return -983040 | min;
        }
        if (num >= 0) {
            int max = num >> 12;
            if (max < 1) {
                return -917504 | max;
            }
            ctx.value1 = arg1;
            ctx.count = 1;
            ctx.where = 1;
            ctx.next = 0;
            ctx.proc = proc;
            return 0;
        }
        ctx.where = 0;
        Object[] args = new Object[]{arg1};
        return this.matchN(proc, args, ctx);
    }

    public int match2(ModuleMethod proc, Object arg1, Object arg2, CallContext ctx) {
        int num = proc.numArgs();
        int min = num & 4095;
        if (min > 2) {
            return -983040 | min;
        }
        if (num >= 0) {
            int max = num >> 12;
            if (max < 2) {
                return -917504 | max;
            }
            ctx.value1 = arg1;
            ctx.value2 = arg2;
            ctx.count = 2;
            ctx.where = 33;
            ctx.next = 0;
            ctx.proc = proc;
            return 0;
        }
        ctx.where = 0;
        Object[] args = new Object[]{arg1, arg2};
        return this.matchN(proc, args, ctx);
    }

    public int match3(ModuleMethod proc, Object arg1, Object arg2, Object arg3, CallContext ctx) {
        int num = proc.numArgs();
        int min = num & 4095;
        if (min > 3) {
            return -983040 | min;
        }
        if (num >= 0) {
            int max = num >> 12;
            if (max < 3) {
                return -917504 | max;
            }
            ctx.value1 = arg1;
            ctx.value2 = arg2;
            ctx.value3 = arg3;
            ctx.count = 3;
            ctx.where = 801;
            ctx.next = 0;
            ctx.proc = proc;
            return 0;
        }
        ctx.where = 0;
        Object[] args = new Object[]{arg1, arg2, arg3};
        return this.matchN(proc, args, ctx);
    }

    public int match4(ModuleMethod proc, Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx) {
        int num = proc.numArgs();
        int min = num & 4095;
        if (min > 4) {
            return -983040 | min;
        }
        if (num >= 0) {
            int max = num >> 12;
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
            ctx.proc = proc;
            return 0;
        }
        ctx.where = 0;
        Object[] args = new Object[]{arg1, arg2, arg3, arg4};
        return this.matchN(proc, args, ctx);
    }

    public int matchN(ModuleMethod proc, Object[] args, CallContext ctx) {
        int num = proc.numArgs();
        int min = num & 4095;
        if (args.length < min) {
            return -983040 | min;
        }
        if (num >= 0) {
            switch (args.length) {
                case 0: {
                    return this.match0(proc, ctx);
                }
                case 1: {
                    return this.match1(proc, args[0], ctx);
                }
                case 2: {
                    return this.match2(proc, args[0], args[1], ctx);
                }
                case 3: {
                    return this.match3(proc, args[0], args[1], args[2], ctx);
                }
                case 4: {
                    return this.match4(proc, args[0], args[1], args[2], args[3], ctx);
                }
            }
            int max = num >> 12;
            if (args.length > max) {
                return -917504 | max;
            }
        }
        ctx.values = args;
        ctx.count = args.length;
        ctx.where = 0;
        ctx.next = 0;
        ctx.proc = proc;
        return 0;
    }
}

