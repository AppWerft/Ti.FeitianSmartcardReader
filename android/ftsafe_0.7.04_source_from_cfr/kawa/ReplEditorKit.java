/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import gnu.kawa.models.Display;
import gnu.kawa.models.Picture;
import gnu.kawa.models.Viewable;
import gnu.kawa.swingviews.SwingDisplay;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import kawa.PictureView;
import kawa.ReplPane;

class ReplEditorKit
extends StyledEditorKit {
    ViewFactory styledFactory;
    ViewFactory factory;
    final ReplPane pane;

    public ReplEditorKit(final ReplPane pane) {
        this.pane = pane;
        this.styledFactory = super.getViewFactory();
        this.factory = new ViewFactory(){

            @Override
            public View create(Element elem) {
                String kind = elem.getName();
                if (kind == "Viewable") {
                    return new ComponentView(elem){

                        @Override
                        protected Component createComponent() {
                            Component comp;
                            AttributeSet attr = this.getElement().getAttributes();
                            JPanel panel = new JPanel();
                            Viewable v = (Viewable)attr.getAttribute(ReplPane.ViewableAttribute);
                            v.makeView(SwingDisplay.getInstance(), panel);
                            if (panel.getComponentCount() == 1) {
                                comp = panel.getComponent(0);
                                panel.removeAll();
                            } else {
                                panel.setBackground(pane.getBackground());
                                comp = panel;
                            }
                            return comp;
                        }
                    };
                }
                if (kind == "Picture") {
                    AttributeSet attr = elem.getAttributes();
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

