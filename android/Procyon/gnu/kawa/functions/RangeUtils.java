// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.math.RealNum;
import gnu.kawa.lispexpr.LangObjType;
import gnu.math.IntNum;
import gnu.lists.Range;

public class RangeUtils
{
    public static Range<?> valueOfUnbounded(final Object start, final Object step) {
        final IntNum iistart = IntNum.asIntNumOrNull(start);
        final IntNum iistep = IntNum.asIntNumOrNull(step);
        if (iistart != null && iistart.inIntRange() && iistep.inIntRange()) {
            return new Range.IntRange(iistart.intValue(), iistep.intValue());
        }
        return new Range<Object>(start, step, -1);
    }
    
    public static Range<?> upto(final Object start, final Object step, final Object end, final boolean orEqual) throws Throwable {
        final IntNum iistart = IntNum.asIntNumOrNull(start);
        final RealNum rstep = LangObjType.coerceRealNum(step);
        if (rstep.sign() <= 0) {
            throw new ClassCastException("step value " + rstep + " is not positive");
        }
        final IntNum iistep = (rstep instanceof IntNum) ? ((IntNum)rstep) : null;
        final IntNum iiend = IntNum.asIntNumOrNull(end);
        if (iistart != null && iiend != null && iistep != null && iistart.inIntRange() && IntNum.compare(iistep, 2147483647L) <= 0) {
            return Range.upto(iistart, iistep, iiend, orEqual);
        }
        Object size = AddOp.$Mn(end, start);
        if (iistep == null || !iistep.isOne()) {
            size = (orEqual ? DivideOp.idiv : DivideOp.iceil).apply2(size, step);
        }
        if (size instanceof Number) {
            return new Range<Object>(start, step, ((Number)size).intValue() + (orEqual ? 1 : 0));
        }
        throw new IndexOutOfBoundsException("start index " + start + " is greater than end index " + end);
    }
    
    public static Range<?> downto(final Object start, final Object step, final Object end, final boolean orEqual) throws Throwable {
        final IntNum iistart = IntNum.asIntNumOrNull(start);
        final RealNum rstep = LangObjType.coerceRealNum(step);
        if (rstep.sign() >= 0) {
            throw new ClassCastException("step value " + rstep + " is not negative");
        }
        final IntNum iistep = (rstep instanceof IntNum) ? ((IntNum)rstep) : null;
        final IntNum iiend = IntNum.asIntNumOrNull(end);
        if (iistart != null && iiend != null && iistep != null && iistart.inIntRange() && IntNum.compare(iistep, -2147483648L) >= 0) {
            return Range.downto(iistart, iistep, iiend, orEqual);
        }
        Object size = AddOp.$Mn(start, end);
        if (iistep == null || !iistep.isMinusOne()) {
            size = (orEqual ? DivideOp.idiv : DivideOp.iceil).apply2(size, AddOp.$Mn(step));
        }
        if (size instanceof Number) {
            return new Range<Object>(start, step, ((Number)size).intValue() + (orEqual ? 1 : 0));
        }
        throw new IndexOutOfBoundsException("start index " + start + " is greater than end index " + end);
    }
    
    public static Range<?> bySize(final Object start, final Object step, final Object size) throws Throwable {
        final IntNum iistart = IntNum.asIntNumOrNull(start);
        final RealNum rstep = LangObjType.coerceRealNum(step);
        final IntNum iistep = (rstep instanceof IntNum) ? ((IntNum)rstep) : null;
        final IntNum iisize = LangObjType.coerceIntNum(size);
        if (!iisize.inRange(0L, 2147483647L)) {
            new IndexOutOfBoundsException("invalid size (negative or too big)");
        }
        final int isize = iisize.intValue();
        if (iistart != null && iistep != null && iistart.inIntRange() && iistep.inIntRange()) {
            return new Range.IntRange(iistart.intValue(), iistep.intValue(), isize);
        }
        return new Range<Object>(start, rstep, isize);
    }
}
