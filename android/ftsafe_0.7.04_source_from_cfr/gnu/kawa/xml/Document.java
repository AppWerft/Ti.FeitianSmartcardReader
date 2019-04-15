/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.io.Path;
import gnu.kawa.xml.KDocument;
import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xml.NodeTree;
import gnu.xml.XMLParser;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class Document {
    public static final Document document = new Document();
    private static ThreadLocal<HashMap<Path, KDocument>> docMapLocation = new ThreadLocal();
    private static HashMap cache = new HashMap();

    public static void parse(Object name, Consumer out) throws Throwable {
        SourceMessages messages = new SourceMessages();
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

    public static KDocument parse(Object uri) throws Throwable {
        NodeTree tree = new NodeTree();
        Document.parse(uri, tree);
        return new KDocument(tree, 10);
    }

    public static void clearLocalCache() {
        docMapLocation.set(null);
    }

    public static void clearSoftCache() {
        cache = new HashMap();
    }

    public static KDocument parseCached(Object uri) throws Throwable {
        return Document.parseCached(Path.valueOf(uri));
    }

    public static synchronized KDocument parseCached(Path uri) throws Throwable {
        KDocument doc;
        DocReference oldref;
        while ((oldref = (DocReference)DocReference.queue.poll()) != null) {
            cache.remove(oldref.key);
        }
        HashMap<Path, KDocument> map = docMapLocation.get();
        if (map == null) {
            map = new HashMap();
            docMapLocation.set(map);
        }
        if ((doc = map.get(uri)) != null) {
            return doc;
        }
        DocReference ref = (DocReference)cache.get(uri);
        if (ref != null) {
            doc = (KDocument)ref.get();
            if (doc == null) {
                cache.remove(uri);
            } else {
                map.put(uri, doc);
                return doc;
            }
        }
        doc = Document.parse(uri);
        map.put(uri, doc);
        cache.put(uri, new DocReference(uri, doc));
        return doc;
    }

    private static class DocReference
    extends SoftReference {
        static ReferenceQueue queue = new ReferenceQueue();
        Path key;

        public DocReference(Path key, KDocument doc) {
            super(doc, queue);
            this.key = key;
        }
    }

}

