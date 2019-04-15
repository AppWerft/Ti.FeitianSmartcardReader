/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class parameterize
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$as$Mnlocation$Pc;
    public static final StaticFieldLocation $Prvt$begin;
    public static final StaticFieldLocation $Prvt$quasiquote;
    public static final StaticFieldLocation $Prvt$let$St;
    public static final StaticFieldLocation $Prvt$try$Mnfinally;
    public static final Macro parameterize$Pc;
    public static final Macro parameterize;
    public static parameterize $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final Object[] Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        Lit11 = Symbol.valueOf("save");
        Lit10 = Symbol.valueOf("quasiquote");
        Lit9 = Symbol.valueOf("gnu.mapping.Location");
        Lit8 = Symbol.valueOf("$lookup$");
        Lit7 = Symbol.valueOf("v");
        Lit6 = Symbol.valueOf("p");
        Lit5 = Symbol.valueOf("begin");
        Lit4 = new Object[0];
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[2];
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\u0003", Lit4, 1, "parameterize.scm:22"), "\u0000", "\u0011\u0018\u0004\u0002", new Object[]{Lit5}, 0);
        Object[] arrobject = new Object[1];
        Lit0 = Symbol.valueOf("parameterize%");
        arrobject[0] = Lit0;
        arrsyntaxRule[1] = new SyntaxRule(new SyntaxPattern("\f\u0018<,\f\u0007\f\u000f\b\u0013\u001b", Lit4, 4, "parameterize.scm:24"), "\u0001\u0001\u0000\u0000", "\u0011\u0018\u00041!\t\u0003\b\u000b\u0012\t\u0010\u001a", arrobject, 0);
        Lit2 = Symbol.valueOf("parameterize");
        Lit3 = new SyntaxRules(Lit4, arrsyntaxRule, 4, Lit2);
        Lit1 = new SyntaxRules(Lit4, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\u000b", Lit4, 2, "parameterize.scm:8"), "\u0001\u0000", "\u0011\u0018\u0004!\u0011\u0018\f\n\b\u0011\u0018\f\u0003", new Object[]{Symbol.valueOf("try-finally"), Lit5}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<,\f\u0007\f\u000f\b\u0013\f\u001f#", Lit4, 5, "parameterize.scm:12"), "\u0001\u0001\u0000\u0001\u0000", "\u0011\u0018\u0004\u00c1y\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\b\u0003)\u0011\u0018,\b\u000b\u00184\b\u0011\u0018<\t\u0012!\u0011\u0018D\u001b\"", new Object[]{Symbol.valueOf("let*"), Lit6, Symbol.valueOf("::"), Symbol.valueOf("<gnu.mapping.Location>"), Symbol.valueOf("as-location%"), Lit7, PairWithPosition.make(PairWithPosition.make(Lit11, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit8, Pair.make(Lit9, Pair.make(Pair.make(Lit10, Pair.make(Symbol.valueOf("setWithSave"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61453), PairWithPosition.make(Lit6, PairWithPosition.make(Lit7, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61488), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61486), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61452), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61452), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61446), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61446), Lit0, PairWithPosition.make(PairWithPosition.make(Lit8, Pair.make(Lit9, Pair.make(Pair.make(Lit10, Pair.make(Symbol.valueOf("setRestore"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 69643), PairWithPosition.make(Lit6, PairWithPosition.make(Lit11, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 69677), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 69675), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 69642)}, 0)}, 5, Lit0);
        $instance = new parameterize();
        $Prvt$as$Mnlocation$Pc = StaticFieldLocation.make("kawa.lib.parameters", "as$Mnlocation$Pc");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        $Prvt$quasiquote = StaticFieldLocation.make("kawa.lang.Quote", "quasiQuote");
        $Prvt$let$St = StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
        $Prvt$try$Mnfinally = StaticFieldLocation.make("kawa.lib.syntax", "try$Mnfinally");
        parameterize$Pc = Macro.make(Lit0, Lit1, "kawa.lib.parameterize");
        parameterize = Macro.make(Lit2, Lit3, "kawa.lib.parameterize");
        parameterize.$runBody$();
    }

    public parameterize() {
        ModuleInfo.register(this);
    }
}

