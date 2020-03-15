// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.lists.FString;
import gnu.mapping.WrappedException;
import gnu.kawa.io.CharArrayOutPort;
import java.io.OutputStream;
import java.io.IOException;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;
import java.text.MessageFormat;
import gnu.kawa.io.OutPort;
import java.io.Writer;
import gnu.mapping.ProcedureN;

public class Format extends ProcedureN
{
    public static final Format format;
    
    public static void format(final Writer dst, final Object[] args, int arg_offset) {
        final Object format = args[arg_offset++];
        final Object[] vals = new Object[args.length - arg_offset];
        System.arraycopy(args, arg_offset, vals, 0, vals.length);
        formatToWriter(dst, format, vals);
    }
    
    public static void formatToWriter(Writer dst, Object format, final Object... vals) {
        if (dst == null) {
            dst = OutPort.outDefault();
        }
        try {
            if (format instanceof MessageFormat) {
                final String out = ((MessageFormat)format).format(vals);
                dst.write(out);
            }
            else {
                if (!(format instanceof ReportFormat)) {
                    format = ParseFormat.asFormat(format, '~');
                }
                ((ReportFormat)format).format(vals, 0, dst, null);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in format: " + ex);
        }
    }
    
    public static void formatToOutputStream(final OutputStream dst, final Object format, final Object... vals) {
        final OutPort port = new OutPort(dst);
        format(port, format, vals);
        port.closeThis();
    }
    
    public static String formatToString(final int arg_offset, final Object... args) {
        final CharArrayOutPort port = new CharArrayOutPort();
        format(port, args, arg_offset);
        final String str = port.toString();
        port.close();
        return str;
    }
    
    public static String sprintfToString(final Object fmt, final Object... args) {
        final ReportFormat rfmt = ParseFormat.asFormat(fmt, '%');
        final CharArrayOutPort port = new CharArrayOutPort();
        try {
            rfmt.format(args, 0, port, null);
        }
        catch (IOException ex) {
            WrappedException.rethrow(ex);
        }
        final String str = port.toString();
        port.close();
        return str;
    }
    
    public static FString formatToFString(final char style, final Object fmt, final Object[] args) {
        final ReportFormat rfmt = ParseFormat.asFormat(fmt, style);
        final CharArrayOutPort port = new CharArrayOutPort();
        try {
            rfmt.format(args, 0, port, null);
        }
        catch (IOException ex) {
            WrappedException.rethrow(ex);
        }
        final char[] chars = port.toCharArray();
        port.close();
        return new FString(chars);
    }
    
    @Override
    public Object applyN(final Object[] args) {
        return format(args);
    }
    
    public static Object format(final Object... args) {
        final Object port_arg = args[0];
        if (port_arg == Boolean.TRUE) {
            format(OutPort.outDefault(), args, 1);
            return Values.empty;
        }
        if (port_arg == Boolean.FALSE) {
            return formatToString(1, args);
        }
        if (port_arg instanceof MessageFormat || port_arg instanceof CharSequence || port_arg instanceof ReportFormat) {
            return formatToString(0, args);
        }
        if (port_arg instanceof Writer) {
            format((Writer)port_arg, args, 1);
            return Values.empty;
        }
        if (port_arg instanceof OutputStream) {
            formatToOutputStream((OutputStream)port_arg, args[1], drop2(args));
            return Values.empty;
        }
        throw new RuntimeException("bad first argument to format");
    }
    
    static Object[] drop2(final Object[] vals) {
        final int xlen = vals.length - 2;
        final Object[] xvals = new Object[xlen];
        System.arraycopy(vals, 2, xvals, 0, xlen);
        return xvals;
    }
    
    static {
        (format = new Format()).setName("format");
        Format.format.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyFormat");
    }
}
