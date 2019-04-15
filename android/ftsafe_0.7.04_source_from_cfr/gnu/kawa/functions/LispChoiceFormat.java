/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;

class LispChoiceFormat
extends ReportFormat {
    int param;
    boolean lastIsDefault;
    boolean testBoolean;
    boolean skipIfFalse;
    Format[] choices;

    LispChoiceFormat() {
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        Format fmt;
        if (this.testBoolean) {
            fmt = this.choices[args[start] == Boolean.FALSE ? 0 : 1];
            ++start;
        } else if (!this.skipIfFalse) {
            int index = LispChoiceFormat.getParam(this.param, -1610612736, args, start);
            if (this.param == -1610612736) {
                ++start;
            }
            if (index < 0 || index >= this.choices.length) {
                if (this.lastIsDefault) {
                    index = this.choices.length - 1;
                } else {
                    return start;
                }
            }
            fmt = this.choices[index];
        } else {
            if (args[start] == Boolean.FALSE) {
                return start + 1;
            }
            fmt = this.choices[0];
        }
        return ReportFormat.format(fmt, args, start, dst, fpos);
    }
}

