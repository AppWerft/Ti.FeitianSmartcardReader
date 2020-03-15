// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.geom.Dimension2D;
import java.awt.Dimension;

public class DDimension extends Dimension
{
    private double w;
    private double h;
    
    public DDimension() {
    }
    
    public DDimension(final double width, final double height) {
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public DDimension(final Dimension2D d) {
        this(d.getWidth(), d.getHeight());
    }
    
    @Override
    public double getWidth() {
        return this.w;
    }
    
    @Override
    public double getHeight() {
        return this.h;
    }
    
    @Override
    public DDimension getSize() {
        return new DDimension(this.w, this.h);
    }
    
    public void setWidth(final double width) {
        this.w = width;
        super.width = (int)Math.ceil(width);
    }
    
    public void setHeight(final double height) {
        this.h = height;
        super.height = (int)Math.ceil(height);
    }
    
    @Override
    public void setSize(final int width, final int height) {
        this.w = width;
        super.width = width;
        this.h = height;
        super.height = height;
    }
    
    @Override
    public void setSize(final double width, final double height) {
        this.setWidth(width);
        this.setHeight(height);
    }
    
    @Override
    public void setSize(final Dimension d) {
        this.setSize(d.getWidth(), d.getHeight());
    }
    
    @Override
    public void setSize(final Dimension2D d) {
        this.setSize(d.getWidth(), d.getHeight());
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof DDimension) {
            final DDimension d = (DDimension)obj;
            return this.w == d.w && this.h == d.h;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + "[width=" + this.getWidth() + ",height=" + this.getHeight() + "]";
    }
}
