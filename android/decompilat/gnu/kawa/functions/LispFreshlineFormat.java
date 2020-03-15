// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import gnu.kawa.io.OutPort;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;

class LispFreshlineFormat extends ReportFormat
{
    int count;
    
    public LispFreshlineFormat(final int count) {
        this.count = count;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        int count = ReportFormat.getParam(this.count, 1, args, start);
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
