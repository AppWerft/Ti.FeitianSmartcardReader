/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
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
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.misc;
import kawa.lib.prim_syntax;
import kawa.lib.std_syntax;
import kawa.lib.strings;
import kawa.standard.syntax_case;

public class enums
extends ModuleBody {
    public static final Macro define$Mnenum;
    public static final Macro $Prvt$$Pcdefine$Mnenum;
    static final PairWithPosition Lit0;
    static final PairWithPosition Lit1;
    static final PairWithPosition Lit2;
    static final PairWithPosition Lit3;
    static final PairWithPosition Lit4;
    public static enums $instance;
    static final SimpleSymbol Lit5;
    static final SyntaxPattern Lit6;
    static final SyntaxTemplate Lit7;
    static final SyntaxTemplate Lit8;
    static final SyntaxPattern Lit9;
    static final SyntaxTemplate Lit10;
    static final SyntaxPattern Lit11;
    static final SyntaxPattern Lit12;
    static final SyntaxPattern Lit13;
    static final SyntaxTemplate Lit14;
    static final SimpleSymbol Lit15;
    static final SyntaxPattern Lit16;
    static final SyntaxTemplate Lit17;
    static final SyntaxTemplate Lit18;
    static final SyntaxTemplate Lit19;
    static final SyntaxTemplate Lit20;
    static final SyntaxTemplate Lit21;
    static final SyntaxTemplate Lit22;
    static final SyntaxTemplate Lit23;
    static final SyntaxTemplate Lit24;
    static final SyntaxTemplate Lit25;
    static final SyntaxTemplate Lit26;
    static final SyntaxTemplate Lit27;
    static final SyntaxTemplate Lit28;
    static final Object[] Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final Object[] Lit35;
    static final Object[] Lit36;
    static final Keyword Lit37;
    static final PairWithPosition Lit38;
    static final PairWithPosition Lit39;
    static final Keyword Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final PairWithPosition Lit44;
    static final PairWithPosition Lit45;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    static Object makeFieldDesc(Symbol t$Mnname, Symbol e$Mnname, int e$Mnval) {
        return Quote.consX$V(new Object[]{e$Mnname, Quote.append$V(new Object[]{Lit0, Quote.consX$V(new Object[]{t$Mnname, Quote.append$V(new Object[]{Lit1, Pair.make(Quote.consX$V(new Object[]{t$Mnname, Quote.consX$V(new Object[]{misc.symbol$To$String(e$Mnname), Quote.consX$V(new Object[]{e$Mnval, LList.Empty})})}), LList.Empty)})})})});
    }

    static PairWithPosition makeInit() {
        return Lit2;
    }

    static Object makeValues(Symbol t$Mnarr, LList e$Mnnames) {
        return Quote.append$V(new Object[]{Lit3, Quote.consX$V(new Object[]{t$Mnarr, Quote.append$V(new Object[]{Lit4, Pair.make(Quote.consX$V(new Object[]{t$Mnarr, Quote.append$V(new Object[]{e$Mnnames, LList.Empty})}), LList.Empty)})})});
    }

    /*
     * Exception decompiling
     */
    static LList mapNames(Symbol t$Mnname, LList e$Mnnames, int i) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static {
        Lit34 = Symbol.valueOf("quote");
        Lit45 = PairWithPosition.make(Lit34, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("enum"), PairWithPosition.make(Symbol.valueOf("final"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253996), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253990), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253990), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253990);
        Lit44 = PairWithPosition.make(Lit34, PairWithPosition.make(Symbol.valueOf("static"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 274451), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 274451);
        Lit43 = Symbol.valueOf("num");
        Lit42 = Symbol.valueOf("str");
        Lit41 = Symbol.valueOf("*init*");
        Lit40 = Keyword.make("access");
        Lit32 = Symbol.valueOf("::");
        Lit39 = PairWithPosition.make(Lit32, PairWithPosition.make(Symbol.valueOf("String"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270354), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270352);
        Lit38 = PairWithPosition.make(Lit44, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 274450);
        Lit37 = Keyword.make("allocation");
        Object[] arrobject = new Object[1];
        Lit36 = arrobject;
        arrobject[0] = "findkeywords";
        Object[] arrobject2 = new Object[2];
        Lit35 = arrobject2;
        Lit5 = Symbol.valueOf("define-enum");
        arrobject2[0] = Lit5;
        arrobject2[1] = "findkeywords";
        Lit33 = Symbol.valueOf("java.lang.Enum");
        Lit31 = Symbol.valueOf("s");
        Lit30 = Symbol.valueOf("valueOf");
        Lit29 = new Object[0];
        Lit28 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0010", Lit29, 0);
        Lit27 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0010", Lit29, 0);
        Lit26 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[]{Pair.make(Lit31, LList.Empty)}, 0);
        Lit25 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[]{Pair.make(PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(Lit33, Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Lit30, LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 278535), LList.Empty)}, 0);
        Lit24 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[]{Pair.make(Lit37, Lit38)}, 0);
        Object[] arrobject3 = new Object[1];
        Lit0 = PairWithPosition.make(Lit32, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270361);
        arrobject3[0] = Pair.make(PairWithPosition.make(Lit30, PairWithPosition.make(Lit31, Lit39, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270351), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 270342), Lit0);
        Lit23 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", arrobject3, 0);
        Lit22 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[]{Pair.make(PairWithPosition.make(Lit33, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253964), PairWithPosition.make(Lit40, PairWithPosition.make(Lit45, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253989), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 253981))}, 0);
        Lit21 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0018\u0004", new Object[]{Pair.make(Symbol.valueOf("define-simple-class"), LList.Empty)}, 0);
        Lit20 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\b\u001d\u001b", Lit29, 1);
        Lit19 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u000b", Lit29, 0);
        Lit18 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\b\u0015\u0013", Lit29, 1);
        Lit17 = new SyntaxTemplate("\u0001\u0001\u0003\u0003", "\u0003", Lit29, 0);
        Lit16 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\r\u001f\u0018\b\b", Lit29, 4, "enums.scm:50");
        Lit15 = Symbol.valueOf("%define-enum");
        Lit14 = new SyntaxTemplate("\u0001\u0003", "\u0011\u0018\u0004\t\f\t\u0003\t\u0010\b\r\u000b", Lit35, 1);
        Lit13 = new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit29, 2, "enums.scm:40");
        Lit12 = new SyntaxPattern("\f\u0018\f\u0007\b", Lit29, 1, "enums.scm:39");
        Lit11 = new SyntaxPattern("\f\u0018\b", Lit29, 0, "enums.scm:38");
        Lit10 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0011\u0018\u0004\t\u0003\u0019\b\r\u000b\b\u0015\u0013", new Object[]{Lit15}, 1);
        Lit9 = new SyntaxPattern("\f\u0018\f\u0002\f\u0007,\r\u000f\b\b\b\r\u0017\u0010\b\b", Lit36, 3, "enums.scm:36");
        Lit8 = new SyntaxTemplate("\u0001\u0003\u0001\u0001\u0003", "\u0011\u0018\u0004\t\f\t\u00039\t\u0013\t\u001b\b\r\u000b\b%#", Lit35, 1);
        Lit7 = new SyntaxTemplate("\u0001\u0003\u0001\u0001\u0003", "\u0013", Lit29, 0);
        Lit6 = new SyntaxPattern("\f\u0018\f\u0002\f\u0007,\r\u000f\b\b\b\f\u0017\f\u001f\r' \b\b", Lit36, 5, "enums.scm:34");
        Lit4 = PairWithPosition.make(Lit37, Lit38, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 110616);
        Lit3 = PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("values"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 110597), Lit0, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 110596);
        Lit2 = PairWithPosition.make(PairWithPosition.make(Lit41, PairWithPosition.make(PairWithPosition.make(Lit42, Lit39, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73741), PairWithPosition.make(PairWithPosition.make(Lit43, PairWithPosition.make(Lit32, PairWithPosition.make(Symbol.valueOf("int"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73765), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73762), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73757), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73757), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73741), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73733), PairWithPosition.make(Lit40, PairWithPosition.make(PairWithPosition.make(Lit34, PairWithPosition.make(Symbol.valueOf("private"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 77838), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 77838), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("invoke-special"), PairWithPosition.make(Lit33, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("this"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81956), PairWithPosition.make(PairWithPosition.make(Lit34, PairWithPosition.make(Lit41, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81964), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81964), PairWithPosition.make(Lit42, PairWithPosition.make(Lit43, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81975), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81971), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81963), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81956), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81941), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81925), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 81925), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 77837), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 77829), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 73732);
        Lit1 = PairWithPosition.make(Lit37, PairWithPosition.make(Lit44, PairWithPosition.make(Lit40, PairWithPosition.make(Lit45, PairWithPosition.make(Keyword.make("init"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 57357), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 53289), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 53281), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 53273), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/enums.scm", 53261);
        enums enums2 = $instance = new enums();
        define$Mnenum = Macro.make(Lit5, new ModuleMethod(enums2, 1, null, 4097), "gnu.kawa.slib.enums");
        enums enums3 = $instance;
        $Prvt$$Pcdefine$Mnenum = Macro.make(Lit15, new ModuleMethod(enums3, 2, null, 4097), "gnu.kawa.slib.enums");
        enums.$runBody$();
    }

    public enums() {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object form) {
        Object object2;
        TemplateScope templateScope;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(5, null);
        if (((Pattern)Lit6).match(form, arrobject, 0) && std_syntax.isIdentifier(Lit7.execute(arrobject, templateScope = TemplateScope.make()))) {
            templateScope = TemplateScope.make();
            object2 = Lit8.execute(arrobject, templateScope);
        } else if (((Pattern)Lit9).match(form, arrobject, 0)) {
            templateScope = TemplateScope.make();
            object2 = Lit10.execute(arrobject, templateScope);
        } else if (((Pattern)Lit11).match(form, arrobject, 0)) {
            object2 = prim_syntax.reportSyntaxError(form, "no enum type name given");
        } else if (((Pattern)Lit12).match(form, arrobject, 0)) {
            object2 = prim_syntax.reportSyntaxError(form, "no enum constants given");
        } else if (((Pattern)Lit13).match(form, arrobject, 0)) {
            templateScope = TemplateScope.make();
            object2 = Lit14.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Object lambda2(Object form) {
        LList values$Mnmethod;
        Object object2;
        LList e$Mnnames;
        Symbol t$Mnname;
        LList other$Mndefs;
        LList opts;
        PairWithPosition init;
        Object object5 = form;
        Object[] arrobject = SyntaxPattern.allocVars(4, null);
        if (!((Pattern)Lit16).match(form, arrobject, 0)) {
            object2 = syntax_case.error("syntax-case", form);
            return object2;
        }
        TemplateScope templateScope = TemplateScope.make();
        Object object6 = Promise.force(Lit17.execute(arrobject, templateScope), Symbol.class);
        try {
            t$Mnname = (Symbol)object6;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "t-name", -2, (Object)e$Mnnames);
        }
        SimpleSymbol t$Mnarr = misc.string$To$Symbol(strings.stringAppend(misc.symbol$To$String(t$Mnname), "[]"));
        TemplateScope templateScope2 = TemplateScope.make();
        Object object7 = Promise.force(Lit18.execute(arrobject, templateScope2), LList.class);
        try {
            e$Mnnames = (LList)object7;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "e-names", -2, (Object)init);
        }
        e$Mnnames.size();
        LList field$Mndescs = enums.mapNames(t$Mnname, e$Mnnames, 0);
        init = enums.makeInit();
        Object object8 = Promise.force(enums.makeValues(t$Mnarr, e$Mnnames), LList.class);
        try {
            values$Mnmethod = (LList)object8;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "values-method", -2, (Object)opts);
        }
        TemplateScope templateScope3 = TemplateScope.make();
        Object object3 = Promise.force(Lit19.execute(arrobject, templateScope3), LList.class);
        try {
            opts = (LList)object3;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "opts", -2, object3);
        }
        object3 = TemplateScope.make();
        Object object22 = Promise.force(Lit20.execute(arrobject, (TemplateScope)object3), LList.class);
        try {
            other$Mndefs = (LList)object22;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "other-defs", -2, object22);
        }
        object3 = TemplateScope.make();
        object2 = Quote.append$V(new Object[]{Lit21.execute(arrobject, (TemplateScope)object3), Quote.consX$V(new Object[]{std_syntax.datum$To$SyntaxObject(form, t$Mnname), Quote.append$V(new Object[]{Lit22.execute(arrobject, (TemplateScope)object3), Quote.append$V(new Object[]{std_syntax.datum$To$SyntaxObject(form, opts), Quote.consX$V(new Object[]{std_syntax.datum$To$SyntaxObject(form, init), Quote.consX$V(new Object[]{std_syntax.datum$To$SyntaxObject(form, values$Mnmethod), Pair.make(Quote.append$V(new Object[]{Lit23.execute(arrobject, (TemplateScope)object3), Quote.consX$V(new Object[]{std_syntax.datum$To$SyntaxObject(form, t$Mnname), Quote.append$V(new Object[]{Lit24.execute(arrobject, (TemplateScope)object3), Pair.make(Quote.append$V(new Object[]{Lit25.execute(arrobject, (TemplateScope)object3), Quote.consX$V(new Object[]{std_syntax.datum$To$SyntaxObject(form, t$Mnname), Lit26.execute(arrobject, (TemplateScope)object3)})}), Lit27.execute(arrobject, (TemplateScope)object3))})})}), Quote.append$V(new Object[]{std_syntax.datum$To$SyntaxObject(form, field$Mndescs), Quote.append$V(new Object[]{std_syntax.datum$To$SyntaxObject(form, other$Mndefs), Lit28.execute(arrobject, (TemplateScope)object3)})}))})})})})})});
        return object2;
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
                return enums.lambda1(object2);
            }
            case 2: {
                return enums.lambda2(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }
}

