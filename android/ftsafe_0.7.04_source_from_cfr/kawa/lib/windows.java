/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.KawaConvert;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.GuiConsole;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class windows
extends ModuleBody {
    public static final ModuleMethod scheme$Mnwindow;
    public static windows $instance;
    static final SimpleSymbol Lit0;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static void schemeWindow() {
        windows.schemeWindow(Boolean.FALSE);
    }

    public static void schemeWindow(Object share) {
        Scheme language = Scheme.getInstance();
        Environment env = KawaConvert.isTrue(share) ? misc.interactionEnvironment() : language.getNewEnvironment();
        Object object2 = Promise.force(share);
        try {
            new GuiConsole(language, env, KawaConvert.isTrue(object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "kawa.GuiConsole.<init>(gnu.expr.Language,gnu.mapping.Environment,boolean)", 3, object2);
        }
    }

    public static {
        Lit0 = Symbol.valueOf("scheme-window");
        windows windows2 = $instance = new windows();
        scheme$Mnwindow = new ModuleMethod(windows2, 1, Lit0, 4096);
        windows.$runBody$();
    }

    public windows() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.proc = moduleMethod;
            callContext.pc = 0;
            return 0;
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.value1 = object2;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply0(ModuleMethod moduleMethod) {
        if (moduleMethod.selector == 1) {
            windows.schemeWindow();
            return Values.empty;
        }
        return super.apply0(moduleMethod);
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector == 1) {
            windows.schemeWindow(object2);
            return Values.empty;
        }
        return super.apply1(moduleMethod, object2);
    }
}

