/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.expr.Special;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReaderExtendedLiteral;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import gnu.text.SourceLocator;
import gnu.text.SyntaxException;
import gnu.xml.XName;
import java.io.IOException;

public class ReaderXmlElement
extends ReaderExtendedLiteral {
    static final Symbol xmlTextSymbol = Symbol.valueOf("$xml-text$");
    static final Symbol xmlCommentSymbol = Symbol.valueOf("$xml-comment$");
    static final Symbol xmlElementSymbol = Symbol.valueOf("$xml-element$");
    static final Symbol xmlCDATASymbol = Symbol.valueOf("$xml-CDATA$");
    static final Symbol xmlProcInstSymbol = Symbol.valueOf("$xml-processing-instruction$");
    static final Symbol xmlAttributeSymbol = Symbol.valueOf("$xml-attribute$");
    static final Symbol resolveQNameSymbol = Symbol.valueOf("$resolve-qname$");
    static final String DEFAULT_ELEMENT_NAMESPACE = "$default-element-namespace$";
    public static final Symbol defaultElementNamespaceSymbol = Symbol.valueOf("$default-element-namespace$");

    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        LispReader reader = (LispReader)in;
        return this.readXMLConstructor(reader, reader.readUnicodeChar(), false);
    }

    public static Pair quote(Object obj) {
        Symbol q = Namespace.EmptyNamespace.getSymbol("quote");
        return LList.list2(q, obj);
    }

    public Object readQNameExpression(LispReader reader, int ch, boolean forElement) throws IOException, SyntaxException {
        String file2 = reader.getName();
        int line = reader.getLineNumber() + 1;
        int column = reader.getColumnNumber();
        reader.tokenBufferLength = 0;
        if (XName.isNameStart(ch)) {
            int colon = -1;
            do {
                reader.tokenBufferAppend(ch);
                ch = reader.readUnicodeChar();
                if (ch == 58 && colon < 0) {
                    colon = reader.tokenBufferLength;
                    continue;
                }
                if (!XName.isNamePart(ch)) break;
            } while (true);
            reader.unread(ch);
            if (colon >= 0 || forElement) {
                int llen = reader.tokenBufferLength - colon - 1;
                String local = new String(reader.tokenBuffer, colon + 1, llen).intern();
                LList ns = LList.Empty;
                if (colon >= 0) {
                    String prefix = new String(reader.tokenBuffer, 0, colon).intern();
                    ns = new Pair(Symbol.valueOf(prefix), ns);
                }
                return new Pair(resolveQNameSymbol, PairWithPosition.make(Symbol.valueOf(local), ns, reader.getName(), line, column));
            }
            Symbol symbol = Namespace.getDefaultSymbol(reader.tokenBufferString().intern());
            return ReaderXmlElement.quote(symbol);
        }
        if (this.enclosedExprDelim(ch, reader) >= 0 || ch == 40) {
            return this.readEnclosedSingleExpression(reader, ReadTable.getCurrent(), ch);
        }
        reader.error("missing element name");
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object readXMLConstructor(LispReader reader, int next, boolean inElementContent) throws IOException, SyntaxException {
        Object exp;
        int startLine = reader.getLineNumber() + 1;
        int startColumn = reader.getColumnNumber() - 2;
        if (next == 33) {
            next = reader.read();
            if (next == 45 && (next = reader.peek()) == 45) {
                reader.skip();
                if (!reader.readDelimited("-->")) {
                    reader.error('f', reader.getName(), startLine, startColumn, "unexpected end-of-file in XML comment starting here - expected \"-->\"");
                }
                String str = reader.tokenBufferString();
                exp = LList.list2(xmlCommentSymbol, str);
            } else if (next == 91 && (next = reader.read()) == 67 && (next = reader.read()) == 68 && (next = reader.read()) == 65 && (next = reader.read()) == 84 && (next = reader.read()) == 65 && (next = reader.read()) == 91) {
                if (!reader.readDelimited("]]>")) {
                    reader.error('f', reader.getName(), startLine, startColumn, "unexpected end-of-file in CDATA starting here - expected \"]]>\"");
                }
                String str = reader.tokenBufferString();
                exp = LList.list2(xmlCDATASymbol, str);
            } else {
                reader.error('f', reader.getName(), startLine, startColumn, "'<!' must be followed by '--' or '[CDATA['");
                while (next >= 0 && next != 62 && next != 10 && next != 13) {
                    next = reader.read();
                }
                exp = null;
            }
        } else if (next == 63) {
            String target;
            int nspaces;
            next = reader.readUnicodeChar();
            if (next < 0 || !XName.isNameStart(next)) {
                reader.error("missing target after '<?'");
            }
            do {
                reader.tokenBufferAppend(next);
            } while (XName.isNamePart(next = reader.readUnicodeChar()));
            target = reader.tokenBufferString();
            nspaces = 0;
            while (next >= 0 && Character.isWhitespace(next)) {
                ++nspaces;
                next = reader.read();
            }
            reader.unread(next);
            char saveReadState = reader.pushNesting('?');
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
            String content = reader.tokenBufferString();
            exp = LList.list3(xmlProcInstSymbol, target, content);
        } else {
            exp = this.readElementConstructor(reader, next);
        }
        return exp;
    }

    public Object readElementConstructor(LispReader reader, int ch) throws IOException, SyntaxException {
        int startLine = reader.getLineNumber() + 1;
        int startColumn = reader.getColumnNumber() - 2;
        Object tag = this.readQNameExpression(reader, ch, true);
        String startTag = reader.tokenBufferLength == 0 ? null : reader.tokenBufferString();
        PairWithPosition tagPair = PairWithPosition.make(tag, LList.Empty, reader.getName(), startLine, startColumn);
        Pair resultTail = tagPair;
        LList namespaceList = LList.Empty;
        Object nsBindings = null;
        boolean sawSpace = false;
        do {
            Object attrExpr;
            ch = reader.readUnicodeChar();
            while (ch >= 0 && Character.isWhitespace(ch)) {
                ch = reader.readUnicodeChar();
                sawSpace = true;
            }
            if (ch < 0 || ch == 62 || ch == 47) break;
            if (!sawSpace) {
                reader.error("missing space before attribute");
            }
            Object attrName = this.readQNameExpression(reader, ch, false);
            int line = reader.getLineNumber() + 1;
            int column = reader.getColumnNumber() + 1 - reader.tokenBufferLength;
            String definingNamespace = null;
            if (reader.tokenBufferLength >= 5 && reader.tokenBuffer[0] == 'x' && reader.tokenBuffer[1] == 'm' && reader.tokenBuffer[2] == 'l' && reader.tokenBuffer[3] == 'n' && reader.tokenBuffer[4] == 's') {
                if (reader.tokenBufferLength == 5) {
                    definingNamespace = "";
                } else if (reader.tokenBuffer[5] == ':') {
                    definingNamespace = new String(reader.tokenBuffer, 6, reader.tokenBufferLength - 6);
                }
            }
            sawSpace = false;
            while ((ch = reader.readUnicodeChar()) >= 0 && Character.isWhitespace(ch)) {
                sawSpace = true;
            }
            if (ch != 61 && reader.tokenBufferLength == 0 && (sawSpace || ch == 47 || ch == 62)) {
                reader.unread(ch);
                attrExpr = attrName;
            } else {
                if (ch != 61) {
                    reader.error("missing '=' after attribute");
                }
                ch = ReaderXmlElement.skipSpace(reader, 32);
                PairWithPosition attrList = PairWithPosition.make(xmlAttributeSymbol, LList.Empty, reader.getName(), startLine, startColumn);
                PairWithPosition attrPair = PairWithPosition.make(attrName, LList.Empty, reader.getName(), startLine, startColumn);
                reader.setCdr(attrList, attrPair);
                Pair attrTail = attrPair;
                if (ch == 91 || ch == 40) {
                    ReadTable rtable = ReadTable.getCurrent();
                    attrTail = this.readEnclosed(reader, rtable, attrTail, ch, ch == 91 ? 93 : 41);
                } else if (ch == 34 || ch == 39) {
                    attrTail = this.readContent(reader, (char)ch, attrTail);
                } else {
                    reader.error("missing attribute value");
                }
                attrExpr = attrList;
                if (definingNamespace != null) {
                    namespaceList = new PairWithPosition(attrPair, Pair.make(Symbol.valueOf(definingNamespace), attrPair.getCdr()), namespaceList);
                }
                sawSpace = false;
            }
            if (definingNamespace != null) continue;
            PairWithPosition pair = PairWithPosition.make(attrExpr, reader.makeNil(), null, -1, -1);
            resultTail.setCdrBackdoor(pair);
            resultTail = pair;
        } while (true);
        boolean empty = false;
        if (ch == 47) {
            ch = reader.read();
            if (ch == 62) {
                empty = true;
            } else {
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
                } while (XName.isNamePart(ch = reader.readUnicodeChar()) || ch == 58);
                String endTag = reader.tokenBufferString();
                if (startTag == null || !endTag.equals(startTag)) {
                    reader.error('e', reader.getName(), reader.getLineNumber() + 1, reader.getColumnNumber() - reader.tokenBufferLength, startTag == null ? "computed start tag closed by '</" + endTag + ">'" : "'<" + startTag + ">' closed by '</" + endTag + ">'");
                }
                reader.tokenBufferLength = 0;
            }
            if ((ch = ReaderXmlElement.skipSpace(reader, ch)) != 62) {
                reader.error("missing '>' after end element");
            }
        }
        namespaceList = LList.reverseInPlace(namespaceList);
        return PairWithPosition.make(xmlElementSymbol, Pair.make(namespaceList, tagPair), reader.getName(), startLine, startColumn);
    }

    @Override
    protected Object checkDelim(LispReader reader, int next, int delimiter) throws IOException, SyntaxException {
        if (delimiter == 60 && next == 60) {
            next = reader.read();
            if (next == 47) {
                return Special.eof;
            }
            return this.readXMLConstructor(reader, next, true);
        }
        if (next < 0 || delimiter != 60 && next == delimiter) {
            return Special.eof;
        }
        return null;
    }

    @Override
    protected boolean isNestableStartDelim(int next) {
        return false;
    }

    @Override
    protected boolean isNestableEndDelim(int next) {
        return false;
    }

    public static int skipSpace(LispReader reader, int ch) throws IOException, SyntaxException {
        while (ch >= 0 && Character.isWhitespace(ch)) {
            ch = reader.readUnicodeChar();
        }
        return ch;
    }

    @Override
    protected int enclosedExprDelim(int ch, LispReader reader) {
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
}

