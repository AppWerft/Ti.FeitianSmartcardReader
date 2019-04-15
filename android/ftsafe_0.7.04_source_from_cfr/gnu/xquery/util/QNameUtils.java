/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XStringType;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.xml.NamespaceBinding;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import java.net.URISyntaxException;

public class QNameUtils {
    public static Object resolveQNameUsingElement(Object qname, KElement node) {
        String prefix;
        String localPart;
        if ((qname = KNode.atomicValue(qname)) == Values.empty || qname == null) {
            return qname;
        }
        if (qname instanceof Values || !(qname instanceof String) && !(qname instanceof UntypedAtomic)) {
            throw new RuntimeException("bad argument to QName");
        }
        String name = TextUtils.replaceWhitespace(qname.toString(), true);
        int colon = name.indexOf(58);
        if (colon < 0) {
            prefix = null;
            localPart = name;
        } else {
            prefix = name.substring(0, colon).intern();
            localPart = name.substring(colon + 1);
        }
        String uri = node.lookupNamespaceURI(prefix);
        if (uri == null) {
            if (prefix == null) {
                uri = "";
            } else {
                throw new RuntimeException("unknown namespace for '" + name + "'");
            }
        }
        if (!QNameUtils.validNCName(localPart) || prefix != null && !QNameUtils.validNCName(prefix)) {
            throw new RuntimeException("invalid QName syntax '" + name + "'");
        }
        return Symbol.make(uri, localPart, prefix == null ? "" : prefix);
    }

    public static Object resolveQName(Object qname, NamespaceBinding constructorNamespaces, NamespaceBinding prologNamespaces) {
        String prefix;
        String localPart;
        if ((qname = KNode.atomicValue(qname)) instanceof Symbol) {
            return qname;
        }
        if (qname instanceof Values || !(qname instanceof String) && !(qname instanceof UntypedAtomic)) {
            throw new RuntimeException("bad argument to QName");
        }
        String name = TextUtils.replaceWhitespace(qname.toString(), true);
        int colon = name.indexOf(58);
        if (colon < 0) {
            localPart = name;
            prefix = null;
        } else {
            prefix = name.substring(0, colon).intern();
            localPart = name.substring(colon + 1);
        }
        if (!QNameUtils.validNCName(localPart) || prefix != null && !QNameUtils.validNCName(prefix)) {
            throw new RuntimeException("invalid QName syntax '" + name + "'");
        }
        String uri = QNameUtils.resolvePrefix(prefix, constructorNamespaces, prologNamespaces);
        return Symbol.make(uri, localPart, prefix == null ? "" : prefix);
    }

    public static String lookupPrefix(String prefix, NamespaceBinding constructorNamespaces, NamespaceBinding prologNamespaces) {
        String uri;
        NamespaceBinding ns = constructorNamespaces;
        do {
            if (ns == null) {
                uri = prologNamespaces.resolve(prefix);
                break;
            }
            if (ns.getPrefix() == prefix) {
                uri = ns.getUri();
                break;
            }
            ns = ns.getNext();
        } while (true);
        if (uri == null && prefix == null) {
            uri = "";
        }
        return uri;
    }

    public static String resolvePrefix(String prefix, NamespaceBinding constructorNamespaces, NamespaceBinding prologNamespaces) {
        String uri = QNameUtils.lookupPrefix(prefix, constructorNamespaces, prologNamespaces);
        if (uri == null) {
            throw new RuntimeException("unknown namespace prefix '" + prefix + "'");
        }
        return uri;
    }

    public static boolean validNCName(String name) {
        return XName.isName(name);
    }

    public static Symbol makeQName(Object paramURI, String paramQName) {
        String prefix;
        String localPart;
        if (paramURI == null || paramURI == Values.empty) {
            paramURI = "";
        }
        int colon = paramQName.indexOf(58);
        String namespaceURI = (String)paramURI;
        if (colon < 0) {
            localPart = paramQName;
            prefix = "";
        } else {
            localPart = paramQName.substring(colon + 1);
            prefix = paramQName.substring(0, colon).intern();
        }
        if (!QNameUtils.validNCName(localPart) || colon >= 0 && !QNameUtils.validNCName(prefix)) {
            throw new IllegalArgumentException("invalid QName syntax '" + paramQName + "'");
        }
        if (colon >= 0 && namespaceURI.length() == 0) {
            throw new IllegalArgumentException("empty uri for '" + paramQName + "'");
        }
        return Symbol.make(namespaceURI, localPart, prefix);
    }

    public static Object localNameFromQName(Object name) {
        if (name == Values.empty || name == null) {
            return name;
        }
        if (!(name instanceof Symbol)) {
            throw new WrongType("local-name-from-QName", 1, name, "xs:QName");
        }
        return XStringType.makeNCName(((Symbol)name).getName());
    }

    public static Object prefixFromQName(Object name) {
        if (name == Values.empty || name == null) {
            return name;
        }
        if (name instanceof Symbol) {
            String prefix = ((Symbol)name).getPrefix();
            if (prefix == null || prefix.length() == 0) {
                return Values.empty;
            }
            return XStringType.makeNCName(prefix);
        }
        throw new WrongType("prefix-from-QName", 1, name, "xs:QName");
    }

    public static Object namespaceURIFromQName(Object name) {
        if (name == Values.empty || name == null) {
            return name;
        }
        try {
            return URIPath.makeURI(((Symbol)name).getNamespaceURI());
        }
        catch (ClassCastException ex) {
            throw new WrongType("namespace-uri", 1, name, "xs:QName");
        }
    }

    public static Object namespaceURIForPrefix(Object prefix, Object element) {
        String str;
        KNode el = KNode.coerce(element);
        if (el == null) {
            throw new WrongType("namespace-uri-for-prefix", 2, element, "node()");
        }
        if (prefix == null || prefix == Values.empty) {
            str = null;
        } else {
            if (!(prefix instanceof String) && !(prefix instanceof UntypedAtomic)) {
                throw new WrongType("namespace-uri-for-prefix", 1, element, "xs:string");
            }
            str = prefix.toString().intern();
            if (str == "") {
                str = null;
            }
        }
        String uri = el.lookupNamespaceURI(str);
        if (uri == null) {
            return Values.empty;
        }
        return uri;
    }

    public static Object resolveURI(Object relative, Object base2) throws URISyntaxException {
        Path baseP;
        if (relative instanceof KNode) {
            relative = KNode.atomicValue(relative);
        }
        if (base2 instanceof KNode) {
            base2 = KNode.atomicValue(base2);
        }
        if (relative == Values.empty || relative == null) {
            return relative;
        }
        if (relative instanceof UntypedAtomic) {
            relative = relative.toString();
        }
        if (base2 instanceof UntypedAtomic) {
            base2 = base2.toString();
        }
        Path path = baseP = base2 instanceof Path ? (Path)base2 : URIPath.makeURI(base2);
        if (relative instanceof Path) {
            return baseP.resolve((Path)relative);
        }
        return baseP.resolve(relative.toString());
    }
}

