// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xml;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public final class NamespaceBinding implements Externalizable
{
    String prefix;
    String uri;
    NamespaceBinding next;
    int depth;
    public static final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";
    public static final NamespaceBinding predefinedXML;
    
    public final String getPrefix() {
        return this.prefix;
    }
    
    public final void setPrefix(final String prefix) {
        this.prefix = prefix;
    }
    
    public final String getUri() {
        return this.uri;
    }
    
    public final void setUri(final String uri) {
        this.uri = uri;
    }
    
    public final NamespaceBinding getNext() {
        return this.next;
    }
    
    public final void setNext(final NamespaceBinding next) {
        this.next = next;
        this.depth = ((next == null) ? 0 : (next.depth + 1));
    }
    
    public static final NamespaceBinding nconc(final NamespaceBinding list1, final NamespaceBinding list2) {
        if (list1 == null) {
            return list2;
        }
        list1.setNext(nconc(list1.next, list2));
        return list1;
    }
    
    public NamespaceBinding(final String prefix, final String uri, final NamespaceBinding next) {
        this.prefix = prefix;
        this.uri = uri;
        this.setNext(next);
    }
    
    public String resolve(final String prefix) {
        for (NamespaceBinding ns = this; ns != null; ns = ns.next) {
            if (ns.prefix == prefix) {
                return ns.uri;
            }
        }
        return null;
    }
    
    public String resolve(final String prefix, final NamespaceBinding fencePost) {
        for (NamespaceBinding ns = this; ns != fencePost; ns = ns.next) {
            if (ns.prefix == prefix) {
                return ns.uri;
            }
        }
        return null;
    }
    
    public static NamespaceBinding commonAncestor(NamespaceBinding ns1, NamespaceBinding ns2) {
        if (ns1.depth > ns2.depth) {
            final NamespaceBinding tmp = ns1;
            ns1 = ns2;
            ns2 = tmp;
        }
        while (ns2.depth > ns1.depth) {
            ns2 = ns2.next;
        }
        while (ns1 != ns2) {
            ns1 = ns1.next;
            ns2 = ns2.next;
        }
        return ns1;
    }
    
    public NamespaceBinding reversePrefix(final NamespaceBinding fencePost) {
        NamespaceBinding prev = fencePost;
        NamespaceBinding t = this;
        int depth = (fencePost == null) ? -1 : fencePost.depth;
        while (t != fencePost) {
            final NamespaceBinding next = t.next;
            t.next = prev;
            prev = t;
            t.depth = ++depth;
            t = next;
        }
        return prev;
    }
    
    public int count(final NamespaceBinding fencePost) {
        int count = 0;
        for (NamespaceBinding ns = this; ns != fencePost; ns = ns.next) {
            ++count;
        }
        return count;
    }
    
    public static NamespaceBinding maybeAdd(final String prefix, final String uri, NamespaceBinding bindings) {
        if (bindings == null) {
            if (uri == null) {
                return bindings;
            }
            bindings = NamespaceBinding.predefinedXML;
        }
        final String found = bindings.resolve(prefix);
        if (found == null) {
            if (uri != null) {
                return new NamespaceBinding(prefix, uri, bindings);
            }
        }
        else if (!found.equals(uri)) {
            return new NamespaceBinding(prefix, uri, bindings);
        }
        return bindings;
    }
    
    @Override
    public String toString() {
        return "Namespace{" + this.prefix + "=" + this.uri + ", depth:" + this.depth + "}";
    }
    
    public String toStringAll() {
        final StringBuffer sbuf = new StringBuffer("Namespaces{");
        for (NamespaceBinding ns = this; ns != null; ns = ns.next) {
            sbuf.append(ns.prefix);
            sbuf.append("=\"");
            sbuf.append(ns.uri);
            sbuf.append((ns == null) ? "\"" : "\", ");
        }
        sbuf.append('}');
        return sbuf.toString();
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeUTF(this.prefix);
        out.writeUTF(this.uri);
        out.writeObject(this.next);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.prefix = in.readUTF();
        this.uri = in.readUTF();
        this.next = (NamespaceBinding)in.readObject();
    }
    
    static {
        predefinedXML = new NamespaceBinding("xml", "http://www.w3.org/XML/1998/namespace", null);
    }
}
