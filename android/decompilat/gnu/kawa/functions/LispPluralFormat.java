// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.io.IOException;
import gnu.math.IntNum;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;

class LispPluralFormat extends ReportFormat
{
    boolean backup;
    boolean y;
    
    public static LispPluralFormat getInstance(final boolean backup, final boolean y) {
        final LispPluralFormat fmt = new LispPluralFormat();
        fmt.backup = backup;
        fmt.y = y;
        return fmt;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        if (this.backup) {
            --start;
        }
        final Object arg = args[start++];
        final boolean plural = arg != IntNum.one();
        if (this.y) {
            dst.append(plural ? "ies" : "y");
        }
        else if (plural) {
            dst.append('s');
        }
        return start;
    }
}
