/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.format.ReportFormat;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;

public class CaseConvertFormat
extends ReportFormat {
    char code;
    Format baseFormat;

    public CaseConvertFormat(Format baseFormat, char action) {
        this.baseFormat = baseFormat;
        this.code = action;
    }

    public Format getBaseFormat() {
        return this.baseFormat;
    }

    public void setBaseFormat(Format baseFormat) {
        this.baseFormat = baseFormat;
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        StringBuffer sbuf = new StringBuffer(100);
        int result = CaseConvertFormat.format(this.baseFormat, args, start, sbuf, fpos);
        int len = sbuf.length();
        char prev = ' ';
        for (int i = 0; i < len; ++i) {
            char ch = sbuf.charAt(i);
            ch = this.code == 'U' ? Character.toUpperCase(ch) : (this.code == 'T' && i == 0 || this.code == 'C' && !Character.isLetterOrDigit(prev) ? Character.toTitleCase(ch) : Character.toLowerCase(ch));
            prev = ch;
            dst.append(ch);
        }
        return result;
    }
}

