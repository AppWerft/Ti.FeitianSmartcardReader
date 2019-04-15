/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.functions.Arithmetic;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XIntegerType;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.xml.TextUtils;
import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberValue
extends Procedure1 {
    public static final NumberValue numberValue = new NumberValue();
    public static final Double NaN = new Double(Double.NaN);

    public static boolean isNaN(Object arg) {
        return (arg instanceof Double || arg instanceof Float || arg instanceof DFloNum) && Double.isNaN(((Number)arg).doubleValue());
    }

    @Override
    public Object apply1(Object arg) {
        if (arg != Values.empty && arg != null) {
            try {
                return NumberValue.numberValue(arg);
            }
            catch (Exception ex) {
                // empty catch block
            }
        }
        return NaN;
    }

    public static Number numberCast(Object value) {
        if (value == Values.empty || value == null) {
            return null;
        }
        if (value instanceof Values) {
            Values vals = (Values)value;
            int ipos = vals.startPos();
            int count = 0;
            while ((ipos = vals.nextPos(ipos)) != 0) {
                if (count > 0) {
                    throw new ClassCastException("non-singleton sequence cast to number");
                }
                value = vals.getPosPrevious(ipos);
                ++count;
            }
        }
        if (value instanceof KNode || value instanceof UntypedAtomic) {
            return (Double)XDataType.doubleType.valueOf(TextUtils.stringValue(value));
        }
        return (Number)value;
    }

    public static Object numberValue(Object value) {
        double d;
        if ((value = KNode.atomicValue(value)) instanceof UntypedAtomic || value instanceof String) {
            try {
                return XDataType.doubleType.valueOf(TextUtils.stringValue(value));
            }
            catch (Exception ex) {
                d = Double.NaN;
            }
        } else {
            d = value instanceof Number && (value instanceof RealNum || !(value instanceof Numeric)) ? ((Number)value).doubleValue() : Double.NaN;
        }
        return XDataType.makeDouble(d);
    }

    public static Object abs(Object value) {
        if (value == null || value == Values.empty) {
            return value;
        }
        if ((value = NumberValue.numberCast(value)) instanceof Double) {
            Double d = (Double)value;
            double x = d;
            long bits = Double.doubleToRawLongBits(x);
            if (bits >= 0L) {
                return d;
            }
            x = Double.longBitsToDouble(bits &= Long.MAX_VALUE);
            return x;
        }
        if (value instanceof Float) {
            Float d = (Float)value;
            float x = d.floatValue();
            int bits = Float.floatToRawIntBits(x);
            if (bits >= 0) {
                return d;
            }
            x = Float.intBitsToFloat(bits &= Integer.MAX_VALUE);
            return Float.valueOf(x);
        }
        if (value instanceof BigDecimal) {
            BigDecimal dec = (BigDecimal)value;
            if (dec.signum() < 0) {
                dec = dec.negate();
            }
            return dec;
        }
        return ((Numeric)value).abs();
    }

    public static Object floor(Object val) {
        Number value = NumberValue.numberCast(val);
        if (value == null) {
            return val;
        }
        if (value instanceof Double) {
            return XDataType.makeDouble(Math.floor((Double)value));
        }
        if (value instanceof Float) {
            return XDataType.makeFloat((float)Math.floor(((Float)value).floatValue()));
        }
        if (value instanceof BigDecimal) {
            BigDecimal dec = (BigDecimal)value;
            return Arithmetic.asIntNum(dec.divide(XDataType.DECIMAL_ONE, 0, 3).toBigInteger());
        }
        return ((RealNum)value).toInt(1);
    }

    public static Object ceiling(Object val) {
        Number value = NumberValue.numberCast(val);
        if (value == null) {
            return val;
        }
        if (value instanceof Double) {
            return XDataType.makeDouble(Math.ceil((Double)value));
        }
        if (value instanceof Float) {
            return XDataType.makeFloat((float)Math.ceil(((Float)value).floatValue()));
        }
        if (value instanceof BigDecimal) {
            BigDecimal dec = (BigDecimal)value;
            return Arithmetic.asIntNum(dec.divide(XDataType.DECIMAL_ONE, 0, 2).toBigInteger());
        }
        return ((RealNum)value).toInt(2);
    }

    public static Object round(Object arg) {
        Number value = NumberValue.numberCast(arg);
        if (value == null) {
            return arg;
        }
        if (value instanceof Double) {
            double val = (Double)value;
            val = val >= -0.5 && val <= 0.0 && (val < 0.0 || Double.doubleToLongBits(val) < 0L) ? -0.0 : Math.floor(val + 0.5);
            return XDataType.makeDouble(val);
        }
        if (value instanceof Float) {
            float val = ((Float)value).floatValue();
            val = (double)val >= -0.5 && (double)val <= 0.0 && ((double)val < 0.0 || Float.floatToIntBits(val) < 0) ? -0.0f : (float)Math.floor((double)val + 0.5);
            return XDataType.makeFloat(val);
        }
        if (value instanceof BigDecimal) {
            BigDecimal dec = (BigDecimal)value;
            int mode = dec.signum() >= 0 ? 4 : 5;
            dec = dec.divide(XDataType.DECIMAL_ONE, 0, mode);
            return Arithmetic.asIntNum(dec.toBigInteger());
        }
        return ((RealNum)value).toInt(4);
    }

    public static Object roundHalfToEven(Object value, IntNum precision) {
        double v;
        Number number = NumberValue.numberCast(value);
        if (number == null) {
            return value;
        }
        if ((value instanceof Double || value instanceof Float) && ((v = ((Number)value).doubleValue()) == 0.0 || Double.isInfinite(v) || Double.isNaN(v))) {
            return value;
        }
        BigDecimal dec = (BigDecimal)XDataType.decimalType.cast(number);
        int prec = precision.intValue();
        dec = dec.setScale(prec, 6);
        if (number instanceof Double) {
            return XDataType.makeDouble(dec.doubleValue());
        }
        if (number instanceof Float) {
            return XDataType.makeFloat(dec.floatValue());
        }
        if (number instanceof IntNum) {
            return XIntegerType.integerType.cast(dec);
        }
        return dec;
    }

    public static Object roundHalfToEven(Object value) {
        return NumberValue.roundHalfToEven(value, IntNum.zero());
    }
}

