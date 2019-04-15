package kawa;

import gnu.kawa.io.OutPort;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextPane;
import javax.swing.text.EditorKit;
import javax.swing.text.MutableAttributeSet;













public class ReplPane
  extends JTextPane
  implements KeyListener
{
  ReplDocument document;
  public static final String ViewableElementName = "Viewable";
  public static final String PictureElementName = "Picture";
  
  public ReplPane(ReplDocument document)
  {
    super(document);
    this.document = document;
    pane = this;
    paneCount += 1;
    
    addKeyListener(this);
    addFocusListener(document);
    
    setCaretPosition(outputMark);
  }
  
  protected EditorKit createDefaultEditorKit()
  {
    return new ReplEditorKit(this);
  }
  





  public void removeNotify()
  {
    super.removeNotify();
    if (--document.paneCount == 0) {
      document.close();
    }
  }
  
  public MutableAttributeSet getInputAttributes()
  {
    return ReplDocument.inputStyle;
  }
  
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == 10)
    {
      document.enter();
      e.consume();
    }
  }
  
  public void keyReleased(KeyEvent e) {}
  
  public void keyTyped(KeyEvent e) {}
  
  public OutPort getStdout()
  {
    return document.out_stream;
  }
  
  public OutPort getStderr() { return document.err_stream; }
  



  public static final Object ViewableAttribute = new String("Viewable");
  
  public static final Object PictureAttribute = new String("Picture");
}
