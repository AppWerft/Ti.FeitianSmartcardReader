// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import gnu.kawa.models.Model;
import gnu.kawa.models.Label;
import gnu.kawa.models.ModelListener;
import javax.swing.JLabel;

class SwingLabel extends JLabel implements ModelListener
{
    Label model;
    
    public SwingLabel(final Label model) {
        this.model = model;
        final String text = model.getText();
        if (text != null) {
            super.setText(text);
        }
        model.addListener(this);
    }
    
    @Override
    public void modelUpdated(final Model model, final Object key) {
        if (key == "text" && model == this.model) {
            super.setText(this.model.getText());
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
}
