/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.CharArrayOutPort;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;

public class PadFormat
extends ReportFormat {
    int minWidth;
    char padChar;
    int where;
    Format fmt;

    public PadFormat(Format fmt, int minWidth, char padChar, int where) {
        this.fmt = fmt;
        this.minWidth = minWidth;
        this.padChar = padChar;
        this.where = where;
    }

    public PadFormat(Format fmt, int minWidth) {
        this(fmt, minWidth, ' ', 100);
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        return PadFormat.format(this.fmt, args, start, dst, this.padChar, this.minWidth, 1, 0, this.where, fpos);
    }

    public static int padNeeded(int actualWidth, int minWidth, int colInc, int minPad) {
        int total = actualWidth + minPad;
        if (colInc <= 1) {
            colInc = minWidth - total;
        }
        while (total < minWidth) {
            total += colInc;
        }
        return total - actualWidth;
    }

    public static int format(Format fmt, Object[] args, int start, Appendable dst, char padChar, int minWidth, int colInc, int minPad, int where, FieldPosition fpos) throws IOException {
        String text;
        if (fmt instanceof ReportFormat) {
            CharArrayOutPort sport = new CharArrayOutPort();
            start = ((ReportFormat)fmt).format(args, start, (Appendable)sport, fpos);
            text = sport.toString();
        } else {
            StringBuffer tbuf = new StringBuffer(200);
            if (fmt instanceof MessageFormat) {
                fmt.format(args, tbuf, fpos);
                start = args.length;
            } else {
                fmt.format(args[start], tbuf, fpos);
                ++start;
            }
            text = tbuf.toString();
        }
        int len = text.length();
        int pad = PadFormat.padNeeded(len, minWidth, colInc, minPad);
        int prefix = 0;
        if (pad > 0) {
            if (where == -1) {
                if (len > 0) {
                    char ch = text.charAt(0);
                    if (ch == '-' || ch == '+') {
                        ++prefix;
                        dst.append(ch);
                    }
                    if (len - prefix > 2 && text.charAt(prefix) == '0') {
                        dst.append('0');
                        ch = text.charAt(++prefix);
                        if (ch == 'x' || ch == 'X') {
                            ++prefix;
                            dst.append(ch);
                        }
                    }
                    if (prefix > 0) {
                        text = text.substring(prefix);
                    }
                }
                where = 0;
            }
            int padAfter = pad * where / 100;
            int padBefore = pad - padAfter;
            while (--padBefore >= 0) {
                dst.append(padChar);
            }
            dst.append(text);
            while (--padAfter >= 0) {
                dst.append(padChar);
            }
        } else {
            dst.append(text);
        }
        return start;
    }
}

