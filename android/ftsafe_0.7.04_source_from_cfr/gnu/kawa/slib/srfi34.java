/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.slib.raise-object-exception;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.standard.Scheme;

public class srfi34
extends ModuleBody {
    public static final ModuleMethod with$Mnexception$Mnhandler;
    public static final Macro guard;
    public static final ModuleMethod raise;
    public static final int $Pcprovide$Pcsrfi$Mn34 = 123;
    public static final Class $Prvt$$Lsraise$Mnobject$Mnexception$Gr;
    public static final Macro $Prvt$guard$Mnaux;
    public static srfi34 $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final Object[] Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final PairWithPosition Lit12;
    static final Object[] Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final PairWithPosition Lit17;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Object withExceptionHandler(Object handler, Object thunk) {
        Object object2;
        try {
            object2 = ((Procedure)Scheme.applyToArgs).apply1(thunk);
        }
        catch (raise-object-exception ex) {
            object2 = ((Procedure)Scheme.applyToArgs).apply2(handler, ex.value);
        }
        catch (Throwable ex) {
            object2 = ((Procedure)Scheme.applyToArgs).apply2(handler, ex);
        }
        return object2;
    }

    public static Type.NeverReturns raise(Object obj) {
        throw new raise-object-exception(obj);
    }

    public static {
        Lit15 = Symbol.valueOf("ex");
        Lit17 = PairWithPosition.make(Lit15, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114732);
        Lit16 = Symbol.valueOf("<raise-object-exception>");
        Lit14 = Symbol.valueOf("begin");
        Lit13 = new Object[0];
        Lit8 = Symbol.valueOf("temp");
        Lit12 = PairWithPosition.make(Lit8, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 274452);
        Lit11 = Symbol.valueOf("if");
        Lit10 = Symbol.valueOf("let");
        Object[] arrobject = new Object[1];
        Lit9 = arrobject;
        Lit7 = Symbol.valueOf("=>");
        arrobject[0] = Lit7;
        Lit6 = Symbol.valueOf("else");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[7];
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u0002\f\u000f\r\u0017\u0010\b\b\b", new Object[]{Lit6}, 3, "srfi34.scm:62"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\b\u0015\u0013", new Object[]{Lit14}, 1);
        arrsyntaxRule[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\b", Lit9, 3, "srfi34.scm:64"), "\u0001\u0001\u0001", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0003", new Object[]{Lit10, Lit8, Lit11, Lit12}, 0);
        Object[] arrobject2 = new Object[5];
        arrobject2[0] = Lit10;
        arrobject2[1] = Lit8;
        arrobject2[2] = Lit11;
        arrobject2[3] = Lit12;
        Lit4 = Symbol.valueOf("guard-aux");
        arrobject2[4] = Lit4;
        arrsyntaxRule[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\f\u001f\r' \b\b", Lit9, 5, "srfi34.scm:69"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0011\u0018$\t\u0003\t\u001b\b%#", arrobject2, 1);
        arrsyntaxRule[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\b", Lit13, 2, "srfi34.scm:74"), "\u0001\u0001", "\u000b", Lit13, 0);
        arrsyntaxRule[4] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\f\u0017\r\u001f\u0018\b\b", Lit13, 4, "srfi34.scm:76"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f\u0011\u0018\f\b\u0011\u0018\u001c\t\u0003\t\u0013\b\u001d\u001b", new Object[]{Lit10, Lit8, Lit11, Lit4}, 1);
        arrsyntaxRule[5] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\b", Lit13, 4, "srfi34.scm:81"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0003", new Object[]{Lit11, Lit14}, 1);
        arrsyntaxRule[6] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\f'\r/(\b\b", Lit13, 6, "srfi34.scm:85"), "\u0001\u0001\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0011\u0018\u0014\t\u0003\t#\b-+", new Object[]{Lit11, Lit14, Lit4}, 1);
        Lit5 = new SyntaxRules(new Object[]{Lit6, Lit7}, arrsyntaxRule, 6, Lit4);
        Lit2 = Symbol.valueOf("guard");
        Lit3 = new SyntaxRules(Lit13, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", Lit13, 3, "srfi34.scm:22"), "\u0001\u0000\u0000", "\u0011\u0018\u0004!\u0011\u0018\f\u0012\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$)\b\t\u0003\u0018,\b\u0011\u00184\u0011\u0018<\n", new Object[]{Symbol.valueOf("try-catch"), Lit14, Lit15, Symbol.valueOf("<java.lang.Throwable>"), Lit10, PairWithPosition.make(PairWithPosition.make(Lit11, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("instance?"), PairWithPosition.make(Lit15, PairWithPosition.make(Lit16, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110614), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110611), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110600), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("field"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("as"), PairWithPosition.make(Lit16, Lit17, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114707), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114703), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Symbol.valueOf("value"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114737), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114737), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114736), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114703), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114696), Lit17, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114696), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110600), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110596), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110596), Lit4, PairWithPosition.make(Symbol.valueOf("primitive-throw"), Lit17, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 122897)}, 0)}, 3, Lit2);
        Lit1 = Symbol.valueOf("raise");
        Lit0 = Symbol.valueOf("with-exception-handler");
        $instance = new srfi34();
        $Prvt$$Lsraise$Mnobject$Mnexception$Gr = raise-object-exception.class;
        srfi34 srfi342 = $instance;
        with$Mnexception$Mnhandler = new ModuleMethod(srfi342, 1, Lit0, 8194);
        raise = new ModuleMethod(srfi342, 2, Lit1, 4097);
        guard = Macro.make(Lit2, Lit3, "gnu.kawa.slib.srfi34");
        $Prvt$guard$Mnaux = Macro.make(Lit4, Lit5, "gnu.kawa.slib.srfi34");
        srfi34.$runBody$();
    }

    public srfi34() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 2) {
            callContext.value1 = object2;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.value1 = object2;
            callContext.value2 = object3;
            callContext.proc = moduleMethod;
            callContext.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector == 2) {
            return srfi34.raise(object2);
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        if (moduleMethod.selector == 1) {
            return srfi34.withExceptionHandler(object2, object3);
        }
        return super.apply2(moduleMethod, object2, object3);
    }
}

