package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;











public class UnescapedData
  implements CharSequence, Externalizable
{
  String data;
  
  public UnescapedData() {}
  
  public UnescapedData(String data)
  {
    this.data = data;
  }
  
  public final String getData() { return data; }
  
  public final String toString() { return data; }
  
  public final boolean equals(Object other)
  {
    return ((other instanceof UnescapedData)) && (data.equals(other.toString()));
  }
  
  public final int hashCode() {
    return data == null ? 0 : data.hashCode();
  }
  
  public int length() {
    return data.length();
  }
  
  public char charAt(int index)
  {
    return data.charAt(index);
  }
  

  public CharSequence subSequence(int start, int end)
  {
    return new UnescapedData(data.substring(start, end));
  }
  



  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(data);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    data = ((String)in.readObject());
  }
}
