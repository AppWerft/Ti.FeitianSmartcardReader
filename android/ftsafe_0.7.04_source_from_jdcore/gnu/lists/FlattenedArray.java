package gnu.lists;

public class FlattenedArray<E>
  extends TransformedArray<E> implements AVector<E>
{
  private final int size;
  private final int brank;
  
  public FlattenedArray(Array<E> base)
  {
    super(base);
    size = base.getSize();
    brank = base.rank();
  }
  
  public int size() {
    return size;
  }
  
  public int getSize(int dim) {
    if (dim != 0)
      badRank(dim);
    return size;
  }
  
  public int effectiveIndex(int i)
  {
    return Arrays.rowMajorToEffectiveIndex(base, i);
  }
  

  public static <E> AVector<E> flatten(Array<E> array)
  {
    if ((array instanceof AVector))
      return (AVector)array;
    if ((array instanceof GeneralArray)) {
      GeneralArray<E> garr = (GeneralArray)array;
      if ((simple) && ((base instanceof AVector)))
        return (AVector)base;
    }
    return new FlattenedArray(array);
  }
}
