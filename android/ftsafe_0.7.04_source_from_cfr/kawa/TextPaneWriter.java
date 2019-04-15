/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import java.io.Writer;
import javax.swing.text.AttributeSet;
import kawa.ReplDocument;

class TextPaneWriter
extends Writer {
    ReplDocument document;
    AttributeSet style;
    String str = "";

    public TextPaneWriter(ReplDocument document, AttributeSet style) {
        this.document = document;
        this.style = style;
    }

    @Override
    public synchronized void write(int x) {
        this.str = this.str + (char)x;
        if (x == 10) {
            this.flush();
        }
    }

    @Override
    public void write(String str) {
        this.document.write(str, this.style);
    }

    @Override
    public synchronized void write(char[] data, int off, int len) {
        this.flush();
        if (len != 0) {
            this.write(new String(data, off, len));
        }
    }

    @Override
    public synchronized void flush() {
        String s = this.str;
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

