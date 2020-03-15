// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.io.Serializable;

public class Label extends Model implements Viewable, Serializable
{
    String text;
    
    public Label() {
    }
    
    public Label(final String text) {
        this.text = text;
    }
    
    @Override
    public void makeView(final Display display, final Object where) {
        display.addLabel(this, where);
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(final String text) {
        this.text = text;
        this.notifyListeners("text");
    }
}
