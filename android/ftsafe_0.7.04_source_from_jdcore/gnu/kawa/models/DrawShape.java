package gnu.kawa.models;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;


public class DrawShape
  implements Picture
{
  Shape shape;
  
  public DrawShape(Shape shape) { this.shape = shape; }
  
  public Shape getShape() { return shape; }
  
  public void paint(java.awt.Graphics2D graphics)
  {
    graphics.draw(shape);
  }
  
  public java.awt.geom.Rectangle2D getBounds2D()
  {
    return shape.getBounds2D();
  }
  
  public Picture transform(AffineTransform tr)
  {
    return new DrawShape(tr.createTransformedShape(shape));
  }
  
  public void visit(PictureVisitor visitor) {
    visitor.visitDrawShape(this);
  }
  
  private static Stroke mergeCap(int value, Stroke old) {
    return WithPaint.merge(new BasicStroke(1.0F, value, 0), 2, (BasicStroke)old);
  }
  


  private static Stroke mergeJoin(int value, Stroke old)
  {
    return WithPaint.merge(new BasicStroke(1.0F, 0, value), 4, (BasicStroke)old);
  }
  

  public static Picture makeDraw(java.util.List<Object> args)
  {
    java.awt.Paint paint = null;
    Stroke stroke = null;
    int propertiesSet = 0;
    int nargs = args.size();
    ArrayList<DrawShape> ops = new ArrayList();
    for (Object arg : args)
      if ((arg instanceof Shape)) {
        ops.add(new DrawShape((Shape)arg));
      }
      else {
        if (ops.size() > 0)
          throw new IllegalArgumentException("draw: property argument after shape argument");
        if (((arg instanceof CharSequence)) || ((arg instanceof gnu.mapping.SimpleSymbol))) {
          String str = arg.toString();
          if (str.equals("butt-cap")) {
            propertiesSet |= 0x2;
            stroke = mergeCap(0, stroke);
          } else if (str.equals("square-cap")) {
            propertiesSet |= 0x2;
            stroke = mergeCap(2, stroke);
          } else if (str.equals("round-cap")) {
            propertiesSet |= 0x2;
            stroke = mergeCap(1, stroke);
          } else if (str.equals("miter-join")) {
            propertiesSet |= 0x4;
            stroke = mergeJoin(0, stroke);
          } else if (str.equals("round-join")) {
            propertiesSet |= 0x4;
            stroke = mergeJoin(1, stroke);
          } else if (str.equals("bevel-join")) {
            propertiesSet |= 0x4;
            stroke = mergeJoin(2, stroke);
          } else {
            java.awt.Color color = StandardColor.valueOf(str);
            if (color == null)
              throw new IllegalArgumentException("draw: unknown keyword or color " + str);
            paint = color;
          }
        } else if ((arg instanceof java.awt.Paint)) {
          paint = (java.awt.Paint)arg;
        } else if ((arg instanceof Stroke)) {
          propertiesSet |= 0x3F;
          stroke = (Stroke)arg;
        } else if ((arg instanceof Number)) {
          float width = ((Number)arg).floatValue();
          propertiesSet |= 0x1;
          stroke = WithPaint.merge(new BasicStroke(width, 0, 0), 1, (BasicStroke)stroke);


        }
        else
        {

          throw new IllegalArgumentException("draw: invalid argument type");
        }
      }
    Picture pic = PBox.combine(ops);
    if ((paint != null) || (stroke != null))
      pic = new WithPaint(pic, paint, stroke, propertiesSet);
    return pic;
  }
}
