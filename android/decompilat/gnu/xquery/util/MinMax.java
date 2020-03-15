// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.xml.TextUtils;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.KNode;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.Arithmetic;
import gnu.lists.Sequence;
import gnu.mapping.Values;

public class MinMax
{
    public static Object min(final Object arg, final NamedCollator collation) {
        return minMax(arg, false, collation);
    }
    
    public static Object max(final Object arg, final NamedCollator collation) {
        return minMax(arg, true, collation);
    }
    
    public static Object minMax(Object arg, final boolean returnMax, final NamedCollator collation) {
        if (!(arg instanceof Values)) {
            arg = convert(arg);
            Compare.atomicCompare(16, arg, arg, collation);
            return arg;
        }
        final Values tlist = (Values)arg;
        int pos = 0;
        final int flags = returnMax ? 16 : 4;
        Object cur = tlist.getPosNext(pos);
        if (cur == Sequence.eofValue) {
            return Values.empty;
        }
        Object result = convert(cur);
        while (true) {
            pos = tlist.nextPos(pos);
            cur = tlist.getPosNext(pos);
            if (cur == Sequence.eofValue) {
                return result;
            }
            cur = convert(cur);
            if (result instanceof Number || cur instanceof Number) {
                final int code1 = Arithmetic.classifyValue(result);
                final int code2 = Arithmetic.classifyValue(cur);
                final int rcode = NumberCompare.compare(result, code1, cur, code2, false);
                if (rcode == -3) {
                    throw new IllegalArgumentException("values cannot be compared");
                }
                final int code3 = Arithmetic.leastSpecificCode(code1, code2);
                boolean castNeeded;
                if (rcode == -2) {
                    result = NumberValue.NaN;
                    castNeeded = true;
                }
                else if (!NumberCompare.checkCompareCode(rcode, flags)) {
                    castNeeded = (code3 != code2);
                    result = cur;
                }
                else {
                    castNeeded = (code3 != code1);
                }
                if (!castNeeded) {
                    continue;
                }
                result = Arithmetic.convert(result, code3);
            }
            else {
                if (Compare.atomicCompare(flags, result, cur, collation)) {
                    continue;
                }
                result = cur;
            }
        }
    }
    
    static Object convert(Object arg) {
        arg = KNode.atomicValue(arg);
        if (arg instanceof UntypedAtomic) {
            arg = XDataType.doubleType.valueOf(TextUtils.stringValue(arg));
        }
        return arg;
    }
}
