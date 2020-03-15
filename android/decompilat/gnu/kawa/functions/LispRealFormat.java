// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import java.text.FieldPosition;
import gnu.math.ExponentialFormat;
import gnu.math.FixedRealFormat;
import java.text.Format;
import gnu.kawa.format.ReportFormat;

class LispRealFormat extends ReportFormat
{
    char op;
    int arg1;
    int arg2;
    int arg3;
    int arg4;
    int arg5;
    int arg6;
    int arg7;
    boolean showPlus;
    boolean internalPad;
    int argsUsed;
    public char style;
    
    LispRealFormat() {
        this.argsUsed = -1;
        this.style = 'L';
    }
    
    public Format resolve(final Object[] args, int start) {
        if (this.argsUsed < 0) {
            this.argsUsed = ((this.arg1 == -1342177280 || this.arg2 == -1342177280 || this.arg3 == -1342177280 || this.arg4 == -1342177280 || this.arg5 == -1342177280 || this.arg6 == -1342177280 || this.arg7 == -1342177280) ? 1 : 0);
            if (this.arg1 == -1610612736) {
                this.argsUsed += 2;
            }
            if (this.arg2 == -1610612736) {
                this.argsUsed += 2;
            }
            if (this.arg3 == -1610612736) {
                this.argsUsed += 2;
            }
            if (this.arg4 == -1610612736) {
                this.argsUsed += 2;
            }
            if (this.arg5 == -1610612736) {
                this.argsUsed += 2;
            }
            if (this.arg6 == -1610612736) {
                this.argsUsed += 2;
            }
            if (this.arg7 == -1610612736) {
                this.argsUsed += 2;
            }
        }
        if (this.argsUsed > 0 && args == null) {
            return this;
        }
        if (this.op == '$') {
            final FixedRealFormat mfmt = new FixedRealFormat();
            final int decimals = ReportFormat.getParam(this.arg1, 2, args, start);
            if (this.arg1 == -1610612736) {
                ++start;
            }
            final int digits = ReportFormat.getParam(this.arg2, 1, args, start);
            if (this.arg2 == -1610612736) {
                ++start;
            }
            final int width = ReportFormat.getParam(this.arg3, 0, args, start);
            if (this.arg3 == -1610612736) {
                ++start;
            }
            final char padChar = ReportFormat.getParam(this.arg4, ' ', args, start);
            if (this.arg4 == -1610612736) {
                ++start;
            }
            mfmt.setMaximumFractionDigits(decimals);
            mfmt.setMinimumIntegerDigits(digits);
            mfmt.width = width;
            mfmt.padChar = padChar;
            mfmt.internalPad = this.internalPad;
            mfmt.showPlus = this.showPlus;
            return mfmt;
        }
        if (this.op == 'F' || this.op == 'f') {
            final FixedRealFormat mfmt = new FixedRealFormat();
            final int width2 = ReportFormat.getParam(this.arg1, 0, args, start);
            if (this.arg1 == -1610612736) {
                ++start;
            }
            final int decimals2 = ReportFormat.getParam(this.arg2, -1, args, start);
            if (this.arg2 == -1610612736) {
                ++start;
            }
            final int scale = ReportFormat.getParam(this.arg3, 0, args, start);
            if (this.arg3 == -1610612736) {
                ++start;
            }
            mfmt.overflowChar = ReportFormat.getParam(this.arg4, '\0', args, start);
            if (this.arg4 == -1610612736) {
                ++start;
            }
            final char padChar = ReportFormat.getParam(this.arg5, ' ', args, start);
            if (this.arg5 == -1610612736) {
                ++start;
            }
            mfmt.setMaximumFractionDigits(decimals2);
            mfmt.setMinimumIntegerDigits(0);
            mfmt.width = width2;
            mfmt.scale = scale;
            mfmt.padChar = padChar;
            mfmt.internalPad = this.internalPad;
            mfmt.showPlus = this.showPlus;
            return mfmt;
        }
        final ExponentialFormat efmt = new ExponentialFormat();
        efmt.exponentShowSign = true;
        efmt.width = ReportFormat.getParam(this.arg1, 0, args, start);
        if (this.arg1 == -1610612736) {
            ++start;
        }
        efmt.fracDigits = ReportFormat.getParam(this.arg2, -1, args, start);
        if (this.arg2 == -1610612736) {
            ++start;
        }
        efmt.expDigits = ReportFormat.getParam(this.arg3, 0, args, start);
        if (this.arg3 == -1610612736) {
            ++start;
        }
        efmt.intDigits = ReportFormat.getParam(this.arg4, 1, args, start);
        if (this.arg4 == -1610612736) {
            ++start;
        }
        efmt.overflowChar = ReportFormat.getParam(this.arg5, '\0', args, start);
        if (this.arg5 == -1610612736) {
            ++start;
        }
        efmt.padChar = ReportFormat.getParam(this.arg6, ' ', args, start);
        if (this.arg6 == -1610612736) {
            ++start;
        }
        efmt.exponentChar = ReportFormat.getParam(this.arg7, 'E', args, start);
        if (this.arg7 == -1610612736) {
            ++start;
        }
        efmt.general = (this.op == 'G' || this.op == 'g');
        efmt.style = this.style;
        efmt.showPlus = this.showPlus;
        return efmt;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final StringBuffer sbuf = new StringBuffer(100);
        final Format fmt = this.resolve(args, start);
        start += this.argsUsed >> 1;
        final Number value = (Number)args[start++];
        fmt.format(value, sbuf, fpos);
        dst.append(sbuf);
        return start;
    }
}
