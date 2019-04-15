package gnu.kawa.models;

import java.awt.Composite;
import java.awt.Graphics2D;
import java.util.Map;

public class WithComposite implements Picture
{
  Picture[] children;
  Composite[] composite;
  
  public WithComposite() {}
  
  public static WithComposite make(Picture picture, Composite composite)
  {
    WithComposite comp = new WithComposite();
    children = new Picture[] { picture };
    composite = new Composite[] { composite };
    return comp;
  }
  

  public static WithComposite make(Picture[] children, Composite[] composite)
  {
    WithComposite comp = new WithComposite();
    children = children;
    composite = composite;
    return comp;
  }
  
  public static WithComposite make(Object[] arguments)
  {
    int n = 0;
    int i = arguments.length; for (;;) { i--; if (i < 0)
        break;
      Object arg = arguments[i];
      if (((arg instanceof Picture)) || ((arg instanceof java.awt.Shape)) || ((arg instanceof java.awt.image.BufferedImage)))
      {
        n++; }
    }
    Picture[] children = new Picture[n];
    Composite[] composite = new Composite[n];
    Composite comp = null;
    int j = 0;
    for (int i = 0; i < arguments.length; i++)
    {
      Object arg = arguments[i];
      if (((arg instanceof Picture)) || ((arg instanceof java.awt.Shape)) || ((arg instanceof java.awt.image.BufferedImage)))
      {

        children[j] = Pictures.asPicture(arg);
        composite[j] = comp;
        j++;
      }
      else if ((arg instanceof Composite))
      {
        comp = (Composite)arg;
      }
      else
      {
        String name = arg.toString().toLowerCase().replace("-", "");
        comp = (Composite)namedComposites.get(name);
        if (comp == null)
          throw new IllegalArgumentException("unknown composite " + name);
      }
    }
    return make(children, composite);
  }
  
  public Composite singleOp() {
    int n = children.length;
    if (n == 0)
      return null;
    Composite first = composite[0];
    for (int i = 1; i < n; i++) {
      Composite cur = composite[i];
      if ((cur != null) && (cur != first))
        return null;
    }
    return first;
  }
  
  public void paint(Graphics2D graphics)
  {
    Composite saved = graphics.getComposite();
    Composite prev = saved;
    try
    {
      int n = children.length;
      for (int i = 0; i < n; i++)
      {
        Composite cur = composite[i];
        if ((cur != null) && (cur != prev))
        {
          graphics.setComposite(cur);
          prev = cur;
        }
        children[i].paint(graphics);
      }
    }
    finally
    {
      if (prev != saved) {
        graphics.setComposite(saved);
      }
    }
  }
  
  public java.awt.geom.Rectangle2D getBounds2D() {
    int n = children.length;
    if (n == 0)
      return null;
    java.awt.geom.Rectangle2D bounds = children[0].getBounds2D();
    for (int i = 1; i < n; i++)
      bounds = bounds.createUnion(children[i].getBounds2D());
    return bounds;
  }
  
  public Picture transform(java.awt.geom.AffineTransform tr)
  {
    int n = children.length;
    Picture[] transformed = new Picture[n];
    for (int i = 0; i < n; i++)
      transformed[i] = children[i].transform(tr);
    return make(transformed, composite);
  }
  
  public void visit(PictureVisitor visitor) { visitor.visitWithComposite(this); }
  

  static Map<String, Composite> namedComposites = new java.util.HashMap();
  
  static { namedComposites.put("clear", java.awt.AlphaComposite.Clear);
    namedComposites.put("dstover", java.awt.AlphaComposite.DstOver);
    namedComposites.put("src", java.awt.AlphaComposite.Src);
    namedComposites.put("srcover", java.awt.AlphaComposite.SrcOver);
  }
}
