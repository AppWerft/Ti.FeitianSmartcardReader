package gnu.lists;





public class GeneralArray<E>
  extends TransformedArray<E>
{
  int[] dimensions;
  


  int[] strides;
  


  int[] lowBounds;
  


  static final int[] zeros = new int[8];
  int offset;
  boolean simple;
  
  protected int nextIndex(int ipos) { return ipos >>> 1; }
  

  public static Array makeSimple(int[] lowBounds, int[] dimensions, SimpleVector base)
  {
    int d = dimensions.length;
    if ((d == 1) && ((lowBounds == null) || (lowBounds[0] == 0)))
      return base;
    return new GeneralArray(base, dimensions, lowBounds);
  }
  
  public GeneralArray() {}
  
  public GeneralArray(int[] dimensions)
  {
    init(new FVector(getSize(dimensions)), dimensions, null, null, 0);
  }
  
  public GeneralArray(AVector<E> base, int[] dimensions, int[] lowBounds, int[] strides, int offset)
  {
    init(base, dimensions, lowBounds, strides, offset);
  }
  
  public GeneralArray(AVector<E> base, int[] dimensions, int[] lowBounds) { init(base, dimensions, lowBounds, null, 0); }
  
  protected void init(AVector<E> base, int[] dimensions, int[] lowBounds, int[] strides, int offset)
  {
    this.base = base;
    simple = ((strides == null) && (offset == 0));
    int d = dimensions.length;
    if (lowBounds == null) {
      lowBounds = zeros;
      if (d > lowBounds.length)
        lowBounds = new int[d];
    }
    if (strides == null) {
      strides = new int[d];
      int n = 1;
      int i = d; for (;;) { i--; if (i < 0) break;
        strides[i] = n;
        n *= dimensions[i];
      }
    }
    this.strides = strides;
    this.dimensions = dimensions;
    this.lowBounds = lowBounds;
    this.offset = offset;
  }
  
  private static int getSize(int[] dimensions) {
    int sz = 1;
    int i = dimensions.length; for (;;) { i--; if (i < 0) break;
      sz *= dimensions[i]; }
    return sz;
  }
  
  public static <E> GeneralArray<E> make0(AVector<E> base) { return make(base, noInts, noInts, noInts, 0); }
  

  public static <E> GeneralArray<E> make(AVector<E> base, int[] dimensions, int[] lowBounds, int[] strides, int offset)
  {
    GeneralArray array = (dimensions.length == 1) && ((lowBounds == null) || (lowBounds[0] == 0)) ? new GeneralArray1() : new GeneralArray();
    


    array.init(base, dimensions, lowBounds, strides, offset);
    return array; }
  
  public AVector<E> getBase() { return (AVector)base; }
  
  public void setBase(AVector<E> base) { if (this.base != null)
      throw new IllegalStateException();
    this.base = base;
  }
  
  public void setBase(E[] data) { setBase(new FVector(data)); }
  
  public void setStrides(int[] strides, int offset) {
    this.strides = strides;
    this.offset = offset; }
  
  public int[] getDimensions() { return dimensions; }
  public int[] getLowBounds() { return lowBounds; }
  
  public int rank() { return dimensions.length; }
  
  public int effectiveIndex()
  {
    checkRank(0);
    return base.effectiveIndex(offset);
  }
  
  public int effectiveIndex(int i)
  {
    checkRank(1);
    int low = lowBounds[0];
    if ((i < low) || (i -= low >= dimensions[0]))
      throw new IndexOutOfBoundsException();
    return base.effectiveIndex(offset + strides[0] * i);
  }
  
  public int effectiveIndex(int i, int j)
  {
    checkRank(2);
    int result = offset;
    int low = lowBounds[0];
    if ((i < low) || (i -= low >= dimensions[0]))
      throw new IndexOutOfBoundsException();
    result += strides[0] * i;
    low = lowBounds[1];
    if ((j < low) || (j -= low >= dimensions[1]))
      throw new IndexOutOfBoundsException();
    result += strides[1] * j;
    return base.effectiveIndex(result);
  }
  
  public int effectiveIndex(int i, int j, int k, int... rest)
  {
    checkRank(rest.length + 3);
    int result = offset;
    int low = lowBounds[0];
    if ((i < low) || (i -= low >= dimensions[0]))
      throw new IndexOutOfBoundsException();
    result += strides[0] * i;
    low = lowBounds[1];
    if ((j < low) || (j -= low >= dimensions[1]))
      throw new IndexOutOfBoundsException();
    result += strides[1] * j;
    low = lowBounds[2];
    if ((k < low) || (k -= low >= dimensions[2]))
      throw new IndexOutOfBoundsException();
    result += strides[2] * k;
    int d = rest.length; for (;;) { d--; if (d < 0) break;
      int index = rest[d];
      low = lowBounds[(d + 3)];
      if ((index < low) || (index -= low >= dimensions[(d + 3)]))
        throw new IndexOutOfBoundsException();
      result += strides[(d + 3)] * index;
    }
    return result;
  }
  


  public int resolve(int[] indexes)
  {
    int result = offset;
    int i = dimensions.length; for (;;) { i--; if (i < 0)
        break;
      int index = indexes[i];
      int low = lowBounds[i];
      if ((index < low) || (index -= low >= dimensions[i]))
        throw new IndexOutOfBoundsException();
      result += strides[i] * index;
    }
    return result;
  }
  















  public E get(int[] indexes)
  {
    return base.getRaw(effectiveIndex(indexes));
  }
  

  public int size()
  {
    int total = 1;
    int i = dimensions.length; for (;;) { i--; if (i < 0) break;
      total *= dimensions[i]; }
    return total;
  }
  
  public int getLowBound(int dim)
  {
    return lowBounds[dim];
  }
  
  public int getSize(int dim)
  {
    return dimensions[dim];
  }
  
  public static void toString(Array array, StringBuffer sbuf)
  {
    sbuf.append("#<array");
    int r = array.rank();
    for (int i = 0; i < r; i++)
    {
      sbuf.append(' ');
      int lo = array.getLowBound(i);
      int sz = array.getSize(i);
      if (lo != 0)
      {
        sbuf.append(lo);
        sbuf.append(':');
      }
      sbuf.append(lo + sz);
    }
    sbuf.append('>');
  }
  
  public String getTag() {
    if ((base instanceof SimpleVector)) {
      return ((SimpleVector)base).getTag();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuffer sbuf = new StringBuffer();
    toString(this, sbuf);
    return sbuf.toString();
  }
}
