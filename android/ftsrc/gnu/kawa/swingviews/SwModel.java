package gnu.kawa.swingviews;

import gnu.kawa.models.Button;
import javax.swing.DefaultButtonModel;


























































class SwModel
  extends DefaultButtonModel
{
  Button model;
  
  public SwModel(Button model)
  {
    this.model = model;
    setActionCommand(model.getText());
  }
}
