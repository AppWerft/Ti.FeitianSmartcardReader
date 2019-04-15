/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Display;
import gnu.kawa.models.Model;
import gnu.kawa.models.Viewable;
import java.io.Serializable;

public class Label
extends Model
implements Viewable,
Serializable {
    String text;

    public Label() {
    }

    public Label(String text) {
        this.text = text;
    }

    @Override
    public void makeView(Display display, Object where) {
        display.addLabel(this, where);
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
        this.notifyListeners("text");
    }
}

