/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.format.ReportFormat;
import java.io.Flushable;
import java.io.IOException;
import java.text.FieldPosition;

public class FlushFormat
extends ReportFormat {
    private static FlushFormat flush;

    public static FlushFormat getInstance() {
        if (flush == null) {
            flush = new FlushFormat();
        }
        return flush;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        if (dst instanceof Flushable) {
            ((Flushable)((Object)dst)).flush();
        }
        return start;
    }
}

