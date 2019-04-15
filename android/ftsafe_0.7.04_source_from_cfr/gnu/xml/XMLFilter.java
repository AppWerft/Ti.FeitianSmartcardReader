/*
 * Decompiled with CFR 0.139.
 */
package gnu.xml;

import gnu.expr.Keyword;
import gnu.kawa.io.InPort;
import gnu.kawa.sax.ContentConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.CharSeq;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.lists.UnescapedData;
import gnu.lists.XConsumer;
import gnu.mapping.Symbol;
import gnu.text.Char;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.xml.MappingInfo;
import gnu.xml.NamespaceBinding;
import gnu.xml.NodeTree;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class XMLFilter
implements DocumentHandler,
ContentHandler,
SourceLocator,
XConsumer,
PositionConsumer {
    TreeList tlist;
    public Consumer out;
    private Consumer base;
    public static final int COPY_NAMESPACES_PRESERVE = 1;
    public static final int COPY_NAMESPACES_INHERIT = 2;
    public transient int copyNamespacesMode = 1;
    Object[] workStack;
    NamespaceBinding namespaceBindings;
    private SourceMessages messages;
    SourceLocator locator;
    InPort in;
    protected int nesting;
    int previous = 0;
    private static final int SAW_KEYWORD = 1;
    private static final int SAW_WORD = 2;
    protected int stringizingLevel;
    protected int stringizingElementNesting = -1;
    protected int ignoringLevel;
    int[] startIndexes = null;
    int attrCount = -1;
    boolean inStartTag;
    String attrLocalName;
    String attrPrefix;
    String currentNamespacePrefix;
    public boolean namespacePrefixes = false;
    MappingInfo[] mappingTable = new MappingInfo[128];
    int mappingTableMask = this.mappingTable.length - 1;
    boolean mismatchReported;

    public void setSourceLocator(InPort in) {
        this.in = in;
        this.locator = this;
    }

    public void setSourceLocator(SourceLocator locator) {
        this.locator = locator;
    }

    public void setMessages(SourceMessages messages) {
        this.messages = messages;
    }

    public NamespaceBinding findNamespaceBinding(String prefix, String uri, NamespaceBinding oldBindings) {
        int hash;
        int n = hash = uri == null ? 0 : uri.hashCode();
        if (prefix != null) {
            hash ^= prefix.hashCode();
        }
        int bucket = hash & this.mappingTableMask;
        MappingInfo info = this.mappingTable[bucket];
        do {
            NamespaceBinding namespaces;
            if (info == null) {
                info = new MappingInfo();
                info.nextInBucket = this.mappingTable[bucket];
                this.mappingTable[bucket] = info;
                info.tagHash = hash;
                info.prefix = prefix;
                info.local = uri;
                info.uri = uri;
                if (uri == "") {
                    uri = null;
                }
                info.namespaces = namespaces = new NamespaceBinding(prefix, uri, oldBindings);
                return info.namespaces;
            }
            if (info.tagHash == hash && info.prefix == prefix && (namespaces = info.namespaces) != null && namespaces.getNext() == this.namespaceBindings && namespaces.getPrefix() == prefix && info.uri == uri) {
                return info.namespaces;
            }
            info = info.nextInBucket;
        } while (true);
    }

    public MappingInfo lookupNamespaceBinding(String prefix, char[] uriChars, int uriStart, int uriLength, int uriHash, NamespaceBinding oldBindings) {
        int hash = prefix == null ? uriHash : prefix.hashCode() ^ uriHash;
        int bucket = hash & this.mappingTableMask;
        MappingInfo info = this.mappingTable[bucket];
        do {
            NamespaceBinding namespaces;
            if (info == null) {
                NamespaceBinding namespaces2;
                info = new MappingInfo();
                info.nextInBucket = this.mappingTable[bucket];
                this.mappingTable[bucket] = info;
                String uri = new String(uriChars, uriStart, uriLength).intern();
                info.tagHash = hash;
                info.prefix = prefix;
                info.local = uri;
                info.uri = uri;
                if (uri == "") {
                    uri = null;
                }
                info.namespaces = namespaces2 = new NamespaceBinding(prefix, uri, oldBindings);
                return info;
            }
            if (info.tagHash == hash && info.prefix == prefix && (namespaces = info.namespaces) != null && namespaces.getNext() == this.namespaceBindings && namespaces.getPrefix() == prefix && MappingInfo.equals(info.uri, uriChars, uriStart, uriLength)) {
                return info;
            }
            info = info.nextInBucket;
        } while (true);
    }

    @Override
    public void endAttribute() {
        if (this.attrLocalName == null) {
            return;
        }
        if (this.previous == 1) {
            this.previous = 0;
            return;
        }
        if (this.stringizingElementNesting >= 0) {
            --this.ignoringLevel;
        }
        if (--this.stringizingLevel == 0) {
            if (this.attrLocalName == "id" && this.attrPrefix == "xml") {
                int valStart = this.startIndexes[this.attrCount - 1] + 5;
                int valEnd = this.tlist.gapStart;
                char[] data = this.tlist.data;
                int i = valStart;
                while (i < valEnd) {
                    char datum;
                    if (((datum = data[i++]) & 65535) <= 40959 && datum != '\t' && datum != '\r' && datum != '\n' && (datum != ' ' || i != valEnd && data[i] != ' ')) continue;
                    StringBuffer sbuf = new StringBuffer();
                    this.tlist.stringValue(valStart, valEnd, sbuf);
                    this.tlist.gapStart = valStart;
                    this.tlist.write(TextUtils.replaceWhitespace(sbuf.toString(), true));
                    break;
                }
            }
            this.attrLocalName = null;
            this.attrPrefix = null;
            if (this.currentNamespacePrefix == null || this.namespacePrefixes) {
                this.tlist.endAttribute();
            }
            if (this.currentNamespacePrefix != null) {
                int attrStart;
                int uriStart = attrStart = this.startIndexes[this.attrCount - 1];
                int uriEnd = this.tlist.gapStart;
                int uriLength = uriEnd - uriStart;
                char[] data = this.tlist.data;
                int uriHash = 0;
                for (int i = uriStart; i < uriEnd; ++i) {
                    char datum = data[i];
                    if ((datum & 65535) > 40959) {
                        StringBuffer sbuf = new StringBuffer();
                        this.tlist.stringValue(uriStart, uriEnd, sbuf);
                        uriHash = sbuf.hashCode();
                        uriStart = 0;
                        uriEnd = uriLength = sbuf.length();
                        data = new char[sbuf.length()];
                        sbuf.getChars(0, uriEnd, data, 0);
                        break;
                    }
                    uriHash = 31 * uriHash + datum;
                }
                this.tlist.gapStart = attrStart;
                String prefix = this.currentNamespacePrefix == "" ? null : this.currentNamespacePrefix;
                MappingInfo info = this.lookupNamespaceBinding(prefix, data, uriStart, uriLength, uriHash, this.namespaceBindings);
                this.namespaceBindings = info.namespaces;
                this.currentNamespacePrefix = null;
            }
        }
    }

    private String resolve(String prefix, boolean isAttribute) {
        if (isAttribute && prefix == null) {
            return "";
        }
        String uri = this.namespaceBindings.resolve(prefix);
        if (uri != null) {
            return uri;
        }
        if (prefix != null) {
            this.error('e', "unknown namespace prefix '" + prefix + '\'');
        }
        return "";
    }

    void closeStartTag() {
        int i;
        Object saved;
        if (this.attrCount < 0 || this.stringizingLevel > 0) {
            return;
        }
        this.inStartTag = false;
        this.previous = 0;
        if (this.attrLocalName != null) {
            this.endAttribute();
        }
        NamespaceBinding outer = this.nesting == 0 ? NamespaceBinding.predefinedXML : (NamespaceBinding)this.workStack[this.nesting - 2];
        NamespaceBinding bindings = this.namespaceBindings;
        block0 : for (i = 0; i <= this.attrCount; ++i) {
            String uri;
            saved = this.workStack[this.nesting + i - 1];
            if (!(saved instanceof Symbol)) continue;
            Symbol sym = (Symbol)saved;
            String prefix = sym.getPrefix();
            if (prefix == "") {
                prefix = null;
            }
            if ((uri = sym.getNamespaceURI()) == "") {
                uri = null;
            }
            if (i > 0 && prefix == null && uri == null) continue;
            boolean isOuter = false;
            NamespaceBinding ns = bindings;
            do {
                if (ns == outer) {
                    isOuter = true;
                }
                if (ns == null) {
                    if (prefix == null && uri == null) continue block0;
                    bindings = this.findNamespaceBinding(prefix, uri, bindings);
                    continue block0;
                }
                if (ns.prefix == prefix) {
                    String nprefix;
                    if (ns.uri == uri) continue block0;
                    if (isOuter) {
                        bindings = this.findNamespaceBinding(prefix, uri, bindings);
                        continue block0;
                    }
                    NamespaceBinding ns2 = bindings;
                    do {
                        if (ns2 == null) {
                            int j = 1;
                            while (bindings.resolve(nprefix = ("_ns_" + j).intern()) != null) {
                                ++j;
                            }
                            break;
                        }
                        if (ns2.uri == uri && bindings.resolve(nprefix = ns2.prefix) == uri) break;
                        ns2 = ns2.next;
                    } while (true);
                    bindings = this.findNamespaceBinding(nprefix, uri, bindings);
                    String local = sym.getLocalName();
                    if (uri == null) {
                        uri = "";
                    }
                    this.workStack[this.nesting + i - 1] = Symbol.make(uri, local, nprefix);
                    continue block0;
                }
                ns = ns.next;
            } while (true);
        }
        for (i = 0; i <= this.attrCount; ++i) {
            Object type;
            String uri;
            String local;
            boolean isNsNode;
            MappingInfo info;
            block45 : {
                block41 : {
                    String prefix;
                    saved = this.workStack[this.nesting + i - 1];
                    isNsNode = false;
                    if (!(saved instanceof MappingInfo) && this.out != this.tlist) break block41;
                    if (saved instanceof MappingInfo) {
                        info = (MappingInfo)saved;
                        prefix = info.prefix;
                        local = info.local;
                        if (i > 0 && (prefix == null && local == "xmlns" || prefix == "xmlns")) {
                            isNsNode = true;
                            uri = "(namespace-node)";
                        } else {
                            uri = this.resolve(prefix, i > 0);
                        }
                    } else {
                        if (!(saved instanceof Symbol)) {
                            throw new ClassCastException("expected element start tag (a symbol) - instead got a " + saved.getClass().getName());
                        }
                        Symbol symbol = (Symbol)saved;
                        info = this.lookupTag(symbol);
                        prefix = info.prefix;
                        local = info.local;
                        uri = symbol.getNamespaceURI();
                    }
                    int hash = info.tagHash;
                    int bucket = hash & this.mappingTableMask;
                    info = this.mappingTable[bucket];
                    Object tagMatch = null;
                    do {
                        block42 : {
                            Symbol type2;
                            XName xname;
                            block44 : {
                                block43 : {
                                    if (info == null) {
                                        info = tagMatch;
                                        info = new MappingInfo();
                                        info.tagHash = hash;
                                        info.prefix = prefix;
                                        info.local = local;
                                        info.nextInBucket = this.mappingTable[bucket];
                                        this.mappingTable[bucket] = info;
                                        info.uri = uri;
                                        info.qname = Symbol.make(uri, local, prefix);
                                        if (i != 0) break;
                                        xname = new XName(info.qname, bindings);
                                        type2 = xname;
                                        info.type = xname;
                                        info.namespaces = bindings;
                                        break;
                                    }
                                    if (info.tagHash != hash || info.local != local || info.prefix != prefix) break block42;
                                    if (info.uri != null) break block43;
                                    info.uri = uri;
                                    info.qname = Symbol.make(uri, local, prefix);
                                    break block44;
                                }
                                if (info.uri != uri) break block42;
                                if (info.qname == null) {
                                    info.qname = Symbol.make(uri, local, prefix);
                                }
                            }
                            if (i == 0) {
                                if (info.namespaces == bindings || info.namespaces == null) {
                                    type2 = info.type;
                                    info.namespaces = bindings;
                                    if (type2 != null) break;
                                    xname = new XName(info.qname, bindings);
                                    type2 = xname;
                                    info.type = xname;
                                    break;
                                }
                            } else {
                                type2 = info.qname;
                                break;
                            }
                        }
                        info = info.nextInBucket;
                    } while (true);
                    this.workStack[this.nesting + i - 1] = info;
                    break block45;
                }
                Symbol sym = (Symbol)saved;
                uri = sym.getNamespaceURI();
                local = sym.getLocalName();
                info = null;
            }
            for (int j = 1; j < i; ++j) {
                Symbol osym;
                Object other = this.workStack[this.nesting + j - 1];
                if (other instanceof Symbol) {
                    osym = (Symbol)other;
                } else {
                    if (!(other instanceof MappingInfo)) continue;
                    osym = ((MappingInfo)other).qname;
                }
                if (local != osym.getLocalPart() || uri != osym.getNamespaceURI()) continue;
                Object tag = this.workStack[this.nesting - 1];
                if (tag instanceof MappingInfo) {
                    tag = ((MappingInfo)tag).qname;
                }
                this.error('e', XMLFilter.duplicateAttributeMessage(osym, tag));
            }
            if (this.out == this.tlist) {
                type = i == 0 ? info.type : info.qname;
                int index = info.index;
                if (index <= 0 || this.tlist.objects[index] != type) {
                    info.index = index = this.tlist.find(type);
                }
                if (i == 0) {
                    this.tlist.setElementName(this.tlist.gapEnd, index);
                    continue;
                }
                if (isNsNode && !this.namespacePrefixes) continue;
                this.tlist.setAttributeName(this.startIndexes[i - 1], index);
                continue;
            }
            Object object2 = info == null ? saved : (type = i == 0 ? info.type : info.qname);
            if (i == 0) {
                this.out.startElement(type);
                continue;
            }
            if (isNsNode && !this.namespacePrefixes) continue;
            this.out.startAttribute(type);
            int start = this.startIndexes[i - 1];
            int end = i < this.attrCount ? this.startIndexes[i] : this.tlist.gapStart;
            this.tlist.consumeIRange(start + 5, end - 1, this.out);
            this.out.endAttribute();
        }
        if (this.out instanceof ContentConsumer) {
            ((ContentConsumer)this.out).endStartTag();
        }
        for (i = 1; i <= this.attrCount; ++i) {
            this.workStack[this.nesting + i - 1] = null;
        }
        if (this.out != this.tlist) {
            this.base = this.out;
            this.tlist.clear();
        }
        this.attrCount = -1;
    }

    protected boolean checkWriteAtomic() {
        this.previous = 0;
        if (this.ignoringLevel > 0) {
            return false;
        }
        this.closeStartTag();
        return true;
    }

    @Override
    public void write(int v) {
        if (this.checkWriteAtomic()) {
            this.base.write(v);
        }
    }

    @Override
    public void writeBoolean(boolean v) {
        if (this.checkWriteAtomic()) {
            this.base.writeBoolean(v);
        }
    }

    @Override
    public void writeFloat(float v) {
        if (this.checkWriteAtomic()) {
            this.base.writeFloat(v);
        }
    }

    @Override
    public void writeDouble(double v) {
        if (this.checkWriteAtomic()) {
            this.base.writeDouble(v);
        }
    }

    @Override
    public void writeInt(int v) {
        if (this.checkWriteAtomic()) {
            this.base.writeInt(v);
        }
    }

    @Override
    public void writeLong(long v) {
        if (this.checkWriteAtomic()) {
            this.base.writeLong(v);
        }
    }

    public void writeDocumentUri(Object uri) {
        if (this.nesting == 2 && this.base instanceof TreeList) {
            ((TreeList)this.base).writeDocumentUri(uri);
        }
    }

    @Override
    public void writePosition(SeqPosition position) {
        this.writePosition((AbstractSequence)position.sequence, position.ipos);
    }

    @Override
    public void writePosition(AbstractSequence seq, int ipos) {
        if (this.ignoringLevel > 0) {
            return;
        }
        if (this.stringizingLevel > 0 && this.previous == 2) {
            if (this.stringizingElementNesting < 0) {
                this.write(32);
            }
            this.previous = 0;
        }
        seq.consumeNext(ipos, this);
        if (this.stringizingLevel > 0 && this.stringizingElementNesting < 0) {
            this.previous = 2;
        }
    }

    @Override
    public void writeObject(Object v) {
        if (this.ignoringLevel > 0) {
            return;
        }
        if (v instanceof SeqPosition) {
            SeqPosition pos = (SeqPosition)v;
            this.writePosition((AbstractSequence)pos.sequence, pos.getPos());
        } else if (v instanceof TreeList) {
            ((TreeList)v).consume(this);
        } else if (v instanceof List && !(v instanceof CharSeq)) {
            List seq = (List)v;
            Iterator it = seq.iterator();
            boolean wasAtomic = false;
            int i = 0;
            while (it.hasNext()) {
                this.writeObject(it.next());
                ++i;
            }
        } else if (v instanceof Keyword) {
            Keyword k = (Keyword)v;
            this.startAttribute(k.asSymbol());
            this.previous = 1;
        } else {
            boolean inImplicitAttr;
            boolean bl = inImplicitAttr = this.previous == 1;
            if (!inImplicitAttr) {
                this.closeStartTag();
            }
            if (v instanceof UnescapedData) {
                this.base.writeObject(v);
                this.previous = 0;
            } else {
                if (this.previous == 2) {
                    this.write(32);
                }
                TextUtils.textValue(v, this);
                this.previous = 2;
            }
            if (inImplicitAttr) {
                this.endAttribute();
            }
        }
    }

    public XMLFilter(Consumer out) {
        this.base = out;
        this.out = out;
        this.tlist = out instanceof NodeTree ? (NodeTree)out : new TreeList();
        this.namespaceBindings = NamespaceBinding.predefinedXML;
    }

    @Override
    public void write(char[] data, int start, int length) {
        if (length == 0) {
            this.writeJoiner();
        } else if (this.checkWriteAtomic()) {
            this.base.write(data, start, length);
        }
    }

    @Override
    public void write(String str) {
        this.write(str, 0, str.length());
    }

    @Override
    public void write(CharSequence str, int start, int length) {
        if (length == 0) {
            this.writeJoiner();
        } else if (this.checkWriteAtomic()) {
            this.base.write(str, start, length);
        }
    }

    final boolean inElement() {
        int i;
        for (i = this.nesting; i > 0 && this.workStack[i - 1] == null; i -= 2) {
        }
        return i != 0;
    }

    public void linefeedFromParser() {
        if (this.inElement() && this.checkWriteAtomic()) {
            this.base.write(10);
        }
    }

    public void textFromParser(char[] data, int start, int length) {
        block6 : {
            if (!this.inElement()) {
                int i = 0;
                do {
                    if (i == length) {
                        return;
                    }
                    if (!Character.isWhitespace(data[start + i])) {
                        this.error('e', "text at document level");
                        break block6;
                    }
                    ++i;
                } while (true);
            }
            if (length > 0) {
                if (!this.checkWriteAtomic()) {
                    return;
                }
                this.base.write(data, start, length);
            }
        }
    }

    protected void writeJoiner() {
        this.previous = 0;
        if (this.ignoringLevel == 0 && this.base instanceof TreeList) {
            ((TreeList)this.base).writeJoiner();
        }
    }

    @Override
    public void writeCDATA(char[] data, int start, int length) {
        if (this.checkWriteAtomic()) {
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).writeCDATA(data, start, length);
            } else {
                this.write(data, start, length);
            }
        }
    }

    protected void startElementCommon() {
        this.closeStartTag();
        if (this.stringizingLevel == 0) {
            this.ensureSpaceInWorkStack(this.nesting);
            this.workStack[this.nesting] = this.namespaceBindings;
            this.tlist.startElement(0);
            this.base = this.tlist;
            this.attrCount = 0;
        } else {
            if (this.previous == 2 && this.stringizingElementNesting < 0) {
                this.write(32);
            }
            this.previous = 0;
            if (this.stringizingElementNesting < 0) {
                this.stringizingElementNesting = this.nesting;
            }
        }
        this.nesting += 2;
    }

    public void emitStartElement(char[] data, int start, int count) {
        this.closeStartTag();
        MappingInfo info = this.lookupTag(data, start, count);
        this.startElementCommon();
        this.ensureSpaceInWorkStack(this.nesting - 1);
        this.workStack[this.nesting - 1] = info;
    }

    @Override
    public void startElement(Object type) {
        this.startElementCommon();
        if (this.stringizingLevel == 0) {
            this.ensureSpaceInWorkStack(this.nesting - 1);
            this.workStack[this.nesting - 1] = type;
            if (this.copyNamespacesMode == 0) {
                this.namespaceBindings = NamespaceBinding.predefinedXML;
            } else if (this.copyNamespacesMode == 1 || this.nesting == 2) {
                this.namespaceBindings = type instanceof XName ? ((XName)type).getNamespaceNodes() : NamespaceBinding.predefinedXML;
            } else {
                NamespaceBinding preserved;
                NamespaceBinding join;
                NamespaceBinding inherited;
                int i = 2;
                do {
                    if (i == this.nesting) {
                        inherited = null;
                        break;
                    }
                    if (this.workStack[i + 1] != null) {
                        inherited = (NamespaceBinding)this.workStack[i];
                        break;
                    }
                    i += 2;
                } while (true);
                this.namespaceBindings = inherited == null ? (type instanceof XName ? ((XName)type).getNamespaceNodes() : NamespaceBinding.predefinedXML) : (this.copyNamespacesMode == 2 ? inherited : (type instanceof XName ? ((join = NamespaceBinding.commonAncestor(inherited, preserved = ((XName)type).getNamespaceNodes())) == inherited ? preserved : this.mergeHelper(inherited, preserved)) : inherited));
            }
        }
    }

    private NamespaceBinding mergeHelper(NamespaceBinding list, NamespaceBinding node) {
        String prefix;
        String found;
        if (node == NamespaceBinding.predefinedXML) {
            return list;
        }
        list = this.mergeHelper(list, node.next);
        String uri = node.uri;
        if (list == null) {
            if (uri == null) {
                return list;
            }
            list = NamespaceBinding.predefinedXML;
        }
        if ((found = list.resolve(prefix = node.prefix)) == null ? uri == null : found.equals(uri)) {
            return list;
        }
        return this.findNamespaceBinding(prefix, uri, list);
    }

    private boolean startAttributeCommon() {
        if (this.stringizingElementNesting >= 0) {
            ++this.ignoringLevel;
        }
        if (this.stringizingLevel++ > 0) {
            return false;
        }
        if (this.attrCount < 0) {
            this.attrCount = 0;
        }
        this.ensureSpaceInWorkStack(this.nesting + this.attrCount);
        this.ensureSpaceInStartIndexes(this.attrCount);
        this.startIndexes[this.attrCount] = this.tlist.gapStart;
        ++this.attrCount;
        return true;
    }

    @Override
    public void startAttribute(Object attrType) {
        String local;
        this.previous = 0;
        Symbol sym = (Symbol)attrType;
        this.attrLocalName = local = sym.getLocalPart();
        this.attrPrefix = sym.getPrefix();
        String uri = sym.getNamespaceURI();
        if (uri == "http://www.w3.org/2000/xmlns/" || uri == "" && local == "xmlns") {
            this.error('e', "attribute name cannot be 'xmlns' or in xmlns namespace");
        }
        if (this.nesting == 2 && this.workStack[1] == null && this.stringizingLevel == 0) {
            this.error('e', "attribute not allowed at document level");
        }
        if (this.attrCount < 0 && this.nesting > 0) {
            this.error('e', "attribute '" + attrType + "' follows non-attribute content");
        }
        if (this.startAttributeCommon()) {
            this.workStack[this.nesting + this.attrCount - 1] = attrType;
            if (this.nesting == 0) {
                this.base.startAttribute(attrType);
            } else {
                this.tlist.startAttribute(0);
            }
        }
    }

    public void emitStartAttribute(char[] data, int start, int count) {
        String local;
        if (this.attrLocalName != null) {
            this.endAttribute();
        }
        if (!this.startAttributeCommon()) {
            return;
        }
        MappingInfo info = this.lookupTag(data, start, count);
        this.workStack[this.nesting + this.attrCount - 1] = info;
        String prefix = info.prefix;
        this.attrLocalName = local = info.local;
        this.attrPrefix = prefix;
        if (prefix != null) {
            if (prefix == "xmlns") {
                this.currentNamespacePrefix = local;
            }
        } else if (local == "xmlns" && prefix == null) {
            this.currentNamespacePrefix = "";
        }
        if (this.currentNamespacePrefix == null || this.namespacePrefixes) {
            this.tlist.startAttribute(0);
        }
    }

    public void emitEndAttributes() {
        if (this.attrLocalName != null) {
            this.endAttribute();
        }
        this.closeStartTag();
    }

    public void emitEndElement(char[] data, int start, int length) {
        if (this.attrLocalName != null) {
            this.error('e', "unclosed attribute");
            this.endAttribute();
        }
        if (!this.inElement()) {
            this.error('e', "unmatched end element");
            return;
        }
        if (data != null) {
            MappingInfo info = this.lookupTag(data, start, length);
            Object old = this.workStack[this.nesting - 1];
            if (old instanceof MappingInfo && !this.mismatchReported) {
                MappingInfo mold = (MappingInfo)old;
                if (info.local != mold.local || info.prefix != mold.prefix) {
                    StringBuffer sbuf = new StringBuffer("</");
                    sbuf.append(data, start, length);
                    sbuf.append("> matching <");
                    String oldPrefix = mold.prefix;
                    if (oldPrefix != null) {
                        sbuf.append(oldPrefix);
                        sbuf.append(':');
                    }
                    sbuf.append(mold.local);
                    sbuf.append('>');
                    this.error('e', sbuf.toString());
                    this.mismatchReported = true;
                }
            }
        }
        this.closeStartTag();
        if (this.nesting <= 0) {
            return;
        }
        this.endElement();
    }

    @Override
    public void endElement() {
        this.closeStartTag();
        this.nesting -= 2;
        this.previous = 0;
        if (this.stringizingLevel == 0) {
            this.namespaceBindings = (NamespaceBinding)this.workStack[this.nesting];
            this.workStack[this.nesting] = null;
            this.workStack[this.nesting + 1] = null;
            this.base.endElement();
        } else if (this.stringizingElementNesting == this.nesting) {
            this.stringizingElementNesting = -1;
            this.previous = 2;
        }
    }

    public void emitEntityReference(char[] name, int start, int length) {
        char c0 = name[start];
        int ch = 63;
        if (length == 2 && name[start + 1] == 't') {
            if (c0 == 'l') {
                ch = 60;
            } else if (c0 == 'g') {
                ch = 62;
            }
        } else if (length == 3) {
            if (c0 == 'a' && name[start + 1] == 'm' && name[start + 2] == 'p') {
                ch = 38;
            }
        } else if (length == 4) {
            char c1 = name[start + 1];
            char c2 = name[start + 2];
            char c3 = name[start + 3];
            if (c0 == 'q' && c1 == 'u' && c2 == 'o' && c3 == 't') {
                ch = 34;
            } else if (c0 == 'a' && c1 == 'p' && c2 == 'o' && c3 == 's') {
                ch = 39;
            }
        }
        this.write(ch);
    }

    public void emitCharacterReference(int value, char[] name, int start, int length) {
        if (value >= 65536) {
            Char.print(value, this);
        } else {
            this.write(value);
        }
    }

    protected void checkValidComment(char[] chars, int offset, int length) {
        int i = length;
        boolean sawHyphen = true;
        while (--i >= 0) {
            boolean curHyphen;
            boolean bl = curHyphen = chars[offset + i] == '-';
            if (sawHyphen && curHyphen) {
                this.error('e', "consecutive or final hyphen in XML comment");
                break;
            }
            sawHyphen = curHyphen;
        }
    }

    @Override
    public void writeComment(char[] chars, int start, int length) {
        this.checkValidComment(chars, start, length);
        this.commentFromParser(chars, start, length);
    }

    public void commentFromParser(char[] chars, int start, int length) {
        if (this.stringizingLevel == 0) {
            this.closeStartTag();
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).writeComment(chars, start, length);
            }
        } else if (this.stringizingElementNesting < 0) {
            this.base.write(chars, start, length);
        }
    }

    @Override
    public void writeProcessingInstruction(String target, char[] content, int offset, int length) {
        target = TextUtils.replaceWhitespace(target, true);
        int i = offset + length;
        block0 : while (--i >= offset) {
            char ch = content[i];
            while (ch == '>' && --i >= offset) {
                ch = content[i];
                if (ch != '?') continue;
                this.error('e', "'?>' is not allowed in a processing-instruction");
                continue block0;
            }
        }
        if ("xml".equalsIgnoreCase(target)) {
            this.error('e', "processing-instruction target may not be 'xml' (ignoring case)");
        }
        if (!XName.isNCName(target)) {
            this.error('e', "processing-instruction target '" + target + "' is not a valid Name");
        }
        this.processingInstructionCommon(target, content, offset, length);
    }

    void processingInstructionCommon(String target, char[] content, int offset, int length) {
        if (this.stringizingLevel == 0) {
            this.closeStartTag();
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).writeProcessingInstruction(target, content, offset, length);
            }
        } else if (this.stringizingElementNesting < 0) {
            this.base.write(content, offset, length);
        }
    }

    public void processingInstructionFromParser(char[] buffer, int tstart, int tlength, int dstart, int dlength) {
        if (tlength == 3 && !this.inElement() && buffer[tstart] == 'x' && buffer[tstart + 1] == 'm' && buffer[tstart + 2] == 'l') {
            return;
        }
        String target = new String(buffer, tstart, tlength);
        this.processingInstructionCommon(target, buffer, dstart, dlength);
    }

    @Override
    public void startDocument() {
        this.closeStartTag();
        if (this.stringizingLevel > 0) {
            this.writeJoiner();
        } else {
            if (this.nesting == 0) {
                this.base.startDocument();
            } else {
                this.writeJoiner();
            }
            this.ensureSpaceInWorkStack(this.nesting);
            this.workStack[this.nesting] = this.namespaceBindings;
            this.workStack[this.nesting + 1] = null;
            this.nesting += 2;
        }
    }

    @Override
    public void endDocument() {
        if (this.stringizingLevel > 0) {
            this.writeJoiner();
            return;
        }
        this.nesting -= 2;
        this.namespaceBindings = (NamespaceBinding)this.workStack[this.nesting];
        this.workStack[this.nesting] = null;
        this.workStack[this.nesting + 1] = null;
        if (this.nesting == 0) {
            this.base.endDocument();
        } else {
            this.writeJoiner();
        }
    }

    public void emitDoctypeDecl(char[] buffer, int target, int tlength, int data, int dlength) {
    }

    @Override
    public void beginEntity(Object baseUri) {
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).beginEntity(baseUri);
        }
    }

    @Override
    public void endEntity() {
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).endEntity();
        }
    }

    @Override
    public XMLFilter append(char c) {
        this.write(c);
        return this;
    }

    @Override
    public XMLFilter append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        this.append(csq, 0, csq.length());
        return this;
    }

    @Override
    public XMLFilter append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        this.write(csq, start, end - start);
        return this;
    }

    MappingInfo lookupTag(Symbol qname) {
        MappingInfo first;
        String local = qname.getLocalPart();
        String prefix = qname.getPrefix();
        if (prefix == "") {
            prefix = null;
        }
        String uri = qname.getNamespaceURI();
        int hash = MappingInfo.hash(prefix, local);
        int index = hash & this.mappingTableMask;
        MappingInfo info = first = this.mappingTable[index];
        do {
            if (info == null) {
                info = new MappingInfo();
                info.qname = qname;
                info.prefix = prefix;
                info.uri = uri;
                info.local = local;
                info.tagHash = hash;
                info.nextInBucket = first;
                this.mappingTable[index] = first;
                return info;
            }
            if (qname == info.qname) {
                return info;
            }
            if (local == info.local && info.qname == null && (uri == info.uri || info.uri == null) && prefix == info.prefix) {
                info.uri = uri;
                info.qname = qname;
                return info;
            }
            info = info.nextInBucket;
        } while (true);
    }

    MappingInfo lookupTag(char[] data, int start, int length) {
        MappingInfo first;
        int hash = 0;
        int prefixHash = 0;
        int colon = -1;
        for (int i = 0; i < length; ++i) {
            char ch = data[start + i];
            if (ch == ':' && colon < 0) {
                colon = i;
                prefixHash = hash;
                hash = 0;
                continue;
            }
            hash = 31 * hash + ch;
        }
        hash = prefixHash ^ hash;
        int index = hash & this.mappingTableMask;
        MappingInfo info = first = this.mappingTable[index];
        do {
            if (info == null) {
                info = new MappingInfo();
                info.tagHash = hash;
                if (colon >= 0) {
                    info.prefix = new String(data, start, colon).intern();
                    int lstart = start + ++colon;
                    info.local = new String(data, lstart, length - colon).intern();
                } else {
                    info.prefix = null;
                    info.local = new String(data, start, length).intern();
                }
                info.nextInBucket = first;
                this.mappingTable[index] = first;
                return info;
            }
            if (hash == info.tagHash && info.match(data, start, length)) {
                return info;
            }
            info = info.nextInBucket;
        } while (true);
    }

    private void ensureSpaceInWorkStack(int oldSize) {
        if (this.workStack == null) {
            this.workStack = new Object[20];
        } else if (oldSize >= this.workStack.length) {
            Object[] tmpn = new Object[2 * this.workStack.length];
            System.arraycopy(this.workStack, 0, tmpn, 0, oldSize);
            this.workStack = tmpn;
        }
    }

    private void ensureSpaceInStartIndexes(int oldSize) {
        if (this.startIndexes == null) {
            this.startIndexes = new int[20];
        } else if (oldSize >= this.startIndexes.length) {
            int[] tmpn = new int[2 * this.startIndexes.length];
            System.arraycopy(this.startIndexes, 0, tmpn, 0, oldSize);
            this.startIndexes = tmpn;
        }
    }

    public static String duplicateAttributeMessage(Symbol attrSymbol, Object elementName) {
        StringBuffer sbuf = new StringBuffer("duplicate attribute: ");
        String uri = attrSymbol.getNamespaceURI();
        if (uri != null && uri.length() > 0) {
            sbuf.append('{');
            sbuf.append('}');
            sbuf.append(uri);
        }
        sbuf.append(attrSymbol.getLocalPart());
        if (elementName != null) {
            sbuf.append(" in <");
            sbuf.append(elementName);
            sbuf.append('>');
        }
        return sbuf.toString();
    }

    public void error(char severity, String message) {
        if (this.messages == null) {
            throw new RuntimeException(message);
        }
        if (this.locator != null) {
            this.messages.error(severity, this.locator, message);
        } else {
            this.messages.error(severity, message);
        }
    }

    @Override
    public boolean ignoring() {
        return this.ignoringLevel > 0;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        if (locator instanceof SourceLocator) {
            this.locator = (SourceLocator)locator;
        }
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        this.startElement(Symbol.make(namespaceURI, localName));
        int numAttributes = atts.getLength();
        for (int i = 0; i < numAttributes; ++i) {
            this.startAttribute(Symbol.make(atts.getURI(i), atts.getLocalName(i)));
            this.write(atts.getValue(i));
            this.endAttribute();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        this.endElement();
    }

    @Override
    public void startElement(String name, AttributeList atts) {
        name = name.intern();
        this.startElement(name);
        int attrLength = atts.getLength();
        for (int i = 0; i < attrLength; ++i) {
            name = atts.getName(i);
            name = name.intern();
            String type = atts.getType(i);
            String value = atts.getValue(i);
            this.startAttribute(name);
            this.write(value);
            this.endAttribute();
        }
    }

    @Override
    public void endElement(String name) throws SAXException {
        this.endElement();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.write(ch, start, length);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        this.write(ch, start, length);
    }

    @Override
    public void processingInstruction(String target, String data) {
        char[] chars = data.toCharArray();
        this.processingInstructionCommon(target, chars, 0, chars.length);
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        this.namespaceBindings = this.findNamespaceBinding(prefix.intern(), uri.intern(), this.namespaceBindings);
    }

    @Override
    public void endPrefixMapping(String prefix) {
        this.namespaceBindings = this.namespaceBindings.getNext();
    }

    @Override
    public void skippedEntity(String name) {
    }

    @Override
    public String getPublicId() {
        return null;
    }

    @Override
    public String getSystemId() {
        return this.in == null ? null : this.in.getName();
    }

    @Override
    public String getFileName() {
        return this.in == null ? null : this.in.getName();
    }

    @Override
    public int getLineNumber() {
        if (this.in == null) {
            return -1;
        }
        int line = this.in.getLineNumber();
        return line < 0 ? -1 : line + 1;
    }

    @Override
    public int getColumnNumber() {
        int col;
        return this.in != null && (col = this.in.getColumnNumber()) > 0 ? col : -1;
    }

    @Override
    public boolean isStableSourceLocation() {
        return false;
    }
}

