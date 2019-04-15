/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.ReportFormat;
import gnu.text.Char;
import java.io.IOException;
import java.text.FieldPosition;

class LispCharacterFormat
extends ReportFormat {
    boolean seenAt;
    boolean seenColon;
    int count;
    int charVal;

    LispCharacterFormat() {
    }

    public static LispCharacterFormat getInstance(int charVal, int count, boolean seenAt, boolean seenColon) {
        LispCharacterFormat fmt = new LispCharacterFormat();
        fmt.count = count;
        fmt.charVal = charVal;
        fmt.seenAt = seenAt;
        fmt.seenColon = seenColon;
        return fmt;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        int count = LispCharacterFormat.getParam(this.count, 1, args, start);
        if (this.count == -1610612736) {
            ++start;
        }
        char charVal = LispCharacterFormat.getParam(this.charVal, '?', args, start);
        if (this.charVal == -1610612736) {
            ++start;
        }
        while (--count >= 0) {
            LispCharacterFormat.printChar(charVal, this.seenAt, this.seenColon, dst);
        }
        return start;
    }

    public static void printChar(int ch, boolean seenAt, boolean seenColon, Appendable dst) throws IOException {
        if (seenAt) {
            dst.append(Char.toScmReadableString(ch));
        } else if (seenColon) {
            if (ch < 32) {
                dst.append('^');
                dst.append((char)(ch + 64));
            } else if (ch >= 127) {
                dst.append("#\\x");
                dst.append(Integer.toString(ch, 16));
            } else {
                Char.append(ch, dst);
            }
        } else {
            Char.append(ch, dst);
        }
    }
}

