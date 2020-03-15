// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.geom.Path2D;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Stroke;
import java.awt.Paint;
import java.awt.Color;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.BasicStroke;

public class Pictures
{
    public static final BasicStroke defaultStroke;
    
    public static Picture asPicture(final Object arg) {
        if (arg instanceof BufferedImage) {
            return new DrawImage((BufferedImage)arg);
        }
        if (arg instanceof Shape) {
            return new DrawShape((Shape)arg);
        }
        return (Picture)arg;
    }
    
    public static Picture[] asPictureAll(final Object[] args) {
        final int np = args.length;
        final Picture[] p = new Picture[np];
        for (int i = 0; i < np; ++i) {
            p[i] = asPicture(args[i]);
        }
        return p;
    }
    
    public static BufferedImage toImage(final Picture picture) {
        final Rectangle2D size = picture.getBounds2D();
        final int w = (int)Math.ceil(size.getWidth());
        final int h = (int)Math.ceil(size.getHeight());
        final BufferedImage image = new BufferedImage(w, h, 2);
        final Graphics2D g2 = image.createGraphics();
        g2.setPaint(Color.BLACK);
        g2.setStroke(Pictures.defaultStroke);
        g2.translate(-size.getX(), -size.getY());
        picture.paint(g2);
        return image;
    }
    
    public static Shape borderShape(final Rectangle2D bounds, final boolean border, final double top, final double right, final double bottom, final double left) {
        final double x0 = bounds.getX();
        final double w = bounds.getWidth();
        final double x2 = x0 + w;
        final double y0 = bounds.getY();
        final double h = bounds.getHeight();
        final double y2 = y0 + h;
        if (border) {
            final double x0b = x0 - left;
            final double x1b = x2 + right;
            final double y0b = y0 - top;
            final double y1b = y2 + bottom;
            final Path2D.Double r = new Path2D.Double();
            r.setWindingRule(1);
            r.moveTo(x0, y0);
            r.lineTo(x2, y0);
            r.lineTo(x2, y2);
            r.lineTo(x0, y2);
            r.closePath();
            r.moveTo(x0b, y0b);
            r.lineTo(x0b, y1b);
            r.lineTo(x1b, y1b);
            r.lineTo(x1b, y0b);
            r.closePath();
            return r;
        }
        return new Rectangle2D.Double(x0 - left, y0 - top, w + left + right, h + top + bottom);
    }
    
    static {
        defaultStroke = new BasicStroke(1.0f, 0, 0);
    }
}
