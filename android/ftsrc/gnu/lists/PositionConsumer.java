package gnu.lists;

public abstract interface PositionConsumer
{
  public abstract void writePosition(SeqPosition paramSeqPosition);
  
  public abstract void writePosition(AbstractSequence paramAbstractSequence, int paramInt);
}
