// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.Color;
import java.util.Iterator;
import java.awt.Paint;
import gnu.mapping.SimpleSymbol;
import java.util.ArrayList;
import java.util.List;
import java.awt.BasicStroke;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Shape;

public class DrawShape implements Picture
{
    Shape shape;
    
    public DrawShape(final Shape shape) {
        this.shape = shape;
    }
    
    public Shape getShape() {
        return this.shape;
    }
    
    @Override
    public void paint(final Graphics2D graphics) {
        graphics.draw(this.shape);
    }
    
    @Override
    public Rectangle2D getBounds2D() {
        return this.shape.getBounds2D();
    }
    
    @Override
    public Picture transform(final AffineTransform tr) {
        return new DrawShape(tr.createTransformedShape(this.shape));
    }
    
    @Override
    public void visit(final PictureVisitor visitor) {
        visitor.visitDrawShape(this);
    }
    
    private static Stroke mergeCap(final int value, final Stroke old) {
        return WithPaint.merge(new BasicStroke(1.0f, value, 0), 2, (BasicStroke)old);
    }
    
    private static Stroke mergeJoin(final int value, final Stroke old) {
        return WithPaint.merge(new BasicStroke(1.0f, 0, value), 4, (BasicStroke)old);
    }
    
    public static Picture makeDraw(final List<Object> args) {
        Paint paint = null;
        Stroke stroke = null;
        int propertiesSet = 0;
        final int nargs = args.size();
        final ArrayList<DrawShape> ops = new ArrayList<DrawShape>();
        for (final Object arg : args) {
            if (arg instanceof Shape) {
                ops.add(new DrawShape((Shape)arg));
            }
            else {
                if (ops.size() > 0) {
                    throw new IllegalArgumentException("draw: property argument after shape argument");
                }
                if (arg instanceof CharSequence || arg instanceof SimpleSymbol) {
                    final String str = arg.toString();
                    if (str.equals("butt-cap")) {
                        propertiesSet |= 0x2;
                        stroke = mergeCap(0, stroke);
                    }
                    else if (str.equals("square-cap")) {
                        propertiesSet |= 0x2;
                        stroke = mergeCap(2, stroke);
                    }
                    else if (str.equals("round-cap")) {
                        propertiesSet |= 0x2;
                        stroke = mergeCap(1, stroke);
                    }
                    else if (str.equals("miter-join")) {
                        propertiesSet |= 0x4;
                        stroke = mergeJoin(0, stroke);
                    }
                    else if (str.equals("round-join")) {
                        propertiesSet |= 0x4;
                        stroke = mergeJoin(1, stroke);
                    }
                    else if (str.equals("bevel-join")) {
                        propertiesSet |= 0x4;
                        stroke = mergeJoin(2, stroke);
                    }
                    else {
                        final Color color = StandardColor.valueOf(str);
                        if (color == null) {
                            throw new IllegalArgumentException("draw: unknown keyword or color " + str);
                        }
                        paint = color;
                    }
                }
                else if (arg instanceof Paint) {
                    paint = (Paint)arg;
                }
                else if (arg instanceof Stroke) {
                    propertiesSet |= 0x3F;
                    stroke = (Stroke)arg;
                }
                else {
                    if (!(arg instanceof Number)) {
                        throw new IllegalArgumentException("draw: invalid argument type");
                    }
                    final float width = ((Number)arg).floatValue();
                    propertiesSet |= 0x1;
                    stroke = WithPaint.merge(new BasicStroke(width, 0, 0), 1, (BasicStroke)stroke);
                }
            }
        }
        Picture pic = PBox.combine(ops);
        if (paint != null || stroke != null) {
            pic = new WithPaint(pic, paint, stroke, propertiesSet);
        }
        return pic;
    }
}
