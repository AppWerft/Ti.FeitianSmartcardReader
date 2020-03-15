// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import java.io.IOException;
import javax.swing.text.AttributeSet;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import java.io.Reader;
import gnu.kawa.io.TtyInPort;

class GuiInPort extends TtyInPort
{
    ReplDocument document;
    
    public GuiInPort(final Reader in, final Path path, final OutPort tie, final ReplDocument document) {
        super(in, path, tie);
        this.document = document;
    }
    
    @Override
    public void emitPrompt(final String prompt) throws IOException {
        this.document.write(prompt, ReplDocument.promptStyle);
    }
}
