// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.text.ParsePosition;
import gnu.kawa.io.CharArrayOutPort;
import java.io.Writer;
import java.io.CharArrayWriter;
import gnu.kawa.format.AbstractFormat;
import gnu.lists.Consumer;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;

public class ObjectFormat extends ReportFormat
{
    int maxChars;
    boolean readable;
    private static ObjectFormat readableFormat;
    private static ObjectFormat plainFormat;
    
    public static ObjectFormat getInstance(final boolean readable) {
        if (readable) {
            if (ObjectFormat.readableFormat == null) {
                ObjectFormat.readableFormat = new ObjectFormat(true);
            }
            return ObjectFormat.readableFormat;
        }
        if (ObjectFormat.plainFormat == null) {
            ObjectFormat.plainFormat = new ObjectFormat(false);
        }
        return ObjectFormat.plainFormat;
    }
    
    public ObjectFormat(final boolean readable) {
        this.readable = readable;
        this.maxChars = -1073741824;
    }
    
    public ObjectFormat(final boolean readable, final int maxChars) {
        this.readable = readable;
        this.maxChars = maxChars;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final int maxChars = ReportFormat.getParam(this.maxChars, -1, args, start);
        if (this.maxChars == -1610612736) {
            ++start;
        }
        return format(args, start, dst, maxChars, this.readable);
    }
    
    private static void print(final Object obj, final OutPort out, final boolean readable) {
        final AbstractFormat format = readable ? DisplayFormat.schemeWriteFormat : DisplayFormat.schemeDisplayFormat;
        final Object save = out.pushFormat(format);
        try {
            format.writeObject(obj, (Consumer)out);
        }
        finally {
            out.popFormat(save);
        }
    }
    
    public static boolean format(final Object arg, final Appendable dst, final int maxChars, final boolean readable) throws IOException {
        if (maxChars < 0 && dst instanceof OutPort) {
            print(arg, (OutPort)dst, readable);
            return true;
        }
        if (maxChars < 0 && dst instanceof CharArrayWriter) {
            final OutPort oport = new OutPort((Writer)dst);
            print(arg, oport, readable);
            oport.close();
            return true;
        }
        final CharArrayOutPort oport2 = new CharArrayOutPort();
        print(arg, oport2, readable);
        final int len = oport2.size();
        if (maxChars < 0 || len <= maxChars) {
            oport2.writeTo(dst);
            return true;
        }
        oport2.writeTo(0, maxChars, dst);
        return false;
    }
    
    public static int format(final Object[] args, int start, final Appendable dst, int maxChars, boolean readable) throws IOException {
        Object arg;
        if (start >= args.length) {
            arg = "#<missing format argument>";
            --start;
            readable = false;
            maxChars = -1;
        }
        else {
            arg = args[start];
        }
        format(arg, dst, maxChars, readable);
        return start + 1;
    }
    
    @Override
    public Object parseObject(final String text, final ParsePosition status) {
        throw new RuntimeException("ObjectFormat.parseObject - not implemented");
    }
}
