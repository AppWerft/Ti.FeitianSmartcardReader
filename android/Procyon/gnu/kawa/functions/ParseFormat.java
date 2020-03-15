// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.kawa.io.CharArrayInPort;
import gnu.lists.FString;
import gnu.kawa.format.PadFormat;
import gnu.kawa.format.CompoundFormat;
import gnu.kawa.format.LiteralFormat;
import java.text.Format;
import java.util.ArrayList;
import java.io.IOException;
import java.text.ParseException;
import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.InPort;
import gnu.mapping.Procedure1;

public class ParseFormat extends Procedure1
{
    public static final ParseFormat parseFormat;
    boolean emacsStyle;
    public static final int PARAM_UNSPECIFIED = -1073741824;
    public static final int PARAM_FROM_LIST = -1610612736;
    public static final int SEEN_MINUS = 1;
    public static final int SEEN_PLUS = 2;
    public static final int SEEN_SPACE = 4;
    public static final int SEEN_ZERO = 8;
    public static final int SEEN_HASH = 16;
    
    public ParseFormat(final boolean emacsStyle) {
        this.emacsStyle = true;
        this.emacsStyle = emacsStyle;
    }
    
    public ReportFormat parseFormat(final InPort fmt) throws ParseException, IOException {
        return parseFormat(fmt, this.emacsStyle ? '?' : '~');
    }
    
    public static ReportFormat parseFormat(final InPort fmt, final char magic) throws ParseException, IOException {
        final StringBuffer fbuf = new StringBuffer(100);
        int position = 0;
        final ArrayList<Format> formats = new ArrayList<Format>();
    Label_0021:
        while (true) {
            while (true) {
                int ch = fmt.read();
                if (ch >= 0) {
                    if (ch != magic) {
                        fbuf.append((char)ch);
                        continue;
                    }
                    ch = fmt.read();
                    if (ch == magic) {
                        fbuf.append((char)ch);
                        continue;
                    }
                }
                final int len = fbuf.length();
                Format format;
                if (len == 0) {
                    format = LiteralFormat.separator;
                }
                else {
                    final char[] text = new char[len];
                    fbuf.getChars(0, len, text, 0);
                    fbuf.setLength(0);
                    format = new LiteralFormat(text);
                }
                formats.add(format);
                if (ch < 0) {
                    final int fcount = formats.size();
                    if (fcount == 1) {
                        final Object f = formats.get(0);
                        if (f instanceof ReportFormat) {
                            return (ReportFormat)f;
                        }
                    }
                    return new CompoundFormat(formats.toArray(new Format[fcount]));
                }
                if (ch == 36) {
                    ch = fmt.read();
                    position = Character.digit((char)ch, 10);
                    if (position < 0) {
                        throw new ParseException("missing number (position) after '%$'", -1);
                    }
                    while (true) {
                        ch = fmt.read();
                        final int digit = Character.digit((char)ch, 10);
                        if (digit < 0) {
                            break;
                        }
                        position = 10 * position + digit;
                    }
                    --position;
                }
                int flags = 0;
                while (true) {
                    switch ((char)ch) {
                        case '-': {
                            flags |= 0x1;
                            break;
                        }
                        case '+': {
                            flags |= 0x2;
                            break;
                        }
                        case ' ': {
                            flags |= 0x4;
                            break;
                        }
                        case '0': {
                            flags |= 0x8;
                            break;
                        }
                        case '#': {
                            flags |= 0x10;
                            break;
                        }
                        default: {
                            int width;
                            if (ch == 42) {
                                width = -1610612736;
                                ch = fmt.read();
                            }
                            else {
                                int digit;
                                if ((digit = Character.digit((char)ch, 10)) >= 0) {
                                    width = digit;
                                    while (true) {
                                        ch = fmt.read();
                                        digit = Character.digit((char)ch, 10);
                                        if (digit < 0) {
                                            break;
                                        }
                                        width = 10 * width + digit;
                                    }
                                }
                                else {
                                    width = -1073741824;
                                }
                            }
                            int precision = -1073741824;
                            if (ch == 46) {
                                ch = fmt.read();
                                if (ch == 42) {
                                    precision = -1610612736;
                                    ch = fmt.read();
                                }
                                else {
                                    int digit;
                                    if ((digit = Character.digit((char)ch, 10)) >= 0) {
                                        precision = digit;
                                        while (true) {
                                            ch = fmt.read();
                                            digit = Character.digit((char)ch, 10);
                                            if (digit < 0) {
                                                break;
                                            }
                                            precision = 10 * precision + digit;
                                        }
                                    }
                                }
                            }
                            char padChar = ((flags & 0x9) == 0x8) ? '0' : ' ';
                            switch (ch) {
                                case 83:
                                case 115: {
                                    format = new ObjectFormat(ch == 83, precision);
                                    break;
                                }
                                case 88:
                                case 100:
                                case 105:
                                case 111:
                                case 120: {
                                    int fflags = 0;
                                    int base;
                                    if (ch == 100 || ch == 105) {
                                        base = 10;
                                    }
                                    else if (ch == 111) {
                                        base = 8;
                                    }
                                    else {
                                        base = 16;
                                        if (ch == 88) {
                                            fflags = 32;
                                        }
                                    }
                                    final boolean seenColon = false;
                                    final boolean seenAt = false;
                                    if ((flags & 0x10) != 0x0) {
                                        fflags |= 0x8;
                                    }
                                    if ((flags & 0x2) != 0x0) {
                                        fflags |= 0x2;
                                    }
                                    if ((flags & 0x1) != 0x0) {
                                        fflags |= 0x10;
                                    }
                                    if ((flags & 0x4) != 0x0) {
                                        fflags |= 0x4;
                                    }
                                    if (precision != -1073741824) {
                                        flags &= 0xFFFFFFF7;
                                        fflags |= 0x40;
                                        format = IntegerFormat.getInstance(base, precision, 48, -1073741824, -1073741824, fflags);
                                        break;
                                    }
                                    format = IntegerFormat.getInstance(base, width, padChar, -1073741824, -1073741824, fflags);
                                    break;
                                }
                                case 69:
                                case 71:
                                case 101:
                                case 102:
                                case 103: {
                                    final LispRealFormat dfmt = new LispRealFormat();
                                    dfmt.op = (char)ch;
                                    dfmt.style = 'P';
                                    dfmt.arg1 = width;
                                    if (precision == -1073741824) {
                                        precision = 6;
                                    }
                                    dfmt.arg2 = precision;
                                    dfmt.showPlus = ((flags & 0x2) != 0x0);
                                    if (ch == 101 || ch == 69 || ch == 103 || ch == 71) {
                                        dfmt.arg3 = 2;
                                        dfmt.arg4 = 1;
                                        dfmt.arg5 = 0;
                                        dfmt.arg6 = padChar;
                                        dfmt.arg7 = ((ch == 69 || ch == 71) ? 69 : 101);
                                    }
                                    else {
                                        dfmt.arg3 = 0;
                                        dfmt.arg5 = padChar;
                                    }
                                    dfmt.internalPad = true;
                                    format = dfmt.resolve(null, 0);
                                    break;
                                }
                                default: {
                                    throw new ParseException("unknown format character '" + ch + "'", -1);
                                }
                            }
                            if (width > 0) {
                                padChar = (((flags & 0x8) != 0x0) ? '0' : ' ');
                                int where;
                                if ((flags & 0x1) != 0x0) {
                                    where = 100;
                                }
                                else if (padChar == '0') {
                                    where = -1;
                                }
                                else {
                                    where = 0;
                                }
                                format = new PadFormat(format, width, padChar, where);
                            }
                            formats.add(format);
                            ++position;
                            continue Label_0021;
                        }
                    }
                    ch = fmt.read();
                }
            }
            break;
        }
    }
    
    @Override
    public Object apply1(final Object arg) {
        return asFormat(arg, this.emacsStyle ? '?' : '~');
    }
    
    public static ReportFormat asFormat(final Object arg, final char style) {
        try {
            if (arg instanceof ReportFormat) {
                return (ReportFormat)arg;
            }
            if (style == '~') {
                return new LispFormat(arg.toString());
            }
            InPort iport;
            if (arg instanceof FString) {
                iport = ((FString)arg).openReader();
            }
            else {
                iport = new CharArrayInPort(arg.toString());
            }
            try {
                return parseFormat(iport, style);
            }
            finally {
                iport.close();
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error parsing format (" + ex + ")");
        }
        catch (ParseException ex2) {
            throw new RuntimeException("Invalid format (" + ex2 + ")");
        }
        catch (IndexOutOfBoundsException ex3) {
            throw new RuntimeException("End while parsing format");
        }
    }
    
    static {
        parseFormat = new ParseFormat(false);
    }
}
