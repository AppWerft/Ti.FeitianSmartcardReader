package gnu.lists;

import gnu.mapping.Lazy;
import gnu.mapping.Promise;
import gnu.math.IntNum;
import java.util.List;

public class ComposedArray<E>
  extends TransformedArray<E>
{
  Array<Integer>[] mappers;
  int rank;
  int[] dims;
  int[] lowBounds;
  
  public ComposedArray(Array base, int rank, int[] dims, int[] lowBounds, Array<Integer>[] mappers)
  {
    super(base);
    this.rank = rank;
    this.dims = dims;
    this.lowBounds = lowBounds;
    this.mappers = mappers;
  }
  
  public int rank() { return rank; }
  
  public int getLowBound(int dim) {
    return lowBounds[dim];
  }
  
  public int getSize(int dim) { return dims[dim]; }
  
  public final int effectiveIndex()
  {
    return resolve(0, 0, 0, noInts);
  }
  
  public final int effectiveIndex(int i) { return resolve(i, 0, 0, noInts); }
  
  public final int effectiveIndex(int i, int j) {
    return resolve(i, j, 0, noInts);
  }
  
  public final int effectiveIndex(int i, int j, int k, int... rest) { return resolve(i, j, k, rest); }
  
  private int resolve(int x, int y, int z, int... rest)
  {
    int brank = base.rank();
    int rlen = rest.length;
    

    int b0 = 0;int b1 = 0;int b2 = 0;
    int[] brest = brank > 3 ? new int[brank - 3] : noInts;
    
    int bpos = 0;
    
    int mpos = 0;
    for (int i = 0; i < brank; i++) {
      Array<Integer> mapper = mappers[i];
      int mrank = mapper.rank();
      

      int bval;
      
      switch (mrank) {
      case 0: 
        bval = mapper.getInt();
        break;
      case 1: 
        bval = mapper.getInt(x);
        x = y;
        y = z;
        if ((mpos >= 3) && (mpos - 3 < rlen))
          z = rest[(mpos - 3)];
        break;
      case 2: 
        bval = mapper.getInt(x, y);
        x = z;
        if ((mpos >= 3) && (mpos - 3 < rlen)) {
          y = rest[(mpos - 3)];
          if ((mpos >= 2) && (mpos - 2 < rlen))
            z = rest[(mpos - 2)];
        }
        break;
      default:  int[] tmp;
        int[] tmp;
        if (mrank == 3) {
          tmp = noInts;
        } else {
          tmp = new int[mrank - 3];
          System.arraycopy(rest, mpos - 3, tmp, 0, mrank - 3);
        }
        bval = mapper.getInt(x, y, z, tmp);
        if ((mpos >= 3) && (mpos - 3 < rlen)) {
          x = rest[(mpos - 3)];
          if ((mpos >= 2) && (mpos - 2 < rlen))
            y = rest[(mpos - 2)];
          if ((mpos >= 1) && (mpos - 1 < rlen))
            z = rest[(mpos - 1)];
        }
        break;
      }
      mpos += mrank;
      switch (bpos) {
      case 0:  b0 = bval; break;
      case 1:  b1 = bval; break;
      case 2:  b2 = bval; break;
      default:  brest[(bpos - 3)] = bval;
      }
      bpos++;
    }
    switch (bpos) {
    case 0:  return base.effectiveIndex();
    case 1:  return base.effectiveIndex(b0);
    case 2:  return base.effectiveIndex(b0, b1); }
    return base.effectiveIndex(b0, b1, b2, brest);
  }
  


  public static Object generalIndex(Array arr, boolean shared, Object... indexes)
  {
    return generalIndex(arr, shared, 0, indexes.length, indexes);
  }
  
  public static Object generalIndex(Array arr, boolean shared, int start, int nindexes, Object[] indexes)
  {
    boolean allInts = true;
    for (int i = 0; i < nindexes; i++) {
      Object index = indexes[(start + i)];
      if (!(index instanceof Number))
      {
        if ((index instanceof Lazy)) {
          index = Promise.force(index);
          indexes[(start + i)] = index;
          if (!(index instanceof Number))
            allInts = false;
        } else {
          allInts = false;
        } }
    }
    boolean linear = true;
    if ((allInts) && (!shared)) {
      switch (nindexes) {
      case 0: 
        return arr.get();
      case 1: 
        return arr.get(((Number)indexes[start]).intValue());
      case 2: 
        return arr.get(((Number)indexes[start]).intValue(), ((Number)indexes[(start + 1)]).intValue());
      }
      
      
      int[] rest = nindexes == 3 ? AbstractSequence.noInts : new int[nindexes];
      
      for (int i = 3; i < nindexes; i++)
        rest[(i - 3)] = ((Number)indexes[(start + i)]).intValue();
      return arr.get(((Number)indexes[start]).intValue(), ((Number)indexes[(start + 1)]).intValue(), ((Number)indexes[(start + 2)]).intValue(), rest);
    }
    



    Array<Integer>[] aindexes = (Array[])new Array[nindexes];
    int rank = 0;
    for (int i = 0; i < nindexes; i++) {
      Array<Integer> iarr = Arrays.asIntArrayOrNull(indexes[(start + i)]);
      if (iarr == null)
        throw new ClassCastException("index is not an integer or integer array " + indexes[(start + i)].getClass().getName());
      aindexes[i] = iarr;
      int irank = iarr.rank();
      if (irank != 0) {
        if (!(iarr instanceof Range.IntRange)) {
          linear = false;
        } else {
          Range.IntRange r = (Range.IntRange)iarr;
          if (r.isUnbounded()) {
            int ilow = arr.getLowBound(i);
            int idim = arr.getSize(i);
            IntNum istart = IntNum.valueOf(istep >= 0 ? ilow : size != -2 ? istart : ilow + idim - 1);
            


            IntNum istep = IntNum.valueOf(istep);
            if (istep >= 0) {
              iarr = Range.upto(istart, istep, IntNum.valueOf(ilow + idim), false);
            } else
              iarr = Range.downto(istart, istep, IntNum.valueOf(ilow), true);
            aindexes[i] = iarr;
          }
        }
      }
      rank += irank;
    }
    if ((!shared) && ((arr instanceof SimpleVector))) {
      if ((linear) && (rank == 1) && (nindexes == 1)) {
        SimpleVector svec = (SimpleVector)arr;
        Range.IntRange range = (Range.IntRange)aindexes[0];
        return Sequences.copy(svec, range, false);
      }
      arr = ((SimpleVector)arr).asImmutable();
      shared = true;
    }
    int[] dimensions = new int[rank];
    int[] lowBounds = new int[rank];
    int k = 0;
    for (int i = 0; i < nindexes; i++) {
      Array<Integer> iarr = aindexes[i];
      int irank = iarr.rank();
      int ilow = arr.getLowBound(i);
      int idim = arr.getSize(i);
      if (irank == 0) {
        int j = iarr.getInt();
        j -= ilow;
        if ((j < 0) || ((idim >= 0) && (j >= idim))) {
          throwBoundException(i, nindexes, arr, "value " + (j + ilow));
        }
      }
      else if ((iarr instanceof Range.IntRange)) {
        Range.IntRange r = (Range.IntRange)iarr;
        int ihigh = ilow + idim - 1;
        int rsize = r.size();
        int rstep = r.getStepInt();
        int istart = r.getStartInt();
        int ilast = r.getLastInt();
        if ((rsize != 0) && (idim != 0) && ((istart < ilow) || ((idim >= 0) && (istart > ihigh)) || (ilast < ilow) || ((idim >= 0) && (ilast > ihigh))))
        {

          String msg = "range [" + istart + " <=: " + ilast + "]";
          
          throwBoundException(i, nindexes, arr, msg);
        }
      }
      


      for (int j = 0; j < irank; j++) {
        dimensions[k] = iarr.getSize(j);
        lowBounds[k] = iarr.getLowBound(j);
        k++;
      }
    }
    

    if ((linear) && (shared) && ((arr instanceof GeneralArray))) {
      GeneralArray garr = (GeneralArray)arr;
      int offset = offset;
      int[] strides = new int[rank];
      k = 0;
      for (int i = 0; i < nindexes; i++) {
        Array<Integer> iarr = aindexes[i];
        int irank = iarr.rank();
        int istride = strides[i];
        int ilow = lowBounds[i];
        int idim = dimensions[i];
        if (iarr.rank() == 0) {
          int j = iarr.getInt();
          offset += istride * (j - ilow);
        } else {
          Range.IntRange r = (Range.IntRange)iarr;
          int sz = r.size();
          int j = r.getStartInt();
          strides[k] = (r.getStepInt() * istride);
          offset += istride * (j - ilow);
          k++;
        }
      }
      return GeneralArray.make(garr.getBase(), dimensions, lowBounds, strides, offset);
    }
    
    if ((shared) && (rank == 1) && (lowBounds[0] == 0)) {
      if (((arr instanceof List)) && (aindexes.length == 1) && ((aindexes[0] instanceof IntSequence)))
      {
        return new IndirectIndexedSeq((List)arr, (IntSequence)aindexes[0]);
      }
      return new AsSequence(arr, rank, dimensions, lowBounds, aindexes);
    }
    
    ComposedArray carr = new ComposedArray(arr, rank, dimensions, lowBounds, aindexes);
    
    if (shared) {
      return carr;
    }
    return Arrays.simpleCopy(carr, false);
  }
  


  private static void throwBoundException(int i, int nindexes, Array oldMapper, String index)
  {
    int ilow = oldMapper.getLowBound(i);
    int idim = oldMapper.getSize(i);
    StringBuilder sbuf = new StringBuilder();
    if (nindexes == 0) {
      sbuf.append("index ");
    } else {
      sbuf.append("index (");
      sbuf.append(i);
      sbuf.append(" of ");
      sbuf.append(nindexes);
      sbuf.append(") ");
    }
    sbuf.append(index);
    sbuf.append(" out of bounds [");
    sbuf.append(ilow);
    sbuf.append(" <: ");
    sbuf.append(idim + ilow);
    sbuf.append("]");
    throw new IndexOutOfBoundsException(sbuf.toString());
  }
  
  public static class AsSequence<E> extends ComposedArray<E> implements AVector<E>
  {
    public AsSequence(Array base, int rank, int[] dims, int[] lowBounds, Array<Integer>[] mappers)
    {
      super(rank, dims, lowBounds, mappers);
    }
  }
}
