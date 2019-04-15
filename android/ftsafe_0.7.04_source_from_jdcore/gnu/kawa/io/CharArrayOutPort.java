package gnu.kawa.io;

import gnu.lists.Consumer;
import gnu.lists.FString;
import java.io.IOException;



public class CharArrayOutPort
  extends OutPort
{
  public CharArrayOutPort()
  {
    super(null, false, CharArrayInPort.stringPath);
  }
  
  public CharArrayOutPort(boolean printPretty, Path path)
  {
    super(null, printPretty, false, path);
  }
  
  public int length()
  {
    return bout.bufferFillPointer;
  }
  
  public int size() {
    return bout.bufferFillPointer;
  }
  

  public void setLength(int length)
  {
    bout.bufferFillPointer = length;
  }
  
  public void reset()
  {
    bout.bufferFillPointer = 0;
  }
  

  public char[] toCharArray()
  {
    int length = bout.bufferFillPointer;
    char[] result = new char[length];
    System.arraycopy(bout.buffer, 0, result, 0, length);
    return result;
  }
  





  public void close()
  {
    flags = 4;
  }
  

  protected boolean closeOnExit()
  {
    return false;
  }
  


  public void finalize() {}
  

  public String toString()
  {
    return toSubString(0);
  }
  




  public String toSubString(int beginIndex, int endIndex)
  {
    if (endIndex > bout.bufferFillPointer)
      throw new IndexOutOfBoundsException();
    return new String(bout.buffer, beginIndex, endIndex - beginIndex);
  }
  




  public String toSubString(int beginIndex)
  {
    return new String(bout.buffer, beginIndex, bout.bufferFillPointer - beginIndex);
  }
  
  public void writeTo(Appendable out)
  {
    writeTo(0, bout.bufferFillPointer, out);
  }
  
  public void writeTo(int start, int count, Appendable out) {
    if ((out instanceof Consumer)) {
      ((Consumer)out).write(bout.buffer, start, count);
    } else {
      try {
        out.append(new FString(bout.buffer), start, start + count);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }
  }
}
