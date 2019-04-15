package gnu.xquery.util;

import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.xml.NamespaceBinding;

public class QNameUtils
{
  public QNameUtils() {}
  
  public static Object resolveQNameUsingElement(Object qname, gnu.kawa.xml.KElement node)
  {
    qname = gnu.kawa.xml.KNode.atomicValue(qname);
    if ((qname == Values.empty) || (qname == null))
      return qname;
    if (((qname instanceof Values)) || ((!(qname instanceof String)) && (!(qname instanceof gnu.kawa.xml.UntypedAtomic))))
    {
      throw new RuntimeException("bad argument to QName"); }
    String name = gnu.xml.TextUtils.replaceWhitespace(qname.toString(), true);
    int colon = name.indexOf(':');
    String localPart;
    String prefix; String localPart; if (colon < 0)
    {
      String prefix = null;
      localPart = name;
    }
    else
    {
      prefix = name.substring(0, colon).intern();
      localPart = name.substring(colon + 1);
    }
    String uri = node.lookupNamespaceURI(prefix);
    if (uri == null)
    {
      if (prefix == null) {
        uri = "";
      } else
        throw new RuntimeException("unknown namespace for '" + name + "'");
    }
    if ((!validNCName(localPart)) || ((prefix != null) && (!validNCName(prefix))))
    {

      throw new RuntimeException("invalid QName syntax '" + name + "'");
    }
    return Symbol.make(uri, localPart, prefix == null ? "" : prefix);
  }
  









  public static Object resolveQName(Object qname, NamespaceBinding constructorNamespaces, NamespaceBinding prologNamespaces)
  {
    qname = gnu.kawa.xml.KNode.atomicValue(qname);
    if ((qname instanceof Symbol))
      return qname;
    if (((qname instanceof Values)) || ((!(qname instanceof String)) && (!(qname instanceof gnu.kawa.xml.UntypedAtomic))))
    {
      throw new RuntimeException("bad argument to QName"); }
    String name = gnu.xml.TextUtils.replaceWhitespace(qname.toString(), true);
    int colon = name.indexOf(':');
    String prefix;
    String prefix; String localPart; if (colon < 0)
    {
      String localPart = name;
      prefix = null;
    }
    else
    {
      prefix = name.substring(0, colon).intern();
      localPart = name.substring(colon + 1);
    }
    if ((!validNCName(localPart)) || ((prefix != null) && (!validNCName(prefix))))
    {

      throw new RuntimeException("invalid QName syntax '" + name + "'");
    }
    String uri = resolvePrefix(prefix, constructorNamespaces, prologNamespaces);
    return Symbol.make(uri, localPart, prefix == null ? "" : prefix);
  }
  







  public static String lookupPrefix(String prefix, NamespaceBinding constructorNamespaces, NamespaceBinding prologNamespaces)
  {
    for (NamespaceBinding ns = constructorNamespaces;; ns = ns.getNext())
    {
      if (ns == null)
      {
        String uri = prologNamespaces.resolve(prefix);
        break;
      }
      if (ns.getPrefix() == prefix)
      {
        String uri = ns.getUri();
        break;
      } }
    String uri;
    if ((uri == null) && (prefix == null))
      uri = "";
    return uri;
  }
  





  public static String resolvePrefix(String prefix, NamespaceBinding constructorNamespaces, NamespaceBinding prologNamespaces)
  {
    String uri = lookupPrefix(prefix, constructorNamespaces, prologNamespaces);
    if (uri == null)
      throw new RuntimeException("unknown namespace prefix '" + prefix + "'");
    return uri;
  }
  
  public static boolean validNCName(String name)
  {
    return gnu.xml.XName.isName(name);
  }
  


  public static Symbol makeQName(Object paramURI, String paramQName)
  {
    if ((paramURI == null) || (paramURI == Values.empty))
      paramURI = "";
    int colon = paramQName.indexOf(':');
    String namespaceURI = (String)paramURI;
    String prefix; String localPart; String prefix; if (colon < 0)
    {
      String localPart = paramQName;
      prefix = "";
    }
    else
    {
      localPart = paramQName.substring(colon + 1);
      prefix = paramQName.substring(0, colon).intern();
    }
    if ((!validNCName(localPart)) || ((colon >= 0) && (!validNCName(prefix))))
    {
      throw new IllegalArgumentException("invalid QName syntax '" + paramQName + "'"); }
    if ((colon >= 0) && (namespaceURI.length() == 0))
      throw new IllegalArgumentException("empty uri for '" + paramQName + "'");
    return Symbol.make(namespaceURI, localPart, prefix);
  }
  
  public static Object localNameFromQName(Object name)
  {
    if ((name == Values.empty) || (name == null))
      return name;
    if (!(name instanceof Symbol))
      throw new gnu.mapping.WrongType("local-name-from-QName", 1, name, "xs:QName");
    return gnu.kawa.xml.XStringType.makeNCName(((Symbol)name).getName());
  }
  
  public static Object prefixFromQName(Object name)
  {
    if ((name == Values.empty) || (name == null))
      return name;
    if ((name instanceof Symbol))
    {
      String prefix = ((Symbol)name).getPrefix();
      if ((prefix == null) || (prefix.length() == 0))
        return Values.empty;
      return gnu.kawa.xml.XStringType.makeNCName(prefix);
    }
    throw new gnu.mapping.WrongType("prefix-from-QName", 1, name, "xs:QName");
  }
  
  public static Object namespaceURIFromQName(Object name)
  {
    if ((name == Values.empty) || (name == null)) {
      return name;
    }
    try {
      return gnu.kawa.io.URIPath.makeURI(((Symbol)name).getNamespaceURI());
    }
    catch (ClassCastException ex)
    {
      throw new gnu.mapping.WrongType("namespace-uri", 1, name, "xs:QName");
    }
  }
  

  public static Object namespaceURIForPrefix(Object prefix, Object element)
  {
    gnu.kawa.xml.KNode el = gnu.kawa.xml.KNode.coerce(element);
    if (el == null)
      throw new gnu.mapping.WrongType("namespace-uri-for-prefix", 2, element, "node()");
    String str;
    String str; if ((prefix == null) || (prefix == Values.empty)) {
      str = null;
    } else { if ((!(prefix instanceof String)) && (!(prefix instanceof gnu.kawa.xml.UntypedAtomic))) {
        throw new gnu.mapping.WrongType("namespace-uri-for-prefix", 1, element, "xs:string");
      }
      
      str = prefix.toString().intern();
      if (str == "")
        str = null;
    }
    String uri = el.lookupNamespaceURI(str);
    if (uri == null) {
      return Values.empty;
    }
    return uri;
  }
  
  public static Object resolveURI(Object relative, Object base)
    throws java.net.URISyntaxException
  {
    if ((relative instanceof gnu.kawa.xml.KNode))
      relative = gnu.kawa.xml.KNode.atomicValue(relative);
    if ((base instanceof gnu.kawa.xml.KNode))
      base = gnu.kawa.xml.KNode.atomicValue(base);
    if ((relative == Values.empty) || (relative == null))
      return relative;
    if ((relative instanceof gnu.kawa.xml.UntypedAtomic))
      relative = relative.toString();
    if ((base instanceof gnu.kawa.xml.UntypedAtomic))
      base = base.toString();
    gnu.kawa.io.Path baseP = (base instanceof gnu.kawa.io.Path) ? (gnu.kawa.io.Path)base : gnu.kawa.io.URIPath.makeURI(base);
    if ((relative instanceof gnu.kawa.io.Path)) {
      return baseP.resolve((gnu.kawa.io.Path)relative);
    }
    return baseP.resolve(relative.toString());
  }
}
