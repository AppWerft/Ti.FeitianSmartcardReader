/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.swingviews;

import gnu.kawa.models.Button;
import gnu.kawa.models.Model;
import gnu.kawa.models.ModelListener;
import gnu.kawa.swingviews.SwModel;
import gnu.kawa.swingviews.SwingDisplay;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class SwingButton
extends JButton
implements ModelListener {
    Button model;

    public SwingButton(Button model) {
        Color bg;
        super(model.getText());
        this.setModel(new SwModel(model));
        this.model = model;
        Object action = model.getAction();
        if (action != null) {
            this.addActionListener(SwingDisplay.makeActionListener(action));
        }
        model.addListener(this);
        Color fg = model.getForeground();
        if (fg != null) {
            super.setBackground(fg);
        }
        if ((bg = model.getBackground()) != null) {
            super.setBackground(bg);
        }
    }

    @Override
    public void setText(String text) {
        if (this.model == null) {
            super.setText(text);
        } else {
            this.model.setText(text);
        }
    }

    @Override
    public void setForeground(Color fg) {
        if (this.model == null) {
            super.setForeground(fg);
        } else {
            this.model.setForeground(fg);
        }
    }

    @Override
    public void setBackground(Color bg) {
        if (this.model == null) {
            super.setBackground(bg);
        } else {
            this.model.setBackground(bg);
        }
    }

    @Override
    public void modelUpdated(Model model, Object key) {
        if (key == "text" && model == this.model) {
            super.setText(this.model.getText());
        } else if (key == "foreground" && model == this.model) {
            super.setForeground(this.model.getForeground());
        } else if (key == "background" && model == this.model) {
            super.setBackground(this.model.getBackground());
        }
    }
}

