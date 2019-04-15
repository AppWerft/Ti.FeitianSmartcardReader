/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.lists.IntSequence;
import gnu.lists.Range;
import gnu.lists.Sequences;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Strings {
    public static int characterAt(CharSequence cseq, int index) {
        return Strings.characterAt(cseq, 0, cseq.length(), index);
    }

    public static int characterAt(CharSequence cseq, int start, int end, int index) {
        char ch0;
        if (index < start || index >= end) {
            throw new IndexOutOfBoundsException();
        }
        char ch1 = cseq.charAt(index);
        if (ch1 >= '\ud800' && ch1 <= '\udbff') {
            char ch2;
            if (index + 1 < end && (ch2 = cseq.charAt(index + 1)) >= '\udc00' && ch2 <= '\udfff') {
                return (ch1 - 55296 << 10) + (ch2 - 56320) + 65536;
            }
        } else if (ch1 >= '\udc00' && ch1 <= '\udfff' && index > start && (ch0 = cseq.charAt(index - 1)) >= '\ud800' && ch0 <= '\udbff') {
            return 2097151;
        }
        return ch1;
    }

    public static int sizeInCodePoints(CharSequence str) {
        int len = str.length();
        int nsurr = 0;
        int i = 0;
        while (i < len) {
            char ch;
            char next;
            if ((ch = str.charAt(i++)) < '\ud800' || ch > '\udbff' || i >= len || (next = str.charAt(i)) < '\udc00' || next > '\udfff') continue;
            ++i;
            ++nsurr;
        }
        return len - nsurr;
    }

    public static void makeUpperCase(CharSeq str) {
        int i = str.length();
        while (--i >= 0) {
            str.setCharAt(i, Character.toUpperCase(str.charAt(i)));
        }
    }

    public static void makeLowerCase(CharSeq str) {
        int i = str.length();
        while (--i >= 0) {
            str.setCharAt(i, Character.toLowerCase(str.charAt(i)));
        }
    }

    public static void makeCapitalize(CharSeq str) {
        char prev = ' ';
        int len = str.length();
        for (int i = 0; i < len; ++i) {
            char ch = str.charAt(i);
            ch = !Character.isLetterOrDigit(prev) ? Character.toTitleCase(ch) : Character.toLowerCase(ch);
            str.setCharAt(i, ch);
            prev = ch;
        }
    }

    public static String toJson(CharSequence str) {
        StringBuilder sbuf = new StringBuilder();
        Strings.printQuoted(str, sbuf, 3);
        return sbuf.toString();
    }

    public static void printJson(CharSequence str, Appendable ps) {
        Strings.printQuoted(str, ps, 3);
    }

    public static void printQuoted(CharSequence str, Appendable ps, int escapes) {
        int len = str.length();
        try {
            ps.append('\"');
            for (int i = 0; i < len; ++i) {
                char ch = str.charAt(i);
                if (ch == '\\' || ch == '\"') {
                    ps.append('\\');
                } else if (escapes > 0) {
                    if (ch == '\n') {
                        ps.append("\\n");
                        continue;
                    }
                    if (ch == '\r') {
                        ps.append("\\r");
                        continue;
                    }
                    if (ch == '\t') {
                        ps.append("\\t");
                        continue;
                    }
                    if (ch == '\u0007' && escapes < 3) {
                        ps.append("\\a");
                        continue;
                    }
                    if (ch == '\b') {
                        ps.append("\\b");
                        continue;
                    }
                    if (ch == '\u000b' && escapes < 3) {
                        ps.append("\\v");
                        continue;
                    }
                    if (ch == '\f') {
                        ps.append("\\f");
                        continue;
                    }
                    if (escapes >= 3 && (ch < ' ' || ch >= '')) {
                        ps.append("\\u");
                        char d = ch;
                        for (int k = 12; k >= 0; k -= 4) {
                            ps.append(Character.forDigit(d >> k & 15, 16));
                        }
                        continue;
                    }
                    if (ch < ' ' || escapes > 1 && ch >= '') {
                        ps.append("\\x");
                        ps.append(Integer.toHexString(ch));
                        ps.append(';');
                        continue;
                    }
                }
                ps.append(ch);
            }
            ps.append('\"');
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void copyInto(CharSequence src, int start, int end, CharSeq dst, int at) {
        int dstLen = dst.length();
        int srcLen = src.length();
        if (at < 0 || at > dstLen || start < 0 || end > srcLen || end < start || dstLen - at < end - start) {
            throw new StringIndexOutOfBoundsException();
        }
        if (at < start) {
            int i = at;
            for (int j = start; j < end; ++j) {
                dst.setCharAt(i, src.charAt(j));
                ++i;
            }
        } else {
            int i = at + end - start;
            int j = end;
            while (--j >= start) {
                dst.setCharAt(--i, src.charAt(j));
            }
        }
    }

    public static CharSequence indirectIndexed(CharSequence base2, IntSequence indexes) {
        Range.IntRange range;
        if (indexes instanceof Range.IntRange && (range = (Range.IntRange)indexes).getStepInt() == 1) {
            int start = range.getStartInt();
            int end = base2.length();
            if (start < 0 || start > end) {
                throw new IndexOutOfBoundsException();
            }
            if (!range.isUnbounded()) {
                int size = range.size();
                if (start + size < 0 || start + size > end) {
                    throw new IndexOutOfBoundsException();
                }
                end = start + size;
            }
            return Strings.substring(base2, start, end);
        }
        int len = indexes.size();
        StringBuilder sbuf = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            sbuf.append(base2.charAt(indexes.getInt(i)));
        }
        return sbuf.toString();
    }

    public static CharSequence substring(CharSequence base2, int start, int end) {
        FString fstr;
        if (base2 instanceof FString && ((fstr = (FString)base2).isVerySimple() || fstr.isSubRange())) {
            return (CharSequence)((Object)Sequences.copy(fstr, start, end, false));
        }
        if (base2 instanceof String) {
            return ((String)base2).substring(start, end);
        }
        int len = end - start;
        StringBuilder sbuf = new StringBuilder(len);
        if (base2 instanceof CharSeq) {
            try {
                ((CharSeq)base2).writeTo(start, len, sbuf);
            }
            catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        } else {
            for (int i = start; i < end; ++i) {
                sbuf.append(base2.charAt(i));
            }
        }
        return sbuf.toString();
    }

    public static String toUtf8(byte[] bytes, int start, int length) {
        try {
            return new String(bytes, start, length, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
}

