/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.PBox;
import gnu.kawa.models.Picture;
import gnu.kawa.models.PictureVisitor;
import gnu.kawa.models.StandardColor;
import gnu.kawa.models.WithPaint;
import gnu.mapping.SimpleSymbol;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class DrawShape
implements Picture {
    Shape shape;

    public DrawShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void paint(Graphics2D graphics) {
        graphics.draw(this.shape);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return this.shape.getBounds2D();
    }

    @Override
    public Picture transform(AffineTransform tr) {
        return new DrawShape(tr.createTransformedShape(this.shape));
    }

    @Override
    public void visit(PictureVisitor visitor) {
        visitor.visitDrawShape(this);
    }

    private static Stroke mergeCap(int value, Stroke old) {
        return WithPaint.merge(new BasicStroke(1.0f, value, 0), 2, (BasicStroke)old);
    }

    private static Stroke mergeJoin(int value, Stroke old) {
        return WithPaint.merge(new BasicStroke(1.0f, 0, value), 4, (BasicStroke)old);
    }

    public static Picture makeDraw(List<Object> args) {
        Paint paint = null;
        Stroke stroke = null;
        int propertiesSet = 0;
        int nargs = args.size();
        ArrayList<DrawShape> ops = new ArrayList<DrawShape>();
        for (Object arg : args) {
            if (arg instanceof Shape) {
                ops.add(new DrawShape((Shape)arg));
                continue;
            }
            if (ops.size() > 0) {
                throw new IllegalArgumentException("draw: property argument after shape argument");
            }
            if (arg instanceof CharSequence || arg instanceof SimpleSymbol) {
                String str = arg.toString();
                if (str.equals("butt-cap")) {
                    propertiesSet |= 2;
                    stroke = DrawShape.mergeCap(0, stroke);
                    continue;
                }
                if (str.equals("square-cap")) {
                    propertiesSet |= 2;
                    stroke = DrawShape.mergeCap(2, stroke);
                    continue;
                }
                if (str.equals("round-cap")) {
                    propertiesSet |= 2;
                    stroke = DrawShape.mergeCap(1, stroke);
                    continue;
                }
                if (str.equals("miter-join")) {
                    propertiesSet |= 4;
                    stroke = DrawShape.mergeJoin(0, stroke);
                    continue;
                }
                if (str.equals("round-join")) {
                    propertiesSet |= 4;
                    stroke = DrawShape.mergeJoin(1, stroke);
                    continue;
                }
                if (str.equals("bevel-join")) {
                    propertiesSet |= 4;
                    stroke = DrawShape.mergeJoin(2, stroke);
                    continue;
                }
                StandardColor color = StandardColor.valueOf(str);
                if (color == null) {
                    throw new IllegalArgumentException("draw: unknown keyword or color " + str);
                }
                paint = color;
                continue;
            }
            if (arg instanceof Paint) {
                paint = (Paint)arg;
                continue;
            }
            if (arg instanceof Stroke) {
                propertiesSet |= 63;
                stroke = (Stroke)arg;
                continue;
            }
            if (arg instanceof Number) {
                float width = ((Number)arg).floatValue();
                propertiesSet |= 1;
                stroke = WithPaint.merge(new BasicStroke(width, 0, 0), 1, (BasicStroke)stroke);
                continue;
            }
            throw new IllegalArgumentException("draw: invalid argument type");
        }
        Picture pic = PBox.combine(ops);
        if (paint != null || stroke != null) {
            pic = new WithPaint(pic, paint, stroke, propertiesSet);
        }
        return pic;
    }
}

