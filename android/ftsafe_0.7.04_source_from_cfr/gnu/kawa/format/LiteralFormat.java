/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.format.ReportFormat;
import gnu.lists.Strings;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.ParsePosition;

public class LiteralFormat
extends ReportFormat {
    String text;
    public static final LiteralFormat separator = new LiteralFormat("");

    public LiteralFormat(char[] text) {
        this.text = String.valueOf(text);
    }

    public LiteralFormat(String text) {
        this.text = text;
    }

    public LiteralFormat(StringBuffer sbuf) {
        this(sbuf.toString());
    }

    @Override
    public int format(Object[] args, int start, Appendable dst, FieldPosition fpos) throws IOException {
        dst.append(this.text);
        return start;
    }

    @Override
    public Object parseObject(String text, ParsePosition status) {
        throw new Error("LiteralFormat.parseObject - not implemented");
    }

    public String content() {
        return this.text;
    }

    public String toString() {
        StringBuilder sbuf = new StringBuilder("LiteralFormat[");
        Strings.printQuoted(this.text, sbuf, 1);
        sbuf.append(']');
        return sbuf.toString();
    }
}

