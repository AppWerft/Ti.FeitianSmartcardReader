// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xml;

import gnu.mapping.Symbol;

final class MappingInfo
{
    MappingInfo nextInBucket;
    int tagHash;
    String prefix;
    String local;
    String uri;
    Symbol qname;
    NamespaceBinding namespaces;
    XName type;
    int index;
    
    MappingInfo() {
        this.index = -1;
    }
    
    static int hash(final String prefix, final String local) {
        int hash = local.hashCode();
        if (prefix != null) {
            hash ^= prefix.hashCode();
        }
        return hash;
    }
    
    static int hash(final char[] data, final int start, final int length) {
        int hash = 0;
        int prefixHash = 0;
        int colonPos = -1;
        for (int i = 0; i < length; ++i) {
            final char ch = data[start + i];
            if (ch == ':' && colonPos < 0) {
                colonPos = i;
                prefixHash = hash;
                hash = 0;
            }
            else {
                hash = 31 * hash + ch;
            }
        }
        return prefixHash ^ hash;
    }
    
    boolean match(final char[] data, final int start, final int length) {
        if (this.prefix != null) {
            final int localLength = this.local.length();
            final int prefixLength = this.prefix.length();
            return length == prefixLength + 1 + localLength && data[prefixLength] == ':' && equals(this.prefix, data, start, prefixLength) && equals(this.local, data, start + prefixLength + 1, localLength);
        }
        return equals(this.local, data, start, length);
    }
    
    static boolean equals(final String tag, final StringBuffer sbuf) {
        final int length = sbuf.length();
        if (tag.length() != length) {
            return false;
        }
        for (int i = 0; i < length; ++i) {
            if (sbuf.charAt(i) != tag.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    static boolean equals(final String tag, final char[] data, final int start, final int length) {
        if (tag.length() != length) {
            return false;
        }
        for (int i = 0; i < length; ++i) {
            if (data[start + i] != tag.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
