/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.kawa;

import gnu.bytecode.Type;
import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.Complex;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Quantity;
import gnu.math.Quaternion;
import gnu.math.RealNum;
import gnu.math.Unit;
import kawa.lib.exceptions;
import kawa.lib.numbers;

public class quaternions
extends ModuleBody {
    public static final StaticFieldLocation quaternion;
    public static final StaticFieldLocation quaternion$Qu;
    public static final StaticFieldLocation real$Mnpart;
    public static final StaticFieldLocation imag$Mnpart;
    public static final StaticFieldLocation jmag$Mnpart;
    public static final StaticFieldLocation kmag$Mnpart;
    public static final ModuleMethod complex$Mnpart;
    public static final ModuleMethod vector$Mnpart;
    public static final ModuleMethod unit$Mnquaternion;
    public static final StaticFieldLocation unit$Mnvector;
    public static final ModuleMethod vector$Mnquaternion$Qu;
    public static final ModuleMethod make$Mnvector$Mnquaternion;
    public static final ModuleMethod vector$Mnquaternion$Mn$Grlist;
    public static final StaticFieldLocation magnitude;
    public static final StaticFieldLocation angle;
    public static final ModuleMethod colatitude;
    public static final ModuleMethod longitude;
    public static final StaticFieldLocation make$Mnrectangular;
    public static final StaticFieldLocation make$Mnpolar;
    public static final StaticFieldLocation $Pl;
    public static final StaticFieldLocation $Mn;
    public static final StaticFieldLocation $St;
    public static final StaticFieldLocation $Sl;
    public static final ModuleMethod dot$Mnproduct;
    public static final ModuleMethod cross$Mnproduct;
    public static final ModuleMethod conjugate;
    public static final StaticFieldLocation exp;
    public static final StaticFieldLocation log;
    public static final StaticFieldLocation expt;
    public static final StaticFieldLocation sqrt;
    public static final StaticFieldLocation sin;
    public static final StaticFieldLocation cos;
    public static final StaticFieldLocation tan;
    public static final StaticFieldLocation asin;
    public static final StaticFieldLocation acos;
    public static final StaticFieldLocation atan;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final IntNum Lit2;
    static final DFloNum Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    public static quaternions $instance;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Complex complexPart(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).complexPart() : (Complex)x;
    }

    public static Quaternion vectorPart(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).vectorPart() : Lit0;
    }

    public static Number colatitude(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).colatitude() : Lit0;
    }

    public static Number longitude(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).longitude() : Lit0;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Number unitQuaternion(Number x) {
        Quantity quantity;
        Number number2;
        if (x instanceof Quaternion) {
            quantity = ((Quaternion)x).unitQuaternion();
            return quantity;
        }
        if (x instanceof Quantity) {
            number2 = quaternions.unitQuaternion(((Quantity)x).number());
            quantity = Quantity.make((Quaternion)number2, ((Quantity)x).unit());
            return quantity;
        }
        if (numbers.isZero(x)) {
            quantity = Lit0;
            return quantity;
        }
        Number number = x;
        try {
            if (numbers.isNegative(LangObjType.coerceRealNum(number))) {
                quantity = Lit1;
                return quantity;
            }
            number = x;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "negative?", 1, (Object)number);
        }
        try {
            if (numbers.isPositive(LangObjType.coerceRealNum(number))) {
                quantity = Lit2;
                return quantity;
            }
            quantity = Lit3;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "positive?", 1, (Object)number);
        }
        return quantity;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.math.Quantity.make(gnu.math.Quaternion,gnu.math.Unit)", 1, (Object)number2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isVectorQuaternion(Object o) {
        boolean bl;
        if (!numbers.isQuaternion(o)) return false;
        Object object2 = Promise.force(o, Number.class);
        try {
            bl = numbers.isZero(numbers.realPart((Number)object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "real-part", 1, object2);
        }
        return bl;
    }

    public static Quaternion makeVectorQuaternion(RealNum x, RealNum y, RealNum z) {
        return (Quaternion)Promise.force(((Procedure)numbers.make$Mnrectangular).apply4(Lit0, x, y, z), Quaternion.class);
    }

    public static LList vectorQuaternion$To$List(Quaternion vec) {
        return LList.list3(numbers.imagPart(vec), numbers.jmagPart(vec), numbers.kmagPart(vec));
    }

    public static RealNum dotProduct(Number x, Number y) {
        if (!quaternions.isVectorQuaternion(x) || !quaternions.isVectorQuaternion(y)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit4, "arguments must be vector quaternions");
            throw Special.reachedUnexpected;
        }
        return LangObjType.coerceRealNum(Promise.force(AddOp.apply2(1, AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(numbers.imagPart(x), numbers.imagPart(y)), ((Procedure)MultiplyOp.$St).apply2(numbers.jmagPart(x), numbers.jmagPart(y))), ((Procedure)MultiplyOp.$St).apply2(numbers.kmagPart(x), numbers.kmagPart(y))), RealNum.class));
    }

    public static Quaternion crossProduct(Number x, Number y) {
        if (!quaternions.isVectorQuaternion(x) || !quaternions.isVectorQuaternion(y)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit5, "arguments must be vector quaternions");
            throw Special.reachedUnexpected;
        }
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(x, y), Number.class);
        try {
            return quaternions.vectorPart((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "vector-part", 0, object2);
        }
    }

    public static Number conjugate(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).conjugate() : x;
    }

    public static {
        Lit14 = Symbol.valueOf("conjugate");
        Lit13 = Symbol.valueOf("vector-quaternion->list");
        Lit12 = Symbol.valueOf("make-vector-quaternion");
        Lit11 = Symbol.valueOf("vector-quaternion?");
        Lit10 = Symbol.valueOf("unit-quaternion");
        Lit9 = Symbol.valueOf("longitude");
        Lit8 = Symbol.valueOf("colatitude");
        Lit7 = Symbol.valueOf("vector-part");
        Lit6 = Symbol.valueOf("complex-part");
        Lit5 = Symbol.valueOf("cross-product");
        Lit4 = Symbol.valueOf("dot-product");
        Lit3 = DFloNum.valueOf(Double.NaN);
        Lit2 = IntNum.valueOf(1);
        Lit1 = IntNum.valueOf(-1);
        Lit0 = IntNum.valueOf(0);
        $instance = new quaternions();
        $Pl = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Pl");
        $Mn = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Mn");
        $Sl = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "$Sl");
        $St = StaticFieldLocation.make("gnu.kawa.functions.MultiplyOp", "$St");
        expt = StaticFieldLocation.make("kawa.standard.expt", "expt");
        quaternion = StaticFieldLocation.make("kawa.lib.numbers", "quaternion");
        quaternion$Qu = StaticFieldLocation.make("kawa.lib.numbers", "quaternion$Qu");
        real$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "real$Mnpart");
        imag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "imag$Mnpart");
        jmag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "jmag$Mnpart");
        kmag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "kmag$Mnpart");
        unit$Mnvector = StaticFieldLocation.make("kawa.lib.numbers", "unit$Mnvector");
        magnitude = StaticFieldLocation.make("kawa.lib.numbers", "magnitude");
        angle = StaticFieldLocation.make("kawa.lib.numbers", "angle");
        make$Mnrectangular = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnrectangular");
        make$Mnpolar = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnpolar");
        exp = StaticFieldLocation.make("kawa.lib.numbers", "exp");
        log = StaticFieldLocation.make("kawa.lib.numbers", "log");
        sqrt = StaticFieldLocation.make("kawa.lib.numbers", "sqrt");
        sin = StaticFieldLocation.make("kawa.lib.numbers", "sin");
        cos = StaticFieldLocation.make("kawa.lib.numbers", "cos");
        tan = StaticFieldLocation.make("kawa.lib.numbers", "tan");
        asin = StaticFieldLocation.make("kawa.lib.numbers", "asin");
        acos = StaticFieldLocation.make("kawa.lib.numbers", "acos");
        atan = StaticFieldLocation.make("kawa.lib.numbers", "atan");
        quaternions quaternions2 = $instance;
        complex$Mnpart = new ModuleMethod(quaternions2, 1, Lit6, 4097);
        vector$Mnpart = new ModuleMethod(quaternions2, 2, Lit7, 4097);
        colatitude = new ModuleMethod(quaternions2, 3, Lit8, 4097);
        longitude = new ModuleMethod(quaternions2, 4, Lit9, 4097);
        unit$Mnquaternion = new ModuleMethod(quaternions2, 5, Lit10, 4097);
        vector$Mnquaternion$Qu = new ModuleMethod(quaternions2, 6, Lit11, 4097);
        make$Mnvector$Mnquaternion = new ModuleMethod(quaternions2, 7, Lit12, 12291);
        vector$Mnquaternion$Mn$Grlist = new ModuleMethod(quaternions2, 8, Lit13, 4097);
        dot$Mnproduct = new ModuleMethod(quaternions2, 9, Lit4, 8194);
        cross$Mnproduct = new ModuleMethod(quaternions2, 10, Lit5, 8194);
        conjugate = new ModuleMethod(quaternions2, 11, Lit14, 4097);
        quaternions.$runBody$();
    }

    public quaternions() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 11: {
                Object object3 = Promise.force(object2, Number.class);
                if (!(object3 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 8: {
                Object object4 = Promise.force(object2, Quaternion.class);
                if (!(object4 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object4;
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
                Object object5 = Promise.force(object2, Number.class);
                if (!(object5 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object6 = Promise.force(object2, Number.class);
                if (!(object6 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                Object object7 = Promise.force(object2, Number.class);
                if (!(object7 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                Object object8 = Promise.force(object2, Number.class);
                if (!(object8 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                Object object9 = Promise.force(object2, Number.class);
                if (!(object9 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 10: {
                Object object4 = Promise.force(object2, Number.class);
                if (!(object4 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, Number.class);
                if (!(object5 instanceof Number)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 9: {
                Object object6 = Promise.force(object2, Number.class);
                if (!(object6 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, Number.class);
                if (!(object7 instanceof Number)) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        if (moduleMethod.selector == 7) {
            Object object5 = Promise.force(object2, RealNum.class);
            if (RealNum.asRealNumOrNull(object5) == null) {
                return -786431;
            }
            callContext.value1 = object5;
            Object object6 = Promise.force(object3, RealNum.class);
            if (RealNum.asRealNumOrNull(object6) == null) {
                return -786430;
            }
            callContext.value2 = object6;
            Object object7 = Promise.force(object4, RealNum.class);
            if (RealNum.asRealNumOrNull(object7) == null) {
                return -786429;
            }
            callContext.value3 = object7;
            callContext.proc = moduleMethod;
            callContext.pc = 3;
            return 0;
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
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
            case 1: {
                return quaternions.complexPart((Number)Promise.force(object2, Number.class));
            }
            case 2: {
                return quaternions.vectorPart((Number)Promise.force(object2, Number.class));
            }
            case 3: {
                return quaternions.colatitude((Number)Promise.force(object2, Number.class));
            }
            case 4: {
                return quaternions.longitude((Number)Promise.force(object2, Number.class));
            }
            case 5: {
                return quaternions.unitQuaternion((Number)Promise.force(object2, Number.class));
            }
            case 6: {
                Boolean bl;
                if (quaternions.isVectorQuaternion(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 8: {
                return quaternions.vectorQuaternion$To$List((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 11: {
                return quaternions.conjugate((Number)Promise.force(object2, Number.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "complex-part", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "vector-part", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "colatitude", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "longitude", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "vector-quaternion->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "conjugate", 1, object2);
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
}

