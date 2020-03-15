// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xml;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;
import gnu.mapping.Symbol;

public class XName extends Symbol implements Externalizable
{
    NamespaceBinding namespaceNodes;
    
    public XName() {
    }
    
    public XName(final Symbol symbol, final NamespaceBinding namespaceNodes) {
        super(symbol.getName(), symbol.getNamespace());
        this.namespaceNodes = namespaceNodes;
    }
    
    public final NamespaceBinding getNamespaceNodes() {
        return this.namespaceNodes;
    }
    
    public final void setNamespaceNodes(final NamespaceBinding nodes) {
        this.namespaceNodes = nodes;
    }
    
    String lookupNamespaceURI(final String prefix) {
        for (NamespaceBinding ns = this.namespaceNodes; ns != null; ns = ns.next) {
            if (prefix == ns.prefix) {
                return ns.uri;
            }
        }
        return null;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeObject(this.namespaceNodes);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        this.namespaceNodes = (NamespaceBinding)in.readObject();
    }
    
    public static boolean isNameStart(final int ch) {
        return Character.isUnicodeIdentifierStart(ch) || ch == 95;
    }
    
    public static boolean isNamePart(final int ch) {
        return Character.isUnicodeIdentifierPart(ch) || ch == 45 || ch == 46;
    }
    
    public static boolean isNmToken(final String value) {
        return checkName(value) >= 0;
    }
    
    public static boolean isName(final String value) {
        return checkName(value) > 0;
    }
    
    public static boolean isNCName(final String value) {
        return checkName(value) > 1;
    }
    
    public static int checkName(final String value) {
        final int len = value.length();
        if (len == 0) {
            return -1;
        }
        int result = 2;
        int i = 0;
        while (i < len) {
            final boolean first = i == 0;
            int ch = value.charAt(i++);
            if (ch >= 55296 && ch < 56320 && i < len) {
                ch = (ch - 55296) * 1024 + (value.charAt(i++) - '\udc00') + 65536;
            }
            if (ch == 58) {
                if (result != 2) {
                    continue;
                }
                result = 1;
            }
            else {
                if (!isNamePart(ch)) {
                    return -1;
                }
                if (!first || isNameStart(ch)) {
                    continue;
                }
                result = 0;
            }
        }
        return result;
    }
}
