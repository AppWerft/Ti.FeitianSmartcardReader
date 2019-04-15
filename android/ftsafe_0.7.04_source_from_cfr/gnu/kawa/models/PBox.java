/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Picture;
import gnu.kawa.models.PictureVisitor;
import gnu.kawa.models.Pictures;
import gnu.kawa.models.WithTransform;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class PBox
implements Picture {
    char axis;
    Picture[] children;
    Rectangle2D bounds;
    double[] translations;
    double spacing;

    private PBox(char axis, Picture[] children) {
        this.axis = axis;
        this.children = children;
        this.init();
    }

    private PBox(char axis, double spacing, Picture[] children) {
        this.axis = axis;
        this.children = children;
        this.spacing = spacing;
        this.init();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return this.bounds;
    }

    void init() {
        int n = this.children.length;
        if (n == 0) {
            return;
        }
        Rectangle2D prevBounds = this.children[0].getBounds2D();
        double minX = prevBounds.getMinX();
        double maxX = prevBounds.getMaxX();
        double minY = prevBounds.getMinY();
        double maxY = prevBounds.getMaxY();
        double deltaX = 0.0;
        double deltaY = 0.0;
        this.translations = new double[n];
        for (int i = 1; i < n; ++i) {
            double cminY;
            double cmaxX;
            double cmaxY;
            double delta;
            Rectangle2D curBounds = this.children[i].getBounds2D();
            if (this.axis == 'X') {
                delta = this.spacing + prevBounds.getMaxX() - curBounds.getMinX();
                deltaX += delta;
            } else if (this.axis == 'Y') {
                delta = this.spacing + prevBounds.getMaxY() - curBounds.getMinY();
                deltaY += delta;
            } else {
                delta = 0.0;
            }
            this.translations[i] = delta + this.translations[i - 1];
            double cminX = curBounds.getMinX() + deltaX;
            if (cminX < minX) {
                minX = cminX;
            }
            if ((cminY = curBounds.getMinY() + deltaY) < minY) {
                minY = cminY;
            }
            if ((cmaxX = curBounds.getMaxX() + deltaX) > maxX) {
                maxX = cmaxX;
            }
            if ((cmaxY = curBounds.getMaxY() + deltaY) > maxY) {
                maxY = cmaxY;
            }
            prevBounds = curBounds;
        }
        this.bounds = new Rectangle2D.Double(minX, minY, maxX - minX, maxY - minY);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paint(Graphics2D graphics) {
        AffineTransform saved = graphics.getTransform();
        try {
            int n = this.children.length;
            double prevOffset = 0.0;
            for (int i = 0; i < n; ++i) {
                double offset = this.translations[i];
                if (i > 0 && this.axis != 'Z') {
                    double delta = offset - prevOffset;
                    if (this.axis == 'X') {
                        graphics.translate(delta, 0.0);
                    } else {
                        graphics.translate(0.0, delta);
                    }
                }
                prevOffset = offset;
                this.children[i].paint(graphics);
            }
        }
        finally {
            graphics.setTransform(saved);
        }
    }

    @Override
    public Picture transform(AffineTransform tr) {
        return new WithTransform(this, tr);
    }

    @Override
    public void visit(PictureVisitor visitor) {
        visitor.visitPBox(this);
    }

    public static /* varargs */ PBox makeBox(char axis, Object ... args) {
        int nargs = args.length;
        int start = 0;
        double spacing = 0.0;
        if (nargs > 0 && args[0] instanceof Number) {
            start = 1;
            spacing = ((Number)args[0]).doubleValue();
        }
        Picture[] pictures2 = new Picture[nargs - start];
        for (int i = start; i < nargs; ++i) {
            pictures2[i - start] = Pictures.asPicture(args[i]);
        }
        return new PBox(axis, spacing, pictures2);
    }

    public static Picture combine(List parts) {
        int nparts = parts.size();
        Picture[] pics = new Picture[nparts];
        parts.toArray(pics);
        return nparts == 1 ? pics[0] : new PBox('Z', pics);
    }
}

