// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.xml.NamespaceBinding;
import java.io.Externalizable;
import gnu.mapping.Namespace;

public class XmlNamespace extends Namespace implements Externalizable
{
    public static final String XHTML_NAMESPACE = "http://www.w3.org/1999/xhtml";
    public static final XmlNamespace HTML;
    public static final NamespaceBinding HTML_BINDINGS;
    
    public static XmlNamespace getInstance(final String prefix, final String uri) {
        final String xname = prefix + " [xml] -> " + uri;
        synchronized (XmlNamespace.nsTable) {
            final Object old = XmlNamespace.nsTable.get(xname);
            if (old instanceof XmlNamespace) {
                return (XmlNamespace)old;
            }
            final XmlNamespace ns = new XmlNamespace();
            ns.setName(uri.intern());
            ns.prefix = prefix.intern();
            XmlNamespace.nsTable.put(xname, ns);
            return ns;
        }
    }
    
    public static XmlNamespace valueOf(final String name, final String prefix) {
        return getInstance(prefix, name);
    }
    
    @Override
    public Object get(final String name) {
        final ElementType type = ElementType.make(this.getSymbol(name));
        if (this == XmlNamespace.HTML) {
            type.setNamespaceNodes(XmlNamespace.HTML_BINDINGS);
        }
        return type;
    }
    
    @Override
    public boolean isConstant(final String key) {
        return true;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.prefix);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName((String)in.readObject());
        this.prefix = (String)in.readObject();
    }
    
    @Override
    public Object readResolve() throws ObjectStreamException {
        final String xname = this.prefix + " -> " + this.getName();
        final Namespace ns = XmlNamespace.nsTable.get(xname);
        if (ns instanceof XmlNamespace) {
            return ns;
        }
        XmlNamespace.nsTable.put(xname, this);
        return this;
    }
    
    static {
        HTML = valueOf("http://www.w3.org/1999/xhtml", "");
        HTML_BINDINGS = new NamespaceBinding(null, "http://www.w3.org/1999/xhtml", NamespaceBinding.predefinedXML);
    }
}
