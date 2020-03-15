// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import java.awt.event.FocusEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import gnu.lists.CharBuffer;
import gnu.kawa.io.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import javax.swing.SwingUtilities;
import gnu.kawa.io.OutPort;
import java.io.Reader;
import gnu.kawa.io.Path;
import javax.swing.text.AttributeSet;
import gnu.expr.ModuleBody;
import javax.swing.text.AbstractDocument;
import gnu.mapping.Future;
import gnu.mapping.Environment;
import gnu.expr.Language;
import gnu.kawa.io.QueueReader;
import gnu.kawa.swingviews.SwingContent;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import java.awt.event.FocusListener;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultStyledDocument;

public class ReplDocument extends DefaultStyledDocument implements DocumentListener, FocusListener
{
    public static StyleContext styles;
    public static Style defaultStyle;
    public static Style inputStyle;
    public static Style redStyle;
    static Style blueStyle;
    static Style promptStyle;
    JTextPane pane;
    int paneCount;
    SwingContent content;
    final QueueReader in_r;
    final GuiInPort in_p;
    final ReplPaneOutPort out_stream;
    final ReplPaneOutPort err_stream;
    Language language;
    Environment environment;
    Future thread;
    public int outputMark;
    public int endMark;
    int length;
    Object closeListeners;
    
    public ReplDocument(final Language language, final Environment penvironment, final boolean shared) {
        this(new SwingContent(), language, penvironment, shared);
    }
    
    private ReplDocument(final SwingContent content, final Language language, final Environment penvironment, final boolean shared) {
        super(content, ReplDocument.styles);
        this.outputMark = 0;
        this.endMark = -1;
        this.length = 0;
        this.content = content;
        ModuleBody.exitIncrement();
        this.addDocumentListener(this);
        this.language = language;
        this.in_r = new QueueReader() {
            @Override
            public void checkAvailable() {
                ReplDocument.this.checkingPendingInput();
            }
        };
        this.out_stream = new ReplPaneOutPort(this, "/dev/stdout", ReplDocument.defaultStyle);
        this.err_stream = new ReplPaneOutPort(this, "/dev/stderr", ReplDocument.redStyle);
        this.in_p = new GuiInPort(this.in_r, Path.valueOf("/dev/stdin"), this.out_stream, this);
        (this.thread = Future.make(new repl(language) {
            @Override
            public Object apply0() {
                final Environment env = Environment.getCurrent();
                if (shared) {
                    env.setIndirectDefines();
                }
                ReplDocument.this.environment = env;
                Shell.run(this.language, env);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ReplDocument.this.fireDocumentClosed();
                    }
                });
                return Values.empty;
            }
        }, penvironment, this.in_p, this.out_stream, this.err_stream)).start();
    }
    
    void enter() {
        final int pos = this.pane.getCaretPosition();
        final CharBuffer b = this.content.buffer;
        final int len = b.length() - 1;
        this.endMark = -1;
        if (pos >= this.outputMark) {
            int lineAfterCaret = b.indexOf(10, pos);
            if (lineAfterCaret == len) {
                if (len > this.outputMark && b.charAt(len - 1) == '\n') {
                    --lineAfterCaret;
                }
                else {
                    this.insertString(len, "\n", null);
                }
            }
            this.endMark = lineAfterCaret;
            synchronized (this.in_r) {
                this.in_r.notifyAll();
            }
            if (pos <= lineAfterCaret) {
                this.pane.setCaretPosition(lineAfterCaret + 1);
            }
        }
        else {
            int lineBefore = (pos == 0) ? 0 : (1 + b.lastIndexOf(10, pos - 1));
            final Element el = this.getCharacterElement(lineBefore);
            final int lineAfter = b.indexOf(10, pos);
            if (el.getAttributes().isEqual(ReplDocument.promptStyle)) {
                lineBefore = el.getEndOffset();
            }
            String str;
            if (lineAfter < 0) {
                str = b.substring(lineBefore, len) + '\n';
            }
            else {
                str = b.substring(lineBefore, lineAfter + 1);
            }
            this.pane.setCaretPosition(this.outputMark);
            this.write(str, ReplDocument.inputStyle);
            if (this.in_r != null) {
                this.in_r.append(str, 0, str.length());
            }
        }
    }
    
    public synchronized void deleteOldText() {
        try {
            final String str = this.getText(0, this.outputMark);
            final int lineBefore = (this.outputMark <= 0) ? 0 : (str.lastIndexOf(10, this.outputMark - 1) + 1);
            this.remove(0, lineBefore);
        }
        catch (BadLocationException ex) {
            throw new Error(ex);
        }
    }
    
    @Override
    public void insertString(final int pos, final String str, final AttributeSet style) {
        try {
            super.insertString(pos, str, style);
        }
        catch (BadLocationException ex) {
            throw new Error(ex);
        }
    }
    
    public void write(final String str, final AttributeSet style) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final boolean moveCaret = ReplDocument.this.pane != null && ReplDocument.this.pane.getCaretPosition() == ReplDocument.this.outputMark;
                ReplDocument.this.insertString(ReplDocument.this.outputMark, str, style);
                final int len = str.length();
                final ReplDocument this$0 = ReplDocument.this;
                this$0.outputMark += len;
                if (moveCaret) {
                    ReplDocument.this.pane.setCaretPosition(ReplDocument.this.outputMark);
                }
            }
        });
    }
    
    public void checkingPendingInput() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final int inputStart = ReplDocument.this.outputMark;
                if (inputStart <= ReplDocument.this.endMark) {
                    final CharBuffer b = ReplDocument.this.content.buffer;
                    final int lineAfter = b.indexOf(10, inputStart);
                    if (lineAfter == ReplDocument.this.endMark) {
                        ReplDocument.this.endMark = -1;
                    }
                    if (inputStart == ReplDocument.this.outputMark) {
                        ReplDocument.this.outputMark = lineAfter + 1;
                    }
                    if (ReplDocument.this.in_r != null) {
                        synchronized (ReplDocument.this.in_r) {
                            ReplDocument.this.in_r.append(b, inputStart, lineAfter + 1);
                            ReplDocument.this.in_r.notifyAll();
                        }
                    }
                }
            }
        });
    }
    
    @Override
    public void focusGained(final FocusEvent e) {
        final Object source = e.getSource();
        if (source instanceof ReplPane) {
            this.pane = (ReplPane)source;
        }
        else {
            this.pane = null;
        }
    }
    
    @Override
    public void focusLost(final FocusEvent e) {
        this.pane = null;
    }
    
    @Override
    public void changedUpdate(final DocumentEvent e) {
        this.textValueChanged(e);
    }
    
    @Override
    public void insertUpdate(final DocumentEvent e) {
        this.textValueChanged(e);
    }
    
    @Override
    public void removeUpdate(final DocumentEvent e) {
        this.textValueChanged(e);
    }
    
    public synchronized void textValueChanged(final DocumentEvent e) {
        final int pos = e.getOffset();
        final int delta = this.getLength() - this.length;
        this.length += delta;
        if (pos < this.outputMark) {
            this.outputMark += delta;
        }
        else if (pos - delta < this.outputMark) {
            this.outputMark = pos;
        }
        if (this.endMark >= 0) {
            if (pos < this.endMark) {
                this.endMark += delta;
            }
            else if (pos - delta < this.endMark) {
                this.endMark = pos;
            }
        }
    }
    
    void close() {
        this.in_r.appendEOF();
        try {
            Thread.sleep(100L);
        }
        catch (InterruptedException ex) {}
        this.thread.stop();
        this.fireDocumentClosed();
        ModuleBody.exitDecrement();
    }
    
    public void addDocumentCloseListener(final DocumentCloseListener listener) {
        if (this.closeListeners == null) {
            this.closeListeners = listener;
        }
        else {
            ArrayList vec;
            if (this.closeListeners instanceof ArrayList) {
                vec = (ArrayList)this.closeListeners;
            }
            else {
                vec = new ArrayList(10);
                vec.add(this.closeListeners);
                this.closeListeners = vec;
            }
            vec.add(listener);
        }
    }
    
    public void removeDocumentCloseListener(final DocumentCloseListener listener) {
        if (this.closeListeners instanceof DocumentCloseListener) {
            if (this.closeListeners == listener) {
                this.closeListeners = null;
            }
        }
        else if (this.closeListeners != null) {
            final ArrayList vec = (ArrayList)this.closeListeners;
            int i = vec.size();
            while (--i >= 0) {
                if (vec.get(i) == listener) {
                    vec.remove(i);
                }
            }
            if (vec.isEmpty()) {
                this.closeListeners = null;
            }
        }
    }
    
    void fireDocumentClosed() {
        if (this.closeListeners instanceof DocumentCloseListener) {
            ((DocumentCloseListener)this.closeListeners).closed(this);
        }
        else if (this.closeListeners != null) {
            final ArrayList vec = (ArrayList)this.closeListeners;
            int i = vec.size();
            while (--i >= 0) {
                vec.get(i).closed(this);
            }
        }
    }
    
    static {
        ReplDocument.styles = new StyleContext();
        ReplDocument.defaultStyle = ReplDocument.styles.addStyle("default", null);
        ReplDocument.inputStyle = ReplDocument.styles.addStyle("input", null);
        ReplDocument.redStyle = ReplDocument.styles.addStyle("red", null);
        ReplDocument.blueStyle = ReplDocument.styles.addStyle("blue", null);
        ReplDocument.promptStyle = ReplDocument.styles.addStyle("prompt", null);
        StyleConstants.setForeground(ReplDocument.redStyle, Color.red);
        StyleConstants.setForeground(ReplDocument.blueStyle, Color.blue);
        StyleConstants.setForeground(ReplDocument.promptStyle, Color.green);
        StyleConstants.setBold(ReplDocument.inputStyle, true);
    }
    
    public interface DocumentCloseListener
    {
        void closed(final ReplDocument p0);
    }
}
