package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.kawa.reflect.OccurrenceType;
import java.io.ObjectOutput;

public class NodeSetType extends OccurrenceType
{
  public NodeSetType(Type itemType)
  {
    super(itemType, 0, -1);
  }
  
  public static Type getInstance(Type base)
  {
    return new NodeSetType(base);
  }
  
  public String toString()
  {
    return super.toString() + "node-set";
  }
  
  public void writeExternal(ObjectOutput out) throws java.io.IOException
  {
    out.writeObject(getBase());
  }
  
  public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    setBase((Type)in.readObject());
  }
}
