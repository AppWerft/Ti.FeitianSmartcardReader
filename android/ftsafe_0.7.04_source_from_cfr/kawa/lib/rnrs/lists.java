/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.rnrs;

import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lang.Continuation;
import kawa.standard.Scheme;

public class lists
extends ModuleBody {
    public static final ModuleMethod find;
    public static final ModuleMethod for$Mnall;
    public static final ModuleMethod exists;
    public static final ModuleMethod filter;
    public static final ModuleMethod partition;
    public static final ModuleMethod fold$Mnleft;
    public static final ModuleMethod fold$Mnright;
    public static final ModuleMethod remp;
    public static final ModuleMethod remove;
    public static final ModuleMethod remv;
    public static final ModuleMethod remq;
    public static final ModuleMethod memp;
    public static final StaticFieldLocation member;
    public static final StaticFieldLocation memv;
    public static final StaticFieldLocation memq;
    public static final ModuleMethod assp;
    public static final StaticFieldLocation assoc;
    public static final StaticFieldLocation assv;
    public static final StaticFieldLocation assq;
    public static final ModuleMethod cons$St;
    public static lists $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object find(Procedure proc, LList lst) {
        Object object2;
        Object x;
        Object object3;
        LList list;
        Object object4 = lst;
        do {
            if (kawa.lib.lists.isNull(list = object4)) {
                object3 = Boolean.FALSE;
                return object3;
            }
            object2 = Promise.force(list, Pair.class);
            x = kawa.lib.lists.car((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        {
            if (KawaConvert.isTrue(proc.apply1(x))) {
                object3 = x;
                return object3;
            }
            object2 = Promise.force(list, Pair.class);
            object4 = kawa.lib.lists.cdr((Pair)object2);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object forAll$V(Procedure proc, LList list1, Object[] argsArray) {
        object4 = LList.makeList(argsArray, 0);
        lists2 = object4;
        if (!kawa.lib.lists.isPair(lists2)) {
            x = kawa.lib.lists.isNull(list1);
            if (x) {
                if (x) {
                    v0 = Boolean.TRUE;
                    return v0;
                }
                v0 = Boolean.FALSE;
                return v0;
            }
            lList = list1;
            try {
                v1 = kawa.lib.lists.car((Pair)lList);
                lList = list1;
            }
            catch (ClassCastException v2) {
                throw new WrongType(v2, "car", 1, head);
            }
            try {
                v3 = kawa.lib.lists.cdr((Pair)lList);
            }
            catch (ClassCastException v4) {
                throw new WrongType(v4, "cdr", 1, head);
            }
        } else {
            object4 = lists.$PcCars$PlCdrs(kawa.lib.lists.cons(list1, lists2));
            n = 0;
            n = Values.incrPos(object4, n);
            object5 = Values.getFromPos(object4, n);
            n = Values.incrPos(object4, n);
            tails2222 = Values.getFromPosFinal(object4, n);
            v5 = x = kawa.lib.lists.isPair(heads2) == false;
            if (x) {
                if (x) {
                    v0 = Boolean.TRUE;
                    return v0;
                }
                v0 = Boolean.FALSE;
                return v0;
            }
            v6 = heads2;
            v7 = tails2222;
            do lbl-1000: // 2 sources:
            {
                object7 = v7;
                heads = v6;
                object22 = Promise.force(tails3, LList.class);
                object8 = lists.$PcCars$PlCdrs((LList)object22);
                n2 = 0;
                break;
            } while (true);
            catch (ClassCastException v8) {
                throw new WrongType(v8, "%cars+cdrs", 0, object22);
            }
            {
                n2 = Values.incrPos(object8, n2);
                object9 = Values.getFromPos(object8, n2);
                n2 = Values.incrPos(object8, n2);
                next$Mntails = Values.getFromPosFinal(object8, n2);
                if (!kawa.lib.lists.isPair(next$Mnheads)) {
                    v0 = Scheme.apply.apply2(proc, heads);
                    return v0;
                }
                if (!KawaConvert.isTrue(Scheme.apply.apply2(proc, heads))) {
                    v0 = Boolean.FALSE;
                    return v0;
                }
                v6 = next$Mnheads;
                v7 = next$Mntails;
                ** while (true)
            }
        }
        do {
            heads2 = v3;
            head = v1;
            if (kawa.lib.lists.isNull(tail)) {
                v0 = proc.apply1(head);
                return v0;
            }
            if (!KawaConvert.isTrue(proc.apply1(head))) {
                v0 = Boolean.FALSE;
                return v0;
            }
            tails2222 = Promise.force(tail, Pair.class);
            v1 = kawa.lib.lists.car((Pair)tails2222);
            break;
        } while (true);
        catch (ClassCastException v9) {
            throw new WrongType(v9, "car", 1, tails2222);
        }
        {
            tails2222 = Promise.force(tail, Pair.class);
            v3 = kawa.lib.lists.cdr((Pair)tails2222);
            continue;
        }
        catch (ClassCastException v10) {
            throw new WrongType(v10, "cdr", 1, tails2222);
        }
    }

    static Object $PcCars$PlCdrs(LList lists2) {
        Object object2;
        CallContext $ctx = CallContext.getInstance();
        Continuation continuation = new Continuation($ctx);
        try {
            Continuation abort = continuation;
            public class Frame4
            extends ModuleBody {
                Continuation abort;

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public Object lambda7recur(Object lists2) {
                    void cars;
                    Values.Values2 values2;
                    int n2;
                    int n;
                    Values values;
                    void list;
                    void a;
                    Values values3;
                    if (!kawa.lib.lists.isPair(lists2)) {
                        values2 = Values.values2(LList.Empty, LList.Empty);
                        return values2;
                    }
                    Object object2 = Promise.force(lists2, Pair.class);
                    try {
                        values = lists.car$PlCdr((Pair)object2);
                        n = 0;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car+cdr", 0, object2);
                    }
                    n = Values.incrPos(values, n);
                    Object object4 = Values.getFromPos(values, n);
                    n = Values.incrPos(values, n);
                    Object other$Mnlists = Values.getFromPosFinal(values, n);
                    if (kawa.lib.lists.isNull(list)) {
                        values2 = ((Procedure)this.abort).apply2(LList.Empty, LList.Empty);
                        return values2;
                    }
                    Object object3 = Promise.force(list, Pair.class);
                    try {
                        values3 = lists.car$PlCdr((Pair)object3);
                        n2 = 0;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car+cdr", 0, object3);
                    }
                    n2 = Values.incrPos(values3, n2);
                    Object object5 = Values.getFromPos(values3, n2);
                    n2 = Values.incrPos(values3, n2);
                    Object d = Values.getFromPosFinal(values3, n2);
                    Object object6 = this.lambda7recur(other$Mnlists);
                    int n3 = 0;
                    n3 = Values.incrPos(object6, n3);
                    Object object7 = Values.getFromPos(object6, n3);
                    n3 = Values.incrPos(object6, n3);
                    Object cdrs = Values.getFromPosFinal(object6, n3);
                    values2 = Values.values2(kawa.lib.lists.cons(a, cars), kawa.lib.lists.cons(d, cdrs));
                    return values2;
                }
            }
            Frame4 $heapFrame = new Frame4();
            $heapFrame.abort = abort;
            continuation.invoked = true;
            object2 = $heapFrame.lambda7recur(lists2);
        }
        catch (Throwable throwable) {
            object2 = Continuation.handleException(throwable, continuation);
        }
        return object2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object exists$V(Procedure proc, LList list1, Object[] argsArray) {
        object3 = LList.makeList(argsArray, 0);
        lists2 = object3;
        if (!kawa.lib.lists.isPair(lists2)) {
            if (kawa.lib.lists.isNull(list1)) {
                v0 = Boolean.FALSE;
                return v0;
            }
            object3 = list1;
            try {
                v1 = kawa.lib.lists.car((Pair)object3);
                object3 = list1;
            }
            catch (ClassCastException v2) {
                throw new WrongType(v2, "car", 1, head);
            }
            try {
                v3 = kawa.lib.lists.cdr((Pair)object3);
            }
            catch (ClassCastException v4) {
                throw new WrongType(v4, "cdr", 1, head);
            }
        } else {
            object3 = lists.$PcCars$PlCdrs(kawa.lib.lists.cons(list1, lists2));
            n = 0;
            n = Values.incrPos(object3, n);
            object4 = Values.getFromPos(object3, n);
            n = Values.incrPos(object3, n);
            tails2222 = Values.getFromPosFinal(object3, n);
            if (!kawa.lib.lists.isPair(heads)) {
                v0 = Boolean.FALSE;
                return v0;
            }
            v5 = heads;
            v6 = tails2222;
            do lbl-1000: // 2 sources:
            {
                object7 = v6;
                heads2 = v5;
                object8 = Promise.force(tails3, LList.class);
                split = lists.$PcCars$PlCdrs$SlPair((LList)object8);
                break;
            } while (true);
            catch (ClassCastException v7) {
                throw new WrongType(v7, "%cars+cdrs/pair", 0, next$Mnheads);
            }
            {
                next$Mnheads = kawa.lib.lists.car(split);
                next$Mntails = kawa.lib.lists.cdr(split);
                if (!kawa.lib.lists.isPair(next$Mnheads)) {
                    v0 = Scheme.apply.apply2(proc, heads2);
                    return v0;
                }
                x = Scheme.apply.apply2(proc, heads2);
                if (KawaConvert.isTrue(x)) {
                    v0 = x;
                    return v0;
                }
                v5 = next$Mnheads;
                v6 = next$Mntails;
                ** while (true)
            }
        }
        do {
            object11 = v3;
            head = v1;
            if (kawa.lib.lists.isNull(tail)) {
                v0 = proc.apply1(head);
                return v0;
            }
            x = proc.apply1(head);
            if (KawaConvert.isTrue(x)) {
                v0 = x;
                return v0;
            }
            tails2222 = Promise.force(tail, Pair.class);
            v1 = kawa.lib.lists.car((Pair)tails2222);
            break;
        } while (true);
        catch (ClassCastException v8) {
            throw new WrongType(v8, "car", 1, tails2222);
        }
        {
            tails2222 = Promise.force(tail, Pair.class);
            v3 = kawa.lib.lists.cdr((Pair)tails2222);
            continue;
        }
        catch (ClassCastException v9) {
            throw new WrongType(v9, "cdr", 1, tails2222);
        }
    }

    static Pair $PcCars$PlCdrs$SlPair(LList lists2) {
        void cars;
        Object object2 = lists.$PcCars$PlCdrs(lists2);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object cdrs = Values.getFromPosFinal(object2, n);
        return kawa.lib.lists.cons(cars, cdrs);
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static Object filter(Procedure proc, LList lst) {
        Object object2;
        Object object3;
        Object tail;
        Object object4 = lst;
        LList lList = LList.Empty;
        block6 : do {
            EmptyList res = lList;
            Object list = object4;
            do {
                void head;
                if (kawa.lib.lists.isNull(list)) {
                    object2 = Promise.force(res, LList.class);
                    break block6;
                }
                Object object5 = Promise.force(list, Pair.class);
                object2 = kawa.lib.lists.car((Pair)object5);
                object3 = Promise.force(list, Pair.class);
                tail = kawa.lib.lists.cdr((Pair)object3);
                if (KawaConvert.isTrue(proc.apply1(head))) {
                    object4 = tail;
                    lList = kawa.lib.lists.cons(head, res);
                    continue block6;
                }
                list = tail;
            } while (true);
            break;
        } while (true);
        return kawa.lib.lists.reverse$Ex((LList)object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, tail);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object partition(Procedure proc, LList lst) {
        var4_2 = LList.Empty;
        in /* !! */  = LList.Empty;
        list = lst;
        do lbl-1000: // 3 sources:
        {
            if (kawa.lib.lists.isNull(list)) {
                v0 = Promise.force(in /* !! */ , LList.class);
                var5_5 = v0;
                var5_5 = Promise.force(out, LList.class);
                return Values.values2(kawa.lib.lists.reverse$Ex((LList)v0), kawa.lib.lists.reverse$Ex((LList)var5_5));
            }
            var6_6 = Promise.force(list, Pair.class);
            var5_5 = kawa.lib.lists.car((Pair)var6_6);
            break;
        } while (true);
        catch (ClassCastException v1) {
            throw new WrongType(v1, "car", 1, tail);
        }
        {
            var7_7 = Promise.force(list, Pair.class);
            tail = kawa.lib.lists.cdr((Pair)var7_7);
            if (KawaConvert.isTrue(proc.apply1(head))) {
                in /* !! */  = kawa.lib.lists.cons(head, in /* !! */ );
                list = tail;
                continue;
            }
            out = kawa.lib.lists.cons(head, out);
            list = tail;
            ** while (true)
        }
        catch (ClassCastException v2) {
            throw new WrongType(v2, "cdr", 1, var7_7);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object foldLeft$V(Procedure combine, Object nil, LList list1, Object[] argsArray) {
        lList = LList.makeList(argsArray, 0);
        lists2 = lList;
        if (kawa.lib.lists.isPair(lists2)) {
            v0 = kawa.lib.lists.cons(list1, lists2);
            v1 = nil;
            do lbl-1000: // 2 sources:
            {
                object7 = v1;
                lists3 = v0;
                object2 = Promise.force(lists3, LList.class);
                object8 = lists.$PcCars$PlCdrs((LList)object2);
                n = 0;
                break;
            } while (true);
            catch (ClassCastException v2) {
                throw new WrongType(v2, "%cars+cdrs", 0, object2);
            }
            {
                n = Values.incrPos(object8, n);
                object9 = Values.getFromPos(object8, n);
                n = Values.incrPos(object8, n);
                cdrs = Values.getFromPosFinal(object8, n);
                if (kawa.lib.lists.isNull(cars)) {
                    v3 = ans2222;
                    return v3;
                }
                v0 = cdrs;
                v1 = Scheme.apply.apply3(combine, ans2222, cars);
                ** while (true)
            }
        }
        v4 = list1;
        v5 = nil;
        do {
            ans2222 = v5;
            list = v4;
            if (kawa.lib.lists.isNull(list)) {
                v3 = ans;
                return v3;
            }
            object3 = Promise.force(list, Pair.class);
            v4 = kawa.lib.lists.cdr((Pair)object3);
            break;
        } while (true);
        catch (ClassCastException v6) {
            throw new WrongType(v6, "cdr", 1, object3);
        }
        {
            object3 = Promise.force(list, Pair.class);
            v5 = combine.apply2(ans, kawa.lib.lists.car((Pair)object3));
            continue;
        }
        catch (ClassCastException v7) {
            throw new WrongType(v7, "car", 1, object3);
        }
    }

    public static Object foldRight$V(Procedure combine, Object nil, LList list1, Object[] argsArray) {
        public class Frame
        extends ModuleBody {
            Procedure combine;
            Object nil;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda1recur(Object lists2) {
                Object object2;
                Object cdrs = lists.$PcCdrs(lists2);
                if (kawa.lib.lists.isNull(cdrs)) {
                    object2 = this.nil;
                    return object2;
                }
                Object object22 = Promise.force(lists2, LList.class);
                try {
                    object2 = ((Procedure)Scheme.apply).apply2(this.combine, lists.$PcCars$Pl((LList)object22, this.lambda1recur(cdrs)));
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "%cars+", 0, object22);
                }
                return object2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda2recur(Object list) {
                Object head;
                Object object2;
                if (kawa.lib.lists.isNull(list)) {
                    object2 = this.nil;
                    return object2;
                }
                Object object22 = Promise.force(list, Pair.class);
                try {
                    head = kawa.lib.lists.car((Pair)object22);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object22);
                }
                object22 = Promise.force(list, Pair.class);
                try {
                    object2 = this.combine.apply2(head, this.lambda2recur(kawa.lib.lists.cdr((Pair)object22)));
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object22);
                }
                return object2;
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.combine = combine;
        $heapFrame.nil = nil;
        LList lList = LList.makeList(argsArray, 0);
        LList lists2 = lList;
        return kawa.lib.lists.isPair(lists2) ? $heapFrame.lambda1recur(kawa.lib.lists.cons(list1, lists2)) : $heapFrame.lambda2recur(list1);
    }

    static Object $PcCdrs(Object lists2) {
        Object object2;
        CallContext $ctx = CallContext.getInstance();
        Continuation continuation = new Continuation($ctx);
        try {
            Continuation abort = continuation;
            public class Frame5
            extends ModuleBody {
                Continuation abort;

                /*
                 * Exception decompiling
                 */
                public Object lambda8recur(Object lists) {
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
            }
            Frame5 $heapFrame = new Frame5();
            $heapFrame.abort = abort;
            continuation.invoked = true;
            object2 = $heapFrame.lambda8recur(lists2);
        }
        catch (Throwable throwable) {
            object2 = Continuation.handleException(throwable, continuation);
        }
        return object2;
    }

    static LList $PcCars$Pl(LList lists2, Object lastElt) {
        public class Frame6
        extends ModuleBody {
            Object last$Mnelt;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda9recur(Object lists2) {
                Pair pair;
                if (!kawa.lib.lists.isPair(lists2)) {
                    pair = LList.list1(this.last$Mnelt);
                    return pair;
                }
                Object object2 = Promise.force(lists2, Pair.class);
                try {
                    pair = kawa.lib.lists.cons(kawa.lib.lists.caar(lists2), this.lambda9recur(kawa.lib.lists.cdr((Pair)object2)));
                    return pair;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object2);
                }
            }
        }
        Frame6 $heapFrame = new Frame6();
        $heapFrame.last$Mnelt = lastElt;
        return (LList)Promise.force($heapFrame.lambda9recur(lists2), LList.class);
    }

    public static LList remp(Procedure proc, LList lst) {
        return (LList)Promise.force(lists.filter(lists.complement(proc), lst), LList.class);
    }

    static Procedure complement(Procedure proc) {
        public class Frame3
        extends ModuleBody {
            Procedure proc;
            final ModuleMethod lambda$Fn4;

            public Frame3() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 4, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:16");
                this.lambda$Fn4 = moduleMethod;
            }

            boolean lambda6(Object x) {
                return !KawaConvert.isTrue(this.proc.apply1(x));
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
                    return this.lambda6(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame3 $heapFrame = new Frame3();
        $heapFrame.proc = proc;
        return $heapFrame.lambda$Fn4;
    }

    public static LList remove(Object obj, LList lst) {
        public class Frame0
        extends ModuleBody {
            Object obj;
            final ModuleMethod lambda$Fn1;

            public Frame0() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:259");
                this.lambda$Fn1 = moduleMethod;
            }

            boolean lambda3(Object o) {
                return !KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(o, this.obj));
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

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply1(ModuleMethod moduleMethod, Object object2) {
                if (moduleMethod.selector == 1) {
                    return this.lambda3(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame0 $heapFrame = new Frame0();
        $heapFrame.obj = obj;
        return (LList)Promise.force(lists.filter($heapFrame.lambda$Fn1, lst), LList.class);
    }

    public static LList remv(Object obj, LList lst) {
        public class Frame1
        extends ModuleBody {
            Object obj;
            final ModuleMethod lambda$Fn2;

            public Frame1() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 2, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:266");
                this.lambda$Fn2 = moduleMethod;
            }

            boolean lambda4(Object o) {
                return !IsEqv.apply(o, this.obj);
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
                    return this.lambda4(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame1 $heapFrame = new Frame1();
        $heapFrame.obj = obj;
        return (LList)Promise.force(lists.filter($heapFrame.lambda$Fn2, lst), LList.class);
    }

    public static LList remq(Object obj, LList lst) {
        public class Frame2
        extends ModuleBody {
            Object obj;
            final ModuleMethod lambda$Fn3;

            public Frame2() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 3, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:273");
                this.lambda$Fn3 = moduleMethod;
            }

            boolean lambda5(Object o) {
                return o != this.obj;
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
                    return this.lambda5(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame2 $heapFrame = new Frame2();
        $heapFrame.obj = obj;
        return (LList)Promise.force(lists.filter($heapFrame.lambda$Fn3, lst), LList.class);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object memp(Procedure proc, LList lst) {
        v0 = lst;
        do {
            if (kawa.lib.lists.isNull(list = v0)) {
                v1 /* !! */  = Boolean.FALSE;
                return v1 /* !! */ ;
            }
            object2 = Promise.force(list, Pair.class);
            if (!KawaConvert.isTrue(proc.apply1(kawa.lib.lists.car((Pair)object2)))) ** break block6
            v1 /* !! */  = list;
            return v1 /* !! */ ;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "car", 1, object2);
        }
        {
            
            object2 = Promise.force(list, Pair.class);
            v0 = kawa.lib.lists.cdr((Pair)object2);
            continue;
        }
        catch (ClassCastException v3) {
            throw new WrongType(v3, "cdr", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object assp(Procedure proc, LList alist) {
        Object object2;
        Object object3 = alist;
        do {
            LList alist2;
            Object object4;
            if (kawa.lib.lists.isNull(alist2 = object3)) {
                object4 = Boolean.FALSE;
                return object4;
            }
            if (KawaConvert.isTrue(proc.apply1(kawa.lib.lists.caar(alist2)))) {
                object2 = Promise.force(alist2, Pair.class);
                object4 = kawa.lib.lists.car((Pair)object2);
                return object4;
            }
            object2 = Promise.force(alist2, Pair.class);
            object3 = kawa.lib.lists.cdr((Pair)object2);
            continue;
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    public static /* varargs */ Object cons$St(Object ... args) {
        return LList.consX(args);
    }

    static Values car$PlCdr(Pair pair) {
        return Values.values2(kawa.lib.lists.car(pair), kawa.lib.lists.cdr(pair));
    }

    public static {
        Lit13 = Symbol.valueOf("cons*");
        Lit12 = Symbol.valueOf("assp");
        Lit11 = Symbol.valueOf("memp");
        Lit10 = Symbol.valueOf("remq");
        Lit9 = Symbol.valueOf("remv");
        Lit8 = Symbol.valueOf("remove");
        Lit7 = Symbol.valueOf("remp");
        Lit6 = Symbol.valueOf("fold-right");
        Lit5 = Symbol.valueOf("fold-left");
        Lit4 = Symbol.valueOf("partition");
        Lit3 = Symbol.valueOf("filter");
        Lit2 = Symbol.valueOf("exists");
        Lit1 = Symbol.valueOf("for-all");
        Lit0 = Symbol.valueOf("find");
        $instance = new lists();
        memq = StaticFieldLocation.make("kawa.lib.lists", "memq");
        memv = StaticFieldLocation.make("kawa.lib.lists", "memv");
        member = StaticFieldLocation.make("kawa.lib.lists", "member");
        assq = StaticFieldLocation.make("kawa.lib.lists", "assq");
        assv = StaticFieldLocation.make("kawa.lib.lists", "assv");
        assoc = StaticFieldLocation.make("kawa.lib.lists", "assoc");
        lists lists2 = $instance;
        find = new ModuleMethod(lists2, 5, Lit0, 8194);
        for$Mnall = new ModuleMethod(lists2, 6, Lit1, -4094);
        exists = new ModuleMethod(lists2, 7, Lit2, -4094);
        filter = new ModuleMethod(lists2, 8, Lit3, 8194);
        partition = new ModuleMethod(lists2, 9, Lit4, 8194);
        fold$Mnleft = new ModuleMethod(lists2, 10, Lit5, -4093);
        fold$Mnright = new ModuleMethod(lists2, 11, Lit6, -4093);
        remp = new ModuleMethod(lists2, 12, Lit7, 8194);
        remove = new ModuleMethod(lists2, 13, Lit8, 8194);
        remv = new ModuleMethod(lists2, 14, Lit9, 8194);
        remq = new ModuleMethod(lists2, 15, Lit10, 8194);
        memp = new ModuleMethod(lists2, 16, Lit11, 8194);
        assp = new ModuleMethod(lists2, 17, Lit12, 8194);
        cons$St = new ModuleMethod(lists2, 18, Lit13, -4096);
        lists.$runBody$();
    }

    public lists() {
        ModuleInfo.register(this);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 17: {
                Object object4 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, LList.class);
                if (!(object5 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 16: {
                Object object6 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, LList.class);
                if (!(object7 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                callContext.value1 = object2;
                Object object8 = Promise.force(object3, LList.class);
                if (!(object8 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 14: {
                callContext.value1 = object2;
                Object object9 = Promise.force(object3, LList.class);
                if (!(object9 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 13: {
                callContext.value1 = object2;
                Object object10 = Promise.force(object3, LList.class);
                if (!(object10 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 12: {
                Object object11 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object11) == null) {
                    return -786431;
                }
                callContext.value1 = object11;
                Object object12 = Promise.force(object3, LList.class);
                if (!(object12 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 9: {
                Object object13 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object13) == null) {
                    return -786431;
                }
                callContext.value1 = object13;
                Object object14 = Promise.force(object3, LList.class);
                if (!(object14 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 8: {
                Object object15 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object15) == null) {
                    return -786431;
                }
                callContext.value1 = object15;
                Object object16 = Promise.force(object3, LList.class);
                if (!(object16 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 5: {
                Object object17 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object17) == null) {
                    return -786431;
                }
                callContext.value1 = object17;
                Object object18 = Promise.force(object3, LList.class);
                if (!(object18 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 18: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 11: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 10: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 7: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 6: {
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 6: {
                Object object2 = Promise.force(arrobject[0], Procedure.class);
                Object object3 = object2;
                object3 = Promise.force(arrobject[1], LList.class);
                int n = arrobject.length - 2;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 2];
                }
                return lists.forAll$V(LangObjType.coerceToProcedure(object2), (LList)object3, arrobject2);
            }
            case 7: {
                Object object4 = Promise.force(arrobject[0], Procedure.class);
                Object object5 = object4;
                object5 = Promise.force(arrobject[1], LList.class);
                int n = arrobject.length - 2;
                Object[] arrobject3 = new Object[n];
                while (--n >= 0) {
                    arrobject3 = arrobject3;
                    arrobject3[n] = arrobject[n + 2];
                }
                return lists.exists$V(LangObjType.coerceToProcedure(object4), (LList)object5, arrobject3);
            }
            case 10: {
                Object object6 = Promise.force(arrobject[0], Procedure.class);
                Object object7 = object6;
                object7 = Promise.force(arrobject[2], LList.class);
                int n = arrobject.length - 3;
                Object[] arrobject4 = new Object[n];
                while (--n >= 0) {
                    arrobject4 = arrobject4;
                    arrobject4[n] = arrobject[n + 3];
                }
                return lists.foldLeft$V(LangObjType.coerceToProcedure(object6), arrobject[1], (LList)object7, arrobject4);
            }
            case 11: {
                Object object8 = Promise.force(arrobject[0], Procedure.class);
                Object object9 = object8;
                object9 = Promise.force(arrobject[2], LList.class);
                int n = arrobject.length - 3;
                Object[] arrobject5 = new Object[n];
                while (--n >= 0) {
                    arrobject5 = arrobject5;
                    arrobject5[n] = arrobject[n + 3];
                }
                return lists.foldRight$V(LangObjType.coerceToProcedure(object8), arrobject[1], (LList)object9, arrobject5);
            }
            case 18: {
                return lists.cons$St(arrobject);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }

}

