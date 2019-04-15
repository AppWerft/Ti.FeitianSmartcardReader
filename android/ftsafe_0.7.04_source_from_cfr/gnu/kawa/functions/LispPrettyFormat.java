/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.kawa.functions.LispFormat;
import gnu.kawa.functions.ObjectFormat;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;

class LispPrettyFormat
extends ReportFormat {
    Format[] segments;
    Format body;
    String prefix;
    String suffix;
    boolean perLine;
    boolean seenAt;

    LispPrettyFormat() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        String pre = this.prefix;
        String suf = this.suffix;
        OutPort out = dst instanceof OutPort ? (OutPort)dst : null;
        try {
            if (this.seenAt) {
                if (out != null) {
                    out.startLogicalBlock(pre, this.perLine, this.suffix);
                }
                start = ReportFormat.format(this.body, args, start, dst, fpos);
            } else {
                Object curArg = args[start];
                Object[] curArr = LispFormat.asArray(curArg);
                if (curArr == null) {
                    suf = "";
                    pre = "";
                }
                if (out != null) {
                    out.startLogicalBlock(pre, this.perLine, this.suffix);
                }
                if (curArr == null) {
                    ObjectFormat.format(curArg, dst, -1, true);
                } else {
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

    public String toString() {
        StringBuffer sbuf = new StringBuffer();
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

