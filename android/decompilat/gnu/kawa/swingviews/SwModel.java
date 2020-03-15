// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import gnu.kawa.models.Button;
import javax.swing.DefaultButtonModel;

class SwModel extends DefaultButtonModel
{
    Button model;
    
    public SwModel(final Button model) {
        this.model = model;
        this.setActionCommand(model.getText());
    }
}
