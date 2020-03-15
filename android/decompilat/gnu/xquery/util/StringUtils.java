// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import gnu.kawa.io.URIPath;
import gnu.kawa.xml.XIntegerType;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.xml.TextUtils;
import gnu.math.IntNum;
import gnu.mapping.WrongType;
import gnu.kawa.io.Path;
import java.net.URI;
import gnu.kawa.xml.UntypedAtomic;
import gnu.mapping.Values;
import gnu.kawa.xml.KNode;

public class StringUtils
{
    private static String ERROR_VALUE;
    
    static String coerceToString(Object arg, final String functionName, final int iarg, final String onEmpty) {
        if (arg instanceof KNode) {
            arg = KNode.atomicValue(arg);
        }
        if ((arg == Values.empty || arg == null) && onEmpty != StringUtils.ERROR_VALUE) {
            return onEmpty;
        }
        if (arg instanceof UntypedAtomic || arg instanceof CharSequence || arg instanceof URI || arg instanceof Path) {
            return arg.toString();
        }
        throw new WrongType(functionName, iarg, arg, (onEmpty == StringUtils.ERROR_VALUE) ? "xs:string" : "xs:string?");
    }
    
    public static Object lowerCase(final Object node) {
        return coerceToString(node, "lower-case", 1, "").toLowerCase();
    }
    
    public static Object upperCase(final Object node) {
        return coerceToString(node, "upper-case", 1, "").toUpperCase();
    }
    
    public static double asDouble(Object value) {
        if (!(value instanceof Number)) {
            value = NumberValue.numberValue(value);
        }
        return ((Number)value).doubleValue();
    }
    
    public static Object substring(final Object str, final Object start) {
        final double d1 = asDouble(start);
        if (Double.isNaN(d1)) {
            return "";
        }
        int i = (int)(d1 - 0.5);
        if (i < 0) {
            i = 0;
        }
        final String s = coerceToString(str, "substring", 1, "");
        final int len = s.length();
        int offset = 0;
        while (--i >= 0) {
            if (offset >= len) {
                return "";
            }
            final char ch = s.charAt(offset++);
            if (ch < '\ud800' || ch >= '\udc00' || offset >= len) {
                continue;
            }
            ++offset;
        }
        return s.substring(offset);
    }
    
    public static Object substring(final Object str, final Object start, final Object length) {
        final String s = coerceToString(str, "substring", 1, "");
        final int len = s.length();
        double d1 = Math.floor(asDouble(start) - 0.5);
        double d2 = d1 + Math.floor(asDouble(length) + 0.5);
        if (d1 <= 0.0) {
            d1 = 0.0;
        }
        if (d2 > len) {
            d2 = len;
        }
        if (d2 <= d1) {
            return "";
        }
        int i1 = (int)d1;
        int i2 = (int)d2 - i1;
        int offset = 0;
        while (--i1 >= 0) {
            if (offset >= len) {
                return "";
            }
            final char ch = s.charAt(offset++);
            if (ch < '\ud800' || ch >= '\udc00' || offset >= len) {
                continue;
            }
            ++offset;
        }
        i1 = offset;
        while (--i2 >= 0) {
            if (offset >= len) {
                return "";
            }
            final char ch = s.charAt(offset++);
            if (ch < '\ud800' || ch >= '\udc00' || offset >= len) {
                continue;
            }
            ++offset;
        }
        i2 = offset;
        return s.substring(i1, i2);
    }
    
    public static Object stringLength(final Object str) {
        final String s = coerceToString(str, "string-length", 1, "");
        final int slen = s.length();
        int len = 0;
        int i = 0;
        while (i < slen) {
            final char ch = s.charAt(i++);
            if (ch >= '\ud800' && ch < '\udc00' && i < slen) {
                ++i;
            }
            ++len;
        }
        return IntNum.make(len);
    }
    
    public static Object substringBefore(final Object str, final Object find) {
        final String s = coerceToString(str, "substring-before", 1, "");
        final String f = coerceToString(find, "substring-before", 2, "");
        final int flen = f.length();
        if (flen == 0) {
            return "";
        }
        final int start = s.indexOf(f);
        return (start >= 0) ? s.substring(0, start) : "";
    }
    
    public static Object substringAfter(final Object str, final Object find) {
        final String s = coerceToString(str, "substring-after", 1, "");
        final String f = coerceToString(find, "substring-after", 2, "");
        final int flen = f.length();
        if (flen == 0) {
            return s;
        }
        final int start = s.indexOf(f);
        return (start >= 0) ? s.substring(start + flen) : "";
    }
    
    public static Object translate(final Object str, Object map, Object trans) {
        final String sv = coerceToString(str, "translate", 1, "");
        map = KNode.atomicValue(map);
        if (!(map instanceof UntypedAtomic) && !(map instanceof String)) {
            throw new WrongType("translate", 2, str, "xs:string");
        }
        final String m = map.toString();
        final int mlen = m.length();
        trans = KNode.atomicValue(trans);
        if (!(trans instanceof UntypedAtomic) && !(trans instanceof String)) {
            throw new WrongType("translate", 3, str, "xs:string");
        }
        final String t = trans.toString();
        if (mlen == 0) {
            return sv;
        }
        final int slen = sv.length();
        final StringBuffer s = new StringBuffer(slen);
        final int tlen = t.length();
        int i = 0;
    Label_0129:
        while (i < slen) {
            char c1 = sv.charAt(i++);
            char c2 = '\0';
            if (c1 >= '\ud800' && c1 < '\udc00' && i < slen) {
                c2 = sv.charAt(i++);
            }
            int j = 0;
            int mi = 0;
        Label_0349:
            while (mi < mlen) {
                final char m2 = m.charAt(mi++);
                char m3 = '\0';
                if (m2 >= '\ud800' && m2 < '\udc00' && mi < mlen) {
                    m3 = m.charAt(mi++);
                }
                if (m2 == c1 && m3 == c2) {
                    int ti = 0;
                    while (ti < tlen) {
                        final char t2 = t.charAt(ti++);
                        char t3 = '\0';
                        if (t2 >= '\ud800' && t2 < '\udc00' && ti < tlen) {
                            t3 = t.charAt(ti++);
                        }
                        if (j == 0) {
                            c1 = t2;
                            c2 = t3;
                            break Label_0349;
                        }
                        --j;
                    }
                    continue Label_0129;
                }
                ++j;
            }
            s.append(c1);
            if (c2 != '\0') {
                s.append(c2);
            }
        }
        return s.toString();
    }
    
    public static Object stringPad(final Object str, final Object padcount) {
        final int count = ((Number)NumberValue.numberValue(padcount)).intValue();
        if (count > 0) {
            final String sv = coerceToString(str, "string-pad", 1, "");
            final int slen = sv.length();
            final StringBuffer s = new StringBuffer(count * slen);
            for (int i = 0; i < count; ++i) {
                s.append(sv);
            }
            return s.toString();
        }
        if (count == 0) {
            return "";
        }
        throw new IndexOutOfBoundsException("Invalid string-pad count");
    }
    
    public static Object contains(final Object str, final Object contain) {
        final String s = coerceToString(str, "contains", 1, "");
        final String c = coerceToString(contain, "contains", 2, "");
        return (s.indexOf(c) < 0) ? Boolean.FALSE : Boolean.TRUE;
    }
    
    public static Object startsWith(final Object str, final Object with) {
        final String s = coerceToString(str, "starts-with", 1, "");
        final String w = coerceToString(with, "starts-with", 2, "");
        return s.startsWith(w) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public static Object endsWith(final Object str, final Object with) {
        final String s = coerceToString(str, "ends-with", 1, "");
        final String w = coerceToString(with, "ends-with", 2, "");
        return s.endsWith(w) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public static Object stringJoin(final Object strseq, final Object join) {
        final StringBuffer s = new StringBuffer();
        final String glue = coerceToString(join, "string-join", 2, StringUtils.ERROR_VALUE);
        final int glen = glue.length();
        int index = 0;
        boolean started = false;
        int next;
        while ((next = Values.nextIndex(strseq, index)) >= 0) {
            final Object obj = Values.nextValue(strseq, index);
            if (obj == Values.empty) {
                continue;
            }
            if (started && glen > 0) {
                s.append(glue);
            }
            s.append(TextUtils.stringValue(obj));
            started = true;
            index = next;
        }
        return s.toString();
    }
    
    public static String concat$V(Object arg1, Object arg2, final Object[] args) {
        arg1 = SequenceUtils.coerceToZeroOrOne(arg1, "concat", 1);
        final String str1 = TextUtils.stringValue(arg1);
        arg2 = SequenceUtils.coerceToZeroOrOne(arg2, "concat", 2);
        final String str2 = TextUtils.stringValue(arg2);
        final StringBuilder result = new StringBuilder(str1);
        result.append(str2);
        for (int count = args.length, i = 0; i < count; ++i) {
            final Object arg3 = SequenceUtils.coerceToZeroOrOne(args[i], "concat", i + 2);
            result.append(TextUtils.stringValue(arg3));
        }
        return result.toString();
    }
    
    public static Object compare(final Object val1, final Object val2, NamedCollator coll) {
        if (val1 == Values.empty || val1 == null || val2 == Values.empty || val2 == null) {
            return Values.empty;
        }
        if (coll == null) {
            coll = NamedCollator.codepointCollation;
        }
        final int ret = coll.compare(val1.toString(), val2.toString());
        return (ret < 0) ? IntNum.minusOne() : ((ret > 0) ? IntNum.one() : IntNum.zero());
    }
    
    public static void stringToCodepoints$X(final Object arg, final CallContext ctx) {
        final String str = coerceToString(arg, "string-to-codepoints", 1, "");
        final int len = str.length();
        final Consumer out = ctx.consumer;
        int i = 0;
        while (i < len) {
            int ch = str.charAt(i++);
            if (ch >= 55296 && ch < 56320 && i < len) {
                ch = (ch - 55296) * 1024 + (str.charAt(i++) - '\udc00') + 65536;
            }
            out.writeInt(ch);
        }
    }
    
    private static void appendCodepoint(final Object code, final StringBuffer sbuf) {
        final IntNum I = (IntNum)XIntegerType.integerType.cast(code);
        int i = I.intValue();
        if (i <= 0 || (i > 55295 && (i < 57344 || (i > 65533 && i < 65536) || i > 1114111))) {
            throw new IllegalArgumentException("codepoints-to-string: " + i + " is not a valid XML character [FOCH0001]");
        }
        if (i >= 65536) {
            sbuf.append((char)((i - 65536 >> 10) + 55296));
            i = (i & 0x3FF) + 56320;
        }
        sbuf.append((char)i);
    }
    
    public static String codepointsToString(final Object arg) {
        if (arg == null) {
            return "";
        }
        final StringBuffer sbuf = new StringBuffer();
        if (arg instanceof Values) {
            final Values vals = (Values)arg;
            int ipos = vals.startPos();
            while ((ipos = vals.nextPos(ipos)) != 0) {
                appendCodepoint(vals.getPosPrevious(ipos), sbuf);
            }
        }
        else {
            appendCodepoint(arg, sbuf);
        }
        return sbuf.toString();
    }
    
    public static String encodeForUri(final Object arg) {
        final String str = coerceToString(arg, "encode-for-uri", 1, "");
        return URIPath.encodeForUri(str, 'U');
    }
    
    public static String iriToUri(final Object arg) {
        final String str = coerceToString(arg, "iri-to-uru", 1, "");
        return URIPath.encodeForUri(str, 'I');
    }
    
    public static String escapeHtmlUri(final Object arg) {
        final String str = coerceToString(arg, "escape-html-uri", 1, "");
        return URIPath.encodeForUri(str, 'H');
    }
    
    public static String normalizeSpace(final Object arg) {
        final String str = coerceToString(arg, "normalize-space", 1, "");
        final int len = str.length();
        StringBuffer sbuf = null;
        int skipped = 0;
        for (int i = 0; i < len; ++i) {
            final char ch = str.charAt(i);
            if (Character.isWhitespace(ch)) {
                if (sbuf == null && skipped == 0 && i > 0) {
                    sbuf = new StringBuffer(str.substring(0, i));
                }
                ++skipped;
            }
            else {
                if (skipped > 0) {
                    if (sbuf != null) {
                        sbuf.append(' ');
                    }
                    else if (skipped > 1 || i == 1 || str.charAt(i - 1) != ' ') {
                        sbuf = new StringBuffer();
                    }
                    skipped = 0;
                }
                if (sbuf != null) {
                    sbuf.append(ch);
                }
            }
        }
        return (sbuf != null) ? sbuf.toString() : ((skipped > 0) ? "" : str);
    }
    
    public static Pattern makePattern(String pattern, final String flags) {
        int fl = 0;
        int i = flags.length();
        while (--i >= 0) {
            final char ch = flags.charAt(i);
            switch (ch) {
                case 'i': {
                    fl |= 0x42;
                    continue;
                }
                case 's': {
                    fl |= 0x20;
                    continue;
                }
                case 'x': {
                    final StringBuffer sbuf = new StringBuffer();
                    final int plen = pattern.length();
                    int inBracket = 0;
                    int j = 0;
                    while (j < plen) {
                        char pch = pattern.charAt(j++);
                        if (pch == '\\' && j < plen) {
                            sbuf.append(pch);
                            pch = pattern.charAt(j++);
                        }
                        else if (pch == '[') {
                            ++inBracket;
                        }
                        else if (pch == ']') {
                            --inBracket;
                        }
                        else if (inBracket == 0 && Character.isWhitespace(pch)) {
                            continue;
                        }
                        sbuf.append(pch);
                    }
                    pattern = sbuf.toString();
                    continue;
                }
                case 'm': {
                    fl |= 0x8;
                    continue;
                }
                default: {
                    throw new IllegalArgumentException("unknown 'replace' flag");
                }
            }
        }
        if (pattern.indexOf("{Is") >= 0) {
            final StringBuffer sbuf2 = new StringBuffer();
            final int plen2 = pattern.length();
            int k = 0;
            while (k < plen2) {
                char pch2 = pattern.charAt(k++);
                if (pch2 == '\\' && k + 4 < plen2) {
                    sbuf2.append(pch2);
                    pch2 = pattern.charAt(k++);
                    sbuf2.append(pch2);
                    if ((pch2 != 'p' && pch2 != 'P') || pattern.charAt(k) != '{' || pattern.charAt(k + 1) != 'I' || pattern.charAt(k + 2) != 's') {
                        continue;
                    }
                    sbuf2.append('{');
                    sbuf2.append('I');
                    sbuf2.append('n');
                    k += 3;
                }
                else {
                    sbuf2.append(pch2);
                }
            }
            pattern = sbuf2.toString();
        }
        return Pattern.compile(pattern, fl);
    }
    
    public static boolean matches(final Object input, final String pattern) {
        return matches(input, pattern, "");
    }
    
    public static boolean matches(final Object arg, final String pattern, final String flags) {
        final String str = coerceToString(arg, "matches", 1, "");
        return makePattern(pattern, flags).matcher(str).find();
    }
    
    public static String replace(final Object input, final String pattern, final String replacement) {
        return replace(input, pattern, replacement, "");
    }
    
    public static String replace(final Object arg, final String pattern, final String replacement, final String flags) {
        final String str = coerceToString(arg, "replace", 1, "");
        final int rlen = replacement.length();
        int i = 0;
        while (i < rlen) {
            char rch = replacement.charAt(i++);
            if (rch == '\\' && (i >= rch || ((rch = replacement.charAt(i++)) != '\\' && rch != '$'))) {
                throw new IllegalArgumentException("invalid replacement string [FORX0004]");
            }
        }
        return makePattern(pattern, flags).matcher(str).replaceAll(replacement);
    }
    
    public static void tokenize$X(final Object arg, final String pattern, final CallContext ctx) {
        tokenize$X(arg, pattern, "", ctx);
    }
    
    public static void tokenize$X(final Object arg, final String pattern, final String flags, final CallContext ctx) {
        final String str = coerceToString(arg, "tokenize", 1, "");
        final Consumer out = ctx.consumer;
        final Matcher matcher = makePattern(pattern, flags).matcher(str);
        final int len = str.length();
        if (len == 0) {
            return;
        }
        int start = 0;
        while (true) {
            final boolean matched = matcher.find();
            if (!matched) {
                out.writeObject(str.substring(start));
                return;
            }
            final int end = matcher.start();
            out.writeObject(str.substring(start, end));
            start = matcher.end();
            if (start == end) {
                throw new IllegalArgumentException("pattern matches empty string");
            }
        }
    }
    
    public static Object codepointEqual(final Object arg1, final Object arg2) {
        final String str1 = coerceToString(arg1, "codepoint-equal", 1, null);
        final String str2 = coerceToString(arg2, "codepoint-equal", 2, null);
        if (str1 == null || str2 == null) {
            return Values.empty;
        }
        return str1.equals(str2) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public static Object normalizeUnicode(final Object arg) {
        return normalizeUnicode(arg, "NFC");
    }
    
    public static Object normalizeUnicode(final Object arg, String form) {
        final String str = coerceToString(arg, "normalize-unicode", 1, "");
        form = form.trim().toUpperCase();
        if ("".equals(form)) {
            return str;
        }
        throw new UnsupportedOperationException("normalize-unicode: unicode string normalization not available");
    }
    
    static {
        StringUtils.ERROR_VALUE = "<error>";
    }
}
