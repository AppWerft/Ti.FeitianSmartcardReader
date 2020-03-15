// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import gnu.kawa.format.ReportFormat;

class LispChoiceFormat extends ReportFormat
{
    int param;
    boolean lastIsDefault;
    boolean testBoolean;
    boolean skipIfFalse;
    Format[] choices;
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        Format fmt;
        if (this.testBoolean) {
            fmt = this.choices[args[start] != Boolean.FALSE];
            ++start;
        }
        else if (!this.skipIfFalse) {
            int index = ReportFormat.getParam(this.param, -1610612736, args, start);
            if (this.param == -1610612736) {
                ++start;
            }
            if (index < 0 || index >= this.choices.length) {
                if (!this.lastIsDefault) {
                    return start;
                }
                index = this.choices.length - 1;
            }
            fmt = this.choices[index];
        }
        else {
            if (args[start] == Boolean.FALSE) {
                return start + 1;
            }
            fmt = this.choices[0];
        }
        return ReportFormat.format(fmt, args, start, dst, fpos);
    }
}
