// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class WithTransform implements Picture
{
    Picture picture;
    AffineTransform transform;
    public static final AffineTransform identityTransform;
    
    public WithTransform(final Picture picture, final AffineTransform transform) {
        this.picture = picture;
        this.transform = transform;
    }
    
    @Override
    public void paint(final Graphics2D graphics) {
        final AffineTransform saved = graphics.getTransform();
        try {
            graphics.transform(this.transform);
            this.picture.paint(graphics);
        }
        finally {
            graphics.setTransform(saved);
        }
    }
    
    @Override
    public Rectangle2D getBounds2D() {
        return this.transform.createTransformedShape(this.picture.getBounds2D()).getBounds2D();
    }
    
    @Override
    public Picture transform(final AffineTransform tr) {
        final AffineTransform combined = new AffineTransform(this.transform);
        combined.concatenate(tr);
        return new WithTransform(this.picture, combined);
    }
    
    @Override
    public void visit(final PictureVisitor visitor) {
        visitor.visitWithTransform(this);
    }
    
    static {
        identityTransform = new AffineTransform();
    }
}
