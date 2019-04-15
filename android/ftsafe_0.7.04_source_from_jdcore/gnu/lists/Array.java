package gnu.lists;

public abstract interface Array<E>
{
  public abstract boolean isEmpty();
  
  public abstract int rank();
  
  public abstract int getElementKind();
  
  public abstract int effectiveIndex();
  
  public abstract int effectiveIndex(int paramInt);
  
  public abstract int effectiveIndex(int paramInt1, int paramInt2);
  
  public abstract int effectiveIndex(int paramInt1, int paramInt2, int paramInt3, int... paramVarArgs);
  
  public abstract int effectiveIndex(int[] paramArrayOfInt);
  
  public abstract E getRaw(int paramInt);
  
  public abstract boolean getBooleanRaw(int paramInt);
  
  public abstract char getCharRaw(int paramInt);
  
  public abstract byte getByteRaw(int paramInt);
  
  public abstract short getShortRaw(int paramInt);
  
  public abstract int getIntRaw(int paramInt);
  
  public abstract long getLongRaw(int paramInt);
  
  public abstract float getFloatRaw(int paramInt);
  
  public abstract double getDoubleRaw(int paramInt);
  
  public abstract void setRaw(int paramInt, E paramE);
  
  public abstract E get();
  
  public abstract E get(int paramInt);
  
  public abstract E get(int paramInt1, int paramInt2);
  
  public abstract E get(int paramInt1, int paramInt2, int paramInt3, int... paramVarArgs);
  
  public abstract E get(int[] paramArrayOfInt);
  
  public abstract void set(int[] paramArrayOfInt, E paramE);
  
  public abstract int getInt();
  
  public abstract int getInt(int paramInt);
  
  public abstract int getInt(int paramInt1, int paramInt2);
  
  public abstract int getInt(int paramInt1, int paramInt2, int paramInt3, int... paramVarArgs);
  
  public abstract int getInt(int[] paramArrayOfInt);
  
  public abstract E getRowMajor(int paramInt);
  
  public abstract Array<E> asImmutable();
  
  public abstract int getLowBound(int paramInt);
  
  public abstract int getSize(int paramInt);
  
  public abstract int getSize();
}
