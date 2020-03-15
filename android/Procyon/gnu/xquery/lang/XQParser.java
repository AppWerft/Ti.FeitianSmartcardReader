// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.lang;

import gnu.expr.ErrorExp;
import gnu.text.SourceError;
import gnu.expr.Mangling;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleExp;
import java.nio.charset.UnsupportedCharsetException;
import gnu.kawa.io.BinaryInPort;
import gnu.lists.LList;
import kawa.standard.require;
import kawa.lang.Translator;
import java.util.HashMap;
import gnu.expr.ModuleManager;
import gnu.xquery.util.QNameUtils;
import gnu.expr.SetExp;
import gnu.expr.Language;
import java.math.BigDecimal;
import java.util.Stack;
import gnu.kawa.xml.MakeWithBaseUri;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.MakeAttribute;
import gnu.lists.FString;
import java.util.Vector;
import gnu.xquery.util.ValuesFilter;
import gnu.lists.NodePredicate;
import gnu.kawa.xml.ParentAxis;
import gnu.kawa.xml.TreeScanner;
import gnu.xquery.util.RelativeStep;
import gnu.kawa.xml.DescendantOrSelfAxis;
import gnu.expr.ScopeExp;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.expr.LambdaExp;
import gnu.expr.IfExp;
import gnu.xml.TextUtils;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.SingletonType;
import gnu.kawa.xml.XDataType;
import gnu.bytecode.Type;
import gnu.kawa.xml.ProcessingInstructionType;
import gnu.kawa.xml.NodeType;
import gnu.math.IntNum;
import gnu.kawa.reflect.OccurrenceType;
import gnu.expr.BeginExp;
import gnu.bytecode.ClassType;
import gnu.kawa.xml.ElementType;
import gnu.mapping.Procedure;
import gnu.kawa.functions.AppendValues;
import gnu.expr.ApplyExp;
import gnu.text.SourceMessages;
import gnu.xml.XName;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.kawa.io.InPort;
import gnu.mapping.Environment;
import gnu.kawa.io.FilePath;
import gnu.mapping.WrappedException;
import gnu.kawa.io.URIPath;
import gnu.xml.NamespaceBinding;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.PrimProcedure;
import gnu.expr.Declaration;
import gnu.mapping.Namespace;
import gnu.kawa.io.Path;
import gnu.xquery.util.NamedCollator;
import gnu.kawa.functions.Convert;
import gnu.xquery.util.CastableAs;
import gnu.kawa.reflect.InstanceOf;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.util.Map;
import gnu.text.Lexer;

public class XQParser extends Lexer
{
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
    public static boolean warnOldVersion;
    public static boolean warnHidePreviousDeclaration;
    static final Symbol DOT_VARNAME;
    static final Symbol POSITION_VARNAME;
    static final Symbol LAST_VARNAME;
    public static final InstanceOf instanceOf;
    public static final CastableAs castableAs;
    public static final Convert treatAs;
    NamedCollator defaultCollator;
    char defaultEmptyOrder;
    boolean emptyOrderDeclarationSeen;
    private Path baseURI;
    boolean baseURIDeclarationSeen;
    boolean boundarySpacePreserve;
    boolean boundarySpaceDeclarationSeen;
    boolean orderingModeUnordered;
    boolean orderingModeSeen;
    boolean copyNamespacesDeclarationSeen;
    int copyNamespacesMode;
    boolean constructionModeStrip;
    boolean constructionModeDeclarationSeen;
    public Namespace[] functionNamespacePath;
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
    static PrimProcedure proc_OccurrenceType_getInstance;
    public static QuoteExp makeChildAxisStep;
    public static QuoteExp makeDescendantAxisStep;
    int enclosedExpressionsSeen;
    public static Expression makeText;
    static final Expression makeCDATA;
    Compilation comp;
    String defaultElementNamespace;
    NamespaceBinding constructorNamespaces;
    NamespaceBinding prologNamespaces;
    static NamespaceBinding builtinNamespaces;
    public static final QuoteExp getExternalFunction;
    public static final String[] axisNames;
    
    public void setStaticBaseUri(final String uri) {
        try {
            this.baseURI = fixupStaticBaseUri(URIPath.valueOf(uri));
        }
        catch (Exception ex) {
            final Throwable th = (ex instanceof WrappedException) ? ((WrappedException)ex).getCause() : ex;
            this.error('e', "invalid URI: " + th.getMessage());
        }
    }
    
    static Path fixupStaticBaseUri(Path path) {
        path = path.getAbsolute();
        if (path instanceof FilePath) {
            path = URIPath.valueOf(path.toURI());
        }
        return path;
    }
    
    public String getStaticBaseUri() {
        Path path = this.baseURI;
        if (path == null) {
            final Environment env = Environment.getCurrent();
            final Object value = env.get(Symbol.make("", "base-uri"), null, null);
            if (value != null) {
                if (value instanceof Path) {
                    path = path;
                }
                else {
                    path = URIPath.valueOf(value.toString());
                }
            }
            final InPort port;
            if (path == null && (port = this.getPort()) != null) {
                path = port.getPath();
                if (path != null && !path.isPlainFile()) {
                    path = null;
                }
            }
            if (path == null) {
                path = Path.currentPath();
            }
            path = fixupStaticBaseUri(path);
            this.baseURI = path;
        }
        return path.toString();
    }
    
    public String resolveAgainstBaseUri(final String uri) {
        if (Path.uriSchemeSpecified(uri)) {
            return uri;
        }
        final String base = this.getStaticBaseUri();
        final Path basePath = Path.valueOf(base);
        return basePath.resolve(uri).toString();
    }
    
    final int skipSpace() throws IOException, SyntaxException {
        return this.skipSpace(true);
    }
    
    final int skipSpace(final boolean verticalToo) throws IOException, SyntaxException {
        int ch;
        while (true) {
            ch = this.read();
            if (ch == 40) {
                if (!this.checkNext(':')) {
                    return 40;
                }
                this.skipComment();
            }
            else if (ch == 123) {
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
            }
            else if (verticalToo) {
                if (ch < 0) {
                    break;
                }
                if (!Character.isWhitespace((char)ch)) {
                    break;
                }
                continue;
            }
            else {
                if (ch != 32 && ch != 9) {
                    break;
                }
                continue;
            }
        }
        return ch;
    }
    
    final void skipToSemicolon() throws IOException {
        int next;
        do {
            next = this.read();
        } while (next >= 0 && next != 59);
    }
    
    final void skipOldComment() throws IOException, SyntaxException {
        int seenDashes = 0;
        final int startLine = this.getLineNumber() + 1;
        final int startColumn = this.getColumnNumber() - 2;
        this.warnOldVersion("use (: :) instead of old-style comment {-- --}");
        while (true) {
            final int ch = this.read();
            if (ch == 45) {
                ++seenDashes;
            }
            else {
                if (ch == 125 && seenDashes >= 2) {
                    break;
                }
                if (ch < 0) {
                    this.curLine = startLine;
                    this.curColumn = startColumn;
                    this.eofError("non-terminated comment starting here");
                }
                else {
                    seenDashes = 0;
                }
            }
        }
    }
    
    final void skipComment() throws IOException, SyntaxException {
        ++this.commentCount;
        final int startLine = this.getLineNumber() + 1;
        final int startColumn = this.getColumnNumber() - 1;
        if (this.errorIfComment != null) {
            this.curLine = startLine;
            this.curColumn = startColumn;
            this.error('e', this.errorIfComment);
        }
        int prev = 0;
        int commentNesting = 0;
        final char saveReadState = this.pushNesting(':');
        while (true) {
            int ch = this.read();
            if (ch == 58) {
                if (prev == 40) {
                    ++commentNesting;
                    ch = 0;
                }
            }
            else if (ch == 41 && prev == 58) {
                if (commentNesting == 0) {
                    break;
                }
                --commentNesting;
            }
            else if (ch < 0) {
                this.curLine = startLine;
                this.curColumn = startColumn;
                this.eofError("non-terminated comment starting here");
            }
            prev = ch;
        }
        this.popNesting(saveReadState);
    }
    
    final int peekNonSpace(final String message) throws IOException, SyntaxException {
        final int ch = this.skipSpace();
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
    
    private int setToken(final int token, final int width) {
        this.curToken = token;
        this.curLine = this.port.getLineNumber() + 1;
        this.curColumn = this.port.getColumnNumber() + 1 - width;
        return token;
    }
    
    void checkSeparator(final char ch) {
        if (XName.isNameStart(ch)) {
            this.error('e', "missing separator", "XPST0003");
        }
    }
    
    int getRawToken() throws IOException, SyntaxException {
        while (true) {
            int next = this.readUnicodeChar();
            if (next < 0) {
                return this.setToken(-1, 0);
            }
            if (next == 10 || next == 13) {
                if (this.nesting <= 0) {
                    return this.setToken(10, 0);
                }
                continue;
            }
            else if (next == 40) {
                if (this.checkNext(':')) {
                    this.skipComment();
                }
                else {
                    if (this.checkNext('#')) {
                        return this.setToken(197, 2);
                    }
                    return this.setToken(40, 1);
                }
            }
            else if (next == 123) {
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
            }
            else {
                if (next != 32 && next != 9) {
                    this.tokenBufferLength = 0;
                    this.curLine = this.port.getLineNumber() + 1;
                    this.curColumn = this.port.getColumnNumber();
                    char ch = (char)next;
                    switch (ch) {
                        case '$':
                        case ')':
                        case ',':
                        case ';':
                        case '?':
                        case '@':
                        case '[':
                        case ']':
                        case '}': {
                            break;
                        }
                        case ':': {
                            if (this.checkNext('=')) {
                                ch = 'L';
                                break;
                            }
                            if (this.checkNext(':')) {
                                ch = 'X';
                                break;
                            }
                            break;
                        }
                        case '|': {
                            ch = '\u01a3';
                            break;
                        }
                        case '*': {
                            ch = '\u019f';
                            break;
                        }
                        case '+': {
                            ch = '\u019d';
                            break;
                        }
                        case '-': {
                            ch = '\u019e';
                            break;
                        }
                        case '!': {
                            if (this.checkNext('=')) {
                                ch = '\u0193';
                                break;
                            }
                            break;
                        }
                        case '/': {
                            if (this.checkNext('/')) {
                                ch = 'D';
                                break;
                            }
                            break;
                        }
                        case '=': {
                            if (this.checkNext('>')) {
                                ch = 'R';
                            }
                            ch = '\u0192';
                            break;
                        }
                        case '>': {
                            ch = (this.checkNext('=') ? '\u0197' : (this.checkNext('>') ? '\u019a' : '\u0195'));
                            break;
                        }
                        case '<': {
                            ch = (this.checkNext('=') ? '\u0196' : (this.checkNext('<') ? '\u019b' : '\u0194'));
                            break;
                        }
                        case '\"':
                        case '\'': {
                            final char saveReadState = this.pushNesting((char)next);
                            while (true) {
                                next = this.readUnicodeChar();
                                if (next < 0) {
                                    this.eofError("unexpected end-of-file in string starting here");
                                }
                                if (next == 38) {
                                    this.parseEntityOrCharRef();
                                }
                                else {
                                    if (ch == next) {
                                        next = this.peek();
                                        if (ch != next) {
                                            break;
                                        }
                                        next = this.read();
                                    }
                                    this.tokenBufferAppend(next);
                                }
                            }
                            this.popNesting(saveReadState);
                            ch = '\"';
                            break;
                        }
                        default: {
                            if (Character.isDigit(ch) || (ch == '.' && Character.isDigit((char)this.peek()))) {
                                boolean seenDot = ch == '.';
                                while (true) {
                                    this.tokenBufferAppend(ch);
                                    next = this.read();
                                    if (next < 0) {
                                        break;
                                    }
                                    ch = (char)next;
                                    if (ch == '.') {
                                        if (seenDot) {
                                            break;
                                        }
                                        seenDot = true;
                                    }
                                    else {
                                        if (!Character.isDigit(ch)) {
                                            break;
                                        }
                                        continue;
                                    }
                                }
                                Label_1075: {
                                    if (next == 101 || next == 69) {
                                        this.tokenBufferAppend((char)next);
                                        next = this.read();
                                        if (next == 43 || next == 45) {
                                            this.tokenBufferAppend(next);
                                            next = this.read();
                                        }
                                        while (true) {
                                            for (int expDigits = 0; next >= 0; next = this.read(), ++expDigits) {
                                                ch = (char)next;
                                                if (!Character.isDigit(ch)) {
                                                    this.checkSeparator(ch);
                                                    this.unread();
                                                    if (expDigits == 0) {
                                                        this.error('e', "no digits following exponent", "XPST0003");
                                                    }
                                                    ch = '2';
                                                    break Label_1075;
                                                }
                                                this.tokenBufferAppend(ch);
                                            }
                                            continue;
                                        }
                                    }
                                    ch = (seenDot ? '1' : '0');
                                    if (next >= 0) {
                                        this.checkSeparator((char)next);
                                        this.unread(next);
                                    }
                                }
                                break;
                            }
                            if (ch == '.') {
                                if (this.checkNext('.')) {
                                    ch = '3';
                                    break;
                                }
                                break;
                            }
                            else if (XName.isNameStart(ch)) {
                                do {
                                    this.tokenBufferAppend(ch);
                                    next = this.read();
                                    ch = (char)next;
                                } while (XName.isNamePart(ch));
                                if (next < 0) {
                                    ch = 'A';
                                    break;
                                }
                                if (next != 58) {
                                    ch = 'A';
                                }
                                else {
                                    next = this.read();
                                    if (next < 0) {
                                        this.eofError("unexpected end-of-file after NAME ':'");
                                    }
                                    ch = (char)next;
                                    if (XName.isNameStart(ch)) {
                                        this.tokenBufferAppend(58);
                                        do {
                                            this.tokenBufferAppend(ch);
                                            next = this.read();
                                            ch = (char)next;
                                        } while (XName.isNamePart(ch));
                                        ch = 'Q';
                                    }
                                    else if (ch == '=') {
                                        this.unread(ch);
                                        ch = 'A';
                                    }
                                    else {
                                        ch = 'C';
                                    }
                                }
                                this.unread(next);
                                break;
                            }
                            else {
                                if (ch >= ' ' && ch < '\u007f') {
                                    this.syntaxError("invalid character '" + ch + '\'');
                                    break;
                                }
                                this.syntaxError("invalid character '\\u" + Integer.toHexString(ch) + '\'');
                                break;
                            }
                            break;
                        }
                    }
                    return this.curToken = ch;
                }
                continue;
            }
        }
    }
    
    public void getDelimited(final String delimiter) throws IOException, SyntaxException {
        if (!this.readDelimited(delimiter)) {
            this.eofError("unexpected end-of-file looking for '" + delimiter + '\'');
        }
    }
    
    public void appendNamedEntity(String name) {
        name = name.intern();
        char ch = '?';
        if (name == "lt") {
            ch = '<';
        }
        else if (name == "gt") {
            ch = '>';
        }
        else if (name == "amp") {
            ch = '&';
        }
        else if (name == "quot") {
            ch = '\"';
        }
        else if (name == "apos") {
            ch = '\'';
        }
        else {
            this.error("unknown enity reference: '" + name + "'");
        }
        this.tokenBufferAppend(ch);
    }
    
    boolean match(final String word1, final String word2, final boolean force) throws IOException, SyntaxException {
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
            final int len = this.tokenBufferLength;
            switch (len) {
                case 2: {
                    final char c1 = this.tokenBuffer[0];
                    final char c2 = this.tokenBuffer[1];
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
                        if (c2 == 't') {
                            this.curToken = 430;
                            break;
                        }
                        break;
                    }
                    else {
                        if (c1 != 'l') {
                            break;
                        }
                        if (c2 == 'e') {
                            this.curToken = 429;
                            break;
                        }
                        if (c2 == 't') {
                            this.curToken = 428;
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 3: {
                    final char c1 = this.tokenBuffer[0];
                    final char c2 = this.tokenBuffer[1];
                    final char c3 = this.tokenBuffer[2];
                    if (c1 == 'a') {
                        if (c2 == 'n' && c3 == 'd') {
                            this.curToken = 401;
                            break;
                        }
                        break;
                    }
                    else if (c1 == 'm') {
                        if (c2 == 'u' && c3 == 'l') {
                            this.curToken = 415;
                        }
                        if (c2 == 'o' && c3 == 'd') {
                            this.curToken = 418;
                            break;
                        }
                        break;
                    }
                    else {
                        if (c1 == 'd' && c2 == 'i' && c3 == 'v') {
                            this.curToken = 416;
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 4: {
                    if (this.match("idiv")) {
                        this.curToken = 417;
                        break;
                    }
                    if (this.match("cast", "as", true)) {
                        this.curToken = 425;
                        break;
                    }
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
                    if (this.match("treat", "as", true)) {
                        this.curToken = 423;
                        break;
                    }
                    break;
                }
                case 6: {
                    if (this.match("except")) {
                        this.curToken = 421;
                        break;
                    }
                    break;
                }
                case 8: {
                    if (this.match("instance", "of", true)) {
                        this.curToken = 422;
                        break;
                    }
                    if (this.match("castable", "as", true)) {
                        this.curToken = 424;
                        break;
                    }
                    break;
                }
                case 9: {
                    if (this.match("intersect")) {
                        this.curToken = 420;
                        break;
                    }
                    break;
                }
                case 10: {
                    if (this.match("instanceof")) {
                        this.warnOldVersion("use 'instanceof of' (two words) instead of 'instanceof'");
                        this.curToken = 422;
                        break;
                    }
                    break;
                }
            }
        }
        return this.curToken;
    }
    
    private boolean lookingAt(final String word0, final String word1) throws IOException, SyntaxException {
        if (!word0.equals(this.curValue)) {
            return false;
        }
        int i = 0;
        final int len = word1.length();
        while (true) {
            final int ch = this.read();
            if (i == len) {
                if (ch < 0) {
                    return true;
                }
                if (!XName.isNamePart((char)ch)) {
                    this.unread();
                    return true;
                }
                ++i;
                break;
            }
            else {
                if (ch < 0) {
                    break;
                }
                if (ch != word1.charAt(i++)) {
                    break;
                }
                continue;
            }
        }
        this.port.skip(-i);
        return false;
    }
    
    int getAxis() {
        final String name = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
        int i = 13;
        while (--i >= 0 && XQParser.axisNames[i] != name) {}
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
        if (this.curToken != 65 && this.curToken != 81) {
            if (this.curToken == 67) {
                final int next = this.read();
                if (next == 58) {
                    this.curToken = this.getAxis();
                }
                else {
                    this.unread(next);
                }
            }
            return this.curToken;
        }
        final int next = this.skipSpace(this.nesting != 0);
        switch (this.tokenBuffer[0]) {
            case 'a': {
                if (!this.match("attribute")) {
                    break;
                }
                if (next == 40) {
                    return this.curToken = 236;
                }
                if (next == 123 || XName.isNameStart((char)next)) {
                    this.unread();
                    return this.curToken = 252;
                }
                break;
            }
            case 'c': {
                if (!this.match("comment")) {
                    break;
                }
                if (next == 40) {
                    return this.curToken = 232;
                }
                if (next == 123) {
                    this.unread();
                    return this.curToken = 254;
                }
                break;
            }
            case 'd': {
                if (next == 123 && this.match("document")) {
                    this.unread();
                    return this.curToken = 256;
                }
                if (next == 40 && this.match("document-node")) {
                    return this.curToken = 234;
                }
                break;
            }
            case 'e': {
                if (this.match("element")) {
                    if (next == 40) {
                        return this.curToken = 235;
                    }
                    if (next == 123 || XName.isNameStart((char)next)) {
                        this.unread();
                        return this.curToken = 251;
                    }
                    break;
                }
                else {
                    if (next == 40 && this.match("empty-sequence")) {
                        return this.curToken = 238;
                    }
                    if (next == 36 && this.match("every")) {
                        return this.curToken = 246;
                    }
                    break;
                }
                break;
            }
            case 'f': {
                if (next == 36 && this.match("for")) {
                    return this.curToken = 243;
                }
                break;
            }
            case 'i': {
                if (next == 40 && this.match("if")) {
                    return this.curToken = 241;
                }
                if (next == 40 && this.match("item")) {
                    return this.curToken = 237;
                }
                break;
            }
            case 'l': {
                if (next == 36 && this.match("let")) {
                    return this.curToken = 244;
                }
                break;
            }
            case 'n': {
                if (next == 40 && this.match("node")) {
                    return this.curToken = 230;
                }
                break;
            }
            case 'o': {
                if (next == 123 && this.match("ordered")) {
                    return this.curToken = 249;
                }
                break;
            }
            case 'p': {
                if (!this.match("processing-instruction")) {
                    break;
                }
                if (next == 40) {
                    return this.curToken = 233;
                }
                if (next == 123 || XName.isNameStart((char)next)) {
                    this.unread();
                    return this.curToken = 255;
                }
                break;
            }
            case 's': {
                if (next == 36 && this.match("some")) {
                    return this.curToken = 245;
                }
                if (next == 40 && this.match("schema-attribute")) {
                    return this.curToken = 239;
                }
                if (next == 40 && this.match("schema-element")) {
                    return this.curToken = 240;
                }
                break;
            }
            case 't': {
                if (this.match("text")) {
                    if (next == 40) {
                        return this.curToken = 231;
                    }
                    if (next == 123) {
                        this.unread();
                        return this.curToken = 253;
                    }
                }
                if (next == 40 && this.match("typeswitch")) {
                    return this.curToken = 242;
                }
                break;
            }
            case 'u': {
                if (next == 123 && this.match("unordered")) {
                    return this.curToken = 250;
                }
                break;
            }
            case 'v': {
                if (next == 123 && this.match("validate")) {
                    return this.curToken = 248;
                }
                break;
            }
        }
        if (next == 40 && this.peek() != 58) {
            return this.curToken = 70;
        }
        if (next == 58 && this.peek() == 58) {
            return this.curToken = this.getAxis();
        }
        final String name = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        this.curValue = name;
        Label_1139: {
            switch (next) {
                case 98: {
                    if (this.lookingAt("declare", "ase-uri")) {
                        return this.curToken = 66;
                    }
                    if (this.lookingAt("declare", "oundary-space")) {
                        return this.curToken = 83;
                    }
                    break;
                }
                case 99: {
                    if (this.lookingAt("declare", "onstruction")) {
                        return this.curToken = 75;
                    }
                    if (this.lookingAt("declare", "opy-namespaces")) {
                        return this.curToken = 76;
                    }
                    break;
                }
                case 100: {
                    if (!this.lookingAt("declare", "efault")) {
                        break Label_1139;
                    }
                    this.getRawToken();
                    if (this.match("function")) {
                        return this.curToken = 79;
                    }
                    if (this.match("element")) {
                        return this.curToken = 69;
                    }
                    if (this.match("collation")) {
                        return this.curToken = 71;
                    }
                    if (this.match("order")) {
                        return this.curToken = 72;
                    }
                    this.error("unrecognized/unimplemented 'declare default'");
                    this.skipToSemicolon();
                    return this.peekOperand();
                }
                case 101: {
                    if (this.lookingAt("default", "lement")) {
                        this.warnOldVersion("replace 'default element' by 'declare default element namespace'");
                        return this.curToken = 69;
                    }
                    break;
                }
                case 102: {
                    if (this.lookingAt("declare", "unction")) {
                        return this.curToken = 80;
                    }
                    if (this.lookingAt("define", "unction")) {
                        this.warnOldVersion("replace 'define function' by 'declare function'");
                        return this.curToken = 80;
                    }
                    if (this.lookingAt("default", "unction")) {
                        this.warnOldVersion("replace 'default function' by 'declare default function namespace'");
                        return this.curToken = 79;
                    }
                    break;
                }
                case 109: {
                    if (this.lookingAt("import", "odule")) {
                        return this.curToken = 73;
                    }
                    break;
                }
                case 110: {
                    if (this.lookingAt("declare", "amespace")) {
                        return this.curToken = 78;
                    }
                    if (this.lookingAt("default", "amespace")) {
                        this.warnOldVersion("replace 'default namespace' by 'declare default element namespace'");
                        return this.curToken = 69;
                    }
                    if (this.lookingAt("module", "amespace")) {
                        return this.curToken = 77;
                    }
                    break;
                }
                case 111: {
                    if (this.lookingAt("declare", "rdering")) {
                        return this.curToken = 85;
                    }
                    if (this.lookingAt("declare", "ption")) {
                        return this.curToken = 111;
                    }
                    break;
                }
                case 115: {
                    if (this.lookingAt("import", "chema")) {
                        return this.curToken = 84;
                    }
                    break;
                }
                case 118: {
                    if (this.lookingAt("declare", "ariable")) {
                        return this.curToken = 86;
                    }
                    if (this.lookingAt("define", "ariable")) {
                        this.warnOldVersion("replace 'define variable' by 'declare variable'");
                        return this.curToken = 86;
                    }
                    if (this.lookingAt("xquery", "ersion")) {
                        return this.curToken = 89;
                    }
                    break;
                }
                case 120: {
                    if (this.lookingAt("declare", "mlspace")) {
                        this.warnOldVersion("replace 'define xmlspace' by 'declare boundary-space'");
                        return this.curToken = 83;
                    }
                    break;
                }
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
    
    void checkAllowedNamespaceDeclaration(final String prefix, final String uri, final boolean inConstructor) {
        final boolean xmlPrefix = "xml".equals(prefix);
        if ("http://www.w3.org/XML/1998/namespace".equals(uri)) {
            if (!xmlPrefix || !inConstructor) {
                this.error('e', "namespace uri cannot be the same as the prefined xml namespace", "XQST0070");
            }
        }
        else if (xmlPrefix || "xmlns".equals(prefix)) {
            this.error('e', "namespace prefix cannot be 'xml' or 'xmlns'", "XQST0070");
        }
    }
    
    void pushNamespace(final String prefix, String uri) {
        if (uri.length() == 0) {
            uri = null;
        }
        this.prologNamespaces = new NamespaceBinding(prefix, uri, this.prologNamespaces);
    }
    
    public XQParser(final InPort port, final SourceMessages messages, final XQuery interp) {
        super(port, messages);
        this.defaultCollator = null;
        this.defaultEmptyOrder = 'L';
        this.baseURI = null;
        this.copyNamespacesMode = 3;
        this.functionNamespacePath = XQuery.defaultFunctionNamespacePath;
        this.defaultElementNamespace = "";
        this.constructorNamespaces = NamespaceBinding.predefinedXML;
        this.interpreter = interp;
        this.nesting = 1;
        final NamespaceBinding ns = XQParser.builtinNamespaces;
        this.prologNamespaces = ns;
    }
    
    @Override
    public void setInteractive(final boolean v) {
        if (this.isInteractive() != v) {
            if (v) {
                --this.nesting;
            }
            else {
                ++this.nesting;
            }
        }
        super.setInteractive(v);
    }
    
    private static final int priority(final int opcode) {
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
            default: {
                return 0;
            }
        }
    }
    
    static Expression makeBinary(final Expression func, final Expression exp1, final Expression exp2) {
        final Expression[] args = { exp1, exp2 };
        return new ApplyExp(func, args);
    }
    
    static Expression makeExprSequence(final Expression exp1, final Expression exp2) {
        return new ApplyExp(AppendValues.appendValues, new Expression[] { exp1, exp2 });
    }
    
    Expression makeBinary(final int op, final Expression exp1, final Expression exp2) throws IOException, SyntaxException {
        Expression func = null;
        switch (op) {
            case 413: {
                func = makeFunctionExp("gnu.xquery.util.ArithOp", "add", "+");
                break;
            }
            case 414: {
                func = makeFunctionExp("gnu.xquery.util.ArithOp", "sub", "-");
                break;
            }
            case 415: {
                func = makeFunctionExp("gnu.xquery.util.ArithOp", "mul", "*");
                break;
            }
            case 416: {
                func = makeFunctionExp("gnu.xquery.util.ArithOp", "div", "div");
                break;
            }
            case 417: {
                func = makeFunctionExp("gnu.xquery.util.ArithOp", "idiv", "idiv");
                break;
            }
            case 418: {
                func = makeFunctionExp("gnu.xquery.util.ArithOp", "mod", "mod");
                break;
            }
            case 426: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "valEq", "eq");
                break;
            }
            case 427: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "valNe", "ne");
                break;
            }
            case 428: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "valLt", "lt");
                break;
            }
            case 429: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "valLe", "le");
                break;
            }
            case 430: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "valGt", "gt");
                break;
            }
            case 431: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "valGe", "ge");
                break;
            }
            case 402: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "=");
                break;
            }
            case 403: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "!=");
                break;
            }
            case 404: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "<");
                break;
            }
            case 406: {
                func = makeFunctionExp("gnu.xquery.util.Compare", "<=");
                break;
            }
            case 405: {
                func = makeFunctionExp("gnu.xquery.util.Compare", ">");
                break;
            }
            case 407: {
                func = makeFunctionExp("gnu.xquery.util.Compare", ">=");
                break;
            }
            case 408: {
                func = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Eq", "is");
                break;
            }
            case 409: {
                func = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Ne", "isnot");
                break;
            }
            case 410: {
                func = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Gr", ">>");
                break;
            }
            case 411: {
                func = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Ls", "<<");
                break;
            }
            case 412: {
                func = makeFunctionExp("kawa.lib.xquery.Xutils", "integerRange");
                break;
            }
            case 419: {
                func = makeFunctionExp("gnu.kawa.xml.UnionNodes", "unionNodes");
                break;
            }
            case 420: {
                func = makeFunctionExp("gnu.kawa.xml.IntersectNodes", "intersectNodes");
                break;
            }
            case 421: {
                func = makeFunctionExp("gnu.kawa.xml.IntersectNodes", "exceptNodes");
                break;
            }
            default: {
                return this.syntaxError("unimplemented binary op: " + op);
            }
        }
        return makeBinary(func, exp1, exp2);
    }
    
    private void parseSimpleKindType() throws IOException, SyntaxException {
        this.getRawToken();
        if (this.curToken == 41) {
            this.getRawToken();
        }
        else {
            this.error("expected ')'");
        }
    }
    
    public Expression parseNamedNodeType(final boolean attribute) throws IOException, SyntaxException {
        Expression tname = null;
        this.getRawToken();
        Expression qname;
        if (this.curToken == 41) {
            qname = QuoteExp.getInstance(ElementType.MATCH_ANY_QNAME);
            this.getRawToken();
        }
        else {
            if (this.curToken == 81 || this.curToken == 65) {
                qname = this.parseNameTest(attribute);
            }
            else {
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
                }
                else {
                    this.syntaxError("expected QName");
                }
            }
            if (this.curToken == 41) {
                this.getRawToken();
            }
            else {
                this.error("expected ')' after element");
            }
        }
        return makeNamedNodeType(attribute, qname, tname);
    }
    
    static Expression makeNamedNodeType(final boolean attribute, final Expression qname, final Expression tname) {
        final Expression[] name = new Expression[2];
        final ClassType nodeType = ClassType.make(attribute ? "gnu.kawa.xml.AttributeType" : "gnu.kawa.xml.ElementType");
        final ApplyExp elt = new ApplyExp(nodeType.getDeclaredMethod("make", 1), new Expression[] { qname });
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
        Expression etype = this.parseItemType();
        int min;
        int max;
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
        }
        else if (this.curToken == 63) {
            min = 0;
            max = 1;
        }
        else if (this.curToken == 413) {
            min = 1;
            max = -1;
        }
        else if (this.curToken == 415) {
            min = 0;
            max = -1;
        }
        else {
            min = 1;
            max = 1;
        }
        if (this.parseContext == 67 && max != 1) {
            return this.syntaxError("type to 'cast as' or 'castable as' must be a 'SingleType'");
        }
        if (min != max) {
            this.getRawToken();
            final Expression[] args = { etype, QuoteExp.getInstance(IntNum.make(min)), QuoteExp.getInstance(IntNum.make(max)) };
            final ApplyExp otype = new ApplyExp(XQParser.proc_OccurrenceType_getInstance, args);
            otype.setFlag(4);
            return otype;
        }
        return etype;
    }
    
    public Expression parseMaybeKindTest() throws IOException, SyntaxException {
        Type type = null;
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
                }
                else {
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
    
    public Expression parseItemType() throws IOException, SyntaxException {
        this.peekOperand();
        final Expression etype = this.parseMaybeKindTest();
        Type type;
        if (etype != null) {
            if (this.parseContext != 67) {
                return etype;
            }
            type = XDataType.anyAtomicType;
        }
        else if (this.curToken == 237) {
            this.parseSimpleKindType();
            type = SingletonType.getInstance();
        }
        else {
            if (this.curToken == 65 || this.curToken == 81) {
                final String tname = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                final ReferenceExp rexp = new ReferenceExp((Object)tname);
                rexp.setFlag(16);
                this.maybeSetLine(rexp, this.curLine, this.curColumn);
                this.getRawToken();
                return rexp;
            }
            return null;
        }
        return QuoteExp.getInstance(type);
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
        final int startLine = this.curLine;
        final int startColumn = this.curColumn;
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
            default: {
                return this.parseBinaryExpr(priority(400));
            }
        }
    }
    
    Expression parseBinaryExpr(final int prio) throws IOException, SyntaxException {
        Expression exp = this.parseUnaryExpr();
        while (true) {
            final int token = this.peekOperator();
            if (token == 10 || (token == 404 && this.peek() == 47)) {
                return exp;
            }
            final int tokPriority = priority(token);
            if (tokPriority < prio) {
                return exp;
            }
            final char saveReadState = this.pushNesting('%');
            this.getRawToken();
            this.popNesting(saveReadState);
            if (token >= 422 && token <= 425) {
                if (token == 425 || token == 424) {
                    this.parseContext = 67;
                }
                final Expression type = this.parseDataType();
                this.parseContext = 0;
                final Expression[] args = new Expression[2];
                Expression func = null;
                switch (token) {
                    case 422: {
                        args[0] = exp;
                        args[1] = type;
                        func = makeFunctionExp("gnu.xquery.lang.XQParser", "instanceOf");
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
                        func = makeFunctionExp("gnu.xquery.lang.XQParser", "treatAs");
                        break;
                    }
                    default: {
                        args[0] = type;
                        args[1] = exp;
                        func = new ReferenceExp(XQResolveNames.castAsDecl);
                        break;
                    }
                }
                exp = new ApplyExp(func, args);
            }
            else if (token == 422) {
                final Expression[] args2 = { exp, this.parseDataType() };
                exp = new ApplyExp(makeFunctionExp("gnu.xquery.lang.XQParser", "instanceOf"), args2);
            }
            else {
                final Expression exp2 = this.parseBinaryExpr(tokPriority + 1);
                if (token == 401) {
                    exp = new IfExp(booleanValue(exp), booleanValue(exp2), XQuery.falseExp);
                }
                else if (token == 400) {
                    exp = new IfExp(booleanValue(exp), XQuery.trueExp, booleanValue(exp2));
                }
                else {
                    exp = this.makeBinary(token, exp, exp2);
                }
            }
        }
    }
    
    Expression parseUnaryExpr() throws IOException, SyntaxException {
        Expression exp;
        if (this.curToken == 414 || this.curToken == 413) {
            final int op = this.curToken;
            this.getRawToken();
            exp = this.parseUnaryExpr();
            final Expression func = makeFunctionExp("gnu.xquery.util.ArithOp", (op == 413) ? "plus" : "minus", (op == 413) ? "+" : "-");
            exp = new ApplyExp(func, new Expression[] { exp });
        }
        else {
            exp = this.parseUnionExpr();
        }
        return exp;
    }
    
    Expression parseUnionExpr() throws IOException, SyntaxException {
        Expression exp = this.parseIntersectExceptExpr();
        while (true) {
            final int op = this.peekOperator();
            if (op != 419) {
                break;
            }
            this.getRawToken();
            final Expression exp2 = this.parseIntersectExceptExpr();
            exp = this.makeBinary(op, exp, exp2);
        }
        return exp;
    }
    
    Expression parseIntersectExceptExpr() throws IOException, SyntaxException {
        Expression exp = this.parsePathExpr();
        while (true) {
            final int op = this.peekOperator();
            if (op != 420 && op != 421) {
                break;
            }
            this.getRawToken();
            final Expression exp2 = this.parsePathExpr();
            exp = this.makeBinary(op, exp, exp2);
        }
        return exp;
    }
    
    Expression parsePathExpr() throws IOException, SyntaxException {
        Expression step1;
        if (this.curToken == 47 || this.curToken == 68) {
            final Declaration dotDecl = this.comp.lexical.lookup(XQParser.DOT_VARNAME, false);
            Expression dot;
            if (dotDecl == null) {
                dot = this.syntaxError("context item is undefined", "XPDY0002");
            }
            else {
                dot = new ReferenceExp(XQParser.DOT_VARNAME, dotDecl);
            }
            step1 = new ApplyExp(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("rootDocument", 1), new Expression[] { dot });
            final int next = this.skipSpace(this.nesting != 0);
            this.unread(next);
            if (next < 0 || next == 41 || next == 125) {
                this.getRawToken();
                return step1;
            }
        }
        else {
            step1 = this.parseStepExpr();
        }
        return this.parseRelativePathExpr(step1);
    }
    
    Expression parseNameTest(final boolean attribute) throws IOException, SyntaxException {
        String local = null;
        String prefix = null;
        if (this.curToken == 81) {
            int colon = this.tokenBufferLength;
            while (this.tokenBuffer[--colon] != ':') {}
            prefix = new String(this.tokenBuffer, 0, colon);
            ++colon;
            local = new String(this.tokenBuffer, colon, this.tokenBufferLength - colon);
        }
        else {
            if (this.curToken == 415) {
                int next = this.read();
                local = "";
                if (next != 58) {
                    this.unread(next);
                }
                else {
                    next = this.read();
                    if (next < 0) {
                        this.eofError("unexpected end-of-file after '*:'");
                    }
                    if (XName.isNameStart((char)next)) {
                        this.unread();
                        this.getRawToken();
                        if (this.curToken != 65) {
                            this.syntaxError("invalid name test");
                        }
                        else {
                            local = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
                        }
                    }
                    else if (next != 42) {
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
            }
            else if (this.curToken == 67) {
                prefix = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                final int next = this.read();
                if (next != 42) {
                    this.syntaxError("invalid characters after 'NCName:'");
                }
                local = "";
            }
        }
        if (prefix != null) {
            prefix = prefix.intern();
        }
        final Expression[] args = { new ApplyExp(new ReferenceExp(XQResolveNames.resolvePrefixDecl), new Expression[] { QuoteExp.getInstance(prefix) }), new QuoteExp((Object)((local == null) ? "" : local)), new QuoteExp((Object)prefix) };
        final ApplyExp make = new ApplyExp(Compilation.typeSymbol.getDeclaredMethod("make", 3), args);
        make.setFlag(4);
        return make;
    }
    
    Expression parseNodeTest(final int axis) throws IOException, SyntaxException {
        final int token = this.peekOperand();
        final Expression[] args = { null };
        final Expression etype = this.parseMaybeKindTest();
        if (etype != null) {
            args[0] = etype;
        }
        else if (this.curToken == 65 || this.curToken == 81 || this.curToken == 67 || this.curToken == 415) {
            args[0] = makeNamedNodeType(axis == 2, this.parseNameTest(axis == 2), null);
        }
        else {
            if (axis >= 0) {
                return this.syntaxError("unsupported axis '" + XQParser.axisNames[axis] + "::'");
            }
            return null;
        }
        final Declaration dotDecl = this.comp.lexical.lookup(XQParser.DOT_VARNAME, false);
        Expression dot;
        if (dotDecl == null) {
            dot = this.syntaxError("node test when context item is undefined", "XPDY0002");
        }
        else {
            dot = new ReferenceExp(XQParser.DOT_VARNAME, dotDecl);
        }
        if (etype == null) {
            this.getRawToken();
        }
        Expression makeAxisStep;
        if (axis == 3 || axis == -1) {
            makeAxisStep = XQParser.makeChildAxisStep;
        }
        else if (axis == 4) {
            makeAxisStep = XQParser.makeDescendantAxisStep;
        }
        else {
            String axisName = null;
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
        final ApplyExp mkAxis = new ApplyExp(makeAxisStep, args);
        mkAxis.setFlag(4);
        return new ApplyExp(mkAxis, new Expression[] { dot });
    }
    
    Expression parseRelativePathExpr(Expression exp) throws IOException, SyntaxException {
        Expression beforeSlashSlash = null;
        while (this.curToken == 47 || this.curToken == 68) {
            final boolean descendants = this.curToken == 68;
            final LambdaExp lexp = new LambdaExp(3);
            final Declaration dotDecl = lexp.addDeclaration(XQParser.DOT_VARNAME);
            dotDecl.setFlag(262144L);
            dotDecl.setType(NodeType.anyNodeTest);
            dotDecl.noteValueUnknown();
            lexp.addDeclaration(XQParser.POSITION_VARNAME, LangPrimType.intType);
            lexp.addDeclaration(XQParser.LAST_VARNAME, LangPrimType.intType);
            this.comp.push(lexp);
            if (descendants) {
                this.curToken = 47;
                final Expression dot = new ReferenceExp(XQParser.DOT_VARNAME, dotDecl);
                final Expression[] args = { dot };
                final TreeScanner op = DescendantOrSelfAxis.anyNode;
                lexp.body = new ApplyExp(op, args);
                beforeSlashSlash = exp;
            }
            else {
                this.getRawToken();
                final Expression exp2 = this.parseStepExpr();
                final Expression func;
                final ApplyExp aexp;
                if (beforeSlashSlash != null && exp2 instanceof ApplyExp && (func = ((ApplyExp)exp2).getFunction()) instanceof ApplyExp && (aexp = (ApplyExp)func).getFunction() == XQParser.makeChildAxisStep) {
                    aexp.setFunction(XQParser.makeDescendantAxisStep);
                    exp = beforeSlashSlash;
                }
                lexp.body = exp2;
                beforeSlashSlash = null;
            }
            this.comp.pop(lexp);
            final Expression[] args2 = { exp, lexp };
            exp = new ApplyExp(RelativeStep.relativeStep, args2);
        }
        return exp;
    }
    
    Expression parseStepExpr() throws IOException, SyntaxException {
        if (this.curToken == 46 || this.curToken == 51) {
            final int axis = (this.curToken == 46) ? 12 : 9;
            this.getRawToken();
            final Declaration dotDecl = this.comp.lexical.lookup(XQParser.DOT_VARNAME, false);
            Expression exp;
            if (dotDecl == null) {
                exp = this.syntaxError("context item is undefined", "XPDY0002");
            }
            else {
                exp = new ReferenceExp(XQParser.DOT_VARNAME, dotDecl);
            }
            if (axis == 9) {
                final Expression[] args = { exp };
                exp = new ApplyExp(ParentAxis.make(NodeType.anyNodeTest), args);
            }
            return this.parseStepQualifiers(exp, (axis == 12) ? -1 : axis);
        }
        int axis = this.peekOperand() - 100;
        Expression unqualifiedStep;
        if (axis >= 0 && axis < 13) {
            this.getRawToken();
            unqualifiedStep = this.parseNodeTest(axis);
        }
        else if (this.curToken == 64) {
            this.getRawToken();
            axis = 2;
            unqualifiedStep = this.parseNodeTest(axis);
        }
        else if (this.curToken == 236) {
            axis = 2;
            unqualifiedStep = this.parseNodeTest(axis);
        }
        else {
            unqualifiedStep = this.parseNodeTest(-1);
            if (unqualifiedStep != null) {
                axis = 3;
            }
            else {
                axis = -1;
                unqualifiedStep = this.parsePrimaryExpr();
            }
        }
        return this.parseStepQualifiers(unqualifiedStep, axis);
    }
    
    Expression parseStepQualifiers(Expression exp, final int axis) throws IOException, SyntaxException {
        while (this.curToken == 91) {
            final int startLine = this.getLineNumber() + 1;
            final int startColumn = this.getColumnNumber() + 1;
            final int saveSeenPosition = this.seenPosition;
            final int saveSawLast = this.seenLast;
            this.getRawToken();
            final LambdaExp lexp = new LambdaExp(3);
            this.maybeSetLine(lexp, startLine, startColumn);
            final Declaration dot = lexp.addDeclaration(XQParser.DOT_VARNAME);
            if (axis >= 0) {
                dot.setType(NodeType.anyNodeTest);
            }
            else {
                dot.setType(SingletonType.getInstance());
            }
            lexp.addDeclaration(XQParser.POSITION_VARNAME, Type.intType);
            lexp.addDeclaration(XQParser.LAST_VARNAME, Type.intType);
            this.comp.push(lexp);
            dot.noteValueUnknown();
            final Expression cond = this.parseExprSequence(93, false);
            if (this.curToken == -1) {
                this.eofError("missing ']' - unexpected end-of-file");
            }
            Procedure valuesFilter;
            if (axis < 0) {
                final char kind = 'P';
                valuesFilter = ValuesFilter.exprFilter;
            }
            else if (axis == 0 || axis == 1 || axis == 9 || axis == 10 || axis == 11) {
                final char kind = 'R';
                valuesFilter = ValuesFilter.reverseFilter;
            }
            else {
                final char kind = 'F';
                valuesFilter = ValuesFilter.forwardFilter;
            }
            this.maybeSetLine(cond, startLine, startColumn);
            this.comp.pop(lexp);
            lexp.body = cond;
            this.getRawToken();
            final Expression[] args = { exp, lexp };
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
            next = this.read();
            int base;
            if (next == 120) {
                base = 16;
                next = this.read();
            }
            else {
                base = 10;
            }
            int value = 0;
            while (next >= 0) {
                final char ch = (char)next;
                final int digit = Character.digit(ch, base);
                if (digit < 0) {
                    break;
                }
                if (value >= 134217728) {
                    break;
                }
                value *= base;
                value += digit;
                next = this.read();
            }
            if (next != 59) {
                this.unread();
                this.error("invalid character reference");
            }
            else if ((value > 0 && value <= 55295) || (value >= 57344 && value <= 65533) || (value >= 65536 && value <= 1114111)) {
                this.tokenBufferAppend(value);
            }
            else {
                this.error('e', "invalid character value " + value, "XQST0090");
            }
        }
        else {
            final int saveLength = this.tokenBufferLength;
            while (next >= 0) {
                final char ch2 = (char)next;
                if (!XName.isNamePart(ch2)) {
                    break;
                }
                this.tokenBufferAppend(ch2);
                next = this.read();
            }
            if (next != 59) {
                this.unread();
                this.error("invalid entity reference");
                return;
            }
            final String ref = new String(this.tokenBuffer, saveLength, this.tokenBufferLength - saveLength);
            this.tokenBufferLength = saveLength;
            this.appendNamedEntity(ref);
        }
    }
    
    void parseContent(final char delimiter, final Vector result) throws IOException, SyntaxException {
        this.tokenBufferLength = 0;
        final int startSize = result.size();
        int prevEnclosed = startSize - 1;
        boolean skippable;
        final boolean skipBoundarySpace = skippable = (!this.boundarySpacePreserve && delimiter == '<');
        while (true) {
            int next = this.read();
            if (next == delimiter) {
                if (delimiter == '<') {
                    next = this.read();
                    Expression text = null;
                    if (this.tokenBufferLength > 0) {
                        final FString str = new FString(this.tokenBuffer, 0, this.tokenBufferLength);
                        text = new QuoteExp(str);
                    }
                    this.tokenBufferLength = 0;
                    if (next != 47) {
                        final Expression content = this.parseXMLConstructor(next, true);
                        boolean isCDATA = false;
                        boolean emptyCDATA = false;
                        if (content instanceof ApplyExp) {
                            final ApplyExp aexp = (ApplyExp)content;
                            if (aexp.getFunction() == XQParser.makeCDATA) {
                                isCDATA = true;
                                final String str2 = (String)aexp.getArg(0).valueIfConstant();
                                emptyCDATA = (str2 != null && str2.length() == 0);
                            }
                        }
                        if (text != null && (!skippable || isCDATA)) {
                            result.addElement(text);
                        }
                        skippable = (!isCDATA && skipBoundarySpace);
                        if (!emptyCDATA) {
                            result.addElement(content);
                        }
                        this.tokenBufferLength = 0;
                        continue;
                    }
                    if (text != null && !skippable) {
                        result.addElement(text);
                        break;
                    }
                    break;
                }
                else if (this.checkNext(delimiter)) {
                    this.tokenBufferAppend(delimiter);
                    continue;
                }
            }
            if (next == delimiter || next < 0 || next == 123) {
                final int postBrace = (next == 123) ? this.read() : -1;
                if (postBrace == 123) {
                    this.tokenBufferAppend(123);
                    skippable = false;
                }
                else {
                    Label_0407: {
                        FString text2;
                        if (this.tokenBufferLength > 0 && !skippable) {
                            text2 = new FString(this.tokenBuffer, 0, this.tokenBufferLength);
                        }
                        else {
                            if (next != 123 || prevEnclosed != result.size()) {
                                break Label_0407;
                            }
                            text2 = new FString();
                        }
                        result.addElement(new QuoteExp(text2));
                    }
                    this.tokenBufferLength = 0;
                    if (next == delimiter) {
                        break;
                    }
                    if (next < 0) {
                        this.eofError("unexpected end-of-file");
                    }
                    else {
                        this.unread(postBrace);
                        ++this.enclosedExpressionsSeen;
                        final Expression exp = this.parseEnclosedExpr();
                        result.addElement(exp);
                        this.tokenBufferLength = 0;
                        prevEnclosed = result.size();
                        skippable = skipBoundarySpace;
                    }
                }
            }
            else if (next == 125) {
                next = this.read();
                if (next == 125) {
                    this.tokenBufferAppend(125);
                    skippable = false;
                }
                else {
                    this.error("unexpected '}' in element content");
                    this.unread(next);
                }
            }
            else if (next == 38) {
                this.parseEntityOrCharRef();
                skippable = false;
            }
            else {
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
            }
        }
    }
    
    Expression parseEnclosedExpr() throws IOException, SyntaxException {
        final String saveErrorIfComment = this.errorIfComment;
        this.errorIfComment = null;
        final char saveReadState = this.pushNesting('{');
        this.peekNonSpace("unexpected end-of-file after '{'");
        final int startLine = this.getLineNumber() + 1;
        final int startColumn = this.getColumnNumber() + 1;
        this.getRawToken();
        Expression exp = this.parseExpr();
        while (true) {
            while (this.curToken != 125) {
                if (this.curToken == -1 || this.curToken == 41 || this.curToken == 93) {
                    exp = this.syntaxError("missing '}'");
                    this.maybeSetLine(exp, startLine, startColumn);
                    this.popNesting(saveReadState);
                    this.errorIfComment = saveErrorIfComment;
                    return exp;
                }
                if (this.curToken != 44) {
                    exp = this.syntaxError("missing '}' or ','");
                }
                else {
                    this.getRawToken();
                }
                exp = makeExprSequence(exp, this.parseExpr());
            }
            continue;
        }
    }
    
    public static Expression booleanValue(final Expression exp) {
        final Expression[] args = { exp };
        final Expression string = makeFunctionExp("gnu.xquery.util.BooleanValue", "booleanValue");
        return new ApplyExp(string, args);
    }
    
    Expression parseXMLConstructor(int next, final boolean inElementContent) throws IOException, SyntaxException {
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
                    final boolean curHyphen = this.tokenBuffer[i] == '-';
                    if (sawHyphen && curHyphen) {
                        bad = true;
                        break;
                    }
                    sawHyphen = curHyphen;
                }
                if (bad) {
                    exp = this.syntaxError("consecutive or final hyphen in XML comment");
                }
                else {
                    final Expression[] args = { new QuoteExp((Object)new String(this.tokenBuffer, 0, this.tokenBufferLength)) };
                    exp = new ApplyExp(makeFunctionExp("gnu.kawa.xml.CommentConstructor", "commentConstructor"), args);
                }
            }
            else if (next == 91 && this.read() == 67 && this.read() == 68 && this.read() == 65 && this.read() == 84 && this.read() == 65 && this.read() == 91) {
                if (!inElementContent) {
                    this.error('e', "CDATA section must be in element content");
                }
                this.getDelimited("]]>");
                final Expression[] args2 = { new QuoteExp((Object)new String(this.tokenBuffer, 0, this.tokenBufferLength)) };
                exp = new ApplyExp(XQParser.makeCDATA, args2);
            }
            else {
                exp = this.syntaxError("'<!' must be followed by '--' or '[CDATA['");
            }
        }
        else if (next == 63) {
            next = this.peek();
            if (next < 0 || !XName.isNameStart((char)next) || this.getRawToken() != 65) {
                this.syntaxError("missing target after '<?'");
            }
            final String target = new String(this.tokenBuffer, 0, this.tokenBufferLength);
            int nspaces = 0;
            while (true) {
                final int ch = this.read();
                if (ch < 0) {
                    break;
                }
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
            final String content = new String(this.tokenBuffer, 0, this.tokenBufferLength);
            final Expression[] args = { new QuoteExp((Object)target), new QuoteExp((Object)content) };
            exp = new ApplyExp(makeFunctionExp("gnu.kawa.xml.MakeProcInst", "makeProcInst"), args);
        }
        else if (next < 0 || !XName.isNameStart((char)next)) {
            exp = this.syntaxError("expected QName after '<'");
        }
        else {
            this.unread(next);
            this.getRawToken();
            final char saveReadState = this.pushNesting('<');
            exp = this.parseElementConstructor();
            if (!inElementContent) {
                exp = this.wrapWithBaseUri(exp);
            }
            this.popNesting(saveReadState);
        }
        return exp;
    }
    
    static ApplyExp castQName(final Expression value, final boolean element) {
        final Declaration fdecl = element ? XQResolveNames.xsQNameDecl : XQResolveNames.xsQNameIgnoreDefaultDecl;
        return new ApplyExp(new ReferenceExp(fdecl), new Expression[] { value });
    }
    
    Expression parseElementConstructor() throws IOException, SyntaxException {
        final String startTag = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        final Vector<Expression> vec = new Vector<Expression>();
        vec.add(castQName(new QuoteExp((Object)startTag), true));
        this.errorIfComment = "comment not allowed in element start tag";
        NamespaceBinding nsBindings = null;
        int ch;
        while (true) {
            boolean sawSpace = false;
            for (ch = this.read(); ch >= 0 && Character.isWhitespace((char)ch); ch = this.read(), sawSpace = true) {}
            if (ch < 0 || ch == 62) {
                break;
            }
            if (ch == 47) {
                break;
            }
            if (!sawSpace) {
                this.syntaxError("missing space before attribute");
            }
            this.unread(ch);
            this.getRawToken();
            final int vecSize = vec.size();
            if (this.curToken != 65 && this.curToken != 81) {
                break;
            }
            final String attrName = new String(this.tokenBuffer, 0, this.tokenBufferLength);
            final int startLine = this.getLineNumber() + 1;
            final int startColumn = this.getColumnNumber() + 1 - this.tokenBufferLength;
            String definingNamespace = null;
            if (this.curToken == 65) {
                if (attrName.equals("xmlns")) {
                    definingNamespace = "";
                }
            }
            else if (attrName.startsWith("xmlns:")) {
                definingNamespace = attrName.substring(6).intern();
            }
            final Expression makeAttr = (definingNamespace != null) ? null : MakeAttribute.makeAttributeExp;
            vec.addElement(castQName(new QuoteExp((Object)attrName), false));
            ch = this.skipSpace();
            if (ch != 61) {
                this.errorIfComment = null;
                return this.syntaxError("missing '=' after attribute");
            }
            ch = this.skipSpace();
            final int enclosedExpressionsStart = this.enclosedExpressionsSeen;
            if (ch == 123) {
                this.warnOldVersion("enclosed attribute value expression should be quoted");
                vec.addElement(this.parseEnclosedExpr());
            }
            else {
                this.parseContent((char)ch, vec);
            }
            final int n = vec.size() - vecSize;
            if (definingNamespace != null) {
                String ns = "";
                if (n == 1) {
                    ns = "";
                }
                else if (this.enclosedExpressionsSeen > enclosedExpressionsStart) {
                    this.syntaxError("enclosed expression not allowed in namespace declaration");
                }
                else {
                    ns = vec.get(vecSize + 1).valueIfConstant().toString().intern();
                }
                vec.setSize(vecSize);
                this.checkAllowedNamespaceDeclaration(definingNamespace, ns, true);
                if (definingNamespace == "") {
                    definingNamespace = null;
                }
                for (NamespaceBinding nsb = nsBindings; nsb != null; nsb = nsb.getNext()) {
                    if (nsb.getPrefix() == definingNamespace) {
                        this.error('e', (definingNamespace == null) ? "duplicate default namespace declaration" : ("duplicate namespace prefix '" + definingNamespace + '\''), "XQST0071");
                        break;
                    }
                }
                nsBindings = new NamespaceBinding(definingNamespace, (ns == "") ? null : ns, nsBindings);
            }
            else {
                final Expression[] args = new Expression[n];
                int i = n;
                while (--i >= 0) {
                    args[i] = vec.elementAt(vecSize + i);
                }
                vec.setSize(vecSize);
                final ApplyExp aexp = new ApplyExp(makeAttr, args);
                this.maybeSetLine(aexp, startLine, startColumn);
                vec.addElement(aexp);
            }
        }
        this.errorIfComment = null;
        boolean empty = false;
        if (ch == 47) {
            ch = this.read();
            if (ch == 62) {
                empty = true;
            }
            else {
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
                final String tag = new String(this.tokenBuffer, 0, this.tokenBufferLength);
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
        final Expression[] args = new Expression[vec.size()];
        vec.copyInto(args);
        final MakeElement mkElement = new MakeElement();
        mkElement.copyNamespacesMode = this.copyNamespacesMode;
        mkElement.setNamespaceNodes(nsBindings);
        final Expression result = new ApplyExp(new QuoteExp(mkElement), args);
        return result;
    }
    
    Expression wrapWithBaseUri(final Expression exp) {
        if (this.getStaticBaseUri() == null) {
            return exp;
        }
        return new ApplyExp(MakeWithBaseUri.makeWithBaseUri, new Expression[] { new ApplyExp(new ReferenceExp(XQResolveNames.staticBaseUriDecl), Expression.noExpressions), exp }).setLine(exp);
    }
    
    Expression parseParenExpr() throws IOException, SyntaxException {
        this.getRawToken();
        final char saveReadState = this.pushNesting('(');
        final Expression exp = this.parseExprSequence(41, true);
        this.popNesting(saveReadState);
        if (this.curToken == -1) {
            this.eofError("missing ')' - unexpected end-of-file");
        }
        return exp;
    }
    
    Expression parseExprSequence(final int rightToken, final boolean optional) throws IOException, SyntaxException {
        if (this.curToken == rightToken || this.curToken == -1) {
            if (!optional) {
                this.syntaxError("missing expression");
            }
            return QuoteExp.voidObjectExp;
        }
        Expression exp = null;
        while (true) {
            final Expression exp2 = this.parseExprSingle();
            exp = ((exp == null) ? exp2 : makeExprSequence(exp, exp2));
            if (this.curToken == rightToken || this.curToken == -1) {
                return exp;
            }
            if (this.nesting == 0 && this.curToken == 10) {
                return exp;
            }
            if (this.curToken != 44) {
                return this.syntaxError((rightToken == 41) ? "expected ')'" : "confused by syntax error");
            }
            this.getRawToken();
        }
    }
    
    Expression parseTypeSwitch() throws IOException, SyntaxException {
        final char save = this.pushNesting('t');
        final Expression selector = this.parseParenExpr();
        this.getRawToken();
        final Object varName = null;
        final Vector vec = new Vector();
        vec.addElement(selector);
        while (this.match("case")) {
            this.pushNesting('c');
            this.getRawToken();
            Declaration decl;
            if (this.curToken == 36) {
                decl = this.parseVariableDeclaration();
                if (decl == null) {
                    return this.syntaxError("missing Variable after '$'");
                }
                this.getRawToken();
                if (this.match("as")) {
                    this.getRawToken();
                }
                else {
                    this.error('e', "missing 'as'");
                }
            }
            else {
                decl = new Declaration("(arg)");
            }
            decl.setTypeExp(this.parseDataType());
            this.popNesting('t');
            final LambdaExp lexp = new LambdaExp(1);
            lexp.addDeclaration(decl);
            if (this.match("return")) {
                this.getRawToken();
            }
            else {
                this.error("missing 'return' after 'case'");
            }
            this.comp.push(lexp);
            this.pushNesting('r');
            final Expression caseExpr = this.parseExpr();
            lexp.body = caseExpr;
            this.popNesting('t');
            this.comp.pop(lexp);
            vec.addElement(lexp);
        }
        if (this.match("default")) {
            final LambdaExp lexp = new LambdaExp(1);
            this.getRawToken();
            Declaration decl;
            if (this.curToken == 36) {
                decl = this.parseVariableDeclaration();
                if (decl == null) {
                    return this.syntaxError("missing Variable after '$'");
                }
                this.getRawToken();
            }
            else {
                decl = new Declaration("(arg)");
            }
            lexp.addDeclaration(decl);
            if (this.match("return")) {
                this.getRawToken();
            }
            else {
                this.error("missing 'return' after 'default'");
            }
            this.comp.push(lexp);
            final Expression defaultExpr = this.parseExpr();
            lexp.body = defaultExpr;
            this.comp.pop(lexp);
            vec.addElement(lexp);
        }
        else {
            this.error(this.comp.isPedantic() ? 'e' : 'w', "no 'default' clause in 'typeswitch'", "XPST0003");
        }
        this.popNesting(save);
        final Expression[] args = new Expression[vec.size()];
        vec.copyInto(args);
        return new ApplyExp(makeFunctionExp("gnu.kawa.reflect.TypeSwitch", "typeSwitch"), args);
    }
    
    Expression parseMaybePrimaryExpr() throws IOException, SyntaxException {
        final int startLine = this.curLine;
        final int startColumn = this.curColumn;
        final int token = this.peekOperand();
        Expression exp = null;
        switch (token) {
            case 40: {
                exp = this.parseParenExpr();
                break;
            }
            case 197: {
                final Stack extArgs = new Stack();
                do {
                    this.getRawToken();
                    Expression qname;
                    if (this.curToken != 81 && this.curToken != 65) {
                        qname = this.syntaxError("missing pragma name");
                    }
                    else {
                        qname = QuoteExp.getInstance(new String(this.tokenBuffer, 0, this.tokenBufferLength));
                    }
                    extArgs.push(qname);
                    final StringBuffer sbuf = new StringBuffer();
                    int spaces = -1;
                    int ch;
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
                        final char saveReadState = this.pushNesting('{');
                        extArgs.push(this.parseExprSequence(125, false));
                        this.popNesting(saveReadState);
                        if (this.curToken == -1) {
                            this.eofError("missing '}' - unexpected end-of-file");
                        }
                    }
                    final Expression[] args = new Expression[extArgs.size()];
                    extArgs.copyInto(args);
                    exp = new ApplyExp(new ReferenceExp(XQResolveNames.handleExtensionDecl), args);
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
                final int next = this.read();
                if (next == 47) {
                    this.getRawToken();
                    String msg;
                    if (this.curToken == 65 || this.curToken == 81 || this.curToken == 67) {
                        msg = "saw end tag '</" + new String(this.tokenBuffer, 0, this.tokenBufferLength) + ">' not in an element constructor";
                    }
                    else {
                        msg = "saw end tag '</' not in an element constructor";
                    }
                    this.curLine = startLine;
                    this.curColumn = startColumn;
                    exp = this.syntaxError(msg);
                    while (this.curToken != 405 && this.curToken != -1 && this.curToken != 10) {
                        this.getRawToken();
                    }
                    return exp;
                }
                exp = this.parseXMLConstructor(next, false);
                this.maybeSetLine(exp, startLine, startColumn);
                break;
            }
            case 34: {
                exp = new QuoteExp((Object)new String(this.tokenBuffer, 0, this.tokenBufferLength).intern());
                break;
            }
            case 48: {
                exp = new QuoteExp(IntNum.valueOf(this.tokenBuffer, 0, this.tokenBufferLength, 10, false));
                break;
            }
            case 49:
            case 50: {
                final String str = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                try {
                    Object val;
                    if (token == 49) {
                        val = new BigDecimal(str);
                    }
                    else {
                        val = new Double(str);
                    }
                    exp = new QuoteExp(val);
                }
                catch (Exception ex) {
                    exp = this.syntaxError("invalid decimal literal: '" + str + "'");
                }
                break;
            }
            case 36: {
                final Object name = this.parseVariable();
                if (name == null) {
                    return this.syntaxError("missing Variable");
                }
                exp = new ReferenceExp(name);
                this.maybeSetLine(exp, this.curLine, this.curColumn);
                break;
            }
            case 70: {
                final Object name = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                final char save = this.pushNesting('(');
                this.getRawToken();
                final Vector vec = new Vector(10);
                if (this.curToken != 41) {
                    while (true) {
                        final Expression arg = this.parseExpr();
                        vec.addElement(arg);
                        if (this.curToken == 41) {
                            break;
                        }
                        if (this.curToken != 44) {
                            return this.syntaxError("missing ')' after function call");
                        }
                        this.getRawToken();
                    }
                }
                final Expression[] args = new Expression[vec.size()];
                vec.copyInto(args);
                final ReferenceExp rexp = new ReferenceExp(name, null);
                rexp.setProcedureName(true);
                exp = new ApplyExp(rexp, args);
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
                this.getRawToken();
                final Vector vec = new Vector();
                Expression func;
                if (token == 251 || token == 252) {
                    Expression element;
                    if (this.curToken == 65 || this.curToken == 81) {
                        element = this.parseNameTest(token != 251);
                    }
                    else {
                        if (this.curToken != 123) {
                            return this.syntaxError("missing element/attribute name");
                        }
                        element = this.parseEnclosedExpr();
                    }
                    vec.addElement(castQName(element, token == 251));
                    if (token == 251) {
                        final MakeElement mk = new MakeElement();
                        mk.copyNamespacesMode = this.copyNamespacesMode;
                        func = new QuoteExp(mk);
                    }
                    else {
                        func = MakeAttribute.makeAttributeExp;
                    }
                    this.getRawToken();
                }
                else if (token == 256) {
                    func = makeFunctionExp("gnu.kawa.xml.DocumentConstructor", "documentConstructor");
                }
                else if (token == 254) {
                    func = makeFunctionExp("gnu.kawa.xml.CommentConstructor", "commentConstructor");
                }
                else if (token == 255) {
                    Expression target;
                    if (this.curToken == 65) {
                        target = new QuoteExp((Object)new String(this.tokenBuffer, 0, this.tokenBufferLength).intern());
                    }
                    else if (this.curToken == 123) {
                        target = this.parseEnclosedExpr();
                    }
                    else {
                        target = this.syntaxError("expected NCName or '{' after 'processing-instruction'");
                        if (this.curToken != 81) {
                            return target;
                        }
                    }
                    vec.addElement(target);
                    func = makeFunctionExp("gnu.kawa.xml.MakeProcInst", "makeProcInst");
                    this.getRawToken();
                }
                else {
                    func = makeFunctionExp("gnu.kawa.xml.MakeText", "makeText");
                }
                final char saveReadState2 = this.pushNesting('{');
                this.peekNonSpace("unexpected end-of-file after '{'");
                if (this.curToken != 123) {
                    return this.syntaxError("missing '{'");
                }
                this.getRawToken();
                if (token == 253 || token == 254 || token == 255) {
                    vec.addElement(this.parseExprSequence(125, token == 255));
                }
                else if (this.curToken != 125) {
                    vec.addElement(this.parseExpr());
                    while (this.curToken == 44) {
                        this.getRawToken();
                        vec.addElement(this.parseExpr());
                    }
                }
                this.popNesting(saveReadState2);
                if (this.curToken != 125) {
                    return this.syntaxError("missing '}'");
                }
                final Expression[] args = new Expression[vec.size()];
                vec.copyInto(args);
                exp = new ApplyExp(func, args);
                this.maybeSetLine(exp, startLine, startColumn);
                if (token == 256 || token == 251) {
                    exp = this.wrapWithBaseUri(exp);
                    break;
                }
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
        final char saveReadState1 = this.pushNesting('i');
        this.getRawToken();
        final char saveReadState2 = this.pushNesting('(');
        final Expression cond = this.parseExprSequence(41, false);
        this.popNesting(saveReadState2);
        if (this.curToken == -1) {
            this.eofError("missing ')' - unexpected end-of-file");
        }
        this.getRawToken();
        if (!this.match("then")) {
            this.syntaxError("missing 'then'");
        }
        else {
            this.getRawToken();
        }
        final Expression thenPart = this.parseExpr();
        if (!this.match("else")) {
            this.syntaxError("missing 'else'");
        }
        else {
            this.getRawToken();
        }
        this.popNesting(saveReadState1);
        final Expression elsePart = this.parseExpr();
        return new IfExp(booleanValue(cond), thenPart, elsePart);
    }
    
    public boolean match(final String word) {
        if (this.curToken != 65) {
            return false;
        }
        final int len = word.length();
        if (this.tokenBufferLength != len) {
            return false;
        }
        int i = len;
        while (--i >= 0) {
            final char cs = word.charAt(i);
            final char cb = this.tokenBuffer[i];
            if (cs != cb) {
                return false;
            }
        }
        return true;
    }
    
    public Object parseVariable() throws IOException, SyntaxException {
        if (this.curToken == 36) {
            this.getRawToken();
        }
        else {
            this.syntaxError("missing '$' before variable name");
        }
        final String str = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        if (this.curToken == 81) {
            return str;
        }
        if (this.curToken == 65) {
            return Namespace.EmptyNamespace.getSymbol(str.intern());
        }
        return null;
    }
    
    public Declaration parseVariableDeclaration() throws IOException, SyntaxException {
        final Object name = this.parseVariable();
        if (name == null) {
            return null;
        }
        final Declaration decl = new Declaration(name);
        this.maybeSetLine(decl, this.getLineNumber() + 1, this.getColumnNumber() + 1 - this.tokenBufferLength);
        return decl;
    }
    
    public Expression parseFLWRExpression(final boolean isFor) throws IOException, SyntaxException {
        final int flworDeclsSave = this.flworDeclsFirst;
        this.flworDeclsFirst = this.flworDeclsCount;
        final Expression exp = this.parseFLWRInner(isFor);
        if (!this.match("order")) {
            this.flworDeclsCount = this.flworDeclsFirst;
            this.flworDeclsFirst = flworDeclsSave;
            return exp;
        }
        final char saveNesting = this.pushNesting(isFor ? 'f' : 'l');
        this.getRawToken();
        if (this.match("by")) {
            this.getRawToken();
        }
        else {
            this.error("missing 'by' following 'order'");
        }
        final Stack specs = new Stack();
        while (true) {
            boolean descending = false;
            char emptyOrder = this.defaultEmptyOrder;
            final LambdaExp lexp = new LambdaExp(this.flworDeclsCount - this.flworDeclsFirst);
            for (int i = this.flworDeclsFirst; i < this.flworDeclsCount; ++i) {
                lexp.addDeclaration(this.flworDecls[i].getSymbol());
            }
            this.comp.push(lexp);
            lexp.body = this.parseExprSingle();
            this.comp.pop(lexp);
            specs.push(lexp);
            if (this.match("ascending")) {
                this.getRawToken();
            }
            else if (this.match("descending")) {
                this.getRawToken();
                descending = true;
            }
            if (this.match("empty")) {
                this.getRawToken();
                if (this.match("greatest")) {
                    this.getRawToken();
                    emptyOrder = 'G';
                }
                else if (this.match("least")) {
                    this.getRawToken();
                    emptyOrder = 'L';
                }
                else {
                    this.error("'empty' sequence order must be 'greatest' or 'least'");
                }
            }
            specs.push(new QuoteExp((Object)((descending ? "D" : "A") + emptyOrder)));
            Object collation = this.defaultCollator;
            if (this.match("collation")) {
                final Object uri = this.parseURILiteral();
                if (uri instanceof String) {
                    try {
                        final String uriString = this.resolveAgainstBaseUri((String)uri);
                        collation = NamedCollator.make(uriString);
                    }
                    catch (Exception name) {
                        this.error('e', "unknown collation '" + uri + "'", "XQST0076");
                    }
                }
                this.getRawToken();
            }
            specs.push(new QuoteExp(collation));
            if (this.curToken != 44) {
                break;
            }
            this.getRawToken();
        }
        if (!this.match("return")) {
            return this.syntaxError("expected 'return' clause");
        }
        this.getRawToken();
        final LambdaExp lexp2 = new LambdaExp(this.flworDeclsCount - this.flworDeclsFirst);
        for (int j = this.flworDeclsFirst; j < this.flworDeclsCount; ++j) {
            lexp2.addDeclaration(this.flworDecls[j].getSymbol());
        }
        this.popNesting(saveNesting);
        this.comp.push(lexp2);
        lexp2.body = this.parseExprSingle();
        this.comp.pop(lexp2);
        final int nspecs = specs.size();
        final Expression[] args = new Expression[2 + nspecs];
        args[0] = exp;
        args[1] = lexp2;
        for (int i = 0; i < nspecs; ++i) {
            args[2 + i] = (Expression)specs.elementAt(i);
        }
        return new ApplyExp(makeFunctionExp("gnu.xquery.util.OrderedMap", "orderedMap"), args);
    }
    
    public Expression parseFLWRInner(final boolean isFor) throws IOException, SyntaxException {
        final char saveNesting = this.pushNesting(isFor ? 'f' : 'l');
        this.curToken = 36;
        final Declaration decl = this.parseVariableDeclaration();
        if (decl == null) {
            return this.syntaxError("missing Variable - saw " + this.tokenString());
        }
        if (this.flworDecls == null) {
            this.flworDecls = new Declaration[8];
        }
        else if (this.flworDeclsCount >= this.flworDecls.length) {
            final Declaration[] tmp = new Declaration[2 * this.flworDeclsCount];
            System.arraycopy(this.flworDecls, 0, tmp, 0, this.flworDeclsCount);
            this.flworDecls = tmp;
        }
        this.flworDecls[this.flworDeclsCount++] = decl;
        this.getRawToken();
        final Expression type = this.parseOptionalTypeDeclaration();
        LambdaExp lexp = null;
        Declaration posDecl = null;
        if (isFor) {
            final boolean sawAt = this.match("at");
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
            }
            else {
                if (this.curToken == 76) {
                    this.getRawToken();
                }
                this.syntaxError("missing 'in' in 'for' clause");
            }
            this.comp.push(lexp);
        }
        else {
            if (this.curToken == 76) {
                this.getRawToken();
            }
            else {
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
        }
        else {
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
        Expression body;
        if (this.curToken == 44) {
            this.getRawToken();
            if (this.curToken != 36) {
                return this.syntaxError("missing $NAME after ','");
            }
            body = this.parseFLWRInner(isFor);
        }
        else if (this.match("for")) {
            this.getRawToken();
            if (this.curToken != 36) {
                return this.syntaxError("missing $NAME after 'for'");
            }
            body = this.parseFLWRInner(true);
        }
        else if (this.match("let")) {
            this.getRawToken();
            if (this.curToken != 36) {
                return this.syntaxError("missing $NAME after 'let'");
            }
            body = this.parseFLWRInner(false);
        }
        else {
            final char save = this.pushNesting('w');
            Expression cond;
            if (this.curToken == 196) {
                this.getRawToken();
                cond = this.parseExprSingle();
            }
            else if (this.match("where")) {
                cond = this.parseExprSingle();
            }
            else {
                cond = null;
            }
            this.popNesting(save);
            final boolean sawStable = this.match("stable");
            if (sawStable) {
                this.getRawToken();
            }
            final boolean sawReturn = this.match("return");
            final boolean sawOrder = this.match("order");
            if (!sawReturn && !sawOrder && !this.match("let") && !this.match("for")) {
                return this.syntaxError("missing 'return' clause");
            }
            if (!sawOrder) {
                this.peekNonSpace("unexpected eof-of-file after 'return'");
            }
            final int bodyLine = this.getLineNumber() + 1;
            final int bodyColumn = this.getColumnNumber() + 1;
            if (sawReturn) {
                this.getRawToken();
            }
            if (sawOrder) {
                final int ndecls = this.flworDeclsCount - this.flworDeclsFirst;
                final Expression[] args = new Expression[ndecls];
                for (int i = 0; i < ndecls; ++i) {
                    args[i] = new ReferenceExp(this.flworDecls[this.flworDeclsFirst + i]);
                }
                body = new ApplyExp(new PrimProcedure("gnu.xquery.util.OrderedMap", "makeTuple$V", 1), args);
            }
            else {
                body = this.parseExprSingle();
            }
            if (cond != null) {
                body = new IfExp(booleanValue(cond), body, QuoteExp.voidExp);
            }
            this.maybeSetLine(body, bodyLine, bodyColumn);
        }
        if (isFor) {
            this.comp.pop(lexp);
            lexp.body = body;
            final Expression[] args2 = { lexp, init };
            return new ApplyExp(makeFunctionExp("gnu.kawa.functions.ValuesMap", (lexp.min_args == 1) ? "valuesMap" : "valuesMapWithPos"), args2);
        }
        return this.comp.letDone(body);
    }
    
    public Expression parseQuantifiedExpr(final boolean isEvery) throws IOException, SyntaxException {
        final char saveNesting = this.pushNesting(isEvery ? 'e' : 's');
        this.curToken = 36;
        final Declaration decl = this.parseVariableDeclaration();
        if (decl == null) {
            return this.syntaxError("missing Variable token:" + this.curToken);
        }
        this.getRawToken();
        final LambdaExp lexp = new LambdaExp(1);
        lexp.addDeclaration(decl);
        decl.noteValueUnknown();
        decl.setFlag(262144L);
        decl.setTypeExp(this.parseOptionalTypeDeclaration());
        if (this.match("in")) {
            this.getRawToken();
        }
        else {
            if (this.curToken == 76) {
                this.getRawToken();
            }
            this.syntaxError("missing 'in' in QuantifiedExpr");
        }
        final Expression[] inits = { this.parseExprSingle() };
        this.popNesting(saveNesting);
        this.comp.push(lexp);
        Expression body;
        if (this.curToken == 44) {
            this.getRawToken();
            if (this.curToken != 36) {
                return this.syntaxError("missing $NAME after ','");
            }
            body = this.parseQuantifiedExpr(isEvery);
        }
        else {
            final boolean sawSatisfies = this.match("satisfies");
            if (!sawSatisfies && !this.match("every") && !this.match("some")) {
                return this.syntaxError("missing 'satisfies' clause");
            }
            this.peekNonSpace("unexpected eof-of-file after 'satisfies'");
            final int bodyLine = this.getLineNumber() + 1;
            final int bodyColumn = this.getColumnNumber() + 1;
            if (sawSatisfies) {
                this.getRawToken();
            }
            body = this.parseExprSingle();
            this.maybeSetLine(body, bodyLine, bodyColumn);
        }
        this.comp.pop(lexp);
        lexp.body = body;
        final Expression[] args = { lexp, inits[0] };
        return new ApplyExp(makeFunctionExp("kawa.lib.xquery.Xutils", isEvery ? "every" : "some"), args);
    }
    
    public Expression parseFunctionDefinition(final int declLine, final int declColumn) throws IOException, SyntaxException {
        if (this.curToken != 81 && this.curToken != 65) {
            return this.syntaxError("missing function name");
        }
        final String name = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        this.getMessages().setLine(this.port.getName(), this.curLine, this.curColumn);
        final Symbol sym = this.namespaceResolve(name, true);
        final String uri = sym.getNamespaceURI();
        if (uri == "http://www.w3.org/XML/1998/namespace" || uri == "http://www.w3.org/2001/XMLSchema" || uri == "http://www.w3.org/2001/XMLSchema-instance" || uri == "http://www.w3.org/2005/xpath-functions") {
            this.error('e', "cannot declare function in standard namespace '" + uri + '\'', "XQST0045");
        }
        else if (uri == "") {
            this.error(this.comp.isPedantic() ? 'e' : 'w', "cannot declare function in empty namespace", "XQST0060");
        }
        else if (this.libraryModuleNamespace != null && uri != this.libraryModuleNamespace && (!"http://www.w3.org/2005/xquery-local-functions".equals(uri) || this.comp.isPedantic())) {
            this.error('e', "function not in namespace of library module", "XQST0048");
        }
        this.getRawToken();
        if (this.curToken != 40) {
            return this.syntaxError("missing parameter list:" + this.curToken);
        }
        this.getRawToken();
        final LambdaExp lexp = new LambdaExp();
        this.maybeSetLine(lexp, declLine, declColumn);
        lexp.setSymbol(sym);
        final Declaration decl = this.comp.currentScope().addDeclaration(sym);
        if (this.comp.isStatic()) {
            decl.setFlag(2048L);
        }
        lexp.setFlag(2048);
        decl.setCanRead(true);
        decl.setProcedureDecl(true);
        this.maybeSetLine(decl, declLine, declColumn);
        this.comp.push(lexp);
        Label_0546: {
            if (this.curToken != 41) {
                while (true) {
                    final Declaration param = this.parseVariableDeclaration();
                    if (param == null) {
                        this.error("missing parameter name");
                    }
                    else {
                        lexp.addDeclaration(param);
                        this.getRawToken();
                        final LambdaExp lambdaExp = lexp;
                        ++lambdaExp.min_args;
                        final LambdaExp lambdaExp2 = lexp;
                        ++lambdaExp2.max_args;
                        param.setTypeExp(this.parseOptionalTypeDeclaration());
                    }
                    if (this.curToken == 41) {
                        break;
                    }
                    if (this.curToken != 44) {
                        final Expression err = this.syntaxError("missing ',' in parameter list");
                        do {
                            this.getRawToken();
                            if (this.curToken < 0 || this.curToken == 59 || this.curToken == 59) {
                                return err;
                            }
                            if (this.curToken == 41) {
                                break Label_0546;
                            }
                        } while (this.curToken != 44);
                    }
                    else {
                        this.getRawToken();
                    }
                }
            }
        }
        this.getRawToken();
        final Expression retType = this.parseOptionalTypeDeclaration();
        lexp.body = this.parseEnclosedExpr();
        this.comp.pop(lexp);
        if (retType != null) {
            lexp.setCoercedReturnValue(retType, this.interpreter);
        }
        final SetExp sexp = new SetExp(decl, lexp);
        sexp.setDefining(true);
        decl.noteValue(lexp);
        return sexp;
    }
    
    public Object readObject() throws IOException, SyntaxException {
        return this.parse(null);
    }
    
    protected Symbol namespaceResolve(final String name, final boolean function) {
        final int colon = name.indexOf(58);
        final String prefix = (colon >= 0) ? name.substring(0, colon).intern() : (function ? "(functions)" : XQuery.DEFAULT_ELEMENT_PREFIX);
        String uri = QNameUtils.lookupPrefix(prefix, this.constructorNamespaces, this.prologNamespaces);
        if (uri == null) {
            if (colon < 0) {
                uri = "";
            }
            else if (!this.comp.isPedantic()) {
                try {
                    final Class cl = Class.forName(prefix);
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
        final String local = (colon < 0) ? name : name.substring(colon + 1);
        return Symbol.make(uri, local, prefix);
    }
    
    void parseSeparator() throws IOException, SyntaxException {
        final int startLine = this.port.getLineNumber() + 1;
        final int startColumn = this.port.getColumnNumber() + 1;
        final int next = this.skipSpace(this.nesting != 0);
        if (next == 59) {
            return;
        }
        if (XQParser.warnOldVersion && next != 10) {
            this.curLine = startLine;
            this.curColumn = startColumn;
            this.error('w', "missing ';' after declaration");
        }
        if (next >= 0) {
            this.unread(next);
        }
    }
    
    public Expression parse(final Compilation comp) throws IOException, SyntaxException {
        this.comp = comp;
        int ch = this.skipSpace();
        if (ch < 0) {
            return null;
        }
        ++this.parseCount;
        this.unread(ch);
        final int startLine = this.getLineNumber() + 1;
        final int startColumn = this.getColumnNumber() + 1;
        if (ch == 35 && startLine == 1 && startColumn == 1) {
            this.read();
            if ((ch = this.read()) != 33 || (ch = this.read()) != 47) {
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
        if (this.curToken == 65 && "namespace".equals(this.curValue)) {
            if (XQParser.warnOldVersion) {
                this.error('w', "use 'declare namespace' instead of 'namespace'");
            }
            this.curToken = 78;
        }
        Label_1373: {
            switch (this.curToken) {
                case 87: {
                    final int declLine = this.getLineNumber() + 1;
                    final int declColumn = this.getColumnNumber() + 1;
                    final int next = this.peekNonSpace("unexpected end-of-file after 'define QName'");
                    if (next == 40) {
                        this.syntaxError("'missing 'function' after 'define'");
                        this.curToken = 65;
                        return this.parseFunctionDefinition(declLine, declColumn);
                    }
                    return this.syntaxError("missing keyword after 'define'");
                }
                case 80: {
                    final int declLine = this.getLineNumber() + 1;
                    final int declColumn = this.getColumnNumber() + 1;
                    this.getRawToken();
                    this.peekNonSpace("unexpected end-of-file after 'define function'");
                    final char save = this.pushNesting('d');
                    final Expression exp = this.parseFunctionDefinition(declLine, declColumn);
                    this.popNesting(save);
                    this.parseSeparator();
                    this.maybeSetLine(exp, startLine, startColumn);
                    this.seenDeclaration = true;
                    return exp;
                }
                case 86: {
                    this.getRawToken();
                    final Declaration decl = this.parseVariableDeclaration();
                    if (decl == null) {
                        return this.syntaxError("missing Variable");
                    }
                    final Object name = decl.getSymbol();
                    if (name instanceof String) {
                        this.getMessages().setLine(this.port.getName(), this.curLine, this.curColumn);
                        decl.setSymbol(this.namespaceResolve((String)name, false));
                    }
                    if (this.libraryModuleNamespace != null) {
                        final String uri = ((Symbol)decl.getSymbol()).getNamespaceURI();
                        if (uri != this.libraryModuleNamespace && (!"http://www.w3.org/2005/xquery-local-functions".equals(uri) || comp.isPedantic())) {
                            this.error('e', "variable not in namespace of library module", "XQST0048");
                        }
                    }
                    comp.currentScope().addDeclaration(decl);
                    this.getRawToken();
                    final Expression type = this.parseOptionalTypeDeclaration();
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
                    }
                    else if (this.match("external")) {
                        final Expression[] args = { castQName(new QuoteExp(decl.getSymbol()), false), (type == null) ? QuoteExp.nullExp : type };
                        init = new ApplyExp(XQParser.getExternalFunction, args);
                        this.maybeSetLine(init, this.curLine, this.curColumn);
                        this.getRawToken();
                    }
                    else {
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
                    final Expression exp = SetExp.makeDefinition(decl, init);
                    this.maybeSetLine(exp, startLine, startColumn);
                    this.seenDeclaration = true;
                    return exp;
                }
                case 77:
                case 78: {
                    final int command = this.curToken;
                    if (command == 77 && this.libraryModuleNamespace != null) {
                        this.error('e', "duplicate module declaration");
                    }
                    else if (this.seenDeclaration && !this.isInteractive()) {
                        this.error('e', "namespace declared after function/variable/option");
                    }
                    final int next = this.skipSpace(this.nesting != 0);
                    if (next < 0) {
                        break Label_1373;
                    }
                    this.unread();
                    if (!XName.isNameStart((char)next)) {
                        break Label_1373;
                    }
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
                    final String uri = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
                    prefix = prefix.intern();
                    for (NamespaceBinding ns = this.prologNamespaces; ns != XQParser.builtinNamespaces; ns = ns.getNext()) {
                        if (ns.getPrefix() == prefix) {
                            this.error('e', "duplicate declarations for the same namespace prefix '" + prefix + "'", "XQST0033");
                            break;
                        }
                    }
                    this.pushNamespace(prefix, uri);
                    this.checkAllowedNamespaceDeclaration(prefix, uri, false);
                    this.parseSeparator();
                    if (command == 77) {
                        final ModuleExp module = comp.getModule();
                        final String className = Compilation.mangleURI(uri) + '.' + XQuery.makeClassName(module.getFileName());
                        module.setName(className);
                        module.setType(comp.mainClass = new ClassType(className));
                        final ModuleManager manager = ModuleManager.getInstance();
                        final ModuleInfo info = manager.find(comp);
                        info.setNamespaceUri(uri);
                        module.setType(comp.mainClass);
                        if (uri.length() == 0) {
                            return this.syntaxError("zero-length module namespace", "XQST0088");
                        }
                        this.libraryModuleNamespace = uri;
                    }
                    return QuoteExp.voidExp;
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
                    final String uri = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
                    if (prefix != null) {
                        this.checkAllowedNamespaceDeclaration(prefix, uri, false);
                        this.pushNamespace(prefix.intern(), uri);
                    }
                    this.getRawToken();
                    ModuleManager.getInstance().find(comp);
                    if (this.seenImports == null) {
                        this.seenImports = new HashMap<String, SourceLocator>();
                    }
                    final SourceLocator oldImport = this.seenImports.get(uri);
                    final Declaration loc = new Declaration(uri);
                    this.maybeSetLine(loc, startLine, startColumn);
                    if (oldImport != null) {
                        comp.error('e', "duplicate import of '" + uri + "'", "XQST0047", loc);
                        comp.error('e', "(this is the previous import)", null, oldImport);
                        return QuoteExp.voidExp;
                    }
                    this.seenImports.put(uri, loc);
                    final ModuleExp module2 = comp.getModule();
                    final Translator.FormStack formStack = new Translator.FormStack(comp);
                    final String packageName = Compilation.mangleURI(uri);
                    comp.setLine(this.port.getName(), startLine, startColumn);
                    if (this.match("at")) {
                        while (true) {
                            this.getRawToken();
                            if (this.curToken != 34) {
                                return this.syntaxError("missing module location");
                            }
                            final String at = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                            final String className2 = Compilation.mangleURI(uri) + '.' + XQuery.makeClassName(at);
                            final ModuleInfo info2 = require.lookupModuleFromSourcePath(at, module2);
                            if (info2 == null) {
                                comp.error('e', "malformed URL: " + at);
                            }
                            require.importDefinitions(className2, info2, null, formStack, module2, comp);
                            final int next = this.skipSpace(this.nesting != 0);
                            if (next != 44) {
                                this.unread(next);
                                this.parseSeparator();
                                break;
                            }
                        }
                    }
                    else {
                        final ModuleManager manager2 = ModuleManager.getInstance();
                        int n = 0;
                        try {
                            manager2.loadPackageInfo(packageName);
                        }
                        catch (ClassNotFoundException ex2) {}
                        catch (Exception ex) {
                            this.error('e', "error loading map for " + uri + " - " + ex);
                        }
                        int i = 0;
                        while (true) {
                            final ModuleInfo info3 = manager2.getModule(i);
                            if (info3 == null) {
                                break;
                            }
                            if (uri.equals(info3.getNamespaceUri())) {
                                ++n;
                                require.importDefinitions(info3.getClassName(), info3, null, formStack, module2, comp);
                            }
                            ++i;
                        }
                        if (n == 0) {
                            this.error('e', "no module found for " + uri);
                        }
                        final String at = null;
                        if (this.curToken != 59) {
                            this.parseSeparator();
                        }
                    }
                    if (comp.pendingImports != null && comp.pendingImports.size() > 0) {
                        this.error('e', "module import forms a cycle", "XQST0073");
                    }
                    final LList forms = (LList)formStack.getFirst();
                    final Expression[] inits = new Expression[forms.size()];
                    forms.toArray(inits);
                    return BeginExp.canonicalize(inits);
                }
                case 71: {
                    if (this.defaultCollator != null && !this.isInteractive()) {
                        this.error('e', "duplicate default collation declaration", "XQST0038");
                    }
                    final Object val = this.parseURILiteral();
                    if (val instanceof Expression) {
                        return (Expression)val;
                    }
                    String collation = (String)val;
                    try {
                        collation = this.resolveAgainstBaseUri(collation);
                        this.defaultCollator = NamedCollator.make(collation);
                    }
                    catch (Exception ex3) {
                        this.defaultCollator = NamedCollator.codepointCollation;
                        this.error('e', "unknown collation '" + collation + "'", "XQST0038");
                    }
                    this.parseSeparator();
                    return QuoteExp.voidExp;
                }
                case 69:
                case 79: {
                    final boolean forFunctions = this.curToken == 79;
                    final String prefix = forFunctions ? "(functions)" : XQuery.DEFAULT_ELEMENT_PREFIX;
                    if (this.prologNamespaces.resolve(prefix, XQParser.builtinNamespaces) != null) {
                        this.error('e', "duplicate default namespace declaration", "XQST0066");
                    }
                    else if (this.seenDeclaration && !this.isInteractive()) {
                        this.error('e', "default namespace declared after function/variable/option");
                    }
                    this.getRawToken();
                    if (this.match("namespace")) {
                        this.getRawToken();
                    }
                    else {
                        final String msg = "expected 'namespace' keyword";
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
                    final String uri = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
                    if (forFunctions) {
                        (this.functionNamespacePath = new Namespace[1])[0] = Namespace.valueOf(uri);
                    }
                    else {
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
                    }
                    else if (this.match("strip")) {
                        this.boundarySpacePreserve = false;
                    }
                    else {
                        if (!this.match("skip")) {
                            return this.syntaxError("boundary-space declaration must be preserve or strip");
                        }
                        this.warnOldVersion("update: declare boundary-space skip -> strip");
                        this.boundarySpacePreserve = false;
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
                    }
                    else {
                        if (!this.match("preserve")) {
                            return this.syntaxError("construction declaration must be strip or preserve");
                        }
                        this.constructionModeStrip = false;
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
                        this.copyNamespacesMode |= 0x1;
                    }
                    else {
                        if (!this.match("no-preserve")) {
                            return this.syntaxError("expected 'preserve' or 'no-preserve' after 'declare copy-namespaces'");
                        }
                        this.copyNamespacesMode &= 0xFFFFFFFE;
                    }
                    this.getRawToken();
                    if (this.curToken != 44) {
                        return this.syntaxError("missing ',' in copy-namespaces declaration");
                    }
                    this.getRawToken();
                    if (this.match("inherit")) {
                        this.copyNamespacesMode |= 0x2;
                    }
                    else {
                        if (!this.match("no-inherit")) {
                            return this.syntaxError("expected 'inherit' or 'no-inherit' in copy-namespaces declaration");
                        }
                        this.copyNamespacesMode &= 0xFFFFFFFD;
                    }
                    this.parseSeparator();
                    return QuoteExp.voidExp;
                }
                case 72: {
                    this.getRawToken();
                    final boolean sawEmpty = this.match("empty");
                    if (this.emptyOrderDeclarationSeen && !this.isInteractive()) {
                        this.syntaxError("duplicate 'declare default empty order' seen", "XQST0069");
                    }
                    this.emptyOrderDeclarationSeen = true;
                    if (sawEmpty) {
                        this.getRawToken();
                    }
                    else {
                        this.syntaxError("expected 'empty greatest' or 'empty least'");
                    }
                    if (this.match("greatest")) {
                        this.defaultEmptyOrder = 'G';
                    }
                    else {
                        if (!this.match("least")) {
                            return this.syntaxError("expected 'empty greatest' or 'empty least'");
                        }
                        this.defaultEmptyOrder = 'L';
                    }
                    this.parseSeparator();
                    return QuoteExp.voidExp;
                }
                case 111: {
                    this.getRawToken();
                    if (this.curToken != 81) {
                        this.syntaxError("expected QName after 'declare option'");
                    }
                    else {
                        final String str = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                        this.getMessages().setLine(this.port.getName(), this.curLine, this.curColumn);
                        final Symbol sym = this.namespaceResolve(str, false);
                        this.getRawToken();
                        if (this.curToken != 34) {
                            this.syntaxError("expected string literal after 'declare option " + str + '\'');
                        }
                        else {
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
                    }
                    else {
                        if (!this.match("unordered")) {
                            return this.syntaxError("ordering declaration must be ordered or unordered");
                        }
                        this.orderingModeUnordered = true;
                    }
                    this.parseSeparator();
                    return QuoteExp.voidExp;
                }
                case 89: {
                    if (this.parseCount != 1) {
                        this.error('e', "'xquery version' does not start module");
                    }
                    else if (this.commentCount > 0) {
                        this.error('w', "comments should not precede 'xquery version'");
                    }
                    this.getRawToken();
                    if (this.curToken == 34) {
                        final String version = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                        if (!version.equals("1.0")) {
                            this.error('e', "unrecognized xquery version " + version, "XQST0031");
                        }
                        this.getRawToken();
                        if (this.match("encoding")) {
                            this.getRawToken();
                            if (this.curToken != 34) {
                                return this.syntaxError("invalid encoding specification");
                            }
                            final String encoding = new String(this.tokenBuffer, 0, this.tokenBufferLength);
                            int j = this.tokenBufferLength;
                            boolean bad = j == 0;
                            while (--j >= 0 && !bad) {
                                ch = this.tokenBuffer[j];
                                if (ch < 65 || ch > 90) {
                                    if (ch >= 97 && ch <= 122) {
                                        continue;
                                    }
                                    if (j != 0 && ((ch >= 48 && ch <= 57) || ch == 46 || ch == 95 || ch == 45)) {
                                        continue;
                                    }
                                    bad = true;
                                }
                            }
                            if (bad) {
                                this.error('e', "invalid encoding name syntax", "XQST0087");
                            }
                            final InPort port = this.getPort();
                            if (port instanceof BinaryInPort) {
                                try {
                                    ((BinaryInPort)port).setCharset(encoding);
                                }
                                catch (UnsupportedCharsetException ex4) {
                                    this.error('e', "unrecognized encoding name");
                                }
                                catch (Exception ex5) {
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
                    return this.syntaxError("missing version string after 'xquery version'");
                }
                case 66: {
                    if (this.baseURIDeclarationSeen && !this.isInteractive()) {
                        this.syntaxError("duplicate 'declare base-uri' seen", "XQST0032");
                    }
                    this.baseURIDeclarationSeen = true;
                    final Object val = this.parseURILiteral();
                    if (val instanceof Expression) {
                        return (Expression)val;
                    }
                    this.parseSeparator();
                    this.setStaticBaseUri((String)val);
                    return QuoteExp.voidExp;
                }
                default: {
                    final Expression exp = this.parseExprSequence(-1, true);
                    if (this.curToken == 10) {
                        this.unread(10);
                    }
                    this.maybeSetLine(exp, startLine, startColumn);
                    if (this.libraryModuleNamespace != null) {
                        this.error('e', "query body in a library module", "XPST0003");
                    }
                    return exp;
                }
            }
        }
    }
    
    public void handleOption(final Symbol name, final String value) {
    }
    
    public static Expression makeFunctionExp(final String className, final String name) {
        return makeFunctionExp(className, Mangling.mangleNameIfNeeded(name), name);
    }
    
    public static Expression makeFunctionExp(final String className, final String fieldName, final String name) {
        return new ReferenceExp(name, Declaration.getDeclarationValueFromStatic(className, fieldName, name));
    }
    
    String tokenString() {
        switch (this.curToken) {
            case 34: {
                final StringBuffer sbuf = new StringBuffer();
                sbuf.append('\"');
                for (int i = 0; i < this.tokenBufferLength; ++i) {
                    final char ch = this.tokenBuffer[i];
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
            default: {
                if (this.curToken >= 100 && this.curToken - 100 < 13) {
                    return XQParser.axisNames[this.curToken - 100] + "::-axis(" + this.curToken + ")";
                }
                if (this.curToken >= 32 && this.curToken < 127) {
                    return Integer.toString(this.curToken) + "='" + (char)this.curToken + "'";
                }
                return Integer.toString(this.curToken);
            }
        }
    }
    
    public void error(final char severity, final String message, final String code) {
        final SourceMessages messages = this.getMessages();
        final SourceError err = new SourceError(severity, this.port.getName(), this.curLine, this.curColumn, message);
        err.code = code;
        messages.error(err);
    }
    
    @Override
    public void error(final char severity, final String message) {
        this.error(severity, message, null);
    }
    
    public Expression declError(final String message) throws IOException, SyntaxException {
        if (this.isInteractive()) {
            return this.syntaxError(message);
        }
        this.error(message);
        while (this.curToken != 59 && this.curToken != -1) {
            this.getRawToken();
        }
        return new ErrorExp(message);
    }
    
    public Expression syntaxError(final String message, final String code) throws IOException, SyntaxException {
        this.error('e', message, code);
        if (this.isInteractive()) {
            this.curToken = 0;
            this.curValue = null;
            this.nesting = 0;
            this.getPort().readState = '\n';
            while (true) {
                final int ch = this.read();
                if (ch < 0) {
                    break;
                }
                if (ch == 13 || ch == 10) {
                    this.unread(ch);
                    break;
                }
            }
            throw new SyntaxException(this.getMessages());
        }
        return new ErrorExp(message);
    }
    
    public Expression syntaxError(final String message) throws IOException, SyntaxException {
        return this.syntaxError(message, "XPST0003");
    }
    
    @Override
    public void eofError(final String msg) throws SyntaxException {
        this.fatal(msg, "XPST0003");
    }
    
    public void fatal(final String msg, final String code) throws SyntaxException {
        final SourceMessages messages = this.getMessages();
        final SourceError err = new SourceError('f', this.port.getName(), this.curLine, this.curColumn, msg);
        err.code = code;
        messages.error(err);
        throw new SyntaxException(messages);
    }
    
    void warnOldVersion(final String message) {
        if (XQParser.warnOldVersion || this.comp.isPedantic()) {
            this.error(this.comp.isPedantic() ? 'e' : 'w', message);
        }
    }
    
    public void maybeSetLine(final Expression exp, final int line, final int column) {
        final String file = this.getName();
        if (file != null && exp.getFileName() == null && !(exp instanceof QuoteExp)) {
            exp.setFile(file);
            exp.setLine(line, column);
        }
    }
    
    public void maybeSetLine(final Declaration decl, final int line, final int column) {
        final String file = this.getName();
        if (file != null) {
            decl.setFile(file);
            decl.setLine(line, column);
        }
    }
    
    static {
        XQParser.warnOldVersion = true;
        XQParser.warnHidePreviousDeclaration = false;
        DOT_VARNAME = Symbol.makeUninterned("$dot$");
        POSITION_VARNAME = Symbol.makeUninterned("$position$");
        LAST_VARNAME = Symbol.makeUninterned("$last$");
        instanceOf = new InstanceOf(XQuery.getInstance(), "instance");
        castableAs = CastableAs.castableAs;
        treatAs = Convert.cast;
        XQParser.proc_OccurrenceType_getInstance = new PrimProcedure(ClassType.make("gnu.kawa.reflect.OccurrenceType").getDeclaredMethod("getInstance", 3));
        XQParser.makeChildAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml.ChildAxis", "make", 1));
        XQParser.makeDescendantAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml.DescendantAxis", "make", 1));
        XQParser.makeText = makeFunctionExp("gnu.kawa.xml.MakeText", "makeText");
        makeCDATA = makeFunctionExp("gnu.kawa.xml.MakeCDATA", "makeCDATA");
        NamespaceBinding ns = NamespaceBinding.predefinedXML;
        ns = new NamespaceBinding("xml", "http://www.w3.org/XML/1998/namespace", ns);
        ns = new NamespaceBinding("xs", "http://www.w3.org/2001/XMLSchema", ns);
        ns = new NamespaceBinding("xsi", "http://www.w3.org/2001/XMLSchema-instance", ns);
        ns = new NamespaceBinding("fn", "http://www.w3.org/2005/xpath-functions", ns);
        ns = new NamespaceBinding("html", "http://www.w3.org/1999/xhtml", ns);
        ns = new NamespaceBinding("kawa", "http://kawa.gnu.org/", ns);
        ns = new NamespaceBinding("qexo", "http://qexo.gnu.org/", ns);
        ns = (XQParser.builtinNamespaces = new NamespaceBinding("local", "http://www.w3.org/2005/xquery-local-functions", ns));
        getExternalFunction = QuoteExp.getInstance(new PrimProcedure("gnu.xquery.lang.XQuery", "getExternal", 2));
        (axisNames = new String[13])[0] = "ancestor";
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
