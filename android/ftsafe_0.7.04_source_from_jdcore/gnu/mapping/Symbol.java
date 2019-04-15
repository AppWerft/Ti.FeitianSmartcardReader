package gnu.mapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;


























public class Symbol
  implements EnvironmentKey, Comparable, Externalizable
{
  protected String name;
  Namespace namespace;
  
  public final Symbol getKeySymbol() { return this; }
  public final Object getKeyProperty() { return null; }
  
  public boolean matches(EnvironmentKey key) {
    return (equals(key.getKeySymbol(), this)) && (key.getKeyProperty() == null);
  }
  
  public boolean matches(Symbol symbol, Object property) {
    return (equals(symbol, this)) && (property == null);
  }
  

  public final String getNamespaceURI()
  {
    Namespace ns = getNamespace();
    String uri = ns == null ? null : ns.getName();
    return uri == Namespace.UNKNOWN_NAMESPACE ? "" : uri;
  }
  
  public final String getLocalPart()
  {
    return name;
  }
  
  public final String getPrefix()
  {
    Namespace ns = namespace;
    return ns == null ? "" : prefix;
  }
  

  public final boolean hasEmptyNamespace()
  {
    Namespace ns = getNamespace();
    String nsname;
    String nsname; return (ns == null) || ((nsname = ns.getName()) == null) || (nsname.length() == 0);
  }
  
  public final boolean hasUnknownNamespace()
  {
    Namespace ns = getNamespace();
    return (ns != null) && (ns.isUnknownNamespace());
  }
  





  public final String getLocalName()
  {
    return name;
  }
  




  public final String getName()
  {
    return name;
  }
  






  public static Symbol make(String uri, String name, String prefix)
  {
    return Namespace.valueOf(uri, prefix).getSymbol(name.intern());
  }
  






  public static Symbol make(Object namespace, String name)
  {
    Namespace ns = (namespace instanceof String) ? Namespace.valueOf((String)namespace) : (Namespace)namespace;
    

    if ((ns == null) || (name == null))
      return makeUninterned(name);
    return ns.getSymbol(name.intern());
  }
  
  public static SimpleSymbol valueOf(String name)
  {
    return (SimpleSymbol)Namespace.EmptyNamespace.getSymbol(name.intern());
  }
  
  public static Symbol valueOf(String name, Object spec)
  {
    if ((spec == null) || (spec == Boolean.FALSE))
      return makeUninterned(name);
    Namespace ns;
    Namespace ns; if ((spec instanceof Namespace)) {
      ns = (Namespace)spec; } else { Namespace ns;
      if (spec == Boolean.TRUE) {
        ns = Namespace.EmptyNamespace;
      } else
        ns = Namespace.valueOf(((CharSequence)spec).toString()); }
    return ns.getSymbol(name.intern());
  }
  











  public static Symbol valueOf(String name, String namespace, String prefix)
  {
    return Namespace.valueOf(namespace, prefix).getSymbol(name.intern());
  }
  
















  public static Symbol parse(String symbol)
  {
    int slen = symbol.length();
    int lbr = -1;int rbr = -1;
    int braceCount = 0;
    int mainStart = 0;
    int prefixEnd = 0;
    for (int i = 0; i < slen; i++)
    {
      char ch = symbol.charAt(i);
      if ((ch == ':') && (braceCount == 0))
      {
        prefixEnd = i;
        mainStart = i + 1;
        break;
      }
      if (ch == '{')
      {
        if (lbr < 0)
        {
          prefixEnd = i;
          lbr = i;
        }
        braceCount++;
      }
      if (ch == '}')
      {
        braceCount--;
        if (braceCount == 0)
        {
          rbr = i;
          mainStart = (i < slen) && (symbol.charAt(i + 1) == ':') ? i + 2 : i + 1;
          break;
        }
        if (braceCount < 0)
        {
          mainStart = prefixEnd;
          break;
        }
      }
    }
    if ((lbr >= 0) && (rbr > 0))
    {
      String uri = symbol.substring(lbr + 1, rbr);
      String prefix = prefixEnd > 0 ? symbol.substring(0, prefixEnd) : null;
      return valueOf(symbol.substring(mainStart), uri, prefix);
    }
    if (prefixEnd > 0)
    {
      return makeWithUnknownNamespace(symbol.substring(mainStart), symbol.substring(0, prefixEnd));
    }
    


    return valueOf(symbol);
  }
  








  public static Symbol makeWithUnknownNamespace(String local, String prefix)
  {
    return Namespace.makeUnknownNamespace(prefix).getSymbol(local.intern());
  }
  











  public Symbol() {}
  










  public static Symbol makeUninterned(String name)
  {
    return new Symbol(name, null);
  }
  

  public static Symbol makeUninterned(String name, Namespace namespace)
  {
    return new Symbol(name, namespace);
  }
  








  protected Symbol(String name, Namespace ns)
  {
    this.name = name;
    
    namespace = ns;
  }
  
  public int compareTo(Object o)
  {
    Symbol other = (Symbol)o;
    if (getNamespaceURI() != other.getNamespaceURI())
      throw new IllegalArgumentException("comparing Symbols in different namespaces");
    return getLocalName().compareTo(other.getLocalName());
  }
  
  public static boolean equals(Symbol sym1, Symbol sym2)
  {
    if (sym1 == sym2)
      return true;
    if ((sym1 == null) || (sym2 == null)) {
      return false;
    }
    

    if (name == name)
    {

      Namespace namespace1 = namespace;
      Namespace namespace2 = namespace;
      

      if ((namespace1 != null) && (namespace2 != null))
        return name == name;
    }
    return false;
  }
  



  public final boolean equals(Object o)
  {
    return ((o instanceof Symbol)) && (equals(this, (Symbol)o));
  }
  
  public int hashCode()
  {
    return name == null ? 0 : name.hashCode();
  }
  

  public final Namespace getNamespace()
  {
    return namespace;
  }
  
  public final void setNamespace(Namespace ns)
  {
    namespace = ns;
  }
  

  public static final Symbol FUNCTION = makeUninterned("(function)");
  










  public static final Symbol PLIST = makeUninterned("(property-list)");
  
  public String toString()
  {
    return toString('P');
  }
  






  public String toString(char style)
  {
    String uri = getNamespaceURI();
    String prefix = getPrefix();
    boolean hasUri = (uri != null) && (uri.length() > 0);
    boolean hasPrefix = (prefix != null) && (prefix.length() > 0);
    String name = getName();
    if ((hasUri) || (hasPrefix))
    {
      StringBuilder sbuf = new StringBuilder();
      if ((hasPrefix) && ((style != 'U') || (!hasUri)))
        sbuf.append(prefix);
      if ((hasUri) && ((style != 'P') || (!hasPrefix)))
      {
        sbuf.append('{');
        sbuf.append(getNamespaceURI());
        sbuf.append('}');
      }
      sbuf.append(':');
      sbuf.append(name);
      return sbuf.toString();
    }
    
    return name;
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    Namespace ns = getNamespace();
    out.writeObject(ns);
    out.writeObject(getName());
  }
  



  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    namespace = ((Namespace)in.readObject());
    name = ((String)in.readObject());
  }
  
  public Object readResolve()
    throws ObjectStreamException
  {
    if (namespace == null)
      return this;
    return make(namespace, getName());
  }
}
