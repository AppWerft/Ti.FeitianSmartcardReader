/*
 * Decompiled with CFR 0.139.
 */
package gnu.xml;

import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.xml.ElementType;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.ItemPredicate;
import gnu.lists.PrintConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.mapping.Symbol;
import gnu.xml.XMLPrinter;
import gnu.xml.XName;

public class NodeTree
extends TreeList {
    static int counter;
    int id;
    String[] idNames;
    int[] idOffsets;
    int idCount;

    @Override
    public int nextPos(int position) {
        boolean isAfter = (position & 1) != 0;
        int index = this.posToDataIndex(position);
        int next = this.nextNodeIndex(index, Integer.MAX_VALUE);
        if (next != index) {
            return next << 1;
        }
        if (index == this.data.length) {
            return 0;
        }
        return (index << 1) + 3;
    }

    public static NodeTree make() {
        return new NodeTree();
    }

    public int getId() {
        if (this.id == 0) {
            this.id = ++counter;
        }
        return this.id;
    }

    @Override
    public int stableCompare(AbstractSequence other) {
        if (this == other) {
            return 0;
        }
        int comp = super.stableCompare(other);
        if (comp == 0 && other instanceof NodeTree) {
            int id2;
            int id1 = this.getId();
            comp = id1 < (id2 = ((NodeTree)other).getId()) ? -1 : (id1 > id2 ? 1 : 0);
        }
        return comp;
    }

    @Override
    public SeqPosition getIteratorAtPos(int ipos) {
        return KNode.make(this, ipos);
    }

    public String posNamespaceURI(int ipos) {
        Object type = this.getNextTypeObject(ipos);
        if (type instanceof XName) {
            return ((XName)type).getNamespaceURI();
        }
        if (type instanceof Symbol) {
            return ((Symbol)type).getNamespaceURI();
        }
        return null;
    }

    public String posPrefix(int ipos) {
        String name = this.getNextTypeName(ipos);
        if (name == null) {
            return null;
        }
        int colon = name.indexOf(58);
        return colon < 0 ? null : name.substring(0, colon);
    }

    public String posLocalName(int ipos) {
        Object type = this.getNextTypeObject(ipos);
        if (type instanceof XName) {
            return ((XName)type).getLocalPart();
        }
        if (type instanceof Symbol) {
            return ((Symbol)type).getLocalName();
        }
        return this.getNextTypeName(ipos);
    }

    public boolean posIsDefaultNamespace(int ipos, String namespaceURI) {
        throw new Error("posIsDefaultNamespace not implemented");
    }

    public String posLookupNamespaceURI(int ipos, String prefix) {
        int kind = this.getNextKind(ipos);
        if (kind != 33) {
            throw new IllegalArgumentException("argument must be an element");
        }
        Object type = this.getNextTypeObject(ipos);
        if (type instanceof XName) {
            return ((XName)type).lookupNamespaceURI(prefix);
        }
        return null;
    }

    public String posLookupPrefix(int ipos, String namespaceURI) {
        throw new Error("posLookupPrefix not implemented");
    }

    public int posFirstChild(int ipos) {
        int index = this.gotoChildrenStart(this.posToDataIndex(ipos));
        if (index < 0) {
            return -1;
        }
        char datum = this.data[index];
        if (datum == '\uf10b' || datum == '\uf10c' || datum == '\uf111') {
            return -1;
        }
        return index << 1;
    }

    public boolean posHasAttributes(int ipos) {
        int index = this.gotoAttributesStart(this.posToDataIndex(ipos));
        if (index < 0) {
            return false;
        }
        return index >= 0 && this.data[index] == '\uf109';
    }

    public int getAttribute(int parent, String namespaceURI, String localName) {
        return this.getAttributeI(parent, namespaceURI == null ? null : namespaceURI.intern(), localName == null ? null : localName.intern());
    }

    public int getAttributeI(int parent, String namespaceURI, String localName) {
        int attr = this.firstAttributePos(parent);
        while (attr != 0 && this.getNextKind(attr) == 35) {
            if (!(localName != null && this.posLocalName(attr) != localName || namespaceURI != null && this.posNamespaceURI(attr) != namespaceURI)) {
                return attr;
            }
            attr = this.nextPos(attr);
        }
        return 0;
    }

    public Object typedValue(int ipos) {
        StringBuffer sbuf = new StringBuffer();
        this.stringValue(this.posToDataIndex(ipos), sbuf);
        String str = sbuf.toString();
        int kind = this.getNextKind(ipos);
        if (kind == 37 || kind == 36) {
            return str;
        }
        return new UntypedAtomic(str);
    }

    public String posTarget(int ipos) {
        int index = this.posToDataIndex(ipos);
        if (this.data[index] != '\uf114') {
            throw new ClassCastException("expected process-instruction");
        }
        return (String)this.objects[this.getIntN(index + 1)];
    }

    public int ancestorAttribute(int ipos, String namespace, String name) {
        while (ipos != -1) {
            int attr = this.getAttributeI(ipos, namespace, name);
            if (attr != 0) {
                return attr;
            }
            ipos = this.parentPos(ipos);
        }
        return 0;
    }

    public Path baseUriOfPos(int pos, boolean resolveRelative) {
        URIPath uri = null;
        int index = this.posToDataIndex(pos);
        while (index != this.data.length) {
            int attr;
            char datum = this.data[index];
            URIPath base2 = null;
            if (datum == '\uf112') {
                int oindex = this.getIntN(index + 1);
                if (oindex >= 0) {
                    base2 = URIPath.makeURI(this.objects[oindex]);
                }
            } else if ((datum >= '\ua000' && datum <= '\uafff' || datum == '\uf108') && (attr = this.getAttributeI(pos, "http://www.w3.org/XML/1998/namespace", "base")) != 0) {
                base2 = URIPath.valueOf(KNode.getNodeValue(this, attr));
            }
            if (base2 != null) {
                Path path = uri = uri == null || !resolveRelative ? base2 : base2.resolve(uri);
                if (((Path)uri).isAbsolute() || !resolveRelative) {
                    return uri;
                }
            }
            if ((index = this.parentOrEntityI(index)) == -1) {
                return uri;
            }
            pos = index << 1;
        }
        return null;
    }

    @Override
    public String toString() {
        CharArrayOutPort wr = new CharArrayOutPort();
        XMLPrinter xp = new XMLPrinter(wr);
        this.consume(xp);
        wr.close();
        return wr.toString();
    }

    public void makeIDtableIfNeeded() {
        if (this.idNames != null) {
            return;
        }
        int size = 64;
        this.idNames = new String[size];
        this.idOffsets = new int[size];
        int limit = this.endPos();
        int ipos = 0;
        while ((ipos = this.nextMatching(ipos, ElementType.anyElement, limit, true)) != 0) {
            int attr = this.getAttributeI(ipos, "http://www.w3.org/XML/1998/namespace", "id");
            if (attr == 0) continue;
            this.enterID(KNode.getNodeValue(this, attr), ipos);
        }
    }

    void enterID(String name, int offset) {
        int size;
        String[] tmpNames = this.idNames;
        int[] tmpOffsets = this.idOffsets;
        if (tmpNames == null) {
            size = 64;
            this.idNames = new String[size];
            this.idOffsets = new int[size];
        } else {
            size = this.idNames.length;
            if (4 * this.idCount >= 3 * size) {
                this.idNames = new String[2 * size];
                this.idOffsets = new int[2 * size];
                this.idCount = 0;
                int i = size;
                while (--i >= 0) {
                    String oldName = tmpNames[i];
                    if (oldName == null) continue;
                    this.enterID(oldName, tmpOffsets[i]);
                }
                tmpNames = this.idNames;
                tmpOffsets = this.idOffsets;
                size = 2 * size;
            }
        }
        int hash = name.hashCode();
        int mask = size - 1;
        int index = hash & mask;
        int step = ~hash << 1 | 1;
        do {
            String oldName;
            if ((oldName = tmpNames[index]) == null) break;
            if (oldName.equals(name)) {
                return;
            }
            index = index + step & mask;
        } while (true);
        tmpNames[index] = name;
        tmpOffsets[index] = offset;
        ++this.idCount;
    }

    public int lookupID(String name) {
        String[] tmpNames = this.idNames;
        int[] tmpOffsets = this.idOffsets;
        int size = this.idNames.length;
        int hash = name.hashCode();
        int mask = size - 1;
        int index = hash & mask;
        int step = ~hash << 1 | 1;
        String oldName;
        while ((oldName = tmpNames[index]) != null) {
            if (oldName.equals(name)) {
                return tmpOffsets[index];
            }
            index = index + step & mask;
        }
        return -1;
    }
}

