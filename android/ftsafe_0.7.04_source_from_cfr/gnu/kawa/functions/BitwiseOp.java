/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.functions.ArithOp;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.math.IntNum;
import gnu.math.UInt;
import gnu.math.ULong;
import java.math.BigInteger;

public class BitwiseOp
extends ArithOp {
    public static final BitwiseOp and = new BitwiseOp("bitwise-and", 13);
    public static final BitwiseOp ior = new BitwiseOp("bitwise-ior", 14);
    public static final BitwiseOp xor = new BitwiseOp("bitwise-xor", 15);
    public static final BitwiseOp ashift = new BitwiseOp("bitwise-arithmetic-shift", 9);
    public static final BitwiseOp ashiftl = new BitwiseOp("bitwise-arithmetic-shift-left", 10);
    public static final BitwiseOp ashiftr = new BitwiseOp("bitwise-arithmetic-shift-right", 11);
    public static final BitwiseOp not = new BitwiseOp("bitwise-not", 16);

    public BitwiseOp(String name, int op) {
        super(name, op);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
        Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forBitwise");
    }

    @Override
    public Object defaultResult() {
        if (this.op == 13) {
            return IntNum.minusOne();
        }
        return IntNum.zero();
    }

    public Object adjustResult(IntNum value, int code) {
        switch (code) {
            case 1: {
                return value.intValue();
            }
            case 2: {
                return UInt.valueOf(value.intValue());
            }
            case 3: {
                return value.longValue();
            }
            case 4: {
                return ULong.valueOf(value.longValue());
            }
            case 5: {
                return new BigInteger(value.toString());
            }
        }
        return value;
    }

    @Override
    public Object apply1(Object arg1) {
        if (this.op == 16) {
            int code1 = Arithmetic.classifyValue(arg1);
            IntNum iarg1 = LangObjType.coerceIntNum(arg1);
            return this.adjustResult(BitOps.not(iarg1), code1);
        }
        return this.apply2(this.defaultResult(), arg1);
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        IntNum result;
        int kind1 = Arithmetic.classifyValue(arg1);
        int kind2 = Arithmetic.classifyValue(arg2);
        int kind = this.op >= 9 && this.op <= 12 && kind1 != 0 ? kind1 : Arithmetic.leastSpecificCode(kind1, kind2);
        IntNum iarg1 = LangObjType.coerceIntNum(arg1);
        IntNum iarg2 = LangObjType.coerceIntNum(arg2);
        switch (this.op) {
            case 13: {
                result = BitOps.and(iarg1, iarg2);
                break;
            }
            case 14: {
                result = BitOps.ior(iarg1, iarg2);
                break;
            }
            case 15: {
                result = BitOps.xor(iarg1, iarg2);
                break;
            }
            case 9: 
            case 10: 
            case 11: {
                int amount = iarg2.intValue();
                if (this.op == 11 || this.op == 10) {
                    BitwiseOp.checkNonNegativeShift(this, amount);
                    if (this.op == 11) {
                        amount = -amount;
                    }
                }
                result = IntNum.shift(iarg1, amount);
                break;
            }
            default: {
                throw new Error();
            }
        }
        return this.adjustResult(result, kind);
    }

    @Override
    public Object applyN(Object[] args) {
        int alen = args.length;
        if (alen == 0) {
            return this.defaultResult();
        }
        if (alen == 1) {
            return this.apply1(args[0]);
        }
        Object r = args[0];
        for (int i = 1; i < alen; ++i) {
            r = this.apply2(r, args[i]);
        }
        return r;
    }

    public static int checkNonNegativeShift(Procedure proc, int amount) {
        if (amount < 0) {
            throw new WrongType(proc, 2, (Object)amount, "non-negative integer");
        }
        return amount;
    }

    public static IntNum shiftLeft(IntNum value, int count) {
        return IntNum.shift(value, BitwiseOp.checkNonNegativeShift(ashiftl, count));
    }

    public static IntNum shiftRight(IntNum value, int count) {
        return IntNum.shift(value, -BitwiseOp.checkNonNegativeShift(ashiftr, count));
    }

    @Override
    public int numArgs() {
        if (this.op >= 9 && this.op <= 12) {
            return 8194;
        }
        if (this.op == 16) {
            return 4097;
        }
        return -4096;
    }
}

