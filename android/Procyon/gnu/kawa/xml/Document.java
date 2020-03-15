// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import gnu.xml.NodeTree;
import gnu.text.SyntaxException;
import gnu.xml.XMLParser;
import gnu.lists.XConsumer;
import gnu.text.SourceMessages;
import gnu.lists.Consumer;
import gnu.kawa.io.Path;
import java.util.HashMap;

public class Document
{
    public static final Document document;
    private static ThreadLocal<HashMap<Path, KDocument>> docMapLocation;
    private static HashMap cache;
    
    public static void parse(final Object name, final Consumer out) throws Throwable {
        final SourceMessages messages = new SourceMessages();
        if (out instanceof XConsumer) {
            ((XConsumer)out).beginEntity(name);
        }
        XMLParser.parse(name, messages, out);
        if (messages.seenErrors()) {
            throw new SyntaxException("document function read invalid XML", messages);
        }
        if (out instanceof XConsumer) {
            ((XConsumer)out).endEntity();
        }
    }
    
    public static KDocument parse(final Object uri) throws Throwable {
        final NodeTree tree = new NodeTree();
        parse(uri, tree);
        return new KDocument(tree, 10);
    }
    
    public static void clearLocalCache() {
        Document.docMapLocation.set(null);
    }
    
    public static void clearSoftCache() {
        Document.cache = new HashMap();
    }
    
    public static KDocument parseCached(final Object uri) throws Throwable {
        return parseCached(Path.valueOf(uri));
    }
    
    public static synchronized KDocument parseCached(final Path uri) throws Throwable {
        while (true) {
            final DocReference oldref = (DocReference)DocReference.queue.poll();
            if (oldref == null) {
                break;
            }
            Document.cache.remove(oldref.key);
        }
        HashMap<Path, KDocument> map = Document.docMapLocation.get();
        if (map == null) {
            map = new HashMap<Path, KDocument>();
            Document.docMapLocation.set(map);
        }
        KDocument doc = map.get(uri);
        if (doc != null) {
            return doc;
        }
        final DocReference ref = Document.cache.get(uri);
        if (ref != null) {
            doc = ref.get();
            if (doc != null) {
                map.put(uri, doc);
                return doc;
            }
            Document.cache.remove(uri);
        }
        doc = parse(uri);
        map.put(uri, doc);
        Document.cache.put(uri, new DocReference(uri, doc));
        return doc;
    }
    
    static {
        document = new Document();
        Document.docMapLocation = new ThreadLocal<HashMap<Path, KDocument>>();
        Document.cache = new HashMap();
    }
    
    private static class DocReference extends SoftReference
    {
        static ReferenceQueue queue;
        Path key;
        
        public DocReference(final Path key, final KDocument doc) {
            super(doc, DocReference.queue);
            this.key = key;
        }
        
        static {
            DocReference.queue = new ReferenceQueue();
        }
    }
}
