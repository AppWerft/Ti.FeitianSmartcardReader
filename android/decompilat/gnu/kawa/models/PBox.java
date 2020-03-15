// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.util.List;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class PBox implements Picture
{
    char axis;
    Picture[] children;
    Rectangle2D bounds;
    double[] translations;
    double spacing;
    
    private PBox(final char axis, final Picture[] children) {
        this.axis = axis;
        this.children = children;
        this.init();
    }
    
    private PBox(final char axis, final double spacing, final Picture[] children) {
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
        final int n = this.children.length;
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
            final Rectangle2D curBounds = this.children[i].getBounds2D();
            double delta;
            if (this.axis == 'X') {
                delta = this.spacing + prevBounds.getMaxX() - curBounds.getMinX();
                deltaX += delta;
            }
            else if (this.axis == 'Y') {
                delta = this.spacing + prevBounds.getMaxY() - curBounds.getMinY();
                deltaY += delta;
            }
            else {
                delta = 0.0;
            }
            this.translations[i] = delta + this.translations[i - 1];
            final double cminX = curBounds.getMinX() + deltaX;
            if (cminX < minX) {
                minX = cminX;
            }
            final double cminY = curBounds.getMinY() + deltaY;
            if (cminY < minY) {
                minY = cminY;
            }
            final double cmaxX = curBounds.getMaxX() + deltaX;
            if (cmaxX > maxX) {
                maxX = cmaxX;
            }
            final double cmaxY = curBounds.getMaxY() + deltaY;
            if (cmaxY > maxY) {
                maxY = cmaxY;
            }
            prevBounds = curBounds;
        }
        this.bounds = new Rectangle2D.Double(minX, minY, maxX - minX, maxY - minY);
    }
    
    @Override
    public void paint(final Graphics2D graphics) {
        final AffineTransform saved = graphics.getTransform();
        try {
            final int n = this.children.length;
            double prevOffset = 0.0;
            for (int i = 0; i < n; ++i) {
                final double offset = this.translations[i];
                if (i > 0 && this.axis != 'Z') {
                    final double delta = offset - prevOffset;
                    if (this.axis == 'X') {
                        graphics.translate(delta, 0.0);
                    }
                    else {
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
    public Picture transform(final AffineTransform tr) {
        return new WithTransform(this, tr);
    }
    
    @Override
    public void visit(final PictureVisitor visitor) {
        visitor.visitPBox(this);
    }
    
    public static PBox makeBox(final char axis, final Object... args) {
        final int nargs = args.length;
        int start = 0;
        double spacing = 0.0;
        if (nargs > 0 && args[0] instanceof Number) {
            start = 1;
            spacing = ((Number)args[0]).doubleValue();
        }
        final Picture[] pictures = new Picture[nargs - start];
        for (int i = start; i < nargs; ++i) {
            pictures[i - start] = Pictures.asPicture(args[i]);
        }
        return new PBox(axis, spacing, pictures);
    }
    
    public static Picture combine(final List parts) {
        final int nparts = parts.size();
        final Picture[] pics = new Picture[nparts];
        parts.toArray(pics);
        return (nparts == 1) ? pics[0] : new PBox('Z', pics);
    }
}
