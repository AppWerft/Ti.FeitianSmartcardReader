// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.geom.Dimension2D;
import java.awt.Dimension;
import gnu.math.IntNum;
import java.io.Serializable;

public abstract class Box extends Model implements Viewable, Serializable
{
    Viewable[] components;
    int numComponents;
    Viewable cellSpacing;
    
    public Viewable getCellSpacing() {
        return this.cellSpacing;
    }
    
    public void setCellSpacing(final Object cellSpacing) {
        if (cellSpacing instanceof IntNum || cellSpacing instanceof Integer) {
            final int size = ((Number)cellSpacing).intValue();
            final Dimension dim = (this.getAxis() == 0) ? new Dimension(size, 0) : new Dimension(0, size);
            this.cellSpacing = Spacer.rigidArea(dim);
        }
        else {
            this.cellSpacing = (Viewable)cellSpacing;
        }
    }
    
    public abstract int getAxis();
    
    public final int getComponentCount() {
        return this.numComponents;
    }
    
    public final Viewable getComponent(final int i) {
        return this.components[i];
    }
    
    public void add(final Viewable component) {
        Viewable[] arr = this.components;
        final int n = this.numComponents;
        if (n == 0) {
            arr = (this.components = new Viewable[4]);
        }
        else if (arr.length <= n) {
            System.arraycopy(arr, 0, this.components = new Viewable[2 * n], 0, n);
            arr = this.components;
        }
        this.components[n] = component;
        this.numComponents = n + 1;
    }
    
    @Override
    public void makeView(final Display display, final Object where) {
        display.addBox(this, where);
    }
}
