/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.text.FieldPosition;

class LispIndentFormat
extends ReportFormat {
    boolean current;
    int columns;

    LispIndentFormat() {
    }

    public static LispIndentFormat getInstance(int columns, boolean current) {
        LispIndentFormat fmt = new LispIndentFormat();
        fmt.columns = columns;
        fmt.current = current;
        return fmt;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        int columns = LispIndentFormat.getParam(this.columns, 0, args, start);
        if (this.columns == -1610612736) {
            ++start;
        }
        if (dst instanceof OutPort) {
            ((OutPort)dst).setIndentation(columns, this.current);
        }
        return start;
    }
}

