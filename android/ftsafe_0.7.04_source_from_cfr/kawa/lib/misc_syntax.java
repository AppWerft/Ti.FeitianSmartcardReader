/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.Compilation;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.GetModuleClass;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.misc;
import kawa.lib.prim_syntax;
import kawa.lib.std_syntax;
import kawa.lib.strings;
import kawa.standard.syntax_case;

public class misc_syntax
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$define$Mnconstant;
    public static final Macro provide;
    public static final Macro test$Mnbegin;
    public static final Macro module$Mnuri;
    public static final Macro resource$Mnurl;
    public static misc_syntax $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxPattern Lit1;
    static final SyntaxTemplate Lit2;
    static final SyntaxTemplate Lit3;
    static final SyntaxTemplate Lit4;
    static final SyntaxPattern Lit5;
    static final SimpleSymbol Lit6;
    static final SyntaxRules Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxPattern Lit9;
    static final SimpleSymbol Lit10;
    static final SyntaxRules Lit11;
    static final Object[] Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final PairWithPosition Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        Lit20 = Symbol.valueOf("%test-begin");
        Lit19 = Symbol.valueOf("srfi-64");
        Lit18 = Symbol.valueOf("else");
        Lit17 = PairWithPosition.make(Lit19, PairWithPosition.make(Values.empty, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90142), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90133);
        Lit16 = Symbol.valueOf("cond-expand");
        Lit15 = Symbol.valueOf("begin");
        Lit14 = Symbol.valueOf("quasiquote");
        Lit13 = Symbol.valueOf("$lookup$");
        Lit12 = new Object[0];
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject = new Object[6];
        arrobject[0] = PairWithPosition.make(Lit13, Pair.make(Symbol.valueOf("gnu.kawa.io.URLPath"), Pair.make(Pair.make(Lit14, Pair.make(Symbol.valueOf("valueOf"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 163847);
        arrobject[1] = Lit13;
        Lit8 = Symbol.valueOf("module-uri");
        arrobject[2] = PairWithPosition.make(Lit13, Pair.make(PairWithPosition.make(Lit8, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 167947), Pair.make(Pair.make(Lit14, Pair.make(Symbol.valueOf("resolve"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 167947);
        arrobject[3] = Pair.make(Pair.make(Lit14, Pair.make(Symbol.valueOf("toURL"), LList.Empty)), LList.Empty);
        arrobject[4] = Pair.make(Pair.make(Lit14, Pair.make(Symbol.valueOf("openConnection"), LList.Empty)), LList.Empty);
        arrobject[5] = Pair.make(Pair.make(Lit14, Pair.make(Symbol.valueOf("getURL"), LList.Empty)), LList.Empty);
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit12, 1, "misc_syntax.scm:39"), "\u0001", "\u0011\u0018\u0004\b\b\u0011\u0018\f\u0099\b\u0011\u0018\fa\b\u0011\u0018\f)\u0011\u0018\u0014\b\u0003\u0018\u001c\u0018$\u0018,", arrobject, 0);
        Lit10 = Symbol.valueOf("resource-url");
        Lit11 = new SyntaxRules(Lit12, arrsyntaxRule, 1, Lit10);
        Lit9 = new SyntaxPattern("\f\u0018\b", Lit12, 0, "misc_syntax.scm:33");
        SyntaxRule[] arrsyntaxRule2 = new SyntaxRule[2];
        Object[] arrobject2 = new Object[4];
        arrobject2[0] = Lit15;
        Lit6 = Symbol.valueOf("test-begin");
        arrobject2[1] = PairWithPosition.make(Lit16, PairWithPosition.make(Lit17, PairWithPosition.make(PairWithPosition.make(Lit18, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("import"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("except"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("srfi"), PairWithPosition.make(IntNum.valueOf(64), PairWithPosition.make(Symbol.valueOf("testing"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94251), PairWithPosition.make(Lit6, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94269), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94251), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94243), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94243), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94235), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94235), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94229), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94229), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90133), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90120);
        arrobject2[2] = Lit20;
        arrobject2[3] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 98336);
        arrsyntaxRule2[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit12, 1, "misc_syntax.scm:20"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\t\u0003\u0018\u001c", arrobject2, 0);
        arrsyntaxRule2[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit12, 2, "misc_syntax.scm:25"), "\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\t\u0003\b\u000b", new Object[]{Lit15, PairWithPosition.make(Lit16, PairWithPosition.make(Lit17, PairWithPosition.make(PairWithPosition.make(Lit18, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("require"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Lit19, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110646), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110646), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110645), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110636), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110636), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110630), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110630), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110613), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110600), Lit20}, 0);
        Lit7 = new SyntaxRules(Lit12, arrsyntaxRule2, 2, Lit6);
        Lit5 = new SyntaxPattern("\f\u0018\u0003", Lit12, 1, "misc_syntax.scm:15");
        Lit4 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0018\u0004", new Object[]{Pair.make(Symbol.valueOf("::"), PairWithPosition.make(Symbol.valueOf("int"), PairWithPosition.make(IntNum.valueOf(123), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 57360), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 57356))}, 0);
        Lit3 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0013", Lit12, 0);
        Lit2 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0018\u0004", new Object[]{Pair.make(Symbol.valueOf("define-constant"), LList.Empty)}, 0);
        Lit1 = new SyntaxPattern("\f\u0007,\f\u000f\f\u0017\b\b", Lit12, 3, "misc_syntax.scm:5");
        Lit0 = Symbol.valueOf("provide");
        $instance = new misc_syntax();
        $Prvt$define$Mnconstant = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");
        misc_syntax misc_syntax2 = $instance;
        provide = Macro.make(Lit0, new ModuleMethod(misc_syntax2, 1, null, 4097), "kawa.lib.misc_syntax");
        test$Mnbegin = Macro.make(Lit6, Lit7, "kawa.lib.misc_syntax");
        misc_syntax misc_syntax3 = $instance;
        ModuleMethod moduleMethod = new ModuleMethod(misc_syntax3, 2, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm:31");
        module$Mnuri = Macro.make(Lit8, moduleMethod, "kawa.lib.misc_syntax");
        resource$Mnurl = Macro.make(Lit10, Lit11, "kawa.lib.misc_syntax");
        misc_syntax.$runBody$();
    }

    public misc_syntax() {
        ModuleInfo.register(this);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object lambda1(Object form) {
        Object object2;
        Object object3;
        Object object4 = form;
        Object[] arrobject = SyntaxPattern.allocVars(3, null);
        if (((Pattern)Lit1).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object[] arrobject2 = new Object[2];
            arrobject2[0] = Lit2.execute(arrobject, templateScope);
            Object[] arrobject3 = new Object[2];
            Object[] arrobject4 = new Object[2];
            arrobject4[0] = "%provide%";
            object3 = Promise.force(std_syntax.syntaxObject$To$Datum(Lit3.execute(arrobject, templateScope)), Symbol.class);
            arrobject4[1] = misc.symbol$To$String((Symbol)object3);
            arrobject3[0] = std_syntax.datum$To$SyntaxObject(form, misc.string$To$Symbol(strings.stringAppend(arrobject4)));
            arrobject3[1] = Lit4.execute(arrobject, templateScope);
            arrobject2[1] = Quote.consX$V(arrobject3);
            object2 = Quote.append$V(arrobject2);
            return object2;
        }
        if (((Pattern)Lit5).match(form, arrobject, 0)) {
            object2 = prim_syntax.reportSyntaxError(form, "provide requires a quoted feature-name");
            return object2;
        }
        object2 = syntax_case.error("syntax-case", form);
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "symbol->string", 1, object3);
        }
    }

    static Object lambda2(Object form) {
        Object object2 = form;
        Object[] arrobject = SyntaxPattern.allocVars(0, null);
        return ((Pattern)Lit9).match(form, arrobject, 0) ? GetModuleClass.getModuleClassURI(Compilation.getCurrent()) : syntax_case.error("syntax-case", form);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 2: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                return misc_syntax.lambda1(object2);
            }
            case 2: {
                return misc_syntax.lambda2(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }
}

