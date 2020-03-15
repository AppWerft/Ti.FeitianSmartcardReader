// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.util.NoSuchElementException;
import gnu.text.Char;
import gnu.math.ULong;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;

public class Sequences
{
    public static List asSequenceOrNull(final Object value) {
        if (value instanceof List) {
            return (List)value;
        }
        if (value instanceof CharSequence) {
            final CharSequence cseq = (CharSequence)value;
            return new SubCharSeq(cseq, 0, cseq.length());
        }
        if (value instanceof Object[]) {
            return new FVector((Object[])value);
        }
        SimpleVector vec = null;
        if (value.getClass().isArray()) {
            if (value instanceof long[]) {
                vec = new S64Vector((long[])value);
            }
            else if (value instanceof int[]) {
                vec = new S32Vector((int[])value);
            }
            else if (value instanceof short[]) {
                vec = new S16Vector((short[])value);
            }
            else if (value instanceof byte[]) {
                vec = new S8Vector((byte[])value);
            }
            else if (value instanceof double[]) {
                vec = new F64Vector((double[])value);
            }
            else if (value instanceof float[]) {
                vec = new F32Vector((float[])value);
            }
            else if (value instanceof boolean[]) {
                vec = new BitVector((boolean[])value);
            }
            else if (value instanceof char[]) {
                vec = new CharVector((char[])value);
            }
            if (vec != null) {
                final SimpleVector simpleVector = vec;
                simpleVector.info |= 0x200000000L;
                return vec;
            }
        }
        return null;
    }
    
    public static IntSequence asIntSequenceOrNull(final Object value) {
        final List lst = asSequenceOrNull(value);
        if (lst == null) {
            return null;
        }
        if (lst instanceof IntSequence) {
            return (IntSequence)lst;
        }
        final int len = lst.size();
        final int[] arr = new int[len];
        int i = 0;
        for (final Object el : lst) {
            arr[i++] = ((Number)el).intValue();
        }
        return new S32Vector(arr);
    }
    
    public static List coerceToSequence(final Object value) {
        final List lst = asSequenceOrNull(value);
        if (lst == null) {
            String msg;
            if (value == null) {
                msg = "null is not a sequence";
            }
            else {
                msg = "cannot cast a " + value.getClass().getName() + " to a sequence";
            }
            throw new ClassCastException(msg);
        }
        return lst;
    }
    
    public static int getSize(final Object values) {
        if (values instanceof Object[]) {
            return ((Object[])values).length;
        }
        if (values instanceof CharSequence) {
            return ((CharSequence)values).length();
        }
        if (values instanceof List) {
            return ((List)values).size();
        }
        if (values.getClass().isArray()) {
            return Array.getLength(values);
        }
        throw new ClassCastException("value is neither List or array");
    }
    
    public static Iterator getIterator(final Object object) {
        if (object instanceof CharSequence) {
            return new CharacterIterator((CharSequence)object);
        }
        if (!(object instanceof Iterable)) {
            final List list = asSequenceOrNull(object);
            if (list != null) {
                return list.iterator();
            }
        }
        return ((Iterable)object).iterator();
    }
    
    public static Object subList(final Object base, final int fromIndex, int toIndex) {
        final List<?> lbase = (List<?>)base;
        if (toIndex == -1) {
            toIndex = lbase.size();
        }
        return lbase.subList(fromIndex, toIndex);
    }
    
    public static List indirectIndexed(final List lst, final IntSequence indexes) {
        return new IndirectIndexedSeq(lst, indexes);
    }
    
    public static Object drop(final Object base, final int count) {
        if (count >= 0) {
            return subList(base, count, -1);
        }
        return subList(base, 0, -count);
    }
    
    public static Object drop(final Object base, final int fromStart, final int fromEnd) {
        final List<?> lbase = (List<?>)base;
        return subList(base, fromStart, lbase.size() - fromEnd);
    }
    
    public static SimpleVector copy(final SimpleVector base, final int start, final int end, final boolean writable) {
        final int sz = end - start;
        if (!base.isVerySimple() && !base.isSubRange()) {
            return copy(base, new Range.IntRange(start, 1, sz), writable);
        }
        final SimpleVector nvec = base.newInstance(-1);
        long flags = 68719476736L;
        if (!writable) {
            flags |= 0x100000000L;
        }
        int baseStart;
        int baseSize;
        if (base.isVerySimple()) {
            baseStart = 0;
            baseSize = base.size();
        }
        else {
            baseStart = base.getOffsetBits();
            baseSize = base.getSizeBits();
        }
        final int off = baseStart + start;
        if (start < 0 || start > end || end > baseSize) {
            throw new IndexOutOfBoundsException();
        }
        nvec.setInfoField(sz, off, flags);
        base.info |= 0x400000000L;
        return nvec;
    }
    
    public static SimpleVector copy(final List base, final Range.IntRange range, final boolean writable) {
        if (base instanceof SimpleVector && range.getStepInt() == 1) {
            final SimpleVector svec = (SimpleVector<Object>)base;
            if (svec.isVerySimple() || svec.isSubRange()) {
                final int start = range.getStartInt();
                final int bsize = base.size();
                final int end = range.isUnbounded() ? bsize : (start + range.getSize());
                if (start < 0 || end > bsize) {
                    throw new IndexOutOfBoundsException();
                }
                return copy(svec, start, end, writable);
            }
        }
        return Arrays.flattenCopy(new IndirectIndexedSeq<Object>(base, range), writable);
    }
    
    private static Object bufferForCopy(Object obj) {
        while (!(obj instanceof SimpleVector)) {
            if (!(obj instanceof TransformedArray)) {
                return null;
            }
            obj = ((TransformedArray)obj).base;
        }
        return ((SimpleVector)obj).getBuffer();
    }
    
    public static boolean copyInPlaceIsSafe(final Object src, final Object dst) {
        final Object s = bufferForCopy(src);
        final Object d = bufferForCopy(dst);
        return s != d && s != null && d != null;
    }
    
    public static void replace(final List lst, int fromStart, final int fromEnd, final List values) {
        if (lst instanceof SimpleVector && values instanceof SimpleVector) {
            final SimpleVector svec = (SimpleVector)values;
            final SimpleVector dvec = (SimpleVector)lst;
            if (svec.getTag() == dvec.getTag()) {
                int srcLength = svec.size();
                final int dstLength = fromEnd - fromStart;
                final int grow = srcLength - dstLength;
                if (grow > 0) {
                    dvec.addSpace(fromEnd, grow);
                }
                final Object dbuffer = dvec.getBuffer();
                Object sbuffer = svec.getBuffer();
                final int dstart = dvec.getSegment(fromStart, srcLength);
                final int sstart;
                if (dstart >= 0 && (sstart = svec.getSegmentReadOnly(0, srcLength)) >= 0) {
                    System.arraycopy(sbuffer, sstart, dbuffer, dstart, srcLength);
                }
                else {
                    int srcStart = 0;
                    final boolean copied = dbuffer == sbuffer;
                    if (copied) {
                        sbuffer = svec.toDataArray();
                    }
                    while (srcLength > 0) {
                        int step = srcLength;
                        final long dresult = dvec.getSegment(fromStart);
                        final int dwhere = (int)dresult;
                        final int dsize = (int)(dresult >> 32);
                        if (dsize < step) {
                            step = dsize;
                        }
                        int swhere;
                        if (copied) {
                            swhere = srcStart;
                        }
                        else {
                            final long sresult = svec.getSegment(srcStart);
                            swhere = (int)sresult;
                            final int ssize = (int)(sresult >> 32);
                            if (ssize < step) {
                                step = ssize;
                            }
                        }
                        if (step == 0) {
                            throw new Error("zero step in replace loop!");
                        }
                        System.arraycopy(sbuffer, swhere, dbuffer, dwhere, step);
                        srcLength -= step;
                        srcStart += step;
                        fromStart += step;
                    }
                }
                if (grow < 0) {
                    dvec.delete(fromEnd + grow, fromEnd);
                }
                return;
            }
        }
        int oldSize = fromEnd - fromStart;
        final int newSize = values.size();
        final Object[] varray = values.toArray();
        int i = 0;
        for (final Object el : varray) {
            if (i < oldSize) {
                lst.set(fromStart + i, el);
            }
            else {
                lst.add(fromStart + i, el);
            }
            ++i;
        }
        if (i < oldSize) {
            if (lst instanceof AbstractSequence) {
                final AbstractSequence alst = (SimpleVector<Object>)lst;
                alst.removePos(alst.createPos(fromStart + i, false), oldSize - i);
            }
            else {
                while (i < oldSize) {
                    lst.remove(fromStart + i);
                    --oldSize;
                }
            }
        }
    }
    
    public static void writeUInt(final int value, final Consumer out) {
        if (value >= 0) {
            out.writeInt(value);
        }
        else {
            out.writeLong((long)value & 0xFFFFFFFFL);
        }
    }
    
    public static void writeULong(final long value, final Consumer out) {
        if (value >= 0L) {
            out.writeLong(value);
        }
        else {
            out.writeObject(ULong.valueOf(value));
        }
    }
    
    public static class CharacterIterator implements Iterator<Char>
    {
        CharSequence cseq;
        int len;
        int pos;
        
        public CharacterIterator(final CharSequence cseq) {
            this.cseq = cseq;
            this.len = cseq.length();
        }
        
        @Override
        public boolean hasNext() {
            return this.pos < this.len;
        }
        
        @Override
        public Char next() {
            if (this.pos >= this.len) {
                throw new NoSuchElementException();
            }
            int ch1 = this.cseq.charAt(this.pos++);
            if (ch1 >= 55296 && ch1 <= 56319 && this.pos < this.len) {
                final int ch2 = this.cseq.charAt(this.pos);
                if (ch2 >= 56320 && ch2 <= 57343) {
                    ch1 = (ch1 - 55296 << 10) + (ch2 - 56320) + 65536;
                    ++this.pos;
                }
            }
            return Char.make(ch1);
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
