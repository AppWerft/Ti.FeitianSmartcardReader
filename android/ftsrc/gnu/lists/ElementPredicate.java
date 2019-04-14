package gnu.lists;

public abstract interface ElementPredicate
  extends NodePredicate
{
  public abstract boolean isInstance(AbstractSequence paramAbstractSequence, int paramInt, Object paramObject);
}
