/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.Array;
import gnu.lists.Arrays;
import gnu.lists.BitVector;
import gnu.lists.CharVector;
import gnu.lists.Consumer;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.FVector;
import gnu.lists.IndirectIndexedSeq;
import gnu.lists.IntSequence;
import gnu.lists.Range;
import gnu.lists.S16Vector;
import gnu.lists.S32Vector;
import gnu.lists.S64Vector;
import gnu.lists.S8Vector;
import gnu.lists.SimpleVector;
import gnu.lists.SubCharSeq;
import gnu.lists.TransformedArray;
import gnu.math.ULong;
import gnu.text.Char;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Sequences {
    public static List asSequenceOrNull(Object value) {
        if (value instanceof List) {
            return (List)value;
        }
        if (value instanceof CharSequence) {
            CharSequence cseq = (CharSequence)value;
            return new SubCharSeq(cseq, 0, cseq.length());
        }
        if (value instanceof Object[]) {
            return new FVector((Object[])value);
        }
        SimpleVector vec = null;
        if (value.getClass().isArray()) {
            if (value instanceof long[]) {
                vec = new S64Vector((long[])value);
            } else if (value instanceof int[]) {
                vec = new S32Vector((int[])value);
            } else if (value instanceof short[]) {
                vec = new S16Vector((short[])value);
            } else if (value instanceof byte[]) {
                vec = new S8Vector((byte[])value);
            } else if (value instanceof double[]) {
                vec = new F64Vector((double[])value);
            } else if (value instanceof float[]) {
                vec = new F32Vector((float[])value);
            } else if (value instanceof boolean[]) {
                vec = new BitVector((boolean[])value);
            } else if (value instanceof char[]) {
                vec = new CharVector((char[])value);
            }
            if (vec != null) {
                vec.info |= 0x200000000L;
                return vec;
            }
        }
        return null;
    }

    public static IntSequence asIntSequenceOrNull(Object value) {
        List lst = Sequences.asSequenceOrNull(value);
        if (lst == null) {
            return null;
        }
        if (lst instanceof IntSequence) {
            return (IntSequence)lst;
        }
        int len = lst.size();
        int[] arr = new int[len];
        int i = 0;
        for (Object el : lst) {
            arr[i++] = ((Number)el).intValue();
        }
        return new S32Vector(arr);
    }

    public static List coerceToSequence(Object value) {
        List lst = Sequences.asSequenceOrNull(value);
        if (lst == null) {
            String msg = value == null ? "null is not a sequence" : "cannot cast a " + value.getClass().getName() + " to a sequence";
            throw new ClassCastException(msg);
        }
        return lst;
    }

    public static int getSize(Object values) {
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
            return java.lang.reflect.Array.getLength(values);
        }
        throw new ClassCastException("value is neither List or array");
    }

    public static Iterator getIterator(Object object2) {
        List list;
        if (object2 instanceof CharSequence) {
            return new CharacterIterator((CharSequence)object2);
        }
        if (!(object2 instanceof Iterable) && (list = Sequences.asSequenceOrNull(object2)) != null) {
            return list.iterator();
        }
        return ((Iterable)object2).iterator();
    }

    public static Object subList(Object base2, int fromIndex, int toIndex) {
        List lbase = (List)base2;
        if (toIndex == -1) {
            toIndex = lbase.size();
        }
        return lbase.subList(fromIndex, toIndex);
    }

    public static List indirectIndexed(List lst, IntSequence indexes) {
        return new IndirectIndexedSeq(lst, indexes);
    }

    public static Object drop(Object base2, int count) {
        if (count >= 0) {
            return Sequences.subList(base2, count, -1);
        }
        return Sequences.subList(base2, 0, -count);
    }

    public static Object drop(Object base2, int fromStart, int fromEnd) {
        List lbase = (List)base2;
        return Sequences.subList(base2, fromStart, lbase.size() - fromEnd);
    }

    public static SimpleVector copy(SimpleVector base2, int start, int end, boolean writable) {
        int sz = end - start;
        if (base2.isVerySimple() || base2.isSubRange()) {
            int baseStart;
            int baseSize;
            SimpleVector nvec = base2.newInstance(-1);
            long flags = 0x1000000000L;
            if (!writable) {
                flags |= 0x100000000L;
            }
            if (base2.isVerySimple()) {
                baseStart = 0;
                baseSize = base2.size();
            } else {
                baseStart = base2.getOffsetBits();
                baseSize = base2.getSizeBits();
            }
            int off = baseStart + start;
            if (start < 0 || start > end || end > baseSize) {
                throw new IndexOutOfBoundsException();
            }
            nvec.setInfoField(sz, off, flags);
            base2.info |= 0x400000000L;
            return nvec;
        }
        return Sequences.copy(base2, new Range.IntRange(start, 1, sz), writable);
    }

    public static SimpleVector copy(List base2, Range.IntRange range, boolean writable) {
        SimpleVector svec;
        if (base2 instanceof SimpleVector && range.getStepInt() == 1 && ((svec = (SimpleVector)base2).isVerySimple() || svec.isSubRange())) {
            int end;
            int start = range.getStartInt();
            int bsize = base2.size();
            int n = end = range.isUnbounded() ? bsize : start + range.getSize();
            if (start < 0 || end > bsize) {
                throw new IndexOutOfBoundsException();
            }
            return Sequences.copy(svec, start, end, writable);
        }
        return Arrays.flattenCopy(new IndirectIndexedSeq(base2, range), writable);
    }

    private static Object bufferForCopy(Object obj) {
        do {
            if (obj instanceof SimpleVector) {
                return ((SimpleVector)obj).getBuffer();
            }
            if (!(obj instanceof TransformedArray)) break;
            obj = ((TransformedArray)obj).base;
        } while (true);
        return null;
    }

    public static boolean copyInPlaceIsSafe(Object src, Object dst) {
        Object d;
        Object s = Sequences.bufferForCopy(src);
        return s != (d = Sequences.bufferForCopy(dst)) && s != null && d != null;
    }

    public static void replace(List lst, int fromStart, int fromEnd, List values) {
        if (lst instanceof SimpleVector && values instanceof SimpleVector) {
            SimpleVector svec = (SimpleVector)values;
            SimpleVector dvec = (SimpleVector)lst;
            if (svec.getTag() == dvec.getTag()) {
                int dstLength;
                int sstart;
                int srcLength = svec.size();
                int grow = srcLength - (dstLength = fromEnd - fromStart);
                if (grow > 0) {
                    dvec.addSpace(fromEnd, grow);
                }
                Object dbuffer = dvec.getBuffer();
                Object sbuffer = svec.getBuffer();
                int dstart = dvec.getSegment(fromStart, srcLength);
                if (dstart >= 0 && (sstart = svec.getSegmentReadOnly(0, srcLength)) >= 0) {
                    System.arraycopy(sbuffer, sstart, dbuffer, dstart, srcLength);
                } else {
                    boolean copied;
                    int srcStart = 0;
                    boolean bl = copied = dbuffer == sbuffer;
                    if (copied) {
                        sbuffer = svec.toDataArray();
                    }
                    while (srcLength > 0) {
                        int swhere;
                        int step = srcLength;
                        long dresult = dvec.getSegment(fromStart);
                        int dwhere = (int)dresult;
                        int dsize = (int)(dresult >> 32);
                        if (dsize < step) {
                            step = dsize;
                        }
                        if (copied) {
                            swhere = srcStart;
                        } else {
                            long sresult = svec.getSegment(srcStart);
                            swhere = (int)sresult;
                            int ssize = (int)(sresult >> 32);
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
        int newSize = values.size();
        Object[] varray = values.toArray();
        int i = 0;
        for (Object el : varray) {
            if (i < oldSize) {
                lst.set(fromStart + i, el);
            } else {
                lst.add(fromStart + i, el);
            }
            ++i;
        }
        if (i < oldSize) {
            if (lst instanceof AbstractSequence) {
                AbstractSequence alst = (AbstractSequence)((Object)lst);
                alst.removePos(alst.createPos(fromStart + i, false), oldSize - i);
            } else {
                while (i < oldSize) {
                    lst.remove(fromStart + i);
                    --oldSize;
                }
            }
        }
    }

    public static void writeUInt(int value, Consumer out) {
        if (value >= 0) {
            out.writeInt(value);
        } else {
            out.writeLong((long)value & 0xFFFFFFFFL);
        }
    }

    public static void writeULong(long value, Consumer out) {
        if (value >= 0L) {
            out.writeLong(value);
        } else {
            out.writeObject(ULong.valueOf(value));
        }
    }

    public static class CharacterIterator
    implements Iterator<Char> {
        CharSequence cseq;
        int len;
        int pos;

        public CharacterIterator(CharSequence cseq) {
            this.cseq = cseq;
            this.len = cseq.length();
        }

        @Override
        public boolean hasNext() {
            return this.pos < this.len;
        }

        @Override
        public Char next() {
            int ch1;
            char ch2;
            if (this.pos >= this.len) {
                throw new NoSuchElementException();
            }
            if ((ch1 = this.cseq.charAt(this.pos++)) >= 55296 && ch1 <= 56319 && this.pos < this.len && (ch2 = this.cseq.charAt(this.pos)) >= '\udc00' && ch2 <= '\udfff') {
                ch1 = (ch1 - 55296 << 10) + (ch2 - 56320) + 65536;
                ++this.pos;
            }
            return Char.make(ch1);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

}

