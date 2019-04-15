/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.kawa.io.Path;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.xml.Document;
import gnu.kawa.xml.KDocument;
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.Nodes;
import gnu.kawa.xml.SortedNodes;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.xml.NamespaceBinding;
import gnu.xml.NodeTree;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import gnu.xquery.lang.XQuery;
import gnu.xquery.util.QNameUtils;
import gnu.xquery.util.StringUtils;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Stack;

public class NodeUtils {
    static String collectionNamespace = "http://gnu.org/kawa/cached-collections";
    public static final Symbol collectionResolverSymbol = Symbol.make("http://www.w3.org/2005/xquery-local-functions", "collection-resolver", "qexo");

    public static Object nodeName(Object node) {
        if (node == Values.empty || node == null) {
            return node;
        }
        if (!(node instanceof KNode)) {
            throw new WrongType("node-name", 1, node, "node()?");
        }
        Symbol sym = ((KNode)node).getNodeSymbol();
        if (sym == null) {
            return Values.empty;
        }
        return sym;
    }

    public static String name(Object node) {
        if (node == Values.empty || node == null) {
            return "";
        }
        Object name = ((KNode)node).getNodeNameObject();
        if (name == null || name == Values.empty) {
            return "";
        }
        return name.toString();
    }

    public static String localName(Object node) {
        if (node == Values.empty || node == null) {
            return "";
        }
        if (!(node instanceof KNode)) {
            throw new WrongType("local-name", 1, node, "node()?");
        }
        Object name = ((KNode)node).getNodeNameObject();
        if (name == null || name == Values.empty) {
            return "";
        }
        if (name instanceof Symbol) {
            return ((Symbol)name).getName();
        }
        return name.toString();
    }

    public static Object namespaceURI(Object node) {
        if (node != Values.empty && node != null) {
            if (!(node instanceof KNode)) {
                throw new WrongType("namespace-uri", 1, node, "node()?");
            }
            Object name = ((KNode)node).getNodeNameObject();
            if (name instanceof Symbol) {
                return QNameUtils.namespaceURIFromQName(name);
            }
        }
        return "";
    }

    public static void prefixesFromNodetype(XName name, Consumer out) {
        NamespaceBinding bindings;
        block0 : for (NamespaceBinding ns = bindings = name.getNamespaceNodes(); ns != null; ns = ns.getNext()) {
            String uri = ns.getUri();
            if (uri == null) continue;
            String prefix = ns.getPrefix();
            NamespaceBinding ns2 = bindings;
            do {
                if (ns2 == ns) {
                    out.writeObject(prefix == null ? "" : prefix);
                    continue block0;
                }
                if (ns2.getPrefix() == prefix) continue block0;
                ns2 = ns2.getNext();
            } while (true);
        }
    }

    public static void inScopePrefixes$X(Object node, CallContext ctx) {
        KElement element = (KElement)node;
        Object type = element.getNodeNameObject();
        if (type instanceof XName) {
            NodeUtils.prefixesFromNodetype((XName)type, ctx.consumer);
        } else {
            ctx.consumer.writeObject("xml");
        }
    }

    public static void data$X(Object arg, CallContext ctx) {
        Consumer out = ctx.consumer;
        if (arg instanceof Values) {
            Values vals = (Values)arg;
            int ipos = vals.startPos();
            while ((ipos = vals.nextPos(ipos)) != 0) {
                out.writeObject(KNode.atomicValue(vals.getPosPrevious(ipos)));
            }
        } else {
            out.writeObject(KNode.atomicValue(arg));
        }
    }

    public static Object root(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        if (!(arg instanceof KNode)) {
            throw new WrongType("root", 1, arg, "node()?");
        }
        KNode node = (KNode)arg;
        return Nodes.root((NodeTree)node.sequence, node.getPos());
    }

    public static KDocument rootDocument(Object arg) {
        if (!(arg instanceof KNode)) {
            throw new WrongType("root-document", 1, arg, "node()?");
        }
        KNode node = (KNode)arg;
        if (!((node = Nodes.root((NodeTree)node.sequence, node.getPos())) instanceof KDocument)) {
            throw new WrongType("root-document", 1, arg, "document()");
        }
        return (KDocument)node;
    }

    public static String getLang(KNode node) {
        NodeTree seq = (NodeTree)node.sequence;
        int attr = seq.ancestorAttribute(node.ipos, "http://www.w3.org/XML/1998/namespace", "lang");
        if (attr == 0) {
            return null;
        }
        return KNode.getNodeValue(seq, attr);
    }

    public static boolean lang(Object testlang, Object node) {
        int testlen;
        String teststr = testlang == null || testlang == Values.empty ? "" : TextUtils.stringValue(testlang);
        String lang = NodeUtils.getLang((KNode)node);
        if (lang == null) {
            return false;
        }
        int langlen = lang.length();
        if (langlen > (testlen = teststr.length()) && lang.charAt(testlen) == '-') {
            lang = lang.substring(0, testlen);
        }
        return lang.equalsIgnoreCase(teststr);
    }

    public static Object documentUri(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        if (!(arg instanceof KNode)) {
            throw new WrongType("xs:document-uri", 1, arg, "node()?");
        }
        KNode node = (KNode)arg;
        Object uri = ((NodeTree)node.sequence).documentUriOfPos(node.ipos);
        return uri == null ? Values.empty : uri;
    }

    public static Object nilled(Object arg) {
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

    public static Object baseUri(Object arg) {
        if (arg == null || arg == Values.empty) {
            return arg;
        }
        if (!(arg instanceof KNode)) {
            throw new WrongType("base-uri", 1, arg, "node()?");
        }
        Path uri = ((KNode)arg).baseURI();
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
            Object[] ar = ((Values)arg).getValues();
            int i = ar.length;
            while (--i >= 0) {
                collector = NodeUtils.getIDs(ar[i], collector);
            }
        } else {
            String str = StringUtils.coerceToString(arg, "fn:id", 1, "");
            int len = str.length();
            int i = 0;
            while (i < len) {
                int start;
                char ch;
                if (Character.isWhitespace(ch = str.charAt(i++))) continue;
                int n = start = XName.isNameStart(ch) ? i - 1 : len;
                while (i < len && !Character.isWhitespace(ch = str.charAt(i))) {
                    ++i;
                    if (start >= len || XName.isNamePart(ch)) continue;
                    start = len;
                }
                if (start < len) {
                    String ref = str.substring(start, i);
                    if (collector == null) {
                        collector = ref;
                    } else {
                        Stack<Object> st;
                        if (collector instanceof Stack) {
                            st = collector;
                        } else {
                            st = new Stack<Object>();
                            st.push(collector);
                            collector = st;
                        }
                        st.push(ref);
                    }
                }
                ++i;
            }
        }
        return collector;
    }

    public static void id$X(Object arg1, Object arg2, CallContext ctx) {
        KNode node = (KNode)arg2;
        NodeTree ntree = (NodeTree)node.sequence;
        KDocument root = (KDocument)Nodes.root(ntree, node.ipos);
        Consumer out = ctx.consumer;
        Object idrefs = NodeUtils.getIDs(arg1, null);
        if (idrefs == null) {
            return;
        }
        ntree.makeIDtableIfNeeded();
        if (out instanceof PositionConsumer && (idrefs instanceof String || out instanceof SortedNodes)) {
            NodeUtils.idScan(idrefs, ntree, (PositionConsumer)((Object)out));
        } else if (idrefs instanceof String) {
            int pos = ntree.lookupID((String)idrefs);
            if (pos != -1) {
                out.writeObject(KNode.make(ntree, pos));
            }
        } else {
            SortedNodes nodes = new SortedNodes();
            NodeUtils.idScan(idrefs, ntree, nodes);
            Values.writeValues(nodes, out);
        }
    }

    private static void idScan(Object ids, NodeTree seq, PositionConsumer out) {
        if (ids instanceof String) {
            int pos = seq.lookupID((String)ids);
            if (pos != -1) {
                out.writePosition(seq, pos);
            }
        } else if (ids instanceof Stack) {
            Stack st = (Stack)ids;
            int n = st.size();
            for (int i = 0; i < n; ++i) {
                NodeUtils.idScan(st.elementAt(i), seq, out);
            }
        }
    }

    public static Object idref(Object arg1, Object arg2) {
        KNode node = (KNode)arg2;
        KDocument root = (KDocument)Nodes.root((NodeTree)node.sequence, node.getPos());
        return Values.empty;
    }

    public static void setSavedCollection(Object uri, Object value, Environment env) {
        if (uri == null) {
            uri = "#default";
        }
        Symbol sym = Symbol.make(collectionNamespace, uri.toString());
        env.put(sym, null, value);
    }

    public static void setSavedCollection(Object uri, Object value) {
        NodeUtils.setSavedCollection(uri, value, Environment.getCurrent());
    }

    public static Object getSavedCollection(Object uri, Environment env) {
        Object coll;
        Symbol sym;
        if (uri == null) {
            uri = "#default";
        }
        if ((coll = env.get(sym = Symbol.make(collectionNamespace, uri.toString()), null, null)) == null) {
            throw new RuntimeException("collection '" + uri + "' not found");
        }
        return coll;
    }

    public static Object getSavedCollection(Object uri) {
        return NodeUtils.getSavedCollection(uri, Environment.getCurrent());
    }

    public static Object collection(Object uri, Object base2) throws Throwable {
        String str;
        int colon;
        Symbol rsym;
        uri = NodeUtils.resolve(uri, base2, "collection");
        Environment env = Environment.getCurrent();
        Object rvalue = env.get(rsym = collectionResolverSymbol, null, null);
        if (rvalue == null) {
            rvalue = env.get(Symbol.makeWithUnknownNamespace(rsym.getLocalName(), rsym.getPrefix()), null, null);
        }
        if (rvalue == null) {
            return NodeUtils.getSavedCollection(uri);
        }
        if ((rvalue instanceof String || rvalue instanceof UntypedAtomic) && (colon = (str = rvalue.toString()).indexOf(58)) > 0) {
            Class<?> rclass;
            String cname = str.substring(0, colon);
            String mname = str.substring(colon + 1);
            try {
                rclass = Class.forName(cname);
            }
            catch (ClassNotFoundException ex) {
                throw new RuntimeException("invalid collection-resolver: class " + cname + " not found");
            }
            catch (Exception ex) {
                throw new RuntimeException("invalid collection-resolver: " + ex);
            }
            ClassType rclassType = (ClassType)ClassType.make(rclass);
            rvalue = ClassMethods.apply(rclassType, mname, '\u0000', XQuery.instance);
            if (rvalue == null) {
                throw new RuntimeException("invalid collection-resolver: no method " + mname + " in " + cname);
            }
        }
        if (!(rvalue instanceof Procedure)) {
            throw new RuntimeException("invalid collection-resolver: " + rvalue);
        }
        return ((Procedure)rvalue).apply1(uri);
    }

    static Object resolve(Object uri, Object base2, String fname) throws Throwable {
        if (!(uri instanceof File || uri instanceof Path || uri instanceof URI || uri instanceof URL)) {
            uri = StringUtils.coerceToString(uri, fname, 1, null);
        }
        if (uri == Values.empty || uri == null) {
            return null;
        }
        return Path.valueOf(base2).resolve(Path.valueOf(uri));
    }

    public static Object docCached(Object uri, Object base2) throws Throwable {
        if ((uri = NodeUtils.resolve(uri, base2, "doc")) == null) {
            return Values.empty;
        }
        return Document.parseCached(uri);
    }

    public static boolean availableCached(Object uri, Object base2) throws Throwable {
        if ((uri = NodeUtils.resolve(uri, base2, "doc-available")) == null) {
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
}

