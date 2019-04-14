package gnu.kawa.models;

import java.awt.Dimension;

public abstract class Box extends Model implements Viewable, java.io.Serializable
{
  Viewable[] components;
  int numComponents;
  Viewable cellSpacing;
  
  public Box() {}
  
  public Viewable getCellSpacing()
  {
    return cellSpacing;
  }
  
  public void setCellSpacing(Object cellSpacing) {
    if (((cellSpacing instanceof gnu.math.IntNum)) || ((cellSpacing instanceof Integer)))
    {

      int size = ((Number)cellSpacing).intValue();
      Dimension dim = getAxis() == 0 ? new Dimension(size, 0) : new Dimension(0, size);
      
      this.cellSpacing = Spacer.rigidArea(dim);




    }
    else
    {




      this.cellSpacing = ((Viewable)cellSpacing);
    }
  }
  
  public abstract int getAxis();
  
  public final int getComponentCount()
  {
    return numComponents;
  }
  
  public final Viewable getComponent(int i)
  {
    return components[i];
  }
  
  public void add(Viewable component)
  {
    Viewable[] arr = components;
    int n = numComponents;
    if (n == 0) {
      components = (arr = new Viewable[4]);
    } else if (arr.length <= n)
    {
      components = new Viewable[2 * n];
      System.arraycopy(arr, 0, components, 0, n);
      arr = components;
    }
    components[n] = component;
    numComponents = (n + 1);
  }
  
  public void makeView(Display display, Object where)
  {
    display.addBox(this, where);
  }
}
