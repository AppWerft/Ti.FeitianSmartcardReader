/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.TtyInPort;
import java.io.IOException;
import java.io.Reader;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import kawa.ReplDocument;

class GuiInPort
extends TtyInPort {
    ReplDocument document;

    public GuiInPort(Reader in, Path path, OutPort tie, ReplDocument document) {
        super(in, path, tie);
        this.document = document;
    }

    @Override
    public void emitPrompt(String prompt) throws IOException {
        this.document.write(prompt, ReplDocument.promptStyle);
    }
}

