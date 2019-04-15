/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.format.ReportFormat;
import gnu.lists.UnescapedData;
import java.io.IOException;
import java.text.FieldPosition;
import java.util.List;

public class DelimitSubstitutionFormat
extends ReportFormat {
    public static final char MARK_GROUP_START = '\uf200';
    public static final char MARK_GROUP_END = '\uf201';
    public static final char MARK_SUBSTITUTION_START = '\uf202';
    public static final char MARK_SUBSTITUTION_END = '\uf203';
    public char markGroupStart = (char)61952;
    public char markGroupEnd = (char)61953;
    public char markSubstitutionStart = (char)61954;
    public char markSubstitutionEnd = (char)61955;
    ReportFormat base;

    public DelimitSubstitutionFormat(ReportFormat base2) {
        this.base = base2;
    }

    public static DelimitSubstitutionFormat getInstance(ReportFormat base2) {
        return new DelimitSubstitutionFormat(base2);
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        if (start >= args.length) {
            dst.append("#<missing format argument>");
            return start;
        }
        Object arg = args[start];
        if (arg instanceof List && !(arg instanceof CharSequence)) {
            dst.append(this.markGroupStart);
            Object[] tmp = new Object[1];
            for (Object a : (List)arg) {
                tmp[0] = a;
                this.format1(tmp, 0, dst, fpos);
            }
            dst.append(this.markGroupEnd);
        } else {
            this.format1(args, start, dst, fpos);
        }
        return start + 1;
    }

    int format1(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        Object arg = args[start];
        if (arg instanceof UnescapedData) {
            dst.append(((UnescapedData)arg).getData());
            ++start;
        } else {
            dst.append(this.markSubstitutionStart);
            start = this.base.format(args, start, dst, fpos);
            dst.append(this.markSubstitutionEnd);
        }
        return start;
    }
}

