package kawa;

import gnu.kawa.models.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position.Bias;
import javax.swing.text.View;









































































































































class PictureView
  extends View
{
  Picture p;
  Rectangle2D bounds;
  
  public PictureView(Element elem, Picture picture)
  {
    super(elem);
    p = picture;
    bounds = picture.getBounds2D();
  }
  
  public void paint(Graphics g, Shape a)
  {
    Graphics2D g2 = (Graphics2D)g;
    Rectangle2D abounds = a.getBounds2D();
    AffineTransform saveTransform = g2.getTransform();
    Paint savePaint = g2.getPaint();
    try
    {
      g2.translate(abounds.getX() - bounds.getX(), abounds.getY() - bounds.getY());
      
      g2.setPaint(Color.BLACK);
      p.paint(g2);
    }
    finally
    {
      g2.setTransform(saveTransform);
      g2.setPaint(savePaint);
    }
  }
  

  public float getAlignment(int axis)
  {
    switch (axis)
    {
    case 1: 
      return 1.0F;
    }
    return super.getAlignment(axis);
  }
  
  public float getPreferredSpan(int axis)
  {
    switch (axis) {
    case 0: 
      return (float)bounds.getWidth();
    case 1: 
      return (float)bounds.getHeight();
    }
    throw new IllegalArgumentException("Invalid axis: " + axis);
  }
  
  public Shape modelToView(int pos, Shape a, Position.Bias b) throws BadLocationException
  {
    int p0 = getStartOffset();
    int p1 = getEndOffset();
    if ((pos >= p0) && (pos <= p1)) {
      Rectangle r = a.getBounds();
      if (pos == p1) {
        x += width;
      }
      width = 0;
      return r;
    }
    throw new BadLocationException(pos + " not in range " + p0 + "," + p1, pos);
  }
  
  public int viewToModel(float x, float y, Shape a, Position.Bias[] bias) {
    Rectangle alloc = (Rectangle)a;
    if (x < x + width / 2) {
      bias[0] = Position.Bias.Forward;
      return getStartOffset();
    }
    bias[0] = Position.Bias.Backward;
    return getEndOffset();
  }
}
