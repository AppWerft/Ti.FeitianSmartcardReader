package gnu.lists;

import gnu.kawa.io.BinaryInPort;
import java.nio.charset.Charset;









public class Blob
  extends U8Vector
  implements CharSequence
{
  private String stringValue;
  Charset charset;
  
  public Blob(byte[] data)
  {
    super(data);
  }
  
  public Blob(byte[] data, Charset charset) {
    super(data);
    this.charset = charset;
  }
  
  public static Blob wrap(byte[] data, int size) {
    Blob blob = new Blob(data);
    blob.setInfoField(size, 0, 73014444032L);
    
    return blob;
  }
  
  public U8Vector asPlainBytevector() {
    if (isVerySimple()) {
      return new U8Vector(data);
    }
    int sz = size();
    byte[] b = new byte[sz];
    U8Vector vec = new U8Vector(b);
    vec.copyFrom(0, this, 0, sz);
    return vec;
  }
  
  public String toString()
  {
    synchronized (this) {
      if (stringValue == null) {
        BinaryInPort in = new BinaryInPort(data, size(), null);
        

        StringBuilder buf = new StringBuilder();
        try {
          boolean bomSeen = false;
          if (charset != null)
            bomSeen = in.setFromByteOrderMark();
          if (!bomSeen)
          {
            in.setCharset(charset != null ? charset : Charset.defaultCharset());
          }
          int ch;
          while ((ch = in.read()) >= 0) {
            buf.append((char)ch);
          }
        } catch (Exception ex) {
          buf.append("[unexpected exception: ");
          buf.append(ex);
          buf.append(']');
        }
        stringValue = buf.toString();
      }
      return stringValue;
    }
  }
  
  public char charAt(int index) { return toString().charAt(index); }
  public int length() { return toString().length(); }
  
  public CharSequence subSequence(int start, int end) { return toString().subSequence(start, end); }
}
