package gnu.kawa.models;

import java.awt.Shape;

public class FillShape implements Picture
{
  Shape shape;
  
  public FillShape(Shape shape)
  {
    this.shape = shape;
  }
  
  public Shape getShape() { return shape; }
  
  public void paint(java.awt.Graphics2D graphics) {
    if (graphics.getPaint() != StandardColor.transparent) {
      graphics.fill(shape);
    }
  }
  
  public java.awt.geom.Rectangle2D getBounds2D() {
    return shape.getBounds2D();
  }
  
  public Picture transform(java.awt.geom.AffineTransform tr)
  {
    return new FillShape(tr.createTransformedShape(shape));
  }
  
  public void visit(PictureVisitor visitor) {
    visitor.visitFillShape(this);
  }
}
