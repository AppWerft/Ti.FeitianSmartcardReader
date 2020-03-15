// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import java.util.Iterator;
import java.util.List;
import gnu.lists.Sequences;
import gnu.text.SourceLocator;
import gnu.kawa.functions.Arrays;
import java.lang.reflect.Array;
import gnu.bytecode.PrimType;
import gnu.expr.Special;
import gnu.expr.ApplicationMainSupport;
import gnu.text.Char;
import gnu.lists.PairWithPosition;
import java.math.BigDecimal;
import gnu.lists.Convert;
import gnu.math.RatNum;
import gnu.math.DFloNum;
import gnu.math.DQuaternion;
import gnu.math.Complex;
import gnu.math.DComplex;
import gnu.math.RealNum;
import gnu.math.IntNum;
import gnu.math.Quaternion;
import gnu.lists.FString;
import gnu.lists.LList;
import kawa.standard.begin;
import gnu.lists.Sequence;
import gnu.expr.Keyword;
import gnu.mapping.Symbol;
import gnu.mapping.SimpleSymbol;
import gnu.expr.QuoteExp;
import gnu.mapping.Values;
import gnu.lists.Pair;
import gnu.mapping.Environment;
import java.util.regex.Matcher;
import java.nio.charset.UnsupportedCharsetException;
import java.util.regex.Pattern;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.kawa.io.BinaryInPort;
import gnu.text.SourceMessages;
import gnu.kawa.io.InPort;
import gnu.kawa.util.GeneralHashTable;
import gnu.text.Lexer;

public class LispReader extends Lexer
{
    boolean returnMutablePairs;
    GeneralHashTable<Integer, Object> sharedStructureTable;
    boolean inQuasiSyntax;
    char readCase;
    public static final char TOKEN_ESCAPE_CHAR = '\uffff';
    protected boolean seenEscapes;
    static final int SCM_COMPLEX = 1;
    public static final int SCM_NUMBERS = 1;
    public static final int SCM_ANGLE = 2;
    public static final int SCM_COLATITUDE = 4;
    public static final int SCM_LEXPONENT_IS_BIGDECIMAL = 8;
    boolean deprecatedXmlEnlosedReported;
    
    public LispReader(final InPort port) {
        super(port);
        this.readCase = lookupReadCase();
    }
    
    public LispReader(final InPort port, final SourceMessages messages) {
        super(port, messages);
        this.readCase = lookupReadCase();
    }
    
    public void setReturnMutablePairs(final boolean v) {
        this.returnMutablePairs = v;
    }
    
    public Object bindSharedObject(final int sharingIndex, final Object value) {
        if (sharingIndex >= 0) {
            GeneralHashTable<Integer, Object> map = this.sharedStructureTable;
            if (map == null) {
                map = new GeneralHashTable<Integer, Object>();
                this.sharedStructureTable = map;
            }
            final Integer key = sharingIndex;
            if (map.get((Object)key, (Object)this) != this) {
                this.error('w', "a duplicate #n= definition was read");
            }
            map.put(key, value);
        }
        return value;
    }
    
    public final void readNestedComment(final char start1, final char start2, final char end1, final char end2) throws IOException, SyntaxException {
        int commentNesting = 1;
        final int startLine = this.port.getLineNumber();
        final int startColumn = this.port.getColumnNumber();
        StringBuilder buf = null;
        if (this.port instanceof BinaryInPort && (startLine == 0 || startLine == 1)) {
            buf = new StringBuilder();
        }
        do {
            int c = this.read();
            if (buf != null) {
                buf.append((char)c);
            }
            if (c == end1) {
                c = this.read();
                if (buf != null) {
                    buf.append((char)c);
                }
                if (c == end2) {
                    --commentNesting;
                }
            }
            else if (c == start1) {
                c = this.read();
                if (c == start2) {
                    ++commentNesting;
                }
            }
            if (c < 0) {
                this.eofError("unexpected end-of-file in " + start1 + start2 + " comment starting here", startLine + 1, startColumn - 1);
                return;
            }
        } while (commentNesting > 0);
        if (buf != null) {
            this.checkEncodingSpec(buf.toString());
        }
    }
    
    public void checkEncodingSpec(final String line) {
        final Matcher m = Pattern.compile("coding[:=]\\s*([-a-zA-Z0-9]+)").matcher(line);
        if (m.find()) {
            final String enc = m.group(1);
            try {
                ((BinaryInPort)this.getPort()).setCharset(enc);
            }
            catch (UnsupportedCharsetException ex) {
                this.error('e', "unrecognized encoding name " + enc);
            }
            catch (Exception ex2) {
                this.error('e', "cannot set encoding name here");
            }
        }
    }
    
    public char getReadCase() {
        return this.readCase;
    }
    
    public void setReadCase(final char readCase) {
        this.readCase = readCase;
    }
    
    static char lookupReadCase() {
        try {
            final String read_case_string = Environment.getCurrent().get("symbol-read-case", "P").toString();
            if (read_case_string.length() > 0) {
                char read_case = read_case_string.charAt(0);
                if (read_case != 'P') {
                    if (read_case == 'u') {
                        read_case = 'U';
                    }
                    else if (read_case == 'd' || read_case == 'l' || read_case == 'L') {
                        read_case = 'D';
                    }
                    else if (read_case == 'i') {
                        read_case = 'I';
                    }
                }
                return read_case;
            }
        }
        catch (Exception ex) {}
        return '\0';
    }
    
    public Object readValues(final int ch, final ReadTable rtable, final int sharingIndex) throws IOException, SyntaxException {
        return this.readValues(ch, rtable.lookup(ch), rtable, sharingIndex);
    }
    
    public Object readValues(final int ch, final ReadTableEntry entry, final ReadTable rtable, final int sharingIndex) throws IOException, SyntaxException {
        this.seenEscapes = false;
        return entry.read(this, ch, -1, sharingIndex);
    }
    
    public Pair readValuesAndAppend(final int ch, final ReadTable rtable, Pair last) throws IOException, SyntaxException {
        final int line = this.port.getLineNumber();
        final int column = this.port.getColumnNumber() - 1;
        final Object values = this.readValues(ch, rtable, -1);
        int index = 0;
        int next = Values.nextIndex(values, index);
        if (next >= 0) {
            do {
                Object value = Values.nextValue(values, index);
                index = next;
                if (value == QuoteExp.voidExp) {
                    value = Values.empty;
                }
                next = Values.nextIndex(values, index);
                if (next < 0) {
                    value = this.handlePostfix(value, rtable, line, column);
                }
                final Pair pair = this.makePair(value, line, column);
                this.setCdr(last, pair);
                last = pair;
            } while (next >= 0);
        }
        return last;
    }
    
    protected Object readAndHandleToken(final int ch, final int startPos, final ReadTable rtable) throws IOException, SyntaxException {
        this.readToken(ch, rtable);
        return this.handleToken(startPos, rtable);
    }
    
    protected Object handleToken(int startPos, final ReadTable rtable) throws IOException, SyntaxException {
        char readCase = this.getReadCase();
        int endPos = this.tokenBufferLength;
        if (!this.seenEscapes) {
            final Object value = parseNumber(this.tokenBuffer, startPos, endPos - startPos, '\0', 0, 0x1 | rtable.extraFlags);
            if (value != null && !(value instanceof String)) {
                this.tokenBufferLength = startPos;
                return value;
            }
        }
        if (readCase == 'I') {
            int upperCount = 0;
            int lowerCount = 0;
            for (int i = startPos; i < endPos; ++i) {
                final char ci = this.tokenBuffer[i];
                if (ci == '\uffff') {
                    ++i;
                }
                else if (Character.isLowerCase(ci)) {
                    ++lowerCount;
                }
                else if (Character.isUpperCase(ci)) {
                    ++upperCount;
                }
            }
            if (lowerCount == 0) {
                readCase = 'D';
            }
            else if (upperCount == 0) {
                readCase = 'U';
            }
            else {
                readCase = 'P';
            }
        }
        final boolean handleUri = endPos >= startPos + 2 && this.tokenBuffer[endPos - 1] == '}' && this.tokenBuffer[endPos - 2] != '\uffff' && this.peek() == 58;
        int packageMarker = -1;
        int lbrace = -1;
        int rbrace = -1;
        int braceNesting = 0;
        int j = startPos;
        boolean uriBad = false;
        for (int k = startPos; k < endPos; ++k) {
            char ci2 = this.tokenBuffer[k];
            if (ci2 == '\uffff') {
                if (++k < endPos) {
                    this.tokenBuffer[j++] = this.tokenBuffer[k];
                }
            }
            else {
                if (handleUri) {
                    if (ci2 == '{') {
                        if (lbrace < 0) {
                            lbrace = j;
                        }
                        else if (braceNesting == 0) {
                            uriBad = true;
                        }
                        ++braceNesting;
                    }
                    else if (ci2 == '}') {
                        if (--braceNesting < 0) {
                            uriBad = true;
                        }
                        else if (braceNesting == 0) {
                            if (rbrace < 0) {
                                rbrace = j;
                            }
                            else {
                                uriBad = true;
                            }
                        }
                    }
                }
                if (braceNesting <= 0) {
                    if (ci2 == ':') {
                        packageMarker = ((packageMarker >= 0) ? -1 : j);
                    }
                    else if (readCase == 'U') {
                        ci2 = Character.toUpperCase(ci2);
                    }
                    else if (readCase == 'D') {
                        ci2 = Character.toLowerCase(ci2);
                    }
                }
                this.tokenBuffer[j++] = ci2;
            }
        }
        endPos = j;
        final int len = endPos - startPos;
        Object result;
        if (lbrace >= 0 && rbrace > lbrace) {
            final String prefix = (lbrace > 0) ? new String(this.tokenBuffer, startPos, lbrace - startPos) : null;
            ++lbrace;
            final String uri = new String(this.tokenBuffer, lbrace, rbrace - lbrace);
            int ch = this.read();
            ch = this.read();
            final Object rightOperand = this.readValues(ch, rtable.lookup(ch), rtable, -1);
            if (!(rightOperand instanceof SimpleSymbol)) {
                this.error("expected identifier in symbol after '{URI}:'");
            }
            result = Symbol.valueOf(rightOperand.toString(), uri, prefix);
        }
        else if (rtable.initialColonIsKeyword && packageMarker == startPos && len > 1) {
            ++startPos;
            final String str = new String(this.tokenBuffer, startPos, endPos - startPos);
            result = Keyword.make(str.intern());
        }
        else if (rtable.finalColonIsKeyword && packageMarker != -1 && packageMarker == endPos - 1 && (len > 1 || this.seenEscapes)) {
            final String str = new String(this.tokenBuffer, startPos, len - 1);
            result = Keyword.make(str.intern());
        }
        else {
            if (len == 1 && this.tokenBuffer[startPos] == '.' && !this.seenEscapes) {
                this.error("invalid use of '.' token");
            }
            result = rtable.makeSymbol(new String(this.tokenBuffer, startPos, len));
        }
        this.tokenBufferLength = startPos;
        return result;
    }
    
    void readToken(int ch, final ReadTable rtable) throws IOException, SyntaxException {
        boolean inEscapes = false;
        int braceNesting = 0;
        while (true) {
            if (ch < 0) {
                if (!inEscapes) {
                    break;
                }
                this.eofError("unexpected EOF between escapes");
            }
            final ReadTableEntry entry = rtable.lookup(ch);
            int kind = entry.getKind();
            if (kind == 0) {
                if (inEscapes) {
                    this.tokenBufferAppend(65535);
                    this.tokenBufferAppend(ch);
                }
                else {
                    if (ch != 125 || --braceNesting < 0) {
                        this.unread(ch);
                        break;
                    }
                    this.tokenBufferAppend(ch);
                }
            }
            else {
                if (ch == rtable.postfixLookupOperator && !inEscapes) {
                    final int next = this.port.peek();
                    if (next == rtable.postfixLookupOperator) {
                        this.unread(ch);
                        break;
                    }
                    if (this.validPostfixLookupStart(next, rtable)) {
                        kind = 5;
                    }
                }
                if (kind == 3) {
                    ch = this.read();
                    if (ch < 0) {
                        this.eofError("unexpected EOF after single escape");
                    }
                    if (rtable.hexEscapeAfterBackslash && (inEscapes || ch == 120 || ch == 88)) {
                        ch = this.readEscape(ch);
                    }
                    if (ch >= 0) {
                        this.tokenBufferAppend(65535);
                        this.tokenBufferAppend(ch);
                    }
                    this.seenEscapes = true;
                }
                else if (kind == 4) {
                    inEscapes = !inEscapes;
                    this.seenEscapes = true;
                }
                else if (inEscapes) {
                    this.tokenBufferAppend(65535);
                    this.tokenBufferAppend(ch);
                }
                else {
                    switch (kind) {
                        case 2: {
                            if (ch == 123 && entry == ReadTableEntry.brace) {
                                ++braceNesting;
                            }
                        }
                        case 6: {
                            this.tokenBufferAppend(ch);
                            break;
                        }
                        case 4: {
                            inEscapes = true;
                            this.seenEscapes = true;
                            break;
                        }
                        case 5: {
                            this.unread(ch);
                            return;
                        }
                        case 1: {
                            this.unread(ch);
                            return;
                        }
                    }
                }
            }
            ch = this.read();
        }
    }
    
    public String readTokenString(final int ch, final ReadTable rtable) throws IOException, SyntaxException {
        final int startPos = this.tokenBufferLength;
        if (ch >= 0) {
            this.tokenBufferAppend(ch);
        }
        this.readToken(this.read(), rtable);
        final int length = this.tokenBufferLength - startPos;
        final String str = new String(this.tokenBuffer, startPos, length);
        this.tokenBufferLength = startPos;
        return str;
    }
    
    public Object readObject() throws IOException, SyntaxException {
        return this.readObject(-1, false);
    }
    
    public Object readObject(final int sharingIndex, final boolean topLevel) throws IOException, SyntaxException {
        final char saveReadState = this.port.readState;
        final int startPos = this.tokenBufferLength;
        this.port.readState = ' ';
        try {
            final ReadTable rtable = ReadTable.getCurrent();
            while (true) {
                final int line = this.port.getLineNumber();
                final int column = this.port.getColumnNumber();
                final int ch = this.port.read();
                if (ch < 0) {
                    return Sequence.eofValue;
                }
                Object value = this.readValues(ch, rtable, sharingIndex);
                if (value == Values.empty) {
                    continue;
                }
                value = this.handlePostfix(value, rtable, line, column);
                if (topLevel && !(value instanceof Pair)) {
                    value = this.makePair(begin.begin, this.makePair(value, line, column), line, column);
                }
                return value;
            }
        }
        finally {
            this.tokenBufferLength = startPos;
            this.port.readState = saveReadState;
        }
    }
    
    protected boolean validPostfixLookupStart(final int ch, final ReadTable rtable) throws IOException {
        if (ch < 0 || ch == rtable.postfixLookupOperator) {
            return false;
        }
        if (ch == 44) {
            return true;
        }
        if (ch == 64) {
            return true;
        }
        final int kind = rtable.lookup(ch).getKind();
        return kind == 2 || kind == 6 || kind == 4 || kind == 3;
    }
    
    protected Object handlePostfix(Object value, final ReadTable rtable, final int line, final int column) throws IOException, SyntaxException {
        if (value == QuoteExp.voidExp) {
            value = Values.empty;
        }
        while (true) {
            int ch = this.port.peek();
            if (ch == 91 && ReadTable.defaultBracketMode == -2) {
                this.port.read();
                final Object lst = ReaderParens.readList(this, null, ch, 1, 93, -1);
                value = this.makePair(value, lst, line, column);
                value = this.makePair(LispLanguage.bracket_apply_sym, value, line, column);
            }
            else {
                if (ch != rtable.postfixLookupOperator) {
                    break;
                }
                this.port.read();
                final int ch2 = this.port.peek();
                Object rightOperand;
                if (ch2 == 64) {
                    this.error('w', "deprecated cast syntax TYPE:@ (use ->TYPE instead)");
                    rightOperand = this.readAndHandleToken(92, 0, rtable);
                }
                else {
                    if (!this.validPostfixLookupStart(ch2, rtable)) {
                        this.unread();
                        break;
                    }
                    ch = this.port.read();
                    rightOperand = this.readValues(ch, rtable.lookup(ch), rtable, -1);
                }
                value = LList.list2(value, LList.list2(LispLanguage.quasiquote_sym, rightOperand));
                value = this.makePair(LispLanguage.lookup_sym, value, line, column);
            }
        }
        return value;
    }
    
    private boolean isPotentialNumber(final char[] buffer, final int start, final int end) {
        int sawDigits = 0;
        for (int i = start; i < end; ++i) {
            final char ch = buffer[i];
            if (Character.isDigit(ch)) {
                ++sawDigits;
            }
            else if (ch == '-' || ch == '+') {
                if (i + 1 == end) {
                    return false;
                }
            }
            else {
                if (ch == '#') {
                    return true;
                }
                if (Character.isLetter(ch) || ch == '/' || ch == '_' || ch == '^') {
                    if (i == start) {
                        return false;
                    }
                }
                else if (ch != '.') {
                    return false;
                }
            }
        }
        return sawDigits > 0;
    }
    
    public static Object parseNumber(final CharSequence str, final int radix) {
        final int len = str.length();
        int where;
        char[] buf;
        if (str instanceof FString && (where = ((FString)str).getSegmentReadOnly(0, len)) >= 0) {
            buf = ((FString)str).getBuffer();
        }
        else {
            where = 0;
            buf = str.toString().toCharArray();
        }
        return parseNumber(buf, where, len, '\0', radix, 1);
    }
    
    public static Object parseNumber(final char[] buffer, final int start, final int count, char exactness, int radix, final int flags) {
        final int end = start + count;
        int pos = start;
        if (pos >= end) {
            return "no digits";
        }
        char ch;
        for (ch = buffer[pos++]; ch == '#'; ch = buffer[pos++]) {
            if (pos >= end) {
                return "no digits";
            }
            ch = buffer[pos++];
            Label_0364: {
                switch (ch) {
                    case 'B':
                    case 'b': {
                        if (radix > 0) {
                            return "duplicate radix specifier";
                        }
                        radix = 2;
                        break;
                    }
                    case 'O':
                    case 'o': {
                        if (radix > 0) {
                            return "duplicate radix specifier";
                        }
                        radix = 8;
                        break;
                    }
                    case 'D':
                    case 'd': {
                        if (radix > 0) {
                            return "duplicate radix specifier";
                        }
                        radix = 10;
                        break;
                    }
                    case 'X':
                    case 'x': {
                        if (radix > 0) {
                            return "duplicate radix specifier";
                        }
                        radix = 16;
                        break;
                    }
                    case 'E':
                    case 'I':
                    case 'e':
                    case 'i': {
                        if (exactness == '\0') {
                            exactness = ch;
                            break;
                        }
                        if (exactness == ' ') {
                            return "non-prefix exactness specifier";
                        }
                        return "duplicate exactness specifier";
                    }
                    default: {
                        int value = 0;
                        while (true) {
                            final int dig = Character.digit(ch, 10);
                            if (dig < 0) {
                                if (ch != 'R' && ch != 'r') {
                                    return "unknown modifier '#" + ch + '\'';
                                }
                                if (radix > 0) {
                                    return "duplicate radix specifier";
                                }
                                if (value < 2 || value > 35) {
                                    return "invalid radix specifier";
                                }
                                radix = value;
                                break Label_0364;
                            }
                            else {
                                value = 10 * value + dig;
                                if (pos >= end) {
                                    return "missing letter after '#'";
                                }
                                ch = buffer[pos++];
                            }
                        }
                        break;
                    }
                }
            }
            if (pos >= end) {
                return "no digits";
            }
        }
        if (exactness == '\0') {
            exactness = ' ';
        }
        if (radix < 0) {
            radix = -radix;
        }
        else if (radix == 0) {
            radix = 10;
        }
        final boolean numeratorNegative;
        boolean negative = numeratorNegative = (ch == '-');
        final boolean sign_seen = ch == '-' || ch == '+';
        if (sign_seen) {
            if (pos >= end) {
                return "no digits following sign";
            }
            ch = buffer[pos++];
        }
        if ((ch == 'i' || ch == 'I') && (pos == end || buffer[pos] == '+' || buffer[pos] == '-') && start == pos - 2 && (flags & 0x1) != 0x0) {
            final char sign = buffer[start];
            if (sign != '+' && sign != '-') {
                return "no digits";
            }
            if (pos < end) {
                final Object jmag = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                if (jmag instanceof String) {
                    return jmag;
                }
                if (!(jmag instanceof Quaternion)) {
                    return "invalid numeric constant (" + jmag + ")";
                }
                final Quaternion qjmag = (Quaternion)jmag;
                final RealNum re = qjmag.re();
                final RealNum im = qjmag.im();
                if (!re.isZero() || !im.isZero()) {
                    return "invalid numeric constant";
                }
                if (exactness == 'i' || exactness == 'I') {
                    return Quaternion.make(0.0, negative ? -1.0 : 1.0, qjmag.doubleJmagValue(), qjmag.doubleKmagValue());
                }
                return Quaternion.make(IntNum.zero(), negative ? IntNum.minusOne() : IntNum.one(), qjmag.jm(), qjmag.km());
            }
            else {
                if (exactness == 'i' || exactness == 'I') {
                    return new DComplex(0.0, negative ? -1.0 : 1.0);
                }
                return negative ? Complex.imMinusOne() : Complex.imOne();
            }
        }
        else if ((ch == 'j' || ch == 'J') && (pos == end || buffer[pos] == '+' || buffer[pos] == '-') && start == pos - 2 && (flags & 0x1) != 0x0) {
            final char sign = buffer[start];
            if (sign != '+' && sign != '-') {
                return "no digits";
            }
            if (pos < end) {
                final Object kmag = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                if (kmag instanceof String) {
                    return kmag;
                }
                if (!(kmag instanceof Quaternion)) {
                    return "invalid numeric constant (" + kmag + ")";
                }
                final Quaternion qkmag = (Quaternion)kmag;
                final RealNum re = qkmag.re();
                final RealNum im = qkmag.im();
                final RealNum jm = qkmag.jm();
                if (!re.isZero() || !im.isZero() || !jm.isZero()) {
                    return "invalid numeric constant";
                }
                if (exactness == 'i' || exactness == 'I') {
                    return Quaternion.make(0.0, 0.0, negative ? -1.0 : 1.0, qkmag.doubleKmagValue());
                }
                return Quaternion.make(IntNum.zero(), IntNum.zero(), negative ? IntNum.minusOne() : IntNum.one(), qkmag.km());
            }
            else {
                if (exactness == 'i' || exactness == 'I') {
                    return new DQuaternion(0.0, 0.0, 0.0, negative ? -1.0 : 1.0);
                }
                return negative ? Quaternion.jmMinusOne() : Quaternion.jmOne();
            }
        }
        else if ((ch == 'k' || ch == 'K') && pos == end && start == pos - 2 && (flags & 0x1) != 0x0) {
            final char sign = buffer[start];
            if (sign != '+' && sign != '-') {
                return "no digits";
            }
            if (exactness == 'i' || exactness == 'I') {
                return new DQuaternion(0.0, 0.0, 0.0, negative ? -1.0 : 1.0);
            }
            return negative ? Quaternion.kmMinusOne() : Quaternion.kmOne();
        }
        else {
            final int realStart = pos - 1;
            boolean hash_seen = false;
            int exp_seen = -1;
            int digits_start = -1;
            int decimal_point = -1;
            final boolean copy_needed = false;
            boolean underscore_seen = false;
            IntNum numerator = null;
            long lvalue = 0L;
        Label_1659:
            while (true) {
                final int digit = Character.digit(ch, radix);
                if (digit >= 0) {
                    if (hash_seen && decimal_point < 0) {
                        return "digit after '#' in number";
                    }
                    if (digits_start < 0) {
                        digits_start = pos - 1;
                    }
                    lvalue = radix * lvalue + digit;
                }
                else {
                    switch (ch) {
                        case '.': {
                            if (decimal_point >= 0) {
                                return "duplicate '.' in number";
                            }
                            if (radix != 10) {
                                return "'.' in non-decimal number";
                            }
                            decimal_point = pos - 1;
                            break;
                        }
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'L':
                        case 'S':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'l':
                        case 's': {
                            if (pos == end || radix != 10) {
                                --pos;
                                break Label_1659;
                            }
                            final char next = buffer[pos];
                            final int exp_pos = pos - 1;
                            if (next == '+' || next == '-') {
                                if (++pos >= end || Character.digit(buffer[pos], 10) < 0) {
                                    return "missing exponent digits";
                                }
                            }
                            else if (Character.digit(next, 10) < 0) {
                                --pos;
                                break Label_1659;
                            }
                            if (exp_seen >= 0) {
                                return "duplicate exponent";
                            }
                            if (radix != 10) {
                                return "exponent in non-decimal number";
                            }
                            if (digits_start < 0) {
                                return "mantissa with no digits";
                            }
                            exp_seen = exp_pos;
                            while (++pos < end) {
                                if (Character.digit(buffer[pos], 10) < 0) {
                                    break;
                                }
                            }
                            break Label_1659;
                        }
                        case '/': {
                            if (numerator != null) {
                                return "multiple fraction symbol '/'";
                            }
                            if (digits_start < 0) {
                                return "no digits before fraction symbol '/'";
                            }
                            if (exp_seen >= 0 || decimal_point >= 0) {
                                return "fraction symbol '/' following exponent or '.'";
                            }
                            numerator = valueOf(buffer, digits_start, pos - digits_start, radix, negative, lvalue);
                            digits_start = -1;
                            lvalue = 0L;
                            negative = false;
                            hash_seen = false;
                            underscore_seen = false;
                            break;
                        }
                        default: {
                            --pos;
                            break Label_1659;
                        }
                    }
                }
                if (pos == end) {
                    break;
                }
                ch = buffer[pos++];
            }
            char infnan = '\0';
            if (digits_start < 0) {
                if (sign_seen && pos + 4 < end && buffer[pos + 3] == '.' && buffer[pos + 4] == '0') {
                    final char b0 = buffer[pos];
                    char b2;
                    char b3;
                    if ((b0 == 'i' || b0 == 'I') && ((b2 = buffer[pos + 1]) == 'n' || b2 == 'N') && ((b3 = buffer[pos + 2]) == 'f' || b3 == 'F')) {
                        infnan = 'i';
                    }
                    else if ((b0 == 'n' || b0 == 'N') && ((b2 = buffer[pos + 1]) == 'a' || b2 == 'A') && ((b3 = buffer[pos + 2]) == 'n' || b3 == 'N')) {
                        infnan = 'n';
                    }
                }
                if (infnan == '\0') {
                    return "no digits";
                }
                pos += 5;
            }
            if (hash_seen || underscore_seen) {}
            boolean inexact = exactness == 'i' || exactness == 'I' || (exactness == ' ' && hash_seen);
            RealNum number = null;
            char exp_char = '\0';
            if (infnan != '\0') {
                inexact = true;
                final double d = (infnan == 'i') ? Double.POSITIVE_INFINITY : Double.NaN;
                number = new DFloNum(negative ? (-d) : d);
            }
            else if (exp_seen >= 0 || decimal_point >= 0) {
                if (digits_start > decimal_point && decimal_point >= 0) {
                    digits_start = decimal_point;
                }
                if (numerator != null) {
                    return "floating-point number after fraction symbol '/'";
                }
                if (exactness == 'e' || exactness == 'E') {
                    int exp = 0;
                    IntNum inumber;
                    if (decimal_point < 0) {
                        inumber = valueOf(buffer, digits_start, exp_seen - digits_start, radix, negative, lvalue);
                    }
                    else {
                        final StringBuilder sbuf = new StringBuilder();
                        if (negative) {
                            sbuf.append('-');
                        }
                        sbuf.append(buffer, digits_start, decimal_point - digits_start);
                        ++decimal_point;
                        final int fracdigits = ((exp_seen >= 0) ? exp_seen : pos) - decimal_point;
                        sbuf.append(buffer, decimal_point, fracdigits);
                        inumber = IntNum.valueOf(sbuf.toString());
                        exp -= fracdigits;
                    }
                    if (exp_seen >= 0) {
                        exp += Integer.parseInt(new String(buffer, exp_seen + 1, pos - (exp_seen + 1)));
                    }
                    if (exp > 0) {
                        number = IntNum.times(inumber, IntNum.power(IntNum.ten(), exp));
                    }
                    else if (exp < 0) {
                        number = RatNum.make(inumber, IntNum.power(IntNum.ten(), -exp));
                    }
                    else {
                        number = inumber;
                    }
                }
                else {
                    String str = new String(buffer, digits_start, pos - digits_start);
                    if (exp_seen >= 0) {
                        exp_char = Character.toLowerCase(buffer[exp_seen]);
                        if (exp_char != 'e') {
                            final int prefix = exp_seen - digits_start;
                            str = str.substring(0, prefix) + 'e' + str.substring(prefix + 1);
                        }
                    }
                    final double d2 = Convert.parseDouble(str);
                    number = new DFloNum(negative ? (-d2) : d2);
                }
            }
            else {
                final IntNum iresult = valueOf(buffer, digits_start, pos - digits_start, radix, negative, lvalue);
                if (numerator == null) {
                    number = iresult;
                }
                else if (iresult.isZero()) {
                    final boolean numeratorZero = numerator.isZero();
                    if (inexact) {
                        number = new DFloNum(numeratorZero ? Double.NaN : (numeratorNegative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY));
                    }
                    else {
                        if (numeratorZero) {
                            return "0/0 is undefined";
                        }
                        number = RatNum.make(numerator, iresult);
                    }
                }
                else {
                    number = RatNum.make(numerator, iresult);
                }
                if (inexact && number.isExact()) {
                    number = new DFloNum((numeratorNegative && number.isZero()) ? -0.0 : number.doubleValue());
                }
            }
            if (exactness == 'e' || exactness == 'E') {
                number = number.toExact();
            }
            if (pos >= end) {
                if (number instanceof DFloNum && exp_char > '\0' && exp_char != 'e') {
                    final double d = number.doubleValue();
                    switch (exp_char) {
                        case 'f':
                        case 's': {
                            return (float)d;
                        }
                        case 'd': {
                            return d;
                        }
                        case 'l': {
                            if ((flags & 0x8) != 0x0) {
                                return BigDecimal.valueOf(d);
                            }
                            break;
                        }
                    }
                }
                return number;
            }
            ch = buffer[pos++];
            if (ch == '@') {
                final Object angle = parseNumber(buffer, pos, end - pos, exactness, radix, flags | 0x2);
                if (angle instanceof String) {
                    return angle;
                }
                if (!(angle instanceof RealNum) && !(angle instanceof RealNum[])) {
                    return "invalid complex polar constant";
                }
                if (angle instanceof RealNum[]) {
                    final RealNum[] polars = (RealNum[])angle;
                    if (number.isZero() && (!polars[0].isExact() || !polars[1].isExact() || !polars[2].isExact())) {
                        return new DFloNum(0.0);
                    }
                    return Quaternion.polar(number, polars[0], polars[1], polars[2]);
                }
                else {
                    final RealNum rangle = (RealNum)angle;
                    if (number.isZero() && !rangle.isExact()) {
                        return new DFloNum(0.0);
                    }
                    return Complex.polar(number, rangle);
                }
            }
            else if (ch == '%') {
                final Object colatitude = parseNumber(buffer, pos, end - pos, exactness, radix, flags | 0x4);
                if (colatitude instanceof String) {
                    return colatitude;
                }
                if (!(colatitude instanceof RealNum) && !(colatitude instanceof RealNum[])) {
                    return "invalid quaternion polar constant";
                }
                if ((flags & 0x2) == 0x0) {
                    final RealNum rangle = IntNum.zero();
                    RealNum rcolatitude;
                    RealNum rlongitude;
                    if (colatitude instanceof RealNum) {
                        rcolatitude = (RealNum)colatitude;
                        rlongitude = IntNum.zero();
                    }
                    else {
                        final RealNum[] polars2 = (RealNum[])colatitude;
                        rcolatitude = polars2[1];
                        rlongitude = polars2[2];
                    }
                    if (number.isZero() && (!rcolatitude.isExact() || !rlongitude.isExact())) {
                        return new DFloNum(0.0);
                    }
                    return Quaternion.polar(number, rangle, rcolatitude, rlongitude);
                }
                else {
                    if (colatitude instanceof RealNum[]) {
                        final RealNum[] polars = (RealNum[])colatitude;
                        polars[0] = number;
                        return polars;
                    }
                    return new RealNum[] { number, (RealNum)colatitude, IntNum.zero() };
                }
            }
            else if (ch == '&') {
                final Object longitude = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                if (longitude instanceof String) {
                    return longitude;
                }
                if (!(longitude instanceof RealNum)) {
                    return "invalid quaternion polar constant";
                }
                final RealNum rlongitude2 = (RealNum)longitude;
                if ((flags & 0x6) == 0x0) {
                    if (number.isZero() && !rlongitude2.isExact()) {
                        return new DFloNum(0.0);
                    }
                    return Quaternion.polar(number, IntNum.zero(), IntNum.zero(), rlongitude2);
                }
                else {
                    if ((flags & 0x4) != 0x0) {
                        return new RealNum[] { IntNum.zero(), number, rlongitude2 };
                    }
                    return new RealNum[] { number, IntNum.zero(), rlongitude2 };
                }
            }
            else {
                if (ch != '-' && ch != '+') {
                    int lcount = 0;
                    while (true) {
                        while (Character.isLetter(ch)) {
                            ++lcount;
                            if (pos == end) {
                                if (lcount == 1) {
                                    final char prev = buffer[pos - 1];
                                    if (prev == 'i' || prev == 'I') {
                                        if (pos >= end) {
                                            return Complex.make(IntNum.zero(), number);
                                        }
                                        final Object jmag2 = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                                        if (jmag2 instanceof String) {
                                            return jmag2;
                                        }
                                        if (!(jmag2 instanceof Quaternion)) {
                                            return "invalid numeric constant (" + jmag2 + ")";
                                        }
                                        final Quaternion qjmag2 = (Quaternion)jmag2;
                                        final RealNum re2 = qjmag2.re();
                                        final RealNum im2 = qjmag2.im();
                                        if (!re2.isZero() || !im2.isZero()) {
                                            return "invalid numeric constant";
                                        }
                                        return Quaternion.make(IntNum.zero(), number, qjmag2.jm(), qjmag2.km());
                                    }
                                    else if (prev == 'j' || prev == 'J') {
                                        if (pos >= end) {
                                            return Quaternion.make(IntNum.zero(), IntNum.zero(), number, IntNum.zero());
                                        }
                                        final Object kmag2 = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                                        if (kmag2 instanceof String) {
                                            return kmag2;
                                        }
                                        if (!(kmag2 instanceof Quaternion)) {
                                            return "invalid numeric constant (" + kmag2 + ")";
                                        }
                                        final Quaternion qkmag2 = (Quaternion)kmag2;
                                        final RealNum re2 = qkmag2.re();
                                        final RealNum im2 = qkmag2.im();
                                        final RealNum jm2 = qkmag2.jm();
                                        if (!re2.isZero() || !im2.isZero() || !jm2.isZero()) {
                                            return "invalid numeric constant";
                                        }
                                        return Quaternion.make(IntNum.zero(), IntNum.zero(), number, qkmag2.km());
                                    }
                                    else if (prev == 'k' || prev == 'K') {
                                        if (pos < end) {
                                            return "junk after imaginary suffix 'k'";
                                        }
                                        return Quaternion.make(IntNum.zero(), IntNum.zero(), IntNum.zero(), number);
                                    }
                                }
                                return "excess junk after number";
                            }
                            ch = buffer[pos++];
                        }
                        --pos;
                        continue;
                    }
                }
                --pos;
                final Object imag = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                if (imag instanceof String) {
                    return imag;
                }
                if (!(imag instanceof Quaternion)) {
                    return "invalid numeric constant (" + imag + ")";
                }
                final Quaternion cimag = (Quaternion)imag;
                final RealNum re3 = cimag.re();
                if (!re3.isZero()) {
                    return "invalid numeric constant";
                }
                return Quaternion.make(number, cimag.im(), cimag.jm(), cimag.km());
            }
        }
    }
    
    private static IntNum valueOf(final char[] buffer, final int digits_start, final int number_of_digits, final int radix, final boolean negative, final long lvalue) {
        if (number_of_digits + radix <= 28) {
            return IntNum.make(negative ? (-lvalue) : lvalue);
        }
        return IntNum.valueOf(buffer, digits_start, number_of_digits, radix, negative);
    }
    
    public int readEscape() throws IOException, SyntaxException {
        final int c = this.read();
        if (c < 0) {
            this.eofError("unexpected EOF in character literal");
            return -1;
        }
        return this.readEscape(c);
    }
    
    public final int readEscape(int c) throws IOException, SyntaxException {
        Label_0886: {
            switch ((char)c) {
                case 'a': {
                    c = 7;
                    break;
                }
                case 'b': {
                    c = 8;
                    break;
                }
                case 't': {
                    c = 9;
                    break;
                }
                case 'n': {
                    c = 10;
                    break;
                }
                case 'v': {
                    c = 11;
                    break;
                }
                case 'f': {
                    c = 12;
                    break;
                }
                case 'r': {
                    c = 13;
                    break;
                }
                case 'e': {
                    c = 27;
                    break;
                }
                case '\"': {
                    c = 34;
                    break;
                }
                case '|': {
                    c = 124;
                    break;
                }
                case '\\': {
                    c = 92;
                    break;
                }
                case '\t':
                case '\n':
                case '\r':
                case ' ': {
                    while (c >= 0) {
                        if (c != 10) {
                            if (c == 13) {
                                if (this.peek() == 10) {
                                    this.skip();
                                }
                                c = 10;
                            }
                            else {
                                if (c == 32 || c == 9) {
                                    c = this.read();
                                    continue;
                                }
                                this.unread(c);
                            }
                        }
                        if (c != 10) {
                            break Label_0886;
                        }
                        do {
                            c = this.read();
                            if (c < 0) {
                                this.eofError("unexpected EOF in literal");
                                return -1;
                            }
                        } while (c == 32 || c == 9);
                        this.unread(c);
                        return -2;
                    }
                    this.eofError("unexpected EOF in literal");
                    return -1;
                }
                case 'M': {
                    c = this.read();
                    if (c != 45) {
                        this.error("Invalid escape character syntax");
                        return 63;
                    }
                    c = this.read();
                    if (c == 92) {
                        c = this.readEscape();
                    }
                    return c | 0x80;
                }
                case 'C': {
                    c = this.read();
                    if (c != 45) {
                        this.error("Invalid escape character syntax");
                        return 63;
                    }
                }
                case '^': {
                    c = this.read();
                    if (c == 92) {
                        c = this.readEscape();
                    }
                    if (c == 63) {
                        return 127;
                    }
                    return c & 0x9F;
                }
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7': {
                    c -= 48;
                    int count = 0;
                    while (++count < 3) {
                        final int d = this.read();
                        final int v = Character.digit((char)d, 8);
                        if (v >= 0) {
                            c = (c << 3) + v;
                        }
                        else {
                            if (d >= 0) {
                                this.unread(d);
                                break;
                            }
                            break;
                        }
                    }
                    break;
                }
                case 'u': {
                    c = 0;
                    int i = 4;
                    while (--i >= 0) {
                        final int d = this.read();
                        if (d < 0) {
                            this.eofError("premature EOF in \\u escape");
                        }
                        final int v = Character.digit((char)d, 16);
                        if (v < 0) {
                            this.error("non-hex character following \\u");
                        }
                        c = 16 * c + v;
                    }
                    break;
                }
                case 'X':
                case 'x': {
                    return this.readHexEscape();
                }
            }
        }
        return c;
    }
    
    public int readHexEscape() throws IOException, SyntaxException {
        int c = 0;
        int d;
        while (true) {
            d = this.read();
            final int v = Character.digit((char)d, 16);
            if (v < 0) {
                break;
            }
            c = (c << 4) + v;
        }
        if (d != 59 && d >= 0) {
            this.unread(d);
        }
        return c;
    }
    
    public final Object readObject(final int c) throws IOException, SyntaxException {
        this.unread(c);
        return this.readObject();
    }
    
    public Object readCommand() throws IOException, SyntaxException {
        return this.readObject(-1, true);
    }
    
    protected Object makeNil() {
        return LList.Empty;
    }
    
    protected Pair makePair(final Object car, final int line, final int column) {
        return this.makePair(car, LList.Empty, line, column);
    }
    
    protected Pair makePair(final Object car, final Object cdr, final int line, final int column) {
        final String pname = this.port.getName();
        if (!this.returnMutablePairs && pname != null && line >= 0) {
            return PairWithPosition.make(car, cdr, pname, line + 1, column + 1);
        }
        return Pair.make(car, cdr);
    }
    
    protected Pair makePair2(final Object car, final Object cadr, final Object cddr, final int line, final int column) {
        return this.makePair(car, this.makePair(cadr, cddr, line, column), line, column);
    }
    
    protected void setCar(final Object pair, final Object car) {
        ((Pair)pair).setCarBackdoor(car);
    }
    
    protected void setCdr(final Object pair, final Object cdr) {
        ((Pair)pair).setCdrBackdoor(cdr);
    }
    
    public static Object readNumberWithRadix(final int previous, final LispReader reader, final int radix) throws IOException, SyntaxException {
        final int startPos = reader.tokenBufferLength - previous;
        final ReadTable rtable = ReadTable.getCurrent();
        while (true) {
            reader.readToken(reader.read(), rtable);
            final int ch = reader.peek();
            if (ch != 35) {
                break;
            }
            reader.tokenBufferAppend(ch);
            reader.skip();
        }
        final int endPos = reader.tokenBufferLength;
        if (startPos == endPos) {
            reader.error("missing numeric token");
            return IntNum.zero();
        }
        final Object result = parseNumber(reader.tokenBuffer, startPos, endPos - startPos, '\0', radix, 0);
        if (result instanceof String) {
            reader.error((String)result);
            return IntNum.zero();
        }
        if (result == null) {
            reader.error("invalid numeric constant");
            return IntNum.zero();
        }
        return result;
    }
    
    public static Object readCharacter(final LispReader reader) throws IOException, SyntaxException {
        int ch = reader.read();
        if (ch < 0) {
            reader.eofError("unexpected EOF in character literal");
        }
        final int startPos = reader.tokenBufferLength;
        reader.tokenBufferAppend(ch);
        reader.readToken(reader.read(), ReadTable.getCurrent());
        final char[] tokenBuffer = reader.tokenBuffer;
        final int length = reader.tokenBufferLength - startPos;
        if (length == 1 || length == 2) {
            ch = Character.codePointAt(tokenBuffer, startPos, reader.tokenBufferLength);
            if (ch > 65535 || length == 1) {
                return Char.make(ch);
            }
        }
        final String name = new String(tokenBuffer, startPos, length);
        ch = Char.nameToChar(name);
        if (ch >= 0) {
            return Char.make(ch);
        }
        ch = tokenBuffer[startPos];
        Label_0207: {
            if (ch == 120 || ch == 88) {
                int value = 0;
                for (int i = 1; i != length; ++i) {
                    final int v = Character.digit(tokenBuffer[startPos + i], 16);
                    if (v < 0) {
                        break Label_0207;
                    }
                    value = 16 * value + v;
                    if (value > 1114111) {
                        reader.error("character scalar value greater than #x10FFFF");
                        return Char.make(63);
                    }
                }
                return Char.make(value);
            }
        }
        ch = Character.digit(ch, 8);
        Label_0271: {
            if (ch >= 0) {
                int value = ch;
                for (int i = 1; i != length; ++i) {
                    ch = Character.digit(tokenBuffer[startPos + i], 8);
                    if (ch < 0) {
                        break Label_0271;
                    }
                    value = 8 * value + ch;
                }
                return Char.make(value);
            }
        }
        reader.error("unknown character name: " + name);
        return Char.make(63);
    }
    
    public static Object readSpecial(final LispReader reader) throws IOException, SyntaxException {
        int ch = reader.read();
        if (ch < 0) {
            reader.eofError("unexpected EOF in #! special form");
        }
        if ((ch == 47 || ch == 32) && reader.getLineNumber() == 0 && reader.getColumnNumber() == 3) {
            final String filename = reader.getName();
            if (filename != null && ApplicationMainSupport.commandName.get(null) == null) {
                ApplicationMainSupport.commandName.set(filename);
            }
            boolean sawBackslash = false;
            while (true) {
                ch = reader.read();
                if (ch < 0) {
                    break;
                }
                if (ch == 92) {
                    sawBackslash = true;
                }
                else if (ch == 10 || ch == 13) {
                    if (!sawBackslash) {
                        break;
                    }
                    sawBackslash = false;
                }
                else {
                    if (!sawBackslash || ch == 32 || ch == 9) {
                        continue;
                    }
                    sawBackslash = false;
                }
            }
            return Values.empty;
        }
        final String name = reader.readTokenString(ch, ReadTable.getCurrent());
        if (name.equals("optional")) {
            return Special.optional;
        }
        if (name.equals("rest")) {
            return Special.rest;
        }
        if (name.equals("key")) {
            return Special.key;
        }
        if (name.equals("eof")) {
            return Special.eof;
        }
        if (name.equals("void")) {
            return QuoteExp.voidExp;
        }
        if (name.equals("default")) {
            return Special.dfault;
        }
        if (name.equals("undefined")) {
            return Special.undefined;
        }
        if (name.equals("abstract")) {
            return Special.abstractSpecial;
        }
        if (name.equals("native")) {
            return Special.nativeSpecial;
        }
        if (name.equals("null")) {
            return null;
        }
        if (name.equals("fold-case")) {
            reader.readCase = 'D';
            return Values.empty;
        }
        if (name.equals("no-fold-case")) {
            reader.readCase = 'P';
            return Values.empty;
        }
        reader.error("unknown named constant #!" + name);
        return null;
    }
    
    public static Object readGeneralArray(final LispReader in, int rank, final PrimType elementType) throws IOException, SyntaxException {
        if (rank == -1) {
            rank = 1;
        }
        final int[] dimensions = new int[rank];
        int[] lowBounds = null;
        boolean error = false;
        int ch = in.read();
        final boolean baddim = false;
        int explicitDims = 0;
        if (ch == 64 || ch == 58) {
            for (int r = 0; r < rank; ++r) {
                if (ch == 64) {
                    ch = in.read();
                    final boolean neg = ch == 45;
                    if (!neg) {
                        in.unread(ch);
                    }
                    int low = in.readIntDigits();
                    if (low < 0) {
                        in.error("expected low-bound after '@'");
                        low = 0;
                    }
                    if (lowBounds == null) {
                        lowBounds = new int[rank];
                    }
                    lowBounds[r] = (neg ? (-low) : low);
                    ch = in.read();
                    if (ch != 58 && r == rank - 1) {
                        break;
                    }
                }
                if (ch == 58) {
                    ++explicitDims;
                    final int dim = in.readIntDigits();
                    if (dim < 0) {
                        in.error("expected dimension after ':'");
                        error = true;
                    }
                    dimensions[r] = dim;
                    ch = in.read();
                }
                else if (ch != 64) {
                    in.error("missing bounds-specifier (seen " + r + " of " + rank + ")");
                    error = true;
                }
            }
        }
        if (ch == 64 || ch == 58) {
            in.error("too many bounds-specifiers for rank-" + rank + " array");
            error = true;
        }
        while (ch >= 0 && Character.isWhitespace(ch)) {
            ch = in.read();
        }
        final SourceLocator sloc = PairWithPosition.make(null, null, in.getName(), in.getLineNumber() + 1, in.getColumnNumber());
        in.unread(ch);
        final Object data = in.readObject();
        if (explicitDims == 0) {
            if (!dimensionsFromNested(0, dimensions, data)) {
                in.error("array value is not a nested true list");
                error = true;
            }
        }
        else if (explicitDims < rank) {
            in.error("only " + explicitDims + " array lengths specified - must be all " + rank + " or none");
            error = true;
        }
        if (error) {
            return LList.Empty;
        }
        int size = 1;
        int d = dimensions.length;
        while (--d >= 0) {
            size *= dimensions[d];
        }
        final Object buffer = (elementType == null) ? new Object[size] : Array.newInstance(elementType.getReflectClass(), size);
        final SourceMessages messages = in.getMessages();
        fromNested(buffer, 0, 0, dimensions, data, elementType, sloc, messages);
        return Arrays.makeFromSimple(dimensions, lowBounds, buffer, elementType);
    }
    
    static boolean dimensionsFromNested(final int dim, final int[] dimensions, final Object data) {
        final int rank = dimensions.length;
        if (dim == rank) {
            return true;
        }
        final List seq = Sequences.asSequenceOrNull(data);
        if (seq == null) {
            return false;
        }
        int len;
        if (seq instanceof Pair) {
            len = LList.listLength(seq, false);
        }
        else {
            len = seq.size();
        }
        if (len < 0) {
            return false;
        }
        if (len > dimensions[dim]) {
            dimensions[dim] = len;
        }
        for (final Object el : seq) {
            if (!dimensionsFromNested(dim + 1, dimensions, el)) {
                return false;
            }
        }
        return true;
    }
    
    static void fromNested(final Object buffer, int index, int dim, final int[] dimensions, Object value, final PrimType elementType, SourceLocator sloc, final SourceMessages messages) {
        final int rank = dimensions.length;
        if (dim == rank) {
            final char sig1 = (elementType == null) ? 'L' : elementType.getSignature().charAt(0);
            if (sig1 == 'B' || sig1 == 'S' || sig1 == 'I' || sig1 == 'J') {
                String msg = null;
                if (!(value instanceof IntNum)) {
                    msg = "expected integer value";
                }
                else {
                    final Object nvalue = LangPrimType.convertIntegerLiteral((IntNum)value, elementType, true);
                    if (nvalue == null) {
                        msg = "integer " + value + " not in range of " + elementType.getName();
                    }
                    else {
                        value = nvalue;
                    }
                }
                if (msg != null) {
                    messages.error('e', sloc, msg);
                    value = LangPrimType.convertIntegerLiteral(IntNum.zero(), elementType, true);
                }
            }
            if (sig1 == 'F' || sig1 == 'D') {
                final RealNum rvalue = RealNum.asRealNumOrNull(value);
                if (rvalue != null) {
                    if (sig1 == 'F') {
                        value = rvalue.floatValue();
                    }
                    else {
                        value = rvalue.doubleValue();
                    }
                }
                else {
                    messages.error('e', sloc, "expected real value");
                }
            }
            Array.set(buffer, index, value);
        }
        else {
            ++dim;
            int stride = 1;
            for (int i = dim; i < rank; ++i) {
                stride *= dimensions[i];
            }
            while (value instanceof Pair) {
                final Pair pair = (Pair)value;
                if (pair instanceof SourceLocator) {
                    sloc = (SourceLocator)pair;
                }
                fromNested(buffer, index, dim, dimensions, pair.getCar(), elementType, sloc, messages);
                value = pair.getCdr();
                index += stride;
            }
            for (final Object el : Sequences.coerceToSequence(value)) {
                fromNested(buffer, index, dim, dimensions, el, elementType, sloc, messages);
                index += stride;
            }
        }
    }
}
