/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.math.IntNum;
import java.io.IOException;
import java.text.FieldPosition;

class LispPluralFormat
extends ReportFormat {
    boolean backup;
    boolean y;

    LispPluralFormat() {
    }

    public static LispPluralFormat getInstance(boolean backup, boolean y) {
        LispPluralFormat fmt = new LispPluralFormat();
        fmt.backup = backup;
        fmt.y = y;
        return fmt;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        boolean plural;
        if (this.backup) {
            // empty if block
        }
        int n = --start;
        ++start;
        Object arg = args[n];
        boolean bl = plural = arg != IntNum.one();
        if (this.y) {
            dst.append(plural ? "ies" : "y");
        } else if (plural) {
            dst.append('s');
        }
        return start;
    }
}

