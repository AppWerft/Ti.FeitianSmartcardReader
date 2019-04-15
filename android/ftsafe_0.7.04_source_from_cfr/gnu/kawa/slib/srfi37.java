/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.ApplyWithValues;
import gnu.kawa.slib.srfi37;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class srfi37
extends ModuleBody {
    public static final ModuleMethod option;
    public static final ModuleMethod option$Mnnames;
    public static final ModuleMethod option$Mnrequired$Mnarg$Qu;
    public static final ModuleMethod option$Mnoptional$Mnarg$Qu;
    public static final ModuleMethod option$Mnprocessor;
    public static final ModuleMethod option$Qu;
    public static final ModuleMethod args$Mnfold;
    static final ClassType option$Mntype;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final IntNum Lit2;
    public static srfi37 $instance;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static boolean isOption(Object obj) {
        return obj instanceof option-type;
    }

    public static option-type option(Object names, Object required$Mnarg$Qu, Object optional$Mnarg$Qu, Object processor) {
        option-type tmp = new option-type();
        tmp.names = names;
        tmp.required$Mnarg$Qu = required$Mnarg$Qu;
        tmp.optional$Mnarg$Qu = optional$Mnarg$Qu;
        tmp.processor = processor;
        return tmp;
    }

    public static Object optionNames(option-type obj) {
        return obj.names;
    }

    public static Object isOptionRequiredArg(option-type obj) {
        return obj.required$Mnarg$Qu;
    }

    public static Object isOptionOptionalArg(option-type obj) {
        return obj.optional$Mnarg$Qu;
    }

    public static Object optionProcessor(option-type obj) {
        return obj.processor;
    }

    public static Object argsFold$V(Object args, Object options, Object unrecognizedOptionProc, Object operandProc, Object[] argsArray) {
        LList lList;
        public class Frame
        extends ModuleBody {
            Object operand$Mnproc;
            Object unrecognized$Mnoption$Mnproc;
            Object options;

            /*
             * Exception decompiling
             */
            public Object lambda1scanArgs(Object args, Object seeds) {
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
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public static Object lambda2find(Object l, Object $Qu) {
                Object object2;
                Object object3;
                do {
                    if (lists.isNull(l)) {
                        object3 = Boolean.FALSE;
                        return object3;
                    }
                    object2 = Promise.force(l, Pair.class);
                    if (!KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply2($Qu, lists.car((Pair)object2)))) break block8;
                    break;
                } while (true);
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object2);
                }
                {
                    block8 : {
                        object2 = Promise.force(l, Pair.class);
                        object3 = lists.car((Pair)object2);
                        return object3;
                    }
                    object2 = Promise.force(l, Pair.class);
                    l = lists.cdr((Pair)object2);
                    continue;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object2);
                }
            }

            public Object lambda3findOption(Object name) {
                new Frame0().staticLink = this;
                public class Frame0
                extends ModuleBody {
                    Object name;
                    Frame staticLink;
                    final ModuleMethod lambda$Fn1;
                    final ModuleMethod lambda$Fn2;

                    public Frame0() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:73");
                        this.lambda$Fn2 = moduleMethod;
                        ModuleMethod moduleMethod2 = new ModuleMethod(this, 2, null, 4097);
                        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:70");
                        this.lambda$Fn1 = moduleMethod2;
                    }

                    Object lambda4(Object option) {
                        Object object2 = Promise.force(option, option-type.class);
                        try {
                            return Frame.lambda2find(srfi37.optionNames((option-type)object2), this.lambda$Fn2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "option-names", 0, object2);
                        }
                    }

                    Object lambda5(Object test$Mnname) {
                        return ((Procedure)Scheme.isEqual).apply2(this.name, test$Mnname);
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
                                return this.lambda5(object2);
                            }
                            case 2: {
                                return this.lambda4(object2);
                            }
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame0 $heapFrame = new Frame0();
                $heapFrame.name = name;
                return Frame.lambda2find(this.options, $heapFrame.lambda$Fn1);
            }

            /*
             * Exception decompiling
             */
            public Object lambda6scanShortOptions(IntNum index, Object shorts, Object args, Object seeds) {
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
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda10scanOperands(Object operands, Object seeds) {
                Object object2;
                new Frame2().staticLink = this;
                public class Frame2
                extends ModuleBody {
                    Object operands;
                    Frame staticLink;
                    final ModuleMethod lambda$Fn6;

                    public Frame2() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 6, null, -4096);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:123");
                        this.lambda$Fn6 = moduleMethod;
                    }

                    Object lambda11$V(Object[] argsArray) {
                        Object object2 = LList.makeList(argsArray, 0);
                        LList seeds = object2;
                        object2 = Promise.force(this.operands, Pair.class);
                        try {
                            return this.staticLink.lambda10scanOperands(lists.cdr((Pair)object2), seeds);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "cdr", 1, object2);
                        }
                    }

                    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
                        if (moduleMethod.selector == 6) {
                            callContext.values = arrobject;
                            callContext.proc = moduleMethod;
                            callContext.pc = 5;
                            return 0;
                        }
                        return super.matchN(moduleMethod, arrobject, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
                        if (moduleMethod.selector == 6) {
                            return this.lambda11$V(arrobject);
                        }
                        return super.applyN(moduleMethod, arrobject);
                    }
                }
                Frame2 $heapFrame = new Frame2();
                $heapFrame.operands = operands;
                if (lists.isNull($heapFrame.operands)) {
                    object2 = ((Procedure)Scheme.apply).apply2(misc.values, seeds);
                    return object2;
                }
                Object object22 = Promise.force($heapFrame.operands, Pair.class);
                try {
                    object2 = ((Procedure)ApplyWithValues.applyWithValues).apply2(((Procedure)Scheme.apply).apply3(this.operand$Mnproc, lists.car((Pair)object22), seeds), $heapFrame.lambda$Fn6);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object22);
                }
                return object2;
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.options = options;
        $heapFrame.unrecognized$Mnoption$Mnproc = unrecognizedOptionProc;
        $heapFrame.operand$Mnproc = operandProc;
        LList seeds = lList = LList.makeList(argsArray, 0);
        return $heapFrame.lambda1scanArgs(args, seeds);
    }

    public static {
        Lit9 = Symbol.valueOf("args-fold");
        Lit8 = Symbol.valueOf("option-processor");
        Lit7 = Symbol.valueOf("option-optional-arg?");
        Lit6 = Symbol.valueOf("option-required-arg?");
        Lit5 = Symbol.valueOf("option-names");
        Lit4 = Symbol.valueOf("option");
        Lit3 = Symbol.valueOf("option?");
        Lit2 = IntNum.valueOf(0);
        Lit1 = IntNum.valueOf(1);
        Lit0 = IntNum.valueOf(3);
        option$Mntype = (ClassType)Type.make(option-type.class);
        srfi37 srfi372 = $instance = new srfi37();
        option$Qu = new ModuleMethod(srfi372, 11, Lit3, 4097);
        option = new ModuleMethod(srfi372, 12, Lit4, 16388);
        option$Mnnames = new ModuleMethod(srfi372, 13, Lit5, 4097);
        option$Mnrequired$Mnarg$Qu = new ModuleMethod(srfi372, 14, Lit6, 4097);
        option$Mnoptional$Mnarg$Qu = new ModuleMethod(srfi372, 15, Lit7, 4097);
        option$Mnprocessor = new ModuleMethod(srfi372, 16, Lit8, 4097);
        args$Mnfold = new ModuleMethod(srfi372, 17, Lit9, -4092);
        srfi37.$runBody$();
    }

    public srfi37() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 16: {
                Object object3 = Promise.force(object2, option-type.class);
                if (!(object3 instanceof option-type)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 15: {
                Object object4 = Promise.force(object2, option-type.class);
                if (!(object4 instanceof option-type)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object5 = Promise.force(object2, option-type.class);
                if (!(object5 instanceof option-type)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 13: {
                Object object6 = Promise.force(object2, option-type.class);
                if (!(object6 instanceof option-type)) {
                    return -786431;
                }
                callContext.value1 = object6;
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
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        if (moduleMethod.selector == 12) {
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
        if (moduleMethod.selector == 17) {
            callContext.values = arrobject;
            callContext.proc = moduleMethod;
            callContext.pc = 5;
            return 0;
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
            case 11: {
                Boolean bl;
                if (srfi37.isOption(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 13: {
                return srfi37.optionNames((option-type)Promise.force(object2, option-type.class));
            }
            case 14: {
                return srfi37.isOptionRequiredArg((option-type)Promise.force(object2, option-type.class));
            }
            case 15: {
                return srfi37.isOptionOptionalArg((option-type)Promise.force(object2, option-type.class));
            }
            case 16: {
                return srfi37.optionProcessor((option-type)Promise.force(object2, option-type.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "option-names", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "option-required-arg?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "option-optional-arg?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "option-processor", 1, object2);
        }
    }

    public Object apply4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5) {
        if (moduleMethod.selector == 12) {
            return srfi37.option(object2, object3, object4, object5);
        }
        return super.apply4(moduleMethod, object2, object3, object4, object5);
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        if (moduleMethod.selector == 17) {
            int n = arrobject.length - 4;
            Object[] arrobject2 = new Object[n];
            while (--n >= 0) {
                arrobject2 = arrobject2;
                arrobject2[n] = arrobject[n + 4];
            }
            return srfi37.argsFold$V(arrobject[0], arrobject[1], arrobject[2], arrobject[3], arrobject2);
        }
        return super.applyN(moduleMethod, arrobject);
    }

    public class option-type {
        public Object names;
        public Object required$Mnarg$Qu;
        public Object optional$Mnarg$Qu;
        public Object processor;
    }

}

