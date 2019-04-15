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
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.io.OutPort;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.slib.printf;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.LocationProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.RealNum;
import gnu.text.Char;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.append;

public class printf
extends ModuleBody {
    static boolean stdio$Clhex$Mnupper$Mncase$Qu;
    static final ModuleMethod stdio$Cliprintf;
    public static final ModuleMethod fprintf;
    public static final ModuleMethod printf;
    public static final ModuleMethod sprintf;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final Char Lit2;
    static final Char Lit3;
    static final Char Lit4;
    static final Char Lit5;
    static final Char Lit6;
    static final Char Lit7;
    static final Char Lit8;
    static final Char Lit9;
    static final Char Lit10;
    static final Char Lit11;
    static final Char Lit12;
    static final IntNum Lit13;
    static final Char Lit14;
    static final Char Lit15;
    static final Char Lit16;
    static final Char Lit17;
    static final Char Lit18;
    static final Char Lit19;
    static final Char Lit20;
    static final Char Lit21;
    static final Char Lit22;
    static final PairWithPosition Lit23;
    static final SimpleSymbol Lit24;
    static final Char Lit25;
    static final Char Lit26;
    static final Char Lit27;
    static final Char Lit28;
    static final Char Lit29;
    static final Char Lit30;
    static final Char Lit31;
    static final Char Lit32;
    static final Char Lit33;
    static final Char Lit34;
    static final Char Lit35;
    static final Char Lit36;
    static final IntNum Lit37;
    static final Char Lit38;
    static final Char Lit39;
    static final Char Lit40;
    static final Char Lit41;
    static final IntNum Lit42;
    static final Char Lit43;
    static final Char Lit44;
    static final Char Lit45;
    static final IntNum Lit46;
    static final Char Lit47;
    static final IntNum Lit48;
    static final IntNum Lit49;
    static final IntNum Lit50;
    static final IntNum Lit51;
    static final IntNum Lit52;
    static final FVector Lit53;
    static final PairWithPosition Lit54;
    static final SimpleSymbol Lit55;
    static final Char Lit56;
    static final Char Lit57;
    static final Char Lit58;
    static final Char Lit59;
    static final Char Lit60;
    static final Char Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final PairWithPosition Lit64;
    static final Char Lit65;
    static final PairWithPosition Lit66;
    static final IntNum Lit67;
    static final IntNum Lit68;
    public static printf $instance;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        stdio$Clhex$Mnupper$Mncase$Qu = strings.isString$Eq("-F", numbers.number$To$String(Lit0, 16), new CharSequence[0]);
    }

    /*
     * Exception decompiling
     */
    static Object stdio$ClIprintf$V(Object out, Object formatString, Object[] argsArray) {
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
    static Object stdio$ClRoundString(CharSequence str, Object ndigs, Object strip$Mn0s) {
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

    static Object stdio$ClParseFloat(Object str, Object proc) {
        public class Frame4
        extends ModuleBody {
            Object proc;
            Object str;
            int n;
            final ModuleMethod lambda$Fn8;

            public Frame4() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 19, null, 16388);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:106");
                this.lambda$Fn8 = moduleMethod;
            }

            /*
             * Exception decompiling
             */
            public Object lambda17real(Object n, Object i, Procedure cont) {
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
            Object lambda18(Object i, Object sgn, Object digs, Object ex) {
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

            public static boolean lambda20parseError() {
                return false;
            }

            /*
             * Exception decompiling
             */
            public Object lambda23sign(Object n, Object i, Procedure cont) {
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
            public Object lambda24digits(Object n, Object i, Procedure cont) {
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

            public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
                if (moduleMethod.selector == 19) {
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

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5) {
                if (moduleMethod.selector == 19) {
                    return this.lambda18(object2, object3, object4, object5);
                }
                return super.apply4(moduleMethod, object2, object3, object4, object5);
            }
        }
        Frame4 $heapFrame = new Frame4();
        $heapFrame.str = str;
        $heapFrame.proc = proc;
        Object object2 = Promise.force($heapFrame.str, CharSequence.class);
        try {
            $heapFrame.n = strings.stringLength((CharSequence)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-length", 1, object2);
        }
        return $heapFrame.lambda17real($heapFrame.n, Lit13, $heapFrame.lambda$Fn8);
    }

    public static IntNum fprintf$V(Object port, Object format, Object[] argsArray) {
        LList lList;
        public class Frame2
        extends ModuleBody {
            Object port;
            IntNum cnt;
            final ModuleMethod lambda$Fn6;

            public Frame2() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 8, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:547");
                this.lambda$Fn6 = moduleMethod;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            boolean lambda15(Object x) {
                if (!strings.isString(x)) {
                    this.cnt = IntNum.add(this.cnt, 1);
                    ports.display(x, this.port);
                    return true;
                }
                Object object2 = Promise.force(x, CharSequence.class);
                try {
                    this.cnt = IntNum.add(this.cnt, strings.stringLength((CharSequence)object2));
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "string-length", 1, object2);
                }
                ports.display(x, this.port);
                return true;
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
                    return this.lambda15(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame2 $heapFrame = new Frame2();
        $heapFrame.port = port;
        LList args = lList = LList.makeList(argsArray, 0);
        $heapFrame.cnt = Lit13;
        ((Procedure)Scheme.apply).apply4(stdio$Cliprintf, $heapFrame.lambda$Fn6, format, args);
        return $heapFrame.cnt;
    }

    public static Object printf$V(Object format, Object[] argsArray) {
        LList lList;
        LList args = lList = LList.makeList(argsArray, 0);
        return ((Procedure)Scheme.apply).apply4(fprintf, ports.current$Mnoutput$Mnport.getValue(), format, args);
    }

    /*
     * Exception decompiling
     */
    public static Object sprintf$V(Object str, Object format, Object[] argsArray) {
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
        Lit70 = Symbol.valueOf("fprintf");
        Lit69 = Symbol.valueOf("stdio:iprintf");
        Lit68 = IntNum.valueOf(9);
        Lit67 = IntNum.valueOf(5);
        Lit40 = Char.valueOf(101);
        Lit58 = Char.valueOf(115);
        Lit3 = Char.valueOf(102);
        Lit39 = Char.valueOf(100);
        Lit21 = Char.valueOf(108);
        Lit26 = Char.valueOf(69);
        Lit35 = Char.valueOf(83);
        Lit5 = Char.valueOf(70);
        Lit25 = Char.valueOf(68);
        Lit20 = Char.valueOf(76);
        Lit66 = PairWithPosition.make(Lit40, PairWithPosition.make(Lit58, PairWithPosition.make(Lit3, PairWithPosition.make(Lit39, PairWithPosition.make(Lit21, PairWithPosition.make(Lit26, PairWithPosition.make(Lit35, PairWithPosition.make(Lit5, PairWithPosition.make(Lit25, PairWithPosition.make(Lit20, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266284), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266280), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266276), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266272), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266268), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266264), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266256), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266252), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266247);
        Lit65 = Char.valueOf(64);
        Lit17 = Char.valueOf(43);
        Lit18 = Char.valueOf(45);
        Lit64 = PairWithPosition.make(Lit17, PairWithPosition.make(Lit18, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 446503), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 446498);
        Lit63 = Symbol.valueOf("sprintf");
        Lit62 = Symbol.valueOf("pad");
        Lit61 = Char.valueOf(42);
        Lit60 = Char.valueOf(63);
        Lit59 = Char.valueOf(120);
        Lit57 = Char.valueOf(117);
        Lit56 = Char.valueOf(105);
        Lit55 = Symbol.valueOf("format-real");
        Lit54 = PairWithPosition.make("i", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1638411);
        Lit53 = FVector.make("y", "z", "a", "f", "p", "n", "u", "m", "", "k", "M", "G", "T", "P", "E", "Z", "Y");
        Lit52 = IntNum.valueOf(3);
        Lit51 = IntNum.valueOf(10);
        Lit50 = IntNum.valueOf(-10);
        Lit49 = IntNum.valueOf(1);
        Lit48 = IntNum.valueOf(6);
        Lit47 = Char.valueOf(107);
        Lit46 = IntNum.valueOf(8);
        Lit45 = Char.valueOf(111);
        Lit44 = Char.valueOf(97);
        Lit43 = Char.valueOf(99);
        Lit42 = IntNum.valueOf(2);
        Lit41 = Char.valueOf(98);
        Lit38 = Char.valueOf(103);
        Lit37 = IntNum.valueOf(16);
        Lit36 = Char.valueOf(88);
        Lit34 = Char.valueOf(85);
        Lit33 = Char.valueOf(75);
        Lit32 = Char.valueOf(73);
        Lit31 = Char.valueOf(79);
        Lit30 = Char.valueOf(67);
        Lit29 = Char.valueOf(66);
        Lit28 = Char.valueOf(65);
        Lit27 = Char.valueOf(71);
        Lit24 = Symbol.valueOf("printf");
        Lit23 = PairWithPosition.make(Lit43, PairWithPosition.make(Lit58, PairWithPosition.make(Lit44, PairWithPosition.make(Lit39, PairWithPosition.make(Lit56, PairWithPosition.make(Lit57, PairWithPosition.make(Lit45, PairWithPosition.make(Lit59, PairWithPosition.make(Lit41, PairWithPosition.make(Lit3, PairWithPosition.make(Lit40, PairWithPosition.make(Lit38, PairWithPosition.make(Lit47, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785876), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785872), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785868), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785864), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781800), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781796), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781792), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781788), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781784), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781780), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781776), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781772), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781767);
        Lit22 = Char.valueOf(104);
        Lit19 = Char.valueOf(46);
        Lit16 = Char.valueOf(48);
        Lit15 = Char.valueOf(32);
        Lit14 = Char.valueOf(35);
        Lit13 = IntNum.valueOf(0);
        Lit12 = Char.valueOf(37);
        Lit11 = Char.valueOf(78);
        Lit10 = Char.valueOf(10);
        Lit9 = Char.valueOf(110);
        Lit8 = Char.valueOf(9);
        Lit7 = Char.valueOf(116);
        Lit6 = Char.valueOf(12);
        Lit4 = Char.valueOf(84);
        Lit2 = Char.valueOf(92);
        Lit1 = IntNum.valueOf(-1);
        Lit0 = IntNum.valueOf(-15);
        printf printf2 = $instance = new printf();
        stdio$Cliprintf = new ModuleMethod(printf2, 20, Lit69, -4094);
        fprintf = new ModuleMethod(printf2, 21, Lit70, -4094);
        printf = new ModuleMethod(printf2, 22, Lit24, -4095);
        sprintf = new ModuleMethod(printf2, 23, Lit63, -4094);
        printf.$runBody$();
    }

    public printf() {
        ModuleInfo.register(this);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 23: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 22: {
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
            case 20: {
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

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 20: {
                int n = arrobject.length - 2;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 2];
                }
                return printf.stdio$ClIprintf$V(arrobject[0], arrobject[1], arrobject2);
            }
            case 21: {
                int n = arrobject.length - 2;
                Object[] arrobject3 = new Object[n];
                while (--n >= 0) {
                    arrobject3 = arrobject3;
                    arrobject3[n] = arrobject[n + 2];
                }
                return printf.fprintf$V(arrobject[0], arrobject[1], arrobject3);
            }
            case 22: {
                int n = arrobject.length - 1;
                Object[] arrobject4 = new Object[n];
                while (--n >= 0) {
                    arrobject4 = arrobject4;
                    arrobject4[n] = arrobject[n + 1];
                }
                return printf.printf$V(arrobject[0], arrobject4);
            }
            case 23: {
                int n = arrobject.length - 2;
                Object[] arrobject5 = new Object[n];
                while (--n >= 0) {
                    arrobject5 = arrobject5;
                    arrobject5[n] = arrobject[n + 2];
                }
                return printf.sprintf$V(arrobject[0], arrobject[1], arrobject5);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }

}

