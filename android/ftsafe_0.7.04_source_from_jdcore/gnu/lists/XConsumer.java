package gnu.lists;

public abstract interface XConsumer
  extends Consumer
{
  public abstract void writeComment(char[] paramArrayOfChar, int paramInt1, int paramInt2);
  
  public abstract void writeProcessingInstruction(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2);
  
  public abstract void writeCDATA(char[] paramArrayOfChar, int paramInt1, int paramInt2);
  
  public abstract void beginEntity(Object paramObject);
  
  public abstract void endEntity();
}
