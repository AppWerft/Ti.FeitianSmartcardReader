// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import gnu.kawa.io.OutPort;
import java.text.FieldPosition;
import java.text.Format;
import gnu.kawa.format.ReportFormat;

class LispPrettyFormat extends ReportFormat
{
    Format[] segments;
    Format body;
    String prefix;
    String suffix;
    boolean perLine;
    boolean seenAt;
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        String pre = this.prefix;
        String suf = this.suffix;
        final OutPort out = (dst instanceof OutPort) ? ((OutPort)dst) : null;
        try {
            if (this.seenAt) {
                if (out != null) {
                    out.startLogicalBlock(pre, this.perLine, this.suffix);
                }
                start = ReportFormat.format(this.body, args, start, dst, fpos);
            }
            else {
                final Object curArg = args[start];
                final Object[] curArr = LispFormat.asArray(curArg);
                if (curArr == null) {
                    suf = (pre = "");
                }
                if (out != null) {
                    out.startLogicalBlock(pre, this.perLine, this.suffix);
                }
                if (curArr == null) {
                    ObjectFormat.format(curArg, dst, -1, true);
                }
                else {
                    ReportFormat.format(this.body, curArr, 0, dst, fpos);
                }
                ++start;
            }
        }
        finally {
            if (out != null) {
                out.endLogicalBlock(suf);
            }
        }
        return start;
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append("LispPrettyFormat[");
        sbuf.append("prefix: \"");
        sbuf.append(this.prefix);
        sbuf.append("\", suffix: \"");
        sbuf.append(this.suffix);
        sbuf.append("\", body: ");
        sbuf.append(this.body);
        sbuf.append("]");
        return sbuf.toString();
    }
}
