package gnu.lists;

public abstract interface IntSequence
  extends AVector<Integer>
{
  public abstract int getInt(int paramInt);
  
  public abstract int size();
}
