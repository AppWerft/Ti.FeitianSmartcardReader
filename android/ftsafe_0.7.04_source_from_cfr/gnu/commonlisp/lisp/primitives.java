/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lisp;

import gnu.commonlisp.lang.Lisp2;
import gnu.commonlisp.lisp.PrimOps;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.DynamicLocation;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import java.io.Externalizable;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.lists;

public class primitives
extends ModuleBody {
    static final Location loc$typep;
    static final Location loc$null;
    public static final ModuleMethod car;
    public static final ModuleMethod first;
    public static final ModuleMethod cdr;
    public static final ModuleMethod rest;
    public static final ModuleMethod second;
    public static final ModuleMethod third;
    public static final ModuleMethod nthcdr;
    public static final ModuleMethod nth;
    public static final ModuleMethod $N1$Mn;
    public static final ModuleMethod $N1$Pl;
    public static final ModuleMethod acons;
    public static final ModuleMethod listp;
    public static final ModuleMethod numberp;
    public static final ModuleMethod atom;
    public static final ModuleMethod eql;
    public static final ModuleMethod complement;
    public static final ModuleMethod member$Mnwith$Mntest;
    public static final ModuleMethod member$Mnwith$Mnkey;
    public static final ModuleMethod member$Mnplain;
    public static final ModuleMethod member;
    public static final ModuleMethod apply;
    public static final ModuleMethod funcall;
    public static final ModuleMethod minusp;
    public static final ModuleMethod plusp;
    public static final Macro flet;
    public static final Macro labels;
    public static final Macro multiple$Mnvalue$Mnbind;
    public static final ModuleMethod floor;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final Keyword Lit2;
    static final Keyword Lit3;
    static final Keyword Lit4;
    static final SimpleSymbol Lit5;
    public static primitives $instance;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SyntaxRules Lit33;
    static final SimpleSymbol Lit34;
    static final SyntaxRules Lit35;
    static final SimpleSymbol Lit36;
    static final SyntaxRules Lit37;
    static final SimpleSymbol Lit38;
    static final Object[] Lit39;
    static final SimpleSymbol Lit40;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Object car(Object x) {
        return Lisp2.isTrueLisp(x) ? ((Pair)Promise.force(x, Pair.class)).getCar() : LList.Empty;
    }

    public static Object first(Object x) {
        return primitives.car(x);
    }

    public static Object cdr(Object x) {
        return Lisp2.isTrueLisp(x) ? ((Pair)Promise.force(x, Pair.class)).getCdr() : LList.Empty;
    }

    public static Object rest(Object x) {
        return primitives.cdr(x);
    }

    public static Object second(Object x) {
        return primitives.first(primitives.rest(x));
    }

    public static Object third(Object x) {
        return primitives.first(primitives.rest(primitives.rest(x)));
    }

    public static Object nthcdr(Object n, Object lst) {
        Object object2;
        void result;
        int n2;
        Integer i;
        Object object3 = Promise.force(n);
        try {
            n2 = ((Number)object3).intValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "n", -2, (Object)i);
        }
        Object object4 = n2;
        Object object5 = object2 = lst;
        while (!NumberCompare.$Eq(i = object4, Lit0)) {
            object4 = primitives.$N1$Mn(i);
            object5 = primitives.cdr(result);
        }
        return result;
    }

    public static Object $N1$Mn(Object x) {
        return AddOp.apply2(-1, x, Lit1);
    }

    public static Object nth(Object n, Object x) {
        return primitives.first(primitives.nthcdr(n, x));
    }

    public static Object $N1$Pl(Object x) {
        return AddOp.apply2(1, x, Lit1);
    }

    public static Pair acons(Object key, Object datum, Object alist) {
        return lists.cons(lists.cons(key, datum), alist);
    }

    public static Object listp(Object obj) {
        try {
            return ((Procedure)Promise.force(loc$typep.get(), Procedure.class)).apply2(obj, LangObjType.listType);
        }
        catch (UnboundLocationException unboundLocationException) {
            unboundLocationException.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 39, 3);
            throw unboundLocationException;
        }
    }

    public static Object numberp(Object obj) {
        try {
            return ((Procedure)Promise.force(loc$typep.get(), Procedure.class)).apply2(obj, LangObjType.numericType);
        }
        catch (UnboundLocationException unboundLocationException) {
            unboundLocationException.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 42, 3);
            throw unboundLocationException;
        }
    }

    public static boolean atom(Object obj) {
        return !lists.isPair(obj);
    }

    public static boolean eql(Object x, Object y) {
        return IsEqv.apply(x, y);
    }

    public static Procedure complement(Object pred) {
        public class Frame
        extends ModuleBody {
            Object pred;
            final ModuleMethod lambda$Fn1;

            public Frame() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, -4096);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp:51");
                this.lambda$Fn1 = moduleMethod;
            }

            boolean lambda1$V(Object[] argsArray) {
                LList lList;
                LList arguments = lList = LList.makeList(argsArray, 0);
                return !Lisp2.isTrueLisp(primitives.apply$V(this.pred, new Object[]{arguments}));
            }

            public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
                if (moduleMethod.selector == 1) {
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
                if (moduleMethod.selector == 1) {
                    return this.lambda1$V(arrobject) ? Lisp2.TRUE : LList.Empty;
                }
                return super.applyN(moduleMethod, arrobject);
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.pred = pred;
        return $heapFrame.lambda$Fn1;
    }

    public static Object apply$V(Object func, Object[] argsArray) {
        LList lList;
        LList args = lList = LList.makeList(argsArray, 0);
        return (PrimOps.symbolp(func) ? (Procedure)Promise.force(PrimOps.symbolFunction(func), Procedure.class) : (Procedure)Promise.force(func, Procedure.class)).applyN(Apply.getArguments(args, 0, (Procedure)apply));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object memberWithTest(Object x, Object lst, Object test, Object key) {
        do lbl-1000: // 2 sources:
        {
            object2 = Promise.force(lst, LList.class);
            lst2 = (LList)object2;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "lst", -2, object2);
        }
        {
            block6 : {
                if (!Lisp2.isTrueLisp(((Procedure)Promise.force(primitives.loc$null.get(), Procedure.class)).apply1(lst2))) break block6;
                v1 /* !! */  = LList.Empty;
                return v1 /* !! */ ;
            }
            if (Lisp2.isTrueLisp(primitives.funcall$V(test, new Object[]{x, primitives.funcall$V(key, new Object[]{primitives.car(lst2)})}))) {
                v1 /* !! */  = lst2;
                return v1 /* !! */ ;
            }
            lst = primitives.cdr(lst2);
            ** while (true)
        }
        catch (UnboundLocationException v2) {
            v2.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 56, 10);
            throw v2;
        }
    }

    public static Object funcall$V(Object func, Object[] argsArray) {
        LList lList;
        LList args = lList = LList.makeList(argsArray, 0);
        return primitives.apply$V(func, new Object[]{args});
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object memberWithKey(Object x, Object lst, Object key) {
        do lbl-1000: // 2 sources:
        {
            object2 = Promise.force(lst, LList.class);
            lst2 = (LList)object2;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "lst", -2, object2);
        }
        {
            block6 : {
                if (!Lisp2.isTrueLisp(((Procedure)Promise.force(primitives.loc$null.get(), Procedure.class)).apply1(lst2))) break block6;
                v1 /* !! */  = LList.Empty;
                return v1 /* !! */ ;
            }
            if (primitives.eql(x, primitives.funcall$V(key, new Object[]{primitives.car(lst2)}))) {
                v1 /* !! */  = lst2;
                return v1 /* !! */ ;
            }
            lst = primitives.cdr(lst2);
            ** while (true)
        }
        catch (UnboundLocationException v2) {
            v2.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 62, 10);
            throw v2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object memberPlain(Object x, Object lst) {
        do lbl-1000: // 2 sources:
        {
            object2 = Promise.force(lst, LList.class);
            lst2 = (LList)object2;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "lst", -2, object2);
        }
        {
            block6 : {
                if (!Lisp2.isTrueLisp(((Procedure)Promise.force(primitives.loc$null.get(), Procedure.class)).apply1(lst2))) break block6;
                v1 /* !! */  = LList.Empty;
                return v1 /* !! */ ;
            }
            if (primitives.eql(x, primitives.car(lst2))) {
                v1 /* !! */  = lst2;
                return v1 /* !! */ ;
            }
            lst = primitives.cdr(lst2);
            ** while (true)
        }
        catch (UnboundLocationException v2) {
            v2.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 68, 10);
            throw v2;
        }
    }

    public static Object member$V(Object x, Object lst, Object[] argsArray) {
        void test$Mnsupplied;
        LList lst2;
        void test;
        Object key = Keyword.searchForKeyword(argsArray, 0, Lit2, LList.Empty);
        Object GS$Dt35 = Keyword.searchForKeyword(argsArray, 0, Lit3, Special.undefined);
        Object GS$Dt36 = Keyword.searchForKeyword(argsArray, 0, Lit4, Special.undefined);
        Externalizable externalizable = GS$Dt35 == Special.undefined ? LList.Empty : Lit5;
        Externalizable test$Mnnot$Mnsupplied = GS$Dt36 == Special.undefined ? LList.Empty : Lit5;
        Object object2 = Lisp2.isTrueLisp(test$Mnsupplied) ? GS$Dt35 : LList.Empty;
        Object test$Mnnot = Lisp2.isTrueLisp(test$Mnnot$Mnsupplied) ? GS$Dt36 : LList.Empty;
        Object object3 = Promise.force(lst, LList.class);
        try {
            lst2 = (LList)object3;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lst", -2, object3);
        }
        return Lisp2.isTrueLisp(test$Mnsupplied) ? primitives.memberWithTest(x, lst2, test, key) : (Lisp2.isTrueLisp(test$Mnnot$Mnsupplied) ? primitives.memberWithTest(x, lst2, primitives.complement(test$Mnnot), key) : (Lisp2.isTrueLisp(key) ? primitives.memberWithKey(x, lst2, key) : primitives.memberPlain(x, lst2)));
    }

    public static boolean minusp(Object x) {
        return NumberCompare.$Ls(x, Lit0);
    }

    public static boolean plusp(Object x) {
        return NumberCompare.$Gr(x, Lit0);
    }

    public static Values floor(Object object2) {
        return primitives.floor(object2, Lit1);
    }

    public static Values floor(Object number, Object divisor) {
        return Values.values2(((Procedure)DivideOp.div).apply2(number, divisor), ((Procedure)DivideOp.remainder).apply2(number, divisor));
    }

    public static {
        Lit40 = Symbol.valueOf("lambda");
        Lit39 = new Object[0];
        Lit38 = Symbol.valueOf("floor");
        Lit36 = Symbol.valueOf("multiple-value-bind");
        Lit37 = new SyntaxRules(Lit39, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\r\u0017\u0010\b\b", Lit39, 3, "primitives.lisp:133"), "\u0001\u0001\u0003", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u000b\b\u0011\u0018\f\t\u0003\b\u0015\u0013", new Object[]{Symbol.valueOf("call-with-values"), Lit40}, 1)}, 3, Lit36);
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject = new Object[5];
        Lit32 = Symbol.valueOf("flet");
        arrobject[0] = Lit32;
        arrobject[1] = PairWithPosition.make(Values.empty, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 483359);
        arrobject[2] = Symbol.valueOf("set!");
        arrobject[3] = Symbol.valueOf("function");
        arrobject[4] = Lit40;
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018lM\f\u0007\f\u000f\r\u0017\u0010\b\b\u0000\u0018\b\r\u001f\u0018\b\b", Lit39, 4, "primitives.lisp:117"), "\u0003\u0003\u0005\u0003", "\u0011\u0018\u0004A\b\u0005\t\u0003\t\u000b\u0018\f\u0099\u0005\u0011\u0018\u0014)\u0011\u0018\u001c\b\u0003\b\u0011\u0018$\t\u000b\b\u0015\u0013\b\u001d\u001b", arrobject, 2);
        Lit34 = Symbol.valueOf("labels");
        Lit35 = new SyntaxRules(Lit39, arrsyntaxRule, 4, Lit34);
        Lit33 = new SyntaxRules(Lit39, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018lM\f\u0007\f\u000f\r\u0017\u0010\b\b\u0000\u0018\b\r\u001f\u0018\b\b", Lit39, 4, "primitives.lisp:110"), "\u0003\u0003\u0005\u0003", "\u0011\u0018\u0004i\b\u0005\t\u0003\b\u0011\u0018\f\t\u000b\b\u0015\u0013\b\u001d\u001b", new Object[]{Symbol.valueOf("%flet"), Lit40}, 2)}, 4, Lit32);
        Lit31 = Symbol.valueOf("plusp");
        Lit30 = Symbol.valueOf("minusp");
        Lit29 = Symbol.valueOf("funcall");
        Lit28 = Symbol.valueOf("apply");
        Lit27 = Symbol.valueOf("member");
        Lit26 = Symbol.valueOf("member-plain");
        Lit25 = Symbol.valueOf("member-with-key");
        Lit24 = Symbol.valueOf("member-with-test");
        Lit23 = Symbol.valueOf("complement");
        Lit22 = Symbol.valueOf("eql");
        Lit21 = Symbol.valueOf("atom");
        Lit20 = Symbol.valueOf("numberp");
        Lit19 = Symbol.valueOf("listp");
        Lit18 = Symbol.valueOf("acons");
        Lit17 = Symbol.valueOf("1+");
        Lit16 = Symbol.valueOf("1-");
        Lit15 = Symbol.valueOf("nth");
        Lit14 = Symbol.valueOf("nthcdr");
        Lit13 = Symbol.valueOf("third");
        Lit12 = Symbol.valueOf("second");
        Lit11 = Symbol.valueOf("rest");
        Lit10 = Symbol.valueOf("cdr");
        Lit9 = Symbol.valueOf("first");
        Lit8 = Symbol.valueOf("car");
        Lit7 = Symbol.valueOf("null");
        Lit6 = Symbol.valueOf("typep");
        Lit5 = Symbol.valueOf("t");
        Lit4 = Keyword.make("test-not");
        Lit3 = Keyword.make("test");
        Lit2 = Keyword.make("key");
        Lit1 = IntNum.valueOf(1);
        Lit0 = IntNum.valueOf(0);
        $instance = new primitives();
        loc$typep = DynamicLocation.getInstance(Lit6, Symbol.FUNCTION);
        loc$null = DynamicLocation.getInstance(Lit7, Symbol.FUNCTION);
        primitives primitives2 = $instance;
        car = new ModuleMethod(primitives2, 2, Lit8, 4097);
        first = new ModuleMethod(primitives2, 3, Lit9, 4097);
        cdr = new ModuleMethod(primitives2, 4, Lit10, 4097);
        rest = new ModuleMethod(primitives2, 5, Lit11, 4097);
        second = new ModuleMethod(primitives2, 6, Lit12, 4097);
        third = new ModuleMethod(primitives2, 7, Lit13, 4097);
        nthcdr = new ModuleMethod(primitives2, 8, Lit14, 8194);
        nth = new ModuleMethod(primitives2, 9, Lit15, 8194);
        $N1$Mn = new ModuleMethod(primitives2, 10, Lit16, 4097);
        $N1$Pl = new ModuleMethod(primitives2, 11, Lit17, 4097);
        acons = new ModuleMethod(primitives2, 12, Lit18, 12291);
        listp = new ModuleMethod(primitives2, 13, Lit19, 4097);
        numberp = new ModuleMethod(primitives2, 14, Lit20, 4097);
        atom = new ModuleMethod(primitives2, 15, Lit21, 4097);
        eql = new ModuleMethod(primitives2, 16, Lit22, 8194);
        complement = new ModuleMethod(primitives2, 17, Lit23, 4097);
        member$Mnwith$Mntest = new ModuleMethod(primitives2, 18, Lit24, 16388);
        member$Mnwith$Mnkey = new ModuleMethod(primitives2, 19, Lit25, 12291);
        member$Mnplain = new ModuleMethod(primitives2, 20, Lit26, 8194);
        member = new ModuleMethod(primitives2, 21, Lit27, -4094);
        apply = new ModuleMethod(primitives2, 22, Lit28, -4095);
        funcall = new ModuleMethod(primitives2, 23, Lit29, -4095);
        minusp = new ModuleMethod(primitives2, 24, Lit30, 4097);
        plusp = new ModuleMethod(primitives2, 25, Lit31, 4097);
        flet = Macro.make(Lit32, Lit33, "gnu.commonlisp.lisp.primitives");
        labels = Macro.make(Lit34, Lit35, "gnu.commonlisp.lisp.primitives");
        multiple$Mnvalue$Mnbind = Macro.make(Lit36, Lit37, "gnu.commonlisp.lisp.primitives");
        floor = new ModuleMethod(primitives2, 26, Lit38, 8193);
        primitives.$runBody$();
    }

    public primitives() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 26: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 25: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 24: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 15: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 13: {
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
            case 10: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
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
            case 5: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
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
            case 26: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 20: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 16: {
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

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 19: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 12: {
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
        if (moduleMethod.selector == 18) {
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
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 2: {
                return primitives.car(object2);
            }
            case 3: {
                return primitives.first(object2);
            }
            case 4: {
                return primitives.cdr(object2);
            }
            case 5: {
                return primitives.rest(object2);
            }
            case 6: {
                return primitives.second(object2);
            }
            case 7: {
                return primitives.third(object2);
            }
            case 10: {
                return primitives.$N1$Mn(object2);
            }
            case 11: {
                return primitives.$N1$Pl(object2);
            }
            case 13: {
                return primitives.listp(object2);
            }
            case 14: {
                return primitives.numberp(object2);
            }
            case 15: {
                return primitives.atom(object2) ? Lisp2.TRUE : LList.Empty;
            }
            case 17: {
                return primitives.complement(object2);
            }
            case 24: {
                return primitives.minusp(object2) ? Lisp2.TRUE : LList.Empty;
            }
            case 25: {
                return primitives.plusp(object2) ? Lisp2.TRUE : LList.Empty;
            }
            case 26: {
                return primitives.floor(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 8: {
                return primitives.nthcdr(object2, object3);
            }
            case 9: {
                return primitives.nth(object2, object3);
            }
            case 16: {
                return primitives.eql(object2, object3) ? Lisp2.TRUE : LList.Empty;
            }
            case 20: {
                return primitives.memberPlain(object2, object3);
            }
            case 26: {
                return primitives.floor(object2, object3);
            }
        }
        return super.apply2(moduleMethod, object2, object3);
    }

    public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
        switch (moduleMethod.selector) {
            case 12: {
                return primitives.acons(object2, object3, object4);
            }
            case 19: {
                return primitives.memberWithKey(object2, object3, object4);
            }
        }
        return super.apply3(moduleMethod, object2, object3, object4);
    }

    public Object apply4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5) {
        if (moduleMethod.selector == 18) {
            return primitives.memberWithTest(object2, object3, object4, object5);
        }
        return super.apply4(moduleMethod, object2, object3, object4, object5);
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 21: {
                int n = arrobject.length - 2;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 2];
                }
                return primitives.member$V(arrobject[0], arrobject[1], arrobject2);
            }
            case 22: {
                int n = arrobject.length - 1;
                Object[] arrobject3 = new Object[n];
                while (--n >= 0) {
                    arrobject3 = arrobject3;
                    arrobject3[n] = arrobject[n + 1];
                }
                return primitives.apply$V(arrobject[0], arrobject3);
            }
            case 23: {
                int n = arrobject.length - 1;
                Object[] arrobject4 = new Object[n];
                while (--n >= 0) {
                    arrobject4 = arrobject4;
                    arrobject4[n] = arrobject[n + 1];
                }
                return primitives.funcall$V(arrobject[0], arrobject4);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }

}

