package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.RandomAccess;


public abstract class SimpleVector<E>
  extends AbstractSequence<E>
  implements AVector<E>, Externalizable, RandomAccess
{
  protected long info = Long.MIN_VALUE;
  
  public SimpleVector() {}
  
  protected final boolean isVerySimple() { return info < 0L; }
  
  protected final boolean isSubRange() {
    return (info & 0x1000000000) != 0L;
  }
  

  protected final boolean isGapBuffer() { return (info & 0x2000000000) != 0L; }
  
  protected final void setInfoField(int size, int offset, long flags) { info = (0xFFFFFFFF & size | offset << 38 | flags); }
  
  protected final int getGapStart() { return getSizeBits(); }
  protected final int getGapEnd() { return getSizeBits() + getOffsetBits(); }
  
  protected final void setGapBounds(int gapStart, int gapEnd, long flags) { setInfoField(gapStart, gapEnd - gapStart, flags | 0x2000000000); }
  

  protected final void setGapBounds(int gapStart, int gapEnd) { setInfoField(gapStart, gapEnd - gapStart, info & 0x3F00000000 | 0x2000000000); }
  
  protected final int getSizeBits() { return (int)info; }
  protected final int getOffsetBits() { return (int)(info >> 38); }
  



  public static final int MAX_GAP_SIZE = 33554431;
  

  public boolean isReadOnly()
  {
    return (info & 0x100000000) != 0L;
  }
  
  public void setReadOnly() {
    info |= 0x100000000;
  }
  
  public int size() {
    int len = getBufferLength();
    if (isVerySimple())
      return len;
    if ((info & 0x1000000000) != 0L) {
      return getSizeBits();
    }
    return len - getOffsetBits();
  }
  
  public int effectiveIndex(int index) {
    if (isVerySimple())
      return index;
    if ((info & 0x1000000000) != 0L)
    {
      if (index >= getSizeBits())
        throw new IndexOutOfBoundsException();
      return index + getOffsetBits();
    }
    
    if (index >= getSizeBits())
      index += getOffsetBits();
    return index;
  }
  
  protected void gapReserve(int where, int needed)
  {
    gapReserveGeneric(where, needed);
  }
  
  protected final void gapReserveGeneric(int where, int needed)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 4	gnu/lists/SimpleVector:info	J
    //   4: ldc2_w 23
    //   7: land
    //   8: lconst_0
    //   9: lcmp
    //   10: ifeq +61 -> 71
    //   13: aload_0
    //   14: getfield 4	gnu/lists/SimpleVector:info	J
    //   17: ldc2_w 16
    //   20: land
    //   21: lconst_0
    //   22: lcmp
    //   23: ifeq +8 -> 31
    //   26: ldc 25
    //   28: goto +5 -> 33
    //   31: ldc 26
    //   33: astore_3
    //   34: new 27	java/lang/UnsupportedOperationException
    //   37: dup
    //   38: new 28	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   45: aload_3
    //   46: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 31
    //   51: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 4	gnu/lists/SimpleVector:info	J
    //   58: invokestatic 32	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   61: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 34	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: aload_0
    //   72: invokevirtual 35	gnu/lists/SimpleVector:size	()I
    //   75: istore_3
    //   76: aload_0
    //   77: invokevirtual 18	gnu/lists/SimpleVector:getBufferLength	()I
    //   80: istore 4
    //   82: aload_0
    //   83: getfield 4	gnu/lists/SimpleVector:info	J
    //   86: ldc2_w 36
    //   89: land
    //   90: lconst_0
    //   91: lcmp
    //   92: ifeq +11 -> 103
    //   95: aload_0
    //   96: aload_0
    //   97: invokevirtual 35	gnu/lists/SimpleVector:size	()I
    //   100: invokevirtual 38	gnu/lists/SimpleVector:doCopyOnWrite	(I)V
    //   103: aload_0
    //   104: invokevirtual 19	gnu/lists/SimpleVector:isVerySimple	()Z
    //   107: ifeq +12 -> 119
    //   110: aload_0
    //   111: iload_3
    //   112: iload_3
    //   113: invokevirtual 39	gnu/lists/SimpleVector:setGapBounds	(II)V
    //   116: goto +16 -> 132
    //   119: aload_0
    //   120: getfield 4	gnu/lists/SimpleVector:info	J
    //   123: ldc2_w 5
    //   126: land
    //   127: lconst_0
    //   128: lcmp
    //   129: ifeq +3 -> 132
    //   132: aload_0
    //   133: invokevirtual 11	gnu/lists/SimpleVector:getSizeBits	()I
    //   136: istore 5
    //   138: aload_0
    //   139: invokevirtual 12	gnu/lists/SimpleVector:getOffsetBits	()I
    //   142: istore 6
    //   144: iload 5
    //   146: iload 6
    //   148: iadd
    //   149: istore 7
    //   151: iload_2
    //   152: iload 7
    //   154: iload 5
    //   156: isub
    //   157: if_icmple +84 -> 241
    //   160: aload_0
    //   161: invokevirtual 18	gnu/lists/SimpleVector:getBufferLength	()I
    //   164: istore 8
    //   166: iload 8
    //   168: bipush 16
    //   170: if_icmpge +8 -> 178
    //   173: bipush 16
    //   175: goto +7 -> 182
    //   178: iconst_2
    //   179: iload 8
    //   181: imul
    //   182: istore 9
    //   184: iload 8
    //   186: iload 7
    //   188: iload 5
    //   190: isub
    //   191: isub
    //   192: istore 10
    //   194: iload 10
    //   196: iload_2
    //   197: iadd
    //   198: istore 11
    //   200: iload 9
    //   202: iload 11
    //   204: if_icmpge +7 -> 211
    //   207: iload 11
    //   209: istore 9
    //   211: iload 9
    //   213: iload 10
    //   215: isub
    //   216: iload_1
    //   217: iadd
    //   218: istore 12
    //   220: aload_0
    //   221: iload 5
    //   223: iload 7
    //   225: iload_1
    //   226: iload 12
    //   228: invokevirtual 40	gnu/lists/SimpleVector:resizeShift	(IIII)V
    //   231: aload_0
    //   232: iload_1
    //   233: iload 12
    //   235: invokevirtual 39	gnu/lists/SimpleVector:setGapBounds	(II)V
    //   238: goto +65 -> 303
    //   241: iload_1
    //   242: iload 5
    //   244: if_icmpeq +59 -> 303
    //   247: iload_1
    //   248: iload 5
    //   250: isub
    //   251: istore 8
    //   253: iload 8
    //   255: ifle +16 -> 271
    //   258: aload_0
    //   259: iload 7
    //   261: iload 5
    //   263: iload 8
    //   265: invokevirtual 41	gnu/lists/SimpleVector:shift	(III)V
    //   268: goto +25 -> 293
    //   271: iload 8
    //   273: ifge +19 -> 292
    //   276: aload_0
    //   277: iload_1
    //   278: iload 7
    //   280: iload 8
    //   282: iadd
    //   283: iload 8
    //   285: ineg
    //   286: invokevirtual 41	gnu/lists/SimpleVector:shift	(III)V
    //   289: goto +4 -> 293
    //   292: return
    //   293: aload_0
    //   294: iload_1
    //   295: iload 7
    //   297: iload 8
    //   299: iadd
    //   300: invokevirtual 39	gnu/lists/SimpleVector:setGapBounds	(II)V
    //   303: return
    // Line number table:
    //   Java source line #86	-> byte code offset #0
    //   Java source line #87	-> byte code offset #13
    //   Java source line #90	-> byte code offset #34
    //   Java source line #92	-> byte code offset #71
    //   Java source line #93	-> byte code offset #76
    //   Java source line #94	-> byte code offset #82
    //   Java source line #95	-> byte code offset #95
    //   Java source line #96	-> byte code offset #103
    //   Java source line #97	-> byte code offset #110
    //   Java source line #98	-> byte code offset #119
    //   Java source line #101	-> byte code offset #132
    //   Java source line #102	-> byte code offset #138
    //   Java source line #103	-> byte code offset #144
    //   Java source line #104	-> byte code offset #151
    //   Java source line #106	-> byte code offset #160
    //   Java source line #107	-> byte code offset #166
    //   Java source line #108	-> byte code offset #184
    //   Java source line #109	-> byte code offset #194
    //   Java source line #110	-> byte code offset #200
    //   Java source line #111	-> byte code offset #207
    //   Java source line #112	-> byte code offset #211
    //   Java source line #113	-> byte code offset #220
    //   Java source line #114	-> byte code offset #231
    //   Java source line #115	-> byte code offset #238
    //   Java source line #116	-> byte code offset #241
    //   Java source line #117	-> byte code offset #247
    //   Java source line #118	-> byte code offset #253
    //   Java source line #119	-> byte code offset #258
    //   Java source line #120	-> byte code offset #271
    //   Java source line #121	-> byte code offset #276
    //   Java source line #123	-> byte code offset #292
    //   Java source line #124	-> byte code offset #293
    //   Java source line #126	-> byte code offset #303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	SimpleVector<E>
    //   0	304	1	where	int
    //   0	304	2	needed	int
    //   33	13	3	msg	String
    //   75	38	3	sz	int
    //   80	3	4	blen	int
    //   136	126	5	gapStart	int
    //   142	5	6	gapSize	int
    //   149	147	7	gapEnd	int
    //   164	21	8	oldLength	int
    //   251	47	8	delta	int
    //   182	30	9	newLength	int
    //   192	22	10	size	int
    //   198	10	11	minLength	int
    //   218	16	12	newGapEnd	int
  }
  
  void resizeShift(int oldGapStart, int oldGapEnd, int newGapStart, int newGapEnd)
  {
    int oldGapSize = oldGapEnd - oldGapStart;
    int newGapSize = newGapEnd - newGapStart;
    int oldLength = getBufferLength();
    int newLength = oldLength - oldGapSize + newGapSize;
    if (newLength > oldLength) {
      copyBuffer(newLength);
    }
    
    int gapDelta = oldGapStart - newGapStart;
    if (gapDelta >= 0) {
      int endLength = oldLength - oldGapEnd;
      shift(oldGapEnd, newLength - endLength, endLength);
      if (gapDelta > 0)
        shift(newGapStart, newGapEnd, gapDelta);
    } else {
      int endLength = newLength - newGapEnd;
      shift(oldLength - endLength, newGapEnd, endLength);
      shift(oldGapEnd, oldGapStart, newGapStart - oldGapStart);
    }
    clearBuffer(newGapStart, newGapSize); }
  
  protected abstract void setBuffer(Object paramObject);
  
  public abstract int getBufferLength();
  
  public abstract void copyBuffer(int paramInt);
  
  protected abstract SimpleVector newInstance(int paramInt);
  public SimpleVector<E> asImmutable() { if ((info & 0x100000000) != 0L)
      return this;
    if (isVerySimple()) {
      SimpleVector<E> tmp = newInstance(-1);
      info |= 0x400000000;
      info |= 0x100000000;
      return tmp;
    }
    return Arrays.flattenCopy(this, false);
  }
  
  protected void checkCanWrite() {
    long fl = info;
    if ((fl & 0x400000000) != 0L) {
      doCopyOnWrite(size());
    }
    if ((fl & 0x100000000) != 0L)
      throw new UnsupportedOperationException("write not allowed to read-only " + (rank() == 1 ? "sequence" : "array"));
  }
  
  protected void doCopyOnWrite(int sz) {
    long fl = info;
    Object old = getBuffer();
    
    copyBuffer(sz);
    if ((fl & 0x1000000000) != 0L) {
      System.arraycopy(old, getOffsetBits(), getBuffer(), 0, sz);
      
      info = -1L;
    }
    fl &= 0xFFFFFFFBFFFFFFFF;
    info = fl;
  }
  


  protected static final long READ_ONLY_FLAG = 4294967296L;
  

  protected static final long SHARED_FLAG = 8589934592L;
  
  public long getSegment(int index)
  {
    int sz = size();
    int size;
    int where; int size; if (isVerySimple()) {
      int where = index;
      size = sz - index; } else { int size;
      if ((info & 0x1000000000) != 0L)
      {
        int istart = getOffsetBits();
        int where = istart + index;
        size = sz - index;
      } else {
        int gapStart = getGapStart();
        int gEnd = getGapEnd();
        int size; if (index < gapStart) {
          int where = index;
          size = gapStart - index;
        } else {
          where = index + getGapEnd() - gapStart;
          size = getBufferLength() - where;
        }
      } }
    return size << 32 | where;
  }
  
  public int getSegment(int index, int len) {
    if (isGapBuffer()) {
      int sz = size();
      if ((index < 0) || (index > sz))
        return -1;
      if (index < 0) {
        index = 0;
      } else if (index + len > sz) {
        len = sz - index;
      }
      
      int gapStart = getGapStart();
      if (index + len <= gapStart)
        return index;
      if (index >= gapStart)
        return index + (getGapEnd() - gapStart);
      if ((info & 0x100000000) != 0L) {
        return -1;
      }
      if (gapStart - index > len >> 1) {
        gapReserve(index + len, 0);
        return index;
      }
      gapReserve(index, 0);
      return index + (getGapEnd() - gapStart);
    }
    
    return getSegmentReadOnly(index, len);
  }
  
  public int getSegmentReadOnly(int start, int len) {
    int sz = size();
    if ((start < 0) || (len < 0) || (start + len > sz))
      return -1;
    long result = getSegment(start);
    int where = (int)result;
    int size = (int)(result >> 32);
    return size >= len ? where : -1;
  }
  


  protected boolean isAfterPos(int ipos)
  {
    return (ipos & 0x1) != 0;
  }
  
  protected abstract Object getBuffer();
  
  public E getRowMajor(int i)
  {
    return get(i);
  }
  



  protected static final long COPY_ON_WRITE = 17179869184L;
  


  protected static final long SUBRANGE_FLAG = 68719476736L;
  

  protected static final long GAP_FLAG = 137438953472L;
  

  protected static final long VERY_SIMPLE_FLAG = Long.MIN_VALUE;
  

  public void fill(E value)
  {
    checkCanWrite();
    int i = size(); for (;;) { i--; if (i < 0) break;
      setRaw(effectiveIndex(i), value);
    }
  }
  
  public void shift(int srcStart, int dstStart, int count) {
    checkCanWrite();
    Object data = getBuffer();
    System.arraycopy(data, srcStart, data, dstStart, count);
  }
  
  public boolean add(E o)
  {
    add(size(), o);
    return true;
  }
  
  public void add(int index, E o)
  {
    addSpace(index, 1);
    setRaw(index, o);
  }
  
  protected int addPos(int ipos, E value) {
    int index = nextIndex(ipos);
    add(index, value);
    
    int ret = createPos(index + 1, true);
    releasePos(ipos);
    return ret;
  }
  
  protected void addSpace(int index, int count)
  {
    gapReserve(index, count);
    setGapBounds(getGapStart() + count, getGapEnd());
  }
  
  public void delete(int start, int end) {
    gapReserve(start, 0);
    int gapStart = getSizeBits();
    int gapSize = getOffsetBits();
    int gapEnd = gapStart + gapSize;
    int count = end - start;
    setGapBounds(start, gapEnd + count);
    clearBuffer(start, count);
  }
  
  protected abstract void clearBuffer(int paramInt1, int paramInt2);
  
  public Object toDataArray() {
    Object buffer = getBuffer();
    Class componentType = buffer.getClass().getComponentType();
    int count = size();
    int index = 0;
    Object copy = Array.newInstance(componentType, count);
    while (count > 0) {
      long result = getSegment(index);
      int where = (int)result;
      int size = (int)(result >> 32);
      if (size > count)
        size = count;
      System.arraycopy(buffer, where, copy, index, size);
      index += size;
      count -= size;
    }
    return copy;
  }
  
  public String getTag()
  {
    return null;
  }
  
  public void writeExternal(ObjectOutput out) throws IOException { out.writeObject(getBuffer()); }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    setBuffer(in.readObject());
  }
}
