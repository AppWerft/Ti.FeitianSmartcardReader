package gnu.xml;

import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


public class XName
  extends Symbol
  implements Externalizable
{
  NamespaceBinding namespaceNodes;
  
  public XName() {}
  
  public XName(Symbol symbol, NamespaceBinding namespaceNodes)
  {
    super(symbol.getName(), symbol.getNamespace());
    this.namespaceNodes = namespaceNodes;
  }
  



  public final NamespaceBinding getNamespaceNodes() { return namespaceNodes; }
  
  public final void setNamespaceNodes(NamespaceBinding nodes) { namespaceNodes = nodes; }
  
  String lookupNamespaceURI(String prefix)
  {
    for (NamespaceBinding ns = namespaceNodes; ns != null; ns = next)
    {
      if (prefix == prefix)
        return uri;
    }
    return null;
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    super.writeExternal(out);
    out.writeObject(namespaceNodes);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    super.readExternal(in);
    namespaceNodes = ((NamespaceBinding)in.readObject());
  }
  

  public static boolean isNameStart(int ch)
  {
    return (Character.isUnicodeIdentifierStart(ch)) || (ch == 95);
  }
  





  public static boolean isNamePart(int ch)
  {
    return (Character.isUnicodeIdentifierPart(ch)) || (ch == 45) || (ch == 46);
  }
  




  public static boolean isNmToken(String value)
  {
    return checkName(value) >= 0;
  }
  
  public static boolean isName(String value)
  {
    return checkName(value) > 0;
  }
  
  public static boolean isNCName(String value)
  {
    return checkName(value) > 1;
  }
  





  public static int checkName(String value)
  {
    int len = value.length();
    if (len == 0)
      return -1;
    int result = 2;
    for (int i = 0; i < len;)
    {
      boolean first = i == 0;
      int ch = value.charAt(i++);
      if ((ch >= 55296) && (ch < 56320) && (i < len))
        ch = (ch - 55296) * 1024 + (value.charAt(i++) - 56320) + 65536;
      if (ch == 58)
      {
        if (result == 2)
          result = 1;
      } else {
        if (!isNamePart(ch))
          return -1;
        if ((first) && (!isNameStart(ch)))
          result = 0;
      } }
    return result;
  }
}
