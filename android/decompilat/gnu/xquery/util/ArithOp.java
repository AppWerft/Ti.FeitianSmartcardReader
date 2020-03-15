// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.math.DFloNum;
import gnu.math.RealNum;
import gnu.math.Unit;
import gnu.math.Duration;
import gnu.kawa.functions.MultiplyOp;
import java.math.MathContext;
import java.math.BigDecimal;
import gnu.math.Numeric;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.AddOp;
import gnu.math.IntNum;
import gnu.xml.TextUtils;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.KNode;
import gnu.mapping.Values;
import gnu.mapping.Procedure;
import java.math.BigInteger;
import gnu.mapping.Procedure1or2;

public class ArithOp extends Procedure1or2
{
    char op;
    static final BigInteger TEN;
    public static final ArithOp add;
    public static final ArithOp sub;
    public static final ArithOp mul;
    public static final ArithOp div;
    public static final ArithOp idiv;
    public static final ArithOp mod;
    public static final ArithOp plus;
    public static final ArithOp minus;
    
    ArithOp(final String name, final char op, final int nargs) {
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
                final int code1 = Arithmetic.classifyValue(arg1);
                switch (code1) {
                    case 9: {
                        return XDataType.makeFloat(-Arithmetic.asFloat(arg1));
                    }
                    case 10: {
                        return XDataType.makeDouble(-Arithmetic.asDouble(arg1));
                    }
                    default: {
                        if (arg1 instanceof Numeric) {
                            return ((Numeric)arg1).neg();
                        }
                        return AddOp.apply2(-1, IntNum.zero(), arg1);
                    }
                }
                break;
            }
            default: {
                throw new UnsupportedOperationException(this.getName());
            }
        }
    }
    
    public static BigDecimal div(final BigDecimal d1, final BigDecimal d2) {
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
            default: {
                final int code1 = Arithmetic.classifyValue(arg1);
                final int code2 = Arithmetic.classifyValue(arg2);
                final int code3 = Arithmetic.leastSpecificCode(code1, code2);
                Label_0480: {
                    switch (this.op) {
                        case 'd': {
                            if (code3 == 0) {
                                break;
                            }
                            if (code3 <= 8) {
                                final BigDecimal d1 = (BigDecimal)XDataType.decimalType.cast(arg1);
                                final BigDecimal d2 = (BigDecimal)XDataType.decimalType.cast(arg2);
                                return div(d1, d2);
                            }
                            if (code3 == 9) {
                                return new Float(((Number)arg1).floatValue() / ((Number)arg2).floatValue());
                            }
                            if (code3 == 10) {
                                return new Double(((Number)arg1).doubleValue() / ((Number)arg2).doubleValue());
                            }
                            if (arg1 instanceof Duration && arg2 instanceof Duration) {
                                final Duration dur1 = (Duration)arg1;
                                final Duration dur2 = (Duration)arg2;
                                if (dur1.unit() == Unit.second && dur2.unit() == Unit.second) {
                                    final long s1 = dur1.getTotalSeconds();
                                    final long s2 = dur2.getTotalSeconds();
                                    final int n1 = dur1.getNanoSecondsOnly();
                                    final int n2 = dur2.getNanoSecondsOnly();
                                    final BigDecimal sec1 = TimeUtils.secondsBigDecimalFromDuration(s1, n1);
                                    final BigDecimal sec2 = TimeUtils.secondsBigDecimalFromDuration(s2, n2);
                                    return div(sec1, sec2);
                                }
                                if (dur1.unit() == Unit.month && dur2.unit() == Unit.month) {
                                    final BigDecimal m1 = BigDecimal.valueOf(dur1.getTotalMonths());
                                    final BigDecimal m2 = BigDecimal.valueOf(dur2.getTotalMonths());
                                    return div(m1, m2);
                                }
                                throw new ArithmeticException("divide of incompatible durations");
                            }
                            else {
                                if (code3 != 0) {
                                    return Arithmetic.asNumeric(arg1).div(Arithmetic.asNumeric(arg2));
                                }
                                break Label_0480;
                            }
                            break;
                        }
                        case 'i': {
                            if (code3 == 0) {
                                break;
                            }
                            if (code3 <= 6) {
                                final IntNum i1 = Arithmetic.asIntNum(arg1);
                                final IntNum i2 = Arithmetic.asIntNum(arg2);
                                return IntNum.quotient(i1, i2);
                            }
                            if (code3 <= 8) {
                                final BigDecimal d1 = (BigDecimal)XDataType.decimalType.cast(arg1);
                                final BigDecimal d2 = (BigDecimal)XDataType.decimalType.cast(arg2);
                                return Arithmetic.asIntNum(d1.divide(d2, 0, 1));
                            }
                            if (code3 <= 9) {
                                final float f = ((Number)arg1).floatValue() / ((Number)arg2).floatValue();
                                return RealNum.toExactInt(f, 3);
                            }
                            final double d3 = ((Number)arg1).doubleValue() / ((Number)arg2).doubleValue();
                            return RealNum.toExactInt(d3, 3);
                        }
                        case 'm': {
                            if (code3 == 0) {
                                break;
                            }
                            if (code3 <= 6) {
                                final IntNum i1 = Arithmetic.asIntNum(arg1);
                                final IntNum i2 = Arithmetic.asIntNum(arg2);
                                return IntNum.remainder(i1, i2);
                            }
                            if (code3 <= 8) {
                                return ArithOp.sub.apply2(arg1, ArithOp.mul.apply2(ArithOp.idiv.apply2(arg1, arg2), arg2));
                            }
                            if (code3 <= 9) {
                                final float f2 = Arithmetic.asFloat(arg1);
                                final float f3 = Arithmetic.asFloat(arg2);
                                return XDataType.makeFloat(f2 % f3);
                            }
                            if (code3 > 11) {
                                break;
                            }
                            final double d4 = Arithmetic.asDouble(arg1);
                            final double d5 = Arithmetic.asDouble(arg2);
                            final double d6 = d4 % d5;
                            if (code3 == 11) {
                                return DFloNum.valueOf(d6);
                            }
                            return XDataType.makeDouble(d6);
                        }
                    }
                }
                throw new UnsupportedOperationException(this.getName());
            }
        }
    }
    
    static {
        TEN = BigInteger.valueOf(10L);
        add = new ArithOp("+", '+', 2);
        sub = new ArithOp("-", '-', 2);
        mul = new ArithOp("*", '*', 2);
        div = new ArithOp("div", 'd', 2);
        idiv = new ArithOp("idiv", 'i', 2);
        mod = new ArithOp("mod", 'm', 2);
        plus = new ArithOp("+", 'P', 1);
        minus = new ArithOp("-", 'M', 1);
    }
}
