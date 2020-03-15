// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import gnu.kawa.io.OutPort;
import java.awt.event.KeyEvent;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.EditorKit;
import java.awt.event.FocusListener;
import javax.swing.text.StyledDocument;
import java.awt.event.KeyListener;
import javax.swing.JTextPane;

public class ReplPane extends JTextPane implements KeyListener
{
    ReplDocument document;
    public static final String ViewableElementName = "Viewable";
    public static final String PictureElementName = "Picture";
    public static final Object ViewableAttribute;
    public static final Object PictureAttribute;
    
    public ReplPane(final ReplDocument document) {
        super(document);
        this.document = document;
        document.pane = this;
        ++document.paneCount;
        this.addKeyListener(this);
        this.addFocusListener(document);
        this.setCaretPosition(document.outputMark);
    }
    
    @Override
    protected EditorKit createDefaultEditorKit() {
        return new ReplEditorKit(this);
    }
    
    @Override
    public void removeNotify() {
        super.removeNotify();
        final ReplDocument document = this.document;
        final int paneCount = document.paneCount - 1;
        document.paneCount = paneCount;
        if (paneCount == 0) {
            this.document.close();
        }
    }
    
    @Override
    public MutableAttributeSet getInputAttributes() {
        return ReplDocument.inputStyle;
    }
    
    @Override
    public void keyPressed(final KeyEvent e) {
        final int code = e.getKeyCode();
        if (code == 10) {
            this.document.enter();
            e.consume();
        }
    }
    
    @Override
    public void keyReleased(final KeyEvent e) {
    }
    
    @Override
    public void keyTyped(final KeyEvent e) {
    }
    
    public OutPort getStdout() {
        return this.document.out_stream;
    }
    
    public OutPort getStderr() {
        return this.document.err_stream;
    }
    
    static {
        ViewableAttribute = new String("Viewable");
        PictureAttribute = new String("Picture");
    }
}
