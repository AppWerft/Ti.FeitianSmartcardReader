// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import javax.swing.text.AttributeSet;
import java.io.Writer;

class TextPaneWriter extends Writer
{
    ReplDocument document;
    AttributeSet style;
    String str;
    
    public TextPaneWriter(final ReplDocument document, final AttributeSet style) {
        this.str = "";
        this.document = document;
        this.style = style;
    }
    
    @Override
    public synchronized void write(final int x) {
        this.str += (char)x;
        if (x == 10) {
            this.flush();
        }
    }
    
    @Override
    public void write(final String str) {
        this.document.write(str, this.style);
    }
    
    @Override
    public synchronized void write(final char[] data, final int off, final int len) {
        this.flush();
        if (len != 0) {
            this.write(new String(data, off, len));
        }
    }
    
    @Override
    public synchronized void flush() {
        final String s = this.str;
        if (!s.equals("")) {
            this.str = "";
            this.write(s);
        }
    }
    
    @Override
    public void close() {
        this.flush();
    }
}
