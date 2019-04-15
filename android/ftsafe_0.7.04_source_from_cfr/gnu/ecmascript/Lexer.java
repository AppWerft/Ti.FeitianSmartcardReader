/*
 * Decompiled with CFR 0.139.
 */
package gnu.ecmascript;

import gnu.ecmascript.Reserved;
import gnu.expr.QuoteExp;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.lists.Sequence;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

public class Lexer
extends gnu.text.Lexer {
    private boolean prevWasCR = false;
    public static final Char lparenToken = Char.make(40);
    public static final Char rparenToken = Char.make(41);
    public static final Char lbraceToken = Char.make(123);
    public static final Char rbraceToken = Char.make(125);
    public static final Char lbracketToken = Char.make(91);
    public static final Char rbracketToken = Char.make(93);
    public static final Char dotToken = Char.make(46);
    public static final Char condToken = Char.make(63);
    public static final Char commaToken = Char.make(44);
    public static final Char colonToken = Char.make(58);
    public static final Char equalToken = Char.make(61);
    public static final Char tildeToken = Char.make(126);
    public static final Char notToken = Char.make(33);
    public static final Char semicolonToken = Char.make(59);
    public static final Object eolToken = Char.make(10);
    public static final Object eofToken = Sequence.eofValue;
    public static final Reserved elseToken = new Reserved("else", 38);
    public static final Reserved newToken = new Reserved("new", 39);
    static Hashtable reserved;

    public Lexer(InPort port) {
        super(port);
    }

    static synchronized void initReserved() {
        if (reserved == null) {
            reserved = new Hashtable(20);
            reserved.put("null", new QuoteExp(null));
            reserved.put("true", new QuoteExp(Boolean.TRUE));
            reserved.put("false", new QuoteExp(Boolean.FALSE));
            reserved.put("var", new Reserved("var", 30));
            reserved.put("if", new Reserved("if", 31));
            reserved.put("while", new Reserved("while", 32));
            reserved.put("for", new Reserved("for", 33));
            reserved.put("continue", new Reserved("continue", 34));
            reserved.put("break", new Reserved("break", 35));
            reserved.put("return", new Reserved("return", 36));
            reserved.put("with", new Reserved("with", 37));
            reserved.put("function", new Reserved("function", 41));
            reserved.put("this", new Reserved("this", 40));
            reserved.put("else", elseToken);
            reserved.put("new", newToken);
        }
    }

    public static Object checkReserved(String name) {
        if (reserved == null) {
            Lexer.initReserved();
        }
        return reserved.get(name);
    }

    public Double getNumericLiteral(int c) throws IOException {
        boolean digit_seen;
        int radix = 10;
        if (c == 48) {
            c = this.read();
            if (c == 120 || c == 88) {
                radix = 16;
                c = this.read();
            } else if (c != 46 && c != 101 && c != 69) {
                radix = 8;
            }
        }
        int i = this.port.pos;
        if (c >= 0) {
            --i;
        }
        this.port.pos = i;
        long ival = Lexer.readDigitsInBuffer(this.port, 0L, radix);
        boolean bl = digit_seen = this.port.pos > i;
        if (digit_seen && this.port.pos < this.port.limit && !Character.isLetterOrDigit((char)(c = this.port.buffer[this.port.pos])) && c != 46) {
            double dval = ival >= 0L ? (double)ival : IntNum.valueOf(this.port.buffer, i, this.port.pos - i, radix, false).doubleValue();
            return new Double(dval);
        }
        if (radix != 10) {
            this.error("invalid character in non-decimal number");
        }
        StringBuffer str = new StringBuffer(20);
        if (digit_seen) {
            str.append(this.port.buffer, i, this.port.pos - i);
        }
        int point_loc = -1;
        int exp = 0;
        boolean exp_seen = false;
        block4 : do {
            if (Character.digit((char)(c = this.port.read()), radix) >= 0) {
                digit_seen = true;
                str.append((char)c);
                continue;
            }
            switch (c) {
                case 46: {
                    if (point_loc >= 0) {
                        this.error("duplicate '.' in number");
                        continue block4;
                    }
                    point_loc = str.length();
                    str.append('.');
                    continue block4;
                }
                case 69: 
                case 101: {
                    int next;
                    if (radix != 10 || (next = this.port.peek()) != 43 && next != 45 && Character.digit((char)next, 10) < 0) break block4;
                    if (!digit_seen) {
                        this.error("mantissa with no digits");
                    }
                    exp = this.readOptionalExponent();
                    exp_seen = true;
                    c = this.read();
                }
            }
            break;
        } while (true);
        if (c >= 0) {
            this.port.unread();
        }
        if (exp != 0) {
            str.append('e');
            str.append(exp);
        }
        return new Double(str.toString());
    }

    public String getStringLiteral(char quote) throws IOException, SyntaxException {
        int i;
        int start = i = this.port.pos;
        int limit = this.port.limit;
        char[] buffer = this.port.buffer;
        while (i < limit) {
            char c = buffer[i];
            if (c == quote) {
                this.port.pos = i + 1;
                return new String(buffer, start, i - start);
            }
            if (c == '\\' || c == '\n' || c == '\r') break;
            ++i;
        }
        this.port.pos = i;
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(buffer, start, i - start);
        int ch;
        while ((ch = this.port.read()) != quote) {
            if (ch < 0) {
                this.eofError("unterminated string literal");
            }
            if (ch == 10 || ch == 13) {
                this.fatal("string literal not terminated before end of line");
            }
            if (ch == 92) {
                ch = this.port.read();
                switch (ch) {
                    int d;
                    int val;
                    case -1: {
                        this.eofError("eof following '\\' in string");
                    }
                    case 10: 
                    case 13: {
                        this.fatal("line terminator following '\\' in string");
                    }
                    case 34: 
                    case 39: 
                    case 92: {
                        break;
                    }
                    case 98: {
                        ch = 8;
                        break;
                    }
                    case 116: {
                        ch = 9;
                        break;
                    }
                    case 110: {
                        ch = 10;
                        break;
                    }
                    case 102: {
                        ch = 12;
                        break;
                    }
                    case 114: {
                        ch = 13;
                        break;
                    }
                    case 117: 
                    case 120: {
                        val = 0;
                        int n = i = ch == 120 ? 2 : 4;
                        while (--i >= 0) {
                            d = this.port.read();
                            if (d < 0) {
                                this.eofError("eof following '\\" + (char)ch + "' in string");
                            }
                            if ((d = (int)Character.forDigit((char)d, 16)) < 0) {
                                this.error("invalid char following '\\" + (char)ch + "' in string");
                                val = 63;
                                break;
                            }
                            val = 16 * val + d;
                        }
                        ch = val;
                        break;
                    }
                    default: {
                        if (ch < 48 || ch > 55) break;
                        val = 0;
                        i = 3;
                        while (--i >= 0) {
                            d = this.port.read();
                            if (d < 0) {
                                this.eofError("eof in octal escape in string literal");
                            }
                            if ((d = (int)Character.forDigit((char)d, 8)) < 0) {
                                this.port.unread_quick();
                                break;
                            }
                            val = 8 * val + d;
                        }
                        ch = val;
                    }
                }
            }
            sbuf.append((char)ch);
        }
        return sbuf.toString();
    }

    public String getIdentifier(int ch) throws IOException {
        int i;
        int start = i - 1;
        int limit = this.port.limit;
        char[] buffer = this.port.buffer;
        for (i = this.port.pos; i < limit && Character.isJavaIdentifierPart(buffer[i]); ++i) {
        }
        this.port.pos = i;
        if (i < limit) {
            return new String(buffer, start, i - start);
        }
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(buffer, start, i - start);
        while ((ch = this.port.read()) >= 0) {
            if (Character.isJavaIdentifierPart((char)ch)) {
                sbuf.append((char)ch);
                continue;
            }
            this.port.unread_quick();
            break;
        }
        return sbuf.toString();
    }

    public Object maybeAssignment(Object token) throws IOException, SyntaxException {
        int ch = this.read();
        if (ch == 61) {
            this.error("assignment operation not implemented");
        }
        if (ch >= 0) {
            this.port.unread_quick();
        }
        return token;
    }

    public Object getToken() throws IOException, SyntaxException {
        int ch = this.read();
        do {
            if (ch < 0) {
                return eofToken;
            }
            if (!Character.isWhitespace((char)ch)) break;
            if (ch == 13) {
                this.prevWasCR = true;
                return eolToken;
            }
            if (ch == 10 && !this.prevWasCR) {
                return eolToken;
            }
            this.prevWasCR = false;
            ch = this.read();
        } while (true);
        switch (ch) {
            case 46: {
                ch = this.port.peek();
                if (ch >= 48 && ch <= 57) {
                    return new QuoteExp(this.getNumericLiteral(46));
                }
                return dotToken;
            }
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: {
                return new QuoteExp(this.getNumericLiteral(ch));
            }
            case 34: 
            case 39: {
                return new QuoteExp(this.getStringLiteral((char)ch));
            }
            case 40: {
                return lparenToken;
            }
            case 41: {
                return rparenToken;
            }
            case 91: {
                return lbracketToken;
            }
            case 93: {
                return rbracketToken;
            }
            case 123: {
                return lbraceToken;
            }
            case 125: {
                return rbraceToken;
            }
            case 63: {
                return condToken;
            }
            case 58: {
                return colonToken;
            }
            case 59: {
                return semicolonToken;
            }
            case 44: {
                return commaToken;
            }
            case 61: {
                if (this.port.peek() == 61) {
                    this.port.skip_quick();
                    return Reserved.opEqual;
                }
                return equalToken;
            }
            case 33: {
                if (this.port.peek() == 61) {
                    this.port.skip_quick();
                    return Reserved.opNotEqual;
                }
                return notToken;
            }
            case 126: {
                return tildeToken;
            }
            case 42: {
                return this.maybeAssignment(Reserved.opTimes);
            }
            case 47: {
                return this.maybeAssignment(Reserved.opDivide);
            }
            case 94: {
                return this.maybeAssignment(Reserved.opBitXor);
            }
            case 37: {
                return this.maybeAssignment(Reserved.opRemainder);
            }
            case 43: {
                if (this.port.peek() == 43) {
                    this.port.skip_quick();
                    return this.maybeAssignment(Reserved.opPlusPlus);
                }
                return this.maybeAssignment(Reserved.opPlus);
            }
            case 45: {
                if (this.port.peek() == 45) {
                    this.port.skip_quick();
                    return this.maybeAssignment(Reserved.opMinusMinus);
                }
                return this.maybeAssignment(Reserved.opMinus);
            }
            case 38: {
                if (this.port.peek() == 38) {
                    this.port.skip_quick();
                    return this.maybeAssignment(Reserved.opBoolAnd);
                }
                return this.maybeAssignment(Reserved.opBitAnd);
            }
            case 124: {
                if (this.port.peek() == 124) {
                    this.port.skip_quick();
                    return this.maybeAssignment(Reserved.opBoolOr);
                }
                return this.maybeAssignment(Reserved.opBitOr);
            }
            case 62: {
                ch = this.port.peek();
                switch (ch) {
                    case 62: {
                        this.port.skip_quick();
                        if (this.port.peek() == 62) {
                            this.port.skip_quick();
                            return this.maybeAssignment(Reserved.opRshiftUnsigned);
                        }
                        return this.maybeAssignment(Reserved.opRshiftSigned);
                    }
                    case 61: {
                        this.port.skip_quick();
                        return Reserved.opGreaterEqual;
                    }
                }
                return Reserved.opGreater;
            }
            case 60: {
                ch = this.port.peek();
                switch (ch) {
                    case 60: {
                        this.port.skip_quick();
                        return this.maybeAssignment(Reserved.opLshift);
                    }
                    case 61: {
                        this.port.skip_quick();
                        return Reserved.opLessEqual;
                    }
                }
                return Reserved.opLess;
            }
        }
        if (Character.isJavaIdentifierStart((char)ch)) {
            String word = this.getIdentifier(ch).intern();
            Object token = Lexer.checkReserved(word);
            if (token != null) {
                return token;
            }
            return word;
        }
        return Char.make((char)ch);
    }

    public static Object getToken(InPort inp) throws IOException, SyntaxException {
        return new Lexer(inp).getToken();
    }

    public static void main(String[] args) {
        InPort inp = InPort.inDefault();
        Lexer reader = new Lexer(inp);
        try {
            Object token;
            do {
                token = reader.getToken();
                OutPort out = OutPort.outDefault();
                out.print("token:");
                out.print(token);
                out.println(" [class:" + token.getClass() + "]");
            } while (token != Sequence.eofValue);
        }
        catch (Exception ex) {
            System.err.println("caught exception:" + ex);
            return;
        }
    }
}

