// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.rnrs;

import gnu.mapping.Values;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.expr.KawaConvert;
import gnu.kawa.util.ExitCalled;
import gnu.mapping.Promise;
import kawa.lib.numbers;
import kawa.lib.lists;
import gnu.kawa.functions.Format;
import gnu.expr.ApplicationMainSupport;
import gnu.lists.LList;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class programs extends ModuleBody
{
    public static final ModuleMethod command$Mnline;
    public static final ModuleMethod exit;
    public static final ModuleMethod emergency$Mnexit;
    static final IntNum Lit0;
    public static programs $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static LList commandLine() {
        final LList rest = LList.makeList(ApplicationMainSupport.commandLineArgArray, 0);
        final String command$Mnname = ApplicationMainSupport.commandName.get(null);
        String s4;
        if (command$Mnname == null) {
            String s3;
            try {
                final String property = System.getProperty("kawa.command.line");
                String s;
                if (property == null) {
                    final String raw2 = System.getProperty("sun.java.command");
                    s = ((raw2 == null) ? null : "java ".concat(raw2));
                }
                else {
                    s = property;
                }
                final String raw3 = s;
                String s2;
                if (raw3 == null) {
                    s2 = null;
                }
                else {
                    final String frest = Format.formatToString(0, "~{ ~a~}", rest);
                    final int rlen = raw3.length();
                    final int flen = frest.length();
                    final int alen = rlen - flen;
                    s2 = ((flen == 0) ? raw3 : ((alen >= 0 && raw3.substring(alen).equals(frest)) ? raw3.substring(0, alen) : null));
                }
                s3 = s2;
            }
            catch (Throwable exp) {
                s3 = null;
            }
            final String command = s3;
            s4 = ((command == null) ? "kawa" : command);
        }
        else {
            s4 = command$Mnname;
        }
        final String arg0 = s4;
        return lists.cons(arg0, rest);
    }
    
    public static void exit() {
        exit(programs.Lit0);
    }
    
    public static void exit(final Object code) {
        Label_0022: {
            if (!numbers.isInteger(code)) {
                break Label_0022;
            }
            final Object force = Promise.force(code);
            try {
                int intValue = ((Number)force).intValue();
                while (true) {
                    final int status = intValue;
                    ExitCalled.doExit(status);
                    return;
                    intValue = (KawaConvert.isTrue(code) ? 0 : -1);
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "status", -2, force);
            }
        }
    }
    
    public static void emergencyExit() {
        emergencyExit(programs.Lit0);
    }
    
    public static void emergencyExit(final Object code) {
        Label_0022: {
            if (!numbers.isInteger(code)) {
                break Label_0022;
            }
            final Object force = Promise.force(code);
            try {
                int intValue = ((Number)force).intValue();
                while (true) {
                    final int status = intValue;
                    Runtime.getRuntime().halt(status);
                    return;
                    intValue = (KawaConvert.isTrue(code) ? 0 : -1);
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "status", -2, force);
            }
        }
    }
    
    static {
        Lit3 = Symbol.valueOf("emergency-exit");
        Lit2 = Symbol.valueOf("exit");
        Lit1 = Symbol.valueOf("command-line");
        Lit0 = IntNum.valueOf(0);
        programs.$instance = new programs();
        final programs $instance = programs.$instance;
        command$Mnline = new ModuleMethod($instance, 1, programs.Lit1, 0);
        exit = new ModuleMethod($instance, 2, programs.Lit2, 4096);
        emergency$Mnexit = new ModuleMethod($instance, 4, programs.Lit3, 4096);
        $runBody$();
    }
    
    public programs() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 4: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 2: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 1: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(moduleMethod, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 4: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(proc, arg1, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 1: {
                return commandLine();
            }
            case 2: {
                exit();
                return Values.empty;
            }
            case 4: {
                emergencyExit();
                return Values.empty;
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object arg1) {
        switch (method.selector) {
            case 2: {
                exit(arg1);
                return Values.empty;
            }
            case 4: {
                emergencyExit(arg1);
                return Values.empty;
            }
            default: {
                return super.apply1(method, arg1);
            }
        }
    }
}
