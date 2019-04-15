/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.math.ExponentialFormat;
import gnu.math.FixedRealFormat;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;

class LispRealFormat
extends ReportFormat {
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
    int argsUsed = -1;
    public char style = (char)76;

    LispRealFormat() {
    }

    public Format resolve(Object[] args, int start) {
        if (this.argsUsed < 0) {
            int n = this.argsUsed = this.arg1 == -1342177280 || this.arg2 == -1342177280 || this.arg3 == -1342177280 || this.arg4 == -1342177280 || this.arg5 == -1342177280 || this.arg6 == -1342177280 || this.arg7 == -1342177280 ? 1 : 0;
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
            FixedRealFormat mfmt = new FixedRealFormat();
            int decimals = LispRealFormat.getParam(this.arg1, 2, args, start);
            if (this.arg1 == -1610612736) {
                ++start;
            }
            int digits = LispRealFormat.getParam(this.arg2, 1, args, start);
            if (this.arg2 == -1610612736) {
                ++start;
            }
            int width = LispRealFormat.getParam(this.arg3, 0, args, start);
            if (this.arg3 == -1610612736) {
                ++start;
            }
            char padChar = LispRealFormat.getParam(this.arg4, ' ', args, start);
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
            FixedRealFormat mfmt = new FixedRealFormat();
            int width = LispRealFormat.getParam(this.arg1, 0, args, start);
            if (this.arg1 == -1610612736) {
                ++start;
            }
            int decimals = LispRealFormat.getParam(this.arg2, -1, args, start);
            if (this.arg2 == -1610612736) {
                ++start;
            }
            int scale = LispRealFormat.getParam(this.arg3, 0, args, start);
            if (this.arg3 == -1610612736) {
                ++start;
            }
            mfmt.overflowChar = LispRealFormat.getParam(this.arg4, '\u0000', args, start);
            if (this.arg4 == -1610612736) {
                ++start;
            }
            char padChar = LispRealFormat.getParam(this.arg5, ' ', args, start);
            if (this.arg5 == -1610612736) {
                ++start;
            }
            mfmt.setMaximumFractionDigits(decimals);
            mfmt.setMinimumIntegerDigits(0);
            mfmt.width = width;
            mfmt.scale = scale;
            mfmt.padChar = padChar;
            mfmt.internalPad = this.internalPad;
            mfmt.showPlus = this.showPlus;
            return mfmt;
        }
        ExponentialFormat efmt = new ExponentialFormat();
        efmt.exponentShowSign = true;
        efmt.width = LispRealFormat.getParam(this.arg1, 0, args, start);
        if (this.arg1 == -1610612736) {
            ++start;
        }
        efmt.fracDigits = LispRealFormat.getParam(this.arg2, -1, args, start);
        if (this.arg2 == -1610612736) {
            ++start;
        }
        efmt.expDigits = LispRealFormat.getParam(this.arg3, 0, args, start);
        if (this.arg3 == -1610612736) {
            ++start;
        }
        efmt.intDigits = LispRealFormat.getParam(this.arg4, 1, args, start);
        if (this.arg4 == -1610612736) {
            ++start;
        }
        efmt.overflowChar = LispRealFormat.getParam(this.arg5, '\u0000', args, start);
        if (this.arg5 == -1610612736) {
            ++start;
        }
        efmt.padChar = LispRealFormat.getParam(this.arg6, ' ', args, start);
        if (this.arg6 == -1610612736) {
            ++start;
        }
        efmt.exponentChar = LispRealFormat.getParam(this.arg7, 'E', args, start);
        if (this.arg7 == -1610612736) {
            ++start;
        }
        efmt.general = this.op == 'G' || this.op == 'g';
        efmt.style = this.style;
        efmt.showPlus = this.showPlus;
        return efmt;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        StringBuffer sbuf = new StringBuffer(100);
        Format fmt = this.resolve(args, start);
        start += this.argsUsed >> 1;
        Number value = (Number)args[start++];
        fmt.format(value, sbuf, fpos);
        dst.append(sbuf);
        return start;
    }
}

