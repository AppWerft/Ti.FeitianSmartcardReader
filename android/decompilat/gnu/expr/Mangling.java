// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

public class Mangling
{
    public static String mangleClassName(final String name) {
        return mangleSymbolic(name, 'C', false);
    }
    
    public static String mangleQualifiedName(final String name) {
        return mangleSymbolic(name, 'Q', false);
    }
    
    public static String mangleSymbolic(final String name, final char context, final boolean force) {
        StringBuilder sbuf = null;
        final int len = name.length();
        if (len == 0) {
            return "\\=";
        }
        int dangerous = 0;
        for (int i = 0; i < len; ++i) {
            final char ch = name.charAt(i);
            char ch2 = '\0';
            switch (ch) {
                case '/': {
                    ch2 = '|';
                    break;
                }
                case '.': {
                    if (context != 'Q') {
                        ch2 = ',';
                        break;
                    }
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
                    if (context == 'M') {
                        ch2 = '^';
                        break;
                    }
                    break;
                }
                case '>': {
                    if (context == 'M') {
                        ch2 = '_';
                        break;
                    }
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
                    break;
                }
            }
            if (ch2 != '\0' && ch != '\\') {
                ++dangerous;
            }
            if (sbuf != null) {
                if (ch2 == '\0') {
                    sbuf.append(ch);
                }
                else {
                    sbuf.append('\\').append(ch2);
                }
            }
            else if (ch2 != '\0') {
                sbuf = new StringBuilder();
                if (i != 0) {
                    sbuf.append("\\=");
                }
                sbuf.append(name, 0, i);
                sbuf.append('\\').append(ch2);
            }
        }
        return (sbuf == null || (dangerous == 0 && !force)) ? name : sbuf.toString();
    }
    
    public static String demangleName(final String name, final boolean reversible) {
        final StringBuffer sbuf = new StringBuffer();
        final int len = name.length();
        boolean mangled = false;
        boolean predicate = false;
        boolean downCaseNext = false;
        for (int i = 0; i < len; ++i) {
            char ch = name.charAt(i);
            if (i == 0 && ch == '$' && len >= 3 && name.charAt(1) == 'N') {
                i = 1;
                mangled = true;
            }
            else {
                if (downCaseNext && !reversible) {
                    ch = Character.toLowerCase(ch);
                    downCaseNext = false;
                }
                char d;
                if (!reversible && ch == 'i' && i == 0 && len > 2 && name.charAt(i + 1) == 's' && !Character.isLowerCase(d = name.charAt(i + 2))) {
                    mangled = true;
                    predicate = true;
                    ++i;
                    if (Character.isUpperCase(d) || Character.isTitleCase(d)) {
                        sbuf.append(Character.toLowerCase(d));
                        ++i;
                    }
                }
                else {
                    if (ch == '$' && i + 2 < len) {
                        final char c1 = name.charAt(i + 1);
                        final char c2 = name.charAt(i + 2);
                        d = demangle2(c1, c2);
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
                    }
                    else if (!reversible && i > 1 && (Character.isUpperCase(ch) || Character.isTitleCase(ch)) && Character.isLowerCase(name.charAt(i - 1))) {
                        sbuf.append('-');
                        mangled = true;
                        ch = Character.toLowerCase(ch);
                    }
                    sbuf.append(ch);
                }
            }
        }
        if (predicate) {
            sbuf.append('?');
        }
        return mangled ? sbuf.toString() : name;
    }
    
    public static char demangle2(final char char1, final char char2) {
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
            default: {
                return '\uffff';
            }
        }
    }
    
    public static String demangleSymbolic(final String name) {
        final int len = name.length();
        if (len < 2 || name.charAt(0) != '\\') {
            return name;
        }
        final StringBuilder sbuf = new StringBuilder();
        int i = (name.charAt(1) == '=') ? 2 : 0;
        while (i < len) {
            final char ch = name.charAt(i);
            if (ch == '\\' && i + 1 < len) {
                final char ch2 = name.charAt(i + 1);
                char ch3 = '\0';
                switch (ch2) {
                    case '|': {
                        ch3 = '/';
                        break;
                    }
                    case ',': {
                        ch3 = '.';
                        break;
                    }
                    case '?': {
                        ch3 = ';';
                        break;
                    }
                    case '%': {
                        ch3 = '$';
                        break;
                    }
                    case '^': {
                        ch3 = '<';
                        break;
                    }
                    case '_': {
                        ch3 = '>';
                        break;
                    }
                    case '{': {
                        ch3 = '[';
                        break;
                    }
                    case '}': {
                        ch3 = ']';
                        break;
                    }
                    case '!': {
                        ch3 = ':';
                        break;
                    }
                    case '-': {
                        ch3 = '\\';
                        break;
                    }
                    default: {
                        ch3 = '\0';
                        break;
                    }
                }
                if (ch3 != '\0') {
                    sbuf.append(ch3);
                }
                else {
                    sbuf.append('\\').append(ch2);
                }
                i += 2;
            }
            else {
                sbuf.append(ch);
                ++i;
            }
        }
        return sbuf.toString();
    }
    
    public static String mangleName(final String name) {
        return Language.mangleName(name, -1);
    }
    
    public static String mangleName(final String name, final boolean reversible) {
        return Language.mangleName(name, reversible ? 1 : -1);
    }
    
    public static String mangleNameIfNeeded(final String name) {
        return Language.mangleNameIfNeeded(name);
    }
    
    public static String demangleName(final String name) {
        return demangleName(name, false);
    }
}
