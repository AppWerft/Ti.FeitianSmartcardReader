// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import java.text.Format;
import gnu.kawa.format.PadFormat;
import gnu.kawa.io.OutPort;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;

class LispObjectFormat extends ReportFormat
{
    int minWidth;
    int colInc;
    int minPad;
    int padChar;
    int where;
    ObjectFormat base;
    
    public LispObjectFormat(final ObjectFormat base, final int minWidth, final int colInc, final int minPad, final int padChar, final int where) {
        this.base = base;
        this.minWidth = minWidth;
        this.colInc = colInc;
        this.minPad = minPad;
        this.padChar = padChar;
        this.where = where;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final int minWidth = ReportFormat.getParam(this.minWidth, 0, args, start);
        if (this.minWidth == -1610612736) {
            ++start;
        }
        final int colInc = ReportFormat.getParam(this.colInc, 1, args, start);
        if (this.colInc == -1610612736) {
            ++start;
        }
        final int minPad = ReportFormat.getParam(this.minPad, 0, args, start);
        if (this.minPad == -1610612736) {
            ++start;
        }
        final char padChar = ReportFormat.getParam(this.padChar, ' ', args, start);
        if (this.padChar == -1610612736) {
            ++start;
        }
        if (this.base.readable && dst instanceof OutPort && minWidth == 0) {
            return this.base.format(args, start, dst, fpos);
        }
        return PadFormat.format(this.base, args, start, dst, padChar, minWidth, colInc, minPad, this.where, fpos);
    }
}
