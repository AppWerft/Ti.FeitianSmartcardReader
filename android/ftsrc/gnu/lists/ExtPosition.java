package gnu.lists;











public class ExtPosition<E, ESEQ extends AbstractSequence<E>>
  extends SeqPosition<E, ESEQ>
{
  int position = -1;
  
  public ExtPosition() {}
  
  public int getPos() { if (position < 0)
      position = PositionManager.manager.register(this);
    return position;
  }
  
  public void setPos(AbstractSequence seq, int ipos)
  {
    throw seq.unsupported("setPos");
  }
  
  public final boolean isAfter()
  {
    return (ipos & 0x1) != 0;
  }
  
  public void release()
  {
    if (position >= 0)
      PositionManager.manager.release(position);
    sequence = null;
  }
}
