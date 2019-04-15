/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.text.FieldPosition;

class LispTabulateFormat
extends ReportFormat {
    boolean relative;
    int colnum;
    int colinc;
    int padChar;

    public LispTabulateFormat(int colnum, int colinc, int padChar, boolean relative) {
        this.colnum = colnum;
        this.colinc = colinc;
        this.relative = relative;
        this.padChar = padChar;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        int spaces;
        int colnum = LispTabulateFormat.getParam(this.colnum, 1, args, start);
        if (this.colnum == -1610612736) {
            ++start;
        }
        int colinc = LispTabulateFormat.getParam(this.colinc, 1, args, start);
        if (this.colinc == -1610612736) {
            ++start;
        }
        char padChar = LispTabulateFormat.getParam(this.padChar, ' ', args, start);
        if (this.padChar == -1610612736) {
            ++start;
        }
        int column = -1;
        if (dst instanceof OutPort) {
            column = ((OutPort)dst).getColumnNumber();
        }
        if (column >= 0) {
            spaces = !this.relative ? (column < colnum ? colnum - column : (colinc <= 0 ? 0 : colinc - (column - colnum) % colinc)) : colnum + colinc - (column + colnum) % colinc;
        } else {
            int n = spaces = this.relative ? colnum : 2;
        }
        while (--spaces >= 0) {
            dst.append(padChar);
        }
        return start;
    }
}

