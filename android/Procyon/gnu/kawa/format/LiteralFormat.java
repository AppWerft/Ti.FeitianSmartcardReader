// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import gnu.lists.Strings;
import java.text.ParsePosition;
import java.io.IOException;
import java.text.FieldPosition;

public class LiteralFormat extends ReportFormat
{
    String text;
    public static final LiteralFormat separator;
    
    public LiteralFormat(final char[] text) {
        this.text = String.valueOf(text);
    }
    
    public LiteralFormat(final String text) {
        this.text = text;
    }
    
    public LiteralFormat(final StringBuffer sbuf) {
        this(sbuf.toString());
    }
    
    @Override
    public int format(final Object[] args, final int start, final Appendable dst, final FieldPosition fpos) throws IOException {
        dst.append(this.text);
        return start;
    }
    
    @Override
    public Object parseObject(final String text, final ParsePosition status) {
        throw new Error("LiteralFormat.parseObject - not implemented");
    }
    
    public String content() {
        return this.text;
    }
    
    @Override
    public String toString() {
        final StringBuilder sbuf = new StringBuilder("LiteralFormat[");
        Strings.printQuoted(this.text, sbuf, 1);
        sbuf.append(']');
        return sbuf.toString();
    }
    
    static {
        separator = new LiteralFormat("");
    }
}
