// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import gnu.kawa.models.Picture;
import javax.swing.text.AttributeSet;
import gnu.kawa.swingviews.SwingDisplay;
import gnu.kawa.models.Viewable;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.text.ComponentView;
import javax.swing.text.View;
import javax.swing.text.Element;
import javax.swing.text.ViewFactory;
import javax.swing.text.StyledEditorKit;

class ReplEditorKit extends StyledEditorKit
{
    ViewFactory styledFactory;
    ViewFactory factory;
    final ReplPane pane;
    
    public ReplEditorKit(final ReplPane pane) {
        this.pane = pane;
        this.styledFactory = super.getViewFactory();
        this.factory = new ViewFactory() {
            @Override
            public View create(final Element elem) {
                final String kind = elem.getName();
                if (kind == "Viewable") {
                    return new ComponentView(elem) {
                        @Override
                        protected Component createComponent() {
                            final AttributeSet attr = this.getElement().getAttributes();
                            final JPanel panel = new JPanel();
                            final Viewable v = (Viewable)attr.getAttribute(ReplPane.ViewableAttribute);
                            v.makeView(SwingDisplay.getInstance(), panel);
                            Component comp;
                            if (panel.getComponentCount() == 1) {
                                comp = panel.getComponent(0);
                                panel.removeAll();
                            }
                            else {
                                panel.setBackground(pane.getBackground());
                                comp = panel;
                            }
                            return comp;
                        }
                    };
                }
                if (kind == "Picture") {
                    final AttributeSet attr = elem.getAttributes();
                    return new PictureView(elem, (Picture)attr.getAttribute(ReplPane.PictureAttribute));
                }
                return ReplEditorKit.this.styledFactory.create(elem);
            }
        };
    }
    
    @Override
    public ViewFactory getViewFactory() {
        return this.factory;
    }
}
