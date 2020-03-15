// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import java.net.URI;
import gnu.mapping.Lazy;
import gnu.xml.XMLPrinter;
import gnu.kawa.io.CheckConsole;
import gnu.kawa.xml.KNode;
import gnu.mapping.Namespace;
import gnu.expr.Keyword;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.xml.XmlNamespace;
import gnu.mapping.Symbol;
import gnu.lists.CharSeq;
import gnu.lists.Strings;
import gnu.lists.GeneralArray;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.format.Printable;
import gnu.lists.Consumable;
import gnu.mapping.Values;
import java.util.Iterator;
import gnu.lists.SimpleVector;
import java.util.List;
import gnu.lists.Range;
import gnu.kawa.io.OutPort;
import gnu.lists.Array;
import gnu.kawa.io.PrettyWriter;
import gnu.mapping.Promise;
import gnu.lists.Pair;
import gnu.lists.PrintConsumer;
import gnu.lists.LList;
import gnu.math.IntNum;
import java.math.BigInteger;
import gnu.math.UnsignedPrim;
import gnu.math.RatNum;
import gnu.text.Char;
import gnu.lists.Consumer;
import gnu.kawa.format.AbstractFormat;
import java.util.regex.Pattern;
import gnu.mapping.ThreadLocation;
import gnu.kawa.format.GenericFormat;

public class DisplayFormat extends GenericFormat
{
    public static GenericFormat standardFormat;
    public static final ThreadLocation outBase;
    public static final ThreadLocation outRadix;
    public static final DisplayFormat schemeDisplayFormat;
    public static final DisplayFormat schemeWriteSimpleFormat;
    public static final DisplayFormat schemeWriteFormat;
    public static final DisplayFormat schemeWriteSharedFormat;
    public int checkSharing;
    boolean readable;
    char language;
    static Pattern r5rsIdentifierMinusInteriorColons;
    
    public DisplayFormat(final boolean readable, final char language) {
        super(DisplayFormat.standardFormat);
        this.checkSharing = -1;
        this.readable = readable;
        this.language = language;
    }
    
    public static DisplayFormat getEmacsLispFormat(final boolean readable) {
        return new DisplayFormat(readable, 'E');
    }
    
    public static DisplayFormat getCommonLispFormat(final boolean readable) {
        return new DisplayFormat(readable, 'C');
    }
    
    public static DisplayFormat getSchemeFormat(final boolean readable) {
        return new DisplayFormat(readable, 'S');
    }
    
    @Override
    public boolean getReadableOutput() {
        return this.readable;
    }
    
    @Override
    public boolean textIsCopied() {
        return !this.readable;
    }
    
    @Override
    public void writeBoolean(final boolean v, final Consumer out) {
        this.write((this.language == 'S') ? (v ? "#t" : "#f") : (v ? "t" : "nil"), out);
    }
    
    public static TryFormatResult writeBoolean(final Object v, final AbstractFormat f, final Consumer out) {
        if (!(v instanceof Boolean)) {
            return TryFormatResult.INVALID_CLASS;
        }
        f.writeBoolean((boolean)v, out);
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writeChar(final Object v, final AbstractFormat f, final Consumer out) {
        boolean readable;
        char language;
        if (f instanceof DisplayFormat) {
            final DisplayFormat dformat = (DisplayFormat)f;
            readable = dformat.readable;
            language = dformat.language;
        }
        else {
            readable = false;
            language = 'S';
        }
        if (v instanceof Char) {
            writeChar(((Char)v).intValue(), readable, language, out);
            return TryFormatResult.HANDLED;
        }
        if (v instanceof Character) {
            writeChar((char)v, readable, language, out);
            return TryFormatResult.HANDLED;
        }
        return TryFormatResult.INVALID_CLASS;
    }
    
    public static TryFormatResult writeRational(final Object obj, final AbstractFormat format, final Consumer out) {
        if (obj instanceof RatNum || obj instanceof UnsignedPrim || (obj instanceof Number && (obj instanceof Long || obj instanceof Integer || obj instanceof Short || obj instanceof Byte || obj instanceof BigInteger))) {
            int b = 10;
            boolean showRadix = false;
            final Object base = DisplayFormat.outBase.get(null);
            final Object printRadix = DisplayFormat.outRadix.get(null);
            if (printRadix != null && (printRadix == Boolean.TRUE || "yes".equals(printRadix.toString()))) {
                showRadix = true;
            }
            if (base instanceof Number) {
                b = ((IntNum)base).intValue();
            }
            else if (base != null) {
                b = Integer.parseInt(base.toString());
            }
            final String asString = Arithmetic.asRatNum(obj).toString(b);
            if (showRadix) {
                if (b == 16) {
                    out.write("#x");
                }
                else if (b == 8) {
                    out.write("#o");
                }
                else if (b == 2) {
                    out.write("#b");
                }
                else if (b != 10 || !(obj instanceof IntNum)) {
                    out.write("#" + base + "r");
                }
            }
            out.write(asString);
            if (showRadix && b == 10 && obj instanceof IntNum) {
                out.write(".");
            }
            return TryFormatResult.HANDLED;
        }
        return TryFormatResult.INVALID_CLASS;
    }
    
    public static void writeChar(final int v, final boolean readable, final char language, final Consumer out) {
        if (!readable) {
            Char.print(v, out);
        }
        else if (language == 'E' && v > 32) {
            out.write(63);
            Char.print(v, out);
        }
        else {
            out.write(Char.toScmReadableString(v));
        }
    }
    
    public static TryFormatResult writeList(Object list, final AbstractFormat format, final Consumer out) {
        if (!(list instanceof LList)) {
            return TryFormatResult.INVALID_CLASS;
        }
        final PrettyWriter pout = (out instanceof PrintConsumer) ? ((PrintConsumer)out).getPrettyWriter() : null;
        final boolean readable = format instanceof DisplayFormat && ((DisplayFormat)format).readable;
        int[] posnStack = null;
        final int checkSharing = (format instanceof DisplayFormat) ? ((DisplayFormat)format).checkSharing : -1;
        Object[] tailStack = null;
        int stackTail = 0;
        PrintConsumer.startLogicalBlock("(", false, ")", out);
        while (list instanceof Pair) {
            final Pair pair = (Pair)list;
            format.writeObject(pair.getCar(), out);
            list = pair.getCdr();
            if (!readable) {
                list = Promise.force(list);
            }
            if (list == LList.Empty) {
                break;
            }
            PrintConsumer.writeSpaceFill(out);
            if (!(list instanceof Pair)) {
                out.write(". ");
                format.writeObject(LList.checkNonList(list), out);
                break;
            }
            if (pout == null || checkSharing < 0) {
                continue;
            }
            final int hashIndex = pout.IDHashLookup(list);
            int posn = pout.IDHashGetFromIndex(hashIndex);
            if (posn != -1) {
                out.write(". ");
                pout.writeBreak(70);
                pout.writeBackReference(posn);
                list = LList.Empty;
                break;
            }
            posn = pout.writePositionMarker(true);
            if (posnStack == null) {
                posnStack = new int[128];
                tailStack = new Object[128];
            }
            else if (stackTail >= posnStack.length) {
                final int[] newPStack = new int[posnStack.length << 1];
                System.arraycopy(posnStack, 0, newPStack, 0, stackTail);
                posnStack = newPStack;
                final Object[] newTStack = new Object[posnStack.length << 1];
                System.arraycopy(tailStack, 0, newTStack, 0, stackTail);
                tailStack = newTStack;
            }
            posnStack[stackTail] = posn;
            pout.IDHashPutAtIndex(tailStack[stackTail++] = list, posn, hashIndex);
        }
        while (--stackTail >= 0) {
            pout.writePairEnd(posnStack[stackTail]);
            if (checkSharing == 0) {
                pout.IDHashRemove(tailStack[stackTail]);
            }
        }
        PrintConsumer.endLogicalBlock(")", out);
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writeArray(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof Array)) {
            return TryFormatResult.INVALID_CLASS;
        }
        if (!format.getReadableOutput() && out instanceof OutPort && ((OutPort)out).atLineStart() && ((OutPort)out).isPrettyPrinting()) {
            out.write(ArrayPrint.print(value, null));
        }
        else {
            write((Array)value, 0, 0, format, out);
        }
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writeRange(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof Range)) {
            return TryFormatResult.INVALID_CLASS;
        }
        final Range range = (Range)value;
        if (!format.getReadableOutput() && !range.isUnspecifiedStart()) {
            return writeSequence(range, format, out);
        }
        PrintConsumer.startLogicalBlock("[", false, "]", out);
        final Object rstart = range.getStart();
        final Object rstep = range.getStep();
        final IntNum istep = IntNum.asIntNumOrNull(rstep);
        final IntNum istart = IntNum.asIntNumOrNull(rstart);
        if (range.isUnspecifiedStart()) {
            if (istep.isOne()) {
                out.write("<:");
            }
            else if (istep.isMinusOne()) {
                out.write(">:");
            }
            else {
                out.write("by: ");
                format.writeObject(rstep, out);
            }
        }
        else {
            format.writeObject(rstart, out);
            final int rsize = range.size();
            if (!range.isUnbounded() && istart != null && istep != null && (istep.isOne() || istep.isMinusOne())) {
                if (istep.isOne()) {
                    out.write(" <: ");
                    format.writeObject(IntNum.add(istart, rsize), out);
                }
                else {
                    out.write(" >: ");
                    format.writeObject(IntNum.add(istart, -rsize), out);
                }
            }
            else {
                out.write(" by: ");
                format.writeObject(rstep, out);
                if (!range.isUnbounded()) {
                    out.write(" size: ");
                    out.writeInt(rsize);
                }
            }
        }
        PrintConsumer.endLogicalBlock("]", out);
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writeJavaArray(final Object value, final AbstractFormat format, final Consumer out) {
        if (value == null || !value.getClass().isArray()) {
            return TryFormatResult.INVALID_CLASS;
        }
        final int len = java.lang.reflect.Array.getLength(value);
        PrintConsumer.startLogicalBlock("[", false, "]", out);
        for (int i = 0; i < len; ++i) {
            if (i > 0) {
                PrintConsumer.writeSpaceFill(out);
            }
            format.writeObject(java.lang.reflect.Array.get(value, i), out);
        }
        PrintConsumer.endLogicalBlock("]", out);
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writeSequence(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof List)) {
            return TryFormatResult.INVALID_CLASS;
        }
        final List vec = (List)value;
        final String tag = (vec instanceof SimpleVector) ? ((SimpleVector)vec).getTag() : null;
        String start;
        String end;
        if (format instanceof DisplayFormat && ((DisplayFormat)format).language == 'E') {
            start = "[";
            end = "]";
        }
        else if ("b".equals(tag)) {
            start = "#*";
            end = "";
        }
        else {
            start = ((tag == null) ? "#(" : ("#" + tag + "("));
            end = ")";
        }
        PrintConsumer.startLogicalBlock(start, false, end, out);
        if ("b".equals(tag)) {
            final SimpleVector bvec = (SimpleVector)vec;
            for (int blen = vec.size(), i = 0; i < blen; ++i) {
                final boolean b = bvec.getBooleanRaw(bvec.effectiveIndex(i));
                out.write(b ? 49 : 48);
            }
        }
        else if (vec instanceof SimpleVector && tag != null) {
            for (int endpos = vec.size() << 1, ipos = 0; ipos < endpos; ipos += 2) {
                if (ipos > 0) {
                    PrintConsumer.writeSpaceFill(out);
                }
                if (!((SimpleVector)vec).consumeNext(ipos, out)) {
                    break;
                }
            }
        }
        else {
            boolean first = true;
            for (final Object el : vec) {
                if (first) {
                    first = false;
                }
                else {
                    PrintConsumer.writeSpaceFill(out);
                }
                format.writeObject(el, out);
            }
        }
        PrintConsumer.endLogicalBlock(end, out);
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writeValues(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof Values)) {
            return TryFormatResult.INVALID_CLASS;
        }
        if (value == Values.empty && format.getReadableOutput()) {
            out.write("#!void");
        }
        else {
            final Values values = (Values)value;
            int it = 0;
            while ((it = values.nextPos(it)) != 0) {
                final Object val = values.getPosPrevious(it);
                format.writeObject(val, out);
            }
        }
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writePrintableConsumable(final Object value, final AbstractFormat format, final Consumer out) {
        if (value instanceof Consumable && (!format.getReadableOutput() || !(value instanceof Printable))) {
            ((Consumable)value).consume(out);
        }
        else {
            if (!(value instanceof Printable)) {
                return TryFormatResult.INVALID_CLASS;
            }
            ((Printable)value).print(out);
        }
        return TryFormatResult.HANDLED;
    }
    
    @Override
    public void writeObject(final Object obj, final Consumer out) {
        final PrettyWriter pout = (out instanceof PrintConsumer) ? ((PrintConsumer)out).getPrettyWriter() : null;
        boolean popIDHashNeeded = false;
        boolean space = false;
        boolean skip = false;
        if (out instanceof PrintConsumer && !(obj instanceof UntypedAtomic) && !(obj instanceof Values) && (this.getReadableOutput() || (!(obj instanceof Char) && !(obj instanceof Character) && !(obj instanceof CharSequence)))) {
            ((PrintConsumer)out).writeWordStart();
            space = true;
        }
        boolean removeNeeded = false;
        try {
            if (pout != null && this.checkSharing >= 0 && this.isInteresting(obj)) {
                popIDHashNeeded = pout.initialiseIDHash();
                pout.setSharing(true);
                final int hashIndex = pout.IDHashLookup(obj);
                final int posn = pout.IDHashGetFromIndex(hashIndex);
                if (posn == -1) {
                    final int nposn = pout.writePositionMarker(false);
                    pout.IDHashPutAtIndex(obj, nposn, hashIndex);
                    removeNeeded = (this.checkSharing == 0);
                    skip = false;
                }
                else {
                    pout.writeBackReference(posn);
                    skip = true;
                    space = true;
                }
            }
            if (!skip) {
                super.writeObject(obj, out);
            }
        }
        finally {
            if (removeNeeded) {
                pout.IDHashRemove(obj);
            }
            if (space) {
                ((PrintConsumer)out).writeWordEnd();
            }
            if (popIDHashNeeded) {
                pout.setSharing(true);
                pout.finishIDHash();
            }
        }
    }
    
    public static TryFormatResult writeObjectDefault(final Object obj, final AbstractFormat format, final Consumer out) {
        final boolean readable = format.getReadableOutput();
        final char language = (format instanceof DisplayFormat) ? ((DisplayFormat)format).language : 'S';
        if (obj instanceof Consumable && (!readable || !(obj instanceof Printable))) {
            ((Consumable)obj).consume(out);
        }
        else if (obj instanceof Printable) {
            ((Printable)obj).print(out);
        }
        else {
            final String asString = (obj == null) ? null : obj.toString();
            out.write((asString == null) ? "#!null" : asString);
        }
        return TryFormatResult.HANDLED;
    }
    
    static int write(final Array array, int index, int level, final AbstractFormat format, final Consumer out) {
        final int rank = array.rank();
        int count = 0;
        String start;
        if (level > 0) {
            start = "(";
        }
        else {
            final boolean printDims = false;
            int i = rank;
            while (--i >= 0 && array.getLowBound(i) == 0 && array.getSize(i) != 0) {}
            final StringBuilder sbuf = new StringBuilder();
            sbuf.append('#');
            sbuf.append(rank);
            final String tag = (array instanceof GeneralArray) ? ((GeneralArray<Object>)array).getTag() : null;
            sbuf.append((tag == null) ? Character.valueOf('a') : tag);
            if (i >= 0) {
                for (i = 0; i < rank; ++i) {
                    final int low = array.getLowBound(i);
                    if (low != 0) {
                        sbuf.append('@');
                        sbuf.append(low);
                    }
                    sbuf.append(':');
                    sbuf.append(array.getSize(i));
                }
            }
            sbuf.append((rank == 0) ? ' ' : '(');
            start = sbuf.toString();
        }
        final String end = (rank == 0) ? "" : ")";
        PrintConsumer.startLogicalBlock(start, false, end, out);
        if (rank > 0) {
            final int size = array.getSize(level);
            ++level;
            for (int j = 0; j < size; ++j) {
                if (j > 0) {
                    PrintConsumer.writeSpaceFill(out);
                }
                int step;
                if (level == rank) {
                    format.writeObject(array.getRowMajor(index), out);
                    step = 1;
                }
                else {
                    step = write(array, index, level, format, out);
                }
                index += step;
                count += step;
            }
        }
        else {
            format.writeObject(array.getRowMajor(index), out);
        }
        PrintConsumer.endLogicalBlock(end, out);
        return count;
    }
    
    public static TryFormatResult writeCharSeq(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof CharSequence)) {
            return TryFormatResult.INVALID_CLASS;
        }
        final CharSequence str = (CharSequence)value;
        if (format.getReadableOutput()) {
            Strings.printQuoted(str, out, 1);
        }
        else if (value instanceof String) {
            out.write((String)value);
        }
        else if (value instanceof CharSeq) {
            final CharSeq seq = (CharSeq)value;
            seq.consume(0, seq.size(), out);
        }
        else {
            for (int len = str.length(), i = 0; i < len; ++i) {
                out.write(str.charAt(i));
            }
        }
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writeEnum(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof Enum)) {
            return TryFormatResult.INVALID_CLASS;
        }
        if (!format.getReadableOutput()) {
            return TryFormatResult.INVALID;
        }
        out.write(value.getClass().getName());
        out.write(":");
        out.write(((Enum)value).name());
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writeSymbol(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof Symbol)) {
            return TryFormatResult.INVALID_CLASS;
        }
        final Symbol sym = (Symbol)value;
        final Namespace ns = sym.getNamespace();
        if (ns == XmlNamespace.HTML) {
            out.write("html:");
            out.write(sym.getLocalPart());
        }
        else if (ns == LispLanguage.entityNamespace || ns == LispLanguage.constructNamespace) {
            out.write(ns.getPrefix());
            out.write(":");
            out.write(sym.getLocalPart());
        }
        else {
            final String prefix = sym.getPrefix();
            final Namespace namespace = sym.getNamespace();
            final String uri = (namespace == null) ? null : namespace.getName();
            final boolean readable = format.getReadableOutput();
            final boolean hasUri = uri != null && uri.length() > 0;
            final boolean hasPrefix = prefix != null && prefix.length() > 0;
            boolean suffixColon = false;
            if (namespace == Keyword.keywordNamespace) {
                final char language = (format instanceof DisplayFormat) ? ((DisplayFormat)format).language : 'S';
                if (language == 'C' || language == 'E') {
                    out.write(58);
                }
                else {
                    suffixColon = true;
                }
            }
            else if (hasPrefix || hasUri) {
                if (hasPrefix) {
                    writeSymbol(prefix, out, readable);
                }
                if (hasUri && (readable || !hasPrefix)) {
                    out.write(123);
                    out.write(uri);
                    out.write(125);
                }
                out.write(58);
            }
            writeSymbol(sym.getName(), out, readable);
            if (suffixColon) {
                out.write(58);
            }
        }
        return TryFormatResult.HANDLED;
    }
    
    static void writeSymbol(final String sym, final Consumer out, final boolean readable) {
        if (readable && !DisplayFormat.r5rsIdentifierMinusInteriorColons.matcher(sym).matches()) {
            final int len = sym.length();
            final boolean r7rsStyle = true;
            if (r7rsStyle) {
                out.write(124);
                for (int i = 0; i < len; ++i) {
                    int ch = sym.charAt(i);
                    if (ch >= 55296 && ch <= 56319) {
                        final char next = sym.charAt(++i);
                        if (next >= '\udc00' && next <= '\udfff') {
                            ch = (ch - 55296 << 10) + (next - '\udc00') + 65536;
                        }
                    }
                    if (ch == 124 || ch == 92 || ch < 32 || ch == 127) {
                        out.write(92);
                        switch (ch) {
                            case 7: {
                                out.write(97);
                                break;
                            }
                            case 8: {
                                out.write(98);
                                break;
                            }
                            case 10: {
                                out.write(110);
                                break;
                            }
                            case 13: {
                                out.write(114);
                                break;
                            }
                            case 9: {
                                out.write(116);
                                break;
                            }
                            case 92: {
                                out.write(92);
                                break;
                            }
                            case 124: {
                                out.write(124);
                                break;
                            }
                            default: {
                                out.write(120);
                                writeHexDigits(ch, out);
                                out.write(59);
                                break;
                            }
                        }
                    }
                    else {
                        Char.print(ch, out);
                    }
                }
                out.write(124);
            }
            else if (len == 0) {
                out.write("||");
            }
            else {
                boolean inVerticalBars = false;
                for (int j = 0; j < len; ++j) {
                    final char ch2 = sym.charAt(j);
                    if (ch2 == '|') {
                        out.write(inVerticalBars ? "|\\" : "\\");
                        inVerticalBars = false;
                    }
                    else if (!inVerticalBars) {
                        out.write(124);
                        inVerticalBars = true;
                    }
                    out.write(ch2);
                }
                if (inVerticalBars) {
                    out.write(124);
                }
            }
            return;
        }
        out.write(sym);
    }
    
    public static TryFormatResult writeKNode(final Object value, final AbstractFormat format, final Consumer out) {
        if (value instanceof KNode) {
            boolean escapeForDomTerm = false;
            if (format.getReadableOutput()) {
                out.write("#");
            }
            else if (CheckConsole.forDomTerm(out)) {
                out.write("\u001b]72;");
                escapeForDomTerm = true;
            }
            XMLPrinter.make(out, "xhtml").writeObject(value);
            if (escapeForDomTerm) {
                out.write("\u0007");
            }
            return TryFormatResult.HANDLED;
        }
        return TryFormatResult.INVALID_CLASS;
    }
    
    public static TryFormatResult writePromise(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof Lazy)) {
            return TryFormatResult.INVALID_CLASS;
        }
        if (format.getReadableOutput()) {
            return TryFormatResult.INVALID;
        }
        format.writeObject(((Lazy)value).getValue(), out);
        return TryFormatResult.HANDLED;
    }
    
    public static TryFormatResult writeURI(final Object value, final AbstractFormat format, final Consumer out) {
        if (!(value instanceof URI)) {
            return TryFormatResult.INVALID_CLASS;
        }
        if (!format.getReadableOutput()) {
            return TryFormatResult.INVALID;
        }
        out.write("#,(URI ");
        Strings.printQuoted(value.toString(), out, 1);
        out.write(41);
        return TryFormatResult.HANDLED;
    }
    
    static void writeHexDigits(int i, final Consumer out) {
        final int high = i >>> 4;
        if (high != 0) {
            writeHexDigits(high, out);
            i &= 0xF;
        }
        out.write("0123456789ABCDEF".charAt(i));
    }
    
    private boolean isInteresting(final Object obj) {
        return obj instanceof Pair || obj instanceof SimpleVector;
    }
    
    static {
        DisplayFormat.standardFormat = new GenericFormat();
        final Class thisCls = DisplayFormat.class;
        DisplayFormat.standardFormat.add(thisCls, "writeObjectDefault");
        DisplayFormat.standardFormat.add(thisCls, "writePrintableConsumable");
        DisplayFormat.standardFormat.add(thisCls, "writeValues");
        DisplayFormat.standardFormat.add(thisCls, "writeSymbol");
        DisplayFormat.standardFormat.add(thisCls, "writeBoolean");
        DisplayFormat.standardFormat.add(thisCls, "writeChar");
        DisplayFormat.standardFormat.add(thisCls, "writePromise");
        DisplayFormat.standardFormat.add(thisCls, "writeURI");
        DisplayFormat.standardFormat.add(thisCls, "writeArray");
        DisplayFormat.standardFormat.add(thisCls, "writeSequence");
        DisplayFormat.standardFormat.add(thisCls, "writeList");
        DisplayFormat.standardFormat.add(thisCls, "writeRange");
        DisplayFormat.standardFormat.add(thisCls, "writeCharSeq");
        DisplayFormat.standardFormat.add(thisCls, "writeKNode");
        DisplayFormat.standardFormat.add(thisCls, "writeRational");
        DisplayFormat.standardFormat.add(thisCls, "writeEnum");
        DisplayFormat.standardFormat.add(thisCls, "writeJavaArray");
        (outBase = new ThreadLocation("out-base")).setGlobal(IntNum.ten());
        outRadix = new ThreadLocation("out-radix");
        schemeDisplayFormat = new DisplayFormat(false, 'S');
        schemeWriteSimpleFormat = new DisplayFormat(true, 'S');
        schemeWriteFormat = new DisplayFormat(true, 'S');
        schemeWriteSharedFormat = new DisplayFormat(true, 'S');
        DisplayFormat.schemeWriteFormat.checkSharing = 0;
        DisplayFormat.schemeWriteSharedFormat.checkSharing = 1;
        DisplayFormat.r5rsIdentifierMinusInteriorColons = Pattern.compile("(([a-zA-Z]|[!$%&*/:<=>?^_~])([a-zA-Z]|[!$%&*/<=>?^_~]|[0-9]|([-+.@]))*[:]?)|([-+]|[.][.][.])");
    }
}
