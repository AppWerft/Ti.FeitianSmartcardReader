/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.models.DrawShape;
import gnu.kawa.models.Picture;
import gnu.kawa.models.PictureToSvg;
import gnu.kawa.models.PictureVisitor;
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KNode;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.xml.NodeTree;
import gnu.xml.XMLFilter;
import gnu.xml.XMLPrinter;
import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class SVGUtils {
    public static boolean haveToSvg = true;

    public static String toSVG(Picture p) {
        CharArrayOutPort cout = new CharArrayOutPort();
        XMLPrinter xout = new XMLPrinter(cout);
        SVGUtils.toSVG(p, xout);
        return cout.toString();
    }

    public static void toSVG(Picture p, PrintConsumer out, boolean headers) {
        if (headers) {
            out.println("<?xml version=\"1.0\" standalone=\"no\"?>");
            out.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
        }
        SVGUtils.toSVG(p, new XMLPrinter(out));
    }

    public static void toSVG(Picture p, Consumer out) {
        Rectangle2D bounds = SVGUtils.adjustBounds(p, p.getBounds2D(), null);
        PictureToSvg.writeSVGElementStart(bounds, out);
        PictureToSvg pout = new PictureToSvg(out);
        p.visit(pout);
        out.endElement();
    }

    public static KElement toSVGNode(Picture p) {
        XMLFilter filter = new XMLFilter(new NodeTree());
        SVGUtils.toSVG(p, filter);
        return (KElement)KNode.make((NodeTree)filter.out);
    }

    public static Rectangle2D adjustBounds(Picture pic, Rectangle2D bounds, AffineTransform transform) {
        AdjustBounds visitor = new AdjustBounds(bounds, transform);
        pic.visit(visitor);
        return visitor.getBounds();
    }

    static class AdjustBounds
    extends PictureVisitor.TrackingState {
        double x0;
        double y0;
        double x1;
        double y1;
        Rectangle2D bounds;
        boolean adjusted;

        public AdjustBounds(Rectangle2D bounds, AffineTransform transform) {
            super(transform);
            this.bounds = bounds;
            this.x0 = bounds.getX();
            this.y0 = bounds.getY();
            this.x1 = this.x0 + bounds.getWidth();
            this.y1 = this.y0 + bounds.getHeight();
        }

        public Rectangle2D getBounds() {
            Rectangle2D b = this.bounds;
            if (this.adjusted) {
                b = new Rectangle2D.Double(this.x0, this.y0, this.x1 - this.x0, this.y1 - this.y0);
            }
            return b;
        }

        @Override
        public void visitDrawShape(DrawShape pic) {
            Shape shape = pic.shape;
            if (this.stroke instanceof BasicStroke && (this.strokePropertiesSet & 1) != 0) {
                double lineWidth = ((BasicStroke)this.stroke).getLineWidth();
                double halfWidth = 0.5 * lineWidth;
                if (this.transform != null) {
                    shape = this.transform.createTransformedShape(shape);
                }
                Rectangle2D transformedBounds = shape.getBounds2D();
                double sx0 = transformedBounds.getX() - halfWidth;
                double sx1 = sx0 + transformedBounds.getWidth() + lineWidth;
                double sy0 = transformedBounds.getY() - halfWidth;
                double sy1 = sy0 + transformedBounds.getHeight() + lineWidth;
                if (sx0 < this.x0) {
                    this.x0 = sx0;
                    this.adjusted = true;
                }
                if (sy0 < this.y0) {
                    this.y0 = sy0;
                    this.adjusted = true;
                }
                if (sx1 > this.x1) {
                    this.x1 = sx1;
                    this.adjusted = true;
                }
                if (sy1 > this.y1) {
                    this.y1 = sy1;
                    this.adjusted = true;
                }
            }
        }
    }

}

