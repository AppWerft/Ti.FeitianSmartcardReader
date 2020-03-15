// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.util.List;

public class CommandCompleter extends RuntimeException
{
    public static final char COMPLETE_REQUEST = '\uf102';
    int prefixLength;
    public String word;
    public int wordCursor;
    public List<String> candidates;
    Compilation comp;
    
    public CommandCompleter(final int prefixLength, final List<String> candidates, final String word, final int wordCursor, final Compilation comp) {
        this.prefixLength = prefixLength;
        this.candidates = candidates;
        this.word = word;
        this.wordCursor = wordCursor;
        this.comp = comp;
    }
    
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
    
    public Compilation getCompilation() {
        return this.comp;
    }
}
