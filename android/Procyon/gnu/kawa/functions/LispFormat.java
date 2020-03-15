// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.kawa.format.ReportFormat;
import gnu.kawa.format.FlushFormat;
import java.text.ParseException;
import gnu.kawa.format.CaseConvertFormat;
import java.util.Vector;
import gnu.text.Char;
import gnu.math.IntNum;
import gnu.kawa.format.LiteralFormat;
import java.util.Stack;
import java.text.Format;
import gnu.kawa.format.DelimitSubstitutionFormat;
import gnu.kawa.format.CompoundFormat;

public class LispFormat extends CompoundFormat
{
    public static final String paramFromList = "<from list>";
    public static final String paramFromCount = "<from count>";
    public static final String paramUnspecified = "<unspecified>";
    static final DelimitSubstitutionFormat delimitSubstitutionInstance;
    
    public LispFormat(final char[] format, final int offset, final int length) throws ParseException {
        super(null, 0);
        int start_nesting = -1;
        int choices_seen = 0;
        final StringBuffer litbuf = new StringBuffer(100);
        final Stack stack = new Stack();
        final int limit = offset + length;
        int i = offset;
        Label_3079: {
        Label_2454:
            while (true) {
                if (i >= limit || format[i] == '~') {
                    final LiteralFormat fmt = (litbuf.length() > 0) ? new LiteralFormat(litbuf) : LiteralFormat.separator;
                    stack.push(fmt);
                    litbuf.setLength(0);
                }
                if (i >= limit) {
                    if (i > limit) {
                        throw new IndexOutOfBoundsException();
                    }
                    break Label_3079;
                }
                else {
                    char ch = format[i++];
                    if (ch != '~') {
                        litbuf.append(ch);
                    }
                    else {
                        final int speci = stack.size();
                        ch = format[i++];
                        while (true) {
                            if (ch == '#') {
                                stack.push("<from count>");
                                ch = format[i++];
                            }
                            else if (ch == 'v' || ch == 'V') {
                                stack.push("<from list>");
                                ch = format[i++];
                            }
                            else if (ch == '-' || ch == '+' || Character.digit(ch, 10) >= 0) {
                                final boolean neg = ch == '-';
                                if (neg || ch == '+') {
                                    ch = format[i++];
                                }
                                int val = 0;
                                final int start = i;
                                while (true) {
                                    final int dig = Character.digit(ch, 10);
                                    if (dig < 0) {
                                        break;
                                    }
                                    val = 10 * val + dig;
                                    ch = format[i++];
                                }
                                stack.push((i - start < 8) ? IntNum.make(neg ? (-val) : val) : IntNum.valueOf(format, start, i - start, 10, neg));
                            }
                            else if (ch == '\'') {
                                stack.push(Char.make(format[i++]));
                                ch = format[i++];
                            }
                            else {
                                if (ch != ',') {
                                    break;
                                }
                                stack.push("<unspecified>");
                            }
                            if (ch != ',') {
                                break;
                            }
                            ch = format[i++];
                        }
                        boolean seenColon = false;
                        boolean seenAt = false;
                        while (true) {
                            if (ch == ':') {
                                seenColon = true;
                            }
                            else {
                                if (ch != '@') {
                                    break;
                                }
                                seenAt = true;
                            }
                            ch = format[i++];
                        }
                        ch = Character.toUpperCase(ch);
                        final int numParams = stack.size() - speci;
                        Format fmt2 = null;
                        switch (ch) {
                            case 'B':
                            case 'D':
                            case 'O':
                            case 'R':
                            case 'X': {
                                int argstart = speci;
                                int base;
                                if (ch == 'R') {
                                    base = getParam(stack, argstart++);
                                }
                                else if (ch == 'D') {
                                    base = 10;
                                }
                                else if (ch == 'O') {
                                    base = 8;
                                }
                                else if (ch == 'X') {
                                    base = 16;
                                }
                                else {
                                    base = 2;
                                }
                                final int minWidth = getParam(stack, argstart);
                                final int padChar = getParam(stack, argstart + 1);
                                final int commaChar = getParam(stack, argstart + 2);
                                final int commaInterval = getParam(stack, argstart + 3);
                                int flags = 0;
                                if (seenColon) {
                                    flags |= 0x1;
                                }
                                if (seenAt) {
                                    flags |= 0x2;
                                }
                                fmt2 = IntegerFormat.getInstance(base, minWidth, padChar, commaChar, commaInterval, flags);
                                break;
                            }
                            case 'P': {
                                fmt2 = LispPluralFormat.getInstance(seenColon, seenAt);
                                break;
                            }
                            case '$':
                            case 'E':
                            case 'F':
                            case 'G': {
                                final LispRealFormat dfmt = new LispRealFormat();
                                dfmt.op = ch;
                                dfmt.style = 'L';
                                dfmt.arg1 = getParam(stack, speci);
                                dfmt.arg2 = getParam(stack, speci + 1);
                                dfmt.arg3 = getParam(stack, speci + 2);
                                dfmt.arg4 = getParam(stack, speci + 3);
                                if (ch != '$') {
                                    dfmt.arg5 = getParam(stack, speci + 4);
                                    if (ch == 'E' || ch == 'G') {
                                        dfmt.arg6 = getParam(stack, speci + 5);
                                        dfmt.arg7 = getParam(stack, speci + 6);
                                    }
                                }
                                dfmt.showPlus = seenAt;
                                dfmt.internalPad = seenColon;
                                fmt2 = dfmt.resolve(null, 0);
                                break;
                            }
                            case 'A':
                            case 'S':
                            case 'W':
                            case 'Y': {
                                final int minWidth = getParam(stack, speci);
                                final int colInc = getParam(stack, speci + 1);
                                final int minPad = getParam(stack, speci + 2);
                                final int padChar = getParam(stack, speci + 3);
                                fmt2 = new LispObjectFormat(ObjectFormat.getInstance(ch != 'A'), minWidth, colInc, minPad, padChar, seenAt ? 0 : 100);
                                break;
                            }
                            case 'C': {
                                final int charVal = (numParams > 0) ? getParam(stack, speci) : -1610612736;
                                fmt2 = LispCharacterFormat.getInstance(charVal, 1, seenAt, seenColon);
                                break;
                            }
                            case '*': {
                                fmt2 = new LispRepositionFormat(getParam(stack, speci), seenColon, seenAt);
                                break;
                            }
                            case '(': {
                                ch = (seenColon ? (seenAt ? 'U' : 'C') : (seenAt ? 'T' : 'L'));
                                final CaseConvertFormat cfmt = new CaseConvertFormat(null, ch);
                                stack.setSize(speci);
                                stack.push(cfmt);
                                stack.push(IntNum.make(start_nesting));
                                start_nesting = speci;
                                continue;
                            }
                            case ')': {
                                if (start_nesting < 0 || !(stack.elementAt(start_nesting) instanceof CaseConvertFormat)) {
                                    throw new ParseException("saw ~) without matching ~(", i);
                                }
                                final CaseConvertFormat cfmt = (CaseConvertFormat)stack.elementAt(start_nesting);
                                cfmt.setBaseFormat(popFormats(stack, start_nesting + 2, speci));
                                start_nesting = stack.pop().intValue();
                                continue;
                            }
                            case '?': {
                                final LispIterationFormat lfmt = new LispIterationFormat();
                                lfmt.seenAt = seenAt;
                                lfmt.maxIterations = 1;
                                lfmt.atLeastOnce = true;
                                fmt2 = lfmt;
                                break;
                            }
                            case '{': {
                                final LispIterationFormat lfmt = new LispIterationFormat();
                                lfmt.seenAt = seenAt;
                                lfmt.seenColon = seenColon;
                                lfmt.maxIterations = getParam(stack, speci);
                                stack.setSize(speci);
                                stack.push(lfmt);
                                stack.push(IntNum.make(start_nesting));
                                start_nesting = speci;
                                continue;
                            }
                            case '}': {
                                if (start_nesting < 0 || !(stack.elementAt(start_nesting) instanceof LispIterationFormat)) {
                                    throw new ParseException("saw ~} without matching ~{", i);
                                }
                                final LispIterationFormat lfmt = (LispIterationFormat)stack.elementAt(start_nesting);
                                lfmt.atLeastOnce = seenColon;
                                if (speci > start_nesting + 2) {
                                    final Format body = popFormats(stack, start_nesting + 2, speci);
                                    if (body != LiteralFormat.separator) {
                                        lfmt.body = body;
                                    }
                                }
                                start_nesting = stack.pop().intValue();
                                continue;
                            }
                            case '<': {
                                final LispPrettyFormat pfmt = new LispPrettyFormat();
                                pfmt.seenAt = seenAt;
                                if (seenColon) {
                                    pfmt.prefix = "(";
                                    pfmt.suffix = ")";
                                }
                                else {
                                    pfmt.prefix = "";
                                    pfmt.suffix = "";
                                }
                                stack.setSize(speci);
                                stack.push(pfmt);
                                stack.push(IntNum.make(start_nesting));
                                stack.push(IntNum.make(choices_seen));
                                start_nesting = speci;
                                choices_seen = 0;
                                continue;
                            }
                            case '>': {
                                if (start_nesting < 0 || !(stack.elementAt(start_nesting) instanceof LispPrettyFormat)) {
                                    throw new ParseException("saw ~> without matching ~<", i);
                                }
                                fmt2 = popFormats(stack, start_nesting + 3 + choices_seen, speci);
                                stack.push(fmt2);
                                final LispPrettyFormat pfmt = (LispPrettyFormat)stack.elementAt(start_nesting);
                                pfmt.segments = getFormats(stack, start_nesting + 3, stack.size());
                                stack.setSize(start_nesting + 3);
                                start_nesting = stack.pop().intValue();
                                start_nesting = stack.pop().intValue();
                                if (!seenColon) {
                                    throw new ParseException("not implemented: justfication i.e. ~<...~>", i);
                                }
                                final int nsegments = pfmt.segments.length;
                                if (nsegments > 3) {
                                    throw new ParseException("too many segments in Logical Block format", i);
                                }
                                if (nsegments >= 2) {
                                    if (!(pfmt.segments[0] instanceof LiteralFormat)) {
                                        throw new ParseException("prefix segment is not literal", i);
                                    }
                                    pfmt.prefix = ((LiteralFormat)pfmt.segments[0]).content();
                                    pfmt.body = pfmt.segments[1];
                                }
                                else {
                                    pfmt.body = pfmt.segments[0];
                                }
                                if (nsegments < 3) {
                                    continue;
                                }
                                if (!(pfmt.segments[2] instanceof LiteralFormat)) {
                                    throw new ParseException("suffix segment is not literal", i);
                                }
                                pfmt.suffix = ((LiteralFormat)pfmt.segments[2]).content();
                                continue;
                            }
                            case '[': {
                                final LispChoiceFormat afmt = new LispChoiceFormat();
                                afmt.param = getParam(stack, speci);
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
                                continue;
                            }
                            case ';': {
                                if (start_nesting < 0) {
                                    break Label_2454;
                                }
                                if (stack.elementAt(start_nesting) instanceof LispChoiceFormat) {
                                    final LispChoiceFormat afmt = (LispChoiceFormat)stack.elementAt(start_nesting);
                                    if (seenColon) {
                                        afmt.lastIsDefault = true;
                                    }
                                    fmt2 = popFormats(stack, start_nesting + 3 + choices_seen, speci);
                                    stack.push(fmt2);
                                    ++choices_seen;
                                    continue;
                                }
                                if (stack.elementAt(start_nesting) instanceof LispPrettyFormat) {
                                    final LispPrettyFormat pfmt = (LispPrettyFormat)stack.elementAt(start_nesting);
                                    if (seenAt) {
                                        pfmt.perLine = true;
                                    }
                                    fmt2 = popFormats(stack, start_nesting + 3 + choices_seen, speci);
                                    stack.push(fmt2);
                                    ++choices_seen;
                                    continue;
                                }
                                break Label_2454;
                            }
                            case ']': {
                                if (start_nesting < 0 || !(stack.elementAt(start_nesting) instanceof LispChoiceFormat)) {
                                    throw new ParseException("saw ~] without matching ~[", i);
                                }
                                fmt2 = popFormats(stack, start_nesting + 3 + choices_seen, speci);
                                stack.push(fmt2);
                                final LispChoiceFormat afmt = (LispChoiceFormat)stack.elementAt(start_nesting);
                                afmt.choices = getFormats(stack, start_nesting + 3, stack.size());
                                stack.setSize(start_nesting + 3);
                                choices_seen = stack.pop().intValue();
                                start_nesting = stack.pop().intValue();
                                continue;
                            }
                            case '^': {
                                final int param1 = getParam(stack, speci);
                                final int param2 = getParam(stack, speci + 1);
                                final int param3 = getParam(stack, speci + 2);
                                fmt2 = new LispEscapeFormat(param1, param2, param3);
                                break;
                            }
                            case '\n': {
                                if (seenAt) {
                                    litbuf.append(ch);
                                }
                                if (!seenColon) {
                                    while (i < limit) {
                                        ch = format[i++];
                                        if (!Character.isWhitespace(ch)) {
                                            --i;
                                            break;
                                        }
                                    }
                                    continue;
                                }
                                continue;
                            }
                            case '!': {
                                fmt2 = FlushFormat.getInstance();
                                break;
                            }
                            case 'T': {
                                final int param1 = getParam(stack, speci);
                                final int param2 = getParam(stack, speci + 1);
                                final int param3 = getParam(stack, speci + 2);
                                fmt2 = new LispTabulateFormat(param1, param2, param3, seenAt);
                                break;
                            }
                            case '&': {
                                final int param1 = getParam(stack, speci);
                                fmt2 = new LispFreshlineFormat(param1);
                                break;
                            }
                            case 'I': {
                                int param1 = getParam(stack, speci);
                                if (param1 == -1073741824) {
                                    param1 = 0;
                                }
                                fmt2 = LispIndentFormat.getInstance(param1, seenColon);
                                break;
                            }
                            case '_': {
                                int param1 = getParam(stack, speci);
                                if (param1 == -1073741824) {
                                    param1 = 1;
                                }
                                final int charVal = (seenColon && seenAt) ? 10 : 32;
                                int kind;
                                if (seenAt && seenColon) {
                                    kind = 82;
                                }
                                else if (seenAt) {
                                    kind = 77;
                                }
                                else if (seenColon) {
                                    kind = 70;
                                }
                                else {
                                    kind = 78;
                                }
                                fmt2 = LispNewlineFormat.getInstance(param1, kind);
                                break;
                            }
                            case '~': {
                                if (numParams == 0) {
                                    litbuf.append(ch);
                                    continue;
                                }
                            }
                            case '|': {
                                int count = getParam(stack, speci);
                                if (count == -1073741824) {
                                    count = 1;
                                }
                                int charVal = getParam(stack, speci + 1);
                                if (charVal == -1073741824) {
                                    charVal = ((ch == '|') ? 12 : 126);
                                }
                                fmt2 = LispCharacterFormat.getInstance(charVal, count, false, false);
                                break;
                            }
                            case '%': {
                                int count = getParam(stack, speci);
                                if (count == -1073741824) {
                                    count = 1;
                                }
                                fmt2 = LispNewlineFormat.getInstance(count, 76);
                                break;
                            }
                            case 'Q': {
                                fmt2 = LispFormat.delimitSubstitutionInstance;
                                break;
                            }
                            default: {
                                throw new ParseException("unrecognized format specifier ~" + ch, i);
                            }
                        }
                        stack.setSize(speci);
                        stack.push(fmt2);
                    }
                }
            }
            throw new ParseException("saw ~; without matching ~[ or ~<", i);
        }
        if (start_nesting >= 0) {
            throw new ParseException("missing ~] or ~}", i);
        }
        this.length = stack.size();
        stack.copyInto(this.formats = new Format[this.length]);
    }
    
    static Format[] getFormats(final Vector vector, final int start, final int end) {
        final Format[] f = new Format[end - start];
        for (int i = start; i < end; ++i) {
            f[i - start] = vector.elementAt(i);
        }
        return f;
    }
    
    static Format popFormats(final Vector vector, final int start, final int end) {
        Format f;
        if (end == start + 1) {
            f = vector.elementAt(start);
        }
        else {
            f = new CompoundFormat(getFormats(vector, start, end));
        }
        vector.setSize(start);
        return f;
    }
    
    public LispFormat(final String str) throws ParseException {
        this(str.toCharArray());
    }
    
    public LispFormat(final char[] format) throws ParseException {
        this(format, 0, format.length);
    }
    
    public static int getParam(final Vector vec, final int index) {
        if (index >= vec.size()) {
            return -1073741824;
        }
        final Object arg = vec.elementAt(index);
        if (arg == "<from list>") {
            return -1610612736;
        }
        if (arg == "<from count>") {
            return -1342177280;
        }
        if (arg == "<unspecified>") {
            return -1073741824;
        }
        return ReportFormat.getParam(arg, -1073741824);
    }
    
    public static Object[] asArray(Object arg) {
        if (arg instanceof Object[]) {
            return (Object[])arg;
        }
        if (!(arg instanceof Sequence)) {
            return null;
        }
        final int count = ((Sequence)arg).size();
        final Object[] arr = new Object[count];
        int i = 0;
        while (arg instanceof Pair) {
            final Pair pair = (Pair)arg;
            arr[i++] = pair.getCar();
            arg = pair.getCdr();
        }
        if (i < count) {
            if (!(arg instanceof Sequence)) {
                return null;
            }
            final int npairs = i;
            final Sequence seq = (Sequence)arg;
            while (i < count) {
                arr[i] = seq.get(npairs + i);
                ++i;
            }
        }
        return arr;
    }
    
    static {
        delimitSubstitutionInstance = DelimitSubstitutionFormat.getInstance(ObjectFormat.getInstance(false));
    }
}
