package gnu.lists;

import gnu.text.Char;
import java.io.IOException;

public abstract interface CharSeq
  extends CharSequence, Sequence<Char>
{
  public abstract int length();
  
  public abstract char charAt(int paramInt);
  
  public abstract void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3);
  
  public abstract void setCharAt(int paramInt, char paramChar);
  
  public abstract void setCharacterAt(int paramInt1, int paramInt2);
  
  public abstract void fill(char paramChar);
  
  public abstract void fill(int paramInt1, int paramInt2, char paramChar);
  
  public abstract CharSeq subSequence(int paramInt1, int paramInt2);
  
  public abstract void writeTo(int paramInt1, int paramInt2, Appendable paramAppendable)
    throws IOException;
  
  public abstract void writeTo(Appendable paramAppendable)
    throws IOException;
  
  public abstract void consume(int paramInt1, int paramInt2, Consumer paramConsumer);
  
  public abstract String toString();
}
