// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;

class LispRepositionFormat extends ReportFormat
{
    boolean backwards;
    boolean absolute;
    int count;
    
    public LispRepositionFormat(final int count, final boolean backwards, final boolean absolute) {
        this.count = count;
        this.backwards = backwards;
        this.absolute = absolute;
    }
    
    @Override
    public int format(final Object[] args, final int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        int count = ReportFormat.getParam(this.count, this.absolute ? 0 : 1, args, start);
        if (!this.absolute) {
            if (this.backwards) {
                count = -count;
            }
            count += start;
        }
        return (count < 0) ? 0 : ((count > args.length) ? args.length : count);
    }
}
