package gnu.lists;

import java.util.List;

public class Sequences
{
  public Sequences() {}
  
  public static List asSequenceOrNull(Object value) {
    if ((value instanceof List))
      return (List)value;
    if ((value instanceof CharSequence)) {
      CharSequence cseq = (CharSequence)value;
      return new SubCharSeq(cseq, 0, cseq.length());
    }
    if ((value instanceof Object[]))
      return new FVector((Object[])value);
    SimpleVector vec = null;
    if (value.getClass().isArray()) {
      if ((value instanceof long[])) {
        vec = new S64Vector((long[])value);
      } else if ((value instanceof int[])) {
        vec = new S32Vector((int[])value);
      } else if ((value instanceof short[])) {
        vec = new S16Vector((short[])value);
      } else if ((value instanceof byte[])) {
        vec = new S8Vector((byte[])value);
      } else if ((value instanceof double[])) {
        vec = new F64Vector((double[])value);
      } else if ((value instanceof float[])) {
        vec = new F32Vector((float[])value);
      } else if ((value instanceof boolean[])) {
        vec = new BitVector((boolean[])value);
      } else if ((value instanceof char[]))
        vec = new CharVector((char[])value);
      if (vec != null) {
        info |= 0x200000000;
        return vec;
      }
    }
    return null;
  }
  
  public static IntSequence asIntSequenceOrNull(Object value) {
    List lst = asSequenceOrNull(value);
    if (lst == null)
      return null;
    if ((lst instanceof IntSequence))
      return (IntSequence)lst;
    int len = lst.size();
    int[] arr = new int[len];
    int i = 0;
    for (Object el : lst) {
      arr[(i++)] = ((Number)el).intValue();
    }
    return new S32Vector(arr);
  }
  
  public static List coerceToSequence(Object value) {
    List lst = asSequenceOrNull(value);
    if (lst == null) { String msg;
      String msg;
      if (value == null) {
        msg = "null is not a sequence";
      } else
        msg = "cannot cast a " + value.getClass().getName() + " to a sequence";
      throw new ClassCastException(msg);
    }
    return lst;
  }
  
  public static int getSize(Object values) {
    if ((values instanceof Object[]))
      return ((Object[])values).length;
    if ((values instanceof CharSequence))
      return ((CharSequence)values).length();
    if ((values instanceof List))
      return ((List)values).size();
    if (values.getClass().isArray()) {
      return java.lang.reflect.Array.getLength(values);
    }
    throw new ClassCastException("value is neither List or array");
  }
  




  public static java.util.Iterator getIterator(Object object)
  {
    if ((object instanceof CharSequence))
      return new CharacterIterator((CharSequence)object);
    if (!(object instanceof Iterable)) {
      List list = asSequenceOrNull(object);
      if (list != null) {
        return list.iterator();
      }
    }
    return ((Iterable)object).iterator();
  }
  
  public static class CharacterIterator
    implements java.util.Iterator<gnu.text.Char>
  {
    CharSequence cseq;
    int len;
    int pos;
    
    public CharacterIterator(CharSequence cseq)
    {
      this.cseq = cseq;
      len = cseq.length(); }
    
    public boolean hasNext() { return pos < len; }
    
    public gnu.text.Char next() {
      if (pos >= len)
        throw new java.util.NoSuchElementException();
      int ch1 = cseq.charAt(pos++);
      if ((ch1 >= 55296) && (ch1 <= 56319) && (pos < len)) {
        int ch2 = cseq.charAt(pos);
        if ((ch2 >= 56320) && (ch2 <= 57343)) {
          ch1 = (ch1 - 55296 << 10) + (ch2 - 56320) + 65536;
          

          pos += 1;
        }
      }
      return gnu.text.Char.make(ch1);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("remove");
    }
  }
  
  public static Object subList(Object base, int fromIndex, int toIndex)
  {
    List<?> lbase = (List)base;
    if (toIndex == -1)
      toIndex = lbase.size();
    return lbase.subList(fromIndex, toIndex);
  }
  



  public static List indirectIndexed(List lst, IntSequence indexes)
  {
    return new IndirectIndexedSeq(lst, indexes);
  }
  
  public static Object drop(Object base, int count) {
    if (count >= 0) {
      return subList(base, count, -1);
    }
    return subList(base, 0, -count);
  }
  
  public static Object drop(Object base, int fromStart, int fromEnd) { List<?> lbase = (List)base;
    return subList(base, fromStart, lbase.size() - fromEnd);
  }
  
  public static SimpleVector copy(SimpleVector base, int start, int end, boolean writable)
  {
    int sz = end - start;
    if ((base.isVerySimple()) || (base.isSubRange())) {
      SimpleVector nvec = base.newInstance(-1);
      long flags = 68719476736L;
      if (!writable)
        flags |= 0x100000000;
      int baseSize;
      int baseStart; int baseSize; if (base.isVerySimple()) {
        int baseStart = 0;
        baseSize = base.size();
      } else {
        baseStart = base.getOffsetBits();
        baseSize = base.getSizeBits();
      }
      int off = baseStart + start;
      if ((start < 0) || (start > end) || (end > baseSize)) {
        throw new IndexOutOfBoundsException();
      }
      nvec.setInfoField(sz, off, flags);
      info |= 0x400000000;
      return nvec;
    }
    return copy(base, new Range.IntRange(start, 1, sz), writable);
  }
  
  public static SimpleVector copy(List base, Range.IntRange range, boolean writable)
  {
    if (((base instanceof SimpleVector)) && (range.getStepInt() == 1)) {
      SimpleVector svec = (SimpleVector)base;
      if ((svec.isVerySimple()) || (svec.isSubRange())) {
        int start = range.getStartInt();
        int bsize = base.size();
        int end = range.isUnbounded() ? bsize : start + range.getSize();
        
        if ((start < 0) || (end > bsize))
          throw new IndexOutOfBoundsException();
        return copy(svec, start, end, writable);
      }
    }
    return Arrays.flattenCopy(new IndirectIndexedSeq(base, range), writable);
  }
  
  private static Object bufferForCopy(Object obj)
  {
    for (;;) {
      if ((obj instanceof SimpleVector))
        return ((SimpleVector)obj).getBuffer();
      if (!(obj instanceof TransformedArray)) break;
      obj = base;
    }
    return null;
  }
  
  public static boolean copyInPlaceIsSafe(Object src, Object dst)
  {
    Object s = bufferForCopy(src);
    Object d = bufferForCopy(dst);
    return (s != d) && (s != null) && (d != null);
  }
  
  public static void replace(List lst, int fromStart, int fromEnd, List values)
  {
    if (((lst instanceof SimpleVector)) && ((values instanceof SimpleVector))) {
      SimpleVector svec = (SimpleVector)values;
      SimpleVector dvec = (SimpleVector)lst;
      if (svec.getTag() == dvec.getTag()) {
        int srcLength = svec.size();
        int dstLength = fromEnd - fromStart;
        int grow = srcLength - dstLength;
        if (grow > 0)
          dvec.addSpace(fromEnd, grow);
        Object dbuffer = dvec.getBuffer();
        Object sbuffer = svec.getBuffer();
        
        int dstart = dvec.getSegment(fromStart, srcLength);
        int sstart; if ((dstart >= 0) && ((sstart = svec.getSegmentReadOnly(0, srcLength)) >= 0))
        {
          System.arraycopy(sbuffer, sstart, dbuffer, dstart, srcLength);
        }
        else {
          int srcStart = 0;
          boolean copied = dbuffer == sbuffer;
          if (copied)
            sbuffer = svec.toDataArray();
          while (srcLength > 0) {
            int step = srcLength;
            long dresult = dvec.getSegment(fromStart);
            int dwhere = (int)dresult;
            int dsize = (int)(dresult >> 32);
            if (dsize < step)
              step = dsize;
            int swhere;
            int swhere; if (copied) {
              swhere = srcStart;
            } else {
              long sresult = svec.getSegment(srcStart);
              swhere = (int)sresult;
              int ssize = (int)(sresult >> 32);
              if (ssize < step)
                step = ssize;
            }
            if (step == 0)
              throw new Error("zero step in replace loop!");
            System.arraycopy(sbuffer, swhere, dbuffer, dwhere, step);
            
            srcLength -= step;
            srcStart += step;
            fromStart += step;
          }
        }
        if (grow < 0)
          dvec.delete(fromEnd + grow, fromEnd);
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
      } else
        lst.add(fromStart + i, el);
      i++;
    }
    if (i < oldSize) {
      if ((lst instanceof AbstractSequence)) {
        AbstractSequence alst = (AbstractSequence)lst;
        alst.removePos(alst.createPos(fromStart + i, false), oldSize - i);
      } else {
        while (i < oldSize) {
          lst.remove(fromStart + i);
          oldSize--;
        }
      }
    }
  }
  
  public static void writeUInt(int value, Consumer out) {
    if (value >= 0) {
      out.writeInt(value);
    } else
      out.writeLong(value & 0xFFFFFFFF);
  }
  
  public static void writeULong(long value, Consumer out) {
    if (value >= 0L) {
      out.writeLong(value);
    } else {
      out.writeObject(gnu.math.ULong.valueOf(value));
    }
  }
}
