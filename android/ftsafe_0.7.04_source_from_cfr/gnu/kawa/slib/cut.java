/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class cut
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        Object[] arrobject = new Object[1];
        Lit20 = arrobject;
        Lit0 = Symbol.valueOf("srfi-26-internal-cut");
        arrobject[0] = Lit0;
        Object[] arrobject2 = new Object[1];
        Lit19 = arrobject2;
        Lit13 = Symbol.valueOf("<>");
        arrobject2[0] = Lit13;
        Lit18 = Symbol.valueOf("rest-slot");
        Lit17 = Symbol.valueOf("apply");
        Object[] arrobject3 = new Object[1];
        Lit16 = arrobject3;
        Lit9 = Symbol.valueOf("<...>");
        arrobject3[0] = Lit9;
        Object[] arrobject4 = new Object[2];
        Lit15 = arrobject4;
        arrobject4[0] = Lit13;
        arrobject4[1] = Lit9;
        Lit12 = Symbol.valueOf("x");
        Lit14 = PairWithPosition.make(Lit12, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/cut.scm", 364616);
        Lit11 = Symbol.valueOf("lambda");
        Lit10 = Symbol.valueOf("let");
        Lit8 = new Object[0];
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject5 = new Object[1];
        Lit2 = Symbol.valueOf("srfi-26-internal-cute");
        arrobject5[0] = Lit2;
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit8, 1, "cut.scm:111"), "\u0000", "\u0011\u0018\u0004\t\u0010\t\u0010\t\u0010\u0002", arrobject5, 0);
        Lit6 = Symbol.valueOf("cute");
        Lit7 = new SyntaxRules(Lit8, arrsyntaxRule, 1, Lit6);
        Lit4 = Symbol.valueOf("cut");
        Lit5 = new SyntaxRules(Lit8, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit8, 1, "cut.scm:106"), "\u0000", "\u0011\u0018\u0004\t\u0010\t\u0010\u0002", Lit20, 0)}, 1, Lit4);
        Lit3 = new SyntaxRules(Lit15, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\f\u000f<\f\u0017\r\u001f\u0018\b\b\b", Lit8, 4, "cut.scm:83"), "\u0003\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\b\u0011\u0018\f\u0019\b\u0005\u0003\b\t\u0013\b\u001d\u001b", new Object[]{Lit10, Lit11}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\f\u000f<\f\u0017\r\u001f\u0018\b\b\f\u0002\b", Lit16, 4, "cut.scm:87"), "\u0003\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\b\u0011\u0018\f)\u0011\u0005\u0003\u0018\u0014\b\u0011\u0018\u001c\t\u0013\u0011\u001d\u001b\u0018$", new Object[]{Lit10, Lit11, Lit12, Lit17, Lit14}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\f\u000f,\r\u0017\u0010\b\b\f\u0002\u001b", Lit19, 4, "cut.scm:92"), "\u0003\u0001\u0003\u0000", "\u0011\u0018\u0004)\u0011\u0005\u0003\u0018\f\t\u000b)\u0011\u0015\u0013\u0018\u0014\u001a", new Object[]{Lit2, Lit14, Lit14}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u001f#", Lit8, 5, "cut.scm:97"), "\u0001\u0001\u0003\u0001\u0000", "\u0011\u0018\u0004\t\u00039)\u0011\u0018\f\b\u001b\u000b)\u0011\u0015\u0013\u0018\u0014\"", new Object[]{Lit2, Lit12, Lit14}, 1)}, 5, Lit2);
        Lit1 = new SyntaxRules(Lit15, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b<\f\u000f\r\u0017\u0010\b\b\b", Lit8, 3, "cut.scm:60"), "\u0003\u0001\u0003", "\u0011\u0018\u0004\u0019\b\u0005\u0003\b)\u0011\u0018\f\b\u000b\b\u0015\u0013", new Object[]{Lit11, Symbol.valueOf("begin")}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b<\f\u000f\r\u0017\u0010\b\b\f\u0002\b", Lit16, 3, "cut.scm:62"), "\u0003\u0001\u0003", "\u0011\u0018\u0004)\u0011\u0005\u0003\u0018\f\b\u0011\u0018\u0014\t\u000b\u0011\u0015\u0013\u0018\u001c", new Object[]{Lit11, Lit18, Lit17, PairWithPosition.make(Lit18, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/cut.scm", 258110)}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b,\r\u000f\b\b\b\f\u0002\u0013", Lit19, 3, "cut.scm:66"), "\u0003\u0003\u0000", "\u0011\u0018\u0004)\u0011\u0005\u0003\u0018\f)\u0011\r\u000b\u0018\u0014\u0012", new Object[]{Lit0, Lit14, Lit14}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b,\r\u000f\b\b\b\f\u0017\u001b", Lit8, 4, "cut.scm:68"), "\u0003\u0003\u0001\u0000", "\u0011\u0018\u0004\u0019\b\u0005\u0003)\u0011\r\u000b\b\u0013\u001a", Lit20, 1)}, 4, Lit0);
        $instance = new cut();
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$apply = StaticFieldLocation.make("kawa.standard.Scheme", "apply");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        $Prvt$srfi$Mn26$Mninternal$Mncut = Macro.make(Lit0, Lit1, "gnu.kawa.slib.cut");
        $Prvt$srfi$Mn26$Mninternal$Mncute = Macro.make(Lit2, Lit3, "gnu.kawa.slib.cut");
        cut = Macro.make(Lit4, Lit5, "gnu.kawa.slib.cut");
        cute = Macro.make(Lit6, Lit7, "gnu.kawa.slib.cut");
        cut.$runBody$();
    }

    public cut() {
        ModuleInfo.register(this);
    }
}

