package gnu.kawa.models;

import java.awt.geom.Path2D.Double;

public class Pictures {
  public Pictures() {}
  
  public static Picture asPicture(Object arg) {
    if ((arg instanceof java.awt.image.BufferedImage))
      return new DrawImage((java.awt.image.BufferedImage)arg);
    if ((arg instanceof java.awt.Shape))
      return new DrawShape((java.awt.Shape)arg);
    return (Picture)arg;
  }
  
  public static Picture[] asPictureAll(Object[] args) { int np = args.length;
    Picture[] p = new Picture[np];
    for (int i = 0; i < np; i++)
      p[i] = asPicture(args[i]);
    return p;
  }
  
  public static java.awt.image.BufferedImage toImage(Picture picture) {
    java.awt.geom.Rectangle2D size = picture.getBounds2D();
    int w = (int)Math.ceil(size.getWidth());
    int h = (int)Math.ceil(size.getHeight());
    java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(w, h, 2);
    
    java.awt.Graphics2D g2 = image.createGraphics();
    g2.setPaint(java.awt.Color.BLACK);
    g2.setStroke(defaultStroke);
    g2.translate(-size.getX(), -size.getY());
    picture.paint(g2);
    return image;
  }
  

  public static java.awt.Shape borderShape(java.awt.geom.Rectangle2D bounds, boolean border, double top, double right, double bottom, double left)
  {
    double x0 = bounds.getX();
    double w = bounds.getWidth();
    double x1 = x0 + w;
    double y0 = bounds.getY();
    double h = bounds.getHeight();
    double y1 = y0 + h;
    if (border) {
      double x0b = x0 - left;
      double x1b = x1 + right;
      double y0b = y0 - top;
      double y1b = y1 + bottom;
      Path2D.Double r = new Path2D.Double();
      r.setWindingRule(1);
      r.moveTo(x0, y0);
      r.lineTo(x1, y0);
      r.lineTo(x1, y1);
      r.lineTo(x0, y1);
      r.closePath();
      r.moveTo(x0b, y0b);
      r.lineTo(x0b, y1b);
      r.lineTo(x1b, y1b);
      r.lineTo(x1b, y0b);
      r.closePath();
      return r;
    }
    return new java.awt.geom.Rectangle2D.Double(x0 - left, y0 - top, w + left + right, h + top + bottom);
  }
  

  public static final java.awt.BasicStroke defaultStroke = new java.awt.BasicStroke(1.0F, 0, 0);
}
