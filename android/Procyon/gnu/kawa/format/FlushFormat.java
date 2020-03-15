// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import java.io.IOException;
import java.io.Flushable;
import java.text.FieldPosition;

public class FlushFormat extends ReportFormat
{
    private static FlushFormat flush;
    
    public static FlushFormat getInstance() {
        if (FlushFormat.flush == null) {
            FlushFormat.flush = new FlushFormat();
        }
        return FlushFormat.flush;
    }
    
    @Override
    public int format(final Object[] args, final int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        if (dst instanceof Flushable) {
            ((Flushable)dst).flush();
        }
        return start;
    }
}
