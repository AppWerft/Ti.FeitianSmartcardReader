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
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyWithValues;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.slib.Stream;
import gnu.kawa.slib.StreamPair;
import gnu.kawa.slib.StreamPromise;
import gnu.kawa.slib.StreamsDerived;
import gnu.kawa.slib.StreamsPrimitive;
import gnu.kawa.slib.srfi1;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.LocationProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RealNum;
import java.io.Serializable;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.std_syntax;
import kawa.standard.Scheme;
import kawa.standard.append;
import kawa.standard.syntax_case;

public class StreamsDerived
extends ModuleBody {
    public static final StaticFieldLocation stream$Mnnull;
    public static final StaticFieldLocation stream$Mncons;
    public static final StaticFieldLocation stream$Qu;
    public static final StaticFieldLocation stream$Mnnull$Qu;
    public static final StaticFieldLocation stream$Mnpair$Qu;
    public static final StaticFieldLocation stream$Mncar;
    public static final StaticFieldLocation stream$Mncdr;
    public static final StaticFieldLocation stream$Mnlambda;
    public static final Macro define$Mnstream;
    public static final ModuleMethod list$Mn$Grstream;
    public static final ModuleMethod port$Mn$Grstream;
    public static final Macro stream;
    public static final ModuleMethod stream$Mn$Grlist;
    public static final ModuleMethod stream$Mnappend;
    public static final ModuleMethod stream$Mnconcat;
    public static final ModuleMethod stream$Mnconstant;
    public static final ModuleMethod stream$Mndrop;
    public static final ModuleMethod stream$Mndrop$Mnwhile;
    public static final ModuleMethod stream$Mnfilter;
    public static final ModuleMethod stream$Mnfold;
    public static final ModuleMethod stream$Mnfor$Mneach;
    public static final ModuleMethod stream$Mnfrom;
    public static final ModuleMethod stream$Mniterate;
    public static final ModuleMethod stream$Mnlength;
    public static final Macro stream$Mnlet;
    public static final ModuleMethod stream$Mnmap;
    public static final Macro stream$Mnmatch;
    public static final Macro stream$Mnof;
    public static final ModuleMethod stream$Mnrange;
    public static final ModuleMethod stream$Mnref;
    public static final ModuleMethod stream$Mnreverse;
    public static final ModuleMethod stream$Mnscan;
    public static final ModuleMethod stream$Mntake;
    public static final ModuleMethod stream$Mntake$Mnwhile;
    public static final ModuleMethod stream$Mnunfold;
    public static final ModuleMethod stream$Mnunfolds;
    public static final ModuleMethod stream$Mnzip;
    public static final int $Pcprovide$Pcsrfi$Mn41$Mnstreams$Mnderived = 123;
    public static final Macro $Prvt$stream$Mnmatch$Mntest;
    public static final Macro $Prvt$stream$Mnmatch$Mnpattern;
    public static final Macro $Prvt$stream$Mnof$Mnaux;
    static final SimpleSymbol Lit0;
    static final IntNum Lit1;
    static final ModuleMethod lambda$Fn7;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final ModuleMethod lambda$Fn26;
    static final IntNum Lit6;
    static final IntNum Lit7;
    static final SimpleSymbol Lit8;
    static final ModuleMethod lambda$Fn33;
    static final SimpleSymbol Lit9;
    static final ModuleMethod lambda$Fn45;
    static final SimpleSymbol Lit10;
    static final ModuleMethod lambda$Fn57;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final ModuleMethod lambda$Fn65;
    public static StreamsDerived $instance;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SyntaxRules Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SyntaxRules Lit26;
    static final SimpleSymbol Lit27;
    static final SyntaxRules Lit28;
    static final SimpleSymbol Lit29;
    static final SyntaxRules Lit30;
    static final SimpleSymbol Lit31;
    static final SyntaxPattern Lit32;
    static final SyntaxTemplate Lit33;
    static final SyntaxPattern Lit34;
    static final SyntaxTemplate Lit35;
    static final SyntaxTemplate Lit36;
    static final SyntaxPattern Lit37;
    static final SyntaxTemplate Lit38;
    static final SyntaxPattern Lit39;
    static final SyntaxTemplate Lit40;
    static final SyntaxTemplate Lit41;
    static final SyntaxPattern Lit42;
    static final SyntaxTemplate Lit43;
    static final SyntaxTemplate Lit44;
    static final SimpleSymbol Lit45;
    static final SyntaxRules Lit46;
    static final SimpleSymbol Lit47;
    static final SyntaxRules Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final PairWithPosition Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final Object[] Lit60;
    static final SimpleSymbol Lit61;
    static final Object[] Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final PairWithPosition Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        ModuleMethod exists = srfi1.any;
    }

    public static Stream list$To$Stream(LList objs) {
        public class Frame
        extends ModuleBody {
            public Object lambda1list$To$Stream(LList objs) {
                new Frame0().staticLink = this;
                public class Frame0
                extends ModuleBody {
                    LList objs;
                    Frame staticLink;
                    final ModuleMethod lambda$Fn1;
                    final ModuleMethod lambda$Fn2;
                    final ModuleMethod lambda$Fn3;

                    public Frame0() {
                        this.lambda$Fn2 = new ModuleMethod(this, 1, null, 0);
                        this.lambda$Fn3 = new ModuleMethod(this, 2, null, 0);
                        this.lambda$Fn1 = new ModuleMethod(this, 3, null, 0);
                    }

                    Object lambda2() {
                        return lists.isNull(this.objs) ? StreamsPrimitive.stream$Mnnull : new StreamPair(new StreamPromise(this.lambda$Fn2, false), new StreamPromise(this.lambda$Fn3, true));
                    }

                    Object lambda3() {
                        LList lList = this.objs;
                        try {
                            return lists.car((Pair)lList);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "car", 1, (Object)lList);
                        }
                    }

                    Object lambda4() {
                        Object object2 = this.objs;
                        try {
                            object2 = Promise.force(lists.cdr((Pair)object2), LList.class);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "cdr", 1, object2);
                        }
                        try {
                            return this.staticLink.lambda1list$To$Stream((LList)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "list->stream", 0, object2);
                        }
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 3: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 2: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 1: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 1: {
                                return this.lambda3();
                            }
                            case 2: {
                                return this.lambda4();
                            }
                            case 3: {
                                return this.lambda2();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame0 $heapFrame = new Frame0();
                $heapFrame.objs = objs;
                return new StreamPromise($heapFrame.lambda$Fn1, true);
            }
        }
        Frame $heapFrame = new Frame();
        return (Stream)$heapFrame.lambda1list$To$Stream(objs);
    }

    public static Stream port$To$Stream() {
        return StreamsDerived.port$To$Stream(ports.current$Mninput$Mnport.getValue());
    }

    public static Stream port$To$Stream(InPort p) {
        public class Frame1
        extends ModuleBody {
            public Object lambda5port$To$Stream(InPort p) {
                new Frame2().staticLink = this;
                public class Frame2
                extends ModuleBody {
                    InPort p;
                    Frame1 staticLink;
                    final ModuleMethod lambda$Fn4;

                    public Frame2() {
                        this.lambda$Fn4 = new ModuleMethod(this, 6, null, 0);
                    }

                    Object lambda6() {
                        new Frame3().staticLink = this;
                        public class Frame3
                        extends ModuleBody {
                            @kawa.SourceType(value="character")
                            int c;
                            Frame2 staticLink;
                            final ModuleMethod lambda$Fn5;
                            final ModuleMethod lambda$Fn6;

                            public Frame3() {
                                this.lambda$Fn5 = new ModuleMethod(this, 4, null, 0);
                                this.lambda$Fn6 = new ModuleMethod(this, 5, null, 0);
                            }

                            @kawa.SourceMethodType(value={"character"})
                            int lambda7() {
                                return this.c;
                            }

                            Object lambda8() {
                                return this.staticLink.staticLink.lambda5port$To$Stream(this.staticLink.p);
                            }

                            public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                                switch (moduleMethod.selector) {
                                    case 5: {
                                        callContext.proc = moduleMethod;
                                        callContext.pc = 0;
                                        return 0;
                                    }
                                    case 4: {
                                        callContext.proc = moduleMethod;
                                        callContext.pc = 0;
                                        return 0;
                                    }
                                }
                                return super.match0(moduleMethod, callContext);
                            }

                            public void apply(CallContext callContext) {
                                ModuleMethod.applyError();
                            }

                            public Object apply0(ModuleMethod moduleMethod) {
                                switch (moduleMethod.selector) {
                                    case 4: {
                                        return gnu.text.Char.make(this.lambda7());
                                    }
                                    case 5: {
                                        return this.lambda8();
                                    }
                                }
                                return super.apply0(moduleMethod);
                            }
                        }
                        Frame3 $heapFrame = new Frame3();
                        $heapFrame.c = ports.readChar(this.p);
                        return $heapFrame.c == -1 ? StreamsPrimitive.stream$Mnnull : new StreamPair(new StreamPromise($heapFrame.lambda$Fn5, false), new StreamPromise($heapFrame.lambda$Fn6, true));
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        if (moduleMethod.selector == 6) {
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
                        if (moduleMethod.selector == 6) {
                            return this.lambda6();
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame2 $heapFrame = new Frame2();
                $heapFrame.p = p;
                return new StreamPromise($heapFrame.lambda$Fn4, true);
            }
        }
        Frame1 $heapFrame = new Frame1();
        return (Stream)$heapFrame.lambda5port$To$Stream(p);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static LList stream$To$List$V(Object[] argsArray) {
        void n;
        Object object2;
        IntNum intNum;
        Stream strm;
        block18 : {
            Stream stream;
            Object object3;
            Serializable serializable = LList.makeList(argsArray, 0);
            LList args = serializable;
            if (args.size() == 1) {
                object3 = Boolean.FALSE;
            } else {
                LList lList = args;
                object3 = serializable = lists.car((Pair)lList);
            }
            if (args.size() == 1) {
                object2 = args;
                object2 = lists.car((Pair)object2);
                stream = (Stream)object2;
            }
            object2 = lists.cadr(args);
            try {
                stream = strm = (Stream)object2;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "strm", -2, object2);
            }
            if (KawaConvert.isTrue(n) && !numbers.isInteger(n)) {
                Type.NeverReturns neverReturns = exceptions.error(Lit0, "non-integer count");
                throw Special.reachedUnexpected;
            }
            if (KawaConvert.isTrue(n)) {
                object2 = Promise.force(n, RealNum.class);
                if (!numbers.isNegative(LangObjType.coerceRealNum(object2))) break block18;
                Type.NeverReturns neverReturns = exceptions.error(Lit0, "negative count");
                throw Special.reachedUnexpected;
            }
        }
        if (!KawaConvert.isTrue(n)) {
            intNum = Lit1;
            return (LList)Promise.force(StreamsDerived.lambda9loop(intNum, strm), LList.class);
        }
        object2 = Promise.force(n, IntNum.class);
        try {
            intNum = LangObjType.coerceIntNum(object2);
            return (LList)Promise.force(StreamsDerived.lambda9loop(intNum, strm), LList.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "loop", 0, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, (Object)strm);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "strm", -2, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "negative?", 1, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object lambda9loop(IntNum n, Stream strm) {
        LList lList;
        boolean x = numbers.isZero(n);
        if (x ? x : StreamsPrimitive.isStreamNull(strm)) {
            lList = LList.Empty;
            return lList;
        }
        Object object2 = StreamsPrimitive.streamCdr(strm);
        try {
            lList = lists.cons(StreamsPrimitive.streamCar(strm), StreamsDerived.lambda9loop(IntNum.add(n, -1), (Stream)object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "loop", 1, object2);
        }
        return lList;
    }

    public static Stream streamAppend$V(Object[] argsArray) {
        Stream stream;
        public class Frame4
        extends ModuleBody {
            static boolean lambda10(Object x) {
                return !StreamsPrimitive.isStream(x);
            }

            public Object lambda11streamAppend(LList strms) {
                new Frame5().staticLink = this;
                public class Frame5
                extends ModuleBody {
                    LList strms;
                    Frame4 staticLink;
                    final ModuleMethod lambda$Fn8;
                    final ModuleMethod lambda$Fn9;
                    final ModuleMethod lambda$Fn10;

                    public Frame5() {
                        this.lambda$Fn9 = new ModuleMethod(this, 7, null, 0);
                        this.lambda$Fn10 = new ModuleMethod(this, 8, null, 0);
                        this.lambda$Fn8 = new ModuleMethod(this, 9, null, 0);
                    }

                    Object lambda12() {
                        Object object2;
                        block12 : {
                            block11 : {
                                Object object3;
                                block10 : {
                                    object3 = this.strms;
                                    try {
                                        if (!lists.isNull(lists.cdr((Pair)object3))) break block10;
                                        object3 = this.strms;
                                    }
                                    catch (ClassCastException classCastException) {
                                        throw new WrongType(classCastException, "cdr", 1, object3);
                                    }
                                    try {
                                        object2 = lists.car((Pair)object3);
                                    }
                                    catch (ClassCastException classCastException) {
                                        throw new WrongType(classCastException, "car", 1, object3);
                                    }
                                }
                                object3 = this.strms;
                                try {
                                    if (!StreamsPrimitive.isStreamNull(lists.car((Pair)object3))) break block11;
                                    object3 = this.strms;
                                }
                                catch (ClassCastException classCastException) {
                                    throw new WrongType(classCastException, "car", 1, object3);
                                }
                                try {
                                    object3 = Promise.force(lists.cdr((Pair)object3), LList.class);
                                }
                                catch (ClassCastException classCastException) {
                                    throw new WrongType(classCastException, "cdr", 1, object3);
                                }
                                try {
                                    object2 = this.staticLink.lambda11streamAppend((LList)object3);
                                    break block12;
                                }
                                catch (ClassCastException classCastException) {
                                    throw new WrongType(classCastException, "stream-append", 0, object3);
                                }
                            }
                            object2 = new StreamPair(new StreamPromise(this.lambda$Fn9, false), new StreamPromise(this.lambda$Fn10, true));
                        }
                        return object2;
                    }

                    Object lambda13() {
                        LList lList = this.strms;
                        try {
                            return StreamsPrimitive.streamCar(lists.car((Pair)lList));
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "car", 1, (Object)lList);
                        }
                    }

                    /*
                     * Exception decompiling
                     */
                    Object lambda14() {
                        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
                        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
                        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
                        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
                        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
                        // org.benf.cfr.reader.entities.Method.dump(Method.java:474)
                        // org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:87)
                        // org.benf.cfr.reader.entities.ClassFile.dumpAsInlineClass(ClassFile.java:1004)
                        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredDefinition.dump(StructuredDefinition.java:45)
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:204)
                        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:543)
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:204)
                        // org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:141)
                        // org.benf.cfr.reader.util.output.TypeOverridingDumper.dump(TypeOverridingDumper.java:97)
                        // org.benf.cfr.reader.entities.Method.dump(Method.java:493)
                        // org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:87)
                        // org.benf.cfr.reader.entities.ClassFile.dumpAsInlineClass(ClassFile.java:1004)
                        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredDefinition.dump(StructuredDefinition.java:45)
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:204)
                        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:543)
                        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:204)
                        // org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:141)
                        // org.benf.cfr.reader.util.output.TypeOverridingDumper.dump(TypeOverridingDumper.java:97)
                        // org.benf.cfr.reader.entities.Method.dump(Method.java:493)
                        // org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:87)
                        // org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1000)
                        // org.benf.cfr.reader.Driver.doJar(Driver.java:134)
                        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                        // org.benf.cfr.reader.Main.main(Main.java:48)
                        throw new IllegalStateException("Decompilation failed");
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 9: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 8: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 7: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 7: {
                                return this.lambda13();
                            }
                            case 8: {
                                return this.lambda14();
                            }
                            case 9: {
                                return this.lambda12();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame5 $heapFrame = new Frame5();
                $heapFrame.strms = strms;
                return new StreamPromise($heapFrame.lambda$Fn8, true);
            }
        }
        Frame4 $heapFrame = new Frame4();
        LList lList = LList.makeList(argsArray, 0);
        LList strms = lList;
        if (lists.isNull(strms)) {
            stream = StreamsPrimitive.stream$Mnnull;
        } else {
            if (KawaConvert.isTrue(srfi1.any$V(lambda$Fn7, strms, new Object[0]))) {
                Type.NeverReturns neverReturns = exceptions.error(Lit2, "non-stream argument");
                throw Special.reachedUnexpected;
            }
            stream = (Stream)$heapFrame.lambda11streamAppend(strms);
        }
        return stream;
    }

    public static Stream streamConcat(Stream strms) {
        public class Frame6
        extends ModuleBody {
            public Object lambda15streamConcat(Stream strms) {
                new Frame7().staticLink = this;
                public class Frame7
                extends ModuleBody {
                    Stream strms;
                    Frame6 staticLink;
                    final ModuleMethod lambda$Fn11;
                    final ModuleMethod lambda$Fn12;
                    final ModuleMethod lambda$Fn13;
                    final ModuleMethod lambda$Fn14;
                    final ModuleMethod lambda$Fn15;

                    public Frame7() {
                        this.lambda$Fn12 = new ModuleMethod(this, 10, null, 0);
                        this.lambda$Fn14 = new ModuleMethod(this, 11, null, 0);
                        this.lambda$Fn15 = new ModuleMethod(this, 12, null, 0);
                        this.lambda$Fn13 = new ModuleMethod(this, 13, null, 0);
                        this.lambda$Fn11 = new ModuleMethod(this, 14, null, 0);
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    Object lambda16() {
                        Object object2;
                        if (StreamsPrimitive.isStreamNull(this.strms)) {
                            object2 = StreamsPrimitive.stream$Mnnull;
                            return object2;
                        }
                        if (!StreamsPrimitive.isStream(StreamsPrimitive.streamCar(this.strms))) {
                            Type.NeverReturns neverReturns = exceptions.error(StreamsDerived.Lit3, "non-stream object in input stream");
                            throw Special.reachedUnexpected;
                        }
                        if (!StreamsPrimitive.isStreamNull(StreamsPrimitive.streamCar(this.strms))) {
                            object2 = new StreamPair(new StreamPromise(this.lambda$Fn12, false), new StreamPromise(this.lambda$Fn13, true));
                            return object2;
                        }
                        Object object22 = StreamsPrimitive.streamCdr(this.strms);
                        try {
                            object2 = this.staticLink.lambda15streamConcat((Stream)object22);
                            return object2;
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-concat", 0, object22);
                        }
                    }

                    Object lambda17() {
                        return StreamsPrimitive.streamCar(StreamsPrimitive.streamCar(this.strms));
                    }

                    Object lambda18() {
                        return this.staticLink.lambda15streamConcat(new StreamPair(new StreamPromise(this.lambda$Fn14, false), new StreamPromise(this.lambda$Fn15, true)));
                    }

                    Object lambda19() {
                        return StreamsPrimitive.streamCdr(StreamsPrimitive.streamCar(this.strms));
                    }

                    Object lambda20() {
                        return StreamsPrimitive.streamCdr(this.strms);
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 14: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 13: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 12: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 11: {
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

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 10: {
                                return this.lambda17();
                            }
                            case 11: {
                                return this.lambda19();
                            }
                            case 12: {
                                return this.lambda20();
                            }
                            case 13: {
                                return this.lambda18();
                            }
                            case 14: {
                                return this.lambda16();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame7 $heapFrame = new Frame7();
                $heapFrame.strms = strms;
                return new StreamPromise($heapFrame.lambda$Fn11, true);
            }
        }
        Frame6 $heapFrame = new Frame6();
        return (Stream)$heapFrame.lambda15streamConcat(strms);
    }

    public static Object streamConstant$V(Object[] argsArray) {
        LList lList;
        public class Frame8
        extends ModuleBody {
            LList objs;
            final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 19, null, 0);
            final ModuleMethod lambda$Fn17 = new ModuleMethod(this, 15, null, 0);
            final ModuleMethod lambda$Fn18 = new ModuleMethod(this, 16, null, 0);
            final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 17, null, 0);
            final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 18, null, 0);

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            Object lambda21() {
                Stream stream;
                block3 : {
                    if (lists.isNull(this.objs)) {
                        stream = StreamsPrimitive.stream$Mnnull;
                        return stream;
                    }
                    LList lList = this.objs;
                    try {
                        if (!lists.isNull(lists.cdr((Pair)lList))) break block3;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, (Object)lList);
                    }
                    stream = new StreamPair(new StreamPromise(this.lambda$Fn17, false), new StreamPromise(this.lambda$Fn18, true));
                    return stream;
                }
                stream = new StreamPair(new StreamPromise(this.lambda$Fn19, false), new StreamPromise(this.lambda$Fn20, true));
                return stream;
            }

            Object lambda22() {
                LList lList = this.objs;
                try {
                    return lists.car((Pair)lList);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, (Object)lList);
                }
            }

            Object lambda23() {
                Object[] arrobject = new Object[1];
                LList lList = this.objs;
                try {
                    arrobject[0] = lists.car((Pair)lList);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, (Object)lList);
                }
                return StreamsDerived.streamConstant$V(arrobject);
            }

            Object lambda24() {
                LList lList = this.objs;
                try {
                    return lists.car((Pair)lList);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, (Object)lList);
                }
            }

            Object lambda25() {
                Object[] arrobject = new Object[2];
                LList lList = this.objs;
                try {
                    arrobject[0] = lists.cdr((Pair)lList);
                    lList = this.objs;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, (Object)lList);
                }
                try {
                    arrobject[1] = LList.list1(lists.car((Pair)lList));
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, (Object)lList);
                }
                return ((Procedure)Scheme.apply).apply2(StreamsDerived.stream$Mnconstant, append.append$V(arrobject));
            }

            public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                switch (moduleMethod.selector) {
                    case 19: {
                        callContext.proc = moduleMethod;
                        callContext.pc = 0;
                        return 0;
                    }
                    case 18: {
                        callContext.proc = moduleMethod;
                        callContext.pc = 0;
                        return 0;
                    }
                    case 17: {
                        callContext.proc = moduleMethod;
                        callContext.pc = 0;
                        return 0;
                    }
                    case 16: {
                        callContext.proc = moduleMethod;
                        callContext.pc = 0;
                        return 0;
                    }
                    case 15: {
                        callContext.proc = moduleMethod;
                        callContext.pc = 0;
                        return 0;
                    }
                }
                return super.match0(moduleMethod, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply0(ModuleMethod moduleMethod) {
                switch (moduleMethod.selector) {
                    case 15: {
                        return this.lambda22();
                    }
                    case 16: {
                        return this.lambda23();
                    }
                    case 17: {
                        return this.lambda24();
                    }
                    case 18: {
                        return this.lambda25();
                    }
                    case 19: {
                        return this.lambda21();
                    }
                }
                return super.apply0(moduleMethod);
            }
        }
        Frame8 $heapFrame = new Frame8();
        $heapFrame.objs = lList = LList.makeList(argsArray, 0);
        return new StreamPromise($heapFrame.lambda$Fn16, true);
    }

    public static Stream streamDrop(IntNum n, Stream strm) {
        public class Frame9
        extends ModuleBody {
            public Object lambda26streamDrop(IntNum n, Stream strm) {
                new Frame10().staticLink = this;
                public class Frame10
                extends ModuleBody {
                    Stream strm;
                    IntNum n;
                    Frame9 staticLink;
                    final ModuleMethod lambda$Fn21;

                    public Frame10() {
                        this.lambda$Fn21 = new ModuleMethod(this, 20, null, 0);
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    Object lambda27() {
                        Object object2;
                        boolean x = numbers.isZero(this.n);
                        if (x ? x : StreamsPrimitive.isStreamNull(this.strm)) {
                            object2 = this.strm;
                            return object2;
                        }
                        Object object22 = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            object2 = this.staticLink.lambda26streamDrop(IntNum.add(this.n, -1), (Stream)object22);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-drop", 1, object22);
                        }
                        return object2;
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        if (moduleMethod.selector == 20) {
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
                        if (moduleMethod.selector == 20) {
                            return this.lambda27();
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame10 $heapFrame = new Frame10();
                $heapFrame.n = n;
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn21, true);
            }
        }
        Frame9 $heapFrame = new Frame9();
        if (numbers.isNegative(n)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit4, "negative argument");
            throw Special.reachedUnexpected;
        }
        return (Stream)$heapFrame.lambda26streamDrop(n, strm);
    }

    public static Stream streamDropWhile(Procedure isPred, Stream strm) {
        public class Frame11
        extends ModuleBody {
            Procedure pred$Qu;

            public Object lambda28streamDropWhile(Stream strm) {
                new Frame12().staticLink = this;
                public class Frame12
                extends ModuleBody {
                    Stream strm;
                    Frame11 staticLink;
                    final ModuleMethod lambda$Fn22;

                    public Frame12() {
                        this.lambda$Fn22 = new ModuleMethod(this, 21, null, 0);
                    }

                    /*
                     * Loose catch block
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     * Lifted jumps to return sites
                     */
                    Object lambda29() {
                        Object object2;
                        Object object3;
                        if (StreamsPrimitive.isStreamPair(this.strm) && KawaConvert.isTrue(this.staticLink.pred$Qu.apply1(StreamsPrimitive.streamCar(this.strm)))) {
                            object2 = StreamsPrimitive.streamCdr(this.strm);
                            object3 = this.staticLink.lambda28streamDropWhile((Stream)object2);
                            return object3;
                        }
                        object3 = this.strm;
                        return object3;
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-drop-while", 0, object2);
                        }
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        if (moduleMethod.selector == 21) {
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
                        if (moduleMethod.selector == 21) {
                            return this.lambda29();
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame12 $heapFrame = new Frame12();
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn22, true);
            }
        }
        Frame11 $heapFrame = new Frame11();
        $heapFrame.pred$Qu = isPred;
        return (Stream)$heapFrame.lambda28streamDropWhile(strm);
    }

    public static Stream streamFilter(Procedure isPred, Stream strm) {
        public class Frame13
        extends ModuleBody {
            Procedure pred$Qu;

            public Object lambda30streamFilter(Stream strm) {
                new Frame14().staticLink = this;
                public class Frame14
                extends ModuleBody {
                    Stream strm;
                    Frame13 staticLink;
                    final ModuleMethod lambda$Fn23;
                    final ModuleMethod lambda$Fn24;
                    final ModuleMethod lambda$Fn25;

                    public Frame14() {
                        this.lambda$Fn24 = new ModuleMethod(this, 22, null, 0);
                        this.lambda$Fn25 = new ModuleMethod(this, 23, null, 0);
                        this.lambda$Fn23 = new ModuleMethod(this, 24, null, 0);
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    Object lambda31() {
                        Object object2;
                        if (StreamsPrimitive.isStreamNull(this.strm)) {
                            object2 = StreamsPrimitive.stream$Mnnull;
                            return object2;
                        }
                        if (KawaConvert.isTrue(this.staticLink.pred$Qu.apply1(StreamsPrimitive.streamCar(this.strm)))) {
                            object2 = new StreamPair(new StreamPromise(this.lambda$Fn24, false), new StreamPromise(this.lambda$Fn25, true));
                            return object2;
                        }
                        Object object22 = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            object2 = this.staticLink.lambda30streamFilter((Stream)object22);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-filter", 0, object22);
                        }
                        return object2;
                    }

                    Object lambda32() {
                        return StreamsPrimitive.streamCar(this.strm);
                    }

                    Object lambda33() {
                        Object object2 = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return this.staticLink.lambda30streamFilter((Stream)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-filter", 0, object2);
                        }
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 24: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 23: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 22: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 22: {
                                return this.lambda32();
                            }
                            case 23: {
                                return this.lambda33();
                            }
                            case 24: {
                                return this.lambda31();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame14 $heapFrame = new Frame14();
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn23, true);
            }
        }
        Frame13 $heapFrame = new Frame13();
        $heapFrame.pred$Qu = isPred;
        return (Stream)$heapFrame.lambda30streamFilter(strm);
    }

    public static Object streamFold(Procedure proc, Object base2, Stream strm) {
        Object base3;
        Object object2 = base2;
        Stream stream = strm;
        do {
            void strm2;
            Stream stream2 = stream;
            base3 = object2;
            if (StreamsPrimitive.isStreamNull(strm2)) break;
            object2 = proc.apply2(base3, StreamsPrimitive.streamCar(strm2));
            stream = (Stream)StreamsPrimitive.streamCdr(strm2);
        } while (true);
        return base3;
    }

    public static Object streamForEach$V(Procedure proc, Object[] argsArray) {
        LList strms;
        LList lList = LList.makeList(argsArray, 0);
        LList strms2 = lList;
        if (lists.isNull(strms2)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit5, "no stream arguments");
            throw Special.reachedUnexpected;
        }
        if (KawaConvert.isTrue(srfi1.any$V(lambda$Fn26, strms2, new Object[0]))) {
            Type.NeverReturns neverReturns = exceptions.error(Lit5, "non-stream argument");
            throw Special.reachedUnexpected;
        }
        LList lList2 = strms2;
        while (!KawaConvert.isTrue(srfi1.any$V(StreamsPrimitive.stream$Mnnull$Qu, strms = lList2, new Object[0]))) {
            Pair pair;
            Object object2;
            Object object3 = strms;
            LList lList3 = LList.Empty;
            Pair pair2 = null;
            while (object3 != LList.Empty) {
                Pair pair3;
                pair = (Pair)Promise.force(object3, Pair.class);
                object2 = pair.getCar();
                if (pair2 == null) {
                    pair3 = new Pair(StreamsPrimitive.streamCar(object2), LList.Empty);
                } else {
                    pair3 = lList3;
                    pair2.setCdr(lList3);
                }
                pair2 = pair3;
                object3 = pair.getCdr();
            }
            ((Procedure)Scheme.apply).apply2(proc, lList3);
            object3 = strms;
            lList3 = LList.Empty;
            pair2 = null;
            while (object3 != LList.Empty) {
                Pair pair4;
                pair = (Pair)Promise.force(object3, Pair.class);
                object2 = pair.getCar();
                if (pair2 == null) {
                    pair4 = new Pair(StreamsPrimitive.streamCdr(object2), LList.Empty);
                } else {
                    pair4 = lList3;
                    pair2.setCdr(lList3);
                }
                pair2 = pair4;
                object3 = pair.getCdr();
            }
            lList2 = lList3;
        }
        return Values.empty;
    }

    static boolean lambda34(Object x) {
        return !StreamsPrimitive.isStream(x);
    }

    public static Stream streamFrom(Numeric numeric) {
        return StreamsDerived.streamFrom(numeric, Lit6);
    }

    public static Stream streamFrom(Numeric first, Numeric delta) {
        public class Frame15
        extends ModuleBody {
            public Object lambda35streamFrom(Numeric first, Numeric delta) {
                new Frame16().staticLink = this;
                public class Frame16
                extends ModuleBody {
                    Numeric delta;
                    Numeric first;
                    Frame15 staticLink;
                    final ModuleMethod lambda$Fn27;
                    final ModuleMethod lambda$Fn28;
                    final ModuleMethod lambda$Fn29;

                    public Frame16() {
                        this.lambda$Fn28 = new ModuleMethod(this, 25, null, 0);
                        this.lambda$Fn29 = new ModuleMethod(this, 26, null, 0);
                        this.lambda$Fn27 = new ModuleMethod(this, 27, null, 0);
                    }

                    StreamPair lambda36() {
                        return new StreamPair(new StreamPromise(this.lambda$Fn28, false), new StreamPromise(this.lambda$Fn29, true));
                    }

                    Numeric lambda37() {
                        return this.first;
                    }

                    Object lambda38() {
                        Object object2 = Promise.force(gnu.kawa.functions.AddOp.apply2(1, this.first, this.delta), Numeric.class);
                        try {
                            return this.staticLink.lambda35streamFrom(LangObjType.coerceNumeric(object2), this.delta);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-from", 0, object2);
                        }
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 27: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 26: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 25: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 25: {
                                return this.lambda37();
                            }
                            case 26: {
                                return this.lambda38();
                            }
                            case 27: {
                                return this.lambda36();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame16 $heapFrame = new Frame16();
                $heapFrame.first = first;
                $heapFrame.delta = delta;
                return new StreamPromise($heapFrame.lambda$Fn27, true);
            }
        }
        Frame15 $heapFrame = new Frame15();
        return (Stream)$heapFrame.lambda35streamFrom(first, delta);
    }

    public static Stream streamIterate(Procedure proc, Object base2) {
        public class Frame17
        extends ModuleBody {
            Procedure proc;

            public Object lambda39streamIterate(Object base2) {
                new Frame18().staticLink = this;
                public class Frame18
                extends ModuleBody {
                    Object base;
                    Frame17 staticLink;
                    final ModuleMethod lambda$Fn30;
                    final ModuleMethod lambda$Fn31;
                    final ModuleMethod lambda$Fn32;

                    public Frame18() {
                        this.lambda$Fn31 = new ModuleMethod(this, 28, null, 0);
                        this.lambda$Fn32 = new ModuleMethod(this, 29, null, 0);
                        this.lambda$Fn30 = new ModuleMethod(this, 30, null, 0);
                    }

                    StreamPair lambda40() {
                        return new StreamPair(new StreamPromise(this.lambda$Fn31, false), new StreamPromise(this.lambda$Fn32, true));
                    }

                    Object lambda41() {
                        return this.base;
                    }

                    Object lambda42() {
                        return this.staticLink.lambda39streamIterate(this.staticLink.proc.apply1(this.base));
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 30: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 29: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 28: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 28: {
                                return this.lambda41();
                            }
                            case 29: {
                                return this.lambda42();
                            }
                            case 30: {
                                return this.lambda40();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame18 $heapFrame = new Frame18();
                $heapFrame.base = base2;
                return new StreamPromise($heapFrame.lambda$Fn30, true);
            }
        }
        Frame17 $heapFrame = new Frame17();
        $heapFrame.proc = proc;
        return (Stream)$heapFrame.lambda39streamIterate(base2);
    }

    public static IntNum streamLength(Stream strm) {
        IntNum len;
        IntNum intNum = Lit7;
        Stream stream = strm;
        do {
            Stream strm2 = stream;
            len = intNum;
            if (StreamsPrimitive.isStreamNull(strm2)) break;
            intNum = IntNum.add(len, 1);
            stream = (Stream)StreamsPrimitive.streamCdr(strm2);
        } while (true);
        return len;
    }

    public static Stream streamMap$V(Procedure proc, Object[] argsArray) {
        public class Frame19
        extends ModuleBody {
            Procedure proc;

            static boolean lambda43(Object x) {
                return !StreamsPrimitive.isStream(x);
            }

            public Object lambda44streamMap(LList strms) {
                new Frame20().staticLink = this;
                public class Frame20
                extends ModuleBody {
                    LList strms;
                    Frame19 staticLink;
                    final ModuleMethod lambda$Fn34;
                    final ModuleMethod lambda$Fn35;
                    final ModuleMethod lambda$Fn36;

                    public Frame20() {
                        this.lambda$Fn35 = new ModuleMethod(this, 31, null, 0);
                        this.lambda$Fn36 = new ModuleMethod(this, 32, null, 0);
                        this.lambda$Fn34 = new ModuleMethod(this, 33, null, 0);
                    }

                    Object lambda45() {
                        Stream stream;
                        if (KawaConvert.isTrue(srfi1.any$V(StreamsPrimitive.stream$Mnnull$Qu, this.strms, new Object[0]))) {
                            stream = StreamsPrimitive.stream$Mnnull;
                        } else {
                            StreamPromise streamPromise = new StreamPromise(this.lambda$Fn35, false);
                            StreamPromise streamPromise2 = new StreamPromise(this.lambda$Fn36, true);
                            stream = new StreamPair(streamPromise, streamPromise2);
                        }
                        return stream;
                    }

                    Object lambda46() {
                        Object object2 = this.strms;
                        LList lList = LList.Empty;
                        Pair pair = null;
                        while (object2 != LList.Empty) {
                            Pair pair2;
                            Pair pair3 = (Pair)Promise.force(object2, Pair.class);
                            Object object3 = pair3.getCar();
                            if (pair == null) {
                                pair2 = new Pair(StreamsPrimitive.streamCar(object3), LList.Empty);
                            } else {
                                pair2 = lList;
                                pair.setCdr(lList);
                            }
                            pair = pair2;
                            object2 = pair3.getCdr();
                        }
                        return ((Procedure)Scheme.apply).apply2(this.staticLink.proc, lList);
                    }

                    Object lambda47() {
                        Object object2 = this.strms;
                        LList lList = LList.Empty;
                        Pair pair = null;
                        while (object2 != LList.Empty) {
                            Pair pair2;
                            Pair pair3 = (Pair)Promise.force(object2, Pair.class);
                            Object object3 = pair3.getCar();
                            if (pair == null) {
                                pair2 = new Pair(StreamsPrimitive.streamCdr(object3), LList.Empty);
                            } else {
                                pair2 = lList;
                                pair.setCdr(lList);
                            }
                            pair = pair2;
                            object2 = pair3.getCdr();
                        }
                        return this.staticLink.lambda44streamMap(lList);
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 33: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 32: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 31: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 31: {
                                return this.lambda46();
                            }
                            case 32: {
                                return this.lambda47();
                            }
                            case 33: {
                                return this.lambda45();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame20 $heapFrame = new Frame20();
                $heapFrame.strms = strms;
                return new StreamPromise($heapFrame.lambda$Fn34, true);
            }
        }
        Frame19 $heapFrame = new Frame19();
        $heapFrame.proc = proc;
        LList lList = LList.makeList(argsArray, 0);
        LList strms = lList;
        if (lists.isNull(strms)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit8, "no stream arguments");
            throw Special.reachedUnexpected;
        }
        if (KawaConvert.isTrue(srfi1.any$V(lambda$Fn33, strms, new Object[0]))) {
            Type.NeverReturns neverReturns = exceptions.error(Lit8, "non-stream argument");
            throw Special.reachedUnexpected;
        }
        return (Stream)$heapFrame.lambda44streamMap(strms);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Stream streamRange$V(Numeric first, Numeric past, Object[] argsArray) {
        Numeric numeric;
        public class Frame21
        extends ModuleBody {
            public Object lambda48streamRange(Numeric first, Numeric past, Numeric delta, Procedure isLt) {
                new Frame22().staticLink = this;
                public class Frame22
                extends ModuleBody {
                    Numeric delta;
                    Numeric past;
                    Numeric first;
                    Procedure lt$Qu;
                    Frame21 staticLink;
                    final ModuleMethod lambda$Fn37;
                    final ModuleMethod lambda$Fn38;
                    final ModuleMethod lambda$Fn39;

                    public Frame22() {
                        this.lambda$Fn38 = new ModuleMethod(this, 34, null, 0);
                        this.lambda$Fn39 = new ModuleMethod(this, 35, null, 0);
                        this.lambda$Fn37 = new ModuleMethod(this, 36, null, 0);
                    }

                    Object lambda49() {
                        return KawaConvert.isTrue(this.lt$Qu.apply2(this.first, this.past)) ? new StreamPair(new StreamPromise(this.lambda$Fn38, false), new StreamPromise(this.lambda$Fn39, true)) : StreamsPrimitive.stream$Mnnull;
                    }

                    Numeric lambda50() {
                        return this.first;
                    }

                    Object lambda51() {
                        Object object2 = Promise.force(gnu.kawa.functions.AddOp.apply2(1, this.first, this.delta), Numeric.class);
                        try {
                            return this.staticLink.lambda48streamRange(LangObjType.coerceNumeric(object2), this.past, this.delta, this.lt$Qu);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-range", 0, object2);
                        }
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
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
                            case 34: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 34: {
                                return this.lambda50();
                            }
                            case 35: {
                                return this.lambda51();
                            }
                            case 36: {
                                return this.lambda49();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame22 $heapFrame = new Frame22();
                $heapFrame.first = first;
                $heapFrame.past = past;
                $heapFrame.delta = delta;
                $heapFrame.lt$Qu = isLt;
                return new StreamPromise($heapFrame.lambda$Fn37, true);
            }
        }
        Frame21 $heapFrame = new Frame21();
        LList lList = LList.makeList(argsArray, 0);
        LList step = lList;
        if (lists.isPair(step)) {
            Object object2 = step;
            object2 = Promise.force(lists.car((Pair)object2), Numeric.class);
            numeric = LangObjType.coerceNumeric(object2);
        } else {
            numeric = NumberCompare.$Ls(first, past) ? Lit6 : Lit1;
        }
        IntNum delta = numeric;
        NumberCompare lt$Qu = NumberCompare.$Ls(Lit7, delta) ? Scheme.numLss : Scheme.numGrt;
        return (Stream)$heapFrame.lambda48streamRange(first, past, delta, lt$Qu);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, (Object)lt$Qu);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "delta", -2, (Object)lt$Qu);
        }
    }

    public static Object streamRef(Stream strm, IntNum n) {
        Stream strm2;
        IntNum n2;
        if (numbers.isNegative(n)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit9, "negative argument");
            throw Special.reachedUnexpected;
        }
        Stream stream = strm;
        IntNum intNum = n2 = n;
        do {
            if (StreamsPrimitive.isStreamNull(strm2 = stream)) {
                Type.NeverReturns neverReturns = exceptions.error(Lit9, "beyond end of stream");
                throw Special.reachedUnexpected;
            }
            if (numbers.isZero(n2)) break;
            stream = (Stream)StreamsPrimitive.streamCdr(strm2);
            intNum = IntNum.add(n2, -1);
        } while (true);
        return StreamsPrimitive.streamCar(strm2);
    }

    public static Stream streamReverse(Stream strm) {
        public class Frame23
        extends ModuleBody {
            public Object lambda52streamReverse(Stream strm, Stream rev) {
                new Frame24().staticLink = this;
                public class Frame24
                extends ModuleBody {
                    Stream rev;
                    Stream strm;
                    Frame23 staticLink;
                    final ModuleMethod lambda$Fn40;
                    final ModuleMethod lambda$Fn41;
                    final ModuleMethod lambda$Fn42;

                    public Frame24() {
                        this.lambda$Fn41 = new ModuleMethod(this, 37, null, 0);
                        this.lambda$Fn42 = new ModuleMethod(this, 38, null, 0);
                        this.lambda$Fn40 = new ModuleMethod(this, 39, null, 0);
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    Object lambda53() {
                        Object object2;
                        if (StreamsPrimitive.isStreamNull(this.strm)) {
                            object2 = this.rev;
                            return object2;
                        }
                        Object object22 = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            object2 = this.staticLink.lambda52streamReverse((Stream)object22, new StreamPair(new StreamPromise(this.lambda$Fn41, false), new StreamPromise(this.lambda$Fn42, true)));
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-reverse", 0, object22);
                        }
                        return object2;
                    }

                    Object lambda54() {
                        return StreamsPrimitive.streamCar(this.strm);
                    }

                    Stream lambda55() {
                        return this.rev;
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
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
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 37: {
                                return this.lambda54();
                            }
                            case 38: {
                                return this.lambda55();
                            }
                            case 39: {
                                return this.lambda53();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame24 $heapFrame = new Frame24();
                $heapFrame.strm = strm;
                $heapFrame.rev = rev;
                return new StreamPromise($heapFrame.lambda$Fn40, true);
            }
        }
        Frame23 $heapFrame = new Frame23();
        return (Stream)$heapFrame.lambda52streamReverse(strm, StreamsPrimitive.stream$Mnnull);
    }

    public static Stream streamScan(Procedure proc, Object base2, Stream strm) {
        public class Frame25
        extends ModuleBody {
            Procedure proc;

            public Object lambda56streamScan(Object base2, Stream strm) {
                new Frame26().staticLink = this;
                public class Frame26
                extends ModuleBody {
                    Object base;
                    Stream strm;
                    Frame25 staticLink;
                    final ModuleMethod lambda$Fn43 = new ModuleMethod(this, 43, null, 0);
                    final ModuleMethod lambda$Fn44 = new ModuleMethod(this, 40, null, 0);
                    final ModuleMethod lambda$Fn46 = new ModuleMethod(this, 41, null, 0);
                    final ModuleMethod lambda$Fn47 = new ModuleMethod(this, 42, null, 0);

                    StreamPair lambda57() {
                        return StreamsPrimitive.isStreamNull(this.strm) ? new StreamPair(new StreamPromise(this.lambda$Fn44, false), new StreamPromise(StreamsDerived.lambda$Fn45, true)) : new StreamPair(new StreamPromise(this.lambda$Fn46, false), new StreamPromise(this.lambda$Fn47, true));
                    }

                    Object lambda58() {
                        return this.base;
                    }

                    static StreamPromise lambda59() {
                        return StreamsPrimitive.stream$Mnnull;
                    }

                    Object lambda60() {
                        return this.base;
                    }

                    Object lambda61() {
                        Object object2 = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return this.staticLink.lambda56streamScan(this.staticLink.proc.apply2(this.base, StreamsPrimitive.streamCar(this.strm)), (Stream)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-scan", 1, object2);
                        }
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 43: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 42: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 41: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 40: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 40: {
                                return this.lambda58();
                            }
                            case 41: {
                                return this.lambda60();
                            }
                            case 42: {
                                return this.lambda61();
                            }
                            case 43: {
                                return this.lambda57();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame26 $heapFrame = new Frame26();
                $heapFrame.base = base2;
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn43, true);
            }
        }
        Frame25 $heapFrame = new Frame25();
        $heapFrame.proc = proc;
        return (Stream)$heapFrame.lambda56streamScan(base2, strm);
    }

    public static Stream streamTake(IntNum n, Stream strm) {
        public class Frame27
        extends ModuleBody {
            public Object lambda62streamTake(IntNum n, Stream strm) {
                new Frame28().staticLink = this;
                public class Frame28
                extends ModuleBody {
                    IntNum n;
                    Stream strm;
                    Frame27 staticLink;
                    final ModuleMethod lambda$Fn48;
                    final ModuleMethod lambda$Fn49;
                    final ModuleMethod lambda$Fn50;

                    public Frame28() {
                        this.lambda$Fn49 = new ModuleMethod(this, 44, null, 0);
                        this.lambda$Fn50 = new ModuleMethod(this, 45, null, 0);
                        this.lambda$Fn48 = new ModuleMethod(this, 46, null, 0);
                    }

                    Object lambda63() {
                        boolean x = StreamsPrimitive.isStreamNull(this.strm);
                        return (x ? x : numbers.isZero(this.n)) ? StreamsPrimitive.stream$Mnnull : new StreamPair(new StreamPromise(this.lambda$Fn49, false), new StreamPromise(this.lambda$Fn50, true));
                    }

                    Object lambda64() {
                        return StreamsPrimitive.streamCar(this.strm);
                    }

                    Object lambda65() {
                        Object object2 = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return this.staticLink.lambda62streamTake(IntNum.add(this.n, -1), (Stream)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-take", 1, object2);
                        }
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 46: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 45: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 44: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 44: {
                                return this.lambda64();
                            }
                            case 45: {
                                return this.lambda65();
                            }
                            case 46: {
                                return this.lambda63();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame28 $heapFrame = new Frame28();
                $heapFrame.n = n;
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn48, true);
            }
        }
        Frame27 $heapFrame = new Frame27();
        if (numbers.isNegative(n)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit10, "negative argument");
            throw Special.reachedUnexpected;
        }
        return (Stream)$heapFrame.lambda62streamTake(n, strm);
    }

    public static Stream streamTakeWhile(Procedure isPred, Stream strm) {
        public class Frame29
        extends ModuleBody {
            Procedure pred$Qu;

            public Object lambda66streamTakeWhile(Stream strm) {
                new Frame30().staticLink = this;
                public class Frame30
                extends ModuleBody {
                    Stream strm;
                    Frame29 staticLink;
                    final ModuleMethod lambda$Fn51;
                    final ModuleMethod lambda$Fn52;
                    final ModuleMethod lambda$Fn53;

                    public Frame30() {
                        this.lambda$Fn52 = new ModuleMethod(this, 47, null, 0);
                        this.lambda$Fn53 = new ModuleMethod(this, 48, null, 0);
                        this.lambda$Fn51 = new ModuleMethod(this, 49, null, 0);
                    }

                    Object lambda67() {
                        return StreamsPrimitive.isStreamNull(this.strm) ? StreamsPrimitive.stream$Mnnull : (KawaConvert.isTrue(this.staticLink.pred$Qu.apply1(StreamsPrimitive.streamCar(this.strm))) ? new StreamPair(new StreamPromise(this.lambda$Fn52, false), new StreamPromise(this.lambda$Fn53, true)) : StreamsPrimitive.stream$Mnnull);
                    }

                    Object lambda68() {
                        return StreamsPrimitive.streamCar(this.strm);
                    }

                    Object lambda69() {
                        Object object2 = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return this.staticLink.lambda66streamTakeWhile((Stream)object2);
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "stream-take-while", 0, object2);
                        }
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 49: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 48: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 47: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 47: {
                                return this.lambda68();
                            }
                            case 48: {
                                return this.lambda69();
                            }
                            case 49: {
                                return this.lambda67();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame30 $heapFrame = new Frame30();
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn51, true);
            }
        }
        Frame29 $heapFrame = new Frame29();
        $heapFrame.pred$Qu = isPred;
        return (Stream)$heapFrame.lambda66streamTakeWhile(strm);
    }

    public static Stream streamUnfold(Procedure mapper, Procedure isPred, Procedure generator, Object base2) {
        public class Frame31
        extends ModuleBody {
            Procedure generator;
            Procedure mapper;
            Procedure pred$Qu;

            public Object lambda70streamUnfold(Object base2) {
                new Frame32().staticLink = this;
                public class Frame32
                extends ModuleBody {
                    Object base;
                    Frame31 staticLink;
                    final ModuleMethod lambda$Fn54;
                    final ModuleMethod lambda$Fn55;
                    final ModuleMethod lambda$Fn56;

                    public Frame32() {
                        this.lambda$Fn55 = new ModuleMethod(this, 50, null, 0);
                        this.lambda$Fn56 = new ModuleMethod(this, 51, null, 0);
                        this.lambda$Fn54 = new ModuleMethod(this, 52, null, 0);
                    }

                    Object lambda71() {
                        return KawaConvert.isTrue(this.staticLink.pred$Qu.apply1(this.base)) ? new StreamPair(new StreamPromise(this.lambda$Fn55, false), new StreamPromise(this.lambda$Fn56, true)) : StreamsPrimitive.stream$Mnnull;
                    }

                    Object lambda72() {
                        return this.staticLink.mapper.apply1(this.base);
                    }

                    Object lambda73() {
                        return this.staticLink.lambda70streamUnfold(this.staticLink.generator.apply1(this.base));
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 52: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 51: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 50: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 50: {
                                return this.lambda72();
                            }
                            case 51: {
                                return this.lambda73();
                            }
                            case 52: {
                                return this.lambda71();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame32 $heapFrame = new Frame32();
                $heapFrame.base = base2;
                return new StreamPromise($heapFrame.lambda$Fn54, true);
            }
        }
        Frame31 $heapFrame = new Frame31();
        $heapFrame.mapper = mapper;
        $heapFrame.pred$Qu = isPred;
        $heapFrame.generator = generator;
        return (Stream)$heapFrame.lambda70streamUnfold(base2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object streamUnfolds(Procedure gen, Object seed) {
        EmptyList seed2;
        public class Frame33
        extends ModuleBody {
            public Object lambda74unfoldResultStream(Procedure gen, Object seed) {
                new Frame34().staticLink = this;
                public class Frame34
                extends ModuleBody {
                    Object seed;
                    Procedure gen;
                    Frame33 staticLink;
                    final ModuleMethod lambda$Fn58;
                    final ModuleMethod lambda$Fn59;

                    public Frame34() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 55, null, -4095);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:331");
                        this.lambda$Fn59 = moduleMethod;
                        this.lambda$Fn58 = new ModuleMethod(this, 56, null, 0);
                    }

                    Object lambda77() {
                        return ((Procedure)ApplyWithValues.applyWithValues).apply2(this.gen.apply1(this.seed), this.lambda$Fn59);
                    }

                    StreamPair lambda78$V(Object next, Object[] argsArray) {
                        LList lList;
                        new Frame35().staticLink = this;
                        public class Frame35
                        extends ModuleBody {
                            Object next;
                            LList results;
                            Frame34 staticLink;
                            final ModuleMethod lambda$Fn60;
                            final ModuleMethod lambda$Fn61;

                            public Frame35() {
                                this.lambda$Fn60 = new ModuleMethod(this, 53, null, 0);
                                this.lambda$Fn61 = new ModuleMethod(this, 54, null, 0);
                            }

                            LList lambda79() {
                                return this.results;
                            }

                            Object lambda80() {
                                return this.staticLink.staticLink.lambda74unfoldResultStream(this.staticLink.gen, this.next);
                            }

                            public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                                switch (moduleMethod.selector) {
                                    case 54: {
                                        callContext.proc = moduleMethod;
                                        callContext.pc = 0;
                                        return 0;
                                    }
                                    case 53: {
                                        callContext.proc = moduleMethod;
                                        callContext.pc = 0;
                                        return 0;
                                    }
                                }
                                return super.match0(moduleMethod, callContext);
                            }

                            public void apply(CallContext callContext) {
                                ModuleMethod.applyError();
                            }

                            public Object apply0(ModuleMethod moduleMethod) {
                                switch (moduleMethod.selector) {
                                    case 53: {
                                        return this.lambda79();
                                    }
                                    case 54: {
                                        return this.lambda80();
                                    }
                                }
                                return super.apply0(moduleMethod);
                            }
                        }
                        Frame35 $heapFrame = new Frame35();
                        $heapFrame.next = next;
                        $heapFrame.results = lList = LList.makeList(argsArray, 0);
                        return new StreamPair(new StreamPromise($heapFrame.lambda$Fn60, false), new StreamPromise($heapFrame.lambda$Fn61, true));
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        if (moduleMethod.selector == 56) {
                            callContext.proc = moduleMethod;
                            callContext.pc = 0;
                            return 0;
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
                        if (moduleMethod.selector == 55) {
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

                    public Object apply0(ModuleMethod moduleMethod) {
                        if (moduleMethod.selector == 56) {
                            return this.lambda77();
                        }
                        return super.apply0(moduleMethod);
                    }

                    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
                        if (moduleMethod.selector == 55) {
                            int n = arrobject.length - 1;
                            Object[] arrobject2 = new Object[n];
                            while (--n >= 0) {
                                arrobject2 = arrobject2;
                                arrobject2[n] = arrobject[n + 1];
                            }
                            return this.lambda78$V(arrobject[0], arrobject2);
                        }
                        return super.applyN(moduleMethod, arrobject);
                    }
                }
                Frame34 $heapFrame = new Frame34();
                $heapFrame.gen = gen;
                $heapFrame.seed = seed;
                return new StreamPromise($heapFrame.lambda$Fn58, true);
            }

            static int lambda75$V(Object[] argsArray) {
                LList lList;
                LList vs = lList = LList.makeList(argsArray, 0);
                return vs.size() - 1;
            }

            public Object lambda76resultStream$To$OutputStream(Stream resultStream, IntNum i) {
                new Frame36().staticLink = this;
                public class Frame36
                extends ModuleBody {
                    IntNum i;
                    Stream result$Mnstream;
                    Frame33 staticLink;
                    final ModuleMethod lambda$Fn62;

                    public Frame36() {
                        this.lambda$Fn62 = new ModuleMethod(this, 59, null, 0);
                    }

                    /*
                     * Loose catch block
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     * Lifted jumps to return sites
                     */
                    Object lambda81() {
                        Object object2;
                        Object object3;
                        new Frame37().staticLink = this;
                        public class Frame37
                        extends ModuleBody {
                            Object result;
                            Frame36 staticLink;
                            final ModuleMethod lambda$Fn63;
                            final ModuleMethod lambda$Fn64;

                            public Frame37() {
                                this.lambda$Fn63 = new ModuleMethod(this, 57, null, 0);
                                this.lambda$Fn64 = new ModuleMethod(this, 58, null, 0);
                            }

                            Object lambda82() {
                                Object object2 = Promise.force(this.result, Pair.class);
                                try {
                                    return lists.car((Pair)object2);
                                }
                                catch (ClassCastException classCastException) {
                                    throw new WrongType(classCastException, "car", 1, object2);
                                }
                            }

                            Object lambda83() {
                                Object object2 = StreamsPrimitive.streamCdr(this.staticLink.result$Mnstream);
                                try {
                                    return this.staticLink.staticLink.lambda76resultStream$To$OutputStream((Stream)object2, this.staticLink.i);
                                }
                                catch (ClassCastException classCastException) {
                                    throw new WrongType(classCastException, "result-stream->output-stream", 0, object2);
                                }
                            }

                            public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                                switch (moduleMethod.selector) {
                                    case 58: {
                                        callContext.proc = moduleMethod;
                                        callContext.pc = 0;
                                        return 0;
                                    }
                                    case 57: {
                                        callContext.proc = moduleMethod;
                                        callContext.pc = 0;
                                        return 0;
                                    }
                                }
                                return super.match0(moduleMethod, callContext);
                            }

                            public void apply(CallContext callContext) {
                                ModuleMethod.applyError();
                            }

                            public Object apply0(ModuleMethod moduleMethod) {
                                switch (moduleMethod.selector) {
                                    case 57: {
                                        return this.lambda82();
                                    }
                                    case 58: {
                                        return this.lambda83();
                                    }
                                }
                                return super.apply0(moduleMethod);
                            }
                        }
                        Frame37 $heapFrame = new Frame37();
                        $heapFrame.result = lists.listRef(StreamsPrimitive.streamCar(this.result$Mnstream), ((java.lang.Number)this.i).intValue() - 1);
                        if (lists.isPair($heapFrame.result)) {
                            object3 = new StreamPair(new StreamPromise($heapFrame.lambda$Fn63, false), new StreamPromise($heapFrame.lambda$Fn64, true));
                            return object3;
                        }
                        if (!KawaConvert.isTrue($heapFrame.result)) {
                            object2 = StreamsPrimitive.streamCdr(this.result$Mnstream);
                            object3 = this.staticLink.lambda76resultStream$To$OutputStream((Stream)object2, this.i);
                            return object3;
                        }
                        if (lists.isNull($heapFrame.result)) {
                            object3 = StreamsPrimitive.stream$Mnnull;
                            return object3;
                        }
                        Type.NeverReturns neverReturns = exceptions.error(StreamsDerived.Lit11, "can't happen");
                        throw Special.reachedUnexpected;
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "result-stream->output-stream", 0, object2);
                        }
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        if (moduleMethod.selector == 59) {
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
                        if (moduleMethod.selector == 59) {
                            return this.lambda81();
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame36 $heapFrame = new Frame36();
                $heapFrame.result$Mnstream = resultStream;
                $heapFrame.i = i;
                return new StreamPromise($heapFrame.lambda$Fn62, true);
            }
        }
        Frame33 $heapFrame = new Frame33();
        Object result$Mnstream = $heapFrame.lambda74unfoldResultStream(gen, seed);
        Object object3 = seed;
        Procedure gen2 = gen;
        IntNum intNum = LangObjType.coerceIntNum(Promise.force(((Procedure)ApplyWithValues.applyWithValues).apply2(gen2.apply1(seed2), lambda$Fn57), IntNum.class));
        LList lList = seed2 = LList.Empty;
        void outputs;
        IntNum i;
        while (!numbers.isZero(i = intNum)) {
            intNum = IntNum.add(i, -1);
            Object object2 = result$Mnstream;
            try {
                lList = lists.cons($heapFrame.lambda76resultStream$To$OutputStream((Stream)object2, i), outputs);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "result-stream->output-stream", 0, object2);
            }
        }
        return ((Procedure)Scheme.apply).apply2(misc.values, outputs);
    }

    public static Stream streamZip$V(Object[] argsArray) {
        public class Frame38
        extends ModuleBody {
            static boolean lambda84(Object x) {
                return !StreamsPrimitive.isStream(x);
            }

            public Object lambda85streamZip(LList strms) {
                new Frame39().staticLink = this;
                public class Frame39
                extends ModuleBody {
                    LList strms;
                    Frame38 staticLink;
                    final ModuleMethod lambda$Fn66;
                    final ModuleMethod lambda$Fn67;
                    final ModuleMethod lambda$Fn68;

                    public Frame39() {
                        this.lambda$Fn67 = new ModuleMethod(this, 60, null, 0);
                        this.lambda$Fn68 = new ModuleMethod(this, 61, null, 0);
                        this.lambda$Fn66 = new ModuleMethod(this, 62, null, 0);
                    }

                    Object lambda86() {
                        Stream stream;
                        if (KawaConvert.isTrue(srfi1.any$V(StreamsPrimitive.stream$Mnnull$Qu, this.strms, new Object[0]))) {
                            stream = StreamsPrimitive.stream$Mnnull;
                        } else {
                            StreamPromise streamPromise = new StreamPromise(this.lambda$Fn67, false);
                            StreamPromise streamPromise2 = new StreamPromise(this.lambda$Fn68, true);
                            stream = new StreamPair(streamPromise, streamPromise2);
                        }
                        return stream;
                    }

                    LList lambda87() {
                        Object object2 = this.strms;
                        LList lList = LList.Empty;
                        Pair pair = null;
                        while (object2 != LList.Empty) {
                            Pair pair2;
                            Pair pair3 = (Pair)Promise.force(object2, Pair.class);
                            Object object3 = pair3.getCar();
                            if (pair == null) {
                                pair2 = new Pair(StreamsPrimitive.streamCar(object3), LList.Empty);
                            } else {
                                pair2 = lList;
                                pair.setCdr(lList);
                            }
                            pair = pair2;
                            object2 = pair3.getCdr();
                        }
                        return lList;
                    }

                    Object lambda88() {
                        Object object2 = this.strms;
                        LList lList = LList.Empty;
                        Pair pair = null;
                        while (object2 != LList.Empty) {
                            Pair pair2;
                            Pair pair3 = (Pair)Promise.force(object2, Pair.class);
                            Object object3 = pair3.getCar();
                            if (pair == null) {
                                pair2 = new Pair(StreamsPrimitive.streamCdr(object3), LList.Empty);
                            } else {
                                pair2 = lList;
                                pair.setCdr(lList);
                            }
                            pair = pair2;
                            object2 = pair3.getCdr();
                        }
                        return this.staticLink.lambda85streamZip(lList);
                    }

                    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                        switch (moduleMethod.selector) {
                            case 62: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 61: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                            case 60: {
                                callContext.proc = moduleMethod;
                                callContext.pc = 0;
                                return 0;
                            }
                        }
                        return super.match0(moduleMethod, callContext);
                    }

                    public void apply(CallContext callContext) {
                        ModuleMethod.applyError();
                    }

                    public Object apply0(ModuleMethod moduleMethod) {
                        switch (moduleMethod.selector) {
                            case 60: {
                                return this.lambda87();
                            }
                            case 61: {
                                return this.lambda88();
                            }
                            case 62: {
                                return this.lambda86();
                            }
                        }
                        return super.apply0(moduleMethod);
                    }
                }
                Frame39 $heapFrame = new Frame39();
                $heapFrame.strms = strms;
                return new StreamPromise($heapFrame.lambda$Fn66, true);
            }
        }
        Frame38 $heapFrame = new Frame38();
        LList lList = LList.makeList(argsArray, 0);
        LList strms = lList;
        if (lists.isNull(strms)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit12, "no stream arguments");
            throw Special.reachedUnexpected;
        }
        if (KawaConvert.isTrue(srfi1.any$V(lambda$Fn65, strms, new Object[0]))) {
            Type.NeverReturns neverReturns = exceptions.error(Lit12, "non-stream argument");
            throw Special.reachedUnexpected;
        }
        return (Stream)$heapFrame.lambda85streamZip(strms);
    }

    public static {
        Lit74 = Symbol.valueOf("stream-lambda");
        Lit73 = Symbol.valueOf("stream-cons");
        Lit72 = Symbol.valueOf("stream-null");
        Lit27 = Symbol.valueOf("stream-match");
        Lit71 = PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Lit27, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847911), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847911);
        Lit70 = Symbol.valueOf("error");
        Lit69 = Symbol.valueOf("list");
        Lit68 = Symbol.valueOf("stream-null?");
        Lit67 = Symbol.valueOf("stream-pair?");
        Lit66 = Symbol.valueOf("and");
        Lit65 = Symbol.valueOf("temp");
        Lit64 = Symbol.valueOf("stream-cdr");
        Lit63 = Symbol.valueOf("stream-car");
        Object[] arrobject = new Object[1];
        Lit62 = arrobject;
        Lit59 = Symbol.valueOf("let");
        arrobject[0] = Lit59;
        Lit61 = Symbol.valueOf("if");
        Lit60 = new Object[0];
        Lit58 = Symbol.valueOf("is");
        Lit57 = Symbol.valueOf("loop");
        Lit55 = Symbol.valueOf("strm");
        Lit56 = PairWithPosition.make(Lit55, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1032218);
        Lit54 = Symbol.valueOf("in");
        Lit53 = Symbol.valueOf("stream-unfold");
        Lit52 = Symbol.valueOf("stream-take-while");
        Lit51 = Symbol.valueOf("stream-scan");
        Lit50 = Symbol.valueOf("stream-reverse");
        Lit49 = Symbol.valueOf("stream-range");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[4];
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit60, 2, "StreamsDerived.scm:248"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[]{Lit73}, 0);
        Object[] arrobject2 = new Object[9];
        Lit25 = Symbol.valueOf("stream-let");
        arrobject2[0] = Lit25;
        arrobject2[1] = Lit57;
        arrobject2[2] = Lit55;
        arrobject2[3] = Lit61;
        arrobject2[4] = PairWithPosition.make(Lit68, Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1032204);
        arrobject2[5] = Lit59;
        arrobject2[6] = PairWithPosition.make(PairWithPosition.make(Lit63, Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1040407), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1040407);
        Lit47 = Symbol.valueOf("stream-of-aux");
        arrobject2[7] = Lit47;
        arrobject2[8] = PairWithPosition.make(Lit57, PairWithPosition.make(PairWithPosition.make(Lit64, Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1044520), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1044520), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1044514);
        arrsyntaxRule[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f<\f\u0017\f\u0002\f\u001f\b\r' \b\b", new Object[]{Lit54}, 5, "StreamsDerived.scm:250"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\u0011\u0018\f1\b\u0011\u0018\u0014\b\u001b\b\u0011\u0018\u001c\u0011\u0018$\t\u000b\b\u0011\u0018,)\b\t\u0013\u00184\b\u0011\u0018<\t\u0003\u0011\u0018D\b%#", arrobject2, 1);
        arrsyntaxRule[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f<\f\u0017\f\u0002\f\u001f\b\r' \b\b", new Object[]{Lit58}, 5, "StreamsDerived.scm:256"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004)\b\t\u0013\b\u001b\b\u0011\u0018\f\t\u0003\t\u000b\b%#", new Object[]{Lit59, Lit47}, 1);
        arrsyntaxRule[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\r\u001f\u0018\b\b", Lit60, 4, "StreamsDerived.scm:258"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u0013Q\u0011\u0018\f\t\u0003\t\u000b\b\u001d\u001b\b\u000b", new Object[]{Lit61, Lit47}, 1);
        Lit48 = new SyntaxRules(new Object[]{Lit54, Lit58}, arrsyntaxRule, 5, Lit47);
        Lit45 = Symbol.valueOf("stream-of");
        Lit46 = new SyntaxRules(Lit60, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit60, 2, "StreamsDerived.scm:243"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\b\r\u000b", new Object[]{Lit47, Lit72}, 1)}, 2, Lit45);
        Lit44 = new SyntaxTemplate("", "\u0018\u0004", new Object[]{Symbol.valueOf("_")}, 0);
        Lit43 = new SyntaxTemplate("\u0001\u0001\u0003\u0001", "\u0011\u0018\u0004A!\t\u000b\b\u0003\b\u0015\u0013\b\u001b", Lit62, 1);
        Lit42 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u001f\b", Lit60, 4, "StreamsDerived.scm:238");
        Lit41 = new SyntaxTemplate("\u0001\u0001\u0003\u0001", "\u0011\u0018\u0004\u0019\b\u0015\u0013\b\u001b", Lit62, 1);
        Lit40 = new SyntaxTemplate("\u0001\u0001\u0003\u0001", "\u000b", Lit60, 0);
        Lit39 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u001f\b", Lit60, 4, "StreamsDerived.scm:235");
        Object[] arrobject3 = new Object[8];
        arrobject3[0] = Lit66;
        arrobject3[1] = Lit67;
        arrobject3[2] = Lit59;
        arrobject3[3] = Lit65;
        arrobject3[4] = Lit63;
        arrobject3[5] = Lit64;
        Lit31 = Symbol.valueOf("stream-match-pattern");
        arrobject3[6] = Lit31;
        arrobject3[7] = PairWithPosition.make(Lit65, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 958525);
        Lit38 = new SyntaxTemplate("\u0001\u0001\u0000\u0003\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0099I\u0011\u0018\u001c\b\u0011\u0018$\b\u0003\b\t\u0003\b\u0011\u0018,\b\u0003\b\u0011\u00184\t\u0003\t\u0012A!\t\u000b\u0018<\b\u001d\u001b\b#", arrobject3, 1);
        Lit37 = new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\u0013,\r\u001f\u0018\b\b\f'\b", Lit60, 5, "StreamsDerived.scm:231");
        Lit36 = new SyntaxTemplate("\u0001\u0001\u0000\u0003\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014I\b\t\u0003\b\u0011\u0018\u001c\b\u0003\b\u0011\u0018$\t\u0003\t\u0012\u0019\b\u001d\u001b\b#", new Object[]{Lit66, Lit67, Lit59, Lit64, Lit31}, 1);
        Lit35 = new SyntaxTemplate("\u0001\u0001\u0000\u0003\u0001", "\u000b", Lit60, 0);
        Lit34 = new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\u0013,\r\u001f\u0018\b\b\f'\b", Lit60, 5, "StreamsDerived.scm:226");
        Lit33 = new SyntaxTemplate("\u0001\u0003\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0019\b\r\u000b\b\u0013", new Object[]{Lit66, Lit68, Lit59}, 1);
        Lit32 = new SyntaxPattern("\f\u0018\f\u0007\f\b,\r\u000f\b\b\b\f\u0017\b", Lit60, 3, "StreamsDerived.scm:224");
        Lit29 = Symbol.valueOf("stream-match-test");
        Lit30 = new SyntaxRules(Lit60, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0017\f\u001f\b\b", Lit60, 4, "StreamsDerived.scm:213"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0010\b\u0011\u0018\f\t\u0013\b\u0011\u0018\u0014\b\u001b", new Object[]{Lit31, Lit66, Lit69}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007,\f\u000f\f\u0017\b\b", Lit60, 3, "StreamsDerived.scm:215"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0010\b\u0011\u0018\f\b\u0013", new Object[]{Lit31, Lit69}, 0)}, 4, Lit29);
        Lit28 = new SyntaxRules(Lit60, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit60, 2, "StreamsDerived.scm:204"), "\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\u001ca\rA\u0011\u0018$\u0011\u0018\f\b\u000b\u0018,\u00184", new Object[]{Lit59, Lit55, Symbol.valueOf("cond"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("not"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("stream?"), Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847887), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847887), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847882), PairWithPosition.make(PairWithPosition.make(Lit70, PairWithPosition.make(Lit71, PairWithPosition.make("non-stream argument", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847924), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847903), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847903), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847881), Lit29, PairWithPosition.make(Symbol.valueOf("=>"), PairWithPosition.make(Symbol.valueOf("car"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 852013), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 852010), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("else"), PairWithPosition.make(PairWithPosition.make(Lit70, PairWithPosition.make(Lit71, PairWithPosition.make("pattern failure", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856100), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856086), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856079), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856079), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856073), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856073)}, 1)}, 2, Lit27);
        Lit26 = new SyntaxRules(Lit60, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L-\f\u000f\f\u0017\b\b\u0010\b\f\u001f\r' \b\b", Lit60, 5, "StreamsDerived.scm:187"), "\u0001\u0003\u0003\u0001\u0003", "\u00b1\u0011\u0018\u0004\u0081\b\t\u0003\b\u0011\u0018\f\u0019\b\r\u000b\t\u001b\b%#\b\u0003\b\u0015\u0013", new Object[]{Symbol.valueOf("letrec"), Lit74}, 1)}, 5, Lit25);
        Lit24 = Symbol.valueOf("stream-length");
        Lit23 = Symbol.valueOf("stream-iterate");
        Lit22 = Symbol.valueOf("stream-from");
        Lit21 = Symbol.valueOf("stream-fold");
        Lit20 = Symbol.valueOf("stream-filter");
        Lit19 = Symbol.valueOf("stream-drop-while");
        SyntaxRule[] arrsyntaxRule2 = new SyntaxRule[2];
        arrsyntaxRule2[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\b", Lit60, 0, "StreamsDerived.scm:78"), "", "\u0018\u0004", new Object[]{Lit72}, 0);
        Object[] arrobject4 = new Object[2];
        arrobject4[0] = Lit73;
        Lit17 = Symbol.valueOf("stream");
        arrobject4[1] = Lit17;
        arrsyntaxRule2[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit60, 2, "StreamsDerived.scm:79"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\b\r\u000b", arrobject4, 1);
        Lit18 = new SyntaxRules(Lit60, arrsyntaxRule2, 2, Lit17);
        Lit16 = Symbol.valueOf("port->stream");
        Lit15 = Symbol.valueOf("list->stream");
        Lit13 = Symbol.valueOf("define-stream");
        Lit14 = new SyntaxRules(Lit60, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\f\u0017\r\u001f\u0018\b\b", Lit60, 4, "StreamsDerived.scm:56"), "\u0001\u0000\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\n\t\u0013\b\u001d\u001b", new Object[]{Symbol.valueOf("define"), Lit74}, 1)}, 4, Lit13);
        Lit12 = Symbol.valueOf("stream-zip");
        Lit11 = Symbol.valueOf("stream-unfolds");
        Lit10 = Symbol.valueOf("stream-take");
        Lit9 = Symbol.valueOf("stream-ref");
        Lit8 = Symbol.valueOf("stream-map");
        Lit7 = IntNum.valueOf(0);
        Lit6 = IntNum.valueOf(1);
        Lit5 = Symbol.valueOf("stream-for-each");
        Lit4 = Symbol.valueOf("stream-drop");
        Lit3 = Symbol.valueOf("stream-concat");
        Lit2 = Symbol.valueOf("stream-append");
        Lit1 = IntNum.valueOf(-1);
        Lit0 = Symbol.valueOf("stream->list");
        $instance = new StreamsDerived();
        stream$Mnnull = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnnull");
        stream$Mncons = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncons");
        stream$Qu = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Qu");
        stream$Mnnull$Qu = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnnull$Qu");
        stream$Mnpair$Qu = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnpair$Qu");
        stream$Mncar = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncar");
        stream$Mncdr = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncdr");
        stream$Mnlambda = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnlambda");
        define$Mnstream = Macro.make(Lit13, Lit14, "gnu.kawa.slib.StreamsDerived");
        StreamsDerived streamsDerived = $instance;
        list$Mn$Grstream = new ModuleMethod(streamsDerived, 63, Lit15, 4097);
        port$Mn$Grstream = new ModuleMethod(streamsDerived, 64, Lit16, 4096);
        stream = Macro.make(Lit17, Lit18, "gnu.kawa.slib.StreamsDerived");
        stream$Mn$Grlist = new ModuleMethod(streamsDerived, 66, Lit0, -4096);
        ModuleMethod moduleMethod = new ModuleMethod(streamsDerived, 67, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:100");
        lambda$Fn7 = moduleMethod;
        stream$Mnappend = new ModuleMethod(streamsDerived, 68, Lit2, -4096);
        stream$Mnconcat = new ModuleMethod(streamsDerived, 69, Lit3, 4097);
        ModuleMethod moduleMethod2 = new ModuleMethod(streamsDerived, 70, "stream-constant", -4096);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:119");
        stream$Mnconstant = moduleMethod2;
        stream$Mndrop = new ModuleMethod(streamsDerived, 71, Lit4, 8194);
        stream$Mndrop$Mnwhile = new ModuleMethod(streamsDerived, 72, Lit19, 8194);
        stream$Mnfilter = new ModuleMethod(streamsDerived, 73, Lit20, 8194);
        stream$Mnfold = new ModuleMethod(streamsDerived, 74, Lit21, 12291);
        ModuleMethod moduleMethod3 = new ModuleMethod(streamsDerived, 75, null, 4097);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:163");
        lambda$Fn26 = moduleMethod3;
        stream$Mnfor$Mneach = new ModuleMethod(streamsDerived, 76, Lit5, -4095);
        stream$Mnfrom = new ModuleMethod(streamsDerived, 77, Lit22, 8193);
        stream$Mniterate = new ModuleMethod(streamsDerived, 79, Lit23, 8194);
        stream$Mnlength = new ModuleMethod(streamsDerived, 80, Lit24, 4097);
        stream$Mnlet = Macro.make(Lit25, Lit26, "gnu.kawa.slib.StreamsDerived");
        ModuleMethod moduleMethod4 = new ModuleMethod(streamsDerived, 81, null, 4097);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:198");
        lambda$Fn33 = moduleMethod4;
        stream$Mnmap = new ModuleMethod(streamsDerived, 82, Lit8, -4095);
        stream$Mnmatch = Macro.make(Lit27, Lit28, "gnu.kawa.slib.StreamsDerived");
        $Prvt$stream$Mnmatch$Mntest = Macro.make(Lit29, Lit30, "gnu.kawa.slib.StreamsDerived");
        StreamsDerived streamsDerived2 = $instance;
        ModuleMethod moduleMethod5 = new ModuleMethod(streamsDerived2, 83, null, 4097);
        moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:219");
        $Prvt$stream$Mnmatch$Mnpattern = Macro.make(Lit31, moduleMethod5, "gnu.kawa.slib.StreamsDerived");
        stream$Mnof = Macro.make(Lit45, Lit46, "gnu.kawa.slib.StreamsDerived");
        $Prvt$stream$Mnof$Mnaux = Macro.make(Lit47, Lit48, "gnu.kawa.slib.StreamsDerived");
        stream$Mnrange = new ModuleMethod(streamsDerived, 84, Lit49, -4094);
        stream$Mnref = new ModuleMethod(streamsDerived, 85, Lit9, 8194);
        stream$Mnreverse = new ModuleMethod(streamsDerived, 86, Lit50, 4097);
        lambda$Fn45 = new ModuleMethod(streamsDerived, 87, null, 0);
        stream$Mnscan = new ModuleMethod(streamsDerived, 88, Lit51, 12291);
        stream$Mntake = new ModuleMethod(streamsDerived, 89, Lit10, 8194);
        stream$Mntake$Mnwhile = new ModuleMethod(streamsDerived, 90, Lit52, 8194);
        stream$Mnunfold = new ModuleMethod(streamsDerived, 91, Lit53, 16388);
        ModuleMethod moduleMethod6 = new ModuleMethod(streamsDerived, 92, null, -4096);
        moduleMethod6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:326");
        lambda$Fn57 = moduleMethod6;
        stream$Mnunfolds = new ModuleMethod(streamsDerived, 93, Lit11, 8194);
        ModuleMethod moduleMethod7 = new ModuleMethod(streamsDerived, 94, null, 4097);
        moduleMethod7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:358");
        lambda$Fn65 = moduleMethod7;
        stream$Mnzip = new ModuleMethod(streamsDerived, 95, Lit12, -4096);
        StreamsDerived.$runBody$();
    }

    public StreamsDerived() {
        ModuleInfo.register(this);
    }

    static Object lambda89(Object x) {
        Object object2;
        TemplateScope templateScope;
        Object object3 = x;
        Object[] arrobject = SyntaxPattern.allocVars(5, null);
        if (((Pattern)Lit32).match(x, arrobject, 0)) {
            TemplateScope templateScope2 = TemplateScope.make();
            object2 = Lit33.execute(arrobject, templateScope2);
        } else if (((Pattern)Lit34).match(x, arrobject, 0) && StreamsDerived.lambda90isWildcard(Lit35.execute(arrobject, templateScope = TemplateScope.make()))) {
            templateScope = TemplateScope.make();
            object2 = Lit36.execute(arrobject, templateScope);
        } else if (((Pattern)Lit37).match(x, arrobject, 0)) {
            templateScope = TemplateScope.make();
            object2 = Lit38.execute(arrobject, templateScope);
        } else if (((Pattern)Lit39).match(x, arrobject, 0) && StreamsDerived.lambda90isWildcard(Lit40.execute(arrobject, templateScope = TemplateScope.make()))) {
            templateScope = TemplateScope.make();
            object2 = Lit41.execute(arrobject, templateScope);
        } else if (((Pattern)Lit42).match(x, arrobject, 0)) {
            templateScope = TemplateScope.make();
            object2 = Lit43.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", x);
        }
        return object2;
    }

    public static boolean lambda90isWildcard(Object x) {
        boolean bl;
        if (std_syntax.isIdentifier(x)) {
            TemplateScope templateScope = TemplateScope.make();
            bl = std_syntax.isFreeIdentifier$Eq(x, Lit44.execute(null, templateScope));
        } else {
            bl = false;
        }
        return bl;
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 87: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 64: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 83: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 94: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 86: {
                Object object3 = object2;
                if (!(object3 instanceof Stream)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 81: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 80: {
                Object object4 = object2;
                if (!(object4 instanceof Stream)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 77: {
                Object object5 = Promise.force(object2, Numeric.class);
                if (Numeric.asNumericOrNull(object5) == null) {
                    return -786431;
                }
                callContext.value1 = object5;
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
            case 69: {
                Object object6 = object2;
                if (!(object6 instanceof Stream)) {
                    return -786431;
                }
                callContext.value1 = object6;
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
            case 64: {
                Object object7 = Promise.force(object2, InPort.class);
                if (!(object7 instanceof InPort)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 63: {
                Object object8 = Promise.force(object2, LList.class);
                if (!(object8 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 93: {
                Object object4 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 90: {
                Object object5 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object5) == null) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = object3;
                if (!(object6 instanceof Stream)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 89: {
                Object object7 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                Object object8 = object3;
                if (!(object8 instanceof Stream)) {
                    return -786430;
                }
                callContext.value2 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 85: {
                Object object9 = object2;
                if (!(object9 instanceof Stream)) {
                    return -786431;
                }
                callContext.value1 = object9;
                Object object10 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object10) == null) {
                    return -786430;
                }
                callContext.value2 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 79: {
                Object object11 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object11) == null) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 77: {
                Object object12 = Promise.force(object2, Numeric.class);
                if (Numeric.asNumericOrNull(object12) == null) {
                    return -786431;
                }
                callContext.value1 = object12;
                Object object13 = Promise.force(object3, Numeric.class);
                if (Numeric.asNumericOrNull(object13) == null) {
                    return -786430;
                }
                callContext.value2 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 73: {
                Object object14 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object14) == null) {
                    return -786431;
                }
                callContext.value1 = object14;
                Object object15 = object3;
                if (!(object15 instanceof Stream)) {
                    return -786430;
                }
                callContext.value2 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 72: {
                Object object16 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object16) == null) {
                    return -786431;
                }
                callContext.value1 = object16;
                Object object17 = object3;
                if (!(object17 instanceof Stream)) {
                    return -786430;
                }
                callContext.value2 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 71: {
                Object object18 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object18) == null) {
                    return -786431;
                }
                callContext.value1 = object18;
                Object object19 = object3;
                if (!(object19 instanceof Stream)) {
                    return -786430;
                }
                callContext.value2 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 88: {
                Object object5 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object5) == null) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                Object object6 = object4;
                if (!(object6 instanceof Stream)) {
                    return -786429;
                }
                callContext.value3 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 74: {
                Object object7 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                Object object8 = object4;
                if (!(object8 instanceof Stream)) {
                    return -786429;
                }
                callContext.value3 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        if (moduleMethod.selector == 91) {
            Object object6 = Promise.force(object2, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                return -786431;
            }
            callContext.value1 = object6;
            Object object7 = Promise.force(object3, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                return -786430;
            }
            callContext.value2 = object7;
            Object object8 = Promise.force(object4, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object8) == null) {
                return -786429;
            }
            callContext.value3 = object8;
            callContext.value4 = object5;
            callContext.proc = moduleMethod;
            callContext.pc = 4;
            return 0;
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 95: {
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
            case 84: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 82: {
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
            case 70: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 68: {
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
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 64: {
                return StreamsDerived.port$To$Stream();
            }
            case 87: {
                return Frame26.lambda59();
            }
        }
        return super.apply0(moduleMethod);
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
            case 63: {
                return StreamsDerived.list$To$Stream((LList)Promise.force(object2, LList.class));
            }
            case 64: {
                return StreamsDerived.port$To$Stream((InPort)Promise.force(object2, InPort.class));
            }
            case 67: {
                Boolean bl;
                if (Frame4.lambda10(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 69: {
                return StreamsDerived.streamConcat((Stream)object2);
            }
            case 75: {
                Boolean bl;
                if (StreamsDerived.lambda34(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 77: {
                return StreamsDerived.streamFrom(LangObjType.coerceNumeric(Promise.force(object2, Numeric.class)));
            }
            case 80: {
                return StreamsDerived.streamLength((Stream)object2);
            }
            case 81: {
                Boolean bl;
                if (Frame19.lambda43(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 86: {
                return StreamsDerived.streamReverse((Stream)object2);
            }
            case 94: {
                Boolean bl;
                if (Frame38.lambda84(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 83: {
                return StreamsDerived.lambda89(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->stream", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "port->stream", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "stream-concat", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "stream-from", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "stream-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "stream-reverse", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
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
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 66: {
                return StreamsDerived.stream$To$List$V(arrobject);
            }
            case 68: {
                return StreamsDerived.streamAppend$V(arrobject);
            }
            case 70: {
                return StreamsDerived.streamConstant$V(arrobject);
            }
            case 76: {
                Object object2 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 1;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 1];
                }
                return StreamsDerived.streamForEach$V(LangObjType.coerceToProcedure(object2), arrobject2);
            }
            case 82: {
                Object object3 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 1;
                Object[] arrobject3 = new Object[n];
                while (--n >= 0) {
                    arrobject3 = arrobject3;
                    arrobject3[n] = arrobject[n + 1];
                }
                return StreamsDerived.streamMap$V(LangObjType.coerceToProcedure(object3), arrobject3);
            }
            case 84: {
                Object object4 = Promise.force(arrobject[0], Numeric.class);
                Object object5 = object4;
                object5 = Promise.force(arrobject[1], Numeric.class);
                int n = arrobject.length - 2;
                Object[] arrobject4 = new Object[n];
                while (--n >= 0) {
                    arrobject4 = arrobject4;
                    arrobject4[n] = arrobject[n + 2];
                }
                return StreamsDerived.streamRange$V(LangObjType.coerceNumeric(object4), LangObjType.coerceNumeric(object5), arrobject4);
            }
            case 92: {
                return Frame33.lambda75$V(arrobject);
            }
            case 95: {
                return StreamsDerived.streamZip$V(arrobject);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }

}

