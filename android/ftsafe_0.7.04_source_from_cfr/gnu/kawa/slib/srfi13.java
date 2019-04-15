/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.slib.srfi13;
import gnu.kawa.slib.srfi14;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.FVector;
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
import gnu.text.Char;
import kawa.SourceMethodType;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.characters;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.rnrs.unicode;
import kawa.lib.std_syntax;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.syntax_case;

public class srfi13
extends ModuleBody {
    public static final Macro $Cloptional;
    public static final Macro let$Mnoptionals$St;
    static final ModuleMethod char$Mncased$Qu;
    public static final Macro let$Mnstring$Mnstart$Plend;
    public static final Macro let$Mnstring$Mnstart$Plend2;
    public static final ModuleMethod string$Mnparse$Mnstart$Plend;
    public static final ModuleMethod $Pccheck$Mnbounds;
    public static final ModuleMethod string$Mnparse$Mnfinal$Mnstart$Plend;
    public static final ModuleMethod substring$Mnspec$Mnok$Qu;
    public static final ModuleMethod check$Mnsubstring$Mnspec;
    public static final ModuleMethod substring$Slshared;
    public static final ModuleMethod $Pcsubstring$Slshared;
    public static final StaticFieldLocation string$Mncopy;
    public static final ModuleMethod string$Mnmap;
    public static final ModuleMethod $Pcstring$Mnmap;
    public static final ModuleMethod string$Mnmap$Ex;
    public static final ModuleMethod $Pcstring$Mnmap$Ex;
    public static final ModuleMethod string$Mnfold;
    public static final ModuleMethod string$Mnfold$Mnright;
    public static final ModuleMethod string$Mnunfold;
    public static final ModuleMethod string$Mnunfold$Mnright;
    public static final StaticFieldLocation string$Mnfor$Mneach;
    public static final ModuleMethod string$Mnevery;
    public static final ModuleMethod string$Mnany;
    public static final ModuleMethod string$Mntabulate;
    public static final ModuleMethod $Pcstring$Mnprefix$Mnlength;
    public static final ModuleMethod $Pcstring$Mnsuffix$Mnlength;
    public static final ModuleMethod $Pcstring$Mnprefix$Mnlength$Mnci;
    public static final ModuleMethod $Pcstring$Mnsuffix$Mnlength$Mnci;
    public static final ModuleMethod string$Mnprefix$Mnlength;
    public static final ModuleMethod string$Mnsuffix$Mnlength;
    public static final ModuleMethod string$Mnprefix$Mnlength$Mnci;
    public static final ModuleMethod string$Mnsuffix$Mnlength$Mnci;
    public static final ModuleMethod string$Mnprefix$Qu;
    public static final ModuleMethod string$Mnsuffix$Qu;
    public static final ModuleMethod string$Mnprefix$Mnci$Qu;
    public static final ModuleMethod string$Mnsuffix$Mnci$Qu;
    public static final ModuleMethod $Pcstring$Mnprefix$Qu;
    public static final ModuleMethod $Pcstring$Mnsuffix$Qu;
    public static final ModuleMethod $Pcstring$Mnprefix$Mnci$Qu;
    public static final ModuleMethod $Pcstring$Mnsuffix$Mnci$Qu;
    public static final ModuleMethod $Pcstring$Mncompare;
    public static final ModuleMethod $Pcstring$Mncompare$Mnci;
    public static final ModuleMethod string$Mncompare;
    public static final ModuleMethod string$Mncompare$Mnci;
    public static final ModuleMethod string$Eq;
    public static final ModuleMethod string$Ls$Gr;
    public static final ModuleMethod string$Ls;
    public static final ModuleMethod string$Gr;
    public static final ModuleMethod string$Ls$Eq;
    public static final ModuleMethod string$Gr$Eq;
    public static final ModuleMethod string$Mnci$Eq;
    public static final ModuleMethod string$Mnci$Ls$Gr;
    public static final ModuleMethod string$Mnci$Ls;
    public static final ModuleMethod string$Mnci$Gr;
    public static final ModuleMethod string$Mnci$Ls$Eq;
    public static final ModuleMethod string$Mnci$Gr$Eq;
    public static final ModuleMethod $Pcstring$Mnhash;
    public static final ModuleMethod string$Mnhash;
    public static final ModuleMethod string$Mnhash$Mnci;
    public static final ModuleMethod string$Mnupcase;
    public static final ModuleMethod string$Mnupcase$Ex;
    public static final ModuleMethod string$Mndowncase;
    public static final ModuleMethod string$Mndowncase$Ex;
    public static final ModuleMethod $Pcstring$Mntitlecase$Ex;
    public static final ModuleMethod string$Mntitlecase$Ex;
    public static final ModuleMethod string$Mntitlecase;
    public static final ModuleMethod string$Mntake;
    public static final ModuleMethod string$Mntake$Mnright;
    public static final ModuleMethod string$Mndrop;
    public static final ModuleMethod string$Mndrop$Mnright;
    public static final ModuleMethod string$Mntrim;
    public static final ModuleMethod string$Mntrim$Mnright;
    public static final ModuleMethod string$Mntrim$Mnboth;
    public static final ModuleMethod string$Mnpad$Mnright;
    public static final ModuleMethod string$Mnpad;
    public static final ModuleMethod string$Mndelete;
    public static final ModuleMethod string$Mnfilter;
    public static final ModuleMethod string$Mnindex;
    public static final ModuleMethod string$Mnindex$Mnright;
    public static final ModuleMethod string$Mnskip;
    public static final ModuleMethod string$Mnskip$Mnright;
    public static final ModuleMethod string$Mncount;
    public static final StaticFieldLocation string$Mnfill$Ex;
    public static final StaticFieldLocation string$Mncopy$Ex;
    public static final StaticFieldLocation $Pcstring$Mncopy$Ex;
    public static final ModuleMethod string$Mncontains;
    public static final ModuleMethod string$Mncontains$Mnci;
    public static final ModuleMethod $Pckmp$Mnsearch;
    public static final ModuleMethod make$Mnkmp$Mnrestart$Mnvector;
    public static final ModuleMethod kmp$Mnstep;
    public static final ModuleMethod string$Mnkmp$Mnpartial$Mnsearch;
    public static final ModuleMethod string$Mnnull$Qu;
    public static final ModuleMethod string$Mnreverse;
    public static final ModuleMethod string$Mnreverse$Ex;
    public static final ModuleMethod reverse$Mnlist$Mn$Grstring;
    public static final StaticFieldLocation string$Mn$Grlist;
    public static final ModuleMethod string$Mnappend$Slshared;
    public static final ModuleMethod string$Mnconcatenate$Slshared;
    public static final ModuleMethod string$Mnconcatenate;
    public static final ModuleMethod string$Mnconcatenate$Mnreverse;
    public static final ModuleMethod string$Mnconcatenate$Mnreverse$Slshared;
    public static final ModuleMethod $Pcfinish$Mnstring$Mnconcatenate$Mnreverse;
    public static final ModuleMethod string$Mnreplace;
    public static final ModuleMethod string$Mntokenize;
    public static final ModuleMethod xsubstring;
    public static final ModuleMethod string$Mnxcopy$Ex;
    public static final ModuleMethod $Pcmultispan$Mnrepcopy$Ex;
    public static final ModuleMethod string$Mnjoin;
    static final IntNum Lit0;
    static final ModuleMethod lambda$Fn1;
    static final IntNum Lit1;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn3;
    static final IntNum Lit2;
    static final ModuleMethod lambda$Fn4;
    static final ModuleMethod lambda$Fn5;
    static final IntNum Lit3;
    static final ModuleMethod lambda$Fn6;
    static final ModuleMethod lambda$Fn7;
    static final ModuleMethod lambda$Fn8;
    static final ModuleMethod lambda$Fn9;
    static final ModuleMethod lambda$Fn10;
    static final ModuleMethod lambda$Fn11;
    static final ModuleMethod lambda$Fn12;
    static final ModuleMethod lambda$Fn13;
    static final ModuleMethod lambda$Fn14;
    static final ModuleMethod lambda$Fn15;
    static final ModuleMethod lambda$Fn16;
    static final ModuleMethod lambda$Fn17;
    static final ModuleMethod lambda$Fn18;
    static final ModuleMethod lambda$Fn19;
    static final ModuleMethod lambda$Fn20;
    static final ModuleMethod lambda$Fn21;
    static final ModuleMethod lambda$Fn22;
    static final ModuleMethod lambda$Fn23;
    static final ModuleMethod lambda$Fn24;
    static final IntNum Lit4;
    static final IntNum Lit5;
    static final IntNum Lit6;
    static final ModuleMethod lambda$Fn25;
    static final Char Lit7;
    static final ModuleMethod lambda$Fn30;
    static final ModuleMethod lambda$Fn31;
    static final IntNum Lit8;
    static final ModuleMethod lambda$Fn39;
    static final ModuleMethod lambda$Fn41;
    static final ModuleMethod lambda$Fn42;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    public static srfi13 $instance;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final SimpleSymbol Lit15;
    static final SyntaxPattern Lit16;
    static final SyntaxTemplate Lit17;
    static final SyntaxPattern Lit18;
    static final SyntaxTemplate Lit19;
    static final SyntaxTemplate Lit20;
    static final SyntaxPattern Lit21;
    static final SyntaxTemplate Lit22;
    static final SyntaxTemplate Lit23;
    static final SyntaxPattern Lit24;
    static final SyntaxTemplate Lit25;
    static final SyntaxTemplate Lit26;
    static final SyntaxPattern Lit27;
    static final SyntaxTemplate Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SyntaxRules Lit31;
    static final SimpleSymbol Lit32;
    static final SyntaxRules Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final SimpleSymbol Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final SimpleSymbol Lit77;
    static final SimpleSymbol Lit78;
    static final SimpleSymbol Lit79;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final SimpleSymbol Lit82;
    static final SimpleSymbol Lit83;
    static final SimpleSymbol Lit84;
    static final SimpleSymbol Lit85;
    static final SimpleSymbol Lit86;
    static final SimpleSymbol Lit87;
    static final SimpleSymbol Lit88;
    static final SimpleSymbol Lit89;
    static final SimpleSymbol Lit90;
    static final SimpleSymbol Lit91;
    static final SimpleSymbol Lit92;
    static final SimpleSymbol Lit93;
    static final SimpleSymbol Lit94;
    static final SimpleSymbol Lit95;
    static final SimpleSymbol Lit96;
    static final SimpleSymbol Lit97;
    static final SimpleSymbol Lit98;
    static final SimpleSymbol Lit99;
    static final SimpleSymbol Lit100;
    static final SimpleSymbol Lit101;
    static final SimpleSymbol Lit102;
    static final SimpleSymbol Lit103;
    static final SimpleSymbol Lit104;
    static final SimpleSymbol Lit105;
    static final SimpleSymbol Lit106;
    static final SimpleSymbol Lit107;
    static final SimpleSymbol Lit108;
    static final SimpleSymbol Lit109;
    static final SimpleSymbol Lit110;
    static final SimpleSymbol Lit111;
    static final SimpleSymbol Lit112;
    static final SimpleSymbol Lit113;
    static final SimpleSymbol Lit114;
    static final SimpleSymbol Lit115;
    static final SimpleSymbol Lit116;
    static final SimpleSymbol Lit117;
    static final SimpleSymbol Lit118;
    static final SimpleSymbol Lit119;
    static final SimpleSymbol Lit120;
    static final SimpleSymbol Lit121;
    static final SimpleSymbol Lit122;
    static final SimpleSymbol Lit123;
    static final SimpleSymbol Lit124;
    static final SimpleSymbol Lit125;
    static final SimpleSymbol Lit126;
    static final SimpleSymbol Lit127;
    static final SimpleSymbol Lit128;
    static final SimpleSymbol Lit129;
    static final SimpleSymbol Lit130;
    static final SimpleSymbol Lit131;
    static final Object[] Lit132;
    static final SimpleSymbol Lit133;
    static final SimpleSymbol Lit134;
    static final SimpleSymbol Lit135;
    static final SimpleSymbol Lit136;
    static final SimpleSymbol Lit137;
    static final SimpleSymbol Lit138;
    static final SimpleSymbol Lit139;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    @SourceMethodType(value={"", "character"})
    static boolean isCharCased(int c) {
        return unicode.charUpcase(c) != unicode.charDowncase(c);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object stringParseStart$PlEnd(Object proc, Object s, Object args) {
        block15 : {
            if (!strings.isString(s)) {
                v0 = exceptions.error(new Object[]{"Non-string value", proc, s});
                throw Special.reachedUnexpected;
            }
            var4_3 = Promise.force(s, CharSequence.class);
            try {
                slen = strings.stringLength((CharSequence)var4_3);
            }
            catch (ClassCastException v1) {
                throw new WrongType(v1, "string-length", 1, (Object)start);
            }
            if (!lists.isPair(args)) {
                v2 = Values.makeFromArray(new Object[]{LList.Empty, srfi13.Lit0, slen});
                return v2;
            }
            var5_5 = Promise.force(args, Pair.class);
            try {
                var4_3 = lists.car((Pair)var5_5);
            }
            catch (ClassCastException v3) {
                throw new WrongType(v3, "car", 1, args);
            }
            var6_6 = Promise.force(args, Pair.class);
            try {
                args = lists.cdr((Pair)var6_6);
            }
            catch (ClassCastException v4) {
                throw new WrongType(v4, "cdr", 1, (Object)var6_6);
            }
            if (!numbers.isInteger(start) || !numbers.isExact(start) || !NumberCompare.$Gr$Eq(start, srfi13.Lit0)) break block15;
            if (!lists.isPair(args)) ** GOTO lbl39
            var8_7 = Promise.force(args, Pair.class);
            try {
                var7_8 = lists.car((Pair)var8_7);
            }
            catch (ClassCastException v5) {
                throw new WrongType(v5, "car", 1, (Object)end);
            }
            var9_10 = Promise.force(args, Pair.class);
            try {
                args = lists.cdr((Pair)var9_10);
            }
            catch (ClassCastException v6) {
                throw new WrongType(v6, "cdr", 1, args);
            }
            if (numbers.isInteger(end) && numbers.isExact(end) && NumberCompare.$Ls$Eq(end, slen)) {
                v7 = Values.values2(end, args);
            } else {
                v8 = exceptions.error(new Object[]{"Illegal substring END spec", proc, end, s});
                throw Special.reachedUnexpected;
lbl39: // 1 sources:
                v7 = Values.values2(slen, args);
            }
            var6_6 = v7;
            end = 0;
            end = Values.incrPos(var6_6, end);
            args = Values.getFromPos(var6_6, end);
            end = Values.incrPos(var6_6, end);
            args = Values.getFromPosFinal(var6_6, end);
            if (NumberCompare.$Ls$Eq(start, end)) {
                v2 = Values.makeFromArray(new Object[]{args, start, end});
                return v2;
            }
            v9 = exceptions.error(new Object[]{"Illegal substring START/END spec", proc, start, end, s});
            throw Special.reachedUnexpected;
        }
        v10 = exceptions.error(new Object[]{"Illegal substring START spec", proc, start, s});
        throw Special.reachedUnexpected;
    }

    public static void $PcCheckBounds(Object proc, CharSequence s, int start, int end) {
        if (start < 0) {
            Type.NeverReturns neverReturns = exceptions.error("Illegal substring START spec", proc, start, s);
            throw Special.reachedUnexpected;
        }
        if (start > end) {
            Type.NeverReturns neverReturns = exceptions.error("Illegal substring START/END spec");
            throw Special.reachedUnexpected;
        }
        if (end > strings.stringLength(s)) {
            Type.NeverReturns neverReturns = exceptions.error("Illegal substring END spec", proc, end, s);
            throw Special.reachedUnexpected;
        }
    }

    public static Values stringParseFinalStart$PlEnd(Object proc, Object s, Object args) {
        void start;
        void rest;
        Object object2 = srfi13.stringParseStart$PlEnd(proc, s, args);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end = Values.getFromPosFinal(object2, n);
        if (lists.isPair(rest)) {
            Type.NeverReturns neverReturns = exceptions.error("Extra arguments to procedure", proc, rest);
            throw Special.reachedUnexpected;
        }
        return Values.values2(start, end);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isSubstringSpecOk(Object s, Object start, Object end) {
        boolean bl;
        if (!strings.isString(s)) return false;
        if (!numbers.isInteger(start)) return false;
        if (!numbers.isExact(start)) return false;
        if (!numbers.isInteger(end)) return false;
        if (!numbers.isExact(end)) return false;
        if (!NumberCompare.$Ls$Eq(Lit0, start)) return false;
        if (!NumberCompare.$Ls$Eq(start, end)) return false;
        Object object2 = Promise.force(s, CharSequence.class);
        try {
            bl = NumberCompare.$Ls$Eq(end, strings.stringLength((CharSequence)object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-length", 1, object2);
        }
        return bl;
    }

    public static void checkSubstringSpec(Object proc, Object s, Object start, Object end) {
        if (!srfi13.isSubstringSpecOk(s, start, end)) {
            Type.NeverReturns neverReturns = exceptions.error("Illegal substring spec.", proc, s, start, end);
            throw Special.reachedUnexpected;
        }
    }

    /*
     * Exception decompiling
     */
    public static Object substring$SlShared$V(Object s, Object start, Object[] argsArray) {
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

    static Object checkArg(Object pred, Object val, Object proc) {
        if (!KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply2(pred, val))) {
            Type.NeverReturns neverReturns = exceptions.error("Bad arg", val, pred, proc);
            throw Special.reachedUnexpected;
        }
        return val;
    }

    static boolean lambda1(Object start) {
        return numbers.isInteger(start) ? (numbers.isExact(start) ? NumberCompare.$Ls$Eq(Lit0, start) : false) : false;
    }

    public static Object $PcSubstring$SlShared(CharSequence s, int start, int end) {
        return numbers.isZero(start) && end == strings.stringLength(s) ? s : strings.substring(s, start, end);
    }

    public static FString stringMap$V(Object proc, Object s, Object[] argsArray) {
        AbstractSequence abstractSequence;
        void start;
        LList maybe$Mnstart$Plend = abstractSequence = LList.makeList(argsArray, 0);
        srfi13.checkArg(misc.procedure$Qu, proc, string$Mnmap);
        abstractSequence = srfi13.stringParseFinalStart$PlEnd(string$Mnmap, s, maybe$Mnstart$Plend);
        int n = 0;
        n = Values.incrPos(abstractSequence, n);
        Object object2 = Values.getFromPos(abstractSequence, n);
        n = Values.incrPos(abstractSequence, n);
        Object end = Values.getFromPosFinal(abstractSequence, n);
        return srfi13.$PcStringMap(proc, s, start, end);
    }

    /*
     * Exception decompiling
     */
    public static FString $PcStringMap(Object proc, Object s, Object start, Object end) {
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

    public static Object stringMap$Ex$V(Object proc, Object s, Object[] argsArray) {
        AbstractSequence abstractSequence;
        void start;
        LList maybe$Mnstart$Plend = abstractSequence = LList.makeList(argsArray, 0);
        srfi13.checkArg(misc.procedure$Qu, proc, string$Mnmap$Ex);
        abstractSequence = srfi13.stringParseFinalStart$PlEnd(string$Mnmap$Ex, s, maybe$Mnstart$Plend);
        int n = 0;
        n = Values.incrPos(abstractSequence, n);
        Object object2 = Values.getFromPos(abstractSequence, n);
        n = Values.incrPos(abstractSequence, n);
        Object end = Values.getFromPosFinal(abstractSequence, n);
        return srfi13.$PcStringMap$Ex(proc, s, start, end);
    }

    /*
     * Exception decompiling
     */
    public static Object $PcStringMap$Ex(Object proc, Object s, Object start, Object end) {
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

    /*
     * Exception decompiling
     */
    public static Object stringFold$V(Object kons, Object knil, Object s, Object[] argsArray) {
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

    /*
     * Exception decompiling
     */
    public static Object stringFoldRight$V(Object kons, Object knil, Object s, Object[] argsArray) {
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

    /*
     * Exception decompiling
     */
    public static Object stringUnfold$V(Object p, Object f, Object g, Object seed, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    static String lambda2(Object x) {
        return "";
    }

    static String lambda3(Object x) {
        return "";
    }

    /*
     * Exception decompiling
     */
    public static Object stringUnfoldRight$V(Object p, Object f, Object g, Object seed, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    static String lambda4(Object x) {
        return "";
    }

    static String lambda5(Object x) {
        return "";
    }

    /*
     * Exception decompiling
     */
    public static Object stringEvery$V(Object criterion, Object s, Object[] argsArray) {
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

    /*
     * Exception decompiling
     */
    public static Object stringAny$V(Object criterion, Object s, Object[] argsArray) {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static FString stringTabulate(Object proc, int len) {
        srfi13.checkArg(misc.procedure$Qu, proc, string$Mntabulate);
        srfi13.checkArg(lambda$Fn6, len, string$Mntabulate);
        FString s = strings.makeString(len);
        int i = len - 1;
        while (i >= 0) {
            Object object2 = Promise.force(((Procedure)Scheme.applyToArgs).apply2(proc, i));
            try {
                strings.stringSet$Ex(s, i, Char.castToCharacter(object2));
                --i;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "string-set!", 3, object2);
            }
        }
        return s;
    }

    static boolean lambda6(Object val) {
        return numbers.isInteger(val) ? (numbers.isExact(val) ? NumberCompare.$Ls$Eq(Lit0, val) : false) : false;
    }

    /*
     * Exception decompiling
     */
    public static Object $PcStringPrefixLength(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object $PcStringSuffixLength(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    /*
     * Exception decompiling
     */
    public static int $PcStringPrefixLengthCi(Object s1, int start1, int end1, Object s2, int start2, int end2) {
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

    /*
     * Exception decompiling
     */
    public static int $PcStringSuffixLengthCi(Object s1, int start1, int end1, Object s2, int start2, int end2) {
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

    public static Object stringPrefixLength$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnprefix$Mnlength, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnprefix$Mnlength, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return srfi13.$PcStringPrefixLength(s1, start1, end1, s2, start2, end2);
    }

    public static Object stringSuffixLength$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnsuffix$Mnlength, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnsuffix$Mnlength, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return srfi13.$PcStringSuffixLength(s1, start1, end1, s2, start2, end2);
    }

    /*
     * Exception decompiling
     */
    public static int stringPrefixLengthCi$V(Object s1, Object s2, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    /*
     * Exception decompiling
     */
    public static int stringSuffixLengthCi$V(Object s1, Object s2, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    public static boolean isStringPrefix$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnprefix$Qu, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnprefix$Qu, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return srfi13.$PcStringPrefix$Qu(s1, start1, end1, s2, start2, end2);
    }

    public static boolean $PcStringPrefix$Qu(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2) {
        Object len1 = AddOp.apply2(-1, end1, start1);
        return NumberCompare.$Ls$Eq(len1, AddOp.apply2(-1, end2, start2)) ? NumberCompare.$Eq(srfi13.$PcStringPrefixLength(s1, start1, end1, s2, start2, end2), len1) : false;
    }

    public static boolean isStringSuffix$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnsuffix$Qu, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnsuffix$Qu, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return srfi13.$PcStringSuffix$Qu(s1, start1, end1, s2, start2, end2);
    }

    public static boolean $PcStringSuffix$Qu(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2) {
        Object len1 = AddOp.apply2(-1, end1, start1);
        return NumberCompare.$Ls$Eq(len1, AddOp.apply2(-1, end2, start2)) ? NumberCompare.$Eq(len1, srfi13.$PcStringSuffixLength(s1, start1, end1, s2, start2, end2)) : false;
    }

    public static boolean isStringPrefixCi$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnprefix$Mnci$Qu, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnprefix$Mnci$Qu, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return srfi13.$PcStringPrefixCi$Qu(s1, start1, end1, s2, start2, end2);
    }

    /*
     * Exception decompiling
     */
    public static boolean $PcStringPrefixCi$Qu(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    public static boolean isStringSuffixCi$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnsuffix$Mnci$Qu, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnsuffix$Mnci$Qu, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return srfi13.$PcStringSuffixCi$Qu(s1, start1, end1, s2, start2, end2);
    }

    /*
     * Exception decompiling
     */
    public static boolean $PcStringSuffixCi$Qu(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object $PcStringCompare(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2, Object proc$Ls, Object proc$Eq, Object proc$Gr) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object $PcStringCompareCi(Object s1, Object start1, Object end1, Object s2, Object start2, Object end2, Object proc$Ls, Object proc$Eq, Object proc$Gr) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    public static Object stringCompare$V(Object s1, Object s2, Object proc$Ls, Object proc$Eq, Object proc$Gr, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        srfi13.checkArg(misc.procedure$Qu, proc$Ls, string$Mncompare);
        srfi13.checkArg(misc.procedure$Qu, proc$Eq, string$Mncompare);
        srfi13.checkArg(misc.procedure$Qu, proc$Gr, string$Mncompare);
        object2 = srfi13.stringParseStart$PlEnd(string$Mncompare, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mncompare, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return srfi13.$PcStringCompare(s1, start1, end1, s2, start2, end2, proc$Ls, proc$Eq, proc$Gr);
    }

    public static Object stringCompareCi$V(Object s1, Object s2, Object proc$Ls, Object proc$Eq, Object proc$Gr, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        srfi13.checkArg(misc.procedure$Qu, proc$Ls, string$Mncompare$Mnci);
        srfi13.checkArg(misc.procedure$Qu, proc$Eq, string$Mncompare$Mnci);
        srfi13.checkArg(misc.procedure$Qu, proc$Gr, string$Mncompare$Mnci);
        object2 = srfi13.stringParseStart$PlEnd(string$Mncompare$Mnci, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mncompare$Mnci, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return srfi13.$PcStringCompareCi(s1, start1, end1, s2, start2, end2, proc$Ls, proc$Eq, proc$Gr);
    }

    public static Object string$Eq$V(Object s1, Object s2, Object[] argsArray) {
        Object object2;
        void rest;
        void start2;
        void start1;
        Object object3 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object3;
        object3 = srfi13.stringParseStart$PlEnd(string$Eq, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object3, n);
        Object object4 = Values.getFromPos(object3, n);
        n = Values.incrPos(object3, n);
        Object object5 = Values.getFromPos(object3, n);
        n = Values.incrPos(object3, n);
        Object end1 = Values.getFromPosFinal(object3, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Eq, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object6 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        if (NumberCompare.$Eq(AddOp.apply2(-1, end1, start1), AddOp.apply2(-1, end2, start2))) {
            boolean x;
            boolean bl = x = s1 == s2 ? NumberCompare.$Eq(start1, start2) : false;
            object2 = x ? (x ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompare(s1, start1, end1, s2, start2, end2, lambda$Fn7, misc.values, lambda$Fn8);
        } else {
            object2 = Boolean.FALSE;
        }
        return object2;
    }

    static boolean lambda7(Object i) {
        return false;
    }

    static boolean lambda8(Object i) {
        return false;
    }

    public static Object string$Ls$Gr$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        boolean x;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Ls$Gr, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Ls$Gr, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        boolean bl = x = !NumberCompare.$Eq(AddOp.apply2(-1, end1, start1), AddOp.apply2(-1, end2, start2));
        return x ? (x ? Boolean.TRUE : Boolean.FALSE) : (s1 != s2 || !NumberCompare.$Eq(start1, start2) ? srfi13.$PcStringCompare(s1, start1, end1, s2, start2, end2, misc.values, lambda$Fn9, misc.values) : Boolean.FALSE);
    }

    static boolean lambda9(Object i) {
        return false;
    }

    public static Object string$Ls$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Ls, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Ls, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return s1 == s2 && NumberCompare.$Eq(start1, start2) ? (NumberCompare.$Ls(end1, end2) ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompare(s1, start1, end1, s2, start2, end2, misc.values, lambda$Fn10, lambda$Fn11);
    }

    static boolean lambda10(Object i) {
        return false;
    }

    static boolean lambda11(Object i) {
        return false;
    }

    public static Object string$Gr$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Gr, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Gr, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return s1 == s2 && NumberCompare.$Eq(start1, start2) ? (NumberCompare.$Gr(end1, end2) ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompare(s1, start1, end1, s2, start2, end2, lambda$Fn12, lambda$Fn13, misc.values);
    }

    static boolean lambda12(Object i) {
        return false;
    }

    static boolean lambda13(Object i) {
        return false;
    }

    public static Object string$Ls$Eq$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Ls$Eq, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Ls$Eq, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return s1 == s2 && NumberCompare.$Eq(start1, start2) ? (NumberCompare.$Ls$Eq(end1, end2) ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompare(s1, start1, end1, s2, start2, end2, misc.values, misc.values, lambda$Fn14);
    }

    static boolean lambda14(Object i) {
        return false;
    }

    public static Object string$Gr$Eq$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Gr$Eq, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Gr$Eq, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return s1 == s2 && NumberCompare.$Eq(start1, start2) ? (NumberCompare.$Gr$Eq(end1, end2) ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompare(s1, start1, end1, s2, start2, end2, lambda$Fn15, misc.values, misc.values);
    }

    static boolean lambda15(Object i) {
        return false;
    }

    public static Object stringCi$Eq$V(Object s1, Object s2, Object[] argsArray) {
        Object object2;
        void rest;
        void start2;
        void start1;
        Object object3 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object3;
        object3 = srfi13.stringParseStart$PlEnd(string$Mnci$Eq, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object3, n);
        Object object4 = Values.getFromPos(object3, n);
        n = Values.incrPos(object3, n);
        Object object5 = Values.getFromPos(object3, n);
        n = Values.incrPos(object3, n);
        Object end1 = Values.getFromPosFinal(object3, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnci$Eq, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object6 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        if (NumberCompare.$Eq(AddOp.apply2(-1, end1, start1), AddOp.apply2(-1, end2, start2))) {
            boolean x;
            boolean bl = x = s1 == s2 ? NumberCompare.$Eq(start1, start2) : false;
            object2 = x ? (x ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompareCi(s1, start1, end1, s2, start2, end2, lambda$Fn16, misc.values, lambda$Fn17);
        } else {
            object2 = Boolean.FALSE;
        }
        return object2;
    }

    static boolean lambda16(Object i) {
        return false;
    }

    static boolean lambda17(Object i) {
        return false;
    }

    public static Object stringCi$Ls$Gr$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        boolean x;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnci$Ls$Gr, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnci$Ls$Gr, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        boolean bl = x = !NumberCompare.$Eq(AddOp.apply2(-1, end1, start1), AddOp.apply2(-1, end2, start2));
        return x ? (x ? Boolean.TRUE : Boolean.FALSE) : (s1 != s2 || !NumberCompare.$Eq(start1, start2) ? srfi13.$PcStringCompareCi(s1, start1, end1, s2, start2, end2, misc.values, lambda$Fn18, misc.values) : Boolean.FALSE);
    }

    static boolean lambda18(Object i) {
        return false;
    }

    public static Object stringCi$Ls$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnci$Ls, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnci$Ls, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return s1 == s2 && NumberCompare.$Eq(start1, start2) ? (NumberCompare.$Ls(end1, end2) ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompareCi(s1, start1, end1, s2, start2, end2, misc.values, lambda$Fn19, lambda$Fn20);
    }

    static boolean lambda19(Object i) {
        return false;
    }

    static boolean lambda20(Object i) {
        return false;
    }

    public static Object stringCi$Gr$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnci$Gr, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnci$Gr, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return s1 == s2 && NumberCompare.$Eq(start1, start2) ? (NumberCompare.$Gr(end1, end2) ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompareCi(s1, start1, end1, s2, start2, end2, lambda$Fn21, lambda$Fn22, misc.values);
    }

    static boolean lambda21(Object i) {
        return false;
    }

    static boolean lambda22(Object i) {
        return false;
    }

    public static Object stringCi$Ls$Eq$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnci$Ls$Eq, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnci$Ls$Eq, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return s1 == s2 && NumberCompare.$Eq(start1, start2) ? (NumberCompare.$Ls$Eq(end1, end2) ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompareCi(s1, start1, end1, s2, start2, end2, misc.values, misc.values, lambda$Fn23);
    }

    static boolean lambda23(Object i) {
        return false;
    }

    public static Object stringCi$Gr$Eq$V(Object s1, Object s2, Object[] argsArray) {
        void rest;
        void start2;
        void start1;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mnci$Gr$Eq, s1, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object end1 = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnci$Gr$Eq, s2, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object end2 = Values.getFromPosFinal(values, n2);
        return s1 == s2 && NumberCompare.$Eq(start1, start2) ? (NumberCompare.$Gr$Eq(end1, end2) ? Boolean.TRUE : Boolean.FALSE) : srfi13.$PcStringCompareCi(s1, start1, end1, s2, start2, end2, lambda$Fn24, misc.values, misc.values);
    }

    static boolean lambda24(Object i) {
        return false;
    }

    /*
     * Exception decompiling
     */
    public static Object $PcStringHash(Object s, Object char$Mn$Grint, Object bound, Object start, Object end) {
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object stringHash$V(Object s, Object[] argsArray) {
        IntNum bound;
        Object object2;
        Object object3;
        IntNum bound2;
        void start;
        LList lList = LList.makeList(argsArray, 0);
        LList maybe$Mnbound$Plstart$Plend = lList;
        if (!lists.isNull(maybe$Mnbound$Plstart$Plend)) {
            LList lList2 = maybe$Mnbound$Plstart$Plend;
            object2 = lists.car((Pair)lList2);
        }
        object2 = bound2 = Lit6;
        if (!(numbers.isInteger(bound2) && numbers.isExact(bound2) && NumberCompare.$Ls$Eq(Lit0, bound2))) {
            bound2 = Lit6;
        }
        if (!lists.isNull(maybe$Mnbound$Plstart$Plend)) {
            LList lList3 = maybe$Mnbound$Plstart$Plend;
            object3 = lists.cdr((Pair)lList3);
        }
        object3 = maybe$Mnbound$Plstart$Plend;
        LList rest = object3;
        Object object4 = Promise.force(bound2, Number.class);
        try {
            bound = numbers.isZero((Number)object4) ? Lit6 : bound2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "zero?", 1, object4);
        }
        object4 = srfi13.stringParseFinalStart$PlEnd(string$Mnhash, s, rest);
        int n = 0;
        n = Values.incrPos(object4, n);
        Object object5 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object end = Values.getFromPosFinal(object4, n);
        return srfi13.$PcStringHash(s, characters.char$Mn$Grinteger, bound, start, end);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, (Object)rest);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)bound);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object stringHashCi$V(Object s, Object[] argsArray) {
        IntNum bound;
        Object object2;
        Object object3;
        IntNum bound2;
        void start;
        LList lList = LList.makeList(argsArray, 0);
        LList maybe$Mnbound$Plstart$Plend = lList;
        if (!lists.isNull(maybe$Mnbound$Plstart$Plend)) {
            LList lList2 = maybe$Mnbound$Plstart$Plend;
            object2 = lists.car((Pair)lList2);
        }
        object2 = bound2 = Lit6;
        if (!(numbers.isInteger(bound2) && numbers.isExact(bound2) && NumberCompare.$Ls$Eq(Lit0, bound2))) {
            bound2 = Lit6;
        }
        if (!lists.isNull(maybe$Mnbound$Plstart$Plend)) {
            LList lList3 = maybe$Mnbound$Plstart$Plend;
            object3 = lists.cdr((Pair)lList3);
        }
        object3 = maybe$Mnbound$Plstart$Plend;
        LList rest = object3;
        Object object4 = Promise.force(bound2, Number.class);
        try {
            bound = numbers.isZero((Number)object4) ? Lit6 : bound2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "zero?", 1, object4);
        }
        object4 = srfi13.stringParseFinalStart$PlEnd(string$Mnhash$Mnci, s, rest);
        int n = 0;
        n = Values.incrPos(object4, n);
        Object object5 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object end = Values.getFromPosFinal(object4, n);
        return srfi13.$PcStringHash(s, lambda$Fn25, bound, start, end);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, (Object)rest);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)bound);
        }
    }

    static int lambda25(Object c) {
        Object object2 = Promise.force(c);
        try {
            return unicode.charDowncase(Char.castToCharacter(object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-downcase", 1, object2);
        }
    }

    public static FString stringUpcase$V(Object s, Object[] argsArray) {
        void start;
        AbstractSequence abstractSequence;
        LList maybe$Mnstart$Plend = abstractSequence = LList.makeList(argsArray, 0);
        abstractSequence = srfi13.stringParseFinalStart$PlEnd(string$Mnupcase, s, maybe$Mnstart$Plend);
        int n = 0;
        n = Values.incrPos(abstractSequence, n);
        Object object2 = Values.getFromPos(abstractSequence, n);
        n = Values.incrPos(abstractSequence, n);
        Object end = Values.getFromPosFinal(abstractSequence, n);
        return srfi13.$PcStringMap(unicode.char$Mnupcase, s, start, end);
    }

    public static Object stringUpcase$Ex$V(Object s, Object[] argsArray) {
        void start;
        AbstractSequence abstractSequence;
        LList maybe$Mnstart$Plend = abstractSequence = LList.makeList(argsArray, 0);
        abstractSequence = srfi13.stringParseFinalStart$PlEnd(string$Mnupcase$Ex, s, maybe$Mnstart$Plend);
        int n = 0;
        n = Values.incrPos(abstractSequence, n);
        Object object2 = Values.getFromPos(abstractSequence, n);
        n = Values.incrPos(abstractSequence, n);
        Object end = Values.getFromPosFinal(abstractSequence, n);
        return srfi13.$PcStringMap$Ex(unicode.char$Mnupcase, s, start, end);
    }

    public static FString stringDowncase$V(Object s, Object[] argsArray) {
        void start;
        AbstractSequence abstractSequence;
        LList maybe$Mnstart$Plend = abstractSequence = LList.makeList(argsArray, 0);
        abstractSequence = srfi13.stringParseFinalStart$PlEnd(string$Mndowncase, s, maybe$Mnstart$Plend);
        int n = 0;
        n = Values.incrPos(abstractSequence, n);
        Object object2 = Values.getFromPos(abstractSequence, n);
        n = Values.incrPos(abstractSequence, n);
        Object end = Values.getFromPosFinal(abstractSequence, n);
        return srfi13.$PcStringMap(unicode.char$Mndowncase, s, start, end);
    }

    public static Object stringDowncase$Ex$V(Object s, Object[] argsArray) {
        void start;
        AbstractSequence abstractSequence;
        LList maybe$Mnstart$Plend = abstractSequence = LList.makeList(argsArray, 0);
        abstractSequence = srfi13.stringParseFinalStart$PlEnd(string$Mndowncase$Ex, s, maybe$Mnstart$Plend);
        int n = 0;
        n = Values.incrPos(abstractSequence, n);
        Object object2 = Values.getFromPos(abstractSequence, n);
        n = Values.incrPos(abstractSequence, n);
        Object end = Values.getFromPosFinal(abstractSequence, n);
        return srfi13.$PcStringMap$Ex(unicode.char$Mndowncase, s, start, end);
    }

    /*
     * Exception decompiling
     */
    public static Object $PcStringTitlecase$Ex(Object s, Object start, Object end) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object stringIndex$V(Object str, Object criterion, Object[] argsArray) {
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

    /*
     * Exception decompiling
     */
    public static Object stringSkip$V(Object str, Object criterion, Object[] argsArray) {
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

    public static Object stringTitlecase$Ex$V(Object s, Object[] argsArray) {
        void start;
        AbstractSequence abstractSequence;
        LList maybe$Mnstart$Plend = abstractSequence = LList.makeList(argsArray, 0);
        abstractSequence = srfi13.stringParseFinalStart$PlEnd(string$Mntitlecase$Ex, s, maybe$Mnstart$Plend);
        int n = 0;
        n = Values.incrPos(abstractSequence, n);
        Object object2 = Values.getFromPos(abstractSequence, n);
        n = Values.incrPos(abstractSequence, n);
        Object end = Values.getFromPosFinal(abstractSequence, n);
        return srfi13.$PcStringTitlecase$Ex(s, start, end);
    }

    /*
     * Exception decompiling
     */
    public static CharSequence stringTitlecase$V(Object s, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object stringTake(Object s, Object n) {
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

    /*
     * Exception decompiling
     */
    public static Object stringTakeRight(Object s, Object n) {
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

    public static Object stringDrop(CharSequence s, Object n) {
        public class Frame1
        extends ModuleBody {
            int len;
            Object n;
            final ModuleMethod lambda$Fn28;

            public Frame1() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 3, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1059");
                this.lambda$Fn28 = moduleMethod;
            }

            boolean lambda28(Object val) {
                return numbers.isInteger(this.n) ? (numbers.isExact(this.n) ? NumberCompare.$Ls$Eq$V(srfi13.Lit0, this.n, this.len, new Object[0]) : false) : false;
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 3) {
                    callContext.value1 = object2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, object2, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply1(ModuleMethod moduleMethod, Object object2) {
                if (moduleMethod.selector == 3) {
                    return this.lambda28(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame1 $heapFrame = new Frame1();
        $heapFrame.n = n;
        $heapFrame.len = strings.stringLength(s);
        srfi13.checkArg($heapFrame.lambda$Fn28, $heapFrame.n, string$Mndrop);
        Object object2 = Promise.force($heapFrame.n);
        try {
            return srfi13.$PcSubstring$SlShared(s, ((Number)object2).intValue(), $heapFrame.len);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%substring/shared", 1, object2);
        }
    }

    public static Object stringDropRight(CharSequence s, Object n) {
        public class Frame2
        extends ModuleBody {
            int len;
            Object n;
            final ModuleMethod lambda$Fn29;

            public Frame2() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 4, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1065");
                this.lambda$Fn29 = moduleMethod;
            }

            boolean lambda29(Object val) {
                return numbers.isInteger(this.n) ? (numbers.isExact(this.n) ? NumberCompare.$Ls$Eq$V(srfi13.Lit0, this.n, this.len, new Object[0]) : false) : false;
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 4) {
                    callContext.value1 = object2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, object2, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply1(ModuleMethod moduleMethod, Object object2) {
                if (moduleMethod.selector == 4) {
                    return this.lambda29(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame2 $heapFrame = new Frame2();
        $heapFrame.n = n;
        $heapFrame.len = strings.stringLength(s);
        srfi13.checkArg($heapFrame.lambda$Fn29, $heapFrame.n, string$Mndrop$Mnright);
        Object object2 = Promise.force(AddOp.apply2(-1, $heapFrame.len, $heapFrame.n));
        try {
            return srfi13.$PcSubstring$SlShared(s, 0, ((Number)object2).intValue());
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%substring/shared", 2, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object stringTrim$V(Object s, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object stringTrimRight$V(Object s, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object stringSkipRight$V(Object str, Object criterion, Object[] argsArray) {
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

    /*
     * Exception decompiling
     */
    public static Object stringTrimBoth$V(Object s, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object stringPadRight$V(Object s, Object n, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    static boolean lambda30(Object n) {
        return numbers.isInteger(n) ? (numbers.isExact(n) ? NumberCompare.$Ls$Eq(Lit0, n) : false) : false;
    }

    /*
     * Exception decompiling
     */
    public static Object stringPad$V(Object s, Object n, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    static boolean lambda31(Object n) {
        return numbers.isInteger(n) ? (numbers.isExact(n) ? NumberCompare.$Ls$Eq(Lit0, n) : false) : false;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static CharSequence stringDelete$V(Object criterion, Object s, Object[] argsArray) {
        LList lList;
        void start;
        Object object2;
        Object object3;
        CharSequence charSequence;
        public class Frame3
        extends ModuleBody {
            FString ans;
            Object cset;
            FString temp;
            Object criterion;
            final ModuleMethod lambda$Fn32;
            final ModuleMethod lambda$Fn33;
            final ModuleMethod lambda$Fn34;

            public Frame3() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 5, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1138");
                this.lambda$Fn32 = moduleMethod;
                ModuleMethod moduleMethod2 = new ModuleMethod(this, 6, null, 8194);
                moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1148");
                this.lambda$Fn33 = moduleMethod2;
                ModuleMethod moduleMethod3 = new ModuleMethod(this, 7, null, 8194);
                moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1153");
                this.lambda$Fn34 = moduleMethod3;
            }

            /*
             * Exception decompiling
             */
            Object lambda32(Object c, Object i) {
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
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                // org.benf.cfr.reader.Main.main(Main.java:48)
                throw new IllegalStateException("Decompilation failed");
            }

            /*
             * Exception decompiling
             */
            Object lambda33(Object c, Object i) {
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
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                // org.benf.cfr.reader.Main.main(Main.java:48)
                throw new IllegalStateException("Decompilation failed");
            }

            /*
             * Exception decompiling
             */
            Object lambda34(Object c, Object i) {
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
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                // org.benf.cfr.reader.Main.main(Main.java:48)
                throw new IllegalStateException("Decompilation failed");
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                switch (moduleMethod.selector) {
                    case 7: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    case 6: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    case 5: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                }
                return super.match2(moduleMethod, object2, object3, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                switch (moduleMethod.selector) {
                    case 5: {
                        return this.lambda32(object2, object3);
                    }
                    case 6: {
                        return this.lambda33(object2, object3);
                    }
                    case 7: {
                        return this.lambda34(object2, object3);
                    }
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame3 $heapFrame = new Frame3();
        $heapFrame.criterion = criterion;
        LList maybe$Mnstart$Plend = lList = LList.makeList(argsArray, 0);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mndelete, s, maybe$Mnstart$Plend);
        int n = 0;
        n = Values.incrPos(values, n);
        Object object4 = Values.getFromPos(values, n);
        n = Values.incrPos(values, n);
        Object end = Values.getFromPosFinal(values, n);
        if (misc.isProcedure($heapFrame.criterion)) {
            Object slen = AddOp.apply2(-1, end, start);
            Object object5 = Promise.force(slen);
            $heapFrame.temp = strings.makeString(((Number)object5).intValue());
            Object ans$Mnlen = srfi13.stringFold$V($heapFrame.lambda$Fn32, Lit0, s, new Object[]{start, end});
            if (NumberCompare.$Eq(ans$Mnlen, slen)) {
                charSequence = $heapFrame.temp;
                return charSequence;
            }
            object3 = Promise.force(ans$Mnlen);
            charSequence = strings.substring($heapFrame.temp, 0, ((Number)object3).intValue());
            return charSequence;
        }
        if ($heapFrame.criterion instanceof srfi14.CharSet) {
            object2 = $heapFrame.criterion;
        } else {
            int[] arrn;
            if (!characters.isChar($heapFrame.criterion)) {
                Type.NeverReturns neverReturns = exceptions.error("string-delete criterion not predicate, char or char-set", $heapFrame.criterion);
                throw Special.reachedUnexpected;
            }
            object2 = new srfi14.CharSet(arrn);
            Object object5 = $heapFrame.criterion;
            if (object5 instanceof int[]) {
                arrn = (int[])object5;
            } else {
                int[] arrn2 = new int[1];
                arrn = arrn2;
                arrn2[0] = Char.castToCharacter(object5);
            }
        }
        $heapFrame.cset = object2;
        Object len = srfi13.stringFold$V($heapFrame.lambda$Fn33, Lit0, s, new Object[]{start, end});
        Object ans$Mnlen = Promise.force(len);
        try {
            $heapFrame.ans = strings.makeString(((Number)ans$Mnlen).intValue());
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-string", 1, ans$Mnlen);
        }
        srfi13.stringFold$V($heapFrame.lambda$Fn34, Lit0, s, new Object[]{start, end});
        charSequence = $heapFrame.ans;
        return charSequence;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-string", 1, ans$Mnlen);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "substring", 3, object3);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static CharSequence stringFilter$V(Object criterion, Object s, Object[] argsArray) {
        LList lList;
        void start;
        Object object2;
        Object object3;
        CharSequence charSequence;
        public class Frame4
        extends ModuleBody {
            FString ans;
            Object cset;
            FString temp;
            Object criterion;
            final ModuleMethod lambda$Fn35;
            final ModuleMethod lambda$Fn36;
            final ModuleMethod lambda$Fn37;

            public Frame4() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 8, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1165");
                this.lambda$Fn35 = moduleMethod;
                ModuleMethod moduleMethod2 = new ModuleMethod(this, 9, null, 8194);
                moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1177");
                this.lambda$Fn36 = moduleMethod2;
                ModuleMethod moduleMethod3 = new ModuleMethod(this, 10, null, 8194);
                moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1182");
                this.lambda$Fn37 = moduleMethod3;
            }

            /*
             * Exception decompiling
             */
            Object lambda35(Object c, Object i) {
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
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                // org.benf.cfr.reader.Main.main(Main.java:48)
                throw new IllegalStateException("Decompilation failed");
            }

            /*
             * Exception decompiling
             */
            Object lambda36(Object c, Object i) {
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
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                // org.benf.cfr.reader.Main.main(Main.java:48)
                throw new IllegalStateException("Decompilation failed");
            }

            /*
             * Exception decompiling
             */
            Object lambda37(Object c, Object i) {
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
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                // org.benf.cfr.reader.Main.main(Main.java:48)
                throw new IllegalStateException("Decompilation failed");
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                switch (moduleMethod.selector) {
                    case 10: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    case 9: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    case 8: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                }
                return super.match2(moduleMethod, object2, object3, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                switch (moduleMethod.selector) {
                    case 8: {
                        return this.lambda35(object2, object3);
                    }
                    case 9: {
                        return this.lambda36(object2, object3);
                    }
                    case 10: {
                        return this.lambda37(object2, object3);
                    }
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame4 $heapFrame = new Frame4();
        $heapFrame.criterion = criterion;
        LList maybe$Mnstart$Plend = lList = LList.makeList(argsArray, 0);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mnfilter, s, maybe$Mnstart$Plend);
        int n = 0;
        n = Values.incrPos(values, n);
        Object object4 = Values.getFromPos(values, n);
        n = Values.incrPos(values, n);
        Object end = Values.getFromPosFinal(values, n);
        if (misc.isProcedure($heapFrame.criterion)) {
            Object slen = AddOp.apply2(-1, end, start);
            Object object5 = Promise.force(slen);
            $heapFrame.temp = strings.makeString(((Number)object5).intValue());
            Object ans$Mnlen = srfi13.stringFold$V($heapFrame.lambda$Fn35, Lit0, s, new Object[]{start, end});
            if (NumberCompare.$Eq(ans$Mnlen, slen)) {
                charSequence = $heapFrame.temp;
                return charSequence;
            }
            object3 = Promise.force(ans$Mnlen);
            charSequence = strings.substring($heapFrame.temp, 0, ((Number)object3).intValue());
            return charSequence;
        }
        if ($heapFrame.criterion instanceof srfi14.CharSet) {
            object2 = $heapFrame.criterion;
        } else {
            int[] arrn;
            if (!characters.isChar($heapFrame.criterion)) {
                Type.NeverReturns neverReturns = exceptions.error("string-delete criterion not predicate, char or char-set", $heapFrame.criterion);
                throw Special.reachedUnexpected;
            }
            object2 = new srfi14.CharSet(arrn);
            Object object5 = $heapFrame.criterion;
            if (object5 instanceof int[]) {
                arrn = (int[])object5;
            } else {
                int[] arrn2 = new int[1];
                arrn = arrn2;
                arrn2[0] = Char.castToCharacter(object5);
            }
        }
        $heapFrame.cset = object2;
        Object len = srfi13.stringFold$V($heapFrame.lambda$Fn36, Lit0, s, new Object[]{start, end});
        Object ans$Mnlen = Promise.force(len);
        try {
            $heapFrame.ans = strings.makeString(((Number)ans$Mnlen).intValue());
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-string", 1, ans$Mnlen);
        }
        srfi13.stringFold$V($heapFrame.lambda$Fn37, Lit0, s, new Object[]{start, end});
        charSequence = $heapFrame.ans;
        return charSequence;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-string", 1, ans$Mnlen);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "substring", 3, object3);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object stringIndexRight$V(Object str, Object criterion, Object[] argsArray) {
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

    /*
     * Exception decompiling
     */
    public static Object stringCount$V(Object s, Object criterion, Object[] argsArray) {
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

    public static Object stringContains$V(Object text, Object pattern, Object[] argsArray) {
        void rest;
        void p$Mnstart;
        void t$Mnstart;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mncontains, text, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object t$Mnend = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mncontains, pattern, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object p$Mnend = Values.getFromPosFinal(values, n2);
        return srfi13.$PcKmpSearch(pattern, text, strings.char$Eq$Qu, p$Mnstart, p$Mnend, t$Mnstart, t$Mnend);
    }

    /*
     * Exception decompiling
     */
    public static Object $PcKmpSearch(Object pattern, Object text, Object c$Eq, Object p$Mnstart, Object p$Mnend, Object t$Mnstart, Object t$Mnend) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    public static Object stringContainsCi$V(Object text, Object pattern, Object[] argsArray) {
        void rest;
        void p$Mnstart;
        void t$Mnstart;
        Object object2 = LList.makeList(argsArray, 0);
        LList maybe$Mnstarts$Plends = object2;
        object2 = srfi13.stringParseStart$PlEnd(string$Mncontains$Mnci, text, maybe$Mnstarts$Plends);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object t$Mnend = Values.getFromPosFinal(object2, n);
        Values values = srfi13.stringParseFinalStart$PlEnd(string$Mncontains$Mnci, pattern, rest);
        int n2 = 0;
        n2 = Values.incrPos(values, n2);
        Object object5 = Values.getFromPos(values, n2);
        n2 = Values.incrPos(values, n2);
        Object p$Mnend = Values.getFromPosFinal(values, n2);
        return srfi13.$PcKmpSearch(pattern, text, strings.char$Mnci$Eq$Qu, p$Mnstart, p$Mnend, t$Mnstart, t$Mnend);
    }

    /*
     * Exception decompiling
     */
    public static FVector makeKmpRestartVector$V(Object pattern, Object[] argsArray) {
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

    /*
     * Exception decompiling
     */
    public static Object kmpStep(Object pat, Object rv, Object c, Object i, Object c$Eq, Object p$Mnstart) {
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

    /*
     * Exception decompiling
     */
    public static Object stringKmpPartialSearch$V(Object pat, Object rv, Object s, Object i, Object[] argsArray) {
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

    public static boolean isStringNull(Object s) {
        Object object2 = Promise.force(s, CharSequence.class);
        try {
            return numbers.isZero(strings.stringLength((CharSequence)object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-length", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public static FString stringReverse$V(Object s, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object stringReverse$Ex$V(Object s, Object[] argsArray) {
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

    /*
     * Exception decompiling
     */
    public static FString reverseList$To$String(Object clist) {
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

    public static Object stringAppend$SlShared$V(Object[] argsArray) {
        LList lList;
        LList strings2 = lList = LList.makeList(argsArray, 0);
        return srfi13.stringConcatenate$SlShared(strings2);
    }

    /*
     * Exception decompiling
     */
    public static Object stringConcatenate$SlShared(Object strings) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public static FString stringConcatenate(Object strings) {
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static FString stringConcatenateReverse$V(Object string$Mnlist, Object[] argsArray) {
        Object end;
        String string;
        Object object32;
        IntNum sum;
        Object len;
        void lis;
        block63 : {
            Object object22;
            LList maybe$Mnfinal$Plend;
            Object object2;
            Object object3;
            block62 : {
                Object object4;
                Object object5;
                Object object6;
                LList lList = LList.makeList(argsArray, 0);
                maybe$Mnfinal$Plend = lList;
                if (!lists.isNull(maybe$Mnfinal$Plend)) {
                    LList lList2 = maybe$Mnfinal$Plend;
                    object4 = lists.car((Pair)lList2);
                }
                object4 = string = "";
                if (!strings.isString(string)) {
                    string = "";
                }
                if (!lists.isNull(maybe$Mnfinal$Plend)) {
                    object22 = maybe$Mnfinal$Plend;
                    object5 = lists.cdr((Pair)object22);
                }
                object5 = maybe$Mnfinal$Plend;
                if (!lists.isNull(object5)) {
                    Pair pair;
                    if (!lists.isNull(maybe$Mnfinal$Plend)) {
                        object22 = maybe$Mnfinal$Plend;
                        object22 = Promise.force(lists.cdr((Pair)object22), Pair.class);
                        pair = (Pair)object22;
                    }
                    object22 = maybe$Mnfinal$Plend;
                    pair = (Pair)object22;
                    object6 = lists.car(pair);
                } else {
                    object22 = Promise.force(string, CharSequence.class);
                    object6 = end = Integer.valueOf(strings.stringLength((CharSequence)object22));
                }
                if (numbers.isInteger(end) && numbers.isExact(end)) {
                    object22 = Promise.force(string, CharSequence.class);
                    if (NumberCompare.$Ls$Eq$V(Lit0, end, strings.stringLength((CharSequence)object22), new Object[0])) break block62;
                }
                object22 = Promise.force(string, CharSequence.class);
                try {
                    end = strings.stringLength((CharSequence)object22);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "string-length", 1, len);
                }
            }
            if (!lists.isNull(maybe$Mnfinal$Plend)) {
                object22 = maybe$Mnfinal$Plend;
                object2 = lists.cdr((Pair)object22);
            }
            object2 = maybe$Mnfinal$Plend;
            if (!lists.isNull(object2)) {
                Pair pair;
                if (!lists.isNull(maybe$Mnfinal$Plend)) {
                    object22 = maybe$Mnfinal$Plend;
                    object22 = Promise.force(lists.cdr((Pair)object22), Pair.class);
                    pair = (Pair)object22;
                }
                object22 = maybe$Mnfinal$Plend;
                pair = (Pair)object22;
                object3 = lists.cdr(pair);
            } else {
                if (!lists.isNull(maybe$Mnfinal$Plend)) {
                    object22 = maybe$Mnfinal$Plend;
                    object3 = lists.cdr((Pair)object22);
                }
                object3 = maybe$Mnfinal$Plend;
            }
            if (!lists.isNull(object3)) {
                Object object7;
                Object object8;
                Object[] arrobject = new Object[2];
                arrobject[0] = "too many arguments";
                if (!lists.isNull(maybe$Mnfinal$Plend)) {
                    len = maybe$Mnfinal$Plend;
                    object8 = lists.cdr((Pair)len);
                }
                object8 = maybe$Mnfinal$Plend;
                if (!lists.isNull(object8)) {
                    Pair pair;
                    if (!lists.isNull(maybe$Mnfinal$Plend)) {
                        len = maybe$Mnfinal$Plend;
                        len = Promise.force(lists.cdr((Pair)len), Pair.class);
                        pair = (Pair)len;
                    }
                    len = maybe$Mnfinal$Plend;
                    pair = (Pair)len;
                    object7 = lists.cdr(pair);
                } else {
                    if (!lists.isNull(maybe$Mnfinal$Plend)) {
                        len = maybe$Mnfinal$Plend;
                        object7 = lists.cdr((Pair)len);
                    }
                    object7 = maybe$Mnfinal$Plend;
                }
                arrobject[1] = object7;
                Type.NeverReturns neverReturns = exceptions.error(arrobject);
                throw Special.reachedUnexpected;
            }
            break block63;
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, end);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "string-length", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "string-length", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, len);
            }
        }
        Object object9 = Lit0;
        Object object10 = string$Mnlist;
        do {
            Object object11 = object10;
            sum = object9;
            if (!lists.isPair(lis)) {
                len = sum;
                return srfi13.$PcFinishStringConcatenateReverse(len, string$Mnlist, string, end);
            }
            object32 = Promise.force(lis, Pair.class);
            object32 = Promise.force(lists.car((Pair)object32), CharSequence.class);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object32);
        }
        {
            object9 = AddOp.apply2(1, sum, strings.stringLength((CharSequence)object32));
            object32 = Promise.force(lis, Pair.class);
            object10 = lists.cdr((Pair)object32);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-length", 1, object32);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object32);
        }
    }

    /*
     * Exception decompiling
     */
    public static FString $PcFinishStringConcatenateReverse(Object len, Object string$Mnlist, Object final, Object end) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object stringConcatenateReverse$SlShared$V(Object string$Mnlist, Object[] argsArray) {
        Object object22;
        String string;
        Object len;
        Object end;
        Object object2;
        void nzlist;
        block73 : {
            Object slen22222222;
            block72 : {
                block74 : {
                    Object object6;
                    Object object3;
                    Object object4;
                    LList maybe$Mnfinal$Plend;
                    block71 : {
                        Object object5;
                        Object object7;
                        Object object8;
                        LList lList = LList.makeList(argsArray, 0);
                        maybe$Mnfinal$Plend = lList;
                        if (!lists.isNull(maybe$Mnfinal$Plend)) {
                            LList lList2 = maybe$Mnfinal$Plend;
                            object8 = lists.car((Pair)lList2);
                        }
                        object8 = string = "";
                        if (!strings.isString(string)) {
                            string = "";
                        }
                        if (!lists.isNull(maybe$Mnfinal$Plend)) {
                            object6 = maybe$Mnfinal$Plend;
                            object5 = lists.cdr((Pair)object6);
                        }
                        object5 = maybe$Mnfinal$Plend;
                        if (!lists.isNull(object5)) {
                            Pair pair;
                            if (!lists.isNull(maybe$Mnfinal$Plend)) {
                                object6 = maybe$Mnfinal$Plend;
                                object6 = Promise.force(lists.cdr((Pair)object6), Pair.class);
                                pair = (Pair)object6;
                            }
                            object6 = maybe$Mnfinal$Plend;
                            pair = (Pair)object6;
                            object7 = lists.car(pair);
                        } else {
                            object6 = Promise.force(string, CharSequence.class);
                            object7 = end = Integer.valueOf(strings.stringLength((CharSequence)object6));
                        }
                        if (numbers.isInteger(end) && numbers.isExact(end)) {
                            object6 = Promise.force(string, CharSequence.class);
                            if (NumberCompare.$Ls$Eq$V(Lit0, end, strings.stringLength((CharSequence)object6), new Object[0])) break block71;
                        }
                        object6 = Promise.force(string, CharSequence.class);
                        try {
                            end = strings.stringLength((CharSequence)object6);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "string-length", 1, len);
                        }
                    }
                    if (!lists.isNull(maybe$Mnfinal$Plend)) {
                        object6 = maybe$Mnfinal$Plend;
                        object3 = lists.cdr((Pair)object6);
                    }
                    object3 = maybe$Mnfinal$Plend;
                    if (!lists.isNull(object3)) {
                        Pair pair;
                        if (!lists.isNull(maybe$Mnfinal$Plend)) {
                            object6 = maybe$Mnfinal$Plend;
                            object6 = Promise.force(lists.cdr((Pair)object6), Pair.class);
                            pair = (Pair)object6;
                        }
                        object6 = maybe$Mnfinal$Plend;
                        pair = (Pair)object6;
                        object4 = lists.cdr(pair);
                    } else {
                        if (!lists.isNull(maybe$Mnfinal$Plend)) {
                            object6 = maybe$Mnfinal$Plend;
                            object4 = lists.cdr((Pair)object6);
                        }
                        object4 = maybe$Mnfinal$Plend;
                    }
                    if (!lists.isNull(object4)) {
                        Object object9;
                        Object object10;
                        Object[] arrobject = new Object[2];
                        arrobject[0] = "too many arguments";
                        if (!lists.isNull(maybe$Mnfinal$Plend)) {
                            len = maybe$Mnfinal$Plend;
                            object10 = lists.cdr((Pair)len);
                        }
                        object10 = maybe$Mnfinal$Plend;
                        if (!lists.isNull(object10)) {
                            Pair pair;
                            if (!lists.isNull(maybe$Mnfinal$Plend)) {
                                len = maybe$Mnfinal$Plend;
                                len = Promise.force(lists.cdr((Pair)len), Pair.class);
                                pair = (Pair)len;
                            }
                            len = maybe$Mnfinal$Plend;
                            pair = (Pair)len;
                            object9 = lists.cdr(pair);
                        } else {
                            if (!lists.isNull(maybe$Mnfinal$Plend)) {
                                len = maybe$Mnfinal$Plend;
                                object9 = lists.cdr((Pair)len);
                            }
                            object9 = maybe$Mnfinal$Plend;
                        }
                        arrobject[1] = object9;
                        Type.NeverReturns neverReturns = exceptions.error(arrobject);
                        throw Special.reachedUnexpected;
                    }
                    break block74;
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, end);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "string-length", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "string-length", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, len);
                    }
                }
                Object object11 = Lit0;
                Boolean bl = Boolean.FALSE;
                Object object12 = string$Mnlist;
                do {
                    void lis;
                    Object object14 = object12;
                    Boolean bl2 = bl;
                    len = object11;
                    if (!lists.isPair(lis)) break;
                    object22 = Promise.force(lis, Pair.class);
                    object22 = Promise.force(lists.car((Pair)object22), CharSequence.class);
                    int slen22222222 = strings.stringLength((CharSequence)object22);
                    object11 = AddOp.apply2(1, len, slen22222222);
                    bl = (KawaConvert.isTrue(nzlist) ? KawaConvert.isTrue(nzlist) : numbers.isZero(slen22222222)) ? nzlist : lis;
                    object22 = Promise.force(lis, Pair.class);
                    object12 = lists.cdr((Pair)object22);
                    continue;
                    break;
                } while (true);
                slen22222222 = Promise.force(len, Number.class);
                try {
                    if (!numbers.isZero((Number)slen22222222)) break block72;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "zero?", 1, slen22222222);
                }
                object2 = srfi13.substring$SlShared$V(string, Lit0, new Object[]{end});
                return object2;
            }
            slen22222222 = Promise.force(end, Number.class);
            try {
                if (!numbers.isZero((Number)slen22222222)) break block73;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "zero?", 1, slen22222222);
            }
            slen22222222 = Promise.force(nzlist, Pair.class);
            try {
                slen22222222 = Promise.force(lists.car((Pair)slen22222222), CharSequence.class);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, slen22222222);
            }
            try {
                if (!NumberCompare.$Eq(len, strings.stringLength((CharSequence)slen22222222))) break block73;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "string-length", 1, slen22222222);
            }
            slen22222222 = Promise.force(nzlist, Pair.class);
            try {
                object2 = lists.car((Pair)slen22222222);
                return object2;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, slen22222222);
            }
        }
        object2 = srfi13.$PcFinishStringConcatenateReverse(len, nzlist, string, end);
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object22);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-length", 1, object22);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object22);
        }
    }

    /*
     * Exception decompiling
     */
    public static FString stringReplace$V(Object s1, Object s2, Object start1, Object end1, Object[] argsArray) {
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

    /*
     * Exception decompiling
     */
    public static Object stringTokenize$V(Object s, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public static CharSequence xsubstring$V(Object s, Object from, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object $PcMultispanRepcopy$Ex(Object target, Object tstart, Object s, Object sfrom, Object sto, Object start, Object end) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 5 blocks at once
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

    /*
     * Exception decompiling
     */
    public static Object stringXcopy$Ex$V(Object target, Object tstart, Object s, Object sfrom, Object[] argsArray) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 5 blocks at once
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

    static boolean lambda41(Object val) {
        return numbers.isInteger(val) ? numbers.isExact(val) : false;
    }

    static boolean lambda42(Object val) {
        return numbers.isInteger(val) ? numbers.isExact(val) : false;
    }

    /*
     * Exception decompiling
     */
    public static Object stringJoin$V(Object strings, Object[] argsArray) {
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
        Lit139 = Symbol.valueOf("x");
        Lit138 = Symbol.valueOf("car");
        Lit137 = Symbol.valueOf("null?");
        Lit136 = Symbol.valueOf("if");
        Lit135 = Symbol.valueOf("let");
        Lit134 = Symbol.valueOf("receive");
        Lit133 = Symbol.valueOf("rest");
        Lit132 = new Object[0];
        Lit131 = Symbol.valueOf("string-join");
        Lit130 = Symbol.valueOf("%multispan-repcopy!");
        Lit129 = Symbol.valueOf("string-xcopy!");
        Lit128 = Symbol.valueOf("xsubstring");
        Lit127 = Symbol.valueOf("string-tokenize");
        Lit126 = Symbol.valueOf("string-replace");
        Lit125 = Symbol.valueOf("%finish-string-concatenate-reverse");
        Lit124 = Symbol.valueOf("string-concatenate-reverse/shared");
        Lit123 = Symbol.valueOf("string-concatenate-reverse");
        Lit122 = Symbol.valueOf("string-concatenate");
        Lit121 = Symbol.valueOf("string-concatenate/shared");
        Lit120 = Symbol.valueOf("string-append/shared");
        Lit119 = Symbol.valueOf("reverse-list->string");
        Lit118 = Symbol.valueOf("string-reverse!");
        Lit117 = Symbol.valueOf("string-reverse");
        Lit116 = Symbol.valueOf("string-null?");
        Lit115 = Symbol.valueOf("string-kmp-partial-search");
        Lit114 = Symbol.valueOf("kmp-step");
        Lit113 = Symbol.valueOf("make-kmp-restart-vector");
        Lit112 = Symbol.valueOf("%kmp-search");
        Lit111 = Symbol.valueOf("string-contains-ci");
        Lit110 = Symbol.valueOf("string-contains");
        Lit109 = Symbol.valueOf("string-count");
        Lit108 = Symbol.valueOf("string-skip-right");
        Lit107 = Symbol.valueOf("string-skip");
        Lit106 = Symbol.valueOf("string-index-right");
        Lit105 = Symbol.valueOf("string-index");
        Lit104 = Symbol.valueOf("string-filter");
        Lit103 = Symbol.valueOf("string-delete");
        Lit102 = Symbol.valueOf("string-pad");
        Lit101 = Symbol.valueOf("string-pad-right");
        Lit100 = Symbol.valueOf("string-trim-both");
        Lit99 = Symbol.valueOf("string-trim-right");
        Lit98 = Symbol.valueOf("string-trim");
        Lit97 = Symbol.valueOf("string-drop-right");
        Lit96 = Symbol.valueOf("string-drop");
        Lit95 = Symbol.valueOf("string-take-right");
        Lit94 = Symbol.valueOf("string-take");
        Lit93 = Symbol.valueOf("string-titlecase");
        Lit92 = Symbol.valueOf("string-titlecase!");
        Lit91 = Symbol.valueOf("%string-titlecase!");
        Lit90 = Symbol.valueOf("string-downcase!");
        Lit89 = Symbol.valueOf("string-downcase");
        Lit88 = Symbol.valueOf("string-upcase!");
        Lit87 = Symbol.valueOf("string-upcase");
        Lit86 = Symbol.valueOf("string-hash-ci");
        Lit85 = Symbol.valueOf("string-hash");
        Lit84 = Symbol.valueOf("%string-hash");
        Lit83 = Symbol.valueOf("string-ci>=");
        Lit82 = Symbol.valueOf("string-ci<=");
        Lit81 = Symbol.valueOf("string-ci>");
        Lit80 = Symbol.valueOf("string-ci<");
        Lit79 = Symbol.valueOf("string-ci<>");
        Lit78 = Symbol.valueOf("string-ci=");
        Lit77 = Symbol.valueOf("string>=");
        Lit76 = Symbol.valueOf("string<=");
        Lit75 = Symbol.valueOf("string>");
        Lit74 = Symbol.valueOf("string<");
        Lit73 = Symbol.valueOf("string<>");
        Lit72 = Symbol.valueOf("string=");
        Lit71 = Symbol.valueOf("string-compare-ci");
        Lit70 = Symbol.valueOf("string-compare");
        Lit69 = Symbol.valueOf("%string-compare-ci");
        Lit68 = Symbol.valueOf("%string-compare");
        Lit67 = Symbol.valueOf("%string-suffix-ci?");
        Lit66 = Symbol.valueOf("%string-prefix-ci?");
        Lit65 = Symbol.valueOf("%string-suffix?");
        Lit64 = Symbol.valueOf("%string-prefix?");
        Lit63 = Symbol.valueOf("string-suffix-ci?");
        Lit62 = Symbol.valueOf("string-prefix-ci?");
        Lit61 = Symbol.valueOf("string-suffix?");
        Lit60 = Symbol.valueOf("string-prefix?");
        Lit59 = Symbol.valueOf("string-suffix-length-ci");
        Lit58 = Symbol.valueOf("string-prefix-length-ci");
        Lit57 = Symbol.valueOf("string-suffix-length");
        Lit56 = Symbol.valueOf("string-prefix-length");
        Lit55 = Symbol.valueOf("%string-suffix-length-ci");
        Lit54 = Symbol.valueOf("%string-prefix-length-ci");
        Lit53 = Symbol.valueOf("%string-suffix-length");
        Lit52 = Symbol.valueOf("%string-prefix-length");
        Lit51 = Symbol.valueOf("string-tabulate");
        Lit50 = Symbol.valueOf("string-any");
        Lit49 = Symbol.valueOf("string-every");
        Lit48 = Symbol.valueOf("string-unfold-right");
        Lit47 = Symbol.valueOf("string-unfold");
        Lit46 = Symbol.valueOf("string-fold-right");
        Lit45 = Symbol.valueOf("string-fold");
        Lit44 = Symbol.valueOf("%string-map!");
        Lit43 = Symbol.valueOf("string-map!");
        Lit42 = Symbol.valueOf("%string-map");
        Lit41 = Symbol.valueOf("string-map");
        Lit40 = Symbol.valueOf("%substring/shared");
        Lit39 = Symbol.valueOf("substring/shared");
        Lit38 = Symbol.valueOf("check-substring-spec");
        Lit37 = Symbol.valueOf("substring-spec-ok?");
        Lit36 = Symbol.valueOf("string-parse-final-start+end");
        Lit35 = Symbol.valueOf("%check-bounds");
        Lit34 = Symbol.valueOf("string-parse-start+end");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject = new Object[5];
        arrobject[0] = Lit135;
        arrobject[1] = Symbol.valueOf("procv");
        Lit30 = Symbol.valueOf("let-string-start+end");
        arrobject[2] = Lit30;
        arrobject[3] = PairWithPosition.make(Lit133, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm", 725035);
        arrobject[4] = Lit133;
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u000f\f\u0017\f\u001f\b\f'\f/\f7\f?\rG@\b\b", Lit132, 9, "srfi13.scm:175"), "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b#\b\u0011\u0018\u00141\t\u0003\t\u000b\u0018\u001c\u0011\u0018\f\t+\t;\b\u0011\u0018\u0014!\t\u0013\b\u001b\u0011\u0018\f\t3\u0011\u0018$\bEC", arrobject, 1);
        Lit32 = Symbol.valueOf("let-string-start+end2");
        Lit33 = new SyntaxRules(Lit132, arrsyntaxRule, 9, Lit32);
        Lit31 = new SyntaxRules(Lit132, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018,\f\u0007\f\u000f\b\f\u0017\f\u001f\f'\r/(\b\b", Lit132, 6, "srfi13.scm:164"), "\u0001\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004!\t\u0003\b\u000bI\u0011\u0018\f\t\u0013\t\u001b\b#\b-+", new Object[]{Lit134, Lit36}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u000f\f\u0017\b\f\u001f\f'\f/\r70\b\b", Lit132, 7, "srfi13.scm:167"), "\u0001\u0001\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\t\u0013\t\u0003\b\u000bI\u0011\u0018\f\t\u001b\t#\b+\b53", new Object[]{Lit134, Lit34}, 1)}, 7, Lit30);
        Lit29 = Symbol.valueOf("char-cased?");
        Object[] arrobject2 = new Object[3];
        arrobject2[0] = Lit134;
        arrobject2[1] = Symbol.valueOf("r");
        Lit15 = Symbol.valueOf("let-optionals*");
        arrobject2[2] = Lit15;
        Lit28 = new SyntaxTemplate("\u0001\u0001\u0003\u0001\u0003\u0003", "\u0011\u0018\u0004A\u0011\u0018\f\t\u000b\b\u0015\u0013!\t\u001b\b\u0003\b\u0011\u0018\u0014\u0011\u0018\f\u0019\b%#\b-+", arrobject2, 1);
        Lit27 = new SyntaxPattern("\f\u0018\f\u0007\u008c\\<\f\u000f\r\u0017\u0010\b\b\f\u001f\b\r' \b\b\r/(\b\b", Lit132, 6, "srfi13.scm:149");
        Lit26 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004\u00c9\b\t\u000b\b\u0011\u0018\fI\u0011\u0018\u0014\b\u0011\u0018\u001c\b\u0003)\u0011\u0018$\b\u0003\b\u0013\u0089\u0011\u0018,)\u0011\u0018\u0014\b\u001b\b\u0011\u00184\t\u000b\b\u0013\b\u0011\u0018<\u00a9\u0011\u0018\fI\u0011\u0018\u0014\b\u0011\u0018\u001c\b\u0003)\u0011\u0018D\b\u0003\b\u0003\u0019\b%#\b-+", new Object[]{Lit135, Lit136, Symbol.valueOf("not"), Lit137, Lit138, Symbol.valueOf("when"), Symbol.valueOf("set!"), Lit15, Symbol.valueOf("cdr")}, 1);
        Lit25 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0003\u0003", "\u000b", Lit132, 0);
        Lit24 = new SyntaxPattern("\f\u0018\f\u0007l<\f\u000f\f\u0017\f\u001f\b\r' \b\b\r/(\b\b", Lit132, 6, "srfi13.scm:142");
        Lit23 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004\t\u0003Q1\t\u000b\t\u0013\u0018\f\b\u001d\u001b\b%#", new Object[]{Lit15, PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm", 577583)}, 1);
        Lit22 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0003", "\u000b", Lit132, 0);
        Lit21 = new SyntaxPattern("\f\u0018\f\u0007\\,\f\u000f\f\u0017\b\r\u001f\u0018\b\b\r' \b\b", Lit132, 5, "srfi13.scm:139");
        Lit20 = new SyntaxTemplate("\u0001\u0001\u0003", "\u0011\u0018\u0004)\b\t\u000b\b\u0003\b\u0015\u0013", new Object[]{Lit135}, 1);
        Lit19 = new SyntaxTemplate("\u0001\u0001\u0003", "\u000b", Lit132, 0);
        Lit18 = new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\r\u0017\u0010\b\b", Lit132, 3, "srfi13.scm:137");
        Lit17 = new SyntaxTemplate("\u0001\u0003", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003A\u0011\u0018\u0014\t\u0010\b\r\u000b\b\u0011\u0018\u001c\t$\b\u0003", new Object[]{Lit136, Lit137, Lit135, Symbol.valueOf("error"), "too many arguments"}, 1);
        Lit16 = new SyntaxPattern("\f\u0018\f\u0007\f\b\r\u000f\b\b\b", Lit132, 2, "srfi13.scm:133");
        Lit13 = Symbol.valueOf(":optional");
        Lit14 = new SyntaxRules(Lit132, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit132, 3, "srfi13.scm:126"), "\u0001\u0001\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\t\u000b\b\u0011\u0018\u0014Q\b\u0011\u0018\u001c\b\u0011\u0018$\b\u0003\b\u0011\u0018\u0004!\t\u0013\u0018,\u0011\u0018\u001c\b\u000b", new Object[]{Lit136, Lit137, Lit135, Lit139, Lit138, PairWithPosition.make(Lit139, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm", 528407)}, 0)}, 3, Lit13);
        Lit12 = Symbol.valueOf("suffix");
        Lit11 = Symbol.valueOf("prefix");
        Lit10 = Symbol.valueOf("strict-infix");
        Lit9 = Symbol.valueOf("infix");
        Lit8 = IntNum.valueOf(-1);
        Lit7 = Char.valueOf(32);
        Lit6 = IntNum.valueOf(4194304);
        Lit5 = IntNum.valueOf(37);
        Lit4 = IntNum.valueOf(65536);
        Lit3 = IntNum.valueOf(40);
        Lit2 = IntNum.valueOf(4096);
        Lit1 = IntNum.valueOf(1);
        Lit0 = IntNum.valueOf(0);
        $instance = new srfi13();
        $Cloptional = Macro.make(Lit13, Lit14, "gnu.kawa.slib.srfi13");
        srfi13 srfi132 = $instance;
        let$Mnoptionals$St = Macro.make(Lit15, new ModuleMethod(srfi132, 13, null, 4097), "gnu.kawa.slib.srfi13");
        srfi13 srfi133 = $instance;
        char$Mncased$Qu = new ModuleMethod(srfi133, 14, Lit29, 4097);
        let$Mnstring$Mnstart$Plend = Macro.make(Lit30, Lit31, "gnu.kawa.slib.srfi13");
        let$Mnstring$Mnstart$Plend2 = Macro.make(Lit32, Lit33, "gnu.kawa.slib.srfi13");
        string$Mnparse$Mnstart$Plend = new ModuleMethod(srfi133, 15, Lit34, 12291);
        $Pccheck$Mnbounds = new ModuleMethod(srfi133, 16, Lit35, 16388);
        string$Mnparse$Mnfinal$Mnstart$Plend = new ModuleMethod(srfi133, 17, Lit36, 12291);
        substring$Mnspec$Mnok$Qu = new ModuleMethod(srfi133, 18, Lit37, 12291);
        check$Mnsubstring$Mnspec = new ModuleMethod(srfi133, 19, Lit38, 16388);
        ModuleMethod moduleMethod = new ModuleMethod(srfi133, 20, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:266");
        lambda$Fn1 = moduleMethod;
        substring$Slshared = new ModuleMethod(srfi133, 21, Lit39, -4094);
        $Pcsubstring$Slshared = new ModuleMethod(srfi133, 22, Lit40, 12291);
        string$Mncopy = StaticFieldLocation.make("kawa.lib.strings", "string$Mncopy");
        string$Mnmap = new ModuleMethod(srfi133, 23, Lit41, -4094);
        $Pcstring$Mnmap = new ModuleMethod(srfi133, 24, Lit42, 16388);
        string$Mnmap$Ex = new ModuleMethod(srfi133, 25, Lit43, -4094);
        $Pcstring$Mnmap$Ex = new ModuleMethod(srfi133, 26, Lit44, 16388);
        string$Mnfold = new ModuleMethod(srfi133, 27, Lit45, -4093);
        string$Mnfold$Mnright = new ModuleMethod(srfi133, 28, Lit46, -4093);
        ModuleMethod moduleMethod2 = new ModuleMethod(srfi133, 29, null, 4097);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:423");
        lambda$Fn2 = moduleMethod2;
        ModuleMethod moduleMethod3 = new ModuleMethod(srfi133, 30, null, 4097);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:423");
        lambda$Fn3 = moduleMethod3;
        string$Mnunfold = new ModuleMethod(srfi133, 31, Lit47, -4092);
        ModuleMethod moduleMethod4 = new ModuleMethod(srfi133, 32, null, 4097);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:468");
        lambda$Fn4 = moduleMethod4;
        ModuleMethod moduleMethod5 = new ModuleMethod(srfi133, 33, null, 4097);
        moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:468");
        lambda$Fn5 = moduleMethod5;
        string$Mnunfold$Mnright = new ModuleMethod(srfi133, 34, Lit48, -4092);
        string$Mnfor$Mneach = StaticFieldLocation.make("kawa.lib.strings", "srfi$Mn13$Mnstring$Mnfor$Mneach");
        string$Mnevery = new ModuleMethod(srfi133, 35, Lit49, -4094);
        string$Mnany = new ModuleMethod(srfi133, 36, Lit50, -4094);
        ModuleMethod moduleMethod6 = new ModuleMethod(srfi133, 37, null, 4097);
        moduleMethod6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:584");
        lambda$Fn6 = moduleMethod6;
        string$Mntabulate = new ModuleMethod(srfi133, 38, Lit51, 8194);
        $Pcstring$Mnprefix$Mnlength = new ModuleMethod(srfi133, 39, Lit52, 24582);
        $Pcstring$Mnsuffix$Mnlength = new ModuleMethod(srfi133, 40, Lit53, 24582);
        $Pcstring$Mnprefix$Mnlength$Mnci = new ModuleMethod(srfi133, 41, Lit54, 24582);
        $Pcstring$Mnsuffix$Mnlength$Mnci = new ModuleMethod(srfi133, 42, Lit55, 24582);
        string$Mnprefix$Mnlength = new ModuleMethod(srfi133, 43, Lit56, -4094);
        string$Mnsuffix$Mnlength = new ModuleMethod(srfi133, 44, Lit57, -4094);
        string$Mnprefix$Mnlength$Mnci = new ModuleMethod(srfi133, 45, Lit58, -4094);
        string$Mnsuffix$Mnlength$Mnci = new ModuleMethod(srfi133, 46, Lit59, -4094);
        string$Mnprefix$Qu = new ModuleMethod(srfi133, 47, Lit60, -4094);
        string$Mnsuffix$Qu = new ModuleMethod(srfi133, 48, Lit61, -4094);
        string$Mnprefix$Mnci$Qu = new ModuleMethod(srfi133, 49, Lit62, -4094);
        string$Mnsuffix$Mnci$Qu = new ModuleMethod(srfi133, 50, Lit63, -4094);
        $Pcstring$Mnprefix$Qu = new ModuleMethod(srfi133, 51, Lit64, 24582);
        $Pcstring$Mnsuffix$Qu = new ModuleMethod(srfi133, 52, Lit65, 24582);
        $Pcstring$Mnprefix$Mnci$Qu = new ModuleMethod(srfi133, 53, Lit66, 24582);
        $Pcstring$Mnsuffix$Mnci$Qu = new ModuleMethod(srfi133, 54, Lit67, 24582);
        $Pcstring$Mncompare = new ModuleMethod(srfi133, 55, Lit68, 36873);
        $Pcstring$Mncompare$Mnci = new ModuleMethod(srfi133, 56, Lit69, 36873);
        string$Mncompare = new ModuleMethod(srfi133, 57, Lit70, -4091);
        string$Mncompare$Mnci = new ModuleMethod(srfi133, 58, Lit71, -4091);
        ModuleMethod moduleMethod7 = new ModuleMethod(srfi133, 59, null, 4097);
        moduleMethod7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:805");
        lambda$Fn7 = moduleMethod7;
        ModuleMethod moduleMethod8 = new ModuleMethod(srfi133, 60, null, 4097);
        moduleMethod8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:807");
        lambda$Fn8 = moduleMethod8;
        string$Eq = new ModuleMethod(srfi133, 61, Lit72, -4094);
        ModuleMethod moduleMethod9 = new ModuleMethod(srfi133, 62, null, 4097);
        moduleMethod9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:816");
        lambda$Fn9 = moduleMethod9;
        string$Ls$Gr = new ModuleMethod(srfi133, 63, Lit73, -4094);
        ModuleMethod moduleMethod10 = new ModuleMethod(srfi133, 64, null, 4097);
        moduleMethod10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:827");
        lambda$Fn10 = moduleMethod10;
        ModuleMethod moduleMethod11 = new ModuleMethod(srfi133, 65, null, 4097);
        moduleMethod11.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:828");
        lambda$Fn11 = moduleMethod11;
        string$Ls = new ModuleMethod(srfi133, 66, Lit74, -4094);
        ModuleMethod moduleMethod12 = new ModuleMethod(srfi133, 67, null, 4097);
        moduleMethod12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:837");
        lambda$Fn12 = moduleMethod12;
        ModuleMethod moduleMethod13 = new ModuleMethod(srfi133, 68, null, 4097);
        moduleMethod13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:838");
        lambda$Fn13 = moduleMethod13;
        string$Gr = new ModuleMethod(srfi133, 69, Lit75, -4094);
        ModuleMethod moduleMethod14 = new ModuleMethod(srfi133, 70, null, 4097);
        moduleMethod14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:850");
        lambda$Fn14 = moduleMethod14;
        string$Ls$Eq = new ModuleMethod(srfi133, 71, Lit76, -4094);
        ModuleMethod moduleMethod15 = new ModuleMethod(srfi133, 72, null, 4097);
        moduleMethod15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:859");
        lambda$Fn15 = moduleMethod15;
        string$Gr$Eq = new ModuleMethod(srfi133, 73, Lit77, -4094);
        ModuleMethod moduleMethod16 = new ModuleMethod(srfi133, 74, null, 4097);
        moduleMethod16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:869");
        lambda$Fn16 = moduleMethod16;
        ModuleMethod moduleMethod17 = new ModuleMethod(srfi133, 75, null, 4097);
        moduleMethod17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:871");
        lambda$Fn17 = moduleMethod17;
        string$Mnci$Eq = new ModuleMethod(srfi133, 76, Lit78, -4094);
        ModuleMethod moduleMethod18 = new ModuleMethod(srfi133, 77, null, 4097);
        moduleMethod18.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:880");
        lambda$Fn18 = moduleMethod18;
        string$Mnci$Ls$Gr = new ModuleMethod(srfi133, 78, Lit79, -4094);
        ModuleMethod moduleMethod19 = new ModuleMethod(srfi133, 79, null, 4097);
        moduleMethod19.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:891");
        lambda$Fn19 = moduleMethod19;
        ModuleMethod moduleMethod20 = new ModuleMethod(srfi133, 80, null, 4097);
        moduleMethod20.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:892");
        lambda$Fn20 = moduleMethod20;
        string$Mnci$Ls = new ModuleMethod(srfi133, 81, Lit80, -4094);
        ModuleMethod moduleMethod21 = new ModuleMethod(srfi133, 82, null, 4097);
        moduleMethod21.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:901");
        lambda$Fn21 = moduleMethod21;
        ModuleMethod moduleMethod22 = new ModuleMethod(srfi133, 83, null, 4097);
        moduleMethod22.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:902");
        lambda$Fn22 = moduleMethod22;
        string$Mnci$Gr = new ModuleMethod(srfi133, 84, Lit81, -4094);
        ModuleMethod moduleMethod23 = new ModuleMethod(srfi133, 85, null, 4097);
        moduleMethod23.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:914");
        lambda$Fn23 = moduleMethod23;
        string$Mnci$Ls$Eq = new ModuleMethod(srfi133, 86, Lit82, -4094);
        ModuleMethod moduleMethod24 = new ModuleMethod(srfi133, 87, null, 4097);
        moduleMethod24.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:923");
        lambda$Fn24 = moduleMethod24;
        string$Mnci$Gr$Eq = new ModuleMethod(srfi133, 88, Lit83, -4094);
        $Pcstring$Mnhash = new ModuleMethod(srfi133, 89, Lit84, 20485);
        string$Mnhash = new ModuleMethod(srfi133, 90, Lit85, -4095);
        ModuleMethod moduleMethod25 = new ModuleMethod(srfi133, 91, null, 4097);
        moduleMethod25.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:971");
        lambda$Fn25 = moduleMethod25;
        string$Mnhash$Mnci = new ModuleMethod(srfi133, 92, Lit86, -4095);
        string$Mnupcase = new ModuleMethod(srfi133, 93, Lit87, -4095);
        string$Mnupcase$Ex = new ModuleMethod(srfi133, 94, Lit88, -4095);
        string$Mndowncase = new ModuleMethod(srfi133, 95, Lit89, -4095);
        string$Mndowncase$Ex = new ModuleMethod(srfi133, 96, Lit90, -4095);
        $Pcstring$Mntitlecase$Ex = new ModuleMethod(srfi133, 97, Lit91, 12291);
        string$Mntitlecase$Ex = new ModuleMethod(srfi133, 98, Lit92, -4095);
        string$Mntitlecase = new ModuleMethod(srfi133, 99, Lit93, -4095);
        string$Mntake = new ModuleMethod(srfi133, 100, Lit94, 8194);
        string$Mntake$Mnright = new ModuleMethod(srfi133, 101, Lit95, 8194);
        string$Mndrop = new ModuleMethod(srfi133, 102, Lit96, 8194);
        string$Mndrop$Mnright = new ModuleMethod(srfi133, 103, Lit97, 8194);
        string$Mntrim = new ModuleMethod(srfi133, 104, Lit98, -4095);
        string$Mntrim$Mnright = new ModuleMethod(srfi133, 105, Lit99, -4095);
        string$Mntrim$Mnboth = new ModuleMethod(srfi133, 106, Lit100, -4095);
        ModuleMethod moduleMethod26 = new ModuleMethod(srfi133, 107, null, 4097);
        moduleMethod26.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1096");
        lambda$Fn30 = moduleMethod26;
        string$Mnpad$Mnright = new ModuleMethod(srfi133, 108, Lit101, -4094);
        ModuleMethod moduleMethod27 = new ModuleMethod(srfi133, 109, null, 4097);
        moduleMethod27.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1108");
        lambda$Fn31 = moduleMethod27;
        string$Mnpad = new ModuleMethod(srfi133, 110, Lit102, -4094);
        string$Mndelete = new ModuleMethod(srfi133, 111, Lit103, -4094);
        string$Mnfilter = new ModuleMethod(srfi133, 112, Lit104, -4094);
        string$Mnindex = new ModuleMethod(srfi133, 113, Lit105, -4094);
        string$Mnindex$Mnright = new ModuleMethod(srfi133, 114, Lit106, -4094);
        string$Mnskip = new ModuleMethod(srfi133, 115, Lit107, -4094);
        string$Mnskip$Mnright = new ModuleMethod(srfi133, 116, Lit108, -4094);
        string$Mncount = new ModuleMethod(srfi133, 117, Lit109, -4094);
        string$Mnfill$Ex = StaticFieldLocation.make("kawa.lib.strings", "string$Mnfill$Ex");
        string$Mncopy$Ex = StaticFieldLocation.make("kawa.lib.strings", "string$Mncopy$Ex");
        $Pcstring$Mncopy$Ex = StaticFieldLocation.make("kawa.lib.strings", "string$Mncopy$Ex");
        string$Mncontains = new ModuleMethod(srfi133, 118, Lit110, -4094);
        string$Mncontains$Mnci = new ModuleMethod(srfi133, 119, Lit111, -4094);
        $Pckmp$Mnsearch = new ModuleMethod(srfi133, 120, Lit112, 28679);
        make$Mnkmp$Mnrestart$Mnvector = new ModuleMethod(srfi133, 121, Lit113, -4095);
        kmp$Mnstep = new ModuleMethod(srfi133, 122, Lit114, 24582);
        string$Mnkmp$Mnpartial$Mnsearch = new ModuleMethod(srfi133, 123, Lit115, -4092);
        string$Mnnull$Qu = new ModuleMethod(srfi133, 124, Lit116, 4097);
        string$Mnreverse = new ModuleMethod(srfi133, 125, Lit117, -4095);
        string$Mnreverse$Ex = new ModuleMethod(srfi133, 126, Lit118, -4095);
        reverse$Mnlist$Mn$Grstring = new ModuleMethod(srfi133, 127, Lit119, 4097);
        string$Mn$Grlist = StaticFieldLocation.make("kawa.lib.strings", "string$Mn$Grlist");
        string$Mnappend$Slshared = new ModuleMethod(srfi133, 128, Lit120, -4096);
        string$Mnconcatenate$Slshared = new ModuleMethod(srfi133, 129, Lit121, 4097);
        string$Mnconcatenate = new ModuleMethod(srfi133, 130, Lit122, 4097);
        string$Mnconcatenate$Mnreverse = new ModuleMethod(srfi133, 131, Lit123, -4095);
        string$Mnconcatenate$Mnreverse$Slshared = new ModuleMethod(srfi133, 132, Lit124, -4095);
        $Pcfinish$Mnstring$Mnconcatenate$Mnreverse = new ModuleMethod(srfi133, 133, Lit125, 16388);
        string$Mnreplace = new ModuleMethod(srfi133, 134, Lit126, -4092);
        string$Mntokenize = new ModuleMethod(srfi133, 135, Lit127, -4095);
        ModuleMethod moduleMethod28 = new ModuleMethod(srfi133, 136, null, 4097);
        moduleMethod28.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1795");
        lambda$Fn39 = moduleMethod28;
        xsubstring = new ModuleMethod(srfi133, 137, Lit128, -4094);
        ModuleMethod moduleMethod29 = new ModuleMethod(srfi133, 138, null, 4097);
        moduleMethod29.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1836");
        lambda$Fn41 = moduleMethod29;
        ModuleMethod moduleMethod30 = new ModuleMethod(srfi133, 139, null, 4097);
        moduleMethod30.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1842");
        lambda$Fn42 = moduleMethod30;
        string$Mnxcopy$Ex = new ModuleMethod(srfi133, 140, Lit129, -4092);
        $Pcmultispan$Mnrepcopy$Ex = new ModuleMethod(srfi133, 141, Lit130, 28679);
        string$Mnjoin = new ModuleMethod(srfi133, 142, Lit131, -4095);
        srfi13.$runBody$();
    }

    public srfi13() {
        ModuleInfo.register(this);
    }

    static Object lambda45(Object form) {
        Object object2;
        TemplateScope templateScope;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(6, null);
        if (((Pattern)Lit16).match(form, arrobject, 0)) {
            TemplateScope templateScope2 = TemplateScope.make();
            object2 = Lit17.execute(arrobject, templateScope2);
        } else if (((Pattern)Lit18).match(form, arrobject, 0) && std_syntax.isIdentifier(Lit19.execute(arrobject, templateScope = TemplateScope.make()))) {
            templateScope = TemplateScope.make();
            object2 = Lit20.execute(arrobject, templateScope);
        } else if (((Pattern)Lit21).match(form, arrobject, 0) && std_syntax.isIdentifier(Lit22.execute(arrobject, templateScope = TemplateScope.make()))) {
            templateScope = TemplateScope.make();
            object2 = Lit23.execute(arrobject, templateScope);
        } else if (((Pattern)Lit24).match(form, arrobject, 0) && std_syntax.isIdentifier(Lit25.execute(arrobject, templateScope = TemplateScope.make()))) {
            templateScope = TemplateScope.make();
            object2 = Lit26.execute(arrobject, templateScope);
        } else if (((Pattern)Lit27).match(form, arrobject, 0)) {
            templateScope = TemplateScope.make();
            object2 = Lit28.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 13: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 139: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 138: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 136: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 130: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 129: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 127: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 124: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 109: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 107: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 91: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 87: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 85: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 83: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 82: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 80: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 79: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 77: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 75: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 74: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 72: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 70: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 68: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 67: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 65: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 64: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 62: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 60: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 59: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 37: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 33: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 32: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 30: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 29: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 20: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object3 = Promise.force(object2);
                if (Char.checkCharOrEof(object3) < 0) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 103: {
                Object object4 = Promise.force(object2, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 102: {
                Object object5 = Promise.force(object2, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 101: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 100: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 38: {
                callContext.value1 = object2;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 97: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 22: {
                Object object5 = Promise.force(object2, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 18: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 17: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 15: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 133: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 26: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 24: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 19: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 16: {
                callContext.value1 = object2;
                Object object6 = Promise.force(object3, CharSequence.class);
                if (!(object6 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 142: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 141: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 140: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 137: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 135: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 134: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 132: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 131: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 128: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 126: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 125: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 123: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 122: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 121: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 120: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 119: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 118: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 117: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 116: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 115: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 114: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 113: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 112: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 111: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 110: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 108: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 106: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 105: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 104: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 99: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 98: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 96: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 95: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 94: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 93: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 92: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 90: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 89: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 88: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 86: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 84: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 81: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 78: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 76: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 73: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 71: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 69: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 66: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 63: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 61: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 58: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 57: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 56: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 55: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 54: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 53: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 52: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 51: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 50: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 49: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 48: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 47: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 46: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 45: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 44: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 43: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 42: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 41: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 40: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 39: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 36: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 35: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 34: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 31: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 28: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 27: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 25: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 23: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 21: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 14: {
                Boolean bl;
                if (srfi13.isCharCased(Char.castToCharacter(Promise.force(object2)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 20: {
                Boolean bl;
                if (srfi13.lambda1(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 29: {
                return srfi13.lambda2(object2);
            }
            case 30: {
                return srfi13.lambda3(object2);
            }
            case 32: {
                return srfi13.lambda4(object2);
            }
            case 33: {
                return srfi13.lambda5(object2);
            }
            case 37: {
                Boolean bl;
                if (srfi13.lambda6(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 59: {
                Boolean bl;
                if (srfi13.lambda7(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 60: {
                Boolean bl;
                if (srfi13.lambda8(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 62: {
                Boolean bl;
                if (srfi13.lambda9(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 64: {
                Boolean bl;
                if (srfi13.lambda10(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 65: {
                Boolean bl;
                if (srfi13.lambda11(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 67: {
                Boolean bl;
                if (srfi13.lambda12(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 68: {
                Boolean bl;
                if (srfi13.lambda13(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 70: {
                Boolean bl;
                if (srfi13.lambda14(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 72: {
                Boolean bl;
                if (srfi13.lambda15(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 74: {
                Boolean bl;
                if (srfi13.lambda16(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 75: {
                Boolean bl;
                if (srfi13.lambda17(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 77: {
                Boolean bl;
                if (srfi13.lambda18(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 79: {
                Boolean bl;
                if (srfi13.lambda19(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 80: {
                Boolean bl;
                if (srfi13.lambda20(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 82: {
                Boolean bl;
                if (srfi13.lambda21(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 83: {
                Boolean bl;
                if (srfi13.lambda22(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 85: {
                Boolean bl;
                if (srfi13.lambda23(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 87: {
                Boolean bl;
                if (srfi13.lambda24(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 91: {
                return srfi13.lambda25(object2);
            }
            case 107: {
                Boolean bl;
                if (srfi13.lambda30(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 109: {
                Boolean bl;
                if (srfi13.lambda31(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 124: {
                Boolean bl;
                if (srfi13.isStringNull(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 127: {
                return srfi13.reverseList$To$String(object2);
            }
            case 129: {
                return srfi13.stringConcatenate$SlShared(object2);
            }
            case 130: {
                return srfi13.stringConcatenate(object2);
            }
            case 136: {
                Boolean bl;
                public class Frame6
                extends ModuleBody {
                    Object from;
                    final ModuleMethod lambda$Fn40;

                    public Frame6() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 12, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi13.scm:1801");
                        this.lambda$Fn40 = moduleMethod;
                    }

                    static boolean lambda39(Object val) {
                        return numbers.isInteger(val) ? numbers.isExact(val) : false;
                    }

                    boolean lambda40(Object val) {
                        return numbers.isInteger(val) ? (numbers.isExact(val) ? NumberCompare.$Ls$Eq(this.from, val) : false) : false;
                    }

                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                        if (moduleMethod.selector == 12) {
                            callContext.value1 = object2;
                            callContext.proc = moduleMethod;
                            callContext.pc = 1;
                            return 0;
                        }
                        return super.match1(moduleMethod, object2, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply1(ModuleMethod moduleMethod, Object object2) {
                        if (moduleMethod.selector == 12) {
                            return this.lambda40(object2) ? Boolean.TRUE : Boolean.FALSE;
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                if (Frame6.lambda39(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 138: {
                Boolean bl;
                if (srfi13.lambda41(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 139: {
                Boolean bl;
                if (srfi13.lambda42(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 13: {
                return srfi13.lambda45(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-cased?", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 38: {
                return srfi13.stringTabulate(object2, ((Number)Promise.force(object3)).intValue());
            }
            case 100: {
                return srfi13.stringTake(object2, object3);
            }
            case 101: {
                return srfi13.stringTakeRight(object2, object3);
            }
            case 102: {
                return srfi13.stringDrop((CharSequence)Promise.force(object2, CharSequence.class), object3);
            }
            case 103: {
                return srfi13.stringDropRight((CharSequence)Promise.force(object2, CharSequence.class), object3);
            }
        }
        return super.apply2(moduleMethod, object2, object3);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-tabulate", 2, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-drop", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-drop-right", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public Object apply4(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4, Object var5_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
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

    /*
     * Exception decompiling
     */
    public Object applyN(ModuleMethod var1_1, Object[] var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

}

