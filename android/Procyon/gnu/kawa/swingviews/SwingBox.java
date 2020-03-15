// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import gnu.kawa.models.Model;
import gnu.kawa.models.Viewable;
import gnu.kawa.models.Display;
import gnu.kawa.models.ModelListener;
import javax.swing.Box;

class SwingBox extends Box implements ModelListener
{
    gnu.kawa.models.Box model;
    
    public SwingBox(final gnu.kawa.models.Box model, final Display display) {
        super(model.getAxis());
        model.addListener(this);
        final Viewable cellSpacing = model.getCellSpacing();
        for (int n = model.getComponentCount(), i = 0; i < n; ++i) {
            if (i > 0 && cellSpacing != null) {
                cellSpacing.makeView(display, this);
            }
            model.getComponent(i).makeView(display, this);
        }
    }
    
    @Override
    public void modelUpdated(final Model model, final Object key) {
    }
}
