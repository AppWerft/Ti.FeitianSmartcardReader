// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.math.UByte;
import gnu.math.UShort;
import gnu.mapping.Promise;
import gnu.kawa.reflect.LazyType;
import gnu.bytecode.PrimType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.bytecode.Type;
import gnu.math.RealNum;
import gnu.math.DFloNum;
import gnu.math.RatNum;
import gnu.math.IntNum;
import gnu.mapping.Lazy;
import java.math.BigDecimal;
import java.math.BigInteger;
import gnu.math.UInt;
import gnu.math.ULong;
import gnu.math.UnsignedPrim;
import gnu.math.Numeric;
import gnu.bytecode.ClassType;
import gnu.kawa.lispexpr.LangObjType;

public class Arithmetic
{
    public static final int INT_CODE = 1;
    public static final int UINT_CODE = 2;
    public static final int LONG_CODE = 3;
    public static final int ULONG_CODE = 4;
    public static final int BIGINTEGER_CODE = 5;
    public static final int INTNUM_CODE = 6;
    public static final int BIGDECIMAL_CODE = 7;
    public static final int RATNUM_CODE = 8;
    public static final int FLOAT_CODE = 9;
    public static final int DOUBLE_CODE = 10;
    public static final int FLONUM_CODE = 11;
    public static final int REALNUM_CODE = 12;
    public static final int NUMERIC_CODE = 13;
    public static final int UNKNOWN_CODE = 0;
    static LangObjType typeDFloNum;
    static LangObjType typeRatNum;
    static LangObjType typeRealNum;
    static ClassType typeNumber;
    static LangObjType typeIntNum;
    
    public static int leastSpecificCode(final int code1, final int code2) {
        return (code1 <= 0 || code2 <= 0) ? 0 : ((code1 < code2) ? code2 : code1);
    }
    
    public static int classifyValue(Object value) {
        while (!(value instanceof Numeric)) {
            if (value instanceof Number) {
                if (value instanceof Integer || value instanceof Short || value instanceof Byte) {
                    return 1;
                }
                if (value instanceof Long) {
                    return 3;
                }
                if (value instanceof UnsignedPrim) {
                    return (value instanceof ULong) ? 4 : ((value instanceof UInt) ? 2 : 1);
                }
                if (value instanceof Float) {
                    return 9;
                }
                if (value instanceof Double) {
                    return 10;
                }
                if (value instanceof BigInteger) {
                    return 5;
                }
                if (value instanceof BigDecimal) {
                    return 7;
                }
            }
            else if (value instanceof Lazy) {
                final Object v = ((Lazy)value).getValue();
                if (v != value) {
                    value = v;
                    continue;
                }
            }
            return 0;
        }
        if (value instanceof IntNum) {
            return 6;
        }
        if (value instanceof RatNum) {
            return 8;
        }
        if (value instanceof DFloNum) {
            return 11;
        }
        if (value instanceof RealNum) {
            return 12;
        }
        return 13;
    }
    
    public static Type kindType(final int kind) {
        switch (kind) {
            case 1: {
                return LangPrimType.intType;
            }
            case 2: {
                return LangPrimType.unsignedIntType;
            }
            case 3: {
                return LangPrimType.longType;
            }
            case 4: {
                return LangPrimType.unsignedLongType;
            }
            case 5: {
                return ClassType.make("java.math.BigInteger");
            }
            case 6: {
                return Arithmetic.typeIntNum;
            }
            case 7: {
                return ClassType.make("java.math.BigDecimal");
            }
            case 8: {
                return Arithmetic.typeRatNum;
            }
            case 9: {
                return LangPrimType.floatType;
            }
            case 10: {
                return LangPrimType.doubleType;
            }
            case 11: {
                return Arithmetic.typeDFloNum;
            }
            case 12: {
                return Arithmetic.typeRealNum;
            }
            case 13: {
                return LangObjType.numericType;
            }
            default: {
                return Type.pointer_type;
            }
        }
    }
    
    public static int classifyType(final Type type) {
        final int kind = 0;
        if (type instanceof PrimType) {
            final char sig = type.getSignature().charAt(0);
            if (sig == 'V' || sig == 'Z' || sig == 'C') {
                return 0;
            }
            if (sig == 'D') {
                return 10;
            }
            if (sig == 'F') {
                return 9;
            }
            if (sig == 'J') {
                return (type == LangPrimType.unsignedLongType) ? 4 : 3;
            }
            return (type == LangPrimType.unsignedIntType) ? 2 : 1;
        }
        else {
            final String tname = type.getName();
            if (type.isSubtype(Arithmetic.typeIntNum)) {
                return 6;
            }
            if (type.isSubtype(Arithmetic.typeRatNum)) {
                return 8;
            }
            if (type.isSubtype(Arithmetic.typeDFloNum)) {
                return 11;
            }
            if ("java.lang.Double".equals(tname)) {
                return 10;
            }
            if ("java.lang.Float".equals(tname)) {
                return 9;
            }
            if ("java.lang.Long".equals(tname)) {
                return 3;
            }
            if ("gnu.math.ULong".equals(tname)) {
                return 4;
            }
            if ("gnu.math.UInt".equals(tname)) {
                return 2;
            }
            if ("java.lang.Integer".equals(tname) || "java.lang.Short".equals(tname) || "java.lang.Byte".equals(tname) || "gnu.math.UShort".equals(tname) || "gnu.math.UByte".equals(tname)) {
                return 1;
            }
            if ("java.math.BigInteger".equals(tname)) {
                return 5;
            }
            if ("java.math.BigDecimal".equals(tname)) {
                return 7;
            }
            if (type.isSubtype(Arithmetic.typeRealNum)) {
                return 12;
            }
            if (type.isSubtype(LangObjType.numericType)) {
                return 13;
            }
            if (type instanceof LazyType) {
                return classifyType(((LazyType)type).getValueType());
            }
            return 0;
        }
    }
    
    public static int asInt(final Object value) {
        return ((Number)Promise.force(value)).intValue();
    }
    
    public static long asLong(final Object value) {
        return ((Number)Promise.force(value)).longValue();
    }
    
    public static float asFloat(final Object value) {
        return ((Number)Promise.force(value)).floatValue();
    }
    
    public static double asDouble(final Object value) {
        return ((Number)Promise.force(value)).doubleValue();
    }
    
    public static BigInteger asBigInteger(Object value) {
        value = Promise.force(value);
        if (value instanceof BigInteger) {
            return (BigInteger)value;
        }
        if (value instanceof IntNum || value instanceof ULong) {
            return new BigInteger(value.toString());
        }
        return BigInteger.valueOf(((Number)value).longValue());
    }
    
    public static IntNum asIntNum(final BigDecimal value) {
        return IntNum.valueOf(value.toBigInteger().toString(), 10);
    }
    
    public static IntNum asIntNum(final BigInteger value) {
        return IntNum.valueOf(value.toString(), 10);
    }
    
    public static IntNum asIntNum(Object value) {
        value = Promise.force(value);
        if (value instanceof IntNum) {
            return (IntNum)value;
        }
        if (value instanceof UnsignedPrim) {
            return ((UnsignedPrim)value).toIntNum();
        }
        if (value instanceof BigInteger) {
            return IntNum.valueOf(value.toString(), 10);
        }
        if (value instanceof BigDecimal) {
            return asIntNum((BigDecimal)value);
        }
        return IntNum.valueOf(((Number)value).longValue());
    }
    
    public static BigDecimal asBigDecimal(Object value) {
        value = Promise.force(value);
        if (value instanceof BigDecimal) {
            return (BigDecimal)value;
        }
        if (value instanceof BigInteger) {
            return new BigDecimal((BigInteger)value);
        }
        if (value instanceof Long || value instanceof Integer || value instanceof Short || value instanceof Byte || value instanceof UInt || value instanceof UShort || value instanceof UByte) {
            return BigDecimal.valueOf(((Number)value).longValue());
        }
        return new BigDecimal(value.toString());
    }
    
    public static RatNum asRatNum(Object value) {
        value = Promise.force(value);
        if (value instanceof RatNum) {
            return (RatNum)value;
        }
        if (value instanceof BigInteger) {
            return IntNum.valueOf(value.toString(), 10);
        }
        if (value instanceof ULong) {
            return IntNum.valueOfUnsigned(((ULong)value).longValue());
        }
        if (value instanceof BigDecimal) {
            return RatNum.valueOf((BigDecimal)value);
        }
        return IntNum.valueOf(((Number)value).longValue());
    }
    
    public static Numeric asNumeric(Object value) {
        value = Promise.force(value);
        final Numeric n = Numeric.asNumericOrNull(value);
        return (Numeric)((n != null) ? n : value);
    }
    
    public static String toString(final Object number, final int radix) {
        final int code = classifyValue(number);
        switch (code) {
            case 1: {
                return Integer.toString(asInt(number), radix);
            }
            case 2:
            case 3: {
                return Long.toString(asLong(number), radix);
            }
            case 4: {
                final long lval = asLong(number);
                if (lval >= 0L) {
                    return Long.toString(lval, radix);
                }
                return IntNum.valueOfUnsigned(lval).toString(radix);
            }
            case 5: {
                return asBigInteger(number).toString(radix);
            }
            case 6: {
                return asIntNum(number).toString(radix);
            }
            case 7: {
                if (radix == 10) {
                    return asBigDecimal(number).toString();
                }
            }
            case 9: {
                if (radix == 10) {
                    return Float.toString(asFloat(number));
                }
            }
            case 10:
            case 11: {
                if (radix == 10) {
                    return Double.toString(asDouble(number));
                }
                break;
            }
        }
        return asNumeric(number).toString(radix);
    }
    
    public static Object convert(Object value, final int code) {
        value = Promise.force(value);
        switch (code) {
            case 1: {
                if (value instanceof Integer) {
                    return value;
                }
                return ((Number)value).intValue();
            }
            case 2: {
                if (value instanceof UInt) {
                    return value;
                }
                return UInt.valueOf(((Number)value).intValue());
            }
            case 3: {
                if (value instanceof Long) {
                    return value;
                }
                return ((Number)value).longValue();
            }
            case 4: {
                if (value instanceof ULong) {
                    return value;
                }
                return ULong.valueOf(((Number)value).longValue());
            }
            case 5: {
                return asBigInteger(value);
            }
            case 6: {
                return asIntNum(value);
            }
            case 7: {
                return asBigDecimal(value);
            }
            case 8: {
                return asRatNum(value);
            }
            case 9: {
                if (value instanceof Float) {
                    return value;
                }
                final float f = asFloat(value);
                return f;
            }
            case 10: {
                if (value instanceof Double) {
                    return value;
                }
                final double d = asDouble(value);
                return d;
            }
            case 11: {
                if (value instanceof DFloNum) {
                    return value;
                }
                return DFloNum.valueOf(asDouble(value));
            }
            case 13: {
                return asNumeric(value);
            }
            case 12: {
                return asNumeric(value);
            }
            default: {
                return value;
            }
        }
    }
    
    public static boolean isExact(final Number num) {
        if (num instanceof Numeric) {
            return ((Numeric)num).isExact();
        }
        return !(num instanceof Double) && !(num instanceof Float) && !(num instanceof BigDecimal);
    }
    
    public static Number toExact(final Number num) {
        if (num instanceof Numeric) {
            return ((Numeric)num).toExact();
        }
        if (num instanceof Double || num instanceof Float || num instanceof BigDecimal) {
            return DFloNum.toExact(num.doubleValue());
        }
        return num;
    }
    
    public static Number toInexact(final Number num) {
        if (num instanceof Numeric) {
            return ((Numeric)num).toInexact();
        }
        if (num instanceof Double || num instanceof Float || num instanceof BigDecimal) {
            return num;
        }
        return num.doubleValue();
    }
    
    static {
        Arithmetic.typeDFloNum = LangObjType.dflonumType;
        Arithmetic.typeRatNum = LangObjType.rationalType;
        Arithmetic.typeRealNum = LangObjType.realType;
        Arithmetic.typeNumber = ClassType.make("java.lang.Number");
        Arithmetic.typeIntNum = LangObjType.integerType;
    }
}
