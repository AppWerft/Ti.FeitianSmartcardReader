/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.math.CComplex;
import gnu.math.Complex;
import gnu.math.DFloNum;
import gnu.math.Duration;
import gnu.math.IntFraction;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.Quantity;
import gnu.math.Quaternion;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.math.BigDecimal;
import java.math.BigInteger;
import kawa.lib.misc;

public class numbers
extends ModuleBody {
    public static final Class Double;
    public static final Class IntNum;
    public static final Class BitOps;
    public static final Class Numeric;
    public static final Class RatNum;
    public static final Class RealNum;
    public static final Class quaternion;
    public static final Class LangObjType;
    public static final ModuleMethod number$Qu;
    public static final ModuleMethod quantity$Qu;
    public static final ModuleMethod quaternion$Qu;
    public static final ModuleMethod complex$Qu;
    public static final ModuleMethod real$Qu;
    public static final ModuleMethod rational$Qu;
    public static final ModuleMethod integer$Qu;
    public static final ModuleMethod exact$Mninteger$Qu;
    public static final ModuleMethod real$Mnvalued$Qu;
    public static final ModuleMethod rational$Mnvalued$Qu;
    public static final ModuleMethod integer$Mnvalued$Qu;
    public static final ModuleMethod exact$Qu;
    public static final ModuleMethod inexact$Qu;
    public static final ModuleMethod zero$Qu;
    public static final ModuleMethod positive$Qu;
    public static final ModuleMethod negative$Qu;
    public static final ModuleMethod finite$Qu;
    public static final ModuleMethod infinite$Qu;
    public static final ModuleMethod nan$Qu;
    public static final ModuleMethod max;
    public static final ModuleMethod min;
    public static final ModuleMethod abs;
    public static final ModuleMethod floor$Sl;
    public static final ModuleMethod truncate$Sl;
    public static final ModuleMethod div$Mnand$Mnmod;
    public static final ModuleMethod div0$Mnand$Mnmod0;
    public static final ModuleMethod gcd;
    public static final ModuleMethod lcm;
    public static final ModuleMethod numerator;
    public static final ModuleMethod denominator;
    public static final ModuleMethod floor;
    public static final ModuleMethod ceiling;
    public static final ModuleMethod truncate;
    public static final ModuleMethod round;
    public static final ModuleMethod rationalize;
    public static final ModuleMethod exp;
    public static final GenericProc log;
    public static final GenericProc sin;
    public static final GenericProc cos;
    public static final GenericProc tan;
    public static final ModuleMethod asin;
    public static final ModuleMethod acos;
    public static final GenericProc atan;
    public static final GenericProc sinh;
    public static final GenericProc cosh;
    public static final GenericProc tanh;
    public static final GenericProc asinh;
    public static final GenericProc acosh;
    public static final GenericProc atanh;
    public static final ModuleMethod sqrt;
    public static final ModuleMethod square;
    public static final GenericProc make$Mnrectangular;
    public static final GenericProc make$Mnpolar;
    public static final ModuleMethod real$Mnpart;
    public static final ModuleMethod imag$Mnpart;
    public static final ModuleMethod jmag$Mnpart;
    public static final ModuleMethod kmag$Mnpart;
    public static final ModuleMethod unit$Mnvector;
    public static final ModuleMethod magnitude;
    public static final ModuleMethod angle;
    public static final ModuleMethod inexact;
    public static final ModuleMethod exact;
    public static final ModuleMethod exact$Mn$Grinexact;
    public static final ModuleMethod inexact$Mn$Grexact;
    public static final ModuleMethod logop;
    public static final ModuleMethod bitwise$Mnbit$Mnset$Qu;
    public static final ModuleMethod bitwise$Mncopy$Mnbit;
    public static final ModuleMethod bitwise$Mncopy$Mnbit$Mnfield;
    public static final ModuleMethod bitwise$Mnbit$Mnfield;
    public static final ModuleMethod bitwise$Mnif;
    public static final ModuleMethod logtest;
    public static final ModuleMethod logcount;
    public static final ModuleMethod bitwise$Mnbit$Mncount;
    public static final ModuleMethod bitwise$Mnlength;
    public static final ModuleMethod bitwise$Mnfirst$Mnbit$Mnset;
    public static final ModuleMethod bitwise$Mnrotate$Mnbit$Mnfield;
    public static final ModuleMethod bitwise$Mnreverse$Mnbit$Mnfield;
    public static final ModuleMethod number$Mn$Grstring;
    public static final ModuleMethod string$Mn$Grnumber;
    public static final ModuleMethod quantity$Mn$Grnumber;
    public static final ModuleMethod quantity$Mn$Grunit;
    public static final ModuleMethod make$Mnquantity;
    public static final ModuleMethod duration;
    public static final ModuleMethod exact$Mninteger$Mnsqrt;
    static final IntNum Lit0;
    static final SimpleSymbol Lit1;
    static final IntNum Lit2;
    static final IntNum Lit3;
    static final CComplex Lit4;
    static final DFloNum Lit5;
    public static numbers $instance;
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
    static final SimpleSymbol Lit33;
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
    static final IntFraction Lit44;
    static final IntNum Lit45;
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

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static boolean isNumber(Object x) {
        return x instanceof Number;
    }

    public static boolean isQuantity(Object x) {
        boolean x2 = x instanceof Quantity;
        return x2 ? x2 : numbers.isJava$DtLang$DtReal(x);
    }

    static boolean isJava$DtLang$DtReal(Object x) {
        boolean x2;
        boolean x3;
        boolean x4;
        boolean x5;
        boolean x6;
        boolean x7;
        boolean x8;
        return x instanceof Number ? ((x6 = x instanceof Long) ? x6 : ((x5 = x instanceof Integer) ? x5 : ((x4 = x instanceof Short) ? x4 : ((x3 = x instanceof Byte) ? x3 : ((x2 = x instanceof Double) ? x2 : ((x7 = x instanceof Float) ? x7 : ((x8 = x instanceof BigInteger) ? x8 : x instanceof BigDecimal))))))) : false;
    }

    public static boolean isQuaternion(Object x) {
        boolean x2 = x instanceof Quaternion;
        return x2 ? x2 : numbers.isJava$DtLang$DtReal(x);
    }

    public static boolean isComplex(Object x) {
        boolean x2 = x instanceof Complex;
        return x2 ? x2 : numbers.isJava$DtLang$DtReal(x);
    }

    public static boolean isReal(Object x) {
        boolean x2 = RealNum.asRealNumOrNull(x) != null;
        return x2 ? x2 : numbers.isJava$DtLang$DtReal(x);
    }

    public static boolean isRational(Object x) {
        boolean x2;
        boolean x3;
        boolean x4;
        boolean x5;
        boolean x6;
        boolean x7;
        boolean bl = x6 = RatNum.asRatNumOrNull(x) != null;
        boolean bl2 = x6 ? x6 : (x instanceof Number ? ((x5 = x instanceof Long) ? x5 : ((x4 = x instanceof Integer) ? x4 : ((x3 = x instanceof Short) ? x3 : ((x2 = x instanceof Byte) ? x2 : ((x7 = x instanceof BigInteger) ? x7 : x instanceof BigDecimal))))) : false);
        return bl2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean isInteger(Object x) {
        Object x22222222;
        boolean x5;
        boolean x22222222;
        boolean x4;
        boolean x6;
        boolean x3 = x instanceof IntNum;
        if (x3) {
            boolean bl = x3;
            return bl;
        }
        if (!(x instanceof Number)) {
            return false;
        }
        boolean x7 = x instanceof Long;
        if (x7 ? x7 : ((x6 = x instanceof Integer) ? x6 : ((x5 = x instanceof Short) ? x5 : ((x4 = x instanceof Byte) ? x4 : x instanceof BigInteger)))) {
            return true;
        }
        boolean x8 = x instanceof DFloNum;
        if (x8 ? x8 : ((x22222222 = x instanceof Float) ? x22222222 : x instanceof Double)) {
            x22222222 = Promise.force(x, Number.class);
            if (Math.IEEEremainder(((Number)x22222222).doubleValue(), 1.0) != 0.0) return false;
            return true;
        }
        if (!(x instanceof BigDecimal)) {
            return false;
        }
        try {
            ((BigDecimal)Promise.force(x, BigDecimal.class)).toBigIntegerExact();
            return true;
        }
        catch (ArithmeticException ex) {
            return false;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "java.lang.Number.doubleValue()", 1, x22222222);
        }
    }

    public static boolean isExactInteger(Object x) {
        boolean x2;
        boolean x3;
        boolean x4;
        boolean x5;
        boolean x6 = x instanceof IntNum;
        boolean bl = x6 ? x6 : (x instanceof Number ? ((x5 = x instanceof Long) ? x5 : ((x4 = x instanceof Integer) ? x4 : ((x3 = x instanceof Short) ? x3 : ((x2 = x instanceof Byte) ? x2 : x instanceof BigInteger)))) : false);
        return bl;
    }

    public static boolean isRealValued(Object x) {
        boolean bl;
        block11 : {
            block12 : {
                block8 : {
                    block9 : {
                        block10 : {
                            if (!numbers.isQuaternion(x)) break block12;
                            Object object2 = Promise.force(x, Number.class);
                            try {
                                if (!numbers.isZero(numbers.imagPart((Number)object2))) break block8;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "imag-part", 0, object2);
                            }
                            object2 = Promise.force(x, Number.class);
                            try {
                                if (!numbers.isZero(numbers.jmagPart((Number)object2))) break block9;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "jmag-part", 0, object2);
                            }
                            object2 = Promise.force(x, Number.class);
                            try {
                                if (!numbers.isZero(numbers.kmagPart((Number)object2))) break block10;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "kmag-part", 0, object2);
                            }
                            object2 = Promise.force(x, Number.class);
                            try {
                                bl = numbers.isReal(numbers.realPart((Number)object2));
                                break block11;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "real-part", 0, object2);
                            }
                        }
                        bl = false;
                        break block11;
                    }
                    bl = false;
                    break block11;
                }
                bl = false;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean isZero(Number x) {
        return x instanceof Numeric ? ((Numeric)x).isZero() : (x instanceof BigInteger ? NumberCompare.$Eq(Lit0, ((Procedure)GetNamedPart.getNamedPart).apply2((BigInteger)x, Lit1)) : (x instanceof BigDecimal ? NumberCompare.$Eq(Lit0, ((Procedure)GetNamedPart.getNamedPart).apply2((BigDecimal)x, Lit1)) : x.doubleValue() == 0.0));
    }

    public static Number imagPart(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).im() : IntNum.zero();
    }

    public static Number jmagPart(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).jm() : IntNum.zero();
    }

    public static Number kmagPart(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).km() : IntNum.zero();
    }

    public static Number realPart(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).re() : x;
    }

    public static boolean isRationalValued(Object x) {
        boolean bl;
        block11 : {
            block12 : {
                block8 : {
                    block9 : {
                        block10 : {
                            if (!numbers.isQuaternion(x)) break block12;
                            Object object2 = Promise.force(x, Number.class);
                            try {
                                if (!numbers.isZero(numbers.imagPart((Number)object2))) break block8;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "imag-part", 0, object2);
                            }
                            object2 = Promise.force(x, Number.class);
                            try {
                                if (!numbers.isZero(numbers.jmagPart((Number)object2))) break block9;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "jmag-part", 0, object2);
                            }
                            object2 = Promise.force(x, Number.class);
                            try {
                                if (!numbers.isZero(numbers.kmagPart((Number)object2))) break block10;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "kmag-part", 0, object2);
                            }
                            object2 = Promise.force(x, Number.class);
                            try {
                                bl = numbers.isRational(numbers.realPart((Number)object2));
                                break block11;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "real-part", 0, object2);
                            }
                        }
                        bl = false;
                        break block11;
                    }
                    bl = false;
                    break block11;
                }
                bl = false;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean isIntegerValued(Object x) {
        boolean bl;
        block11 : {
            block12 : {
                block8 : {
                    block9 : {
                        block10 : {
                            if (!numbers.isQuaternion(x)) break block12;
                            Object object2 = Promise.force(x, Number.class);
                            try {
                                if (!numbers.isZero(numbers.imagPart((Number)object2))) break block8;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "imag-part", 0, object2);
                            }
                            object2 = Promise.force(x, Number.class);
                            try {
                                if (!numbers.isZero(numbers.jmagPart((Number)object2))) break block9;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "jmag-part", 0, object2);
                            }
                            object2 = Promise.force(x, Number.class);
                            try {
                                if (!numbers.isZero(numbers.kmagPart((Number)object2))) break block10;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "kmag-part", 0, object2);
                            }
                            object2 = Promise.force(x, Number.class);
                            try {
                                bl = numbers.isInteger(numbers.realPart((Number)object2));
                                break block11;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "real-part", 0, object2);
                            }
                        }
                        bl = false;
                        break block11;
                    }
                    bl = false;
                    break block11;
                }
                bl = false;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean isExact(Object x) {
        return x instanceof Number ? Arithmetic.isExact((Number)Promise.force(x, Number.class)) : false;
    }

    public static boolean isInexact(Object x) {
        return x instanceof Number ? !Arithmetic.isExact((Number)Promise.force(x, Number.class)) : false;
    }

    public static boolean isPositive(RealNum x) {
        return x.sign() > 0;
    }

    public static boolean isNegative(RealNum x) {
        return x.isNegative();
    }

    public static boolean isFinite(Number z) {
        double d;
        boolean bl = z instanceof Quaternion ? ((Quaternion)z).classifyFinite() > 0 : (numbers.isJava$DtLang$DtReal(z) ? (!Double.isInfinite(d = z.doubleValue()) ? !Double.isNaN(d) : false) : false);
        return bl;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean isInfinite(Number z) {
        boolean bl;
        if (z instanceof Quaternion) {
            boolean x3;
            boolean x2;
            boolean x;
            Number number = z;
            Quaternion zc = (Quaternion)number;
            if (zc.re().classifyFinite() == 0) {
                return true;
            }
            boolean bl2 = x = false;
            if (x) {
                bl = x;
                return bl;
            }
            if (zc.im().classifyFinite() == 0) {
                return true;
            }
            boolean bl3 = x2 = false;
            if (x2) {
                bl = x2;
                return bl;
            }
            if (zc.jm().classifyFinite() == 0) {
                return true;
            }
            boolean bl4 = x3 = false;
            if (x3) {
                bl = x3;
                return bl;
            }
            if (zc.km().classifyFinite() != 0) return false;
            return true;
        }
        if (!numbers.isJava$DtLang$DtReal(z)) return false;
        double d = z.doubleValue();
        bl = Double.isInfinite(d);
        return bl;
        catch (ClassCastException classCastException) {
            void x;
            throw new WrongType(classCastException, "zc", -2, (Object)x);
        }
    }

    public static boolean isNan(Number z) {
        boolean bl;
        if (z instanceof Quaternion) {
            bl = ((Quaternion)z).classifyFinite() < 0;
        } else if (numbers.isJava$DtLang$DtReal(z)) {
            double d = z.doubleValue();
            bl = Double.isNaN(d);
        } else {
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* varargs */ Object max(Object ... args) {
        RealNum result;
        int i2;
        int n2 = args.length;
        Object object3 = Promise.force(args[0], RealNum.class);
        try {
            result = LangObjType.coerceRealNum(object3);
            i2 = 1;
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "result", -2, (Object)i2);
        }
        void n;
        while (i2 < n) {
            Object object2 = Promise.force(args[i2], RealNum.class);
            try {
                result = result.max(LangObjType.coerceRealNum(object2));
                ++i2;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "gnu.math.RealNum.max(real)", 2, object2);
            }
        }
        return result;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* varargs */ Object min(Object ... args) {
        RealNum result;
        int i2;
        int n2 = args.length;
        Object object3 = Promise.force(args[0], RealNum.class);
        try {
            result = LangObjType.coerceRealNum(object3);
            i2 = 0;
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "result", -2, (Object)i2);
        }
        void n;
        while (i2 < n) {
            Object object2 = Promise.force(args[i2], RealNum.class);
            try {
                result = result.min(LangObjType.coerceRealNum(object2));
                ++i2;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "gnu.math.RealNum.min(real)", 2, object2);
            }
        }
        return result;
    }

    public static Number abs(Number x) {
        return x instanceof Numeric ? ((Numeric)x).abs() : (NumberCompare.$Gr$Eq(x, Lit0) ? (Number)x : (Number)((Number)Promise.force(((Procedure)AddOp.$Mn).apply1(x), Number.class)));
    }

    public static Object floor$Sl(RealNum x, RealNum y) {
        RealNum r;
        RealNum q;
        Object object2 = Promise.force(((Procedure)DivideOp.floorQuotient).apply2(x, y), RealNum.class);
        try {
            q = LangObjType.coerceRealNum(object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "q", -2, (Object)r);
        }
        Object object3 = Promise.force(AddOp.apply2(-1, x, ((Procedure)MultiplyOp.$St).apply2(q, y)), RealNum.class);
        try {
            r = LangObjType.coerceRealNum(object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "r", -2, object3);
        }
        return misc.values(q, r);
    }

    public static Object truncate$Sl(RealNum x, RealNum y) {
        RealNum r;
        RealNum q;
        Object object2 = Promise.force(((Procedure)DivideOp.quotient).apply2(x, y), RealNum.class);
        try {
            q = LangObjType.coerceRealNum(object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "q", -2, (Object)r);
        }
        Object object3 = Promise.force(AddOp.apply2(-1, x, ((Procedure)MultiplyOp.$St).apply2(q, y)), RealNum.class);
        try {
            r = LangObjType.coerceRealNum(object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "r", -2, object3);
        }
        return misc.values(q, r);
    }

    public static Object divAndMod(RealNum x, RealNum y) {
        RealNum r;
        RealNum q;
        Object object2 = Promise.force(((Procedure)DivideOp.div).apply2(x, y), RealNum.class);
        try {
            q = LangObjType.coerceRealNum(object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "q", -2, (Object)r);
        }
        Object object3 = Promise.force(AddOp.apply2(-1, x, ((Procedure)MultiplyOp.$St).apply2(q, y)), RealNum.class);
        try {
            r = LangObjType.coerceRealNum(object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "r", -2, object3);
        }
        return misc.values(q, r);
    }

    public static Object div0AndMod0(RealNum x, RealNum y) {
        RealNum r;
        RealNum q;
        Object object2 = Promise.force(((Procedure)DivideOp.div0).apply2(x, y), RealNum.class);
        try {
            q = LangObjType.coerceRealNum(object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "q", -2, (Object)r);
        }
        Object object3 = Promise.force(AddOp.apply2(-1, x, ((Procedure)MultiplyOp.$St).apply2(q, y)), RealNum.class);
        try {
            r = LangObjType.coerceRealNum(object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "r", -2, object3);
        }
        return misc.values(q, r);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ RealNum gcd(RealNum ... args) {
        int n;
        RealNum realNum;
        Number number;
        boolean result$Mninexact;
        int n2 = args.length;
        boolean bl = false;
        IntNum result = Lit0;
        for (int i = 0; i < n; ++i) {
            IntNum intNum;
            RealNum val = args[i];
            boolean cur$Mninexact = numbers.isInexact(val);
            if (cur$Mninexact) {
                result$Mninexact = true;
                number = numbers.exact(val);
                intNum = LangObjType.coerceIntNum(number);
            }
            number = val;
            intNum = LangObjType.coerceIntNum(number);
            IntNum cur = intNum;
            result = i == 0 ? cur : IntNum.gcd(result, cur);
        }
        if (result$Mninexact) {
            realNum = LangObjType.coerceRealNum(numbers.inexact(result));
            return realNum;
        }
        realNum = result;
        return realNum;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cur", -2, (Object)number);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cur", -2, (Object)number);
        }
    }

    public static Number exact(Number num) {
        return Arithmetic.toExact(num);
    }

    public static Number inexact(Number num) {
        return Arithmetic.toInexact(num);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ RealNum lcm(RealNum ... args) {
        int n;
        RealNum realNum;
        Number number;
        boolean result$Mninexact;
        int n2 = args.length;
        boolean bl = false;
        IntNum result = Lit2;
        for (int i = 0; i < n; ++i) {
            IntNum intNum;
            RealNum val = args[i];
            boolean cur$Mninexact = numbers.isInexact(val);
            if (cur$Mninexact) {
                result$Mninexact = true;
                number = numbers.exact(val);
                intNum = LangObjType.coerceIntNum(number);
            }
            number = val;
            intNum = LangObjType.coerceIntNum(number);
            IntNum cur = intNum;
            result = i == 0 ? cur : IntNum.lcm(result, cur);
        }
        if (result$Mninexact) {
            realNum = LangObjType.coerceRealNum(numbers.inexact(result));
            return realNum;
        }
        realNum = result;
        return realNum;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cur", -2, (Object)number);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cur", -2, (Object)number);
        }
    }

    public static RealNum numerator(RealNum x) {
        return x instanceof RatNum ? ((RatNum)x).numerator() : LangObjType.coerceRealNum(numbers.inexact(LangObjType.coerceRatNum(numbers.exact(x)).numerator()));
    }

    public static RealNum denominator(RealNum x) {
        return x instanceof RatNum ? ((RatNum)x).denominator() : LangObjType.coerceRealNum(numbers.inexact(LangObjType.coerceRatNum(numbers.exact(x)).denominator()));
    }

    public static RealNum floor(RealNum x) {
        return x.toInt(Numeric.FLOOR);
    }

    public static RealNum ceiling(RealNum x) {
        return x.toInt(Numeric.CEILING);
    }

    public static RealNum truncate(RealNum x) {
        return x.toInt(Numeric.TRUNCATE);
    }

    public static RealNum round(RealNum x) {
        return x.toInt(Numeric.ROUND);
    }

    public static RealNum rationalize(RealNum x, RealNum y) {
        return RatNum.rationalize(LangObjType.coerceRealNum(x.sub(y)), LangObjType.coerceRealNum(x.add(y)));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Number exp(Number x) {
        Number number;
        if (!numbers.isJava$DtLang$DtReal(x)) {
            if (!(x instanceof Quaternion)) throw new IllegalArgumentException();
            number = ((Quaternion)x).exp();
            return number;
        }
        Number number2 = x;
        try {
            number = Math.exp(number2.doubleValue());
            return number;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "java.lang.Math.exp(double)", 1, (Object)number2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Number asin(Number x) {
        Number number;
        Quaternion u;
        Quaternion q;
        if (numbers.isJava$DtLang$DtReal(x)) {
            Number number2 = x;
            number = Math.asin(number2.doubleValue());
            return number;
        }
        if (numbers.isRealValued(x) && NumberCompare.$Ls$Eq$V(Lit3, x, Lit2, new Object[0])) {
            number = new DFloNum(Math.asin(x.doubleValue()));
            return number;
        }
        Numeric numeric = Arithmetic.asNumeric(x);
        try {
            q = (Quaternion)numeric;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "q", -2, (Object)u);
        }
        u = numbers.unitVector(q);
        Quaternion v = NumberCompare.$Eq(Lit0, u) ? Lit4 : u;
        Object object2 = Promise.force(AddOp.apply2(-1, Lit2, ((Procedure)MultiplyOp.$St).apply2(q, q)), Number.class);
        try {
            number = (Number)Promise.force(((Procedure)AddOp.$Mn).apply1(((Procedure)MultiplyOp.$St).apply2(v, ((Procedure)log).apply1(AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(v, q), numbers.sqrt((Number)object2))))), Number.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sqrt", 0, object2);
        }
        return number;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "java.lang.Math.asin(double)", 1, (Object)q);
        }
    }

    public static Quaternion unitVector(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).unitVector() : Lit0;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Number sqrt(Number x) {
        Number number;
        Quantity num;
        if (numbers.isJava$DtLang$DtReal(x)) {
            Number number3 = x;
            number = Math.sqrt(number3.doubleValue());
            return number;
        }
        if (!(x instanceof Quantity)) {
            number = (Number)Promise.force(Values.empty, Number.class);
            return number;
        }
        Number number2 = x;
        try {
            num = (Quantity)number2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "num", -2, (Object)number2);
        }
        number = Quantity.make(num.number().sqrt(), num.unit().sqrt());
        return number;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "java.lang.Math.sqrt(double)", 1, (Object)num);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Number acos(Number x) {
        Number number;
        Quaternion u;
        Quaternion q;
        if (numbers.isJava$DtLang$DtReal(x)) {
            Number number2 = x;
            number = Math.acos(number2.doubleValue());
            return number;
        }
        if (numbers.isRealValued(x) && NumberCompare.$Ls$Eq$V(Lit3, x, Lit2, new Object[0])) {
            number = new DFloNum(Math.acos(x.doubleValue()));
            return number;
        }
        Numeric numeric = Arithmetic.asNumeric(x);
        try {
            q = (Quaternion)numeric;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "q", -2, (Object)u);
        }
        u = numbers.unitVector(q);
        Quaternion v = NumberCompare.$Eq(Lit0, u) ? Lit4 : u;
        Object object2 = Promise.force(AddOp.apply2(-1, ((Procedure)MultiplyOp.$St).apply2(q, q), Lit2), Number.class);
        try {
            number = (Number)Promise.force(((Procedure)AddOp.$Mn).apply1(((Procedure)MultiplyOp.$St).apply2(v, ((Procedure)log).apply1(AddOp.apply2(1, q, numbers.sqrt((Number)object2))))), Number.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sqrt", 0, object2);
        }
        return number;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "java.lang.Math.acos(double)", 1, (Object)q);
        }
    }

    public static Number square(Number x) {
        return (Number)Promise.force(((Procedure)MultiplyOp.$St).apply2(x, x), Number.class);
    }

    public static Number magnitude(Number x) {
        return numbers.abs(x);
    }

    public static RealNum angle(Number x) {
        return x instanceof Quaternion ? ((Quaternion)x).angle() : (x.doubleValue() < 0.0 ? DFloNum.make(Math.PI) : Lit5);
    }

    public static Number exact$To$Inexact(Number num) {
        return Arithmetic.toInexact(num);
    }

    public static Number inexact$To$Exact(Number num) {
        return Arithmetic.toExact(num);
    }

    public static IntNum logop(int op, IntNum i, IntNum j) {
        return BitOps.bitOp(op, i, j);
    }

    public static boolean isBitwiseBitSet(IntNum i, int bitno) {
        return BitOps.bitValue(i, bitno);
    }

    public static IntNum bitwiseCopyBit(IntNum i, int bitno, int new$Mnvalue) {
        return BitOps.setBitValue(i, bitno, new$Mnvalue);
    }

    public static IntNum bitwiseCopyBitField(IntNum to, int start, int end, IntNum from) {
        return numbers.bitwiseIf(BitOps.makeMask(start, end), IntNum.shift(from, start), to);
    }

    public static IntNum bitwiseIf(IntNum e1, IntNum e2, IntNum e3) {
        return BitOps.ior(BitOps.and(e1, e2), BitOps.and(BitOps.not(e1), e3));
    }

    public static IntNum bitwiseBitField(IntNum i, int start, int end) {
        return BitOps.extract(i, start, end);
    }

    public static boolean logtest(IntNum i, IntNum j) {
        return BitOps.test(i, j);
    }

    public static int logcount(IntNum i) {
        return BitOps.bitCount(IntNum.compare(i, 0L) >= 0 ? i : BitOps.not(i));
    }

    public static int bitwiseBitCount(IntNum i) {
        return IntNum.compare(i, 0L) >= 0 ? BitOps.bitCount(i) : -1 - BitOps.bitCount(BitOps.not(i));
    }

    public static int bitwiseLength(IntNum i) {
        return i.intLength();
    }

    public static int bitwiseFirstBitSet(IntNum i) {
        return BitOps.lowestBitSet(i);
    }

    public static IntNum bitwiseRotateBitField(IntNum n, int start, int end, int count) {
        IntNum intNum;
        int width = end - start;
        if (width > 0) {
            int r = count % width;
            int count2 = r < 0 ? r + width : r;
            IntNum field0 = numbers.bitwiseBitField(n, start, end);
            IntNum field1 = IntNum.shift(field0, count2);
            IntNum field2 = IntNum.shift(field0, count2 - width);
            IntNum field = BitOps.ior(field1, field2);
            intNum = numbers.bitwiseCopyBitField(n, start, end, field);
        } else {
            intNum = n;
        }
        return intNum;
    }

    public static IntNum bitwiseReverseBitField(IntNum n, int start, int end) {
        return BitOps.reverseBits(n, start, end);
    }

    public static CharSequence number$To$String(Number number) {
        return numbers.number$To$String(number, 10);
    }

    public static CharSequence number$To$String(Number arg, int radix) {
        boolean x;
        boolean bl = x = radix < 2;
        if (x ? x : radix > 36) {
            throw new IllegalArgumentException(Format.formatToString(0, "invalid radix ~d", radix));
        }
        return new FString((CharSequence)Arithmetic.toString(arg, radix));
    }

    public static Object string$To$Number(CharSequence charSequence) {
        return numbers.string$To$Number(charSequence, 10);
    }

    public static Object string$To$Number(CharSequence str, int radix) {
        boolean x;
        boolean bl = x = radix < 2;
        if (x ? x : radix > 36) {
            throw new IllegalArgumentException(Format.formatToString(0, "invalid radix ~d", radix));
        }
        Object result = LispReader.parseNumber(str, -radix);
        return result instanceof Numeric ? result : Boolean.FALSE;
    }

    public static Quaternion quantity$To$Number(Quantity q) {
        q.unit();
        double factor = q.doubleValue();
        return factor == 1.0 ? q.number() : Quaternion.make(q.reValue(), q.imValue(), q.jmValue(), q.kmValue());
    }

    public static Unit quantity$To$Unit(Quantity q) {
        return q.unit();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Quantity makeQuantity(Object val, Object unit) {
        Unit u;
        Unit unit2;
        Object object2;
        if (unit instanceof Unit) {
            object2 = Promise.force(unit, Unit.class);
            unit2 = (Unit)object2;
        }
        Object object3 = Promise.force(unit, String.class);
        unit2 = u = Unit.lookup((String)(object3 == null ? null : object3.toString()));
        if (u == null) {
            throw new IllegalArgumentException(Format.formatToString(0, "unknown unit: ~s", unit).toString());
        }
        object2 = Promise.force(val, Quaternion.class);
        try {
            return Quantity.make((Quaternion)object2, u);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.math.Quantity.make(gnu.math.Quaternion,gnu.math.Unit)", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "u", -2, object2);
        }
    }

    public static Duration duration(Object duration) {
        Object object2 = Promise.force(duration, String.class);
        return Duration.parseDuration((String)(object2 == null ? null : object2.toString()));
    }

    public static Object exactIntegerSqrt(IntNum i) {
        IntNum intNum;
        IntNum q;
        IntNum rem;
        IntNum init;
        if (IntNum.compare(i, 0L) < 0) {
            throw new IllegalArgumentException(Format.formatToString(0, "negative argument: ~A", i));
        }
        double dval = i.doubleValue();
        if (Double.isInfinite(dval)) {
            int il = i.intLength();
            intNum = BitOps.makeMask(il, il + 1);
        } else {
            intNum = RealNum.toExactInt(Math.sqrt(dval), Numeric.TRUNCATE);
        }
        IntNum intNum2 = init = intNum;
        do {
            boolean x;
            boolean bl = x = IntNum.compare(rem = IntNum.sub(i, IntNum.times(q = intNum2, q)), 0L) < 0;
            if (!(x ? x : IntNum.compare(IntNum.shift(q, 1), IntNum.add(rem, -1)) <= 0)) break;
            intNum2 = IntNum.shift(IntNum.add(q, IntNum.quotient(i, q)), -1);
        } while (true);
        return misc.values(q, rem);
    }

    public static {
        Lit78 = Symbol.valueOf("exact-integer-sqrt");
        Lit77 = Symbol.valueOf("duration");
        Lit76 = Symbol.valueOf("make-quantity");
        Lit75 = Symbol.valueOf("quantity->unit");
        Lit74 = Symbol.valueOf("quantity->number");
        Lit73 = Symbol.valueOf("string->number");
        Lit72 = Symbol.valueOf("number->string");
        Lit71 = Symbol.valueOf("bitwise-reverse-bit-field");
        Lit70 = Symbol.valueOf("bitwise-rotate-bit-field");
        Lit69 = Symbol.valueOf("bitwise-first-bit-set");
        Lit68 = Symbol.valueOf("bitwise-length");
        Lit67 = Symbol.valueOf("bitwise-bit-count");
        Lit66 = Symbol.valueOf("logcount");
        Lit65 = Symbol.valueOf("logtest");
        Lit64 = Symbol.valueOf("bitwise-if");
        Lit63 = Symbol.valueOf("bitwise-bit-field");
        Lit62 = Symbol.valueOf("bitwise-copy-bit-field");
        Lit61 = Symbol.valueOf("bitwise-copy-bit");
        Lit60 = Symbol.valueOf("bitwise-bit-set?");
        Lit59 = Symbol.valueOf("logop");
        Lit58 = Symbol.valueOf("inexact->exact");
        Lit57 = Symbol.valueOf("exact->inexact");
        Lit56 = Symbol.valueOf("exact");
        Lit55 = Symbol.valueOf("inexact");
        Lit54 = Symbol.valueOf("angle");
        Lit53 = Symbol.valueOf("magnitude");
        Lit52 = Symbol.valueOf("unit-vector");
        Lit51 = Symbol.valueOf("kmag-part");
        Lit50 = Symbol.valueOf("jmag-part");
        Lit49 = Symbol.valueOf("imag-part");
        Lit48 = Symbol.valueOf("real-part");
        Lit47 = Symbol.valueOf("square");
        Lit46 = Symbol.valueOf("sqrt");
        Lit45 = IntNum.valueOf(2);
        Lit2 = IntNum.valueOf(1);
        Lit44 = new IntFraction(Lit2, Lit45);
        Lit43 = Symbol.valueOf("acos");
        Lit42 = Symbol.valueOf("asin");
        Lit41 = Symbol.valueOf("exp");
        Lit40 = Symbol.valueOf("rationalize");
        Lit39 = Symbol.valueOf("round");
        Lit38 = Symbol.valueOf("truncate");
        Lit37 = Symbol.valueOf("ceiling");
        Lit36 = Symbol.valueOf("floor");
        Lit35 = Symbol.valueOf("denominator");
        Lit34 = Symbol.valueOf("numerator");
        Lit33 = Symbol.valueOf("lcm");
        Lit32 = Symbol.valueOf("gcd");
        Lit31 = Symbol.valueOf("div0-and-mod0");
        Lit30 = Symbol.valueOf("div-and-mod");
        Lit29 = Symbol.valueOf("truncate/");
        Lit28 = Symbol.valueOf("floor/");
        Lit27 = Symbol.valueOf("abs");
        Lit26 = Symbol.valueOf("min");
        Lit25 = Symbol.valueOf("max");
        Lit24 = Symbol.valueOf("nan?");
        Lit23 = Symbol.valueOf("infinite?");
        Lit22 = Symbol.valueOf("finite?");
        Lit21 = Symbol.valueOf("negative?");
        Lit20 = Symbol.valueOf("positive?");
        Lit19 = Symbol.valueOf("zero?");
        Lit18 = Symbol.valueOf("inexact?");
        Lit17 = Symbol.valueOf("exact?");
        Lit16 = Symbol.valueOf("integer-valued?");
        Lit15 = Symbol.valueOf("rational-valued?");
        Lit14 = Symbol.valueOf("real-valued?");
        Lit13 = Symbol.valueOf("exact-integer?");
        Lit12 = Symbol.valueOf("integer?");
        Lit11 = Symbol.valueOf("rational?");
        Lit10 = Symbol.valueOf("real?");
        Lit9 = Symbol.valueOf("complex?");
        Lit8 = Symbol.valueOf("quaternion?");
        Lit7 = Symbol.valueOf("quantity?");
        Lit6 = Symbol.valueOf("number?");
        Lit5 = DFloNum.valueOf(0.0);
        Lit0 = IntNum.valueOf(0);
        Lit4 = new CComplex(Lit0, Lit2);
        Lit3 = IntNum.valueOf(-1);
        Lit1 = Symbol.valueOf("signum");
        LangObjType = LangObjType.class;
        quaternion = Quaternion.class;
        RealNum = RealNum.class;
        RatNum = RatNum.class;
        Numeric = Numeric.class;
        BitOps = BitOps.class;
        IntNum = IntNum.class;
        Double = Double.class;
        numbers numbers2 = $instance = new numbers();
        number$Qu = new ModuleMethod(numbers2, 1, Lit6, 4097);
        quantity$Qu = new ModuleMethod(numbers2, 2, Lit7, 4097);
        quaternion$Qu = new ModuleMethod(numbers2, 3, Lit8, 4097);
        complex$Qu = new ModuleMethod(numbers2, 4, Lit9, 4097);
        real$Qu = new ModuleMethod(numbers2, 5, Lit10, 4097);
        rational$Qu = new ModuleMethod(numbers2, 6, Lit11, 4097);
        integer$Qu = new ModuleMethod(numbers2, 7, Lit12, 4097);
        exact$Mninteger$Qu = new ModuleMethod(numbers2, 8, Lit13, 4097);
        real$Mnvalued$Qu = new ModuleMethod(numbers2, 9, Lit14, 4097);
        rational$Mnvalued$Qu = new ModuleMethod(numbers2, 10, Lit15, 4097);
        integer$Mnvalued$Qu = new ModuleMethod(numbers2, 11, Lit16, 4097);
        exact$Qu = new ModuleMethod(numbers2, 12, Lit17, 4097);
        inexact$Qu = new ModuleMethod(numbers2, 13, Lit18, 4097);
        zero$Qu = new ModuleMethod(numbers2, 14, Lit19, 4097);
        positive$Qu = new ModuleMethod(numbers2, 15, Lit20, 4097);
        negative$Qu = new ModuleMethod(numbers2, 16, Lit21, 4097);
        finite$Qu = new ModuleMethod(numbers2, 17, Lit22, 4097);
        infinite$Qu = new ModuleMethod(numbers2, 18, Lit23, 4097);
        nan$Qu = new ModuleMethod(numbers2, 19, Lit24, 4097);
        max = new ModuleMethod(numbers2, 20, Lit25, -4096);
        min = new ModuleMethod(numbers2, 21, Lit26, -4096);
        abs = new ModuleMethod(numbers2, 22, Lit27, 4097);
        floor$Sl = new ModuleMethod(numbers2, 23, Lit28, 8194);
        truncate$Sl = new ModuleMethod(numbers2, 24, Lit29, 8194);
        div$Mnand$Mnmod = new ModuleMethod(numbers2, 25, Lit30, 8194);
        div0$Mnand$Mnmod0 = new ModuleMethod(numbers2, 26, Lit31, 8194);
        gcd = new ModuleMethod(numbers2, 27, Lit32, -4096);
        lcm = new ModuleMethod(numbers2, 28, Lit33, -4096);
        numerator = new ModuleMethod(numbers2, 29, Lit34, 4097);
        denominator = new ModuleMethod(numbers2, 30, Lit35, 4097);
        floor = new ModuleMethod(numbers2, 31, Lit36, 4097);
        ceiling = new ModuleMethod(numbers2, 32, Lit37, 4097);
        truncate = new ModuleMethod(numbers2, 33, Lit38, 4097);
        round = new ModuleMethod(numbers2, 34, Lit39, 4097);
        rationalize = new ModuleMethod(numbers2, 35, Lit40, 8194);
        exp = new ModuleMethod(numbers2, 36, Lit41, 4097);
        GenericProc genericProc = new GenericProc("log");
        numbers $instance = numbers.$instance;
        ModuleMethod moduleMethod = new ModuleMethod($instance, 37, null, 8194);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:258");
        genericProc.add(moduleMethod);
        numbers $instance2 = numbers.$instance;
        ModuleMethod moduleMethod2 = new ModuleMethod($instance2, 38, null, 4097);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:266");
        genericProc.add(moduleMethod2);
        log = genericProc;
        GenericProc genericProc2 = new GenericProc("sin");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod3 = new ModuleMethod($instance, 39, null, 4097);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:273");
        genericProc2.add(moduleMethod3);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod4 = new ModuleMethod($instance2, 40, null, 4097);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:275");
        genericProc2.add(moduleMethod4);
        sin = genericProc2;
        GenericProc genericProc3 = new GenericProc("cos");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod5 = new ModuleMethod($instance, 41, null, 4097);
        moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:279");
        genericProc3.add(moduleMethod5);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod6 = new ModuleMethod($instance2, 42, null, 4097);
        moduleMethod6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:281");
        genericProc3.add(moduleMethod6);
        cos = genericProc3;
        GenericProc genericProc4 = new GenericProc("tan");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod7 = new ModuleMethod($instance, 43, null, 4097);
        moduleMethod7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:285");
        genericProc4.add(moduleMethod7);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod8 = new ModuleMethod($instance2, 44, null, 4097);
        moduleMethod8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:287");
        genericProc4.add(moduleMethod8);
        tan = genericProc4;
        asin = new ModuleMethod(numbers2, 45, Lit42, 4097);
        acos = new ModuleMethod(numbers2, 46, Lit43, 4097);
        GenericProc genericProc5 = new GenericProc("atan");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod9 = new ModuleMethod($instance, 47, null, 8194);
        moduleMethod9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:315");
        genericProc5.add(moduleMethod9);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod10 = new ModuleMethod($instance2, 48, null, 4097);
        moduleMethod10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:325");
        genericProc5.add(moduleMethod10);
        atan = genericProc5;
        GenericProc genericProc6 = new GenericProc("sinh");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod11 = new ModuleMethod($instance, 49, null, 4097);
        moduleMethod11.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:338");
        genericProc6.add(moduleMethod11);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod12 = new ModuleMethod($instance2, 50, null, 4097);
        moduleMethod12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:344");
        genericProc6.add(moduleMethod12);
        numbers $instance3 = numbers.$instance;
        ModuleMethod moduleMethod13 = new ModuleMethod($instance3, 51, null, 4097);
        moduleMethod13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:347");
        genericProc6.add(moduleMethod13);
        sinh = genericProc6;
        GenericProc genericProc7 = new GenericProc("cosh");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod14 = new ModuleMethod($instance, 52, null, 4097);
        moduleMethod14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:352");
        genericProc7.add(moduleMethod14);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod15 = new ModuleMethod($instance2, 53, null, 4097);
        moduleMethod15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:358");
        genericProc7.add(moduleMethod15);
        $instance3 = numbers.$instance;
        ModuleMethod moduleMethod16 = new ModuleMethod($instance3, 54, null, 4097);
        moduleMethod16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:361");
        genericProc7.add(moduleMethod16);
        cosh = genericProc7;
        GenericProc genericProc8 = new GenericProc("tanh");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod17 = new ModuleMethod($instance, 55, null, 4097);
        moduleMethod17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:366");
        genericProc8.add(moduleMethod17);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod18 = new ModuleMethod($instance2, 56, null, 4097);
        moduleMethod18.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:374");
        genericProc8.add(moduleMethod18);
        $instance3 = numbers.$instance;
        ModuleMethod moduleMethod19 = new ModuleMethod($instance3, 57, null, 4097);
        moduleMethod19.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:379");
        genericProc8.add(moduleMethod19);
        tanh = genericProc8;
        GenericProc genericProc9 = new GenericProc("asinh");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod20 = new ModuleMethod($instance, 58, null, 4097);
        moduleMethod20.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:384");
        genericProc9.add(moduleMethod20);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod21 = new ModuleMethod($instance2, 59, null, 4097);
        moduleMethod21.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:387");
        genericProc9.add(moduleMethod21);
        asinh = genericProc9;
        GenericProc genericProc10 = new GenericProc("acosh");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod22 = new ModuleMethod($instance, 60, null, 4097);
        moduleMethod22.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:392");
        genericProc10.add(moduleMethod22);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod23 = new ModuleMethod($instance2, 61, null, 4097);
        moduleMethod23.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:395");
        genericProc10.add(moduleMethod23);
        acosh = genericProc10;
        GenericProc genericProc11 = new GenericProc("atanh");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod24 = new ModuleMethod($instance, 62, null, 4097);
        moduleMethod24.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:400");
        genericProc11.add(moduleMethod24);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod25 = new ModuleMethod($instance2, 63, null, 4097);
        moduleMethod25.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:403");
        genericProc11.add(moduleMethod25);
        atanh = genericProc11;
        sqrt = new ModuleMethod(numbers2, 64, Lit46, 4097);
        square = new ModuleMethod(numbers2, 65, Lit47, 4097);
        GenericProc genericProc12 = new GenericProc("make-rectangular");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod26 = new ModuleMethod($instance, 66, null, 8194);
        moduleMethod26.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:419");
        genericProc12.add(moduleMethod26);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod27 = new ModuleMethod($instance2, 67, null, 16388);
        moduleMethod27.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:421");
        genericProc12.add(moduleMethod27);
        make$Mnrectangular = genericProc12;
        GenericProc genericProc13 = new GenericProc("make-polar");
        $instance = numbers.$instance;
        ModuleMethod moduleMethod28 = new ModuleMethod($instance, 68, null, 8194);
        moduleMethod28.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:425");
        genericProc13.add(moduleMethod28);
        $instance2 = numbers.$instance;
        ModuleMethod moduleMethod29 = new ModuleMethod($instance2, 69, null, 16388);
        moduleMethod29.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:427");
        genericProc13.add(moduleMethod29);
        make$Mnpolar = genericProc13;
        real$Mnpart = new ModuleMethod(numbers2, 70, Lit48, 4097);
        imag$Mnpart = new ModuleMethod(numbers2, 71, Lit49, 4097);
        jmag$Mnpart = new ModuleMethod(numbers2, 72, Lit50, 4097);
        kmag$Mnpart = new ModuleMethod(numbers2, 73, Lit51, 4097);
        unit$Mnvector = new ModuleMethod(numbers2, 74, Lit52, 4097);
        magnitude = new ModuleMethod(numbers2, 75, Lit53, 4097);
        angle = new ModuleMethod(numbers2, 76, Lit54, 4097);
        inexact = new ModuleMethod(numbers2, 77, Lit55, 4097);
        exact = new ModuleMethod(numbers2, 78, Lit56, 4097);
        exact$Mn$Grinexact = new ModuleMethod(numbers2, 79, Lit57, 4097);
        inexact$Mn$Grexact = new ModuleMethod(numbers2, 80, Lit58, 4097);
        logop = new ModuleMethod(numbers2, 81, Lit59, 12291);
        bitwise$Mnbit$Mnset$Qu = new ModuleMethod(numbers2, 82, Lit60, 8194);
        bitwise$Mncopy$Mnbit = new ModuleMethod(numbers2, 83, Lit61, 12291);
        bitwise$Mncopy$Mnbit$Mnfield = new ModuleMethod(numbers2, 84, Lit62, 16388);
        bitwise$Mnbit$Mnfield = new ModuleMethod(numbers2, 85, Lit63, 12291);
        bitwise$Mnif = new ModuleMethod(numbers2, 86, Lit64, 12291);
        logtest = new ModuleMethod(numbers2, 87, Lit65, 8194);
        logcount = new ModuleMethod(numbers2, 88, Lit66, 4097);
        bitwise$Mnbit$Mncount = new ModuleMethod(numbers2, 89, Lit67, 4097);
        bitwise$Mnlength = new ModuleMethod(numbers2, 90, Lit68, 4097);
        bitwise$Mnfirst$Mnbit$Mnset = new ModuleMethod(numbers2, 91, Lit69, 4097);
        bitwise$Mnrotate$Mnbit$Mnfield = new ModuleMethod(numbers2, 92, Lit70, 16388);
        bitwise$Mnreverse$Mnbit$Mnfield = new ModuleMethod(numbers2, 93, Lit71, 12291);
        number$Mn$Grstring = new ModuleMethod(numbers2, 94, Lit72, 8193);
        string$Mn$Grnumber = new ModuleMethod(numbers2, 96, Lit73, 8193);
        quantity$Mn$Grnumber = new ModuleMethod(numbers2, 98, Lit74, 4097);
        quantity$Mn$Grunit = new ModuleMethod(numbers2, 99, Lit75, 4097);
        make$Mnquantity = new ModuleMethod(numbers2, 100, Lit76, 8194);
        duration = new ModuleMethod(numbers2, 101, Lit77, 4097);
        exact$Mninteger$Mnsqrt = new ModuleMethod(numbers2, 102, Lit78, 4097);
        numbers.$runBody$();
    }

    public numbers() {
        ModuleInfo.register(this);
    }

    /*
     * Exception decompiling
     */
    public static Number lambda1(Number x, Number base) {
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
    public static Number lambda2(Number x) {
        Number number;
        Number number2;
        if (numbers.isJava$DtLang$DtReal(x)) {
            number2 = x;
            number = Math.log(number2.doubleValue());
            return number;
        }
        if (x instanceof Quaternion) {
            number = ((Quaternion)x).log();
            return number;
        }
        number = (Number)Promise.force(Values.empty, Number.class);
        return number;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "java.lang.Math.log(double)", 1, (Object)number2);
        }
    }

    public static Quaternion lambda3(Quaternion q) {
        return q.sin();
    }

    public static double lambda4(double x) {
        return Math.sin(x);
    }

    public static Quaternion lambda5(Quaternion q) {
        return q.cos();
    }

    public static double lambda6(double x) {
        return Math.cos(x);
    }

    public static Quaternion lambda7(Quaternion q) {
        return q.tan();
    }

    public static double lambda8(double x) {
        return Math.tan(x);
    }

    public static Number lambda9(Number y, Number x) {
        Number number;
        if (y instanceof RealNum && x instanceof RealNum) {
            number = new DFloNum(Math.atan2(y.doubleValue(), x.doubleValue()));
        } else {
            boolean x2;
            boolean x3 = numbers.isJava$DtLang$DtReal(y);
            if ((x3 ? x3 : y instanceof RealNum) && ((x2 = numbers.isJava$DtLang$DtReal(x)) ? x2 : x instanceof RealNum)) {
                number = Math.atan2(y.doubleValue(), x.doubleValue());
            } else {
                throw new IllegalArgumentException();
            }
        }
        return number;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Number lambda10(Number x) {
        Number number;
        Quaternion q;
        Quaternion u;
        if (x instanceof RealNum) {
            number = new DFloNum(Math.atan(x.doubleValue()));
            return number;
        }
        if (numbers.isJava$DtLang$DtReal(x)) {
            number = Math.atan(x.doubleValue());
            return number;
        }
        Number number2 = x;
        try {
            q = (Quaternion)number2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "q", -2, (Object)u);
        }
        u = numbers.unitVector(q);
        Quaternion v = NumberCompare.$Eq(Lit0, u) ? Lit4 : u;
        number = (Number)Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(Lit44, v), ((Procedure)log).apply1(((Procedure)MultiplyOp.$St).apply2(AddOp.apply2(1, v, q), ((Procedure)DivideOp.$Sl).apply2(Lit2, AddOp.apply2(-1, v, q))))), Number.class);
        return number;
    }

    public static Complex lambda11(Complex z) {
        void x;
        double y2;
        Number number = numbers.realPart(z);
        try {
            double d = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void y2;
            throw new WrongType(classCastException, "x", -2, (Object)y2);
        }
        Number number2 = numbers.imagPart(z);
        try {
            y2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "y", -2, (Object)number2);
        }
        return Complex.make(Math.sinh((double)x) * Math.cos(y2), Math.cosh((double)x) * Math.sin(y2));
    }

    public static Quaternion lambda12(Quaternion q) {
        Object object2 = Promise.force(((Procedure)AddOp.$Mn).apply1(q), Number.class);
        try {
            return (Quaternion)Promise.force(((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(-1, numbers.exp(q), numbers.exp((Number)object2)), Lit45), Quaternion.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", 0, object2);
        }
    }

    public static double lambda13(double x) {
        return Math.sinh(x);
    }

    public static Complex lambda14(Complex z) {
        void x;
        double y2;
        Number number = numbers.realPart(z);
        try {
            double d = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void y2;
            throw new WrongType(classCastException, "x", -2, (Object)y2);
        }
        Number number2 = numbers.imagPart(z);
        try {
            y2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "y", -2, (Object)number2);
        }
        return Complex.make(Math.cosh((double)x) * Math.cos(y2), Math.sinh((double)x) * Math.sin(y2));
    }

    public static Quaternion lambda15(Quaternion q) {
        Object object2 = Promise.force(((Procedure)AddOp.$Mn).apply1(q), Number.class);
        try {
            return (Quaternion)Promise.force(((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(1, numbers.exp(q), numbers.exp((Number)object2)), Lit45), Quaternion.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", 0, object2);
        }
    }

    public static double lambda16(double x) {
        return Math.cosh(x);
    }

    public static Complex lambda17(Complex z) {
        void x;
        double y2;
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(Lit45, numbers.realPart(z)));
        try {
            double d = ((Number)object2).doubleValue();
        }
        catch (ClassCastException classCastException) {
            void y2;
            throw new WrongType(classCastException, "x", -2, (Object)y2);
        }
        Object object3 = Promise.force(((Procedure)MultiplyOp.$St).apply2(Lit45, numbers.imagPart(z)));
        try {
            y2 = ((Number)object3).doubleValue();
        }
        catch (ClassCastException classCastException) {
            void w;
            throw new WrongType(classCastException, "y", -2, (Object)w);
        }
        double w = Math.cosh((double)x) + Math.cos(y2);
        return Complex.make(Math.sinh((double)x) / w, Math.sin(y2) / w);
    }

    public static Quaternion lambda18(Quaternion q) {
        Quaternion e$Up$Mnq;
        void e$Upq;
        Number number = numbers.exp(q);
        try {
            Quaternion quaternion = (Quaternion)number;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "e^q", -2, (Object)e$Up$Mnq);
        }
        Object object2 = Promise.force(((Procedure)AddOp.$Mn).apply1(q), Number.class);
        try {
            object2 = numbers.exp((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", 0, object2);
        }
        try {
            e$Up$Mnq = (Quaternion)object2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "e^-q", -2, object2);
        }
        return (Quaternion)Promise.force(((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(-1, e$Upq, e$Up$Mnq), AddOp.apply2(1, e$Upq, e$Up$Mnq)), Quaternion.class);
    }

    public static double lambda19(double x) {
        return Math.tanh(x);
    }

    public static Quaternion lambda20(Quaternion q) {
        Object object2 = Promise.force(AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(q, q), Lit2), Number.class);
        try {
            return (Quaternion)Promise.force(((Procedure)log).apply1(AddOp.apply2(1, q, numbers.sqrt((Number)object2))), Quaternion.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sqrt", 0, object2);
        }
    }

    public static double lambda21(double x) {
        return Math.log(x + Math.sqrt(x * x + 1.0));
    }

    /*
     * Exception decompiling
     */
    public static Quaternion lambda22(Quaternion q) {
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

    public static double lambda23(double x) {
        return Math.log(x + Math.sqrt(x * x - 1.0));
    }

    public static Quaternion lambda24(Quaternion q) {
        return (Quaternion)Promise.force(((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(-1, ((Procedure)log).apply1(AddOp.apply2(1, Lit2, q)), ((Procedure)log).apply1(AddOp.apply2(-1, Lit2, q))), Lit45), Quaternion.class);
    }

    public static double lambda25(double x) {
        return 0.5 * Math.log((1.0 + x) / (1.0 - x));
    }

    public static Complex lambda26(RealNum x, RealNum y) {
        return Complex.make(x, y);
    }

    public static Quaternion lambda27(RealNum w, RealNum x, RealNum y, RealNum z) {
        return Quaternion.make(w, x, y, z);
    }

    public static Complex lambda28(double x, double y) {
        return Complex.polar(x, y);
    }

    public static Quaternion lambda29(double r, double t, double u, double v) {
        return Quaternion.polar(r, t, u, v);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 63: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 62: {
                Object object3 = Promise.force(object2, Quaternion.class);
                if (!(object3 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 61: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 60: {
                Object object4 = Promise.force(object2, Quaternion.class);
                if (!(object4 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 59: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 58: {
                Object object5 = Promise.force(object2, Quaternion.class);
                if (!(object5 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 57: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 56: {
                Object object6 = Promise.force(object2, Quaternion.class);
                if (!(object6 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 55: {
                Object object7 = Promise.force(object2, Complex.class);
                if (!(object7 instanceof Complex)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 54: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 53: {
                Object object8 = Promise.force(object2, Quaternion.class);
                if (!(object8 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 52: {
                Object object9 = Promise.force(object2, Complex.class);
                if (!(object9 instanceof Complex)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 51: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 50: {
                Object object10 = Promise.force(object2, Quaternion.class);
                if (!(object10 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 49: {
                Object object11 = Promise.force(object2, Complex.class);
                if (!(object11 instanceof Complex)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 48: {
                Object object12 = Promise.force(object2, Number.class);
                if (!(object12 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 44: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 43: {
                Object object13 = Promise.force(object2, Quaternion.class);
                if (!(object13 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 42: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 41: {
                Object object14 = Promise.force(object2, Quaternion.class);
                if (!(object14 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 40: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 39: {
                Object object15 = Promise.force(object2, Quaternion.class);
                if (!(object15 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 38: {
                Object object16 = Promise.force(object2, Number.class);
                if (!(object16 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 102: {
                Object object17 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object17) == null) {
                    return -786431;
                }
                callContext.value1 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 101: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 99: {
                Object object18 = Promise.force(object2, Quantity.class);
                if (!(object18 instanceof Quantity)) {
                    return -786431;
                }
                callContext.value1 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 98: {
                Object object19 = Promise.force(object2, Quantity.class);
                if (!(object19 instanceof Quantity)) {
                    return -786431;
                }
                callContext.value1 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 96: {
                Object object20 = Promise.force(object2, CharSequence.class);
                if (!(object20 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 94: {
                Object object21 = Promise.force(object2, Number.class);
                if (!(object21 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 91: {
                Object object22 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object22) == null) {
                    return -786431;
                }
                callContext.value1 = object22;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 90: {
                Object object23 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object23) == null) {
                    return -786431;
                }
                callContext.value1 = object23;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 89: {
                Object object24 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object24) == null) {
                    return -786431;
                }
                callContext.value1 = object24;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 88: {
                Object object25 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object25) == null) {
                    return -786431;
                }
                callContext.value1 = object25;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 80: {
                Object object26 = Promise.force(object2, Number.class);
                if (!(object26 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object26;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 79: {
                Object object27 = Promise.force(object2, Number.class);
                if (!(object27 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object27;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 78: {
                Object object28 = Promise.force(object2, Number.class);
                if (!(object28 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object28;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 77: {
                Object object29 = Promise.force(object2, Number.class);
                if (!(object29 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object29;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 76: {
                Object object30 = Promise.force(object2, Number.class);
                if (!(object30 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object30;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 75: {
                Object object31 = Promise.force(object2, Number.class);
                if (!(object31 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object31;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 74: {
                Object object32 = Promise.force(object2, Number.class);
                if (!(object32 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object32;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 73: {
                Object object33 = Promise.force(object2, Number.class);
                if (!(object33 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object33;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 72: {
                Object object34 = Promise.force(object2, Number.class);
                if (!(object34 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object34;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 71: {
                Object object35 = Promise.force(object2, Number.class);
                if (!(object35 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object35;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 70: {
                Object object36 = Promise.force(object2, Number.class);
                if (!(object36 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object36;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 65: {
                Object object37 = Promise.force(object2, Number.class);
                if (!(object37 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object37;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 64: {
                Object object38 = Promise.force(object2, Number.class);
                if (!(object38 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object38;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 46: {
                Object object39 = Promise.force(object2, Number.class);
                if (!(object39 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object39;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 45: {
                Object object40 = Promise.force(object2, Number.class);
                if (!(object40 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object40;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 36: {
                Object object41 = Promise.force(object2, Number.class);
                if (!(object41 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object41;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 34: {
                Object object42 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object42) == null) {
                    return -786431;
                }
                callContext.value1 = object42;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 33: {
                Object object43 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object43) == null) {
                    return -786431;
                }
                callContext.value1 = object43;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 32: {
                Object object44 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object44) == null) {
                    return -786431;
                }
                callContext.value1 = object44;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 31: {
                Object object45 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object45) == null) {
                    return -786431;
                }
                callContext.value1 = object45;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 30: {
                Object object46 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object46) == null) {
                    return -786431;
                }
                callContext.value1 = object46;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 29: {
                Object object47 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object47) == null) {
                    return -786431;
                }
                callContext.value1 = object47;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 22: {
                Object object48 = Promise.force(object2, Number.class);
                if (!(object48 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object48;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 19: {
                Object object49 = Promise.force(object2, Number.class);
                if (!(object49 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object49;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                Object object50 = Promise.force(object2, Number.class);
                if (!(object50 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object50;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                Object object51 = Promise.force(object2, Number.class);
                if (!(object51 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object51;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                Object object52 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object52) == null) {
                    return -786431;
                }
                callContext.value1 = object52;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 15: {
                Object object53 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object53) == null) {
                    return -786431;
                }
                callContext.value1 = object53;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object54 = Promise.force(object2, Number.class);
                if (!(object54 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object54;
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
            case 10: {
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
            case 8: {
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
            case 1: {
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
            case 68: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 66: {
                Object object4 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object5) == null) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 47: {
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
            case 37: {
                Object object8 = Promise.force(object2, Number.class);
                if (!(object8 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = Promise.force(object3, Number.class);
                if (!(object9 instanceof Number)) {
                    return -786430;
                }
                callContext.value2 = object9;
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
            case 96: {
                Object object10 = Promise.force(object2, CharSequence.class);
                if (!(object10 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 94: {
                Object object11 = Promise.force(object2, Number.class);
                if (!(object11 instanceof Number)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 87: {
                Object object12 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object12) == null) {
                    return -786431;
                }
                callContext.value1 = object12;
                Object object13 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object13) == null) {
                    return -786430;
                }
                callContext.value2 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 82: {
                Object object14 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object14) == null) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 35: {
                Object object15 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object15) == null) {
                    return -786431;
                }
                callContext.value1 = object15;
                Object object16 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object16) == null) {
                    return -786430;
                }
                callContext.value2 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 26: {
                Object object17 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object17) == null) {
                    return -786431;
                }
                callContext.value1 = object17;
                Object object18 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object18) == null) {
                    return -786430;
                }
                callContext.value2 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 25: {
                Object object19 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object19) == null) {
                    return -786431;
                }
                callContext.value1 = object19;
                Object object20 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object20) == null) {
                    return -786430;
                }
                callContext.value2 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 24: {
                Object object21 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object21) == null) {
                    return -786431;
                }
                callContext.value1 = object21;
                Object object22 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object22) == null) {
                    return -786430;
                }
                callContext.value2 = object22;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 23: {
                Object object23 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object23) == null) {
                    return -786431;
                }
                callContext.value1 = object23;
                Object object24 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object24) == null) {
                    return -786430;
                }
                callContext.value2 = object24;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 93: {
                Object object5 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object5) == null) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 86: {
                Object object6 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object7) == null) {
                    return -786430;
                }
                callContext.value2 = object7;
                Object object8 = Promise.force(object4, IntNum.class);
                if (IntNum.asIntNumOrNull(object8) == null) {
                    return -786429;
                }
                callContext.value3 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 85: {
                Object object9 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object9) == null) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 83: {
                Object object10 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object10) == null) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 81: {
                callContext.value1 = Promise.force(object2);
                Object object11 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object11) == null) {
                    return -786430;
                }
                callContext.value2 = object11;
                Object object12 = Promise.force(object4, IntNum.class);
                if (IntNum.asIntNumOrNull(object12) == null) {
                    return -786429;
                }
                callContext.value3 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 69: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 67: {
                Object object6 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object7) == null) {
                    return -786430;
                }
                callContext.value2 = object7;
                Object object8 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object8) == null) {
                    return -786429;
                }
                callContext.value3 = object8;
                Object object9 = Promise.force(object5, RealNum.class);
                if (RealNum.asRealNumOrNull(object9) == null) {
                    return -786428;
                }
                callContext.value4 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 92: {
                Object object10 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object10) == null) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 84: {
                Object object11 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object11) == null) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                Object object12 = Promise.force(object5, IntNum.class);
                if (IntNum.asIntNumOrNull(object12) == null) {
                    return -786428;
                }
                callContext.value4 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
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
                Boolean bl;
                if (numbers.isNumber(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 2: {
                Boolean bl;
                if (numbers.isQuantity(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 3: {
                Boolean bl;
                if (numbers.isQuaternion(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 4: {
                Boolean bl;
                if (numbers.isComplex(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 5: {
                Boolean bl;
                if (numbers.isReal(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 6: {
                Boolean bl;
                if (numbers.isRational(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 7: {
                Boolean bl;
                if (numbers.isInteger(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 8: {
                Boolean bl;
                if (numbers.isExactInteger(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 9: {
                Boolean bl;
                if (numbers.isRealValued(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 10: {
                Boolean bl;
                if (numbers.isRationalValued(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 11: {
                Boolean bl;
                if (numbers.isIntegerValued(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 12: {
                Boolean bl;
                if (numbers.isExact(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 13: {
                Boolean bl;
                if (numbers.isInexact(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 14: {
                Boolean bl;
                if (numbers.isZero((Number)Promise.force(object2, Number.class))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 15: {
                Boolean bl;
                if (numbers.isPositive(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 16: {
                Boolean bl;
                if (numbers.isNegative(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 17: {
                Boolean bl;
                if (numbers.isFinite((Number)Promise.force(object2, Number.class))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 18: {
                Boolean bl;
                if (numbers.isInfinite((Number)Promise.force(object2, Number.class))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 19: {
                Boolean bl;
                if (numbers.isNan((Number)Promise.force(object2, Number.class))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 22: {
                return numbers.abs((Number)Promise.force(object2, Number.class));
            }
            case 29: {
                return numbers.numerator(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 30: {
                return numbers.denominator(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 31: {
                return numbers.floor(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 32: {
                return numbers.ceiling(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 33: {
                return numbers.truncate(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 34: {
                return numbers.round(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 36: {
                return numbers.exp((Number)Promise.force(object2, Number.class));
            }
            case 45: {
                return numbers.asin((Number)Promise.force(object2, Number.class));
            }
            case 46: {
                return numbers.acos((Number)Promise.force(object2, Number.class));
            }
            case 64: {
                return numbers.sqrt((Number)Promise.force(object2, Number.class));
            }
            case 65: {
                return numbers.square((Number)Promise.force(object2, Number.class));
            }
            case 70: {
                return numbers.realPart((Number)Promise.force(object2, Number.class));
            }
            case 71: {
                return numbers.imagPart((Number)Promise.force(object2, Number.class));
            }
            case 72: {
                return numbers.jmagPart((Number)Promise.force(object2, Number.class));
            }
            case 73: {
                return numbers.kmagPart((Number)Promise.force(object2, Number.class));
            }
            case 74: {
                return numbers.unitVector((Number)Promise.force(object2, Number.class));
            }
            case 75: {
                return numbers.magnitude((Number)Promise.force(object2, Number.class));
            }
            case 76: {
                return numbers.angle((Number)Promise.force(object2, Number.class));
            }
            case 77: {
                return numbers.inexact((Number)Promise.force(object2, Number.class));
            }
            case 78: {
                return numbers.exact((Number)Promise.force(object2, Number.class));
            }
            case 79: {
                return numbers.exact$To$Inexact((Number)Promise.force(object2, Number.class));
            }
            case 80: {
                return numbers.inexact$To$Exact((Number)Promise.force(object2, Number.class));
            }
            case 88: {
                return numbers.logcount(LangObjType.coerceIntNum(Promise.force(object2, IntNum.class)));
            }
            case 89: {
                return numbers.bitwiseBitCount(LangObjType.coerceIntNum(Promise.force(object2, IntNum.class)));
            }
            case 90: {
                return numbers.bitwiseLength(LangObjType.coerceIntNum(Promise.force(object2, IntNum.class)));
            }
            case 91: {
                return numbers.bitwiseFirstBitSet(LangObjType.coerceIntNum(Promise.force(object2, IntNum.class)));
            }
            case 94: {
                return numbers.number$To$String((Number)Promise.force(object2, Number.class));
            }
            case 96: {
                return numbers.string$To$Number((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 98: {
                return numbers.quantity$To$Number((Quantity)Promise.force(object2, Quantity.class));
            }
            case 99: {
                return numbers.quantity$To$Unit((Quantity)Promise.force(object2, Quantity.class));
            }
            case 101: {
                return numbers.duration(object2);
            }
            case 102: {
                return numbers.exactIntegerSqrt(LangObjType.coerceIntNum(Promise.force(object2, IntNum.class)));
            }
            case 38: {
                return numbers.lambda2((Number)Promise.force(object2, Number.class));
            }
            case 39: {
                return numbers.lambda3((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 40: {
                return numbers.lambda4(((Number)Promise.force(object2)).doubleValue());
            }
            case 41: {
                return numbers.lambda5((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 42: {
                return numbers.lambda6(((Number)Promise.force(object2)).doubleValue());
            }
            case 43: {
                return numbers.lambda7((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 44: {
                return numbers.lambda8(((Number)Promise.force(object2)).doubleValue());
            }
            case 48: {
                return numbers.lambda10((Number)Promise.force(object2, Number.class));
            }
            case 49: {
                return numbers.lambda11((Complex)Promise.force(object2, Complex.class));
            }
            case 50: {
                return numbers.lambda12((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 51: {
                return numbers.lambda13(((Number)Promise.force(object2)).doubleValue());
            }
            case 52: {
                return numbers.lambda14((Complex)Promise.force(object2, Complex.class));
            }
            case 53: {
                return numbers.lambda15((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 54: {
                return numbers.lambda16(((Number)Promise.force(object2)).doubleValue());
            }
            case 55: {
                return numbers.lambda17((Complex)Promise.force(object2, Complex.class));
            }
            case 56: {
                return numbers.lambda18((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 57: {
                return numbers.lambda19(((Number)Promise.force(object2)).doubleValue());
            }
            case 58: {
                return numbers.lambda20((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 59: {
                return numbers.lambda21(((Number)Promise.force(object2)).doubleValue());
            }
            case 60: {
                return numbers.lambda22((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 61: {
                return numbers.lambda23(((Number)Promise.force(object2)).doubleValue());
            }
            case 62: {
                return numbers.lambda24((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 63: {
                return numbers.lambda25(((Number)Promise.force(object2)).doubleValue());
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "zero?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "positive?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "negative?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "finite?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "infinite?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "nan?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "abs", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "numerator", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "denominator", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "floor", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "ceiling", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "truncate", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "round", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exp", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "asin", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "acos", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sqrt", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "square", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "real-part", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "imag-part", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "jmag-part", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "kmag-part", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-vector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "magnitude", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "angle", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "inexact", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exact", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exact->inexact", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "inexact->exact", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "logcount", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "bitwise-bit-count", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "bitwise-length", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "bitwise-first-bit-set", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string->number", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "quantity->number", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "quantity->unit", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "exact-integer-sqrt", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
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

    /*
     * Exception decompiling
     */
    public Object apply4(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4, Object var5_5) {
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
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        Object object2;
        Object object3;
        switch (moduleMethod.selector) {
            case 20: {
                return numbers.max(arrobject);
            }
            case 21: {
                return numbers.min(arrobject);
            }
            case 27: {
                int n = arrobject.length;
                RealNum[] arrrealNum = new RealNum[n];
                do {
                    if (--n < 0) {
                        return numbers.gcd(arrrealNum);
                    }
                    arrrealNum = arrrealNum;
                    object3 = arrobject[n];
                    arrrealNum[n] = LangObjType.coerceRealNum(object3);
                    continue;
                    break;
                } while (true);
            }
            case 28: {
                int n = arrobject.length;
                RealNum[] arrrealNum = new RealNum[n];
                while (--n >= 0) {
                    arrrealNum = arrrealNum;
                    object2 = arrobject[n];
                    arrrealNum[n] = LangObjType.coerceRealNum(object2);
                    continue;
                    break;
                }
                return numbers.lcm(arrrealNum);
            }
        }
        return super.applyN(moduleMethod, arrobject);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gcd", 0, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lcm", 0, object2);
        }
    }
}

