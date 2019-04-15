/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1or2;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.Duration;
import gnu.math.IntNum;
import gnu.math.NamedUnit;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.math.Unit;
import gnu.xml.TextUtils;
import gnu.xquery.util.TimeUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class ArithOp
extends Procedure1or2 {
    char op;
    static final BigInteger TEN = BigInteger.valueOf(10L);
    public static final ArithOp add = new ArithOp("+", '+', 2);
    public static final ArithOp sub = new ArithOp("-", '-', 2);
    public static final ArithOp mul = new ArithOp("*", '*', 2);
    public static final ArithOp div = new ArithOp("div", 'd', 2);
    public static final ArithOp idiv = new ArithOp("idiv", 'i', 2);
    public static final ArithOp mod = new ArithOp("mod", 'm', 2);
    public static final ArithOp plus = new ArithOp("+", 'P', 1);
    public static final ArithOp minus = new ArithOp("-", 'M', 1);

    ArithOp(String name, char op, int nargs) {
        super(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateArithOp");
        this.op = op;
    }

    @Override
    public Object apply1(Object arg1) throws Throwable {
        if (arg1 == Values.empty || arg1 == null) {
            return arg1;
        }
        if (arg1 instanceof KNode || arg1 instanceof UntypedAtomic) {
            arg1 = XDataType.doubleType.valueOf(TextUtils.stringValue(arg1));
        }
        switch (this.op) {
            case 'P': {
                return AddOp.apply2(1, IntNum.zero(), arg1);
            }
            case 'M': {
                int code1 = Arithmetic.classifyValue(arg1);
                switch (code1) {
                    case 9: {
                        return XDataType.makeFloat(-Arithmetic.asFloat(arg1));
                    }
                    case 10: {
                        return XDataType.makeDouble(-Arithmetic.asDouble(arg1));
                    }
                }
                if (arg1 instanceof Numeric) {
                    return ((Numeric)arg1).neg();
                }
                return AddOp.apply2(-1, IntNum.zero(), arg1);
            }
        }
        throw new UnsupportedOperationException(this.getName());
    }

    public static BigDecimal div(BigDecimal d1, BigDecimal d2) {
        return d1.divide(d2, MathContext.DECIMAL128);
    }

    @Override
    public Object apply2(Object arg1, Object arg2) throws Throwable {
        if (arg1 == Values.empty || arg1 == null) {
            return arg1;
        }
        if (arg2 == Values.empty || arg2 == null) {
            return arg2;
        }
        if (arg1 instanceof KNode || arg1 instanceof UntypedAtomic) {
            arg1 = XDataType.doubleType.valueOf(TextUtils.stringValue(arg1));
        }
        if (arg2 instanceof KNode || arg2 instanceof UntypedAtomic) {
            arg2 = XDataType.doubleType.valueOf(TextUtils.stringValue(arg2));
        }
        switch (this.op) {
            case '+': {
                return AddOp.apply2(1, arg1, arg2);
            }
            case '-': {
                return AddOp.apply2(-1, arg1, arg2);
            }
            case '*': {
                return MultiplyOp.$St.apply2(arg1, arg2);
            }
        }
        int code1 = Arithmetic.classifyValue(arg1);
        int code2 = Arithmetic.classifyValue(arg2);
        int code = Arithmetic.leastSpecificCode(code1, code2);
        switch (this.op) {
            case 'd': {
                if (code == 0) break;
                if (code <= 8) {
                    BigDecimal d1 = (BigDecimal)XDataType.decimalType.cast(arg1);
                    BigDecimal d2 = (BigDecimal)XDataType.decimalType.cast(arg2);
                    return ArithOp.div(d1, d2);
                }
                if (code == 9) {
                    return new Float(((Number)arg1).floatValue() / ((Number)arg2).floatValue());
                }
                if (code == 10) {
                    return new Double(((Number)arg1).doubleValue() / ((Number)arg2).doubleValue());
                }
                if (arg1 instanceof Duration && arg2 instanceof Duration) {
                    Duration dur1 = (Duration)arg1;
                    Duration dur2 = (Duration)arg2;
                    if (dur1.unit() == Unit.second && dur2.unit() == Unit.second) {
                        long s1 = dur1.getTotalSeconds();
                        long s2 = dur2.getTotalSeconds();
                        int n1 = dur1.getNanoSecondsOnly();
                        int n2 = dur2.getNanoSecondsOnly();
                        BigDecimal sec1 = TimeUtils.secondsBigDecimalFromDuration(s1, n1);
                        BigDecimal sec2 = TimeUtils.secondsBigDecimalFromDuration(s2, n2);
                        return ArithOp.div(sec1, sec2);
                    }
                    if (dur1.unit() == Unit.month && dur2.unit() == Unit.month) {
                        BigDecimal m1 = BigDecimal.valueOf(dur1.getTotalMonths());
                        BigDecimal m2 = BigDecimal.valueOf(dur2.getTotalMonths());
                        return ArithOp.div(m1, m2);
                    }
                    throw new ArithmeticException("divide of incompatible durations");
                }
                if (code != 0) {
                    return Arithmetic.asNumeric(arg1).div(Arithmetic.asNumeric(arg2));
                }
            }
            case 'i': {
                if (code == 0) break;
                if (code <= 6) {
                    IntNum i1 = Arithmetic.asIntNum(arg1);
                    IntNum i2 = Arithmetic.asIntNum(arg2);
                    return IntNum.quotient(i1, i2);
                }
                if (code <= 8) {
                    BigDecimal d1 = (BigDecimal)XDataType.decimalType.cast(arg1);
                    BigDecimal d2 = (BigDecimal)XDataType.decimalType.cast(arg2);
                    return Arithmetic.asIntNum(d1.divide(d2, 0, 1));
                }
                if (code <= 9) {
                    float f = ((Number)arg1).floatValue() / ((Number)arg2).floatValue();
                    return RealNum.toExactInt(f, 3);
                }
                double d = ((Number)arg1).doubleValue() / ((Number)arg2).doubleValue();
                return RealNum.toExactInt(d, 3);
            }
            case 'm': {
                if (code == 0) break;
                if (code <= 6) {
                    IntNum i1 = Arithmetic.asIntNum(arg1);
                    IntNum i2 = Arithmetic.asIntNum(arg2);
                    return IntNum.remainder(i1, i2);
                }
                if (code <= 8) {
                    return sub.apply2(arg1, mul.apply2(idiv.apply2(arg1, arg2), arg2));
                }
                if (code <= 9) {
                    float f1 = Arithmetic.asFloat(arg1);
                    float f2 = Arithmetic.asFloat(arg2);
                    return XDataType.makeFloat(f1 % f2);
                }
                if (code > 11) break;
                double d1 = Arithmetic.asDouble(arg1);
                double d2 = Arithmetic.asDouble(arg2);
                double d = d1 % d2;
                if (code == 11) {
                    return DFloNum.valueOf(d);
                }
                return XDataType.makeDouble(d);
            }
        }
        throw new UnsupportedOperationException(this.getName());
    }
}

