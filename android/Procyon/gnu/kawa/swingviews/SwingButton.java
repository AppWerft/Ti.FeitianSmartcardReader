// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import gnu.kawa.models.Model;
import java.awt.Color;
import javax.swing.ButtonModel;
import gnu.kawa.models.Button;
import gnu.kawa.models.ModelListener;
import javax.swing.JButton;

public class SwingButton extends JButton implements ModelListener
{
    Button model;
    
    public SwingButton(final Button model) {
        super(model.getText());
        this.setModel(new SwModel(model));
        this.model = model;
        final Object action = model.getAction();
        if (action != null) {
            this.addActionListener(SwingDisplay.makeActionListener(action));
        }
        model.addListener(this);
        final Color fg = model.getForeground();
        if (fg != null) {
            super.setBackground(fg);
        }
        final Color bg = model.getBackground();
        if (bg != null) {
            super.setBackground(bg);
        }
    }
    
    @Override
    public void setText(final String text) {
        if (this.model == null) {
            super.setText(text);
        }
        else {
            this.model.setText(text);
        }
    }
    
    @Override
    public void setForeground(final Color fg) {
        if (this.model == null) {
            super.setForeground(fg);
        }
        else {
            this.model.setForeground(fg);
        }
    }
    
    @Override
    public void setBackground(final Color bg) {
        if (this.model == null) {
            super.setBackground(bg);
        }
        else {
            this.model.setBackground(bg);
        }
    }
    
    @Override
    public void modelUpdated(final Model model, final Object key) {
        if (key == "text" && model == this.model) {
            super.setText(this.model.getText());
        }
        else if (key == "foreground" && model == this.model) {
            super.setForeground(this.model.getForeground());
        }
        else if (key == "background" && model == this.model) {
            super.setBackground(this.model.getBackground());
        }
    }
}
