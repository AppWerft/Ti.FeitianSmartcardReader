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
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.kawa.reflect.StaticFieldLocation;
import kawa.lang.Macro;
import gnu.expr.ModuleBody;

public class cut extends ModuleBody
{
    public static final Macro cut;
    public static final Macro cute;
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$apply;
    public static final StaticFieldLocation $Prvt$begin;
    public static final StaticFieldLocation $Prvt$lambda;
    public static final Macro $Prvt$srfi$Mn26$Mninternal$Mncut;
    public static final Macro $Prvt$srfi$Mn26$Mninternal$Mncute;
    public static cut $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit6;
    static final SyntaxRules Lit7;
    static final Object[] Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final PairWithPosition Lit14;
    static final Object[] Lit15;
    static final Object[] Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final Object[] Lit19;
    static final Object[] Lit20;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        (Lit20 = new Object[] { null })[0] = (Lit0 = Symbol.valueOf("srfi-26-internal-cut"));
        (Lit19 = new Object[] { null })[0] = (Lit13 = Symbol.valueOf("<>"));
        Lit18 = Symbol.valueOf("rest-slot");
        Lit17 = Symbol.valueOf("apply");
        (Lit16 = new Object[] { null })[0] = (Lit9 = Symbol.valueOf("<...>"));
        final Object[] lit15 = new Object[2];
        (Lit15 = lit15)[0] = gnu.kawa.slib.cut.Lit13;
        lit15[1] = gnu.kawa.slib.cut.Lit9;
        Lit14 = PairWithPosition.make(Lit12 = Symbol.valueOf("x"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/cut.scm", 364616);
        Lit11 = Symbol.valueOf("lambda");
        Lit10 = Symbol.valueOf("let");
        Lit8 = new Object[0];
        Lit7 = new SyntaxRules(gnu.kawa.slib.cut.Lit8, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", gnu.kawa.slib.cut.Lit8, 1, "cut.scm:111"), "\u0000", "\u0011\u0018\u0004\t\u0010\t\u0010\t\u0010\u0002", new Object[] { Lit2 = Symbol.valueOf("srfi-26-internal-cute") }, 0) }, 1, Lit6 = Symbol.valueOf("cute"));
        Lit5 = new SyntaxRules(gnu.kawa.slib.cut.Lit8, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", gnu.kawa.slib.cut.Lit8, 1, "cut.scm:106"), "\u0000", "\u0011\u0018\u0004\t\u0010\t\u0010\u0002", gnu.kawa.slib.cut.Lit20, 0) }, 1, Lit4 = Symbol.valueOf("cut"));
        Lit3 = new SyntaxRules(gnu.kawa.slib.cut.Lit15, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\f\u000f<\f\u0017\r\u001f\u0018\b\b\b", gnu.kawa.slib.cut.Lit8, 4, "cut.scm:83"), "\u0003\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\b\u0011\u0018\f\u0019\b\u0005\u0003\b\t\u0013\b\u001d\u001b", new Object[] { gnu.kawa.slib.cut.Lit10, gnu.kawa.slib.cut.Lit11 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\f\u000f<\f\u0017\r\u001f\u0018\b\b\f\u0002\b", gnu.kawa.slib.cut.Lit16, 4, "cut.scm:87"), "\u0003\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\b\u0011\u0018\f)\u0011\u0005\u0003\u0018\u0014\b\u0011\u0018\u001c\t\u0013\u0011\u001d\u001b\u0018$", new Object[] { gnu.kawa.slib.cut.Lit10, gnu.kawa.slib.cut.Lit11, gnu.kawa.slib.cut.Lit12, gnu.kawa.slib.cut.Lit17, gnu.kawa.slib.cut.Lit14 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\f\u000f,\r\u0017\u0010\b\b\f\u0002\u001b", gnu.kawa.slib.cut.Lit19, 4, "cut.scm:92"), "\u0003\u0001\u0003\u0000", "\u0011\u0018\u0004)\u0011\u0005\u0003\u0018\f\t\u000b)\u0011\u0015\u0013\u0018\u0014\u001a", new Object[] { gnu.kawa.slib.cut.Lit2, gnu.kawa.slib.cut.Lit14, gnu.kawa.slib.cut.Lit14 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u001f#", gnu.kawa.slib.cut.Lit8, 5, "cut.scm:97"), "\u0001\u0001\u0003\u0001\u0000", "\u0011\u0018\u0004\t\u00039)\u0011\u0018\f\b\u001b\u000b)\u0011\u0015\u0013\u0018\u0014\"", new Object[] { gnu.kawa.slib.cut.Lit2, gnu.kawa.slib.cut.Lit12, gnu.kawa.slib.cut.Lit14 }, 1) }, 5, gnu.kawa.slib.cut.Lit2);
        Lit1 = new SyntaxRules(gnu.kawa.slib.cut.Lit15, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b<\f\u000f\r\u0017\u0010\b\b\b", gnu.kawa.slib.cut.Lit8, 3, "cut.scm:60"), "\u0003\u0001\u0003", "\u0011\u0018\u0004\u0019\b\u0005\u0003\b)\u0011\u0018\f\b\u000b\b\u0015\u0013", new Object[] { gnu.kawa.slib.cut.Lit11, Symbol.valueOf("begin") }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b<\f\u000f\r\u0017\u0010\b\b\f\u0002\b", gnu.kawa.slib.cut.Lit16, 3, "cut.scm:62"), "\u0003\u0001\u0003", "\u0011\u0018\u0004)\u0011\u0005\u0003\u0018\f\b\u0011\u0018\u0014\t\u000b\u0011\u0015\u0013\u0018\u001c", new Object[] { gnu.kawa.slib.cut.Lit11, gnu.kawa.slib.cut.Lit18, gnu.kawa.slib.cut.Lit17, PairWithPosition.make(gnu.kawa.slib.cut.Lit18, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/cut.scm", 258110) }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b,\r\u000f\b\b\b\f\u0002\u0013", gnu.kawa.slib.cut.Lit19, 3, "cut.scm:66"), "\u0003\u0003\u0000", "\u0011\u0018\u0004)\u0011\u0005\u0003\u0018\f)\u0011\r\u000b\u0018\u0014\u0012", new Object[] { gnu.kawa.slib.cut.Lit0, gnu.kawa.slib.cut.Lit14, gnu.kawa.slib.cut.Lit14 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b,\r\u000f\b\b\b\f\u0017\u001b", gnu.kawa.slib.cut.Lit8, 4, "cut.scm:68"), "\u0003\u0003\u0001\u0000", "\u0011\u0018\u0004\u0019\b\u0005\u0003)\u0011\r\u000b\b\u0013\u001a", gnu.kawa.slib.cut.Lit20, 1) }, 4, gnu.kawa.slib.cut.Lit0);
        gnu.kawa.slib.cut.$instance = new cut();
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$apply = StaticFieldLocation.make("kawa.standard.Scheme", "apply");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        $Prvt$srfi$Mn26$Mninternal$Mncut = Macro.make(gnu.kawa.slib.cut.Lit0, gnu.kawa.slib.cut.Lit1, "gnu.kawa.slib.cut");
        $Prvt$srfi$Mn26$Mninternal$Mncute = Macro.make(gnu.kawa.slib.cut.Lit2, gnu.kawa.slib.cut.Lit3, "gnu.kawa.slib.cut");
        cut = Macro.make(gnu.kawa.slib.cut.Lit4, gnu.kawa.slib.cut.Lit5, "gnu.kawa.slib.cut");
        cute = Macro.make(gnu.kawa.slib.cut.Lit6, gnu.kawa.slib.cut.Lit7, "gnu.kawa.slib.cut");
        $runBody$();
    }
    
    public cut() {
        ModuleInfo.register(this);
    }
}
