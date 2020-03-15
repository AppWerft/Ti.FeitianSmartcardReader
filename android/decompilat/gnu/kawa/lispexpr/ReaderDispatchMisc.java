// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import java.util.regex.Pattern;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.kawa.util.GeneralHashTable;
import gnu.mapping.Values;
import gnu.kawa.io.InPort;
import gnu.bytecode.PrimType;
import gnu.expr.Keyword;
import gnu.lists.BitVector;
import gnu.text.Lexer;

public class ReaderDispatchMisc extends ReadTableEntry
{
    protected int code;
    private static ReaderDispatchMisc instance;
    
    public static ReaderDispatchMisc getInstance() {
        return ReaderDispatchMisc.instance;
    }
    
    public ReaderDispatchMisc() {
        this.code = -1;
    }
    
    public ReaderDispatchMisc(final int code) {
        this.code = code;
    }
    
    public Object read(final Lexer in, int ch, int count) throws IOException, SyntaxException {
        final LispReader reader = (LispReader)in;
        char saveReadState = '\0';
        if (this.code >= 0) {
            ch = this.code;
        }
        switch (ch) {
            case 42: {
                final String name = reader.readTokenString(-1, ReadTable.getCurrent());
                int len;
                final int nlen = len = name.length();
                if (count >= 0) {
                    if (nlen > count) {
                        in.error("too many bits in bit vector");
                    }
                    len = count;
                }
                final boolean[] arr = new boolean[len];
                char prev = '0';
                for (int i = 0; i < len; ++i) {
                    final char c = prev = ((i < nlen) ? name.charAt(i) : prev);
                    if (c == '1' || c == 't' || c == 'F') {
                        arr[i] = true;
                    }
                    else if (c != '0' && c != 'f' && c != 'F') {
                        prev = '0';
                        in.error("invalid character (at offset " + i + ") in bitvector");
                    }
                }
                return new BitVector(arr);
            }
            case 58: {
                final String name = reader.readTokenString(-1, ReadTable.getCurrent());
                return Keyword.make(name.intern());
            }
            case 92: {
                return LispReader.readCharacter(reader);
            }
            case 33: {
                return LispReader.readSpecial(reader);
            }
            case 70:
            case 84: {
                final int startPos = reader.tokenBufferLength;
                while (ch >= 0 && Character.isLetterOrDigit(ch)) {
                    reader.tokenBufferAppend(ch);
                    ch = reader.read();
                }
                reader.unread(ch);
                final String name = new String(reader.tokenBuffer, startPos, reader.tokenBufferLength - startPos);
                reader.tokenBufferLength = startPos;
                final String nameLC = name.toLowerCase();
                if (nameLC.equals("t") || nameLC.equals("true")) {
                    return Boolean.TRUE;
                }
                if (nameLC.equals("f") || nameLC.equals("false")) {
                    return Boolean.FALSE;
                }
                PrimType elementType;
                if (nameLC.equals("f32")) {
                    elementType = LangPrimType.floatType;
                }
                else {
                    if (!nameLC.equals("f64")) {
                        in.error("unexpected characters following '#'");
                        return Boolean.FALSE;
                    }
                    elementType = LangPrimType.doubleType;
                }
                return LispReader.readGeneralArray(reader, count, elementType);
            }
            case 83:
            case 85: {
                final int size = reader.readIntDigits();
                PrimType elementType = null;
                switch (size) {
                    case 8: {
                        elementType = ((ch == 85) ? LangPrimType.unsignedByteType : LangPrimType.byteType);
                        break;
                    }
                    case 16: {
                        elementType = ((ch == 85) ? LangPrimType.unsignedShortType : LangPrimType.shortType);
                        break;
                    }
                    case 32: {
                        elementType = ((ch == 85) ? LangPrimType.unsignedIntType : LangPrimType.intType);
                        break;
                    }
                    case 64: {
                        elementType = ((ch == 85) ? LangPrimType.unsignedLongType : LangPrimType.longType);
                        break;
                    }
                    default: {
                        in.error("expected 8, 16, 32, or 64 after #S or #U");
                        elementType = null;
                        break;
                    }
                }
                return LispReader.readGeneralArray(reader, count, elementType);
            }
            case 82: {
                if (count > 36) {
                    final StringBuilder sbuf = new StringBuilder("the radix ");
                    if (count < Integer.MAX_VALUE) {
                        sbuf.append(count);
                        sbuf.append(' ');
                    }
                    sbuf.append("is too big (max is 36)");
                    in.error(sbuf.toString());
                    count = 36;
                }
                return LispReader.readNumberWithRadix(0, reader, count);
            }
            case 88: {
                return LispReader.readNumberWithRadix(0, reader, 16);
            }
            case 68: {
                return LispReader.readNumberWithRadix(0, reader, 10);
            }
            case 79: {
                return LispReader.readNumberWithRadix(0, reader, 8);
            }
            case 66: {
                return LispReader.readNumberWithRadix(0, reader, 2);
            }
            case 69:
            case 73: {
                reader.tokenBufferAppend(35);
                reader.tokenBufferAppend(ch);
                return LispReader.readNumberWithRadix(2, reader, 0);
            }
            case 65: {
                return LispReader.readGeneralArray(reader, count, null);
            }
            case 47: {
                return readRegex(in, ch, count);
            }
            case 59: {
                final InPort port = reader.getPort();
                if (port instanceof InPort) {
                    saveReadState = port.readState;
                    port.readState = ';';
                }
                try {
                    reader.readObject();
                }
                finally {
                    if (port instanceof InPort) {
                        port.readState = saveReadState;
                    }
                }
                return Values.empty;
            }
            case 44: {
                return ReaderDispatchSyntaxQuote.readNamedConstructor(reader);
            }
            case 61: {
                return reader.readObject(count, false);
            }
            case 35: {
                if (in instanceof LispReader) {
                    final GeneralHashTable<Integer, Object> map = ((LispReader)in).sharedStructureTable;
                    if (map != null) {
                        final Integer key = count;
                        final Object object = map.get((Object)key, in);
                        if (object != in) {
                            return object;
                        }
                    }
                }
                in.error("an unrecognized #n# back-reference was read");
                return Boolean.FALSE;
            }
            default: {
                in.error("An invalid #-construct was read.");
                return Values.empty;
            }
        }
    }
    
    public static Pattern readRegex(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        final int startPos = in.tokenBufferLength;
        final InPort port = in.getPort();
        char saveReadState = '\0';
        int flags = 0;
        Label_0039: {
            if (!(port instanceof InPort)) {
                break Label_0039;
            }
            saveReadState = port.readState;
            port.readState = '/';
            try {
                while (true) {
                    int c = port.read();
                    if (c < 0) {
                        in.eofError("unexpected EOF in regex literal");
                    }
                    if (c == ch) {
                        break;
                    }
                    if (c == 92) {
                        c = port.read();
                        if ((c == 32 || c == 9 || c == 13 || c == 10) && in instanceof LispReader) {
                            c = ((LispReader)in).readEscape(c);
                            if (c == -2) {
                                continue;
                            }
                        }
                        if (c < 0) {
                            in.eofError("unexpected EOF in regex literal");
                        }
                        if (c != ch) {
                            in.tokenBufferAppend(92);
                        }
                    }
                    in.tokenBufferAppend(c);
                }
                final String pattern = new String(in.tokenBuffer, startPos, in.tokenBufferLength - startPos);
                while (true) {
                    final int c = in.peek();
                    if (c == 105 || c == 73) {
                        flags |= 0x42;
                    }
                    else if (c == 115 || c == 83) {
                        flags |= 0x20;
                    }
                    else if (c == 109 || c == 77) {
                        flags |= 0x8;
                    }
                    else {
                        if (!Character.isLetter(c)) {
                            break;
                        }
                        in.error("unrecognized regex option '" + (char)c + '\'');
                    }
                    in.skip();
                }
                return Pattern.compile(pattern, flags);
            }
            finally {
                in.tokenBufferLength = startPos;
                if (port instanceof InPort) {
                    port.readState = saveReadState;
                }
            }
        }
    }
    
    static {
        ReaderDispatchMisc.instance = new ReaderDispatchMisc();
    }
}
