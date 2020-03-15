// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.kawa.lispexpr.LangObjType;
import java.math.BigInteger;
import gnu.math.ULong;
import gnu.math.UInt;
import gnu.math.IntNum;
import gnu.mapping.PropertySet;
import gnu.mapping.Procedure;

public class BitwiseOp extends ArithOp
{
    public static final BitwiseOp and;
    public static final BitwiseOp ior;
    public static final BitwiseOp xor;
    public static final BitwiseOp ashift;
    public static final BitwiseOp ashiftl;
    public static final BitwiseOp ashiftr;
    public static final BitwiseOp not;
    
    public BitwiseOp(final String name, final int op) {
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
    
    public Object adjustResult(final IntNum value, final int code) {
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
            default: {
                return value;
            }
        }
    }
    
    @Override
    public Object apply1(final Object arg1) {
        if (this.op == 16) {
            final int code1 = Arithmetic.classifyValue(arg1);
            final IntNum iarg1 = LangObjType.coerceIntNum(arg1);
            return this.adjustResult(BitOps.not(iarg1), code1);
        }
        return this.apply2(this.defaultResult(), arg1);
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        final int kind1 = Arithmetic.classifyValue(arg1);
        final int kind2 = Arithmetic.classifyValue(arg2);
        final int kind3 = (this.op >= 9 && this.op <= 12 && kind1 != 0) ? kind1 : Arithmetic.leastSpecificCode(kind1, kind2);
        final IntNum iarg1 = LangObjType.coerceIntNum(arg1);
        final IntNum iarg2 = LangObjType.coerceIntNum(arg2);
        IntNum result = null;
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
                    checkNonNegativeShift(this, amount);
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
        return this.adjustResult(result, kind3);
    }
    
    @Override
    public Object applyN(final Object[] args) {
        final int alen = args.length;
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
    
    public static int checkNonNegativeShift(final Procedure proc, final int amount) {
        if (amount < 0) {
            throw new WrongType(proc, 2, amount, "non-negative integer");
        }
        return amount;
    }
    
    public static IntNum shiftLeft(final IntNum value, final int count) {
        return IntNum.shift(value, checkNonNegativeShift(BitwiseOp.ashiftl, count));
    }
    
    public static IntNum shiftRight(final IntNum value, final int count) {
        return IntNum.shift(value, -checkNonNegativeShift(BitwiseOp.ashiftr, count));
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
    
    static {
        and = new BitwiseOp("bitwise-and", 13);
        ior = new BitwiseOp("bitwise-ior", 14);
        xor = new BitwiseOp("bitwise-xor", 15);
        ashift = new BitwiseOp("bitwise-arithmetic-shift", 9);
        ashiftl = new BitwiseOp("bitwise-arithmetic-shift-left", 10);
        ashiftr = new BitwiseOp("bitwise-arithmetic-shift-right", 11);
        not = new BitwiseOp("bitwise-not", 16);
    }
}
