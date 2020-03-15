// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.text.Lexer;

public abstract class ReadTableEntry
{
    public static final ReadTableEntry illegal;
    public static final ReadTableEntry whitespace;
    public static final ReadTableEntry singleEscape;
    public static final ReadTableEntry multipleEscape;
    public static final ReadTableEntry constituent;
    public static final ReadTableEntry brace;
    public static final ReadTableEntry ampersand;
    
    public static ReadTableEntry getIllegalInstance() {
        return ReadTableEntry.illegal;
    }
    
    public static ReadTableEntry getWhitespaceInstance() {
        return ReadTableEntry.whitespace;
    }
    
    public static ReadTableEntry getSingleEscapeInstance() {
        return ReadTableEntry.singleEscape;
    }
    
    public static ReadTableEntry getMultipleEscapeInstance() {
        return ReadTableEntry.multipleEscape;
    }
    
    public static ReadTableEntry getDigitInstance() {
        return ReadTableEntry.constituent;
    }
    
    public static ReadTableEntry getConstituentInstance() {
        return ReadTableEntry.constituent;
    }
    
    public int getKind() {
        return 5;
    }
    
    protected Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        throw new Error("invalid character");
    }
    
    public Object read(final Lexer in, final int ch, final int count, final int sharingIndex) throws IOException, SyntaxException {
        return ((LispReader)in).bindSharedObject(sharingIndex, this.read(in, ch, count));
    }
    
    static {
        illegal = new ReaderMisc(0);
        whitespace = new ReaderMisc(1);
        singleEscape = new ReaderConstituent(3);
        multipleEscape = new ReaderConstituent(4);
        constituent = new ReaderConstituent(2);
        brace = new ReaderConstituent(2);
        ampersand = new ReaderExtendedLiteral();
    }
}
