// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.PrintWriter;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;

class LispNewlineFormat extends ReportFormat
{
    static final String line_separator;
    int kind;
    int count;
    
    public static LispNewlineFormat getInstance(final int count, final int kind) {
        final LispNewlineFormat fmt = new LispNewlineFormat();
        fmt.count = count;
        fmt.kind = kind;
        return fmt;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        int count = ReportFormat.getParam(this.count, 1, args, start);
        if (this.count == -1610612736) {
            ++start;
        }
        while (--count >= 0) {
            printNewline(this.kind, dst);
        }
        return start;
    }
    
    public static void printNewline(final int kind, final Appendable dst) throws IOException {
        if (dst instanceof OutPort && kind != 76) {
            ((OutPort)dst).writeBreak(kind);
        }
        else if (dst instanceof PrintWriter) {
            ((PrintWriter)dst).println();
        }
        else {
            dst.append(LispNewlineFormat.line_separator);
        }
    }
    
    static {
        line_separator = System.getProperty("line.separator", "\n");
    }
}
