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
import gnu.math.UInt;
import gnu.math.ULong;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AddOp
extends ArithOp {
    int plusOrMinus = 1;
    public static final AddOp $Pl = new AddOp("+", 1);
    public static final AddOp $Mn = new AddOp("-", -1);

    public AddOp(String name, int plusOrMinus) {
        super(name, plusOrMinus > 0 ? 1 : 2);
        this.plusOrMinus = plusOrMinus;
        String compiler = plusOrMinus > 0 ? "gnu.kawa.functions.CompileArith:$Pl" : "gnu.kawa.functions.CompileArith:$Mn";
        Procedure.compilerKey.set(this, compiler);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
    }

    public static Object apply2(int plusOrMinus, Object arg1, Object arg2) {
        int code1 = Arithmetic.classifyValue(arg1);
        int code2 = Arithmetic.classifyValue(arg2);
        int code = Arithmetic.leastSpecificCode(code1, code2);
        switch (code) {
            case 1: 
            case 2: {
                int i1 = Arithmetic.asInt(arg1);
                int i2 = Arithmetic.asInt(arg2);
                int is = plusOrMinus > 0 ? i1 + i2 : i1 - i2;
                return code == 1 ? Integer.valueOf(is) : UInt.valueOf(is);
            }
            case 3: 
            case 4: {
                long l1 = Arithmetic.asLong(arg1);
                long l2 = Arithmetic.asLong(arg2);
                long ls = plusOrMinus > 0 ? l1 + l2 : l1 - l2;
                return code == 1 ? Long.valueOf(ls) : ULong.valueOf(ls);
            }
            case 5: {
                BigInteger bi1 = Arithmetic.asBigInteger(arg1);
                BigInteger bi2 = Arithmetic.asBigInteger(arg2);
                return plusOrMinus > 0 ? bi1.add(bi2) : bi1.subtract(bi2);
            }
            case 6: {
                return IntNum.add(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2), plusOrMinus);
            }
            case 7: {
                BigDecimal bd1 = Arithmetic.asBigDecimal(arg1);
                BigDecimal bd2 = Arithmetic.asBigDecimal(arg2);
                return plusOrMinus > 0 ? bd1.add(bd2) : bd1.subtract(bd2);
            }
            case 8: {
                return RatNum.add(Arithmetic.asRatNum(arg1), Arithmetic.asRatNum(arg2), plusOrMinus);
            }
            case 9: {
                float f1 = Arithmetic.asFloat(arg1);
                float f2 = Arithmetic.asFloat(arg2);
                return new Float(plusOrMinus > 0 ? f1 + f2 : f1 - f2);
            }
            case 10: {
                double d1 = Arithmetic.asDouble(arg1);
                double d2 = Arithmetic.asDouble(arg2);
                return new Double(plusOrMinus > 0 ? d1 + d2 : d1 - d2);
            }
            case 11: {
                double d1 = Arithmetic.asDouble(arg1);
                double d2 = Arithmetic.asDouble(arg2);
                return new DFloNum(plusOrMinus > 0 ? d1 + d2 : d1 - d2);
            }
        }
        Numeric num1 = Arithmetic.asNumeric(arg1);
        Numeric num2 = Arithmetic.asNumeric(arg2);
        return num1.add(num2, plusOrMinus);
    }

    public static Object $Pl(Object arg1, Object arg2) {
        return AddOp.apply2(1, arg1, arg2);
    }

    public static Object $Mn(Object arg1, Object arg2) {
        return AddOp.apply2(-1, arg1, arg2);
    }

    public static Object $Mn(Object arg1) {
        int code = Arithmetic.classifyValue(arg1);
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
        }
        return Arithmetic.asNumeric(arg1).neg();
    }

    public static Object $Pl$V(Object arg1, Object arg2, Object arg3, Object[] rest) {
        return AddOp.applyN(1, AddOp.apply2(1, AddOp.apply2(1, arg1, arg2), arg3), rest);
    }

    public static Object $Mn$V(Object arg1, Object arg2, Object arg3, Object[] rest) {
        return AddOp.applyN(-1, AddOp.apply2(-1, AddOp.apply2(-1, arg1, arg2), arg3), rest);
    }

    public static Object applyN(int plusOrMinus, Object[] args) {
        int len = args.length;
        if (len == 0) {
            return IntNum.zero();
        }
        Object result = args[0];
        if (len == 1 && plusOrMinus < 0) {
            return AddOp.$Mn(result);
        }
        for (int i = 1; i < len; ++i) {
            result = AddOp.apply2(plusOrMinus, result, args[i]);
        }
        return result;
    }

    public static Object applyN(int plusOrMinus, Object init, Object[] args) {
        int len = args.length;
        Object result = init;
        for (int i = 0; i < len; ++i) {
            result = AddOp.apply2(plusOrMinus, result, args[i]);
        }
        return result;
    }

    @Override
    public Object applyN(Object[] args) {
        return AddOp.applyN(this.plusOrMinus, args);
    }
}

