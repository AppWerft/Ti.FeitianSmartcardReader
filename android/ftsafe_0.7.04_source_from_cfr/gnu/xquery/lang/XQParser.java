/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.Mangling;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.NameLookup;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.functions.Convert;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.FilePath;
import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.reflect.SingletonType;
import gnu.kawa.xml.DescendantOrSelfAxis;
import gnu.kawa.xml.ElementType;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.MakeWithBaseUri;
import gnu.kawa.xml.NodeType;
import gnu.kawa.xml.ParentAxis;
import gnu.kawa.xml.ProcessingInstructionType;
import gnu.kawa.xml.XDataType;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.math.IntNum;
import gnu.text.Lexer;
import gnu.text.SourceError;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xml.NamespaceBinding;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import gnu.xquery.lang.XQResolveNames;
import gnu.xquery.lang.XQuery;
import gnu.xquery.util.CastableAs;
import gnu.xquery.util.NamedCollator;
import gnu.xquery.util.QNameUtils;
import gnu.xquery.util.RelativeStep;
import gnu.xquery.util.ValuesFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import kawa.lang.Translator;
import kawa.standard.require;

public class XQParser
extends Lexer {
    int curToken;
    Object curValue;
    int parseContext;
    boolean seenDeclaration;
    String libraryModuleNamespace;
    Map<String, SourceLocator> seenImports;
    int curLine;
    int curColumn;
    XQuery interpreter;
    int seenPosition;
    int seenLast;
    public static boolean warnOldVersion = true;
    public static boolean warnHidePreviousDeclaration = false;
    static final Symbol DOT_VARNAME = Symbol.makeUninterned("$dot$");
    static final Symbol POSITION_VARNAME = Symbol.makeUninterned("$position$");
    static final Symbol LAST_VARNAME = Symbol.makeUninterned("$last$");
    public static final InstanceOf instanceOf = new InstanceOf(XQuery.getInstance(), "instance");
    public static final CastableAs castableAs = CastableAs.castableAs;
    public static final Convert treatAs = Convert.cast;
    NamedCollator defaultCollator = null;
    char defaultEmptyOrder = (char)76;
    boolean emptyOrderDeclarationSeen;
    private Path baseURI = null;
    boolean baseURIDeclarationSeen;
    boolean boundarySpacePreserve;
    boolean boundarySpaceDeclarationSeen;
    boolean orderingModeUnordered;
    boolean orderingModeSeen;
    boolean copyNamespacesDeclarationSeen;
    int copyNamespacesMode = 3;
    boolean constructionModeStrip;
    boolean constructionModeDeclarationSeen;
    public Namespace[] functionNamespacePath = XQuery.defaultFunctionNamespacePath;
    Declaration[] flworDecls;
    int flworDeclsFirst;
    int flworDeclsCount;
    int parseCount;
    int commentCount;
    String errorIfComment;
    static final int EOF_TOKEN = -1;
    static final int EOL_TOKEN = 10;
    static final char INTEGER_TOKEN = '0';
    static final char DECIMAL_TOKEN = '1';
    static final char DOUBLE_TOKEN = '2';
    static final int STRING_TOKEN = 34;
    static final int SLASHSLASH_TOKEN = 68;
    static final int DOTDOT_TOKEN = 51;
    static final int COLON_EQUAL_TOKEN = 76;
    static final int COLON_COLON_TOKEN = 88;
    static final int NCNAME_TOKEN = 65;
    static final int NCNAME_COLON_TOKEN = 67;
    static final int QNAME_TOKEN = 81;
    static final int ARROW_TOKEN = 82;
    static final int FNAME_TOKEN = 70;
    static final int IMPORT_MODULE_TOKEN = 73;
    static final int IMPORT_SCHEMA_TOKEN = 84;
    static final int MODULE_NAMESPACE_TOKEN = 77;
    static final int DECLARE_NAMESPACE_TOKEN = 78;
    static final int DECLARE_BOUNDARY_SPACE_TOKEN = 83;
    static final int DEFAULT_ELEMENT_TOKEN = 69;
    static final int DEFAULT_FUNCTION_TOKEN = 79;
    static final int DEFAULT_COLLATION_TOKEN = 71;
    static final int DEFAULT_ORDER_TOKEN = 72;
    static final int DECLARE_FUNCTION_TOKEN = 80;
    static final int DECLARE_VARIABLE_TOKEN = 86;
    static final int DECLARE_BASE_URI_TOKEN = 66;
    static final int DECLARE_ORDERING_TOKEN = 85;
    static final int DECLARE_CONSTRUCTION_TOKEN = 75;
    static final int DECLARE_OPTION_TOKEN = 111;
    static final int DECLARE_COPY_NAMESPACES_TOKEN = 76;
    static final int DEFINE_QNAME_TOKEN = 87;
    static final int XQUERY_VERSION_TOKEN = 89;
    static final int OP_AXIS_FIRST = 100;
    static final int COUNT_OP_AXIS = 13;
    static final int AXIS_ANCESTOR = 0;
    static final int AXIS_ANCESTOR_OR_SELF = 1;
    static final int AXIS_ATTRIBUTE = 2;
    static final int AXIS_CHILD = 3;
    static final int AXIS_DESCENDANT = 4;
    static final int AXIS_DESCENDANT_OR_SELF = 5;
    static final int AXIS_FOLLOWING = 6;
    static final int AXIS_FOLLOWING_SIBLING = 7;
    static final int AXIS_NAMESPACE = 8;
    static final int AXIS_PARENT = 9;
    static final int AXIS_PRECEDING = 10;
    static final int AXIS_PRECEDING_SIBLING = 11;
    static final int AXIS_SELF = 12;
    static final int OP_WHERE = 196;
    static final int PRAGMA_START_TOKEN = 197;
    static final int OP_BASE = 400;
    static final int OP_OR = 400;
    static final int OP_AND = 401;
    static final int OP_EQU = 402;
    static final int OP_NEQ = 403;
    static final int OP_LSS = 404;
    static final int OP_GRT = 405;
    static final int OP_LEQ = 406;
    static final int OP_GEQ = 407;
    static final int OP_IS = 408;
    static final int OP_ISNOT = 409;
    static final int OP_GRTGRT = 410;
    static final int OP_LSSLSS = 411;
    static final int OP_RANGE_TO = 412;
    static final int OP_ADD = 413;
    static final int OP_SUB = 414;
    static final int OP_MUL = 415;
    static final int OP_DIV = 416;
    static final int OP_IDIV = 417;
    static final int OP_MOD = 418;
    static final int OP_UNION = 419;
    static final int OP_INTERSECT = 420;
    static final int OP_EXCEPT = 421;
    static final int OP_INSTANCEOF = 422;
    static final int OP_TREAT_AS = 423;
    static final int OP_CASTABLE_AS = 424;
    static final int OP_CAST_AS = 425;
    static final int OP_EQ = 426;
    static final int OP_NE = 427;
    static final int OP_LT = 428;
    static final int OP_LE = 429;
    static final int OP_GT = 430;
    static final int OP_GE = 431;
    static final int OP_NODE = 230;
    static final int OP_TEXT = 231;
    static final int OP_COMMENT = 232;
    static final int OP_PI = 233;
    static final int OP_DOCUMENT = 234;
    static final int OP_ELEMENT = 235;
    static final int OP_ATTRIBUTE = 236;
    static final int OP_ITEM = 237;
    static final int OP_EMPTY_SEQUENCE = 238;
    static final int OP_SCHEMA_ATTRIBUTE = 239;
    static final int OP_SCHEMA_ELEMENT = 240;
    static final int IF_LPAREN_TOKEN = 241;
    static final int TYPESWITCH_LPAREN_TOKEN = 242;
    static final int FOR_DOLLAR_TOKEN = 243;
    static final int LET_DOLLAR_TOKEN = 244;
    static final int SOME_DOLLAR_TOKEN = 245;
    static final int EVERY_DOLLAR_TOKEN = 246;
    static final int CASE_DOLLAR_TOKEN = 247;
    static final int VALIDATE_LBRACE_TOKEN = 248;
    static final int ORDERED_LBRACE_TOKEN = 249;
    static final int UNORDERED_LBRACE_TOKEN = 250;
    static final int ELEMENT_TOKEN = 251;
    static final int ATTRIBUTE_TOKEN = 252;
    static final int TEXT_TOKEN = 253;
    static final int COMMENT_TOKEN = 254;
    static final int PI_TOKEN = 255;
    static final int DOCUMENT_TOKEN = 256;
    private int saveToken;
    private Object saveValue;
    private boolean warnedOldStyleKindTest;
    static PrimProcedure proc_OccurrenceType_getInstance = new PrimProcedure(ClassType.make("gnu.kawa.reflect.OccurrenceType").getDeclaredMethod("getInstance", 3));
    public static QuoteExp makeChildAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml.ChildAxis", "make", 1));
    public static QuoteExp makeDescendantAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml.DescendantAxis", "make", 1));
    int enclosedExpressionsSeen;
    public static Expression makeText = XQParser.makeFunctionExp("gnu.kawa.xml.MakeText", "makeText");
    static final Expression makeCDATA = XQParser.makeFunctionExp("gnu.kawa.xml.MakeCDATA", "makeCDATA");
    Compilation comp;
    String defaultElementNamespace = "";
    NamespaceBinding constructorNamespaces = NamespaceBinding.predefinedXML;
    NamespaceBinding prologNamespaces;
    static NamespaceBinding builtinNamespaces;
    public static final QuoteExp getExternalFunction;
    public static final String[] axisNames;

    public void setStaticBaseUri(String uri) {
        try {
            this.baseURI = XQParser.fixupStaticBaseUri(URIPath.valueOf(uri));
        }
        catch (Exception ex) {
            Exception th = ex instanceof WrappedException ? ((WrappedException)ex).getCause() : ex;
            this.error('e', "invalid URI: " + th.getMessage());
        }
    }

    static Path fixupStaticBaseUri(Path path) {
        if ((path = path.getAbsolute()) instanceof FilePath) {
            path = URIPath.valueOf(path.toURI());
        }
        return path;
    }

    public String getStaticBaseUri() {
        Path path = this.baseURI;
        if (path == null) {
            InPort port;
            Environment env = Environment.getCurrent();
            Object value = env.get(Symbol.make("", "base-uri"), null, null);
            if (value != null && !(value instanceof Path)) {
                path = URIPath.valueOf(value.toString());
            }
            if (path == null && (port = this.getPort()) != null && (path = port.getPath()) != null && !path.isPlainFile()) {
                path = null;
            }
            if (path == null) {
                path = Path.currentPath();
            }
            this.baseURI = path = XQParser.fixupStaticBaseUri(path);
        }
        return path.toString();
    }

    public String resolveAgainstBaseUri(String uri) {
        if (Path.uriSchemeSpecified(uri)) {
            return uri;
        }
        String base2 = this.getStaticBaseUri();
        Path basePath = Path.valueOf(base2);
        return basePath.resolve(uri).toString();
    }

    final int skipSpace() throws IOException, SyntaxException {
        return this.skipSpace(true);
    }

    final int skipSpace(boolean verticalToo) throws IOException, SyntaxException {
        int ch;
        do {
            if ((ch = this.read()) == 40) {
                if (!this.checkNext(':')) {
                    return 40;
                }
                this.skipComment();
                continue;
            }
            if (ch == 123) {
                ch = this.read();
                if (ch != 45) {
                    this.unread(ch);
                    return 123;
                }
                ch = this.read();
                if (ch != 45) {
                    this.unread(ch);
                    this.unread(45);
                    return 123;
                }
                this.skipOldComment();
                continue;
            }
            if (verticalToo ? ch < 0 || !Character.isWhitespace((char)ch) : ch != 32 && ch != 9) break;
        } while (true);
        return ch;
    }

    final void skipToSemicolon() throws IOException {
        int next;
        while ((next = this.read()) >= 0 && next != 59) {
        }
    }

    final void skipOldComment() throws IOException, SyntaxException {
        int seenDashes = 0;
        int startLine = this.getLineNumber() + 1;
        int startColumn = this.getColumnNumber() - 2;
        this.warnOldVersion("use (: :) instead of old-style comment {-- --}");
        do {
            int ch;
            if ((ch = this.read()) == 45) {
                ++seenDashes;
                continue;
            }
            if (ch == 125 && seenDashes >= 2) {
                return;
            }
            if (ch < 0) {
                this.curLine = startLine;
                this.curColumn = startColumn;
                this.eofError("non-terminated comment starting here");
                continue;
            }
            seenDashes = 0;
        } while (true);
    }

    final void skipComment() throws IOException, SyntaxException {
        ++this.commentCount;
        int startLine = this.getLineNumber() + 1;
        int startColumn = this.getColumnNumber() - 1;
        if (this.errorIfComment != null) {
            this.curLine = startLine;
            this.curColumn = startColumn;
            this.error('e', this.errorIfComment);
        }
        int prev = 0;
        int commentNesting = 0;
        char saveReadState = this.pushNesting(':');
        do {
            int ch;
            if ((ch = this.read()) == 58) {
                if (prev == 40) {
                    ++commentNesting;
                    ch = 0;
                }
            } else if (ch == 41 && prev == 58) {
                if (commentNesting == 0) {
                    this.popNesting(saveReadState);
                    return;
                }
                --commentNesting;
            } else if (ch < 0) {
                this.curLine = startLine;
                this.curColumn = startColumn;
                this.eofError("non-terminated comment starting here");
            }
            prev = ch;
        } while (true);
    }

    final int peekNonSpace(String message) throws IOException, SyntaxException {
        int ch = this.skipSpace();
        if (ch < 0) {
            this.eofError(message);
        }
        this.unread(ch);
        return ch;
    }

    @Override
    public void mark() throws IOException {
        super.mark();
        this.saveToken = this.curToken;
        this.saveValue = this.curValue;
    }

    @Override
    public void reset() throws IOException {
        this.curToken = this.saveToken;
        this.curValue = this.saveValue;
        super.reset();
    }

    private int setToken(int token, int width) {
        this.curToken = token;
        this.curLine = this.port.getLineNumber() + 1;
        this.curColumn = this.port.getColumnNumber() + 1 - width;
        return token;
    }

    void checkSeparator(char ch) {
        if (XName.isNameStart(ch)) {
            this.error('e', "missing separator", "XPST0003");
        }
    }

    int getRawToken() throws IOException, SyntaxException {
        int next;
        do {
            if ((next = this.readUnicodeChar()) < 0) {
                return this.setToken(-1, 0);
            }
            if (next == 10 || next == 13) {
                if (this.nesting > 0) continue;
                return this.setToken(10, 0);
            }
            if (next == 40) {
                if (this.checkNext(':')) {
                    this.skipComment();
                    continue;
                }
                if (this.checkNext('#')) {
                    return this.setToken(197, 2);
                }
                return this.setToken(40, 1);
            }
            if (next == 123) {
                if (!this.checkNext('-')) {
                    return this.setToken(123, 1);
                }
                next = this.read();
                if (next != 45) {
                    this.unread();
                    this.unread();
                    return this.setToken(123, 1);
                }
                this.skipOldComment();
                continue;
            }
            if (next != 32 && next != 9) break;
        } while (true);
        this.tokenBufferLength = 0;
        this.curLine = this.port.getLineNumber() + 1;
        this.curColumn = this.port.getColumnNumber();
        int ch = next;
        switch (ch) {
            case 36: 
            case 41: 
            case 44: 
            case 59: 
            case 63: 
            case 64: 
            case 91: 
            case 93: 
            case 125: {
                break;
            }
            case 58: {
                if (this.checkNext('=')) {
                    ch = 76;
                    break;
                }
                if (!this.checkNext(':')) break;
                ch = 88;
                break;
            }
            case 124: {
                ch = 419;
                break;
            }
            case 42: {
                ch = 415;
                break;
            }
            case 43: {
                ch = 413;
                break;
            }
            case 45: {
                ch = 414;
                break;
            }
            case 33: {
                if (!this.checkNext('=')) break;
                ch = 403;
                break;
            }
            case 47: {
                if (!this.checkNext('/')) break;
                ch = 68;
                break;
            }
            case 61: {
                if (this.checkNext('>')) {
                    ch = 82;
                }
                ch = 402;
                break;
            }
            case 62: {
                ch = this.checkNext('=') ? 407 : (this.checkNext('>') ? 410 : 405);
                break;
            }
            case 60: {
                ch = this.checkNext('=') ? 406 : (this.checkNext('<') ? 411 : 404);
                break;
            }
            case 34: 
            case 39: {
                char saveReadState = this.pushNesting((char)next);
                do {
                    if ((next = this.readUnicodeChar()) < 0) {
                        this.eofError("unexpected end-of-file in string starting here");
                    }
                    if (next == 38) {
                        this.parseEntityOrCharRef();
                        continue;
                    }
                    if (ch == next) {
                        next = this.peek();
                        if (ch != next) break;
                        next = this.read();
                    }
                    this.tokenBufferAppend(next);
                } while (true);
                this.popNesting(saveReadState);
                ch = 34;
                break;
            }
            default: {
                if (Character.isDigit((char)ch) || ch == 46 && Character.isDigit((char)this.peek())) {
                    boolean seenDot = ch == 46;
                    do {
                        this.tokenBufferAppend(ch);
                        next = this.read();
                        if (next < 0) break;
                        ch = (char)next;
                        if (ch == 46) {
                            if (seenDot) break;
                            seenDot = true;
                            continue;
                        }
                        if (!Character.isDigit((char)ch)) break;
                    } while (true);
                    if (next == 101 || next == 69) {
                        this.tokenBufferAppend((char)next);
                        next = this.read();
                        if (next == 43 || next == 45) {
                            this.tokenBufferAppend(next);
                            next = this.read();
                        }
                        int expDigits = 0;
                        while (next >= 0) {
                            ch = (char)next;
                            if (!Character.isDigit((char)ch)) {
                                this.checkSeparator((char)ch);
                                this.unread();
                                break;
                            }
                            this.tokenBufferAppend(ch);
                            next = this.read();
                            ++expDigits;
                        }
                        if (expDigits == 0) {
                            this.error('e', "no digits following exponent", "XPST0003");
                        }
                        ch = 50;
                        break;
                    }
                    int n = ch = seenDot ? 49 : 48;
                    if (next < 0) break;
                    this.checkSeparator((char)next);
                    this.unread(next);
                    break;
                }
                if (ch == 46) {
                    if (!this.checkNext('.')) break;
                    ch = 51;
                    break;
                }
                if (XName.isNameStart(ch)) {
                    do {
                        this.tokenBufferAppend(ch);
                    } while (XName.isNamePart(ch = (int)((char)(next = this.read()))));
                    if (next < 0) {
                        ch = 65;
                        break;
                    }
                    if (next != 58) {
                        ch = 65;
                    } else {
                        next = this.read();
                        if (next < 0) {
                            this.eofError("unexpected end-of-file after NAME ':'");
                        }
                        if (XName.isNameStart(ch = (int)((char)next))) {
                            this.tokenBufferAppend(58);
                            do {
                                this.tokenBufferAppend(ch);
                            } while (XName.isNamePart(ch = (int)((char)(next = this.read()))));
                            ch = 81;
                        } else if (ch == 61) {
                            this.unread(ch);
                            ch = 65;
                        } else {
                            ch = 67;
                        }
                    }
                    this.unread(next);
                    break;
                }
                if (ch >= 32 && ch < 127) {
                    this.syntaxError("invalid character '" + (char)ch + '\'');
                    break;
                }
                this.syntaxError("invalid character '\\u" + Integer.toHexString(ch) + '\'');
            }
        }
        this.curToken = ch;
        return ch;
    }

    public void getDelimited(String delimiter) throws IOException, SyntaxException {
        if (!this.readDelimited(delimiter)) {
            this.eofError("unexpected end-of-file looking for '" + delimiter + '\'');
        }
    }

    public void appendNamedEntity(String name) {
        name = name.intern();
        int ch = 63;
        if (name == "lt") {
            ch = 60;
        } else if (name == "gt") {
            ch = 62;
        } else if (name == "amp") {
            ch = 38;
        } else if (name == "quot") {
            ch = 34;
        } else if (name == "apos") {
            ch = 39;
        } else {
            this.error("unknown enity reference: '" + name + "'");
        }
        this.tokenBufferAppend(ch);
    }

    boolean match(String word1, String word2, boolean force) throws IOException, SyntaxException {
        if (this.match(word1)) {
            this.mark();
            this.getRawToken();
            if (this.match(word2)) {
                this.reset();
                this.getRawToken();
                return true;
            }
            this.reset();
            if (force) {
                this.error('e', "'" + word1 + "' must be followed by '" + word2 + "'", "XPST0003");
                return true;
            }
        }
        return false;
    }

    int peekOperator() throws IOException, SyntaxException {
        while (this.curToken == 10) {
            if (this.nesting == 0) {
                return 10;
            }
            this.getRawToken();
        }
        if (this.curToken == 65) {
            int len = this.tokenBufferLength;
            switch (len) {
                case 2: {
                    char c1 = this.tokenBuffer[0];
                    char c2 = this.tokenBuffer[1];
                    if (c1 == 'o' && c2 == 'r') {
                        this.curToken = 400;
                        break;
                    }
                    if (c1 == 't' && c2 == 'o') {
                        this.curToken = 412;
                        break;
                    }
                    if (c1 == 'i' && c2 == 's') {
                        this.curToken = 408;
                        break;
                    }
                    if (c1 == 'e' && c2 == 'q') {
                        this.curToken = 426;
                        break;
                    }
                    if (c1 == 'n' && c2 == 'e') {
                        this.curToken = 427;
                        break;
                    }
                    if (c1 == 'g') {
                        if (c2 == 'e') {
                            this.curToken = 431;
                            break;
                        }
                        if (c2 != 't') break;
                        this.curToken = 430;
                        break;
                    }
                    if (c1 != 'l') break;
                    if (c2 == 'e') {
                        this.curToken = 429;
                        break;
                    }
                    if (c2 != 't') break;
                    this.curToken = 428;
                    break;
                }
                case 3: {
                    char c1 = this.tokenBuffer[0];
                    char c2 = this.tokenBuffer[1];
                    char c3 = this.tokenBuffer[2];
                    if (c1 == 'a') {
                        if (c2 != 'n' || c3 != 'd') break;
                        this.curToken = 401;
                        break;
                    }
                    if (c1 == 'm') {
                        if (c2 == 'u' && c3 == 'l') {
                            this.curToken = 415;
                        }
                        if (c2 != 'o' || c3 != 'd') break;
                        this.curToken = 418;
                        break;
                    }
                    if (c1 != 'd' || c2 != 'i' || c3 != 'v') break;
                    this.curToken = 416;
                    break;
                }
                case 4: {
                    if (this.match("idiv")) {
                        this.curToken = 417;
                        break;
                    }
                    if (!this.match("cast", "as", true)) break;
                    this.curToken = 425;
                    break;
                }
                case 5: {
                    if (this.match("where")) {
                        this.curToken = 196;
                        break;
                    }
                    if (this.match("isnot")) {
                        this.curToken = 409;
                        break;
                    }
                    if (this.match("union")) {
                        this.curToken = 419;
                        break;
                    }
                    if (!this.match("treat", "as", true)) break;
                    this.curToken = 423;
                    break;
                }
                case 6: {
                    if (!this.match("except")) break;
                    this.curToken = 421;
                    break;
                }
                case 8: {
                    if (this.match("instance", "of", true)) {
                        this.curToken = 422;
                        break;
                    }
                    if (!this.match("castable", "as", true)) break;
                    this.curToken = 424;
                    break;
                }
                case 9: {
                    if (!this.match("intersect")) break;
                    this.curToken = 420;
                    break;
                }
                case 10: {
                    if (!this.match("instanceof")) break;
                    this.warnOldVersion("use 'instanceof of' (two words) instead of 'instanceof'");
                    this.curToken = 422;
                    break;
                }
            }
        }
        return this.curToken;
    }

    private boolean lookingAt(String word0, String word1) throws IOException, SyntaxException {
        int ch;
        if (!word0.equals(this.curValue)) {
            return false;
        }
        int i = 0;
        int len = word1.length();
        do {
            ch = this.read();
            if (i != len) continue;
            if (ch < 0) {
                return true;
            }
            if (!XName.isNamePart((char)ch)) {
                this.unread();
                return true;
            }
            ++i;
            break;
        } while (ch >= 0 && ch == word1.charAt(i++));
        this.port.skip(-i);
        return false;
    }

    int getAxis() {
        String name = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
        int i = 13;
        while (--i >= 0 && axisNames[i] != name) {
        }
        if (i < 0 || i == 8) {
            this.error('e', "unknown axis name '" + name + '\'', "XPST0003");
            i = 3;
        }
        return (char)(100 + i);
    }

    int peekOperand() throws IOException, SyntaxException {
        while (this.curToken == 10) {
            this.getRawToken();
        }
        if (this.curToken == 65 || this.curToken == 81) {
            int next = this.skipSpace(this.nesting != 0);
            switch (this.tokenBuffer[0]) {
                case 'a': {
                    if (!this.match("attribute")) break;
                    if (next == 40) {
                        this.curToken = 236;
                        return 236;
                    }
                    if (next != 123 && !XName.isNameStart((char)next)) break;
                    this.unread();
                    this.curToken = 252;
                    return 252;
                }
                case 'c': {
                    if (!this.match("comment")) break;
                    if (next == 40) {
                        this.curToken = 232;
                        return 232;
                    }
                    if (next != 123) break;
                    this.unread();
                    this.curToken = 254;
                    return 254;
                }
                case 'd': {
                    if (next == 123 && this.match("document")) {
                        this.unread();
                        this.curToken = 256;
                        return 256;
                    }
                    if (next != 40 || !this.match("document-node")) break;
                    this.curToken = 234;
                    return 234;
                }
                case 'e': {
                    if (this.match("element")) {
                        if (next == 40) {
                            this.curToken = 235;
                            return 235;
                        }
                        if (next != 123 && !XName.isNameStart((char)next)) break;
                        this.unread();
                        this.curToken = 251;
                        return 251;
                    }
                    if (next == 40 && this.match("empty-sequence")) {
                        this.curToken = 238;
                        return 238;
                    }
                    if (next != 36 || !this.match("every")) break;
                    this.curToken = 246;
                    return 246;
                }
                case 'f': {
                    if (next != 36 || !this.match("for")) break;
                    this.curToken = 243;
                    return 243;
                }
                case 'i': {
                    if (next == 40 && this.match("if")) {
                        this.curToken = 241;
                        return 241;
                    }
                    if (next != 40 || !this.match("item")) break;
                    this.curToken = 237;
                    return 237;
                }
                case 'l': {
                    if (next != 36 || !this.match("let")) break;
                    this.curToken = 244;
                    return 244;
                }
                case 'n': {
                    if (next != 40 || !this.match("node")) break;
                    this.curToken = 230;
                    return 230;
                }
                case 'o': {
                    if (next != 123 || !this.match("ordered")) break;
                    this.curToken = 249;
                    return 249;
                }
                case 'p': {
                    if (!this.match("processing-instruction")) break;
                    if (next == 40) {
                        this.curToken = 233;
                        return 233;
                    }
                    if (next != 123 && !XName.isNameStart((char)next)) break;
                    this.unread();
                    this.curToken = 255;
                    return 255;
                }
                case 's': {
                    if (next == 36 && this.match("some")) {
                        this.curToken = 245;
                        return 245;
                    }
                    if (next == 40 && this.match("schema-attribute")) {
                        this.curToken = 239;
                        return 239;
                    }
                    if (next != 40 || !this.match("schema-element")) break;
                    this.curToken = 240;
                    return 240;
                }
                case 't': {
                    if (this.match("text")) {
                        if (next == 40) {
                            this.curToken = 231;
                            return 231;
                        }
                        if (next == 123) {
                            this.unread();
                            this.curToken = 253;
                            return 253;
                        }
                    }
                    if (next != 40 || !this.match("typeswitch")) break;
                    this.curToken = 242;
                    return 242;
                }
                case 'u': {
                    if (next != 123 || !this.match("unordered")) break;
                    this.curToken = 250;
                    return 250;
                }
                case 'v': {
                    if (next != 123 || !this.match("validate")) break;
                    this.curToken = 248;
                    return 248;
                }
            }
            if (next == 40 && this.peek() != 58) {
                this.curToken = 70;
                return 70;
            }
            if (next == 58 && this.peek() == 58) {
                this.curToken = this.getAxis();
                return this.curToken;
            }
            String name = new String(this.tokenBuffer, 0, this.tokenBufferLength);
            this.curValue = name;
            switch (next) {
                case 98: {
                    if (this.lookingAt("declare", "ase-uri")) {
                        this.curToken = 66;
                        return 66;
                    }
                    if (!this.lookingAt("declare", "oundary-space")) break;
                    this.curToken = 83;
                    return 83;
                }
                case 99: {
                    if (this.lookingAt("declare", "onstruction")) {
                        this.curToken = 75;
                        return 75;
                    }
                    if (!this.lookingAt("declare", "opy-namespaces")) break;
                    this.curToken = 76;
                    return 76;
                }
                case 100: {
                    if (this.lookingAt("declare", "efault")) {
                        this.getRawToken();
                        if (this.match("function")) {
                            this.curToken = 79;
                            return 79;
                        }
                        if (this.match("element")) {
                            this.curToken = 69;
                            return 69;
                        }
                        if (this.match("collation")) {
                            this.curToken = 71;
                            return 71;
                        }
                        if (this.match("order")) {
                            this.curToken = 72;
                            return 72;
                        }
                        this.error("unrecognized/unimplemented 'declare default'");
                        this.skipToSemicolon();
                        return this.peekOperand();
                    }
                }
                case 101: {
                    if (!this.lookingAt("default", "lement")) break;
                    this.warnOldVersion("replace 'default element' by 'declare default element namespace'");
                    this.curToken = 69;
                    return 69;
                }
                case 102: {
                    if (this.lookingAt("declare", "unction")) {
                        this.curToken = 80;
                        return 80;
                    }
                    if (this.lookingAt("define", "unction")) {
                        this.warnOldVersion("replace 'define function' by 'declare function'");
                        this.curToken = 80;
                        return 80;
                    }
                    if (!this.lookingAt("default", "unction")) break;
                    this.warnOldVersion("replace 'default function' by 'declare default function namespace'");
                    this.curToken = 79;
                    return 79;
                }
                case 109: {
                    if (!this.lookingAt("import", "odule")) break;
                    this.curToken = 73;
                    return 73;
                }
                case 110: {
                    if (this.lookingAt("declare", "amespace")) {
                        this.curToken = 78;
                        return 78;
                    }
                    if (this.lookingAt("default", "amespace")) {
                        this.warnOldVersion("replace 'default namespace' by 'declare default element namespace'");
                        this.curToken = 69;
                        return 69;
                    }
                    if (!this.lookingAt("module", "amespace")) break;
                    this.curToken = 77;
                    return 77;
                }
                case 111: {
                    if (this.lookingAt("declare", "rdering")) {
                        this.curToken = 85;
                        return 85;
                    }
                    if (!this.lookingAt("declare", "ption")) break;
                    this.curToken = 111;
                    return 111;
                }
                case 115: {
                    if (!this.lookingAt("import", "chema")) break;
                    this.curToken = 84;
                    return 84;
                }
                case 118: {
                    if (this.lookingAt("declare", "ariable")) {
                        this.curToken = 86;
                        return 86;
                    }
                    if (this.lookingAt("define", "ariable")) {
                        this.warnOldVersion("replace 'define variable' by 'declare variable'");
                        this.curToken = 86;
                        return 86;
                    }
                    if (!this.lookingAt("xquery", "ersion")) break;
                    this.curToken = 89;
                    return 89;
                }
                case 120: {
                    if (!this.lookingAt("declare", "mlspace")) break;
                    this.warnOldVersion("replace 'define xmlspace' by 'declare boundary-space'");
                    this.curToken = 83;
                    return 83;
                }
            }
            if (next >= 0) {
                this.unread();
                if (XName.isNameStart((char)next) && this.curValue.equals("define")) {
                    this.getRawToken();
                    this.curToken = 87;
                }
            }
            return this.curToken;
        }
        if (this.curToken == 67) {
            int next = this.read();
            if (next == 58) {
                this.curToken = this.getAxis();
            } else {
                this.unread(next);
            }
        }
        return this.curToken;
    }

    void checkAllowedNamespaceDeclaration(String prefix, String uri, boolean inConstructor) {
        boolean xmlPrefix = "xml".equals(prefix);
        if ("http://www.w3.org/XML/1998/namespace".equals(uri)) {
            if (!xmlPrefix || !inConstructor) {
                this.error('e', "namespace uri cannot be the same as the prefined xml namespace", "XQST0070");
            }
        } else if (xmlPrefix || "xmlns".equals(prefix)) {
            this.error('e', "namespace prefix cannot be 'xml' or 'xmlns'", "XQST0070");
        }
    }

    void pushNamespace(String prefix, String uri) {
        if (uri.length() == 0) {
            uri = null;
        }
        this.prologNamespaces = new NamespaceBinding(prefix, uri, this.prologNamespaces);
    }

    public XQParser(InPort port, SourceMessages messages, XQuery interp) {
        NamespaceBinding ns;
        super(port, messages);
        this.interpreter = interp;
        this.nesting = 1;
        this.prologNamespaces = ns = builtinNamespaces;
    }

    @Override
    public void setInteractive(boolean v) {
        if (this.isInteractive() != v) {
            this.nesting = v ? --this.nesting : ++this.nesting;
        }
        super.setInteractive(v);
    }

    private static final int priority(int opcode) {
        switch (opcode) {
            case 400: {
                return 1;
            }
            case 401: {
                return 2;
            }
            case 402: 
            case 403: 
            case 404: 
            case 405: 
            case 406: 
            case 407: 
            case 408: 
            case 409: 
            case 410: 
            case 411: 
            case 426: 
            case 427: 
            case 428: 
            case 429: 
            case 430: 
            case 431: {
                return 3;
            }
            case 412: {
                return 4;
            }
            case 413: 
            case 414: {
                return 5;
            }
            case 415: 
            case 416: 
            case 417: 
            case 418: {
                return 6;
            }
            case 419: {
                return 7;
            }
            case 420: 
            case 421: {
                return 8;
            }
            case 422: {
                return 9;
            }
            case 423: {
                return 10;
            }
            case 424: {
                return 11;
            }
            case 425: {
                return 12;
            }
        }
        return 0;
    }

    static Expression makeBinary(Expression func, Expression exp1, Expression exp2) {
        Expression[] args = new Expression[]{exp1, exp2};
        return new ApplyExp(func, args);
    }

    static Expression makeExprSequence(Expression exp1, Expression exp2) {
        return new ApplyExp(AppendValues.appendValues, exp1, exp2);
    }

    Expression makeBinary(int op, Expression exp1, Expression exp2) throws IOException, SyntaxException {
        Expression func;
        switch (op) {
            case 413: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.ArithOp", "add", "+");
                break;
            }
            case 414: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.ArithOp", "sub", "-");
                break;
            }
            case 415: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.ArithOp", "mul", "*");
                break;
            }
            case 416: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.ArithOp", "div", "div");
                break;
            }
            case 417: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.ArithOp", "idiv", "idiv");
                break;
            }
            case 418: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.ArithOp", "mod", "mod");
                break;
            }
            case 426: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "valEq", "eq");
                break;
            }
            case 427: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "valNe", "ne");
                break;
            }
            case 428: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "valLt", "lt");
                break;
            }
            case 429: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "valLe", "le");
                break;
            }
            case 430: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "valGt", "gt");
                break;
            }
            case 431: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "valGe", "ge");
                break;
            }
            case 402: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "=");
                break;
            }
            case 403: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "!=");
                break;
            }
            case 404: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "<");
                break;
            }
            case 406: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", "<=");
                break;
            }
            case 405: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", ">");
                break;
            }
            case 407: {
                func = XQParser.makeFunctionExp("gnu.xquery.util.Compare", ">=");
                break;
            }
            case 408: {
                func = XQParser.makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Eq", "is");
                break;
            }
            case 409: {
                func = XQParser.makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Ne", "isnot");
                break;
            }
            case 410: {
                func = XQParser.makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Gr", ">>");
                break;
            }
            case 411: {
                func = XQParser.makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Ls", "<<");
                break;
            }
            case 412: {
                func = XQParser.makeFunctionExp("kawa.lib.xquery.Xutils", "integerRange");
                break;
            }
            case 419: {
                func = XQParser.makeFunctionExp("gnu.kawa.xml.UnionNodes", "unionNodes");
                break;
            }
            case 420: {
                func = XQParser.makeFunctionExp("gnu.kawa.xml.IntersectNodes", "intersectNodes");
                break;
            }
            case 421: {
                func = XQParser.makeFunctionExp("gnu.kawa.xml.IntersectNodes", "exceptNodes");
                break;
            }
            default: {
                return this.syntaxError("unimplemented binary op: " + op);
            }
        }
        return XQParser.makeBinary(func, exp1, exp2);
    }

    private void parseSimpleKindType() throws IOException, SyntaxException {
        this.getRawToken();
        if (this.curToken == 41) {
            this.getRawToken();
        } else {
            this.error("expected ')'");
        }
    }

    public Expression parseNamedNodeType(boolean attribute) throws IOException, SyntaxException {
        Expression qname;
        Expression tname = null;
        this.getRawToken();
        if (this.curToken == 41) {
            qname = QuoteExp.getInstance(ElementType.MATCH_ANY_QNAME);
            this.getRawToken();
        } else {
            if (this.curToken == 81 || this.curToken == 65) {
                qname = this.parseNameTest(attribute);
            } else {
                if (this.curToken != 415) {
                    this.syntaxError("expected QName or *");
                }
                qname = QuoteExp.getInstance(ElementType.MATCH_ANY_QNAME);
            }
            this.getRawToken();
            if (this.curToken == 44) {
                this.getRawToken();
                if (this.curToken == 81 || this.curToken == 65) {
                    tname = this.parseDataType();
                } else {
                    this.syntaxError("expected QName");
                }
            }
            if (this.curToken == 41) {
                this.getRawToken();
            } else {
                this.error("expected ')' after element");
            }
        }
        return XQParser.makeNamedNodeType(attribute, qname, tname);
    }

    static Expression makeNamedNodeType(boolean attribute, Expression qname, Expression tname) {
        Expression[] name = new Expression[2];
        ClassType nodeType = ClassType.make(attribute ? "gnu.kawa.xml.AttributeType" : "gnu.kawa.xml.ElementType");
        ApplyExp elt = new ApplyExp(nodeType.getDeclaredMethod("make", 1), qname);
        elt.setFlag(4);
        if (tname == null) {
            return elt;
        }
        return new BeginExp(tname, elt);
    }

    private void warnOldStyleKindTest() {
        if (this.warnedOldStyleKindTest) {
            return;
        }
        this.error('w', "old-style KindTest - first one here");
        this.warnedOldStyleKindTest = true;
    }

    public Expression parseOptionalTypeDeclaration() throws IOException, SyntaxException {
        if (!this.match("as")) {
            return null;
        }
        this.getRawToken();
        return this.parseDataType();
    }

    public Expression parseDataType() throws IOException, SyntaxException {
        int max;
        int min;
        Expression etype = this.parseItemType();
        if (etype == null) {
            if (this.curToken != 238) {
                return this.syntaxError("bad syntax - expected DataType");
            }
            this.parseSimpleKindType();
            if (this.curToken == 63 || this.curToken == 413 || this.curToken == 415) {
                this.getRawToken();
                return this.syntaxError("occurrence-indicator meaningless after empty-sequence()");
            }
            etype = QuoteExp.getInstance(OccurrenceType.emptySequenceType);
            min = 0;
            max = 0;
        } else if (this.curToken == 63) {
            min = 0;
            max = 1;
        } else if (this.curToken == 413) {
            min = 1;
            max = -1;
        } else if (this.curToken == 415) {
            min = 0;
            max = -1;
        } else {
            min = 1;
            max = 1;
        }
        if (this.parseContext == 67 && max != 1) {
            return this.syntaxError("type to 'cast as' or 'castable as' must be a 'SingleType'");
        }
        if (min != max) {
            this.getRawToken();
            Expression[] args = new Expression[]{etype, QuoteExp.getInstance(IntNum.make(min)), QuoteExp.getInstance(IntNum.make(max))};
            ApplyExp otype = new ApplyExp(proc_OccurrenceType_getInstance, args);
            otype.setFlag(4);
            return otype;
        }
        return etype;
    }

    public Expression parseMaybeKindTest() throws IOException, SyntaxException {
        NodeType type;
        switch (this.curToken) {
            case 235: 
            case 236: {
                return this.parseNamedNodeType(this.curToken == 236);
            }
            case 231: {
                this.parseSimpleKindType();
                type = NodeType.textNodeTest;
                break;
            }
            case 232: {
                this.parseSimpleKindType();
                type = NodeType.commentNodeTest;
                break;
            }
            case 234: {
                this.parseSimpleKindType();
                type = NodeType.documentNodeTest;
                break;
            }
            case 230: {
                this.parseSimpleKindType();
                type = NodeType.anyNodeTest;
                break;
            }
            case 233: {
                this.getRawToken();
                String piTarget = null;
                if (this.curToken == 65 || this.curToken == 34) {
                    piTarget = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                    this.getRawToken();
                }
                if (this.curToken == 41) {
                    this.getRawToken();
                } else {
                    this.error("expected ')'");
                }
                type = ProcessingInstructionType.getInstance(piTarget);
                break;
            }
            default: {
                return null;
            }
        }
        return QuoteExp.getInstance(type);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Expression parseItemType() throws IOException, SyntaxException {
        this.peekOperand();
        Expression etype = this.parseMaybeKindTest();
        if (etype != null) {
            if (this.parseContext != 67) return etype;
            XDataType type = XDataType.anyAtomicType;
            return QuoteExp.getInstance(type);
        } else if (this.curToken == 237) {
            this.parseSimpleKindType();
            SingletonType type = SingletonType.getInstance();
            return QuoteExp.getInstance(type);
        } else {
            if (this.curToken != 65 && this.curToken != 81) return null;
            String tname = new String(this.tokenBuffer, 0, this.tokenBufferLength);
            ReferenceExp rexp = new ReferenceExp(tname);
            rexp.setFlag(16);
            this.maybeSetLine(rexp, this.curLine, this.curColumn);
            this.getRawToken();
            return rexp;
        }
    }

    Object parseURILiteral() throws IOException, SyntaxException {
        this.getRawToken();
        if (this.curToken != 34) {
            return this.declError("expected a URILiteral");
        }
        String str = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        str = TextUtils.replaceWhitespace(str, true);
        return str;
    }

    Expression parseExpr() throws IOException, SyntaxException {
        return this.parseExprSingle();
    }

    final Expression parseExprSingle() throws IOException, SyntaxException {
        int startLine = this.curLine;
        int startColumn = this.curColumn;
        this.peekOperand();
        switch (this.curToken) {
            case 241: {
                return this.parseIfExpr();
            }
            case 242: {
                return this.parseTypeSwitch();
            }
            case 243: {
                return this.parseFLWRExpression(true);
            }
            case 244: {
                return this.parseFLWRExpression(false);
            }
            case 245: {
                return this.parseQuantifiedExpr(false);
            }
            case 246: {
                return this.parseQuantifiedExpr(true);
            }
        }
        return this.parseBinaryExpr(XQParser.priority(400));
    }

    Expression parseBinaryExpr(int prio) throws IOException, SyntaxException {
        Expression exp = this.parseUnaryExpr();
        int token;
        while ((token = this.peekOperator()) != 10 && (token != 404 || this.peek() != 47)) {
            int tokPriority = XQParser.priority(token);
            if (tokPriority < prio) {
                return exp;
            }
            char saveReadState = this.pushNesting('%');
            this.getRawToken();
            this.popNesting(saveReadState);
            if (token >= 422 && token <= 425) {
                Expression func;
                if (token == 425 || token == 424) {
                    this.parseContext = 67;
                }
                Expression type = this.parseDataType();
                this.parseContext = 0;
                Expression[] args = new Expression[2];
                switch (token) {
                    case 422: {
                        args[0] = exp;
                        args[1] = type;
                        func = XQParser.makeFunctionExp("gnu.xquery.lang.XQParser", "instanceOf");
                        break;
                    }
                    case 424: {
                        args[0] = exp;
                        args[1] = type;
                        func = new ReferenceExp(XQResolveNames.castableAsDecl);
                        break;
                    }
                    case 423: {
                        args[0] = type;
                        args[1] = exp;
                        func = XQParser.makeFunctionExp("gnu.xquery.lang.XQParser", "treatAs");
                        break;
                    }
                    default: {
                        args[0] = type;
                        args[1] = exp;
                        func = new ReferenceExp(XQResolveNames.castAsDecl);
                    }
                }
                exp = new ApplyExp(func, args);
                continue;
            }
            if (token == 422) {
                Expression[] args = new Expression[]{exp, this.parseDataType()};
                exp = new ApplyExp(XQParser.makeFunctionExp("gnu.xquery.lang.XQParser", "instanceOf"), args);
                continue;
            }
            Expression exp2 = this.parseBinaryExpr(tokPriority + 1);
            if (token == 401) {
                exp = new IfExp(XQParser.booleanValue(exp), XQParser.booleanValue(exp2), XQuery.falseExp);
                continue;
            }
            if (token == 400) {
                exp = new IfExp(XQParser.booleanValue(exp), XQuery.trueExp, XQParser.booleanValue(exp2));
                continue;
            }
            exp = this.makeBinary(token, exp, exp2);
        }
        return exp;
    }

    Expression parseUnaryExpr() throws IOException, SyntaxException {
        Expression exp;
        if (this.curToken == 414 || this.curToken == 413) {
            int op = this.curToken;
            this.getRawToken();
            exp = this.parseUnaryExpr();
            Expression func = XQParser.makeFunctionExp("gnu.xquery.util.ArithOp", op == 413 ? "plus" : "minus", op == 413 ? "+" : "-");
            exp = new ApplyExp(func, exp);
        } else {
            exp = this.parseUnionExpr();
        }
        return exp;
    }

    Expression parseUnionExpr() throws IOException, SyntaxException {
        int op;
        Expression exp = this.parseIntersectExceptExpr();
        while ((op = this.peekOperator()) == 419) {
            this.getRawToken();
            Expression exp2 = this.parseIntersectExceptExpr();
            exp = this.makeBinary(op, exp, exp2);
        }
        return exp;
    }

    Expression parseIntersectExceptExpr() throws IOException, SyntaxException {
        int op;
        Expression exp = this.parsePathExpr();
        while ((op = this.peekOperator()) == 420 || op == 421) {
            this.getRawToken();
            Expression exp2 = this.parsePathExpr();
            exp = this.makeBinary(op, exp, exp2);
        }
        return exp;
    }

    Expression parsePathExpr() throws IOException, SyntaxException {
        Expression step1;
        if (this.curToken == 47 || this.curToken == 68) {
            Declaration dotDecl = this.comp.lexical.lookup((Object)DOT_VARNAME, false);
            Expression dot = dotDecl == null ? this.syntaxError("context item is undefined", "XPDY0002") : new ReferenceExp(DOT_VARNAME, dotDecl);
            step1 = new ApplyExp(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("rootDocument", 1), dot);
            int next = this.skipSpace(this.nesting != 0);
            this.unread(next);
            if (next < 0 || next == 41 || next == 125) {
                this.getRawToken();
                return step1;
            }
        } else {
            step1 = this.parseStepExpr();
        }
        return this.parseRelativePathExpr(step1);
    }

    Expression parseNameTest(boolean attribute) throws IOException, SyntaxException {
        String local = null;
        String prefix = null;
        if (this.curToken == 81) {
            int colon = this.tokenBufferLength;
            while (this.tokenBuffer[--colon] != ':') {
            }
            prefix = new String(this.tokenBuffer, 0, colon);
            local = new String(this.tokenBuffer, ++colon, this.tokenBufferLength - colon);
        } else {
            if (this.curToken == 415) {
                int next = this.read();
                local = "";
                if (next != 58) {
                    this.unread(next);
                } else {
                    next = this.read();
                    if (next < 0) {
                        this.eofError("unexpected end-of-file after '*:'");
                    }
                    if (XName.isNameStart((char)next)) {
                        this.unread();
                        this.getRawToken();
                        if (this.curToken != 65) {
                            this.syntaxError("invalid name test");
                        } else {
                            local = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
                        }
                    } else if (next != 42) {
                        this.syntaxError("missing local-name after '*:'");
                    }
                }
                return QuoteExp.getInstance(Symbol.makeUninterned(local));
            }
            if (this.curToken == 65) {
                local = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                if (attribute) {
                    return new QuoteExp(Namespace.EmptyNamespace.getSymbol(local.intern()));
                }
                prefix = null;
            } else if (this.curToken == 67) {
                prefix = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                int next = this.read();
                if (next != 42) {
                    this.syntaxError("invalid characters after 'NCName:'");
                }
                local = "";
            }
        }
        if (prefix != null) {
            prefix = prefix.intern();
        }
        Expression[] args = new Expression[]{new ApplyExp(new ReferenceExp(XQResolveNames.resolvePrefixDecl), QuoteExp.getInstance(prefix)), new QuoteExp(local == null ? "" : local), new QuoteExp(prefix)};
        ApplyExp make2 = new ApplyExp(Compilation.typeSymbol.getDeclaredMethod("make", 3), args);
        make2.setFlag(4);
        return make2;
    }

    Expression parseNodeTest(int axis) throws IOException, SyntaxException {
        QuoteExp makeAxisStep;
        int token = this.peekOperand();
        Expression[] args = new Expression[1];
        Expression etype = this.parseMaybeKindTest();
        if (etype != null) {
            args[0] = etype;
        } else if (this.curToken == 65 || this.curToken == 81 || this.curToken == 67 || this.curToken == 415) {
            args[0] = XQParser.makeNamedNodeType(axis == 2, this.parseNameTest(axis == 2), null);
        } else {
            if (axis >= 0) {
                return this.syntaxError("unsupported axis '" + axisNames[axis] + "::'");
            }
            return null;
        }
        Declaration dotDecl = this.comp.lexical.lookup((Object)DOT_VARNAME, false);
        Expression dot = dotDecl == null ? this.syntaxError("node test when context item is undefined", "XPDY0002") : new ReferenceExp(DOT_VARNAME, dotDecl);
        if (etype == null) {
            this.getRawToken();
        }
        if (axis == 3 || axis == -1) {
            makeAxisStep = makeChildAxisStep;
        } else if (axis == 4) {
            makeAxisStep = makeDescendantAxisStep;
        } else {
            String axisName;
            switch (axis) {
                case 5: {
                    axisName = "DescendantOrSelf";
                    break;
                }
                case 12: {
                    axisName = "Self";
                    break;
                }
                case 9: {
                    axisName = "Parent";
                    break;
                }
                case 0: {
                    axisName = "Ancestor";
                    break;
                }
                case 1: {
                    axisName = "AncestorOrSelf";
                    break;
                }
                case 6: {
                    axisName = "Following";
                    break;
                }
                case 7: {
                    axisName = "FollowingSibling";
                    break;
                }
                case 10: {
                    axisName = "Preceding";
                    break;
                }
                case 11: {
                    axisName = "PrecedingSibling";
                    break;
                }
                case 2: {
                    axisName = "Attribute";
                    break;
                }
                default: {
                    throw new Error();
                }
            }
            makeAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml." + axisName + "Axis", "make", 1));
        }
        ApplyExp mkAxis = new ApplyExp(makeAxisStep, args);
        mkAxis.setFlag(4);
        return new ApplyExp(mkAxis, dot);
    }

    Expression parseRelativePathExpr(Expression exp) throws IOException, SyntaxException {
        Expression beforeSlashSlash = null;
        while (this.curToken == 47 || this.curToken == 68) {
            boolean descendants = this.curToken == 68;
            LambdaExp lexp = new LambdaExp(3);
            Declaration dotDecl = lexp.addDeclaration(DOT_VARNAME);
            dotDecl.setFlag(262144L);
            dotDecl.setType(NodeType.anyNodeTest);
            dotDecl.noteValueUnknown();
            lexp.addDeclaration(POSITION_VARNAME, LangPrimType.intType);
            lexp.addDeclaration(LAST_VARNAME, LangPrimType.intType);
            this.comp.push(lexp);
            if (descendants) {
                this.curToken = 47;
                ReferenceExp dot = new ReferenceExp(DOT_VARNAME, dotDecl);
                Expression[] args = new Expression[]{dot};
                DescendantOrSelfAxis op = DescendantOrSelfAxis.anyNode;
                lexp.body = new ApplyExp(op, args);
                beforeSlashSlash = exp;
            } else {
                ApplyExp aexp;
                Expression func;
                this.getRawToken();
                Expression exp2 = this.parseStepExpr();
                if (beforeSlashSlash != null && exp2 instanceof ApplyExp && (func = ((ApplyExp)exp2).getFunction()) instanceof ApplyExp && (aexp = (ApplyExp)func).getFunction() == makeChildAxisStep) {
                    aexp.setFunction(makeDescendantAxisStep);
                    exp = beforeSlashSlash;
                }
                lexp.body = exp2;
                beforeSlashSlash = null;
            }
            this.comp.pop(lexp);
            Expression[] args = new Expression[]{exp, lexp};
            exp = new ApplyExp(RelativeStep.relativeStep, args);
        }
        return exp;
    }

    Expression parseStepExpr() throws IOException, SyntaxException {
        Expression unqualifiedStep;
        if (this.curToken == 46 || this.curToken == 51) {
            int axis = this.curToken == 46 ? 12 : 9;
            this.getRawToken();
            Declaration dotDecl = this.comp.lexical.lookup((Object)DOT_VARNAME, false);
            Expression exp = dotDecl == null ? this.syntaxError("context item is undefined", "XPDY0002") : new ReferenceExp(DOT_VARNAME, dotDecl);
            if (axis == 9) {
                Expression[] args = new Expression[]{exp};
                exp = new ApplyExp(ParentAxis.make(NodeType.anyNodeTest), args);
            }
            return this.parseStepQualifiers(exp, axis == 12 ? -1 : axis);
        }
        int axis = this.peekOperand() - 100;
        if (axis >= 0 && axis < 13) {
            this.getRawToken();
            unqualifiedStep = this.parseNodeTest(axis);
        } else if (this.curToken == 64) {
            this.getRawToken();
            axis = 2;
            unqualifiedStep = this.parseNodeTest(axis);
        } else if (this.curToken == 236) {
            axis = 2;
            unqualifiedStep = this.parseNodeTest(axis);
        } else {
            unqualifiedStep = this.parseNodeTest(-1);
            if (unqualifiedStep != null) {
                axis = 3;
            } else {
                axis = -1;
                unqualifiedStep = this.parsePrimaryExpr();
            }
        }
        return this.parseStepQualifiers(unqualifiedStep, axis);
    }

    Expression parseStepQualifiers(Expression exp, int axis) throws IOException, SyntaxException {
        while (this.curToken == 91) {
            ValuesFilter valuesFilter;
            int kind;
            int startLine = this.getLineNumber() + 1;
            int startColumn = this.getColumnNumber() + 1;
            int saveSeenPosition = this.seenPosition;
            int saveSawLast = this.seenLast;
            this.getRawToken();
            LambdaExp lexp = new LambdaExp(3);
            this.maybeSetLine(lexp, startLine, startColumn);
            Declaration dot = lexp.addDeclaration(DOT_VARNAME);
            if (axis >= 0) {
                dot.setType(NodeType.anyNodeTest);
            } else {
                dot.setType(SingletonType.getInstance());
            }
            lexp.addDeclaration(POSITION_VARNAME, Type.intType);
            lexp.addDeclaration(LAST_VARNAME, Type.intType);
            this.comp.push(lexp);
            dot.noteValueUnknown();
            Expression cond = this.parseExprSequence(93, false);
            if (this.curToken == -1) {
                this.eofError("missing ']' - unexpected end-of-file");
            }
            if (axis < 0) {
                kind = 80;
                valuesFilter = ValuesFilter.exprFilter;
            } else if (axis == 0 || axis == 1 || axis == 9 || axis == 10 || axis == 11) {
                kind = 82;
                valuesFilter = ValuesFilter.reverseFilter;
            } else {
                kind = 70;
                valuesFilter = ValuesFilter.forwardFilter;
            }
            this.maybeSetLine(cond, startLine, startColumn);
            this.comp.pop(lexp);
            lexp.body = cond;
            this.getRawToken();
            Expression[] args = new Expression[]{exp, lexp};
            exp = new ApplyExp(valuesFilter, args);
        }
        return exp;
    }

    Expression parsePrimaryExpr() throws IOException, SyntaxException {
        Expression exp = this.parseMaybePrimaryExpr();
        if (exp == null) {
            exp = this.syntaxError("missing expression");
            if (this.curToken != -1) {
                this.getRawToken();
            }
            return exp;
        }
        return exp;
    }

    void parseEntityOrCharRef() throws IOException, SyntaxException {
        int next = this.read();
        if (next == 35) {
            int base2;
            char ch;
            int value;
            int digit;
            next = this.read();
            if (next == 120) {
                base2 = 16;
                next = this.read();
            } else {
                base2 = 10;
            }
            for (value = 0; next >= 0 && (digit = Character.digit(ch = (char)next, base2)) >= 0 && value < 134217728; value += digit) {
                value *= base2;
                next = this.read();
            }
            if (next != 59) {
                this.unread();
                this.error("invalid character reference");
            } else if (value > 0 && value <= 55295 || value >= 57344 && value <= 65533 || value >= 65536 && value <= 1114111) {
                this.tokenBufferAppend(value);
            } else {
                this.error('e', "invalid character value " + value, "XQST0090");
            }
        } else {
            char ch;
            int saveLength = this.tokenBufferLength;
            while (next >= 0 && XName.isNamePart(ch = (char)next)) {
                this.tokenBufferAppend(ch);
                next = this.read();
            }
            if (next != 59) {
                this.unread();
                this.error("invalid entity reference");
                return;
            }
            String ref = new String(this.tokenBuffer, saveLength, this.tokenBufferLength - saveLength);
            this.tokenBufferLength = saveLength;
            this.appendNamedEntity(ref);
        }
    }

    void parseContent(char delimiter, Vector result) throws IOException, SyntaxException {
        boolean skipBoundarySpace;
        this.tokenBufferLength = 0;
        int startSize = result.size();
        int prevEnclosed = startSize - 1;
        boolean skippable = skipBoundarySpace = !this.boundarySpacePreserve && delimiter == '<';
        do {
            int next;
            block20 : {
                int postBrace;
                block23 : {
                    FString text;
                    block22 : {
                        block21 : {
                            if ((next = this.read()) == delimiter) {
                                if (delimiter == '<') {
                                    ApplyExp aexp;
                                    next = this.read();
                                    QuoteExp text2 = null;
                                    if (this.tokenBufferLength > 0) {
                                        FString str = new FString(this.tokenBuffer, 0, this.tokenBufferLength);
                                        text2 = new QuoteExp(str);
                                    }
                                    this.tokenBufferLength = 0;
                                    if (next == 47) {
                                        if (text2 == null || skippable) break;
                                        result.addElement(text2);
                                        break;
                                    }
                                    Expression content = this.parseXMLConstructor(next, true);
                                    boolean isCDATA = false;
                                    boolean emptyCDATA = false;
                                    if (content instanceof ApplyExp && (aexp = (ApplyExp)content).getFunction() == makeCDATA) {
                                        isCDATA = true;
                                        String str = (String)aexp.getArg(0).valueIfConstant();
                                        boolean bl = emptyCDATA = str != null && str.length() == 0;
                                    }
                                    if (text2 != null && (!skippable || isCDATA)) {
                                        result.addElement(text2);
                                    }
                                    skippable = isCDATA ? false : skipBoundarySpace;
                                    if (!emptyCDATA) {
                                        result.addElement(content);
                                    }
                                    this.tokenBufferLength = 0;
                                    continue;
                                }
                                if (this.checkNext(delimiter)) {
                                    this.tokenBufferAppend(delimiter);
                                    continue;
                                }
                            }
                            if (next != delimiter && next >= 0 && next != 123) break block20;
                            int n = postBrace = next == 123 ? this.read() : -1;
                            if (postBrace == 123) {
                                this.tokenBufferAppend(123);
                                skippable = false;
                                continue;
                            }
                            if (this.tokenBufferLength <= 0 || skippable) break block21;
                            text = new FString(this.tokenBuffer, 0, this.tokenBufferLength);
                            break block22;
                        }
                        if (next != 123 || prevEnclosed != result.size()) break block23;
                        text = new FString();
                    }
                    result.addElement(new QuoteExp(text));
                }
                this.tokenBufferLength = 0;
                if (next == delimiter) break;
                if (next < 0) {
                    this.eofError("unexpected end-of-file");
                    continue;
                }
                this.unread(postBrace);
                ++this.enclosedExpressionsSeen;
                Expression exp = this.parseEnclosedExpr();
                result.addElement(exp);
                this.tokenBufferLength = 0;
                prevEnclosed = result.size();
                skippable = skipBoundarySpace;
                continue;
            }
            if (next == 125) {
                next = this.read();
                if (next == 125) {
                    this.tokenBufferAppend(125);
                    skippable = false;
                    continue;
                }
                this.error("unexpected '}' in element content");
                this.unread(next);
                continue;
            }
            if (next == 38) {
                this.parseEntityOrCharRef();
                skippable = false;
                continue;
            }
            if (delimiter != '<' && (next == 9 || next == 10 || next == 13)) {
                next = 32;
            }
            if (next == 60) {
                this.error('e', "'<' must be quoted in a direct attribute value");
            }
            if (skippable) {
                skippable = Character.isWhitespace((char)next);
            }
            this.tokenBufferAppend((char)next);
        } while (true);
    }

    Expression parseEnclosedExpr() throws IOException, SyntaxException {
        String saveErrorIfComment = this.errorIfComment;
        this.errorIfComment = null;
        char saveReadState = this.pushNesting('{');
        this.peekNonSpace("unexpected end-of-file after '{'");
        int startLine = this.getLineNumber() + 1;
        int startColumn = this.getColumnNumber() + 1;
        this.getRawToken();
        Expression exp = this.parseExpr();
        while (this.curToken != 125) {
            if (this.curToken == -1 || this.curToken == 41 || this.curToken == 93) {
                exp = this.syntaxError("missing '}'");
                break;
            }
            if (this.curToken != 44) {
                exp = this.syntaxError("missing '}' or ','");
            } else {
                this.getRawToken();
            }
            exp = XQParser.makeExprSequence(exp, this.parseExpr());
        }
        this.maybeSetLine(exp, startLine, startColumn);
        this.popNesting(saveReadState);
        this.errorIfComment = saveErrorIfComment;
        return exp;
    }

    public static Expression booleanValue(Expression exp) {
        Expression[] args = new Expression[]{exp};
        Expression string = XQParser.makeFunctionExp("gnu.xquery.util.BooleanValue", "booleanValue");
        return new ApplyExp(string, args);
    }

    Expression parseXMLConstructor(int next, boolean inElementContent) throws IOException, SyntaxException {
        Expression exp;
        if (next == 33) {
            next = this.read();
            if (next == 45 && this.peek() == 45) {
                this.skip();
                this.getDelimited("-->");
                boolean bad = false;
                int i = this.tokenBufferLength;
                boolean sawHyphen = true;
                while (--i >= 0) {
                    boolean curHyphen;
                    boolean bl = curHyphen = this.tokenBuffer[i] == '-';
                    if (sawHyphen && curHyphen) {
                        bad = true;
                        break;
                    }
                    sawHyphen = curHyphen;
                }
                if (bad) {
                    exp = this.syntaxError("consecutive or final hyphen in XML comment");
                } else {
                    Expression[] args = new Expression[]{new QuoteExp(new String(this.tokenBuffer, 0, this.tokenBufferLength))};
                    exp = new ApplyExp(XQParser.makeFunctionExp("gnu.kawa.xml.CommentConstructor", "commentConstructor"), args);
                }
            } else if (next == 91 && this.read() == 67 && this.read() == 68 && this.read() == 65 && this.read() == 84 && this.read() == 65 && this.read() == 91) {
                if (!inElementContent) {
                    this.error('e', "CDATA section must be in element content");
                }
                this.getDelimited("]]>");
                Expression[] args = new Expression[]{new QuoteExp(new String(this.tokenBuffer, 0, this.tokenBufferLength))};
                exp = new ApplyExp(makeCDATA, args);
            } else {
                exp = this.syntaxError("'<!' must be followed by '--' or '[CDATA['");
            }
        } else if (next == 63) {
            int ch;
            next = this.peek();
            if (next < 0 || !XName.isNameStart((char)next) || this.getRawToken() != 65) {
                this.syntaxError("missing target after '<?'");
            }
            String target = new String(this.tokenBuffer, 0, this.tokenBufferLength);
            int nspaces = 0;
            while ((ch = this.read()) >= 0) {
                if (!Character.isWhitespace((char)ch)) {
                    this.unread();
                    break;
                }
                ++nspaces;
            }
            this.getDelimited("?>");
            if (nspaces == 0 && this.tokenBufferLength > 0) {
                this.syntaxError("target must be followed by space or '?>'");
            }
            String content = new String(this.tokenBuffer, 0, this.tokenBufferLength);
            Expression[] args = new Expression[]{new QuoteExp(target), new QuoteExp(content)};
            exp = new ApplyExp(XQParser.makeFunctionExp("gnu.kawa.xml.MakeProcInst", "makeProcInst"), args);
        } else if (next < 0 || !XName.isNameStart((char)next)) {
            exp = this.syntaxError("expected QName after '<'");
        } else {
            this.unread(next);
            this.getRawToken();
            char saveReadState = this.pushNesting('<');
            exp = this.parseElementConstructor();
            if (!inElementContent) {
                exp = this.wrapWithBaseUri(exp);
            }
            this.popNesting(saveReadState);
        }
        return exp;
    }

    static ApplyExp castQName(Expression value, boolean element) {
        Declaration fdecl = element ? XQResolveNames.xsQNameDecl : XQResolveNames.xsQNameIgnoreDefaultDecl;
        return new ApplyExp(new ReferenceExp(fdecl), value);
    }

    Expression parseElementConstructor() throws IOException, SyntaxException {
        Object[] args;
        int ch;
        String startTag = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        Vector<Expression> vec = new Vector<Expression>();
        vec.add(XQParser.castQName(new QuoteExp(startTag), true));
        this.errorIfComment = "comment not allowed in element start tag";
        NamespaceBinding nsBindings = null;
        do {
            boolean sawSpace = false;
            ch = this.read();
            while (ch >= 0 && Character.isWhitespace((char)ch)) {
                ch = this.read();
                sawSpace = true;
            }
            if (ch < 0 || ch == 62 || ch == 47) break;
            if (!sawSpace) {
                this.syntaxError("missing space before attribute");
            }
            this.unread(ch);
            this.getRawToken();
            int vecSize = vec.size();
            if (this.curToken != 65 && this.curToken != 81) break;
            String attrName = new String(this.tokenBuffer, 0, this.tokenBufferLength);
            int startLine = this.getLineNumber() + 1;
            int startColumn = this.getColumnNumber() + 1 - this.tokenBufferLength;
            String definingNamespace = null;
            if (this.curToken == 65) {
                if (attrName.equals("xmlns")) {
                    definingNamespace = "";
                }
            } else if (attrName.startsWith("xmlns:")) {
                definingNamespace = attrName.substring(6).intern();
            }
            QuoteExp makeAttr = definingNamespace != null ? null : MakeAttribute.makeAttributeExp;
            vec.addElement(XQParser.castQName(new QuoteExp(attrName), false));
            ch = this.skipSpace();
            if (ch != 61) {
                this.errorIfComment = null;
                return this.syntaxError("missing '=' after attribute");
            }
            ch = this.skipSpace();
            int enclosedExpressionsStart = this.enclosedExpressionsSeen;
            if (ch == 123) {
                this.warnOldVersion("enclosed attribute value expression should be quoted");
                vec.addElement(this.parseEnclosedExpr());
            } else {
                this.parseContent((char)ch, vec);
            }
            int n = vec.size() - vecSize;
            if (definingNamespace != null) {
                String ns = "";
                if (n == 1) {
                    ns = "";
                } else if (this.enclosedExpressionsSeen > enclosedExpressionsStart) {
                    this.syntaxError("enclosed expression not allowed in namespace declaration");
                } else {
                    ns = ((Expression)vec.get(vecSize + 1)).valueIfConstant().toString().intern();
                }
                vec.setSize(vecSize);
                this.checkAllowedNamespaceDeclaration(definingNamespace, ns, true);
                if (definingNamespace == "") {
                    definingNamespace = null;
                }
                for (NamespaceBinding nsb = nsBindings; nsb != null; nsb = nsb.getNext()) {
                    if (nsb.getPrefix() != definingNamespace) continue;
                    this.error('e', definingNamespace == null ? "duplicate default namespace declaration" : "duplicate namespace prefix '" + definingNamespace + '\'', "XQST0071");
                    break;
                }
                nsBindings = new NamespaceBinding(definingNamespace, ns == "" ? null : ns, nsBindings);
                continue;
            }
            args = new Expression[n];
            int i = n;
            while (--i >= 0) {
                args[i] = (Expression)vec.elementAt(vecSize + i);
            }
            vec.setSize(vecSize);
            ApplyExp aexp = new ApplyExp(makeAttr, (Expression[])args);
            this.maybeSetLine(aexp, startLine, startColumn);
            vec.addElement(aexp);
        } while (true);
        this.errorIfComment = null;
        boolean empty = false;
        if (ch == 47) {
            ch = this.read();
            if (ch == 62) {
                empty = true;
            } else {
                this.unread(ch);
            }
        }
        if (!empty) {
            if (ch != 62) {
                return this.syntaxError("missing '>' after start element");
            }
            this.parseContent('<', vec);
            ch = this.peek();
            if (ch >= 0) {
                if (!XName.isNameStart((char)ch)) {
                    return this.syntaxError("invalid tag syntax after '</'");
                }
                this.getRawToken();
                String tag = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                if (!tag.equals(startTag)) {
                    return this.syntaxError("'<" + startTag + ">' closed by '</" + tag + ">'");
                }
                this.errorIfComment = "comment not allowed in element end tag";
                ch = this.skipSpace();
                this.errorIfComment = null;
            }
            if (ch != 62) {
                return this.syntaxError("missing '>' after end element");
            }
        }
        args = new Expression[vec.size()];
        vec.copyInto(args);
        MakeElement mkElement = new MakeElement();
        mkElement.copyNamespacesMode = this.copyNamespacesMode;
        mkElement.setNamespaceNodes(nsBindings);
        ApplyExp result = new ApplyExp(new QuoteExp(mkElement), (Expression[])args);
        return result;
    }

    Expression wrapWithBaseUri(Expression exp) {
        if (this.getStaticBaseUri() == null) {
            return exp;
        }
        return new ApplyExp(MakeWithBaseUri.makeWithBaseUri, new ApplyExp(new ReferenceExp(XQResolveNames.staticBaseUriDecl), Expression.noExpressions), exp).setLine(exp);
    }

    Expression parseParenExpr() throws IOException, SyntaxException {
        this.getRawToken();
        char saveReadState = this.pushNesting('(');
        Expression exp = this.parseExprSequence(41, true);
        this.popNesting(saveReadState);
        if (this.curToken == -1) {
            this.eofError("missing ')' - unexpected end-of-file");
        }
        return exp;
    }

    Expression parseExprSequence(int rightToken, boolean optional) throws IOException, SyntaxException {
        if (this.curToken == rightToken || this.curToken == -1) {
            if (!optional) {
                this.syntaxError("missing expression");
            }
            return QuoteExp.voidObjectExp;
        }
        Expression exp = null;
        do {
            Expression exp1 = this.parseExprSingle();
            Expression expression = exp = exp == null ? exp1 : XQParser.makeExprSequence(exp, exp1);
            if (this.curToken == rightToken || this.curToken == -1) break;
            if (this.nesting == 0 && this.curToken == 10) {
                return exp;
            }
            if (this.curToken != 44) {
                return this.syntaxError(rightToken == 41 ? "expected ')'" : "confused by syntax error");
            }
            this.getRawToken();
        } while (true);
        return exp;
    }

    Expression parseTypeSwitch() throws IOException, SyntaxException {
        LambdaExp lexp;
        Declaration decl;
        char save = this.pushNesting('t');
        Expression selector = this.parseParenExpr();
        this.getRawToken();
        Object varName = null;
        Vector<Expression> vec = new Vector<Expression>();
        vec.addElement(selector);
        while (this.match("case")) {
            Expression caseExpr;
            this.pushNesting('c');
            this.getRawToken();
            if (this.curToken == 36) {
                decl = this.parseVariableDeclaration();
                if (decl == null) {
                    return this.syntaxError("missing Variable after '$'");
                }
                this.getRawToken();
                if (this.match("as")) {
                    this.getRawToken();
                } else {
                    this.error('e', "missing 'as'");
                }
            } else {
                decl = new Declaration("(arg)");
            }
            decl.setTypeExp(this.parseDataType());
            this.popNesting('t');
            lexp = new LambdaExp(1);
            lexp.addDeclaration(decl);
            if (this.match("return")) {
                this.getRawToken();
            } else {
                this.error("missing 'return' after 'case'");
            }
            this.comp.push(lexp);
            this.pushNesting('r');
            lexp.body = caseExpr = this.parseExpr();
            this.popNesting('t');
            this.comp.pop(lexp);
            vec.addElement(lexp);
        }
        if (this.match("default")) {
            Expression defaultExpr;
            lexp = new LambdaExp(1);
            this.getRawToken();
            if (this.curToken == 36) {
                decl = this.parseVariableDeclaration();
                if (decl == null) {
                    return this.syntaxError("missing Variable after '$'");
                }
                this.getRawToken();
            } else {
                decl = new Declaration("(arg)");
            }
            lexp.addDeclaration(decl);
            if (this.match("return")) {
                this.getRawToken();
            } else {
                this.error("missing 'return' after 'default'");
            }
            this.comp.push(lexp);
            lexp.body = defaultExpr = this.parseExpr();
            this.comp.pop(lexp);
            vec.addElement(lexp);
        } else {
            this.error(this.comp.isPedantic() ? (char)'e' : 'w', "no 'default' clause in 'typeswitch'", "XPST0003");
        }
        this.popNesting(save);
        Object[] args = new Expression[vec.size()];
        vec.copyInto(args);
        return new ApplyExp(XQParser.makeFunctionExp("gnu.kawa.reflect.TypeSwitch", "typeSwitch"), (Expression[])args);
    }

    Expression parseMaybePrimaryExpr() throws IOException, SyntaxException {
        Expression exp;
        int startLine = this.curLine;
        int startColumn = this.curColumn;
        int token = this.peekOperand();
        switch (token) {
            case 40: {
                exp = this.parseParenExpr();
                break;
            }
            case 197: {
                Stack<Expression> extArgs = new Stack<Expression>();
                do {
                    int ch;
                    this.getRawToken();
                    Expression qname = this.curToken != 81 && this.curToken != 65 ? this.syntaxError("missing pragma name") : QuoteExp.getInstance(new String(this.tokenBuffer, 0, this.tokenBufferLength));
                    extArgs.push(qname);
                    StringBuffer sbuf = new StringBuffer();
                    int spaces = -1;
                    do {
                        ch = this.read();
                        ++spaces;
                    } while (ch >= 0 && Character.isWhitespace((char)ch));
                    while (ch != 35 || this.peek() != 41) {
                        if (ch < 0) {
                            this.eofError("pragma ended by end-of-file");
                        }
                        if (spaces == 0) {
                            this.error("missing space between pragma and extension content");
                        }
                        spaces = 1;
                        sbuf.append((char)ch);
                        ch = this.read();
                    }
                    this.read();
                    extArgs.push(QuoteExp.getInstance(sbuf.toString()));
                    this.getRawToken();
                } while (this.curToken == 197);
                if (this.curToken == 123) {
                    this.getRawToken();
                    if (this.curToken != 125) {
                        char saveReadState = this.pushNesting('{');
                        extArgs.push(this.parseExprSequence(125, false));
                        this.popNesting(saveReadState);
                        if (this.curToken == -1) {
                            this.eofError("missing '}' - unexpected end-of-file");
                        }
                    }
                    Object[] args = new Expression[extArgs.size()];
                    extArgs.copyInto(args);
                    exp = new ApplyExp(new ReferenceExp(XQResolveNames.handleExtensionDecl), (Expression[])args);
                    break;
                }
                exp = this.syntaxError("missing '{' after pragma");
                break;
            }
            case 123: {
                exp = this.syntaxError("saw unexpected '{' - assume you meant '('");
                this.parseEnclosedExpr();
                break;
            }
            case 404: {
                int next = this.read();
                if (next == 47) {
                    this.getRawToken();
                    String msg = this.curToken == 65 || this.curToken == 81 || this.curToken == 67 ? "saw end tag '</" + new String(this.tokenBuffer, 0, this.tokenBufferLength) + ">' not in an element constructor" : "saw end tag '</' not in an element constructor";
                    this.curLine = startLine;
                    this.curColumn = startColumn;
                    Expression exp2 = this.syntaxError(msg);
                    while (this.curToken != 405 && this.curToken != -1 && this.curToken != 10) {
                        this.getRawToken();
                    }
                    return exp2;
                }
                exp = this.parseXMLConstructor(next, false);
                this.maybeSetLine(exp, startLine, startColumn);
                break;
            }
            case 34: {
                exp = new QuoteExp(new String(this.tokenBuffer, 0, this.tokenBufferLength).intern());
                break;
            }
            case 48: {
                exp = new QuoteExp(IntNum.valueOf(this.tokenBuffer, 0, this.tokenBufferLength, 10, false));
                break;
            }
            case 49: 
            case 50: {
                String str = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                try {
                    Number val = token == 49 ? new BigDecimal(str) : new Double(str);
                    exp = new QuoteExp(val);
                }
                catch (Exception ex) {
                    exp = this.syntaxError("invalid decimal literal: '" + str + "'");
                }
                break;
            }
            case 36: {
                Object name = this.parseVariable();
                if (name == null) {
                    return this.syntaxError("missing Variable");
                }
                exp = new ReferenceExp(name);
                this.maybeSetLine(exp, this.curLine, this.curColumn);
                break;
            }
            case 70: {
                String name = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                char save = this.pushNesting('(');
                this.getRawToken();
                Vector<Expression> vec = new Vector<Expression>(10);
                if (this.curToken != 41) {
                    do {
                        Expression arg = this.parseExpr();
                        vec.addElement(arg);
                        if (this.curToken == 41) break;
                        if (this.curToken != 44) {
                            return this.syntaxError("missing ')' after function call");
                        }
                        this.getRawToken();
                    } while (true);
                }
                Object[] args = new Expression[vec.size()];
                vec.copyInto(args);
                ReferenceExp rexp = new ReferenceExp(name, null);
                rexp.setProcedureName(true);
                exp = new ApplyExp(rexp, (Expression[])args);
                this.maybeSetLine(exp, startLine, startColumn);
                this.popNesting(save);
                break;
            }
            case 251: 
            case 252: 
            case 253: 
            case 254: 
            case 255: 
            case 256: {
                Expression func;
                this.getRawToken();
                Vector<Expression> vec = new Vector<Expression>();
                if (token == 251 || token == 252) {
                    Expression element;
                    if (this.curToken == 65 || this.curToken == 81) {
                        element = this.parseNameTest(token != 251);
                    } else if (this.curToken == 123) {
                        element = this.parseEnclosedExpr();
                    } else {
                        return this.syntaxError("missing element/attribute name");
                    }
                    vec.addElement(XQParser.castQName(element, token == 251));
                    if (token == 251) {
                        MakeElement mk = new MakeElement();
                        mk.copyNamespacesMode = this.copyNamespacesMode;
                        func = new QuoteExp(mk);
                    } else {
                        func = MakeAttribute.makeAttributeExp;
                    }
                    this.getRawToken();
                } else if (token == 256) {
                    func = XQParser.makeFunctionExp("gnu.kawa.xml.DocumentConstructor", "documentConstructor");
                } else if (token == 254) {
                    func = XQParser.makeFunctionExp("gnu.kawa.xml.CommentConstructor", "commentConstructor");
                } else if (token == 255) {
                    Expression target;
                    if (this.curToken == 65) {
                        target = new QuoteExp(new String(this.tokenBuffer, 0, this.tokenBufferLength).intern());
                    } else if (this.curToken == 123) {
                        target = this.parseEnclosedExpr();
                    } else {
                        target = this.syntaxError("expected NCName or '{' after 'processing-instruction'");
                        if (this.curToken != 81) {
                            return target;
                        }
                    }
                    vec.addElement(target);
                    func = XQParser.makeFunctionExp("gnu.kawa.xml.MakeProcInst", "makeProcInst");
                    this.getRawToken();
                } else {
                    func = XQParser.makeFunctionExp("gnu.kawa.xml.MakeText", "makeText");
                }
                char saveReadState = this.pushNesting('{');
                this.peekNonSpace("unexpected end-of-file after '{'");
                if (this.curToken != 123) {
                    return this.syntaxError("missing '{'");
                }
                this.getRawToken();
                if (token == 253 || token == 254 || token == 255) {
                    vec.addElement(this.parseExprSequence(125, token == 255));
                } else if (this.curToken != 125) {
                    vec.addElement(this.parseExpr());
                    while (this.curToken == 44) {
                        this.getRawToken();
                        vec.addElement(this.parseExpr());
                    }
                }
                this.popNesting(saveReadState);
                if (this.curToken != 125) {
                    return this.syntaxError("missing '}'");
                }
                Object[] args = new Expression[vec.size()];
                vec.copyInto(args);
                exp = new ApplyExp(func, (Expression[])args);
                this.maybeSetLine(exp, startLine, startColumn);
                if (token != 256 && token != 251) break;
                exp = this.wrapWithBaseUri(exp);
                break;
            }
            case 249: 
            case 250: {
                this.getRawToken();
                exp = this.parseExprSequence(125, false);
                break;
            }
            default: {
                return null;
            }
        }
        this.getRawToken();
        return exp;
    }

    public Expression parseIfExpr() throws IOException, SyntaxException {
        char saveReadState1 = this.pushNesting('i');
        this.getRawToken();
        char saveReadState2 = this.pushNesting('(');
        Expression cond = this.parseExprSequence(41, false);
        this.popNesting(saveReadState2);
        if (this.curToken == -1) {
            this.eofError("missing ')' - unexpected end-of-file");
        }
        this.getRawToken();
        if (!this.match("then")) {
            this.syntaxError("missing 'then'");
        } else {
            this.getRawToken();
        }
        Expression thenPart = this.parseExpr();
        if (!this.match("else")) {
            this.syntaxError("missing 'else'");
        } else {
            this.getRawToken();
        }
        this.popNesting(saveReadState1);
        Expression elsePart = this.parseExpr();
        return new IfExp(XQParser.booleanValue(cond), thenPart, elsePart);
    }

    public boolean match(String word) {
        if (this.curToken != 65) {
            return false;
        }
        int len = word.length();
        if (this.tokenBufferLength != len) {
            return false;
        }
        int i = len;
        while (--i >= 0) {
            char cb;
            char cs = word.charAt(i);
            if (cs == (cb = this.tokenBuffer[i])) continue;
            return false;
        }
        return true;
    }

    public Object parseVariable() throws IOException, SyntaxException {
        if (this.curToken == 36) {
            this.getRawToken();
        } else {
            this.syntaxError("missing '$' before variable name");
        }
        String str = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        if (this.curToken == 81) {
            return str;
        }
        if (this.curToken == 65) {
            return Namespace.EmptyNamespace.getSymbol(str.intern());
        }
        return null;
    }

    public Declaration parseVariableDeclaration() throws IOException, SyntaxException {
        Object name = this.parseVariable();
        if (name == null) {
            return null;
        }
        Declaration decl = new Declaration(name);
        this.maybeSetLine(decl, this.getLineNumber() + 1, this.getColumnNumber() + 1 - this.tokenBufferLength);
        return decl;
    }

    public Expression parseFLWRExpression(boolean isFor) throws IOException, SyntaxException {
        int flworDeclsSave = this.flworDeclsFirst;
        this.flworDeclsFirst = this.flworDeclsCount;
        Expression exp = this.parseFLWRInner(isFor);
        if (this.match("order")) {
            char saveNesting = this.pushNesting(isFor ? (char)'f' : 'l');
            this.getRawToken();
            if (this.match("by")) {
                this.getRawToken();
            } else {
                this.error("missing 'by' following 'order'");
            }
            Stack<Expression> specs = new Stack<Expression>();
            do {
                boolean descending = false;
                int emptyOrder = this.defaultEmptyOrder;
                LambdaExp lexp = new LambdaExp(this.flworDeclsCount - this.flworDeclsFirst);
                for (int i = this.flworDeclsFirst; i < this.flworDeclsCount; ++i) {
                    lexp.addDeclaration(this.flworDecls[i].getSymbol());
                }
                this.comp.push(lexp);
                lexp.body = this.parseExprSingle();
                this.comp.pop(lexp);
                specs.push(lexp);
                if (this.match("ascending")) {
                    this.getRawToken();
                } else if (this.match("descending")) {
                    this.getRawToken();
                    descending = true;
                }
                if (this.match("empty")) {
                    this.getRawToken();
                    if (this.match("greatest")) {
                        this.getRawToken();
                        emptyOrder = 71;
                    } else if (this.match("least")) {
                        this.getRawToken();
                        emptyOrder = 76;
                    } else {
                        this.error("'empty' sequence order must be 'greatest' or 'least'");
                    }
                }
                specs.push(new QuoteExp((descending ? "D" : "A") + (char)emptyOrder));
                NamedCollator collation = this.defaultCollator;
                if (this.match("collation")) {
                    Object uri = this.parseURILiteral();
                    if (uri instanceof String) {
                        try {
                            String uriString = this.resolveAgainstBaseUri((String)uri);
                            collation = NamedCollator.make(uriString);
                        }
                        catch (Exception name) {
                            this.error('e', "unknown collation '" + uri + "'", "XQST0076");
                        }
                    }
                    this.getRawToken();
                }
                specs.push(new QuoteExp(collation));
                if (this.curToken != 44) break;
                this.getRawToken();
            } while (true);
            if (!this.match("return")) {
                return this.syntaxError("expected 'return' clause");
            }
            this.getRawToken();
            LambdaExp lexp = new LambdaExp(this.flworDeclsCount - this.flworDeclsFirst);
            for (int i = this.flworDeclsFirst; i < this.flworDeclsCount; ++i) {
                lexp.addDeclaration(this.flworDecls[i].getSymbol());
            }
            this.popNesting(saveNesting);
            this.comp.push(lexp);
            lexp.body = this.parseExprSingle();
            this.comp.pop(lexp);
            int nspecs = specs.size();
            Expression[] args = new Expression[2 + nspecs];
            args[0] = exp;
            args[1] = lexp;
            for (int i = 0; i < nspecs; ++i) {
                args[2 + i] = (Expression)specs.elementAt(i);
            }
            return new ApplyExp(XQParser.makeFunctionExp("gnu.xquery.util.OrderedMap", "orderedMap"), args);
        }
        this.flworDeclsCount = this.flworDeclsFirst;
        this.flworDeclsFirst = flworDeclsSave;
        return exp;
    }

    public Expression parseFLWRInner(boolean isFor) throws IOException, SyntaxException {
        Expression body;
        char saveNesting = this.pushNesting(isFor ? (char)'f' : 'l');
        this.curToken = 36;
        Declaration decl = this.parseVariableDeclaration();
        if (decl == null) {
            return this.syntaxError("missing Variable - saw " + this.tokenString());
        }
        if (this.flworDecls == null) {
            this.flworDecls = new Declaration[8];
        } else if (this.flworDeclsCount >= this.flworDecls.length) {
            Declaration[] tmp = new Declaration[2 * this.flworDeclsCount];
            System.arraycopy(this.flworDecls, 0, tmp, 0, this.flworDeclsCount);
            this.flworDecls = tmp;
        }
        this.flworDecls[this.flworDeclsCount++] = decl;
        this.getRawToken();
        Expression type = this.parseOptionalTypeDeclaration();
        LambdaExp lexp = null;
        Declaration posDecl = null;
        if (isFor) {
            boolean sawAt = this.match("at");
            lexp = new LambdaExp(sawAt ? 2 : 1);
            if (sawAt) {
                this.getRawToken();
                if (this.curToken == 36) {
                    posDecl = this.parseVariableDeclaration();
                    this.getRawToken();
                }
                if (posDecl == null) {
                    this.syntaxError("missing Variable after 'at'");
                }
            }
            if (this.match("in")) {
                this.getRawToken();
            } else {
                if (this.curToken == 76) {
                    this.getRawToken();
                }
                this.syntaxError("missing 'in' in 'for' clause");
            }
            this.comp.push(lexp);
        } else {
            if (this.curToken == 76) {
                this.getRawToken();
            } else {
                if (this.match("in")) {
                    this.getRawToken();
                }
                this.syntaxError("missing ':=' in 'let' clause");
            }
            this.comp.letStart();
        }
        Expression init = this.parseExprSingle();
        if (isFor) {
            lexp.addDeclaration(decl);
            decl.noteValueUnknown();
            decl.setFlag(262144L);
        } else {
            if (type != null) {
                init = Compilation.makeCoercion(init, type);
            }
            this.comp.letVariable(decl, init);
            this.comp.letEnter();
        }
        if (type != null) {
            decl.setTypeExp(type);
        }
        this.popNesting(saveNesting);
        if (posDecl != null) {
            lexp.addDeclaration(posDecl);
            posDecl.setType(LangPrimType.intType);
            posDecl.noteValueUnknown();
            posDecl.setFlag(262144L);
        }
        if (this.curToken == 44) {
            this.getRawToken();
            if (this.curToken != 36) {
                return this.syntaxError("missing $NAME after ','");
            }
            body = this.parseFLWRInner(isFor);
        } else if (this.match("for")) {
            this.getRawToken();
            if (this.curToken != 36) {
                return this.syntaxError("missing $NAME after 'for'");
            }
            body = this.parseFLWRInner(true);
        } else if (this.match("let")) {
            this.getRawToken();
            if (this.curToken != 36) {
                return this.syntaxError("missing $NAME after 'let'");
            }
            body = this.parseFLWRInner(false);
        } else {
            Expression cond;
            char save = this.pushNesting('w');
            if (this.curToken == 196) {
                this.getRawToken();
                cond = this.parseExprSingle();
            } else {
                cond = this.match("where") ? this.parseExprSingle() : null;
            }
            this.popNesting(save);
            boolean sawStable = this.match("stable");
            if (sawStable) {
                this.getRawToken();
            }
            boolean sawReturn = this.match("return");
            boolean sawOrder = this.match("order");
            if (!(sawReturn || sawOrder || this.match("let") || this.match("for"))) {
                return this.syntaxError("missing 'return' clause");
            }
            if (!sawOrder) {
                this.peekNonSpace("unexpected eof-of-file after 'return'");
            }
            int bodyLine = this.getLineNumber() + 1;
            int bodyColumn = this.getColumnNumber() + 1;
            if (sawReturn) {
                this.getRawToken();
            }
            if (sawOrder) {
                int ndecls = this.flworDeclsCount - this.flworDeclsFirst;
                Expression[] args = new Expression[ndecls];
                for (int i = 0; i < ndecls; ++i) {
                    args[i] = new ReferenceExp(this.flworDecls[this.flworDeclsFirst + i]);
                }
                body = new ApplyExp(new PrimProcedure("gnu.xquery.util.OrderedMap", "makeTuple$V", 1), args);
            } else {
                body = this.parseExprSingle();
            }
            if (cond != null) {
                body = new IfExp(XQParser.booleanValue(cond), body, QuoteExp.voidExp);
            }
            this.maybeSetLine(body, bodyLine, bodyColumn);
        }
        if (isFor) {
            this.comp.pop(lexp);
            lexp.body = body;
            Expression[] args = new Expression[]{lexp, init};
            return new ApplyExp(XQParser.makeFunctionExp("gnu.kawa.functions.ValuesMap", lexp.min_args == 1 ? "valuesMap" : "valuesMapWithPos"), args);
        }
        return this.comp.letDone(body);
    }

    public Expression parseQuantifiedExpr(boolean isEvery) throws IOException, SyntaxException {
        Expression body;
        char saveNesting = this.pushNesting(isEvery ? (char)'e' : 's');
        this.curToken = 36;
        Declaration decl = this.parseVariableDeclaration();
        if (decl == null) {
            return this.syntaxError("missing Variable token:" + this.curToken);
        }
        this.getRawToken();
        LambdaExp lexp = new LambdaExp(1);
        lexp.addDeclaration(decl);
        decl.noteValueUnknown();
        decl.setFlag(262144L);
        decl.setTypeExp(this.parseOptionalTypeDeclaration());
        if (this.match("in")) {
            this.getRawToken();
        } else {
            if (this.curToken == 76) {
                this.getRawToken();
            }
            this.syntaxError("missing 'in' in QuantifiedExpr");
        }
        Expression[] inits = new Expression[]{this.parseExprSingle()};
        this.popNesting(saveNesting);
        this.comp.push(lexp);
        if (this.curToken == 44) {
            this.getRawToken();
            if (this.curToken != 36) {
                return this.syntaxError("missing $NAME after ','");
            }
            body = this.parseQuantifiedExpr(isEvery);
        } else {
            boolean sawSatisfies = this.match("satisfies");
            if (!(sawSatisfies || this.match("every") || this.match("some"))) {
                return this.syntaxError("missing 'satisfies' clause");
            }
            this.peekNonSpace("unexpected eof-of-file after 'satisfies'");
            int bodyLine = this.getLineNumber() + 1;
            int bodyColumn = this.getColumnNumber() + 1;
            if (sawSatisfies) {
                this.getRawToken();
            }
            body = this.parseExprSingle();
            this.maybeSetLine(body, bodyLine, bodyColumn);
        }
        this.comp.pop(lexp);
        lexp.body = body;
        Expression[] args = new Expression[]{lexp, inits[0]};
        return new ApplyExp(XQParser.makeFunctionExp("kawa.lib.xquery.Xutils", isEvery ? "every" : "some"), args);
    }

    public Expression parseFunctionDefinition(int declLine, int declColumn) throws IOException, SyntaxException {
        if (this.curToken != 81 && this.curToken != 65) {
            return this.syntaxError("missing function name");
        }
        String name = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        this.getMessages().setLine(this.port.getName(), this.curLine, this.curColumn);
        Symbol sym = this.namespaceResolve(name, true);
        String uri = sym.getNamespaceURI();
        if (uri == "http://www.w3.org/XML/1998/namespace" || uri == "http://www.w3.org/2001/XMLSchema" || uri == "http://www.w3.org/2001/XMLSchema-instance" || uri == "http://www.w3.org/2005/xpath-functions") {
            this.error('e', "cannot declare function in standard namespace '" + uri + '\'', "XQST0045");
        } else if (uri == "") {
            this.error(this.comp.isPedantic() ? (char)'e' : 'w', "cannot declare function in empty namespace", "XQST0060");
        } else if (this.libraryModuleNamespace != null && uri != this.libraryModuleNamespace && (!"http://www.w3.org/2005/xquery-local-functions".equals(uri) || this.comp.isPedantic())) {
            this.error('e', "function not in namespace of library module", "XQST0048");
        }
        this.getRawToken();
        if (this.curToken != 40) {
            return this.syntaxError("missing parameter list:" + this.curToken);
        }
        this.getRawToken();
        LambdaExp lexp = new LambdaExp();
        this.maybeSetLine(lexp, declLine, declColumn);
        lexp.setSymbol(sym);
        Declaration decl = this.comp.currentScope().addDeclaration(sym);
        if (this.comp.isStatic()) {
            decl.setFlag(2048L);
        }
        lexp.setFlag(2048);
        decl.setCanRead(true);
        decl.setProcedureDecl(true);
        this.maybeSetLine(decl, declLine, declColumn);
        this.comp.push(lexp);
        if (this.curToken != 41) {
            block0 : do {
                Declaration param;
                if ((param = this.parseVariableDeclaration()) == null) {
                    this.error("missing parameter name");
                } else {
                    lexp.addDeclaration(param);
                    this.getRawToken();
                    ++lexp.min_args;
                    ++lexp.max_args;
                    param.setTypeExp(this.parseOptionalTypeDeclaration());
                }
                if (this.curToken == 41) break;
                if (this.curToken != 44) {
                    Expression err = this.syntaxError("missing ',' in parameter list");
                    do {
                        this.getRawToken();
                        if (this.curToken < 0 || this.curToken == 59 || this.curToken == 59) {
                            return err;
                        }
                        if (this.curToken == 41) break block0;
                    } while (this.curToken != 44);
                    continue;
                }
                this.getRawToken();
            } while (true);
        }
        this.getRawToken();
        Expression retType = this.parseOptionalTypeDeclaration();
        lexp.body = this.parseEnclosedExpr();
        this.comp.pop(lexp);
        if (retType != null) {
            lexp.setCoercedReturnValue(retType, this.interpreter);
        }
        SetExp sexp = new SetExp(decl, (Expression)lexp);
        sexp.setDefining(true);
        decl.noteValue(lexp);
        return sexp;
    }

    public Object readObject() throws IOException, SyntaxException {
        return this.parse(null);
    }

    protected Symbol namespaceResolve(String name, boolean function2) {
        int colon = name.indexOf(58);
        String prefix = colon >= 0 ? name.substring(0, colon).intern() : (function2 ? "(functions)" : XQuery.DEFAULT_ELEMENT_PREFIX);
        String uri = QNameUtils.lookupPrefix(prefix, this.constructorNamespaces, this.prologNamespaces);
        if (uri == null) {
            if (colon < 0) {
                uri = "";
            } else if (!this.comp.isPedantic()) {
                try {
                    Class<?> cl = Class.forName(prefix);
                    uri = "class:" + prefix;
                }
                catch (Exception ex) {
                    uri = null;
                }
            }
            if (uri == null) {
                this.getMessages().error('e', "unknown namespace prefix '" + prefix + "'", "XPST0081");
                uri = "(unknown namespace)";
            }
        }
        String local = colon < 0 ? name : name.substring(colon + 1);
        return Symbol.make(uri, local, prefix);
    }

    void parseSeparator() throws IOException, SyntaxException {
        int startLine = this.port.getLineNumber() + 1;
        int startColumn = this.port.getColumnNumber() + 1;
        int next = this.skipSpace(this.nesting != 0);
        if (next == 59) {
            return;
        }
        if (warnOldVersion && next != 10) {
            this.curLine = startLine;
            this.curColumn = startColumn;
            this.error('w', "missing ';' after declaration");
        }
        if (next >= 0) {
            this.unread(next);
        }
    }

    public Expression parse(Compilation comp) throws IOException, SyntaxException {
        this.comp = comp;
        int ch = this.skipSpace();
        if (ch < 0) {
            return null;
        }
        ++this.parseCount;
        this.unread(ch);
        int startLine = this.getLineNumber() + 1;
        int startColumn = this.getColumnNumber() + 1;
        if (ch == 35 && startLine == 1 && startColumn == 1) {
            this.read();
            ch = this.read();
            if (ch != 33 || (ch = this.read()) != 47) {
                this.error("'#' is only allowed in initial '#!/PROGRAM'");
            }
            while (ch != 13 && ch != 10 && ch >= 0) {
                ch = this.read();
            }
        }
        if (this.getRawToken() == -1) {
            return null;
        }
        this.peekOperand();
        if (this.curToken == 65 && "namespace".equals((String)this.curValue)) {
            if (warnOldVersion) {
                this.error('w', "use 'declare namespace' instead of 'namespace'");
            }
            this.curToken = 78;
        }
        switch (this.curToken) {
            int next2;
            case 87: {
                int declLine = this.getLineNumber() + 1;
                int declColumn = this.getColumnNumber() + 1;
                int next2 = this.peekNonSpace("unexpected end-of-file after 'define QName'");
                if (next2 == 40) {
                    this.syntaxError("'missing 'function' after 'define'");
                    this.curToken = 65;
                    return this.parseFunctionDefinition(declLine, declColumn);
                }
                return this.syntaxError("missing keyword after 'define'");
            }
            case 80: {
                int declLine = this.getLineNumber() + 1;
                int declColumn = this.getColumnNumber() + 1;
                this.getRawToken();
                this.peekNonSpace("unexpected end-of-file after 'define function'");
                char save = this.pushNesting('d');
                Expression exp = this.parseFunctionDefinition(declLine, declColumn);
                this.popNesting(save);
                this.parseSeparator();
                this.maybeSetLine(exp, startLine, startColumn);
                this.seenDeclaration = true;
                return exp;
            }
            case 86: {
                String uri;
                this.getRawToken();
                Declaration decl = this.parseVariableDeclaration();
                if (decl == null) {
                    return this.syntaxError("missing Variable");
                }
                Object name = decl.getSymbol();
                if (name instanceof String) {
                    this.getMessages().setLine(this.port.getName(), this.curLine, this.curColumn);
                    decl.setSymbol(this.namespaceResolve((String)name, false));
                }
                if (this.libraryModuleNamespace != null && (uri = ((Symbol)decl.getSymbol()).getNamespaceURI()) != this.libraryModuleNamespace && (!"http://www.w3.org/2005/xquery-local-functions".equals(uri) || comp.isPedantic())) {
                    this.error('e', "variable not in namespace of library module", "XQST0048");
                }
                comp.currentScope().addDeclaration(decl);
                this.getRawToken();
                Expression type = this.parseOptionalTypeDeclaration();
                decl.setCanRead(true);
                decl.setFlag(16384L);
                Expression init = null;
                boolean sawEq = false;
                if (this.curToken == 402 || this.curToken == 76) {
                    if (this.curToken == 402) {
                        this.error("declare variable contains '=' instead of ':='");
                    }
                    this.getRawToken();
                    sawEq = true;
                }
                if (this.curToken == 123) {
                    this.warnOldVersion("obsolete '{' in variable declaration");
                    init = this.parseEnclosedExpr();
                    this.parseSeparator();
                } else if (this.match("external")) {
                    Expression[] args = new Expression[]{XQParser.castQName(new QuoteExp(decl.getSymbol()), false), type == null ? QuoteExp.nullExp : type};
                    init = new ApplyExp(getExternalFunction, args);
                    this.maybeSetLine(init, this.curLine, this.curColumn);
                    this.getRawToken();
                } else {
                    init = this.parseExpr();
                    Expression err = null;
                    if (!sawEq || init == null) {
                        err = this.syntaxError("expected ':= init' or 'external'");
                    }
                    if (init == null) {
                        init = err;
                    }
                }
                if (type != null) {
                    init = Compilation.makeCoercion(init, type);
                }
                decl.noteValue(init);
                SetExp exp = SetExp.makeDefinition(decl, init);
                this.maybeSetLine(exp, startLine, startColumn);
                this.seenDeclaration = true;
                return exp;
            }
            case 77: 
            case 78: {
                int command = this.curToken;
                if (command == 77 && this.libraryModuleNamespace != null) {
                    this.error('e', "duplicate module declaration");
                } else if (this.seenDeclaration && !this.isInteractive()) {
                    this.error('e', "namespace declared after function/variable/option");
                }
                next2 = this.skipSpace(this.nesting != 0);
                if (next2 >= 0) {
                    this.unread();
                    if (XName.isNameStart((char)next2)) {
                        this.getRawToken();
                        if (this.curToken != 65) {
                            return this.syntaxError("missing namespace prefix");
                        }
                        String prefix = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                        this.getRawToken();
                        if (this.curToken != 402) {
                            return this.syntaxError("missing '=' in namespace declaration");
                        }
                        this.getRawToken();
                        if (this.curToken != 34) {
                            return this.syntaxError("missing uri in namespace declaration");
                        }
                        String uri = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
                        prefix = prefix.intern();
                        for (NamespaceBinding ns = this.prologNamespaces; ns != builtinNamespaces; ns = ns.getNext()) {
                            if (ns.getPrefix() != prefix) continue;
                            this.error('e', "duplicate declarations for the same namespace prefix '" + prefix + "'", "XQST0033");
                            break;
                        }
                        this.pushNamespace(prefix, uri);
                        this.checkAllowedNamespaceDeclaration(prefix, uri, false);
                        this.parseSeparator();
                        if (command == 77) {
                            ModuleExp module = comp.getModule();
                            String className = Compilation.mangleURI(uri) + '.' + XQuery.makeClassName(module.getFileName());
                            module.setName(className);
                            comp.mainClass = new ClassType(className);
                            module.setType(comp.mainClass);
                            ModuleManager manager = ModuleManager.getInstance();
                            ModuleInfo info = manager.find(comp);
                            info.setNamespaceUri(uri);
                            module.setType(comp.mainClass);
                            if (uri.length() == 0) {
                                return this.syntaxError("zero-length module namespace", "XQST0088");
                            }
                            this.libraryModuleNamespace = uri;
                        }
                        return QuoteExp.voidExp;
                    }
                }
            }
            case 84: {
                this.fatal("'import schema' not implemented", "XQST0009");
            }
            case 73: {
                this.getRawToken();
                String prefix = null;
                if (this.match("namespace")) {
                    this.getRawToken();
                    if (this.curToken != 65) {
                        return this.syntaxError("missing namespace prefix");
                    }
                    prefix = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                    this.getRawToken();
                    if (this.curToken != 402) {
                        return this.syntaxError("missing '=' in namespace declaration");
                    }
                    this.getRawToken();
                }
                if (this.curToken != 34) {
                    return this.syntaxError("missing uri in namespace declaration");
                }
                if (this.tokenBufferLength == 0) {
                    return this.syntaxError("zero-length target namespace", "XQST0088");
                }
                String uri = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
                if (prefix != null) {
                    this.checkAllowedNamespaceDeclaration(prefix, uri, false);
                    this.pushNamespace(prefix.intern(), uri);
                }
                this.getRawToken();
                ModuleManager.getInstance().find(comp);
                if (this.seenImports == null) {
                    this.seenImports = new HashMap<String, SourceLocator>();
                }
                SourceLocator oldImport = this.seenImports.get(uri);
                Declaration loc = new Declaration(uri);
                this.maybeSetLine(loc, startLine, startColumn);
                if (oldImport != null) {
                    comp.error('e', "duplicate import of '" + uri + "'", "XQST0047", loc);
                    comp.error('e', "(this is the previous import)", null, oldImport);
                    return QuoteExp.voidExp;
                }
                this.seenImports.put(uri, loc);
                ModuleExp module = comp.getModule();
                Translator.FormStack formStack = new Translator.FormStack(comp);
                String packageName = Compilation.mangleURI(uri);
                comp.setLine(this.port.getName(), startLine, startColumn);
                if (this.match("at")) {
                    do {
                        this.getRawToken();
                        if (this.curToken != 34) {
                            return this.syntaxError("missing module location");
                        }
                        String at = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                        String className = Compilation.mangleURI(uri) + '.' + XQuery.makeClassName(at);
                        ModuleInfo info = require.lookupModuleFromSourcePath(at, module);
                        if (info == null) {
                            comp.error('e', "malformed URL: " + at);
                        }
                        require.importDefinitions(className, info, null, formStack, module, comp);
                    } while ((next2 = this.skipSpace(this.nesting != 0)) == 44);
                    this.unread(next2);
                    this.parseSeparator();
                } else {
                    ModuleInfo info;
                    ModuleManager manager = ModuleManager.getInstance();
                    int n = 0;
                    try {
                        manager.loadPackageInfo(packageName);
                    }
                    catch (ClassNotFoundException ex) {
                    }
                    catch (Exception ex) {
                        this.error('e', "error loading map for " + uri + " - " + ex);
                    }
                    int i = 0;
                    while ((info = manager.getModule(i)) != null) {
                        if (uri.equals(info.getNamespaceUri())) {
                            ++n;
                            require.importDefinitions(info.getClassName(), info, null, formStack, module, comp);
                        }
                        ++i;
                    }
                    if (n == 0) {
                        this.error('e', "no module found for " + uri);
                    }
                    Object at = null;
                    if (this.curToken != 59) {
                        this.parseSeparator();
                    }
                }
                if (comp.pendingImports != null && comp.pendingImports.size() > 0) {
                    this.error('e', "module import forms a cycle", "XQST0073");
                }
                LList forms = (LList)formStack.getFirst();
                Expression[] inits = new Expression[forms.size()];
                forms.toArray(inits);
                return BeginExp.canonicalize(inits);
            }
            case 71: {
                Object val;
                if (this.defaultCollator != null && !this.isInteractive()) {
                    this.error('e', "duplicate default collation declaration", "XQST0038");
                }
                if ((val = this.parseURILiteral()) instanceof Expression) {
                    return (Expression)val;
                }
                String collation = (String)val;
                try {
                    collation = this.resolveAgainstBaseUri(collation);
                    this.defaultCollator = NamedCollator.make(collation);
                }
                catch (Exception ex) {
                    this.defaultCollator = NamedCollator.codepointCollation;
                    this.error('e', "unknown collation '" + collation + "'", "XQST0038");
                }
                this.parseSeparator();
                return QuoteExp.voidExp;
            }
            case 69: 
            case 79: {
                String prefix;
                boolean forFunctions = this.curToken == 79;
                String string = prefix = forFunctions ? "(functions)" : XQuery.DEFAULT_ELEMENT_PREFIX;
                if (this.prologNamespaces.resolve(prefix, builtinNamespaces) != null) {
                    this.error('e', "duplicate default namespace declaration", "XQST0066");
                } else if (this.seenDeclaration && !this.isInteractive()) {
                    this.error('e', "default namespace declared after function/variable/option");
                }
                this.getRawToken();
                if (this.match("namespace")) {
                    this.getRawToken();
                } else {
                    String msg = "expected 'namespace' keyword";
                    if (this.curToken != 34 && this.curToken != 402) {
                        return this.declError(msg);
                    }
                    this.warnOldVersion(msg);
                }
                if (this.curToken == 402 || this.curToken == 76) {
                    this.warnOldVersion("extra '=' in default namespace declaration");
                    this.getRawToken();
                }
                if (this.curToken != 34) {
                    return this.declError("missing namespace uri");
                }
                String uri = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
                if (forFunctions) {
                    this.functionNamespacePath = new Namespace[1];
                    this.functionNamespacePath[0] = Namespace.valueOf(uri);
                } else {
                    this.defaultElementNamespace = uri;
                }
                this.pushNamespace(prefix, uri);
                this.checkAllowedNamespaceDeclaration(prefix, uri, false);
                this.parseSeparator();
                return QuoteExp.voidExp;
            }
            case 83: {
                this.getRawToken();
                if (this.curToken == 402) {
                    this.warnOldVersion("obsolate '=' in boundary-space declaration");
                    this.getRawToken();
                }
                if (this.boundarySpaceDeclarationSeen && !this.isInteractive()) {
                    this.syntaxError("duplicate 'declare boundary-space' seen", "XQST0068");
                }
                this.boundarySpaceDeclarationSeen = true;
                if (this.match("preserve")) {
                    this.boundarySpacePreserve = true;
                } else if (this.match("strip")) {
                    this.boundarySpacePreserve = false;
                } else if (this.match("skip")) {
                    this.warnOldVersion("update: declare boundary-space skip -> strip");
                    this.boundarySpacePreserve = false;
                } else {
                    return this.syntaxError("boundary-space declaration must be preserve or strip");
                }
                this.parseSeparator();
                return QuoteExp.voidExp;
            }
            case 75: {
                this.getRawToken();
                if (this.constructionModeDeclarationSeen && !this.isInteractive()) {
                    this.syntaxError("duplicate 'declare construction' seen", "XQST0067");
                }
                this.constructionModeDeclarationSeen = true;
                if (this.match("strip")) {
                    this.constructionModeStrip = true;
                } else if (this.match("preserve")) {
                    this.constructionModeStrip = false;
                } else {
                    return this.syntaxError("construction declaration must be strip or preserve");
                }
                this.parseSeparator();
                return QuoteExp.voidExp;
            }
            case 76: {
                this.getRawToken();
                if (this.copyNamespacesDeclarationSeen && !this.isInteractive()) {
                    this.syntaxError("duplicate 'declare copy-namespaces' seen", "XQST0055");
                }
                this.copyNamespacesDeclarationSeen = true;
                if (this.match("preserve")) {
                    this.copyNamespacesMode |= 1;
                } else if (this.match("no-preserve")) {
                    this.copyNamespacesMode &= -2;
                } else {
                    return this.syntaxError("expected 'preserve' or 'no-preserve' after 'declare copy-namespaces'");
                }
                this.getRawToken();
                if (this.curToken != 44) {
                    return this.syntaxError("missing ',' in copy-namespaces declaration");
                }
                this.getRawToken();
                if (this.match("inherit")) {
                    this.copyNamespacesMode |= 2;
                } else if (this.match("no-inherit")) {
                    this.copyNamespacesMode &= -3;
                } else {
                    return this.syntaxError("expected 'inherit' or 'no-inherit' in copy-namespaces declaration");
                }
                this.parseSeparator();
                return QuoteExp.voidExp;
            }
            case 72: {
                this.getRawToken();
                boolean sawEmpty = this.match("empty");
                if (this.emptyOrderDeclarationSeen && !this.isInteractive()) {
                    this.syntaxError("duplicate 'declare default empty order' seen", "XQST0069");
                }
                this.emptyOrderDeclarationSeen = true;
                if (sawEmpty) {
                    this.getRawToken();
                } else {
                    this.syntaxError("expected 'empty greatest' or 'empty least'");
                }
                if (this.match("greatest")) {
                    this.defaultEmptyOrder = (char)71;
                } else if (this.match("least")) {
                    this.defaultEmptyOrder = (char)76;
                } else {
                    return this.syntaxError("expected 'empty greatest' or 'empty least'");
                }
                this.parseSeparator();
                return QuoteExp.voidExp;
            }
            case 111: {
                this.getRawToken();
                if (this.curToken != 81) {
                    this.syntaxError("expected QName after 'declare option'");
                } else {
                    String str = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                    this.getMessages().setLine(this.port.getName(), this.curLine, this.curColumn);
                    Symbol sym = this.namespaceResolve(str, false);
                    this.getRawToken();
                    if (this.curToken != 34) {
                        this.syntaxError("expected string literal after 'declare option " + str + '\'');
                    } else {
                        this.handleOption(sym, new String(this.tokenBuffer, 0, this.tokenBufferLength));
                    }
                }
                this.parseSeparator();
                this.seenDeclaration = true;
                return QuoteExp.voidExp;
            }
            case 85: {
                if (this.orderingModeSeen && !this.isInteractive()) {
                    this.syntaxError("duplicate 'declare ordering' seen", "XQST0065");
                }
                this.orderingModeSeen = true;
                this.getRawToken();
                if (this.match("ordered")) {
                    this.orderingModeUnordered = false;
                } else if (this.match("unordered")) {
                    this.orderingModeUnordered = true;
                } else {
                    return this.syntaxError("ordering declaration must be ordered or unordered");
                }
                this.parseSeparator();
                return QuoteExp.voidExp;
            }
            case 89: {
                if (this.parseCount != 1) {
                    this.error('e', "'xquery version' does not start module");
                } else if (this.commentCount > 0) {
                    this.error('w', "comments should not precede 'xquery version'");
                }
                this.getRawToken();
                if (this.curToken == 34) {
                    String version = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                    if (!version.equals("1.0")) {
                        this.error('e', "unrecognized xquery version " + version, "XQST0031");
                    }
                } else {
                    return this.syntaxError("missing version string after 'xquery version'");
                }
                this.getRawToken();
                if (this.match("encoding")) {
                    boolean bad;
                    InPort port;
                    this.getRawToken();
                    if (this.curToken != 34) {
                        return this.syntaxError("invalid encoding specification");
                    }
                    String encoding = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                    int i = this.tokenBufferLength;
                    boolean bl = bad = i == 0;
                    while (--i >= 0 && !bad) {
                        ch = this.tokenBuffer[i];
                        if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122 || i != 0 && (ch >= 48 && ch <= 57 || ch == 46 || ch == 95 || ch == 45)) continue;
                        bad = true;
                    }
                    if (bad) {
                        this.error('e', "invalid encoding name syntax", "XQST0087");
                    }
                    if ((port = this.getPort()) instanceof BinaryInPort) {
                        try {
                            ((BinaryInPort)port).setCharset(encoding);
                        }
                        catch (UnsupportedCharsetException ex) {
                            this.error('e', "unrecognized encoding name");
                        }
                        catch (Exception ex) {
                            this.error('e', "cannot set encoding name here");
                        }
                    }
                    this.getRawToken();
                }
                if (this.curToken != 59) {
                    this.syntaxError("missing ';'");
                }
                return QuoteExp.voidExp;
            }
            case 66: {
                if (this.baseURIDeclarationSeen && !this.isInteractive()) {
                    this.syntaxError("duplicate 'declare base-uri' seen", "XQST0032");
                }
                this.baseURIDeclarationSeen = true;
                Object val = this.parseURILiteral();
                if (val instanceof Expression) {
                    return (Expression)val;
                }
                this.parseSeparator();
                this.setStaticBaseUri((String)val);
                return QuoteExp.voidExp;
            }
        }
        Expression exp = this.parseExprSequence(-1, true);
        if (this.curToken == 10) {
            this.unread(10);
        }
        this.maybeSetLine(exp, startLine, startColumn);
        if (this.libraryModuleNamespace != null) {
            this.error('e', "query body in a library module", "XPST0003");
        }
        return exp;
    }

    public void handleOption(Symbol name, String value) {
    }

    public static Expression makeFunctionExp(String className, String name) {
        return XQParser.makeFunctionExp(className, Mangling.mangleNameIfNeeded(name), name);
    }

    public static Expression makeFunctionExp(String className, String fieldName, String name) {
        return new ReferenceExp(name, Declaration.getDeclarationValueFromStatic(className, fieldName, name));
    }

    String tokenString() {
        switch (this.curToken) {
            case 34: {
                StringBuffer sbuf = new StringBuffer();
                sbuf.append('\"');
                for (int i = 0; i < this.tokenBufferLength; ++i) {
                    char ch = this.tokenBuffer[i];
                    if (ch == '\"') {
                        sbuf.append('\"');
                    }
                    sbuf.append(ch);
                }
                sbuf.append('\"');
                return sbuf.toString();
            }
            case 70: {
                return new String(this.tokenBuffer, 0, this.tokenBufferLength) + " + '('";
            }
            case 65: 
            case 81: {
                return new String(this.tokenBuffer, 0, this.tokenBufferLength);
            }
            case -1: {
                return "<EOF>";
            }
        }
        if (this.curToken >= 100 && this.curToken - 100 < 13) {
            return axisNames[this.curToken - 100] + "::-axis(" + this.curToken + ")";
        }
        if (this.curToken >= 32 && this.curToken < 127) {
            return Integer.toString(this.curToken) + "='" + (char)this.curToken + "'";
        }
        return Integer.toString(this.curToken);
    }

    public void error(char severity, String message, String code) {
        SourceMessages messages = this.getMessages();
        SourceError err = new SourceError(severity, this.port.getName(), this.curLine, this.curColumn, message);
        err.code = code;
        messages.error(err);
    }

    @Override
    public void error(char severity, String message) {
        this.error(severity, message, null);
    }

    public Expression declError(String message) throws IOException, SyntaxException {
        if (this.isInteractive()) {
            return this.syntaxError(message);
        }
        this.error(message);
        while (this.curToken != 59 && this.curToken != -1) {
            this.getRawToken();
        }
        return new ErrorExp(message);
    }

    public Expression syntaxError(String message, String code) throws IOException, SyntaxException {
        this.error('e', message, code);
        if (this.isInteractive()) {
            int ch;
            this.curToken = 0;
            this.curValue = null;
            this.nesting = 0;
            this.getPort().readState = (char)10;
            while ((ch = this.read()) >= 0) {
                if (ch != 13 && ch != 10) continue;
                this.unread(ch);
                break;
            }
            throw new SyntaxException(this.getMessages());
        }
        return new ErrorExp(message);
    }

    public Expression syntaxError(String message) throws IOException, SyntaxException {
        return this.syntaxError(message, "XPST0003");
    }

    @Override
    public void eofError(String msg) throws SyntaxException {
        this.fatal(msg, "XPST0003");
    }

    public void fatal(String msg, String code) throws SyntaxException {
        SourceMessages messages = this.getMessages();
        SourceError err = new SourceError('f', this.port.getName(), this.curLine, this.curColumn, msg);
        err.code = code;
        messages.error(err);
        throw new SyntaxException(messages);
    }

    void warnOldVersion(String message) {
        if (warnOldVersion || this.comp.isPedantic()) {
            this.error(this.comp.isPedantic() ? (char)'e' : 'w', message);
        }
    }

    public void maybeSetLine(Expression exp, int line, int column) {
        String file2 = this.getName();
        if (file2 != null && exp.getFileName() == null && !(exp instanceof QuoteExp)) {
            exp.setFile(file2);
            exp.setLine(line, column);
        }
    }

    public void maybeSetLine(Declaration decl, int line, int column) {
        String file2 = this.getName();
        if (file2 != null) {
            decl.setFile(file2);
            decl.setLine(line, column);
        }
    }

    static {
        NamespaceBinding ns = NamespaceBinding.predefinedXML;
        ns = new NamespaceBinding("xml", "http://www.w3.org/XML/1998/namespace", ns);
        ns = new NamespaceBinding("xs", "http://www.w3.org/2001/XMLSchema", ns);
        ns = new NamespaceBinding("xsi", "http://www.w3.org/2001/XMLSchema-instance", ns);
        ns = new NamespaceBinding("fn", "http://www.w3.org/2005/xpath-functions", ns);
        ns = new NamespaceBinding("html", "http://www.w3.org/1999/xhtml", ns);
        ns = new NamespaceBinding("kawa", "http://kawa.gnu.org/", ns);
        ns = new NamespaceBinding("qexo", "http://qexo.gnu.org/", ns);
        builtinNamespaces = ns = new NamespaceBinding("local", "http://www.w3.org/2005/xquery-local-functions", ns);
        getExternalFunction = QuoteExp.getInstance(new PrimProcedure("gnu.xquery.lang.XQuery", "getExternal", 2));
        axisNames = new String[13];
        XQParser.axisNames[0] = "ancestor";
        XQParser.axisNames[1] = "ancestor-or-self";
        XQParser.axisNames[2] = "attribute";
        XQParser.axisNames[3] = "child";
        XQParser.axisNames[4] = "descendant";
        XQParser.axisNames[5] = "descendant-or-self";
        XQParser.axisNames[6] = "following";
        XQParser.axisNames[7] = "following-sibling";
        XQParser.axisNames[8] = "namespace";
        XQParser.axisNames[9] = "parent";
        XQParser.axisNames[10] = "preceding";
        XQParser.axisNames[11] = "preceding-sibling";
        XQParser.axisNames[12] = "self";
    }
}

