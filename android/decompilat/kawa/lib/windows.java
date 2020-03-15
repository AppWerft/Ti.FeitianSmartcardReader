// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Values;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.mapping.Environment;
import gnu.expr.Language;
import gnu.mapping.WrongType;
import kawa.GuiConsole;
import gnu.mapping.Promise;
import gnu.expr.KawaConvert;
import kawa.standard.Scheme;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class windows extends ModuleBody
{
    public static final ModuleMethod scheme$Mnwindow;
    public static windows $instance;
    static final SimpleSymbol Lit0;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static void schemeWindow() {
        schemeWindow(Boolean.FALSE);
    }
    
    public static void schemeWindow(final Object share) {
        final Language language = Scheme.getInstance();
        final Environment env = KawaConvert.isTrue(share) ? misc.interactionEnvironment() : language.getNewEnvironment();
        final Language language2 = language;
        final Environment penvironment = env;
        final Object force = Promise.force(share);
        try {
            final GuiConsole guiConsole = new GuiConsole(language2, penvironment, KawaConvert.isTrue(force));
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "kawa.GuiConsole.<init>(gnu.expr.Language,gnu.mapping.Environment,boolean)", 3, force);
        }
    }
    
    static {
        Lit0 = Symbol.valueOf("scheme-window");
        windows.$instance = new windows();
        scheme$Mnwindow = new ModuleMethod(windows.$instance, 1, windows.Lit0, 4096);
        $runBody$();
    }
    
    public windows() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.proc = moduleMethod;
            return ctx.pc = 0;
        }
        return super.match0(moduleMethod, ctx);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.value1 = o;
            ctx.proc = moduleMethod;
            ctx.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, o, ctx);
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        if (method.selector == 1) {
            schemeWindow();
            return Values.empty;
        }
        return super.apply0(method);
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        if (method.selector == 1) {
            schemeWindow(o);
            return Values.empty;
        }
        return super.apply1(method, o);
    }
}
