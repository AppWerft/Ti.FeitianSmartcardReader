package gnu.kawa.xml;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Hashtable;

public class XmlNamespace extends gnu.mapping.Namespace implements java.io.Externalizable
{
  public static final String XHTML_NAMESPACE = "http://www.w3.org/1999/xhtml";
  public static final XmlNamespace HTML = valueOf("http://www.w3.org/1999/xhtml", "");
  public static final gnu.xml.NamespaceBinding HTML_BINDINGS = new gnu.xml.NamespaceBinding(null, "http://www.w3.org/1999/xhtml", gnu.xml.NamespaceBinding.predefinedXML);
  


  public static XmlNamespace getInstance(String prefix, String uri)
  {
    String xname = prefix + " [xml] -> " + uri;
    synchronized (nsTable)
    {
      Object old = nsTable.get(xname);
      if ((old instanceof XmlNamespace))
        return (XmlNamespace)old;
      XmlNamespace ns = new XmlNamespace();
      ns.setName(uri.intern());
      prefix = prefix.intern();
      nsTable.put(xname, ns);
      return ns;
    }
  }
  


  public static XmlNamespace valueOf(String name, String prefix)
  {
    return getInstance(prefix, name);
  }
  





  public XmlNamespace() {}
  





  public Object get(String name)
  {
    ElementType type = ElementType.make(getSymbol(name));
    if (this == HTML)
      type.setNamespaceNodes(HTML_BINDINGS);
    return type;
  }
  
  public boolean isConstant(String key)
  {
    return true;
  }
  
  public void writeExternal(ObjectOutput out) throws java.io.IOException
  {
    out.writeObject(getName());
    out.writeObject(prefix);
  }
  
  public void readExternal(ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    setName((String)in.readObject());
    prefix = ((String)in.readObject());
  }
  
  public Object readResolve() throws java.io.ObjectStreamException
  {
    String xname = prefix + " -> " + getName();
    gnu.mapping.Namespace ns = (gnu.mapping.Namespace)nsTable.get(xname);
    if ((ns instanceof XmlNamespace))
      return ns;
    nsTable.put(xname, this);
    return this;
  }
}
