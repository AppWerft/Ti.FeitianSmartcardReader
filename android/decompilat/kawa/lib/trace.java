// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.WrongType;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.lists.PairWithPosition;
import gnu.lists.LList;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.expr.PrimProcedure;
import gnu.mapping.Procedure;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import kawa.lang.Macro;
import gnu.expr.ModuleBody;

public class trace extends ModuleBody
{
    public static final Macro $Pcdo$Mntrace;
    public static final Macro trace;
    public static final Macro untrace;
    public static final ModuleMethod disassemble;
    public static trace $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit6;
    static final Object[] Lit7;
    static final SimpleSymbol Lit8;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object disassemble(final Procedure proc) {
        final CallContext $ctx;
        final CallContext ctx = $ctx = CallContext.getInstance();
        final int startFromContext = $ctx.startFromContext();
        try {
            PrimProcedure.disassemble$X(proc, ctx);
        }
        finally {
            $ctx.cleanupFromContext(startFromContext);
        }
        return $ctx.getFromContext(startFromContext);
    }
    
    static {
        Lit8 = Symbol.valueOf("begin");
        Lit7 = new Object[0];
        Lit6 = Symbol.valueOf("disassemble");
        Lit5 = new SyntaxRules(kawa.lib.trace.Lit7, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", kawa.lib.trace.Lit7, 1, "trace.scm:18"), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\t\u0003\u0018\u0014", new Object[] { kawa.lib.trace.Lit8, Lit0 = Symbol.valueOf("%do-trace"), PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 77851) }, 1) }, 1, Lit4 = Symbol.valueOf("untrace"));
        Lit3 = new SyntaxRules(kawa.lib.trace.Lit7, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", kawa.lib.trace.Lit7, 1, "trace.scm:13"), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\t\u0003\u0018\u0014", new Object[] { kawa.lib.trace.Lit8, kawa.lib.trace.Lit0, PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 57371) }, 1) }, 1, Lit2 = Symbol.valueOf("trace"));
        Lit1 = new SyntaxRules(kawa.lib.trace.Lit7, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", kawa.lib.trace.Lit7, 2, "trace.scm:5"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\t\u0003\b\u000b", new Object[] { Symbol.valueOf("set!"), Symbol.valueOf("invoke-static"), Symbol.valueOf("<kawa.standard.TracedProcedure>"), PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Symbol.valueOf("doTrace"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 32806), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 32806) }, 0) }, 2, kawa.lib.trace.Lit0);
        kawa.lib.trace.$instance = new trace();
        $Pcdo$Mntrace = Macro.make(kawa.lib.trace.Lit0, kawa.lib.trace.Lit1, "kawa.lib.trace");
        trace = Macro.make(kawa.lib.trace.Lit2, kawa.lib.trace.Lit3, "kawa.lib.trace");
        untrace = Macro.make(kawa.lib.trace.Lit4, kawa.lib.trace.Lit5, "kawa.lib.trace");
        disassemble = new ModuleMethod(kawa.lib.trace.$instance, 1, kawa.lib.trace.Lit6, 4097);
        $runBody$();
    }
    
    public trace() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector != 1) {
            return super.match1(moduleMethod, o, ctx);
        }
        final Object force = Promise.force(o, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force) != null) {
            ctx.value1 = force;
            ctx.proc = moduleMethod;
            ctx.pc = 1;
            return 0;
        }
        return -786431;
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object argValue) {
        Label_0024: {
            if (method.selector != 1) {
                break Label_0024;
            }
            final Object force = Promise.force(argValue, Procedure.class);
            try {
                return disassemble(LangObjType.coerceToProcedure(force));
                return super.apply1(method, argValue);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "disassemble", 1, argValue);
            }
        }
    }
}
