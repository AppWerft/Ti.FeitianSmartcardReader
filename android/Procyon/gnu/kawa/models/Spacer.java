// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.io.Serializable;

public class Spacer extends Model implements Viewable, Serializable
{
    Dimension2D minSize;
    Dimension2D preferredSize;
    Dimension2D maxSize;
    
    public Dimension2D getMinimumSize2D() {
        return this.minSize;
    }
    
    public Dimension2D getPreferredSize2D() {
        return this.preferredSize;
    }
    
    public Dimension2D getMaximumSize2D() {
        return this.maxSize;
    }
    
    public Dimension getMinimumSize() {
        return Display.asDimension(this.minSize);
    }
    
    public Dimension getPreferredSize() {
        return Display.asDimension(this.preferredSize);
    }
    
    public Dimension getMaximumSize() {
        return Display.asDimension(this.maxSize);
    }
    
    public boolean isRigid() {
        return this.minSize == this.maxSize || (this.minSize != null && this.maxSize != null && this.minSize.getWidth() == this.maxSize.getWidth() && this.minSize.getHeight() == this.maxSize.getHeight());
    }
    
    public static Spacer rigidArea(final Dimension2D d) {
        final Spacer spacer = new Spacer();
        spacer.minSize = d;
        spacer.maxSize = d;
        spacer.preferredSize = d;
        return spacer;
    }
    
    public static Spacer rigidArea(final int width, final int height) {
        return rigidArea(new Dimension(width, height));
    }
    
    @Override
    public void makeView(final Display display, final Object where) {
        display.addSpacer(this, where);
    }
}
