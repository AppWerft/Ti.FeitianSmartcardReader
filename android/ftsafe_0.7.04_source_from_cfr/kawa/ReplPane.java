/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import gnu.kawa.io.OutPort;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextPane;
import javax.swing.text.EditorKit;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import kawa.ReplDocument;
import kawa.ReplEditorKit;
import kawa.ReplPaneOutPort;

public class ReplPane
extends JTextPane
implements KeyListener {
    ReplDocument document;
    public static final String ViewableElementName = "Viewable";
    public static final String PictureElementName = "Picture";
    public static final Object ViewableAttribute = new String("Viewable");
    public static final Object PictureAttribute = new String("Picture");

    public ReplPane(ReplDocument document) {
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
        if (--this.document.paneCount == 0) {
            this.document.close();
        }
    }

    @Override
    public MutableAttributeSet getInputAttributes() {
        return ReplDocument.inputStyle;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 10) {
            this.document.enter();
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public OutPort getStdout() {
        return this.document.out_stream;
    }

    public OutPort getStderr() {
        return this.document.err_stream;
    }
}

