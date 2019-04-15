package gnu.kawa.swingviews;

import gnu.kawa.models.DrawImage;
import gnu.kawa.models.Spacer;
import gnu.kawa.models.Text;
import java.util.WeakHashMap;

public class SwingDisplay extends gnu.kawa.models.Display
{
  public SwingDisplay() {}
  
  static final SwingDisplay instance = new SwingDisplay();
  
  public static gnu.kawa.models.Display getInstance() { return instance; }
  
  public gnu.kawa.models.Window makeWindow()
  {
    SwingFrame window = new SwingFrame(null, null, null);
    display = this;
    return window;
  }
  
  public void addButton(gnu.kawa.models.Button model, Object where)
  {
    addView(new SwingButton(model), where);
  }
  
  public void addLabel(gnu.kawa.models.Label model, Object where)
  {
    addView(new SwingLabel(model), where);
  }
  
  public void addImage(DrawImage model, Object where)
  {
    addView(new javax.swing.JLabel(new javax.swing.ImageIcon(model.getImage())), where);
  }
  




  public void addText(Text model, Object where)
  {
    addView(new javax.swing.JTextField(getSwingDocument(model), model.getText(), 50), where);
  }
  

  private static WeakHashMap documents = null;
  
  static synchronized javax.swing.text.Document getSwingDocument(Text model)
  {
    if (documents == null)
      documents = new WeakHashMap();
    Object existing = documents.get(model);
    if (existing != null)
      return (javax.swing.text.Document)existing;
    javax.swing.text.Document doc = new javax.swing.text.PlainDocument(new SwingContent(buffer));
    
    documents.put(model, doc);
    return doc;
  }
  
  public void addBox(gnu.kawa.models.Box model, Object where)
  {
    addView(new SwingBox(model, this), where);
  }
  
  public void addSpacer(Spacer model, Object where)
  {
    addView(new javax.swing.Box.Filler(model.getMinimumSize(), model.getPreferredSize(), model.getMaximumSize()), where);
  }
  



  public void addView(Object view, Object where)
  {
    ((java.awt.Container)where).add((java.awt.Component)view);
  }
  
  public static java.awt.event.ActionListener makeActionListener(Object command)
  {
    if ((command instanceof java.awt.event.ActionListener))
      return (java.awt.event.ActionListener)command;
    return new ProcActionListener((gnu.mapping.Procedure)command);
  }
  

  public gnu.kawa.models.Model coerceToModel(Object component)
  {
    if ((component instanceof java.awt.Component))
      return new ComponentModel((java.awt.Component)component);
    if ((component instanceof gnu.kawa.models.Picture))
    {
      return new ComponentModel(new SwingPicture((gnu.kawa.models.Picture)component)); }
    return super.coerceToModel(component);
  }
}
