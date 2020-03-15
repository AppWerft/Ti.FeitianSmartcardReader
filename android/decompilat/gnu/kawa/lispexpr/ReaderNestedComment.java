// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.text.SyntaxException;
import java.io.IOException;
import gnu.mapping.Values;
import gnu.text.Lexer;

public class ReaderNestedComment extends ReadTableEntry
{
    char start1;
    char start2;
    char end1;
    char end2;
    static ReaderNestedComment lispInstance;
    
    public static ReaderNestedComment getLispInstance() {
        return ReaderNestedComment.lispInstance;
    }
    
    public ReaderNestedComment(final char start1, final char start2, final char end1, final char end2) {
        this.start1 = start1;
        this.start2 = start2;
        this.end1 = end1;
        this.end2 = end2;
    }
    
    public Object read(final Lexer in, final int ch, final int count) throws IOException, SyntaxException {
        this.readNestedComment((LispReader)in);
        return Values.empty;
    }
    
    public void readNestedComment(final LispReader reader) throws IOException, SyntaxException {
        final InPort port = reader.getPort();
        char saveReadState = '\0';
        if (port instanceof InPort) {
            saveReadState = port.readState;
            port.readState = this.start1;
        }
        try {
            reader.readNestedComment(this.start1, this.start2, this.end1, this.end2);
        }
        finally {
            if (port instanceof InPort) {
                port.readState = saveReadState;
            }
        }
    }
    
    static {
        ReaderNestedComment.lispInstance = new ReaderNestedComment('#', '|', '|', '#');
    }
}
