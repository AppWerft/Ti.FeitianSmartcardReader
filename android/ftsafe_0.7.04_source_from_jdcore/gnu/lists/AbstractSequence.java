package gnu.lists;

import gnu.kawa.util.HashUtils;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;












public abstract class AbstractSequence<E>
{
  public AbstractSequence() {}
  
  public static final int[] noInts = new int[0];
  
  public int size() {
    if (rank() == 1) return getSize(0);
    throw unsupported("size");
  }
  
  public int getSize() {
    int sz = 1;
    int r = rank(); for (;;) { r--; if (r < 0) break;
      sz *= getSize(r); }
    return sz;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public int rank()
  {
    return 1;
  }
  
  protected void checkRank(int i) {
    if (i != rank())
      throw badRank(i);
  }
  
  protected RuntimeException badRank(int i) {
    return new RuntimeException("wrong number of indexes " + i + " to " + rank() + "-rank array");
  }
  

  public Array<E> asImmutable() { throw unsupported("asImmutable"); }
  
  public E get() { return getRaw(effectiveIndex()); }
  
  public E get(int i) { return getRaw(effectiveIndex(i)); }
  
  public E get(int i, int j) { return getRaw(effectiveIndex(i, j)); }
  
  public E get(int i, int j, int k, int... rest) { return getRaw(effectiveIndex(i, j, k, rest)); }
  
  public E get(int[] indexes) {
    return getRaw(effectiveIndex(indexes));
  }
  
  protected void checkCanWrite() {}
  
  public E getRowMajor(int index) {
    if (rank() == 1)
      return get(index);
    if ((this instanceof Array))
      return Arrays.getRowMajor((Array)this, index);
    throw unsupportedException("getRowMajor");
  }
  
  public int effectiveIndex() {
    checkRank(0);
    return 0;
  }
  
  public int effectiveIndex(int index) { checkRank(1);
    return index - getLowBound(0);
  }
  
  public int effectiveIndex(int i, int j) { checkRank(2);
    return (i - getLowBound(0)) * getSize(1) + (j - getLowBound(1));
  }
  
  public int effectiveIndex(int i, int j, int k, int... rest) { int r = rest.length;
    checkRank(3 + r);
    int eff = 0;
    int stride = 1;
    for (;;) { r--; if (r < 0) break;
      eff += (rest[r] - getLowBound(3 + r)) * stride;
      stride *= getSize(3 + r);
    }
    eff += (k - getLowBound(2)) * stride;
    stride *= getSize(2);
    eff += (j - getLowBound(1)) * stride;
    stride *= getSize(1);
    eff += (i - getLowBound(0)) * stride;
    return eff;
  }
  
  public int effectiveIndex(int[] indexes) {
    int ilength = indexes.length;
    switch (indexes.length) {
    case 0: 
      return effectiveIndex();
    case 1: 
      return effectiveIndex(indexes[0]);
    case 2: 
      return effectiveIndex(indexes[0], indexes[1]); }
    int[] rest;
    int[] rest;
    if (ilength == 3) {
      rest = noInts;
    } else {
      rest = new int[ilength - 3];
      System.arraycopy(indexes, 3, rest, 0, ilength - 3);
    }
    return effectiveIndex(indexes[0], indexes[1], indexes[2], rest);
  }
  

  public E getRaw(int index) { throw unsupported("getRaw"); }
  
  protected void setBuffer(Object obj) { throw unsupported("setBuffer"); }
  

  public void setRaw(int index, E value) { throw unsupported("setRaw"); }
  
  public boolean getBooleanRaw(int index) {
    Object value = getRaw(index);
    return (value != null) && (((Boolean)value).booleanValue());
  }
  
  public char getCharRaw(int index) {
    return ((Character)getRaw(index)).charValue();
  }
  
  public byte getByteRaw(int index) {
    return ((Number)getRaw(index)).byteValue();
  }
  
  public short getShortRaw(int index) {
    return ((Number)getRaw(index)).shortValue();
  }
  
  public int getIntRaw(int index) {
    return ((Number)getRaw(index)).intValue();
  }
  
  public long getLongRaw(int index) {
    return ((Number)getRaw(index)).longValue();
  }
  
  public float getFloatRaw(int index) {
    return ((Number)getRaw(index)).floatValue();
  }
  
  public double getDoubleRaw(int index) {
    return ((Number)getRaw(index)).doubleValue();
  }
  
  public int getInt() { return getIntRaw(effectiveIndex()); }
  public int getInt(int i) { return getIntRaw(effectiveIndex(i)); }
  public int getInt(int i, int j) { return getIntRaw(effectiveIndex(i, j)); }
  
  public int getInt(int i, int j, int k, int... rest) { return getIntRaw(effectiveIndex(i, j, k, rest)); }
  
  public int getInt(int[] indexes) { return getIntRaw(effectiveIndex(indexes)); }
  
  public void set(int[] indexes, E value)
  {
    checkCanWrite();
    setRaw(effectiveIndex(indexes), value);
  }
  
  public int getLowBound(int dim)
  {
    return 0;
  }
  
  public int getSize(int dim)
  {
    return dim == 0 ? size() : 1;
  }
  
  public int getElementKind() { return 32; }
  
  protected RuntimeException unsupported(String text)
  {
    return unsupportedException(getClass().getName() + " does not implement " + text);
  }
  

  public static RuntimeException unsupportedException(String text)
  {
    return new UnsupportedOperationException(text);
  }
  
  public E set(int index, E value) {
    checkCanWrite();
    int effi = effectiveIndex(index);
    E old = getRaw(effi);
    setRaw(effi, value);
    return old;
  }
  
  public void setAt(int index, E value) {
    checkCanWrite();
    setRaw(effectiveIndex(index), value);
  }
  
  public void fill(E value)
  {
    for (int i = startPos(); (i = nextPos(i)) != 0;) {
      setPosPrevious(i, value);
    }
  }
  
  public void fillPosRange(int fromPos, int toPos, E value) {
    for (int i = copyPos(fromPos); 
        compare(i, toPos) < 0; i = nextPos(i))
      setPosNext(i, value);
    releasePos(i);
  }
  
  public void fill(int fromIndex, int toIndex, E value)
  {
    int i = createPos(fromIndex, false);
    int limit = createPos(toIndex, true);
    for (; compare(i, limit) < 0; i = nextPos(i))
      setPosNext(i, value);
    releasePos(i);
    releasePos(limit);
  }
  




  public int indexOf(Object o)
  {
    int i = 0;
    for (int iter = startPos(); (iter = nextPos(iter)) != 0; i++)
    {
      Object v = getPosPrevious(iter);
      if (o == null ? v == null : o.equals(v))
      {
        releasePos(iter);
        return i;
      }
    }
    return -1;
  }
  


  public int lastIndexOf(Object o)
  {
    int n = size(); for (;;) { n--; if (n < 0)
        break;
      Object e = get(n);
      if (o == null ? e == null : o.equals(e))
        return n;
    }
    return -1;
  }
  








  public int nextMatching(int startPos, ItemPredicate type, int endPos, boolean descend)
  {
    if (descend)
      throw unsupported("nextMatching with descend");
    int ipos = startPos;
    do
    {
      if (compare(ipos, endPos) >= 0)
        return 0;
      ipos = nextPos(ipos);
    } while (!type.isInstancePos(this, ipos));
    return ipos;
  }
  


  public boolean contains(Object o)
  {
    return indexOf(o) >= 0;
  }
  

  public boolean containsAll(Collection<?> c)
  {
    Iterator<?> i = c.iterator();
    while (i.hasNext())
    {
      Object e = i.next();
      if (!contains(e))
        return false;
    }
    return true;
  }
  
  public final Enumeration<E> elements()
  {
    return getIterator(0);
  }
  
  public final SeqPosition<E, AbstractSequence<E>> getIterator()
  {
    return getIterator(0);
  }
  
  public SeqPosition<E, AbstractSequence<E>> getIterator(int index)
  {
    return new SeqPosition(this, index, false);
  }
  
  public SeqPosition<E, AbstractSequence<E>> getIteratorAtPos(int ipos)
  {
    return new SeqPosition(this, copyPos(ipos));
  }
  
  public final Iterator<E> iterator()
  {
    return getIterator(0);
  }
  
  public final ListIterator<E> listIterator()
  {
    return getIterator(0);
  }
  
  public final ListIterator<E> listIterator(int index)
  {
    return getIterator(index);
  }
  



  protected int addPos(int ipos, E value)
  {
    throw unsupported("addPos");
  }
  

  public boolean add(E o)
  {
    addPos(endPos(), o);
    return true;
  }
  

  public void add(int index, E o)
  {
    int pos = createPos(index, false);
    addPos(pos, o);
    releasePos(pos);
  }
  

  public boolean addAll(Collection<? extends E> c)
  {
    return addAll(size(), c);
  }
  

  public boolean addAll(int index, Collection<? extends E> c)
  {
    boolean changed = false;
    int pos = createPos(index, false);
    for (Iterator<? extends E> it = c.iterator(); it.hasNext();)
    {
      pos = addPos(pos, it.next());
      changed = true;
    }
    releasePos(pos);
    return changed;
  }
  











  public void removePos(int ipos, int count)
  {
    int rpos = createRelativePos(ipos, count, false);
    if (count >= 0) {
      removePosRange(ipos, rpos);
    } else
      removePosRange(rpos, ipos);
    releasePos(rpos);
  }
  







  protected void removePosRange(int ipos0, int ipos1)
  {
    throw unsupported("removePosRange");
  }
  
  public E remove(int index)
  {
    if ((index < 0) || (index >= size()))
      throw new IndexOutOfBoundsException();
    int ipos = createPos(index, false);
    E result = getPosNext(ipos);
    removePos(ipos, 1);
    releasePos(ipos);
    return result;
  }
  
  public boolean remove(Object o)
  {
    int index = indexOf(o);
    if (index < 0)
      return false;
    int ipos = createPos(index, false);
    removePos(ipos, 1);
    releasePos(ipos);
    return true;
  }
  
  public boolean removeAll(Collection<?> c)
  {
    boolean changed = false;
    for (int iter = startPos(); (iter = nextPos(iter)) != 0;)
    {
      Object value = getPosPrevious(iter);
      if (c.contains(value))
      {
        removePos(iter, -1);
        changed = true;
      }
    }
    return changed;
  }
  
  public boolean retainAll(Collection<?> c)
  {
    boolean changed = false;
    for (int iter = startPos(); (iter = nextPos(iter)) != 0;)
    {
      Object value = getPosPrevious(iter);
      if (!c.contains(value))
      {
        removePos(iter, -1);
        changed = true;
      }
    }
    return changed;
  }
  
  public void clear()
  {
    removePos(startPos(), endPos());
  }
  



  protected boolean isAfterPos(int ipos)
  {
    return (ipos & 0x1) != 0;
  }
  





  public int createPos(int index, boolean isAfter)
  {
    return index << 1 | (isAfter ? 1 : 0);
  }
  
  public int createRelativePos(int pos, int delta, boolean isAfter)
  {
    return createPos(nextIndex(pos) + delta, isAfter);
  }
  
  public int startPos() { return 0; }
  public int endPos() { return -1; }
  








  protected void releasePos(int ipos) {}
  








  public int copyPos(int ipos)
  {
    return ipos;
  }
  

  protected int getIndexDifference(int ipos1, int ipos0)
  {
    return nextIndex(ipos1) - nextIndex(ipos0);
  }
  


  protected int nextIndex(int ipos)
  {
    return ipos == -1 ? size() : ipos >>> 1;
  }
  
  public int xnextIndex(int ipos) { return nextIndex(ipos); }
  

  protected int fromEndIndex(int ipos)
  {
    return size() - nextIndex(ipos);
  }
  





  protected int getContainingSequenceSize(int ipos)
  {
    return size();
  }
  
  public boolean hasNext(int ipos)
  {
    return nextIndex(ipos) != size();
  }
  
  public int getNextKind(int ipos)
  {
    return hasNext(ipos) ? 32 : 0;
  }
  
  public String getNextTypeName(int ipos)
  {
    Object type = getNextTypeObject(ipos);
    return type == null ? null : type.toString();
  }
  
  public E getNextTypeObject(int ipos)
  {
    return null;
  }
  

  protected boolean hasPrevious(int ipos)
  {
    return nextIndex(ipos) != 0;
  }
  





  public int nextPos(int ipos)
  {
    if (!hasNext(ipos))
      return 0;
    int next = createRelativePos(ipos, 1, true);
    releasePos(ipos);
    return next;
  }
  





  public int previousPos(int ipos)
  {
    if (!hasPrevious(ipos))
      return 0;
    int next = createRelativePos(ipos, -1, false);
    releasePos(ipos);
    return next;
  }
  





  public final boolean gotoChildrenStart(TreePosition pos)
  {
    int ipos = firstChildPos(pos.getPos());
    if (ipos == 0)
      return false;
    pos.push(this, ipos);
    return true;
  }
  






  public int firstChildPos(int ipos)
  {
    return 0;
  }
  
  public int firstChildPos(int ipos, ItemPredicate predicate)
  {
    int child = firstChildPos(ipos);
    if (child == 0)
      return 0;
    if (predicate.isInstancePos(this, child)) {
      return child;
    }
    return nextMatching(child, predicate, endPos(), false);
  }
  



  public int firstAttributePos(int ipos)
  {
    return 0;
  }
  




  public int parentPos(int ipos)
  {
    return endPos();
  }
  
  protected boolean gotoParent(TreePosition pos)
  {
    if (depth < 0)
      return false;
    pos.pop();
    return true;
  }
  
  public int getAttributeLength()
  {
    return 0;
  }
  
  public Object getAttribute(int index)
  {
    return null;
  }
  
  protected boolean gotoAttributesStart(TreePosition pos)
  {
    return false;
  }
  






  public Object getPosNext(int ipos)
  {
    if (!hasNext(ipos))
      return Sequence.eofValue;
    return get(nextIndex(ipos));
  }
  





  public Object getPosPrevious(int ipos)
  {
    int index = nextIndex(ipos);
    if (index <= 0)
      return Sequence.eofValue;
    return get(index - 1);
  }
  
  protected void setPosNext(int ipos, E value)
  {
    int index = nextIndex(ipos);
    if (index >= size())
      throw new IndexOutOfBoundsException();
    set(index, value);
  }
  
  protected void setPosPrevious(int ipos, E value)
  {
    int index = nextIndex(ipos);
    if (index == 0)
      throw new IndexOutOfBoundsException();
    set(index - 1, value);
  }
  
  public final int nextIndex(SeqPosition pos)
  {
    return nextIndex(ipos);
  }
  

  public boolean equals(int ipos1, int ipos2)
  {
    return compare(ipos1, ipos2) == 0;
  }
  

  public int compare(int ipos1, int ipos2)
  {
    int i1 = nextIndex(ipos1);
    int i2 = nextIndex(ipos2);
    return i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
  }
  
  public final int compare(SeqPosition i1, SeqPosition i2)
  {
    return compare(ipos, ipos);
  }
  
  public Object[] toArray()
  {
    int len = size();
    Object[] arr = new Object[len];
    int it = startPos();
    int i = 0;
    while ((it = nextPos(it)) != 0)
      arr[(i++)] = getPosPrevious(it);
    return arr;
  }
  
  public <T> T[] toArray(T[] arr)
  {
    int alen = arr.length;
    int len = size();
    if (len > alen)
    {
      Class componentType = arr.getClass().getComponentType();
      arr = (Object[])java.lang.reflect.Array.newInstance(componentType, len);
      alen = len;
    }
    
    int it = startPos();
    for (int i = 0; (it = nextPos(it)) != 0; i++)
    {
      arr[i] = getPosPrevious(it);
    }
    if (len < alen)
      arr[len] = null;
    return arr;
  }
  

  public int stableCompare(AbstractSequence other)
  {
    int id1 = System.identityHashCode(this);
    int id2 = System.identityHashCode(other);
    return id1 > id2 ? 1 : id1 < id2 ? -1 : 0;
  }
  




  public static int compare(AbstractSequence seq1, int pos1, AbstractSequence seq2, int pos2)
  {
    if (seq1 == seq2)
      return seq1.compare(pos1, pos2);
    return seq1.stableCompare(seq2);
  }
  
  public int hashCode()
  {
    if ((rank() != 1) && ((this instanceof Array))) {
      return Arrays.hashCode((Array)this);
    }
    int hash = 1;
    for (int i = startPos(); (i = nextPos(i)) != 0;)
    {
      Object obj = getPosPrevious(i);
      hash = 31 * hash + (obj == null ? 0 : obj.hashCode());
    }
    return hash;
  }
  
  public int boundedHash(int seed, int limit) {
    int count = 0;
    int sublimit = limit >> 1;
    for (int i = startPos(); (i = nextPos(i)) != 0;) {
      count++; if (count > limit)
        break;
      int h = HashUtils.boundedHash(getPosPrevious(i), 0, sublimit);
      seed = HashUtils.murmur3step(seed, h);
    }
    return HashUtils.murmur3finish(seed, count);
  }
  


  public boolean equals(Object o)
  {
    if ((!(this instanceof List)) || (!(o instanceof List)))
    {
      return this == o; }
    Iterator<E> it1 = iterator();
    Iterator<E> it2 = ((List)o).iterator();
    for (;;)
    {
      boolean more1 = it1.hasNext();
      boolean more2 = it2.hasNext();
      if (more1 != more2)
        return false;
      if (!more1)
        return true;
      E e1 = it1.next();
      E e2 = it2.next();
      if (e1 == null)
      {
        if (e2 != null) {
          return false;
        }
      } else if (!e1.equals(e2)) {
        return false;
      }
    }
  }
  
  public Sequence subSequence(SeqPosition start, SeqPosition end) {
    return subSequencePos(ipos, ipos);
  }
  
  protected Sequence<E> subSequencePos(int ipos0, int ipos1)
  {
    return new SubSequence(this, ipos0, ipos1);
  }
  
  public List<E> subList(int fromIx, int toIx)
  {
    return subSequencePos(createPos(fromIx, false), createPos(toIx, true));
  }
  



  public boolean consumeNext(int ipos, Consumer out)
  {
    int next = nextPos(ipos);
    if (next == 0)
      return false;
    consumePosRange(ipos, next, out);
    return true;
  }
  
  public void consumePosRange(int iposStart, int iposEnd, Consumer out)
  {
    if (out.ignoring())
      return;
    int it = copyPos(iposStart);
    while (!equals(it, iposEnd))
    {
      if (!hasNext(it))
        throw new RuntimeException();
      out.writeObject(getPosNext(it));
      it = nextPos(it);
    }
    releasePos(it);
  }
  
  public void consume(int fromIndex, int toIndex, Consumer out) {
    int ipos0 = createPos(fromIndex, false);
    int ipos1 = createPos(toIndex, true);
    consumePosRange(ipos0, ipos1, out);
    releasePos(ipos0);
    releasePos(ipos1);
  }
  
  public void consume(Consumer out)
  {
    boolean isSequence = this instanceof Sequence;
    if (isSequence)
      out.startElement("#sequence");
    consumePosRange(startPos(), endPos(), out);
    if (isSequence) {
      out.endElement();
    }
  }
  
  public void toString(String sep, StringBuffer sbuf) {
    boolean seen = false;
    for (int i = startPos(); (i = nextPos(i)) != 0;)
    {
      if (seen) {
        sbuf.append(sep);
      } else
        seen = true;
      sbuf.append(getPosPrevious(i));
    }
  }
  
  public String toString()
  {
    StringBuffer sbuf = new StringBuffer(100);
    if ((this instanceof Sequence))
      sbuf.append('[');
    toString(", ", sbuf);
    if ((this instanceof Sequence))
      sbuf.append(']');
    return sbuf.toString();
  }
}
