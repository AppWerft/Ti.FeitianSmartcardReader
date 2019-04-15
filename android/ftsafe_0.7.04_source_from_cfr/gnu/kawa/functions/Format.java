/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.kawa.functions.ParseFormat;
import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.OutPort;
import gnu.lists.FString;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.MessageFormat;

public class Format
extends ProcedureN {
    public static final Format format = new Format();

    public static void format(Writer dst, Object[] args, int arg_offset) {
        Object format = args[arg_offset++];
        Object[] vals = new Object[args.length - arg_offset];
        System.arraycopy(args, arg_offset, vals, 0, vals.length);
        Format.formatToWriter(dst, format, vals);
    }

    public static /* varargs */ void formatToWriter(Writer dst, Object format, Object ... vals) {
        if (dst == null) {
            dst = OutPort.outDefault();
        }
        try {
            if (format instanceof MessageFormat) {
                String out = ((MessageFormat)format).format(vals);
                dst.write(out);
            } else {
                if (!(format instanceof ReportFormat)) {
                    format = ParseFormat.asFormat(format, '~');
                }
                ((ReportFormat)format).format(vals, 0, (Appendable)dst, (FieldPosition)null);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in format: " + ex);
        }
    }

    public static /* varargs */ void formatToOutputStream(OutputStream dst, Object format, Object ... vals) {
        OutPort port = new OutPort(dst);
        Format.format(port, format, vals);
        port.closeThis();
    }

    public static /* varargs */ String formatToString(int arg_offset, Object ... args) {
        CharArrayOutPort port = new CharArrayOutPort();
        Format.format(port, args, arg_offset);
        String str = port.toString();
        port.close();
        return str;
    }

    public static /* varargs */ String sprintfToString(Object fmt, Object ... args) {
        ReportFormat rfmt = ParseFormat.asFormat(fmt, '%');
        CharArrayOutPort port = new CharArrayOutPort();
        try {
            rfmt.format(args, 0, (Appendable)port, (FieldPosition)null);
        }
        catch (IOException ex) {
            WrappedException.rethrow(ex);
        }
        String str = port.toString();
        port.close();
        return str;
    }

    public static FString formatToFString(char style, Object fmt, Object[] args) {
        ReportFormat rfmt = ParseFormat.asFormat(fmt, style);
        CharArrayOutPort port = new CharArrayOutPort();
        try {
            rfmt.format(args, 0, (Appendable)port, (FieldPosition)null);
        }
        catch (IOException ex) {
            WrappedException.rethrow(ex);
        }
        char[] chars = port.toCharArray();
        port.close();
        return new FString(chars);
    }

    @Override
    public Object applyN(Object[] args) {
        return Format.format(args);
    }

    public static /* varargs */ Object format(Object ... args) {
        Object port_arg = args[0];
        if (port_arg == Boolean.TRUE) {
            Format.format(OutPort.outDefault(), args, 1);
            return Values.empty;
        }
        if (port_arg == Boolean.FALSE) {
            return Format.formatToString(1, args);
        }
        if (port_arg instanceof MessageFormat || port_arg instanceof CharSequence || port_arg instanceof ReportFormat) {
            return Format.formatToString(0, args);
        }
        if (port_arg instanceof Writer) {
            Format.format((Writer)port_arg, args, 1);
            return Values.empty;
        }
        if (port_arg instanceof OutputStream) {
            Format.formatToOutputStream((OutputStream)port_arg, args[1], Format.drop2(args));
            return Values.empty;
        }
        throw new RuntimeException("bad first argument to format");
    }

    static Object[] drop2(Object[] vals) {
        int xlen = vals.length - 2;
        Object[] xvals = new Object[xlen];
        System.arraycopy(vals, 2, xvals, 0, xlen);
        return xvals;
    }

    static {
        format.setName("format");
        format.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyFormat");
    }
}

