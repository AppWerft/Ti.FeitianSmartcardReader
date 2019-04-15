/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XDataType;
import gnu.lists.Sequence;
import gnu.mapping.Values;
import gnu.xml.TextUtils;
import gnu.xquery.util.Compare;
import gnu.xquery.util.NamedCollator;
import gnu.xquery.util.NumberValue;

public class MinMax {
    public static Object min(Object arg, NamedCollator collation) {
        return MinMax.minMax(arg, false, collation);
    }

    public static Object max(Object arg, NamedCollator collation) {
        return MinMax.minMax(arg, true, collation);
    }

    public static Object minMax(Object arg, boolean returnMax, NamedCollator collation) {
        if (arg instanceof Values) {
            Values tlist = (Values)arg;
            int pos = 0;
            int flags = returnMax ? 16 : 4;
            Object cur = tlist.getPosNext(pos);
            if (cur == Sequence.eofValue) {
                return Values.empty;
            }
            Object result = MinMax.convert(cur);
            do {
                if ((cur = tlist.getPosNext(pos = tlist.nextPos(pos))) == Sequence.eofValue) {
                    return result;
                }
                cur = MinMax.convert(cur);
                if (result instanceof Number || cur instanceof Number) {
                    int code2;
                    boolean castNeeded;
                    int code1 = Arithmetic.classifyValue(result);
                    int rcode = NumberCompare.compare(result, code1, cur, code2 = Arithmetic.classifyValue(cur), false);
                    if (rcode == -3) {
                        throw new IllegalArgumentException("values cannot be compared");
                    }
                    int code = Arithmetic.leastSpecificCode(code1, code2);
                    if (rcode == -2) {
                        result = NumberValue.NaN;
                        castNeeded = true;
                    } else if (!NumberCompare.checkCompareCode(rcode, flags)) {
                        castNeeded = code != code2;
                        result = cur;
                    } else {
                        boolean bl = castNeeded = code != code1;
                    }
                    if (!castNeeded) continue;
                    result = Arithmetic.convert(result, code);
                    continue;
                }
                if (Compare.atomicCompare(flags, result, cur, collation)) continue;
                result = cur;
            } while (true);
        }
        arg = MinMax.convert(arg);
        Compare.atomicCompare(16, arg, arg, collation);
        return arg;
    }

    static Object convert(Object arg) {
        if ((arg = KNode.atomicValue(arg)) instanceof UntypedAtomic) {
            arg = (Double)XDataType.doubleType.valueOf(TextUtils.stringValue(arg));
        }
        return arg;
    }
}

