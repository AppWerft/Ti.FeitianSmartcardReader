/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.expr.Keyword;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.format.GenericFormat;
import gnu.kawa.format.Printable;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.ArrayPrint;
import gnu.kawa.io.CheckConsole;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.PrettyWriter;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.CharSeq;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.GeneralArray;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PrintConsumer;
import gnu.lists.Range;
import gnu.lists.SimpleVector;
import gnu.lists.Strings;
import gnu.mapping.Lazy;
import gnu.mapping.Namespace;
import gnu.mapping.Promise;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.math.RatNum;
import gnu.math.UnsignedPrim;
import gnu.text.Char;
import gnu.xml.XMLPrinter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayFormat
extends GenericFormat {
    public static GenericFormat standardFormat = new GenericFormat();
    public static final ThreadLocation outBase;
    public static final ThreadLocation outRadix;
    public static final DisplayFormat schemeDisplayFormat;
    public static final DisplayFormat schemeWriteSimpleFormat;
    public static final DisplayFormat schemeWriteFormat;
    public static final DisplayFormat schemeWriteSharedFormat;
    public int checkSharing = -1;
    boolean readable;
    char language;
    static Pattern r5rsIdentifierMinusInteriorColons;

    public DisplayFormat(boolean readable, char language) {
        super(standardFormat);
        this.readable = readable;
        this.language = language;
    }

    public static DisplayFormat getEmacsLispFormat(boolean readable) {
        return new DisplayFormat(readable, 'E');
    }

    public static DisplayFormat getCommonLispFormat(boolean readable) {
        return new DisplayFormat(readable, 'C');
    }

    public static DisplayFormat getSchemeFormat(boolean readable) {
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
    public void writeBoolean(boolean v, Consumer out) {
        this.write(this.language == 'S' ? (v ? "#t" : "#f") : (v ? "t" : "nil"), out);
    }

    public static GenericFormat.TryFormatResult writeBoolean(Object v, AbstractFormat f, Consumer out) {
        if (!(v instanceof Boolean)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        f.writeBoolean((Boolean)v, out);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeChar(Object v, AbstractFormat f, Consumer out) {
        boolean readable;
        char language;
        if (f instanceof DisplayFormat) {
            DisplayFormat dformat = (DisplayFormat)f;
            readable = dformat.readable;
            language = dformat.language;
        } else {
            readable = false;
            language = 'S';
        }
        if (v instanceof Char) {
            DisplayFormat.writeChar(((Char)v).intValue(), readable, language, out);
            return GenericFormat.TryFormatResult.HANDLED;
        }
        if (v instanceof Character) {
            DisplayFormat.writeChar(((Character)v).charValue(), readable, language, out);
            return GenericFormat.TryFormatResult.HANDLED;
        }
        return GenericFormat.TryFormatResult.INVALID_CLASS;
    }

    public static GenericFormat.TryFormatResult writeRational(Object obj, AbstractFormat format, Consumer out) {
        if (obj instanceof RatNum || obj instanceof UnsignedPrim || obj instanceof Number && (obj instanceof Long || obj instanceof Integer || obj instanceof Short || obj instanceof Byte || obj instanceof BigInteger)) {
            int b = 10;
            boolean showRadix = false;
            Object base2 = outBase.get(null);
            Object printRadix = outRadix.get(null);
            if (printRadix != null && (printRadix == Boolean.TRUE || "yes".equals(printRadix.toString()))) {
                showRadix = true;
            }
            if (base2 instanceof Number) {
                b = ((IntNum)base2).intValue();
            } else if (base2 != null) {
                b = Integer.parseInt(base2.toString());
            }
            String asString = Arithmetic.asRatNum(obj).toString(b);
            if (showRadix) {
                if (b == 16) {
                    out.write("#x");
                } else if (b == 8) {
                    out.write("#o");
                } else if (b == 2) {
                    out.write("#b");
                } else if (b != 10 || !(obj instanceof IntNum)) {
                    out.write("#" + base2 + "r");
                }
            }
            out.write(asString);
            if (showRadix && b == 10 && obj instanceof IntNum) {
                out.write(".");
            }
            return GenericFormat.TryFormatResult.HANDLED;
        }
        return GenericFormat.TryFormatResult.INVALID_CLASS;
    }

    public static void writeChar(int v, boolean readable, char language, Consumer out) {
        if (!readable) {
            Char.print(v, out);
        } else if (language == 'E' && v > 32) {
            out.write(63);
            Char.print(v, out);
        } else {
            out.write(Char.toScmReadableString(v));
        }
    }

    public static GenericFormat.TryFormatResult writeList(Object list, AbstractFormat format, Consumer out) {
        if (!(list instanceof LList)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        PrettyWriter pout = out instanceof PrintConsumer ? ((PrintConsumer)out).getPrettyWriter() : null;
        boolean readable = format instanceof DisplayFormat ? ((DisplayFormat)format).readable : false;
        int[] posnStack = null;
        int checkSharing = format instanceof DisplayFormat ? ((DisplayFormat)format).checkSharing : -1;
        Object[] tailStack = null;
        int stackTail = 0;
        PrintConsumer.startLogicalBlock("(", false, ")", out);
        while (list instanceof Pair) {
            Pair pair = (Pair)list;
            format.writeObject(pair.getCar(), out);
            list = pair.getCdr();
            if (!readable) {
                list = Promise.force(list);
            }
            if (list == LList.Empty) break;
            PrintConsumer.writeSpaceFill(out);
            if (!(list instanceof Pair)) {
                out.write(". ");
                format.writeObject(LList.checkNonList(list), out);
                break;
            }
            if (pout == null || checkSharing < 0) continue;
            int hashIndex = pout.IDHashLookup(list);
            int posn = pout.IDHashGetFromIndex(hashIndex);
            if (posn == -1) {
                posn = pout.writePositionMarker(true);
                if (posnStack == null) {
                    posnStack = new int[128];
                    tailStack = new Object[128];
                } else if (stackTail >= posnStack.length) {
                    int[] newPStack = new int[posnStack.length << 1];
                    System.arraycopy(posnStack, 0, newPStack, 0, stackTail);
                    posnStack = newPStack;
                    Object[] newTStack = new Object[posnStack.length << 1];
                    System.arraycopy(tailStack, 0, newTStack, 0, stackTail);
                    tailStack = newTStack;
                }
                posnStack[stackTail] = posn;
                tailStack[stackTail++] = list;
                pout.IDHashPutAtIndex(list, posn, hashIndex);
                continue;
            }
            out.write(". ");
            pout.writeBreak(70);
            pout.writeBackReference(posn);
            list = LList.Empty;
            break;
        }
        while (--stackTail >= 0) {
            pout.writePairEnd((int)posnStack[stackTail]);
            if (checkSharing != 0) continue;
            pout.IDHashRemove(tailStack[stackTail]);
        }
        PrintConsumer.endLogicalBlock(")", out);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeArray(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof gnu.lists.Array)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (!format.getReadableOutput() && out instanceof OutPort && ((OutPort)out).atLineStart() && ((OutPort)out).isPrettyPrinting()) {
            out.write(ArrayPrint.print(value, null));
        } else {
            DisplayFormat.write((gnu.lists.Array)value, 0, 0, format, out);
        }
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeRange(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof Range)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        Range range = (Range)value;
        if (!format.getReadableOutput() && !range.isUnspecifiedStart()) {
            return DisplayFormat.writeSequence(range, format, out);
        }
        PrintConsumer.startLogicalBlock("[", false, "]", out);
        Object rstart = range.getStart();
        Object rstep = range.getStep();
        IntNum istep = IntNum.asIntNumOrNull(rstep);
        IntNum istart = IntNum.asIntNumOrNull(rstart);
        if (range.isUnspecifiedStart()) {
            if (istep.isOne()) {
                out.write("<:");
            } else if (istep.isMinusOne()) {
                out.write(">:");
            } else {
                out.write("by: ");
                format.writeObject(rstep, out);
            }
        } else {
            format.writeObject(rstart, out);
            int rsize = range.size();
            if (!range.isUnbounded() && istart != null && istep != null && (istep.isOne() || istep.isMinusOne())) {
                if (istep.isOne()) {
                    out.write(" <: ");
                    format.writeObject((Object)IntNum.add(istart, rsize), out);
                } else {
                    out.write(" >: ");
                    format.writeObject((Object)IntNum.add(istart, -rsize), out);
                }
            } else {
                out.write(" by: ");
                format.writeObject(rstep, out);
                if (!range.isUnbounded()) {
                    out.write(" size: ");
                    out.writeInt(rsize);
                }
            }
        }
        PrintConsumer.endLogicalBlock("]", out);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeJavaArray(Object value, AbstractFormat format, Consumer out) {
        if (value == null || !value.getClass().isArray()) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        int len = Array.getLength(value);
        PrintConsumer.startLogicalBlock("[", false, "]", out);
        for (int i = 0; i < len; ++i) {
            if (i > 0) {
                PrintConsumer.writeSpaceFill(out);
            }
            format.writeObject(Array.get(value, i), out);
        }
        PrintConsumer.endLogicalBlock("]", out);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeSequence(Object value, AbstractFormat format, Consumer out) {
        String end;
        String tag;
        String start;
        if (!(value instanceof List)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        List vec = (List)value;
        String string = tag = vec instanceof SimpleVector ? ((SimpleVector)vec).getTag() : null;
        if (format instanceof DisplayFormat && ((DisplayFormat)format).language == 'E') {
            start = "[";
            end = "]";
        } else if ("b".equals(tag)) {
            start = "#*";
            end = "";
        } else {
            start = tag == null ? "#(" : "#" + tag + "(";
            end = ")";
        }
        PrintConsumer.startLogicalBlock(start, false, end, out);
        if ("b".equals(tag)) {
            SimpleVector bvec = (SimpleVector)vec;
            int blen = vec.size();
            for (int i = 0; i < blen; ++i) {
                boolean b = bvec.getBooleanRaw(bvec.effectiveIndex(i));
                out.write(b ? 49 : 48);
            }
        } else if (vec instanceof SimpleVector && tag != null) {
            int endpos = vec.size() << 1;
            for (int ipos = 0; ipos < endpos; ipos += 2) {
                if (ipos > 0) {
                    PrintConsumer.writeSpaceFill(out);
                }
                if (((SimpleVector)vec).consumeNext(ipos, out)) {
                    continue;
                }
                break;
            }
        } else {
            boolean first = true;
            for (Object el : vec) {
                if (first) {
                    first = false;
                } else {
                    PrintConsumer.writeSpaceFill(out);
                }
                format.writeObject(el, out);
            }
        }
        PrintConsumer.endLogicalBlock(end, out);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeValues(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof Values)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (value == Values.empty && format.getReadableOutput()) {
            out.write("#!void");
        } else {
            Values values = (Values)value;
            int it = 0;
            while ((it = values.nextPos(it)) != 0) {
                Object val = values.getPosPrevious(it);
                format.writeObject(val, out);
            }
        }
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writePrintableConsumable(Object value, AbstractFormat format, Consumer out) {
        if (!(!(value instanceof Consumable) || format.getReadableOutput() && value instanceof Printable)) {
            ((Consumable)value).consume(out);
        } else if (value instanceof Printable) {
            ((Printable)value).print(out);
        } else {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        return GenericFormat.TryFormatResult.HANDLED;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void writeObject(Object obj, Consumer out) {
        PrettyWriter pout = out instanceof PrintConsumer ? ((PrintConsumer)out).getPrettyWriter() : null;
        boolean popIDHashNeeded = false;
        boolean space = false;
        boolean skip = false;
        if (!(!(out instanceof PrintConsumer) || obj instanceof UntypedAtomic || obj instanceof Values || !this.getReadableOutput() && (obj instanceof Char || obj instanceof Character || obj instanceof CharSequence))) {
            ((PrintConsumer)out).writeWordStart();
            space = true;
        }
        boolean removeNeeded = false;
        try {
            if (pout != null && this.checkSharing >= 0 && this.isInteresting(obj)) {
                popIDHashNeeded = pout.initialiseIDHash();
                pout.setSharing(true);
                int hashIndex = pout.IDHashLookup(obj);
                int posn = pout.IDHashGetFromIndex(hashIndex);
                if (posn == -1) {
                    int nposn = pout.writePositionMarker(false);
                    pout.IDHashPutAtIndex(obj, nposn, hashIndex);
                    removeNeeded = this.checkSharing == 0;
                    skip = false;
                } else {
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

    public static GenericFormat.TryFormatResult writeObjectDefault(Object obj, AbstractFormat format, Consumer out) {
        int language;
        boolean readable = format.getReadableOutput();
        int n = language = format instanceof DisplayFormat ? (int)((DisplayFormat)format).language : 83;
        if (!(!(obj instanceof Consumable) || readable && obj instanceof Printable)) {
            ((Consumable)obj).consume(out);
        } else if (obj instanceof Printable) {
            ((Printable)obj).print(out);
        } else {
            String asString = obj == null ? null : obj.toString();
            out.write(asString == null ? "#!null" : asString);
        }
        return GenericFormat.TryFormatResult.HANDLED;
    }

    static int write(gnu.lists.Array array, int index, int level, AbstractFormat format, Consumer out) {
        String start;
        int rank = array.rank();
        int count = 0;
        if (level > 0) {
            start = "(";
        } else {
            boolean printDims = false;
            int i = rank;
            while (--i >= 0 && array.getLowBound(i) == 0 && array.getSize(i) != 0) {
            }
            StringBuilder sbuf = new StringBuilder();
            sbuf.append('#');
            sbuf.append(rank);
            String tag = array instanceof GeneralArray ? ((GeneralArray)array).getTag() : null;
            sbuf.append(tag == null ? Character.valueOf('a') : tag);
            if (i >= 0) {
                for (i = 0; i < rank; ++i) {
                    int low = array.getLowBound(i);
                    if (low != 0) {
                        sbuf.append('@');
                        sbuf.append(low);
                    }
                    sbuf.append(':');
                    sbuf.append(array.getSize(i));
                }
            }
            sbuf.append(rank == 0 ? (char)' ' : '(');
            start = sbuf.toString();
        }
        String end = rank == 0 ? "" : ")";
        PrintConsumer.startLogicalBlock(start, false, end, out);
        if (rank > 0) {
            int size = array.getSize(level);
            ++level;
            for (int i = 0; i < size; ++i) {
                int step;
                if (i > 0) {
                    PrintConsumer.writeSpaceFill(out);
                }
                if (level == rank) {
                    format.writeObject(array.getRowMajor(index), out);
                    step = 1;
                } else {
                    step = DisplayFormat.write(array, index, level, format, out);
                }
                index += step;
                count += step;
            }
        } else {
            format.writeObject(array.getRowMajor(index), out);
        }
        PrintConsumer.endLogicalBlock(end, out);
        return count;
    }

    public static GenericFormat.TryFormatResult writeCharSeq(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof CharSequence)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        CharSequence str = (CharSequence)value;
        if (format.getReadableOutput()) {
            Strings.printQuoted(str, out, 1);
        } else if (value instanceof String) {
            out.write((String)value);
        } else if (value instanceof CharSeq) {
            CharSeq seq = (CharSeq)value;
            seq.consume(0, seq.size(), out);
        } else {
            int len = str.length();
            for (int i = 0; i < len; ++i) {
                out.write(str.charAt(i));
            }
        }
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeEnum(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof Enum)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (!format.getReadableOutput()) {
            return GenericFormat.TryFormatResult.INVALID;
        }
        out.write(value.getClass().getName());
        out.write(":");
        out.write(((Enum)value).name());
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeSymbol(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof Symbol)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        Symbol sym = (Symbol)value;
        Namespace ns = sym.getNamespace();
        if (ns == XmlNamespace.HTML) {
            out.write("html:");
            out.write(sym.getLocalPart());
        } else if (ns == LispLanguage.entityNamespace || ns == LispLanguage.constructNamespace) {
            out.write(ns.getPrefix());
            out.write(":");
            out.write(sym.getLocalPart());
        } else {
            String prefix = sym.getPrefix();
            Namespace namespace = sym.getNamespace();
            String uri = namespace == null ? null : namespace.getName();
            boolean readable = format.getReadableOutput();
            boolean hasUri = uri != null && uri.length() > 0;
            boolean hasPrefix = prefix != null && prefix.length() > 0;
            boolean suffixColon = false;
            if (namespace == Keyword.keywordNamespace) {
                int language;
                int n = language = format instanceof DisplayFormat ? (int)((DisplayFormat)format).language : 83;
                if (language == 67 || language == 69) {
                    out.write(58);
                } else {
                    suffixColon = true;
                }
            } else if (hasPrefix || hasUri) {
                if (hasPrefix) {
                    DisplayFormat.writeSymbol(prefix, out, readable);
                }
                if (hasUri && (readable || !hasPrefix)) {
                    out.write(123);
                    out.write(uri);
                    out.write(125);
                }
                out.write(58);
            }
            DisplayFormat.writeSymbol(sym.getName(), out, readable);
            if (suffixColon) {
                out.write(58);
            }
        }
        return GenericFormat.TryFormatResult.HANDLED;
    }

    static void writeSymbol(String sym, Consumer out, boolean readable) {
        if (readable && !r5rsIdentifierMinusInteriorColons.matcher(sym).matches()) {
            int len = sym.length();
            boolean r7rsStyle = true;
            if (r7rsStyle) {
                out.write(124);
                for (int i = 0; i < len; ++i) {
                    char next;
                    int ch = sym.charAt(i);
                    if (ch >= 55296 && ch <= 56319 && (next = sym.charAt(++i)) >= '\udc00' && next <= '\udfff') {
                        ch = (ch - 55296 << 10) + (next - 56320) + 65536;
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
                                DisplayFormat.writeHexDigits(ch, out);
                                out.write(59);
                                break;
                            }
                        }
                        continue;
                    }
                    Char.print(ch, out);
                }
                out.write(124);
            } else if (len == 0) {
                out.write("||");
            } else {
                boolean inVerticalBars = false;
                for (int i = 0; i < len; ++i) {
                    char ch = sym.charAt(i);
                    if (ch == '|') {
                        out.write(inVerticalBars ? "|\\" : "\\");
                        inVerticalBars = false;
                    } else if (!inVerticalBars) {
                        out.write(124);
                        inVerticalBars = true;
                    }
                    out.write(ch);
                }
                if (inVerticalBars) {
                    out.write(124);
                }
            }
            return;
        }
        out.write(sym);
    }

    public static GenericFormat.TryFormatResult writeKNode(Object value, AbstractFormat format, Consumer out) {
        if (value instanceof KNode) {
            boolean escapeForDomTerm = false;
            if (format.getReadableOutput()) {
                out.write("#");
            } else if (CheckConsole.forDomTerm(out)) {
                out.write("\u001b]72;");
                escapeForDomTerm = true;
            }
            XMLPrinter.make(out, "xhtml").writeObject(value);
            if (escapeForDomTerm) {
                out.write("\u0007");
            }
            return GenericFormat.TryFormatResult.HANDLED;
        }
        return GenericFormat.TryFormatResult.INVALID_CLASS;
    }

    public static GenericFormat.TryFormatResult writePromise(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof Lazy)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (format.getReadableOutput()) {
            return GenericFormat.TryFormatResult.INVALID;
        }
        format.writeObject(((Lazy)value).getValue(), out);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    public static GenericFormat.TryFormatResult writeURI(Object value, AbstractFormat format, Consumer out) {
        if (!(value instanceof URI)) {
            return GenericFormat.TryFormatResult.INVALID_CLASS;
        }
        if (!format.getReadableOutput()) {
            return GenericFormat.TryFormatResult.INVALID;
        }
        out.write("#,(URI ");
        Strings.printQuoted(value.toString(), out, 1);
        out.write(41);
        return GenericFormat.TryFormatResult.HANDLED;
    }

    static void writeHexDigits(int i, Consumer out) {
        int high = i >>> 4;
        if (high != 0) {
            DisplayFormat.writeHexDigits(high, out);
            i &= 15;
        }
        out.write("0123456789ABCDEF".charAt(i));
    }

    private boolean isInteresting(Object obj) {
        return obj instanceof Pair || obj instanceof SimpleVector;
    }

    static {
        Class<DisplayFormat> thisCls = DisplayFormat.class;
        standardFormat.add(thisCls, "writeObjectDefault");
        standardFormat.add(thisCls, "writePrintableConsumable");
        standardFormat.add(thisCls, "writeValues");
        standardFormat.add(thisCls, "writeSymbol");
        standardFormat.add(thisCls, "writeBoolean");
        standardFormat.add(thisCls, "writeChar");
        standardFormat.add(thisCls, "writePromise");
        standardFormat.add(thisCls, "writeURI");
        standardFormat.add(thisCls, "writeArray");
        standardFormat.add(thisCls, "writeSequence");
        standardFormat.add(thisCls, "writeList");
        standardFormat.add(thisCls, "writeRange");
        standardFormat.add(thisCls, "writeCharSeq");
        standardFormat.add(thisCls, "writeKNode");
        standardFormat.add(thisCls, "writeRational");
        standardFormat.add(thisCls, "writeEnum");
        standardFormat.add(thisCls, "writeJavaArray");
        outBase = new ThreadLocation("out-base");
        outBase.setGlobal(IntNum.ten());
        outRadix = new ThreadLocation("out-radix");
        schemeDisplayFormat = new DisplayFormat(false, 'S');
        schemeWriteSimpleFormat = new DisplayFormat(true, 'S');
        schemeWriteFormat = new DisplayFormat(true, 'S');
        schemeWriteSharedFormat = new DisplayFormat(true, 'S');
        DisplayFormat.schemeWriteFormat.checkSharing = 0;
        DisplayFormat.schemeWriteSharedFormat.checkSharing = 1;
        r5rsIdentifierMinusInteriorColons = Pattern.compile("(([a-zA-Z]|[!$%&*/:<=>?^_~])([a-zA-Z]|[!$%&*/<=>?^_~]|[0-9]|([-+.@]))*[:]?)|([-+]|[.][.][.])");
    }
}

