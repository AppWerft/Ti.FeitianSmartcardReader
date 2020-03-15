// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

import java.io.PrintWriter;

public class SyntaxException extends RuntimeException
{
    String header;
    SourceMessages messages;
    public int maxToPrint;
    
    public SyntaxException(final SourceMessages messages) {
        this.maxToPrint = 10;
        this.messages = messages;
    }
    
    public SyntaxException(final String header, final SourceMessages messages) {
        this.maxToPrint = 10;
        this.header = header;
        this.messages = messages;
    }
    
    public final String getHeader() {
        return this.header;
    }
    
    public final void setHeader(final String header) {
        this.header = header;
    }
    
    public SourceMessages getMessages() {
        return this.messages;
    }
    
    public void printAll(final PrintWriter out, final int max) {
        if (this.header != null) {
            out.println(this.header);
        }
        this.messages.printAll(out, max);
    }
    
    public void clear() {
        this.messages.clear();
    }
    
    @Override
    public String getMessage() {
        final StringBuilder buffer = new StringBuilder();
        if (this.header != null) {
            buffer.append(this.header);
        }
        this.messages.printAll(buffer, this.maxToPrint);
        return buffer.toString().replace("\r\n", "\n");
    }
}
