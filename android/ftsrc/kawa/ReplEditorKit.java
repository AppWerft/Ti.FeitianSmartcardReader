package kawa;

import gnu.kawa.models.Picture;
import gnu.kawa.models.Viewable;
import gnu.kawa.swingviews.SwingDisplay;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;















































































class ReplEditorKit
  extends StyledEditorKit
{
  ViewFactory styledFactory;
  ViewFactory factory;
  final ReplPane pane;
  
  public ReplEditorKit(final ReplPane pane)
  {
    this.pane = pane;
    styledFactory = super.getViewFactory();
    factory = new ViewFactory()
    {
      public View create(Element elem)
      {
        String kind = elem.getName();
        if (kind == "Viewable")
        {
          new ComponentView(elem)
          {

            protected Component createComponent()
            {
              AttributeSet attr = getElement().getAttributes();
              JPanel panel = new JPanel();
              Viewable v = (Viewable)attr.getAttribute(ReplPane.ViewableAttribute);
              



              v.makeView(SwingDisplay.getInstance(), panel);
              Component comp; if (panel.getComponentCount() == 1)
              {
                Component comp = panel.getComponent(0);
                panel.removeAll();
              }
              else
              {
                panel.setBackground(val$pane.getBackground());
                comp = panel;
              }
              return comp;
            }
          };
        }
        if (kind == "Picture")
        {
          AttributeSet attr = elem.getAttributes();
          return new PictureView(elem, (Picture)attr.getAttribute(ReplPane.PictureAttribute));
        }
        return styledFactory.create(elem);
      }
    };
  }
  

  public ViewFactory getViewFactory()
  {
    return factory;
  }
}
