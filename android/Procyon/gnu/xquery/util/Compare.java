// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.mapping.Symbol;
import gnu.kawa.functions.NumberCompare;
import gnu.math.Unit;
import gnu.kawa.xml.XDataType;
import gnu.math.DFloNum;
import gnu.math.Duration;
import gnu.kawa.xml.XTimeType;
import gnu.math.DateTime;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.KNode;
import gnu.mapping.Values;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;

public class Compare extends Procedure2
{
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
    public static final Compare $Eq;
    public static final Compare $Ex$Eq;
    public static final Compare $Gr;
    public static final Compare $Gr$Eq;
    public static final Compare $Ls;
    public static final Compare $Ls$Eq;
    public static final Compare valEq;
    public static final Compare valNe;
    public static final Compare valGt;
    public static final Compare valGe;
    public static final Compare valLt;
    public static final Compare valLe;
    
    public static Compare make(final String name, final int flags) {
        final Compare proc = new Compare();
        proc.setName(name);
        proc.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateCompare");
        proc.flags = flags;
        return proc;
    }
    
    public static boolean apply(final int flags, final Object arg1, final Object arg2, final NamedCollator collator) {
        if (arg1 instanceof Values) {
            final Values values1 = (Values)arg1;
            int iter = 0;
            do {
                iter = values1.nextPos(iter);
                if (iter == 0) {
                    return false;
                }
            } while (!apply(flags, values1.getPosPrevious(iter), arg2, collator));
            return true;
        }
        if (arg2 instanceof Values) {
            final Values values2 = (Values)arg2;
            int iter = 0;
            do {
                iter = values2.nextPos(iter);
                if (iter == 0) {
                    return false;
                }
            } while (!apply(flags, arg1, values2.getPosPrevious(iter), collator));
            return true;
        }
        return atomicCompare(flags, KNode.atomicValue(arg1), KNode.atomicValue(arg2), collator);
    }
    
    public static boolean equalityComparison(final int flags) {
        return (flags & 0x10) != 0x0 == ((flags & 0x4) != 0x0);
    }
    
    public static boolean atomicCompare(final int flags, Object arg1, Object arg2, final NamedCollator collator) {
        if (arg1 instanceof UntypedAtomic) {
            final String str = arg1.toString();
            if ((flags & 0x20) != 0x0) {
                arg1 = str;
            }
            else if (arg2 instanceof DateTime) {
                arg1 = XTimeType.parseDateTime(str, ((DateTime)arg2).components());
            }
            else if (arg2 instanceof Duration) {
                arg1 = Duration.parse(str, ((Duration)arg2).unit());
            }
            else if (arg2 instanceof Number) {
                arg1 = new DFloNum(str);
            }
            else if (arg2 instanceof Boolean) {
                arg1 = XDataType.booleanType.valueOf(str);
            }
            else {
                arg1 = str;
            }
        }
        if (arg2 instanceof UntypedAtomic) {
            final String str = arg2.toString();
            if ((flags & 0x20) != 0x0) {
                arg2 = str;
            }
            else if (arg1 instanceof DateTime) {
                arg2 = XTimeType.parseDateTime(str, ((DateTime)arg1).components());
            }
            else if (arg1 instanceof Duration) {
                arg2 = Duration.parse(str, ((Duration)arg1).unit());
            }
            else if (arg1 instanceof Number) {
                arg2 = new DFloNum(str);
            }
            else if (arg1 instanceof Boolean) {
                arg2 = XDataType.booleanType.valueOf(str);
            }
            else {
                arg2 = str;
            }
        }
        if (arg1 instanceof Number || arg2 instanceof Number) {
            int comp;
            if (arg1 instanceof Duration) {
                if (!(arg2 instanceof Duration)) {
                    comp = -3;
                }
                else {
                    final Duration d1 = (Duration)arg1;
                    final Duration d2 = (Duration)arg2;
                    if ((d1.unit != d2.unit || d1.unit == Unit.duration) && !equalityComparison(flags)) {
                        comp = -3;
                    }
                    else {
                        comp = Duration.compare(d1, d2);
                    }
                }
            }
            else if (arg1 instanceof DateTime) {
                if (!(arg2 instanceof DateTime)) {
                    comp = -3;
                }
                else {
                    final DateTime d3 = (DateTime)arg1;
                    final DateTime d4 = (DateTime)arg2;
                    final int m1 = d3.components();
                    final int m2 = d4.components();
                    if (m1 != m2) {
                        comp = -3;
                    }
                    else if (!equalityComparison(flags) && m1 != 112 && m1 != 14 && m1 != 126) {
                        comp = -3;
                    }
                    else {
                        comp = DateTime.compare(d3, d4);
                    }
                }
            }
            else if (arg2 instanceof Duration || arg2 instanceof DateTime) {
                comp = -3;
            }
            else {
                comp = NumberCompare.compare(arg1, arg2, false);
            }
            if (comp == -3 && (flags & 0x40) == 0x0) {
                throw new IllegalArgumentException("values cannot be compared");
            }
            return NumberCompare.checkCompareCode(comp, flags);
        }
        else {
            int comp;
            if (arg1 instanceof Symbol) {
                if (arg2 instanceof Symbol && equalityComparison(flags)) {
                    comp = (arg1.equals(arg2) ? 0 : -2);
                }
                else {
                    comp = -3;
                }
            }
            else if (arg1 instanceof Boolean) {
                if (arg2 instanceof Boolean) {
                    final boolean b1 = (boolean)arg1;
                    final boolean b2 = (boolean)arg2;
                    comp = ((b1 == b2) ? 0 : (b2 ? -1 : 1));
                }
                else {
                    comp = -3;
                }
            }
            else if (arg2 instanceof Boolean || arg2 instanceof Symbol) {
                comp = -3;
            }
            else {
                final String str2 = arg1.toString();
                final String str3 = arg2.toString();
                if (collator != null) {
                    comp = collator.compare(str2, str3);
                }
                else {
                    comp = NamedCollator.codepointCompare(str2, str3);
                }
                comp = ((comp < 0) ? -1 : ((comp > 0) ? 1 : 0));
            }
            if (comp == -3 && (flags & 0x40) == 0x0) {
                throw new IllegalArgumentException("values cannot be compared");
            }
            return NumberCompare.checkCompareCode(comp, flags);
        }
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        if ((this.flags & 0x20) == 0x0) {
            return apply(this.flags, arg1, arg2, null) ? Boolean.TRUE : Boolean.FALSE;
        }
        if (arg1 == null || arg1 == Values.empty) {
            return arg1;
        }
        if (arg2 == null || arg2 == Values.empty) {
            return arg2;
        }
        return atomicCompare(this.flags, KNode.atomicValue(arg1), KNode.atomicValue(arg2), null) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    static {
        $Eq = make("=", 8);
        $Ex$Eq = make("!=", 23);
        $Gr = make(">", 16);
        $Gr$Eq = make(">=", 24);
        $Ls = make("<", 4);
        $Ls$Eq = make("<=", 12);
        valEq = make("eq", 40);
        valNe = make("ne", 55);
        valGt = make("gt", 48);
        valGe = make("ge", 56);
        valLt = make("lt", 36);
        valLe = make("le", 44);
    }
}
