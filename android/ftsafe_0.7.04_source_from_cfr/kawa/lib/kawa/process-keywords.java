/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.kawa;

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
import gnu.math.IntNum;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class process-keywords
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$if;
    public static final Macro process$Mnkeywords;
    public static process-keywords $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final Object[] Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final PairWithPosition Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final PairWithPosition Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final PairWithPosition Lit20;
    static final PairWithPosition Lit21;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        Lit9 = Symbol.valueOf("loop");
        Lit10 = Symbol.valueOf("+");
        Lit5 = Symbol.valueOf("i");
        Lit20 = PairWithPosition.make(PairWithPosition.make(Lit10, PairWithPosition.make(Lit5, PairWithPosition.make(IntNum.valueOf(1), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 61491), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 61489), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 61486), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 61486);
        Lit21 = PairWithPosition.make(PairWithPosition.make(Lit9, Lit20, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 90119), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 90119);
        Lit19 = Symbol.valueOf("value");
        Lit18 = Symbol.valueOf("name");
        Lit17 = Symbol.valueOf("invoke");
        Lit16 = Symbol.valueOf("getName");
        Lit15 = Symbol.valueOf("quote");
        Lit14 = Symbol.valueOf("attr");
        Lit7 = Symbol.valueOf("arg");
        Lit13 = PairWithPosition.make(Lit7, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 57379);
        Lit12 = Symbol.valueOf("<gnu.kawa.xml.KAttr>");
        Lit11 = Symbol.valueOf("instance?");
        Lit8 = PairWithPosition.make(Symbol.valueOf("primitive-array-get"), PairWithPosition.make(Symbol.valueOf("<object>"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 45094), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 45073);
        Lit6 = Symbol.valueOf("num-args");
        Lit4 = Symbol.valueOf("<int>");
        Lit3 = Symbol.valueOf("::");
        Lit2 = new Object[0];
        Lit0 = Symbol.valueOf("process-keywords");
        Lit1 = new SyntaxRules(Lit2, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f\b", Lit2, 4, "process-keywords.scm:7"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\u0091\b\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\t\u000b\u0018,\b\u0011\u0018\u0004\u0011\u00184\u0011\u0018<\b\u0011\u0018D\u0011\u0018L\b\u0011\u0018\u0004a\b\u0011\u0018T\b\u0011\u0018\\\t\u000b\u0018d\b\u0011\u0018l\u00a9\u0011\u0018ty\t\u0013\t\u0003\u0011\u0018|\b\u0011\u0018\u0084\t\u000b\u0018\u008c\u0018\u0094\u0099\u0011\u0018\u009ci\u0011\u0018\u00a4\u0011\u0018\u00ac\b\t\u0013\t\u0003\u0018\u00b4\u0018\u00bc\b\u0011\u0018\u00c41\t\u001b\t\u0003\u0018\u00cc\u0018\u00d4", new Object[]{Symbol.valueOf("let"), Lit6, Lit3, Lit4, Symbol.valueOf("field"), PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Symbol.valueOf("length"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 32810), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 32810), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 32809), Lit9, PairWithPosition.make(PairWithPosition.make(Lit5, PairWithPosition.make(Lit3, PairWithPosition.make(Lit4, PairWithPosition.make(IntNum.valueOf(0), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 36893), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 36887), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 36884), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 36881), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 36880), Symbol.valueOf("if"), PairWithPosition.make(Symbol.valueOf("<"), PairWithPosition.make(Lit5, PairWithPosition.make(Lit6, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 40977), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 40975), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 40972), Lit7, Lit8, PairWithPosition.make(Lit5, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 45109), Symbol.valueOf("cond"), PairWithPosition.make(Lit11, PairWithPosition.make(Lit7, PairWithPosition.make(Symbol.valueOf("<gnu.expr.Keyword>"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 49181), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 49177), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 49166), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(Symbol.valueOf("gnu.expr.Keyword"), Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Lit16, LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 57354), Lit13, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 57353), Lit8, Lit20, PairWithPosition.make(PairWithPosition.make(Lit9, PairWithPosition.make(PairWithPosition.make(Lit10, PairWithPosition.make(Lit5, PairWithPosition.make(IntNum.valueOf(2), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 65554), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 65552), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 65549), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 65549), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 65543), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 65543), PairWithPosition.make(Lit11, PairWithPosition.make(Lit7, PairWithPosition.make(Lit12, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 69654), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 69650), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 69639), Symbol.valueOf("let*"), PairWithPosition.make(PairWithPosition.make(Lit14, PairWithPosition.make(Lit3, PairWithPosition.make(Lit12, Lit13, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 73751), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 73748), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 73742), PairWithPosition.make(PairWithPosition.make(Lit18, PairWithPosition.make(Lit3, PairWithPosition.make(Symbol.valueOf("<java.lang.String>"), PairWithPosition.make(PairWithPosition.make(Lit17, PairWithPosition.make(Lit14, PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit16, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77873), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77873), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77872), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77867), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77859), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77859), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77840), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77837), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77831), PairWithPosition.make(PairWithPosition.make(Lit19, PairWithPosition.make(PairWithPosition.make(Lit17, PairWithPosition.make(Lit14, PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Symbol.valueOf("getObjectValue"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 81948), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 81948), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 81947), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 81942), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 81934), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 81934), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 81927), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 81927), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 77831), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 73741), PairWithPosition.make(Lit18, PairWithPosition.make(Lit19, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 86050), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/process-keywords.scm", 86045), Lit21, Symbol.valueOf("else"), Lit13, Lit21}, 0)}, 4, Lit0);
        $instance = new process-keywords();
        $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
        process$Mnkeywords = Macro.make(Lit0, Lit1, "kawa.lib.kawa.process-keywords");
        process-keywords.$runBody$();
    }

    public process-keywords() {
        ModuleInfo.register(this);
    }
}

