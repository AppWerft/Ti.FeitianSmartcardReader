package gnu.kawa.models;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public abstract interface Picture
{
  public abstract void paint(Graphics2D paramGraphics2D);
  
  public abstract Rectangle2D getBounds2D();
  
  public abstract Picture transform(AffineTransform paramAffineTransform);
  
  public abstract void visit(PictureVisitor paramPictureVisitor);
}
