package gnu.kawa.models;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class WithTransform implements Picture
{
  Picture picture;
  AffineTransform transform;
  public static final AffineTransform identityTransform = new AffineTransform();
  
  public WithTransform(Picture picture, AffineTransform transform)
  {
    this.picture = picture;
    this.transform = transform;
  }
  
  public void paint(Graphics2D graphics)
  {
    AffineTransform saved = graphics.getTransform();
    try
    {
      graphics.transform(transform);
      picture.paint(graphics);
    }
    finally
    {
      graphics.setTransform(saved);
    }
  }
  
  public java.awt.geom.Rectangle2D getBounds2D()
  {
    return transform.createTransformedShape(picture.getBounds2D()).getBounds2D();
  }
  

  public Picture transform(AffineTransform tr)
  {
    AffineTransform combined = new AffineTransform(transform);
    combined.concatenate(tr);
    return new WithTransform(picture, combined);
  }
  
  public void visit(PictureVisitor visitor) { visitor.visitWithTransform(this); }
}
