package gnu.lists;

public abstract interface Consumer
  extends Appendable
{
  public abstract void writeBoolean(boolean paramBoolean);
  
  public abstract void writeFloat(float paramFloat);
  
  public abstract void writeDouble(double paramDouble);
  
  public abstract void writeInt(int paramInt);
  
  public abstract void writeLong(long paramLong);
  
  public abstract void startDocument();
  
  public abstract void endDocument();
  
  public abstract void startElement(Object paramObject);
  
  public abstract void endElement();
  
  public abstract void startAttribute(Object paramObject);
  
  public abstract void endAttribute();
  
  public abstract void writeObject(Object paramObject);
  
  public abstract boolean ignoring();
  
  public abstract void write(int paramInt);
  
  public abstract void write(String paramString);
  
  public abstract void write(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  
  public abstract void write(char[] paramArrayOfChar, int paramInt1, int paramInt2);
  
  public abstract Consumer append(char paramChar);
  
  public abstract Consumer append(CharSequence paramCharSequence);
  
  public abstract Consumer append(CharSequence paramCharSequence, int paramInt1, int paramInt2);
}
