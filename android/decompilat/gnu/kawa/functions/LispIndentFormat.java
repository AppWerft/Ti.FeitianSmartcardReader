// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import gnu.kawa.io.OutPort;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;

class LispIndentFormat extends ReportFormat
{
    boolean current;
    int columns;
    
    public static LispIndentFormat getInstance(final int columns, final boolean current) {
        final LispIndentFormat fmt = new LispIndentFormat();
        fmt.columns = columns;
        fmt.current = current;
        return fmt;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final int columns = ReportFormat.getParam(this.columns, 0, args, start);
        if (this.columns == -1610612736) {
            ++start;
        }
        if (dst instanceof OutPort) {
            ((OutPort)dst).setIndentation(columns, this.current);
        }
        return start;
    }
}
