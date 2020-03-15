// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.math.Numeric;
import java.math.BigDecimal;
import java.math.BigInteger;
import gnu.math.RatNum;
import gnu.math.IntNum;
import gnu.mapping.Procedure;
import gnu.expr.Language;
import gnu.mapping.ProcedureN;

public class NumberCompare extends ProcedureN
{
    Language language;
    static final int RESULT_GRT = 1;
    static final int RESULT_EQU = 0;
    static final int RESULT_LSS = -1;
    static final int RESULT_NAN = -2;
    static final int RESULT_NEQ = -3;
    public static final int TRUE_IF_GRT = 16;
    public static final int TRUE_IF_EQU = 8;
    public static final int TRUE_IF_LSS = 4;
    public static final int TRUE_IF_NAN = 2;
    public static final int TRUE_IF_NEQ = 1;
    int flags;
    
    @Override
    public int numArgs() {
        return -4094;
    }
    
    public static boolean $Eq(final Object arg1, final Object arg2) {
        return apply2(8, arg1, arg2);
    }
    
    public static boolean $Gr(final Object arg1, final Object arg2) {
        return apply2(16, arg1, arg2);
    }
    
    public static boolean $Gr$Eq(final Object arg1, final Object arg2) {
        return apply2(24, arg1, arg2);
    }
    
    public static boolean $Ls(final Object arg1, final Object arg2) {
        return apply2(4, arg1, arg2);
    }
    
    public static boolean $Ls$Eq(final Object arg1, final Object arg2) {
        return apply2(12, arg1, arg2);
    }
    
    public static boolean $Eq$V(final Object arg1, final Object arg2, final Object arg3, final Object[] rest) {
        return $Eq(arg1, arg2) && $Eq(arg2, arg3) && (rest.length == 0 || ($Eq(arg3, rest[0]) && applyN(8, rest)));
    }
    
    public static boolean $Gr$V(final Object arg1, final Object arg2, final Object arg3, final Object[] rest) {
        return $Gr(arg1, arg2) && $Gr(arg2, arg3) && (rest.length == 0 || ($Gr(arg3, rest[0]) && applyN(16, rest)));
    }
    
    public static boolean $Gr$Eq$V(final Object arg1, final Object arg2, final Object arg3, final Object[] rest) {
        return $Gr$Eq(arg1, arg2) && $Gr$Eq(arg2, arg3) && (rest.length == 0 || ($Gr$Eq(arg3, rest[0]) && applyN(24, rest)));
    }
    
    public static boolean $Ls$V(final Object arg1, final Object arg2, final Object arg3, final Object[] rest) {
        return $Ls(arg1, arg2) && $Ls(arg2, arg3) && (rest.length == 0 || ($Ls(arg3, rest[0]) && applyN(4, rest)));
    }
    
    public static boolean $Ls$Eq$V(final Object arg1, final Object arg2, final Object arg3, final Object[] rest) {
        return $Ls$Eq(arg1, arg2) && $Ls$Eq(arg2, arg3) && (rest.length == 0 || ($Ls$Eq(arg3, rest[0]) && applyN(12, rest)));
    }
    
    public static NumberCompare make(final Language language, final String name, final int flags) {
        final NumberCompare proc = new NumberCompare();
        proc.language = language;
        proc.setName(name);
        proc.flags = flags;
        proc.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplySimpleBoolean");
        proc.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileNumberCompare");
        return proc;
    }
    
    protected final Language getLanguage() {
        return this.language;
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        return this.getLanguage().booleanObject(apply2(this.flags, arg1, arg2));
    }
    
    public static boolean apply2(final int flags, final Object arg1, final Object arg2) {
        return (1 << 3 + compareStrict(arg1, arg2, true) & flags) != 0x0;
    }
    
    public static boolean checkCompareCode(final int code, final int flags) {
        return (1 << 3 + code & flags) != 0x0;
    }
    
    public static boolean applyWithPromotion(final int flags, final Object arg1, final Object arg2) {
        return checkCompareCode(compareStrict(arg1, arg2, false), flags);
    }
    
    public static int compare(final Object arg1, final Object arg2, final boolean exact) {
        final int code1 = Arithmetic.classifyValue(arg1);
        final int code2 = Arithmetic.classifyValue(arg2);
        return compare(arg1, code1, arg2, code2, exact);
    }
    
    public static int compareStrict(final Object arg1, final Object arg2, final boolean exact) {
        final int code1 = Arithmetic.classifyValue(arg1);
        final int code2 = Arithmetic.classifyValue(arg2);
        final int r = compare(arg1, code1, arg2, code2, exact);
        if (r == -3) {
            throw new IllegalArgumentException("bad value for numeric compare");
        }
        return r;
    }
    
    public static int compare(final Object arg1, final int code1, final Object arg2, final int code2, final boolean exact) {
        final int code3 = Arithmetic.leastSpecificCode(code1, code2);
        if (code3 == 0) {
            return -3;
        }
        switch (code3) {
            case 1: {
                final int i1 = Arithmetic.asInt(arg1);
                final int i2 = Arithmetic.asInt(arg2);
                final int comp = (i1 < i2) ? -1 : ((i1 > i2) ? 1 : 0);
                return comp;
            }
            case 2:
            case 3:
            case 4: {
                long l1 = Arithmetic.asLong(arg1);
                long l2 = Arithmetic.asLong(arg2);
                if (code3 == 4) {
                    if (code1 == 1 && l1 < 0L) {
                        return -1;
                    }
                    if (code2 == 1 && l2 < 0L) {
                        return 1;
                    }
                    l1 += Long.MIN_VALUE;
                    l2 += Long.MIN_VALUE;
                }
                final int comp = (l1 < l2) ? -1 : ((l1 > l2) ? 1 : 0);
                return comp;
            }
            case 5: {
                final BigInteger bi1 = Arithmetic.asBigInteger(arg1);
                final BigInteger bi2 = Arithmetic.asBigInteger(arg2);
                final int comp = bi1.compareTo(bi2);
                return comp;
            }
            case 6: {
                final int comp = IntNum.compare(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2));
                return comp;
            }
            case 7: {
                final BigDecimal bd1 = Arithmetic.asBigDecimal(arg1);
                final BigDecimal bd2 = Arithmetic.asBigDecimal(arg2);
                final int comp = bd1.compareTo(bd2);
                return comp;
            }
            case 8: {
                final int comp = RatNum.compare(Arithmetic.asRatNum(arg1), Arithmetic.asRatNum(arg2));
                return comp;
            }
            case 9: {
                if (!exact || (code1 > 8 && code2 > 8)) {
                    final float f1 = Arithmetic.asFloat(arg1);
                    final float f2 = Arithmetic.asFloat(arg2);
                    final int comp = (f1 > f2) ? 1 : ((f1 < f2) ? -1 : ((f1 == f2) ? 0 : -2));
                    return comp;
                }
            }
            case 10:
            case 11: {
                if (!exact || (code1 > 8 && code2 > 8)) {
                    final double d1 = Arithmetic.asDouble(arg1);
                    final double d2 = Arithmetic.asDouble(arg2);
                    final int comp = (d1 > d2) ? 1 : ((d1 < d2) ? -1 : ((d1 == d2) ? 0 : -2));
                    return comp;
                }
                break;
            }
        }
        final Numeric num1 = Arithmetic.asNumeric(arg1);
        final Numeric num2 = Arithmetic.asNumeric(arg2);
        final int comp = num1.compare(num2);
        return comp;
    }
    
    static boolean applyN(final int flags, final Object[] args) {
        for (int i = 0; i < args.length - 1; ++i) {
            final Object arg1 = args[i];
            final Object arg2 = args[i + 1];
            if (!apply2(flags, arg1, arg2)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Object applyN(final Object[] args) {
        return this.getLanguage().booleanObject(applyN(this.flags, args));
    }
}
