package gnu.kawa.xml;

import gnu.kawa.io.Path;
import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xml.NodeTree;
import gnu.xml.XMLParser;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;




public class Document
{
  public static final Document document = new Document();
  
  public Document() {}
  
  public static void parse(Object name, Consumer out) throws Throwable { SourceMessages messages = new SourceMessages();
    if ((out instanceof XConsumer))
      ((XConsumer)out).beginEntity(name);
    XMLParser.parse(name, messages, out);
    if (messages.seenErrors()) {
      throw new SyntaxException("document function read invalid XML", messages);
    }
    if ((out instanceof XConsumer)) {
      ((XConsumer)out).endEntity();
    }
  }
  
  public static KDocument parse(Object uri) throws Throwable {
    NodeTree tree = new NodeTree();
    parse(uri, tree);
    return new KDocument(tree, 10);
  }
  
  private static ThreadLocal<HashMap<Path, KDocument>> docMapLocation = new ThreadLocal();
  


  private static HashMap cache = new HashMap();
  
  private static class DocReference
    extends SoftReference
  {
    static ReferenceQueue queue = new ReferenceQueue();
    Path key;
    
    public DocReference(Path key, KDocument doc) {
      super(queue);
      this.key = key;
    }
  }
  


  public static void clearLocalCache()
  {
    docMapLocation.set(null);
  }
  


  public static void clearSoftCache()
  {
    cache = new HashMap();
  }
  

  public static KDocument parseCached(Object uri)
    throws Throwable
  {
    return parseCached(Path.valueOf(uri));
  }
  

  public static synchronized KDocument parseCached(Path uri)
    throws Throwable
  {
    for (;;)
    {
      DocReference oldref = (DocReference)DocReference.queue.poll();
      if (oldref == null)
        break;
      cache.remove(key);
    }
    
    HashMap<Path, KDocument> map = (HashMap)docMapLocation.get();
    if (map == null)
    {
      map = new HashMap();
      docMapLocation.set(map);
    }
    KDocument doc = (KDocument)map.get(uri);
    if (doc != null) {
      return doc;
    }
    DocReference ref = (DocReference)cache.get(uri);
    if (ref != null)
    {
      doc = (KDocument)ref.get();
      if (doc == null) {
        cache.remove(uri);
      }
      else {
        map.put(uri, doc);
        return doc;
      }
    }
    
    doc = parse(uri);
    map.put(uri, doc);
    
    cache.put(uri, new DocReference(uri, doc));
    
    return doc;
  }
}
