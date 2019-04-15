/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.rnrs;

import gnu.expr.ApplicationMainSupport;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Format;
import gnu.kawa.util.ExitCalled;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.lists;
import kawa.lib.numbers;

public class programs
extends ModuleBody {
    public static final ModuleMethod command$Mnline;
    public static final ModuleMethod exit;
    public static final ModuleMethod emergency$Mnexit;
    static final IntNum Lit0;
    public static programs $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static LList commandLine() {
        String string;
        LList rest = LList.makeList(ApplicationMainSupport.commandLineArgArray, 0);
        String command$Mnname = ApplicationMainSupport.commandName.get(null);
        if (command$Mnname == null) {
            String string2;
            try {
                String string3;
                String raw;
                String raw2;
                String raw1 = System.getProperty("kawa.command.line");
                Object object2 = raw1 == null ? ((raw2 = System.getProperty("sun.java.command")) == null ? null : "java ".concat(raw2)) : (raw = raw1);
                if (raw == null) {
                    string3 = null;
                } else {
                    String frest = Format.formatToString(0, "~{ ~a~}", rest);
                    int rlen = raw.length();
                    int flen = frest.length();
                    int alen = rlen - flen;
                    string3 = flen == 0 ? raw : (alen >= 0 && raw.substring(alen).equals(frest) ? raw.substring(0, alen) : null);
                }
                string2 = string3;
            }
            catch (Throwable exp) {
                string2 = null;
            }
            String command = string2;
            string = command == null ? "kawa" : command;
        } else {
            string = command$Mnname;
        }
        String arg0 = string;
        return lists.cons(arg0, rest);
    }

    public static void exit() {
        programs.exit(Lit0);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void exit(Object code) {
        Object object2;
        int n;
        if (numbers.isInteger(code)) {
            object2 = Promise.force(code);
            n = ((Number)object2).intValue();
        } else {
            n = KawaConvert.isTrue(code) ? 0 : -1;
        }
        int status = n;
        ExitCalled.doExit(status);
        return;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "status", -2, object2);
        }
    }

    public static void emergencyExit() {
        programs.emergencyExit(Lit0);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void emergencyExit(Object code) {
        Object object2;
        int n;
        if (numbers.isInteger(code)) {
            object2 = Promise.force(code);
            n = ((Number)object2).intValue();
        } else {
            n = KawaConvert.isTrue(code) ? 0 : -1;
        }
        int status = n;
        Runtime.getRuntime().halt(status);
        return;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "status", -2, object2);
        }
    }

    public static {
        Lit3 = Symbol.valueOf("emergency-exit");
        Lit2 = Symbol.valueOf("exit");
        Lit1 = Symbol.valueOf("command-line");
        Lit0 = IntNum.valueOf(0);
        programs programs2 = $instance = new programs();
        command$Mnline = new ModuleMethod(programs2, 1, Lit1, 0);
        exit = new ModuleMethod(programs2, 2, Lit2, 4096);
        emergency$Mnexit = new ModuleMethod(programs2, 4, Lit3, 4096);
        programs.$runBody$();
    }

    public programs() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 4: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 2: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 1: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 4: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 1: {
                return programs.commandLine();
            }
            case 2: {
                programs.exit();
                return Values.empty;
            }
            case 4: {
                programs.emergencyExit();
                return Values.empty;
            }
        }
        return super.apply0(moduleMethod);
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 2: {
                programs.exit(object2);
                return Values.empty;
            }
            case 4: {
                programs.emergencyExit(object2);
                return Values.empty;
            }
        }
        return super.apply1(moduleMethod, object2);
    }
}

