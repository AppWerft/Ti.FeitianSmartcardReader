/*
 * Decompiled with CFR 0.139.
 */
package gnu.xml;

import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import gnu.xml.XName;

final class MappingInfo {
    MappingInfo nextInBucket;
    int tagHash;
    String prefix;
    String local;
    String uri;
    Symbol qname;
    NamespaceBinding namespaces;
    XName type;
    int index = -1;

    MappingInfo() {
    }

    static int hash(String prefix, String local) {
        int hash = local.hashCode();
        if (prefix != null) {
            hash ^= prefix.hashCode();
        }
        return hash;
    }

    static int hash(char[] data, int start, int length) {
        int hash = 0;
        int prefixHash = 0;
        int colonPos = -1;
        for (int i = 0; i < length; ++i) {
            char ch = data[start + i];
            if (ch == ':' && colonPos < 0) {
                colonPos = i;
                prefixHash = hash;
                hash = 0;
                continue;
            }
            hash = 31 * hash + ch;
        }
        return prefixHash ^ hash;
    }

    boolean match(char[] data, int start, int length) {
        if (this.prefix != null) {
            int localLength = this.local.length();
            int prefixLength = this.prefix.length();
            return length == prefixLength + 1 + localLength && data[prefixLength] == ':' && MappingInfo.equals(this.prefix, data, start, prefixLength) && MappingInfo.equals(this.local, data, start + prefixLength + 1, localLength);
        }
        return MappingInfo.equals(this.local, data, start, length);
    }

    static boolean equals(String tag, StringBuffer sbuf) {
        int length = sbuf.length();
        if (tag.length() != length) {
            return false;
        }
        for (int i = 0; i < length; ++i) {
            if (sbuf.charAt(i) == tag.charAt(i)) continue;
            return false;
        }
        return true;
    }

    static boolean equals(String tag, char[] data, int start, int length) {
        if (tag.length() != length) {
            return false;
        }
        for (int i = 0; i < length; ++i) {
            if (data[start + i] == tag.charAt(i)) continue;
            return false;
        }
        return true;
    }
}

