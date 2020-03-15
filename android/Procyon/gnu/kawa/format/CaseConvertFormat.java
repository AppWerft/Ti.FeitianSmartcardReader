// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;

public class CaseConvertFormat extends ReportFormat
{
    char code;
    Format baseFormat;
    
    public CaseConvertFormat(final Format baseFormat, final char action) {
        this.baseFormat = baseFormat;
        this.code = action;
    }
    
    public Format getBaseFormat() {
        return this.baseFormat;
    }
    
    public void setBaseFormat(final Format baseFormat) {
        this.baseFormat = baseFormat;
    }
    
    @Override
    public int format(final Object[] args, final int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final StringBuffer sbuf = new StringBuffer(100);
        final int result = ReportFormat.format(this.baseFormat, args, start, sbuf, fpos);
        final int len = sbuf.length();
        char prev = ' ';
        for (int i = 0; i < len; ++i) {
            char ch = sbuf.charAt(i);
            if (this.code == 'U') {
                ch = Character.toUpperCase(ch);
            }
            else if ((this.code == 'T' && i == 0) || (this.code == 'C' && !Character.isLetterOrDigit(prev))) {
                ch = Character.toTitleCase(ch);
            }
            else {
                ch = Character.toLowerCase(ch);
            }
            prev = ch;
            dst.append(ch);
        }
        return result;
    }
}
