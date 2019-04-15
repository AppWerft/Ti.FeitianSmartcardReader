/*
 * Decompiled with CFR 0.139.
 */
package gnu.xml;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class NamespaceBinding
implements Externalizable {
    String prefix;
    String uri;
    NamespaceBinding next;
    int depth;
    public static final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";
    public static final NamespaceBinding predefinedXML = new NamespaceBinding("xml", "http://www.w3.org/XML/1998/namespace", null);

    public final String getPrefix() {
        return this.prefix;
    }

    public final void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setUri(String uri) {
        this.uri = uri;
    }

    public final NamespaceBinding getNext() {
        return this.next;
    }

    public final void setNext(NamespaceBinding next) {
        this.next = next;
        this.depth = next == null ? 0 : next.depth + 1;
    }

    public static final NamespaceBinding nconc(NamespaceBinding list1, NamespaceBinding list2) {
        if (list1 == null) {
            return list2;
        }
        list1.setNext(NamespaceBinding.nconc(list1.next, list2));
        return list1;
    }

    public NamespaceBinding(String prefix, String uri, NamespaceBinding next) {
        this.prefix = prefix;
        this.uri = uri;
        this.setNext(next);
    }

    public String resolve(String prefix) {
        NamespaceBinding ns = this;
        while (ns != null) {
            if (ns.prefix == prefix) {
                return ns.uri;
            }
            ns = ns.next;
        }
        return null;
    }

    public String resolve(String prefix, NamespaceBinding fencePost) {
        NamespaceBinding ns = this;
        while (ns != fencePost) {
            if (ns.prefix == prefix) {
                return ns.uri;
            }
            ns = ns.next;
        }
        return null;
    }

    public static NamespaceBinding commonAncestor(NamespaceBinding ns1, NamespaceBinding ns2) {
        if (ns1.depth > ns2.depth) {
            NamespaceBinding tmp = ns1;
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

    public NamespaceBinding reversePrefix(NamespaceBinding fencePost) {
        int depth;
        NamespaceBinding prev = fencePost;
        NamespaceBinding t = this;
        int n = depth = fencePost == null ? -1 : fencePost.depth;
        while (t != fencePost) {
            NamespaceBinding next = t.next;
            t.next = prev;
            prev = t;
            t.depth = ++depth;
            t = next;
        }
        return prev;
    }

    public int count(NamespaceBinding fencePost) {
        int count = 0;
        NamespaceBinding ns = this;
        while (ns != fencePost) {
            ++count;
            ns = ns.next;
        }
        return count;
    }

    public static NamespaceBinding maybeAdd(String prefix, String uri, NamespaceBinding bindings) {
        String found;
        if (bindings == null) {
            if (uri == null) {
                return bindings;
            }
            bindings = predefinedXML;
        }
        if ((found = bindings.resolve(prefix)) == null ? uri == null : found.equals(uri)) {
            return bindings;
        }
        return new NamespaceBinding(prefix, uri, bindings);
    }

    public String toString() {
        return "Namespace{" + this.prefix + "=" + this.uri + ", depth:" + this.depth + "}";
    }

    public String toStringAll() {
        StringBuffer sbuf = new StringBuffer("Namespaces{");
        NamespaceBinding ns = this;
        while (ns != null) {
            sbuf.append(ns.prefix);
            sbuf.append("=\"");
            sbuf.append(ns.uri);
            sbuf.append(ns == null ? "\"" : "\", ");
            ns = ns.next;
        }
        sbuf.append('}');
        return sbuf.toString();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.prefix);
        out.writeUTF(this.uri);
        out.writeObject(this.next);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.prefix = in.readUTF();
        this.uri = in.readUTF();
        this.next = (NamespaceBinding)in.readObject();
    }
}

