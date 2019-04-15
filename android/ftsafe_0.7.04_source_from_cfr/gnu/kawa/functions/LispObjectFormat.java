/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.PadFormat;
import gnu.kawa.format.ReportFormat;
import gnu.kawa.functions.ObjectFormat;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.text.FieldPosition;

class LispObjectFormat
extends ReportFormat {
    int minWidth;
    int colInc;
    int minPad;
    int padChar;
    int where;
    ObjectFormat base;

    public LispObjectFormat(ObjectFormat base2, int minWidth, int colInc, int minPad, int padChar, int where) {
        this.base = base2;
        this.minWidth = minWidth;
        this.colInc = colInc;
        this.minPad = minPad;
        this.padChar = padChar;
        this.where = where;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        int minWidth = LispObjectFormat.getParam(this.minWidth, 0, args, start);
        if (this.minWidth == -1610612736) {
            ++start;
        }
        int colInc = LispObjectFormat.getParam(this.colInc, 1, args, start);
        if (this.colInc == -1610612736) {
            ++start;
        }
        int minPad = LispObjectFormat.getParam(this.minPad, 0, args, start);
        if (this.minPad == -1610612736) {
            ++start;
        }
        char padChar = LispObjectFormat.getParam(this.padChar, ' ', args, start);
        if (this.padChar == -1610612736) {
            ++start;
        }
        if (this.base.readable && dst instanceof OutPort && minWidth == 0) {
            return this.base.format(args, start, dst, fpos);
        }
        return PadFormat.format(this.base, args, start, dst, padChar, minWidth, colInc, minPad, this.where, fpos);
    }
}

