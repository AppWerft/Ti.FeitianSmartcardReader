/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Picture;
import gnu.kawa.models.PictureVisitor;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class WithTransform
implements Picture {
    Picture picture;
    AffineTransform transform;
    public static final AffineTransform identityTransform = new AffineTransform();

    public WithTransform(Picture picture, AffineTransform transform) {
        this.picture = picture;
        this.transform = transform;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paint(Graphics2D graphics) {
        AffineTransform saved = graphics.getTransform();
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
    public Picture transform(AffineTransform tr) {
        AffineTransform combined = new AffineTransform(this.transform);
        combined.concatenate(tr);
        return new WithTransform(this.picture, combined);
    }

    @Override
    public void visit(PictureVisitor visitor) {
        visitor.visitWithTransform(this);
    }
}

