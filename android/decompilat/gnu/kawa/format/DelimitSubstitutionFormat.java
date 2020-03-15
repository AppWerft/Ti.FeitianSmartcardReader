// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import gnu.lists.UnescapedData;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.text.FieldPosition;

public class DelimitSubstitutionFormat extends ReportFormat
{
    public static final char MARK_GROUP_START = '\uf200';
    public static final char MARK_GROUP_END = '\uf201';
    public static final char MARK_SUBSTITUTION_START = '\uf202';
    public static final char MARK_SUBSTITUTION_END = '\uf203';
    public char markGroupStart;
    public char markGroupEnd;
    public char markSubstitutionStart;
    public char markSubstitutionEnd;
    ReportFormat base;
    
    public DelimitSubstitutionFormat(final ReportFormat base) {
        this.markGroupStart = '\uf200';
        this.markGroupEnd = '\uf201';
        this.markSubstitutionStart = '\uf202';
        this.markSubstitutionEnd = '\uf203';
        this.base = base;
    }
    
    public static DelimitSubstitutionFormat getInstance(final ReportFormat base) {
        return new DelimitSubstitutionFormat(base);
    }
    
    @Override
    public int format(final Object[] args, final int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        if (start >= args.length) {
            dst.append("#<missing format argument>");
            return start;
        }
        final Object arg = args[start];
        if (arg instanceof List && !(arg instanceof CharSequence)) {
            dst.append(this.markGroupStart);
            final Object[] tmp = { null };
            for (final Object a : (List)arg) {
                tmp[0] = a;
                this.format1(tmp, 0, dst, fpos);
            }
            dst.append(this.markGroupEnd);
        }
        else {
            this.format1(args, start, dst, fpos);
        }
        return start + 1;
    }
    
    int format1(final Object[] args, int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        final Object arg = args[start];
        if (arg instanceof UnescapedData) {
            dst.append(((UnescapedData)arg).getData());
            ++start;
        }
        else {
            dst.append(this.markSubstitutionStart);
            start = this.base.format(args, start, dst, fpos);
            dst.append(this.markSubstitutionEnd);
        }
        return start;
    }
}
