/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.PrimProcedure;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class trace
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Object disassemble(Procedure proc) {
        CallContext $ctx = CallContext.getInstance();
        int n = $ctx.startFromContext();
        try {
            PrimProcedure.disassemble$X(proc, $ctx);
        }
        catch (Throwable throwable) {
            $ctx.cleanupFromContext(n);
            throw throwable;
        }
        return $ctx.getFromContext(n);
    }

    public static {
        Lit8 = Symbol.valueOf("begin");
        Lit7 = new Object[0];
        Lit6 = Symbol.valueOf("disassemble");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject = new Object[3];
        arrobject[0] = Lit8;
        Lit0 = Symbol.valueOf("%do-trace");
        arrobject[1] = Lit0;
        arrobject[2] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 77851);
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", Lit7, 1, "trace.scm:18"), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\t\u0003\u0018\u0014", arrobject, 1);
        Lit4 = Symbol.valueOf("untrace");
        Lit5 = new SyntaxRules(Lit7, arrsyntaxRule, 1, Lit4);
        Lit2 = Symbol.valueOf("trace");
        Lit3 = new SyntaxRules(Lit7, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", Lit7, 1, "trace.scm:13"), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\t\u0003\u0018\u0014", new Object[]{Lit8, Lit0, PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 57371)}, 1)}, 1, Lit2);
        Lit1 = new SyntaxRules(Lit7, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit7, 2, "trace.scm:5"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\t\u0003\b\u000b", new Object[]{Symbol.valueOf("set!"), Symbol.valueOf("invoke-static"), Symbol.valueOf("<kawa.standard.TracedProcedure>"), PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Symbol.valueOf("doTrace"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 32806), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 32806)}, 0)}, 2, Lit0);
        $instance = new trace();
        $Pcdo$Mntrace = Macro.make(Lit0, Lit1, "kawa.lib.trace");
        trace = Macro.make(Lit2, Lit3, "kawa.lib.trace");
        untrace = Macro.make(Lit4, Lit5, "kawa.lib.trace");
        trace trace2 = $instance;
        disassemble = new ModuleMethod(trace2, 1, Lit6, 4097);
        trace.$runBody$();
    }

    public trace() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            Object object3 = Promise.force(object2, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object3) == null) {
                return -786431;
            }
            callContext.value1 = object3;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector != 1) return super.apply1(moduleMethod, object2);
        try {
            return trace.disassemble(LangObjType.coerceToProcedure(Promise.force(object2, Procedure.class)));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "disassemble", 1, object2);
        }
    }
}

