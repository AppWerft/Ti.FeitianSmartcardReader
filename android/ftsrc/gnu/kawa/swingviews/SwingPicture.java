package gnu.kawa.swingviews;

import gnu.kawa.models.Picture;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class SwingPicture extends JPanel
{
  Picture picture;
  java.awt.Dimension dim;
  Rectangle2D rect;
  
  public SwingPicture(Picture picture)
  {
    setPicture(picture);
  }
  
  public Picture getPicture() { return picture; }
  
  public void setPicture(Object picture) {
    setPicture(gnu.kawa.models.Pictures.asPicture(picture));
  }
  
  public void setPicture(Picture picture) {
    this.picture = picture;
    
    Rectangle2D rect = picture.getBounds2D();
    this.rect = rect;
    int h = (int)Math.ceil(rect.getHeight());
    int w = (int)Math.ceil(rect.getWidth());
    dim = new java.awt.Dimension(w, h);
    if (!isPreferredSizeSet())
      setPreferredSize(dim);
    repaint(0L, 0, 0, getWidth(), getHeight());
  }
  
  public void paintComponent(java.awt.Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    java.awt.geom.AffineTransform saveTransform = g2.getTransform();
    java.awt.Stroke savedStroke = g2.getStroke();
    try {
      g2.setStroke(gnu.kawa.models.Pictures.defaultStroke);
      g2.translate((getWidth() - rect.getWidth()) * 0.5D - rect.getX(), (getHeight() - rect.getHeight()) * 0.5D - rect.getY());
      
      picture.paint(g2);
    } finally {
      g2.setTransform(saveTransform);
      g2.setStroke(savedStroke);
    }
  }
}
