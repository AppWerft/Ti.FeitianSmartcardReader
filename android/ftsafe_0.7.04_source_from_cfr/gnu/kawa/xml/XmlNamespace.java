/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.ElementType;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;

public class XmlNamespace
extends Namespace
implements Externalizable {
    public static final String XHTML_NAMESPACE = "http://www.w3.org/1999/xhtml";
    public static final XmlNamespace HTML = XmlNamespace.valueOf("http://www.w3.org/1999/xhtml", "");
    public static final NamespaceBinding HTML_BINDINGS = new NamespaceBinding(null, "http://www.w3.org/1999/xhtml", NamespaceBinding.predefinedXML);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static XmlNamespace getInstance(String prefix, String uri) {
        String xname = prefix + " [xml] -> " + uri;
        Hashtable hashtable2 = nsTable;
        synchronized (hashtable2) {
            Object old = nsTable.get(xname);
            if (old instanceof XmlNamespace) {
                return (XmlNamespace)old;
            }
            XmlNamespace ns = new XmlNamespace();
            ns.setName(uri.intern());
            ns.prefix = prefix.intern();
            nsTable.put(xname, ns);
            return ns;
        }
    }

    public static XmlNamespace valueOf(String name, String prefix) {
        return XmlNamespace.getInstance(prefix, name);
    }

    @Override
    public Object get(String name) {
        ElementType type = ElementType.make(this.getSymbol(name));
        if (this == HTML) {
            type.setNamespaceNodes(HTML_BINDINGS);
        }
        return type;
    }

    @Override
    public boolean isConstant(String key) {
        return true;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.prefix);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName((String)in.readObject());
        this.prefix = (String)in.readObject();
    }

    @Override
    public Object readResolve() throws ObjectStreamException {
        String xname = this.prefix + " -> " + this.getName();
        Namespace ns = (Namespace)nsTable.get(xname);
        if (ns instanceof XmlNamespace) {
            return ns;
        }
        nsTable.put(xname, this);
        return this;
    }
}

