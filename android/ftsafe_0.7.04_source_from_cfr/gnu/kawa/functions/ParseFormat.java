/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.CompoundFormat;
import gnu.kawa.format.LiteralFormat;
import gnu.kawa.format.PadFormat;
import gnu.kawa.format.ReportFormat;
import gnu.kawa.functions.IntegerFormat;
import gnu.kawa.functions.LispFormat;
import gnu.kawa.functions.LispRealFormat;
import gnu.kawa.functions.ObjectFormat;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.InPort;
import gnu.lists.FString;
import gnu.mapping.Procedure1;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;

public class ParseFormat
extends Procedure1 {
    public static final ParseFormat parseFormat = new ParseFormat(false);
    boolean emacsStyle = true;
    public static final int PARAM_UNSPECIFIED = -1073741824;
    public static final int PARAM_FROM_LIST = -1610612736;
    public static final int SEEN_MINUS = 1;
    public static final int SEEN_PLUS = 2;
    public static final int SEEN_SPACE = 4;
    public static final int SEEN_ZERO = 8;
    public static final int SEEN_HASH = 16;

    public ParseFormat(boolean emacsStyle) {
        this.emacsStyle = emacsStyle;
    }

    public ReportFormat parseFormat(InPort fmt) throws ParseException, IOException {
        return ParseFormat.parseFormat(fmt, this.emacsStyle ? (char)'?' : '~');
    }

    public static ReportFormat parseFormat(InPort fmt, char magic) throws ParseException, IOException {
        Object f;
        StringBuffer fbuf = new StringBuffer(100);
        int position = 0;
        ArrayList<LiteralFormat> formats = new ArrayList<LiteralFormat>();
        do {
            int ch;
            int len;
            Format format;
            int width;
            if ((ch = fmt.read()) >= 0) {
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
            if ((len = fbuf.length()) == 0) {
                format = LiteralFormat.separator;
            } else {
                char[] text = new char[len];
                fbuf.getChars(0, len, text, 0);
                fbuf.setLength(0);
                format = new LiteralFormat(text);
            }
            formats.add((LiteralFormat)format);
            if (ch < 0) break;
            if (ch == 36) {
                int digit;
                ch = fmt.read();
                position = Character.digit((char)ch, 10);
                if (position < 0) {
                    throw new ParseException("missing number (position) after '%$'", -1);
                }
                while ((digit = Character.digit((char)(ch = fmt.read()), 10)) >= 0) {
                    position = 10 * position + digit;
                }
                --position;
            }
            int flags = 0;
            block14 : do {
                switch ((char)ch) {
                    case '-': {
                        flags |= true;
                        break;
                    }
                    case '+': {
                        flags |= 2;
                        break;
                    }
                    case ' ': {
                        flags |= 4;
                        break;
                    }
                    case '0': {
                        flags |= 8;
                        break;
                    }
                    case '#': {
                        flags |= 16;
                        break;
                    }
                    default: {
                        break block14;
                    }
                }
                ch = fmt.read();
            } while (true);
            if (ch == 42) {
                width = -1610612736;
                ch = fmt.read();
            } else {
                int digit = Character.digit((char)ch, 10);
                if (digit >= 0) {
                    width = digit;
                    while ((digit = Character.digit((char)(ch = fmt.read()), 10)) >= 0) {
                        width = 10 * width + digit;
                    }
                } else {
                    width = -1073741824;
                }
            }
            int precision = -1073741824;
            if (ch == 46) {
                ch = fmt.read();
                if (ch == 42) {
                    precision = -1610612736;
                    ch = fmt.read();
                } else {
                    int digit = Character.digit((char)ch, 10);
                    if (digit >= 0) {
                        precision = digit;
                        while ((digit = Character.digit((char)(ch = fmt.read()), 10)) >= 0) {
                            precision = 10 * precision + digit;
                        }
                    }
                }
            }
            int padChar = (flags & 9) == 8 ? 48 : 32;
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
                    int base2;
                    int fflags = 0;
                    if (ch == 100 || ch == 105) {
                        base2 = 10;
                    } else if (ch == 111) {
                        base2 = 8;
                    } else {
                        base2 = 16;
                        if (ch == 88) {
                            fflags = 32;
                        }
                    }
                    boolean seenColon = false;
                    boolean seenAt = false;
                    if ((flags & 16) != 0) {
                        fflags |= 8;
                    }
                    if ((flags & 2) != 0) {
                        fflags |= 2;
                    }
                    if ((flags & 1) != 0) {
                        fflags |= 16;
                    }
                    if ((flags & 4) != 0) {
                        fflags |= 4;
                    }
                    if (precision != -1073741824) {
                        flags &= -9;
                        format = IntegerFormat.getInstance(base2, precision, 48, -1073741824, -1073741824, fflags |= 64);
                        break;
                    }
                    format = IntegerFormat.getInstance(base2, width, padChar, -1073741824, -1073741824, fflags);
                    break;
                }
                case 69: 
                case 71: 
                case 101: 
                case 102: 
                case 103: {
                    LispRealFormat dfmt = new LispRealFormat();
                    dfmt.op = (char)ch;
                    dfmt.style = (char)80;
                    dfmt.arg1 = width;
                    if (precision == -1073741824) {
                        precision = 6;
                    }
                    dfmt.arg2 = precision;
                    boolean bl = dfmt.showPlus = (flags & 2) != 0;
                    if (ch == 101 || ch == 69 || ch == 103 || ch == 71) {
                        dfmt.arg3 = 2;
                        dfmt.arg4 = 1;
                        dfmt.arg5 = 0;
                        dfmt.arg6 = padChar;
                        dfmt.arg7 = ch == 69 || ch == 71 ? 69 : 101;
                    } else {
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
                int n = padChar = (flags & 8) != 0 ? 48 : 32;
                int where = (flags & 1) != 0 ? 100 : (padChar == 48 ? -1 : 0);
                format = new PadFormat(format, width, (char)padChar, where);
            }
            formats.add((LiteralFormat)format);
            ++position;
        } while (true);
        int fcount = formats.size();
        if (fcount == 1 && (f = formats.get(0)) instanceof ReportFormat) {
            return (ReportFormat)f;
        }
        return new CompoundFormat(formats.toArray(new Format[fcount]));
    }

    @Override
    public Object apply1(Object arg) {
        return ParseFormat.asFormat(arg, this.emacsStyle ? (char)'?' : '~');
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ReportFormat asFormat(Object arg, char style) {
        ReportFormat reportFormat;
        if (arg instanceof ReportFormat) {
            return (ReportFormat)arg;
        }
        if (style == '~') {
            return new LispFormat(arg.toString());
        }
        CharArrayInPort iport = arg instanceof FString ? ((FString)arg).openReader() : new CharArrayInPort(arg.toString());
        try {
            reportFormat = ParseFormat.parseFormat(iport, style);
        }
        catch (Throwable throwable) {
            try {
                iport.close();
                throw throwable;
            }
            catch (IOException ex) {
                throw new RuntimeException("Error parsing format (" + ex + ")");
            }
            catch (ParseException ex) {
                throw new RuntimeException("Invalid format (" + ex + ")");
            }
            catch (IndexOutOfBoundsException ex) {
                throw new RuntimeException("End while parsing format");
            }
        }
        iport.close();
        return reportFormat;
    }
}

