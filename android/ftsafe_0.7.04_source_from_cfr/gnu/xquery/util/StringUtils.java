/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XIntegerType;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.xml.TextUtils;
import gnu.xquery.util.NamedCollator;
import gnu.xquery.util.NumberValue;
import gnu.xquery.util.SequenceUtils;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private static String ERROR_VALUE = "<error>";

    static String coerceToString(Object arg, String functionName, int iarg, String onEmpty) {
        if (arg instanceof KNode) {
            arg = KNode.atomicValue(arg);
        }
        if ((arg == Values.empty || arg == null) && onEmpty != ERROR_VALUE) {
            return onEmpty;
        }
        if (arg instanceof UntypedAtomic || arg instanceof CharSequence || arg instanceof URI || arg instanceof Path) {
            return arg.toString();
        }
        throw new WrongType(functionName, iarg, arg, onEmpty == ERROR_VALUE ? "xs:string" : "xs:string?");
    }

    public static Object lowerCase(Object node) {
        return StringUtils.coerceToString(node, "lower-case", 1, "").toLowerCase();
    }

    public static Object upperCase(Object node) {
        return StringUtils.coerceToString(node, "upper-case", 1, "").toUpperCase();
    }

    public static double asDouble(Object value) {
        if (!(value instanceof Number)) {
            value = NumberValue.numberValue(value);
        }
        return ((Number)value).doubleValue();
    }

    public static Object substring(Object str, Object start) {
        double d1 = StringUtils.asDouble(start);
        if (Double.isNaN(d1)) {
            return "";
        }
        int i = (int)(d1 - 0.5);
        if (i < 0) {
            i = 0;
        }
        String s = StringUtils.coerceToString(str, "substring", 1, "");
        int len = s.length();
        int offset = 0;
        while (--i >= 0) {
            char ch;
            if (offset >= len) {
                return "";
            }
            if ((ch = s.charAt(offset++)) < '\ud800' || ch >= '\udc00' || offset >= len) continue;
            ++offset;
        }
        return s.substring(offset);
    }

    public static Object substring(Object str, Object start, Object length) {
        char ch;
        String s = StringUtils.coerceToString(str, "substring", 1, "");
        int len = s.length();
        double d1 = Math.floor(StringUtils.asDouble(start) - 0.5);
        double d2 = d1 + Math.floor(StringUtils.asDouble(length) + 0.5);
        if (d1 <= 0.0) {
            d1 = 0.0;
        }
        if (d2 > (double)len) {
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
            if ((ch = s.charAt(offset++)) < '\ud800' || ch >= '\udc00' || offset >= len) continue;
            ++offset;
        }
        i1 = offset;
        while (--i2 >= 0) {
            if (offset >= len) {
                return "";
            }
            if ((ch = s.charAt(offset++)) < '\ud800' || ch >= '\udc00' || offset >= len) continue;
            ++offset;
        }
        i2 = offset;
        return s.substring(i1, i2);
    }

    public static Object stringLength(Object str) {
        String s = StringUtils.coerceToString(str, "string-length", 1, "");
        int slen = s.length();
        int len = 0;
        int i = 0;
        while (i < slen) {
            char ch;
            if ((ch = s.charAt(i++)) >= '\ud800' && ch < '\udc00' && i < slen) {
                ++i;
            }
            ++len;
        }
        return IntNum.make(len);
    }

    public static Object substringBefore(Object str, Object find) {
        String s = StringUtils.coerceToString(str, "substring-before", 1, "");
        String f = StringUtils.coerceToString(find, "substring-before", 2, "");
        int flen = f.length();
        if (flen == 0) {
            return "";
        }
        int start = s.indexOf(f);
        return start >= 0 ? s.substring(0, start) : "";
    }

    public static Object substringAfter(Object str, Object find) {
        String s = StringUtils.coerceToString(str, "substring-after", 1, "");
        String f = StringUtils.coerceToString(find, "substring-after", 2, "");
        int flen = f.length();
        if (flen == 0) {
            return s;
        }
        int start = s.indexOf(f);
        return start >= 0 ? s.substring(start + flen) : "";
    }

    public static Object translate(Object str, Object map, Object trans) {
        String sv = StringUtils.coerceToString(str, "translate", 1, "");
        if (!((map = KNode.atomicValue(map)) instanceof UntypedAtomic) && !(map instanceof String)) {
            throw new WrongType("translate", 2, str, "xs:string");
        }
        String m = map.toString();
        int mlen = m.length();
        if (!((trans = KNode.atomicValue(trans)) instanceof UntypedAtomic) && !(trans instanceof String)) {
            throw new WrongType("translate", 3, str, "xs:string");
        }
        String t = trans.toString();
        if (mlen == 0) {
            return sv;
        }
        int slen = sv.length();
        StringBuffer s = new StringBuffer(slen);
        int tlen = t.length();
        int i = 0;
        block0 : while (i < slen) {
            char c1 = sv.charAt(i++);
            char c2 = '\u0000';
            if (c1 >= '\ud800' && c1 < '\udc00' && i < slen) {
                c2 = sv.charAt(i++);
            }
            int j = 0;
            int mi = 0;
            block1 : while (mi < mlen) {
                char m1 = m.charAt(mi++);
                char m2 = '\u0000';
                if (m1 >= '\ud800' && m1 < '\udc00' && mi < mlen) {
                    m2 = m.charAt(mi++);
                }
                if (m1 == c1 && m2 == c2) {
                    int ti = 0;
                    while (ti < tlen) {
                        char t1 = t.charAt(ti++);
                        char t2 = '\u0000';
                        if (t1 >= '\ud800' && t1 < '\udc00' && ti < tlen) {
                            t2 = t.charAt(ti++);
                        }
                        if (j == 0) {
                            c1 = t1;
                            c2 = t2;
                            break block1;
                        }
                        --j;
                    }
                    continue block0;
                }
                ++j;
            }
            s.append(c1);
            if (c2 == '\u0000') continue;
            s.append(c2);
        }
        return s.toString();
    }

    public static Object stringPad(Object str, Object padcount) {
        int count = ((Number)NumberValue.numberValue(padcount)).intValue();
        if (count <= 0) {
            if (count == 0) {
                return "";
            }
            throw new IndexOutOfBoundsException("Invalid string-pad count");
        }
        String sv = StringUtils.coerceToString(str, "string-pad", 1, "");
        int slen = sv.length();
        StringBuffer s = new StringBuffer(count * slen);
        for (int i = 0; i < count; ++i) {
            s.append(sv);
        }
        return s.toString();
    }

    public static Object contains(Object str, Object contain) {
        String c;
        String s = StringUtils.coerceToString(str, "contains", 1, "");
        return s.indexOf(c = StringUtils.coerceToString(contain, "contains", 2, "")) < 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Object startsWith(Object str, Object with) {
        String w;
        String s = StringUtils.coerceToString(str, "starts-with", 1, "");
        return s.startsWith(w = StringUtils.coerceToString(with, "starts-with", 2, "")) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Object endsWith(Object str, Object with) {
        String w;
        String s = StringUtils.coerceToString(str, "ends-with", 1, "");
        return s.endsWith(w = StringUtils.coerceToString(with, "ends-with", 2, "")) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Object stringJoin(Object strseq, Object join) {
        int next;
        StringBuffer s = new StringBuffer();
        String glue = StringUtils.coerceToString(join, "string-join", 2, ERROR_VALUE);
        int glen = glue.length();
        int index = 0;
        boolean started = false;
        while ((next = Values.nextIndex(strseq, index)) >= 0) {
            Object obj = Values.nextValue(strseq, index);
            if (obj == Values.empty) continue;
            if (started && glen > 0) {
                s.append(glue);
            }
            s.append(TextUtils.stringValue(obj));
            started = true;
            index = next;
        }
        return s.toString();
    }

    public static String concat$V(Object arg1, Object arg2, Object[] args) {
        arg1 = SequenceUtils.coerceToZeroOrOne(arg1, "concat", 1);
        String str1 = TextUtils.stringValue(arg1);
        arg2 = SequenceUtils.coerceToZeroOrOne(arg2, "concat", 2);
        String str2 = TextUtils.stringValue(arg2);
        StringBuilder result = new StringBuilder(str1);
        result.append(str2);
        int count = args.length;
        for (int i = 0; i < count; ++i) {
            Object arg = SequenceUtils.coerceToZeroOrOne(args[i], "concat", i + 2);
            result.append(TextUtils.stringValue(arg));
        }
        return result.toString();
    }

    public static Object compare(Object val1, Object val2, NamedCollator coll) {
        int ret;
        if (val1 == Values.empty || val1 == null || val2 == Values.empty || val2 == null) {
            return Values.empty;
        }
        if (coll == null) {
            coll = NamedCollator.codepointCollation;
        }
        return (ret = coll.compare(val1.toString(), val2.toString())) < 0 ? IntNum.minusOne() : (ret > 0 ? IntNum.one() : IntNum.zero());
    }

    public static void stringToCodepoints$X(Object arg, CallContext ctx) {
        String str = StringUtils.coerceToString(arg, "string-to-codepoints", 1, "");
        int len = str.length();
        Consumer out = ctx.consumer;
        int i = 0;
        while (i < len) {
            int ch;
            if ((ch = str.charAt(i++)) >= 55296 && ch < 56320 && i < len) {
                ch = (ch - 55296) * 1024 + (str.charAt(i++) - 56320) + 65536;
            }
            out.writeInt(ch);
        }
    }

    private static void appendCodepoint(Object code, StringBuffer sbuf) {
        IntNum I = (IntNum)XIntegerType.integerType.cast(code);
        int i = I.intValue();
        if (i <= 0 || i > 55295 && (i < 57344 || i > 65533 && i < 65536 || i > 1114111)) {
            throw new IllegalArgumentException("codepoints-to-string: " + i + " is not a valid XML character [FOCH0001]");
        }
        if (i >= 65536) {
            sbuf.append((char)((i - 65536 >> 10) + 55296));
            i = (i & 1023) + 56320;
        }
        sbuf.append((char)i);
    }

    public static String codepointsToString(Object arg) {
        if (arg == null) {
            return "";
        }
        StringBuffer sbuf = new StringBuffer();
        if (arg instanceof Values) {
            Values vals = (Values)arg;
            int ipos = vals.startPos();
            while ((ipos = vals.nextPos(ipos)) != 0) {
                StringUtils.appendCodepoint(vals.getPosPrevious(ipos), sbuf);
            }
        } else {
            StringUtils.appendCodepoint(arg, sbuf);
        }
        return sbuf.toString();
    }

    public static String encodeForUri(Object arg) {
        String str = StringUtils.coerceToString(arg, "encode-for-uri", 1, "");
        return URIPath.encodeForUri(str, 'U');
    }

    public static String iriToUri(Object arg) {
        String str = StringUtils.coerceToString(arg, "iri-to-uru", 1, "");
        return URIPath.encodeForUri(str, 'I');
    }

    public static String escapeHtmlUri(Object arg) {
        String str = StringUtils.coerceToString(arg, "escape-html-uri", 1, "");
        return URIPath.encodeForUri(str, 'H');
    }

    public static String normalizeSpace(Object arg) {
        String str = StringUtils.coerceToString(arg, "normalize-space", 1, "");
        int len = str.length();
        StringBuffer sbuf = null;
        int skipped = 0;
        for (int i = 0; i < len; ++i) {
            char ch = str.charAt(i);
            if (Character.isWhitespace(ch)) {
                if (sbuf == null && skipped == 0 && i > 0) {
                    sbuf = new StringBuffer(str.substring(0, i));
                }
                ++skipped;
                continue;
            }
            if (skipped > 0) {
                if (sbuf != null) {
                    sbuf.append(' ');
                } else if (skipped > 1 || i == 1 || str.charAt(i - 1) != ' ') {
                    sbuf = new StringBuffer();
                }
                skipped = 0;
            }
            if (sbuf == null) continue;
            sbuf.append(ch);
        }
        return sbuf != null ? sbuf.toString() : (skipped > 0 ? "" : str);
    }

    public static Pattern makePattern(String pattern, String flags) {
        int fl = 0;
        int i = flags.length();
        block6 : while (--i >= 0) {
            char ch = flags.charAt(i);
            switch (ch) {
                case 'i': {
                    fl |= 66;
                    continue block6;
                }
                case 's': {
                    fl |= 32;
                    continue block6;
                }
                case 'x': {
                    StringBuffer sbuf = new StringBuffer();
                    int plen = pattern.length();
                    int inBracket = 0;
                    int j = 0;
                    while (j < plen) {
                        char pch;
                        if ((pch = pattern.charAt(j++)) == '\\' && j < plen) {
                            sbuf.append(pch);
                            pch = pattern.charAt(j++);
                        } else if (pch == '[') {
                            ++inBracket;
                        } else if (pch == ']') {
                            --inBracket;
                        } else if (inBracket == 0 && Character.isWhitespace(pch)) continue;
                        sbuf.append(pch);
                    }
                    pattern = sbuf.toString();
                    continue block6;
                }
                case 'm': {
                    fl |= 8;
                    continue block6;
                }
            }
            throw new IllegalArgumentException("unknown 'replace' flag");
        }
        if (pattern.indexOf("{Is") >= 0) {
            StringBuffer sbuf = new StringBuffer();
            int plen = pattern.length();
            int j = 0;
            while (j < plen) {
                char pch;
                if ((pch = pattern.charAt(j++)) == '\\' && j + 4 < plen) {
                    sbuf.append(pch);
                    pch = pattern.charAt(j++);
                    sbuf.append(pch);
                    if (pch != 'p' && pch != 'P' || pattern.charAt(j) != '{' || pattern.charAt(j + 1) != 'I' || pattern.charAt(j + 2) != 's') continue;
                    sbuf.append('{');
                    sbuf.append('I');
                    sbuf.append('n');
                    j += 3;
                    continue;
                }
                sbuf.append(pch);
            }
            pattern = sbuf.toString();
        }
        return Pattern.compile(pattern, fl);
    }

    public static boolean matches(Object input, String pattern) {
        return StringUtils.matches(input, pattern, "");
    }

    public static boolean matches(Object arg, String pattern, String flags) {
        String str = StringUtils.coerceToString(arg, "matches", 1, "");
        return StringUtils.makePattern(pattern, flags).matcher(str).find();
    }

    public static String replace(Object input, String pattern, String replacement) {
        return StringUtils.replace(input, pattern, replacement, "");
    }

    public static String replace(Object arg, String pattern, String replacement, String flags) {
        String str = StringUtils.coerceToString(arg, "replace", 1, "");
        int rlen = replacement.length();
        int i = 0;
        while (i < rlen) {
            char rch;
            if ((rch = replacement.charAt(i++)) != '\\' || i < rch && ((rch = replacement.charAt(i++)) == '\\' || rch == '$')) continue;
            throw new IllegalArgumentException("invalid replacement string [FORX0004]");
        }
        return StringUtils.makePattern(pattern, flags).matcher(str).replaceAll(replacement);
    }

    public static void tokenize$X(Object arg, String pattern, CallContext ctx) {
        StringUtils.tokenize$X(arg, pattern, "", ctx);
    }

    public static void tokenize$X(Object arg, String pattern, String flags, CallContext ctx) {
        Consumer out;
        int start;
        String str;
        block2 : {
            int end;
            str = StringUtils.coerceToString(arg, "tokenize", 1, "");
            out = ctx.consumer;
            Matcher matcher = StringUtils.makePattern(pattern, flags).matcher(str);
            int len = str.length();
            if (len == 0) {
                return;
            }
            start = 0;
            do {
                boolean matched;
                if (!(matched = matcher.find())) break block2;
                end = matcher.start();
                out.writeObject(str.substring(start, end));
            } while ((start = matcher.end()) != end);
            throw new IllegalArgumentException("pattern matches empty string");
        }
        out.writeObject(str.substring(start));
    }

    public static Object codepointEqual(Object arg1, Object arg2) {
        String str1 = StringUtils.coerceToString(arg1, "codepoint-equal", 1, null);
        String str2 = StringUtils.coerceToString(arg2, "codepoint-equal", 2, null);
        if (str1 == null || str2 == null) {
            return Values.empty;
        }
        return str1.equals(str2) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Object normalizeUnicode(Object arg) {
        return StringUtils.normalizeUnicode(arg, "NFC");
    }

    public static Object normalizeUnicode(Object arg, String form) {
        String str = StringUtils.coerceToString(arg, "normalize-unicode", 1, "");
        if ("".equals(form = form.trim().toUpperCase())) {
            return str;
        }
        throw new UnsupportedOperationException("normalize-unicode: unicode string normalization not available");
    }
}

