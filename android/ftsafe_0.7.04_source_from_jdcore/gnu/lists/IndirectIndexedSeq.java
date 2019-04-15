package gnu.lists;

import java.util.List;



public class IndirectIndexedSeq<E>
  extends AbstractSequence<E>
  implements Sequence<E>, Array<E>
{
  List<E> base;
  IntSequence indexes;
  
  public IndirectIndexedSeq(List<E> base, IntSequence indexes)
  {
    this.base = base;
    this.indexes = indexes;
  }
  
  public int size()
  {
    return indexes.size();
  }
  
  public int getElementKind() {
    return ((base instanceof AbstractSequence) ? Integer.valueOf(((AbstractSequence)base).getElementKind()) : null).intValue();
  }
  
  public int getBufferLength()
  {
    return base.size();
  }
  
  public int effectiveIndex(int i) { return indexes.getInt(i); }
  
  public E get(int index)
  {
    return base.get(indexes.getInt(index));
  }
  
  public E set(int index, E value) {
    return base.set(indexes.getInt(index), value);
  }
  
  public E getRaw(int i) {
    return base.get(i);
  }
  
  public void setRaw(int index, E value) { base.set(index, value); }
  
  public void copyBuffer(int length) { throw unsupported("copyBuffer"); }
}
