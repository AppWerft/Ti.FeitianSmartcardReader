// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import gnu.kawa.models.Display;
import java.awt.Component;
import gnu.kawa.models.Model;

class ComponentModel extends Model
{
    Component component;
    
    public ComponentModel(final Component component) {
        this.component = component;
    }
    
    @Override
    public void makeView(final Display display, final Object where) {
        display.addView(this.component, where);
    }
}
