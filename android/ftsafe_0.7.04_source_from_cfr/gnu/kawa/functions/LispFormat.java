/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.kawa.format.CaseConvertFormat;
import gnu.kawa.format.CompoundFormat;
import gnu.kawa.format.DelimitSubstitutionFormat;
import gnu.kawa.format.FlushFormat;
import gnu.kawa.format.LiteralFormat;
import gnu.kawa.functions.IntegerFormat;
import gnu.kawa.functions.LispCharacterFormat;
import gnu.kawa.functions.LispChoiceFormat;
import gnu.kawa.functions.LispEscapeFormat;
import gnu.kawa.functions.LispFreshlineFormat;
import gnu.kawa.functions.LispIndentFormat;
import gnu.kawa.functions.LispIterationFormat;
import gnu.kawa.functions.LispNewlineFormat;
import gnu.kawa.functions.LispObjectFormat;
import gnu.kawa.functions.LispPluralFormat;
import gnu.kawa.functions.LispPrettyFormat;
import gnu.kawa.functions.LispRealFormat;
import gnu.kawa.functions.LispRepositionFormat;
import gnu.kawa.functions.LispTabulateFormat;
import gnu.kawa.functions.ObjectFormat;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.math.IntNum;
import gnu.text.Char;
import java.text.Format;
import java.text.ParseException;
import java.util.Stack;
import java.util.Vector;

public class LispFormat
extends CompoundFormat {
    public static final String paramFromList = "<from list>";
    public static final String paramFromCount = "<from count>";
    public static final String paramUnspecified = "<unspecified>";
    static final DelimitSubstitutionFormat delimitSubstitutionInstance = DelimitSubstitutionFormat.getInstance(ObjectFormat.getInstance(false));

    public LispFormat(char[] format, int offset, int length) throws ParseException {
        super(null, 0);
        int start_nesting = -1;
        int choices_seen = 0;
        StringBuffer litbuf = new StringBuffer(100);
        Stack<Object> stack = new Stack<Object>();
        int limit = offset + length;
        int i = offset;
        block29 : do {
            char ch;
            Format fmt5;
            if (i >= limit || format[i] == '~') {
                LiteralFormat fmt2 = litbuf.length() > 0 ? new LiteralFormat(litbuf) : LiteralFormat.separator;
                stack.push(fmt2);
                litbuf.setLength(0);
            }
            if (i >= limit) break;
            if ((ch = format[i++]) != '~') {
                litbuf.append(ch);
                continue;
            }
            int speci = stack.size();
            ch = format[i++];
            do {
                if (ch == '#') {
                    stack.push(paramFromCount);
                    ch = format[i++];
                } else if (ch == 'v' || ch == 'V') {
                    stack.push(paramFromList);
                    ch = format[i++];
                } else if (ch == '-' || ch == '+' || Character.digit(ch, 10) >= 0) {
                    boolean neg;
                    int dig;
                    boolean bl = neg = ch == '-';
                    if (neg || ch == '+') {
                        ch = format[i++];
                    }
                    int val = 0;
                    int start = i;
                    while ((dig = Character.digit(ch, 10)) >= 0) {
                        val = 10 * val + dig;
                        ch = format[i++];
                    }
                    stack.push(i - start < 8 ? IntNum.make(neg ? -val : val) : IntNum.valueOf(format, start, i - start, 10, neg));
                } else if (ch == '\'') {
                    stack.push(Char.make(format[i++]));
                    ch = format[i++];
                } else {
                    if (ch != ',') break;
                    stack.push(paramUnspecified);
                }
                if (ch != ',') break;
                ch = format[i++];
            } while (true);
            boolean seenColon = false;
            boolean seenAt = false;
            do {
                if (ch == ':') {
                    seenColon = true;
                } else {
                    if (ch != '@') break;
                    seenAt = true;
                }
                ch = format[i++];
            } while (true);
            ch = Character.toUpperCase(ch);
            int numParams = stack.size() - speci;
            switch (ch) {
                CaseConvertFormat cfmt;
                LispPrettyFormat pfmt;
                int charVal;
                int param1;
                int minWidth;
                LispIterationFormat lfmt;
                int param2;
                int param3;
                int count;
                int padChar;
                case 'B': 
                case 'D': 
                case 'O': 
                case 'R': 
                case 'X': {
                    int argstart = speci;
                    int base2 = ch == 'R' ? LispFormat.getParam(stack, argstart++) : (ch == 'D' ? 10 : (ch == 'O' ? 8 : (ch == 'X' ? 16 : 2)));
                    minWidth = LispFormat.getParam(stack, argstart);
                    padChar = LispFormat.getParam(stack, argstart + 1);
                    int commaChar = LispFormat.getParam(stack, argstart + 2);
                    int commaInterval = LispFormat.getParam(stack, argstart + 3);
                    int flags = 0;
                    if (seenColon) {
                        flags |= true;
                    }
                    if (seenAt) {
                        flags |= 2;
                    }
                    fmt5 = IntegerFormat.getInstance(base2, minWidth, padChar, commaChar, commaInterval, flags);
                    break;
                }
                case 'P': {
                    fmt5 = LispPluralFormat.getInstance(seenColon, seenAt);
                    break;
                }
                case '$': 
                case 'E': 
                case 'F': 
                case 'G': {
                    LispRealFormat dfmt = new LispRealFormat();
                    dfmt.op = ch;
                    dfmt.style = (char)76;
                    dfmt.arg1 = LispFormat.getParam(stack, speci);
                    dfmt.arg2 = LispFormat.getParam(stack, speci + 1);
                    dfmt.arg3 = LispFormat.getParam(stack, speci + 2);
                    dfmt.arg4 = LispFormat.getParam(stack, speci + 3);
                    if (ch != '$') {
                        dfmt.arg5 = LispFormat.getParam(stack, speci + 4);
                        if (ch == 'E' || ch == 'G') {
                            dfmt.arg6 = LispFormat.getParam(stack, speci + 5);
                            dfmt.arg7 = LispFormat.getParam(stack, speci + 6);
                        }
                    }
                    dfmt.showPlus = seenAt;
                    dfmt.internalPad = seenColon;
                    fmt5 = dfmt.resolve(null, 0);
                    break;
                }
                case 'A': 
                case 'S': 
                case 'W': 
                case 'Y': {
                    minWidth = LispFormat.getParam(stack, speci);
                    int colInc = LispFormat.getParam(stack, speci + 1);
                    int minPad = LispFormat.getParam(stack, speci + 2);
                    padChar = LispFormat.getParam(stack, speci + 3);
                    fmt5 = new LispObjectFormat(ObjectFormat.getInstance(ch != 'A'), minWidth, colInc, minPad, padChar, seenAt ? 0 : 100);
                    break;
                }
                case 'C': {
                    charVal = numParams > 0 ? LispFormat.getParam(stack, speci) : -1610612736;
                    fmt5 = LispCharacterFormat.getInstance(charVal, 1, seenAt, seenColon);
                    break;
                }
                case '*': {
                    fmt5 = new LispRepositionFormat(LispFormat.getParam(stack, speci), seenColon, seenAt);
                    break;
                }
                case '(': {
                    ch = seenColon ? (seenAt ? (char)'U' : 'C') : (seenAt ? (char)'T' : 'L');
                    cfmt = new CaseConvertFormat(null, ch);
                    stack.setSize(speci);
                    stack.push(cfmt);
                    stack.push(IntNum.make(start_nesting));
                    start_nesting = speci;
                    continue block29;
                }
                case ')': {
                    if (start_nesting < 0 || !(stack.elementAt(start_nesting) instanceof CaseConvertFormat)) {
                        throw new ParseException("saw ~) without matching ~(", i);
                    }
                    cfmt = (CaseConvertFormat)stack.elementAt(start_nesting);
                    cfmt.setBaseFormat(LispFormat.popFormats(stack, start_nesting + 2, speci));
                    start_nesting = ((IntNum)stack.pop()).intValue();
                    continue block29;
                }
                case '?': {
                    lfmt = new LispIterationFormat();
                    lfmt.seenAt = seenAt;
                    lfmt.maxIterations = 1;
                    lfmt.atLeastOnce = true;
                    fmt5 = lfmt;
                    break;
                }
                case '{': {
                    lfmt = new LispIterationFormat();
                    lfmt.seenAt = seenAt;
                    lfmt.seenColon = seenColon;
                    lfmt.maxIterations = LispFormat.getParam(stack, speci);
                    stack.setSize(speci);
                    stack.push(lfmt);
                    stack.push(IntNum.make(start_nesting));
                    start_nesting = speci;
                    continue block29;
                }
                case '}': {
                    Format body;
                    if (start_nesting < 0 || !(stack.elementAt(start_nesting) instanceof LispIterationFormat)) {
                        throw new ParseException("saw ~} without matching ~{", i);
                    }
                    lfmt = (LispIterationFormat)stack.elementAt(start_nesting);
                    lfmt.atLeastOnce = seenColon;
                    if (speci > start_nesting + 2 && (body = LispFormat.popFormats(stack, start_nesting + 2, speci)) != LiteralFormat.separator) {
                        lfmt.body = body;
                    }
                    start_nesting = ((IntNum)stack.pop()).intValue();
                    continue block29;
                }
                case '<': {
                    pfmt = new LispPrettyFormat();
                    pfmt.seenAt = seenAt;
                    if (seenColon) {
                        pfmt.prefix = "(";
                        pfmt.suffix = ")";
                    } else {
                        pfmt.prefix = "";
                        pfmt.suffix = "";
                    }
                    stack.setSize(speci);
                    stack.push(pfmt);
                    stack.push(IntNum.make(start_nesting));
                    stack.push(IntNum.make(choices_seen));
                    start_nesting = speci;
                    choices_seen = 0;
                    continue block29;
                }
                case '>': {
                    if (start_nesting < 0 || !(stack.elementAt(start_nesting) instanceof LispPrettyFormat)) {
                        throw new ParseException("saw ~> without matching ~<", i);
                    }
                    Format fmt3 = LispFormat.popFormats(stack, start_nesting + 3 + choices_seen, speci);
                    stack.push(fmt3);
                    pfmt = (LispPrettyFormat)stack.elementAt(start_nesting);
                    pfmt.segments = LispFormat.getFormats(stack, start_nesting + 3, stack.size());
                    stack.setSize(start_nesting + 3);
                    start_nesting = ((IntNum)stack.pop()).intValue();
                    start_nesting = ((IntNum)stack.pop()).intValue();
                    if (seenColon) {
                        int nsegments = pfmt.segments.length;
                        if (nsegments > 3) {
                            throw new ParseException("too many segments in Logical Block format", i);
                        }
                        if (nsegments >= 2) {
                            if (!(pfmt.segments[0] instanceof LiteralFormat)) {
                                throw new ParseException("prefix segment is not literal", i);
                            }
                            pfmt.prefix = ((LiteralFormat)pfmt.segments[0]).content();
                            pfmt.body = pfmt.segments[1];
                        } else {
                            pfmt.body = pfmt.segments[0];
                        }
                        if (nsegments < 3) continue block29;
                        if (!(pfmt.segments[2] instanceof LiteralFormat)) {
                            throw new ParseException("suffix segment is not literal", i);
                        }
                        pfmt.suffix = ((LiteralFormat)pfmt.segments[2]).content();
                        continue block29;
                    }
                    throw new ParseException("not implemented: justfication i.e. ~<...~>", i);
                }
                case '[': {
                    LispChoiceFormat afmt = new LispChoiceFormat();
                    afmt.param = LispFormat.getParam(stack, speci);
                    if (afmt.param == -1073741824) {
                        afmt.param = -1610612736;
                    }
                    if (seenColon) {
                        afmt.testBoolean = true;
                    }
                    if (seenAt) {
                        afmt.skipIfFalse = true;
                    }
                    stack.setSize(speci);
                    stack.push(afmt);
                    stack.push(IntNum.make(start_nesting));
                    stack.push(IntNum.make(choices_seen));
                    start_nesting = speci;
                    choices_seen = 0;
                    continue block29;
                }
                case ';': {
                    if (start_nesting >= 0) {
                        if (stack.elementAt(start_nesting) instanceof LispChoiceFormat) {
                            LispChoiceFormat afmt = (LispChoiceFormat)stack.elementAt(start_nesting);
                            if (seenColon) {
                                afmt.lastIsDefault = true;
                            }
                            Format fmt3 = LispFormat.popFormats(stack, start_nesting + 3 + choices_seen, speci);
                            stack.push(fmt3);
                            ++choices_seen;
                            continue block29;
                        }
                        if (stack.elementAt(start_nesting) instanceof LispPrettyFormat) {
                            pfmt = (LispPrettyFormat)stack.elementAt(start_nesting);
                            if (seenAt) {
                                pfmt.perLine = true;
                            }
                            Format fmt4 = LispFormat.popFormats(stack, start_nesting + 3 + choices_seen, speci);
                            stack.push(fmt4);
                            ++choices_seen;
                            continue block29;
                        }
                    }
                    throw new ParseException("saw ~; without matching ~[ or ~<", i);
                }
                case ']': {
                    if (start_nesting < 0 || !(stack.elementAt(start_nesting) instanceof LispChoiceFormat)) {
                        throw new ParseException("saw ~] without matching ~[", i);
                    }
                    Format fmt5 = LispFormat.popFormats(stack, start_nesting + 3 + choices_seen, speci);
                    stack.push(fmt5);
                    LispChoiceFormat afmt = (LispChoiceFormat)stack.elementAt(start_nesting);
                    afmt.choices = LispFormat.getFormats(stack, start_nesting + 3, stack.size());
                    stack.setSize(start_nesting + 3);
                    choices_seen = ((IntNum)stack.pop()).intValue();
                    start_nesting = ((IntNum)stack.pop()).intValue();
                    continue block29;
                }
                case '^': {
                    param1 = LispFormat.getParam(stack, speci);
                    param2 = LispFormat.getParam(stack, speci + 1);
                    param3 = LispFormat.getParam(stack, speci + 2);
                    fmt5 = new LispEscapeFormat(param1, param2, param3);
                    break;
                }
                case '\n': {
                    if (seenAt) {
                        litbuf.append(ch);
                    }
                    if (seenColon) continue block29;
                    do {
                        if (i >= limit) continue block29;
                    } while (Character.isWhitespace(ch = format[i++]));
                    --i;
                    continue block29;
                }
                case '!': {
                    fmt5 = FlushFormat.getInstance();
                    break;
                }
                case 'T': {
                    param1 = LispFormat.getParam(stack, speci);
                    param2 = LispFormat.getParam(stack, speci + 1);
                    param3 = LispFormat.getParam(stack, speci + 2);
                    fmt5 = new LispTabulateFormat(param1, param2, param3, seenAt);
                    break;
                }
                case '&': {
                    param1 = LispFormat.getParam(stack, speci);
                    fmt5 = new LispFreshlineFormat(param1);
                    break;
                }
                case 'I': {
                    param1 = LispFormat.getParam(stack, speci);
                    if (param1 == -1073741824) {
                        param1 = 0;
                    }
                    fmt5 = LispIndentFormat.getInstance(param1, seenColon);
                    break;
                }
                case '_': {
                    param1 = LispFormat.getParam(stack, speci);
                    if (param1 == -1073741824) {
                        param1 = 1;
                    }
                    int n = charVal = seenColon && seenAt ? 10 : 32;
                    int kind = seenAt && seenColon ? 82 : (seenAt ? 77 : (seenColon ? 70 : 78));
                    fmt5 = LispNewlineFormat.getInstance(param1, kind);
                    break;
                }
                case '~': {
                    if (numParams == 0) {
                        litbuf.append(ch);
                        continue block29;
                    }
                }
                case '|': {
                    count = LispFormat.getParam(stack, speci);
                    if (count == -1073741824) {
                        count = 1;
                    }
                    if ((charVal = LispFormat.getParam(stack, speci + 1)) == -1073741824) {
                        charVal = ch == '|' ? 12 : 126;
                    }
                    fmt5 = LispCharacterFormat.getInstance(charVal, count, false, false);
                    break;
                }
                case '%': {
                    count = LispFormat.getParam(stack, speci);
                    if (count == -1073741824) {
                        count = 1;
                    }
                    fmt5 = LispNewlineFormat.getInstance(count, 76);
                    break;
                }
                case 'Q': {
                    fmt5 = delimitSubstitutionInstance;
                    break;
                }
                default: {
                    throw new ParseException("unrecognized format specifier ~" + ch, i);
                }
            }
            stack.setSize(speci);
            stack.push(fmt5);
        } while (true);
        if (i > limit) {
            throw new IndexOutOfBoundsException();
        }
        if (start_nesting >= 0) {
            throw new ParseException("missing ~] or ~}", i);
        }
        this.length = stack.size();
        this.formats = new Format[this.length];
        stack.copyInto(this.formats);
    }

    static Format[] getFormats(Vector vector, int start, int end) {
        Format[] f = new Format[end - start];
        for (int i = start; i < end; ++i) {
            f[i - start] = (Format)vector.elementAt(i);
        }
        return f;
    }

    static Format popFormats(Vector vector, int start, int end) {
        Format f = end == start + 1 ? (Format)vector.elementAt(start) : new CompoundFormat(LispFormat.getFormats(vector, start, end));
        vector.setSize(start);
        return f;
    }

    public LispFormat(String str) throws ParseException {
        this(str.toCharArray());
    }

    public LispFormat(char[] format) throws ParseException {
        this(format, 0, format.length);
    }

    public static int getParam(Vector vec, int index) {
        if (index >= vec.size()) {
            return -1073741824;
        }
        Object arg = vec.elementAt(index);
        if (arg == paramFromList) {
            return -1610612736;
        }
        if (arg == paramFromCount) {
            return -1342177280;
        }
        if (arg == paramUnspecified) {
            return -1073741824;
        }
        return LispFormat.getParam(arg, -1073741824);
    }

    public static Object[] asArray(Object arg) {
        if (arg instanceof Object[]) {
            return (Object[])arg;
        }
        if (!(arg instanceof Sequence)) {
            return null;
        }
        int count = ((Sequence)arg).size();
        Object[] arr = new Object[count];
        int i = 0;
        while (arg instanceof Pair) {
            Pair pair = (Pair)arg;
            arr[i++] = pair.getCar();
            arg = pair.getCdr();
        }
        if (i < count) {
            if (!(arg instanceof Sequence)) {
                return null;
            }
            int npairs = i;
            Sequence seq = (Sequence)arg;
            while (i < count) {
                arr[i] = seq.get(npairs + i);
                ++i;
            }
        }
        return arr;
    }
}

