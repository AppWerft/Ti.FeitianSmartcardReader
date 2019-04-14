package gnu.xml;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;



public final class NamespaceBinding
  implements Externalizable
{
  String prefix;
  String uri;
  NamespaceBinding next;
  int depth;
  public static final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";
  
  public final String getPrefix() { return prefix; }
  public final void setPrefix(String prefix) { this.prefix = prefix; }
  





  public final String getUri() { return uri; }
  public final void setUri(String uri) { this.uri = uri; }
  





  public final NamespaceBinding getNext() { return next; }
  
  public final void setNext(NamespaceBinding next) {
    this.next = next;
    depth = (next == null ? 0 : depth + 1);
  }
  




  public static final NamespaceBinding nconc(NamespaceBinding list1, NamespaceBinding list2)
  {
    if (list1 == null)
      return list2;
    list1.setNext(nconc(next, list2));
    return list1;
  }
  


  public NamespaceBinding(String prefix, String uri, NamespaceBinding next)
  {
    this.prefix = prefix;
    this.uri = uri;
    setNext(next);
  }
  



  public static final NamespaceBinding predefinedXML = new NamespaceBinding("xml", "http://www.w3.org/XML/1998/namespace", null);
  





  public String resolve(String prefix)
  {
    for (NamespaceBinding ns = this; ns != null; ns = next)
    {
      if (prefix == prefix)
        return uri;
    }
    return null;
  }
  





  public String resolve(String prefix, NamespaceBinding fencePost)
  {
    for (NamespaceBinding ns = this; ns != fencePost; ns = next)
    {
      if (prefix == prefix)
        return uri;
    }
    return null;
  }
  

  public static NamespaceBinding commonAncestor(NamespaceBinding ns1, NamespaceBinding ns2)
  {
    if (depth > depth)
    {
      NamespaceBinding tmp = ns1;
      ns1 = ns2;
      ns2 = tmp;
    }
    while (depth > depth)
      ns2 = next;
    while (ns1 != ns2)
    {
      ns1 = next;
      ns2 = next;
    }
    return ns1;
  }
  




















  public NamespaceBinding reversePrefix(NamespaceBinding fencePost)
  {
    NamespaceBinding prev = fencePost;
    NamespaceBinding t = this;
    int depth = fencePost == null ? -1 : depth;
    while (t != fencePost)
    {
      NamespaceBinding next = next;
      next = prev;
      prev = t;
      depth = (++depth);
      t = next;
    }
    return prev;
  }
  

  public int count(NamespaceBinding fencePost)
  {
    int count = 0;
    for (NamespaceBinding ns = this; ns != fencePost; ns = next)
      count++;
    return count;
  }
  


  public static NamespaceBinding maybeAdd(String prefix, String uri, NamespaceBinding bindings)
  {
    if (bindings == null)
    {
      if (uri == null)
        return bindings;
      bindings = predefinedXML;
    }
    String found = bindings.resolve(prefix);
    if (found == null ? uri == null : found.equals(uri))
      return bindings;
    return new NamespaceBinding(prefix, uri, bindings);
  }
  

  public String toString()
  {
    return "Namespace{" + prefix + "=" + uri + ", depth:" + depth + "}";
  }
  

  public String toStringAll()
  {
    StringBuffer sbuf = new StringBuffer("Namespaces{");
    for (NamespaceBinding ns = this; ns != null; ns = next)
    {
      sbuf.append(prefix);
      sbuf.append("=\"");
      sbuf.append(uri);
      sbuf.append(ns == null ? "\"" : "\", ");
    }
    sbuf.append('}');
    return sbuf.toString();
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    out.writeUTF(prefix);
    out.writeUTF(uri);
    out.writeObject(next);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    prefix = in.readUTF();
    uri = in.readUTF();
    next = ((NamespaceBinding)in.readObject());
  }
}
