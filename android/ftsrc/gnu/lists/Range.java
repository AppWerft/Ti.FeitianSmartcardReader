package gnu.lists;

import gnu.math.IntNum;
import java.io.ObjectOutput;

public class Range<E> extends AbstractSequence<E> implements AVector<E>
{
  E start;
  Object step;
  int size;
  
  public Range(E start, Object step, int size)
  {
    this.start = start;
    this.step = step;
    this.size = size;
  }
  
  public E getStart() { return start; }
  public Object getStep() { return step; }
  
  public E get(int index)
  {
    if ((index >= size) && (size >= 0))
      throw new IndexOutOfBoundsException();
    return gnu.kawa.functions.AddOp.$Pl(start, gnu.kawa.functions.MultiplyOp.apply(Integer.valueOf(index), step));
  }
  
  public E getRaw(int index) {
    return get(index);
  }
  
  public int size() { return size; }
  
  public boolean isUnbounded() { return size < 0; }
  public boolean isUnspecifiedStart() { return size == -2; }
  public boolean isUnspecifiedLast() { return isUnbounded(); }
  
  public static class IntRange extends Range<Integer> implements IntSequence, java.io.Externalizable
  {
    int istart;
    int istep;
    
    public IntRange(int start, int step, int size) {
      super(Integer.valueOf(step), size);
      istart = start;
      istep = step;
    }
    
    public IntRange(int start, int step) {
      super(Integer.valueOf(step), -1);
      istart = start;
      istep = step;
    }
    
    public int getStartInt() { return istart; }
    public int getLastInt() { return istart + (size - 1) * istep; }
    public int getStepInt() { return istep; }
    
    public int getInt(int index) {
      if ((index >= size) && (size >= 0))
        throw new IndexOutOfBoundsException("index:" + index + " size:" + size);
      return istart + istep * index;
    }
    
    public IntRange subListFromRange(int rstart, int rstep, int rsize) {
      int nstart = istart + rstart * istep;
      int nstep = istep * rstep;
      if ((isUnbounded()) && (rsize == -1))
        return new IntRange(nstart, nstep);
      int nsize;
      int nsize; if (isUnbounded()) {
        nsize = rsize;
      } else {
        nsize = (size - rstart + rstep - 1) / rstep;
        if (rsize != -1) {
          if (rsize > nsize)
            throw new IndexOutOfBoundsException();
          nsize = rsize;
        }
      }
      return new IntRange(nstart, nstep, nsize);
    }
    
    public IntRange subList(int fromIx, int toIx) {
      return subListFromRange(fromIx, 1, toIx - fromIx);
    }
    
    public Integer getStart() {
      return Integer.valueOf(getStartInt());
    }
    
    public Integer get(int index) { return Integer.valueOf(getInt(index)); }
    
    public Integer getRaw(int index) {
      return Integer.valueOf(getInt(index));
    }
    
    public int getIntRaw(int index) { return getInt(index); }
    
    public int getElementKind() { return 22; }
    
    public void writeExternal(ObjectOutput out) throws java.io.IOException {
      out.writeInt(size);
      out.writeInt(istart);
      out.writeInt(istep);
    }
    
    public void readExternal(java.io.ObjectInput in) throws java.io.IOException, ClassNotFoundException
    {
      size = in.readInt();
      istart = in.readInt();
      istep = in.readInt();
    }
  }
  

  public static void listAll(Range r)
  {
    int i = 0;
    for (Object x : r) {
      System.err.println("[" + i++ + "]: " + r);
    }
  }
  
  public String toString() {
    return "#<range start:" + getStart() + " step:" + getStep() + " size:" + size + ">";
  }
  
  public static final IntRange zeroAndUp = new IntRange(0, 1);
  
  public static IntRange upto(IntNum iistart, IntNum iistep, IntNum iiend, boolean orEqual) {
    int istart = iistart.intValue();
    int istep = iistep.intValue();
    IntNum size = IntNum.sub(iiend, iistart);
    if (istep != 1)
      size = IntNum.quotient(size, iistep, orEqual ? 3 : 2);
    int isize;
    int isize;
    if (size.sign() < 0) {
      isize = 0;
    } else { if (IntNum.compare(size, Integer.MAX_VALUE - (orEqual ? 1 : 0)) > 0) {
        throw new IndexOutOfBoundsException("size too large");
      }
      isize = size.intValue() + (orEqual ? 1 : 0); }
    return new IntRange(istart, istep, isize);
  }
  
  public static IntRange downto(IntNum iistart, IntNum iistep, IntNum iiend, boolean orEqual) { int istart = iistart.intValue();
    int istep = iistep.intValue();
    IntNum size = IntNum.sub(iistart, iiend);
    if (istep != -1)
      size = IntNum.quotient(size, IntNum.neg(iistep), orEqual ? 3 : 2);
    int isize;
    int isize;
    if (size.sign() < 0) {
      isize = 0;
    } else { if (IntNum.compare(size, Integer.MAX_VALUE - (orEqual ? 1 : 0)) > 0) {
        throw new IndexOutOfBoundsException("size too large");
      }
      isize = size.intValue() + (orEqual ? 1 : 0); }
    return new IntRange(istart, istep, isize);
  }
}
