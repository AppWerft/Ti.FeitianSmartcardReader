package kawa;

import gnu.expr.Language;
import gnu.kawa.io.QueueReader;
import gnu.kawa.swingviews.SwingContent;
import gnu.lists.CharBuffer;
import gnu.mapping.Environment;
import gnu.mapping.Future;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class ReplDocument extends javax.swing.text.DefaultStyledDocument implements javax.swing.event.DocumentListener, java.awt.event.FocusListener
{
  public static StyleContext styles = new StyleContext();
  public static Style defaultStyle = styles.addStyle("default", null);
  public static Style inputStyle = styles.addStyle("input", null);
  public static Style redStyle = styles.addStyle("red", null);
  static Style blueStyle = styles.addStyle("blue", null);
  static Style promptStyle = styles.addStyle("prompt", null);
  
  static { StyleConstants.setForeground(redStyle, Color.red);
    StyleConstants.setForeground(blueStyle, Color.blue);
    StyleConstants.setForeground(promptStyle, Color.green);
    StyleConstants.setBold(inputStyle, true);
  }
  

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
  
  public ReplDocument(Language language, Environment penvironment, boolean shared)
  {
    this(new SwingContent(), language, penvironment, shared);
  }
  

  private ReplDocument(SwingContent content, Language language, Environment penvironment, final boolean shared)
  {
    super(content, styles);
    this.content = content;
    gnu.expr.ModuleBody.exitIncrement();
    
    addDocumentListener(this);
    
    this.language = language;
    
    in_r = new QueueReader()
    {
      public void checkAvailable()
      {
        checkingPendingInput();
      }
    };
    out_stream = new ReplPaneOutPort(this, "/dev/stdout", defaultStyle);
    err_stream = new ReplPaneOutPort(this, "/dev/stderr", redStyle);
    in_p = new GuiInPort(in_r, gnu.kawa.io.Path.valueOf("/dev/stdin"), out_stream, this);
    

    thread = Future.make(new repl(language)
    {
      public Object apply0()
      {
        Environment env = Environment.getCurrent();
        if (shared)
          env.setIndirectDefines();
        environment = env;
        Shell.run(language, env);
        SwingUtilities.invokeLater(new Runnable() {
          public void run() { fireDocumentClosed(); }
        });
        return gnu.mapping.Values.empty; } }, penvironment, in_p, out_stream, err_stream);
    

    thread.start();
  }
  

























  void enter()
  {
    int pos = pane.getCaretPosition();
    CharBuffer b = content.buffer;
    int len = b.length() - 1;
    endMark = -1;
    if (pos >= outputMark)
    {
      int lineAfterCaret = b.indexOf(10, pos);
      if (lineAfterCaret == len)
      {
        if ((len > outputMark) && (b.charAt(len - 1) == '\n')) {
          lineAfterCaret--;
        } else
          insertString(len, "\n", null);
      }
      endMark = lineAfterCaret;
      




      synchronized (in_r)
      {
        in_r.notifyAll();
      }
      if (pos <= lineAfterCaret) {
        pane.setCaretPosition(lineAfterCaret + 1);
      }
    }
    else {
      int lineBefore = pos == 0 ? 0 : 1 + b.lastIndexOf(10, pos - 1);
      Element el = getCharacterElement(lineBefore);
      int lineAfter = b.indexOf(10, pos);
      
      if (el.getAttributes().isEqual(promptStyle))
        lineBefore = el.getEndOffset();
      String str;
      String str; if (lineAfter < 0) {
        str = b.substring(lineBefore, len) + '\n';
      } else
        str = b.substring(lineBefore, lineAfter + 1);
      pane.setCaretPosition(outputMark);
      write(str, inputStyle);
      
      if (in_r != null) {
        in_r.append(str, 0, str.length());
      }
    }
  }
  


  public synchronized void deleteOldText()
  {
    try
    {
      String str = getText(0, outputMark);
      int lineBefore = outputMark <= 0 ? 0 : str.lastIndexOf('\n', outputMark - 1) + 1;
      
      remove(0, lineBefore);

    }
    catch (BadLocationException ex)
    {

      throw new Error(ex);
    }
  }
  




  public void insertString(int pos, String str, AttributeSet style)
  {
    try
    {
      super.insertString(pos, str, style);

    }
    catch (BadLocationException ex)
    {
      throw new Error(ex);
    }
  }
  







  public void write(final String str, final AttributeSet style)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run() {
        boolean moveCaret = (pane != null) && (pane.getCaretPosition() == outputMark);
        
        insertString(outputMark, str, style);
        int len = str.length();
        outputMark += len;
        if (moveCaret) {
          pane.setCaretPosition(outputMark);
        }
      }
    });
  }
  




  public void checkingPendingInput()
  {
    SwingUtilities.invokeLater(new Runnable()
    {

      public void run()
      {
        int inputStart = outputMark;
        if (inputStart <= endMark)
        {
          CharBuffer b = content.buffer;
          int lineAfter = b.indexOf(10, inputStart);
          if (lineAfter == endMark)
            endMark = -1;
          if (inputStart == outputMark)
            outputMark = (lineAfter + 1);
          if (in_r != null) {
            synchronized (in_r) {
              in_r.append(b, inputStart, lineAfter + 1);
              in_r.notifyAll();
            }
          }
        }
      }
    });
  }
  
  public void focusGained(FocusEvent e)
  {
    Object source = e.getSource();
    if ((source instanceof ReplPane))
    {
      pane = ((ReplPane)source);
    }
    else
    {
      pane = null;
    }
  }
  
  public void focusLost(FocusEvent e) {
    pane = null;
  }
  
  public void changedUpdate(DocumentEvent e) { textValueChanged(e); }
  public void insertUpdate(DocumentEvent e) { textValueChanged(e); }
  public void removeUpdate(DocumentEvent e) { textValueChanged(e); }
  


  public synchronized void textValueChanged(DocumentEvent e)
  {
    int pos = e.getOffset();
    int delta = getLength() - length;
    length += delta;
    if (pos < outputMark) {
      outputMark += delta;
    } else if (pos - delta < outputMark)
      outputMark = pos;
    if (endMark >= 0)
    {
      if (pos < endMark) {
        endMark += delta;
      } else if (pos - delta < endMark)
        endMark = pos;
    }
  }
  
  void close() {
    in_r.appendEOF();
    try
    {
      Thread.sleep(100L);
    }
    catch (InterruptedException ex) {}
    

    thread.stop();
    fireDocumentClosed();
    gnu.expr.ModuleBody.exitDecrement();
  }
  




  public void addDocumentCloseListener(DocumentCloseListener listener)
  {
    if (closeListeners == null) {
      closeListeners = listener;
    } else {
      ArrayList vec;
      ArrayList vec;
      if ((closeListeners instanceof ArrayList)) {
        vec = (ArrayList)closeListeners;
      }
      else {
        vec = new ArrayList(10);
        vec.add(closeListeners);
        closeListeners = vec;
      }
      vec.add(listener);
    }
  }
  
  public void removeDocumentCloseListener(DocumentCloseListener listener)
  {
    if ((closeListeners instanceof DocumentCloseListener))
    {
      if (closeListeners == listener) {
        closeListeners = null;
      }
    } else if (closeListeners != null)
    {
      ArrayList vec = (ArrayList)closeListeners;
      int i = vec.size(); for (;;) { i--; if (i < 0)
          break;
        if (vec.get(i) == listener)
          vec.remove(i);
      }
      if (vec.isEmpty()) {
        closeListeners = null;
      }
    }
  }
  
  void fireDocumentClosed() {
    if ((closeListeners instanceof DocumentCloseListener)) {
      ((DocumentCloseListener)closeListeners).closed(this);
    } else if (closeListeners != null)
    {
      ArrayList vec = (ArrayList)closeListeners;
      int i = vec.size(); for (;;) { i--; if (i < 0) break;
        ((DocumentCloseListener)vec.get(i)).closed(this);
      }
    }
  }
  
  public static abstract interface DocumentCloseListener
  {
    public abstract void closed(ReplDocument paramReplDocument);
  }
}
