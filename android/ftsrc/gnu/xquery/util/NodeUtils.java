package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.xml.NodeTree;
import java.util.Stack;

public class NodeUtils
{
  public NodeUtils() {}
  
  public static Object nodeName(Object node)
  {
    if ((node == Values.empty) || (node == null))
      return node;
    if (!(node instanceof KNode))
      throw new WrongType("node-name", 1, node, "node()?");
    Object sym = ((KNode)node).getNodeSymbol();
    if (sym == null) {
      return Values.empty;
    }
    return sym;
  }
  
  public static String name(Object node)
  {
    if ((node == Values.empty) || (node == null))
      return "";
    Object name = ((KNode)node).getNodeNameObject();
    if ((name == null) || (name == Values.empty))
      return "";
    return name.toString();
  }
  
  public static String localName(Object node)
  {
    if ((node == Values.empty) || (node == null))
      return "";
    if (!(node instanceof KNode))
      throw new WrongType("local-name", 1, node, "node()?");
    Object name = ((KNode)node).getNodeNameObject();
    if ((name == null) || (name == Values.empty))
      return "";
    if ((name instanceof Symbol))
      return ((Symbol)name).getName();
    return name.toString();
  }
  
  public static Object namespaceURI(Object node)
  {
    if ((node != Values.empty) && (node != null))
    {
      if (!(node instanceof KNode))
        throw new WrongType("namespace-uri", 1, node, "node()?");
      Object name = ((KNode)node).getNodeNameObject();
      if ((name instanceof Symbol))
        return QNameUtils.namespaceURIFromQName(name);
    }
    return "";
  }
  
  public static void prefixesFromNodetype(gnu.xml.XName name, Consumer out)
  {
    gnu.xml.NamespaceBinding bindings = name.getNamespaceNodes();
    for (gnu.xml.NamespaceBinding ns = bindings; 
        ns != null; 
        ns = ns.getNext())
    {
      String uri = ns.getUri();
      if (uri != null)
      {
        String prefix = ns.getPrefix();
        

        for (gnu.xml.NamespaceBinding ns2 = bindings;; ns2 = ns2.getNext())
        {
          if (ns2 == ns)
          {
            out.writeObject(prefix == null ? "" : prefix);
          }
          else {
            if (ns2.getPrefix() == prefix) {
              break;
            }
          }
        }
      }
    }
  }
  


  public static void inScopePrefixes$X(Object node, CallContext ctx)
  {
    gnu.kawa.xml.KElement element = (gnu.kawa.xml.KElement)node;
    Object type = element.getNodeNameObject();
    if ((type instanceof gnu.xml.XName)) {
      prefixesFromNodetype((gnu.xml.XName)type, consumer);
    } else {
      consumer.writeObject("xml");
    }
  }
  
  public static void data$X(Object arg, CallContext ctx)
  {
    Consumer out = consumer;
    if ((arg instanceof Values))
    {
      Values vals = (Values)arg;
      int ipos = vals.startPos();
      while ((ipos = vals.nextPos(ipos)) != 0) {
        out.writeObject(KNode.atomicValue(vals.getPosPrevious(ipos)));
      }
    } else {
      out.writeObject(KNode.atomicValue(arg));
    }
  }
  
  public static Object root(Object arg)
  {
    if ((arg == null) || (arg == Values.empty))
      return arg;
    if (!(arg instanceof KNode))
      throw new WrongType("root", 1, arg, "node()?");
    KNode node = (KNode)arg;
    return gnu.kawa.xml.Nodes.root((NodeTree)sequence, node.getPos());
  }
  



  public static gnu.kawa.xml.KDocument rootDocument(Object arg)
  {
    if (!(arg instanceof KNode))
      throw new WrongType("root-document", 1, arg, "node()?");
    KNode node = (KNode)arg;
    node = gnu.kawa.xml.Nodes.root((NodeTree)sequence, node.getPos());
    if (!(node instanceof gnu.kawa.xml.KDocument))
      throw new WrongType("root-document", 1, arg, "document()");
    return (gnu.kawa.xml.KDocument)node;
  }
  
  public static String getLang(KNode node)
  {
    NodeTree seq = (NodeTree)sequence;
    int attr = seq.ancestorAttribute(ipos, "http://www.w3.org/XML/1998/namespace", "lang");
    

    if (attr == 0) {
      return null;
    }
    return KNode.getNodeValue(seq, attr);
  }
  
  public static boolean lang(Object testlang, Object node) {
    String teststr;
    String teststr;
    if ((testlang == null) || (testlang == Values.empty)) {
      teststr = "";
    } else
      teststr = gnu.xml.TextUtils.stringValue(testlang);
    String lang = getLang((KNode)node);
    if (lang == null)
      return false;
    int langlen = lang.length();
    int testlen = teststr.length();
    if ((langlen > testlen) && (lang.charAt(testlen) == '-'))
      lang = lang.substring(0, testlen);
    return lang.equalsIgnoreCase(teststr);
  }
  
  public static Object documentUri(Object arg)
  {
    if ((arg == null) || (arg == Values.empty))
      return arg;
    if (!(arg instanceof KNode))
      throw new WrongType("xs:document-uri", 1, arg, "node()?");
    KNode node = (KNode)arg;
    Object uri = ((NodeTree)sequence).documentUriOfPos(ipos);
    return uri == null ? Values.empty : uri;
  }
  
  public static Object nilled(Object arg)
  {
    if ((arg == null) || (arg == Values.empty))
      return arg;
    if (!(arg instanceof KNode))
      throw new WrongType("nilled", 1, arg, "node()?");
    if (!(arg instanceof gnu.kawa.xml.KElement))
      return Values.empty;
    return Boolean.FALSE;
  }
  
  public static Object baseUri(Object arg)
  {
    if ((arg == null) || (arg == Values.empty))
      return arg;
    if (!(arg instanceof KNode))
      throw new WrongType("base-uri", 1, arg, "node()?");
    gnu.kawa.io.Path uri = ((KNode)arg).baseURI();
    if (uri == null) {
      return Values.empty;
    }
    return uri;
  }
  








  static Object getIDs(Object arg, Object collector)
  {
    if ((arg instanceof KNode))
      arg = KNode.atomicValue(arg);
    if ((arg instanceof Values))
    {
      Object[] ar = ((Values)arg).getValues();
      int i = ar.length; for (;;) { i--; if (i < 0) break;
        collector = getIDs(ar[i], collector);
      }
    }
    else {
      String str = StringUtils.coerceToString(arg, "fn:id", 1, "");
      int len = str.length();
      int i = 0;
      while (i < len)
      {
        char ch = str.charAt(i++);
        if (!Character.isWhitespace(ch))
        {
          int start = gnu.xml.XName.isNameStart(ch) ? i - 1 : len;
          while (i < len)
          {
            ch = str.charAt(i);
            if (Character.isWhitespace(ch))
              break;
            i++;
            if ((start < len) && (!gnu.xml.XName.isNamePart(ch)))
              start = len;
          }
          if (start < len)
          {
            String ref = str.substring(start, i);
            if (collector == null) {
              collector = ref;
            } else {
              Stack st;
              Stack st;
              if ((collector instanceof Stack)) {
                st = (Stack)collector;
              }
              else {
                st = new Stack();
                st.push(collector);
                collector = st;
              }
              st.push(ref);
            }
          }
          i++;
        }
      } }
    return collector;
  }
  
  public static void id$X(Object arg1, Object arg2, CallContext ctx)
  {
    KNode node = (KNode)arg2;
    NodeTree ntree = (NodeTree)sequence;
    gnu.kawa.xml.KDocument root = (gnu.kawa.xml.KDocument)gnu.kawa.xml.Nodes.root(ntree, ipos);
    
    Consumer out = consumer;
    Object idrefs = getIDs(arg1, null);
    if (idrefs == null)
      return;
    ntree.makeIDtableIfNeeded();
    if (((out instanceof gnu.lists.PositionConsumer)) && (((idrefs instanceof String)) || ((out instanceof gnu.kawa.xml.SortedNodes))))
    {
      idScan(idrefs, ntree, (gnu.lists.PositionConsumer)out);
    } else if ((idrefs instanceof String))
    {
      int pos = ntree.lookupID((String)idrefs);
      if (pos != -1) {
        out.writeObject(KNode.make(ntree, pos));
      }
    }
    else {
      gnu.kawa.xml.SortedNodes nodes = new gnu.kawa.xml.SortedNodes();
      idScan(idrefs, ntree, nodes);
      Values.writeValues(nodes, out);
    }
  }
  
  private static void idScan(Object ids, NodeTree seq, gnu.lists.PositionConsumer out)
  {
    if ((ids instanceof String))
    {
      int pos = seq.lookupID((String)ids);
      if (pos != -1) {
        out.writePosition(seq, pos);
      }
    } else if ((ids instanceof Stack))
    {
      Stack st = (Stack)ids;
      int n = st.size();
      for (int i = 0; i < n; i++) {
        idScan(st.elementAt(i), seq, out);
      }
    }
  }
  
  public static Object idref(Object arg1, Object arg2) {
    KNode node = (KNode)arg2;
    gnu.kawa.xml.KDocument root = (gnu.kawa.xml.KDocument)gnu.kawa.xml.Nodes.root((NodeTree)sequence, node.getPos());
    
    return Values.empty;
  }
  

  static String collectionNamespace = "http://gnu.org/kawa/cached-collections";
  


  public static void setSavedCollection(Object uri, Object value, Environment env)
  {
    if (uri == null)
      uri = "#default";
    Symbol sym = Symbol.make(collectionNamespace, uri.toString());
    env.put(sym, null, value);
  }
  

  public static void setSavedCollection(Object uri, Object value)
  {
    setSavedCollection(uri, value, Environment.getCurrent());
  }
  



  public static Object getSavedCollection(Object uri, Environment env)
  {
    if (uri == null)
      uri = "#default";
    Symbol sym = Symbol.make(collectionNamespace, uri.toString());
    Object coll = env.get(sym, null, null);
    if (coll == null)
      throw new RuntimeException("collection '" + uri + "' not found");
    return coll;
  }
  



  public static Object getSavedCollection(Object uri)
  {
    return getSavedCollection(uri, Environment.getCurrent());
  }
  

  public static final Symbol collectionResolverSymbol = Symbol.make("http://www.w3.org/2005/xquery-local-functions", "collection-resolver", "qexo");
  

  public static Object collection(Object uri, Object base)
    throws Throwable
  {
    uri = resolve(uri, base, "collection");
    Environment env = Environment.getCurrent();
    Symbol rsym = collectionResolverSymbol;
    Object rvalue = env.get(rsym, null, null);
    if (rvalue == null)
    {
      rvalue = env.get(Symbol.makeWithUnknownNamespace(rsym.getLocalName(), rsym.getPrefix()), null, null);
    }
    



    if (rvalue == null)
    {
      return getSavedCollection(uri); }
    String str;
    int colon; if ((((rvalue instanceof String)) || ((rvalue instanceof gnu.kawa.xml.UntypedAtomic))) && ((colon = (str = rvalue.toString()).indexOf(':')) > 0))
    {

      String cname = str.substring(0, colon);
      String mname = str.substring(colon + 1);
      Class rclass;
      try
      {
        rclass = Class.forName(cname);
      }
      catch (ClassNotFoundException ex)
      {
        throw new RuntimeException("invalid collection-resolver: class " + cname + " not found");
      }
      catch (Exception ex)
      {
        throw new RuntimeException("invalid collection-resolver: " + ex);
      }
      gnu.bytecode.ClassType rclassType = (gnu.bytecode.ClassType)gnu.bytecode.ClassType.make(rclass);
      rvalue = gnu.kawa.reflect.ClassMethods.apply(rclassType, mname, '\000', gnu.xquery.lang.XQuery.instance);
      if (rvalue == null)
        throw new RuntimeException("invalid collection-resolver: no method " + mname + " in " + cname);
    }
    if (!(rvalue instanceof gnu.mapping.Procedure))
      throw new RuntimeException("invalid collection-resolver: " + rvalue);
    return ((gnu.mapping.Procedure)rvalue).apply1(uri);
  }
  
  static Object resolve(Object uri, Object base, String fname)
    throws Throwable
  {
    if ((!(uri instanceof java.io.File)) && (!(uri instanceof gnu.kawa.io.Path)) && (!(uri instanceof java.net.URI)) && (!(uri instanceof java.net.URL)))
    {




      uri = StringUtils.coerceToString(uri, fname, 1, null); }
    if ((uri == Values.empty) || (uri == null))
      return null;
    return gnu.kawa.io.Path.valueOf(base).resolve(gnu.kawa.io.Path.valueOf(uri));
  }
  




  public static Object docCached(Object uri, Object base)
    throws Throwable
  {
    uri = resolve(uri, base, "doc");
    if (uri == null)
      return Values.empty;
    return gnu.kawa.xml.Document.parseCached(uri);
  }
  





  public static boolean availableCached(Object uri, Object base)
    throws Throwable
  {
    uri = resolve(uri, base, "doc-available");
    if (uri == null) {
      return false;
    }
    try {
      gnu.kawa.xml.Document.parseCached(uri);
      return true;
    }
    catch (Exception ex) {}
    
    return false;
  }
}
