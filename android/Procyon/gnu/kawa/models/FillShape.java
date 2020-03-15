// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Shape;

public class FillShape implements Picture
{
    Shape shape;
    
    public FillShape(final Shape shape) {
        this.shape = shape;
    }
    
    public Shape getShape() {
        return this.shape;
    }
    
    @Override
    public void paint(final Graphics2D graphics) {
        if (graphics.getPaint() != StandardColor.transparent) {
            graphics.fill(this.shape);
        }
    }
    
    @Override
    public Rectangle2D getBounds2D() {
        return this.shape.getBounds2D();
    }
    
    @Override
    public Picture transform(final AffineTransform tr) {
        return new FillShape(tr.createTransformedShape(this.shape));
    }
    
    @Override
    public void visit(final PictureVisitor visitor) {
        visitor.visitFillShape(this);
    }
}
