/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.FieldPosition;

class LispNewlineFormat
extends ReportFormat {
    static final String line_separator = System.getProperty("line.separator", "\n");
    int kind;
    int count;

    LispNewlineFormat() {
    }

    public static LispNewlineFormat getInstance(int count, int kind) {
        LispNewlineFormat fmt = new LispNewlineFormat();
        fmt.count = count;
        fmt.kind = kind;
        return fmt;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        int count = LispNewlineFormat.getParam(this.count, 1, args, start);
        if (this.count == -1610612736) {
            ++start;
        }
        while (--count >= 0) {
            LispNewlineFormat.printNewline(this.kind, dst);
        }
        return start;
    }

    public static void printNewline(int kind, Appendable dst) throws IOException {
        if (dst instanceof OutPort && kind != 76) {
            ((OutPort)dst).writeBreak(kind);
        } else if (dst instanceof PrintWriter) {
            ((PrintWriter)dst).println();
        } else {
            dst.append(line_separator);
        }
    }
}

