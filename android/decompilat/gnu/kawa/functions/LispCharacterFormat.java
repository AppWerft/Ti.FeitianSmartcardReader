// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.text.Char;
import java.io.IOException;
import java.text.FieldPosition;
import gnu.kawa.format.ReportFormat;

class LispCharacterFormat extends ReportFormat
{
    boolean seenAt;
    boolean seenColon;
    int count;
    int charVal;
    
    public static LispCharacterFormat getInstance(final int charVal, final int count, final boolean seenAt, final boolean seenColon) {
        final LispCharacterFormat fmt = new LispCharacterFormat();
        fmt.count = count;
        fmt.charVal = charVal;
        fmt.seenAt = seenAt;
        fmt.seenColon = seenColon;
        return fmt;
    }
    
    @Override
    public int format(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        int count = ReportFormat.getParam(this.count, 1, args, start);
        if (this.count == -1610612736) {
            ++start;
        }
        final int charVal = ReportFormat.getParam(this.charVal, '?', args, start);
        if (this.charVal == -1610612736) {
            ++start;
        }
        while (--count >= 0) {
            printChar(charVal, this.seenAt, this.seenColon, dst);
        }
        return start;
    }
    
    public static void printChar(final int ch, final boolean seenAt, final boolean seenColon, final Appendable dst) throws IOException {
        if (seenAt) {
            dst.append(Char.toScmReadableString(ch));
        }
        else if (seenColon) {
            if (ch < 32) {
                dst.append('^');
                dst.append((char)(ch + 64));
            }
            else if (ch >= 127) {
                dst.append("#\\x");
                dst.append(Integer.toString(ch, 16));
            }
            else {
                Char.append(ch, dst);
            }
        }
        else {
            Char.append(ch, dst);
        }
    }
}
