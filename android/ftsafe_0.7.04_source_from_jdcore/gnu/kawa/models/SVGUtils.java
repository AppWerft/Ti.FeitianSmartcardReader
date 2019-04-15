package gnu.kawa.models;

import gnu.kawa.io.CharArrayOutPort;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.xml.XMLFilter;
import gnu.xml.XMLPrinter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class SVGUtils
{
  public SVGUtils() {}
  
  public static boolean haveToSvg = true;
  
  public static String toSVG(Picture p) {
    CharArrayOutPort cout = new CharArrayOutPort();
    XMLPrinter xout = new XMLPrinter(cout);
    toSVG(p, xout);
    return cout.toString();
  }
  
  public static void toSVG(Picture p, PrintConsumer out, boolean headers) {
    if (headers) {
      out.println("<?xml version=\"1.0\" standalone=\"no\"?>");
      out.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
    }
    
    toSVG(p, new XMLPrinter(out));
  }
  
  public static void toSVG(Picture p, Consumer out) {
    Rectangle2D bounds = adjustBounds(p, p.getBounds2D(), null);
    PictureToSvg.writeSVGElementStart(bounds, out);
    PictureToSvg pout = new PictureToSvg(out);
    p.visit(pout);
    out.endElement();
  }
  
  public static gnu.kawa.xml.KElement toSVGNode(Picture p) {
    XMLFilter filter = new XMLFilter(new gnu.xml.NodeTree());
    toSVG(p, filter);
    return (gnu.kawa.xml.KElement)gnu.kawa.xml.KNode.make((gnu.xml.NodeTree)out);
  }
  
  public static Rectangle2D adjustBounds(Picture pic, Rectangle2D bounds, AffineTransform transform) {
    AdjustBounds visitor = new AdjustBounds(bounds, transform);
    pic.visit(visitor);
    return visitor.getBounds(); }
  
  static class AdjustBounds extends PictureVisitor.TrackingState { double x0;
    double y0;
    double x1;
    double y1;
    Rectangle2D bounds;
    boolean adjusted;
    
    public AdjustBounds(Rectangle2D bounds, AffineTransform transform) { super();
      this.bounds = bounds;
      x0 = bounds.getX();
      y0 = bounds.getY();
      x1 = (x0 + bounds.getWidth());
      y1 = (y0 + bounds.getHeight());
    }
    
    public Rectangle2D getBounds() { Rectangle2D b = bounds;
      if (adjusted)
        b = new java.awt.geom.Rectangle2D.Double(x0, y0, x1 - x0, y1 - y0);
      return b;
    }
    
    public void visitDrawShape(DrawShape pic)
    {
      java.awt.Shape shape = shape;
      if (((stroke instanceof java.awt.BasicStroke)) && ((strokePropertiesSet & 0x1) != 0))
      {
        double lineWidth = ((java.awt.BasicStroke)stroke).getLineWidth();
        double halfWidth = 0.5D * lineWidth;
        if (transform != null)
          shape = transform.createTransformedShape(shape);
        Rectangle2D transformedBounds = shape.getBounds2D();
        double sx0 = transformedBounds.getX() - halfWidth;
        double sx1 = sx0 + transformedBounds.getWidth() + lineWidth;
        double sy0 = transformedBounds.getY() - halfWidth;
        double sy1 = sy0 + transformedBounds.getHeight() + lineWidth;
        if (sx0 < x0) {
          x0 = sx0;
          adjusted = true;
        }
        if (sy0 < y0) {
          y0 = sy0;
          adjusted = true;
        }
        if (sx1 > x1) {
          x1 = sx1;
          adjusted = true;
        }
        if (sy1 > y1) {
          y1 = sy1;
          adjusted = true;
        }
      }
    }
  }
}
