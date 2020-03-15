// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.expr.Special;
import gnu.xml.NamespaceBinding;
import gnu.text.SourceLocator;
import gnu.lists.PairWithPosition;
import gnu.xml.XName;
import gnu.lists.LList;
import gnu.mapping.Namespace;
import gnu.lists.Pair;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Lexer;
import gnu.mapping.Symbol;

public class ReaderXmlElement extends ReaderExtendedLiteral
{
    static final Symbol xmlTextSymbol;
    static final Symbol xmlCommentSymbol;
    static final Symbol xmlElementSymbol;
    static final Symbol xmlCDATASymbol;
    static final Symbol xmlProcInstSymbol;
    static final Symbol xmlAttributeSymbol;
    static final Symbol resolveQNameSymbol;
    static final String DEFAULT_ELEMENT_NAMESPACE = "$default-element-namespace$";
    public static final Symbol defaultElementNamespaceSymbol;
    
    @Override
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        final LispReader reader = (LispReader)in;
        return this.readXMLConstructor(reader, reader.readUnicodeChar(), false);
    }
    
    public static Pair quote(final Object obj) {
        final Symbol q = Namespace.EmptyNamespace.getSymbol("quote");
        return LList.list2(q, obj);
    }
    
    public Object readQNameExpression(final LispReader reader, int ch, final boolean forElement) throws IOException, SyntaxException {
        final String file = reader.getName();
        final int line = reader.getLineNumber() + 1;
        final int column = reader.getColumnNumber();
        reader.tokenBufferLength = 0;
        if (XName.isNameStart(ch)) {
            int colon = -1;
            while (true) {
                reader.tokenBufferAppend(ch);
                ch = reader.readUnicodeChar();
                if (ch == 58 && colon < 0) {
                    colon = reader.tokenBufferLength;
                }
                else {
                    if (!XName.isNamePart(ch)) {
                        break;
                    }
                    continue;
                }
            }
            reader.unread(ch);
            if (colon >= 0 || forElement) {
                final int llen = reader.tokenBufferLength - colon - 1;
                final String local = new String(reader.tokenBuffer, colon + 1, llen).intern();
                Object ns = LList.Empty;
                if (colon >= 0) {
                    final String prefix = new String(reader.tokenBuffer, 0, colon).intern();
                    ns = new Pair(Symbol.valueOf(prefix), ns);
                }
                return new Pair(ReaderXmlElement.resolveQNameSymbol, PairWithPosition.make(Symbol.valueOf(local), ns, reader.getName(), line, column));
            }
            final Symbol symbol = Namespace.getDefaultSymbol(reader.tokenBufferString().intern());
            return quote(symbol);
        }
        else {
            if (this.enclosedExprDelim(ch, reader) >= 0 || ch == 40) {
                return this.readEnclosedSingleExpression(reader, ReadTable.getCurrent(), ch);
            }
            reader.error("missing element name");
            return null;
        }
    }
    
    Object readXMLConstructor(final LispReader reader, int next, final boolean inElementContent) throws IOException, SyntaxException {
        final int startLine = reader.getLineNumber() + 1;
        final int startColumn = reader.getColumnNumber() - 2;
        Object exp;
        if (next == 33) {
            next = reader.read();
            if (next == 45 && (next = reader.peek()) == 45) {
                reader.skip();
                if (!reader.readDelimited("-->")) {
                    reader.error('f', reader.getName(), startLine, startColumn, "unexpected end-of-file in XML comment starting here - expected \"-->\"");
                }
                final String str = reader.tokenBufferString();
                exp = LList.list2(ReaderXmlElement.xmlCommentSymbol, str);
            }
            else if (next == 91 && (next = reader.read()) == 67 && (next = reader.read()) == 68 && (next = reader.read()) == 65 && (next = reader.read()) == 84 && (next = reader.read()) == 65 && (next = reader.read()) == 91) {
                if (!reader.readDelimited("]]>")) {
                    reader.error('f', reader.getName(), startLine, startColumn, "unexpected end-of-file in CDATA starting here - expected \"]]>\"");
                }
                final String str = reader.tokenBufferString();
                exp = LList.list2(ReaderXmlElement.xmlCDATASymbol, str);
            }
            else {
                reader.error('f', reader.getName(), startLine, startColumn, "'<!' must be followed by '--' or '[CDATA['");
                while (next >= 0 && next != 62 && next != 10 && next != 13) {
                    next = reader.read();
                }
                exp = null;
            }
        }
        else if (next == 63) {
            next = reader.readUnicodeChar();
            if (next < 0 || !XName.isNameStart(next)) {
                reader.error("missing target after '<?'");
            }
            do {
                reader.tokenBufferAppend(next);
                next = reader.readUnicodeChar();
            } while (XName.isNamePart(next));
            final String target = reader.tokenBufferString();
            int nspaces = 0;
            while (next >= 0 && Character.isWhitespace(next)) {
                ++nspaces;
                next = reader.read();
            }
            reader.unread(next);
            final char saveReadState = reader.pushNesting('?');
            try {
                if (!reader.readDelimited("?>")) {
                    reader.error('f', reader.getName(), startLine, startColumn, "unexpected end-of-file looking for \"?>\"");
                }
            }
            finally {
                reader.popNesting(saveReadState);
            }
            if (nspaces == 0 && reader.tokenBufferLength > 0) {
                reader.error("target must be followed by space or '?>'");
            }
            final String content = reader.tokenBufferString();
            exp = LList.list3(ReaderXmlElement.xmlProcInstSymbol, target, content);
        }
        else {
            exp = this.readElementConstructor(reader, next);
        }
        return exp;
    }
    
    public Object readElementConstructor(final LispReader reader, int ch) throws IOException, SyntaxException {
        final int startLine = reader.getLineNumber() + 1;
        final int startColumn = reader.getColumnNumber() - 2;
        final Object tag = this.readQNameExpression(reader, ch, true);
        final String startTag = (reader.tokenBufferLength == 0) ? null : reader.tokenBufferString();
        Pair resultTail;
        final Pair tagPair = resultTail = PairWithPosition.make(tag, LList.Empty, reader.getName(), startLine, startColumn);
        LList namespaceList = LList.Empty;
        final NamespaceBinding nsBindings = null;
        boolean sawSpace = false;
        while (true) {
            for (ch = reader.readUnicodeChar(); ch >= 0 && Character.isWhitespace(ch); ch = reader.readUnicodeChar(), sawSpace = true) {}
            if (ch < 0 || ch == 62 || ch == 47) {
                break;
            }
            if (!sawSpace) {
                reader.error("missing space before attribute");
            }
            final Object attrName = this.readQNameExpression(reader, ch, false);
            final int line = reader.getLineNumber() + 1;
            final int column = reader.getColumnNumber() + 1 - reader.tokenBufferLength;
            String definingNamespace = null;
            if (reader.tokenBufferLength >= 5 && reader.tokenBuffer[0] == 'x' && reader.tokenBuffer[1] == 'm' && reader.tokenBuffer[2] == 'l' && reader.tokenBuffer[3] == 'n' && reader.tokenBuffer[4] == 's') {
                if (reader.tokenBufferLength == 5) {
                    definingNamespace = "";
                }
                else if (reader.tokenBuffer[5] == ':') {
                    definingNamespace = new String(reader.tokenBuffer, 6, reader.tokenBufferLength - 6);
                }
            }
            sawSpace = false;
            while (true) {
                ch = reader.readUnicodeChar();
                if (ch < 0) {
                    break;
                }
                if (!Character.isWhitespace(ch)) {
                    break;
                }
                sawSpace = true;
            }
            Object attrExpr;
            if (ch != 61 && reader.tokenBufferLength == 0 && (sawSpace || ch == 47 || ch == 62)) {
                reader.unread(ch);
                attrExpr = attrName;
            }
            else {
                if (ch != 61) {
                    reader.error("missing '=' after attribute");
                }
                ch = skipSpace(reader, 32);
                final PairWithPosition attrList = PairWithPosition.make(ReaderXmlElement.xmlAttributeSymbol, LList.Empty, reader.getName(), startLine, startColumn);
                final PairWithPosition attrPair = PairWithPosition.make(attrName, LList.Empty, reader.getName(), startLine, startColumn);
                reader.setCdr(attrList, attrPair);
                Pair attrTail = attrPair;
                if (ch == 91 || ch == 40) {
                    final ReadTable rtable = ReadTable.getCurrent();
                    final int startDelimiter;
                    attrTail = this.readEnclosed(reader, rtable, attrTail, startDelimiter, ((startDelimiter = ch) == 91) ? 93 : 41);
                }
                else if (ch == 34 || ch == 39) {
                    attrTail = this.readContent(reader, (char)ch, attrTail);
                }
                else {
                    reader.error("missing attribute value");
                }
                attrExpr = attrList;
                if (definingNamespace != null) {
                    namespaceList = new PairWithPosition(attrPair, Pair.make(Symbol.valueOf(definingNamespace), attrPair.getCdr()), namespaceList);
                }
                sawSpace = false;
            }
            if (definingNamespace != null) {
                continue;
            }
            final Pair pair = PairWithPosition.make(attrExpr, reader.makeNil(), null, -1, -1);
            resultTail.setCdrBackdoor(pair);
            resultTail = pair;
        }
        boolean empty = false;
        if (ch == 47) {
            ch = reader.read();
            if (ch == 62) {
                empty = true;
            }
            else {
                reader.unread(ch);
            }
        }
        if (!empty) {
            if (ch != 62) {
                reader.error("missing '>' after start element");
                return Boolean.FALSE;
            }
            resultTail = this.readContent(reader, '<', resultTail);
            ch = reader.readUnicodeChar();
            if (XName.isNameStart(ch)) {
                reader.tokenBufferLength = 0;
                do {
                    reader.tokenBufferAppend(ch);
                    ch = reader.readUnicodeChar();
                } while (XName.isNamePart(ch) || ch == 58);
                final String endTag = reader.tokenBufferString();
                if (startTag == null || !endTag.equals(startTag)) {
                    reader.error('e', reader.getName(), reader.getLineNumber() + 1, reader.getColumnNumber() - reader.tokenBufferLength, (startTag == null) ? ("computed start tag closed by '</" + endTag + ">'") : ("'<" + startTag + ">' closed by '</" + endTag + ">'"));
                }
                reader.tokenBufferLength = 0;
            }
            ch = skipSpace(reader, ch);
            if (ch != 62) {
                reader.error("missing '>' after end element");
            }
        }
        namespaceList = LList.reverseInPlace(namespaceList);
        return PairWithPosition.make(ReaderXmlElement.xmlElementSymbol, Pair.make(namespaceList, tagPair), reader.getName(), startLine, startColumn);
    }
    
    @Override
    protected Object checkDelim(final LispReader reader, int next, final int delimiter) throws IOException, SyntaxException {
        if (delimiter == 60 && next == 60) {
            next = reader.read();
            if (next == 47) {
                return Special.eof;
            }
            return this.readXMLConstructor(reader, next, true);
        }
        else {
            if (next < 0 || (delimiter != 60 && next == delimiter)) {
                return Special.eof;
            }
            return null;
        }
    }
    
    @Override
    protected boolean isNestableStartDelim(final int next) {
        return false;
    }
    
    @Override
    protected boolean isNestableEndDelim(final int next) {
        return false;
    }
    
    public static int skipSpace(final LispReader reader, int ch) throws IOException, SyntaxException {
        while (ch >= 0 && Character.isWhitespace(ch)) {
            ch = reader.readUnicodeChar();
        }
        return ch;
    }
    
    @Override
    protected int enclosedExprDelim(final int ch, final LispReader reader) {
        if (ch == 91) {
            return 93;
        }
        if (ch == 123) {
            if (!reader.deprecatedXmlEnlosedReported) {
                reader.error('w', "use '[' instead of deprecated '{' for enclosed expression");
                reader.deprecatedXmlEnlosedReported = true;
            }
            return 125;
        }
        return -1;
    }
    
    static {
        xmlTextSymbol = Symbol.valueOf("$xml-text$");
        xmlCommentSymbol = Symbol.valueOf("$xml-comment$");
        xmlElementSymbol = Symbol.valueOf("$xml-element$");
        xmlCDATASymbol = Symbol.valueOf("$xml-CDATA$");
        xmlProcInstSymbol = Symbol.valueOf("$xml-processing-instruction$");
        xmlAttributeSymbol = Symbol.valueOf("$xml-attribute$");
        resolveQNameSymbol = Symbol.valueOf("$resolve-qname$");
        defaultElementNamespaceSymbol = Symbol.valueOf("$default-element-namespace$");
    }
}
