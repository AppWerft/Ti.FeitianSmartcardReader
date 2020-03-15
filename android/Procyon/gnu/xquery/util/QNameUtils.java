// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import java.net.URISyntaxException;
import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.xml.XStringType;
import gnu.mapping.WrongType;
import gnu.xml.XName;
import gnu.xml.NamespaceBinding;
import gnu.mapping.Symbol;
import gnu.xml.TextUtils;
import gnu.kawa.xml.UntypedAtomic;
import gnu.mapping.Values;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.KElement;

public class QNameUtils
{
    public static Object resolveQNameUsingElement(Object qname, final KElement node) {
        qname = KNode.atomicValue(qname);
        if (qname == Values.empty || qname == null) {
            return qname;
        }
        if (qname instanceof Values || (!(qname instanceof String) && !(qname instanceof UntypedAtomic))) {
            throw new RuntimeException("bad argument to QName");
        }
        final String name = TextUtils.replaceWhitespace(qname.toString(), true);
        final int colon = name.indexOf(58);
        String prefix;
        String localPart;
        if (colon < 0) {
            prefix = null;
            localPart = name;
        }
        else {
            prefix = name.substring(0, colon).intern();
            localPart = name.substring(colon + 1);
        }
        String uri = node.lookupNamespaceURI(prefix);
        if (uri == null) {
            if (prefix != null) {
                throw new RuntimeException("unknown namespace for '" + name + "'");
            }
            uri = "";
        }
        if (!validNCName(localPart) || (prefix != null && !validNCName(prefix))) {
            throw new RuntimeException("invalid QName syntax '" + name + "'");
        }
        return Symbol.make(uri, localPart, (prefix == null) ? "" : prefix);
    }
    
    public static Object resolveQName(Object qname, final NamespaceBinding constructorNamespaces, final NamespaceBinding prologNamespaces) {
        qname = KNode.atomicValue(qname);
        if (qname instanceof Symbol) {
            return qname;
        }
        if (qname instanceof Values || (!(qname instanceof String) && !(qname instanceof UntypedAtomic))) {
            throw new RuntimeException("bad argument to QName");
        }
        final String name = TextUtils.replaceWhitespace(qname.toString(), true);
        final int colon = name.indexOf(58);
        String localPart;
        String prefix;
        if (colon < 0) {
            localPart = name;
            prefix = null;
        }
        else {
            prefix = name.substring(0, colon).intern();
            localPart = name.substring(colon + 1);
        }
        if (!validNCName(localPart) || (prefix != null && !validNCName(prefix))) {
            throw new RuntimeException("invalid QName syntax '" + name + "'");
        }
        final String uri = resolvePrefix(prefix, constructorNamespaces, prologNamespaces);
        return Symbol.make(uri, localPart, (prefix == null) ? "" : prefix);
    }
    
    public static String lookupPrefix(final String prefix, final NamespaceBinding constructorNamespaces, final NamespaceBinding prologNamespaces) {
        while (true) {
            for (NamespaceBinding ns = constructorNamespaces; ns != null; ns = ns.getNext()) {
                if (ns.getPrefix() == prefix) {
                    String uri = ns.getUri();
                    if (uri == null && prefix == null) {
                        uri = "";
                    }
                    return uri;
                }
            }
            String uri = prologNamespaces.resolve(prefix);
            continue;
        }
    }
    
    public static String resolvePrefix(final String prefix, final NamespaceBinding constructorNamespaces, final NamespaceBinding prologNamespaces) {
        final String uri = lookupPrefix(prefix, constructorNamespaces, prologNamespaces);
        if (uri == null) {
            throw new RuntimeException("unknown namespace prefix '" + prefix + "'");
        }
        return uri;
    }
    
    public static boolean validNCName(final String name) {
        return XName.isName(name);
    }
    
    public static Symbol makeQName(Object paramURI, final String paramQName) {
        if (paramURI == null || paramURI == Values.empty) {
            paramURI = "";
        }
        final int colon = paramQName.indexOf(58);
        final String namespaceURI = (String)paramURI;
        String localPart;
        String prefix;
        if (colon < 0) {
            localPart = paramQName;
            prefix = "";
        }
        else {
            localPart = paramQName.substring(colon + 1);
            prefix = paramQName.substring(0, colon).intern();
        }
        if (!validNCName(localPart) || (colon >= 0 && !validNCName(prefix))) {
            throw new IllegalArgumentException("invalid QName syntax '" + paramQName + "'");
        }
        if (colon >= 0 && namespaceURI.length() == 0) {
            throw new IllegalArgumentException("empty uri for '" + paramQName + "'");
        }
        return Symbol.make(namespaceURI, localPart, prefix);
    }
    
    public static Object localNameFromQName(final Object name) {
        if (name == Values.empty || name == null) {
            return name;
        }
        if (!(name instanceof Symbol)) {
            throw new WrongType("local-name-from-QName", 1, name, "xs:QName");
        }
        return XStringType.makeNCName(((Symbol)name).getName());
    }
    
    public static Object prefixFromQName(final Object name) {
        if (name == Values.empty || name == null) {
            return name;
        }
        if (!(name instanceof Symbol)) {
            throw new WrongType("prefix-from-QName", 1, name, "xs:QName");
        }
        final String prefix = ((Symbol)name).getPrefix();
        if (prefix == null || prefix.length() == 0) {
            return Values.empty;
        }
        return XStringType.makeNCName(prefix);
    }
    
    public static Object namespaceURIFromQName(final Object name) {
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
    
    public static Object namespaceURIForPrefix(final Object prefix, final Object element) {
        final KNode el = KNode.coerce(element);
        if (el == null) {
            throw new WrongType("namespace-uri-for-prefix", 2, element, "node()");
        }
        String str;
        if (prefix == null || prefix == Values.empty) {
            str = null;
        }
        else {
            if (!(prefix instanceof String) && !(prefix instanceof UntypedAtomic)) {
                throw new WrongType("namespace-uri-for-prefix", 1, element, "xs:string");
            }
            str = prefix.toString().intern();
            if (str == "") {
                str = null;
            }
        }
        final String uri = el.lookupNamespaceURI(str);
        if (uri == null) {
            return Values.empty;
        }
        return uri;
    }
    
    public static Object resolveURI(Object relative, Object base) throws URISyntaxException {
        if (relative instanceof KNode) {
            relative = KNode.atomicValue(relative);
        }
        if (base instanceof KNode) {
            base = KNode.atomicValue(base);
        }
        if (relative == Values.empty || relative == null) {
            return relative;
        }
        if (relative instanceof UntypedAtomic) {
            relative = relative.toString();
        }
        if (base instanceof UntypedAtomic) {
            base = base.toString();
        }
        final Path baseP = (base instanceof Path) ? ((Path)base) : URIPath.makeURI(base);
        if (relative instanceof Path) {
            return baseP.resolve((Path)relative);
        }
        return baseP.resolve(relative.toString());
    }
}
