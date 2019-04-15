/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.swingviews;

import gnu.kawa.models.Display;
import gnu.kawa.models.Model;
import java.awt.Component;

class ComponentModel
extends Model {
    Component component;

    public ComponentModel(Component component) {
        this.component = component;
    }

    @Override
    public void makeView(Display display, Object where) {
        display.addView(this.component, where);
    }
}

