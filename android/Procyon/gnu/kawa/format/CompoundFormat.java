// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import java.text.ParsePosition;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;

public class CompoundFormat extends ReportFormat
{
    protected int length;
    protected Format[] formats;
    
    public CompoundFormat(final Format[] formats, final int length) {
        this.formats = formats;
        this.length = length;
    }
    
    public CompoundFormat(final Format[] formats) {
        this.formats = formats;
        this.length = formats.length;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        for (int i = 0; i < this.length; ++i) {
            final Format fmt = this.formats[i];
            if (fmt instanceof ReportFormat) {
                start = ((ReportFormat)fmt).format(args, start, dst, fpos);
                if (start < 0) {
                    return start;
                }
            }
            else if (start >= args.length) {
                dst.append("#<missing format argument>");
            }
            else {
                final StringBuffer sbuf = new StringBuffer();
                fmt.format(args[start], sbuf, fpos);
                dst.append(sbuf.toString());
                ++start;
            }
        }
        return start;
    }
    
    @Override
    public final int format(final Object[] args, int start, final StringBuffer sbuf, final FieldPosition fpos) {
        for (int i = 0; i < this.length; ++i) {
            final Format fmt = this.formats[i];
            if (fmt instanceof ReportFormat) {
                start = ((ReportFormat)fmt).format(args, start, sbuf, fpos);
                if (start < 0) {
                    return start;
                }
            }
            else {
                fmt.format(args[start], sbuf, fpos);
                ++start;
            }
        }
        return start;
    }
    
    @Override
    public Object parseObject(final String text, final ParsePosition status) {
        throw new Error("CompoundFormat.parseObject - not implemented");
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append("CompoundFormat[");
        for (int i = 0; i < this.length; ++i) {
            if (i > 0) {
                sbuf.append(", ");
            }
            sbuf.append(this.formats[i]);
        }
        sbuf.append("]");
        return sbuf.toString();
    }
}
