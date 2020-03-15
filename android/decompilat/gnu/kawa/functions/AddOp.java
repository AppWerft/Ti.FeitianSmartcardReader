// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.math.Numeric;
import java.math.BigDecimal;
import java.math.BigInteger;
import gnu.math.DFloNum;
import gnu.math.RatNum;
import gnu.math.IntNum;
import gnu.math.ULong;
import gnu.math.UInt;
import gnu.mapping.PropertySet;
import gnu.mapping.Procedure;

public class AddOp extends ArithOp
{
    int plusOrMinus;
    public static final AddOp $Pl;
    public static final AddOp $Mn;
    
    public AddOp(final String name, final int plusOrMinus) {
        super(name, (plusOrMinus > 0) ? 1 : 2);
        this.plusOrMinus = 1;
        this.plusOrMinus = plusOrMinus;
        final String compiler = (plusOrMinus > 0) ? "gnu.kawa.functions.CompileArith:$Pl" : "gnu.kawa.functions.CompileArith:$Mn";
        Procedure.compilerKey.set(this, compiler);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
    }
    
    public static Object apply2(final int plusOrMinus, final Object arg1, final Object arg2) {
        final int code1 = Arithmetic.classifyValue(arg1);
        final int code2 = Arithmetic.classifyValue(arg2);
        final int code3 = Arithmetic.leastSpecificCode(code1, code2);
        switch (code3) {
            case 1:
            case 2: {
                final int i1 = Arithmetic.asInt(arg1);
                final int i2 = Arithmetic.asInt(arg2);
                final int is = (plusOrMinus > 0) ? (i1 + i2) : (i1 - i2);
                return (code3 == 1) ? Integer.valueOf(is) : UInt.valueOf(is);
            }
            case 3:
            case 4: {
                final long l1 = Arithmetic.asLong(arg1);
                final long l2 = Arithmetic.asLong(arg2);
                final long ls = (plusOrMinus > 0) ? (l1 + l2) : (l1 - l2);
                return (code3 == 1) ? Long.valueOf(ls) : ULong.valueOf(ls);
            }
            case 5: {
                final BigInteger bi1 = Arithmetic.asBigInteger(arg1);
                final BigInteger bi2 = Arithmetic.asBigInteger(arg2);
                return (plusOrMinus > 0) ? bi1.add(bi2) : bi1.subtract(bi2);
            }
            case 6: {
                return IntNum.add(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2), plusOrMinus);
            }
            case 7: {
                final BigDecimal bd1 = Arithmetic.asBigDecimal(arg1);
                final BigDecimal bd2 = Arithmetic.asBigDecimal(arg2);
                return (plusOrMinus > 0) ? bd1.add(bd2) : bd1.subtract(bd2);
            }
            case 8: {
                return RatNum.add(Arithmetic.asRatNum(arg1), Arithmetic.asRatNum(arg2), plusOrMinus);
            }
            case 9: {
                final float f1 = Arithmetic.asFloat(arg1);
                final float f2 = Arithmetic.asFloat(arg2);
                return new Float((plusOrMinus > 0) ? (f1 + f2) : (f1 - f2));
            }
            case 10: {
                final double d1 = Arithmetic.asDouble(arg1);
                final double d2 = Arithmetic.asDouble(arg2);
                return new Double((plusOrMinus > 0) ? (d1 + d2) : (d1 - d2));
            }
            case 11: {
                final double d1 = Arithmetic.asDouble(arg1);
                final double d2 = Arithmetic.asDouble(arg2);
                return new DFloNum((plusOrMinus > 0) ? (d1 + d2) : (d1 - d2));
            }
            default: {
                final Numeric num1 = Arithmetic.asNumeric(arg1);
                final Numeric num2 = Arithmetic.asNumeric(arg2);
                return num1.add(num2, plusOrMinus);
            }
        }
    }
    
    public static Object $Pl(final Object arg1, final Object arg2) {
        return apply2(1, arg1, arg2);
    }
    
    public static Object $Mn(final Object arg1, final Object arg2) {
        return apply2(-1, arg1, arg2);
    }
    
    public static Object $Mn(final Object arg1) {
        final int code = Arithmetic.classifyValue(arg1);
        switch (code) {
            case 1: {
                return -Arithmetic.asInt(arg1);
            }
            case 2: {
                return UInt.valueOf(-Arithmetic.asInt(arg1));
            }
            case 3: {
                return -Arithmetic.asLong(arg1);
            }
            case 4: {
                return ULong.valueOf(-Arithmetic.asLong(arg1));
            }
            case 5: {
                return Arithmetic.asBigInteger(arg1).negate();
            }
            case 6: {
                return IntNum.neg(Arithmetic.asIntNum(arg1));
            }
            case 7: {
                return Arithmetic.asBigDecimal(arg1).negate();
            }
            case 8: {
                return RatNum.neg(Arithmetic.asRatNum(arg1));
            }
            case 9: {
                return new Float(-Arithmetic.asFloat(arg1));
            }
            case 10: {
                return new Double(-Arithmetic.asDouble(arg1));
            }
            case 11: {
                return new DFloNum(-Arithmetic.asDouble(arg1));
            }
            default: {
                return Arithmetic.asNumeric(arg1).neg();
            }
        }
    }
    
    public static Object $Pl$V(final Object arg1, final Object arg2, final Object arg3, final Object[] rest) {
        return applyN(1, apply2(1, apply2(1, arg1, arg2), arg3), rest);
    }
    
    public static Object $Mn$V(final Object arg1, final Object arg2, final Object arg3, final Object[] rest) {
        return applyN(-1, apply2(-1, apply2(-1, arg1, arg2), arg3), rest);
    }
    
    public static Object applyN(final int plusOrMinus, final Object[] args) {
        final int len = args.length;
        if (len == 0) {
            return IntNum.zero();
        }
        Object result = args[0];
        if (len == 1 && plusOrMinus < 0) {
            return $Mn(result);
        }
        for (int i = 1; i < len; ++i) {
            result = apply2(plusOrMinus, result, args[i]);
        }
        return result;
    }
    
    public static Object applyN(final int plusOrMinus, final Object init, final Object[] args) {
        final int len = args.length;
        Object result = init;
        for (int i = 0; i < len; ++i) {
            result = apply2(plusOrMinus, result, args[i]);
        }
        return result;
    }
    
    @Override
    public Object applyN(final Object[] args) {
        return applyN(this.plusOrMinus, args);
    }
    
    static {
        $Pl = new AddOp("+", 1);
        $Mn = new AddOp("-", -1);
    }
}
