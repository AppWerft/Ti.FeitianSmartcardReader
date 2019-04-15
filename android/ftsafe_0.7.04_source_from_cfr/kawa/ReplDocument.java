/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.QueueReader;
import gnu.kawa.swingviews.SwingContent;
import gnu.lists.CharBuffer;
import gnu.mapping.Environment;
import gnu.mapping.Future;
import gnu.mapping.Values;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Reader;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import kawa.GuiInPort;
import kawa.ReplPane;
import kawa.ReplPaneOutPort;
import kawa.Shell;
import kawa.repl;

public class ReplDocument
extends DefaultStyledDocument
implements DocumentListener,
FocusListener {
    public static StyleContext styles = new StyleContext();
    public static Style defaultStyle = styles.addStyle("default", null);
    public static Style inputStyle = styles.addStyle("input", null);
    public static Style redStyle = styles.addStyle("red", null);
    static Style blueStyle = styles.addStyle("blue", null);
    static Style promptStyle = styles.addStyle("prompt", null);
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
    public int outputMark = 0;
    public int endMark = -1;
    int length = 0;
    Object closeListeners;

    public ReplDocument(Language language, Environment penvironment, boolean shared) {
        this(new SwingContent(), language, penvironment, shared);
    }

    private ReplDocument(SwingContent content, Language language, Environment penvironment, final boolean shared) {
        super(content, styles);
        this.content = content;
        ModuleBody.exitIncrement();
        this.addDocumentListener(this);
        this.language = language;
        this.in_r = new QueueReader(){

            @Override
            public void checkAvailable() {
                ReplDocument.this.checkingPendingInput();
            }
        };
        this.out_stream = new ReplPaneOutPort(this, "/dev/stdout", defaultStyle);
        this.err_stream = new ReplPaneOutPort(this, "/dev/stderr", redStyle);
        this.in_p = new GuiInPort(this.in_r, Path.valueOf("/dev/stdin"), this.out_stream, this);
        this.thread = Future.make(new repl(language){

            @Override
            public Object apply0() {
                Environment env = Environment.getCurrent();
                if (shared) {
                    env.setIndirectDefines();
                }
                ReplDocument.this.environment = env;
                Shell.run(this.language, env);
                SwingUtilities.invokeLater(new Runnable(){

                    @Override
                    public void run() {
                        ReplDocument.this.fireDocumentClosed();
                    }
                });
                return Values.empty;
            }

        }, penvironment, this.in_p, this.out_stream, this.err_stream);
        this.thread.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void enter() {
        int pos = this.pane.getCaretPosition();
        CharBuffer b = this.content.buffer;
        int len = b.length() - 1;
        this.endMark = -1;
        if (pos >= this.outputMark) {
            int lineAfterCaret = b.indexOf(10, pos);
            if (lineAfterCaret == len) {
                if (len > this.outputMark && b.charAt(len - 1) == '\n') {
                    --lineAfterCaret;
                } else {
                    this.insertString(len, "\n", null);
                }
            }
            this.endMark = lineAfterCaret;
            QueueReader queueReader = this.in_r;
            synchronized (queueReader) {
                this.in_r.notifyAll();
            }
            if (pos <= lineAfterCaret) {
                this.pane.setCaretPosition(lineAfterCaret + 1);
            }
        } else {
            int lineBefore = pos == 0 ? 0 : 1 + b.lastIndexOf(10, pos - 1);
            Element el = this.getCharacterElement(lineBefore);
            int lineAfter = b.indexOf(10, pos);
            if (el.getAttributes().isEqual(promptStyle)) {
                lineBefore = el.getEndOffset();
            }
            String str = lineAfter < 0 ? b.substring(lineBefore, len) + '\n' : b.substring(lineBefore, lineAfter + 1);
            this.pane.setCaretPosition(this.outputMark);
            this.write(str, inputStyle);
            if (this.in_r != null) {
                this.in_r.append(str, 0, str.length());
            }
        }
    }

    public synchronized void deleteOldText() {
        try {
            String str = this.getText(0, this.outputMark);
            int lineBefore = this.outputMark <= 0 ? 0 : str.lastIndexOf(10, this.outputMark - 1) + 1;
            this.remove(0, lineBefore);
        }
        catch (BadLocationException ex) {
            throw new Error(ex);
        }
    }

    @Override
    public void insertString(int pos, String str, AttributeSet style) {
        try {
            super.insertString(pos, str, style);
        }
        catch (BadLocationException ex) {
            throw new Error(ex);
        }
    }

    public void write(final String str, final AttributeSet style) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                boolean moveCaret = ReplDocument.this.pane != null && ReplDocument.this.pane.getCaretPosition() == ReplDocument.this.outputMark;
                ReplDocument.this.insertString(ReplDocument.this.outputMark, str, style);
                int len = str.length();
                ReplDocument.this.outputMark += len;
                if (moveCaret) {
                    ReplDocument.this.pane.setCaretPosition(ReplDocument.this.outputMark);
                }
            }
        });
    }

    public void checkingPendingInput() {
        SwingUtilities.invokeLater(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                int inputStart = ReplDocument.this.outputMark;
                if (inputStart <= ReplDocument.this.endMark) {
                    CharBuffer b = ReplDocument.this.content.buffer;
                    int lineAfter = b.indexOf(10, inputStart);
                    if (lineAfter == ReplDocument.this.endMark) {
                        ReplDocument.this.endMark = -1;
                    }
                    if (inputStart == ReplDocument.this.outputMark) {
                        ReplDocument.this.outputMark = lineAfter + 1;
                    }
                    if (ReplDocument.this.in_r != null) {
                        QueueReader queueReader = ReplDocument.this.in_r;
                        synchronized (queueReader) {
                            ReplDocument.this.in_r.append(b, inputStart, lineAfter + 1);
                            ReplDocument.this.in_r.notifyAll();
                        }
                    }
                }
            }
        });
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        this.pane = source instanceof ReplPane ? (ReplPane)source : null;
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.pane = null;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.textValueChanged(e);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.textValueChanged(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.textValueChanged(e);
    }

    public synchronized void textValueChanged(DocumentEvent e) {
        int pos = e.getOffset();
        int delta = this.getLength() - this.length;
        this.length += delta;
        if (pos < this.outputMark) {
            this.outputMark += delta;
        } else if (pos - delta < this.outputMark) {
            this.outputMark = pos;
        }
        if (this.endMark >= 0) {
            if (pos < this.endMark) {
                this.endMark += delta;
            } else if (pos - delta < this.endMark) {
                this.endMark = pos;
            }
        }
    }

    void close() {
        this.in_r.appendEOF();
        try {
            Thread.sleep(100L);
        }
        catch (InterruptedException ex) {
            // empty catch block
        }
        this.thread.stop();
        this.fireDocumentClosed();
        ModuleBody.exitDecrement();
    }

    public void addDocumentCloseListener(DocumentCloseListener listener) {
        if (this.closeListeners == null) {
            this.closeListeners = listener;
        } else {
            ArrayList<Object> vec;
            if (this.closeListeners instanceof ArrayList) {
                vec = (ArrayList<Object>)this.closeListeners;
            } else {
                vec = new ArrayList<Object>(10);
                vec.add(this.closeListeners);
                this.closeListeners = vec;
            }
            vec.add(listener);
        }
    }

    public void removeDocumentCloseListener(DocumentCloseListener listener) {
        if (this.closeListeners instanceof DocumentCloseListener) {
            if (this.closeListeners == listener) {
                this.closeListeners = null;
            }
        } else if (this.closeListeners != null) {
            ArrayList vec = (ArrayList)this.closeListeners;
            int i = vec.size();
            while (--i >= 0) {
                if (vec.get(i) != listener) continue;
                vec.remove(i);
            }
            if (vec.isEmpty()) {
                this.closeListeners = null;
            }
        }
    }

    void fireDocumentClosed() {
        if (this.closeListeners instanceof DocumentCloseListener) {
            ((DocumentCloseListener)this.closeListeners).closed(this);
        } else if (this.closeListeners != null) {
            ArrayList vec = (ArrayList)this.closeListeners;
            int i = vec.size();
            while (--i >= 0) {
                ((DocumentCloseListener)vec.get(i)).closed(this);
            }
        }
    }

    static {
        StyleConstants.setForeground(redStyle, Color.red);
        StyleConstants.setForeground(blueStyle, Color.blue);
        StyleConstants.setForeground(promptStyle, Color.green);
        StyleConstants.setBold(inputStyle, true);
    }

    public static interface DocumentCloseListener {
        public void closed(ReplDocument var1);
    }

}

