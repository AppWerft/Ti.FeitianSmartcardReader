/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Language;

public class Mangling {
    public static String mangleClassName(String name) {
        return Mangling.mangleSymbolic(name, 'C', false);
    }

    public static String mangleQualifiedName(String name) {
        return Mangling.mangleSymbolic(name, 'Q', false);
    }

    public static String mangleSymbolic(String name, char context, boolean force) {
        StringBuilder sbuf = null;
        int len = name.length();
        if (len == 0) {
            return "\\=";
        }
        int dangerous = 0;
        for (int i = 0; i < len; ++i) {
            char ch = name.charAt(i);
            char ch2 = '\u0000';
            switch (ch) {
                case '/': {
                    ch2 = '|';
                    break;
                }
                case '.': {
                    if (context == 'Q') break;
                    ch2 = ',';
                    break;
                }
                case ';': {
                    ch2 = '?';
                    break;
                }
                case '$': {
                    ch2 = '%';
                    break;
                }
                case '<': {
                    if (context != 'M') break;
                    ch2 = '^';
                    break;
                }
                case '>': {
                    if (context != 'M') break;
                    ch2 = '_';
                    break;
                }
                case '[': {
                    ch2 = '{';
                    break;
                }
                case ']': {
                    ch2 = '}';
                    break;
                }
                case ':': {
                    ch2 = '!';
                    break;
                }
                case '\\': {
                    ch2 = '-';
                }
            }
            if (ch2 != '\u0000' && ch != '\\') {
                ++dangerous;
            }
            if (sbuf != null) {
                if (ch2 == '\u0000') {
                    sbuf.append(ch);
                    continue;
                }
                sbuf.append('\\').append(ch2);
                continue;
            }
            if (ch2 == '\u0000') continue;
            sbuf = new StringBuilder();
            if (i != 0) {
                sbuf.append("\\=");
            }
            sbuf.append(name, 0, i);
            sbuf.append('\\').append(ch2);
        }
        return sbuf == null || dangerous == 0 && !force ? name : sbuf.toString();
    }

    public static String demangleName(String name, boolean reversible) {
        StringBuffer sbuf = new StringBuffer();
        int len = name.length();
        boolean mangled = false;
        boolean predicate = false;
        boolean downCaseNext = false;
        for (int i = 0; i < len; ++i) {
            char d;
            char ch = name.charAt(i);
            if (i == 0 && ch == '$' && len >= 3 && name.charAt(1) == 'N') {
                i = 1;
                mangled = true;
                continue;
            }
            if (downCaseNext && !reversible) {
                ch = Character.toLowerCase(ch);
                downCaseNext = false;
            }
            if (!reversible && ch == 'i' && i == 0 && len > 2 && name.charAt(i + 1) == 's' && !Character.isLowerCase(d = name.charAt(i + 2))) {
                mangled = true;
                predicate = true;
                ++i;
                if (!Character.isUpperCase(d) && !Character.isTitleCase(d)) continue;
                sbuf.append(Character.toLowerCase(d));
                ++i;
                continue;
            }
            if (ch == '$' && i + 2 < len) {
                char c2;
                char c1 = name.charAt(i + 1);
                d = Mangling.demangle2(c1, c2 = name.charAt(i + 2));
                if (d != '\uffff') {
                    sbuf.append(d);
                    i += 2;
                    mangled = true;
                    downCaseNext = true;
                    continue;
                }
                if (c1 == 'T' && c2 == 'o' && i + 3 < len && name.charAt(i + 3) == '$') {
                    sbuf.append("->");
                    i += 3;
                    mangled = true;
                    downCaseNext = true;
                    continue;
                }
            } else if (!reversible && i > 1 && (Character.isUpperCase(ch) || Character.isTitleCase(ch)) && Character.isLowerCase(name.charAt(i - 1))) {
                sbuf.append('-');
                mangled = true;
                ch = Character.toLowerCase(ch);
            }
            sbuf.append(ch);
        }
        if (predicate) {
            sbuf.append('?');
        }
        return mangled ? sbuf.toString() : name;
    }

    public static char demangle2(char char1, char char2) {
        switch (char1 << 16 | char2) {
            case 4259949: {
                return '&';
            }
            case 4259956: {
                return '@';
            }
            case 4391020: {
                return ':';
            }
            case 4391021: {
                return ',';
            }
            case 4456561: {
                return '\"';
            }
            case 4456564: {
                return '.';
            }
            case 4522097: {
                return '=';
            }
            case 4522104: {
                return '!';
            }
            case 4653170: {
                return '>';
            }
            case 4980802: {
                return '[';
            }
            case 4980803: {
                return '{';
            }
            case 4980816: {
                return '(';
            }
            case 4980851: {
                return '<';
            }
            case 5046371: {
                return '%';
            }
            case 5046382: {
                return '-';
            }
            case 5111917: {
                return '#';
            }
            case 5242979: {
                return '%';
            }
            case 5242988: {
                return '+';
            }
            case 5308533: {
                return '?';
            }
            case 5374018: {
                return ']';
            }
            case 5374019: {
                return '}';
            }
            case 5374032: {
                return ')';
            }
            case 5439555: {
                return ';';
            }
            case 5439596: {
                return '/';
            }
            case 5439601: {
                return '\\';
            }
            case 5439604: {
                return '*';
            }
            case 5505132: {
                return '~';
            }
            case 5570672: {
                return '^';
            }
            case 5636162: {
                return '|';
            }
        }
        return '\uffff';
    }

    public static String demangleSymbolic(String name) {
        int i;
        int len = name.length();
        if (len < 2 || name.charAt(0) != '\\') {
            return name;
        }
        StringBuilder sbuf = new StringBuilder();
        int n = i = name.charAt(1) == '=' ? 2 : 0;
        while (i < len) {
            char ch = name.charAt(i);
            if (ch == '\\' && i + 1 < len) {
                char ch1;
                char ch2 = name.charAt(i + 1);
                switch (ch2) {
                    case '|': {
                        ch1 = '/';
                        break;
                    }
                    case ',': {
                        ch1 = '.';
                        break;
                    }
                    case '?': {
                        ch1 = ';';
                        break;
                    }
                    case '%': {
                        ch1 = '$';
                        break;
                    }
                    case '^': {
                        ch1 = '<';
                        break;
                    }
                    case '_': {
                        ch1 = '>';
                        break;
                    }
                    case '{': {
                        ch1 = '[';
                        break;
                    }
                    case '}': {
                        ch1 = ']';
                        break;
                    }
                    case '!': {
                        ch1 = ':';
                        break;
                    }
                    case '-': {
                        ch1 = '\\';
                        break;
                    }
                    default: {
                        ch1 = '\u0000';
                    }
                }
                if (ch1 != '\u0000') {
                    sbuf.append(ch1);
                } else {
                    sbuf.append('\\').append(ch2);
                }
                i += 2;
                continue;
            }
            sbuf.append(ch);
            ++i;
        }
        return sbuf.toString();
    }

    public static String mangleName(String name) {
        return Language.mangleName(name, -1);
    }

    public static String mangleName(String name, boolean reversible) {
        return Language.mangleName(name, reversible ? 1 : -1);
    }

    public static String mangleNameIfNeeded(String name) {
        return Language.mangleNameIfNeeded(name);
    }

    public static String demangleName(String name) {
        return Mangling.demangleName(name, false);
    }
}

