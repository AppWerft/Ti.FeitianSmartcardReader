/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.format.ReportFormat;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class CompoundFormat
extends ReportFormat {
    protected int length;
    protected Format[] formats;

    public CompoundFormat(Format[] formats, int length) {
        this.formats = formats;
        this.length = length;
    }

    public CompoundFormat(Format[] formats) {
        this.formats = formats;
        this.length = formats.length;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        for (int i = 0; i < this.length; ++i) {
            Format fmt = this.formats[i];
            if (fmt instanceof ReportFormat) {
                if ((start = ((ReportFormat)fmt).format(args, start, dst, fpos)) >= 0) continue;
                return start;
            }
            if (start >= args.length) {
                dst.append("#<missing format argument>");
                continue;
            }
            StringBuffer sbuf = new StringBuffer();
            fmt.format(args[start], sbuf, fpos);
            dst.append(sbuf.toString());
            ++start;
        }
        return start;
    }

    @Override
    public final int format(Object[] args, int start, StringBuffer sbuf, FieldPosition fpos) {
        for (int i = 0; i < this.length; ++i) {
            Format fmt = this.formats[i];
            if (fmt instanceof ReportFormat) {
                if ((start = ((ReportFormat)fmt).format(args, start, sbuf, fpos)) >= 0) continue;
                return start;
            }
            fmt.format(args[start], sbuf, fpos);
            ++start;
        }
        return start;
    }

    @Override
    public Object parseObject(String text, ParsePosition status) {
        throw new Error("CompoundFormat.parseObject - not implemented");
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer();
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

