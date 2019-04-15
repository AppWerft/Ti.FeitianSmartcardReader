/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Display;
import gnu.kawa.models.Model;
import java.awt.Color;

public class Button
extends Model {
    boolean disabled;
    String text;
    Object action;
    Color foreground;
    Color background;
    Object width;

    @Override
    public void makeView(Display display, Object where) {
        display.addButton(this, where);
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
        this.notifyListeners("text");
    }

    public Object getAction() {
        return this.action;
    }

    public void setAction(Object action) {
        this.action = action;
    }

    public Color getForeground() {
        return this.foreground;
    }

    public void setForeground(Color fg) {
        this.foreground = fg;
        this.notifyListeners("foreground");
    }

    public Color getBackground() {
        return this.background;
    }

    public void setBackground(Color bg) {
        this.background = bg;
        this.notifyListeners("background");
    }
}

