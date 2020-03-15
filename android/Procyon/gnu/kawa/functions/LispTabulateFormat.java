// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import gnu.kawa.io.OutPort;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;

class LispTabulateFormat extends ReportFormat
{
    boolean relative;
    int colnum;
    int colinc;
    int padChar;
    
    public LispTabulateFormat(final int colnum, final int colinc, final int padChar, final boolean relative) {
        this.colnum = colnum;
        this.colinc = colinc;
        this.relative = relative;
        this.padChar = padChar;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final int colnum = ReportFormat.getParam(this.colnum, 1, args, start);
        if (this.colnum == -1610612736) {
            ++start;
        }
        final int colinc = ReportFormat.getParam(this.colinc, 1, args, start);
        if (this.colinc == -1610612736) {
            ++start;
        }
        final char padChar = ReportFormat.getParam(this.padChar, ' ', args, start);
        if (this.padChar == -1610612736) {
            ++start;
        }
        int column = -1;
        if (dst instanceof OutPort) {
            column = ((OutPort)dst).getColumnNumber();
        }
        int spaces;
        if (column >= 0) {
            if (!this.relative) {
                if (column < colnum) {
                    spaces = colnum - column;
                }
                else if (colinc <= 0) {
                    spaces = 0;
                }
                else {
                    spaces = colinc - (column - colnum) % colinc;
                }
            }
            else {
                spaces = colnum + colinc - (column + colnum) % colinc;
            }
        }
        else {
            spaces = (this.relative ? colnum : 2);
        }
        while (--spaces >= 0) {
            dst.append(padChar);
        }
        return start;
    }
}
