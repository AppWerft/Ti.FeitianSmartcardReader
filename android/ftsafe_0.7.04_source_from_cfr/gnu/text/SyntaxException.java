/*
 * Decompiled with CFR 0.139.
 */
package gnu.text;

import gnu.text.SourceMessages;
import java.io.PrintWriter;

public class SyntaxException
extends RuntimeException {
    String header;
    SourceMessages messages;
    public int maxToPrint = 10;

    public SyntaxException(SourceMessages messages) {
        this.messages = messages;
    }

    public SyntaxException(String header, SourceMessages messages) {
        this.header = header;
        this.messages = messages;
    }

    public final String getHeader() {
        return this.header;
    }

    public final void setHeader(String header) {
        this.header = header;
    }

    public SourceMessages getMessages() {
        return this.messages;
    }

    public void printAll(PrintWriter out, int max) {
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
        StringBuilder buffer = new StringBuilder();
        if (this.header != null) {
            buffer.append(this.header);
        }
        this.messages.printAll(buffer, this.maxToPrint);
        return buffer.toString().replace("\r\n", "\n");
    }
}

