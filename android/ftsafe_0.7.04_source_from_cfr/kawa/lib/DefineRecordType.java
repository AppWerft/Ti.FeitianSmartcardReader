/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.Keyword;
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

public class DefineRecordType
extends ModuleBody {
    public static final Macro define$Mnrecord$Mntype;
    public static final StaticFieldLocation $Prvt$define;
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$begin;
    public static final StaticFieldLocation $Prvt$define$Mnclass;
    public static final StaticFieldLocation $Prvt$instance$Qu;
    public static final StaticFieldLocation $Prvt$slot$Mnref;
    public static final StaticFieldLocation $Prvt$slot$Mnset$Ex;
    public static final StaticFieldLocation $Prvt$make;
    public static final StaticFieldLocation $Prvt$quote;
    public static final Macro $Prvt$$Pcdefine$Mnrecord$Mnfield;
    public static DefineRecordType $instance;
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
    static final PairWithPosition Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        Lit13 = Symbol.valueOf("tmp");
        Lit12 = Symbol.valueOf("slot-set!");
        Lit11 = Symbol.valueOf("begin");
        Lit10 = PairWithPosition.make(Symbol.valueOf("value"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/DefineRecordType.scm", 253992);
        Lit9 = Symbol.valueOf("quote");
        Lit8 = Symbol.valueOf("slot-ref");
        Lit7 = Symbol.valueOf("::");
        Lit6 = Symbol.valueOf("obj");
        Lit5 = Symbol.valueOf("define");
        Lit4 = new Object[0];
        Lit2 = Symbol.valueOf("%define-record-field");
        Lit3 = new SyntaxRules(Lit4, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit4, 3, "DefineRecordType.scm:55"), "\u0001\u0001\u0001", "\u0011\u0018\u0004Y\t\u0013\b\u0011\u0018\f\u0011\u0018\u0014\b\u0003\b\u0011\u0018\u001c\u0011\u0018\f\b\u0011\u0018$\b\u000b", new Object[]{Lit5, Lit6, Lit7, Lit8, Lit9}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f\b", Lit4, 4, "DefineRecordType.scm:58"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\u00e1\u0011\u0018\fY\t\u0013\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0003\b\u0011\u0018$\u0011\u0018\u0014\b\u0011\u0018,\b\u000b\b\u0011\u0018\fi\t\u001bA\u0011\u0018\u0014\u0011\u0018\u001c\b\u0003\u00184\u0011\u0018\u001c\u0011\u0018<\b\u0011\u0018D\u0011\u0018\u0014)\u0011\u0018,\b\u000b\u0018L", new Object[]{Lit11, Lit5, Lit6, Lit7, Lit8, Lit9, Lit10, Symbol.valueOf("<void>"), Lit12, Lit10}, 0)}, 4, Lit2);
        Lit0 = Symbol.valueOf("define-record-type");
        Lit1 = new SyntaxRules(Lit4, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\r\u0017\u0010\b\b\f\u001f-\f'\f/3 \u0018\b", Lit4, 7, "DefineRecordType.scm:34"), "\u0001\u0001\u0003\u0001\u0003\u0003\u0002", "\u0011\u0018\u0004\u0081\u0011\u0018\f\t\u0003\t\u0010\u0011\u0018\u0014\t\u001c\b%\b#\u00b9\u0011\u0018$!\t\u001b\u0018,\u0011\u00184\u0011\u0018<\b\u0011\u0018D\u0011\u0018L\b\u0003\u01c1\u0011\u0018$)\t\u000b\b\u0015\u0013\u0011\u00184\t\u0003\b\u0011\u0018Ty\b\u0011\u0018\\\u0011\u00184\t\u0003\b\u0011\u0018d\b\u0003\u0099\u0011\u0018\u0004\b\u0015\u0011\u0018l\u0011\u0018\\)\u0011\u0018t\b\u0013\b\u0013\u0018|\b%\u0011\u0018\u0084\t\u0003\t#\t+2", new Object[]{Lit11, Symbol.valueOf("define-class"), Keyword.make("interface"), Boolean.FALSE, Lit5, PairWithPosition.make(Lit6, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/DefineRecordType.scm", 167963), Lit7, Symbol.valueOf("<boolean>"), Symbol.valueOf("instance?"), Lit6, Symbol.valueOf("let"), Lit13, Symbol.valueOf("make"), Lit12, Lit9, PairWithPosition.make(Lit13, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/DefineRecordType.scm", 188421), Lit2}, 1)}, 7, Lit0);
        $instance = new DefineRecordType();
        $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        $Prvt$define$Mnclass = StaticFieldLocation.make("kawa.standard.define_class", "define_class");
        $Prvt$instance$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "instanceOf");
        $Prvt$slot$Mnref = StaticFieldLocation.make("gnu.kawa.reflect.SlotGet", "slotRef");
        $Prvt$slot$Mnset$Ex = StaticFieldLocation.make("gnu.kawa.reflect.SlotSet", "set$Mnfield$Ex");
        $Prvt$make = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "make");
        $Prvt$quote = StaticFieldLocation.make("kawa.lang.Quote", "plainQuote");
        define$Mnrecord$Mntype = Macro.make(Lit0, Lit1, "kawa.lib.DefineRecordType");
        $Prvt$$Pcdefine$Mnrecord$Mnfield = Macro.make(Lit2, Lit3, "kawa.lib.DefineRecordType");
        DefineRecordType.$runBody$();
    }

    public DefineRecordType() {
        ModuleInfo.register(this);
    }
}

