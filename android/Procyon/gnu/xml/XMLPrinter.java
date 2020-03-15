// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xml;

import gnu.lists.AbstractSequence;
import gnu.text.Char;
import gnu.lists.UnescapedData;
import gnu.expr.Keyword;
import gnu.lists.Consumable;
import gnu.lists.SeqPosition;
import gnu.math.DFloNum;
import java.math.BigDecimal;
import gnu.math.RealNum;
import gnu.mapping.Symbol;
import gnu.kawa.xml.XmlNamespace;
import java.io.StringWriter;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import gnu.lists.Consumer;
import java.io.Writer;
import gnu.mapping.ThreadLocation;
import gnu.lists.XConsumer;
import gnu.lists.PositionConsumer;
import gnu.lists.PrintConsumer;

public class XMLPrinter extends PrintConsumer implements PositionConsumer, XConsumer
{
    protected int printIndent;
    public boolean indentAttributes;
    boolean printXMLdecl;
    boolean inDocument;
    boolean inAttribute;
    boolean inStartTag;
    int inComment;
    boolean needXMLdecl;
    boolean canonicalize;
    public boolean canonicalizeCDATA;
    public int useEmptyElementTag;
    public boolean escapeText;
    public boolean escapeNonAscii;
    boolean isHtml;
    boolean isHtmlOrXhtml;
    boolean undeclareNamespaces;
    Object style;
    public boolean extended;
    public static final ThreadLocation doctypeSystem;
    public static final ThreadLocation doctypePublic;
    public static final ThreadLocation<String> indentLoc;
    NamespaceBinding namespaceBindings;
    NamespaceBinding[] namespaceSaveStack;
    Object[] elementNameStack;
    int elementNesting;
    private static final int WORD = -2;
    private static final int ELEMENT_START = -3;
    private static final int ELEMENT_END = -4;
    private static final int COMMENT = -5;
    private static final int KEYWORD = -6;
    private static final int PROC_INST = -7;
    int prev;
    char savedHighSurrogate;
    static final String HtmlEmptyTags = "/area/base/basefont/br/col/command/embed/frame/hr/img/input/isindex/keygen/link/meta/para/param/source/track/wbr/";
    
    public void setPrintXMLdecl(final boolean value) {
        this.printXMLdecl = value;
    }
    
    public XMLPrinter(final Writer out, final boolean autoFlush) {
        super(out, autoFlush);
        this.printIndent = -1;
        this.printXMLdecl = false;
        this.inAttribute = false;
        this.inStartTag = false;
        this.needXMLdecl = false;
        this.canonicalize = true;
        this.useEmptyElementTag = 2;
        this.escapeText = true;
        this.escapeNonAscii = true;
        this.isHtml = false;
        this.isHtmlOrXhtml = false;
        this.undeclareNamespaces = false;
        this.extended = true;
        this.namespaceBindings = NamespaceBinding.predefinedXML;
        this.namespaceSaveStack = new NamespaceBinding[20];
        this.elementNameStack = new Object[20];
        this.prev = 32;
    }
    
    public XMLPrinter(final Writer out) {
        super(out);
        this.printIndent = -1;
        this.printXMLdecl = false;
        this.inAttribute = false;
        this.inStartTag = false;
        this.needXMLdecl = false;
        this.canonicalize = true;
        this.useEmptyElementTag = 2;
        this.escapeText = true;
        this.escapeNonAscii = true;
        this.isHtml = false;
        this.isHtmlOrXhtml = false;
        this.undeclareNamespaces = false;
        this.extended = true;
        this.namespaceBindings = NamespaceBinding.predefinedXML;
        this.namespaceSaveStack = new NamespaceBinding[20];
        this.elementNameStack = new Object[20];
        this.prev = 32;
    }
    
    public XMLPrinter(final Consumer out) {
        super(out, false);
        this.printIndent = -1;
        this.printXMLdecl = false;
        this.inAttribute = false;
        this.inStartTag = false;
        this.needXMLdecl = false;
        this.canonicalize = true;
        this.useEmptyElementTag = 2;
        this.escapeText = true;
        this.escapeNonAscii = true;
        this.isHtml = false;
        this.isHtmlOrXhtml = false;
        this.undeclareNamespaces = false;
        this.extended = true;
        this.namespaceBindings = NamespaceBinding.predefinedXML;
        this.namespaceSaveStack = new NamespaceBinding[20];
        this.elementNameStack = new Object[20];
        this.prev = 32;
    }
    
    public XMLPrinter(final PrintConsumer out) {
        super((Writer)out, false);
        this.printIndent = -1;
        this.printXMLdecl = false;
        this.inAttribute = false;
        this.inStartTag = false;
        this.needXMLdecl = false;
        this.canonicalize = true;
        this.useEmptyElementTag = 2;
        this.escapeText = true;
        this.escapeNonAscii = true;
        this.isHtml = false;
        this.isHtmlOrXhtml = false;
        this.undeclareNamespaces = false;
        this.extended = true;
        this.namespaceBindings = NamespaceBinding.predefinedXML;
        this.namespaceSaveStack = new NamespaceBinding[20];
        this.elementNameStack = new Object[20];
        this.prev = 32;
    }
    
    public XMLPrinter(final OutputStream out) {
        super(new OutputStreamWriter(out));
        this.printIndent = -1;
        this.printXMLdecl = false;
        this.inAttribute = false;
        this.inStartTag = false;
        this.needXMLdecl = false;
        this.canonicalize = true;
        this.useEmptyElementTag = 2;
        this.escapeText = true;
        this.escapeNonAscii = true;
        this.isHtml = false;
        this.isHtmlOrXhtml = false;
        this.undeclareNamespaces = false;
        this.extended = true;
        this.namespaceBindings = NamespaceBinding.predefinedXML;
        this.namespaceSaveStack = new NamespaceBinding[20];
        this.elementNameStack = new Object[20];
        this.prev = 32;
    }
    
    public static XMLPrinter make(final Consumer out, final Object style) {
        final XMLPrinter xout = new XMLPrinter(out);
        xout.setStyle(style);
        return xout;
    }
    
    public static String toString(final Object value) {
        final StringWriter stringWriter = new StringWriter();
        new XMLPrinter(stringWriter).writeObject(value);
        return stringWriter.toString();
    }
    
    public void setStyle(final Object style) {
        this.style = style;
        this.useEmptyElementTag = (this.canonicalize ? 0 : 1);
        if ("html".equals(style)) {
            this.isHtml = true;
            this.isHtmlOrXhtml = true;
            this.useEmptyElementTag = 2;
            if (this.namespaceBindings == NamespaceBinding.predefinedXML) {
                this.namespaceBindings = XmlNamespace.HTML_BINDINGS;
            }
        }
        else if (this.namespaceBindings == XmlNamespace.HTML_BINDINGS) {
            this.namespaceBindings = NamespaceBinding.predefinedXML;
        }
        if ("xhtml".equals(style)) {
            this.isHtmlOrXhtml = true;
            this.useEmptyElementTag = 2;
        }
        if ("plain".equals(style)) {
            this.escapeText = false;
        }
    }
    
    public void setEscapeText(final boolean v) {
        this.escapeText = v;
    }
    
    public void setEscapeNonAscii(final boolean v) {
        this.escapeNonAscii = v;
    }
    
    public void setCanonicalizeCDATA(final boolean v) {
        this.canonicalizeCDATA = v;
    }
    
    public void setUseEmptyElementTag(final int v) {
        this.useEmptyElementTag = v;
    }
    
    public void setExtended(final boolean v) {
        this.extended = v;
    }
    
    public void setIndent(final int v) {
        this.printIndent = v;
    }
    
    boolean mustHexEscape(final int v) {
        return (v >= 127 && (v <= 159 || this.escapeNonAscii)) || v == 8232 || (v < 32 && (this.inAttribute || (v != 9 && v != 10)));
    }
    
    @Override
    public void write(final int v) {
        this.closeTag();
        if (this.printIndent >= 0 && (v == 13 || v == 10)) {
            if (v != 10 || this.prev != 13) {
                this.writeBreak(82);
            }
            if (this.inComment > 0) {
                this.inComment = 1;
            }
            return;
        }
        if (!this.escapeText) {
            this.writeRaw(v);
            this.prev = v;
        }
        else if (this.inComment > 0) {
            if (v == 45) {
                if (this.inComment == 1) {
                    this.inComment = 2;
                }
                else {
                    this.writeRaw(32);
                }
            }
            else {
                this.inComment = 1;
            }
            this.writeRaw(v);
        }
        else {
            this.prev = 59;
            if (v == 60 && (!this.isHtml || !this.inAttribute)) {
                this.writeRaw("&lt;");
            }
            else if (v == 62) {
                this.writeRaw("&gt;");
            }
            else if (v == 38) {
                this.writeRaw("&amp;");
            }
            else if (v == 34 && this.inAttribute) {
                this.writeRaw("&quot;");
            }
            else if (this.mustHexEscape(v)) {
                int i;
                if ((i = v) >= 55296) {
                    if (v < 56320) {
                        this.savedHighSurrogate = (char)v;
                        return;
                    }
                    if (v < 57344) {
                        i = (this.savedHighSurrogate - '\ud800') * 1024 + (i - 56320) + 65536;
                        this.savedHighSurrogate = '\0';
                    }
                }
                this.writeRaw("&#x" + Integer.toHexString(i).toUpperCase() + ";");
            }
            else {
                this.writeRaw(v);
                this.prev = v;
            }
        }
    }
    
    private void startWord() {
        this.closeTag();
        this.writeWordStart();
    }
    
    @Override
    public void writeBoolean(final boolean v) {
        this.startWord();
        super.print(v);
        this.writeWordEnd();
    }
    
    @Override
    protected void startNumber() {
        this.startWord();
    }
    
    @Override
    protected void endNumber() {
        this.writeWordEnd();
    }
    
    public void closeTag() {
        if (this.inStartTag && !this.inAttribute) {
            if (this.printIndent >= 0 && this.indentAttributes) {
                this.endLogicalBlock("");
            }
            this.writeRaw(">");
            this.inStartTag = false;
            this.prev = -3;
        }
        else if (this.needXMLdecl) {
            this.writeRaw("<?xml version=\"1.0\"?>\n");
            if (this.printIndent >= 0) {
                this.startLogicalBlock("", "", 2);
            }
            this.needXMLdecl = false;
            this.prev = 62;
        }
    }
    
    void setIndentMode() {
        final Object xmlIndent = XMLPrinter.indentLoc.get(null);
        final String indent = (xmlIndent == null) ? null : xmlIndent.toString();
        if (indent == null) {
            this.printIndent = -1;
        }
        else if (indent.equals("pretty")) {
            this.printIndent = 0;
        }
        else if (indent.equals("always") || indent.equals("yes")) {
            this.printIndent = 1;
        }
        else {
            this.printIndent = -1;
        }
    }
    
    @Override
    public void startDocument() {
        if (this.printXMLdecl) {
            this.needXMLdecl = true;
        }
        this.setIndentMode();
        this.inDocument = true;
        if (this.printIndent >= 0 && !this.needXMLdecl) {
            this.startLogicalBlock("", "", 2);
        }
    }
    
    @Override
    public void endDocument() {
        this.inDocument = false;
        if (this.printIndent >= 0) {
            this.endLogicalBlock("");
        }
        this.freshLine();
    }
    
    @Override
    public void beginEntity(final Object base) {
    }
    
    @Override
    public void endEntity() {
    }
    
    protected void writeQName(final Object name) {
        if (name instanceof Symbol) {
            final Symbol sname = (Symbol)name;
            final String prefix = sname.getPrefix();
            if (prefix != null && prefix.length() > 0) {
                this.writeRaw(prefix);
                this.writeRaw(58);
            }
            this.writeRaw(sname.getLocalPart());
        }
        else {
            this.writeRaw((name == null) ? "{null name}" : ((String)name));
        }
    }
    
    public void writeDoctypeIfDefined(final String tagname) {
        final Object systemIdentifier = XMLPrinter.doctypeSystem.get(null);
        if (systemIdentifier != null) {
            final String systemId = systemIdentifier.toString();
            if (systemId.length() > 0) {
                final Object publicIdentifier = XMLPrinter.doctypePublic.get(null);
                final String publicId = (publicIdentifier == null) ? null : publicIdentifier.toString();
                this.writeDoctype(tagname, systemId, publicId);
            }
        }
    }
    
    public void writeDoctype(final String tagname, final String systemId, final String publicId) {
        this.writeRaw("<!DOCTYPE ");
        this.writeRaw(tagname);
        if (publicId != null && publicId.length() > 0) {
            this.writeRaw(" PUBLIC \"");
            this.writeRaw(publicId);
            this.writeRaw("\" \"");
        }
        else {
            this.writeRaw(" SYSTEM \"");
        }
        this.writeRaw(systemId);
        this.writeRaw("\">");
        this.println();
    }
    
    @Override
    public void startElement(final Object type) {
        this.closeTag();
        if (this.elementNesting == 0) {
            if (!this.inDocument) {
                this.setIndentMode();
            }
            if (this.prev == -7) {
                this.write(10);
            }
            if (type != null) {
                this.writeDoctypeIfDefined(type.toString());
            }
        }
        if (this.printIndent >= 0) {
            if (this.prev == -3 || this.prev == -4 || this.prev == -5) {
                this.writeBreak((this.printIndent > 0) ? 82 : 78);
            }
            this.startLogicalBlock("", "", 2);
        }
        this.writeRaw(60);
        this.writeQName(type);
        if (this.printIndent >= 0 && this.indentAttributes) {
            this.startLogicalBlock("", "", 2);
        }
        this.elementNameStack[this.elementNesting] = type;
        NamespaceBinding elementBindings = null;
        this.namespaceSaveStack[this.elementNesting++] = this.namespaceBindings;
        if (type instanceof XName) {
            elementBindings = ((XName)type).namespaceNodes;
            final NamespaceBinding join = NamespaceBinding.commonAncestor(elementBindings, this.namespaceBindings);
            int numBindings = (elementBindings == null) ? 0 : elementBindings.count(join);
            final NamespaceBinding[] sortedBindings = new NamespaceBinding[numBindings];
            int i = 0;
            final boolean sortNamespaces = this.canonicalize;
            NamespaceBinding ns = elementBindings;
        Label_0364_Outer:
            while (ns != join) {
                int j = i;
                final boolean skip = false;
                final String uri = ns.getUri();
                final String prefix = ns.getPrefix();
                while (true) {
                    while (--j >= 0) {
                        final NamespaceBinding ns_j = sortedBindings[j];
                        final String prefix_j = ns_j.getPrefix();
                        if (prefix == prefix_j) {
                            ns = ns.next;
                            continue Label_0364_Outer;
                        }
                        if (!sortNamespaces) {
                            continue Label_0364_Outer;
                        }
                        if (prefix == null) {
                            break;
                        }
                        if (prefix_j != null && prefix.compareTo(prefix_j) <= 0) {
                            break;
                        }
                        sortedBindings[j + 1] = ns_j;
                    }
                    if (sortNamespaces) {
                        ++j;
                    }
                    else {
                        j = i;
                    }
                    sortedBindings[j] = ns;
                    ++i;
                    continue;
                }
            }
            numBindings = (i = i);
            while (--i >= 0) {
                ns = sortedBindings[i];
                final String prefix2 = ns.prefix;
                final String uri2 = ns.uri;
                if (uri2 == this.namespaceBindings.resolve(prefix2)) {
                    continue;
                }
                if (uri2 == null && prefix2 != null && !this.undeclareNamespaces) {
                    continue;
                }
                this.writeRaw(32);
                if (prefix2 == null) {
                    this.writeRaw("xmlns");
                }
                else {
                    this.writeRaw("xmlns:");
                    this.writeRaw(prefix2);
                }
                this.writeRaw("=\"");
                this.inAttribute = true;
                if (uri2 != null) {
                    this.write(uri2);
                }
                this.inAttribute = false;
                this.writeRaw(34);
            }
            if (this.undeclareNamespaces) {
                for (ns = this.namespaceBindings; ns != join; ns = ns.next) {
                    final String prefix2 = ns.prefix;
                    if (ns.uri != null && elementBindings.resolve(prefix2) == null) {
                        this.writeRaw(32);
                        if (prefix2 == null) {
                            this.writeRaw("xmlns");
                        }
                        else {
                            this.writeRaw("xmlns:");
                            this.writeRaw(prefix2);
                        }
                        this.writeRaw("=\"\"");
                    }
                }
            }
            this.namespaceBindings = elementBindings;
        }
        if (this.elementNesting >= this.namespaceSaveStack.length) {
            final NamespaceBinding[] nstmp = new NamespaceBinding[2 * this.elementNesting];
            System.arraycopy(this.namespaceSaveStack, 0, nstmp, 0, this.elementNesting);
            this.namespaceSaveStack = nstmp;
            final Object[] nmtmp = new Object[2 * this.elementNesting];
            System.arraycopy(this.elementNameStack, 0, nmtmp, 0, this.elementNesting);
            this.elementNameStack = nmtmp;
        }
        this.inStartTag = true;
        if (this.isHtml) {
            final String typeName = this.getHtmlTag(type);
            if ("script".equals(typeName) || "style".equals(typeName)) {
                this.escapeText = false;
            }
        }
    }
    
    public static boolean isHtmlEmptyElementTag(final String name) {
        final int index = "/area/base/basefont/br/col/command/embed/frame/hr/img/input/isindex/keygen/link/meta/para/param/source/track/wbr/".indexOf(name);
        return index > 0 && "/area/base/basefont/br/col/command/embed/frame/hr/img/input/isindex/keygen/link/meta/para/param/source/track/wbr/".charAt(index - 1) == '/' && "/area/base/basefont/br/col/command/embed/frame/hr/img/input/isindex/keygen/link/meta/para/param/source/track/wbr/".charAt(index + name.length()) == '/';
    }
    
    protected String getHtmlTag(final Object type) {
        if (type instanceof Symbol) {
            final Symbol sym = (Symbol)type;
            final String uri = sym.getNamespaceURI();
            if (uri == "http://www.w3.org/1999/xhtml" || (this.isHtmlOrXhtml && uri == "")) {
                return sym.getLocalPart();
            }
        }
        else if (this.isHtmlOrXhtml) {
            return type.toString();
        }
        return null;
    }
    
    @Override
    public void endElement() {
        if (this.useEmptyElementTag == 0) {
            this.closeTag();
        }
        final Object type = this.elementNameStack[this.elementNesting - 1];
        final String typeName = this.getHtmlTag(type);
        if (this.inStartTag) {
            if (this.printIndent >= 0 && this.indentAttributes) {
                this.endLogicalBlock("");
            }
            String end = null;
            final boolean isEmpty = typeName != null && isHtmlEmptyElementTag(typeName);
            if ((this.useEmptyElementTag == 0 || (typeName != null && !isEmpty)) && type instanceof Symbol) {
                final Symbol sym = (Symbol)type;
                final String prefix = sym.getPrefix();
                final String uri = sym.getNamespaceURI();
                final String local = sym.getLocalName();
                if (prefix != "") {
                    end = "></" + prefix + ":" + local + ">";
                }
                else if (uri == "" || uri == null || uri == this.namespaceBindings.resolve(null)) {
                    end = "></" + local + ">";
                }
            }
            if (end == null) {
                end = ((isEmpty && this.isHtml) ? ">" : ((this.useEmptyElementTag == 2) ? " />" : "/>"));
            }
            this.writeRaw(end);
            this.inStartTag = false;
        }
        else {
            if (this.printIndent >= 0) {
                this.setIndentation(0, false);
                if (this.prev == -4) {
                    this.writeBreak((this.printIndent > 0) ? 82 : 78);
                }
            }
            this.writeRaw("</");
            this.writeQName(type);
            this.writeRaw(">");
        }
        if (this.printIndent >= 0) {
            this.endLogicalBlock("");
        }
        this.prev = -4;
        if (this.isHtml && typeName != null && !this.escapeText && ("script".equals(typeName) || "style".equals(typeName))) {
            this.escapeText = true;
        }
        final NamespaceBinding[] namespaceSaveStack = this.namespaceSaveStack;
        final int elementNesting = this.elementNesting - 1;
        this.elementNesting = elementNesting;
        this.namespaceBindings = namespaceSaveStack[elementNesting];
        this.namespaceSaveStack[this.elementNesting] = null;
        this.elementNameStack[this.elementNesting] = null;
    }
    
    @Override
    public void startAttribute(final Object attrType) {
        if (!this.inStartTag && !this.extended) {
            this.error("attribute not in element", "SENR0001");
        }
        if (this.inAttribute) {
            this.writeRaw(34);
        }
        this.inAttribute = true;
        this.writeRaw(32);
        if (this.printIndent >= 0) {
            this.writeBreakFill();
        }
        this.writeRaw((attrType == null) ? "{null name}" : attrType.toString());
        this.writeRaw("=\"");
        this.prev = 32;
    }
    
    @Override
    public void endAttribute() {
        if (this.inAttribute) {
            if (this.prev != -6) {
                this.writeRaw(34);
                this.inAttribute = false;
            }
            this.prev = 32;
        }
    }
    
    @Override
    public void writeDouble(final double d) {
        this.startWord();
        this.writeRaw(formatDouble(d));
    }
    
    @Override
    public void writeFloat(final float f) {
        this.startWord();
        this.writeRaw(formatFloat(f));
    }
    
    public static String formatDouble(final double d) {
        if (Double.isNaN(d)) {
            return "NaN";
        }
        final boolean neg = d < 0.0;
        if (Double.isInfinite(d)) {
            return neg ? "-INF" : "INF";
        }
        final double dabs = neg ? (-d) : d;
        final String dstr = Double.toString(d);
        if ((dabs >= 1000000.0 || dabs < 1.0E-6) && dabs != 0.0) {
            return RealNum.toStringScientific(dstr);
        }
        return formatDecimal(RealNum.toStringDecimal(dstr));
    }
    
    public static String formatFloat(final float f) {
        if (Float.isNaN(f)) {
            return "NaN";
        }
        final boolean neg = f < 0.0f;
        if (Float.isInfinite(f)) {
            return neg ? "-INF" : "INF";
        }
        final float fabs = neg ? (-f) : f;
        final String fstr = Float.toString(f);
        if ((fabs >= 1000000.0f || fabs < 1.0E-6) && fabs != 0.0) {
            return RealNum.toStringScientific(fstr);
        }
        return formatDecimal(RealNum.toStringDecimal(fstr));
    }
    
    public static String formatDecimal(final BigDecimal dec) {
        return formatDecimal(dec.toPlainString());
    }
    
    static String formatDecimal(final String str) {
        final int dot = str.indexOf(46);
        if (dot >= 0) {
            int pos;
            final int len = pos = str.length();
            char ch;
            do {
                ch = str.charAt(--pos);
            } while (ch == '0');
            if (ch != '.') {
                ++pos;
            }
            return (pos == len) ? str : str.substring(0, pos);
        }
        return str;
    }
    
    @Override
    public void print(Object v) {
        if (v instanceof BigDecimal) {
            v = formatDecimal((BigDecimal)v);
        }
        else if (v instanceof Double || v instanceof DFloNum) {
            v = formatDouble(((Number)v).doubleValue());
        }
        else if (v instanceof Float) {
            v = formatFloat((float)v);
        }
        this.write((v == null) ? "(null)" : v.toString());
    }
    
    @Override
    public void writeObject(final Object v) {
        if (v instanceof SeqPosition) {
            this.clearWordEnd();
            final SeqPosition pos = (SeqPosition)v;
            pos.sequence.consumeNext(pos.ipos, this);
            if (pos.sequence instanceof NodeTree) {
                this.prev = 45;
            }
            return;
        }
        if (v instanceof Consumable) {
            ((Consumable)v).consume(this);
            return;
        }
        if (v instanceof Keyword) {
            this.startAttribute(((Keyword)v).getName());
            this.prev = -6;
            return;
        }
        this.closeTag();
        if (v instanceof UnescapedData) {
            this.clearWordEnd();
            this.writeRaw(((UnescapedData)v).getData());
            this.prev = 45;
        }
        else if (v instanceof Char) {
            Char.print(((Char)v).intValue(), this);
        }
        else {
            this.startWord();
            this.prev = 32;
            this.print(v);
            this.writeWordEnd();
            this.prev = -2;
        }
    }
    
    @Override
    public boolean ignoring() {
        return false;
    }
    
    @Override
    public void write(final String str, int start, final int length) {
        if (length > 0) {
            this.closeTag();
            final int limit = start + length;
            int count = 0;
            while (start < limit) {
                final char c = str.charAt(start++);
                Label_0108: {
                    if (!this.mustHexEscape(c)) {
                        if (this.inComment > 0) {
                            if (c == '-') {
                                break Label_0108;
                            }
                            if (this.inComment == 2) {
                                break Label_0108;
                            }
                        }
                        else if (c == '<' || c == '>' || c == '&' || (this.inAttribute && (c == '\"' || c < ' '))) {
                            break Label_0108;
                        }
                        ++count;
                        continue;
                    }
                }
                if (count > 0) {
                    this.writeRaw(str, start - 1 - count, count);
                }
                this.write(c);
                count = 0;
            }
            if (count > 0) {
                this.writeRaw(str, limit - count, count);
            }
        }
        this.prev = 45;
    }
    
    @Override
    public void write(final char[] buf, int off, final int len) {
        if (len > 0) {
            this.closeTag();
            final int limit = off + len;
            int count = 0;
            while (off < limit) {
                final char c = buf[off++];
                Label_0106: {
                    if (!this.mustHexEscape(c)) {
                        if (this.inComment > 0) {
                            if (c == '-') {
                                break Label_0106;
                            }
                            if (this.inComment == 2) {
                                break Label_0106;
                            }
                        }
                        else if (c == '<' || c == '>' || c == '&' || (this.inAttribute && (c == '\"' || c < ' '))) {
                            break Label_0106;
                        }
                        ++count;
                        continue;
                    }
                }
                if (count > 0) {
                    this.writeRaw(buf, off - 1 - count, count);
                }
                this.write(c);
                count = 0;
            }
            if (count > 0) {
                this.writeRaw(buf, limit - count, count);
            }
        }
        this.prev = 45;
    }
    
    @Override
    public void writePosition(final AbstractSequence seq, final int ipos) {
        seq.consumeNext(ipos, this);
    }
    
    public void writeBaseUri(final Object uri) {
    }
    
    public void beginComment() {
        this.closeTag();
        if (this.printIndent >= 0 && (this.prev == -3 || this.prev == -4 || this.prev == -5)) {
            this.writeBreak((this.printIndent > 0) ? 82 : 78);
        }
        this.writeRaw("<!--");
        this.inComment = 1;
    }
    
    public void endComment() {
        this.writeRaw("-->");
        this.prev = -5;
        this.inComment = 0;
    }
    
    public void writeComment(final String chars) {
        this.beginComment();
        this.write(chars);
        this.endComment();
    }
    
    @Override
    public void writeComment(final char[] chars, final int offset, final int length) {
        this.beginComment();
        this.write(chars, offset, length);
        this.endComment();
    }
    
    @Override
    public void writeCDATA(final char[] chars, int offset, int length) {
        if (this.canonicalizeCDATA) {
            this.write(chars, offset, length);
            return;
        }
        this.closeTag();
        this.writeRaw("<![CDATA[");
        for (int limit = offset + length, i = offset; i < limit - 2; ++i) {
            if (chars[i] == ']' && chars[i + 1] == ']' && chars[i + 2] == '>') {
                if (i > offset) {
                    this.writeRaw(chars, offset, i - offset);
                }
                this.writeRaw("]]]><![CDATA[]>");
                offset = i + 3;
                length = limit - offset;
                i += 2;
            }
        }
        this.writeRaw(chars, offset, length);
        this.writeRaw("]]>");
        this.prev = 62;
    }
    
    @Override
    public void writeProcessingInstruction(final String target, final char[] content, final int offset, final int length) {
        if ("xml".equals(target)) {
            this.needXMLdecl = false;
        }
        this.closeTag();
        this.writeRaw("<?");
        this.writeRaw(target);
        this.writeRaw(32);
        this.writeRaw(content, offset, length);
        this.writeRaw("?>");
        this.prev = -7;
    }
    
    @Override
    public void writePosition(final SeqPosition position) {
        position.sequence.consumeNext(position.ipos, this);
    }
    
    public void error(final String msg, final String code) {
        throw new RuntimeException("serialization error: " + msg + " [" + code + ']');
    }
    
    static {
        doctypeSystem = new ThreadLocation("doctype-system");
        doctypePublic = new ThreadLocation("doctype-public");
        indentLoc = new ThreadLocation<String>("xml-indent");
    }
}
