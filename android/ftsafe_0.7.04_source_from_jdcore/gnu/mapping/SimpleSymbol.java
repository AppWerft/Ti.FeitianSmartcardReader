package gnu.mapping;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;



public class SimpleSymbol
  extends Symbol
{
  public SimpleSymbol() {}
  
  public SimpleSymbol(String key)
  {
    super(key, Namespace.EmptyNamespace);
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    out.writeObject(getName());
  }
  



  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    name = ((String)in.readObject()).intern();
  }
  
  public Object readResolve()
    throws ObjectStreamException
  {
    return Namespace.EmptyNamespace.getSymbol(getName().intern());
  }
}
