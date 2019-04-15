/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Compilation;
import java.util.List;

public class CommandCompleter
extends RuntimeException {
    public static final char COMPLETE_REQUEST = '\uf102';
    int prefixLength;
    public String word;
    public int wordCursor;
    public List<String> candidates;
    Compilation comp;

    public CommandCompleter(int prefixLength, List<String> candidates, String word, int wordCursor, Compilation comp) {
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

