// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import gnu.bytecode.Type;
import kawa.standard.Scheme;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class srfi34 extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object withExceptionHandler(final Object handler, final Object thunk) {
        Object o;
        try {
            o = Scheme.applyToArgs.apply1(thunk);
        }
        catch (raise-object-exception raise-object-exception) {
            o = Scheme.applyToArgs.apply2(handler, raise-object-exception.value);
        }
        catch (Throwable ex) {
            o = Scheme.applyToArgs.apply2(handler, ex);
        }
        return o;
    }
    
    public static Type.NeverReturns raise(final Object obj) {
        throw new raise-object-exception(obj);
    }
    
    static {
        Lit17 = PairWithPosition.make(Lit15 = Symbol.valueOf("ex"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114732);
        Lit16 = Symbol.valueOf("<raise-object-exception>");
        Lit14 = Symbol.valueOf("begin");
        Lit13 = new Object[0];
        Lit12 = PairWithPosition.make(Lit8 = Symbol.valueOf("temp"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 274452);
        Lit11 = Symbol.valueOf("if");
        Lit10 = Symbol.valueOf("let");
        (Lit9 = new Object[] { null })[0] = (Lit7 = Symbol.valueOf("=>"));
        Lit6 = Symbol.valueOf("else");
        Lit5 = new SyntaxRules(new Object[] { srfi34.Lit6, srfi34.Lit7 }, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u0002\f\u000f\r\u0017\u0010\b\b\b", new Object[] { srfi34.Lit6 }, 3, "srfi34.scm:62"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\b\u0015\u0013", new Object[] { srfi34.Lit14 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\b", srfi34.Lit9, 3, "srfi34.scm:64"), "\u0001\u0001\u0001", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0003", new Object[] { srfi34.Lit10, srfi34.Lit8, srfi34.Lit11, srfi34.Lit12 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\f\u001f\r' \b\b", srfi34.Lit9, 5, "srfi34.scm:69"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0011\u0018$\t\u0003\t\u001b\b%#", new Object[] { srfi34.Lit10, srfi34.Lit8, srfi34.Lit11, srfi34.Lit12, Lit4 = Symbol.valueOf("guard-aux") }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\b", srfi34.Lit13, 2, "srfi34.scm:74"), "\u0001\u0001", "\u000b", srfi34.Lit13, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\f\u0017\r\u001f\u0018\b\b", srfi34.Lit13, 4, "srfi34.scm:76"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f\u0011\u0018\f\b\u0011\u0018\u001c\t\u0003\t\u0013\b\u001d\u001b", new Object[] { srfi34.Lit10, srfi34.Lit8, srfi34.Lit11, srfi34.Lit4 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\b", srfi34.Lit13, 4, "srfi34.scm:81"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0003", new Object[] { srfi34.Lit11, srfi34.Lit14 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\f'\r/(\b\b", srfi34.Lit13, 6, "srfi34.scm:85"), "\u0001\u0001\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0011\u0018\u0014\t\u0003\t#\b-+", new Object[] { srfi34.Lit11, srfi34.Lit14, srfi34.Lit4 }, 1) }, 6, srfi34.Lit4);
        Lit3 = new SyntaxRules(srfi34.Lit13, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", srfi34.Lit13, 3, "srfi34.scm:22"), "\u0001\u0000\u0000", "\u0011\u0018\u0004!\u0011\u0018\f\u0012\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$)\b\t\u0003\u0018,\b\u0011\u00184\u0011\u0018<\n", new Object[] { Symbol.valueOf("try-catch"), srfi34.Lit14, srfi34.Lit15, Symbol.valueOf("<java.lang.Throwable>"), srfi34.Lit10, PairWithPosition.make(PairWithPosition.make(srfi34.Lit11, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("instance?"), PairWithPosition.make(srfi34.Lit15, PairWithPosition.make(srfi34.Lit16, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110614), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110611), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110600), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("field"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("as"), PairWithPosition.make(srfi34.Lit16, srfi34.Lit17, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114707), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114703), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Symbol.valueOf("value"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114737), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114737), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114736), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114703), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114696), srfi34.Lit17, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 114696), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110600), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110596), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 110596), srfi34.Lit4, PairWithPosition.make(Symbol.valueOf("primitive-throw"), srfi34.Lit17, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi34.scm", 122897) }, 0) }, 3, Lit2 = Symbol.valueOf("guard"));
        Lit1 = Symbol.valueOf("raise");
        Lit0 = Symbol.valueOf("with-exception-handler");
        srfi34.$instance = new srfi34();
        $Prvt$$Lsraise$Mnobject$Mnexception$Gr = raise-object-exception.class;
        final srfi34 $instance = srfi34.$instance;
        with$Mnexception$Mnhandler = new ModuleMethod($instance, 1, srfi34.Lit0, 8194);
        raise = new ModuleMethod($instance, 2, srfi34.Lit1, 4097);
        guard = Macro.make(srfi34.Lit2, srfi34.Lit3, "gnu.kawa.slib.srfi34");
        $Prvt$guard$Mnaux = Macro.make(srfi34.Lit4, srfi34.Lit5, "gnu.kawa.slib.srfi34");
        $runBody$();
    }
    
    public srfi34() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector == 2) {
            ctx.value1 = o;
            ctx.proc = moduleMethod;
            ctx.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, o, ctx);
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.value1 = o;
            ctx.value2 = o2;
            ctx.proc = moduleMethod;
            ctx.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, o, o2, ctx);
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        if (method.selector == 2) {
            return raise(o);
        }
        return super.apply1(method, o);
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
        if (method.selector == 1) {
            return withExceptionHandler(o, o2);
        }
        return super.apply2(method, o, o2);
    }
}
