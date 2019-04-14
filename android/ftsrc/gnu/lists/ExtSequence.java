package gnu.lists;




public abstract class ExtSequence<E>
  extends AbstractSequence<E>
{
  public ExtSequence() {}
  


  public int copyPos(int ipos)
  {
    if (ipos <= 0)
      return ipos;
    return PositionManager.manager.register(PositionManager.getPositionObject(ipos).copy());
  }
  
  protected void releasePos(int ipos)
  {
    if (ipos > 0) {
      PositionManager.manager.release(ipos);
    }
  }
  
  protected boolean isAfterPos(int ipos) {
    if (ipos <= 0)
      return ipos < 0;
    return (getPositionObjectipos & 0x1) != 0;
  }
  
  protected int nextIndex(int ipos)
  {
    return ipos == 0 ? 0 : ipos == -1 ? size() : PositionManager.getPositionObject(ipos).nextIndex();
  }
}
