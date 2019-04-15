/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.functions.ArithOp;
import gnu.kawa.functions.Arithmetic;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Symbol;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.math.UInt;
import gnu.math.ULong;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class DivideOp
extends ArithOp {
    int rounding_mode;
    public static final DivideOp $Sl = new DivideOp("/", 4);
    public static final DivideOp idiv = new DivideOp("idiv", 7);
    public static final DivideOp iceil = new DivideOp("iceil", 7);
    public static final DivideOp floorQuotient = new DivideOp("floor-quotient", 6);
    public static final DivideOp quotient = new DivideOp("quotient", 6);
    public static final DivideOp remainder = new DivideOp("remainder", 8);
    public static final DivideOp modulo = new DivideOp("modulo", 8);
    public static final DivideOp div = new DivideOp("div", 6);
    public static final DivideOp mod = new DivideOp("mod", 8);
    public static final DivideOp div0 = new DivideOp("div0", 6);
    public static final DivideOp mod0 = new DivideOp("mod0", 8);

    public int getRoundingMode() {
        return this.rounding_mode;
    }

    public DivideOp(String name, int op) {
        super(name, op);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
        Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forDiv");
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        int len = args.length;
        if (len == 0) {
            return IntNum.one();
        }
        Object result = args[0];
        if (len == 1) {
            return this.apply2(IntNum.one(), result);
        }
        for (int i = 1; i < len; ++i) {
            result = this.apply2(result, args[i]);
        }
        return result;
    }

    @Override
    public Object apply2(Object arg1, Object arg2) throws Throwable {
        int code;
        Number result;
        int code1 = Arithmetic.classifyValue(arg1);
        int code2 = Arithmetic.classifyValue(arg2);
        int scode = code = Arithmetic.leastSpecificCode(code1, code2);
        if (code < 6 && code != 0) {
            switch (this.op) {
                case 4: 
                case 5: {
                    code = 6;
                    scode = 6;
                    break;
                }
                default: {
                    if (this.rounding_mode == 3 && code >= 1 && code <= 3) break;
                    scode = 6;
                }
            }
        }
        if (this.op == 5 && code <= 12 && code != 0) {
            scode = 12;
            if (code != 10 && code != 9) {
                code = 11;
            }
        } else if (scode == 10 || scode == 9) {
            scode = 11;
            if (this.op == 7) {
                code = scode;
            }
        }
        block3 : switch (scode) {
            case 1: {
                int i1 = Arithmetic.asInt(arg1);
                int i2 = Arithmetic.asInt(arg2);
                switch (this.op) {
                    case 8: {
                        i1 %= i2;
                        break;
                    }
                    default: {
                        i1 /= i2;
                    }
                }
                result = i1;
                break;
            }
            case 2: 
            case 3: {
                long l1 = Arithmetic.asLong(arg1);
                long l2 = Arithmetic.asLong(arg2);
                if (scode == 2) {
                    l1 &= 0xFFFFFFFFL;
                    l2 &= 0xFFFFFFFFL;
                }
                switch (this.op) {
                    case 8: {
                        l1 %= l2;
                        break;
                    }
                    default: {
                        l1 /= l2;
                    }
                }
                if (scode == 2) {
                    result = UInt.valueOf((int)l1);
                    break;
                }
                result = l1;
                break;
            }
            case 6: {
                switch (this.op) {
                    default: {
                        result = IntNum.quotient(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2), this.getRoundingMode());
                        break block3;
                    }
                    case 8: {
                        result = IntNum.remainder(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2), this.getRoundingMode());
                        break block3;
                    }
                    case 4: 
                }
                result = RatNum.make(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2));
                scode = code = result instanceof IntNum ? 6 : 8;
                break;
            }
            case 7: {
                RoundingMode mround;
                BigDecimal bd1 = Arithmetic.asBigDecimal(arg1);
                BigDecimal bd2 = Arithmetic.asBigDecimal(arg2);
                int mprec = 0;
                switch (this.getRoundingMode()) {
                    case 1: {
                        mround = RoundingMode.FLOOR;
                        break;
                    }
                    case 2: {
                        mround = RoundingMode.CEILING;
                        break;
                    }
                    case 3: {
                        mround = RoundingMode.DOWN;
                        break;
                    }
                    case 5: {
                        mround = bd2.signum() < 0 ? RoundingMode.CEILING : RoundingMode.FLOOR;
                    }
                    default: {
                        mround = RoundingMode.HALF_EVEN;
                    }
                }
                MathContext mcontext = new MathContext(mprec, mround);
                switch (this.op) {
                    default: {
                        result = bd1.divide(bd2);
                        break block3;
                    }
                    case 6: {
                        result = bd1.divideToIntegralValue(bd2, mcontext);
                        break block3;
                    }
                    case 7: {
                        result = bd1.divideToIntegralValue(bd2, mcontext).toBigInteger();
                        scode = 5;
                        code = 5;
                        break block3;
                    }
                    case 8: 
                }
                result = bd1.remainder(bd2, mcontext);
                break;
            }
            case 11: {
                double d1 = Arithmetic.asDouble(arg1);
                double d2 = Arithmetic.asDouble(arg2);
                switch (this.op) {
                    default: {
                        result = DFloNum.valueOf(d1 / d2);
                        break block3;
                    }
                    case 6: {
                        result = RealNum.toInt(d1 / d2, this.getRoundingMode());
                        break block3;
                    }
                    case 7: {
                        result = RealNum.toExactInt(d1 / d2, this.getRoundingMode());
                        scode = 6;
                        code = 6;
                        break block3;
                    }
                    case 8: 
                }
                if (d2 != 0.0) {
                    d1 -= RealNum.toInt(d1 / d2, this.getRoundingMode()) * d2;
                }
                result = DFloNum.valueOf(d1);
                break;
            }
            default: {
                Numeric num1 = Arithmetic.asNumeric(arg1);
                Numeric num2 = Arithmetic.asNumeric(arg2);
                if (this.op == 8 && num2.isZero()) {
                    return num2.isExact() ? num1 : num1.toInexact();
                }
                Numeric numr = num1.div(num2);
                if (this.op == 8) {
                    numr = num1.sub(((RealNum)numr).toInt(this.getRoundingMode()).mul(num2));
                }
                switch (this.op) {
                    case 7: {
                        result = ((RealNum)numr).toExactInt(this.rounding_mode);
                        code = 6;
                        scode = 6;
                        break block3;
                    }
                    case 6: {
                        result = ((RealNum)numr).toInt(this.rounding_mode);
                        break block3;
                    }
                    case 5: {
                        result = numr.toInexact();
                        break block3;
                    }
                }
                result = numr;
            }
        }
        if (code != scode) {
            switch (code) {
                case 1: {
                    result = result.intValue();
                    break;
                }
                case 2: {
                    result = UInt.valueOf(result.intValue());
                    break;
                }
                case 3: {
                    result = result.longValue();
                    break;
                }
                case 4: {
                    result = ULong.valueOf(result.longValue());
                    break;
                }
                case 9: {
                    result = Float.valueOf(result.floatValue());
                    break;
                }
                case 10: {
                    result = result.doubleValue();
                    break;
                }
                case 5: {
                    result = Arithmetic.asBigInteger(result);
                }
            }
        }
        return result;
    }

    @Override
    public int numArgs() {
        return this.op == 4 ? -4095 : 8194;
    }

    static {
        DivideOp.idiv.rounding_mode = 3;
        DivideOp.iceil.rounding_mode = 2;
        DivideOp.quotient.rounding_mode = 3;
        DivideOp.floorQuotient.rounding_mode = 1;
        DivideOp.remainder.rounding_mode = 3;
        DivideOp.modulo.rounding_mode = 1;
        DivideOp.div.rounding_mode = 5;
        DivideOp.mod.rounding_mode = 5;
        DivideOp.div0.rounding_mode = 4;
        DivideOp.mod0.rounding_mode = 4;
    }
}

