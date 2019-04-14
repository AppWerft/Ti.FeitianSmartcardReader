package gnu.lists;

public abstract interface AttributePredicate
  extends NodePredicate
{
  public abstract boolean isInstance(AbstractSequence paramAbstractSequence, int paramInt, Object paramObject);
}
