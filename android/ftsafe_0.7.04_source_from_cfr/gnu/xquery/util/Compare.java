/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XTimeType;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.BaseUnit;
import gnu.math.DFloNum;
import gnu.math.DateTime;
import gnu.math.Duration;
import gnu.math.Unit;
import gnu.xquery.util.NamedCollator;

public class Compare
extends Procedure2 {
    static final int RESULT_GRT = 1;
    static final int RESULT_EQU = 0;
    static final int RESULT_LSS = -1;
    static final int RESULT_NAN = -2;
    static final int RESULT_NEQ = -3;
    static final int TRUE_IF_GRT = 16;
    static final int TRUE_IF_EQU = 8;
    static final int TRUE_IF_LSS = 4;
    static final int TRUE_IF_NAN = 2;
    static final int TRUE_IF_NEQ = 1;
    static final int VALUE_COMPARISON = 32;
    static final int LENIENT_COMPARISON = 64;
    static final int LENIENT_EQ = 72;
    int flags;
    public static final Compare $Eq = Compare.make("=", 8);
    public static final Compare $Ex$Eq = Compare.make("!=", 23);
    public static final Compare $Gr = Compare.make(">", 16);
    public static final Compare $Gr$Eq = Compare.make(">=", 24);
    public static final Compare $Ls = Compare.make("<", 4);
    public static final Compare $Ls$Eq = Compare.make("<=", 12);
    public static final Compare valEq = Compare.make("eq", 40);
    public static final Compare valNe = Compare.make("ne", 55);
    public static final Compare valGt = Compare.make("gt", 48);
    public static final Compare valGe = Compare.make("ge", 56);
    public static final Compare valLt = Compare.make("lt", 36);
    public static final Compare valLe = Compare.make("le", 44);

    public static Compare make(String name, int flags) {
        Compare proc = new Compare();
        proc.setName(name);
        proc.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateCompare");
        proc.flags = flags;
        return proc;
    }

    public static boolean apply(int flags, Object arg1, Object arg2, NamedCollator collator) {
        if (arg1 instanceof Values) {
            Values values1 = (Values)arg1;
            int iter = 0;
            do {
                if ((iter = values1.nextPos(iter)) != 0) continue;
                return false;
            } while (!Compare.apply(flags, values1.getPosPrevious(iter), arg2, collator));
            return true;
        }
        if (arg2 instanceof Values) {
            Values values2 = (Values)arg2;
            int iter = 0;
            do {
                if ((iter = values2.nextPos(iter)) != 0) continue;
                return false;
            } while (!Compare.apply(flags, arg1, values2.getPosPrevious(iter), collator));
            return true;
        }
        return Compare.atomicCompare(flags, KNode.atomicValue(arg1), KNode.atomicValue(arg2), collator);
    }

    public static boolean equalityComparison(int flags) {
        return (flags & 16) != 0 == ((flags & 4) != 0);
    }

    public static boolean atomicCompare(int flags, Object arg1, Object arg2, NamedCollator collator) {
        int comp;
        String str;
        if (arg1 instanceof UntypedAtomic) {
            str = arg1.toString();
            arg1 = (flags & 32) != 0 ? str : (arg2 instanceof DateTime ? XTimeType.parseDateTime(str, ((DateTime)arg2).components()) : (arg2 instanceof Duration ? Duration.parse(str, ((Duration)arg2).unit()) : (arg2 instanceof Number ? new DFloNum(str) : (arg2 instanceof Boolean ? XDataType.booleanType.valueOf(str) : str))));
        }
        if (arg2 instanceof UntypedAtomic) {
            str = arg2.toString();
            arg2 = (flags & 32) != 0 ? str : (arg1 instanceof DateTime ? XTimeType.parseDateTime(str, ((DateTime)arg1).components()) : (arg1 instanceof Duration ? Duration.parse(str, ((Duration)arg1).unit()) : (arg1 instanceof Number ? new DFloNum(str) : (arg1 instanceof Boolean ? XDataType.booleanType.valueOf(str) : str))));
        }
        if (arg1 instanceof Number || arg2 instanceof Number) {
            int comp2;
            if (arg1 instanceof Duration) {
                if (!(arg2 instanceof Duration)) {
                    comp2 = -3;
                } else {
                    Duration d1 = (Duration)arg1;
                    Duration d2 = (Duration)arg2;
                    comp2 = !(d1.unit == d2.unit && d1.unit != Unit.duration || Compare.equalityComparison(flags)) ? -3 : Duration.compare(d1, d2);
                }
            } else if (arg1 instanceof DateTime) {
                if (!(arg2 instanceof DateTime)) {
                    comp2 = -3;
                } else {
                    int m2;
                    DateTime d1 = (DateTime)arg1;
                    DateTime d2 = (DateTime)arg2;
                    int m1 = d1.components();
                    comp2 = m1 != (m2 = d2.components()) ? -3 : (!Compare.equalityComparison(flags) && m1 != 112 && m1 != 14 && m1 != 126 ? -3 : DateTime.compare(d1, d2));
                }
            } else {
                comp2 = arg2 instanceof Duration || arg2 instanceof DateTime ? -3 : NumberCompare.compare(arg1, arg2, false);
            }
            if (comp2 == -3 && (flags & 64) == 0) {
                throw new IllegalArgumentException("values cannot be compared");
            }
            return NumberCompare.checkCompareCode(comp2, flags);
        }
        if (arg1 instanceof Symbol) {
            comp = arg2 instanceof Symbol && Compare.equalityComparison(flags) ? (arg1.equals(arg2) ? 0 : -2) : -3;
        } else if (arg1 instanceof Boolean) {
            boolean b1;
            boolean b2;
            comp = arg2 instanceof Boolean ? ((b1 = ((Boolean)arg1).booleanValue()) == (b2 = ((Boolean)arg2).booleanValue()) ? 0 : (b2 ? -1 : 1)) : -3;
        } else if (arg2 instanceof Boolean || arg2 instanceof Symbol) {
            comp = -3;
        } else {
            String str1 = arg1.toString();
            String str2 = arg2.toString();
            comp = collator != null ? collator.compare(str1, str2) : NamedCollator.codepointCompare(str1, str2);
            int n = comp < 0 ? -1 : (comp = comp > 0 ? 1 : 0);
        }
        if (comp == -3 && (flags & 64) == 0) {
            throw new IllegalArgumentException("values cannot be compared");
        }
        return NumberCompare.checkCompareCode(comp, flags);
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        if ((this.flags & 32) != 0) {
            if (arg1 == null || arg1 == Values.empty) {
                return arg1;
            }
            if (arg2 == null || arg2 == Values.empty) {
                return arg2;
            }
            return Compare.atomicCompare(this.flags, KNode.atomicValue(arg1), KNode.atomicValue(arg2), null) ? Boolean.TRUE : Boolean.FALSE;
        }
        return Compare.apply(this.flags, arg1, arg2, null) ? Boolean.TRUE : Boolean.FALSE;
    }
}

