/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.text.FieldPosition;

class LispFreshlineFormat
extends ReportFormat {
    int count;

    public LispFreshlineFormat(int count) {
        this.count = count;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        int count = LispFreshlineFormat.getParam(this.count, 1, args, start);
        if (this.count == -1610612736) {
            ++start;
        }
        if (count > 0) {
            if (dst instanceof OutPort) {
                ((OutPort)dst).freshLine();
                --count;
            }
            while (--count >= 0) {
                dst.append('\n');
            }
        }
        return start;
    }
}

