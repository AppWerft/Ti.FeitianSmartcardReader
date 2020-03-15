// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.kawa.xml.XIntegerType;
import gnu.math.IntNum;
import gnu.kawa.functions.Arithmetic;
import java.math.BigDecimal;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.xml.TextUtils;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.KNode;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.mapping.Procedure1;

public class NumberValue extends Procedure1
{
    public static final NumberValue numberValue;
    public static final Double NaN;
    
    public static boolean isNaN(final Object arg) {
        return (arg instanceof Double || arg instanceof Float || arg instanceof DFloNum) && Double.isNaN(((Number)arg).doubleValue());
    }
    
    @Override
    public Object apply1(final Object arg) {
        if (arg != Values.empty && arg != null) {
            try {
                return numberValue(arg);
            }
            catch (Exception ex) {}
        }
        return NumberValue.NaN;
    }
    
    public static Number numberCast(Object value) {
        if (value == Values.empty || value == null) {
            return null;
        }
        if (value instanceof Values) {
            final Values vals = (Values)value;
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
        value = KNode.atomicValue(value);
        Label_0038: {
            if (!(value instanceof UntypedAtomic)) {
                if (!(value instanceof String)) {
                    break Label_0038;
                }
            }
            try {
                return XDataType.doubleType.valueOf(TextUtils.stringValue(value));
            }
            catch (Exception ex) {
                final double d = Double.NaN;
                return XDataType.makeDouble(d);
            }
        }
        double d;
        if (value instanceof Number && (value instanceof RealNum || !(value instanceof Numeric))) {
            d = ((Number)value).doubleValue();
        }
        else {
            d = Double.NaN;
        }
        return XDataType.makeDouble(d);
    }
    
    public static Object abs(Object value) {
        if (value == null || value == Values.empty) {
            return value;
        }
        value = numberCast(value);
        if (value instanceof Double) {
            final Double d = (Double)value;
            double x = d;
            long bits = Double.doubleToRawLongBits(x);
            if (bits >= 0L) {
                return d;
            }
            bits &= Long.MAX_VALUE;
            x = Double.longBitsToDouble(bits);
            return x;
        }
        else if (value instanceof Float) {
            final Float d2 = (Float)value;
            float x2 = d2;
            int bits2 = Float.floatToRawIntBits(x2);
            if (bits2 >= 0) {
                return d2;
            }
            bits2 &= Integer.MAX_VALUE;
            x2 = Float.intBitsToFloat(bits2);
            return x2;
        }
        else {
            if (value instanceof BigDecimal) {
                BigDecimal dec = (BigDecimal)value;
                if (dec.signum() < 0) {
                    dec = dec.negate();
                }
                return dec;
            }
            return ((Numeric)value).abs();
        }
    }
    
    public static Object floor(final Object val) {
        final Number value = numberCast(val);
        if (value == null) {
            return val;
        }
        if (value instanceof Double) {
            return XDataType.makeDouble(Math.floor((double)value));
        }
        if (value instanceof Float) {
            return XDataType.makeFloat((float)Math.floor((float)value));
        }
        if (value instanceof BigDecimal) {
            final BigDecimal dec = (BigDecimal)value;
            return Arithmetic.asIntNum(dec.divide(XDataType.DECIMAL_ONE, 0, 3).toBigInteger());
        }
        return ((RealNum)value).toInt(1);
    }
    
    public static Object ceiling(final Object val) {
        final Number value = numberCast(val);
        if (value == null) {
            return val;
        }
        if (value instanceof Double) {
            return XDataType.makeDouble(Math.ceil((double)value));
        }
        if (value instanceof Float) {
            return XDataType.makeFloat((float)Math.ceil((float)value));
        }
        if (value instanceof BigDecimal) {
            final BigDecimal dec = (BigDecimal)value;
            return Arithmetic.asIntNum(dec.divide(XDataType.DECIMAL_ONE, 0, 2).toBigInteger());
        }
        return ((RealNum)value).toInt(2);
    }
    
    public static Object round(final Object arg) {
        final Number value = numberCast(arg);
        if (value == null) {
            return arg;
        }
        if (value instanceof Double) {
            double val = (double)value;
            if (val >= -0.5 && val <= 0.0 && (val < 0.0 || Double.doubleToLongBits(val) < 0L)) {
                val = -0.0;
            }
            else {
                val = Math.floor(val + 0.5);
            }
            return XDataType.makeDouble(val);
        }
        if (value instanceof Float) {
            float val2 = (float)value;
            if (val2 >= -0.5 && val2 <= 0.0 && (val2 < 0.0 || Float.floatToIntBits(val2) < 0)) {
                val2 = -0.0f;
            }
            else {
                val2 = (float)Math.floor(val2 + 0.5);
            }
            return XDataType.makeFloat(val2);
        }
        if (value instanceof BigDecimal) {
            BigDecimal dec = (BigDecimal)value;
            final int mode = (dec.signum() >= 0) ? 4 : 5;
            dec = dec.divide(XDataType.DECIMAL_ONE, 0, mode);
            return Arithmetic.asIntNum(dec.toBigInteger());
        }
        return ((RealNum)value).toInt(4);
    }
    
    public static Object roundHalfToEven(final Object value, final IntNum precision) {
        final Number number = numberCast(value);
        if (number == null) {
            return value;
        }
        if (value instanceof Double || value instanceof Float) {
            final double v = ((Number)value).doubleValue();
            if (v == 0.0 || Double.isInfinite(v) || Double.isNaN(v)) {
                return value;
            }
        }
        BigDecimal dec = (BigDecimal)XDataType.decimalType.cast(number);
        final int prec = precision.intValue();
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
    
    public static Object roundHalfToEven(final Object value) {
        return roundHalfToEven(value, IntNum.zero());
    }
    
    static {
        numberValue = new NumberValue();
        NaN = new Double(Double.NaN);
    }
}
