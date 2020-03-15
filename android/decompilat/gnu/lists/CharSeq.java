// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.IOException;
import gnu.text.Char;

public interface CharSeq extends CharSequence, Sequence<Char>
{
    int length();
    
    char charAt(final int p0);
    
    void getChars(final int p0, final int p1, final char[] p2, final int p3);
    
    void setCharAt(final int p0, final char p1);
    
    void setCharacterAt(final int p0, final int p1);
    
    void fill(final char p0);
    
    void fill(final int p0, final int p1, final char p2);
    
    CharSeq subSequence(final int p0, final int p1);
    
    void writeTo(final int p0, final int p1, final Appendable p2) throws IOException;
    
    void writeTo(final Appendable p0) throws IOException;
    
    void consume(final int p0, final int p1, final Consumer p2);
    
    String toString();
}
