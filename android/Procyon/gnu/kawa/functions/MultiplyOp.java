// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import gnu.math.DFloNum;
import gnu.math.RatNum;
import gnu.math.ULong;
import gnu.math.UInt;
import gnu.mapping.Promise;
import gnu.math.IntNum;
import gnu.mapping.PropertySet;
import gnu.mapping.Procedure;

public class MultiplyOp extends ArithOp
{
    public static final MultiplyOp $St;
    
    public MultiplyOp(final String name) {
        super(name, 3);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
        Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forMul");
    }
    
    @Override
    public Object defaultResult() {
        return IntNum.one();
    }
    
    public static Object apply(final Object arg1, final Object arg2) {
        final int code1 = Arithmetic.classifyValue(arg1);
        final int code2 = Arithmetic.classifyValue(arg2);
        return combine((Number)arg1, arg2, Arithmetic.leastSpecificCode(code1, code2));
    }
    
    @Override
    public Object applyN(final Object[] args) {
        final int len = args.length;
        if (len == 0) {
            return IntNum.one();
        }
        Number result = (Number)Promise.force(args[0]);
        int code = Arithmetic.classifyValue(result);
        for (int i = 1; i < len; ++i) {
            final Object arg2 = args[i];
            final int code2 = Arithmetic.classifyValue(arg2);
            code = Arithmetic.leastSpecificCode(code, code2);
            result = combine(result, arg2, code);
        }
        return result;
    }
    
    public static Number combine(Number result, final Object arg2, final int code) {
        switch (code) {
            case 1:
            case 2: {
                final int i1 = Arithmetic.asInt(result);
                final int i2 = Arithmetic.asInt(arg2);
                final int ir = i1 * i2;
                return (code == 1) ? Integer.valueOf(ir) : UInt.valueOf(ir);
            }
            case 3:
            case 4: {
                final long l1 = Arithmetic.asLong(result);
                final long l2 = Arithmetic.asLong(arg2);
                final long lr = l1 * l2;
                return (code == 3) ? Long.valueOf(lr) : ULong.valueOf(lr);
            }
            case 5: {
                final BigInteger bi1 = Arithmetic.asBigInteger(result);
                final BigInteger bi2 = Arithmetic.asBigInteger(arg2);
                result = bi1.multiply(bi2);
                break;
            }
            case 6: {
                result = IntNum.times(Arithmetic.asIntNum(result), Arithmetic.asIntNum(arg2));
                break;
            }
            case 7: {
                final BigDecimal bd1 = Arithmetic.asBigDecimal(result);
                final BigDecimal bd2 = Arithmetic.asBigDecimal(arg2);
                result = bd1.multiply(bd2);
                break;
            }
            case 8: {
                result = RatNum.times(Arithmetic.asRatNum(result), Arithmetic.asRatNum(arg2));
                break;
            }
            case 9: {
                final float f1 = Arithmetic.asFloat(result);
                final float f2 = Arithmetic.asFloat(arg2);
                result = new Float(f1 * f2);
                break;
            }
            case 10: {
                final double d1 = Arithmetic.asDouble(result);
                final double d2 = Arithmetic.asDouble(arg2);
                result = new Double(d1 * d2);
                break;
            }
            case 11: {
                final double d1 = Arithmetic.asDouble(result);
                final double d2 = Arithmetic.asDouble(arg2);
                result = new DFloNum(d1 * d2);
                break;
            }
            default: {
                result = Arithmetic.asNumeric(result).mul(Arithmetic.asNumeric(arg2));
                break;
            }
        }
        return result;
    }
    
    static {
        $St = new MultiplyOp("*");
    }
}
