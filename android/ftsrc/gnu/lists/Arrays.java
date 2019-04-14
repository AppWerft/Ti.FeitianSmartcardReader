package gnu.lists;

public class Arrays {
  public Arrays() {}
  
  public static int rowMajorToEffectiveIndex(Array arr, int index) { if ((arr instanceof GeneralArray)) {
      GeneralArray garr = (GeneralArray)arr;
      if (simple)
        return base.effectiveIndex(index);
    }
    int r = arr.rank();
    switch (r) {
    case 0: 
      return arr.effectiveIndex();
    case 1: 
      return arr.effectiveIndex(index + arr.getLowBound(0));
    case 2: 
      int sz1 = arr.getSize(1);
      return arr.effectiveIndex(index / sz1 + arr.getLowBound(0), index % sz1 + arr.getLowBound(1));
    }
    
    int[] rest = r == 3 ? AbstractSequence.noInts : new int[r - 3];
    int p = 1;
    
    int i = r; for (;;) { i--; if (i < 3) break;
      int sz = arr.getSize(i);
      rest[i] = (index % sz + arr.getLowBound(i));
      index /= sz;
    }
    int sz = arr.getSize(2);
    int i2 = index % sz + arr.getLowBound(2);
    index /= sz;
    sz = arr.getSize(1);
    int i1 = index % sz + arr.getLowBound(1);
    index /= sz;
    sz = arr.getSize(0);
    int i0 = index % sz + arr.getLowBound(0);
    return arr.effectiveIndex(i0, i1, i2, rest);
  }
  
  public static <E> E getRowMajor(Array<E> arr, int index)
  {
    return arr.getRaw(rowMajorToEffectiveIndex(arr, index));
  }
  
  public static int hashCode(Array arr) {
    int rank = arr.rank();
    int[] indexes = new int[rank];
    int size = 1;
    for (int r = 0; r < rank; r++) {
      indexes[r] = arr.getLowBound(r);
      size *= arr.getSize(r);
    }
    int hash = 1;
    for (int i = 0; i < size; i++) {
      Object element = arr.get(indexes);
      hash = 31 * hash + (element == null ? 0 : element.hashCode());
      incrementIndexes(indexes, arr);
    }
    return hash;
  }
  
  public static Array<Integer> asIntArrayOrNull(Object obj) {
    if ((obj instanceof Array)) {
      Array arr = (Array)obj;
      int kind = arr.getElementKind();
      if ((kind >= 17) && (kind <= 24))
        return arr;
    }
    if ((obj instanceof Array)) {
      Array arr = (Array)obj;
      int sz = arr.getSize();
      int rank = arr.rank();
      int[] data = new int[sz];
      int[] dims = new int[rank];
      int[] lows = null;
      int[] work = new int[rank];
      for (int i = 0; i < rank; i++) {
        dims[i] = arr.getSize(i);
        int low = arr.getLowBound(i);
        if (low != 0) {
          if (lows == null)
            lows = new int[rank];
          lows[i] = low;
        }
        work[i] = low;
      }
      for (int j = 0; j < sz;) {
        Object datum = arr.get(work);
        data[j] = ((Number)datum).intValue();
        j++; if (j == sz)
          break;
        work[(rank - 1)] += 1;
        int i = rank; for (;;) { i--; if (i < 0) break;
          int low = lows == null ? 0 : lows[i];
          if (work[i] < low + dims[i])
            break;
          work[i] = low;
          work[(i - 1)] += 1;
        }
      }
      S32Vector vec = new S32Vector(data);
      if ((rank == 1) && (lows == null))
        return vec;
      return new GeneralArray(vec, dims, lows);
    }
    IntSequence is = Sequences.asIntSequenceOrNull(obj);
    if (is != null)
      return is;
    if ((obj instanceof Number))
    {
      int[] iis = { ((Number)obj).intValue() };
      S32Vector vec = new S32Vector(iis);
      return new GeneralArray(vec, AbstractSequence.noInts, AbstractSequence.noInts);
    }
    

    return null;
  }
  
  public static void incrementIndexes(int[] indexes, Array<?> arr) {
    int r = arr.rank(); for (;;) { r--; if (r < 0) break;
      int ind = indexes[r];
      ind++;
      int low = arr.getLowBound(r);
      int dim = arr.getSize(r);
      if (ind - low < dim) {
        indexes[r] = ind;
        break;
      }
      indexes[r] = low;
    }
  }
  
  public static int[] getDimensions(Array<?> arr) {
    if ((arr instanceof GeneralArray))
      return dimensions;
    int rank = arr.rank();
    int[] dims = new int[rank];
    int i = rank; for (;;) { i--; if (i < 0) break;
      dims[i] = arr.getSize(i); }
    return dims;
  }
  
  public static int[] getLowBounds(Array<?> arr) {
    if ((arr instanceof GeneralArray))
      return lowBounds;
    int rank = arr.rank();
    int[] lows = new int[rank];
    int i = rank; for (;;) { i--; if (i < 0) break;
      lows[i] = arr.getLowBound(i); }
    return lows;
  }
  
  public static <E> void fill(Array<E> arr, E value) {
    int rank = arr.rank();
    int[] indexes = new int[rank];
    int r = rank; for (;;) { r--; if (r < 0) break;
      indexes[r] = arr.getLowBound(r); }
    int size = arr.getSize();
    int i = size; for (;;) { i--; if (i < 0) break;
      arr.set(indexes, value);
      incrementIndexes(indexes, arr);
    }
  }
  
  public static <E> void copy(Array<E> dst, Array<E> src) {
    int rank = dst.rank();
    if (rank != src.rank())
      throw new RuntimeException("incompatible arrays for copy (source rank :" + src.rank() + ", destination rank:" + rank + ")");
    int[] idst = new int[rank];
    int[] isrc = new int[rank];
    int r = rank; for (;;) { r--; if (r < 0) break;
      int ssize = src.getSize(r);
      int dsize = dst.getSize(r);
      if (ssize != dsize)
        throw new RuntimeException("incompatible arrays for copy, dimension " + r + " (source size: " + ssize + "; destination: " + dsize + ")");
      isrc[r] = src.getLowBound(r);
      idst[r] = dst.getLowBound(r);
    }
    int size = dst.getSize();
    int i = size; for (;;) { i--; if (i < 0) break;
      E value = src.get(isrc);
      dst.set(idst, value);
      incrementIndexes(isrc, src);
      incrementIndexes(idst, dst);
    }
  }
  
  public static <E> GeneralArray<E> simpleCopy(Array<E> arr, boolean writable) {
    SimpleVector<E> vec = flattenCopy(arr, writable);
    return GeneralArray.make(vec, getDimensions(arr), getLowBounds(arr), null, 0);
  }
  
  public static <E> SimpleVector<E> flattenCopy(Array<E> arr, boolean writable)
  {
    int rank = arr.rank();
    int[] indexes = new int[rank];
    int d = rank; for (;;) { d--; if (d < 0) break;
      indexes[d] = arr.getLowBound(d); }
    int size = arr.getSize();
    int kind = arr.getElementKind();
    SimpleVector vec;
    switch (kind)
    {
    case 27: 
      boolean[] data = new boolean[size];
      for (int i = 0; i < size; i++) {
        int effi = arr.effectiveIndex(indexes);
        incrementIndexes(indexes, arr);
        data[i] = arr.getBooleanRaw(effi);
      }
      vec = new BitVector(data);
      
      break;
    
    case 29: 
      char[] data = new char[size];
      for (int i = 0; i < size; i++) {
        int effi = arr.effectiveIndex(indexes);
        incrementIndexes(indexes, arr);
        data[i] = arr.getCharRaw(effi);
      }
      vec = new CharVector(data);
      
      break;
    
    case 17: 
    case 18: 
      byte[] data = new byte[size];
      for (int i = 0; i < size; i++) {
        int effi = arr.effectiveIndex(indexes);
        incrementIndexes(indexes, arr);
        data[i] = arr.getByteRaw(effi);
      }
      vec = kind == 18 ? new S8Vector(data) : new U8Vector(data);
      

      break;
    
    case 19: 
    case 20: 
      short[] data = new short[size];
      for (int i = 0; i < size; i++) {
        int effi = arr.effectiveIndex(indexes);
        incrementIndexes(indexes, arr);
        data[i] = arr.getShortRaw(effi);
      }
      vec = kind == 20 ? new S16Vector(data) : new U16Vector(data);
      

      break;
    
    case 21: 
    case 22: 
      int[] data = new int[size];
      for (int i = 0; i < size; i++) {
        int effi = arr.effectiveIndex(indexes);
        incrementIndexes(indexes, arr);
        data[i] = arr.getIntRaw(effi);
      }
      vec = kind == 22 ? new S32Vector(data) : new U32Vector(data);
      

      break;
    
    case 23: 
    case 24: 
      long[] data = new long[size];
      for (int i = 0; i < size; i++) {
        int effi = arr.effectiveIndex(indexes);
        incrementIndexes(indexes, arr);
        data[i] = arr.getLongRaw(effi);
      }
      vec = kind == 24 ? new S64Vector(data) : new U64Vector(data);
      

      break;
    
    case 25: 
      float[] data = new float[size];
      for (int i = 0; i < size; i++) {
        int effi = arr.effectiveIndex(indexes);
        incrementIndexes(indexes, arr);
        data[i] = arr.getFloatRaw(effi);
      }
      vec = new F32Vector(data);
      
      break;
    
    case 26: 
      double[] data = new double[size];
      for (int i = 0; i < size; i++) {
        int effi = arr.effectiveIndex(indexes);
        incrementIndexes(indexes, arr);
        data[i] = arr.getDoubleRaw(effi);
      }
      vec = new F64Vector(data);
      
      break;
    case 28: 
    default: 
      Object[] data = new Object[size];
      for (int i = 0; i < size; i++) {
        int effi = arr.effectiveIndex(indexes);
        incrementIndexes(indexes, arr);
        data[i] = arr.getRaw(effi);
      }
      vec = new FVector(data);
    }
    
    
    if (!writable)
      info |= 0x100000000;
    return vec;
  }
}
