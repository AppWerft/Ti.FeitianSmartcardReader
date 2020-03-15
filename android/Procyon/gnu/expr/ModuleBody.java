// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.ProcedureN;
import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;
import gnu.mapping.Values;
import kawa.Shell;
import gnu.kawa.io.OutPort;
import gnu.kawa.util.ExitCalled;
import gnu.kawa.io.WriterManager;
import gnu.mapping.WrappedException;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure0;

public abstract class ModuleBody extends Procedure0 implements RunnableModule
{
    protected boolean runDone;
    private static boolean mainPrintValues;
    private static int exitCounter;
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        if (ctx.pc == 0) {
            this.run(ctx);
        }
    }
    
    @Override
    public void run(final CallContext ctx) throws Throwable {
    }
    
    public void run() {
        synchronized (this) {
            if (this.runDone) {
                return;
            }
            this.runDone = true;
        }
        this.run(VoidConsumer.instance);
    }
    
    public void run(final Consumer out) {
        final CallContext ctx = CallContext.getInstance();
        final Consumer save = ctx.consumer;
        ctx.consumer = out;
        Throwable th;
        try {
            this.run(ctx);
            th = null;
        }
        catch (Throwable ex) {
            th = ex;
        }
        runCleanup(ctx, th, save);
    }
    
    public static void runCleanup(final CallContext ctx, Throwable th, final Consumer save) {
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
        final CallContext ctx = CallContext.getInstance();
        this.match0(ctx);
        return ctx.runUntilValue();
    }
    
    public static boolean getMainPrintValues() {
        return ModuleBody.mainPrintValues;
    }
    
    public static void setMainPrintValues(final boolean value) {
        ModuleBody.mainPrintValues = value;
    }
    
    public static synchronized void exitIncrement() {
        if (ModuleBody.exitCounter == 0) {
            ++ModuleBody.exitCounter;
        }
        ++ModuleBody.exitCounter;
    }
    
    public static synchronized void exitDecrement() {
        int counter = ModuleBody.exitCounter;
        if (counter > 0) {
            if (--counter == 0) {
                System.exit(0);
            }
            else {
                ModuleBody.exitCounter = counter;
            }
        }
    }
    
    public final void runAsMain() {
        runAsMain(this);
    }
    
    public static void runAsMain(final RunnableModule module) {
        final boolean registered = WriterManager.instance.registerShutdownHook();
        try {
            ExitCalled.push();
            final CallContext ctx = CallContext.getInstance();
            if (getMainPrintValues()) {
                final OutPort out = OutPort.outDefault();
                ctx.consumer = Shell.getOutputConsumer(out);
                module.run(ctx);
                ctx.runUntilDone();
                out.freshLine();
            }
            else {
                ctx.consumer = VoidConsumer.instance;
                module.run(ctx);
                ctx.runUntilDone();
            }
            if (!registered) {
                OutPort.runCleanups();
            }
            exitDecrement();
        }
        catch (ExitCalled ex) {
            throw ex;
        }
        catch (Throwable ex2) {
            ex2.printStackTrace();
            OutPort.runCleanups();
            System.exit(-1);
        }
        finally {
            ExitCalled.pop();
        }
    }
    
    public Object apply0(final ModuleMethod method) throws Throwable {
        return this.applyN(method, Values.noArgs);
    }
    
    public Object apply1(final ModuleMethod method, final Object arg1) throws Throwable {
        final Object[] args = { arg1 };
        return this.applyN(method, args);
    }
    
    public Object apply2(final ModuleMethod method, final Object arg1, final Object arg2) throws Throwable {
        final Object[] args = { arg1, arg2 };
        return this.applyN(method, args);
    }
    
    public Object apply3(final ModuleMethod method, final Object arg1, final Object arg2, final Object arg3) throws Throwable {
        final Object[] args = { arg1, arg2, arg3 };
        return this.applyN(method, args);
    }
    
    public Object apply4(final ModuleMethod method, final Object arg1, final Object arg2, final Object arg3, final Object arg4) throws Throwable {
        final Object[] args = { arg1, arg2, arg3, arg4 };
        return this.applyN(method, args);
    }
    
    public Object applyN(final ModuleMethod method, final Object[] args) throws Throwable {
        final int count = args.length;
        final int num = method.numArgs();
        if (count >= (num & 0xFFF) && (num < 0 || count <= num >> 12)) {
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
    
    public int match0(final ModuleMethod proc, final CallContext ctx) {
        final int num = proc.numArgs();
        final int min = num & 0xFFF;
        if (min > 0) {
            return 0xFFF10000 | min;
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
    
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        final int num = proc.numArgs();
        final int min = num & 0xFFF;
        if (min > 1) {
            return 0xFFF10000 | min;
        }
        if (num < 0) {
            ctx.where = 0;
            final Object[] args = { arg1 };
            return this.matchN(proc, args, ctx);
        }
        final int max = num >> 12;
        if (max < 1) {
            return 0xFFF20000 | max;
        }
        ctx.value1 = arg1;
        ctx.count = 1;
        ctx.where = 1;
        ctx.next = 0;
        ctx.proc = proc;
        return 0;
    }
    
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        final int num = proc.numArgs();
        final int min = num & 0xFFF;
        if (min > 2) {
            return 0xFFF10000 | min;
        }
        if (num < 0) {
            ctx.where = 0;
            final Object[] args = { arg1, arg2 };
            return this.matchN(proc, args, ctx);
        }
        final int max = num >> 12;
        if (max < 2) {
            return 0xFFF20000 | max;
        }
        ctx.value1 = arg1;
        ctx.value2 = arg2;
        ctx.count = 2;
        ctx.where = 33;
        ctx.next = 0;
        ctx.proc = proc;
        return 0;
    }
    
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        final int num = proc.numArgs();
        final int min = num & 0xFFF;
        if (min > 3) {
            return 0xFFF10000 | min;
        }
        if (num < 0) {
            ctx.where = 0;
            final Object[] args = { arg1, arg2, arg3 };
            return this.matchN(proc, args, ctx);
        }
        final int max = num >> 12;
        if (max < 3) {
            return 0xFFF20000 | max;
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
    
    public int match4(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        final int num = proc.numArgs();
        final int min = num & 0xFFF;
        if (min > 4) {
            return 0xFFF10000 | min;
        }
        if (num < 0) {
            ctx.where = 0;
            final Object[] args = { arg1, arg2, arg3, arg4 };
            return this.matchN(proc, args, ctx);
        }
        final int max = num >> 12;
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
        ctx.proc = proc;
        return 0;
    }
    
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        final int num = proc.numArgs();
        final int min = num & 0xFFF;
        if (args.length < min) {
            return 0xFFF10000 | min;
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
                default: {
                    final int max = num >> 12;
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
        ctx.proc = proc;
        return 0;
    }
}
