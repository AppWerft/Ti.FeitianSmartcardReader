// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Namespace;
import java.text.BreakIterator;
import gnu.mapping.Symbol;

public class UnicodeUtils
{
    static final Symbol Mc;
    static final Symbol Pc;
    static final Symbol Cc;
    static final Symbol Sc;
    static final Symbol Pd;
    static final Symbol Nd;
    static final Symbol Me;
    static final Symbol Pe;
    static final Symbol Pf;
    static final Symbol Cf;
    static final Symbol Pi;
    static final Symbol Nl;
    static final Symbol Zl;
    static final Symbol Ll;
    static final Symbol Sm;
    static final Symbol Lm;
    static final Symbol Sk;
    static final Symbol Mn;
    static final Symbol Lo;
    static final Symbol No;
    static final Symbol Po;
    static final Symbol So;
    static final Symbol Zp;
    static final Symbol Co;
    static final Symbol Zs;
    static final Symbol Ps;
    static final Symbol Cs;
    static final Symbol Lt;
    static final Symbol Cn;
    static final Symbol Lu;
    
    public static boolean isWhitespace(final int ch) {
        return ch == 32 || (ch >= 9 && ch <= 13) || (ch >= 133 && (ch == 133 || ch == 160 || ch == 5760 || ch == 6158 || (ch >= 8192 && ch <= 12288 && (ch <= 8202 || ch == 8232 || ch == 8233 || ch == 8239 || ch == 8287 || ch == 12288))));
    }
    
    public static String capitalize(final String str) {
        final StringBuilder sbuf = new StringBuilder();
        final BreakIterator wb = BreakIterator.getWordInstance();
        wb.setText(str);
        int start = wb.first();
        for (int end = wb.next(); end != -1; end = wb.next()) {
            boolean isWord = false;
            for (int p = start; p < end; ++p) {
                if (Character.isLetter(str.codePointAt(p))) {
                    isWord = true;
                    break;
                }
            }
            if (!isWord) {
                sbuf.append(str, start, end);
            }
            else {
                final char first = str.charAt(start);
                final char title = Character.toTitleCase(first);
                sbuf.append(title);
                sbuf.append(str.substring(start + 1, end).toLowerCase());
            }
            start = end;
        }
        return sbuf.toString();
    }
    
    public static CharSequence foldCase(final CharSequence str) {
        final int len = str.length();
        if (len == 0) {
            return "";
        }
        StringBuilder sbuf = null;
        final int start = 0;
        int i = 0;
        while (true) {
            int ch = (i == len) ? -1 : str.charAt(i);
            int w = 1;
            if (ch >= 55296 && ch <= 56319 && i + 1 < len) {
                final char next = str.charAt(i + 1);
                ++w;
                if (next >= '\udc00' && next <= '\udfff') {
                    ch = (ch - 55296 << 10) + (ch - 56320) + 65536;
                }
            }
            int chl;
            if (ch == -1) {
                chl = ch;
            }
            else if (ch == 223 || ch == 304) {
                chl = -2;
            }
            else if (ch == 962) {
                chl = 963;
            }
            else {
                chl = Character.toLowerCase(Character.toUpperCase(ch));
            }
            if (ch != chl || sbuf != null) {
                if (sbuf == null) {
                    sbuf = new StringBuilder();
                    sbuf.append(str, 0, i);
                }
                if (chl == -1) {
                    return sbuf;
                }
                if (chl == -2) {
                    if (ch == 223) {
                        sbuf.append('s');
                        sbuf.append('s');
                    }
                    else {
                        sbuf.append('i');
                        sbuf.append('\u0307');
                    }
                }
                else if (chl >= 65536) {
                    sbuf.append((char)((i - 65536 >> 10) + 55296));
                    sbuf.append((char)((i & 0x3FF) + 56320));
                }
                else {
                    sbuf.append((char)chl);
                }
            }
            else if (ch < 0) {
                return str;
            }
            i += w;
        }
    }
    
    public static Symbol generalCategory(final int ch) {
        switch (Character.getType(ch)) {
            case 8: {
                return UnicodeUtils.Mc;
            }
            case 23: {
                return UnicodeUtils.Pc;
            }
            case 15: {
                return UnicodeUtils.Cc;
            }
            case 26: {
                return UnicodeUtils.Sc;
            }
            case 20: {
                return UnicodeUtils.Pd;
            }
            case 9: {
                return UnicodeUtils.Nd;
            }
            case 7: {
                return UnicodeUtils.Me;
            }
            case 22: {
                return UnicodeUtils.Pe;
            }
            case 30: {
                return UnicodeUtils.Pf;
            }
            case 16: {
                return UnicodeUtils.Cf;
            }
            case 29: {
                return UnicodeUtils.Pi;
            }
            case 10: {
                return UnicodeUtils.Nl;
            }
            case 13: {
                return UnicodeUtils.Zl;
            }
            case 2: {
                return UnicodeUtils.Ll;
            }
            case 25: {
                return UnicodeUtils.Sm;
            }
            case 4: {
                return UnicodeUtils.Lm;
            }
            case 27: {
                return UnicodeUtils.Sk;
            }
            case 6: {
                return UnicodeUtils.Mn;
            }
            case 5: {
                return UnicodeUtils.Lo;
            }
            case 11: {
                return UnicodeUtils.No;
            }
            case 24: {
                return UnicodeUtils.Po;
            }
            case 28: {
                return UnicodeUtils.So;
            }
            case 14: {
                return UnicodeUtils.Zp;
            }
            case 18: {
                return UnicodeUtils.Co;
            }
            case 12: {
                return UnicodeUtils.Zs;
            }
            case 21: {
                return UnicodeUtils.Ps;
            }
            case 19: {
                return UnicodeUtils.Cs;
            }
            case 3: {
                return UnicodeUtils.Lt;
            }
            case 1: {
                return UnicodeUtils.Lu;
            }
            default: {
                return UnicodeUtils.Cn;
            }
        }
    }
    
    static {
        final Namespace empty = Namespace.EmptyNamespace;
        Mc = empty.getSymbol("Mc");
        Pc = empty.getSymbol("Pc");
        Cc = empty.getSymbol("Cc");
        Sc = empty.getSymbol("Sc");
        Pd = empty.getSymbol("Pd");
        Nd = empty.getSymbol("Nd");
        Me = empty.getSymbol("Me");
        Pe = empty.getSymbol("Pe");
        Pf = empty.getSymbol("Pf");
        Cf = empty.getSymbol("Cf");
        Pi = empty.getSymbol("Pi");
        Nl = empty.getSymbol("Nl");
        Zl = empty.getSymbol("Zl");
        Ll = empty.getSymbol("Ll");
        Sm = empty.getSymbol("Sm");
        Lm = empty.getSymbol("Lm");
        Sk = empty.getSymbol("Sk");
        Mn = empty.getSymbol("Mn");
        Lo = empty.getSymbol("Lo");
        No = empty.getSymbol("No");
        Po = empty.getSymbol("Po");
        So = empty.getSymbol("So");
        Zp = empty.getSymbol("Zp");
        Co = empty.getSymbol("Co");
        Zs = empty.getSymbol("Zs");
        Ps = empty.getSymbol("Ps");
        Cs = empty.getSymbol("Cs");
        Lt = empty.getSymbol("Lt");
        Cn = empty.getSymbol("Cn");
        Lu = empty.getSymbol("Lu");
    }
}
