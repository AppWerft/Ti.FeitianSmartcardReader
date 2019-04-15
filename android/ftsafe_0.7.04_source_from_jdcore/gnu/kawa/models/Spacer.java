package gnu.kawa.models;

import java.awt.geom.Dimension2D;

public class Spacer
  extends Model
  implements Viewable, java.io.Serializable
{
  Dimension2D minSize;
  Dimension2D preferredSize;
  Dimension2D maxSize;
  
  public Spacer() {}
  
  public Dimension2D getMinimumSize2D() { return minSize; }
  
  public Dimension2D getPreferredSize2D() { return preferredSize; }
  
  public Dimension2D getMaximumSize2D() { return maxSize; }
  

  public java.awt.Dimension getMinimumSize() { return Display.asDimension(minSize); }
  
  public java.awt.Dimension getPreferredSize() { return Display.asDimension(preferredSize); }
  
  public java.awt.Dimension getMaximumSize() { return Display.asDimension(maxSize); }
  
  public boolean isRigid()
  {
    if (minSize == maxSize)
      return true;
    if ((minSize != null) && (maxSize != null) && (minSize.getWidth() == maxSize.getWidth()) && (minSize.getHeight() == maxSize.getHeight()))
    {

      return true; }
    return false;
  }
  
  public static Spacer rigidArea(Dimension2D d)
  {
    Spacer spacer = new Spacer();
    minSize = d;
    maxSize = d;
    preferredSize = d;
    return spacer;
  }
  
  public static Spacer rigidArea(int width, int height)
  {
    return rigidArea(new java.awt.Dimension(width, height));
  }
  
  public void makeView(Display display, Object where)
  {
    display.addSpacer(this, where);
  }
}
