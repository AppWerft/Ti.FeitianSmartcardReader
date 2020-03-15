// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.Color;

public class Button extends Model
{
    boolean disabled;
    String text;
    Object action;
    Color foreground;
    Color background;
    Object width;
    
    @Override
    public void makeView(final Display display, final Object where) {
        display.addButton(this, where);
    }
    
    public boolean isDisabled() {
        return this.disabled;
    }
    
    public void setDisabled(final boolean disabled) {
        this.disabled = disabled;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(final String text) {
        this.text = text;
        this.notifyListeners("text");
    }
    
    public Object getAction() {
        return this.action;
    }
    
    public void setAction(final Object action) {
        this.action = action;
    }
    
    public Color getForeground() {
        return this.foreground;
    }
    
    public void setForeground(final Color fg) {
        this.foreground = fg;
        this.notifyListeners("foreground");
    }
    
    public Color getBackground() {
        return this.background;
    }
    
    public void setBackground(final Color bg) {
        this.background = bg;
        this.notifyListeners("background");
    }
}
