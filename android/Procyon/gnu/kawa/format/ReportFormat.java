// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import gnu.text.Char;
import java.text.ParsePosition;
import gnu.lists.Consumer;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;

public abstract class ReportFormat extends Format
{
    public static final int PARAM_FROM_LIST = -1610612736;
    public static final int PARAM_FROM_COUNT = -1342177280;
    public static final int PARAM_UNSPECIFIED = -1073741824;
    
    public static int result(final int resultCode, final int nextArg) {
        return resultCode << 24 | nextArg;
    }
    
    public static int nextArg(final int result) {
        return result & 0xFFFFFF;
    }
    
    public static int resultCode(final int result) {
        return result >>> 24;
    }
    
    public abstract int format(final Object[] p0, final int p1, final Appendable p2, final FieldPosition p3) throws IOException;
    
    public int format(final Object arg, final int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        if (arg instanceof Object[]) {
            return this.format((Object[])arg, start, dst, fpos);
        }
        final Object[] args = { arg };
        return this.format(args, start, dst, fpos);
    }
    
    @Override
    public StringBuffer format(final Object obj, final StringBuffer sbuf, final FieldPosition fpos) {
        this.format((Object[])obj, 0, sbuf, fpos);
        return sbuf;
    }
    
    public int format(final Object[] args, int start, final StringBuffer sbuf, final FieldPosition fpos) {
        final CharArrayWriter wr = new CharArrayWriter();
        try {
            start = this.format(args, start, wr, fpos);
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
    
    public static int format(final Format fmt, final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        if (fmt instanceof ReportFormat) {
            return ((ReportFormat)fmt).format(args, start, dst, fpos);
        }
        final StringBuffer sbuf = new StringBuffer();
        if (fmt instanceof MessageFormat) {
            start = format(fmt, args, start, sbuf, fpos);
        }
        else {
            fmt.format(args[start++], sbuf, fpos);
        }
        dst.append(sbuf);
        return start;
    }
    
    public static int format(final Format fmt, final Object[] args, final int start, final StringBuffer sbuf, final FieldPosition fpos) {
        if (fmt instanceof ReportFormat) {
            return ((ReportFormat)fmt).format(args, start, sbuf, fpos);
        }
        int nargs;
        Object arg;
        if (fmt instanceof MessageFormat) {
            nargs = args.length - start;
            if (start > 0) {
                final Object[] subarr = new Object[args.length - start];
                System.arraycopy(args, start, subarr, 0, subarr.length);
                arg = subarr;
            }
            else {
                arg = args;
            }
        }
        else {
            arg = args[start];
            nargs = 1;
        }
        fmt.format(arg, sbuf, fpos);
        return start + nargs;
    }
    
    public static void print(final Writer dst, final String str) throws IOException {
        if (dst instanceof PrintWriter) {
            ((PrintWriter)dst).print(str);
        }
        else {
            dst.write(str);
        }
    }
    
    public static void print(final Object value, final Consumer out) {
        if (value instanceof Printable) {
            ((Printable)value).print(out);
        }
        else {
            out.write((value == null) ? "null" : value.toString());
        }
    }
    
    @Override
    public Object parseObject(final String text, final ParsePosition status) {
        throw new Error("ReportFormat.parseObject - not implemented");
    }
    
    public static int getParam(final Object arg, final int defaultValue) {
        if (arg instanceof Number) {
            return ((Number)arg).intValue();
        }
        if (arg instanceof Character) {
            return (char)arg;
        }
        if (arg instanceof Char) {
            return ((Char)arg).charValue();
        }
        return defaultValue;
    }
    
    protected static int getParam(final int param, final int defaultValue, final Object[] args, final int start) {
        if (param == -1342177280) {
            return args.length - start;
        }
        if (param == -1610612736) {
            return (args == null) ? defaultValue : getParam(args[start], defaultValue);
        }
        if (param == -1073741824) {
            return defaultValue;
        }
        return param;
    }
    
    protected static char getParam(final int param, final char defaultValue, final Object[] args, final int start) {
        return (char)getParam(param, (int)defaultValue, args, start);
    }
}
