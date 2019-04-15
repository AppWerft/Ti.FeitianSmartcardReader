/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SourceName;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.slib.pregexp;
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
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.SourceType;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.append;

public class pregexp
extends ModuleBody {
    public static IntNum $Stpregexp$Mnversion$St;
    @SourceType(value="character")
    public static int $Stpregexp$Mncomment$Mnchar$St;
    public static int $Stpregexp$Mnnul$Mnchar$Mnint$St;
    @SourceType(value="character")
    public static int $Stpregexp$Mnreturn$Mnchar$St;
    @SourceType(value="character")
    public static int $Stpregexp$Mntab$Mnchar$St;
    public static Object $Stpregexp$Mnspace$Mnsensitive$Qu$St;
    public static final ModuleMethod pregexp$Mnreverse$Ex;
    public static ModuleMethod pregexp$Mnerror;
    public static final ModuleMethod pregexp$Mnread$Mnpattern;
    public static final ModuleMethod pregexp$Mnread$Mnbranch;
    public static final ModuleMethod pregexp$Mnread$Mnpiece;
    public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnnumber;
    public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnchar;
    public static final ModuleMethod pregexp$Mnread$Mnposix$Mnchar$Mnclass;
    public static final ModuleMethod pregexp$Mnread$Mncluster$Mntype;
    public static final ModuleMethod pregexp$Mnread$Mnsubpattern;
    public static final ModuleMethod pregexp$Mnwrap$Mnquantifier$Mnif$Mnany;
    public static final ModuleMethod pregexp$Mnread$Mnnums;
    public static final ModuleMethod pregexp$Mninvert$Mnchar$Mnlist;
    public static final ModuleMethod pregexp$Mnread$Mnchar$Mnlist;
    public static final ModuleMethod pregexp$Mnstring$Mnmatch;
    public static final ModuleMethod pregexp$Mnchar$Mnword$Qu;
    public static final ModuleMethod pregexp$Mnat$Mnword$Mnboundary$Qu;
    public static final ModuleMethod pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu;
    public static final ModuleMethod pregexp$Mnlist$Mnref;
    public static final ModuleMethod pregexp$Mnmake$Mnbackref$Mnlist;
    public static final ModuleMethod pregexp$Mnmatch$Mnpositions$Mnaux;
    public static final ModuleMethod pregexp$Mnreplace$Mnaux;
    public static final ModuleMethod pregexp;
    public static final ModuleMethod pregexp$Mnmatch$Mnpositions;
    public static final ModuleMethod pregexp$Mnmatch;
    public static final ModuleMethod pregexp$Mnsplit;
    public static final ModuleMethod pregexp$Mnreplace;
    public static final ModuleMethod pregexp$Mnreplace$St;
    public static final ModuleMethod pregexp$Mnquote;
    static final IntNum Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final IntNum Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final Char Lit10;
    static final IntNum Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final PairWithPosition Lit15;
    static final PairWithPosition Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final PairWithPosition Lit20;
    static final SimpleSymbol Lit21;
    static final Char Lit22;
    static final Char Lit23;
    static final SimpleSymbol Lit24;
    static final PairWithPosition Lit25;
    static final PairWithPosition Lit26;
    static final PairWithPosition Lit27;
    static final PairWithPosition Lit28;
    static final PairWithPosition Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final PairWithPosition Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final IntNum Lit40;
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
    static final ModuleMethod lambda$Fn1;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final PairWithPosition Lit64;
    static final ModuleMethod lambda$Fn4;
    static final SimpleSymbol Lit65;
    static final ModuleMethod lambda$Fn5;
    static final SimpleSymbol Lit66;
    static final ModuleMethod lambda$Fn9;
    static final SimpleSymbol Lit67;
    static final ModuleMethod lambda$Fn10;
    static final SimpleSymbol Lit68;
    static final ModuleMethod lambda$Fn11;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final PairWithPosition Lit73;
    static final Char Lit74;
    public static pregexp $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        $Stpregexp$Mnversion$St = Lit0;
        $Stpregexp$Mncomment$Mnchar$St = 59;
        $Stpregexp$Mnnul$Mnchar$Mnint$St = 97 - 97;
        $Stpregexp$Mnreturn$Mnchar$St = 13 + $Stpregexp$Mnnul$Mnchar$Mnint$St;
        $Stpregexp$Mntab$Mnchar$St = 9 + $Stpregexp$Mnnul$Mnchar$Mnint$St;
        $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
        pregexp$Mnerror = exceptions.error;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object pregexpReverse$Ex(Object s) {
        Object d;
        Object object2;
        EmptyList r;
        Object s2;
        Object object3 = s;
        Object object4 = r = LList.Empty;
        do {
            if (lists.isNull(s2 = object3)) {
                return r;
            }
            object2 = Promise.force(s2, Pair.class);
            d = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        {
            object2 = Promise.force(s2, Pair.class);
            lists.setCdr$Ex((Pair)object2, r);
            object3 = d;
            object4 = s2;
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object pregexpReadPattern(Object s, Object i, Object n) {
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
    public static Object pregexpReadBranch(Object s, Object i, Object n) {
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
    public static Object pregexpReadPiece(Object s, Object i, Object n) {
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
    public static Object pregexpWrapQuantifierIfAny(Object vv, Object s, Object n) {
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
    public static Object pregexpReadEscapedNumber(Object s, Object i, Object n) {
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
    public static Object pregexpReadEscapedChar(Object s, Object i, Object n) {
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
    public static Object pregexpReadSubpattern(Object s, Object i, Object n) {
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
    public static Object pregexpReadCharList(Object s, Object i, Object n) {
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
    public static Object pregexpReadPosixCharClass(Object s, Object i, Object n) {
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
    public static Object pregexpReadClusterType(Object s, Object i, Object n) {
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
    public static Object pregexpReadNums(Object s, Object i, Object n) {
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

    public static Object pregexpInvertCharList(Object vv) {
        Object object2 = Promise.force(vv, Pair.class);
        try {
            object2 = Promise.force(lists.car((Pair)object2), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        try {
            lists.setCar$Ex((Pair)object2, Lit44);
            return vv;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-car!", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object pregexpStringMatch(Object s1, Object s, Object i, Object n, Object sk, Object fk) {
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

    public static boolean isPregexpCharWord(Object c) {
        boolean bl;
        block4 : {
            Object object2 = Promise.force(c);
            try {
                boolean x = unicode.isCharAlphabetic(Char.castToCharacter(object2));
                if (!x) break block4;
                bl = x;
            }
            catch (ClassCastException classCastException) {
                void x;
                throw new WrongType(classCastException, "char-alphabetic?", 1, (Object)x);
            }
        }
        Object object3 = Promise.force(c);
        try {
            boolean x = unicode.isCharNumeric(Char.castToCharacter(object3));
            bl = x ? x : Char.castToCharacter(Promise.force(c)) == 95;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "char-numeric?", 1, object3);
        }
        return bl;
    }

    /*
     * Exception decompiling
     */
    public static boolean isPregexpAtWordBoundary(Object s, Object i, Object n) {
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean isPregexpCheckIfInCharClass(Object c, Object char$Mnclass) {
        switch (char$Mnclass.hashCode()) {
            case 1753596759: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit49)) break;
                if (Char.castToCharacter(Promise.force(c)) >= 128) return false;
                return true;
            }
            case 1754309978: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit50)) break;
                if (Char.castToCharacter(Promise.force(c)) == 32) {
                    return true;
                }
                v0 = x = false;
                if (x) {
                    v1 = x;
                    return v1;
                }
                if (Char.castToCharacter(Promise.force(c)) != pregexp.$Stpregexp$Mntab$Mnchar$St) return false;
                return true;
            }
            case 1753400676: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit51)) break;
                x = Promise.force(c);
                v1 = unicode.isCharAlphabetic(Char.castToCharacter(x));
                return v1;
            }
            case 1771990184: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit52)) break;
                x = Promise.force(c);
                v1 = unicode.isCharUpperCase(Char.castToCharacter(x));
                return v1;
            }
            case 1824626: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit9)) break;
                if (Char.castToCharacter(Promise.force(c)) != 10) return true;
                return false;
            }
            case 1753399169: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit53)) break;
                var3_13 = Promise.force(c);
                x = unicode.isCharAlphabetic(Char.castToCharacter(var3_13));
                if (!x) ** GOTO lbl40
                v1 = x;
                return v1;
lbl40: // 1 sources:
                var3_13 = Promise.force(c);
                v1 = unicode.isCharNumeric(Char.castToCharacter(var3_13));
                return v1;
            }
            case 1756073267: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit17)) break;
                x = Promise.force(c);
                v1 = unicode.isCharNumeric(Char.castToCharacter(x));
                return v1;
            }
            case 1763655431: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit54)) break;
                x = Promise.force(c);
                v1 = unicode.isCharLowerCase(Char.castToCharacter(x));
                return v1;
            }
            case 57219652: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit14)) break;
                var3_14 = Promise.force(c);
                x = unicode.isCharAlphabetic(Char.castToCharacter(var3_14));
                if (!x) ** GOTO lbl64
                v1 = x;
                return v1;
lbl64: // 1 sources:
                var4_18 = Promise.force(c);
                x = unicode.isCharNumeric(Char.castToCharacter(var4_18));
                if (!x) ** GOTO lbl70
                v1 = x;
                return v1;
lbl70: // 1 sources:
                if (Char.castToCharacter(Promise.force(c)) != 95) return false;
                return true;
            }
            case -828280721: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit55)) break;
                x = Promise.force(c);
                x = unicode.isCharNumeric(Char.castToCharacter(x));
                if (!x) ** GOTO lbl80
                v1 = x;
                return v1;
lbl80: // 1 sources:
                if (Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(97)) {
                    return true;
                }
                v2 = x = false;
                if (x) {
                    v1 = x;
                    return v1;
                }
                if (Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(98)) {
                    return true;
                }
                v3 = x = false;
                if (x) {
                    v1 = x;
                    return v1;
                }
                if (Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(99)) {
                    return true;
                }
                v4 = x = false;
                if (x) {
                    v1 = x;
                    return v1;
                }
                if (Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(100)) {
                    return true;
                }
                v5 = x = false;
                if (x) {
                    v1 = x;
                    return v1;
                }
                if (Character.toUpperCase(Char.castToCharacter(Promise.force(c))) == Character.toUpperCase(101)) {
                    return true;
                }
                v6 = x = false;
                if (x) {
                    v1 = x;
                    return v1;
                }
                if (Character.toUpperCase(Char.castToCharacter(Promise.force(c))) != Character.toUpperCase(102)) return false;
                return true;
            }
            case 1770128652: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit18)) break;
                x = Promise.force(c);
                v1 = unicode.isCharWhitespace(Char.castToCharacter(x));
                return v1;
            }
            case 1755311465: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit56)) break;
                if (Char.castToCharacter(Promise.force(c)) >= 32) return false;
                return true;
            }
            case 1767425715: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit57)) break;
                if (Char.castToCharacter(Promise.force(c)) < 32) return false;
                return true;
            }
            case 1759106388: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit58)) break;
                if (Char.castToCharacter(Promise.force(c)) < 32) {
                    return false;
                }
                x = Promise.force(c);
                if (unicode.isCharWhitespace(Char.castToCharacter(x)) == false) return true;
                return false;
            }
            case 1767519552: {
                if (!IsEqv.apply(char$Mnclass, pregexp.Lit59)) break;
                if (Char.castToCharacter(Promise.force(c)) < 32) {
                    return false;
                }
                x = Promise.force(c);
                if (unicode.isCharWhitespace(Char.castToCharacter(x)) != false) return false;
                x = Promise.force(c);
                if (unicode.isCharAlphabetic(Char.castToCharacter(x)) != false) return false;
                x = Promise.force(c);
                if (unicode.isCharNumeric(Char.castToCharacter(x)) == false) return true;
                return false;
            }
        }
        v7 = exceptions.error(new Object[]{pregexp.Lit60});
        throw Special.reachedUnexpected;
        catch (ClassCastException v8) {
            throw new WrongType(v8, "char-alphabetic?", 1, x);
        }
        catch (ClassCastException v9) {
            throw new WrongType(v9, "char-upper-case?", 1, x);
        }
        catch (ClassCastException v10) {
            throw new WrongType(v10, "char-alphabetic?", 1, (Object)x);
        }
        catch (ClassCastException v11) {
            throw new WrongType(v11, "char-numeric?", 1, (Object)x);
        }
        catch (ClassCastException v12) {
            throw new WrongType(v12, "char-numeric?", 1, x);
        }
        catch (ClassCastException v13) {
            throw new WrongType(v13, "char-lower-case?", 1, x);
        }
        catch (ClassCastException v14) {
            throw new WrongType(v14, "char-alphabetic?", 1, (Object)x);
        }
        catch (ClassCastException v15) {
            throw new WrongType(v15, "char-numeric?", 1, (Object)x);
        }
        catch (ClassCastException v16) {
            throw new WrongType(v16, "char-numeric?", 1, x);
        }
        catch (ClassCastException v17) {
            throw new WrongType(v17, "char-whitespace?", 1, x);
        }
        catch (ClassCastException v18) {
            throw new WrongType(v18, "char-whitespace?", 1, x);
        }
        catch (ClassCastException v19) {
            throw new WrongType(v19, "char-whitespace?", 1, x);
        }
        catch (ClassCastException v20) {
            throw new WrongType(v20, "char-alphabetic?", 1, x);
        }
        catch (ClassCastException v21) {
            throw new WrongType(v21, "char-numeric?", 1, x);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object pregexpListRef(Object s, Object i) {
        Object object2;
        IntNum k;
        Object object3 = s;
        IntNum intNum = k = Lit40;
        do {
            Object s2;
            Object object4;
            if (lists.isNull(s2 = object3)) {
                object4 = Boolean.FALSE;
                return object4;
            }
            if (NumberCompare.$Eq(k, i)) {
                object2 = Promise.force(s2, Pair.class);
                object4 = lists.car((Pair)object2);
                return object4;
            }
            object2 = Promise.force(s2, Pair.class);
            object3 = lists.cdr((Pair)object2);
            intNum = IntNum.add(k, 1);
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    public static Object pregexpMakeBackrefList(Object re) {
        return pregexp.lambda1sub(re);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object lambda1sub(Object re) {
        Object sub$Mncdr$Mnre;
        Object object2;
        void car$Mnre;
        if (!lists.isPair(re)) {
            object2 = LList.Empty;
            return object2;
        }
        Object object4 = Promise.force(re, Pair.class);
        try {
            Object object5 = lists.car((Pair)object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, sub$Mncdr$Mnre);
        }
        Object object22 = Promise.force(re, Pair.class);
        try {
            sub$Mncdr$Mnre = pregexp.lambda1sub(lists.cdr((Pair)object22));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object22);
        }
        if (IsEqv.apply(car$Mnre, Lit61)) {
            object2 = lists.cons(lists.cons(re, Boolean.FALSE), sub$Mncdr$Mnre);
            return object2;
        }
        object2 = append.append$V(new Object[]{pregexp.lambda1sub(car$Mnre), sub$Mncdr$Mnre});
        return object2;
    }

    /*
     * Exception decompiling
     */
    public static Object pregexpMatchPositionsAux(Object re, Object s, Object sn, Object start, Object n, Object i) {
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
    public static Object pregexpReplaceAux(Object str, Object ins, Object n, Object backrefs) {
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

    public static Pair pregexp(Object s) {
        $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
        Object object2 = Promise.force(s, CharSequence.class);
        try {
            object2 = Promise.force(pregexp.pregexpReadPattern(s, Lit40, strings.stringLength((CharSequence)object2)), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-length", 1, object2);
        }
        try {
            return LList.list2(Lit61, lists.car((Pair)object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object pregexpMatchPositions$V(Object pat, Object str, Object[] argsArray) {
        IntNum start;
        IntNum i;
        Object object2;
        int str$Mnlen;
        block20 : {
            LList lList;
            Object object5;
            Object object3;
            LList opt$Mnargs = lList = LList.makeList(argsArray, 0);
            if (strings.isString(pat)) {
                pat = pregexp.pregexp(pat);
            } else if (!lists.isPair(pat)) {
                Type.NeverReturns neverReturns = exceptions.error(Lit71, Lit72, pat);
                throw Special.reachedUnexpected;
            }
            Object object6 = Promise.force(str, CharSequence.class);
            try {
                str$Mnlen = strings.stringLength((CharSequence)object6);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "string-length", 1, (Object)start);
            }
            if (lists.isNull(opt$Mnargs)) {
                object3 = Lit40;
            } else {
                object5 = opt$Mnargs;
                Object start2 = lists.car((Pair)object5);
                object5 = opt$Mnargs;
                object5 = Promise.force(lists.cdr((Pair)object5), LList.class);
                opt$Mnargs = (LList)object5;
                object3 = start = start2;
            }
            if (lists.isNull(opt$Mnargs)) {
                object2 = str$Mnlen;
            } else {
                object5 = opt$Mnargs;
                object2 = lists.car((Pair)object5);
            }
            break block20;
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, (Object)i);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, (Object)i);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "opt-args", -2, (Object)i);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, (Object)i);
            }
        }
        Integer end = object2;
        Object object4 = start;
        do {
            Object object5;
            if (!NumberCompare.$Ls$Eq(i = object4, end)) {
                object5 = Boolean.FALSE;
                return object5;
            }
            Object x = pregexp.pregexpMatchPositionsAux(pat, str, str$Mnlen, start, end, i);
            if (KawaConvert.isTrue(x)) {
                object5 = x;
                return object5;
            }
            object4 = AddOp.apply2(1, i, Lit3);
        } while (true);
    }

    /*
     * Exception decompiling
     */
    public static Object pregexpMatch$V(Object pat, Object str, Object[] argsArray) {
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
    public static Object pregexpSplit(Object pat, Object str) {
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
    public static Object pregexpReplace(Object pat, Object str, Object ins) {
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
    public static Object pregexpReplace$St(Object pat, Object str, Object ins) {
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
    public static Object pregexpQuote(Object s) {
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
        Lit74 = Char.valueOf(92);
        Lit10 = Char.valueOf(94);
        Lit73 = PairWithPosition.make(Lit74, PairWithPosition.make(Char.valueOf(46), PairWithPosition.make(Char.valueOf(63), PairWithPosition.make(Char.valueOf(42), PairWithPosition.make(Char.valueOf(43), PairWithPosition.make(Char.valueOf(124), PairWithPosition.make(Lit10, PairWithPosition.make(Char.valueOf(36), PairWithPosition.make(Char.valueOf(91), PairWithPosition.make(Char.valueOf(93), PairWithPosition.make(Char.valueOf(123), PairWithPosition.make(Char.valueOf(125), PairWithPosition.make(Char.valueOf(40), PairWithPosition.make(Char.valueOf(41), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170361), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170357), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170353), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170349), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170345), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3170341), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166269), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166265), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166261), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166253), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166249), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166245), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 3166240);
        Lit72 = Symbol.valueOf("pattern-must-be-compiled-or-string-regexp");
        Lit71 = Symbol.valueOf("pregexp-match-positions");
        Lit70 = Symbol.valueOf("greedy-quantifier-operand-could-be-empty");
        Lit69 = Symbol.valueOf("non-existent-backref");
        Lit68 = Symbol.valueOf(":lookbehind");
        Lit67 = Symbol.valueOf(":neg-lookahead");
        Lit66 = Symbol.valueOf(":no-backtrack");
        Lit65 = Symbol.valueOf(":lookahead");
        Lit35 = Symbol.valueOf(":between");
        Lit40 = IntNum.valueOf(0);
        Lit9 = Symbol.valueOf(":any");
        Lit64 = PairWithPosition.make(Lit35, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit40, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit9, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355265), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355262), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 2355247);
        Lit63 = Symbol.valueOf(":neg-lookbehind");
        Lit62 = Symbol.valueOf("pregexp-match-positions-aux");
        Lit61 = Symbol.valueOf(":sub");
        Lit60 = Symbol.valueOf("pregexp-check-if-in-char-class?");
        Lit59 = Symbol.valueOf(":punct");
        Lit58 = Symbol.valueOf(":graph");
        Lit57 = Symbol.valueOf(":print");
        Lit56 = Symbol.valueOf(":cntrl");
        Lit55 = Symbol.valueOf(":xdigit");
        Lit54 = Symbol.valueOf(":lower");
        Lit53 = Symbol.valueOf(":alnum");
        Lit52 = Symbol.valueOf(":upper");
        Lit51 = Symbol.valueOf(":alpha");
        Lit50 = Symbol.valueOf(":blank");
        Lit49 = Symbol.valueOf(":ascii");
        Lit48 = Symbol.valueOf(":char-range");
        Lit47 = Symbol.valueOf(":one-of-chars");
        Lit46 = Symbol.valueOf("character-class-ended-too-soon");
        Lit45 = Symbol.valueOf("pregexp-read-char-list");
        Lit44 = Symbol.valueOf(":none-of-chars");
        Lit43 = Symbol.valueOf("pregexp-read-nums");
        Lit42 = Symbol.valueOf("left-brace-must-be-followed-by-number");
        Lit41 = Symbol.valueOf("pregexp-wrap-quantifier-if-any");
        Lit39 = Symbol.valueOf("next-i");
        Lit38 = Symbol.valueOf("at-most");
        Lit37 = Symbol.valueOf("at-least");
        Lit36 = Symbol.valueOf("minimal?");
        Lit34 = Symbol.valueOf("pregexp-read-subpattern");
        Lit33 = PairWithPosition.make(Lit61, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 962582);
        Lit32 = Symbol.valueOf(":case-insensitive");
        Lit31 = Symbol.valueOf(":case-sensitive");
        Lit30 = Symbol.valueOf("pregexp-read-cluster-type");
        Lit29 = PairWithPosition.make(Lit68, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 892959);
        Lit28 = PairWithPosition.make(Lit63, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 897055);
        Lit27 = PairWithPosition.make(Lit65, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 872476);
        Lit26 = PairWithPosition.make(Lit66, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 880668);
        Lit25 = PairWithPosition.make(Lit67, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 876572);
        Lit24 = Symbol.valueOf("pregexp-read-posix-char-class");
        Lit23 = Char.valueOf(58);
        Lit22 = Char.valueOf(10);
        Lit21 = Symbol.valueOf(":not-wbdry");
        Lit12 = Symbol.valueOf(":neg-char");
        Lit18 = Symbol.valueOf(":space");
        Lit20 = PairWithPosition.make(Lit12, PairWithPosition.make(Lit18, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 704551), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 704540);
        Lit19 = Symbol.valueOf(":wbdry");
        Lit17 = Symbol.valueOf(":digit");
        Lit14 = Symbol.valueOf(":word");
        Lit16 = PairWithPosition.make(Lit12, PairWithPosition.make(Lit14, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 716839), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 716828);
        Lit15 = PairWithPosition.make(Lit12, PairWithPosition.make(Lit17, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 688167), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm", 688156);
        Lit13 = Symbol.valueOf(":empty");
        Lit11 = IntNum.valueOf(2);
        Lit8 = Symbol.valueOf(":bos");
        Lit7 = Symbol.valueOf("backslash");
        Lit6 = Symbol.valueOf("pregexp-read-piece");
        Lit5 = Symbol.valueOf(":backref");
        Lit4 = Symbol.valueOf(":eos");
        Lit3 = IntNum.valueOf(1);
        Lit2 = Symbol.valueOf(":seq");
        Lit1 = Symbol.valueOf(":or");
        Lit0 = IntNum.valueOf(20050502);
        pregexp pregexp2 = $instance = new pregexp();
        ModuleMethod moduleMethod = new ModuleMethod(pregexp2, 16, "pregexp-reverse!", 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:47");
        pregexp$Mnreverse$Ex = moduleMethod;
        ModuleMethod moduleMethod2 = new ModuleMethod(pregexp2, 17, "pregexp-read-pattern", 12291);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:70");
        pregexp$Mnread$Mnpattern = moduleMethod2;
        ModuleMethod moduleMethod3 = new ModuleMethod(pregexp2, 18, "pregexp-read-branch", 12291);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:84");
        pregexp$Mnread$Mnbranch = moduleMethod3;
        ModuleMethod moduleMethod4 = new ModuleMethod(pregexp2, 19, "pregexp-read-piece", 12291);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:96");
        pregexp$Mnread$Mnpiece = moduleMethod4;
        ModuleMethod moduleMethod5 = new ModuleMethod(pregexp2, 20, "pregexp-read-escaped-number", 12291);
        moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:143");
        pregexp$Mnread$Mnescaped$Mnnumber = moduleMethod5;
        ModuleMethod moduleMethod6 = new ModuleMethod(pregexp2, 21, "pregexp-read-escaped-char", 12291);
        moduleMethod6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:160");
        pregexp$Mnread$Mnescaped$Mnchar = moduleMethod6;
        ModuleMethod moduleMethod7 = new ModuleMethod(pregexp2, 22, "pregexp-read-posix-char-class", 12291);
        moduleMethod7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:179");
        pregexp$Mnread$Mnposix$Mnchar$Mnclass = moduleMethod7;
        ModuleMethod moduleMethod8 = new ModuleMethod(pregexp2, 23, "pregexp-read-cluster-type", 12291);
        moduleMethod8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:205");
        pregexp$Mnread$Mncluster$Mntype = moduleMethod8;
        ModuleMethod moduleMethod9 = new ModuleMethod(pregexp2, 24, "pregexp-read-subpattern", 12291);
        moduleMethod9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:238");
        pregexp$Mnread$Mnsubpattern = moduleMethod9;
        ModuleMethod moduleMethod10 = new ModuleMethod(pregexp2, 25, "pregexp-wrap-quantifier-if-any", 12291);
        moduleMethod10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:259");
        pregexp$Mnwrap$Mnquantifier$Mnif$Mnany = moduleMethod10;
        ModuleMethod moduleMethod11 = new ModuleMethod(pregexp2, 26, "pregexp-read-nums", 12291);
        moduleMethod11.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:305");
        pregexp$Mnread$Mnnums = moduleMethod11;
        ModuleMethod moduleMethod12 = new ModuleMethod(pregexp2, 27, "pregexp-invert-char-list", 4097);
        moduleMethod12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:328");
        pregexp$Mninvert$Mnchar$Mnlist = moduleMethod12;
        ModuleMethod moduleMethod13 = new ModuleMethod(pregexp2, 28, "pregexp-read-char-list", 12291);
        moduleMethod13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:335");
        pregexp$Mnread$Mnchar$Mnlist = moduleMethod13;
        ModuleMethod moduleMethod14 = new ModuleMethod(pregexp2, 29, "pregexp-string-match", 24582);
        moduleMethod14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:373");
        pregexp$Mnstring$Mnmatch = moduleMethod14;
        ModuleMethod moduleMethod15 = new ModuleMethod(pregexp2, 30, "pregexp-char-word?", 4097);
        moduleMethod15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:384");
        pregexp$Mnchar$Mnword$Qu = moduleMethod15;
        ModuleMethod moduleMethod16 = new ModuleMethod(pregexp2, 31, "pregexp-at-word-boundary?", 12291);
        moduleMethod16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:392");
        pregexp$Mnat$Mnword$Mnboundary$Qu = moduleMethod16;
        ModuleMethod moduleMethod17 = new ModuleMethod(pregexp2, 32, "pregexp-check-if-in-char-class?", 8194);
        moduleMethod17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:404");
        pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu = moduleMethod17;
        ModuleMethod moduleMethod18 = new ModuleMethod(pregexp2, 33, "pregexp-list-ref", 8194);
        moduleMethod18.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:434");
        pregexp$Mnlist$Mnref = moduleMethod18;
        ModuleMethod moduleMethod19 = new ModuleMethod(pregexp2, 34, "pregexp-make-backref-list", 4097);
        moduleMethod19.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:453");
        pregexp$Mnmake$Mnbackref$Mnlist = moduleMethod19;
        ModuleMethod moduleMethod20 = new ModuleMethod(pregexp2, 35, null, 0);
        moduleMethod20.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:468");
        lambda$Fn1 = moduleMethod20;
        ModuleMethod moduleMethod21 = new ModuleMethod(pregexp2, 36, null, 0);
        moduleMethod21.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:577");
        lambda$Fn4 = moduleMethod21;
        ModuleMethod moduleMethod22 = new ModuleMethod(pregexp2, 37, null, 0);
        moduleMethod22.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:555");
        lambda$Fn5 = moduleMethod22;
        ModuleMethod moduleMethod23 = new ModuleMethod(pregexp2, 38, null, 0);
        moduleMethod23.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:582");
        lambda$Fn9 = moduleMethod23;
        ModuleMethod moduleMethod24 = new ModuleMethod(pregexp2, 39, null, 0);
        moduleMethod24.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:560");
        lambda$Fn10 = moduleMethod24;
        ModuleMethod moduleMethod25 = new ModuleMethod(pregexp2, 40, null, 0);
        moduleMethod25.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:568");
        lambda$Fn11 = moduleMethod25;
        ModuleMethod moduleMethod26 = new ModuleMethod(pregexp2, 41, "pregexp-match-positions-aux", 24582);
        moduleMethod26.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:464");
        pregexp$Mnmatch$Mnpositions$Mnaux = moduleMethod26;
        ModuleMethod moduleMethod27 = new ModuleMethod(pregexp2, 42, "pregexp-replace-aux", 16388);
        moduleMethod27.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:643");
        pregexp$Mnreplace$Mnaux = moduleMethod27;
        ModuleMethod moduleMethod28 = new ModuleMethod(pregexp2, 43, "pregexp", 4097);
        moduleMethod28.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:669");
        pregexp = moduleMethod28;
        ModuleMethod moduleMethod29 = new ModuleMethod(pregexp2, 44, "pregexp-match-positions", -4094);
        moduleMethod29.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:674");
        pregexp$Mnmatch$Mnpositions = moduleMethod29;
        ModuleMethod moduleMethod30 = new ModuleMethod(pregexp2, 45, "pregexp-match", -4094);
        moduleMethod30.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:694");
        pregexp$Mnmatch = moduleMethod30;
        ModuleMethod moduleMethod31 = new ModuleMethod(pregexp2, 46, "pregexp-split", 8194);
        moduleMethod31.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:704");
        pregexp$Mnsplit = moduleMethod31;
        ModuleMethod moduleMethod32 = new ModuleMethod(pregexp2, 47, "pregexp-replace", 12291);
        moduleMethod32.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:727");
        pregexp$Mnreplace = moduleMethod32;
        ModuleMethod moduleMethod33 = new ModuleMethod(pregexp2, 48, "pregexp-replace*", 12291);
        moduleMethod33.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:740");
        pregexp$Mnreplace$St = moduleMethod33;
        ModuleMethod moduleMethod34 = new ModuleMethod(pregexp2, 49, "pregexp-quote", 4097);
        moduleMethod34.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:768");
        pregexp$Mnquote = moduleMethod34;
        pregexp.$runBody$();
    }

    public pregexp() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 40: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 39: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 38: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 37: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 36: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 35: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 49: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 43: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 34: {
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
            case 27: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 46: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 33: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 32: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 48: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 47: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 31: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 28: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 26: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 25: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 24: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 23: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 22: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 21: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 20: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 19: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
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
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        if (moduleMethod.selector == 42) {
            callContext.value1 = object2;
            callContext.value2 = object3;
            callContext.value3 = object4;
            callContext.value4 = object5;
            callContext.proc = moduleMethod;
            callContext.pc = 4;
            return 0;
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
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
            case 41: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 29: {
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

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            public class Frame0
            extends ModuleBody {
                boolean maximal$Qu;
                Object q;
                boolean could$Mnloop$Mninfinitely$Qu;
                Object re;
                Object p;
                Object old;
                @SourceName(name="re")
                Object re$1;
                Object sk;
                Object i;
                Object fk;
                Frame staticLink;
                final ModuleMethod lambda$Fn2;
                final ModuleMethod lambda$Fn3;
                final ModuleMethod lambda$Fn6;
                final ModuleMethod lambda$Fn7;
                final ModuleMethod lambda$Fn8;
                final ModuleMethod lambda$Fn12;

                public Frame0() {
                    ModuleMethod moduleMethod = new ModuleMethod(this, 9, null, 4097);
                    moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:518");
                    this.lambda$Fn2 = moduleMethod;
                    ModuleMethod moduleMethod2 = new ModuleMethod(this, 10, null, 0);
                    moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:519");
                    this.lambda$Fn3 = moduleMethod2;
                    ModuleMethod moduleMethod3 = new ModuleMethod(this, 11, null, 4097);
                    moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:549");
                    this.lambda$Fn6 = moduleMethod3;
                    ModuleMethod moduleMethod4 = new ModuleMethod(this, 12, null, 4097);
                    moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:591");
                    this.lambda$Fn7 = moduleMethod4;
                    ModuleMethod moduleMethod5 = new ModuleMethod(this, 13, null, 0);
                    moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:594");
                    this.lambda$Fn8 = moduleMethod5;
                    ModuleMethod moduleMethod6 = new ModuleMethod(this, 14, null, 4097);
                    moduleMethod6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:545");
                    this.lambda$Fn12 = moduleMethod6;
                }

                Object lambda5(Object i1) {
                    return ((Procedure)Scheme.applyToArgs).apply1(this.fk);
                }

                Object lambda6() {
                    return ((Procedure)Scheme.applyToArgs).apply2(this.sk, AddOp.apply2(1, this.i, pregexp.Lit3));
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public Object lambda7loupOr(Object backrefs, Object res) {
                    Object object2;
                    new Frame3().staticLink = this;
                    public class Frame3
                    extends ModuleBody {
                        Object res;
                        Frame0 staticLink;
                        final ModuleMethod lambda$Fn15;
                        final ModuleMethod lambda$Fn16;

                        public Frame3() {
                            ModuleMethod moduleMethod = new ModuleMethod(this, 3, null, 4097);
                            moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:531");
                            this.lambda$Fn15 = moduleMethod;
                            ModuleMethod moduleMethod2 = new ModuleMethod(this, 4, null, 0);
                            moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:534");
                            this.lambda$Fn16 = moduleMethod2;
                        }

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        Object lambda22(Object i1) {
                            Object object2;
                            Object x = ((Procedure)Scheme.applyToArgs).apply2(this.staticLink.sk, i1);
                            if (KawaConvert.isTrue(x)) {
                                object2 = x;
                                return object2;
                            }
                            Object object22 = Promise.force(this.res, Pair.class);
                            try {
                                public class Frame
                                extends ModuleBody {
                                    Object sn;
                                    Procedure identity;
                                    Object backrefs;
                                    Object case$Mnsensitive$Qu;
                                    Object s;
                                    Object n;
                                    Object start;

                                    public Frame() {
                                        ModuleMethod moduleMethod = new ModuleMethod(this, 15, "identity", 4097);
                                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:465");
                                        this.identity = moduleMethod;
                                    }

                                    public static Object lambda2identity(Object x) {
                                        return x;
                                    }

                                    /*
                                     * Exception decompiling
                                     */
                                    public Object lambda3sub(Object backrefs, Object re, Object i, Object sk, Object fk) {
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

                                    static boolean lambda4() {
                                        return false;
                                    }

                                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                                        if (moduleMethod.selector == 15) {
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
                                        if (moduleMethod.selector == 15) {
                                            return Frame.lambda2identity(object2);
                                        }
                                        return super.apply1(moduleMethod, object2);
                                    }
                                }
                                object2 = this.staticLink.lambda7loupOr(this.staticLink.staticLink.backrefs, lists.cdr((Pair)object22));
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "cdr", 1, object22);
                            }
                            return object2;
                        }

                        Object lambda23() {
                            Object object2 = Promise.force(this.res, Pair.class);
                            try {
                                return this.staticLink.lambda7loupOr(this.staticLink.staticLink.backrefs, lists.cdr((Pair)object2));
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "cdr", 1, object2);
                            }
                        }

                        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                            if (moduleMethod.selector == 4) {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            return super.match0(moduleMethod, callContext);
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

                        public Object apply0(ModuleMethod moduleMethod) {
                            if (moduleMethod.selector == 4) {
                                return this.lambda23();
                            }
                            return super.apply0(moduleMethod);
                        }

                        public Object apply1(ModuleMethod moduleMethod, Object object2) {
                            if (moduleMethod.selector == 3) {
                                return this.lambda22(object2);
                            }
                            return super.apply1(moduleMethod, object2);
                        }
                    }
                    Frame3 $heapFrame = new Frame3();
                    $heapFrame.res = res;
                    if (lists.isNull($heapFrame.res)) {
                        object2 = ((Procedure)Scheme.applyToArgs).apply1(this.fk);
                        return object2;
                    }
                    Object object22 = Promise.force($heapFrame.res, Pair.class);
                    try {
                        object2 = this.staticLink.lambda3sub(backrefs, lists.car((Pair)object22), this.i, $heapFrame.lambda$Fn15, $heapFrame.lambda$Fn16);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object22);
                    }
                    return object2;
                }

                public Object lambda8loupP(Object maximal$Qu, Object q, Object re, Object p, Object backrefs, IntNum k, Object i) {
                    Object object2;
                    new Frame4().staticLink = this;
                    public class Frame4
                    extends ModuleBody {
                        Object q;
                        IntNum k;
                        Object i;
                        Frame0 staticLink;
                        final ModuleMethod lambda$Fn17;

                        public Frame4() {
                            ModuleMethod moduleMethod = new ModuleMethod(this, 8, null, 4097);
                            moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:606");
                            this.lambda$Fn17 = moduleMethod;
                        }

                        Object lambda24(Object i1) {
                            if (this.staticLink.could$Mnloop$Mninfinitely$Qu && NumberCompare.$Eq(i1, this.i)) {
                                Type.NeverReturns neverReturns = exceptions.error(pregexp.Lit62, pregexp.Lit70);
                                throw Special.reachedUnexpected;
                            }
                            return this.staticLink.lambda8loupP(this.staticLink.maximal$Qu ? Boolean.TRUE : Boolean.FALSE, this.staticLink.q, this.staticLink.re, this.staticLink.p, this.staticLink.staticLink.backrefs, IntNum.add(this.k, 1), i1);
                        }

                        public Object lambda25loupQ(Object re, Object maximal$Qu, Object q, Object backrefs, IntNum k, Object i) {
                            Object x;
                            new Frame5().staticLink = this;
                            public class Frame5
                            extends ModuleBody {
                                Procedure fk;
                                IntNum k;
                                Object i;
                                Frame4 staticLink;
                                final ModuleMethod lambda$Fn18;
                                final ModuleMethod lambda$Fn19;

                                public Frame5() {
                                    ModuleMethod moduleMethod = new ModuleMethod(this, 5, "fk", 0);
                                    moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:616");
                                    this.fk = moduleMethod;
                                    ModuleMethod moduleMethod2 = new ModuleMethod(this, 6, null, 4097);
                                    moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:621");
                                    this.lambda$Fn18 = moduleMethod2;
                                    ModuleMethod moduleMethod3 = new ModuleMethod(this, 7, null, 4097);
                                    moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:632");
                                    this.lambda$Fn19 = moduleMethod3;
                                }

                                public Object lambda26fk() {
                                    return ((Procedure)Scheme.applyToArgs).apply2(this.staticLink.staticLink.sk, this.i);
                                }

                                Object lambda27(Object i1) {
                                    if (this.staticLink.staticLink.could$Mnloop$Mninfinitely$Qu && NumberCompare.$Eq(i1, this.i)) {
                                        Type.NeverReturns neverReturns = exceptions.error(pregexp.Lit62, pregexp.Lit70);
                                        throw Special.reachedUnexpected;
                                    }
                                    Object x = this.staticLink.lambda25loupQ(this.staticLink.staticLink.re, this.staticLink.staticLink.maximal$Qu ? Boolean.TRUE : Boolean.FALSE, this.staticLink.q, this.staticLink.staticLink.staticLink.backrefs, IntNum.add(this.k, 1), i1);
                                    return KawaConvert.isTrue(x) ? x : this.lambda26fk();
                                }

                                Object lambda28(Object i1) {
                                    return this.staticLink.lambda25loupQ(this.staticLink.staticLink.re, this.staticLink.staticLink.maximal$Qu ? Boolean.TRUE : Boolean.FALSE, this.staticLink.q, this.staticLink.staticLink.staticLink.backrefs, IntNum.add(this.k, 1), i1);
                                }

                                public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                                    if (moduleMethod.selector == 5) {
                                        callContext.proc = moduleMethod;
                                        callContext.pc = 0;
                                        return 0;
                                    }
                                    return super.match0(moduleMethod, callContext);
                                }

                                public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                                    switch (moduleMethod.selector) {
                                        case 7: {
                                            callContext.value1 = object2;
                                            callContext.proc = moduleMethod;
                                            callContext.pc = 1;
                                            return 0;
                                        }
                                        case 6: {
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

                                public Object apply0(ModuleMethod moduleMethod) {
                                    if (moduleMethod.selector == 5) {
                                        return this.lambda26fk();
                                    }
                                    return super.apply0(moduleMethod);
                                }

                                public Object apply1(ModuleMethod moduleMethod, Object object2) {
                                    switch (moduleMethod.selector) {
                                        case 6: {
                                            return this.lambda27(object2);
                                        }
                                        case 7: {
                                            return this.lambda28(object2);
                                        }
                                    }
                                    return super.apply1(moduleMethod, object2);
                                }
                            }
                            Frame5 $heapFrame = new Frame5();
                            $heapFrame.k = k;
                            $heapFrame.i = i;
                            $heapFrame.fk = $heapFrame.fk;
                            return KawaConvert.isTrue(q) && NumberCompare.$Gr$Eq($heapFrame.k, q) ? $heapFrame.lambda26fk() : (KawaConvert.isTrue(maximal$Qu) ? this.staticLink.staticLink.lambda3sub(backrefs, re, $heapFrame.i, $heapFrame.lambda$Fn18, $heapFrame.fk) : (KawaConvert.isTrue(x = $heapFrame.lambda26fk()) ? x : this.staticLink.staticLink.lambda3sub(backrefs, re, $heapFrame.i, $heapFrame.lambda$Fn19, $heapFrame.fk)));
                        }

                        public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                            if (moduleMethod.selector == 8) {
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
                            if (moduleMethod.selector == 8) {
                                return this.lambda24(object2);
                            }
                            return super.apply1(moduleMethod, object2);
                        }
                    }
                    Frame4 $heapFrame = new Frame4();
                    $heapFrame.k = k;
                    $heapFrame.i = i;
                    if (NumberCompare.$Ls($heapFrame.k, p)) {
                        object2 = this.staticLink.lambda3sub(backrefs, re, $heapFrame.i, $heapFrame.lambda$Fn17, this.fk);
                    } else {
                        $heapFrame.q = KawaConvert.isTrue(q) ? AddOp.apply2(-1, q, p) : Boolean.FALSE;
                        object2 = $heapFrame.lambda25loupQ(re, maximal$Qu, $heapFrame.q, backrefs, pregexp.Lit40, $heapFrame.i);
                    }
                    return object2;
                }

                static boolean lambda9() {
                    return false;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public Object lambda10loupOneOfChars(Object backrefs, Object chars) {
                    Object object2;
                    new Frame1().staticLink = this;
                    public class Frame1
                    extends ModuleBody {
                        Object chars;
                        Frame0 staticLink;
                        final ModuleMethod lambda$Fn13;

                        public Frame1() {
                            ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 0);
                            moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:513");
                            this.lambda$Fn13 = moduleMethod;
                        }

                        Object lambda20() {
                            Object object2 = Promise.force(this.chars, Pair.class);
                            try {
                                return this.staticLink.lambda10loupOneOfChars(this.staticLink.staticLink.backrefs, lists.cdr((Pair)object2));
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "cdr", 1, object2);
                            }
                        }

                        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                            if (moduleMethod.selector == 1) {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            return super.match0(moduleMethod, callContext);
                        }

                        public void apply(CallContext callContext) {
                            ModuleMethod.applyError();
                        }

                        public Object apply0(ModuleMethod moduleMethod) {
                            if (moduleMethod.selector == 1) {
                                return this.lambda20();
                            }
                            return super.apply0(moduleMethod);
                        }
                    }
                    Frame1 $heapFrame = new Frame1();
                    $heapFrame.chars = chars;
                    if (lists.isNull($heapFrame.chars)) {
                        object2 = ((Procedure)Scheme.applyToArgs).apply1(this.fk);
                        return object2;
                    }
                    Object object22 = Promise.force($heapFrame.chars, Pair.class);
                    try {
                        object2 = this.staticLink.lambda3sub(backrefs, lists.car((Pair)object22), this.i, this.sk, $heapFrame.lambda$Fn13);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object22);
                    }
                    return object2;
                }

                static boolean lambda11() {
                    return false;
                }

                Object lambda12(Object i1) {
                    Object object2 = Promise.force(lists.assv(this.re$1, this.staticLink.backrefs), Pair.class);
                    try {
                        lists.setCdr$Ex((Pair)object2, lists.cons(this.i, i1));
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "set-cdr!", 1, object2);
                    }
                    return ((Procedure)Scheme.applyToArgs).apply2(this.sk, i1);
                }

                Object lambda13(Object i1) {
                    this.staticLink.case$Mnsensitive$Qu = this.old;
                    return ((Procedure)Scheme.applyToArgs).apply2(this.sk, i1);
                }

                Object lambda14() {
                    this.staticLink.case$Mnsensitive$Qu = this.old;
                    return ((Procedure)Scheme.applyToArgs).apply1(this.fk);
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public Object lambda15loupSeq(Object backrefs, Object res, Object i) {
                    Object object2;
                    new Frame2().staticLink = this;
                    public class Frame2
                    extends ModuleBody {
                        Object res;
                        Frame0 staticLink;
                        final ModuleMethod lambda$Fn14;

                        public Frame2() {
                            ModuleMethod moduleMethod = new ModuleMethod(this, 2, null, 4097);
                            moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pregexp.scm:524");
                            this.lambda$Fn14 = moduleMethod;
                        }

                        Object lambda21(Object i1) {
                            Object object2 = Promise.force(this.res, Pair.class);
                            try {
                                return this.staticLink.lambda15loupSeq(this.staticLink.staticLink.backrefs, lists.cdr((Pair)object2), i1);
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "cdr", 1, object2);
                            }
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

                        public void apply(CallContext callContext) {
                            ModuleMethod.applyError();
                        }

                        public Object apply1(ModuleMethod moduleMethod, Object object2) {
                            if (moduleMethod.selector == 2) {
                                return this.lambda21(object2);
                            }
                            return super.apply1(moduleMethod, object2);
                        }
                    }
                    Frame2 $heapFrame = new Frame2();
                    $heapFrame.res = res;
                    if (lists.isNull($heapFrame.res)) {
                        object2 = ((Procedure)Scheme.applyToArgs).apply2(this.sk, i);
                        return object2;
                    }
                    Object object22 = Promise.force($heapFrame.res, Pair.class);
                    try {
                        object2 = this.staticLink.lambda3sub(backrefs, lists.car((Pair)object22), i, $heapFrame.lambda$Fn14, this.fk);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object22);
                    }
                    return object2;
                }

                static boolean lambda16() {
                    return false;
                }

                static boolean lambda17() {
                    return false;
                }

                static boolean lambda18() {
                    return false;
                }

                Object lambda19(Object i) {
                    return ((Procedure)Scheme.applyToArgs).apply2(this.sk, i);
                }

                public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                    switch (moduleMethod.selector) {
                        case 13: {
                            callContext.proc = moduleMethod;
                            callContext.pc = 0;
                            return 0;
                        }
                        case 10: {
                            callContext.proc = moduleMethod;
                            callContext.pc = 0;
                            return 0;
                        }
                    }
                    return super.match0(moduleMethod, callContext);
                }

                public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                    switch (moduleMethod.selector) {
                        case 14: {
                            callContext.value1 = object2;
                            callContext.proc = moduleMethod;
                            callContext.pc = 1;
                            return 0;
                        }
                        case 12: {
                            callContext.value1 = object2;
                            callContext.proc = moduleMethod;
                            callContext.pc = 1;
                            return 0;
                        }
                        case 11: {
                            callContext.value1 = object2;
                            callContext.proc = moduleMethod;
                            callContext.pc = 1;
                            return 0;
                        }
                        case 9: {
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

                public Object apply0(ModuleMethod moduleMethod) {
                    switch (moduleMethod.selector) {
                        case 10: {
                            return this.lambda6();
                        }
                        case 13: {
                            return this.lambda14();
                        }
                    }
                    return super.apply0(moduleMethod);
                }

                public Object apply1(ModuleMethod moduleMethod, Object object2) {
                    switch (moduleMethod.selector) {
                        case 9: {
                            return this.lambda5(object2);
                        }
                        case 11: {
                            return this.lambda12(object2);
                        }
                        case 12: {
                            return this.lambda13(object2);
                        }
                        case 14: {
                            return this.lambda19(object2);
                        }
                    }
                    return super.apply1(moduleMethod, object2);
                }
            }
            case 35: {
                return Frame.lambda4() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 36: {
                return Frame0.lambda9() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 37: {
                return Frame0.lambda11() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 38: {
                return Frame0.lambda16() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 39: {
                return Frame0.lambda17() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 40: {
                return Frame0.lambda18() ? Boolean.TRUE : Boolean.FALSE;
            }
        }
        return super.apply0(moduleMethod);
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 16: {
                return pregexp.pregexpReverse$Ex(object2);
            }
            case 27: {
                return pregexp.pregexpInvertCharList(object2);
            }
            case 30: {
                return pregexp.isPregexpCharWord(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 34: {
                return pregexp.pregexpMakeBackrefList(object2);
            }
            case 43: {
                return pregexp.pregexp(object2);
            }
            case 49: {
                return pregexp.pregexpQuote(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 32: {
                return pregexp.isPregexpCheckIfInCharClass(object2, object3) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 33: {
                return pregexp.pregexpListRef(object2, object3);
            }
            case 46: {
                return pregexp.pregexpSplit(object2, object3);
            }
        }
        return super.apply2(moduleMethod, object2, object3);
    }

    public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
        switch (moduleMethod.selector) {
            case 17: {
                return pregexp.pregexpReadPattern(object2, object3, object4);
            }
            case 18: {
                return pregexp.pregexpReadBranch(object2, object3, object4);
            }
            case 19: {
                return pregexp.pregexpReadPiece(object2, object3, object4);
            }
            case 20: {
                return pregexp.pregexpReadEscapedNumber(object2, object3, object4);
            }
            case 21: {
                return pregexp.pregexpReadEscapedChar(object2, object3, object4);
            }
            case 22: {
                return pregexp.pregexpReadPosixCharClass(object2, object3, object4);
            }
            case 23: {
                return pregexp.pregexpReadClusterType(object2, object3, object4);
            }
            case 24: {
                return pregexp.pregexpReadSubpattern(object2, object3, object4);
            }
            case 25: {
                return pregexp.pregexpWrapQuantifierIfAny(object2, object3, object4);
            }
            case 26: {
                return pregexp.pregexpReadNums(object2, object3, object4);
            }
            case 28: {
                return pregexp.pregexpReadCharList(object2, object3, object4);
            }
            case 31: {
                return pregexp.isPregexpAtWordBoundary(object2, object3, object4) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 47: {
                return pregexp.pregexpReplace(object2, object3, object4);
            }
            case 48: {
                return pregexp.pregexpReplace$St(object2, object3, object4);
            }
        }
        return super.apply3(moduleMethod, object2, object3, object4);
    }

    public Object apply4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5) {
        if (moduleMethod.selector == 42) {
            return pregexp.pregexpReplaceAux(object2, object3, object4, object5);
        }
        return super.apply4(moduleMethod, object2, object3, object4, object5);
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 29: {
                return pregexp.pregexpStringMatch(arrobject[0], arrobject[1], arrobject[2], arrobject[3], arrobject[4], arrobject[5]);
            }
            case 41: {
                return pregexp.pregexpMatchPositionsAux(arrobject[0], arrobject[1], arrobject[2], arrobject[3], arrobject[4], arrobject[5]);
            }
            case 44: {
                int n = arrobject.length - 2;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 2];
                }
                return pregexp.pregexpMatchPositions$V(arrobject[0], arrobject[1], arrobject2);
            }
            case 45: {
                int n = arrobject.length - 2;
                Object[] arrobject3 = new Object[n];
                while (--n >= 0) {
                    arrobject3 = arrobject3;
                    arrobject3[n] = arrobject[n + 2];
                }
                return pregexp.pregexpMatch$V(arrobject[0], arrobject[1], arrobject3);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }

}

