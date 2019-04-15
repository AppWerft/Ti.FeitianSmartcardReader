/*
 * Decompiled with CFR 0.139.
 */
package gnu.xml;

import gnu.expr.Keyword;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.PrintConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.UnescapedData;
import gnu.lists.XConsumer;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.math.DFloNum;
import gnu.math.RealNum;
import gnu.text.Char;
import gnu.xml.NamespaceBinding;
import gnu.xml.NodeTree;
import gnu.xml.XName;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;

public class XMLPrinter
extends PrintConsumer
implements PositionConsumer,
XConsumer {
    protected int printIndent = -1;
    public boolean indentAttributes;
    boolean printXMLdecl = false;
    boolean inDocument;
    boolean inAttribute = false;
    boolean inStartTag = false;
    int inComment;
    boolean needXMLdecl = false;
    boolean canonicalize = true;
    public boolean canonicalizeCDATA;
    public int useEmptyElementTag = 2;
    public boolean escapeText = true;
    public boolean escapeNonAscii = true;
    boolean isHtml = false;
    boolean isHtmlOrXhtml = false;
    boolean undeclareNamespaces = false;
    Object style;
    public boolean extended = true;
    public static final ThreadLocation doctypeSystem = new ThreadLocation("doctype-system");
    public static final ThreadLocation doctypePublic = new ThreadLocation("doctype-public");
    public static final ThreadLocation<String> indentLoc = new ThreadLocation("xml-indent");
    NamespaceBinding namespaceBindings = NamespaceBinding.predefinedXML;
    NamespaceBinding[] namespaceSaveStack = new NamespaceBinding[20];
    Object[] elementNameStack = new Object[20];
    int elementNesting;
    private static final int WORD = -2;
    private static final int ELEMENT_START = -3;
    private static final int ELEMENT_END = -4;
    private static final int COMMENT = -5;
    private static final int KEYWORD = -6;
    private static final int PROC_INST = -7;
    int prev = 32;
    char savedHighSurrogate;
    static final String HtmlEmptyTags = "/area/base/basefont/br/col/command/embed/frame/hr/img/input/isindex/keygen/link/meta/para/param/source/track/wbr/";

    public void setPrintXMLdecl(boolean value) {
        this.printXMLdecl = value;
    }

    public XMLPrinter(Writer out, boolean autoFlush) {
        super(out, autoFlush);
    }

    public XMLPrinter(Writer out) {
        super(out);
    }

    public XMLPrinter(Consumer out) {
        super(out, false);
    }

    public XMLPrinter(PrintConsumer out) {
        super(out, false);
    }

    public XMLPrinter(OutputStream out) {
        super(new OutputStreamWriter(out));
    }

    public static XMLPrinter make(Consumer out, Object style) {
        XMLPrinter xout = new XMLPrinter(out);
        xout.setStyle(style);
        return xout;
    }

    public static String toString(Object value) {
        StringWriter stringWriter = new StringWriter();
        new XMLPrinter(stringWriter).writeObject(value);
        return stringWriter.toString();
    }

    public void setStyle(Object style) {
        this.style = style;
        int n = this.useEmptyElementTag = this.canonicalize ? 0 : 1;
        if ("html".equals(style)) {
            this.isHtml = true;
            this.isHtmlOrXhtml = true;
            this.useEmptyElementTag = 2;
            if (this.namespaceBindings == NamespaceBinding.predefinedXML) {
                this.namespaceBindings = XmlNamespace.HTML_BINDINGS;
            }
        } else if (this.namespaceBindings == XmlNamespace.HTML_BINDINGS) {
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

    public void setEscapeText(boolean v) {
        this.escapeText = v;
    }

    public void setEscapeNonAscii(boolean v) {
        this.escapeNonAscii = v;
    }

    public void setCanonicalizeCDATA(boolean v) {
        this.canonicalizeCDATA = v;
    }

    public void setUseEmptyElementTag(int v) {
        this.useEmptyElementTag = v;
    }

    public void setExtended(boolean v) {
        this.extended = v;
    }

    public void setIndent(int v) {
        this.printIndent = v;
    }

    boolean mustHexEscape(int v) {
        return v >= 127 && (v <= 159 || this.escapeNonAscii) || v == 8232 || v < 32 && (this.inAttribute || v != 9 && v != 10);
    }

    @Override
    public void write(int v) {
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
        } else if (this.inComment > 0) {
            if (v == 45) {
                if (this.inComment == 1) {
                    this.inComment = 2;
                } else {
                    this.writeRaw(32);
                }
            } else {
                this.inComment = 1;
            }
            this.writeRaw(v);
        } else {
            this.prev = 59;
            if (!(v != 60 || this.isHtml && this.inAttribute)) {
                this.writeRaw("&lt;");
            } else if (v == 62) {
                this.writeRaw("&gt;");
            } else if (v == 38) {
                this.writeRaw("&amp;");
            } else if (v == 34 && this.inAttribute) {
                this.writeRaw("&quot;");
            } else if (this.mustHexEscape(v)) {
                int i = v;
                if (v >= 55296) {
                    if (v < 56320) {
                        this.savedHighSurrogate = (char)v;
                        return;
                    }
                    if (v < 57344) {
                        i = (this.savedHighSurrogate - 55296) * 1024 + (i - 56320) + 65536;
                        this.savedHighSurrogate = '\u0000';
                    }
                }
                this.writeRaw("&#x" + Integer.toHexString(i).toUpperCase() + ";");
            } else {
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
    public void writeBoolean(boolean v) {
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
        } else if (this.needXMLdecl) {
            this.writeRaw("<?xml version=\"1.0\"?>\n");
            if (this.printIndent >= 0) {
                this.startLogicalBlock("", "", 2);
            }
            this.needXMLdecl = false;
            this.prev = 62;
        }
    }

    void setIndentMode() {
        String indent;
        Object xmlIndent = indentLoc.get(null);
        String string = indent = xmlIndent == null ? null : xmlIndent.toString();
        this.printIndent = indent == null ? -1 : (indent.equals("pretty") ? 0 : (indent.equals("always") || indent.equals("yes") ? 1 : -1));
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
    public void beginEntity(Object base2) {
    }

    @Override
    public void endEntity() {
    }

    protected void writeQName(Object name) {
        if (name instanceof Symbol) {
            Symbol sname = (Symbol)name;
            String prefix = sname.getPrefix();
            if (prefix != null && prefix.length() > 0) {
                this.writeRaw(prefix);
                this.writeRaw(58);
            }
            this.writeRaw(sname.getLocalPart());
        } else {
            this.writeRaw(name == null ? "{null name}" : (String)name);
        }
    }

    public void writeDoctypeIfDefined(String tagname) {
        String systemId;
        Object systemIdentifier = doctypeSystem.get(null);
        if (systemIdentifier != null && (systemId = systemIdentifier.toString()).length() > 0) {
            Object publicIdentifier = doctypePublic.get(null);
            String publicId = publicIdentifier == null ? null : publicIdentifier.toString();
            this.writeDoctype(tagname, systemId, publicId);
        }
    }

    public void writeDoctype(String tagname, String systemId, String publicId) {
        this.writeRaw("<!DOCTYPE ");
        this.writeRaw(tagname);
        if (publicId != null && publicId.length() > 0) {
            this.writeRaw(" PUBLIC \"");
            this.writeRaw(publicId);
            this.writeRaw("\" \"");
        } else {
            this.writeRaw(" SYSTEM \"");
        }
        this.writeRaw(systemId);
        this.writeRaw("\">");
        this.println();
    }

    @Override
    public void startElement(Object type) {
        String typeName;
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
                this.writeBreak(this.printIndent > 0 ? 82 : 78);
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
            NamespaceBinding join = NamespaceBinding.commonAncestor(elementBindings, this.namespaceBindings);
            int numBindings = elementBindings == null ? 0 : elementBindings.count(join);
            NamespaceBinding[] sortedBindings = new NamespaceBinding[numBindings];
            int i = 0;
            boolean sortNamespaces = this.canonicalize;
            NamespaceBinding ns = elementBindings;
            while (ns != join) {
                block22 : {
                    int j = i;
                    boolean skip = false;
                    String uri = ns.getUri();
                    String prefix = ns.getPrefix();
                    while (--j >= 0) {
                        NamespaceBinding ns_j = sortedBindings[j];
                        String prefix_j = ns_j.getPrefix();
                        if (prefix != prefix_j) {
                            if (!sortNamespaces) continue;
                            if (prefix == null || prefix_j != null && prefix.compareTo(prefix_j) <= 0) break;
                            sortedBindings[j + 1] = ns_j;
                            continue;
                        }
                        break block22;
                    }
                    j = sortNamespaces ? ++j : i;
                    sortedBindings[j] = ns;
                    ++i;
                }
                ns = ns.next;
            }
            i = numBindings = i;
            while (--i >= 0) {
                ns = sortedBindings[i];
                String uri = ns.uri;
                String prefix = ns.prefix;
                if (uri == this.namespaceBindings.resolve(prefix) || uri == null && prefix != null && !this.undeclareNamespaces) continue;
                this.writeRaw(32);
                if (prefix == null) {
                    this.writeRaw("xmlns");
                } else {
                    this.writeRaw("xmlns:");
                    this.writeRaw(prefix);
                }
                this.writeRaw("=\"");
                this.inAttribute = true;
                if (uri != null) {
                    this.write(uri);
                }
                this.inAttribute = false;
                this.writeRaw(34);
            }
            if (this.undeclareNamespaces) {
                ns = this.namespaceBindings;
                while (ns != join) {
                    String prefix = ns.prefix;
                    if (ns.uri != null && elementBindings.resolve(prefix) == null) {
                        this.writeRaw(32);
                        if (prefix == null) {
                            this.writeRaw("xmlns");
                        } else {
                            this.writeRaw("xmlns:");
                            this.writeRaw(prefix);
                        }
                        this.writeRaw("=\"\"");
                    }
                    ns = ns.next;
                }
            }
            this.namespaceBindings = elementBindings;
        }
        if (this.elementNesting >= this.namespaceSaveStack.length) {
            NamespaceBinding[] nstmp = new NamespaceBinding[2 * this.elementNesting];
            System.arraycopy(this.namespaceSaveStack, 0, nstmp, 0, this.elementNesting);
            this.namespaceSaveStack = nstmp;
            Object[] nmtmp = new Object[2 * this.elementNesting];
            System.arraycopy(this.elementNameStack, 0, nmtmp, 0, this.elementNesting);
            this.elementNameStack = nmtmp;
        }
        this.inStartTag = true;
        if (this.isHtml && ("script".equals(typeName = this.getHtmlTag(type)) || "style".equals(typeName))) {
            this.escapeText = false;
        }
    }

    public static boolean isHtmlEmptyElementTag(String name) {
        int index = HtmlEmptyTags.indexOf(name);
        return index > 0 && HtmlEmptyTags.charAt(index - 1) == '/' && HtmlEmptyTags.charAt(index + name.length()) == '/';
    }

    protected String getHtmlTag(Object type) {
        if (type instanceof Symbol) {
            Symbol sym = (Symbol)type;
            String uri = sym.getNamespaceURI();
            if (uri == "http://www.w3.org/1999/xhtml" || this.isHtmlOrXhtml && uri == "") {
                return sym.getLocalPart();
            }
        } else if (this.isHtmlOrXhtml) {
            return type.toString();
        }
        return null;
    }

    @Override
    public void endElement() {
        if (this.useEmptyElementTag == 0) {
            this.closeTag();
        }
        Object type = this.elementNameStack[this.elementNesting - 1];
        String typeName = this.getHtmlTag(type);
        if (this.inStartTag) {
            boolean isEmpty;
            if (this.printIndent >= 0 && this.indentAttributes) {
                this.endLogicalBlock("");
            }
            String end = null;
            boolean bl = isEmpty = typeName != null && XMLPrinter.isHtmlEmptyElementTag(typeName);
            if ((this.useEmptyElementTag == 0 || typeName != null && !isEmpty) && type instanceof Symbol) {
                Symbol sym = (Symbol)type;
                String prefix = sym.getPrefix();
                String uri = sym.getNamespaceURI();
                String local = sym.getLocalName();
                if (prefix != "") {
                    end = "></" + prefix + ":" + local + ">";
                } else if (uri == "" || uri == null || uri == this.namespaceBindings.resolve(null)) {
                    end = "></" + local + ">";
                }
            }
            if (end == null) {
                end = isEmpty && this.isHtml ? ">" : (this.useEmptyElementTag == 2 ? " />" : "/>");
            }
            this.writeRaw(end);
            this.inStartTag = false;
        } else {
            if (this.printIndent >= 0) {
                this.setIndentation(0, false);
                if (this.prev == -4) {
                    this.writeBreak(this.printIndent > 0 ? 82 : 78);
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
        this.namespaceBindings = this.namespaceSaveStack[--this.elementNesting];
        this.namespaceSaveStack[this.elementNesting] = null;
        this.elementNameStack[this.elementNesting] = null;
    }

    @Override
    public void startAttribute(Object attrType) {
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
        this.writeRaw(attrType == null ? "{null name}" : attrType.toString());
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
    public void writeDouble(double d) {
        this.startWord();
        this.writeRaw(XMLPrinter.formatDouble(d));
    }

    @Override
    public void writeFloat(float f) {
        this.startWord();
        this.writeRaw(XMLPrinter.formatFloat(f));
    }

    public static String formatDouble(double d) {
        boolean neg;
        if (Double.isNaN(d)) {
            return "NaN";
        }
        boolean bl = neg = d < 0.0;
        if (Double.isInfinite(d)) {
            return neg ? "-INF" : "INF";
        }
        double dabs = neg ? -d : d;
        String dstr = Double.toString(d);
        if ((dabs >= 1000000.0 || dabs < 1.0E-6) && dabs != 0.0) {
            return RealNum.toStringScientific(dstr);
        }
        return XMLPrinter.formatDecimal(RealNum.toStringDecimal(dstr));
    }

    public static String formatFloat(float f) {
        boolean neg;
        if (Float.isNaN(f)) {
            return "NaN";
        }
        boolean bl = neg = f < 0.0f;
        if (Float.isInfinite(f)) {
            return neg ? "-INF" : "INF";
        }
        float fabs = neg ? -f : f;
        String fstr = Float.toString(f);
        if ((fabs >= 1000000.0f || (double)fabs < 1.0E-6) && (double)fabs != 0.0) {
            return RealNum.toStringScientific(fstr);
        }
        return XMLPrinter.formatDecimal(RealNum.toStringDecimal(fstr));
    }

    public static String formatDecimal(BigDecimal dec) {
        return XMLPrinter.formatDecimal(dec.toPlainString());
    }

    static String formatDecimal(String str) {
        int dot = str.indexOf(46);
        if (dot >= 0) {
            char ch;
            int len;
            int pos = len = str.length();
            while ((ch = str.charAt(--pos)) == '0') {
            }
            if (ch != '.') {
                ++pos;
            }
            return pos == len ? str : str.substring(0, pos);
        }
        return str;
    }

    @Override
    public void print(Object v) {
        if (v instanceof BigDecimal) {
            v = XMLPrinter.formatDecimal((BigDecimal)v);
        } else if (v instanceof Double || v instanceof DFloNum) {
            v = XMLPrinter.formatDouble(((Number)v).doubleValue());
        } else if (v instanceof Float) {
            v = XMLPrinter.formatFloat(((Float)v).floatValue());
        }
        this.write(v == null ? "(null)" : v.toString());
    }

    @Override
    public void writeObject(Object v) {
        if (v instanceof SeqPosition) {
            this.clearWordEnd();
            SeqPosition pos = (SeqPosition)v;
            ((AbstractSequence)pos.sequence).consumeNext(pos.ipos, this);
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
        } else if (v instanceof Char) {
            Char.print(((Char)v).intValue(), this);
        } else {
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
    public void write(String str, int start, int length) {
        if (length > 0) {
            this.closeTag();
            int limit = start + length;
            int count = 0;
            while (start < limit) {
                char c;
                if (this.mustHexEscape(c = str.charAt(start++)) || (this.inComment > 0 ? c == '-' || this.inComment == 2 : c == '<' || c == '>' || c == '&' || this.inAttribute && (c == '\"' || c < ' '))) {
                    if (count > 0) {
                        this.writeRaw(str, start - 1 - count, count);
                    }
                    this.write(c);
                    count = 0;
                    continue;
                }
                ++count;
            }
            if (count > 0) {
                this.writeRaw(str, limit - count, count);
            }
        }
        this.prev = 45;
    }

    @Override
    public void write(char[] buf, int off, int len) {
        if (len > 0) {
            this.closeTag();
            int limit = off + len;
            int count = 0;
            while (off < limit) {
                char c;
                if (this.mustHexEscape(c = buf[off++]) || (this.inComment > 0 ? c == '-' || this.inComment == 2 : c == '<' || c == '>' || c == '&' || this.inAttribute && (c == '\"' || c < ' '))) {
                    if (count > 0) {
                        this.writeRaw(buf, off - 1 - count, count);
                    }
                    this.write(c);
                    count = 0;
                    continue;
                }
                ++count;
            }
            if (count > 0) {
                this.writeRaw(buf, limit - count, count);
            }
        }
        this.prev = 45;
    }

    @Override
    public void writePosition(AbstractSequence seq, int ipos) {
        seq.consumeNext(ipos, this);
    }

    public void writeBaseUri(Object uri) {
    }

    public void beginComment() {
        this.closeTag();
        if (this.printIndent >= 0 && (this.prev == -3 || this.prev == -4 || this.prev == -5)) {
            this.writeBreak(this.printIndent > 0 ? 82 : 78);
        }
        this.writeRaw("<!--");
        this.inComment = 1;
    }

    public void endComment() {
        this.writeRaw("-->");
        this.prev = -5;
        this.inComment = 0;
    }

    public void writeComment(String chars) {
        this.beginComment();
        this.write(chars);
        this.endComment();
    }

    @Override
    public void writeComment(char[] chars, int offset, int length) {
        this.beginComment();
        this.write(chars, offset, length);
        this.endComment();
    }

    @Override
    public void writeCDATA(char[] chars, int offset, int length) {
        if (this.canonicalizeCDATA) {
            this.write(chars, offset, length);
            return;
        }
        this.closeTag();
        this.writeRaw("<![CDATA[");
        int limit = offset + length;
        for (int i = offset; i < limit - 2; ++i) {
            if (chars[i] != ']' || chars[i + 1] != ']' || chars[i + 2] != '>') continue;
            if (i > offset) {
                this.writeRaw(chars, offset, i - offset);
            }
            this.writeRaw("]]]><![CDATA[]>");
            offset = i + 3;
            length = limit - offset;
            i += 2;
        }
        this.writeRaw(chars, offset, length);
        this.writeRaw("]]>");
        this.prev = 62;
    }

    @Override
    public void writeProcessingInstruction(String target, char[] content, int offset, int length) {
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
    public void writePosition(SeqPosition position) {
        ((AbstractSequence)position.sequence).consumeNext(position.ipos, this);
    }

    public void error(String msg, String code) {
        throw new RuntimeException("serialization error: " + msg + " [" + code + ']');
    }
}

