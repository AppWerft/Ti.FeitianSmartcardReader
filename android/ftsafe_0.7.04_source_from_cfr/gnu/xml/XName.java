/*
 * Decompiled with CFR 0.139.
 */
package gnu.xml;

import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class XName
extends Symbol
implements Externalizable {
    NamespaceBinding namespaceNodes;

    public XName() {
    }

    public XName(Symbol symbol, NamespaceBinding namespaceNodes) {
        super(symbol.getName(), symbol.getNamespace());
        this.namespaceNodes = namespaceNodes;
    }

    public final NamespaceBinding getNamespaceNodes() {
        return this.namespaceNodes;
    }

    public final void setNamespaceNodes(NamespaceBinding nodes) {
        this.namespaceNodes = nodes;
    }

    String lookupNamespaceURI(String prefix) {
        NamespaceBinding ns = this.namespaceNodes;
        while (ns != null) {
            if (prefix == ns.prefix) {
                return ns.uri;
            }
            ns = ns.next;
        }
        return null;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeObject(this.namespaceNodes);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        this.namespaceNodes = (NamespaceBinding)in.readObject();
    }

    public static boolean isNameStart(int ch) {
        return Character.isUnicodeIdentifierStart(ch) || ch == 95;
    }

    public static boolean isNamePart(int ch) {
        return Character.isUnicodeIdentifierPart(ch) || ch == 45 || ch == 46;
    }

    public static boolean isNmToken(String value) {
        return XName.checkName(value) >= 0;
    }

    public static boolean isName(String value) {
        return XName.checkName(value) > 0;
    }

    public static boolean isNCName(String value) {
        return XName.checkName(value) > 1;
    }

    public static int checkName(String value) {
        int len = value.length();
        if (len == 0) {
            return -1;
        }
        int result = 2;
        int i = 0;
        while (i < len) {
            int ch;
            boolean first = i == 0;
            if ((ch = value.charAt(i++)) >= 55296 && ch < 56320 && i < len) {
                ch = (ch - 55296) * 1024 + (value.charAt(i++) - 56320) + 65536;
            }
            if (ch == 58) {
                if (result != 2) continue;
                result = 1;
                continue;
            }
            if (!XName.isNamePart(ch)) {
                return -1;
            }
            if (!first || XName.isNameStart(ch)) continue;
            result = 0;
        }
        return result;
    }
}

