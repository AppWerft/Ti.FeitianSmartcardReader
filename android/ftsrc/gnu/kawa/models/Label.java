package gnu.kawa.models;

import java.io.Serializable;



public class Label
  extends Model
  implements Viewable, Serializable
{
  String text;
  
  public Label() {}
  
  public Label(String text)
  {
    this.text = text;
  }
  
  public void makeView(Display display, Object where)
  {
    display.addLabel(this, where);
  }
  
  public String getText()
  {
    return text;
  }
  
  public void setText(String text)
  {
    this.text = text;
    notifyListeners("text");
  }
}
