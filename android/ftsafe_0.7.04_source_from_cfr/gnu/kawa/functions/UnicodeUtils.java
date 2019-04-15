/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.text.BreakIterator;

public class UnicodeUtils {
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

    public static boolean isWhitespace(int ch) {
        if (ch == 32 || ch >= 9 && ch <= 13) {
            return true;
        }
        if (ch < 133) {
            return false;
        }
        if (ch == 133 || ch == 160 || ch == 5760 || ch == 6158) {
            return true;
        }
        if (ch < 8192 || ch > 12288) {
            return false;
        }
        return ch <= 8202 || ch == 8232 || ch == 8233 || ch == 8239 || ch == 8287 || ch == 12288;
    }

    public static String capitalize(String str) {
        StringBuilder sbuf = new StringBuilder();
        BreakIterator wb = BreakIterator.getWordInstance();
        wb.setText(str);
        int start = wb.first();
        int end = wb.next();
        while (end != -1) {
            boolean isWord = false;
            for (int p = start; p < end; ++p) {
                if (!Character.isLetter(str.codePointAt(p))) continue;
                isWord = true;
                break;
            }
            if (!isWord) {
                sbuf.append(str, start, end);
            } else {
                char first = str.charAt(start);
                char title = Character.toTitleCase(first);
                sbuf.append(title);
                sbuf.append(str.substring(start + 1, end).toLowerCase());
            }
            start = end;
            end = wb.next();
        }
        return sbuf.toString();
    }

    public static CharSequence foldCase(CharSequence str) {
        int len = str.length();
        if (len == 0) {
            return "";
        }
        StringBuilder sbuf = null;
        boolean start = false;
        int i = 0;
        do {
            int chl;
            int ch = i == len ? -1 : (int)str.charAt(i);
            int w = 1;
            if (ch >= 55296 && ch <= 56319 && i + 1 < len) {
                char next = str.charAt(i + 1);
                ++w;
                if (next >= '\udc00' && next <= '\udfff') {
                    ch = (ch - 55296 << 10) + (ch - 56320) + 65536;
                }
            }
            if (ch != (chl = ch == -1 ? ch : (ch == 223 || ch == 304 ? -2 : (ch == 962 ? 963 : Character.toLowerCase(Character.toUpperCase(ch))))) || sbuf != null) {
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
                    } else {
                        sbuf.append('i');
                        sbuf.append('\u0307');
                    }
                } else if (chl >= 65536) {
                    sbuf.append((char)((i - 65536 >> 10) + 55296));
                    sbuf.append((char)((i & 1023) + 56320));
                } else {
                    sbuf.append((char)chl);
                }
            } else if (ch < 0) {
                return str;
            }
            i += w;
        } while (true);
    }

    public static Symbol generalCategory(int ch) {
        switch (Character.getType(ch)) {
            case 8: {
                return Mc;
            }
            case 23: {
                return Pc;
            }
            case 15: {
                return Cc;
            }
            case 26: {
                return Sc;
            }
            case 20: {
                return Pd;
            }
            case 9: {
                return Nd;
            }
            case 7: {
                return Me;
            }
            case 22: {
                return Pe;
            }
            case 30: {
                return Pf;
            }
            case 16: {
                return Cf;
            }
            case 29: {
                return Pi;
            }
            case 10: {
                return Nl;
            }
            case 13: {
                return Zl;
            }
            case 2: {
                return Ll;
            }
            case 25: {
                return Sm;
            }
            case 4: {
                return Lm;
            }
            case 27: {
                return Sk;
            }
            case 6: {
                return Mn;
            }
            case 5: {
                return Lo;
            }
            case 11: {
                return No;
            }
            case 24: {
                return Po;
            }
            case 28: {
                return So;
            }
            case 14: {
                return Zp;
            }
            case 18: {
                return Co;
            }
            case 12: {
                return Zs;
            }
            case 21: {
                return Ps;
            }
            case 19: {
                return Cs;
            }
            case 3: {
                return Lt;
            }
            case 1: {
                return Lu;
            }
        }
        return Cn;
    }

    static {
        Namespace empty = Namespace.EmptyNamespace;
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

