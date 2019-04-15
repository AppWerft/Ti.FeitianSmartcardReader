package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import java.io.ObjectOutput;
import java.util.Hashtable;

public class ClassNamespace extends gnu.mapping.Namespace implements java.io.Externalizable
{
  ClassType ctype;
  
  public ClassType getClassType()
  {
    return ctype;
  }
  
  public static ClassNamespace getInstance(String name, ClassType ctype)
  {
    synchronized (nsTable)
    {
      Object old = nsTable.get(name);
      if ((old instanceof ClassNamespace))
        return (ClassNamespace)old;
      ClassNamespace ns = new ClassNamespace(ctype);
      nsTable.put(name, ns);
      return ns;
    }
  }
  

  public ClassNamespace() {}
  

  public ClassNamespace(ClassType ctype)
  {
    setName("class:" + ctype.getName());
    this.ctype = ctype;
  }
  
  public Object get(String name)
  {
    try
    {
      return gnu.kawa.functions.GetNamedPart.getTypePart(ctype, name);
    }
    catch (Throwable ex)
    {
      throw gnu.mapping.WrappedException.rethrow(ex);
    }
  }
  
  public void writeExternal(ObjectOutput out) throws java.io.IOException
  {
    out.writeObject(ctype);
  }
  
  public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    ctype = ((ClassType)in.readObject());
    setName("class:" + ctype.getName());
  }
  
  public Object readResolve() throws java.io.ObjectStreamException
  {
    String name = getName();
    if (name != null)
    {
      gnu.mapping.Namespace ns = (gnu.mapping.Namespace)nsTable.get(name);
      if ((ns instanceof ClassNamespace))
        return ns;
      nsTable.put(name, this);
    }
    return this;
  }
}
