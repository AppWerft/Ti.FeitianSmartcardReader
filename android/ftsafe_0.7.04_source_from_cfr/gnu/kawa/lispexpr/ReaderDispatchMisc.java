/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.PrimType;
import gnu.expr.Keyword;
import gnu.kawa.io.InPort;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderDispatchSyntaxQuote;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.BitVector;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.regex.Pattern;

public class ReaderDispatchMisc
extends ReadTableEntry {
    protected int code;
    private static ReaderDispatchMisc instance = new ReaderDispatchMisc();

    public static ReaderDispatchMisc getInstance() {
        return instance;
    }

    public ReaderDispatchMisc() {
        this.code = -1;
    }

    public ReaderDispatchMisc(int code) {
        this.code = code;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        LispReader reader = (LispReader)in;
        char saveReadState = '\u0000';
        if (this.code >= 0) {
            ch = this.code;
        }
        switch (ch) {
            case 42: {
                int nlen;
                String name = reader.readTokenString(-1, ReadTable.getCurrent());
                int len = nlen = name.length();
                if (count >= 0) {
                    if (nlen > count) {
                        in.error("too many bits in bit vector");
                    }
                    len = count;
                }
                boolean[] arr = new boolean[len];
                int prev = 48;
                for (int i = 0; i < len; ++i) {
                    int c;
                    prev = c = i < nlen ? (int)name.charAt(i) : prev;
                    if (c == 49 || c == 116 || c == 70) {
                        arr[i] = true;
                        continue;
                    }
                    if (c == 48 || c == 102 || c == 70) continue;
                    prev = 48;
                    in.error("invalid character (at offset " + i + ") in bitvector");
                }
                return new BitVector(arr);
            }
            case 58: {
                String name = reader.readTokenString(-1, ReadTable.getCurrent());
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
                PrimType elementType;
                int startPos = reader.tokenBufferLength;
                while (ch >= 0 && Character.isLetterOrDigit(ch)) {
                    reader.tokenBufferAppend(ch);
                    ch = reader.read();
                }
                reader.unread(ch);
                String name = new String(reader.tokenBuffer, startPos, reader.tokenBufferLength - startPos);
                reader.tokenBufferLength = startPos;
                String nameLC = name.toLowerCase();
                if (nameLC.equals("t") || nameLC.equals("true")) {
                    return Boolean.TRUE;
                }
                if (nameLC.equals("f") || nameLC.equals("false")) {
                    return Boolean.FALSE;
                }
                if (nameLC.equals("f32")) {
                    elementType = LangPrimType.floatType;
                } else if (nameLC.equals("f64")) {
                    elementType = LangPrimType.doubleType;
                } else {
                    in.error("unexpected characters following '#'");
                    return Boolean.FALSE;
                }
                return LispReader.readGeneralArray(reader, count, elementType);
            }
            case 83: 
            case 85: {
                PrimType elementType;
                int size = reader.readIntDigits();
                switch (size) {
                    case 8: {
                        elementType = ch == 85 ? LangPrimType.unsignedByteType : LangPrimType.byteType;
                        break;
                    }
                    case 16: {
                        elementType = ch == 85 ? LangPrimType.unsignedShortType : LangPrimType.shortType;
                        break;
                    }
                    case 32: {
                        elementType = ch == 85 ? LangPrimType.unsignedIntType : LangPrimType.intType;
                        break;
                    }
                    case 64: {
                        elementType = ch == 85 ? LangPrimType.unsignedLongType : LangPrimType.longType;
                        break;
                    }
                    default: {
                        in.error("expected 8, 16, 32, or 64 after #S or #U");
                        elementType = null;
                    }
                }
                return LispReader.readGeneralArray(reader, count, elementType);
            }
            case 82: {
                if (count > 36) {
                    StringBuilder sbuf = new StringBuilder("the radix ");
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
                return ReaderDispatchMisc.readRegex(in, ch, count);
            }
            case 59: {
                InPort port = reader.getPort();
                if (port instanceof InPort) {
                    saveReadState = port.readState;
                    port.readState = (char)59;
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
                Integer key;
                Lexer object2;
                GeneralHashTable<Integer, Object> map;
                if (in instanceof LispReader && (map = ((LispReader)in).sharedStructureTable) != null && (object2 = map.get(key = Integer.valueOf(count), in)) != in) {
                    return object2;
                }
                in.error("an unrecognized #n# back-reference was read");
                return Boolean.FALSE;
            }
        }
        in.error("An invalid #-construct was read.");
        return Values.empty;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Pattern readRegex(Lexer in, int ch, int count) throws IOException, SyntaxException {
        int startPos = in.tokenBufferLength;
        InPort port = in.getPort();
        char saveReadState = '\u0000';
        int flags = 0;
        if (port instanceof InPort) {
            saveReadState = port.readState;
            port.readState = (char)47;
        }
        try {
            int c;
            do {
                if ((c = port.read()) < 0) {
                    in.eofError("unexpected EOF in regex literal");
                }
                if (c == ch) break;
                if (c == 92) {
                    c = port.read();
                    if ((c == 32 || c == 9 || c == 13 || c == 10) && in instanceof LispReader && (c = ((LispReader)in).readEscape(c)) == -2) continue;
                    if (c < 0) {
                        in.eofError("unexpected EOF in regex literal");
                    }
                    if (c != ch) {
                        in.tokenBufferAppend(92);
                    }
                }
                in.tokenBufferAppend(c);
            } while (true);
            String pattern = new String(in.tokenBuffer, startPos, in.tokenBufferLength - startPos);
            do {
                if ((c = in.peek()) == 105 || c == 73) {
                    flags |= 66;
                } else if (c == 115 || c == 83) {
                    flags |= 32;
                } else if (c == 109 || c == 77) {
                    flags |= 8;
                } else {
                    if (!Character.isLetter(c)) break;
                    in.error("unrecognized regex option '" + (char)c + '\'');
                }
                in.skip();
            } while (true);
            Pattern c2 = Pattern.compile(pattern, flags);
            return c2;
        }
        finally {
            in.tokenBufferLength = startPos;
            if (port instanceof InPort) {
                port.readState = saveReadState;
            }
        }
    }
}

