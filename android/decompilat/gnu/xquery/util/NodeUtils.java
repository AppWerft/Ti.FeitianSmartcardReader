// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.kawa.xml.Document;
import java.net.URL;
import java.net.URI;
import java.io.File;
import gnu.mapping.Procedure;
import gnu.expr.Language;
import gnu.bytecode.ObjectType;
import gnu.kawa.reflect.ClassMethods;
import gnu.xquery.lang.XQuery;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.kawa.xml.UntypedAtomic;
import gnu.mapping.Environment;
import gnu.lists.AbstractSequence;
import gnu.kawa.xml.SortedNodes;
import gnu.lists.PositionConsumer;
import java.util.Stack;
import gnu.kawa.io.Path;
import gnu.xml.TextUtils;
import gnu.kawa.xml.KDocument;
import gnu.kawa.xml.Nodes;
import gnu.xml.NodeTree;
import gnu.kawa.xml.KElement;
import gnu.mapping.CallContext;
import gnu.xml.NamespaceBinding;
import gnu.lists.Consumer;
import gnu.xml.XName;
import gnu.mapping.WrongType;
import gnu.kawa.xml.KNode;
import gnu.mapping.Values;
import gnu.mapping.Symbol;

public class NodeUtils
{
    static String collectionNamespace;
    public static final Symbol collectionResolverSymbol;
    
    public static Object nodeName(final Object node) {
        if (node == Values.empty || node == null) {
            return node;
        }
        if (!(node instanceof KNode)) {
            throw new WrongType("node-name", 1, node, "node()?");
        }
        final Object sym = ((KNode)node).getNodeSymbol();
        if (sym == null) {
            return Values.empty;
        }
        return sym;
    }
    
    public static String name(final Object node) {
        if (node == Values.empty || node == null) {
            return "";
        }
        final Object name = ((KNode)node).getNodeNameObject();
        if (name == null || name == Values.empty) {
            return "";
        }
        return name.toString();
    }
    
    public static String localName(final Object node) {
        if (node == Values.empty || node == null) {
            return "";
        }
        if (!(node instanceof KNode)) {
            throw new WrongType("local-name", 1, node, "node()?");
        }
        final Object name = ((KNode)node).getNodeNameObject();
        if (name == null || name == Values.empty) {
            return "";
        }
        if (name instanceof Symbol) {
            return ((Symbol)name).getName();
        }
        return name.toString();
    }
    
    public static Object namespaceURI(final Object node) {
        if (node != Values.empty && node != null) {
            if (!(node instanceof KNode)) {
                throw new WrongType("namespace-uri", 1, node, "node()?");
            }
            final Object name = ((KNode)node).getNodeNameObject();
            if (name instanceof Symbol) {
                return QNameUtils.namespaceURIFromQName(name);
            }
        }
        return "";
    }
    
    public static void prefixesFromNodetype(final XName name, final Consumer out) {
        NamespaceBinding ns;
    Label_0084:
        for (NamespaceBinding bindings = ns = name.getNamespaceNodes(); ns != null; ns = ns.getNext()) {
            final String uri = ns.getUri();
            if (uri != null) {
                final String prefix = ns.getPrefix();
                for (NamespaceBinding ns2 = bindings; ns2 != ns; ns2 = ns2.getNext()) {
                    if (ns2.getPrefix() == prefix) {
                        continue Label_0084;
                    }
                }
                out.writeObject((prefix == null) ? "" : prefix);
            }
        }
    }
    
    public static void inScopePrefixes$X(final Object node, final CallContext ctx) {
        final KElement element = (KElement)node;
        final Object type = element.getNodeNameObject();
        if (type instanceof XName) {
            prefixesFromNodetype((XName)type, ctx.consumer);
        }
        else {
            ctx.consumer.writeObject("xml");
        }
    }
    
    public static void data$X(final Object arg, final CallContext ctx) {
        final Consumer out = ctx.consumer;
        if (arg instanceof Values) {
            final Values vals = (Values)arg;
            int ipos = vals.startPos();
            while ((ipos = vals.nextPos(ipos)) != 0) {
                out.writeObject(KNode.atomicValue(vals.getPosPrevious(ipos)));
            }
        }
        else {
            out.writeObject(KNode.atomicValue(arg));
        }
    }
    
    public static Object root(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        if (!(arg instanceof KNode)) {
            throw new WrongType("root", 1, arg, "node()?");
        }
        final KNode node = (KNode)arg;
        return Nodes.root((NodeTree)node.sequence, node.getPos());
    }
    
    public static KDocument rootDocument(final Object arg) {
        if (!(arg instanceof KNode)) {
            throw new WrongType("root-document", 1, arg, "node()?");
        }
        KNode node = (KNode)arg;
        node = Nodes.root((NodeTree)node.sequence, node.getPos());
        if (!(node instanceof KDocument)) {
            throw new WrongType("root-document", 1, arg, "document()");
        }
        return (KDocument)node;
    }
    
    public static String getLang(final KNode node) {
        final NodeTree seq = (NodeTree)node.sequence;
        final int attr = seq.ancestorAttribute(node.ipos, "http://www.w3.org/XML/1998/namespace", "lang");
        if (attr == 0) {
            return null;
        }
        return KNode.getNodeValue(seq, attr);
    }
    
    public static boolean lang(final Object testlang, final Object node) {
        String teststr;
        if (testlang == null || testlang == Values.empty) {
            teststr = "";
        }
        else {
            teststr = TextUtils.stringValue(testlang);
        }
        String lang = getLang((KNode)node);
        if (lang == null) {
            return false;
        }
        final int langlen = lang.length();
        final int testlen = teststr.length();
        if (langlen > testlen && lang.charAt(testlen) == '-') {
            lang = lang.substring(0, testlen);
        }
        return lang.equalsIgnoreCase(teststr);
    }
    
    public static Object documentUri(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        if (!(arg instanceof KNode)) {
            throw new WrongType("xs:document-uri", 1, arg, "node()?");
        }
        final KNode node = (KNode)arg;
        final Object uri = ((NodeTree)node.sequence).documentUriOfPos(node.ipos);
        return (uri == null) ? Values.empty : uri;
    }
    
    public static Object nilled(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        if (!(arg instanceof KNode)) {
            throw new WrongType("nilled", 1, arg, "node()?");
        }
        if (!(arg instanceof KElement)) {
            return Values.empty;
        }
        return Boolean.FALSE;
    }
    
    public static Object baseUri(final Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        if (!(arg instanceof KNode)) {
            throw new WrongType("base-uri", 1, arg, "node()?");
        }
        final Path uri = ((KNode)arg).baseURI();
        if (uri == null) {
            return Values.empty;
        }
        return uri;
    }
    
    static Object getIDs(Object arg, Object collector) {
        if (arg instanceof KNode) {
            arg = KNode.atomicValue(arg);
        }
        if (arg instanceof Values) {
            final Object[] ar = ((Values)arg).getValues();
            int i = ar.length;
            while (--i >= 0) {
                collector = getIDs(ar[i], collector);
            }
        }
        else {
            final String str = StringUtils.coerceToString(arg, "fn:id", 1, "");
            final int len = str.length();
            int j = 0;
            while (j < len) {
                char ch = str.charAt(j++);
                if (Character.isWhitespace(ch)) {
                    continue;
                }
                int start = XName.isNameStart(ch) ? (j - 1) : len;
                while (j < len) {
                    ch = str.charAt(j);
                    if (Character.isWhitespace(ch)) {
                        break;
                    }
                    ++j;
                    if (start >= len || XName.isNamePart(ch)) {
                        continue;
                    }
                    start = len;
                }
                if (start < len) {
                    final String ref = str.substring(start, j);
                    if (collector == null) {
                        collector = ref;
                    }
                    else {
                        Stack st;
                        if (collector instanceof Stack) {
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
                ++j;
            }
        }
        return collector;
    }
    
    public static void id$X(final Object arg1, final Object arg2, final CallContext ctx) {
        final KNode node = (KNode)arg2;
        final NodeTree ntree = (NodeTree)node.sequence;
        final KDocument root = (KDocument)Nodes.root(ntree, node.ipos);
        final Consumer out = ctx.consumer;
        final Object idrefs = getIDs(arg1, null);
        if (idrefs == null) {
            return;
        }
        ntree.makeIDtableIfNeeded();
        if (out instanceof PositionConsumer && (idrefs instanceof String || out instanceof SortedNodes)) {
            idScan(idrefs, ntree, (PositionConsumer)out);
        }
        else if (idrefs instanceof String) {
            final int pos = ntree.lookupID((String)idrefs);
            if (pos != -1) {
                out.writeObject(KNode.make(ntree, pos));
            }
        }
        else {
            final SortedNodes nodes = new SortedNodes();
            idScan(idrefs, ntree, nodes);
            Values.writeValues(nodes, out);
        }
    }
    
    private static void idScan(final Object ids, final NodeTree seq, final PositionConsumer out) {
        if (ids instanceof String) {
            final int pos = seq.lookupID((String)ids);
            if (pos != -1) {
                out.writePosition(seq, pos);
            }
        }
        else if (ids instanceof Stack) {
            final Stack st = (Stack)ids;
            for (int n = st.size(), i = 0; i < n; ++i) {
                idScan(st.elementAt(i), seq, out);
            }
        }
    }
    
    public static Object idref(final Object arg1, final Object arg2) {
        final KNode node = (KNode)arg2;
        final KDocument root = (KDocument)Nodes.root((NodeTree)node.sequence, node.getPos());
        return Values.empty;
    }
    
    public static void setSavedCollection(Object uri, final Object value, final Environment env) {
        if (uri == null) {
            uri = "#default";
        }
        final Symbol sym = Symbol.make(NodeUtils.collectionNamespace, uri.toString());
        env.put(sym, null, value);
    }
    
    public static void setSavedCollection(final Object uri, final Object value) {
        setSavedCollection(uri, value, Environment.getCurrent());
    }
    
    public static Object getSavedCollection(Object uri, final Environment env) {
        if (uri == null) {
            uri = "#default";
        }
        final Symbol sym = Symbol.make(NodeUtils.collectionNamespace, uri.toString());
        final Object coll = env.get(sym, null, null);
        if (coll == null) {
            throw new RuntimeException("collection '" + uri + "' not found");
        }
        return coll;
    }
    
    public static Object getSavedCollection(final Object uri) {
        return getSavedCollection(uri, Environment.getCurrent());
    }
    
    public static Object collection(Object uri, final Object base) throws Throwable {
        uri = resolve(uri, base, "collection");
        final Environment env = Environment.getCurrent();
        final Symbol rsym = NodeUtils.collectionResolverSymbol;
        Object rvalue = env.get(rsym, null, null);
        if (rvalue == null) {
            rvalue = env.get(Symbol.makeWithUnknownNamespace(rsym.getLocalName(), rsym.getPrefix()), null, null);
        }
        if (rvalue == null) {
            return getSavedCollection(uri);
        }
        final String str;
        final int colon;
        if ((rvalue instanceof String || rvalue instanceof UntypedAtomic) && (colon = (str = rvalue.toString()).indexOf(58)) > 0) {
            final String cname = str.substring(0, colon);
            final String mname = str.substring(colon + 1);
            Class rclass;
            try {
                rclass = Class.forName(cname);
            }
            catch (ClassNotFoundException ex2) {
                throw new RuntimeException("invalid collection-resolver: class " + cname + " not found");
            }
            catch (Exception ex) {
                throw new RuntimeException("invalid collection-resolver: " + ex);
            }
            final ClassType rclassType = (ClassType)Type.make(rclass);
            rvalue = ClassMethods.apply(rclassType, mname, '\0', XQuery.instance);
            if (rvalue == null) {
                throw new RuntimeException("invalid collection-resolver: no method " + mname + " in " + cname);
            }
        }
        if (!(rvalue instanceof Procedure)) {
            throw new RuntimeException("invalid collection-resolver: " + rvalue);
        }
        return ((Procedure)rvalue).apply1(uri);
    }
    
    static Object resolve(Object uri, final Object base, final String fname) throws Throwable {
        if (!(uri instanceof File) && !(uri instanceof Path) && !(uri instanceof URI) && !(uri instanceof URL)) {
            uri = StringUtils.coerceToString(uri, fname, 1, null);
        }
        if (uri == Values.empty || uri == null) {
            return null;
        }
        return Path.valueOf(base).resolve(Path.valueOf(uri));
    }
    
    public static Object docCached(Object uri, final Object base) throws Throwable {
        uri = resolve(uri, base, "doc");
        if (uri == null) {
            return Values.empty;
        }
        return Document.parseCached(uri);
    }
    
    public static boolean availableCached(Object uri, final Object base) throws Throwable {
        uri = resolve(uri, base, "doc-available");
        if (uri == null) {
            return false;
        }
        try {
            Document.parseCached(uri);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    static {
        NodeUtils.collectionNamespace = "http://gnu.org/kawa/cached-collections";
        collectionResolverSymbol = Symbol.make("http://www.w3.org/2005/xquery-local-functions", "collection-resolver", "qexo");
    }
}
