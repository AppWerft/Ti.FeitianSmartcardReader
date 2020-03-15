// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.Shape;
import java.awt.BasicStroke;
import gnu.kawa.xml.KNode;
import gnu.xml.XMLFilter;
import gnu.xml.NodeTree;
import gnu.kawa.xml.KElement;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.xml.XMLPrinter;
import gnu.kawa.io.CharArrayOutPort;

public class SVGUtils
{
    public static boolean haveToSvg;
    
    public static String toSVG(final Picture p) {
        final CharArrayOutPort cout = new CharArrayOutPort();
        final XMLPrinter xout = new XMLPrinter(cout);
        toSVG(p, xout);
        return cout.toString();
    }
    
    public static void toSVG(final Picture p, final PrintConsumer out, final boolean headers) {
        if (headers) {
            out.println("<?xml version=\"1.0\" standalone=\"no\"?>");
            out.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
        }
        toSVG(p, new XMLPrinter(out));
    }
    
    public static void toSVG(final Picture p, final Consumer out) {
        final Rectangle2D bounds = adjustBounds(p, p.getBounds2D(), null);
        PictureToSvg.writeSVGElementStart(bounds, out);
        final PictureToSvg pout = new PictureToSvg(out);
        p.visit(pout);
        out.endElement();
    }
    
    public static KElement toSVGNode(final Picture p) {
        final XMLFilter filter = new XMLFilter(new NodeTree());
        toSVG(p, filter);
        return (KElement)KNode.make((NodeTree)filter.out);
    }
    
    public static Rectangle2D adjustBounds(final Picture pic, final Rectangle2D bounds, final AffineTransform transform) {
        final AdjustBounds visitor = new AdjustBounds(bounds, transform);
        pic.visit(visitor);
        return visitor.getBounds();
    }
    
    static {
        SVGUtils.haveToSvg = true;
    }
    
    static class AdjustBounds extends TrackingState
    {
        double x0;
        double y0;
        double x1;
        double y1;
        Rectangle2D bounds;
        boolean adjusted;
        
        public AdjustBounds(final Rectangle2D bounds, final AffineTransform transform) {
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
        public void visitDrawShape(final DrawShape pic) {
            Shape shape = pic.shape;
            if (this.stroke instanceof BasicStroke && (this.strokePropertiesSet & 0x1) != 0x0) {
                final double lineWidth = ((BasicStroke)this.stroke).getLineWidth();
                final double halfWidth = 0.5 * lineWidth;
                if (this.transform != null) {
                    shape = this.transform.createTransformedShape(shape);
                }
                final Rectangle2D transformedBounds = shape.getBounds2D();
                final double sx0 = transformedBounds.getX() - halfWidth;
                final double sx2 = sx0 + transformedBounds.getWidth() + lineWidth;
                final double sy0 = transformedBounds.getY() - halfWidth;
                final double sy2 = sy0 + transformedBounds.getHeight() + lineWidth;
                if (sx0 < this.x0) {
                    this.x0 = sx0;
                    this.adjusted = true;
                }
                if (sy0 < this.y0) {
                    this.y0 = sy0;
                    this.adjusted = true;
                }
                if (sx2 > this.x1) {
                    this.x1 = sx2;
                    this.adjusted = true;
                }
                if (sy2 > this.y1) {
                    this.y1 = sy2;
                    this.adjusted = true;
                }
            }
        }
    }
}
