package gnu.kawa.swingviews;

import gnu.lists.AbstractSequence;
import java.awt.Container;
import javax.swing.JFrame;

public class SwingFrame extends JFrame implements gnu.kawa.models.Window
{
  SwingDisplay display;
  
  public gnu.kawa.models.Display getDisplay()
  {
    return display;
  }
  

  public SwingFrame(String title, javax.swing.JMenuBar menubar, Object contents)
  {
    JFrame fr = this;
    if (title != null)
      fr.setTitle(title);
    if (menubar != null)
      fr.setJMenuBar(menubar);
    Container pane = getContentPane();
    pane.setLayout(new javax.swing.BoxLayout(pane, 0));
    addComponent(contents);
  }
  
  public void setContent(Object content)
  {
    setContentPane(new javax.swing.JPanel());
    addComponent(content);
    pack();
  }
  
  public void setMenuBar(Object menubar)
  {
    setJMenuBar((javax.swing.JMenuBar)menubar);
  }
  
  public void addComponent(Object contents)
  {
    if (((contents instanceof gnu.lists.FString)) || ((contents instanceof String))) {
      getContentPane().add(new javax.swing.JLabel(contents.toString())); } else { AbstractSequence seq;
      int iter; if ((contents instanceof AbstractSequence))
      {
        seq = (AbstractSequence)contents;
        for (iter = seq.startPos(); (iter = seq.nextPos(iter)) != 0;) {
          addComponent(seq.getPosPrevious(iter));
        }
      } else if ((contents instanceof gnu.kawa.models.Viewable)) {
        ((gnu.kawa.models.Viewable)contents).makeView(getDisplay(), getContentPane());
      } else if ((contents instanceof gnu.kawa.models.Picture)) {
        getContentPane().add(new SwingPicture((gnu.kawa.models.Picture)contents));
      } else if (contents != null) {
        getContentPane().add((java.awt.Component)contents);
      }
    }
  }
  
  public void open() { pack();
    setVisible(true);
  }
}
