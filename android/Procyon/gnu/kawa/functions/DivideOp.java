// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.math.Numeric;
import java.math.BigDecimal;
import gnu.math.ULong;
import gnu.math.RealNum;
import gnu.math.DFloNum;
import java.math.MathContext;
import java.math.RoundingMode;
import gnu.math.RatNum;
import gnu.math.UInt;
import gnu.math.IntNum;
import gnu.mapping.PropertySet;
import gnu.mapping.Procedure;

public class DivideOp extends ArithOp
{
    int rounding_mode;
    public static final DivideOp $Sl;
    public static final DivideOp idiv;
    public static final DivideOp iceil;
    public static final DivideOp floorQuotient;
    public static final DivideOp quotient;
    public static final DivideOp remainder;
    public static final DivideOp modulo;
    public static final DivideOp div;
    public static final DivideOp mod;
    public static final DivideOp div0;
    public static final DivideOp mod0;
    
    public int getRoundingMode() {
        return this.rounding_mode;
    }
    
    public DivideOp(final String name, final int op) {
        super(name, op);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
        Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forDiv");
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        final int len = args.length;
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
    public Object apply2(final Object arg1, final Object arg2) throws Throwable {
        final int code1 = Arithmetic.classifyValue(arg1);
        final int code2 = Arithmetic.classifyValue(arg2);
        int scode;
        int code3 = scode = Arithmetic.leastSpecificCode(code1, code2);
        if (code3 < 6 && code3 != 0) {
            switch (this.op) {
                case 4:
                case 5: {
                    code3 = (scode = 6);
                    break;
                }
                default: {
                    if (this.rounding_mode == 3 && code3 >= 1 && code3 <= 3) {
                        break;
                    }
                    scode = 6;
                    break;
                }
            }
        }
        if (this.op == 5 && code3 <= 12 && code3 != 0) {
            scode = 12;
            if (code3 != 10 && code3 != 9) {
                code3 = 11;
            }
        }
        else if (scode == 10 || scode == 9) {
            scode = 11;
            if (this.op == 7) {
                code3 = scode;
            }
        }
        Number result = null;
        Label_1043: {
            switch (scode) {
                case 1: {
                    int i1 = Arithmetic.asInt(arg1);
                    final int i2 = Arithmetic.asInt(arg2);
                    switch (this.op) {
                        case 8: {
                            i1 %= i2;
                            break;
                        }
                        default: {
                            i1 /= i2;
                            break;
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
                            break;
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
                            break Label_1043;
                        }
                        case 8: {
                            result = IntNum.remainder(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2), this.getRoundingMode());
                            break Label_1043;
                        }
                        case 4: {
                            result = RatNum.make(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2));
                            code3 = (scode = ((result instanceof IntNum) ? 6 : 8));
                            break Label_1043;
                        }
                    }
                    break;
                }
                case 7: {
                    final BigDecimal bd1 = Arithmetic.asBigDecimal(arg1);
                    final BigDecimal bd2 = Arithmetic.asBigDecimal(arg2);
                    final int mprec = 0;
                    RoundingMode mround = null;
                    Label_0620: {
                        switch (this.getRoundingMode()) {
                            case 1: {
                                mround = RoundingMode.FLOOR;
                                break Label_0620;
                            }
                            case 2: {
                                mround = RoundingMode.CEILING;
                                break Label_0620;
                            }
                            case 3: {
                                mround = RoundingMode.DOWN;
                                break Label_0620;
                            }
                            case 5: {
                                mround = ((bd2.signum() < 0) ? RoundingMode.CEILING : RoundingMode.FLOOR);
                                break;
                            }
                        }
                        mround = RoundingMode.HALF_EVEN;
                    }
                    final MathContext mcontext = new MathContext(mprec, mround);
                    switch (this.op) {
                        default: {
                            result = bd1.divide(bd2);
                            break Label_1043;
                        }
                        case 6: {
                            result = bd1.divideToIntegralValue(bd2, mcontext);
                            break Label_1043;
                        }
                        case 7: {
                            result = bd1.divideToIntegralValue(bd2, mcontext).toBigInteger();
                            scode = (code3 = 5);
                            break Label_1043;
                        }
                        case 8: {
                            result = bd1.remainder(bd2, mcontext);
                            break Label_1043;
                        }
                    }
                    break;
                }
                case 11: {
                    double d1 = Arithmetic.asDouble(arg1);
                    final double d2 = Arithmetic.asDouble(arg2);
                    switch (this.op) {
                        default: {
                            result = DFloNum.valueOf(d1 / d2);
                            break Label_1043;
                        }
                        case 6: {
                            result = RealNum.toInt(d1 / d2, this.getRoundingMode());
                            break Label_1043;
                        }
                        case 7: {
                            result = RealNum.toExactInt(d1 / d2, this.getRoundingMode());
                            scode = (code3 = 6);
                            break Label_1043;
                        }
                        case 8: {
                            if (d2 != 0.0) {
                                d1 -= RealNum.toInt(d1 / d2, this.getRoundingMode()) * d2;
                            }
                            result = DFloNum.valueOf(d1);
                            break Label_1043;
                        }
                    }
                    break;
                }
                default: {
                    final Numeric num1 = Arithmetic.asNumeric(arg1);
                    final Numeric num2 = Arithmetic.asNumeric(arg2);
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
                            code3 = (scode = 6);
                            break Label_1043;
                        }
                        case 6: {
                            result = ((RealNum)numr).toInt(this.rounding_mode);
                            break Label_1043;
                        }
                        case 5: {
                            result = numr.toInexact();
                            break Label_1043;
                        }
                        default: {
                            result = numr;
                            break Label_1043;
                        }
                    }
                    break;
                }
            }
        }
        if (code3 != scode) {
            switch (code3) {
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
                    result = result.floatValue();
                    break;
                }
                case 10: {
                    result = result.doubleValue();
                    break;
                }
                case 5: {
                    result = Arithmetic.asBigInteger(result);
                    break;
                }
            }
        }
        return result;
    }
    
    @Override
    public int numArgs() {
        return (this.op == 4) ? -4095 : 8194;
    }
    
    static {
        $Sl = new DivideOp("/", 4);
        idiv = new DivideOp("idiv", 7);
        iceil = new DivideOp("iceil", 7);
        floorQuotient = new DivideOp("floor-quotient", 6);
        quotient = new DivideOp("quotient", 6);
        remainder = new DivideOp("remainder", 8);
        modulo = new DivideOp("modulo", 8);
        div = new DivideOp("div", 6);
        mod = new DivideOp("mod", 8);
        div0 = new DivideOp("div0", 6);
        mod0 = new DivideOp("mod0", 8);
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
