/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.PrimType;
import gnu.expr.ApplicationMainSupport;
import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.kawa.functions.Arrays;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderParens;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.Convert;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.Sequence;
import gnu.lists.Sequences;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.Values;
import gnu.math.Complex;
import gnu.math.DComplex;
import gnu.math.DFloNum;
import gnu.math.DQuaternion;
import gnu.math.IntNum;
import gnu.math.Quaternion;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kawa.standard.begin;

public class LispReader
extends Lexer {
    boolean returnMutablePairs;
    GeneralHashTable<Integer, Object> sharedStructureTable;
    boolean inQuasiSyntax;
    char readCase = LispReader.lookupReadCase();
    public static final char TOKEN_ESCAPE_CHAR = '\uffff';
    protected boolean seenEscapes;
    static final int SCM_COMPLEX = 1;
    public static final int SCM_NUMBERS = 1;
    public static final int SCM_ANGLE = 2;
    public static final int SCM_COLATITUDE = 4;
    public static final int SCM_LEXPONENT_IS_BIGDECIMAL = 8;
    boolean deprecatedXmlEnlosedReported;

    public LispReader(InPort port) {
        super(port);
    }

    public LispReader(InPort port, SourceMessages messages) {
        super(port, messages);
    }

    public void setReturnMutablePairs(boolean v) {
        this.returnMutablePairs = v;
    }

    public Object bindSharedObject(int sharingIndex, Object value) {
        if (sharingIndex >= 0) {
            Integer key;
            GeneralHashTable<Integer, Object> map = this.sharedStructureTable;
            if (map == null) {
                map = new GeneralHashTable();
                this.sharedStructureTable = map;
            }
            if (map.get(key = Integer.valueOf(sharingIndex), this) != this) {
                this.error('w', "a duplicate #n= definition was read");
            }
            map.put(key, value);
        }
        return value;
    }

    public final void readNestedComment(char start1, char start2, char end1, char end2) throws IOException, SyntaxException {
        int commentNesting = 1;
        int startLine = this.port.getLineNumber();
        int startColumn = this.port.getColumnNumber();
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
            } else if (c == start1 && (c = this.read()) == start2) {
                ++commentNesting;
            }
            if (c >= 0) continue;
            this.eofError("unexpected end-of-file in " + start1 + start2 + " comment starting here", startLine + 1, startColumn - 1);
            return;
        } while (commentNesting > 0);
        if (buf != null) {
            this.checkEncodingSpec(buf.toString());
        }
    }

    public void checkEncodingSpec(String line) {
        Matcher m = Pattern.compile("coding[:=]\\s*([-a-zA-Z0-9]+)").matcher(line);
        if (m.find()) {
            String enc = m.group(1);
            try {
                ((BinaryInPort)this.getPort()).setCharset(enc);
            }
            catch (UnsupportedCharsetException ex) {
                this.error('e', "unrecognized encoding name " + enc);
            }
            catch (Exception ex) {
                this.error('e', "cannot set encoding name here");
            }
        }
    }

    public char getReadCase() {
        return this.readCase;
    }

    public void setReadCase(char readCase) {
        this.readCase = readCase;
    }

    static char lookupReadCase() {
        try {
            String read_case_string = Environment.getCurrent().get("symbol-read-case", (Object)"P").toString();
            if (read_case_string.length() > 0) {
                int read_case = read_case_string.charAt(0);
                if (read_case != 80) {
                    if (read_case == 117) {
                        read_case = 85;
                    } else if (read_case == 100 || read_case == 108 || read_case == 76) {
                        read_case = 68;
                    } else if (read_case == 105) {
                        read_case = 73;
                    }
                }
                return (char)read_case;
            }
        }
        catch (Exception ex) {
            // empty catch block
        }
        return '\u0000';
    }

    public Object readValues(int ch, ReadTable rtable, int sharingIndex) throws IOException, SyntaxException {
        return this.readValues(ch, rtable.lookup(ch), rtable, sharingIndex);
    }

    public Object readValues(int ch, ReadTableEntry entry, ReadTable rtable, int sharingIndex) throws IOException, SyntaxException {
        this.seenEscapes = false;
        return entry.read(this, ch, -1, sharingIndex);
    }

    public Pair readValuesAndAppend(int ch, ReadTable rtable, Pair last) throws IOException, SyntaxException {
        block3 : {
            int index;
            int line = this.port.getLineNumber();
            int column = this.port.getColumnNumber() - 1;
            Object values = this.readValues(ch, rtable, -1);
            int next = Values.nextIndex(values, index = 0);
            if (next < 0) break block3;
            do {
                Object value = Values.nextValue(values, index);
                index = next;
                if (value == QuoteExp.voidExp) {
                    value = Values.empty;
                }
                if ((next = Values.nextIndex(values, index)) < 0) {
                    value = this.handlePostfix(value, rtable, line, column);
                }
                Pair pair = this.makePair(value, line, column);
                this.setCdr(last, pair);
                last = pair;
            } while (next >= 0);
        }
        return last;
    }

    protected Object readAndHandleToken(int ch, int startPos, ReadTable rtable) throws IOException, SyntaxException {
        this.readToken(ch, rtable);
        return this.handleToken(startPos, rtable);
    }

    protected Object handleToken(int startPos, ReadTable rtable) throws IOException, SyntaxException {
        Object value;
        Object result;
        int readCase = this.getReadCase();
        int endPos = this.tokenBufferLength;
        if (!this.seenEscapes && (value = LispReader.parseNumber(this.tokenBuffer, startPos, endPos - startPos, '\u0000', 0, 1 | rtable.extraFlags)) != null && !(value instanceof String)) {
            this.tokenBufferLength = startPos;
            return value;
        }
        if (readCase == 73) {
            int upperCount = 0;
            int lowerCount = 0;
            for (int i = startPos; i < endPos; ++i) {
                char ci = this.tokenBuffer[i];
                if (ci == '\uffff') {
                    ++i;
                    continue;
                }
                if (Character.isLowerCase(ci)) {
                    ++lowerCount;
                    continue;
                }
                if (!Character.isUpperCase(ci)) continue;
                ++upperCount;
            }
            readCase = lowerCount == 0 ? 68 : (upperCount == 0 ? 85 : 80);
        }
        boolean handleUri = endPos >= startPos + 2 && this.tokenBuffer[endPos - 1] == '}' && this.tokenBuffer[endPos - 2] != '\uffff' && this.peek() == 58;
        int packageMarker = -1;
        int lbrace = -1;
        int rbrace = -1;
        int braceNesting = 0;
        int j = startPos;
        boolean uriBad = false;
        for (int i = startPos; i < endPos; ++i) {
            char ci = this.tokenBuffer[i];
            if (ci == '\uffff') {
                if (++i >= endPos) continue;
                this.tokenBuffer[j++] = this.tokenBuffer[i];
                continue;
            }
            if (handleUri) {
                if (ci == '{') {
                    if (lbrace < 0) {
                        lbrace = j;
                    } else if (braceNesting == 0) {
                        uriBad = true;
                    }
                    ++braceNesting;
                } else if (ci == '}') {
                    if (--braceNesting < 0) {
                        uriBad = true;
                    } else if (braceNesting == 0) {
                        if (rbrace < 0) {
                            rbrace = j;
                        } else {
                            uriBad = true;
                        }
                    }
                }
            }
            if (braceNesting <= 0) {
                if (ci == ':') {
                    packageMarker = packageMarker >= 0 ? -1 : j;
                } else if (readCase == 85) {
                    ci = Character.toUpperCase(ci);
                } else if (readCase == 68) {
                    ci = Character.toLowerCase(ci);
                }
            }
            this.tokenBuffer[j++] = ci;
        }
        endPos = j;
        int len = endPos - startPos;
        if (lbrace >= 0 && rbrace > lbrace) {
            String prefix = lbrace > 0 ? new String(this.tokenBuffer, startPos, lbrace - startPos) : null;
            String uri = new String(this.tokenBuffer, ++lbrace, rbrace - lbrace);
            int ch = this.read();
            ch = this.read();
            Object rightOperand = this.readValues(ch, rtable.lookup(ch), rtable, -1);
            if (!(rightOperand instanceof SimpleSymbol)) {
                this.error("expected identifier in symbol after '{URI}:'");
            }
            result = Symbol.valueOf(rightOperand.toString(), uri, prefix);
        } else if (rtable.initialColonIsKeyword && packageMarker == startPos && len > 1) {
            String str = new String(this.tokenBuffer, ++startPos, endPos - startPos);
            result = Keyword.make(str.intern());
        } else if (rtable.finalColonIsKeyword && packageMarker != -1 && packageMarker == endPos - 1 && (len > 1 || this.seenEscapes)) {
            String str = new String(this.tokenBuffer, startPos, len - 1);
            result = Keyword.make(str.intern());
        } else {
            if (len == 1 && this.tokenBuffer[startPos] == '.' && !this.seenEscapes) {
                this.error("invalid use of '.' token");
            }
            result = rtable.makeSymbol(new String(this.tokenBuffer, startPos, len));
        }
        this.tokenBufferLength = startPos;
        return result;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void readToken(int ch, ReadTable rtable) throws IOException, SyntaxException {
        inEscapes = false;
        braceNesting = 0;
        do {
            if (ch < 0) {
                if (inEscapes == false) return;
                this.eofError("unexpected EOF between escapes");
            }
            if ((kind = (entry = rtable.lookup(ch)).getKind()) != 0) ** GOTO lbl17
            if (inEscapes) {
                this.tokenBufferAppend(65535);
                this.tokenBufferAppend(ch);
            } else if (ch == 125 && --braceNesting >= 0) {
                this.tokenBufferAppend(ch);
            } else {
                this.unread(ch);
                return;
lbl17: // 1 sources:
                if (ch == rtable.postfixLookupOperator && !inEscapes) {
                    next = this.port.peek();
                    if (next == rtable.postfixLookupOperator) {
                        this.unread(ch);
                        return;
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
                } else if (kind == 4) {
                    inEscapes = inEscapes == false;
                    this.seenEscapes = true;
                } else if (inEscapes) {
                    this.tokenBufferAppend(65535);
                    this.tokenBufferAppend(ch);
                } else {
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
        } while (true);
    }

    public String readTokenString(int ch, ReadTable rtable) throws IOException, SyntaxException {
        int startPos = this.tokenBufferLength;
        if (ch >= 0) {
            this.tokenBufferAppend(ch);
        }
        this.readToken(this.read(), rtable);
        int length = this.tokenBufferLength - startPos;
        String str = new String(this.tokenBuffer, startPos, length);
        this.tokenBufferLength = startPos;
        return str;
    }

    public Object readObject() throws IOException, SyntaxException {
        return this.readObject(-1, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object readObject(int sharingIndex, boolean topLevel) throws IOException, SyntaxException {
        char saveReadState = this.port.readState;
        int startPos = this.tokenBufferLength;
        this.port.readState = (char)32;
        try {
            int line;
            int ch;
            Object value;
            int column;
            ReadTable rtable = ReadTable.getCurrent();
            do {
                line = this.port.getLineNumber();
                column = this.port.getColumnNumber();
                ch = this.port.read();
                if (ch >= 0) continue;
                Object object2 = Sequence.eofValue;
                return object2;
            } while ((value = this.readValues(ch, rtable, sharingIndex)) == Values.empty);
            value = this.handlePostfix(value, rtable, line, column);
            if (topLevel && !(value instanceof Pair)) {
                value = this.makePair(begin.begin, this.makePair(value, line, column), line, column);
            }
            Object object3 = value;
            return object3;
        }
        finally {
            this.tokenBufferLength = startPos;
            this.port.readState = saveReadState;
        }
    }

    protected boolean validPostfixLookupStart(int ch, ReadTable rtable) throws IOException {
        if (ch < 0 || ch == rtable.postfixLookupOperator) {
            return false;
        }
        if (ch == 44) {
            return true;
        }
        if (ch == 64) {
            return true;
        }
        int kind = rtable.lookup(ch).getKind();
        return kind == 2 || kind == 6 || kind == 4 || kind == 3;
    }

    protected Object handlePostfix(Object value, ReadTable rtable, int line, int column) throws IOException, SyntaxException {
        if (value == QuoteExp.voidExp) {
            value = Values.empty;
        }
        do {
            int ch;
            Object rightOperand;
            if ((ch = this.port.peek()) == 91 && ReadTable.defaultBracketMode == -2) {
                this.port.read();
                Object lst = ReaderParens.readList(this, null, ch, 1, 93, -1);
                value = this.makePair(value, lst, line, column);
                value = this.makePair(LispLanguage.bracket_apply_sym, value, line, column);
                continue;
            }
            if (ch != rtable.postfixLookupOperator) break;
            this.port.read();
            int ch2 = this.port.peek();
            if (ch2 == 64) {
                this.error('w', "deprecated cast syntax TYPE:@ (use ->TYPE instead)");
                rightOperand = this.readAndHandleToken(92, 0, rtable);
            } else {
                if (!this.validPostfixLookupStart(ch2, rtable)) {
                    this.unread();
                    break;
                }
                ch = this.port.read();
                rightOperand = this.readValues(ch, rtable.lookup(ch), rtable, -1);
            }
            value = LList.list2(value, LList.list2(LispLanguage.quasiquote_sym, rightOperand));
            value = this.makePair(LispLanguage.lookup_sym, value, line, column);
        } while (true);
        return value;
    }

    private boolean isPotentialNumber(char[] buffer, int start, int end) {
        int sawDigits = 0;
        for (int i = start; i < end; ++i) {
            char ch = buffer[i];
            if (Character.isDigit(ch)) {
                ++sawDigits;
                continue;
            }
            if (ch == '-' || ch == '+') {
                if (i + 1 != end) continue;
                return false;
            }
            if (ch == '#') {
                return true;
            }
            if (!(Character.isLetter(ch) || ch == '/' || ch == '_' || ch == '^' ? i == start : ch != '.')) continue;
            return false;
        }
        return sawDigits > 0;
    }

    public static Object parseNumber(CharSequence str, int radix) {
        char[] buf;
        int where;
        int len = str.length();
        if (str instanceof FString && (where = ((FString)str).getSegmentReadOnly(0, len)) >= 0) {
            buf = ((FString)str).getBuffer();
        } else {
            where = 0;
            buf = ((Object)str).toString().toCharArray();
        }
        return LispReader.parseNumber(buf, where, len, '\u0000', radix, 1);
    }

    public static Object parseNumber(char[] buffer, int start, int count, char exactness, int radix, int flags) {
        double d;
        boolean negative;
        boolean sign_seen;
        int pos = start;
        int end = start + count;
        if (pos >= end) {
            return "no digits";
        }
        char ch = buffer[pos++];
        while (ch == '#') {
            if (pos >= end) {
                return "no digits";
            }
            ch = buffer[pos++];
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
                    if (exactness != '\u0000') {
                        if (exactness == ' ') {
                            return "non-prefix exactness specifier";
                        }
                        return "duplicate exactness specifier";
                    }
                    exactness = ch;
                    break;
                }
                default: {
                    int dig;
                    int value = 0;
                    while ((dig = Character.digit(ch, 10)) >= 0) {
                        value = 10 * value + dig;
                        if (pos >= end) {
                            return "missing letter after '#'";
                        }
                        ch = buffer[pos++];
                    }
                    if (ch == 'R' || ch == 'r') {
                        if (radix > 0) {
                            return "duplicate radix specifier";
                        }
                        if (value < 2 || value > 35) {
                            return "invalid radix specifier";
                        }
                        radix = value;
                        break;
                    }
                    return "unknown modifier '#" + ch + '\'';
                }
            }
            if (pos >= end) {
                return "no digits";
            }
            ch = buffer[pos++];
        }
        if (exactness == '\u0000') {
            exactness = (char)32;
        }
        if (radix < 0) {
            radix = -radix;
        } else if (radix == 0) {
            radix = 10;
        }
        boolean numeratorNegative = negative = ch == '-';
        boolean bl = sign_seen = ch == '-' || ch == '+';
        if (sign_seen) {
            if (pos >= end) {
                return "no digits following sign";
            }
            ch = buffer[pos++];
        }
        if (!(ch != 'i' && ch != 'I' || pos != end && buffer[pos] != '+' && buffer[pos] != '-' || start != pos - 2 || (flags & 1) == 0)) {
            char sign = buffer[start];
            if (sign != '+' && sign != '-') {
                return "no digits";
            }
            if (pos < end) {
                Object jmag = LispReader.parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                if (jmag instanceof String) {
                    return jmag;
                }
                if (!(jmag instanceof Quaternion)) {
                    return "invalid numeric constant (" + jmag + ")";
                }
                Quaternion qjmag = (Quaternion)jmag;
                RealNum re = qjmag.re();
                RealNum im = qjmag.im();
                if (!re.isZero() || !im.isZero()) {
                    return "invalid numeric constant";
                }
                if (exactness == 'i' || exactness == 'I') {
                    return Quaternion.make(0.0, negative ? -1.0 : 1.0, qjmag.doubleJmagValue(), qjmag.doubleKmagValue());
                }
                return Quaternion.make(IntNum.zero(), negative ? IntNum.minusOne() : IntNum.one(), qjmag.jm(), qjmag.km());
            }
            if (exactness == 'i' || exactness == 'I') {
                return new DComplex(0.0, negative ? -1.0 : 1.0);
            }
            return negative ? Complex.imMinusOne() : Complex.imOne();
        }
        if (!(ch != 'j' && ch != 'J' || pos != end && buffer[pos] != '+' && buffer[pos] != '-' || start != pos - 2 || (flags & 1) == 0)) {
            char sign = buffer[start];
            if (sign != '+' && sign != '-') {
                return "no digits";
            }
            if (pos < end) {
                Object kmag = LispReader.parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                if (kmag instanceof String) {
                    return kmag;
                }
                if (!(kmag instanceof Quaternion)) {
                    return "invalid numeric constant (" + kmag + ")";
                }
                Quaternion qkmag = (Quaternion)kmag;
                RealNum re = qkmag.re();
                RealNum im = qkmag.im();
                RealNum jm = qkmag.jm();
                if (!(re.isZero() && im.isZero() && jm.isZero())) {
                    return "invalid numeric constant";
                }
                if (exactness == 'i' || exactness == 'I') {
                    return Quaternion.make(0.0, 0.0, negative ? -1.0 : 1.0, qkmag.doubleKmagValue());
                }
                return Quaternion.make(IntNum.zero(), IntNum.zero(), negative ? IntNum.minusOne() : IntNum.one(), qkmag.km());
            }
            if (exactness == 'i' || exactness == 'I') {
                return new DQuaternion(0.0, 0.0, 0.0, negative ? -1.0 : 1.0);
            }
            return negative ? Quaternion.jmMinusOne() : Quaternion.jmOne();
        }
        if ((ch == 'k' || ch == 'K') && pos == end && start == pos - 2 && (flags & 1) != 0) {
            char sign = buffer[start];
            if (sign != '+' && sign != '-') {
                return "no digits";
            }
            if (exactness == 'i' || exactness == 'I') {
                return new DQuaternion(0.0, 0.0, 0.0, negative ? -1.0 : 1.0);
            }
            return negative ? Quaternion.kmMinusOne() : Quaternion.kmOne();
        }
        int realStart = pos - 1;
        boolean hash_seen = false;
        int exp_seen = -1;
        int digits_start = -1;
        int decimal_point = -1;
        boolean copy_needed = false;
        boolean underscore_seen = false;
        IntNum numerator = null;
        long lvalue = 0L;
        block19 : do {
            int digit;
            if ((digit = Character.digit(ch, radix)) >= 0) {
                if (hash_seen && decimal_point < 0) {
                    return "digit after '#' in number";
                }
                if (digits_start < 0) {
                    digits_start = pos - 1;
                }
                lvalue = (long)radix * lvalue + (long)digit;
            } else {
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
                            break block19;
                        }
                        char next = buffer[pos];
                        int exp_pos = pos - 1;
                        if (next == '+' || next == '-') {
                            if (++pos >= end || Character.digit(buffer[pos], 10) < 0) {
                                return "missing exponent digits";
                            }
                        } else if (Character.digit(next, 10) < 0) {
                            --pos;
                            break block19;
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
                        while (++pos < end && Character.digit(buffer[pos], 10) >= 0) {
                        }
                        break block19;
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
                        numerator = LispReader.valueOf(buffer, digits_start, pos - digits_start, radix, negative, lvalue);
                        digits_start = -1;
                        lvalue = 0L;
                        negative = false;
                        hash_seen = false;
                        underscore_seen = false;
                        break;
                    }
                    default: {
                        --pos;
                        break block19;
                    }
                }
            }
            if (pos == end) break;
            ch = buffer[pos++];
        } while (true);
        int infnan = 0;
        if (digits_start < 0) {
            if (sign_seen && pos + 4 < end && buffer[pos + 3] == '.' && buffer[pos + 4] == '0') {
                char b2;
                char b1;
                char b0 = buffer[pos];
                if (!(b0 != 'i' && b0 != 'I' || (b1 = buffer[pos + 1]) != 'n' && b1 != 'N' || (b2 = buffer[pos + 2]) != 'f' && b2 != 'F')) {
                    infnan = 105;
                } else if (!(b0 != 'n' && b0 != 'N' || (b1 = buffer[pos + 1]) != 'a' && b1 != 'A' || (b2 = buffer[pos + 2]) != 'n' && b2 != 'N')) {
                    infnan = 110;
                }
            }
            if (infnan == 0) {
                return "no digits";
            }
            pos += 5;
        }
        if (hash_seen || underscore_seen) {
            // empty if block
        }
        boolean inexact2 = exactness == 'i' || exactness == 'I' || exactness == ' ' && hash_seen;
        RealNum number = null;
        int exp_char = 0;
        if (infnan != 0) {
            inexact2 = true;
            d = infnan == 105 ? Double.POSITIVE_INFINITY : Double.NaN;
            number = new DFloNum(negative ? -d : d);
        } else if (exp_seen >= 0 || decimal_point >= 0) {
            if (digits_start > decimal_point && decimal_point >= 0) {
                digits_start = decimal_point;
            }
            if (numerator != null) {
                return "floating-point number after fraction symbol '/'";
            }
            if (exactness == 'e' || exactness == 'E') {
                IntNum inumber;
                int exp = 0;
                if (decimal_point < 0) {
                    inumber = LispReader.valueOf(buffer, digits_start, exp_seen - digits_start, radix, negative, lvalue);
                } else {
                    StringBuilder sbuf = new StringBuilder();
                    if (negative) {
                        sbuf.append('-');
                    }
                    sbuf.append(buffer, digits_start, decimal_point - digits_start);
                    int fracdigits = (exp_seen >= 0 ? exp_seen : pos) - ++decimal_point;
                    sbuf.append(buffer, decimal_point, fracdigits);
                    inumber = IntNum.valueOf(sbuf.toString());
                    exp -= fracdigits;
                }
                if (exp_seen >= 0) {
                    exp += Integer.parseInt(new String(buffer, exp_seen + 1, pos - (exp_seen + 1)));
                }
                number = exp > 0 ? IntNum.times(inumber, IntNum.power(IntNum.ten(), exp)) : (exp < 0 ? RatNum.make(inumber, IntNum.power(IntNum.ten(), -exp)) : inumber);
            } else {
                String str = new String(buffer, digits_start, pos - digits_start);
                if (exp_seen >= 0 && (exp_char = (int)Character.toLowerCase(buffer[exp_seen])) != 101) {
                    int prefix = exp_seen - digits_start;
                    str = str.substring(0, prefix) + 'e' + str.substring(prefix + 1);
                }
                double d2 = Convert.parseDouble(str);
                number = new DFloNum(negative ? -d2 : d2);
            }
        } else {
            IntNum iresult = LispReader.valueOf(buffer, digits_start, pos - digits_start, radix, negative, lvalue);
            if (numerator == null) {
                number = iresult;
            } else if (iresult.isZero()) {
                boolean numeratorZero = numerator.isZero();
                if (inexact2) {
                    number = new DFloNum(numeratorZero ? Double.NaN : (numeratorNegative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY));
                } else {
                    if (numeratorZero) {
                        return "0/0 is undefined";
                    }
                    number = RatNum.make(numerator, iresult);
                }
            } else {
                number = RatNum.make(numerator, iresult);
            }
            if (inexact2 && number.isExact()) {
                number = new DFloNum(numeratorNegative && number.isZero() ? -0.0 : number.doubleValue());
            }
        }
        if (exactness == 'e' || exactness == 'E') {
            number = number.toExact();
        }
        if (pos < end) {
            RealNum rangle;
            RealNum[] polars;
            if ((ch = buffer[pos++]) == '@') {
                Object angle = LispReader.parseNumber(buffer, pos, end - pos, exactness, radix, flags | 2);
                if (angle instanceof String) {
                    return angle;
                }
                if (!(angle instanceof RealNum) && !(angle instanceof RealNum[])) {
                    return "invalid complex polar constant";
                }
                if (angle instanceof RealNum[]) {
                    polars = (RealNum[])angle;
                    if (!(!number.isZero() || polars[0].isExact() && polars[1].isExact() && polars[2].isExact())) {
                        return new DFloNum(0.0);
                    }
                    return Quaternion.polar(number, polars[0], polars[1], polars[2]);
                }
                rangle = (RealNum)angle;
                if (number.isZero() && !rangle.isExact()) {
                    return new DFloNum(0.0);
                }
                return Complex.polar(number, rangle);
            }
            if (ch == '%') {
                Object colatitude = LispReader.parseNumber(buffer, pos, end - pos, exactness, radix, flags | 4);
                if (colatitude instanceof String) {
                    return colatitude;
                }
                if (!(colatitude instanceof RealNum) && !(colatitude instanceof RealNum[])) {
                    return "invalid quaternion polar constant";
                }
                if ((flags & 2) == 0) {
                    RealNum rcolatitude;
                    RealNum rlongitude;
                    rangle = IntNum.zero();
                    if (colatitude instanceof RealNum) {
                        rcolatitude = (RealNum)colatitude;
                        rlongitude = IntNum.zero();
                    } else {
                        RealNum[] polars2 = (RealNum[])colatitude;
                        rcolatitude = polars2[1];
                        rlongitude = polars2[2];
                    }
                    if (!(!number.isZero() || rcolatitude.isExact() && rlongitude.isExact())) {
                        return new DFloNum(0.0);
                    }
                    return Quaternion.polar(number, rangle, rcolatitude, rlongitude);
                }
                if (colatitude instanceof RealNum[]) {
                    polars = (RealNum[])colatitude;
                    polars[0] = number;
                    return polars;
                }
                return new RealNum[]{number, (RealNum)colatitude, IntNum.zero()};
            }
            if (ch == '&') {
                Object longitude = LispReader.parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                if (longitude instanceof String) {
                    return longitude;
                }
                if (!(longitude instanceof RealNum)) {
                    return "invalid quaternion polar constant";
                }
                RealNum rlongitude = (RealNum)longitude;
                if ((flags & 6) == 0) {
                    if (number.isZero() && !rlongitude.isExact()) {
                        return new DFloNum(0.0);
                    }
                    return Quaternion.polar(number, IntNum.zero(), IntNum.zero(), rlongitude);
                }
                if ((flags & 4) != 0) {
                    return new RealNum[]{IntNum.zero(), number, rlongitude};
                }
                return new RealNum[]{number, IntNum.zero(), rlongitude};
            }
            if (ch == '-' || ch == '+') {
                Object imag;
                if ((imag = LispReader.parseNumber(buffer, --pos, end - pos, exactness, radix, flags)) instanceof String) {
                    return imag;
                }
                if (!(imag instanceof Quaternion)) {
                    return "invalid numeric constant (" + imag + ")";
                }
                Quaternion cimag = (Quaternion)imag;
                RealNum re = cimag.re();
                if (!re.isZero()) {
                    return "invalid numeric constant";
                }
                return Quaternion.make(number, cimag.im(), cimag.jm(), cimag.km());
            }
            int lcount = 0;
            do {
                if (!Character.isLetter(ch)) {
                    --pos;
                    break;
                }
                ++lcount;
                if (pos == end) break;
                ch = buffer[pos++];
            } while (true);
            if (lcount == 1) {
                char prev = buffer[pos - 1];
                if (prev == 'i' || prev == 'I') {
                    if (pos < end) {
                        Object jmag = LispReader.parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                        if (jmag instanceof String) {
                            return jmag;
                        }
                        if (!(jmag instanceof Quaternion)) {
                            return "invalid numeric constant (" + jmag + ")";
                        }
                        Quaternion qjmag = (Quaternion)jmag;
                        RealNum re = qjmag.re();
                        RealNum im = qjmag.im();
                        if (!re.isZero() || !im.isZero()) {
                            return "invalid numeric constant";
                        }
                        return Quaternion.make(IntNum.zero(), number, qjmag.jm(), qjmag.km());
                    }
                    return Complex.make(IntNum.zero(), number);
                }
                if (prev == 'j' || prev == 'J') {
                    if (pos < end) {
                        Object kmag = LispReader.parseNumber(buffer, pos, end - pos, exactness, radix, flags);
                        if (kmag instanceof String) {
                            return kmag;
                        }
                        if (!(kmag instanceof Quaternion)) {
                            return "invalid numeric constant (" + kmag + ")";
                        }
                        Quaternion qkmag = (Quaternion)kmag;
                        RealNum re = qkmag.re();
                        RealNum im = qkmag.im();
                        RealNum jm = qkmag.jm();
                        if (!(re.isZero() && im.isZero() && jm.isZero())) {
                            return "invalid numeric constant";
                        }
                        return Quaternion.make(IntNum.zero(), IntNum.zero(), number, qkmag.km());
                    }
                    return Quaternion.make(IntNum.zero(), IntNum.zero(), number, IntNum.zero());
                }
                if (prev == 'k' || prev == 'K') {
                    if (pos < end) {
                        return "junk after imaginary suffix 'k'";
                    }
                    return Quaternion.make(IntNum.zero(), IntNum.zero(), IntNum.zero(), number);
                }
            }
            return "excess junk after number";
        }
        if (number instanceof DFloNum && exp_char > 0 && exp_char != 101) {
            d = number.doubleValue();
            switch (exp_char) {
                case 102: 
                case 115: {
                    return Float.valueOf((float)d);
                }
                case 100: {
                    return d;
                }
                case 108: {
                    if ((flags & 8) == 0) break;
                    return BigDecimal.valueOf(d);
                }
            }
        }
        return number;
    }

    private static IntNum valueOf(char[] buffer, int digits_start, int number_of_digits, int radix, boolean negative, long lvalue) {
        if (number_of_digits + radix <= 28) {
            return IntNum.make(negative ? -lvalue : lvalue);
        }
        return IntNum.valueOf(buffer, digits_start, number_of_digits, radix, negative);
    }

    public int readEscape() throws IOException, SyntaxException {
        int c = this.read();
        if (c < 0) {
            this.eofError("unexpected EOF in character literal");
            return -1;
        }
        return this.readEscape(c);
    }

    public final int readEscape(int c) throws IOException, SyntaxException {
        block0 : switch ((char)c) {
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
                do {
                    if (c < 0) {
                        this.eofError("unexpected EOF in literal");
                        return -1;
                    }
                    if (c == 10) break;
                    if (c == 13) {
                        if (this.peek() == 10) {
                            this.skip();
                        }
                        c = 10;
                        break;
                    }
                    if (c != 32 && c != 9) {
                        this.unread(c);
                        break;
                    }
                    c = this.read();
                } while (true);
                if (c != 10) break;
                do {
                    if ((c = this.read()) >= 0) continue;
                    this.eofError("unexpected EOF in literal");
                    return -1;
                } while (c == 32 || c == 9);
                this.unread(c);
                return -2;
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
                return c | 128;
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
                return c & 159;
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
                    int d = this.read();
                    int v = Character.digit((char)d, 8);
                    if (v >= 0) {
                        c = (c << 3) + v;
                        continue;
                    }
                    if (d < 0) break block0;
                    this.unread(d);
                    break block0;
                }
                break;
            }
            case 'u': {
                c = 0;
                int i = 4;
                while (--i >= 0) {
                    int v;
                    int d = this.read();
                    if (d < 0) {
                        this.eofError("premature EOF in \\u escape");
                    }
                    if ((v = Character.digit((char)d, 16)) < 0) {
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
        return c;
    }

    public int readHexEscape() throws IOException, SyntaxException {
        int c;
        block1 : {
            int v;
            int d;
            c = 0;
            while ((v = Character.digit((char)(d = this.read()), 16)) >= 0) {
                c = (c << 4) + v;
            }
            if (d == 59 || d < 0) break block1;
            this.unread(d);
        }
        return c;
    }

    public final Object readObject(int c) throws IOException, SyntaxException {
        this.unread(c);
        return this.readObject();
    }

    public Object readCommand() throws IOException, SyntaxException {
        return this.readObject(-1, true);
    }

    protected Object makeNil() {
        return LList.Empty;
    }

    protected Pair makePair(Object car, int line, int column) {
        return this.makePair(car, LList.Empty, line, column);
    }

    protected Pair makePair(Object car, Object cdr, int line, int column) {
        String pname = this.port.getName();
        if (!this.returnMutablePairs && pname != null && line >= 0) {
            return PairWithPosition.make(car, cdr, pname, line + 1, column + 1);
        }
        return Pair.make(car, cdr);
    }

    protected Pair makePair2(Object car, Object cadr, Object cddr, int line, int column) {
        return this.makePair(car, this.makePair(cadr, cddr, line, column), line, column);
    }

    protected void setCar(Object pair, Object car) {
        ((Pair)pair).setCarBackdoor(car);
    }

    protected void setCdr(Object pair, Object cdr) {
        ((Pair)pair).setCdrBackdoor(cdr);
    }

    public static Object readNumberWithRadix(int previous, LispReader reader, int radix) throws IOException, SyntaxException {
        int startPos = reader.tokenBufferLength - previous;
        ReadTable rtable = ReadTable.getCurrent();
        do {
            reader.readToken(reader.read(), rtable);
            int ch = reader.peek();
            if (ch != 35) break;
            reader.tokenBufferAppend(ch);
            reader.skip();
        } while (true);
        int endPos = reader.tokenBufferLength;
        if (startPos == endPos) {
            reader.error("missing numeric token");
            return IntNum.zero();
        }
        Object result = LispReader.parseNumber(reader.tokenBuffer, startPos, endPos - startPos, '\u0000', radix, 0);
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

    public static Object readCharacter(LispReader reader) throws IOException, SyntaxException {
        int value;
        int i;
        int ch = reader.read();
        if (ch < 0) {
            reader.eofError("unexpected EOF in character literal");
        }
        int startPos = reader.tokenBufferLength;
        reader.tokenBufferAppend(ch);
        reader.readToken(reader.read(), ReadTable.getCurrent());
        char[] tokenBuffer = reader.tokenBuffer;
        int length = reader.tokenBufferLength - startPos;
        if (!(length != 1 && length != 2 || (ch = Character.codePointAt(tokenBuffer, startPos, reader.tokenBufferLength)) <= 65535 && length != 1)) {
            return Char.make(ch);
        }
        String name = new String(tokenBuffer, startPos, length);
        ch = Char.nameToChar(name);
        if (ch >= 0) {
            return Char.make(ch);
        }
        ch = tokenBuffer[startPos];
        if (ch == 120 || ch == 88) {
            value = 0;
            i = 1;
            do {
                if (i == length) {
                    return Char.make(value);
                }
                int v = Character.digit(tokenBuffer[startPos + i], 16);
                if (v < 0) break;
                if ((value = 16 * value + v) > 1114111) {
                    reader.error("character scalar value greater than #x10FFFF");
                    return Char.make(63);
                }
                ++i;
            } while (true);
        }
        if ((ch = Character.digit(ch, 8)) >= 0) {
            value = ch;
            i = 1;
            do {
                if (i == length) {
                    return Char.make(value);
                }
                ch = Character.digit(tokenBuffer[startPos + i], 8);
                if (ch < 0) break;
                value = 8 * value + ch;
                ++i;
            } while (true);
        }
        reader.error("unknown character name: " + name);
        return Char.make(63);
    }

    public static Object readSpecial(LispReader reader) throws IOException, SyntaxException {
        int ch = reader.read();
        if (ch < 0) {
            reader.eofError("unexpected EOF in #! special form");
        }
        if ((ch == 47 || ch == 32) && reader.getLineNumber() == 0 && reader.getColumnNumber() == 3) {
            String filename = reader.getName();
            if (filename != null && ApplicationMainSupport.commandName.get(null) == null) {
                ApplicationMainSupport.commandName.set(filename);
            }
            boolean sawBackslash = false;
            while ((ch = reader.read()) >= 0) {
                if (ch == 92) {
                    sawBackslash = true;
                    continue;
                }
                if (ch == 10 || ch == 13) {
                    if (!sawBackslash) break;
                    sawBackslash = false;
                    continue;
                }
                if (!sawBackslash || ch == 32 || ch == 9) continue;
                sawBackslash = false;
            }
            return Values.empty;
        }
        String name = reader.readTokenString(ch, ReadTable.getCurrent());
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
            reader.readCase = (char)68;
            return Values.empty;
        }
        if (name.equals("no-fold-case")) {
            reader.readCase = (char)80;
            return Values.empty;
        }
        reader.error("unknown named constant #!" + name);
        return null;
    }

    public static Object readGeneralArray(LispReader in, int rank, PrimType elementType) throws IOException, SyntaxException {
        if (rank == -1) {
            rank = 1;
        }
        int[] dimensions = new int[rank];
        int[] lowBounds = null;
        boolean error = false;
        int ch = in.read();
        boolean baddim = false;
        int explicitDims = 0;
        if (ch == 64 || ch == 58) {
            for (int r = 0; r < rank; ++r) {
                if (ch == 64) {
                    boolean neg;
                    int low;
                    ch = in.read();
                    boolean bl = neg = ch == 45;
                    if (!neg) {
                        in.unread(ch);
                    }
                    if ((low = in.readIntDigits()) < 0) {
                        in.error("expected low-bound after '@'");
                        low = 0;
                    }
                    if (lowBounds == null) {
                        lowBounds = new int[rank];
                    }
                    lowBounds[r] = neg ? -low : low;
                    ch = in.read();
                    if (ch != 58 && r == rank - 1) break;
                }
                if (ch == 58) {
                    ++explicitDims;
                    int dim = in.readIntDigits();
                    if (dim < 0) {
                        in.error("expected dimension after ':'");
                        error = true;
                    }
                    dimensions[r] = dim;
                    ch = in.read();
                    continue;
                }
                if (ch == 64) continue;
                in.error("missing bounds-specifier (seen " + r + " of " + rank + ")");
                error = true;
            }
        }
        if (ch == 64 || ch == 58) {
            in.error("too many bounds-specifiers for rank-" + rank + " array");
            error = true;
        }
        while (ch >= 0 && Character.isWhitespace(ch)) {
            ch = in.read();
        }
        PairWithPosition sloc = PairWithPosition.make(null, null, in.getName(), in.getLineNumber() + 1, in.getColumnNumber());
        in.unread(ch);
        Object data = in.readObject();
        if (explicitDims == 0) {
            if (!LispReader.dimensionsFromNested(0, dimensions, data)) {
                in.error("array value is not a nested true list");
                error = true;
            }
        } else if (explicitDims < rank) {
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
        Object[] buffer = elementType == null ? new Object[size] : Array.newInstance(elementType.getReflectClass(), size);
        SourceMessages messages = in.getMessages();
        LispReader.fromNested(buffer, 0, 0, dimensions, data, elementType, sloc, messages);
        return Arrays.makeFromSimple(dimensions, lowBounds, buffer, elementType);
    }

    static boolean dimensionsFromNested(int dim, int[] dimensions, Object data) {
        int rank = dimensions.length;
        if (dim == rank) {
            return true;
        }
        List seq = Sequences.asSequenceOrNull(data);
        if (seq == null) {
            return false;
        }
        int len = seq instanceof Pair ? LList.listLength(seq, false) : seq.size();
        if (len < 0) {
            return false;
        }
        if (len > dimensions[dim]) {
            dimensions[dim] = len;
        }
        for (Object el : seq) {
            if (LispReader.dimensionsFromNested(dim + 1, dimensions, el)) continue;
            return false;
        }
        return true;
    }

    static void fromNested(Object buffer, int index, int dim, int[] dimensions, Object value, PrimType elementType, SourceLocator sloc, SourceMessages messages) {
        int rank = dimensions.length;
        if (dim == rank) {
            int sig1;
            int n = sig1 = elementType == null ? 76 : (int)elementType.getSignature().charAt(0);
            if (sig1 == 66 || sig1 == 83 || sig1 == 73 || sig1 == 74) {
                String msg = null;
                if (!(value instanceof IntNum)) {
                    msg = "expected integer value";
                } else {
                    Object nvalue = LangPrimType.convertIntegerLiteral((IntNum)value, elementType, true);
                    if (nvalue == null) {
                        msg = "integer " + value + " not in range of " + elementType.getName();
                    } else {
                        value = nvalue;
                    }
                }
                if (msg != null) {
                    messages.error('e', sloc, msg);
                    value = LangPrimType.convertIntegerLiteral(IntNum.zero(), elementType, true);
                }
            }
            if (sig1 == 70 || sig1 == 68) {
                RealNum rvalue = RealNum.asRealNumOrNull(value);
                if (rvalue != null) {
                    value = sig1 == 70 ? (Number)Float.valueOf(rvalue.floatValue()) : (Number)rvalue.doubleValue();
                } else {
                    messages.error('e', sloc, "expected real value");
                }
            }
            Array.set(buffer, index, value);
        } else {
            int stride = 1;
            for (int i = ++dim; i < rank; ++i) {
                stride *= dimensions[i];
            }
            while (value instanceof Pair) {
                Pair pair = (Pair)value;
                if (pair instanceof SourceLocator) {
                    sloc = (SourceLocator)((Object)pair);
                }
                LispReader.fromNested(buffer, index, dim, dimensions, pair.getCar(), elementType, sloc, messages);
                value = pair.getCdr();
                index += stride;
            }
            for (Object el : Sequences.coerceToSequence(value)) {
                LispReader.fromNested(buffer, index, dim, dimensions, el, elementType, sloc, messages);
                index += stride;
            }
        }
    }
}

