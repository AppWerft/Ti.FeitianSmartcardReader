/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.kawa.functions.LispFormat;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;

class LispIterationFormat
extends ReportFormat {
    int maxIterations;
    boolean seenAt;
    boolean seenColon;
    boolean atLeastOnce;
    Format body;

    LispIterationFormat() {
    }

    public static int format(Format body, int maxIterations, Object[] args, int start, Appendable dst, boolean seenColon, boolean atLeastOnce) throws IOException {
        for (int i = 0; (i != maxIterations || maxIterations == -1) && (start != args.length || i <= 0 && atLeastOnce); ++i) {
            if (seenColon) {
                Object curArg = args[start];
                Object[] curArr = LispFormat.asArray(curArg);
                if (curArr == null) {
                    // empty if block
                }
                int result = ReportFormat.format(body, curArr, 0, dst, null);
                ++start;
                if (ReportFormat.resultCode(result) != 242) continue;
                break;
            }
            if ((start = ReportFormat.format(body, args, start, dst, null)) >= 0) continue;
            start = ReportFormat.nextArg(start);
            break;
        }
        return start;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        Object arg;
        Format body;
        int maxIterations = LispIterationFormat.getParam(this.maxIterations, -1, args, start);
        if (this.maxIterations == -1610612736) {
            ++start;
        }
        if ((body = this.body) == null) {
            if ((arg = args[start++]) instanceof Format) {
                body = (Format)arg;
            } else {
                try {
                    body = new LispFormat(arg.toString());
                }
                catch (Exception ex) {
                    dst.append("<invalid argument for \"~{~}\" format>");
                    return args.length;
                }
            }
        }
        if (this.seenAt) {
            return LispIterationFormat.format(body, maxIterations, args, start, dst, this.seenColon, this.atLeastOnce);
        }
        arg = args[start];
        Object[] curArgs = LispFormat.asArray(arg);
        if (curArgs == null) {
            dst.append('{');
            dst.append(arg.toString());
            dst.append('}');
        } else {
            LispIterationFormat.format(body, maxIterations, curArgs, 0, dst, this.seenColon, this.atLeastOnce);
        }
        return start + 1;
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("LispIterationFormat[");
        sbuf.append(this.body);
        sbuf.append("]");
        return sbuf.toString();
    }
}

