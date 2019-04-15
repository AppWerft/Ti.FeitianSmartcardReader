/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.slib.genwrite;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;

public class genwrite
extends ModuleBody {
    public static final ModuleMethod generic$Mnwrite;
    public static final ModuleMethod reverse$Mnstring$Mnappend;
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
    static final IntNum Lit13;
    static final IntNum Lit14;
    static final IntNum Lit15;
    static final IntNum Lit16;
    static final IntNum Lit17;
    static final IntNum Lit18;
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
    public static genwrite $instance;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Object genericWrite(Object obj, Object isDisplay, Object width, Object output) {
        Object object2;
        public class Frame
        extends ModuleBody {
            Object width;
            Object display$Qu;
            Object output;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda1out(Object str, Object col) {
                Object object2;
                if (!KawaConvert.isTrue(col)) {
                    object2 = Boolean.FALSE;
                    return object2;
                }
                if (!KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply2(this.output, str))) {
                    object2 = Boolean.FALSE;
                    return object2;
                }
                Object object22 = Promise.force(str, CharSequence.class);
                try {
                    object2 = AddOp.apply2(1, col, strings.stringLength((CharSequence)object22));
                    return object2;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "string-length", 1, object22);
                }
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public static boolean lambda3isReadMacro(Object l) {
                var2_1 = Promise.force(l, Pair.class);
                try {
                    var1_2 = lists.car((Pair)var2_1);
                }
                catch (ClassCastException v0) {
                    throw new WrongType(v0, "car", 1, tail);
                }
                var3_3 = Promise.force(l, Pair.class);
                try {
                    tail = lists.cdr((Pair)var3_3);
                }
                catch (ClassCastException v1) {
                    throw new WrongType(v1, "cdr", 1, l);
                }
                switch (head.hashCode()) {
                    case -279091325: {
                        if (IsEqv.apply(head, genwrite.Lit29) == false) return false;
                        ** GOTO lbl23
                    }
                    case 1896636553: {
                        if (IsEqv.apply(head, genwrite.Lit30) == false) return false;
                        ** GOTO lbl23
                    }
                    case 107953788: {
                        if (IsEqv.apply(head, genwrite.Lit31) == false) return false;
                        ** GOTO lbl23
                    }
                    case 881169219: {
                        if (IsEqv.apply(head, genwrite.Lit32) == false) return false;
lbl23: // 4 sources:
                        l = tail;
                        if (!lists.isPair(l)) {
                            return false;
                        }
                        var4_4 = Promise.force(l, Pair.class);
                        v2 = lists.isNull(lists.cdr((Pair)var4_4));
                        return v2;
                    }
                }
                return false;
                catch (ClassCastException v3) {
                    throw new WrongType(v3, "cdr", 1, var4_4);
                }
            }

            public static Object lambda5readMacroBody(Object l) {
                return lists.cadr(l);
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public static Object lambda6readMacroPrefix(Object l) {
                void head;
                Object object2 = Promise.force(l, Pair.class);
                try {
                    Object object3 = lists.car((Pair)object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object2);
                }
                object2 = Promise.force(l, Pair.class);
                try {
                    lists.cdr((Pair)object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object2);
                }
                switch (head.hashCode()) {
                    case -279091325: {
                        if (!IsEqv.apply(head, genwrite.Lit29)) break;
                        return ",";
                    }
                    case 1896636553: {
                        if (!IsEqv.apply(head, genwrite.Lit30)) break;
                        return "`";
                    }
                    case 107953788: {
                        if (!IsEqv.apply(head, genwrite.Lit31)) break;
                        return "'";
                    }
                    case 881169219: {
                        if (!IsEqv.apply(head, genwrite.Lit32)) break;
                        return ",@";
                    }
                }
                Values values = Values.empty;
                return values;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public Object lambda21wr(Object obj, Object col) {
                block19 : {
                    block18 : {
                        if (!lists.isPair(obj)) break block18;
                        var4_3 = col;
                        expr = obj;
                        if (Frame.lambda3isReadMacro(expr)) {
                            v0 = this.lambda21wr(Frame.lambda5readMacroBody(expr), this.lambda1out(Frame.lambda6readMacroPrefix(expr), col));
                            return v0;
                        }
                        v1 = expr;
                        v2 = col;
                        ** GOTO lbl21
                    }
                    if (!lists.isNull(obj)) break block19;
                    v1 = obj;
                    v2 = col;
                    ** GOTO lbl21
                }
                if (vectors.isVector(obj)) {
                    expr = Promise.force(obj, FVector.class);
                    v1 = vectors.vector$To$List((FVector)expr);
                    v2 = var6_5 = this.lambda1out("#", col);
lbl21: // 3 sources:
                    if (!lists.isPair(l = v1)) {
                        v0 = this.lambda1out("()", col);
                        return v0;
                    }
                    var7_7 = Promise.force(l, Pair.class);
                    v3 = lists.cdr((Pair)var7_7);
                    if (KawaConvert.isTrue(col)) {
                        var7_7 = Promise.force(l, Pair.class);
                        v4 = this.lambda21wr(lists.car((Pair)var7_7), this.lambda1out("(", col));
                    }
                    v4 = Boolean.FALSE;
                } else {
                    v0 = this.lambda1out(Format.formatToString(0, new Object[]{KawaConvert.isTrue(this.display$Qu) != false ? "~a" : "~s", obj}), col);
                    return v0;
                    catch (ClassCastException v5) {
                        throw new WrongType(v5, "cdr", 1, l);
                    }
                    catch (ClassCastException v6) {
                        throw new WrongType(v6, "car", 1, l);
                    }
                }
                catch (ClassCastException v7) {
                    throw new WrongType(v7, "vector->list", 1, expr);
                }
                do {
                    var8_8 = v4;
                    l = v3;
                    if (!KawaConvert.isTrue(col)) {
                        v0 = col;
                        return v0;
                    }
                    if (!lists.isPair(l)) break;
                    var9_9 = Promise.force(l, Pair.class);
                    v3 = lists.cdr((Pair)var9_9);
                    var9_9 = Promise.force(l, Pair.class);
                    v4 = this.lambda21wr(lists.car((Pair)var9_9), this.lambda1out(" ", col));
                    continue;
                    break;
                } while (true);
                if (lists.isNull(l)) {
                    v0 = this.lambda1out(")", col);
                    return v0;
                }
                v0 = this.lambda1out(")", this.lambda21wr(l, this.lambda1out(" . ", col)));
                return v0;
                catch (ClassCastException v8) {
                    throw new WrongType(v8, "cdr", 1, var9_9);
                }
                catch (ClassCastException v9) {
                    throw new WrongType(v9, "car", 1, var9_9);
                }
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.display$Qu = isDisplay;
        $heapFrame.width = width;
        $heapFrame.output = output;
        if (KawaConvert.isTrue($heapFrame.width)) {
            Object obj2 = obj;
            new Frame0().staticLink = $heapFrame;
            public class Frame0
            extends ModuleBody {
                Procedure pp$MnDO = new ModuleMethod(this, 11, genwrite.Lit28, 12291);
                Procedure pp$MnBEGIN = new ModuleMethod(this, 10, genwrite.Lit27, 12291);
                Procedure pp$MnLET = new ModuleMethod(this, 9, genwrite.Lit26, 12291);
                Procedure pp$MnAND = new ModuleMethod(this, 8, genwrite.Lit25, 12291);
                Procedure pp$MnCASE = new ModuleMethod(this, 7, genwrite.Lit24, 12291);
                Procedure pp$MnCOND = new ModuleMethod(this, 6, genwrite.Lit23, 12291);
                Procedure pp$MnIF = new ModuleMethod(this, 5, genwrite.Lit22, 12291);
                Procedure pp$MnLAMBDA = new ModuleMethod(this, 4, genwrite.Lit21, 12291);
                Procedure pp$Mnexpr$Mnlist = new ModuleMethod(this, 3, genwrite.Lit20, 12291);
                Procedure pp$Mnexpr = new ModuleMethod(this, 2, genwrite.Lit19, 12291);
                Frame staticLink;

                /*
                 * Unable to fully structure code
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public Object lambda2ppExpr(Object expr, Object col, Object extra) {
                    block22 : {
                        block23 : {
                            if (Frame.lambda3isReadMacro(expr)) {
                                v0 = this.lambda4pr(Frame.lambda5readMacroBody(expr), this.staticLink.lambda1out(Frame.lambda6readMacroPrefix(expr), col), extra, this.pp$Mnexpr);
                                return v0;
                            }
                            var5_4 = Promise.force(expr, Pair.class);
                            try {
                                head = lists.car((Pair)var5_4);
                            }
                            catch (ClassCastException v1) {
                                throw new WrongType(v1, "car", 1, (Object)proc);
                            }
                            if (!misc.isSymbol(head)) {
                                v0 = this.lambda9ppList(expr, col, extra, this.pp$Mnexpr);
                                return v0;
                            }
                            head = head;
                            switch (head.hashCode()) {
                                case -1335633477: {
                                    if (!IsEqv.apply(head, genwrite.Lit0)) break;
                                    ** GOTO lbl44
                                }
                                case 107035: {
                                    if (!IsEqv.apply(head, genwrite.Lit1)) break;
                                    v2 = this.pp$MnLET;
                                    break block23;
                                }
                                case 3318127: {
                                    if (!IsEqv.apply(head, genwrite.Lit2)) break;
                                    ** GOTO lbl44
                                }
                                case 3555: {
                                    if (!IsEqv.apply(head, genwrite.Lit3)) break;
                                    ** GOTO lbl36
                                }
                                case 3059490: {
                                    if (!IsEqv.apply(head, genwrite.Lit4)) break;
                                    v2 = this.pp$MnCOND;
                                    break block23;
                                }
                                case -1106174827: {
                                    if (!IsEqv.apply(head, genwrite.Lit5)) break;
                                    ** GOTO lbl44
                                }
                                case 96727: {
                                    if (!IsEqv.apply(head, genwrite.Lit6)) break;
lbl36: // 2 sources:
                                    v2 = this.pp$MnAND;
                                    break block23;
                                }
                                case 93616297: {
                                    if (!IsEqv.apply(head, genwrite.Lit7)) break;
                                    v2 = this.pp$MnBEGIN;
                                    break block23;
                                }
                                case -1110092857: {
                                    if (!IsEqv.apply(head, genwrite.Lit8)) break;
lbl44: // 4 sources:
                                    v2 = this.pp$MnLAMBDA;
                                    break block23;
                                }
                                case 3526655: {
                                    if (!IsEqv.apply(head, genwrite.Lit9)) break;
                                    ** GOTO lbl51
                                }
                                case 3357: {
                                    if (!IsEqv.apply(head, genwrite.Lit10)) break;
lbl51: // 2 sources:
                                    v2 = this.pp$MnIF;
                                    break block23;
                                }
                                case 3211: {
                                    if (!IsEqv.apply(head, genwrite.Lit11)) break;
                                    v2 = this.pp$MnDO;
                                    break block23;
                                }
                                case 3046192: {
                                    if (!IsEqv.apply(head, genwrite.Lit12)) break;
                                    v2 = this.pp$MnCASE;
                                    break block23;
                                }
                            }
                            v2 = proc = Boolean.FALSE;
                        }
                        if (KawaConvert.isTrue(proc)) {
                            v0 = Scheme.applyToArgs.apply4(proc, expr, col, extra);
                            return v0;
                        }
                        head = Promise.force(head, Symbol.class);
                        try {
                            if (strings.stringLength(misc.symbol$To$String((Symbol)head)) <= 5) break block22;
                        }
                        catch (ClassCastException v3) {
                            throw new WrongType(v3, "symbol->string", 1, head);
                        }
                        v0 = this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, this.pp$Mnexpr);
                        return v0;
                    }
                    v0 = this.lambda8ppCall(expr, col, extra, this.pp$Mnexpr);
                    return v0;
                }

                /*
                 * Loose catch block
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public Object lambda4pr(Object obj, Object col, Object extra, Object pp$Mnpair) {
                    Object object2;
                    Object object3;
                    new Frame1().staticLink = this;
                    public class Frame1
                    extends ModuleBody {
                        Object left;
                        Object result;
                        Frame0 staticLink;
                        final ModuleMethod lambda$Fn1;

                        public Frame1() {
                            ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 4097);
                            moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/genwrite.scm:72");
                            this.lambda$Fn1 = moduleMethod;
                        }

                        boolean lambda20(Object str) {
                            this.result = lists.cons(str, this.result);
                            Object object2 = Promise.force(str, CharSequence.class);
                            try {
                                this.left = AddOp.apply2(-1, this.left, strings.stringLength((CharSequence)object2));
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "string-length", 1, object2);
                            }
                            return NumberCompare.$Gr(this.left, genwrite.Lit13);
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
                                return this.lambda20(object2) ? Boolean.TRUE : Boolean.FALSE;
                            }
                            return super.apply1(moduleMethod, object2);
                        }
                    }
                    Frame1 $heapFrame = new Frame1();
                    boolean x = lists.isPair(obj);
                    if (x ? x : vectors.isVector(obj)) {
                        $heapFrame.result = LList.Empty;
                        $heapFrame.left = numbers.min(AddOp.apply2(1, AddOp.apply2(-1, AddOp.apply2(-1, this.staticLink.width, col), extra), genwrite.Lit16), genwrite.Lit17);
                        genwrite.genericWrite(obj, this.staticLink.display$Qu, Boolean.FALSE, $heapFrame.lambda$Fn1);
                        if (NumberCompare.$Gr($heapFrame.left, genwrite.Lit13)) {
                            object3 = this.staticLink.lambda1out(genwrite.reverseStringAppend($heapFrame.result), col);
                            return object3;
                        }
                        if (lists.isPair(obj)) {
                            object3 = ((Procedure)Scheme.applyToArgs).apply4(pp$Mnpair, obj, col, extra);
                            return object3;
                        }
                        object2 = Promise.force(obj, FVector.class);
                        object3 = this.lambda9ppList(vectors.vector$To$List((FVector)object2), this.staticLink.lambda1out("#", col), extra, this.pp$Mnexpr);
                        return object3;
                    }
                    object3 = this.staticLink.lambda21wr(obj, col);
                    return object3;
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "vector->list", 1, object2);
                    }
                }

                /*
                 * Loose catch block
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public Object lambda7ppGeneral(Object expr, Object col, Object extra, Object named$Qu, Object pp$Mn1, Object pp$Mn2, Procedure pp$Mn3) {
                    void v11;
                    IntNum extra3;
                    Object col$St$St;
                    Object rest;
                    Object rest3;
                    void col12;
                    Object col$St;
                    Object head;
                    Object rest4;
                    IntNum extra2;
                    void col1;
                    void col2;
                    Object object2;
                    void col13;
                    Object object3;
                    void col3;
                    void v9;
                    void v7;
                    void col23;
                    void col22;
                    Object object4;
                    Object object5;
                    Object object6;
                    Object object7;
                    Object rest2;
                    Object object8;
                    Object object9;
                    Object object10 = Promise.force(expr, Pair.class);
                    try {
                        head = lists.car((Pair)object10);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, rest);
                    }
                    Object object11 = Promise.force(expr, Pair.class);
                    try {
                        rest = lists.cdr((Pair)object11);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, col$St);
                    }
                    col$St = this.staticLink.lambda21wr(head, this.staticLink.lambda1out("(", col));
                    if (KawaConvert.isTrue(named$Qu) && lists.isPair(rest)) {
                        Object object12 = Promise.force(rest, Pair.class);
                        Object name = lists.car((Pair)object12);
                        Object object13 = Promise.force(rest, Pair.class);
                        rest3 = lists.cdr((Pair)object13);
                        col$St$St = this.staticLink.lambda21wr(name, this.staticLink.lambda1out(" ", col$St));
                        object6 = rest3;
                        object2 = AddOp.apply2(1, col, genwrite.Lit18);
                        object7 = col$St$St;
                        object3 = AddOp.apply2(1, col$St$St, genwrite.Lit16);
                    } else {
                        object6 = rest;
                        object2 = AddOp.apply2(1, col, genwrite.Lit18);
                        object7 = col$St;
                        object3 = AddOp.apply2(1, col$St, genwrite.Lit16);
                    }
                    Object object14 = object3;
                    Object object15 = object7;
                    Object object16 = object2;
                    Object rest5 = object6;
                    if (KawaConvert.isTrue(pp$Mn1) && lists.isPair(rest5)) {
                        Object object17 = Promise.force(rest5, Pair.class);
                        Object val1 = lists.car((Pair)object17);
                        Object object18 = Promise.force(rest5, Pair.class);
                        rest2 = lists.cdr((Pair)object18);
                        extra3 = lists.isNull(rest2) ? AddOp.apply2(1, extra, genwrite.Lit16) : genwrite.Lit13;
                        object8 = rest2;
                        v7 = col1;
                        object9 = this.lambda4pr(val1, this.lambda19indent(col3, col23), extra3, pp$Mn1);
                        v9 = col3;
                    } else {
                        object8 = rest5;
                        v7 = col1;
                        object9 = col23;
                        v9 = col3;
                    }
                    void var21_21 = v9;
                    extra3 = object9;
                    rest2 = v7;
                    Object rest6 = object8;
                    if (KawaConvert.isTrue(pp$Mn2) && lists.isPair(rest6)) {
                        void col32;
                        Object object19 = Promise.force(rest6, Pair.class);
                        Object val1 = lists.car((Pair)object19);
                        Object object20 = Promise.force(rest6, Pair.class);
                        rest4 = lists.cdr((Pair)object20);
                        extra2 = lists.isNull(rest4) ? AddOp.apply2(1, extra, genwrite.Lit16) : genwrite.Lit13;
                        object4 = rest4;
                        v11 = col13;
                        object5 = this.lambda4pr(val1, this.lambda19indent(col32, col22), extra2, pp$Mn2);
                    } else {
                        object4 = rest6;
                        v11 = col13;
                        object5 = col22;
                    }
                    extra2 = object5;
                    rest4 = v11;
                    Object rest7 = object4;
                    return this.lambda22ppDown(rest7, col2, col12, extra, pp$Mn3);
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, rest3);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, col$St$St);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, (Object)col13);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, (Object)col22);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, (Object)col12);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, (Object)col2);
                    }
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public Object lambda8ppCall(Object expr, Object col, Object extra, Procedure pp$Mnitem) {
                    Object col$St;
                    Object object2;
                    Object object3 = Promise.force(expr, Pair.class);
                    try {
                        col$St = this.staticLink.lambda21wr(lists.car((Pair)object3), this.staticLink.lambda1out("(", col));
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object3);
                    }
                    if (!KawaConvert.isTrue(col)) {
                        object2 = Boolean.FALSE;
                        return object2;
                    }
                    object3 = Promise.force(expr, Pair.class);
                    try {
                        object2 = this.lambda22ppDown(lists.cdr((Pair)object3), col$St, AddOp.apply2(1, col$St, genwrite.Lit16), extra, pp$Mnitem);
                        return object2;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, object3);
                    }
                }

                public Object lambda9ppList(Object l, Object col, Object extra, Procedure pp$Mnitem) {
                    Object col2 = this.staticLink.lambda1out("(", col);
                    return this.lambda22ppDown(l, col2, col2, extra, pp$Mnitem);
                }

                public Object lambda10ppExprList(Object l, Object col, Object extra) {
                    return this.lambda9ppList(l, col, extra, this.pp$Mnexpr);
                }

                public Object lambda11ppLAMBDA(Object expr, Object col, Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, this.pp$Mnexpr$Mnlist, Boolean.FALSE, this.pp$Mnexpr);
                }

                public Object lambda12ppIF(Object expr, Object col, Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, this.pp$Mnexpr, Boolean.FALSE, this.pp$Mnexpr);
                }

                public Object lambda13ppCOND(Object expr, Object col, Object extra) {
                    return this.lambda8ppCall(expr, col, extra, this.pp$Mnexpr$Mnlist);
                }

                public Object lambda14ppCASE(Object expr, Object col, Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, this.pp$Mnexpr, Boolean.FALSE, this.pp$Mnexpr$Mnlist);
                }

                public Object lambda15ppAND(Object expr, Object col, Object extra) {
                    return this.lambda8ppCall(expr, col, extra, this.pp$Mnexpr);
                }

                /*
                 * Loose catch block
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public Object lambda16ppLET(Object expr, Object col, Object extra) {
                    boolean named$Qu2222;
                    Object object2;
                    boolean bl;
                    Object rest;
                    Boolean bl2;
                    Object object3 = Promise.force(expr, Pair.class);
                    try {
                        rest = lists.cdr((Pair)object3);
                    }
                    catch (ClassCastException classCastException) {
                        void named$Qu2222;
                        throw new WrongType(classCastException, "cdr", 1, (Object)named$Qu2222);
                    }
                    if (lists.isPair(rest)) {
                        object2 = Promise.force(rest, Pair.class);
                        bl = misc.isSymbol(lists.car((Pair)object2));
                    } else {
                        bl = named$Qu2222 = false;
                    }
                    if (named$Qu2222) {
                        bl2 = Boolean.TRUE;
                        return this.lambda7ppGeneral(expr, col, extra, bl2, this.pp$Mnexpr$Mnlist, Boolean.FALSE, this.pp$Mnexpr);
                    }
                    bl2 = Boolean.FALSE;
                    return this.lambda7ppGeneral(expr, col, extra, bl2, this.pp$Mnexpr$Mnlist, Boolean.FALSE, this.pp$Mnexpr);
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object2);
                    }
                }

                public Object lambda17ppBEGIN(Object expr, Object col, Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, this.pp$Mnexpr);
                }

                public Object lambda18ppDO(Object expr, Object col, Object extra) {
                    return this.lambda7ppGeneral(expr, col, extra, Boolean.FALSE, this.pp$Mnexpr$Mnlist, this.pp$Mnexpr$Mnlist, this.pp$Mnexpr);
                }

                public Object lambda19indent(Object to, Object col) {
                    Object object2;
                    block4 : {
                        void col2;
                        block3 : {
                            Object n;
                            Object object3;
                            Object object4;
                            block8 : {
                                block5 : {
                                    block6 : {
                                        block7 : {
                                            if (!KawaConvert.isTrue(col)) break block5;
                                            if (!NumberCompare.$Ls(to, col)) break block6;
                                            if (!KawaConvert.isTrue(this.staticLink.lambda1out(strings.makeString(1, 10), col))) break block7;
                                            object3 = to;
                                            object4 = genwrite.Lit13;
                                            break block8;
                                        }
                                        object2 = Boolean.FALSE;
                                        break block4;
                                    }
                                    object3 = AddOp.apply2(-1, to, col);
                                    object4 = col;
                                    break block8;
                                }
                                object2 = Boolean.FALSE;
                                break block4;
                            }
                            do {
                                Object object5 = object4;
                                n = object3;
                                if (!NumberCompare.$Gr(n, genwrite.Lit13)) break block3;
                                if (!NumberCompare.$Gr(n, genwrite.Lit14)) break;
                                object3 = AddOp.apply2(-1, n, genwrite.Lit15);
                                object4 = this.staticLink.lambda1out("        ", col2);
                            } while (true);
                            Object object6 = Promise.force(n);
                            try {
                                object2 = this.staticLink.lambda1out(strings.substring("        ", 0, ((Number)object6).intValue()), col2);
                                break block4;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "substring", 3, object6);
                            }
                        }
                        object2 = col2;
                    }
                    return object2;
                }

                /*
                 * Loose catch block
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public Object lambda22ppDown(Object l, Object col1, Object col2, Object extra, Object pp$Mnitem) {
                    Object l2;
                    IntNum extra2;
                    Object object2;
                    void col;
                    Object object3;
                    Object object4 = l;
                    Object object5 = col1;
                    do {
                        Object object6 = object5;
                        l2 = object4;
                        if (!KawaConvert.isTrue(col)) {
                            object3 = Boolean.FALSE;
                            return object3;
                        }
                        if (!lists.isPair(l2)) break;
                        Object object7 = Promise.force(l2, Pair.class);
                        Object rest = lists.cdr((Pair)object7);
                        extra2 = lists.isNull(rest) ? AddOp.apply2(1, extra, genwrite.Lit16) : genwrite.Lit13;
                        object4 = rest;
                        object2 = Promise.force(l2, Pair.class);
                        object5 = this.lambda4pr(lists.car((Pair)object2), this.lambda19indent(col2, col), extra2, pp$Mnitem);
                        continue;
                        break;
                    } while (true);
                    if (lists.isNull(l2)) {
                        object3 = this.staticLink.lambda1out(")", col);
                        return object3;
                    }
                    object3 = this.staticLink.lambda1out(")", this.lambda4pr(l2, this.lambda19indent(col2, this.staticLink.lambda1out(".", this.lambda19indent(col2, col))), AddOp.apply2(1, extra, genwrite.Lit16), pp$Mnitem));
                    return object3;
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, (Object)extra2);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object2);
                    }
                }

                public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
                    switch (moduleMethod.selector) {
                        case 11: {
                            callContext.value1 = object2;
                            callContext.value2 = object3;
                            callContext.value3 = object4;
                            callContext.proc = moduleMethod;
                            callContext.pc = 3;
                            return 0;
                        }
                        case 10: {
                            callContext.value1 = object2;
                            callContext.value2 = object3;
                            callContext.value3 = object4;
                            callContext.proc = moduleMethod;
                            callContext.pc = 3;
                            return 0;
                        }
                        case 9: {
                            callContext.value1 = object2;
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
                        case 7: {
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
                        case 5: {
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
                        case 3: {
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

                public void apply(CallContext callContext) {
                    ModuleMethod.applyError();
                }

                public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
                    switch (moduleMethod.selector) {
                        case 2: {
                            return this.lambda2ppExpr(object2, object3, object4);
                        }
                        case 3: {
                            return this.lambda10ppExprList(object2, object3, object4);
                        }
                        case 4: {
                            return this.lambda11ppLAMBDA(object2, object3, object4);
                        }
                        case 5: {
                            return this.lambda12ppIF(object2, object3, object4);
                        }
                        case 6: {
                            return this.lambda13ppCOND(object2, object3, object4);
                        }
                        case 7: {
                            return this.lambda14ppCASE(object2, object3, object4);
                        }
                        case 8: {
                            return this.lambda15ppAND(object2, object3, object4);
                        }
                        case 9: {
                            return this.lambda16ppLET(object2, object3, object4);
                        }
                        case 10: {
                            return this.lambda17ppBEGIN(object2, object3, object4);
                        }
                        case 11: {
                            return this.lambda18ppDO(object2, object3, object4);
                        }
                    }
                    return super.apply3(moduleMethod, object2, object3, object4);
                }
            }
            Frame0 $heapFrame2 = new Frame0();
            $heapFrame2.pp$Mnexpr = $heapFrame2.pp$Mnexpr;
            $heapFrame2.pp$Mnexpr$Mnlist = $heapFrame2.pp$Mnexpr$Mnlist;
            $heapFrame2.pp$MnLAMBDA = $heapFrame2.pp$MnLAMBDA;
            $heapFrame2.pp$MnIF = $heapFrame2.pp$MnIF;
            $heapFrame2.pp$MnCOND = $heapFrame2.pp$MnCOND;
            $heapFrame2.pp$MnCASE = $heapFrame2.pp$MnCASE;
            $heapFrame2.pp$MnAND = $heapFrame2.pp$MnAND;
            $heapFrame2.pp$MnLET = $heapFrame2.pp$MnLET;
            $heapFrame2.pp$MnBEGIN = $heapFrame2.pp$MnBEGIN;
            $heapFrame2.pp$MnDO = $heapFrame2.pp$MnDO;
            object2 = $heapFrame.lambda1out(strings.makeString(1, 10), $heapFrame2.lambda4pr(obj2, Lit13, Lit13, $heapFrame2.pp$Mnexpr));
        } else {
            object2 = $heapFrame.lambda21wr(obj, Lit13);
        }
        return object2;
    }

    public static Object reverseStringAppend(Object l) {
        return genwrite.lambda23revStringAppend(l, Lit13);
    }

    /*
     * Exception decompiling
     */
    public static Object lambda23revStringAppend(Object l, Object i) {
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

    public static {
        Lit34 = Symbol.valueOf("reverse-string-append");
        Lit33 = Symbol.valueOf("generic-write");
        Lit32 = Symbol.valueOf("unquote-splicing");
        Lit31 = Symbol.valueOf("quote");
        Lit30 = Symbol.valueOf("quasiquote");
        Lit29 = Symbol.valueOf("unquote");
        Lit28 = Symbol.valueOf("pp-DO");
        Lit27 = Symbol.valueOf("pp-BEGIN");
        Lit26 = Symbol.valueOf("pp-LET");
        Lit25 = Symbol.valueOf("pp-AND");
        Lit24 = Symbol.valueOf("pp-CASE");
        Lit23 = Symbol.valueOf("pp-COND");
        Lit22 = Symbol.valueOf("pp-IF");
        Lit21 = Symbol.valueOf("pp-LAMBDA");
        Lit20 = Symbol.valueOf("pp-expr-list");
        Lit19 = Symbol.valueOf("pp-expr");
        Lit18 = IntNum.valueOf(2);
        Lit17 = IntNum.valueOf(50);
        Lit16 = IntNum.valueOf(1);
        Lit15 = IntNum.valueOf(8);
        Lit14 = IntNum.valueOf(7);
        Lit13 = IntNum.valueOf(0);
        Lit12 = Symbol.valueOf("case");
        Lit11 = Symbol.valueOf("do");
        Lit10 = Symbol.valueOf("if");
        Lit9 = Symbol.valueOf("set!");
        Lit8 = Symbol.valueOf("lambda");
        Lit7 = Symbol.valueOf("begin");
        Lit6 = Symbol.valueOf("and");
        Lit5 = Symbol.valueOf("letrec");
        Lit4 = Symbol.valueOf("cond");
        Lit3 = Symbol.valueOf("or");
        Lit2 = Symbol.valueOf("let*");
        Lit1 = Symbol.valueOf("let");
        Lit0 = Symbol.valueOf("define");
        genwrite genwrite2 = $instance = new genwrite();
        generic$Mnwrite = new ModuleMethod(genwrite2, 12, Lit33, 16388);
        reverse$Mnstring$Mnappend = new ModuleMethod(genwrite2, 13, Lit34, 4097);
        genwrite.$runBody$();
    }

    public genwrite() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 13) {
            callContext.value1 = object2;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
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

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector == 13) {
            return genwrite.reverseStringAppend(object2);
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5) {
        if (moduleMethod.selector == 12) {
            return genwrite.genericWrite(object2, object3, object4, object5);
        }
        return super.apply4(moduleMethod, object2, object3, object4, object5);
    }

}

