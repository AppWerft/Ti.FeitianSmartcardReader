package gnu.kawa.models;

import java.awt.geom.AffineTransform;

public class PictureVisitor {
  public PictureVisitor() {}
  
  public void visitFillShape(FillShape pic) {}
  
  public void visitDrawShape(DrawShape pic) {}
  
  public void visitDrawImage(DrawImage pic) {}
  
  public void visitWithPaint(WithPaint pic) { picture.visit(this); }
  

  public void visitWithTransform(WithTransform pic) { picture.visit(this); }
  
  public void visitWithComposite(WithComposite pic) {
    for (Picture child : children)
      child.visit(this);
  }
  
  public void visitPBox(PBox pic) { for (Picture child : children)
      child.visit(this);
  }
  
  public static class TrackingState extends PictureVisitor {
    protected AffineTransform transform;
    protected java.awt.Stroke stroke = null;
    protected java.awt.Paint paint = null;
    protected int strokePropertiesSet = 0;
    
    public TrackingState(AffineTransform transform) {
      this.transform = transform;
    }
    
    public TrackingState() { transform = null; }
    

    public void visitWithTransform(WithTransform pic)
    {
      AffineTransform savedTransform = transform;
      try {
        transform = transform;
        if (savedTransform != null) {
          transform = new AffineTransform(transform);
          transform.preConcatenate(savedTransform);
        }
        super.visitWithTransform(pic);
      } finally {
        transform = savedTransform;
      }
    }
    
    public void visitWithPaint(WithPaint pic)
    {
      java.awt.Paint savedPaint = paint;
      java.awt.Stroke savedStroke = stroke;
      int savedPropertiesSet = strokePropertiesSet;
      try {
        if (paint != null)
          paint = paint;
        java.awt.Stroke nstroke = stroke;
        if (nstroke != null) {
          strokePropertiesSet |= propertiesSet;
          if (((savedStroke instanceof java.awt.BasicStroke)) && ((nstroke instanceof java.awt.BasicStroke)) && ((propertiesSet & 0x3F) != 63))
          {

            nstroke = WithPaint.merge((java.awt.BasicStroke)nstroke, propertiesSet, (java.awt.BasicStroke)savedStroke);
          }
          stroke = nstroke;
        }
        super.visitWithPaint(pic);
      } finally {
        if (paint != null)
          paint = savedPaint;
        if (stroke != null)
          stroke = savedStroke;
        strokePropertiesSet = savedPropertiesSet;
      }
    }
  }
}
