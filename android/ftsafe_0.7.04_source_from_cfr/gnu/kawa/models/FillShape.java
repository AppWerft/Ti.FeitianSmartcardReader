/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Picture;
import gnu.kawa.models.PictureVisitor;
import gnu.kawa.models.StandardColor;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class FillShape
implements Picture {
    Shape shape;

    public FillShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void paint(Graphics2D graphics) {
        if (graphics.getPaint() != StandardColor.transparent) {
            graphics.fill(this.shape);
        }
    }

    @Override
    public Rectangle2D getBounds2D() {
        return this.shape.getBounds2D();
    }

    @Override
    public Picture transform(AffineTransform tr) {
        return new FillShape(tr.createTransformedShape(this.shape));
    }

    @Override
    public void visit(PictureVisitor visitor) {
        visitor.visitFillShape(this);
    }
}

