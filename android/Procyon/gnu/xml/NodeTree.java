// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xml;

import gnu.lists.ItemPredicate;
import gnu.kawa.xml.ElementType;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.URIPath;
import gnu.kawa.io.Path;
import gnu.kawa.xml.UntypedAtomic;
import gnu.mapping.Symbol;
import gnu.kawa.xml.KNode;
import gnu.lists.SeqPosition;
import gnu.lists.AbstractSequence;
import gnu.lists.TreeList;

public class NodeTree extends TreeList
{
    static int counter;
    int id;
    String[] idNames;
    int[] idOffsets;
    int idCount;
    
    @Override
    public int nextPos(final int position) {
        final boolean isAfter = (position & 0x1) != 0x0;
        final int index = this.posToDataIndex(position);
        final int next = this.nextNodeIndex(index, Integer.MAX_VALUE);
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
            this.id = ++NodeTree.counter;
        }
        return this.id;
    }
    
    @Override
    public int stableCompare(final AbstractSequence other) {
        if (this == other) {
            return 0;
        }
        int comp = super.stableCompare(other);
        if (comp == 0 && other instanceof NodeTree) {
            final int id1 = this.getId();
            final int id2 = ((NodeTree)other).getId();
            comp = ((id1 < id2) ? -1 : ((id1 > id2) ? 1 : 0));
        }
        return comp;
    }
    
    @Override
    public SeqPosition getIteratorAtPos(final int ipos) {
        return KNode.make(this, ipos);
    }
    
    public String posNamespaceURI(final int ipos) {
        final Object type = this.getNextTypeObject(ipos);
        if (type instanceof XName) {
            return ((XName)type).getNamespaceURI();
        }
        if (type instanceof Symbol) {
            return ((Symbol)type).getNamespaceURI();
        }
        return null;
    }
    
    public String posPrefix(final int ipos) {
        final String name = this.getNextTypeName(ipos);
        if (name == null) {
            return null;
        }
        final int colon = name.indexOf(58);
        return (colon < 0) ? null : name.substring(0, colon);
    }
    
    public String posLocalName(final int ipos) {
        final Object type = this.getNextTypeObject(ipos);
        if (type instanceof XName) {
            return ((XName)type).getLocalPart();
        }
        if (type instanceof Symbol) {
            return ((Symbol)type).getLocalName();
        }
        return this.getNextTypeName(ipos);
    }
    
    public boolean posIsDefaultNamespace(final int ipos, final String namespaceURI) {
        throw new Error("posIsDefaultNamespace not implemented");
    }
    
    public String posLookupNamespaceURI(final int ipos, final String prefix) {
        final int kind = this.getNextKind(ipos);
        if (kind != 33) {
            throw new IllegalArgumentException("argument must be an element");
        }
        final Object type = this.getNextTypeObject(ipos);
        if (type instanceof XName) {
            return ((XName)type).lookupNamespaceURI(prefix);
        }
        return null;
    }
    
    public String posLookupPrefix(final int ipos, final String namespaceURI) {
        throw new Error("posLookupPrefix not implemented");
    }
    
    public int posFirstChild(final int ipos) {
        final int index = this.gotoChildrenStart(this.posToDataIndex(ipos));
        if (index < 0) {
            return -1;
        }
        final char datum = this.data[index];
        if (datum == '\uf10b' || datum == '\uf10c' || datum == '\uf111') {
            return -1;
        }
        return index << 1;
    }
    
    public boolean posHasAttributes(final int ipos) {
        final int index = this.gotoAttributesStart(this.posToDataIndex(ipos));
        return index >= 0 && index >= 0 && this.data[index] == '\uf109';
    }
    
    public int getAttribute(final int parent, final String namespaceURI, final String localName) {
        return this.getAttributeI(parent, (namespaceURI == null) ? null : namespaceURI.intern(), (localName == null) ? null : localName.intern());
    }
    
    public int getAttributeI(final int parent, final String namespaceURI, final String localName) {
        for (int attr = this.firstAttributePos(parent); attr != 0 && this.getNextKind(attr) == 35; attr = this.nextPos(attr)) {
            if ((localName == null || this.posLocalName(attr) == localName) && (namespaceURI == null || this.posNamespaceURI(attr) == namespaceURI)) {
                return attr;
            }
        }
        return 0;
    }
    
    public Object typedValue(final int ipos) {
        final StringBuffer sbuf = new StringBuffer();
        this.stringValue(this.posToDataIndex(ipos), sbuf);
        final String str = sbuf.toString();
        final int kind = this.getNextKind(ipos);
        if (kind == 37 || kind == 36) {
            return str;
        }
        return new UntypedAtomic(str);
    }
    
    public String posTarget(final int ipos) {
        final int index = this.posToDataIndex(ipos);
        if (this.data[index] != '\uf114') {
            throw new ClassCastException("expected process-instruction");
        }
        return (String)this.objects[this.getIntN(index + 1)];
    }
    
    public int ancestorAttribute(int ipos, final String namespace, final String name) {
        while (ipos != -1) {
            final int attr = this.getAttributeI(ipos, namespace, name);
            if (attr != 0) {
                return attr;
            }
            ipos = this.parentPos(ipos);
        }
        return 0;
    }
    
    public Path baseUriOfPos(int pos, final boolean resolveRelative) {
        Path uri = null;
        int index = this.posToDataIndex(pos);
        while (index != this.data.length) {
            final char datum = this.data[index];
            Path base = null;
            if (datum == '\uf112') {
                final int oindex = this.getIntN(index + 1);
                if (oindex >= 0) {
                    base = URIPath.makeURI(this.objects[oindex]);
                }
            }
            else if ((datum >= '\ua000' && datum <= '\uafff') || datum == '\uf108') {
                final int attr = this.getAttributeI(pos, "http://www.w3.org/XML/1998/namespace", "base");
                if (attr != 0) {
                    base = URIPath.valueOf(KNode.getNodeValue(this, attr));
                }
            }
            if (base != null) {
                uri = ((uri == null || !resolveRelative) ? base : base.resolve(uri));
                if (uri.isAbsolute() || !resolveRelative) {
                    return uri;
                }
            }
            index = this.parentOrEntityI(index);
            if (index == -1) {
                return uri;
            }
            pos = index << 1;
        }
        return null;
    }
    
    @Override
    public String toString() {
        final CharArrayOutPort wr = new CharArrayOutPort();
        final XMLPrinter xp = new XMLPrinter(wr);
        this.consume(xp);
        wr.close();
        return wr.toString();
    }
    
    public void makeIDtableIfNeeded() {
        if (this.idNames != null) {
            return;
        }
        final int size = 64;
        this.idNames = new String[size];
        this.idOffsets = new int[size];
        final int limit = this.endPos();
        int ipos = 0;
        while (true) {
            ipos = this.nextMatching(ipos, ElementType.anyElement, limit, true);
            if (ipos == 0) {
                break;
            }
            final int attr = this.getAttributeI(ipos, "http://www.w3.org/XML/1998/namespace", "id");
            if (attr == 0) {
                continue;
            }
            this.enterID(KNode.getNodeValue(this, attr), ipos);
        }
    }
    
    void enterID(final String name, final int offset) {
        String[] tmpNames = this.idNames;
        int[] tmpOffsets = this.idOffsets;
        int size;
        if (tmpNames == null) {
            size = 64;
            this.idNames = new String[size];
            this.idOffsets = new int[size];
        }
        else if (4 * this.idCount >= 3 * (size = this.idNames.length)) {
            this.idNames = new String[2 * size];
            this.idOffsets = new int[2 * size];
            this.idCount = 0;
            int i = size;
            while (--i >= 0) {
                final String oldName = tmpNames[i];
                if (oldName != null) {
                    this.enterID(oldName, tmpOffsets[i]);
                }
            }
            tmpNames = this.idNames;
            tmpOffsets = this.idOffsets;
            size *= 2;
        }
        final int hash = name.hashCode();
        final int mask = size - 1;
        int index = hash & mask;
        final int step = ~hash << 1 | 0x1;
        while (true) {
            final String oldName2 = tmpNames[index];
            if (oldName2 == null) {
                tmpNames[index] = name;
                tmpOffsets[index] = offset;
                ++this.idCount;
                return;
            }
            if (oldName2.equals(name)) {
                return;
            }
            index = (index + step & mask);
        }
    }
    
    public int lookupID(final String name) {
        final String[] tmpNames = this.idNames;
        final int[] tmpOffsets = this.idOffsets;
        final int size = this.idNames.length;
        final int hash = name.hashCode();
        final int mask = size - 1;
        int index = hash & mask;
        final int step = ~hash << 1 | 0x1;
        while (true) {
            final String oldName = tmpNames[index];
            if (oldName == null) {
                return -1;
            }
            if (oldName.equals(name)) {
                return tmpOffsets[index];
            }
            index = (index + step & mask);
        }
    }
}
