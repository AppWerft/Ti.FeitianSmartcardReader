// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import gnu.kawa.format.ReportFormat;

class LispIterationFormat extends ReportFormat
{
    int maxIterations;
    boolean seenAt;
    boolean seenColon;
    boolean atLeastOnce;
    Format body;
    
    public static int format(final Format body, final int maxIterations, final Object[] args, int start, final Appendable dst, final boolean seenColon, final boolean atLeastOnce) throws IOException {
        for (int i = 0; i != maxIterations || maxIterations == -1; ++i) {
            if (start == args.length) {
                if (i > 0) {
                    break;
                }
                if (!atLeastOnce) {
                    break;
                }
            }
            if (seenColon) {
                final Object curArg = args[start];
                final Object[] curArr = LispFormat.asArray(curArg);
                if (curArr == null) {}
                final int result = ReportFormat.format(body, curArr, 0, dst, null);
                ++start;
                if (ReportFormat.resultCode(result) == 242) {
                    break;
                }
            }
            else {
                start = ReportFormat.format(body, args, start, dst, null);
                if (start < 0) {
                    start = ReportFormat.nextArg(start);
                    break;
                }
            }
        }
        return start;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final int maxIterations = ReportFormat.getParam(this.maxIterations, -1, args, start);
        if (this.maxIterations == -1610612736) {
            ++start;
        }
        Format body = this.body;
        if (body == null) {
            final Object arg = args[start++];
            if (arg instanceof Format) {
                body = (Format)arg;
            }
            else {
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
            return format(body, maxIterations, args, start, dst, this.seenColon, this.atLeastOnce);
        }
        final Object arg = args[start];
        final Object[] curArgs = LispFormat.asArray(arg);
        if (curArgs == null) {
            dst.append('{');
            dst.append(arg.toString());
            dst.append('}');
        }
        else {
            format(body, maxIterations, curArgs, 0, dst, this.seenColon, this.atLeastOnce);
        }
        return start + 1;
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append("LispIterationFormat[");
        sbuf.append(this.body);
        sbuf.append("]");
        return sbuf.toString();
    }
}
