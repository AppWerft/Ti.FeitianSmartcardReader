/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.Setter;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.RealNum;
import kawa.lib.lists;
import kawa.lib.numbers;
import kawa.standard.Scheme;
import kawa.standard.append;

public class srfi95
extends ModuleBody {
    public static final ModuleMethod sorted$Qu;
    public static final ModuleMethod merge;
    public static final ModuleMethod merge$Ex;
    public static final ModuleMethod sort;
    public static final ModuleMethod sort$Ex;
    public static final ModuleMethod $Pcsort$Mnlist;
    public static final ModuleMethod $Pcsort$Mnvector;
    public static final ModuleMethod $Pcvector$Mnsort$Ex;
    static final ModuleMethod identity;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final IntNum Lit2;
    static final IntNum Lit3;
    public static srfi95 $instance;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    static Object identity(Object x) {
        return x;
    }

    public static Object isSorted(Object object2, Object object3) {
        return srfi95.isSorted(object2, object3, identity);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object isSorted(Object seq, Object less$Qu, Object key) {
        if (lists.isNull(seq)) {
            v0 = Boolean.TRUE;
            return v0;
        }
        if (seq instanceof Sequence) {
            object22 = Promise.force(seq, Sequence.class);
            arr2 = (Sequence)object22;
            dimax = -1 + arr2.size();
            v1 = x = dimax <= 1;
            if (x) {
                if (x) {
                    v0 = Boolean.TRUE;
                    return v0;
                }
                v0 = Boolean.FALSE;
                return v0;
            }
        } else {
            block26 : {
                arr2 = Promise.force(seq, Pair.class);
                try {
                    if (!lists.isNull(lists.cdr((Pair)arr2))) break block26;
                    v0 = Boolean.TRUE;
                    return v0;
                }
                catch (ClassCastException v2) {
                    throw new WrongType(v2, "cdr", 1, last2);
                }
            }
            arr2 = Promise.force(seq, Pair.class);
            try {
                v3 = Scheme.applyToArgs.apply2(key, lists.car((Pair)arr2));
            }
            catch (ClassCastException v4) {
                throw new WrongType(v4, "car", 1, last2);
            }
            arr2 = Promise.force(seq, Pair.class);
            try {
                v5 = lists.cdr((Pair)arr2);
            }
            catch (ClassCastException v6) {
                throw new WrongType(v6, "cdr", 1, last2);
            }
            catch (ClassCastException v7) {
                throw new WrongType(v7, "arr", -2, (Object)next);
            }
        }
        v8 = -1 + dimax;
        v9 = Scheme.applyToArgs.apply2(key, arr2.get(dimax));
        do lbl-1000: // 2 sources:
        {
            object5 = v9;
            idx = v8;
            object6 = Promise.force(idx, RealNum.class);
            x2 = numbers.isNegative(LangObjType.coerceRealNum(object6));
            if (!x2) ** break block27
            if (x2) {
                v0 = Boolean.TRUE;
                return v0;
            }
            v0 = Boolean.FALSE;
            return v0;
            break;
        } while (true);
        catch (ClassCastException v10) {
            throw new WrongType(v10, "negative?", 1, nxt);
        }
        {
            
            nxt = Scheme.applyToArgs.apply2(key, Scheme.applyToArgs.apply2(arr2, idx));
            if (!KawaConvert.isTrue(Scheme.applyToArgs.apply3(less$Qu, nxt, last3222))) {
                v0 = Boolean.FALSE;
                return v0;
            }
            v8 = AddOp.apply2(1, srfi95.Lit0, idx);
            v9 = nxt;
            ** while (true)
        }
        do {
            dimax = v5;
            last2 = v3;
            x = lists.isNull(next);
            if (x) {
                if (x) {
                    v0 = Boolean.TRUE;
                    return v0;
                }
                v0 = Boolean.FALSE;
                return v0;
            }
            last3222 = Promise.force(next, Pair.class);
            nxt2 = Scheme.applyToArgs.apply2(key, lists.car((Pair)last3222));
            break;
        } while (true);
        catch (ClassCastException v11) {
            throw new WrongType(v11, "car", 1, last3222);
        }
        {
            if (KawaConvert.isTrue(Scheme.applyToArgs.apply3(less$Qu, nxt2, last2))) {
                v0 = Boolean.FALSE;
                return v0;
            }
            v3 = nxt2;
            last3222 = Promise.force(next, Pair.class);
            v5 = lists.cdr((Pair)last3222);
            continue;
        }
        catch (ClassCastException v12) {
            throw new WrongType(v12, "cdr", 1, last3222);
        }
    }

    public static Object merge(Object object2, Object object3, Object object4) {
        return srfi95.merge(object2, object3, object4, identity);
    }

    /*
     * Exception decompiling
     */
    public static Object merge(Object a, Object b, Object isLess, Object key) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 6 blocks at once
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

    public static Object merge$Ex(Object object2, Object object3, Object object4) {
        return srfi95.merge$Ex(object2, object3, object4, identity);
    }

    public static Object merge$Ex(Object a, Object b, Object less$Qu, Object key) {
        return srfi95.sort$ClMerge$Ex(a, b, less$Qu, key);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object sort$ClMerge$Ex(Object a, Object b, Object isLess, Object key) {
        public class Frame1
        extends ModuleBody {
            Object key;
            Object less$Qu;

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public Object lambda3loop(Object r, Object a, Object kcara, Object b, Object kcarb) {
                Object object2;
                do {
                    block19 : {
                        Values values;
                        if (KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply3(this.less$Qu, kcarb, kcara))) {
                            block18 : {
                                object2 = Promise.force(r, Pair.class);
                                lists.setCdr$Ex((Pair)object2, b);
                                object2 = Promise.force(b, Pair.class);
                                if (!lists.isNull(lists.cdr((Pair)object2))) break block18;
                                object2 = Promise.force(b, Pair.class);
                                lists.setCdr$Ex((Pair)object2, a);
                                values = Values.empty;
                                return values;
                            }
                            Object object3 = b;
                            object2 = Promise.force(b, Pair.class);
                            kcarb = ((Procedure)Scheme.applyToArgs).apply2(this.key, lists.cadr(b));
                            {
                                b = lists.cdr((Pair)object2);
                            }
                            r = object3;
                            continue;
                        }
                        object2 = Promise.force(r, Pair.class);
                        lists.setCdr$Ex((Pair)object2, a);
                        object2 = Promise.force(a, Pair.class);
                        if (!lists.isNull(lists.cdr((Pair)object2))) break block19;
                        object2 = Promise.force(a, Pair.class);
                        lists.setCdr$Ex((Pair)object2, b);
                        values = Values.empty;
                        return values;
                    }
                    Object object4 = a;
                    object2 = Promise.force(a, Pair.class);
                    kcara = ((Procedure)Scheme.applyToArgs).apply2(this.key, lists.cadr(a));
                    {
                        a = lists.cdr((Pair)object2);
                    }
                    r = object4;
                } while (true);
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "set-cdr!", 1, object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "set-cdr!", 1, object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "set-cdr!", 1, object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "set-cdr!", 1, object2);
                }
            }
        }
        Frame1 $heapFrame;
        Object kcarb;
        Object object2;
        Object object3;
        block20 : {
            void kcara;
            $heapFrame = new Frame1();
            $heapFrame.less$Qu = isLess;
            $heapFrame.key = key;
            if (lists.isNull(a)) {
                object2 = b;
                return object2;
            }
            if (lists.isNull(b)) {
                object2 = a;
                return object2;
            }
            Object object4 = Promise.force(a, Pair.class);
            try {
                Object object5 = ((Procedure)Scheme.applyToArgs).apply2($heapFrame.key, lists.car((Pair)object4));
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, kcarb);
            }
            object3 = Promise.force(b, Pair.class);
            try {
                kcarb = ((Procedure)Scheme.applyToArgs).apply2($heapFrame.key, lists.car((Pair)object3));
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, object3);
            }
            if (KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply3($heapFrame.less$Qu, kcarb, kcara))) {
                block19 : {
                    object3 = Promise.force(b, Pair.class);
                    if (!lists.isNull(lists.cdr((Pair)object3))) break block19;
                    object3 = Promise.force(b, Pair.class);
                    lists.setCdr$Ex((Pair)object3, a);
                }
                object3 = Promise.force(b, Pair.class);
                $heapFrame.lambda3loop(b, a, kcara, lists.cdr((Pair)object3), ((Procedure)Scheme.applyToArgs).apply2($heapFrame.key, lists.cadr(b)));
                object2 = b;
                return object2;
            }
            object3 = Promise.force(a, Pair.class);
            try {
                if (!lists.isNull(lists.cdr((Pair)object3))) break block20;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, object3);
            }
            object3 = Promise.force(a, Pair.class);
            try {
                lists.setCdr$Ex((Pair)object3, b);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "set-cdr!", 1, object3);
            }
        }
        object3 = Promise.force(a, Pair.class);
        try {
            $heapFrame.lambda3loop(a, lists.cdr((Pair)object3), ((Procedure)Scheme.applyToArgs).apply2($heapFrame.key, lists.cadr(a)), b, kcarb);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        object2 = a;
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object $PcSortList(Object seq, Object isLess, Object key) {
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

    public static Object sort$Ex(Sequence sequence, Object object2) {
        return srfi95.sort$Ex(sequence, object2, Boolean.FALSE);
    }

    /*
     * Exception decompiling
     */
    public static Object sort$Ex(Sequence seq, Object less$Qu, Object key) {
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
    public static Object $PcVectorSort$Ex(Sequence seq, Object less$Qu, Object key) {
        v0 = srfi95.$PcSortList(srfi95.rank$Mn1Array$To$List(seq), less$Qu, key);
        v1 = srfi95.Lit3;
        do lbl-1000: // 2 sources:
        {
            intNum = v1;
            sorted = v0;
            if (lists.isNull(sorted) != false) return seq;
            object2 = Promise.force(sorted, Pair.class);
            ((Procedure)Promise.force(Setter.setter.apply1(seq), Procedure.class)).apply2(i, lists.car((Pair)object2));
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "car", 1, object2);
        }
        {
            object2 = Promise.force(sorted, Pair.class);
            v0 = lists.cdr((Pair)object2);
            v1 = IntNum.add((IntNum)i, 1);
            ** while (true)
        }
        catch (ClassCastException v3) {
            throw new WrongType(v3, "cdr", 1, object2);
        }
    }

    static Object rank$Mn1Array$To$List(Sequence seq) {
        LList lst = LList.Empty;
        for (int idx = seq.size() - 1; idx >= 0; --idx) {
            lst = lists.cons(seq.get(idx), lst);
        }
        return lst;
    }

    public static FVector $PcSortVector(Sequence sequence, Object object2) {
        return srfi95.$PcSortVector(sequence, object2, Boolean.FALSE);
    }

    /*
     * Exception decompiling
     */
    public static FVector $PcSortVector(Sequence seq, Object less$Qu, Object key) {
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

    public static Object sort(Sequence sequence, Object object2) {
        return srfi95.sort(sequence, object2, Boolean.FALSE);
    }

    public static Object sort(Sequence seq, Object less$Qu, Object key) {
        return lists.isList(seq) ? srfi95.$PcSortList(append.append$V(new Object[]{seq, LList.Empty}), less$Qu, key) : srfi95.$PcSortVector(seq, less$Qu, key);
    }

    public static {
        Lit12 = Symbol.valueOf("sort");
        Lit11 = Symbol.valueOf("%sort-vector");
        Lit10 = Symbol.valueOf("%vector-sort!");
        Lit9 = Symbol.valueOf("sort!");
        Lit8 = Symbol.valueOf("%sort-list");
        Lit7 = Symbol.valueOf("merge!");
        Lit6 = Symbol.valueOf("merge");
        Lit5 = Symbol.valueOf("sorted?");
        Lit4 = Symbol.valueOf("identity");
        Lit3 = IntNum.valueOf(0);
        Lit2 = IntNum.valueOf(1);
        Lit1 = IntNum.valueOf(2);
        Lit0 = IntNum.valueOf(-1);
        srfi95 srfi952 = $instance = new srfi95();
        identity = new ModuleMethod(srfi952, 1, Lit4, 4097);
        sorted$Qu = new ModuleMethod(srfi952, 2, Lit5, 12290);
        merge = new ModuleMethod(srfi952, 4, Lit6, 16387);
        merge$Ex = new ModuleMethod(srfi952, 6, Lit7, 16387);
        $Pcsort$Mnlist = new ModuleMethod(srfi952, 8, Lit8, 12291);
        sort$Ex = new ModuleMethod(srfi952, 9, Lit9, 12290);
        $Pcvector$Mnsort$Ex = new ModuleMethod(srfi952, 11, Lit10, 12291);
        $Pcsort$Mnvector = new ModuleMethod(srfi952, 12, Lit11, 12290);
        sort = new ModuleMethod(srfi952, 14, Lit12, 12290);
        srfi95.$runBody$();
    }

    public srfi95() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.value1 = object2;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 14: {
                Object object4 = Promise.force(object2, Sequence.class);
                if (!(object4 instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 12: {
                Object object5 = Promise.force(object2, Sequence.class);
                if (!(object5 instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 9: {
                Object object6 = Promise.force(object2, Sequence.class);
                if (!(object6 instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 2: {
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
            case 14: {
                Object object5 = Promise.force(object2, Sequence.class);
                if (!(object5 instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 12: {
                Object object6 = Promise.force(object2, Sequence.class);
                if (!(object6 instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 11: {
                Object object7 = Promise.force(object2, Sequence.class);
                if (!(object7 instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 9: {
                Object object8 = Promise.force(object2, Sequence.class);
                if (!(object8 instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 8: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 6: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 4: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 2: {
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
            case 6: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 4: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector == 1) {
            return srfi95.identity(object2);
        }
        return super.apply1(moduleMethod, object2);
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
            case 2: {
                return srfi95.isSorted(object2, object3);
            }
            case 9: {
                return srfi95.sort$Ex((Sequence)Promise.force(object2, Sequence.class), object3);
            }
            case 12: {
                return srfi95.$PcSortVector((Sequence)Promise.force(object2, Sequence.class), object3);
            }
            case 14: {
                return srfi95.sort((Sequence)Promise.force(object2, Sequence.class), object3);
            }
        }
        return super.apply2(moduleMethod, object2, object3);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sort!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%sort-vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sort", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
        switch (moduleMethod.selector) {
            case 2: {
                return srfi95.isSorted(object2, object3, object4);
            }
            case 4: {
                return srfi95.merge(object2, object3, object4);
            }
            case 6: {
                return srfi95.merge$Ex(object2, object3, object4);
            }
            case 8: {
                return srfi95.$PcSortList(object2, object3, object4);
            }
            case 9: {
                return srfi95.sort$Ex((Sequence)Promise.force(object2, Sequence.class), object3, object4);
            }
            case 11: {
                return srfi95.$PcVectorSort$Ex((Sequence)Promise.force(object2, Sequence.class), object3, object4);
            }
            case 12: {
                return srfi95.$PcSortVector((Sequence)Promise.force(object2, Sequence.class), object3, object4);
            }
            case 14: {
                return srfi95.sort((Sequence)Promise.force(object2, Sequence.class), object3, object4);
            }
        }
        return super.apply3(moduleMethod, object2, object3, object4);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sort!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%vector-sort!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%sort-vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sort", 1, object2);
        }
    }

    public Object apply4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5) {
        switch (moduleMethod.selector) {
            case 4: {
                return srfi95.merge(object2, object3, object4, object5);
            }
            case 6: {
                return srfi95.merge$Ex(object2, object3, object4, object5);
            }
        }
        return super.apply4(moduleMethod, object2, object3, object4, object5);
    }

}

