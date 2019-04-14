package gnu.kawa.swingviews;

import gnu.kawa.models.Label;
import gnu.kawa.models.Model;
import gnu.kawa.models.ModelListener;
import javax.swing.JLabel;









































































































































class SwingLabel
  extends JLabel
  implements ModelListener
{
  Label model;
  
  public SwingLabel(Label model)
  {
    this.model = model;
    String text = model.getText();
    if (text != null)
      super.setText(text);
    model.addListener(this);
  }
  
  public void modelUpdated(Model model, Object key)
  {
    if ((key == "text") && (model == this.model)) {
      super.setText(this.model.getText());
    }
  }
  
  public void setText(String text) {
    if (model == null) {
      super.setText(text);
    } else {
      model.setText(text);
    }
  }
}
