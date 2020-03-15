// 
// Decompiled by Procyon v0.5.36
// 

package gnu.ecmascript;

import gnu.lists.Sequence;
import gnu.kawa.io.OutPort;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.math.IntNum;
import gnu.expr.QuoteExp;
import gnu.kawa.io.InPort;
import java.util.Hashtable;
import gnu.text.Char;

public class Lexer extends gnu.text.Lexer
{
    private boolean prevWasCR;
    public static final Char lparenToken;
    public static final Char rparenToken;
    public static final Char lbraceToken;
    public static final Char rbraceToken;
    public static final Char lbracketToken;
    public static final Char rbracketToken;
    public static final Char dotToken;
    public static final Char condToken;
    public static final Char commaToken;
    public static final Char colonToken;
    public static final Char equalToken;
    public static final Char tildeToken;
    public static final Char notToken;
    public static final Char semicolonToken;
    public static final Object eolToken;
    public static final Object eofToken;
    public static final Reserved elseToken;
    public static final Reserved newToken;
    static Hashtable reserved;
    
    public Lexer(final InPort port) {
        super(port);
        this.prevWasCR = false;
    }
    
    static synchronized void initReserved() {
        if (Lexer.reserved == null) {
            (Lexer.reserved = new Hashtable(20)).put("null", new QuoteExp((Object)null));
            Lexer.reserved.put("true", new QuoteExp(Boolean.TRUE));
            Lexer.reserved.put("false", new QuoteExp(Boolean.FALSE));
            Lexer.reserved.put("var", new Reserved("var", 30));
            Lexer.reserved.put("if", new Reserved("if", 31));
            Lexer.reserved.put("while", new Reserved("while", 32));
            Lexer.reserved.put("for", new Reserved("for", 33));
            Lexer.reserved.put("continue", new Reserved("continue", 34));
            Lexer.reserved.put("break", new Reserved("break", 35));
            Lexer.reserved.put("return", new Reserved("return", 36));
            Lexer.reserved.put("with", new Reserved("with", 37));
            Lexer.reserved.put("function", new Reserved("function", 41));
            Lexer.reserved.put("this", new Reserved("this", 40));
            Lexer.reserved.put("else", Lexer.elseToken);
            Lexer.reserved.put("new", Lexer.newToken);
        }
    }
    
    public static Object checkReserved(final String name) {
        if (Lexer.reserved == null) {
            initReserved();
        }
        return Lexer.reserved.get(name);
    }
    
    public Double getNumericLiteral(int c) throws IOException {
        int radix = 10;
        if (c == 48) {
            c = this.read();
            if (c == 120 || c == 88) {
                radix = 16;
                c = this.read();
            }
            else if (c != 46 && c != 101) {
                if (c != 69) {
                    radix = 8;
                }
            }
        }
        int i = this.port.pos;
        if (c >= 0) {
            --i;
        }
        this.port.pos = i;
        final long ival = gnu.text.Lexer.readDigitsInBuffer(this.port, 0L, radix);
        boolean digit_seen = this.port.pos > i;
        if (digit_seen && this.port.pos < this.port.limit) {
            c = this.port.buffer[this.port.pos];
            if (!Character.isLetterOrDigit((char)c) && c != 46) {
                double dval;
                if (ival >= 0L) {
                    dval = (double)ival;
                }
                else {
                    dval = IntNum.valueOf(this.port.buffer, i, this.port.pos - i, radix, false).doubleValue();
                }
                return new Double(dval);
            }
        }
        if (radix != 10) {
            this.error("invalid character in non-decimal number");
        }
        final StringBuffer str = new StringBuffer(20);
        if (digit_seen) {
            str.append(this.port.buffer, i, this.port.pos - i);
        }
        int point_loc = -1;
        int exp = 0;
        boolean exp_seen = false;
    Label_0443:
        while (true) {
            c = this.port.read();
            if (Character.digit((char)c, radix) >= 0) {
                digit_seen = true;
                str.append((char)c);
            }
            else {
                switch (c) {
                    case 46: {
                        if (point_loc >= 0) {
                            this.error("duplicate '.' in number");
                            continue;
                        }
                        point_loc = str.length();
                        str.append('.');
                        continue;
                    }
                    case 69:
                    case 101: {
                        if (radix != 10) {
                            break Label_0443;
                        }
                        final int next;
                        if ((next = this.port.peek()) != 43 && next != 45 && Character.digit((char)next, 10) < 0) {
                            break Label_0443;
                        }
                        if (!digit_seen) {
                            this.error("mantissa with no digits");
                        }
                        exp = this.readOptionalExponent();
                        exp_seen = true;
                        c = this.read();
                        break Label_0443;
                    }
                    default: {
                        break Label_0443;
                    }
                }
            }
        }
        if (c >= 0) {
            this.port.unread();
        }
        if (exp != 0) {
            str.append('e');
            str.append(exp);
        }
        return new Double(str.toString());
    }
    
    public String getStringLiteral(final char quote) throws IOException, SyntaxException {
        final int start;
        int i = start = this.port.pos;
        final int limit = this.port.limit;
        final char[] buffer = this.port.buffer;
        while (i < limit) {
            final char c = buffer[i];
            if (c == quote) {
                this.port.pos = i + 1;
                return new String(buffer, start, i - start);
            }
            if (c == '\\' || c == '\n') {
                break;
            }
            if (c == '\r') {
                break;
            }
            ++i;
        }
        this.port.pos = i;
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append(buffer, start, i - start);
        while (true) {
            int ch = this.port.read();
            if (ch == quote) {
                break;
            }
            if (ch < 0) {
                this.eofError("unterminated string literal");
            }
            if (ch == 10 || ch == 13) {
                this.fatal("string literal not terminated before end of line");
            }
            if (ch == 92) {
                ch = this.port.read();
                switch (ch) {
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
                        int val = 0;
                        i = ((ch == 120) ? 2 : 4);
                        while (--i >= 0) {
                            int d = this.port.read();
                            if (d < 0) {
                                this.eofError("eof following '\\" + (char)ch + "' in string");
                            }
                            d = Character.forDigit((char)d, 16);
                            if (d < 0) {
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
                        if (ch < 48) {
                            break;
                        }
                        if (ch > 55) {
                            break;
                        }
                        int val = 0;
                        i = 3;
                        while (--i >= 0) {
                            int d = this.port.read();
                            if (d < 0) {
                                this.eofError("eof in octal escape in string literal");
                            }
                            d = Character.forDigit((char)d, 8);
                            if (d < 0) {
                                this.port.unread_quick();
                                break;
                            }
                            val = 8 * val + d;
                        }
                        ch = val;
                        break;
                    }
                }
            }
            sbuf.append((char)ch);
        }
        return sbuf.toString();
    }
    
    public String getIdentifier(int ch) throws IOException {
        int i = this.port.pos;
        final int start = i - 1;
        int limit;
        char[] buffer;
        for (limit = this.port.limit, buffer = this.port.buffer; i < limit && Character.isJavaIdentifierPart(buffer[i]); ++i) {}
        if ((this.port.pos = i) < limit) {
            return new String(buffer, start, i - start);
        }
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append(buffer, start, i - start);
        while (true) {
            ch = this.port.read();
            if (ch < 0) {
                break;
            }
            if (!Character.isJavaIdentifierPart((char)ch)) {
                this.port.unread_quick();
                break;
            }
            sbuf.append((char)ch);
        }
        return sbuf.toString();
    }
    
    public Object maybeAssignment(final Object token) throws IOException, SyntaxException {
        final int ch = this.read();
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
        while (ch >= 0) {
            if (!Character.isWhitespace((char)ch)) {
                switch (ch) {
                    case 46: {
                        ch = this.port.peek();
                        if (ch >= 48 && ch <= 57) {
                            return new QuoteExp(this.getNumericLiteral(46));
                        }
                        return Lexer.dotToken;
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
                        return new QuoteExp((Object)this.getStringLiteral((char)ch));
                    }
                    case 40: {
                        return Lexer.lparenToken;
                    }
                    case 41: {
                        return Lexer.rparenToken;
                    }
                    case 91: {
                        return Lexer.lbracketToken;
                    }
                    case 93: {
                        return Lexer.rbracketToken;
                    }
                    case 123: {
                        return Lexer.lbraceToken;
                    }
                    case 125: {
                        return Lexer.rbraceToken;
                    }
                    case 63: {
                        return Lexer.condToken;
                    }
                    case 58: {
                        return Lexer.colonToken;
                    }
                    case 59: {
                        return Lexer.semicolonToken;
                    }
                    case 44: {
                        return Lexer.commaToken;
                    }
                    case 61: {
                        if (this.port.peek() == 61) {
                            this.port.skip_quick();
                            return Reserved.opEqual;
                        }
                        return Lexer.equalToken;
                    }
                    case 33: {
                        if (this.port.peek() == 61) {
                            this.port.skip_quick();
                            return Reserved.opNotEqual;
                        }
                        return Lexer.notToken;
                    }
                    case 126: {
                        return Lexer.tildeToken;
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
                            default: {
                                return Reserved.opGreater;
                            }
                        }
                        break;
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
                            default: {
                                return Reserved.opLess;
                            }
                        }
                        break;
                    }
                    default: {
                        if (!Character.isJavaIdentifierStart((char)ch)) {
                            return Char.make((char)ch);
                        }
                        final String word = this.getIdentifier(ch).intern();
                        final Object token = checkReserved(word);
                        if (token != null) {
                            return token;
                        }
                        return word;
                    }
                }
            }
            else {
                if (ch == 13) {
                    this.prevWasCR = true;
                    return Lexer.eolToken;
                }
                if (ch == 10 && !this.prevWasCR) {
                    return Lexer.eolToken;
                }
                this.prevWasCR = false;
                ch = this.read();
            }
        }
        return Lexer.eofToken;
    }
    
    public static Object getToken(final InPort inp) throws IOException, SyntaxException {
        return new Lexer(inp).getToken();
    }
    
    public static void main(final String[] args) {
        final InPort inp = InPort.inDefault();
        final Lexer reader = new Lexer(inp);
        try {
            Object token;
            do {
                token = reader.getToken();
                final OutPort out = OutPort.outDefault();
                out.print("token:");
                out.print(token);
                out.println(" [class:" + token.getClass() + "]");
            } while (token != Sequence.eofValue);
        }
        catch (Exception ex) {
            System.err.println("caught exception:" + ex);
        }
    }
    
    static {
        lparenToken = Char.make(40);
        rparenToken = Char.make(41);
        lbraceToken = Char.make(123);
        rbraceToken = Char.make(125);
        lbracketToken = Char.make(91);
        rbracketToken = Char.make(93);
        dotToken = Char.make(46);
        condToken = Char.make(63);
        commaToken = Char.make(44);
        colonToken = Char.make(58);
        equalToken = Char.make(61);
        tildeToken = Char.make(126);
        notToken = Char.make(33);
        semicolonToken = Char.make(59);
        eolToken = Char.make(10);
        eofToken = Sequence.eofValue;
        elseToken = new Reserved("else", 38);
        newToken = new Reserved("new", 39);
    }
}
