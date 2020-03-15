// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xml;

import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import gnu.text.Char;
import java.util.Iterator;
import gnu.lists.UnescapedData;
import gnu.expr.Keyword;
import gnu.lists.CharSeq;
import java.util.List;
import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;
import gnu.kawa.sax.ContentConsumer;
import gnu.mapping.Symbol;
import gnu.kawa.io.InPort;
import gnu.text.SourceMessages;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.lists.PositionConsumer;
import gnu.lists.XConsumer;
import gnu.text.SourceLocator;
import org.xml.sax.ContentHandler;
import org.xml.sax.DocumentHandler;

public class XMLFilter implements DocumentHandler, ContentHandler, SourceLocator, XConsumer, PositionConsumer
{
    TreeList tlist;
    public Consumer out;
    private Consumer base;
    public static final int COPY_NAMESPACES_PRESERVE = 1;
    public static final int COPY_NAMESPACES_INHERIT = 2;
    public transient int copyNamespacesMode;
    Object[] workStack;
    NamespaceBinding namespaceBindings;
    private SourceMessages messages;
    SourceLocator locator;
    InPort in;
    protected int nesting;
    int previous;
    private static final int SAW_KEYWORD = 1;
    private static final int SAW_WORD = 2;
    protected int stringizingLevel;
    protected int stringizingElementNesting;
    protected int ignoringLevel;
    int[] startIndexes;
    int attrCount;
    boolean inStartTag;
    String attrLocalName;
    String attrPrefix;
    String currentNamespacePrefix;
    public boolean namespacePrefixes;
    MappingInfo[] mappingTable;
    int mappingTableMask;
    boolean mismatchReported;
    
    public void setSourceLocator(final InPort in) {
        this.in = in;
        this.locator = this;
    }
    
    public void setSourceLocator(final SourceLocator locator) {
        this.locator = locator;
    }
    
    public void setMessages(final SourceMessages messages) {
        this.messages = messages;
    }
    
    public NamespaceBinding findNamespaceBinding(final String prefix, String uri, final NamespaceBinding oldBindings) {
        int hash = (uri == null) ? 0 : uri.hashCode();
        if (prefix != null) {
            hash ^= prefix.hashCode();
        }
        final int bucket = hash & this.mappingTableMask;
        for (MappingInfo info = this.mappingTable[bucket]; info != null; info = info.nextInBucket) {
            final NamespaceBinding namespaces;
            if (info.tagHash == hash && info.prefix == prefix && (namespaces = info.namespaces) != null && namespaces.getNext() == this.namespaceBindings && namespaces.getPrefix() == prefix && info.uri == uri) {
                return info.namespaces;
            }
        }
        MappingInfo info = new MappingInfo();
        info.nextInBucket = this.mappingTable[bucket];
        this.mappingTable[bucket] = info;
        info.tagHash = hash;
        info.prefix = prefix;
        info.local = uri;
        if ((info.uri = uri) == "") {
            uri = null;
        }
        NamespaceBinding namespaces = new NamespaceBinding(prefix, uri, oldBindings);
        return info.namespaces = namespaces;
    }
    
    public MappingInfo lookupNamespaceBinding(final String prefix, final char[] uriChars, final int uriStart, final int uriLength, final int uriHash, final NamespaceBinding oldBindings) {
        final int hash = (prefix == null) ? uriHash : (prefix.hashCode() ^ uriHash);
        final int bucket = hash & this.mappingTableMask;
        for (MappingInfo info = this.mappingTable[bucket]; info != null; info = info.nextInBucket) {
            final NamespaceBinding namespaces;
            if (info.tagHash == hash && info.prefix == prefix && (namespaces = info.namespaces) != null && namespaces.getNext() == this.namespaceBindings && namespaces.getPrefix() == prefix && MappingInfo.equals(info.uri, uriChars, uriStart, uriLength)) {
                return info;
            }
        }
        MappingInfo info = new MappingInfo();
        info.nextInBucket = this.mappingTable[bucket];
        this.mappingTable[bucket] = info;
        String uri = new String(uriChars, uriStart, uriLength).intern();
        info.tagHash = hash;
        info.prefix = prefix;
        info.local = uri;
        if ((info.uri = uri) == "") {
            uri = null;
        }
        final NamespaceBinding namespaces2 = new NamespaceBinding(prefix, uri, oldBindings);
        info.namespaces = namespaces2;
        return info;
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
                final int valStart = this.startIndexes[this.attrCount - 1] + 5;
                final int valEnd = this.tlist.gapStart;
                final char[] data = this.tlist.data;
                int i = valStart;
                while (i < valEnd) {
                    final char datum = data[i++];
                    if ((datum & '\uffff') > 40959 || datum == '\t' || datum == '\r' || datum == '\n' || (datum == ' ' && (i == valEnd || data[i] == ' '))) {
                        final StringBuffer sbuf = new StringBuffer();
                        this.tlist.stringValue(valStart, valEnd, sbuf);
                        this.tlist.gapStart = valStart;
                        this.tlist.write(TextUtils.replaceWhitespace(sbuf.toString(), true));
                        break;
                    }
                }
            }
            this.attrLocalName = null;
            this.attrPrefix = null;
            if (this.currentNamespacePrefix == null || this.namespacePrefixes) {
                this.tlist.endAttribute();
            }
            if (this.currentNamespacePrefix != null) {
                int uriStart;
                final int attrStart = uriStart = this.startIndexes[this.attrCount - 1];
                int uriEnd = this.tlist.gapStart;
                int uriLength = uriEnd - uriStart;
                char[] data2 = this.tlist.data;
                int uriHash = 0;
                for (int j = uriStart; j < uriEnd; ++j) {
                    final char datum2 = data2[j];
                    if ((datum2 & '\uffff') > 40959) {
                        final StringBuffer sbuf2 = new StringBuffer();
                        this.tlist.stringValue(uriStart, uriEnd, sbuf2);
                        uriHash = sbuf2.hashCode();
                        uriStart = 0;
                        uriLength = (uriEnd = sbuf2.length());
                        data2 = new char[sbuf2.length()];
                        sbuf2.getChars(0, uriEnd, data2, 0);
                        break;
                    }
                    uriHash = 31 * uriHash + datum2;
                }
                this.tlist.gapStart = attrStart;
                final String prefix = (this.currentNamespacePrefix == "") ? null : this.currentNamespacePrefix;
                final MappingInfo info = this.lookupNamespaceBinding(prefix, data2, uriStart, uriLength, uriHash, this.namespaceBindings);
                this.namespaceBindings = info.namespaces;
                this.currentNamespacePrefix = null;
            }
        }
    }
    
    private String resolve(final String prefix, final boolean isAttribute) {
        if (isAttribute && prefix == null) {
            return "";
        }
        final String uri = this.namespaceBindings.resolve(prefix);
        if (uri != null) {
            return uri;
        }
        if (prefix != null) {
            this.error('e', "unknown namespace prefix '" + prefix + '\'');
        }
        return "";
    }
    
    void closeStartTag() {
        if (this.attrCount < 0 || this.stringizingLevel > 0) {
            return;
        }
        this.inStartTag = false;
        this.previous = 0;
        if (this.attrLocalName != null) {
            this.endAttribute();
        }
        final NamespaceBinding outer = (NamespaceBinding)((this.nesting == 0) ? NamespaceBinding.predefinedXML : this.workStack[this.nesting - 2]);
        NamespaceBinding bindings = this.namespaceBindings;
    Label_0400:
        for (int i = 0; i <= this.attrCount; ++i) {
            final Object saved = this.workStack[this.nesting + i - 1];
            if (saved instanceof Symbol) {
                final Symbol sym = (Symbol)saved;
                String prefix = sym.getPrefix();
                if (prefix == "") {
                    prefix = null;
                }
                String uri = sym.getNamespaceURI();
                if (uri == "") {
                    uri = null;
                }
                if (i <= 0 || prefix != null || uri != null) {
                    boolean isOuter = false;
                    NamespaceBinding ns = bindings;
                    while (true) {
                        if (ns == outer) {
                            isOuter = true;
                        }
                        if (ns == null) {
                            if (prefix != null || uri != null) {
                                bindings = this.findNamespaceBinding(prefix, uri, bindings);
                                break;
                            }
                            break;
                        }
                        else if (ns.prefix == prefix) {
                            if (ns.uri == uri) {
                                break;
                            }
                            if (isOuter) {
                                bindings = this.findNamespaceBinding(prefix, uri, bindings);
                                break;
                            }
                            while (true) {
                                for (NamespaceBinding ns2 = bindings; ns2 != null; ns2 = ns2.next) {
                                    if (ns2.uri == uri) {
                                        final String nprefix = ns2.prefix;
                                        if (bindings.resolve(nprefix) == uri) {
                                            bindings = this.findNamespaceBinding(nprefix, uri, bindings);
                                            final String local = sym.getLocalName();
                                            if (uri == null) {
                                                uri = "";
                                            }
                                            this.workStack[this.nesting + i - 1] = Symbol.make(uri, local, nprefix);
                                            continue Label_0400;
                                        }
                                    }
                                }
                                int j = 1;
                                while (true) {
                                    final String nprefix = ("_ns_" + j).intern();
                                    if (bindings.resolve(nprefix) == null) {
                                        break;
                                    }
                                    ++j;
                                }
                                continue;
                            }
                        }
                        else {
                            ns = ns.next;
                        }
                    }
                }
            }
        }
        for (int i = 0; i <= this.attrCount; ++i) {
            final Object saved = this.workStack[this.nesting + i - 1];
            boolean isNsNode = false;
            MappingInfo info = null;
            String local2 = null;
            String uri2 = null;
            Label_0988: {
                if (saved instanceof MappingInfo || this.out == this.tlist) {
                    String prefix2;
                    if (saved instanceof MappingInfo) {
                        info = (MappingInfo)saved;
                        prefix2 = info.prefix;
                        local2 = info.local;
                        if (i > 0 && ((prefix2 == null && local2 == "xmlns") || prefix2 == "xmlns")) {
                            isNsNode = true;
                            uri2 = "(namespace-node)";
                        }
                        else {
                            uri2 = this.resolve(prefix2, i > 0);
                        }
                    }
                    else {
                        if (!(saved instanceof Symbol)) {
                            throw new ClassCastException("expected element start tag (a symbol) - instead got a " + saved.getClass().getName());
                        }
                        final Symbol symbol = (Symbol)saved;
                        info = this.lookupTag(symbol);
                        prefix2 = info.prefix;
                        local2 = info.local;
                        uri2 = symbol.getNamespaceURI();
                    }
                    final int hash = info.tagHash;
                    final int bucket = hash & this.mappingTableMask;
                    info = this.mappingTable[bucket];
                    final MappingInfo tagMatch = null;
                    while (true) {
                        while (info != null) {
                            Label_0936: {
                                if (info.tagHash == hash && info.local == local2 && info.prefix == prefix2) {
                                    if (info.uri == null) {
                                        info.uri = uri2;
                                        info.qname = Symbol.make(uri2, local2, prefix2);
                                    }
                                    else {
                                        if (info.uri != uri2) {
                                            break Label_0936;
                                        }
                                        if (info.qname == null) {
                                            info.qname = Symbol.make(uri2, local2, prefix2);
                                        }
                                    }
                                    if (i == 0) {
                                        if (info.namespaces != bindings && info.namespaces != null) {
                                            break Label_0936;
                                        }
                                        Object type = info.type;
                                        info.namespaces = bindings;
                                        if (type == null) {
                                            type = (info.type = new XName(info.qname, bindings));
                                        }
                                    }
                                    else {
                                        final Object type = info.qname;
                                    }
                                    this.workStack[this.nesting + i - 1] = info;
                                    break Label_0988;
                                }
                            }
                            info = info.nextInBucket;
                        }
                        info = tagMatch;
                        info = new MappingInfo();
                        info.tagHash = hash;
                        info.prefix = prefix2;
                        info.local = local2;
                        info.nextInBucket = this.mappingTable[bucket];
                        this.mappingTable[bucket] = info;
                        info.uri = uri2;
                        info.qname = Symbol.make(uri2, local2, prefix2);
                        if (i == 0) {
                            final Object type = info.type = new XName(info.qname, bindings);
                            info.namespaces = bindings;
                        }
                        continue;
                    }
                }
                else {
                    final Symbol sym2 = (Symbol)saved;
                    uri2 = sym2.getNamespaceURI();
                    local2 = sym2.getLocalName();
                    info = null;
                }
            }
            for (int k = 1; k < i; ++k) {
                final Object other = this.workStack[this.nesting + k - 1];
                Symbol osym;
                if (other instanceof Symbol) {
                    osym = (Symbol)other;
                }
                else {
                    if (!(other instanceof MappingInfo)) {
                        continue;
                    }
                    osym = ((MappingInfo)other).qname;
                }
                if (local2 == osym.getLocalPart() && uri2 == osym.getNamespaceURI()) {
                    Object tag = this.workStack[this.nesting - 1];
                    if (tag instanceof MappingInfo) {
                        tag = ((MappingInfo)tag).qname;
                    }
                    this.error('e', duplicateAttributeMessage(osym, tag));
                }
            }
            if (this.out == this.tlist) {
                final Object type2 = (i == 0) ? info.type : info.qname;
                int index = info.index;
                if (index <= 0 || this.tlist.objects[index] != type2) {
                    index = this.tlist.find(type2);
                    info.index = index;
                }
                if (i == 0) {
                    this.tlist.setElementName(this.tlist.gapEnd, index);
                }
                else if (!isNsNode || this.namespacePrefixes) {
                    this.tlist.setAttributeName(this.startIndexes[i - 1], index);
                }
            }
            else {
                final Object type2 = (info == null) ? saved : ((i == 0) ? info.type : info.qname);
                if (i == 0) {
                    this.out.startElement(type2);
                }
                else if (!isNsNode || this.namespacePrefixes) {
                    this.out.startAttribute(type2);
                    final int start = this.startIndexes[i - 1];
                    final int end = (i < this.attrCount) ? this.startIndexes[i] : this.tlist.gapStart;
                    this.tlist.consumeIRange(start + 5, end - 1, this.out);
                    this.out.endAttribute();
                }
            }
        }
        if (this.out instanceof ContentConsumer) {
            ((ContentConsumer)this.out).endStartTag();
        }
        for (int i = 1; i <= this.attrCount; ++i) {
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
    public void write(final int v) {
        if (this.checkWriteAtomic()) {
            this.base.write(v);
        }
    }
    
    @Override
    public void writeBoolean(final boolean v) {
        if (this.checkWriteAtomic()) {
            this.base.writeBoolean(v);
        }
    }
    
    @Override
    public void writeFloat(final float v) {
        if (this.checkWriteAtomic()) {
            this.base.writeFloat(v);
        }
    }
    
    @Override
    public void writeDouble(final double v) {
        if (this.checkWriteAtomic()) {
            this.base.writeDouble(v);
        }
    }
    
    @Override
    public void writeInt(final int v) {
        if (this.checkWriteAtomic()) {
            this.base.writeInt(v);
        }
    }
    
    @Override
    public void writeLong(final long v) {
        if (this.checkWriteAtomic()) {
            this.base.writeLong(v);
        }
    }
    
    public void writeDocumentUri(final Object uri) {
        if (this.nesting == 2 && this.base instanceof TreeList) {
            ((TreeList)this.base).writeDocumentUri(uri);
        }
    }
    
    @Override
    public void writePosition(final SeqPosition position) {
        this.writePosition(position.sequence, position.ipos);
    }
    
    @Override
    public void writePosition(final AbstractSequence seq, final int ipos) {
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
    public void writeObject(final Object v) {
        if (this.ignoringLevel > 0) {
            return;
        }
        if (v instanceof SeqPosition) {
            final SeqPosition pos = (SeqPosition)v;
            this.writePosition(pos.sequence, pos.getPos());
        }
        else if (v instanceof TreeList) {
            ((TreeList)v).consume(this);
        }
        else if (v instanceof List && !(v instanceof CharSeq)) {
            final List seq = (List)v;
            final Iterator it = seq.iterator();
            final boolean wasAtomic = false;
            int i = 0;
            while (it.hasNext()) {
                this.writeObject(it.next());
                ++i;
            }
        }
        else if (v instanceof Keyword) {
            final Keyword k = (Keyword)v;
            this.startAttribute(k.asSymbol());
            this.previous = 1;
        }
        else {
            final boolean inImplicitAttr = this.previous == 1;
            if (!inImplicitAttr) {
                this.closeStartTag();
            }
            if (v instanceof UnescapedData) {
                this.base.writeObject(v);
                this.previous = 0;
            }
            else {
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
    
    public XMLFilter(final Consumer out) {
        this.copyNamespacesMode = 1;
        this.previous = 0;
        this.stringizingElementNesting = -1;
        this.startIndexes = null;
        this.attrCount = -1;
        this.namespacePrefixes = false;
        this.mappingTable = new MappingInfo[128];
        this.mappingTableMask = this.mappingTable.length - 1;
        this.base = out;
        this.out = out;
        if (out instanceof NodeTree) {
            this.tlist = (NodeTree)out;
        }
        else {
            this.tlist = new TreeList();
        }
        this.namespaceBindings = NamespaceBinding.predefinedXML;
    }
    
    @Override
    public void write(final char[] data, final int start, final int length) {
        if (length == 0) {
            this.writeJoiner();
        }
        else if (this.checkWriteAtomic()) {
            this.base.write(data, start, length);
        }
    }
    
    @Override
    public void write(final String str) {
        this.write(str, 0, str.length());
    }
    
    @Override
    public void write(final CharSequence str, final int start, final int length) {
        if (length == 0) {
            this.writeJoiner();
        }
        else if (this.checkWriteAtomic()) {
            this.base.write(str, start, length);
        }
    }
    
    final boolean inElement() {
        int i;
        for (i = this.nesting; i > 0 && this.workStack[i - 1] == null; i -= 2) {}
        return i != 0;
    }
    
    public void linefeedFromParser() {
        if (this.inElement() && this.checkWriteAtomic()) {
            this.base.write(10);
        }
    }
    
    public void textFromParser(final char[] data, final int start, final int length) {
        if (!this.inElement()) {
            for (int i = 0; i != length; ++i) {
                if (!Character.isWhitespace(data[start + i])) {
                    this.error('e', "text at document level");
                    return;
                }
            }
            return;
        }
        if (length > 0) {
            if (!this.checkWriteAtomic()) {
                return;
            }
            this.base.write(data, start, length);
        }
    }
    
    protected void writeJoiner() {
        this.previous = 0;
        if (this.ignoringLevel == 0 && this.base instanceof TreeList) {
            ((TreeList)this.base).writeJoiner();
        }
    }
    
    @Override
    public void writeCDATA(final char[] data, final int start, final int length) {
        if (this.checkWriteAtomic()) {
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).writeCDATA(data, start, length);
            }
            else {
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
        }
        else {
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
    
    public void emitStartElement(final char[] data, final int start, final int count) {
        this.closeStartTag();
        final MappingInfo info = this.lookupTag(data, start, count);
        this.startElementCommon();
        this.ensureSpaceInWorkStack(this.nesting - 1);
        this.workStack[this.nesting - 1] = info;
    }
    
    @Override
    public void startElement(final Object type) {
        this.startElementCommon();
        if (this.stringizingLevel == 0) {
            this.ensureSpaceInWorkStack(this.nesting - 1);
            this.workStack[this.nesting - 1] = type;
            if (this.copyNamespacesMode == 0) {
                this.namespaceBindings = NamespaceBinding.predefinedXML;
            }
            else {
                if (this.copyNamespacesMode != 1 && this.nesting != 2) {
                    int i = 2;
                    while (true) {
                        while (i != this.nesting) {
                            if (this.workStack[i + 1] != null) {
                                final NamespaceBinding inherited = (NamespaceBinding)this.workStack[i];
                                if (inherited == null) {
                                    this.namespaceBindings = ((type instanceof XName) ? ((XName)type).getNamespaceNodes() : NamespaceBinding.predefinedXML);
                                    return;
                                }
                                if (this.copyNamespacesMode == 2) {
                                    this.namespaceBindings = inherited;
                                    return;
                                }
                                if (type instanceof XName) {
                                    final NamespaceBinding preserved = ((XName)type).getNamespaceNodes();
                                    final NamespaceBinding join = NamespaceBinding.commonAncestor(inherited, preserved);
                                    if (join == inherited) {
                                        this.namespaceBindings = preserved;
                                    }
                                    else {
                                        this.namespaceBindings = this.mergeHelper(inherited, preserved);
                                    }
                                    return;
                                }
                                this.namespaceBindings = inherited;
                                return;
                            }
                            else {
                                i += 2;
                            }
                        }
                        final NamespaceBinding inherited = null;
                        continue;
                    }
                }
                this.namespaceBindings = ((type instanceof XName) ? ((XName)type).getNamespaceNodes() : NamespaceBinding.predefinedXML);
            }
        }
    }
    
    private NamespaceBinding mergeHelper(NamespaceBinding list, final NamespaceBinding node) {
        if (node == NamespaceBinding.predefinedXML) {
            return list;
        }
        list = this.mergeHelper(list, node.next);
        final String uri = node.uri;
        if (list == null) {
            if (uri == null) {
                return list;
            }
            list = NamespaceBinding.predefinedXML;
        }
        final String prefix = node.prefix;
        final String found = list.resolve(prefix);
        if (found == null) {
            if (uri != null) {
                return this.findNamespaceBinding(prefix, uri, list);
            }
        }
        else if (!found.equals(uri)) {
            return this.findNamespaceBinding(prefix, uri, list);
        }
        return list;
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
    public void startAttribute(final Object attrType) {
        this.previous = 0;
        final Symbol sym = (Symbol)attrType;
        final String local = sym.getLocalPart();
        this.attrLocalName = local;
        this.attrPrefix = sym.getPrefix();
        final String uri = sym.getNamespaceURI();
        if (uri == "http://www.w3.org/2000/xmlns/" || (uri == "" && local == "xmlns")) {
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
            }
            else {
                this.tlist.startAttribute(0);
            }
        }
    }
    
    public void emitStartAttribute(final char[] data, final int start, final int count) {
        if (this.attrLocalName != null) {
            this.endAttribute();
        }
        if (!this.startAttributeCommon()) {
            return;
        }
        final MappingInfo info = this.lookupTag(data, start, count);
        this.workStack[this.nesting + this.attrCount - 1] = info;
        final String prefix = info.prefix;
        final String local = info.local;
        this.attrLocalName = local;
        if ((this.attrPrefix = prefix) != null) {
            if (prefix == "xmlns") {
                this.currentNamespacePrefix = local;
            }
        }
        else if (local == "xmlns" && prefix == null) {
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
    
    public void emitEndElement(final char[] data, final int start, final int length) {
        if (this.attrLocalName != null) {
            this.error('e', "unclosed attribute");
            this.endAttribute();
        }
        if (!this.inElement()) {
            this.error('e', "unmatched end element");
            return;
        }
        if (data != null) {
            final MappingInfo info = this.lookupTag(data, start, length);
            final Object old = this.workStack[this.nesting - 1];
            if (old instanceof MappingInfo && !this.mismatchReported) {
                final MappingInfo mold = (MappingInfo)old;
                if (info.local != mold.local || info.prefix != mold.prefix) {
                    final StringBuffer sbuf = new StringBuffer("</");
                    sbuf.append(data, start, length);
                    sbuf.append("> matching <");
                    final String oldPrefix = mold.prefix;
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
        }
        else if (this.stringizingElementNesting == this.nesting) {
            this.stringizingElementNesting = -1;
            this.previous = 2;
        }
    }
    
    public void emitEntityReference(final char[] name, final int start, final int length) {
        final char c0 = name[start];
        char ch = '?';
        if (length == 2 && name[start + 1] == 't') {
            if (c0 == 'l') {
                ch = '<';
            }
            else if (c0 == 'g') {
                ch = '>';
            }
        }
        else if (length == 3) {
            if (c0 == 'a' && name[start + 1] == 'm' && name[start + 2] == 'p') {
                ch = '&';
            }
        }
        else if (length == 4) {
            final char c2 = name[start + 1];
            final char c3 = name[start + 2];
            final char c4 = name[start + 3];
            if (c0 == 'q' && c2 == 'u' && c3 == 'o' && c4 == 't') {
                ch = '\"';
            }
            else if (c0 == 'a' && c2 == 'p' && c3 == 'o' && c4 == 's') {
                ch = '\'';
            }
        }
        this.write(ch);
    }
    
    public void emitCharacterReference(final int value, final char[] name, final int start, final int length) {
        if (value >= 65536) {
            Char.print(value, this);
        }
        else {
            this.write(value);
        }
    }
    
    protected void checkValidComment(final char[] chars, final int offset, final int length) {
        int i = length;
        boolean sawHyphen = true;
        while (--i >= 0) {
            final boolean curHyphen = chars[offset + i] == '-';
            if (sawHyphen && curHyphen) {
                this.error('e', "consecutive or final hyphen in XML comment");
                break;
            }
            sawHyphen = curHyphen;
        }
    }
    
    @Override
    public void writeComment(final char[] chars, final int start, final int length) {
        this.checkValidComment(chars, start, length);
        this.commentFromParser(chars, start, length);
    }
    
    public void commentFromParser(final char[] chars, final int start, final int length) {
        if (this.stringizingLevel == 0) {
            this.closeStartTag();
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).writeComment(chars, start, length);
            }
        }
        else if (this.stringizingElementNesting < 0) {
            this.base.write(chars, start, length);
        }
    }
    
    @Override
    public void writeProcessingInstruction(String target, final char[] content, final int offset, final int length) {
        target = TextUtils.replaceWhitespace(target, true);
        int i = offset + length;
        while (--i >= offset) {
            char ch = content[i];
            while (ch == '>' && --i >= offset) {
                ch = content[i];
                if (ch == '?') {
                    this.error('e', "'?>' is not allowed in a processing-instruction");
                    break;
                }
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
    
    void processingInstructionCommon(final String target, final char[] content, final int offset, final int length) {
        if (this.stringizingLevel == 0) {
            this.closeStartTag();
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).writeProcessingInstruction(target, content, offset, length);
            }
        }
        else if (this.stringizingElementNesting < 0) {
            this.base.write(content, offset, length);
        }
    }
    
    public void processingInstructionFromParser(final char[] buffer, final int tstart, final int tlength, final int dstart, final int dlength) {
        if (tlength == 3 && !this.inElement() && buffer[tstart] == 'x' && buffer[tstart + 1] == 'm' && buffer[tstart + 2] == 'l') {
            return;
        }
        final String target = new String(buffer, tstart, tlength);
        this.processingInstructionCommon(target, buffer, dstart, dlength);
    }
    
    @Override
    public void startDocument() {
        this.closeStartTag();
        if (this.stringizingLevel > 0) {
            this.writeJoiner();
        }
        else {
            if (this.nesting == 0) {
                this.base.startDocument();
            }
            else {
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
        }
        else {
            this.writeJoiner();
        }
    }
    
    public void emitDoctypeDecl(final char[] buffer, final int target, final int tlength, final int data, final int dlength) {
    }
    
    @Override
    public void beginEntity(final Object baseUri) {
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
    public XMLFilter append(final char c) {
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
    public XMLFilter append(CharSequence csq, final int start, final int end) {
        if (csq == null) {
            csq = "null";
        }
        this.write(csq, start, end - start);
        return this;
    }
    
    MappingInfo lookupTag(final Symbol qname) {
        final String local = qname.getLocalPart();
        String prefix = qname.getPrefix();
        if (prefix == "") {
            prefix = null;
        }
        final String uri = qname.getNamespaceURI();
        final int hash = MappingInfo.hash(prefix, local);
        final int index = hash & this.mappingTableMask;
        MappingInfo info;
        MappingInfo first;
        for (first = (info = this.mappingTable[index]); info != null; info = info.nextInBucket) {
            if (qname == info.qname) {
                return info;
            }
            if (local == info.local && info.qname == null && (uri == info.uri || info.uri == null) && prefix == info.prefix) {
                info.uri = uri;
                info.qname = qname;
                return info;
            }
        }
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
    
    MappingInfo lookupTag(final char[] data, final int start, final int length) {
        int hash = 0;
        int prefixHash = 0;
        int colon = -1;
        for (int i = 0; i < length; ++i) {
            final char ch = data[start + i];
            if (ch == ':' && colon < 0) {
                colon = i;
                prefixHash = hash;
                hash = 0;
            }
            else {
                hash = 31 * hash + ch;
            }
        }
        hash ^= prefixHash;
        final int index = hash & this.mappingTableMask;
        MappingInfo info;
        MappingInfo first;
        for (first = (info = this.mappingTable[index]); info != null; info = info.nextInBucket) {
            if (hash == info.tagHash && info.match(data, start, length)) {
                return info;
            }
        }
        info = new MappingInfo();
        info.tagHash = hash;
        if (colon >= 0) {
            info.prefix = new String(data, start, colon).intern();
            ++colon;
            final int lstart = start + colon;
            info.local = new String(data, lstart, length - colon).intern();
        }
        else {
            info.prefix = null;
            info.local = new String(data, start, length).intern();
        }
        info.nextInBucket = first;
        this.mappingTable[index] = first;
        return info;
    }
    
    private void ensureSpaceInWorkStack(final int oldSize) {
        if (this.workStack == null) {
            this.workStack = new Object[20];
        }
        else if (oldSize >= this.workStack.length) {
            final Object[] tmpn = new Object[2 * this.workStack.length];
            System.arraycopy(this.workStack, 0, tmpn, 0, oldSize);
            this.workStack = tmpn;
        }
    }
    
    private void ensureSpaceInStartIndexes(final int oldSize) {
        if (this.startIndexes == null) {
            this.startIndexes = new int[20];
        }
        else if (oldSize >= this.startIndexes.length) {
            final int[] tmpn = new int[2 * this.startIndexes.length];
            System.arraycopy(this.startIndexes, 0, tmpn, 0, oldSize);
            this.startIndexes = tmpn;
        }
    }
    
    public static String duplicateAttributeMessage(final Symbol attrSymbol, final Object elementName) {
        final StringBuffer sbuf = new StringBuffer("duplicate attribute: ");
        final String uri = attrSymbol.getNamespaceURI();
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
    
    public void error(final char severity, final String message) {
        if (this.messages == null) {
            throw new RuntimeException(message);
        }
        if (this.locator != null) {
            this.messages.error(severity, this.locator, message);
        }
        else {
            this.messages.error(severity, message);
        }
    }
    
    @Override
    public boolean ignoring() {
        return this.ignoringLevel > 0;
    }
    
    @Override
    public void setDocumentLocator(final Locator locator) {
        if (locator instanceof SourceLocator) {
            this.locator = (SourceLocator)locator;
        }
    }
    
    @Override
    public void startElement(final String namespaceURI, final String localName, final String qName, final Attributes atts) {
        this.startElement(Symbol.make(namespaceURI, localName));
        for (int numAttributes = atts.getLength(), i = 0; i < numAttributes; ++i) {
            this.startAttribute(Symbol.make(atts.getURI(i), atts.getLocalName(i)));
            this.write(atts.getValue(i));
            this.endAttribute();
        }
    }
    
    @Override
    public void endElement(final String namespaceURI, final String localName, final String qName) {
        this.endElement();
    }
    
    @Override
    public void startElement(String name, final AttributeList atts) {
        name = name.intern();
        this.startElement(name);
        for (int attrLength = atts.getLength(), i = 0; i < attrLength; ++i) {
            name = atts.getName(i);
            name = name.intern();
            final String type = atts.getType(i);
            final String value = atts.getValue(i);
            this.startAttribute(name);
            this.write(value);
            this.endAttribute();
        }
    }
    
    @Override
    public void endElement(final String name) throws SAXException {
        this.endElement();
    }
    
    @Override
    public void characters(final char[] ch, final int start, final int length) throws SAXException {
        this.write(ch, start, length);
    }
    
    @Override
    public void ignorableWhitespace(final char[] ch, final int start, final int length) throws SAXException {
        this.write(ch, start, length);
    }
    
    @Override
    public void processingInstruction(final String target, final String data) {
        final char[] chars = data.toCharArray();
        this.processingInstructionCommon(target, chars, 0, chars.length);
    }
    
    @Override
    public void startPrefixMapping(final String prefix, final String uri) {
        this.namespaceBindings = this.findNamespaceBinding(prefix.intern(), uri.intern(), this.namespaceBindings);
    }
    
    @Override
    public void endPrefixMapping(final String prefix) {
        this.namespaceBindings = this.namespaceBindings.getNext();
    }
    
    @Override
    public void skippedEntity(final String name) {
    }
    
    @Override
    public String getPublicId() {
        return null;
    }
    
    @Override
    public String getSystemId() {
        return (this.in == null) ? null : this.in.getName();
    }
    
    @Override
    public String getFileName() {
        return (this.in == null) ? null : this.in.getName();
    }
    
    @Override
    public int getLineNumber() {
        if (this.in == null) {
            return -1;
        }
        final int line = this.in.getLineNumber();
        return (line < 0) ? -1 : (line + 1);
    }
    
    @Override
    public int getColumnNumber() {
        final int col;
        return (this.in != null && (col = this.in.getColumnNumber()) > 0) ? col : -1;
    }
    
    @Override
    public boolean isStableSourceLocation() {
        return false;
    }
}
