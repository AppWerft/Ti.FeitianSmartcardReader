package gnu.kawa.models;

import gnu.lists.FString;
import gnu.mapping.ThreadLocation;
import gnu.mapping.WrappedException;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.lang.reflect.Method;



public abstract class Display
{
  public static ThreadLocation myDisplay = new ThreadLocation("my-display");
  
  public Display() {}
  
  public static Display getInstance() { Object d = myDisplay.get(null);
    if ((d instanceof Display))
      return (Display)d;
    String name = d == null ? "swing" : d.toString();
    Class[] noClasses = new Class[0];
    for (;;)
    {
      int comma = name.indexOf(',');
      String rest = null;
      if (comma >= 0)
      {
        rest = name.substring(comma + 1);
        name = name.substring(0, comma);
      }
      
      if (name.equals("swing")) {
        name = "gnu.kawa.swingviews.SwingDisplay";
      } else if (name.equals("swt")) {
        name = "gnu.kawa.swtviews.SwtDisplay";
      } else if (name.equals("echo2")) {
        name = "gnu.kawa.echo2.Echo2Display";
      }
      try
      {
        Class clas = Class.forName(name);
        Method method = clas.getDeclaredMethod("getInstance", noClasses);
        
        return (Display)method.invoke(null, new Object[0]);
      }
      catch (ClassNotFoundException ex)
      {
        if (rest == null)
          throw new RuntimeException("no display toolkit: " + d);
        name = rest;
      }
      catch (Exception ex)
      {
        throw WrappedException.wrapIfNeeded(ex);
      }
    }
  }
  
  public abstract Window makeWindow();
  
  public abstract void addButton(Button paramButton, Object paramObject);
  
  public abstract void addLabel(Label paramLabel, Object paramObject);
  
  public abstract void addImage(DrawImage paramDrawImage, Object paramObject);
  
  public void addText(Text model, Object where)
  {
    throw new Error("makeView called on Text");
  }
  
  public void addSpacer(Spacer model, Object where)
  {
    throw new Error("makeView called on Spacer");
  }
  
  public abstract void addBox(Box paramBox, Object paramObject);
  
  public abstract void addView(Object paramObject1, Object paramObject2);
  
  public static Dimension asDimension(Dimension2D dim)
  {
    if (((dim instanceof Dimension)) || (dim == null)) {
      return (Dimension)dim;
    }
    return new Dimension((int)(dim.getWidth() + 0.5D), (int)(dim.getHeight() + 0.5D));
  }
  

  public Model coerceToModel(Object component)
  {
    if (((component instanceof FString)) || ((component instanceof String)))
      return new Label(component.toString());
    return (Model)component;
  }
}
