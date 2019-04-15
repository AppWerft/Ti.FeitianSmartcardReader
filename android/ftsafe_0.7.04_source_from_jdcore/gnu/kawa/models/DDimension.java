package gnu.kawa.models;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;






public class DDimension
  extends Dimension
{
  private double w;
  private double h;
  
  public DDimension() {}
  
  public DDimension(double width, double height)
  {
    setWidth(width);
    setHeight(height);
  }
  
  public DDimension(Dimension2D d) { this(d.getWidth(), d.getHeight()); }
  
  public double getWidth()
  {
    return w;
  }
  
  public double getHeight() { return h; }
  
  public DDimension getSize()
  {
    return new DDimension(w, h);
  }
  
  public void setWidth(double width) {
    w = width;
    this.width = ((int)Math.ceil(width));
  }
  
  public void setHeight(double height) {
    h = height;
    this.height = ((int)Math.ceil(height));
  }
  
  public void setSize(int width, int height)
  {
    w = width;
    this.width = width;
    h = height;
    this.height = height;
  }
  
  public void setSize(double width, double height)
  {
    setWidth(width);
    setHeight(height);
  }
  
  public void setSize(Dimension d)
  {
    setSize(d.getWidth(), d.getHeight());
  }
  
  public void setSize(Dimension2D d) {
    setSize(d.getWidth(), d.getHeight());
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof DDimension)) {
      DDimension d = (DDimension)obj;
      return (w == w) && (h == h);
    }
    
    return false;
  }
  
  public String toString()
  {
    return getClass().getName() + "[width=" + getWidth() + ",height=" + getHeight() + "]";
  }
}
