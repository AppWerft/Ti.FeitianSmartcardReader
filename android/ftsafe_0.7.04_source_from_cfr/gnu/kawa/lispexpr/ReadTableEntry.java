/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReaderConstituent;
import gnu.kawa.lispexpr.ReaderExtendedLiteral;
import gnu.kawa.lispexpr.ReaderMisc;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public abstract class ReadTableEntry {
    public static final ReadTableEntry illegal = new ReaderMisc(0);
    public static final ReadTableEntry whitespace = new ReaderMisc(1);
    public static final ReadTableEntry singleEscape = new ReaderConstituent(3);
    public static final ReadTableEntry multipleEscape = new ReaderConstituent(4);
    public static final ReadTableEntry constituent = new ReaderConstituent(2);
    public static final ReadTableEntry brace = new ReaderConstituent(2);
    public static final ReadTableEntry ampersand = new ReaderExtendedLiteral();

    public static ReadTableEntry getIllegalInstance() {
        return illegal;
    }

    public static ReadTableEntry getWhitespaceInstance() {
        return whitespace;
    }

    public static ReadTableEntry getSingleEscapeInstance() {
        return singleEscape;
    }

    public static ReadTableEntry getMultipleEscapeInstance() {
        return multipleEscape;
    }

    public static ReadTableEntry getDigitInstance() {
        return constituent;
    }

    public static ReadTableEntry getConstituentInstance() {
        return constituent;
    }

    public int getKind() {
        return 5;
    }

    protected Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        throw new Error("invalid character");
    }

    public Object read(Lexer in, int ch, int count, int sharingIndex) throws IOException, SyntaxException {
        return ((LispReader)in).bindSharedObject(sharingIndex, this.read(in, ch, count));
    }
}

