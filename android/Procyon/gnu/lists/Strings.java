// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.UnsupportedEncodingException;
import java.io.IOException;

public class Strings
{
    public static int characterAt(final CharSequence cseq, final int index) {
        return characterAt(cseq, 0, cseq.length(), index);
    }
    
    public static int characterAt(final CharSequence cseq, final int start, final int end, final int index) {
        if (index < start || index >= end) {
            throw new IndexOutOfBoundsException();
        }
        final char ch1 = cseq.charAt(index);
        if (ch1 >= '\ud800' && ch1 <= '\udbff') {
            if (index + 1 < end) {
                final char ch2 = cseq.charAt(index + 1);
                if (ch2 >= '\udc00' && ch2 <= '\udfff') {
                    return (ch1 - '\ud800' << 10) + (ch2 - '\udc00') + 65536;
                }
            }
        }
        else if (ch1 >= '\udc00' && ch1 <= '\udfff' && index > start) {
            final char ch3 = cseq.charAt(index - 1);
            if (ch3 >= '\ud800' && ch3 <= '\udbff') {
                return 2097151;
            }
        }
        return ch1;
    }
    
    public static int sizeInCodePoints(final CharSequence str) {
        final int len = str.length();
        int nsurr = 0;
        int i = 0;
        while (i < len) {
            final char ch = str.charAt(i++);
            if (ch >= '\ud800' && ch <= '\udbff' && i < len) {
                final int next = str.charAt(i);
                if (next < 56320 || next > 57343) {
                    continue;
                }
                ++i;
                ++nsurr;
            }
        }
        return len - nsurr;
    }
    
    public static void makeUpperCase(final CharSeq str) {
        int i = str.length();
        while (--i >= 0) {
            str.setCharAt(i, Character.toUpperCase(str.charAt(i)));
        }
    }
    
    public static void makeLowerCase(final CharSeq str) {
        int i = str.length();
        while (--i >= 0) {
            str.setCharAt(i, Character.toLowerCase(str.charAt(i)));
        }
    }
    
    public static void makeCapitalize(final CharSeq str) {
        char prev = ' ';
        for (int len = str.length(), i = 0; i < len; ++i) {
            char ch = str.charAt(i);
            if (!Character.isLetterOrDigit(prev)) {
                ch = Character.toTitleCase(ch);
            }
            else {
                ch = Character.toLowerCase(ch);
            }
            str.setCharAt(i, ch);
            prev = ch;
        }
    }
    
    public static String toJson(final CharSequence str) {
        final StringBuilder sbuf = new StringBuilder();
        printQuoted(str, sbuf, 3);
        return sbuf.toString();
    }
    
    public static void printJson(final CharSequence str, final Appendable ps) {
        printQuoted(str, ps, 3);
    }
    
    public static void printQuoted(final CharSequence str, final Appendable ps, final int escapes) {
        final int len = str.length();
        try {
            ps.append('\"');
            for (int i = 0; i < len; ++i) {
                final char ch = str.charAt(i);
                if (ch == '\\' || ch == '\"') {
                    ps.append('\\');
                }
                else if (escapes > 0) {
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
                    if (escapes >= 3 && (ch < ' ' || ch >= '\u007f')) {
                        ps.append("\\u");
                        final int d = ch;
                        for (int k = 12; k >= 0; k -= 4) {
                            ps.append(Character.forDigit(d >> k & 0xF, 16));
                        }
                        continue;
                    }
                    if (ch < ' ' || (escapes > 1 && ch >= '\u007f')) {
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
    
    public static void copyInto(final CharSequence src, final int start, final int end, final CharSeq dst, final int at) {
        final int dstLen = dst.length();
        final int srcLen = src.length();
        if (at < 0 || at > dstLen || start < 0 || end > srcLen || end < start || dstLen - at < end - start) {
            throw new StringIndexOutOfBoundsException();
        }
        if (at < start) {
            int i = at;
            for (int j = start; j < end; ++j) {
                dst.setCharAt(i, src.charAt(j));
                ++i;
            }
        }
        else {
            int i = at + end - start;
            int j = end;
            while (--j >= start) {
                dst.setCharAt(--i, src.charAt(j));
            }
        }
    }
    
    public static CharSequence indirectIndexed(final CharSequence base, final IntSequence indexes) {
        if (indexes instanceof Range.IntRange) {
            final Range.IntRange range = (Range.IntRange)indexes;
            if (range.getStepInt() == 1) {
                final int start = range.getStartInt();
                int end = base.length();
                if (start < 0 || start > end) {
                    throw new IndexOutOfBoundsException();
                }
                if (!range.isUnbounded()) {
                    final int size = range.size();
                    if (start + size < 0 || start + size > end) {
                        throw new IndexOutOfBoundsException();
                    }
                    end = start + size;
                }
                return substring(base, start, end);
            }
        }
        final int len = indexes.size();
        final StringBuilder sbuf = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            sbuf.append(base.charAt(indexes.getInt(i)));
        }
        return sbuf.toString();
    }
    
    public static CharSequence substring(final CharSequence base, final int start, final int end) {
        if (base instanceof FString) {
            final FString fstr = (FString)base;
            if (fstr.isVerySimple() || fstr.isSubRange()) {
                return (CharSequence)Sequences.copy(fstr, start, end, false);
            }
        }
        if (base instanceof String) {
            return ((String)base).substring(start, end);
        }
        final int len = end - start;
        final StringBuilder sbuf = new StringBuilder(len);
        if (base instanceof CharSeq) {
            try {
                ((CharSeq)base).writeTo(start, len, sbuf);
                return sbuf.toString();
            }
            catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        }
        for (int i = start; i < end; ++i) {
            sbuf.append(base.charAt(i));
        }
        return sbuf.toString();
    }
    
    public static String toUtf8(final byte[] bytes, final int start, final int length) {
        try {
            return new String(bytes, start, length, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
