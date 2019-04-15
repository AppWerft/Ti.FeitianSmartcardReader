/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.text.Char;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;

public abstract class ReportFormat
extends Format {
    public static final int PARAM_FROM_LIST = -1610612736;
    public static final int PARAM_FROM_COUNT = -1342177280;
    public static final int PARAM_UNSPECIFIED = -1073741824;

    public static int result(int resultCode, int nextArg) {
        return resultCode << 24 | nextArg;
    }

    public static int nextArg(int result) {
        return result & 16777215;
    }

    public static int resultCode(int result) {
        return result >>> 24;
    }

    public abstract int format(Object[] var1, int var2, Appendable var3, FieldPosition var4) throws IOException;

    public int format(Object arg, int start, Appendable dst, FieldPosition fpos) throws IOException {
        if (arg instanceof Object[]) {
            return this.format((Object[])arg, start, dst, fpos);
        }
        Object[] args = new Object[]{arg};
        return this.format(args, start, dst, fpos);
    }

    @Override
    public StringBuffer format(Object obj, StringBuffer sbuf, FieldPosition fpos) {
        this.format((Object[])obj, 0, sbuf, fpos);
        return sbuf;
    }

    public int format(Object[] args, int start, StringBuffer sbuf, FieldPosition fpos) {
        CharArrayWriter wr = new CharArrayWriter();
        try {
            start = this.format(args, start, (Appendable)wr, fpos);
            if (start < 0) {
                return start;
            }
        }
        catch (IOException ex) {
            throw new Error("unexpected exception: " + ex);
        }
        sbuf.append(wr.toCharArray());
        return start;
    }

    public static int format(Format fmt, Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        if (fmt instanceof ReportFormat) {
            return ((ReportFormat)fmt).format(args, start, dst, fpos);
        }
        StringBuffer sbuf = new StringBuffer();
        if (fmt instanceof MessageFormat) {
            start = ReportFormat.format(fmt, args, start, sbuf, fpos);
        } else {
            fmt.format(args[start++], sbuf, fpos);
        }
        dst.append(sbuf);
        return start;
    }

    public static int format(Format fmt, Object[] args, int start, StringBuffer sbuf, FieldPosition fpos) {
        Object[] arg;
        int nargs;
        if (fmt instanceof ReportFormat) {
            return ((ReportFormat)fmt).format(args, start, sbuf, fpos);
        }
        if (fmt instanceof MessageFormat) {
            nargs = args.length - start;
            if (start > 0) {
                Object[] subarr = new Object[args.length - start];
                System.arraycopy(args, start, subarr, 0, subarr.length);
                arg = subarr;
            } else {
                arg = args;
            }
        } else {
            arg = args[start];
            nargs = 1;
        }
        fmt.format(arg, sbuf, fpos);
        return start + nargs;
    }

    public static void print(Writer dst, String str) throws IOException {
        if (dst instanceof PrintWriter) {
            ((PrintWriter)dst).print(str);
        } else {
            dst.write(str);
        }
    }

    public static void print(Object value, Consumer out) {
        if (value instanceof Printable) {
            ((Printable)value).print(out);
        } else {
            out.write(value == null ? "null" : value.toString());
        }
    }

    @Override
    public Object parseObject(String text, ParsePosition status) {
        throw new Error("ReportFormat.parseObject - not implemented");
    }

    public static int getParam(Object arg, int defaultValue) {
        if (arg instanceof Number) {
            return ((Number)arg).intValue();
        }
        if (arg instanceof Character) {
            return ((Character)arg).charValue();
        }
        if (arg instanceof Char) {
            return ((Char)arg).charValue();
        }
        return defaultValue;
    }

    protected static int getParam(int param, int defaultValue, Object[] args, int start) {
        if (param == -1342177280) {
            return args.length - start;
        }
        if (param == -1610612736) {
            return args == null ? defaultValue : ReportFormat.getParam(args[start], defaultValue);
        }
        if (param == -1073741824) {
            return defaultValue;
        }
        return param;
    }

    protected static char getParam(int param, char defaultValue, Object[] args, int start) {
        return (char)ReportFormat.getParam(param, (int)defaultValue, args, start);
    }
}

